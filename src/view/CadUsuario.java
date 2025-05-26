package view; //Package view (classes que, quando executadas, interagem com o usuário)
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.componentes.PainelBotoes;
import view.componentes.sidebar;




public class CadUsuario extends Application {
    private boolean darkMode = false;
    private Scene scene;

    @Override
    public void start(Stage janela) throws Exception {
        //Carregar imagens


        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/iconsHotel.png"));

        Image imgFunc = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/icons8-male-user-96.png"));


        BorderPane mainPane = new BorderPane();

        sidebar sidebar = new sidebar();

        sidebar.setStyle("-fx-background-color:#dacbc2");
        sidebar.setStyle("-fx-background-color:#dacbc2 ; -fx-padding: 40px;");
        sidebar.setSpacing(12);


        mainPane.setRight(sidebar);


        PainelBotoes button = new PainelBotoes();
        mainPane.setBottom(button);

        Button btnModoNoturno = new Button("Modo Noturno");
        btnModoNoturno.setOnAction(e -> toggleDarkMode(mainPane));



        //Parâmetros para definir como a imagem será visualizada


        ImageView viewimgFunc = new ImageView(imgFunc);
        viewimgFunc.setFitWidth(50);
        viewimgFunc.setFitHeight(50);


        // Titulo
        Label lblTitulo = new Label("Funcionário");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-text-fill: #210F26; -fx-font-size: 16px;-fx-font-weight: bold;");
        VBox vbox = new VBox(viewimgFunc);
        HBox titleBox = new HBox(lblTitulo);
        // Add dentro do primeiro hbox


        vbox.setAlignment(Pos.CENTER);
        titleBox.setAlignment(Pos.CENTER);
        //  titleBox.setStyle("-fx-background-color: rgba(206,160,255,0.96)");


        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@yahoo.com", "hotmail.com", "outlook.com", "icloud.com");
        boxEmail.setPromptText("Selecione: ");
        boxEmail.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px; -fx-cursor: hand;");

        ComboBox<String> boxCargo = new ComboBox<>();
        boxCargo.getItems().addAll("TI", "RH", "Gerente", "Estagiario", "Supervisor");
        boxCargo.setPromptText("Cargos ");
        boxCargo.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px; -fx-cursor: hand;");


        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("email@gmail.com");
        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha...");
        Label lblCargo = new Label("Cargo: ");
        TextField txtCargo = new TextField();


        txtEmail.setStyle("-fx-background-color:#F2E6D8;-fx-border-radius: 10; -fx-background-radius: 10px;");
        lblEmail.setStyle("-fx-text-fill: #210F26; -fx-font-weight: bold;");
        txtSenha.setStyle("-fx-background-color:#F2E6D8;-fx-border-radius: 10; -fx-background-radius: 10px; ");
        lblSenha.setStyle("-fx-text-fill: #210F26; -fx-font-weight: bold;");
        txtCargo.setStyle("-fx-background-color:#F2E6D8;-fx-border-radius: 10; -fx-background-radius: 10px;");
        lblCargo.setStyle("-fx-text-fill: #210F26; -fx-font-weight: bold;");




        GridPane formGrid = new GridPane();
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail, 2, 2);
        formGrid.add(lblSenha, 0, 3);
        formGrid.add(txtSenha, 1, 3);
        formGrid.add(lblCargo, 0, 4);
        formGrid.add(boxCargo, 1, 4);


        //lacuna, espaçamento
        formGrid.setHgap(10); // Gap (lacuna) de uma coluna para outra (na horizontal)
        formGrid.setVgap(10); // gap (lacuna) de uma linha para outra na vertical
        formGrid.setAlignment(Pos.CENTER);


        VBox layout = new VBox(10, vbox, titleBox, formGrid, button,btnModoNoturno);
        layout.setAlignment(Pos.CENTER);
      //  layout.setStyle("-fx-background-color: linear-gradient(to right,#D9C1D7, #ECE7FF);");

        mainPane.setCenter(layout);


        //layout -> mainPaine
        Scene scene = new Scene(mainPane, 650, 500);
        janela.setTitle("Hotel Shalom");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);

        janela.setResizable(false); //impedi a imagem de redimencionar


        janela.show();





    }

       private void toggleDarkMode(BorderPane mainPane) {
        darkMode = !darkMode;

        if (darkMode) {
            applyDarkTheme(mainPane);
        } else {
            applyLightTheme(mainPane);
        }
    }

    private void applyLightTheme(Pane... panes) {
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: linear-gradient(to right,#D9C1D7, #ECE7FF); " +
                    "-fx-border-radius: 10px; -fx-background-radius: 10px;");
        }
    }

    private void applyDarkTheme(Pane... panes) {
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(60, 60, 60, 0.9); " +
                    "-fx-border-radius: 30px; -fx-background-radius: 10px; " +
                    "-fx-text-fill: white;");
        }
    }









    private TextField mascara(String mascara) {
        TextField tf = new TextField();
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            // Remove todos os caracteres não numéricos
            String valor = newValue.replaceAll("[^0-9]", "");

            // Aplica a máscara
            StringBuilder valorFormatado = new StringBuilder();
            int index = 0;

            for (char c : mascara.toCharArray()) {
                if (c == '#') {
                    if (index < valor.length()) {
                        valorFormatado.append(valor.charAt(index));
                        index++;

                    } else {
                        break; // Para se o valor acabar
                    }
                } else {
                    valorFormatado.append(c); // Adiciona o caractere da máscara (não é um dígito)
                }
            }

            // Atualiza o texto do TextField
            tf.setText(valorFormatado.toString());

            // Posiciona o cursor no final do texto
            tf.positionCaret(valorFormatado.length());
        });

        return tf;
    }




    public static void main(String[] args){
        launch(args); //Inicializa o JAVAFX (aplicação)
    }

}

