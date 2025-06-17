package view.componentes;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class sidebar extends VBox {

    public Button btnclientes = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionários:");
    public Button btnQuartos = new Button("Quartos");
    public Button btnReserva = new Button("Reserva:");
    public Button btnRelatorio = new Button("Relatórios:");

    public sidebar() {

        Image iconFuncionario = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/icons8-funcionario-96.png"));


        Image iconQuarto = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/icons8-interior-do-quarto-50.png"));

        Image iconRelatorio = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/icons8-relatório-gráfico-96.png"));

        Image iconReserva= new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/icons8-reserva-96.png"));

        Image iconCliente = new Image(getClass().getResourceAsStream
                ("/view/resoucers/img/icons8-cliente-96.png"));


        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resoucers/fonts/"+"Ubuntu-Regular.ttf"),14);

        Font fontePlay = Font.loadFont(getClass().getResourceAsStream("/view/resoucers/fonts/"+"PlayfairDisplay-Bold.ttf"),15);



        ImageView viewiconQuarto = new ImageView(iconQuarto);
        viewiconQuarto.setFitWidth(20);
        viewiconQuarto.setFitHeight(20);


        btnQuartos.setGraphic(viewiconQuarto);

        ImageView viewiconFuncionario = new ImageView(iconFuncionario);
        viewiconFuncionario.setFitWidth(20);
        viewiconFuncionario.setFitHeight(20);

        btnFuncionario.setGraphic(viewiconFuncionario);

        ImageView viewiconRelatorio = new ImageView(iconRelatorio);
        viewiconRelatorio.setFitWidth(20);
        viewiconRelatorio.setFitHeight(20);

        btnRelatorio.setGraphic(viewiconRelatorio);


        ImageView viewiconReserva = new ImageView(iconReserva);
        viewiconReserva.setFitWidth(20);
        viewiconReserva.setFitHeight(20);

        btnReserva.setGraphic(viewiconReserva);

        ImageView viewiconCliente = new ImageView(iconCliente);
        viewiconCliente.setFitWidth(20);
        viewiconCliente.setFitHeight(20);

        btnclientes.setGraphic(viewiconCliente);






        Label lblMenu = new Label("Hotel Shalom");
     lblMenu.setStyle ("-fx-text-fill: BLACK;"
     );

     lblMenu.setFont(Font.font(fontePlay.getFamily(), 25));

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent; " +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;";   //Setar o cursor de mãozinha para o mouse

        btnclientes.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuartos.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        btnclientes.setOnMouseEntered((evento) ->
                btnclientes.setStyle(styleButton.replace("transparent", "#D6B6CC")));
        btnclientes.setOnMouseExited(evento -> btnclientes.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6B6CC")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuartos.setOnMouseEntered(evento ->
                btnQuartos.setStyle(styleButton.replace("transparent", "#D6B6CC")));
        btnQuartos.setOnMouseExited(evento -> btnQuartos.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6B6CC")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#D6B6CC")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));




        //Espaçamento externo (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(0,        0,       20,       0));
        //margem:        superior,   direita,    inferior,    esquerda







        setStyle("-fx-background-color: #967143; -fx-padding: 40px;");
        setSpacing(12);
        getChildren().addAll(lblMenu, btnclientes,btnFuncionario,btnQuartos,btnReserva,btnRelatorio);



    }


}


