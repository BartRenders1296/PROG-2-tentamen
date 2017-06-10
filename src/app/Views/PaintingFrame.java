package app.Views;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class PaintingFrame extends Stage {

    private PaintingPanel paintingPanel;
    private BorderPane root;

    private MenuItem loadPainting;
    private MenuItem savePainting;
    private MenuItem exit;
    private MenuItem addLeaf;
    private MenuItem addPine;
    private MenuItem addhundred;
    private MenuItem clearTrees;
    private RadioMenuItem arial;
    private RadioMenuItem courier;
    private RadioMenuItem helvetica;
    private RadioMenuItem timesNewRoman;

    private ToggleGroup tGroup;

    private Text autograph;

    private CheckMenuItem play;

    public PaintingFrame() {
        centerOnScreen();
        setTitle("Bart Renders - Painting");
        root = new BorderPane();
        paintingPanel = new PaintingPanel(800, 580);

        autograph = new Text("Bart Renders");
        autograph.setTranslateX(650);
        autograph.setTranslateY(250);
        autograph.setFont(Font.font("Arial", 20));

        BorderPane backgroundPane = new BorderPane();

        Pane topPane = new Pane();
        topPane.setStyle("-fx-background-color: skyblue;");
        topPane.setMinWidth(paintingPanel.getWidth());
        topPane.setMinHeight(paintingPanel.getHeight()/2);

        Pane bottomPane = new Pane();
        bottomPane.setStyle("-fx-background-color: sandybrown;");
        bottomPane.setMinWidth(paintingPanel.getWidth());
        bottomPane.setMinHeight(paintingPanel.getHeight()/2 + 5);

        backgroundPane.setTop(topPane);
        bottomPane.getChildren().add(autograph);
        backgroundPane.setBottom(bottomPane);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundPane, paintingPanel);

        root.setTop(getMenu());
        root.setCenter(stackPane);

        setScene(new Scene(root, 800, 600));
        setResizable(false);
    }

    private MenuBar getMenu() {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu treeMenu = new Menu("Tree");
        Menu fontMenu = new Menu("Autograph font");
        Menu movieMenu = new Menu("Movie");

        loadPainting = new MenuItem("load painting...");
        savePainting = new MenuItem("save painting as...");
        exit = new MenuItem("exit");

        addLeaf = new MenuItem("add Leaf Tree");
        addPine = new MenuItem("add Pine Tree");
        addhundred = new MenuItem("add 100 Trees");
        clearTrees = new MenuItem("clear all Trees");

        arial = new RadioMenuItem("Arial");
        courier = new RadioMenuItem("Courier");
        helvetica = new RadioMenuItem("Helvetica");
        timesNewRoman = new RadioMenuItem("Times New Roman");

        tGroup = new ToggleGroup();
        arial.setToggleGroup(tGroup);
        courier.setToggleGroup(tGroup);
        helvetica.setToggleGroup(tGroup);
        timesNewRoman.setToggleGroup(tGroup);

        play = new CheckMenuItem("play");

        fileMenu.getItems().addAll(loadPainting, savePainting, exit);
        treeMenu.getItems().addAll(addLeaf, addPine, addhundred, clearTrees);
        fontMenu.getItems().addAll(arial, courier, helvetica, timesNewRoman);
        movieMenu.getItems().add(play);

        menuBar.prefWidthProperty().bind(widthProperty());

        menuBar.getMenus().addAll(fileMenu, treeMenu, fontMenu, movieMenu);

        return menuBar;
    }

    public MenuItem getLoadPainting() {
        return loadPainting;
    }

    public MenuItem getSavePainting() {
        return savePainting;
    }

    public MenuItem getExit() {
        return exit;
    }

    public MenuItem getAddLeaf() {
        return addLeaf;
    }

    public MenuItem getAddPine() {
        return addPine;
    }

    public MenuItem getAddhundred() {
        return addhundred;
    }

    public MenuItem getClearTrees() {
        return clearTrees;
    }

    public RadioMenuItem getArial() {
        return arial;
    }

    public RadioMenuItem getCourier() {
        return courier;
    }

    public RadioMenuItem getHelvetica() {
        return helvetica;
    }

    public RadioMenuItem getTimesNewRoman() {
        return timesNewRoman;
    }

    public CheckMenuItem getPlay() {
        return play;
    }

    public PaintingPanel getPaintingPanel() {
        return paintingPanel;
    }

    public ToggleGroup gettGroup() {
        return tGroup;
    }

    public Text getAutograph() {
        return autograph;
    }
}
