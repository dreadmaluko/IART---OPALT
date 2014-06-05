package Algorithm.Genetic;
import java.util.Arrays;
import java.util.Random;

public class Population {

	private static final int TOURNAMENT_SIZE = 3;

	private static final Random rand = new Random(System.currentTimeMillis());

	private float elitism;
	private float mutation;
	private float crossover;
	private Chromosome[] popArr;


	public Population(int size, float crossoverRatio, float elitismRatio, 
			float mutationRatio) {

		this.crossover = crossoverRatio;
		this.elitism = elitismRatio;
		this.mutation = mutationRatio;
		
		generatePopulation(size);	
	}
	
	private void generatePopulation(int size){
		// Generate an initial population
		this.popArr = new Chromosome[size];
		for (int i = 0; i < size; i++) {
			this.popArr[i] = Chromosome.generateRandom();
		}

		Arrays.sort(this.popArr);
	}

	public void evolve() {
		// Create a buffer for the new generation
		Chromosome[] buffer = new Chromosome[popArr.length];

		// Copy over a portion of the population unchanged, based on 
		// the elitism ratio.
		int idx = Math.round(popArr.length * elitism);
		System.arraycopy(popArr, 0, buffer, 0, idx);

		// Iterate over the remainder of the population and evolve as 
		// appropriate.
		while (idx < buffer.length) {
			// Check to see if we should perform a crossover. 
			if (rand.nextFloat() <= crossover) {

				// Select the parents and mate to get their children
				Chromosome[] parents = selectParents();
				Chromosome[] children = parents[0].mate(parents[1]);

				// Check to see if the first child should be mutated.
				if (rand.nextFloat() <= mutation) {
					buffer[idx++] = children[0].mutate();
				} else {
					buffer[idx++] = children[0];
				}

				// Repeat for the second child, if there is room.
				if (idx < buffer.length) {
					if (rand.nextFloat() <= mutation) {
						buffer[idx] = children[1].mutate();
					} else {
						buffer[idx] = children[1];
					}
				}
			} else { // No crossover, so copy verbatium.
				// Determine if mutation should occur.
				if (rand.nextFloat() <= mutation) {
					buffer[idx] = popArr[idx].mutate();
				} else {
					buffer[idx] = popArr[idx];
				}
			}

			// Increase our counter
			++idx;
		}

		// Sort the buffer based on fitness.
		Arrays.sort(buffer);

		// Reset the population
		popArr = buffer;
	}

	public Chromosome[] getPopulation() {
		Chromosome[] arr = new Chromosome[popArr.length];
		System.arraycopy(popArr, 0, arr, 0, popArr.length);

		return arr;
	}

	public float getElitism() {
		return elitism;
	}

	public float getCrossover() {
		return crossover;
	}

	public float getMutation() {
		return mutation;
	}

	private Chromosome[] selectParents() {
		Chromosome[] parents = new Chromosome[2];

		// Randomly select two parents via tournament selection.
		for (int i = 0; i < 2; i++) {
			parents[i] = popArr[rand.nextInt(popArr.length)];
			for (int j = 0; j < TOURNAMENT_SIZE; j++) {
				int idx = rand.nextInt(popArr.length);
				if (popArr[idx].compareTo(parents[i]) < 0) {
					parents[i] = popArr[idx];
				}
			}
		}

		return parents;
	}
}