package jaframework.demo;

import jaframework.def.annotations.Field;
import jaframework.def.annotations.File;
import jaframework.def.annotations.Index;

@File(name="ALUMNOS.txt", alias="ALUMNOS")
@Index(key="sexo-name", alias="IDX1")
public class Alumno
{
	@Field(size=4)
	private int legajo;
	
	@Field(size=10)
	private String name;
	
	@Field(size=10)
	private String fechaIngreso;
	
	@Field(size=1)
	private char sexo;
	
	@Field(size=2)
	private int nota;
	
	public int getNota()
	{
		return nota;
	}

	public void setNota(int nota)
	{
		this.nota=nota;
	}

	@Override
	public String toString()
	{
	   String linea = "";
	   linea+="legajo="+legajo+ ", name="+name+", ";
	   linea+="fechaIngreso="+fechaIngreso+", sexo="+sexo;
	   return linea;
	}

	public int getLegajo()
	{
		return legajo;
	}

	public void setLegajo(int legajo)
	{
		this.legajo = legajo;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFechaIngreso()
	{
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso)
	{
		this.fechaIngreso = fechaIngreso;
	}

	public char getSexo()
	{
		return sexo;
	}

	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}
}
