package testes.aceitacao;

import easyaccept.EasyAccept;

public class TestesAceitacao {
	public static void main(String[] args) {
		args = new String[] { "facade.Facade", 
				"testes_aceitacao/use_case_1.txt", 
				"testes_aceitacao/use_case_2.txt",
				"testes_aceitacao/use_case_3.txt", 
				"testes_aceitacao/use_case_4.txt",
				"testes_aceitacao/use_case_5.txt", 
				"testes_aceitacao/use_case_6.txt", 
				"testes_aceitacao/use_case_7.txt"
				};
		EasyAccept.main(args);
	}
}

