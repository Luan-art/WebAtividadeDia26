package model;

public class Tarefa {
	
	 private int id;
	 private String titulo;
	 private String descriacao;
	 private String status;
	 private String data_criacao;
	 private String data_conclusao;
	 private int idUser;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescriacao() {
		return descriacao;
	}
	public void setDescriacao(String descriacao) {
		this.descriacao = descriacao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(String data_criacao) {
		this.data_criacao = data_criacao;
	}
	public String getData_conclusao() {
		return data_conclusao;
	}
	public void setData_conclusao(String data_conclusao) {
		this.data_conclusao = data_conclusao;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	 
   
}
