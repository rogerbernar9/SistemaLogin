package manager;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import entity.Usuario;
import persistence.UsuarioDao;

@ManagedBean(name="mb")
@SessionScoped
public class ManagerBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	 private Usuario logado;
	 private List<Usuario> usuarios;
	 
	 @ManagedProperty(value="#{usuarioDaoSpring}")
	 private UsuarioDao usuarioDao;

	 
	 public ManagerBean() {
	 this.logado = new Usuario();
     SecurityContext context = SecurityContextHolder.getContext();
     Authentication userLogado = context.getAuthentication();
	logado.setNome(((User) userLogado.getPrincipal()).getUsername());		  
	}

	 public List<Usuario> getUsuarios() {
		this.usuarios = usuarioDao.findAll();
		return usuarios;
	}
	 
	 
	public Usuario getLogado() {
		return logado;
	}


	public void setLogado(Usuario logado) {
		this.logado = logado;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
}
