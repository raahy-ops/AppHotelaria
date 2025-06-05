package util;

import dao.*;
import model.Usuario;

import java.sql.Connection;

public class Testeconexaodb {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");

            try {
                CargosDAO cargosDAO = new CargosDAO();
                cargosDAO.inserirCargos();

                System.out.println("Cargo Inserido com sucesso!");

                condb.close();
                System.out.println("conexão encerrada!");

            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
