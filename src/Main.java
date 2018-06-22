import java.nio.channels.ShutdownChannelGroupException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Grupo: ");
		System.out.println("\tLucas Henrique Grizante\t\t 82928");
		System.out.println("\tDouglas Shoiti Yassuda \t\t 82823");
		System.out.println("\tIgor Mendonça da Silva \t\t 83042");
		System.out.println("\tNatalia Moraes de Arka \t\t 84223");
		System.out.println("\tIngrid do Couto Honório\t\t 82413");
		System.out.println();
		System.out.println("Single Layer Perceptron -- Rede neural de camada unica!");
		System.out.println("Testado com a porta AND e com a porta OR!");
		System.out.println();
		// o problema da porta AND que te mostrei na semana anterior, era o BIAS...
		// Procurei na internet, e falaram pra testar com BIAS = -1, ai deu certinho!
		
        double entradasConhecidas[][] = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };
        
        // porta AND   
        double saidasConhecidas[] = {
                0, 0, 0, 1 
                };
        /* Porta OR
         double saidasConhecidas[] = {
                0, 1, 1, 1 
                };        
         
         */
        
        RedeNeural rede = new RedeNeural(entradasConhecidas[0].length);
        rede.training(entradasConhecidas, saidasConhecidas, 10000);
        
        double valorAPensar[] = {0, 1}; 
        double resultado = rede.think(valorAPensar);
        
        System.out.print("Valor a Pensar: ");
        int numEntradas = valorAPensar.length;
        System.out.print(valorAPensar[0]);
        for(int i = 1; i < numEntradas; i++)
        {
        	System.out.print(", " + valorAPensar[i]);
        }
        System.out.println();
        System.out.println("Resultado: " + resultado);
        rede.showWeights();
	}
	

}
