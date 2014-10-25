package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CassandraDAO{
	
	//CRIANDO AS CONEXÕES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jugkeyspace");
    EntityManager em = emf.createEntityManager();
	
	@Test
    public void persistir(Object entidade){
        em.persist(entidade);        
        em.clear();       
    }    
	
    public void remover(Object entidade){
        em.remove(entidade);
        em.clear();
    }
    
    public <T> T encontrarPorID(Class<T> entityClass, Object id){
        T resultado = em.find(entityClass, id);
        return resultado;
    }
    
	@SuppressWarnings("unchecked")
	public List<UsersJug> listar(){
    	Query q = em.createQuery("select * from usersJug");
    	return q.getResultList();
    }
}



