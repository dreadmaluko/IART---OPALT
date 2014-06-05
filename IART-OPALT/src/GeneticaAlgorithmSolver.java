import java.io.IOException;

import Algorithm.Genetic.Chromosome;
import Algorithm.Genetic.Population;
import GeographicArea.GeographicArea;


public class GeneticaAlgorithmSolver {

	
	private GeographicArea ga;
	// The size of the simulation population
	final int populationSize = 2048;

	// The maximum number of generations for the simulation.
	final int maxGenerations = 16384;

	// The probability of crossover for any member of the population,
	// where 0.0 <= crossoverRatio <= 1.0
	final float crossoverRatio = 0.8f;

	// The portion of the population that will be retained without change
	// between evolutions, where 0.0 <= elitismRatio < 1.0
	final float elitismRatio = 0.1f;

	// The probability of mutation for any member of the population,
	// where 0.0 <= mutationRatio <= 1.0
	final float mutationRatio = 0.03f;
	
	
	
	public GeneticaAlgorithmSolver() throws IOException{
		ga = new GeographicArea();
	}
	
	public void solve(){
		
		long startTime = System.currentTimeMillis();
		
		Population pop = new Population(populationSize, crossoverRatio, 
			elitismRatio, mutationRatio);
		int i = 0;
		Chromosome best = pop.getPopulation()[0];

		while ((i++ <= maxGenerations) && (best.getFitness() != 0)) {
			System.out.println("Generation " + i + ": " + best.getGene());
			pop.evolve();
			best = pop.getPopulation()[0];
		}
				

		long endTime = System.currentTimeMillis();


		System.out.println("Generation " + i + ": " + best.getGene());
		System.out.println("Total execution time: " + (endTime - startTime) + "ms");
		
		ga.setNewUtilitiesDistribution(best.getGene().toCharArray());
		
		ga.printInfo();
	}

	public static void main(String[] args) throws IOException {

		new GeneticaAlgorithmSolver().solve();

		
	}
}
