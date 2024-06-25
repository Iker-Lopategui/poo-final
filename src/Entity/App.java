package Entity; // Corrigido para corresponder ao diretório

import DAO.UsuarioDAO;

public class App {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setGenero(1); // Usando um valor int
        usuario.setLogin("Iker");
        usuario.setSenha("senha123");
        usuario.setNome("Iker Lopategui");
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrarUsuario(usuario);
    }
}
