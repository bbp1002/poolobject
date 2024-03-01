/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Alberto Lanchares Diez
 * @author Borja Blanco Porres
 *
 */
public class ReusablePoolTest {

	private ReusablePool pool;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pool = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool pool = ReusablePool.getInstance();
		//No es nulo
		assertNotNull(pool);
		//El objeto devuelto es una instancia de ReusablePool
		assertTrue(pool instanceof ReusablePool);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		try {
	        Reusable reusable1 = pool.acquireReusable();
	        assertNotNull(reusable1); // Verifica que el objeto devuelto no es nulo
	        assertTrue(reusable1 instanceof Reusable); // Verifica que el objeto devuelto es una instancia de Reusable
	        
	        Reusable reusable2 = pool.acquireReusable();
	        assertNotNull(reusable2); // Verifica que el segundo objeto devuelto no es nulo
	        assertTrue(reusable2 instanceof Reusable); // Verifica que el segundo objeto devuelto es una instancia de Reusable

	    } catch (NotFreeInstanceException e) {
	        fail("No debería lanzar una excepción al adquirir objetos reusables.");
	    }
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		
	}

}