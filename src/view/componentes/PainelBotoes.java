package view.componentes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javax.swing.text.View;

public class PainelBotoes extends HBox {
public PainelBotoes() {


    Image imgBtnCad = new Image(getClass().getResourceAsStream
            ("/view/resoucers/img/iconsCad.png"));
    Image imgBtnUp = new Image(getClass().getResourceAsStream
            ("/view/resoucers/img/iconsSincronizar48.png"));
    Image imgBtnDel = new Image(getClass().getResourceAsStream
            ("/view/resoucers/img/iconsDelete.png"));











    ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(20);
        viewImgBtnCad.setFitHeight(20);



    ImageView viewImgBtnDel = new ImageView(imgBtnDel);
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);

    ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);


    Button btnCadastrar = new Button("Cadastrar",viewImgBtnCad);
    Button btnAtualizar = new Button("Atualizar",viewImgBtnUp);
    Button btnExcluir = new Button("Excluir",viewImgBtnDel);



    btnCadastrar.setStyle("-fx-background-color: linear-gradient(to right,#e6a4c8, #6B5BA6); -fx-font-weight: bold; -fx-background-radius: 10;  -fx-text-fill: #ffffff; -fx-cursor: hand; ");
    btnAtualizar.setStyle("-fx-background-color: linear-gradient(to right,#e6a4c8, #6B5BA6); -fx-font-weight: bold; -fx-background-radius: 10; -fx-border-radius: 10;  -fx-text-fill: #ffffff; -fx-cursor: hand; ");
    btnExcluir.setStyle("-fx-background-color: linear-gradient(to right,#e6a4c8, #6B5BA6); -fx-font-weight: bold; -fx-background-radius: 10;  -fx-text-fill: #ffffff; -fx-cursor: hand; ");


    setAlignment(Pos.CENTER);
    setSpacing(10);


    getChildren().addAll(btnCadastrar,btnAtualizar, btnExcluir);


     }
}
