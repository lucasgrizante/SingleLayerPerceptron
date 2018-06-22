import java.util.Random;

public class RedeNeural {
	public static double[] weights; // os pesos serão acessiveis em todas as classes.
	public static double bias = -1; // valor default.
	private double learningRate = 0.3; // valor default

	
	public RedeNeural(int numEntradas)
	{
		weights = new double[numEntradas];
		// gerar pesos aleatorios de 0 a 1
		Random r = new Random();
		for(int i = 0; i < numEntradas; i++)
		{
			weights[i] = r.nextDouble();
		}	
	}
	
	
	// caso queira, ja pode começar rede neural com os pesos corretos, pra nao precisar treinar, apenas pensar
	public RedeNeural(double pesos[])
	{
		weights = pesos;
	}
	
	public void setLearningRate(double learningRate)
	{
		this.learningRate = learningRate;
	}
	
	public void setBias(double bias)
	{
		this.bias = bias;
	}
	
	public void training(double [][] inputs, double[] expectedOutputs, int maxAttemptsOfTraining)
	{
		int count = 0;
		do{		
			for(int i = 0; i < inputs.length; i++)
			{
				double currentResult = think(inputs[i]);
				double error = expectedOutputs[i] - currentResult;
				
				// o comentario abaixo é pra debug, caso vc queira ver como ele calcula, tira as //.. fica bem intuitivo pra ver se esta certo ou nao prof Mauricio
				//System.out.println("i1: " + inputs[i][0] + " -- i2: " + inputs[i][1] + " -- r: " + currentResult + " -- er: " + error);
				if(error != 0)
				{
					// se nao acertou a predição, corrigir os pesos:
					for(int j = 0; j < weights.length; j++)
					{
						weights[j] = calculateNewWeight(weights[j], inputs[i][j], error);
					}
				}
			}
		}while(++count < maxAttemptsOfTraining);		
	}
	
	private double calculateNewWeight(double currentWeigth, double input, double error)
	{
		double new_weight = 0;
		new_weight = currentWeigth + (learningRate * input * error);
			
		return new_weight;
	}
		
	
	public double think(double inputs[])
	{
		NeuronioSaida ns = new NeuronioSaida();
		ns.setInputs(inputs);			
		double inputFunctionResult = ns.inputFunction();	
		double currentOutput = ns.activationFunction(inputFunctionResult);
		return currentOutput;
	}
	
	public void showWeights()
	{
		if(weights == null) {
			System.out.println("Os pesos ainda nao foram inicializados");
			return;
		}
		int numeroDePesos = RedeNeural.weights.length;
		for(int i = 0; i < numeroDePesos; i++)
		{
			System.out.println("Peso " + i + ": " + RedeNeural.weights[i]);
		}
	}
}
