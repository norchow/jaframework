package jaframework.demo;

import jaframework.def.annotations.Field;
import jaframework.def.annotations.File;
import jaframework.def.annotations.Index;

@File(name="EMPLEADOS.txt")
@Index(key="-legajo", alias="legajo")
public class Empleado
{
	@Field(size=2)
	private int legajo;
	
	@Field(size=10)
	private String nombre;

	public void setLegajo(int legajo)
	{
		this.legajo = legajo;
	}

	public int getLegajo()
	{
		return legajo;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return nombre;
	}
	
	public Empleado(){}

	public Empleado(int legajo, String nombre)
	{
		super();
		this.legajo = legajo;
		this.nombre = nombre;
	}

	@Override
	public String toString()
	{
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + "]";
	}
	
	
}
