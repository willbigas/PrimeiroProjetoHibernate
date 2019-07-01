package br.com.willbigas.primeiroprojetohibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Will
 */
public class GenericDao<Entidade> {

    private Class<Entidade> classeGenerica;

    public GenericDao() {
        this.classeGenerica = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public boolean salvar(Entidade entidade) {
        Session sessao = FabricaConexaoHibernate.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
            return true;
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            System.out.println(erro.getMessage());
            return false;
        } finally {
            sessao.close();
        }
    }

    public List<Entidade> listar() {
        Session sessao = FabricaConexaoHibernate.getFabricaDeSessoes().openSession();
        Transaction transacao = null;
        transacao = sessao.beginTransaction();
        Entidade entidade;
        try {
            Criteria consulta = sessao.createCriteria(classeGenerica);
            List<Entidade> resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public Entidade buscar(Integer codigo) {
        Session sessao = FabricaConexaoHibernate.getFabricaDeSessoes().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            Entidade resultado = (Entidade) sessao.get(classeGenerica, codigo);
            transacao.commit();
            return resultado;
        } catch (RuntimeException erro) {
            transacao.rollback();
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Entidade entidade) {
        Session sessao = FabricaConexaoHibernate.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public boolean editar(Entidade entidade) {
        Session sessao = FabricaConexaoHibernate.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.update(entidade);
            transacao.commit();
            return true;
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            erro.printStackTrace();
            return false;
        } finally {
            sessao.close();
        }
    }

}
