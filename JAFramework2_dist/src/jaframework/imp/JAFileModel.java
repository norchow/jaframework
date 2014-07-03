package jaframework.imp;

import java.util.HashMap;

public class JAFileModel {
	private String name;
	private HashMap<String, Integer> atributos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, Integer> atributos) {
		this.atributos = atributos;
	}
}
