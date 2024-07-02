/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.sism.residenziale.anag.tracciato;

import it.mds.sdk.flusso.sism.residenziale.anag.parser.regole.RecordDtoSismResidenzialeAnagrafica;
import it.mds.sdk.flusso.sism.residenziale.anag.parser.regole.conf.ConfigurazioneFlussoSismResAnag;
import it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.ObjectFactory;
import it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.PeriodoRiferimento;
import it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.ResidenzialeAnagrafica;
import it.mds.sdk.gestorefile.GestoreFile;
import it.mds.sdk.gestorefile.factory.GestoreFileFactory;
import it.mds.sdk.libreriaregole.tracciato.TracciatoSplitter;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.persistence.sessions.Record;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("tracciatoSplitterSismResAnag")
public class TracciatoSplitterImpl implements TracciatoSplitter<RecordDtoSismResidenzialeAnagrafica> {

    @Override
    public List<Path> dividiTracciato(Path tracciato) {
        return null;
    }

    @Override
    public List<Path> dividiTracciato(List<RecordDtoSismResidenzialeAnagrafica> records, String idRun) {

        try {

            ConfigurazioneFlussoSismResAnag conf = getConfigurazione();
            String annoRif = records.get(0).getAnnoRiferimento();
            String codiceRegione = records.get(0).getCodiceRegione();
            //XML ANAGRAFICA
            ObjectFactory objAnag = getObjectFactory();
            ResidenzialeAnagrafica residenzialeAnagrafica = objAnag.createResidenzialeAnagrafica();
            //imposto la regione/periodo/anno che è unica per il file? TODO
            residenzialeAnagrafica.setCodiceRegione(codiceRegione);
            residenzialeAnagrafica.setAnnoRiferimento(annoRif);
            residenzialeAnagrafica.setPeriodoRiferimento(PeriodoRiferimento.fromValue(records.get(0).getPeriodoRiferimento()));

            for (RecordDtoSismResidenzialeAnagrafica r : records) {
                if (!r.getTipoOperazioneAnagrafica().equalsIgnoreCase("NM")) {
                    creaAnagraficaXml(r, residenzialeAnagrafica, objAnag);
                }
            }

            //recupero il path del file xsd di anagrafica
            URL resourceAnagrafica = this.getClass().getClassLoader().getResource("ANR.xsd");
            log.debug("URL dell'XSD per la validazione idrun {} : {}", idRun, resourceAnagrafica);


            String pathAnagraf = conf.getXmlOutput().getPercorso() + "SDK_RES_ANR_" + records.get(0).getPeriodoRiferimento() + "_" + idRun + ".xml";
            //gestoreFile.scriviDto(residenzialeAnagrafica, pathAnagraf, resourceAnagrafica);

            return List.of(Path.of(pathAnagraf));
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            log.error("[{}].dividiTracciato  - records[{}]  - idRun[{}] -" + e.getMessage(),
                    this.getClass().getName(),
                    records.stream().map(obj -> "" + obj.toString()).collect(Collectors.joining("|")),
                    idRun,
                    e
            );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossibile validare il csv in ingresso. message: " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void creaAnagraficaXml(RecordDtoSismResidenzialeAnagrafica r, ResidenzialeAnagrafica residenzialeAnagrafica,
                                   ObjectFactory objAnag) {

        //ASL RIF
        ResidenzialeAnagrafica.AziendaSanitariaRiferimento currentAsl = getCurrentAsl(residenzialeAnagrafica, r);
        if (currentAsl == null) {
            currentAsl = creaAsl(r.getCodiceAziendaSanitariaRiferimento(), objAnag);
            residenzialeAnagrafica.getAziendaSanitariaRiferimento().add(currentAsl);

        }

        //DSM
        ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM currentDsm = getCurrentDsm(currentAsl, r);
        if (currentDsm == null) {
            currentDsm = creaDSM(r.getCodiceDipartimentoSaluteMentale(), objAnag);
            currentAsl.getDSM().add(currentDsm);
        }

        //ASSISTITO
        ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM.Assistito currentAssistito = creaAssistito(r,objAnag);
        currentDsm.getAssistito().add(currentAssistito);

    }

    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento creaAsl(String codAsl,
                                                                       ObjectFactory objAnag) {
        ResidenzialeAnagrafica.AziendaSanitariaRiferimento asl = objAnag.createResidenzialeAnagraficaAziendaSanitariaRiferimento();
        asl.setCodiceAziendaSanitariaRiferimento(codAsl);
        return asl;
    }

    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM creaDSM(String codDsm,
                                                                           ObjectFactory objAnag) {
        ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM dsm = objAnag.createResidenzialeAnagraficaAziendaSanitariaRiferimentoDSM();
        dsm.setCodiceDSM(codDsm);
        return dsm;
    }

    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM.Assistito creaAssistito(RecordDtoSismResidenzialeAnagrafica r,
                                                                                           ObjectFactory objAnag) {
        ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM.Assistito assistito = objAnag.createResidenzialeAnagraficaAziendaSanitariaRiferimentoDSMAssistito();
        assistito.setSesso(r.getSesso());
        assistito.setAnnoNascita(r.getAnnoNascita());
        assistito.setASLResidenza(r.getAslProvenienza());
        assistito.setCittadinanza(r.getCittadinanza());
        assistito.setCodiceProfessionale(r.getCodiceProfessionale());
        assistito.setCodiceRegioneResidenza(r.getCodiceRegioneResidenza());
        assistito.setCollocazioneSocioAmbientale(r.getCollocazioneSocioAmbientale());
        assistito.setCUNI(r.getCuni());
        assistito.setIdRec(r.getIdRecord());
        assistito.setStatoCivile(r.getStatoCivile());
        assistito.setStatoEsteroResidenza(r.getStatoEsteroResidenza());
        assistito.setTipologiaCI(BigInteger.valueOf(r.getTipologiaCodiceIdentificativoAssistito()));
        assistito.setValiditaCI(BigInteger.valueOf(r.getValiditaCodiceIdentificativoAssistito()));
        assistito.setTipoOperazione(it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.TipoOperazione.fromValue(r.getTipoOperazioneAnagrafica()));
        assistito.setTitoloStudio(r.getTitoloStudio());
        return assistito;
    }

    public ResidenzialeAnagrafica creaResidenzialeAnagrafica(List<RecordDtoSismResidenzialeAnagrafica> records, ResidenzialeAnagrafica residenzialeAnagrafica) {

        //Imposto gli attribute element

        String annoRif = records.get(0).getAnnoRiferimento();
        String codiceRegione = records.get(0).getCodiceRegione();

        if (residenzialeAnagrafica == null) {
            ObjectFactory objResidenzialeAnagrafica = getObjectFactory();
            residenzialeAnagrafica = objResidenzialeAnagrafica.createResidenzialeAnagrafica();
            residenzialeAnagrafica.setAnnoRiferimento(annoRif);
            residenzialeAnagrafica.setCodiceRegione(codiceRegione);
            residenzialeAnagrafica.setPeriodoRiferimento(it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.PeriodoRiferimento.fromValue(records.get(0).getPeriodoRiferimento()));


            for (RecordDtoSismResidenzialeAnagrafica r : records) {
                if (!r.getTipoOperazioneAnagrafica().equalsIgnoreCase("NM")) {
                    creaAnagraficaXml(r, residenzialeAnagrafica, objResidenzialeAnagrafica);
                }
            }
        }
        return residenzialeAnagrafica;
    }

    public ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM getCurrentDsm(ResidenzialeAnagrafica.AziendaSanitariaRiferimento currentAsl, RecordDtoSismResidenzialeAnagrafica r) {
        return currentAsl.getDSM()
                .stream()
                .filter(dsm -> r.getCodiceDipartimentoSaluteMentale().equalsIgnoreCase(dsm.getCodiceDSM()))
                .findFirst()
                .orElse(null);
    }

    public ResidenzialeAnagrafica.AziendaSanitariaRiferimento getCurrentAsl(ResidenzialeAnagrafica residenzialeAnagrafica, RecordDtoSismResidenzialeAnagrafica r) {
        return residenzialeAnagrafica.getAziendaSanitariaRiferimento()
                .stream()
                .filter(asl -> r.getCodiceAziendaSanitariaRiferimento().equalsIgnoreCase(asl.getCodiceAziendaSanitariaRiferimento()))
                .findFirst()
                .orElse(null);
    }

    public ConfigurazioneFlussoSismResAnag getConfigurazione() {
        return new ConfigurazioneFlussoSismResAnag();
    }

    private ObjectFactory getObjectFactory() {
        return new ObjectFactory();
    }
}
