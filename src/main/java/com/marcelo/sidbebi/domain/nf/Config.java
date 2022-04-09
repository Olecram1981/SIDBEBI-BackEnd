package com.marcelo.sidbebi.domain.nf;

import java.io.FileNotFoundException;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;

public class Config {
	
	public static ConfiguracoesNfe iniciaConfiguracoes() throws NfeException, FileNotFoundException, CertificadoException {
		Certificado certificado = CertificadoService.certificadoPfx(null, null);
			
		return ConfiguracoesNfe.criarConfiguracoes(EstadosEnum.MT, AmbienteEnum.HOMOLOGACAO, certificado, "C:\\SRA\\Nfe\\Schemas");
	}

}
