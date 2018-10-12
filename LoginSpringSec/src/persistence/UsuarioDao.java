package persistence;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Usuario;

public class UsuarioDao {

	private HibernateTemplate hibernate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernate = new HibernateTemplate(sessionFactory);
	}
	
	public void create(Usuario u) throws Exception{
		hibernate.save(u);
	}
	
	public void update(Usuario u) throws Exception{
		hibernate.update(u);
	}
	
	public void delete(Usuario u) throws Exception{
		hibernate.delete(u);
	}
	
	public List<Usuario> findAll(){
		return hibernate.loadAll(Usuario.class);
	}
	
	public Usuario findByCode(Integer cod){
		return (Usuario) hibernate.get(Usuario.class, cod);
	}

	
	public HibernateTemplate getHibernate() {
		return hibernate;
	}

	public void setHibernate(HibernateTemplate hibernate) {
		this.hibernate = hibernate;
	}


}
