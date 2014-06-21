package jaframework.demo;

import jaframework.def.annotations.Field;
import jaframework.def.annotations.File;
import jaframework.def.annotations.Files;
import jaframework.def.annotations.Index;
import jaframework.def.annotations.Indexes;

//@Files( {@File(name="ALUMNOS1.TXT",alias="ALUMNOS1", index=@Index(key="pepe", alias="popo"))
//	    ,@File(name="ALUMNOS2.TXT",alias="ALUMNOS2") 
//	    ,@File(name="ALUMNOSOut.TXT",alias="ALUMNOSOut", indexes={@Index(key="plpl",alias="popop")})} )	    

@File(name="ALUMNOS.TXT")
@Index(key="sexo-name", alias="LEG")
//@Indexes({@Index(key="name",alias="N"),@Index(key="-legajo",alias="L")})
public class CopyOfAlumno_bkp
{
	@Field(size=4)
	private int legajo;
	
	@Field(size=10)
	private String name;
	
	@Field(size=10)
	private String fechaIngreso;
	
	@Field(size=1)
	private char sexo;
	
	@Override
	public String toString()
	{
		return "Alumno [legajo=" + legajo + ", name=" + name + ", fechaIngreso=" + fechaIngreso + ", sexo=" + sexo + "]";
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
