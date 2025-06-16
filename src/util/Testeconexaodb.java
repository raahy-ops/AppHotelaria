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
                    //adicionaisDAO.inserirAdicionais(); // Correção do método
                    //adicionaisDAO.pesquisarAdicionais();
                    //adicionaisDAO.alterarAdicionais();
                    //adicionaisDAO.deletarAdicionais();

                    CargosDAO cargosDAO = new CargosDAO();
                    //cargosDAO.inserirCargos();
                    //cargosDAO.pesquisarCargo();
                   //cargosDAO.alterarCargo();
                    //cargosDAO.deletarCargo();



                    QuartosDAO quartosDAO = new QuartosDAO();
                   // quartosDAO.inserirQuarto();
                    //quartosDAO.pesquisarQuarto();
                   //quartosDAO.alterarQuarto();
                    //quartosDAO.deletarQuarto();


                    ClientesDAO clientesDAO = new ClientesDAO();
                    //clientesDAO.inserirCliente();
                    //clientesDAO.pesquisarCliente();
                    //clientesDAO.alterarCliente();
                    //clientesDAO.deletarCliente();


                    UsuariosDAO usuariosDAO = new UsuariosDAO();
                    //usuariosDAO.inserirUsuario();
                    //usuariosDAO.pesquisarUsuario();
                    //usuariosDAO.alterarUsuario();
                    //usuariosDAO.deletarUsuario();


                    PedidosDAO  pedidosDAO = new PedidosDAO();
                    //pedidosDAO.inserirPedido();
                    //pedidosDAO.pesquisarPedido();
                   //pedidosDAO.alterarPedido();
                    //pedidosDAO.deletarPedido();








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