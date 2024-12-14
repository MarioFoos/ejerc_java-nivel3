package com.cursojava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/* Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm)
 * de dos números enteros. No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente. 
 **/
public class MCD_MCM_App
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Números:");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		scanner.close();
		
		System.out.println("MCM: " + findMCM(num1, num2));
		System.out.println("MCD: " + findMCD(num1, num2));
	}
	/**
	 * Encontrar el MCD de dos números
	 * @param num1 Número 1
	 * @param num2 Número 2
	 * @return MCD
	 */
	public static int findMCD(int num1, int num2)
	{
		// Factors de ambos números
		HashMap<Integer, Integer> factors1 = findFactors(num1);
		HashMap<Integer, Integer> factors2 = findFactors(num2);
		
		// Para el MCD busco solo los factores comunes con el menor exponente
		HashMap<Integer, Integer> factorsMCD = new HashMap<>();
		// Recorro los primeros buscando en los segundos
		for(Entry<Integer, Integer> entry1 : factors1.entrySet())
		{
			for(Entry<Integer, Integer> entry2 : factors2.entrySet())
			{
				if(entry1.getKey() == entry2.getKey())
				{
					factorsMCD.put(entry1.getKey(), (entry1.getValue() < entry2.getValue()) ? entry1.getValue() : entry2.getValue());
				}
			}
		}
		return buildNumber(factorsMCD);
	}
	
	/**
	 * Encontrar el MCM de dos números
	 * @param num1 Número 1
	 * @param num2 Número 2
	 * @return MCM
	 */
	public static int findMCM(int num1, int num2)
	{
		// Factors de ambos números
		HashMap<Integer, Integer> factors1 = findFactors(num1);
		HashMap<Integer, Integer> factors2 = findFactors(num2);
		
		// Para el múltiplo común menor busco los factores comunes y no comunes con el mayor exponente
		HashMap<Integer, Integer> factorsMCM = new HashMap<>();
		for(Entry<Integer, Integer> entry : factors1.entrySet())
		{
			int prime = entry.getKey();
			int exp = entry.getValue();
			
			if(!factorsMCM.containsKey(prime) || exp > factorsMCM.get(prime))
			{
				factorsMCM.put(prime, exp);
			}
		}
		for(Entry<Integer, Integer> entry : factors2.entrySet())
		{
			int prime = entry.getKey();
			int exp = entry.getValue();
			
			if(!factorsMCM.containsKey(prime) || exp > factorsMCM.get(prime))
			{
				factorsMCM.put(prime, exp);
			}
		}
		return buildNumber(factorsMCM);
	}
	/**
	 * Calculo el número a partir de sus factores
	 * @param factors Factores
	 * @return Número
	 */
	public static int buildNumber(HashMap<Integer, Integer> factors)
	{
		int num = 1;
		for(Entry<Integer, Integer> entry : factors.entrySet())
		{
			num *= (int) Math.pow(entry.getKey(), entry.getValue());
		}
		return num;
	}
	
	/**
	 * Encontrar los factores del número
	 * @param num Número
	 * @return Factores
	 */
	public static HashMap<Integer, Integer> findFactors(int num)
	{
		// Busco los primos hasta el número dado por si es primo
		ArrayList<Integer> primes = findPrimes(num);
		HashMap<Integer, Integer> factors = new HashMap<>();
		int exp = 0;
	
		for(int prime : primes)
		{
			if((exp = isDivisible(num, prime)) > 0)
			{
				factors.put(prime, exp);
			}
		}
		return factors;
	}
	
	/**
	 * Compruebo cuantas veces se puede dividir el número por el primo para hallar el exponente 
	 * @param num Numero
	 * @param prime Primo
	 * @return Exponente
	 */
	public static int isDivisible(int num, int prime)
	{
		if(prime == 1)
		{
			return 0;
		}
		int exp = 0;
		while(num%prime == 0)
		{
			num /= prime;
			++exp;
		}
		return exp;
	}
	/**
	 * Encontrar todos los primos hasta max
	 * @param max Máximo
	 * @return Primos
	 */
	public static ArrayList<Integer> findPrimes(int max)
	{
		ArrayList<Integer> primes = new ArrayList<>();
		int prime;
		while(true)
		{
			prime = findNextPrime(primes);
			if(prime > max)
			{
				break;
			}
			primes.add(prime);
		}
		return primes;
	}
	
	/**
	 * Encontrar el siguiente primo de una lista de números primos
	 * @param primes Primos
	 * @return Siguiente
	 */
	public static int findNextPrime(ArrayList<Integer> primes)
	{
		if(primes.isEmpty())
		{
			return 1;
		}
		int i = primes.get(primes.size() - 1);
		int next = i + 1;
		while(true)
		{
			// Testeo si el numero es divisible por alguno de la lista
			if(!isDivisible(next, primes))
			{
				return next;
			}
			++next;
		}
	}
	/**
	 * Comprueba si un número es divisible por una lista de números primos
	 * @param num Número
	 * @param primes Primos
	 * @return true si es divisible
	 */
	public static boolean isDivisible(int num, ArrayList<Integer> primes)
	{
		for(int prime : primes)
		{
			if(prime != 1 && num%prime == 0)
			{
				return true;
			}
		}
		return false;
	}
}
