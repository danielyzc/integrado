/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.OrdenSalidaDetalleAlmacenProductosCostos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class OrdenSalidaDetalleAlmacenProductosCostosFacade extends AbstractFacade<OrdenSalidaDetalleAlmacenProductosCostos> implements OrdenSalidaDetalleAlmacenProductosCostosFacadeLocal {
    @PersistenceContext(unitName = "integrado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenSalidaDetalleAlmacenProductosCostosFacade() {
        super(OrdenSalidaDetalleAlmacenProductosCostos.class);
    }
    
}
