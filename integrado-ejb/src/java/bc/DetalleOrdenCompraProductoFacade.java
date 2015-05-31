/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleOrdenCompraProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleOrdenCompraProductoFacade extends AbstractFacade<DetalleOrdenCompraProducto> implements DetalleOrdenCompraProductoFacadeLocal {
    @PersistenceContext(unitName = "integrado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleOrdenCompraProductoFacade() {
        super(DetalleOrdenCompraProducto.class);
    }
    
}
