package com.cursojava;

import java.util.Scanner;

/**
 * Crea una función que reciba dos parámetros para crear una cuenta atrás.
 * - El primero, representa el número en el que comienza la cuenta.
 * - El segundo, los segundos que tienen que transcurrir entre cada cuenta.
 * - Sólo se aceptan números enteros positivos.
 * - El programa finaliza al llegar a cero.
 * - Debes imprimir cada número de la cuenta atrás.
 */
public class CountdownApp
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresar número inicial:");
		int init = scanner.nextInt();
		System.out.println("Ingresar intervalo en segundos:");
		int seconds = scanner.nextInt();
		scanner.close();
		
		countDown(init, seconds);
	}
	public static void countDown(int init, int seconds)
	{
		if(init < 0 || seconds < 0)
		{
			System.out.println("Parámetros no válidos");
			return;
		}
		for(int i = init; i > 0; --i)
		{
			System.out.println(i);
			try
			{
				Thread.sleep(1000*seconds);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("0 - Fin del programa");
	}
}

