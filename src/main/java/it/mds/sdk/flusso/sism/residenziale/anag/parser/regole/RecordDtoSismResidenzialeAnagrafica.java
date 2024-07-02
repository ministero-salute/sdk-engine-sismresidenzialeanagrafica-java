/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.sism.residenziale.anag.parser.regole;

import com.opencsv.bean.CsvBindByPosition;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDtoSismResidenzialeAnagrafica extends RecordDtoGenerico {

    @CsvBindByPosition(position = 0)
    private String annoRiferimento; //ANN_RIF

    @CsvBindByPosition(position = 1)
    private String codiceRegione; //COD_REG

    @CsvBindByPosition(position = 2)
    private String periodoRiferimento; //COD_PER

    @CsvBindByPosition(position = 3)
    private String codiceAziendaSanitariaRiferimento; //COD_ASR_RFR

    @CsvBindByPosition(position = 4)
    private String codiceDipartimentoSaluteMentale;//COD_DSM

    @CsvBindByPosition(position = 5)
    private String idRecord;//ID_REC_KEYX

    @CsvBindByPosition(position = 6)
    private String cuni;

    @CsvBindByPosition(position = 7)
    private Integer validitaCodiceIdentificativoAssistito; //COD_VLD_ID_ASS

    @CsvBindByPosition(position = 8)
    private Integer tipologiaCodiceIdentificativoAssistito;//COD_TYP_ID_ASS

    @CsvBindByPosition(position = 9)
    private String annoNascita;//ANNO_NAS

    @CsvBindByPosition(position = 10)
    private String sesso; //SEX

    @CsvBindByPosition(position = 11)
    private String cittadinanza;//CTD

    @CsvBindByPosition(position = 12)
    private String codiceRegioneResidenza;//COD_REG_RES

    @CsvBindByPosition(position = 13)
    private String aslProvenienza;//ASL_RES

    @CsvBindByPosition(position = 14)
    private String statoEsteroResidenza; //STT_EST_RES

    @CsvBindByPosition(position = 15)
    private String statoCivile;//STT_CVL

    @CsvBindByPosition(position = 16)
    private String collocazioneSocioAmbientale;//CLZ_ABL

    @CsvBindByPosition(position = 17)
    private String titoloStudio; //TTL_STU

    @CsvBindByPosition(position = 18)
    private String codiceProfessionale;//CDZ_PRO

    @CsvBindByPosition(position = 19)
    private String tipoOperazioneAnagrafica;//TYP_OPR_ANA

}
