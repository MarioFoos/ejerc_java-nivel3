package com.cursojava;

import java.util.ArrayList;

/**
 * Crea una funci�n que sea capaz de dibujar el "Tri�ngulo de Pascal" indic�ndole �nicamente el tama�o del lado.
 * Aqu� puedes ver r�pidamente c�mo se calcula el tri�ngulo:
 * https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 */
public class PascalApp
{
	public static void main(String[] args)
	{
		/**
		 *         1
		 *       1  1
		 *     1  2  1
		 *    1  3  3  1
		 *  1  4  6  4  1
		 * 1 5  10 10  5  1
		 */
		printPascal(2);
	}
	public static void printPascal(int rows)
	{
		for(int i = 0; i < rows; ++i)
		{
			System.out.println(genRow(i + 1));
		}
	}
	public static ArrayList<Integer> genRow(int row)
	{
		ArrayList<Integer> line = new ArrayList<>();
		if(row == 1)
		{
			line.add(1);
			return line;
		}
		if(row == 2)
		{
			line.add(1);
			line.add(1);
			return line;
		}
		ArrayList<Integer> prev = genRow(row - 1);
		// El primer y �ltimo n�mero siempre son 1
		line.add(1);
		for(int i = 0; i < row - 2; ++i)
		{
			// Tomo la suma de los dos n�meros de arriba
			line.add(prev.get(i) + prev.get(i + 1));
		}
		line.add(1);
		return line;
	}
}
