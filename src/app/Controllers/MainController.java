package app.Controllers;

import app.Enums.TreeSize;
import app.Enums.TreeType;
import app.Models.Tree;
import app.Models.World;
import app.Threads.MovieThread;
import app.Views.PaintingFrame;
import javafx.scene.control.Alert;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class MainController {

    private PaintingFrame paintingFrame;
    private World world;

    MovieThread movieThread;

    public MainController() {
        paintingFrame = new PaintingFrame();
        paintingFrame.show();
        world = new World();
        movieThread = new MovieThread(world);

        world.addObserver(paintingFrame.getPaintingPanel());

        init();
    }

    private void init() {
        paintingFrame.setOnCloseRequest(ActionEvent -> System.exit(0));

        paintingFrame.getExit().setOnAction(ActionEvent -> System.exit(0));

        paintingFrame.getAddLeaf().setOnAction(ActionEvent -> world.addTree(TreeType.LEAF));

        paintingFrame.getAddPine().setOnAction(ActionEvent -> world.addTree(TreeType.PINE));

        paintingFrame.getAddhundred().setOnAction(ActionEvent -> {
            for (int i = 0; i < 100; i++) {
                world.addTree(TreeType.getRandomType());
            }
        });

        paintingFrame.getArial().setSelected(true);
        paintingFrame.getArial().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Arial", paintingFrame.getAutograph().getFont().getSize()));
        });

        paintingFrame.getCourier().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Courier New", paintingFrame.getAutograph().getFont().getSize()));
            paintingFrame.getCourier().setSelected(true);
        });

        paintingFrame.getHelvetica().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Helvetica", paintingFrame.getAutograph().getFont().getSize()));
            paintingFrame.getHelvetica().setSelected(true);
        });

        paintingFrame.getTimesNewRoman().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Times New Roman", paintingFrame.getAutograph().getFont().getSize()));
            paintingFrame.getTimesNewRoman().setSelected(true);
        });

        paintingFrame.getPlay().setOnAction(ActionEvent -> {
            if (paintingFrame.getPlay().isSelected()) {
                movieThread.start();
            } else {
                movieThread.toggle();
                movieThread = new MovieThread(world);
            }
        });

        paintingFrame.getClearTrees().setOnAction(ActionEvent -> {
            paintingFrame.getPaintingPanel().clear();
            world.getTrees().clear();
        });

        paintingFrame.getSavePainting().setOnAction(ActionEvent -> savePainting());

        paintingFrame.getLoadPainting().setOnAction(ActionEvent -> loadPainting());
    }

    private void loadPainting() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Painting files (*.painting)", "*.painting"));
        String userDirectoryString = "paintings";
        File userDirectory = new File(userDirectoryString);
        if (!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }
        fileChooser.setInitialDirectory(userDirectory);
        File selectedFile = fileChooser.showOpenDialog(paintingFrame);
        if (selectedFile != null && getFileExtension(selectedFile).equals("painting")) {
            paintingFrame.getPaintingPanel().clear();
            world.getTrees().clear();
            try {
                BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(Pattern.quote(":"));
                    if (parts != null) {
                        Tree tree = new Tree();
                        if (!parts[0].isEmpty() && !parts[2].isEmpty() && !parts[3].isEmpty()) {
                            tree.setType(TreeType.getType(parts[0]));
                            tree.setSize(TreeSize.valueOf(TreeSize.class, parts[1]));
                            tree.setRelX(new Double(parts[2]));
                            tree.setRelY(new Double(parts[3]));
                            tree.setSpeed();
                            world.addTree(tree);
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Something went wrong while loading your file.");
            alert.showAndWait();
        }
    }

    public void savePainting() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Painting files (*.painting)", "*.painting");
        fileChooser.getExtensionFilters().add(extFilter);
        String userDirectoryString = "paintings";
        File userDirectory = new File(userDirectoryString);
        if (!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }
        fileChooser.setInitialDirectory(userDirectory);
        File file = fileChooser.showSaveDialog(paintingFrame);

        if (file != null) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileWriter finalWriter = writer;
            world.getTrees().forEach(Tree -> {
                String record = Tree.getType().getFilePrefix() + ":" + Tree.getTreeSize().getFilePrefix() + ":" + (int) Tree.getRelX() + ":" + (int) Tree.getRelY() + "\n";
                try {
                    finalWriter.write(record);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            try {
                finalWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
