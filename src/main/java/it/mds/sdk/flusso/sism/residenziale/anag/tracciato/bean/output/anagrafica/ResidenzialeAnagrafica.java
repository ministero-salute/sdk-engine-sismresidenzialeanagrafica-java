//
// Questo file � stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.05.31 alle 06:55:45 PM CEST 
//


package it.mds.sdk.flusso.sism.residenziale.anag.tracciato.bean.output.anagrafica;

import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AnnoRiferimento" type="{}AnnoRiferimento"/&gt;
 *         &lt;element name="PeriodoRiferimento" type="{}PeriodoRiferimento"/&gt;
 *         &lt;element name="CodiceRegione" type="{}CodiceRegione"/&gt;
 *         &lt;element name="AziendaSanitariaRiferimento" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CodiceAziendaSanitariaRiferimento" type="{}CodiceAziendaSanitariaRiferimento"/&gt;
 *                   &lt;element name="DSM" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CodiceDSM" type="{}CodiceDSM"/&gt;
 *                             &lt;element name="Assistito" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Id_Rec" type="{}Id_Rec"/&gt;
 *                                       &lt;element name="CUNI" type="{}CUNI"/&gt;
 *                                       &lt;element name="validitaCI" type="{}validitaCI"/&gt;
 *                                       &lt;element name="tipologiaCI" type="{}tipologiaCI"/&gt;
 *                                       &lt;element name="AnnoNascita" type="{}AnnoNascita"/&gt;
 *                                       &lt;element name="Sesso" type="{}Sesso"/&gt;
 *                                       &lt;element name="Cittadinanza" type="{}Cittadinanza"/&gt;
 *                                       &lt;element name="CodiceRegioneResidenza" type="{}CodiceRegioneResidenza"/&gt;
 *                                       &lt;element name="ASLResidenza" type="{}ASLResidenza"/&gt;
 *                                       &lt;element name="StatoEsteroResidenza" type="{}StatoEsteroResidenza" minOccurs="0"/&gt;
 *                                       &lt;element name="StatoCivile" type="{}StatoCivile"/&gt;
 *                                       &lt;element name="CollocazioneSocioAmbientale" type="{}CollocazioneSocioAmbientale"/&gt;
 *                                       &lt;element name="TitoloStudio" type="{}TitoloStudio"/&gt;
 *                                       &lt;element name="CodiceProfessionale" type="{}CodiceProfessionale"/&gt;
 *                                       &lt;element name="TipoOperazione" type="{}TipoOperazione"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "annoRiferimento",
    "periodoRiferimento",
    "codiceRegione",
    "aziendaSanitariaRiferimento"
})
@XmlRootElement(name = "ResidenzialeAnagrafica")
public class ResidenzialeAnagrafica {

    @XmlElement(name = "AnnoRiferimento", required = true)
    protected String annoRiferimento;

    @XmlElement(name = "PeriodoRiferimento", required = true)
    @XmlSchemaType(name = "string")
    protected PeriodoRiferimento periodoRiferimento;

    @XmlElement(name = "CodiceRegione", required = true)
    protected String codiceRegione;

    @XmlElement(name = "AziendaSanitariaRiferimento", required = true)
    protected List<AziendaSanitariaRiferimento> aziendaSanitariaRiferimento;

    /**
     * Recupera il valore della propriet� annoRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoRiferimento() {
        return annoRiferimento;
    }

    /**
     * Imposta il valore della propriet� annoRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoRiferimento(String value) {
        this.annoRiferimento = value;
    }

    /**
     * Recupera il valore della propriet� periodoRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link PeriodoRiferimento }
     *     
     */
    public PeriodoRiferimento getPeriodoRiferimento() {
        return periodoRiferimento;
    }

    /**
     * Imposta il valore della propriet� periodoRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodoRiferimento }
     *     
     */
    public void setPeriodoRiferimento(PeriodoRiferimento value) {
        this.periodoRiferimento = value;
    }

    /**
     * Recupera il valore della propriet� codiceRegione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceRegione() {
        return codiceRegione;
    }

    /**
     * Imposta il valore della propriet� codiceRegione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceRegione(String value) {
        this.codiceRegione = value;
    }

    /**
     * Gets the value of the aziendaSanitariaRiferimento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the aziendaSanitariaRiferimento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAziendaSanitariaRiferimento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AziendaSanitariaRiferimento }
     * 
     * 
     */
    public List<AziendaSanitariaRiferimento> getAziendaSanitariaRiferimento() {
        if (aziendaSanitariaRiferimento == null) {
            aziendaSanitariaRiferimento = new ArrayList<AziendaSanitariaRiferimento>();
        }
        return this.aziendaSanitariaRiferimento;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="CodiceAziendaSanitariaRiferimento" type="{}CodiceAziendaSanitariaRiferimento"/&gt;
     *         &lt;element name="DSM" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CodiceDSM" type="{}CodiceDSM"/&gt;
     *                   &lt;element name="Assistito" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Id_Rec" type="{}Id_Rec"/&gt;
     *                             &lt;element name="CUNI" type="{}CUNI"/&gt;
     *                             &lt;element name="validitaCI" type="{}validitaCI"/&gt;
     *                             &lt;element name="tipologiaCI" type="{}tipologiaCI"/&gt;
     *                             &lt;element name="AnnoNascita" type="{}AnnoNascita"/&gt;
     *                             &lt;element name="Sesso" type="{}Sesso"/&gt;
     *                             &lt;element name="Cittadinanza" type="{}Cittadinanza"/&gt;
     *                             &lt;element name="CodiceRegioneResidenza" type="{}CodiceRegioneResidenza"/&gt;
     *                             &lt;element name="ASLResidenza" type="{}ASLResidenza"/&gt;
     *                             &lt;element name="StatoEsteroResidenza" type="{}StatoEsteroResidenza" minOccurs="0"/&gt;
     *                             &lt;element name="StatoCivile" type="{}StatoCivile"/&gt;
     *                             &lt;element name="CollocazioneSocioAmbientale" type="{}CollocazioneSocioAmbientale"/&gt;
     *                             &lt;element name="TitoloStudio" type="{}TitoloStudio"/&gt;
     *                             &lt;element name="CodiceProfessionale" type="{}CodiceProfessionale"/&gt;
     *                             &lt;element name="TipoOperazione" type="{}TipoOperazione"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "codiceAziendaSanitariaRiferimento",
        "dsm"
    })
    public static class AziendaSanitariaRiferimento {

        @XmlElement(name = "CodiceAziendaSanitariaRiferimento", required = true)
        protected String codiceAziendaSanitariaRiferimento;
        @XmlElement(name = "DSM", required = true)
        protected List<DSM> dsm;

        /**
         * Recupera il valore della propriet� codiceAziendaSanitariaRiferimento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodiceAziendaSanitariaRiferimento() {
            return codiceAziendaSanitariaRiferimento;
        }

        /**
         * Imposta il valore della propriet� codiceAziendaSanitariaRiferimento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodiceAziendaSanitariaRiferimento(String value) {
            this.codiceAziendaSanitariaRiferimento = value;
        }

        /**
         * Gets the value of the dsm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the dsm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDSM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DSM }
         * 
         * 
         */
        public List<DSM> getDSM() {
            if (dsm == null) {
                dsm = new ArrayList<DSM>();
            }
            return this.dsm;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="CodiceDSM" type="{}CodiceDSM"/&gt;
         *         &lt;element name="Assistito" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Id_Rec" type="{}Id_Rec"/&gt;
         *                   &lt;element name="CUNI" type="{}CUNI"/&gt;
         *                   &lt;element name="validitaCI" type="{}validitaCI"/&gt;
         *                   &lt;element name="tipologiaCI" type="{}tipologiaCI"/&gt;
         *                   &lt;element name="AnnoNascita" type="{}AnnoNascita"/&gt;
         *                   &lt;element name="Sesso" type="{}Sesso"/&gt;
         *                   &lt;element name="Cittadinanza" type="{}Cittadinanza"/&gt;
         *                   &lt;element name="CodiceRegioneResidenza" type="{}CodiceRegioneResidenza"/&gt;
         *                   &lt;element name="ASLResidenza" type="{}ASLResidenza"/&gt;
         *                   &lt;element name="StatoEsteroResidenza" type="{}StatoEsteroResidenza" minOccurs="0"/&gt;
         *                   &lt;element name="StatoCivile" type="{}StatoCivile"/&gt;
         *                   &lt;element name="CollocazioneSocioAmbientale" type="{}CollocazioneSocioAmbientale"/&gt;
         *                   &lt;element name="TitoloStudio" type="{}TitoloStudio"/&gt;
         *                   &lt;element name="CodiceProfessionale" type="{}CodiceProfessionale"/&gt;
         *                   &lt;element name="TipoOperazione" type="{}TipoOperazione"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codiceDSM",
            "assistito"
        })
        public static class DSM {

            @XmlElement(name = "CodiceDSM", required = true)
            protected String codiceDSM;
            @XmlElement(name = "Assistito", required = true)
            protected List<Assistito> assistito;

            /**
             * Recupera il valore della propriet� codiceDSM.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodiceDSM() {
                return codiceDSM;
            }

            /**
             * Imposta il valore della propriet� codiceDSM.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodiceDSM(String value) {
                this.codiceDSM = value;
            }

            /**
             * Gets the value of the assistito property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the assistito property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAssistito().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Assistito }
             * 
             * 
             */
            public List<Assistito> getAssistito() {
                if (assistito == null) {
                    assistito = new ArrayList<Assistito>();
                }
                return this.assistito;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="Id_Rec" type="{}Id_Rec"/&gt;
             *         &lt;element name="CUNI" type="{}CUNI"/&gt;
             *         &lt;element name="validitaCI" type="{}validitaCI"/&gt;
             *         &lt;element name="tipologiaCI" type="{}tipologiaCI"/&gt;
             *         &lt;element name="AnnoNascita" type="{}AnnoNascita"/&gt;
             *         &lt;element name="Sesso" type="{}Sesso"/&gt;
             *         &lt;element name="Cittadinanza" type="{}Cittadinanza"/&gt;
             *         &lt;element name="CodiceRegioneResidenza" type="{}CodiceRegioneResidenza"/&gt;
             *         &lt;element name="ASLResidenza" type="{}ASLResidenza"/&gt;
             *         &lt;element name="StatoEsteroResidenza" type="{}StatoEsteroResidenza" minOccurs="0"/&gt;
             *         &lt;element name="StatoCivile" type="{}StatoCivile"/&gt;
             *         &lt;element name="CollocazioneSocioAmbientale" type="{}CollocazioneSocioAmbientale"/&gt;
             *         &lt;element name="TitoloStudio" type="{}TitoloStudio"/&gt;
             *         &lt;element name="CodiceProfessionale" type="{}CodiceProfessionale"/&gt;
             *         &lt;element name="TipoOperazione" type="{}TipoOperazione"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "idRec",
                "cuni",
                "validitaCI",
                "tipologiaCI",
                "annoNascita",
                "sesso",
                "cittadinanza",
                "codiceRegioneResidenza",
                "aslResidenza",
                "statoEsteroResidenza",
                "statoCivile",
                "collocazioneSocioAmbientale",
                "titoloStudio",
                "codiceProfessionale",
                "tipoOperazione"
            })
            public static class Assistito {

                @XmlElement(name = "Id_Rec", required = true)
                protected String idRec;
                @XmlElement(name = "CUNI", required = true)
                protected String cuni;
                @XmlElement(required = true)
                protected BigInteger validitaCI;
                @XmlElement(required = true)
                protected BigInteger tipologiaCI;
                @XmlElement(name = "AnnoNascita", required = true)
                protected String annoNascita;
                @XmlElement(name = "Sesso", required = true)
                protected String sesso;
                @XmlElement(name = "Cittadinanza", required = true)
                protected String cittadinanza;
                @XmlElement(name = "CodiceRegioneResidenza", required = true)
                protected String codiceRegioneResidenza;
                @XmlElement(name = "ASLResidenza", required = true)
                protected String aslResidenza;
                @XmlElement(name = "StatoEsteroResidenza")
                protected String statoEsteroResidenza;
                @XmlElement(name = "StatoCivile", required = true)
                protected String statoCivile;
                @XmlElement(name = "CollocazioneSocioAmbientale", required = true)
                protected String collocazioneSocioAmbientale;
                @XmlElement(name = "TitoloStudio", required = true)
                protected String titoloStudio;
                @XmlElement(name = "CodiceProfessionale", required = true)
                protected String codiceProfessionale;
                @XmlElement(name = "TipoOperazione", required = true, defaultValue = "I")
                @XmlSchemaType(name = "string")
                protected TipoOperazione tipoOperazione;

                /**
                 * Recupera il valore della propriet� idRec.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIdRec() {
                    return idRec;
                }

                /**
                 * Imposta il valore della propriet� idRec.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIdRec(String value) {
                    this.idRec = value;
                }

                /**
                 * Recupera il valore della propriet� cuni.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCUNI() {
                    return cuni;
                }

                /**
                 * Imposta il valore della propriet� cuni.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCUNI(String value) {
                    this.cuni = value;
                }

                /**
                 * Recupera il valore della propriet� validitaCI.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getValiditaCI() {
                    return validitaCI;
                }

                /**
                 * Imposta il valore della propriet� validitaCI.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setValiditaCI(BigInteger value) {
                    this.validitaCI = value;
                }

                /**
                 * Recupera il valore della propriet� tipologiaCI.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTipologiaCI() {
                    return tipologiaCI;
                }

                /**
                 * Imposta il valore della propriet� tipologiaCI.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTipologiaCI(BigInteger value) {
                    this.tipologiaCI = value;
                }

                /**
                 * Recupera il valore della propriet� annoNascita.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAnnoNascita() {
                    return annoNascita;
                }

                /**
                 * Imposta il valore della propriet� annoNascita.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAnnoNascita(String value) {
                    this.annoNascita = value;
                }

                /**
                 * Recupera il valore della propriet� sesso.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSesso() {
                    return sesso;
                }

                /**
                 * Imposta il valore della propriet� sesso.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSesso(String value) {
                    this.sesso = value;
                }

                /**
                 * Recupera il valore della propriet� cittadinanza.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCittadinanza() {
                    return cittadinanza;
                }

                /**
                 * Imposta il valore della propriet� cittadinanza.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCittadinanza(String value) {
                    this.cittadinanza = value;
                }

                /**
                 * Recupera il valore della propriet� codiceRegioneResidenza.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodiceRegioneResidenza() {
                    return codiceRegioneResidenza;
                }

                /**
                 * Imposta il valore della propriet� codiceRegioneResidenza.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodiceRegioneResidenza(String value) {
                    this.codiceRegioneResidenza = value;
                }

                /**
                 * Recupera il valore della propriet� aslResidenza.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getASLResidenza() {
                    return aslResidenza;
                }

                /**
                 * Imposta il valore della propriet� aslResidenza.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setASLResidenza(String value) {
                    this.aslResidenza = value;
                }

                /**
                 * Recupera il valore della propriet� statoEsteroResidenza.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStatoEsteroResidenza() {
                    return statoEsteroResidenza;
                }

                /**
                 * Imposta il valore della propriet� statoEsteroResidenza.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStatoEsteroResidenza(String value) {
                    this.statoEsteroResidenza = value;
                }

                /**
                 * Recupera il valore della propriet� statoCivile.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStatoCivile() {
                    return statoCivile;
                }

                /**
                 * Imposta il valore della propriet� statoCivile.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStatoCivile(String value) {
                    this.statoCivile = value;
                }

                /**
                 * Recupera il valore della propriet� collocazioneSocioAmbientale.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCollocazioneSocioAmbientale() {
                    return collocazioneSocioAmbientale;
                }

                /**
                 * Imposta il valore della propriet� collocazioneSocioAmbientale.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCollocazioneSocioAmbientale(String value) {
                    this.collocazioneSocioAmbientale = value;
                }

                /**
                 * Recupera il valore della propriet� titoloStudio.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTitoloStudio() {
                    return titoloStudio;
                }

                /**
                 * Imposta il valore della propriet� titoloStudio.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTitoloStudio(String value) {
                    this.titoloStudio = value;
                }

                /**
                 * Recupera il valore della propriet� codiceProfessionale.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodiceProfessionale() {
                    return codiceProfessionale;
                }

                /**
                 * Imposta il valore della propriet� codiceProfessionale.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodiceProfessionale(String value) {
                    this.codiceProfessionale = value;
                }

                /**
                 * Recupera il valore della propriet� tipoOperazione.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TipoOperazione }
                 *     
                 */
                public TipoOperazione getTipoOperazione() {
                    return tipoOperazione;
                }

                /**
                 * Imposta il valore della propriet� tipoOperazione.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TipoOperazione }
                 *     
                 */
                public void setTipoOperazione(TipoOperazione value) {
                    this.tipoOperazione = value;
                }

            }

        }

    }

}
