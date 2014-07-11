package jaframework.imp;

import java.lang.reflect.Field;

public class JAFileModel {
	private String name;
	private Field[] atributos;
	private Class<?> clazz;
	
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Field[] getAtributos() {
		return atributos;
	}
	public void setAtributos(Field[] atributos) {
		this.atributos = atributos;
	}
}
