

import br.com.willbigas.primeiroprojetohibernate.DaoImpl.TipoUsuarioDao;
import br.com.willbigas.primeiroprojetohibernate.model.TipoUsuario;
import java.util.List;

/**
 *
 * @author Will
 */
public class Principal {
    
    public static void main(String[] args) {
        TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
        TipoUsuario tipoUsuario = new TipoUsuario();
//        tipoUsuario.setId(1);
//        tipoUsuario.setNome("William");
//        tipoUsuario.setTipoPermissao(1);
//        tipoUsuario.setAtivo(true);
//        tipoUsuarioDao.salvar(tipoUsuario);
//        
        List<TipoUsuario> tiposDeUsuario  = tipoUsuarioDao.listar();
        System.out.println(tiposDeUsuario);
        
    }
    
}
