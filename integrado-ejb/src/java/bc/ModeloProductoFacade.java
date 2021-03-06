/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ModeloProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ModeloProductoFacade extends AbstractFacade<ModeloProducto> implements ModeloProductoFacadeLocal {
    @PersistenceContext(unitName = "integrado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloProductoFacade() {
        super(ModeloProducto.class);
    }
    
}
