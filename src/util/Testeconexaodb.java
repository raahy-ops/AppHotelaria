package util;

import dao.*;
import model.Usuario;

import java.sql.Connection;

public class Testeconexaodb {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        try (Connection condb = conexao.conectar()) {
            if (condb != null) {
                System.out.println("Conexão estabelecida com sucesso!");

                try {
                    AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                    adicionaisDAO.inserirAdicionais(); // Correção do método

                    CargosDAO cargosDAO = new CargosDAO();
                    //cargosDAO.inserirCargos();
                    cargosDAO.pesquisarargo();

                    QuartosDAO quartosDAO = new QuartosDAO();
                   // quartosDAO.inserirQuarto();
                    quartosDAO.pesquisarQuarto();


                    ClientesDAO clientesDAO = new ClientesDAO();
                    clientesDAO.inserirCliente();
                    clientesDAO.pesquisarCliente();

                    UsuariosDAO usuariosDAO = new UsuariosDAO();
                    usuariosDAO.inserirUsuario();
                    usuariosDAO.pesquisarUsuario();



                    System.out.println("Operações realizadas com sucesso!");
                } catch (Exception erro) {
                    System.out.println("Erro ao executar operações: " + erro.getMessage());
                }
            } else {
                System.out.println("Falha ao conectar ao banco de dados!");
            }
        } catch (Exception erro) {
            System.out.println("Erro ao estabelecer conexão: " + erro.getMessage());
        }
    }
}