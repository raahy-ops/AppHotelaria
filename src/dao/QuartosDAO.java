package dao;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
            return linhaAfetada > 0;
        } catch( Exception erro){

            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
}
