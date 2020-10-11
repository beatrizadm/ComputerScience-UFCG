package bonus;

public class Coisa {
	public static void main(String[] args) {
		
		ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC3");
        contaLCC2.consomeEspaco(123);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.consomeEspaco(10);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(3);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(4);
        System.out.println(contaLCC2.atingiuCota());
        System.out.println(contaLCC2.toString());

        Disciplina c1 = new Disciplina("Construtor 1");
        c1.cadastraHoras(4);
        c1.cadastraNota(1, 4.0);
        c1.cadastraNota(2, 5.0);
        c1.cadastraNota(3, 7.0);
        System.out.println(c1.aprovado());
        c1.cadastraNota(4, 10.0);
        System.out.println(c1.aprovado());
        System.out.println(c1.toString());

        Disciplina c2 = new Disciplina("Construtor 2", 5);
        c2.cadastraHoras(8);
        c2.cadastraNota(1, 4.0);
        c2.cadastraNota(2, 5.0);
        c2.cadastraNota(3, 7.0);
        System.out.println(c2.aprovado());
        c2.cadastraNota(4, 10.0);
        c2.cadastraNota(5, 9.0);
        System.out.println(c2.aprovado());
        System.out.println(c2.toString());

        Double[] pesos = {6.0, 4.0};
        Disciplina c3 = new Disciplina("Construtor 3", 2, pesos);
        c3.cadastraHoras(6);
        c3.cadastraNota(1, 5);
        System.out.println(c3.aprovado());
        c3.cadastraNota(2, 6);
        System.out.println(c3.aprovado());
        System.out.println(c3.toString());
        
        
        ContaCantina bg = new ContaCantina("BG");
        bg.cadastraLanche(3, 600, "X-Tudo");
        bg.cadastraLanche(2, 400, "Coixinha");
        bg.pagaConta(300);
        System.out.println(bg.listarDetalhes());
        System.out.println(bg.toString());
        
		
		Saude saude = new Saude();
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("fraca");
        saude.defineSaudeFisica("boa");
        saude.definirEmoji(":/");
        System.out.println(saude.getStatusGeral());
	}   
}


