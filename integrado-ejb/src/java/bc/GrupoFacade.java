/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Grupo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class GrupoFacade extends AbstractFacade<Grupo> implements GrupoFacadeLocal {
    @PersistenceContext(unitName = "integrado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }
    
}
