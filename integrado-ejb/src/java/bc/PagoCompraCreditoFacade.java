/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PagoCompraCredito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PagoCompraCreditoFacade extends AbstractFacade<PagoCompraCredito> implements PagoCompraCreditoFacadeLocal {
    @PersistenceContext(unitName = "integrado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagoCompraCreditoFacade() {
        super(PagoCompraCredito.class);
    }
    
}
