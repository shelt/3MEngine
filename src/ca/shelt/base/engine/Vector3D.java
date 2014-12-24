package ca.shelt.base.engine;

public class Vector3D
{
	private float x;
	private float y;
	private float z;
	
	public Vector3D(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float dot(Vector3D v)
	{
		return (v.getX() * x) + (v.getY() + y) + (v.getZ() + z);
	}
	
	public Vector3D cross(Vector3D v)
	{
		float x = y * (v.getZ()) - z * (v.getY());
		float y = z * (v.getX()) - x * (v.getZ());
		float z = x * (v.getY()) - y * (v.getX());
		
		return new Vector3D(x, y, z);
	}
	
	public float length()
	{
		return (float) Math.sqrt(x*x + y*y + z*z);
	}
	
	public Vector3D normalize()
	{
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	
	public Vector2D rotate(float angle)//TODO
	{
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		return new Vector2D((float)(x * cos - y * sin), (float)(sin + y * cos));
	}
	
	/**
	 * VECTOR OPERATIONS
	 */
	public Vector3D add(Vector3D v)
	{
		return new Vector3D(x + v.getX(), y + v.getY(), z + v.getZ());
	}
	
	public Vector3D sub(Vector3D v)
	{
		return new Vector3D(x - v.getX(), y - v.getY(), z - v.getZ());
	}
	
	public Vector3D mult(Vector3D v)
	{
		return new Vector3D(x * v.getX(), y * v.getY(), z * v.getZ());
	}
	
	public Vector3D div(Vector3D v)
	{
		return new Vector3D(x / v.getX(), y / v.getY(), z / v.getZ());
	}
	
	/**
	 * SCALAR OPERATIONS
	 */
	public Vector3D sub(float s)
	{
		return new Vector3D(x - s, y - s, z - s);
	}
	public Vector3D add(float s)
	{
		return new Vector3D(x + s, y + s, z + s);
	}
	public Vector3D mult(float s)
	{
		return new Vector3D(x * s, y * s, z * s);
	}
	public Vector3D div(float s)
	{
		return new Vector3D(x / s, y / s, z / s);
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
	
	public float getZ()
	{
		return z;
	}
	public void setZ(float z)
	{
		this.z = z;
	}
	
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
	
}
