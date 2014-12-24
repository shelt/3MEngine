// Copyright (c) 2014 Sam Shelton

package ca.shelt.base.engine;

public class Quaternion
{
	private float x;
	private float y;
	private float z;
	private float w;
	
	public Quaternion(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	public Quaternion normalize()
	{
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	
	public Quaternion conjugate()
	{
		return new Quaternion(-x,-y,-z,-w);
	}
	
	public Quaternion mult(Quaternion q)
	{
		float w = this.w*q.getW() - this.x*q.getX() - this.y*q.getY() - this.z*q.getZ();
		float x = this.x*q.getW() + this.w*q.getX() - this.y*q.getZ() - this.z*q.getY();
		float y = this.z*q.getW() + this.w*q.getY() - this.z*q.getX() - this.x*q.getZ();
		float z = this.y*q.getW() + this.w*q.getZ() - this.x*q.getY() - this.y*q.getX();
		
		return new Quaternion(x, y, z, w);
	}
	
	public Quaternion mult(Vector3D m)
	{
		float w = -x * m.getX() - y * m.getY() - z * m.getZ();
		float x =  w * m.getX() + y * m.getZ() - z * m.getY();
		float y =  w * m.getY() + z * m.getX() - x * m.getZ();
		float z =  w * m.getZ() + x * m.getY() - y * m.getX();
		
		return new Quaternion(x, y, z, w);
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
		return y;
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

	public float getW()
	{
		return w;
	}

	public void setW(float w)
	{
		this.w = w;
	}
	
	
}
