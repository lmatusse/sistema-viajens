package mz.co.ldevz.entity;

public enum UsuarioPerfil {
ADMIN(1, "ADMIN"), CLIENTE(2, "CLIENTE"), FUNCIONARIO(3, "FUNCIONARIO");
	
	private long cod;
	private String desc;

	private UsuarioPerfil(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
