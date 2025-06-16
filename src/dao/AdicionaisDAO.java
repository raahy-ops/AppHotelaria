package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(/*Adicionais adicionais*/) {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO adicionais" + "(nome,preco) VALUES (?,?);");

            //Setar os Parâmetros
            novoAdicional.setString(1, "Tudo Incluso");
            novoAdicional.setDouble(2, 600.00);

            int linhaAfetada = novoAdicional.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais: " + erro);
            return false;
        }
    }

    public boolean alterarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement adicionalAlterado  = conndb.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?; ");
            adicionalAlterado.setString(1, "Tudo incluso");
            adicionalAlterado.setDouble(2, 600.00);
            adicionalAlterado.setInt(3, 1);

            int linhaAfetada = adicionalAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar adicional: " + erro);
            return false;
        }
    }

    public boolean deletarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicional = conndb.prepareStatement
                    ("DELETE FROM adicionais WHERE id = ?;");
            removeAdicional.setInt(1, 1);
            int linhaAfetada = removeAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar adicional: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaAdicional = conndb.prepareStatement("SELECT nome, preco" +
                    " FROM adicionais WHERE id = ?");
            buscaAdicional.setInt(1, 1);
            ResultSet resultado = buscaAdicional.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");
                System.out.println("Nome: " + nome + " - Preço: " + preco);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar preço: " + erro);
        }
    }
}


