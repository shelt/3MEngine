package ca.shelt.base.engine;

public class Vector2D
{
	private float x;
	private float y;
	
	public Vector2D(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public float length()
	{
		return (float) Math.sqrt(x*x + y*y);
	}
	
	public float dot(Vector2D v)
	{
		return (v.getX() * x) + (v.getY() + y);
	}
	
	public Vector2D normalize()
	{
		float length = length();
		
		x /= length;
		y /= length;
		
		return this;
	}
	
	public Vector2D rotate(float angle)
	{
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		return new Vector2D((float)(x * cos - y * sin), (float)(sin + y * cos));
	}
	

	
	public Vector2D add(Vector2D v)
	{
		return new Vector2D(x + v.getX(), y + v.getY());
	}
	
	public Vector2D add(float s)
	{
		return new Vector2D(x + s, y + s);
	}
	
	public Vector2D sub(Vector2D v)
	{
		return new Vector2D(x - v.getX(), y - v.getY());
	}
	
	public Vector2D sub(float s)
	{
		return new Vector2D(x - s, y - s);
	}
	
	public Vector2D mult(Vector2D v)
	{
		return new Vector2D(x * v.getX(), y * v.getY());
	}
	
	public Vector2D mult(float s)
	{
		return new Vector2D(x * s, y * s);
	}
	
	public Vector2D div(Vector2D v)
	{
		return new Vector2D(x / v.getX(), y / v.getY());
	}
	
	public Vector2D div(float s)
	{
		return new Vector2D(x / s, y / s);
	}
	
	
	/**
	 * [GS]ETTERS
	 */
	
	public float getX()
	{
		return x;
	}
	public void setX(float x)
	{
		this.x = x;
	}
	
	public float getY()
	{
		return x;
	}
	public void setY(float y)
	{
		this.y = y;
	}
	
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
}
