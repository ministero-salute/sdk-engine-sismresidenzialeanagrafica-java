/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.sism.residenziale.anag;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"it.mds.sdk.flusso.sism.residenziale.anag.controller", "it.mds.sdk.flusso.sism.residenziale.anag","it.mds.sdk.rest.persistence.entity",
        "it.mds.sdk.libreriaregole.validator",
        "it.mds.sdk.flusso.sism.residenziale.anag.service", "it.mds.sdk.flusso.sism.residenziale.anag.tracciato",
        "it.mds.sdk.gestoreesiti", "it.mds.sdk.flusso.sism.residenziale.anag.parser.regole","it.mds.sdk.flusso.sism.residenziale.anag.parser.regole.conf",
        "it.mds.sdk.connettoremds"})

@OpenAPIDefinition(info=@Info(title = "SDK Ministero Della Salute - Flusso ANR", version = "0.0.5-SNAPSHOT", description = "Flusso Sism Residenziale Anagrafica"))
public class FlussoSismResidenzialeAnagrafica {

    public static void main(String[] args) {
        SpringApplication.run(FlussoSismResidenzialeAnagrafica.class, args);
    }

}
