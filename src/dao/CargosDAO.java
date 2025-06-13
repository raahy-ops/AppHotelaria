package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CargosDAO {

    //Objeto para instanciar classe Conexão para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCargos(/*Usuario usuario*/) {
        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoCargo = conndb.prepareStatement("INSERT INTO cargos  " + "(nome) VALUES (?);");

            //Setar os Parâmetros
            novoCargo.setString(1, "TI");




            int linhaAfetada = novoCargo.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;


        } catch (Exception erro) {

            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }


    public boolean alterarCargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement cargoAlterado  = conndb.prepareStatement("UPDATE cargos" +
                    "SET nome = ? " + " WHERE id = ?; ");
            cargoAlterado.setString(2, "TI");
            cargoAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1

            int linhaAfetada = cargoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar cargo: " + erro);
            return false;
        }
    }

    public boolean deletarCargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCargo = conndb.prepareStatement
                    ("DELETE FROM cargos WHERE id = ?;");
            removeCargo.setInt(1, 1);
            int linhaAfetada = removeCargo.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Cargo: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaCargo = conndb.prepareStatement("SELECT nome" +
                    " FROM cargos WHERE id = ?");
            buscaCargo.setInt(1, 1);
            ResultSet resultado = buscaCargo.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("Nome: " + nome);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar Cargos: " + erro);
        }
    }
}



