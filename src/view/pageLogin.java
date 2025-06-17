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
        imageView.setFitWidth(450); // Define a largura da imagem
        imageView.setFitHeight(600); // Define a altura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção da imagem


        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(imageView);


        // Titulo
        Label lblTitulo = new Label(" Faça seu login");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px;-fx-font-weight: bold; -fx-text-fill:#372F0B;");


        Button btnEntrar = new Button("Entrar");
        HBox titleBox = new HBox(lblTitulo, btnEntrar); // Add dentro do primeiro hbox


        btnEntrar.setStyle("-fx-background-color: #8c6328;  -fx-font-weight: bold; -fx-border-radius: 16; -fx-background-radius: 16px; -fx-padding: 5px 60px; -fx-text-fill: white;  -fx-cursor: hand;");
        btnEntrar.setAlignment(Pos.CENTER);


        titleBox.setAlignment(Pos.CENTER);
        //  titleBox.setStyle("-fx-background-color: rgba(206,160,255,0.96)");



        // Ícones para os campos
        ImageView userIcon = new ImageView(new Image(getClass().getResourceAsStream("/view/resoucers/img/icons8-user-48.png")));
        userIcon.setFitWidth(20);
        userIcon.setFitHeight(20);

        ImageView keyIcon = new ImageView(new Image(getClass().getResourceAsStream("/view/resoucers/img/icons8-chave-48.png")));
        keyIcon.setFitWidth(19);
        keyIcon.setFitHeight(19);







        //Campos de Entrada

        Label lblEmail = new Label();
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("email@gmail.com");
        lblEmail.setGraphic(userIcon);

        Label lblSenha = new Label();
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Digite sua senha");
        lblSenha.setGraphic(keyIcon);


        TextField textField = new TextField();
        textField.setPromptText("Digite sua senha");
        textField.setVisible(false); // Inicialmente oculta


        // Criando o CheckBox para alternar a visibilidade da senha
        CheckBox showPasswordCheckBox = new CheckBox("Mostrar senha");
        showPasswordCheckBox.setStyle("-fx-text-fill: #514F59; -fx-font-weight: bold ");


        textField.setStyle("-fx-border-radius: 10; -fx-background-radius: 10;");


        // Alternar entre PasswordField e TextField
        showPasswordCheckBox.setOnAction(event -> {
            if (showPasswordCheckBox.isSelected()) {
                textField.setText(passwordField.getText());
                textField.setVisible(true);
                passwordField.setVisible(false);
            } else {
                passwordField.setText(textField.getText());
                passwordField.setVisible(true);
                textField.setVisible(false);
            }
        });


        txtEmail.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");
        passwordField.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");


        GridPane formGrid = new GridPane();

        formGrid.add(lblEmail, 0, 0);
        formGrid.add(txtEmail, 1, 0);
        formGrid.add(lblSenha, 0, 1);
        formGrid.add(passwordField, 1, 1);
        formGrid.add(textField, 1, 1);
        formGrid.add(showPasswordCheckBox, 1, 2);


        //lacuna, espaçamento
        formGrid.setHgap(5); // Gap (lacuna) de uma coluna para outra (na horizontal)
        formGrid.setVgap(15); // gap (lacuna) de uma linha para outtra na vertical
        formGrid.setAlignment(Pos.CENTER_LEFT);
        formGrid.setTranslateX(20); // Ajuste fino para mover um pouco à esquerda




        HBox btnBox = new HBox(btnEntrar);
        btnBox.setAlignment(Pos.CENTER_RIGHT); // Alinha o botão à direita
        btnBox.setPadding(new Insets(0, 20, 0, 0));


        // Criando um VBox com mais espaçamento e centralização
        VBox layout = new VBox(20, lblTitulo, formGrid, btnBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(100)); // Espaçamento interno maior
        janela.setResizable(false);
        mainPane.setCenter(layout);
        btnEntrar.setAlignment(Pos.CENTER_RIGHT);





        //layout -> mainPaine
        Scene scene = new Scene(mainPane, 750, 600);
        janela.setTitle("Hotel Shalom");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setScene(scene);

        janela.show();


        HBox hbox = new HBox(5); // Espaço entre a imagem e o TextField
        hbox.setAlignment(Pos.CENTER_LEFT); // Alinha os itens à esquerda

        txtEmail.setFocusTraversable(false);
        passwordField.setFocusTraversable(false);
        showPasswordCheckBox.setFocusTraversable(false);


    }


    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }

}


