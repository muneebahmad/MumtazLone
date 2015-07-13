/**
  * copyright ©2013-2014 ®Algorithmi™.
  *
  * @author ¶muneebahmad¶ (ahmadgallian@yahoo.com) 
  * NetBeans IDE http://www.netbeans.org
  *
  * The following source - code IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  * THE SOFTWARE.
  * **/
package pk.algorithmi.jarcola.muneebahmad.main;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;
import pk.algorithmi.jarcola.muneebahmad.main.ui.BufferedPwdWriterReader;
import pk.algorithmi.jarcola.muneebahmad.main.ui.MainWindow;

/**
 *
 * @author muneebahmad
 */
public class MumtazLone extends Application {
    
    private Stage               mainStage;
    private Stage               loginStage;
    private boolean             loggedIn =              false;
    private ImageView           puppyView;
    private String              pass;
    private PasswordField       pwdField;
    private final ImageView     logoView =              new ImageView(new Image(MumtazLone.class.getResourceAsStream("images/snooker-logo.png")));
    private final ImageView     bgView =                new ImageView(new Image(MumtazLone.class.getResourceAsStream("images/bg.png")));
    
    
    @Override
    public void start(Stage primaryStage) {
        loginStage = new Stage();
        makeLoginScreen(loginStage);
    }
    
    /**
     * 
     * @param primaryStage 
     */
    private void makeMainWindow(Stage primaryStage) {
        MainWindow window = new MainWindow(primaryStage);
    }
    
    /**
     * 
     * @param primaryStage 
     */
    private void makeLoginScreen(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 250, 450, Color.BISQUE);
        
        root.getChildren().add(bgView);
        bgView.getTransforms().add(new Scale(250, 450, 0, 0));
        
        //LOGO
        logoView.setLayoutX(35);
        logoView.setLayoutY(10);
        root.getChildren().add(logoView);
        
        //LABEL
        /**Text userName = new Text(24, 44, "R2 Snooker");
        Font dialogFont = Font.font("Dialog", 35);
        userName.setFont(dialogFont);
        userName.setFill(Color.DARKBLUE);
        root.getChildren().add(userName);
        * **/
        Reflection reflect = new Reflection();
        reflect.setFraction(0.6f);
        reflect.setTopOffset(-45);
        logoView.setEffect(reflect);
        
        FadeTransition fd = new FadeTransition(Duration.millis(1500), logoView);
        fd.setFromValue(1);
        fd.setToValue(0.2);
        fd.setAutoReverse(true);
        fd.setCycleCount(Integer.MAX_VALUE);
        //fd.play();
        
        //PUPPY IMAGE
        this.puppyView = new ImageView(new Image(MumtazLone.class.
                getResourceAsStream("images/main_image.png")));
        this.puppyView.setLayoutX(35);
        this.puppyView.setLayoutY(160);
        root.getChildren().add(puppyView);
        Reflection ref = new Reflection();
        ref.setFraction(0.8f);
        ref.setTopOffset(-15);
        puppyView.setEffect(ref);
        
        //Password LABEL
        Text pwdText = new Text(24, logoView.getLayoutY() + 330, "Enter Password");
        Font pwdTextFnt = Font.font("Dialog", 15);
        pwdText.setFont(pwdTextFnt);
        pwdText.setFill(Color.DARKGRAY);
        root.getChildren().add(pwdText);
        
        //FIELD
        pwdField = new PasswordField();
        pwdField.setLayoutX(24);
        pwdField.setLayoutY(logoView.getLayoutY() + 340);
        pwdField.setPromptText("password");
        root.getChildren().add(pwdField);
        
        //BUTTONS
        Button resetButt = new Button("Reset");
        resetButt.setLayoutX(45);
        resetButt.setLayoutY(420);
        resetButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                pwdField.setText("");
            }
        });
        root.getChildren().add(resetButt);
        
        Button forgotButt = new Button("Forgot!");
        forgotButt.setLayoutX(110);
        forgotButt.setLayoutY(420);
        forgotButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                makeForgotDialog();
            }
        });
        root.getChildren().add(forgotButt);
        
        Button enterButt = new Button("Enter");
        enterButt.setLayoutX(185);
        enterButt.setLayoutY(420);
        enterButt.setDefaultButton(true);
        enterButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                pass = pwdField.getText().toString();
                if (pass.equals(BufferedPwdWriterReader.readPwd())) {
                    mainStage = new Stage();
                    makeMainWindow(mainStage);
                    loginStage.close();
                    System.out.println("\n\nSUCCESSFULL\n");
                } else {
                    makePuppyNoAnim();
                }
            }

            private void makePuppyNoAnim() {
                TranslateTransition td = new TranslateTransition(Duration.millis(50), puppyView);
                td.setFromX(0);
                td.setToX(10);
                td.setCycleCount(10);
                td.setAutoReverse(true);
                td.setInterpolator(Interpolator.EASE_BOTH);
                td.play();
                //makeErrorDialog();
            }
        });
        root.getChildren().add(enterButt);
        FadeTransition bd = new FadeTransition(Duration.millis(500), enterButt);
        bd.setFromValue(1);
        bd.setToValue(0.7);
        bd.setAutoReverse(true);
        bd.setCycleCount(Integer.MAX_VALUE);
        bd.play();
        
        //-------------------------
        primaryStage.setTitle("Login to Enter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    
    private void makeErrorDialog() {
        final Stage errStage = new Stage();
        Group root = new Group();
        Scene scn = new Scene(root, 700, 200, Color.BISQUE);
        
        //LABEL
        Text userName = new Text(200, 100, "Your provided password is wrong");
        Font dialogFont = Font.font("Dialog", 30);
        userName.setFont(dialogFont);
        userName.setFill(Color.ORANGERED);
        root.getChildren().add(userName);
        Reflection reflect = new Reflection();
        reflect.setFraction(0.8f);
        reflect.setTopOffset(-8);
        userName.setEffect(reflect);
        
        //PUPPY IMAGE
        this.puppyView = new ImageView(new Image(MumtazLone.class.
                getResourceAsStream("images/puppy33.png")));
        this.puppyView.setLayoutX(5);
        this.puppyView.setLayoutY(5);
        root.getChildren().add(puppyView);
        Reflection ref = new Reflection();
        ref.setFraction(0.8f);
        ref.setTopOffset(-85);
        puppyView.setEffect(ref);
        
        RotateTransition rT = new RotateTransition(Duration.millis(3000), puppyView);
        rT.setFromAngle(0);
        rT.setToAngle(359);
        rT.setAutoReverse(true);
        rT.setCycleCount(Integer.MAX_VALUE);
        rT.play();
        
        //BUTTON
        Button exitButton = new Button("Exit");
        exitButton.setLayoutX(530);
        exitButton.setLayoutY(170);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        root.getChildren().add(exitButton);
        
        Button againButt = new Button("Try Again!");
        againButt.setLayoutX(600);
        againButt.setLayoutY(170);
        againButt.setDefaultButton(true);
        againButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                errStage.close();
            }
        });
        root.getChildren().add(againButt);
        FadeTransition bd = new FadeTransition(Duration.millis(500), againButt);
        bd.setFromValue(1);
        bd.setToValue(0.7);
        bd.setAutoReverse(true);
        bd.setCycleCount(Integer.MAX_VALUE);
        bd.play();
        
        //--------------------------------
        errStage.setTitle("Error Occured");
        errStage.setScene(scn);
        errStage.setResizable(false);
        errStage.show();
    }
    
    private void makeForgotDialog() {
        final Stage errStage = new Stage();
        Group root = new Group();
        Scene scn = new Scene(root, 700, 200, Color.BISQUE);
        
        //LABEL
        Text userName = new Text(200, 100, "Contact Muneeb Ahmad: "
                + "ahmadgallian@yahoo.com");
        Font dialogFont = Font.font("Dialog", 20);
        userName.setFont(dialogFont);
        userName.setFill(Color.BLUE);
        root.getChildren().add(userName);
        Reflection reflect = new Reflection();
        reflect.setFraction(0.8f);
        reflect.setTopOffset(-8);
        userName.setEffect(reflect);
        
        //PUPPY IMAGE
        this.puppyView = new ImageView(new Image(MumtazLone.class.
                getResourceAsStream("images/main_image.png")));
        this.puppyView.setLayoutX(5);
        this.puppyView.setLayoutY(5);
        root.getChildren().add(puppyView);
        Reflection ref = new Reflection();
        ref.setFraction(0.8f);
        ref.setTopOffset(-85);
        puppyView.setEffect(ref);
        
        RotateTransition rT = new RotateTransition(Duration.millis(3000), puppyView);
        rT.setFromAngle(0);
        rT.setToAngle(359);
        rT.setAutoReverse(true);
        rT.setCycleCount(Integer.MAX_VALUE);
        rT.play();
        
        //BUTTON
        Button exitButton = new Button("Exit");
        exitButton.setLayoutX(530);
        exitButton.setLayoutY(170);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        root.getChildren().add(exitButton);
        
        Button againButt = new Button("OK!");
        againButt.setLayoutX(600);
        againButt.setLayoutY(170);
        againButt.setDefaultButton(true);
        againButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                errStage.close();
            }
        });
        root.getChildren().add(againButt);
        FadeTransition bd = new FadeTransition(Duration.millis(500), againButt);
        bd.setFromValue(1);
        bd.setToValue(0.7);
        bd.setAutoReverse(true);
        bd.setCycleCount(Integer.MAX_VALUE);
        bd.play();
        
        //--------------------------------
        errStage.setTitle("PUPPY'S MEMORY LOSS");
        errStage.setScene(scn);
        errStage.setResizable(false);
        errStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}/** end class. */
