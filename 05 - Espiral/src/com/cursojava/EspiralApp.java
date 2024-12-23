package com.cursojava;

/**
 * Crea una función que dibuje una espiral como la del ejemplo. Únicamente se indica de forma dinámica el tamaño del lado.
 * Símbolos permitidos: ═ ║ ╗ ╔ ╝ ╚
 * Ejemplo espiral de lado 5 (5 filas y 5 columnas):
 * 	════╗
 * 	╔══╗║
 * 	║╔╗║║
 * 	║╚═╝║
 * 	╚═══╝
 */
public class EspiralApp
{
	public static void main(String[] args)
	{
		int side = 5;
		
		char[][] mat = new char[side][side];
		for(int i = 0; i < side; ++i)
		{
			for(int j = 0; j < side; ++j)
			{
				mat[i][j] = '_';	// Caracter para cuando no haya nada cargado
			}
		}
		for(int i = 0; i <= side/2; ++i)
		{
			fillSquare(mat, i, i);
		}
		show(mat);
	}
	public static void fillSquare(char[][] mat, int row, int col)
	{
		int side = mat[0].length;
		
		fill2Right(mat, row);
		fill2Bottom(mat, side - col - 1);
		fill2left(mat, side - col - 1);
		fill2Top(mat, col);
	}
	public static void fill2Top(char[][] mat, int col)
	{
		int side = mat[0].length;
		for(int r = side - 1; r >= 0; --r)
		{
			if(mat[r][col] == '_')
			{
				if(r > 0 && mat[r - 1][col] == '_')
				{
					mat[r][col] = '║';
				}
				else
				{
					mat[r][col] = '╔';
				}
			}
		}
	}
	public static void fill2left(char[][] mat, int row)
	{
		int side = mat[0].length;
		for(int c = side - 1; c >= 0; --c)
		{
			if(mat[row][c] == '_')
			{
				if(c > 0 && mat[row][c - 1] == '_')
				{
					mat[row][c] = '═';
				}
				else
				{
					mat[row][c] = '╚';
				}
			}
		}
	}
	public static void fill2Bottom(char[][] mat, int col)
	{
		int side = mat[0].length;
		for(int r = 0; r < side; ++r)
		{
			if(mat[r][col] == '_')
			{
				if(r < side - 1 && mat[r + 1][col] == '_')
				{
					mat[r][col] = '║';
				}
				else
				{
					mat[r][col] = '╝';
				}
			}
		}
	}
	public static void fill2Right(char[][] mat, int row)
	{
		int side = mat[0].length;
		for(int c = 0; c < side; ++c)
		{
			if(mat[row][c] == '_')
			{
				if(c < side -1 && mat[row][c + 1] == '_')
				{
					mat[row][c] = '═';
				}
				else
				{
					mat[row][c] = '╗';
				}
			}
		}
	}
	public static void show(char[][] mat)
	{
		int side = mat[0].length;
		
		// Filas
		for(int i = 0; i < side; ++i)
		{
			// Columnas
			for(int j = 0; j < side; ++j)
			{
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
}
