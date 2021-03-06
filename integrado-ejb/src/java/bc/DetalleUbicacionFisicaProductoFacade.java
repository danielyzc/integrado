/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleUbicacionFisicaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleUbicacionFisicaProductoFacade extends AbstractFacade<DetalleUbicacionFisicaProducto> implements DetalleUbicacionFisicaProductoFacadeLocal {
    @PersistenceContext(unitName = "integrado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleUbicacionFisicaProductoFacade() {
        super(DetalleUbicacionFisicaProducto.class);
    }
    
}
