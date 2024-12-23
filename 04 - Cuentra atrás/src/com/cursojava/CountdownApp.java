package com.cursojava;

import java.util.Scanner;

/**
 * Crea una funci�n que reciba dos par�metros para crear una cuenta atr�s.
 * - El primero, representa el n�mero en el que comienza la cuenta.
 * - El segundo, los segundos que tienen que transcurrir entre cada cuenta.
 * - S�lo se aceptan n�meros enteros positivos.
 * - El programa finaliza al llegar a cero.
 * - Debes imprimir cada n�mero de la cuenta atr�s.
 */
public class CountdownApp
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresar n�mero inicial:");
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
			System.out.println("Par�metros no v�lidos");
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

