package br.com.willbigas.primeiroprojetohibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Will
 */
public class FabricaConexaoHibernate {

    private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

    public static SessionFactory getFabricaDeSessoes() {
        return fabricaDeSessoes;
    }

    private static SessionFactory criarFabricaDeSessoes() {
        try {
            Configuration configuracao = new Configuration().configure();

            ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
            SessionFactory fabrica = configuracao.buildSessionFactory();
            return fabrica;
        } catch (Throwable ex) {
            System.err.println("A fábrica de sessões não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
