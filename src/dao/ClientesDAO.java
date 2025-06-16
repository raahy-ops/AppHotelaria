package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClientesDAO {

    //Objeto para instanciar classe Conexão para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCliente(/*Cliente Cliente*/) {
        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " + "(nome, email, telefone, cpf) VALUES (?,?,?,?);");

            //Setar os Parâmetros
            novoCliente.setString(1, "Cleiton");
            novoCliente.setString(2, "Cleiton@gmail.com");
            novoCliente.setString(3, "(15)23598828");
            novoCliente.setString(4, "195.870.158-00");


            int linhaAfetada = novoCliente.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;


        } catch (Exception erro) {

            System.out.println("Erro ao inserir clientes: " + erro);
            return false;
        }
    }

    public boolean alterarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clienteAlterado  = conndb.prepareStatement("UPDATE clientes SET nome = ?, email = ?, telefone = ?, cpf = ? WHERE id = ?; ");
            clienteAlterado.setString(1, "Cleiton");
            clienteAlterado.setString(2, "Cleiton@gmail.com");
            clienteAlterado.setString(3, "(15)23598828");
            clienteAlterado.setString(4, "195.870.158-00");
            clienteAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = clienteAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar cliente: " + erro);
            return false;
        }
    }


    public boolean deletarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCliente = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, 1);

            int linhaAfetada = removeCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Cliente: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscacliente = conndb.prepareStatement("SELECT nome, email, telefone, cpf FROM clientes WHERE id = ?");
            buscacliente.setInt(1, 1);
            ResultSet resultado = buscacliente.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String telefone = resultado.getString("telefone");
                String cpf = resultado.getString("cpf");
                System.out.println("Nome: " + nome + " - Email: " + email + " - Telefone: " + telefone + " - CPF: " + cpf);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar clientes: " + erro);
        }
    }
}


