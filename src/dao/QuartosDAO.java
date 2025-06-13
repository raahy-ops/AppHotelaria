package dao;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {

    //Objeto para instanciar classe Conexão para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto(/*Quarto quarto */) {
        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos" + "(nome, numero, qnt_cama_casal, qnt_cama_solteiro, preco, disponivel) VALUES (?,?,?,?,?,?);");

            //Setar os Parâmetros
            novoQuarto.setString(1,"Cleiton");
            novoQuarto.setString(2,"606");
            novoQuarto.setInt(3,2);
            novoQuarto.setInt(4,2);
            novoQuarto.setDouble(5,1000.00);
            novoQuarto.setBoolean(6,true);

            int linhaAfetada = novoQuarto.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;



        } catch( Exception erro){

            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
    public boolean alterarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado  = conndb.prepareStatement("UPDATE quartos" +
                    "SET nome = ?, numero = ?, qnt_cama_casal = ?, " +
                    "qnt_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?; ");

            quartoAlterado.setString(1, "Cleiton");
            quartoAlterado.setString(2, "606");
            quartoAlterado.setInt(3, 2);
            quartoAlterado.setInt(4, 2);
            quartoAlterado.setDouble(5, 1000.00);
            quartoAlterado.setBoolean(6, true);
            quartoAlterado.setInt(7, 1);
            int linhaAfetada = quartoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar quarto: " + erro);
            return false;
        }
    }


    public boolean deletarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuarto = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeQuarto.setInt(1, 1);
            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Quarto: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaQuarto = conndb.prepareStatement("SELECT nome, numero, qnt_cama_casal, qnt_cama_solteiro, preco, disponivel FROM cargos WHERE id = ?");
            buscaQuarto.setInt(1, 1);
            ResultSet resultado = buscaQuarto.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                Integer qnt_cama_casal=  resultado.getInt("qnt_cama_casal");
                Integer qnt_cama_solteiro=  resultado.getInt("qnt_cama_solteiro");
                Double preco = resultado.getDouble("preco");
                Boolean disponivel = resultado.getBoolean("disponivel");

                System.out.println("Nome: " + nome + " - Numero: " + numero + " -  qnt_cama_casal: " +  qnt_cama_casal + "qnt_cama_solteiro" + qnt_cama_solteiro + "preco" + preco + "disponivel" + disponivel);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar quartos: " + erro);
        }
    }
}
