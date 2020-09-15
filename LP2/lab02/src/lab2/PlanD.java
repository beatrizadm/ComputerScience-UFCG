/*
 * Alguns comentários: 
 * 
 * FEITO
 * - Em Estudo, o atributo minutos só mantem o último valor adicionado. 
 * (REVER ISSO)      Na verdade, o getMinutos deveria retornar o total.                    
 * O deve descansar também pode ter um retorno mais direto: "return this.total >= 120" 
 * 
 * FEITO
 * - Em Lazer, é melhor só procurar quem é o menor quando fizer o getMenor. O mesmo para o maior. 
 * A lógica é de que, da maneira como está, seria necessário se preocupar 
 * em reacalcular menor e maior a cada vez q tarefa fosse trabalhada. 
 * Deixa que o método cuide disso. Daí não precisaria ter os atributos maior/menor, o q simplifica o objeto. 
 * 
 * FEITO
 * - Em Organizacao, o atributo media não é usado fora do escopo local do mediatarefa. 
 * Deixa ele como uma variável local mesmo. 
 * Também é desnecessário ter o atributo idTarefa, pode usar uma variável de escopo local para isso mesmo. 
 * 
 * 
 * Bom lab, só essas alterações, mas já pode seguir em frente por lab 3. 
 * P.S. a nota que dou é 0 (tenta ajeitar os erros) 
 * ou 1 (pode ajeitar, mas se quiser, pode prosseguir pro lab 3)
 * 
 */


package lab2; 

public class PlanD {
    public static void main(String[] args) {

    	
    	/*
            Estudo estudoP2 = new Estudo("Classes e Objetos");
            estudoP2.adicionaMinutos(10);
            System.out.println(estudoP2.deveDescansar()); // false
            estudoP2.adicionaMinutos(120);
            System.out.println(estudoP2.deveDescansar()); // true, estudo > 120 min
            System.out.println(estudoP2.toString()); // Classes e Objetos (130 min)
            System.out.println("====");
            Estudo estudoCalculo = new Estudo("Integrais");
            estudoCalculo.adicionaMinutos(1);
            System.out.println(estudoCalculo.deveDescansar()); // false
            System.out.println(estudoCalculo.toString()); // Integrais (10 min)             
            System.out.println("====");
      	*/
            int numTarefas = 3;
          
            Organizacao orgQuarto = new Organizacao("Quarto", numTarefas);
            orgQuarto.cadastraTarefa(0, 5);   
            orgQuarto.cadastraTarefa(1, 20); 
            orgQuarto.cadastraTarefa(2, 5);
          
            //System.out.println(orgQuarto.getArrayTarefas(1)); // 20
            System.out.println(orgQuarto.mediaTarefa()); // 10
            orgQuarto.cadastraTarefa(1, 5);
            System.out.println(orgQuarto.mediaTarefa()); // 5
            System.out.println(orgQuarto.toString()); // Quarto (3 tarefas, 5min/tarefa)
            System.out.println("====");
           /*
            
             
            
            Lazer tv = new Lazer("TV", 180);  // limite de 180 minutos e 180 atividades
            tv.cadastraAtividade("Fruit Basket", 24);             
            tv.cadastraAtividade("BoJack Horseman", 22);             
            tv.cadastraAtividade("Black Mirror", 48);
            tv.cadastraAtividade("Cidade de Deus", 135); // n vai ser cadastrado,passa do limite de minutos
            System.out.println(tv.totalAtividades());
            System.out.println(tv.tempoTotal());
            System.out.println(tv.toString());
            Lazer piano = new Lazer("Piano");  // limite padrão de 60 min
            System.out.println(piano.totalAtividades()); // 0
           */
    }  
}
