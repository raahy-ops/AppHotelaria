package dao;

import model.Pedido;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {

    //Objeto para instanciar classe Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO usuarios (usuario_id, cliente_id, pagamento) VALUES (?, ?, ?);");
            //Setar os parâmetros
            novoPedido.setInt(1, 1);
            novoPedido.setInt(2, 1);
            novoPedido.setString(3, "Dinheiro");

            int linhaAfetada = novoPedido.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir pedido: " + erro);
            return false;
        }
    }

    public boolean alterarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pedidoAlterado  = conndb.prepareStatement("UPDATE pedidos SET usuario_id = ?, cliente_id = ?,data = ?,pagamento = ? WHERE id = ?; ");
            pedidoAlterado.setInt(1, 1);
            pedidoAlterado.setInt(2, 1);
            pedidoAlterado.setString(3, "2025-06-01");
            pedidoAlterado.setString(4, "Pix");
            pedidoAlterado.setInt(5, 1);


            int linhaAfetada = pedidoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar pedido: " + erro);
            return false;
        }
    }

    public boolean deletarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removePedido = conndb.prepareStatement
                    ("DELETE FROM pedidos WHERE id = ?;");
            removePedido.setInt(1, 1);
            int linhaAfetada = removePedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Pedido: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaPedido = conndb.prepareStatement("SELECT usuario_id, cliente_id, pagamento " +
                    " FROM pedidos WHERE id = ?");
            buscaPedido.setInt(1, 1);
            ResultSet resultado = buscaPedido.executeQuery();

            while (resultado.next()) {
                String usuario_id = resultado.getString("usuario_id");
                String cliente_id = resultado.getString("cliente_id");
                String pagamento = resultado.getString("pagamento");


                System.out.println("Usuario_id: " + usuario_id + " - Cliente_id: " + cliente_id + " - Pagamento: " + pagamento);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar pedido: " + erro);
        }
    }
}




