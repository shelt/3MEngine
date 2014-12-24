// Copyright (c) 2014 Sam Shelton

package ca.shelt.base.engine;

public class Matrix4D
{
	private float [][] matrix;
	
	public Matrix4D()
	{
		matrix = new float[4][4];
	}
	
	public Matrix4D toID()
	{
		matrix[0][0] = 1;
		matrix[1][0] = 0;
		matrix[2][0] = 0;
		matrix[3][0] = 0;
		
		matrix[0][1] = 0;
		matrix[1][1] = 1;
		matrix[2][1] = 0;
		matrix[3][1] = 0;
		
		matrix[0][2] = 0;
		matrix[1][2] = 0;
		matrix[2][2] = 1;
		matrix[3][2] = 0;
		
		matrix[0][3] = 0;
		matrix[1][3] = 0;
		matrix[2][3] = 0;
		matrix[3][3] = 1;
		
		return this;
	}
	
	public Matrix4D mult(Matrix4D matrix)
	{
		Matrix4D result = new Matrix4D();
		
		for(int i=0; i<4; i++)
		{
			for(int k=0; k<4; k++)
			{
				matrix.set(i,k, this.matrix[i][0] * matrix.get(0,k) +
								this.matrix[i][1] * matrix.get(1,k) +
								this.matrix[i][2] * matrix.get(2,k) + 
								this.matrix[i][3] * matrix.get(3,k));
			}
		}
	}
	
	public float[][] getMatrix()
	{
		return matrix;
	}
	
	public float get(int x, int y)
	{
		return matrix[x][y];
	}
	
	public void set(float[][] matrix)
	{
		this.matrix = matrix;
	}
}
