package com.cursojava;

/* Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
 * - 0 si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 */

public class TresEnLineaApp
{
	private static int ROWS = 3;
	private static int COLS = 3;
	private static String RET_X = "X";
	private static String RET_O = "O";
	private static String RET_TIE = "Empate";
	private static String RET_NULL = "Nulo";
	private static String RET_ERR = "ERROR";
	private static String RET_BOTH = "0";
	
	public static void main(String[] args)
	{
		String[][] mat = { {"X", "X", "X"}, {"O", "X", "O"}, {"O", "O", "X"} };
		String res = analizeGame(mat);
		
		logMatrix(mat);
		
		if(res.equals(RET_X))
		{
			System.out.println("Ganaron las X");
		}
		else if(res.equals(RET_O))
		{
			System.out.println("Ganaron las O");
		}
		else if(res.equals(RET_TIE))
		{
			System.out.println("Empate");
		}
		else if(res.equals(RET_BOTH))
		{
			System.out.println("Ganaron ambos");
		}
		else if(res.equals(RET_NULL))
		{
			System.out.println("Cantidad de X y O incorrecta");
		}
		else if(res.equals(RET_ERR))
		{
			System.out.println("Error en los datos");
		}
	}

	public static String analizeGame(String[][] mat)
	{
		String res = "";
		int countX = 0, countO = 0;
		
		// Comprobamos que la matriz sea correcta, que todos sean X y O (y vacío) y que haya a los sumo uno de diferencia entre ambos
		for(int r = 0; r < ROWS; ++r)
		{
			for(int c = 0; c < COLS; ++c)
			{
				if(mat[r][c].equalsIgnoreCase("X"))
				{
					++countX;
				}
				else if(mat[r][c].equalsIgnoreCase("O"))
				{
					++countO;
				}
				else if(mat[r][c].isEmpty())
				{
					// Es válido
				}
				else
				{
					// Otro valor no esperado, agrego otro tipo de retorno 
					return RET_ERR;
				}
			}
		}
		if(Math.abs(countX - countO) > 1)
		{
			return RET_NULL;
		}
		// Me fijo si hay alguna línea ganadora con X
		countX = 0;
		countO = 0;
		for(int r = 0; r < ROWS; ++r)
		{
			if(mat[r][0].equals("X") && mat[r][1].equals("X") && mat[r][2].equals("X"))
			{
				++countX;
			}
			else if(mat[r][0].equals("O") && mat[r][1].equals("O") && mat[r][2].equals("O"))
			{
				++countO;
			}
		}
		for(int c = 0; c < COLS; ++c)
		{
			if(mat[0][c].equals("X") && mat[1][c].equals("X") && mat[2][c].equals("X"))
			{
				++countX;
			}
			else if(mat[0][c].equals("O") && mat[1][c].equals("O") && mat[2][c].equals("O"))
			{
				++countO;
			}
		}
		if(mat[1][1].equals("X"))
		{
			if(mat[0][0].equals("X") && mat[2][2].equals("X"))
			{
				++countX;
			}
			if(mat[2][0].equals("X") && mat[0][2].equals("X"))
			{
				++countX;
			}
		}
		else if(mat[1][1].equals("O"))
		{
			if(mat[0][0].equals("O") && mat[2][2].equals("O"))
			{
				++countO;
			}
			if(mat[2][0].equals("O") && mat[0][2].equals("O"))
			{
				++countO;
			}
		}
		if(countO > countX)
		{
			return RET_O;
		}
		if(countX > countO)
		{
			return RET_X;
		}
		if(countX == countO)
		{
			if(countX == 0)
			{
				return RET_TIE;	
			}
			else
			{
				return RET_BOTH;
			}
		}
		return res;
	}
	
	public static void logMatrix(String[][] mat)
	{
		for(int r = 0; r < ROWS; ++r)
		{
			for(int c = 0; c < COLS; ++c)
			{
				if(mat[r][c].isEmpty())
				{
					System.out.print("  ");
				}
				else
				{
					System.out.print(mat[r][c] + " ");
				}
			}
			System.out.println();
		}
	}

}
