package blokus.view;

import blokus.controller.Controller;
import blokus.controller.ControllerImpl;
import blokus.model.Model;
import blokus.model.ModelImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) throws Exception {

    Model model = new ModelImpl();

    Controller controller = new ControllerImpl(model);

    View view = new View(controller);

    Scene scene = new Scene(view.render());
    // scene.getStylesheets().add("main.css");
    stage.setScene(scene);

    // Refresh view when model changes
    model.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.sizeToScene();
        });

    // Show the stage
    stage.setTitle("Blokus");
    stage.show();
    }
}
