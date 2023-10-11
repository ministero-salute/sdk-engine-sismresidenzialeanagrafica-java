package it.mds.sdk.flusso.sism.residenziale.anag.parser.regole;

import it.mds.sdk.flusso.sism.residenziale.anag.parser.regole.conf.ConfigurazioneFlussoSismResAnag;
import it.mds.sdk.flusso.sism.residenziale.anag.tracciato.TracciatoSplitterImpl;
import it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.ObjectFactory;
import it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica.ResidenzialeAnagrafica;
import it.mds.sdk.gestorefile.GestoreFile;
import it.mds.sdk.gestorefile.factory.GestoreFileFactory;
import it.mds.sdk.libreriaregole.dtos.CampiInputBean;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class TracciatoSplitterImplTest {

    @InjectMocks
    @Spy
    private TracciatoSplitterImpl tracciatoSplitter;
    private ConfigurazioneFlussoSismResAnag configurazione = Mockito.mock(ConfigurazioneFlussoSismResAnag.class);
    private ObjectFactory objectFactory = Mockito.mock(ObjectFactory.class);
    private ResidenzialeAnagrafica residenzialeAnagrafica = Mockito.mock(ResidenzialeAnagrafica.class);
    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento asl = Mockito.mock(ResidenzialeAnagrafica.AziendaSanitariaRiferimento.class);
    private ConfigurazioneFlussoSismResAnag.XmlOutput xmlOutput = Mockito.mock(ConfigurazioneFlussoSismResAnag.XmlOutput.class);
    private MockedStatic<GestoreFileFactory> gestore;
    private GestoreFile gestoreFile = Mockito.mock(GestoreFile.class);
    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento aziendaSanitariaRiferimento = Mockito.mock(ResidenzialeAnagrafica.AziendaSanitariaRiferimento.class);
    private List<ResidenzialeAnagrafica.AziendaSanitariaRiferimento> aziendaSanitariaRiferimentoList = new ArrayList<>();
    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM dsm = Mockito.mock(ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM.class);
    private List<ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM> listDsm = new ArrayList<>();
    private ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM.Assistito assistito = Mockito.mock(ResidenzialeAnagrafica.AziendaSanitariaRiferimento.DSM.Assistito.class);
    private RecordDtoSismResidenzialeAnagrafica r = new RecordDtoSismResidenzialeAnagrafica();
    List<RecordDtoSismResidenzialeAnagrafica> records = new ArrayList<>();

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        gestore = mockStatic(GestoreFileFactory.class);
        initMockedRecord(r);
        records.add(r);
    }

    @Test
    void dividiTracciatoTest() throws JAXBException, IOException, SAXException {

        when(tracciatoSplitter.getConfigurazione()).thenReturn(configurazione);
        when(objectFactory.createResidenzialeAnagrafica()).thenReturn(residenzialeAnagrafica);
        when(residenzialeAnagrafica.getAziendaSanitariaRiferimento()).thenReturn(List.of(asl));
        when(configurazione.getXmlOutput()).thenReturn(xmlOutput);
        when(xmlOutput.getPercorso()).thenReturn("percorso");
        gestore.when(() -> GestoreFileFactory.getGestoreFile("XML")).thenReturn(gestoreFile);
        doNothing().when(gestoreFile).scriviDto(any(), any(), any());

        Assertions.assertEquals(
                List.of(Path.of("percorsoSDK_RES_ANR_S1_100.xml")),
                this.tracciatoSplitter.dividiTracciato(records, "100")
        );

    }

    @Test
    void dividiTracciatoTestOk2() throws JAXBException, IOException, SAXException {
//        records.get(0).setTipoOperazionePrestazione("C");
        when(tracciatoSplitter.getConfigurazione()).thenReturn(configurazione);
        when(objectFactory.createResidenzialeAnagrafica()).thenReturn(residenzialeAnagrafica);
        when(residenzialeAnagrafica.getAziendaSanitariaRiferimento()).thenReturn(List.of(asl));

        when(configurazione.getXmlOutput()).thenReturn(xmlOutput);
        when(xmlOutput.getPercorso()).thenReturn("percorso");
        gestore.when(() -> GestoreFileFactory.getGestoreFile("XML")).thenReturn(gestoreFile);
        doNothing().when(gestoreFile).scriviDto(any(), any(), any());

        doReturn(null).when(tracciatoSplitter).getCurrentAsl(any(), any());
        doReturn(null).when(tracciatoSplitter).getCurrentDsm(any(), any());
//        doReturn(null).when(tracciatoSplitter).getAssistito(any(), any());
//        doReturn(null).when(tracciatoSplitter).getStruttura(any(), any());
//        doReturn(null).when(tracciatoSplitter).getContatto(any(), any());

        Assertions.assertEquals(
                List.of(Path.of("percorsoSDK_RES_ANR_S1_100.xml")),
                this.tracciatoSplitter.dividiTracciato(records, "100")
        );

    }

//    @Test
//    void getContattoTest(){
//        var list = List.of(contatto);
//
//        when(struttura.getContatto()).thenReturn(list);
//        var c = tracciatoSplitter.getContatto(struttura, r);
//    }
//
//    @Test
//    void getStrutturaTest(){
//        var list = List.of(assistito);
//
//        when(dsm.getAssistito()).thenReturn(list);
//        var c = tracciatoSplitter.getAssistito(dsm, r);
//    }

    @Test
    void getCurrentDsmTest(){
        var list = List.of(dsm);
        when(asl.getDSM()).thenReturn(list);
        var c = tracciatoSplitter.getCurrentDsm(asl, r);
    }

    @Test
    void getCurrentAslTest(){
        var list = List.of(asl);

        when(residenzialeAnagrafica.getAziendaSanitariaRiferimento()).thenReturn(list);
        var c = tracciatoSplitter.getCurrentAsl(residenzialeAnagrafica, r);
    }

    @Test
    void creaPrestazioniSanitarieTest(){
        var list = List.of(asl);
        var c = tracciatoSplitter.creaResidenzialeAnagrafica(records, null);
    }

    @AfterEach
    void closeMocks(){
        gestore.close();
    }

    private void initMockedRecord(RecordDtoSismResidenzialeAnagrafica r) {
        CampiInputBean campiInputBean = new CampiInputBean();
        campiInputBean.setPeriodoRiferimentoInput("Q1");
        campiInputBean.setAnnoRiferimentoInput("2022");
        r.setTipoOperazioneAnagrafica("C");
        r.setAnnoRiferimento("2022");
        r.setCodiceRegione("080");
        r.setPeriodoRiferimento("S1");
        r.setCodiceDipartimentoSaluteMentale("cdsm");
        r.setCodiceAziendaSanitariaRiferimento("casr");
        r.setIdRecord("ic");
        r.setTipologiaCodiceIdentificativoAssistito(1);
        r.setValiditaCodiceIdentificativoAssistito(1);
        records.add(r);
    }
}
