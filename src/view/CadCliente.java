package view; //Package view (classes que, quando executadas, interagem com o usuário)
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe VBox: é um dos tipos de layouts
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.componentes.PainelBotoes;
import view.componentes.sidebar;


public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        //Carregar imagens


        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/iconsHotel.png"));

        Image imgUser = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/iconsUser.png"));

        BorderPane mainPane = new BorderPane();



        sidebar sidebar = new sidebar();



        mainPane.setLeft(sidebar);


        PainelBotoes button = new PainelBotoes();
        mainPane.setBottom(button);


        //Parâmetros para definir como a imagem será visualizada




        ImageView viewimgUser = new ImageView(imgUser);
        viewimgUser.setFitWidth(20);
        viewimgUser.setFitHeight(20);



        // Titulo
        Label lblTitulo = new Label(" Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px;-fx-font-weight: bold; -fx-color: #1C1E10");
        HBox titleBox= new HBox(viewimgUser,lblTitulo); // Add dentro do primeiro hbox






        titleBox.setAlignment(Pos.CENTER);
      //  titleBox.setStyle("-fx-background-color: rgba(206,160,255,0.96)");


        ComboBox<String> boxEmail = new ComboBox<>();
       boxEmail.getItems().addAll("@gmail.com", "@yahoo.com", "hotmail.com", "outlook.com", "icloud.com");
       boxEmail.setPromptText("Selecione: ");
        boxEmail.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px; -fx-cursor: hand;");






        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome completo ");
        Label lblCPF = new Label("CPF: ");
        TextField txtCPF =  mascara("###.###.###-###");
        txtCPF.setPromptText("000.000.000-00");
        Label lblEmail = new Label( "E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("email@gmail.com");


        Label lblTele = new Label("Tel");
        TextField txtTel = mascara("(##) #####-#####");
        txtTel.setPromptText("(__)_____-_____");

        txtNome.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");
        txtCPF.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");
        txtEmail.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");
        txtTel.setStyle("-fx-border-radius: 10; -fx-background-radius: 10px;");



        Label lblTel = new Label("Telefone: ");
        TextField txtTele = new TextField();







        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail,2,2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);


        //lacuna, espaçamento
        formGrid.setHgap(10); // Gap (lacuna) de uma coluna para outra (na horizontal)
        formGrid.setVgap(10); // gap (lacuna) de uma linha para outtra na vertical
        formGrid.setAlignment(Pos.CENTER);














        VBox layout = new VBox( 10,  titleBox, formGrid,button);
        layout.setAlignment(Pos.CENTER);

        mainPane.setCenter(layout);


                        //layout -> mainPaine
        Scene scene = new Scene(mainPane, 650, 500);
        janela.setTitle("Hotel Shalom");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);

        janela.setResizable(false); //impadi a imagem de redimencionar


        janela.show();



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
