
public class NeuronioSaida {
	private double[] inputs;
	private double threshold = 0.5; // valor default, acima disso a saida � 1, e abaixo a saida � 0
	
	public void setInputs(double inputs[])
	{
		this.inputs = inputs;
	}
	
	public double inputFunction()
	{
		int numeroDeEntradas = inputs.length;
		if(RedeNeural.weights.length != numeroDeEntradas)
		{
			System.out.println("Erro: O numero de pesos nao eh o mesmo numero de entradas!");
			return 0;
		}
		
		int soma = 0;
		for(int i = 0; i < numeroDeEntradas; i++)
		{
			soma += inputs[i]*RedeNeural.weights[i];
		}
		
		soma += RedeNeural.bias;
		return soma;		
	}
	
	
	// estamos utilizando uma fun��o degrau, que � 1 apartir do threshold, e 0 antes dele.
	public double activationFunction(double inputFunctionResult)
	{
	  if (inputFunctionResult >= threshold) return 1;
	  return 0;
	}
	

}
