package com.capg.cba.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capg.cba.entities.Cab;

@Repository
/*a specialization of the @Component annotation which indicates that an annotated class is a â€œRepositoryâ€�,
 *  which can be used as a mechanism for encapsulating storage, retrieval, 
 *  and search behavior which emulates a collection of objects.
 */

@Transactional
//@Transactional should be used on specific methods where it is actually needed, not on the entire class.
public class CabRepositoryImpl implements CabRepository {
	
	@PersistenceContext
	/*PersistenceContext annotation, which is used to inject an EntityManager object 
	*and establish the scope of the injected object (e.g., a transaction).28
    */
    private EntityManager entityManager;
	/* An EntityManager object manages a set of entities that are defined by a persistence unit.
	 *  Each EntityManager instance is associated with a persistence context.
	 */
   //@Override annotation indicates that the child class method is over-writing its base class method
	@Override
	public Cab insertCab(Cab cab) {
		return entityManager.merge(cab);
	}

	@Override
	public Cab findCabById(int cabId) {
		return entityManager.find(Cab.class,cabId);
	}

	@Override
	public Cab updateCab(Cab cabBooking) {
		Cab cab=findCabById(cabBooking.getCabId());
		cab.setCarType(cabBooking.getCarType());
		cab.setPerKmRate(cabBooking.getPerKmRate());
		cab=entityManager.merge(cab);
		return cab;
	}
		
    
	@Override
	public List<Cab> viewCabsOfType(String carType) {
		Query q = entityManager.createQuery("select e from Cab ");
	    List<Cab> list=q.getResultList();
		return list;
	}
    
    @Override
   public int countCabsOfType(String carType) {
	Query query = entityManager.createQuery("select count(e) from Cab e where e.carType = :carType");
	query.setParameter("carType", carType);
	System.out.println();
	try 
	{
		Object a=query.getSingleResult();
		a.toString();
		int i=Integer.parseInt(a.toString());
		return i;
	}
	catch(Exception e)
	{
		System.out.println("i can handle:"+e);
	}
	return 0;
    }

	@Override
	public Cab deleteCab(int cabId) {
		Cab cab=entityManager.find(Cab.class, cabId);
		entityManager.remove(cab);
		return cab;
	
}

	}