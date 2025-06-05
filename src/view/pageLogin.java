package view; //Package view (classes que, quando executadas, interagem com o usuário)

import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import view.componentes.PainelBotoes;
import view.componentes.sidebar;

import static javax.swing.text.StyleConstants.setAlignment;


public class pageLogin extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        //Carregar imagens


        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/iconsHotel.png"));

        Image imagem = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/AdobeStock_995526341.jpeg"));


        ImageView imageView = new ImageView(imagem);
        imageView.setFitWidth(500); // Define a largura da imagem
        imageView.setFitHeight(600); // Define a altura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção da imagem


        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(imageView);


        // Titulo
        Label lblTitulo = new Label(" Faça seu login");
        lblTitulo.setAlignment(Pos.CENTER_RIGHT);
        lblTitulo.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;");


        Button btnEntrar = new Button("Entrar");
        HBox titleBox = new HBox(lblTitulo, btnEntrar); // Add dentro do primeiro hbox

        btnEntrar.setStyle("-fx-background-color: #bd8d46;  -fx-font-weight: bold; -fx-border-radius: 16; -fx-background-radius: 16px; -fx-padding: 5px 60px; -fx-text-fill: white;  -fx-cursor: hand;");

        btnEntrar.setAlignment(Pos.CENTER);


        titleBox.setAlignment(Pos.CENTER_RIGHT);
        //  titleBox.setStyle("-fx-background-color: rgba(206,160,255,0.96)");


        Label lblSenha = new Label("Senha:");
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha ");


        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("email@gmail.com");

        txtEmail.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");
        txtSenha.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");
        lblEmail.setStyle("-fx-text-fill: #bd8d46");


        GridPane formGrid = new GridPane();

        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(lblSenha, 0, 0);
        formGrid.add(txtSenha, 1, 0);


        //lacuna, espaçamento
        formGrid.setHgap(5); // Gap (lacuna) de uma coluna para outra (na horizontal)
        formGrid.setVgap(5); // gap (lacuna) de uma linha para outtra na vertical
        formGrid.setAlignment(Pos.CENTER_RIGHT);


        VBox layout = new VBox(10, titleBox, formGrid, btnEntrar);
        layout.setAlignment(Pos.CENTER_RIGHT);
        mainPane.setCenter(layout);
        janela.setResizable(false);
        layout.setPadding(new Insets(40));


        //layout -> mainPaine
        Scene scene = new Scene(mainPane, 750, 600);
        janela.setTitle("Hotel Shalom");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setScene(scene);


        janela.show();


        HBox hbox = new HBox(5); // Espaço entre a imagem e o TextField
        hbox.setAlignment(Pos.CENTER_LEFT); // Alinha os itens à esquerda


    }


    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }

}


