package br.com.javaparaweb.financeiro.usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	Usuario usuario = new Usuario();
	String confirmarSenha;
	
	public String novo(){
		this.usuario=new Usuario();
		this.usuario.setAtivo(true);
		return"publico/usuario";
	}
	public String salvar(){
		FacesContext context= FacesContext.getCurrentInstance();
		String senha=this.usuario.getSenha();
		if(!senha.equals(this.confirmarSenha)){
			FacesMessage facesMessage= new FacesMessage("A senha n�o foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		UsuarioRN usuarioRN= new UsuarioRN();
		usuarioRN.Salvar(this.usuario);
		
		return "usuariosucesso";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
