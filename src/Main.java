import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.transform.*;
import javafx.scene.image.*;
public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
// STEP ONE: ADD A CAMERA
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        scene.setCamera(camera);

// STEP SEVEN: ADD A SPHERE
        Sphere sphere = new Sphere(200);
       /* sphere.setTranslateX(-180);
        sphere.setTranslateY(-100);
        sphere.setTranslateZ(100);*/
        root.getChildren().add(sphere);
        Image earthImage = new Image("cylindrical_equal_area.png");
        PhongMaterial earthPhong = new PhongMaterial();

        earthPhong.setDiffuseMap(earthImage);
        sphere.setMaterial(earthPhong);
      /*  sphere.setRotationAxis(Rotate.X_AXIS);
        sphere.setRotate(-100);*/
//STEP EIGHT: ADD A MESH OBJECT
// STEP NINE: ANIMATE THE OBJECTS
       RotateTransition rt4 = new RotateTransition();
        rt4.setNode(sphere);
        rt4.setDuration(Duration.millis(9000));
        rt4.setAxis(Rotate.Y_AXIS);
        rt4.setByAngle(360);
        rt4.setCycleCount(Animation.INDEFINITE);
        rt4.setInterpolator(Interpolator.LINEAR);
        rt4.play();
// STEP TEN: ADD A LIGHT SOURCE
       /* PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(-1000);
        light.setTranslateY(100);
        light.setTranslateZ(-1000);
        root.getChildren().add(light);*/
// Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D World");
        primaryStage.show();
    }
}