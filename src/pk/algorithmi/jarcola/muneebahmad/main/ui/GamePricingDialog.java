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

package pk.algorithmi.jarcola.muneebahmad.main.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class GamePricingDialog {

    private final ImageView logo = new ImageView(new Image(AboutDialog.class.getResourceAsStream("gfx/algo_logo3.png")));
    private static final String TITLE = "Game Pricing Dialog";
    private static final String LBLTXT = "This dialog menu will set the price(s) of different"
                                        + " game(s) type(s) provieded in your Cue Club!. You can"
                                        + " edit them whenever you desire.";
    
    private Stage primaryStage;
    private Group root;
    private Scene scene;
    
    private Text lblText;
    private Text singleTxt;
    private TextField singleField;
    private Button singleSaveButt;
    private Text doubleTxt;
    private TextField doubleField;
    private Button doubleSaveButt;
    private Text centuryTxt;
    private TextField centuryField;
    private Button centurySaveButt;
    private Text timerTxt;
    private TextField timerField;
    private Button timerSaveButt;
    private Button saveAllButt;
    
    private Separator separator;
    
    /**
     * DEFAULT.
     */
    public GamePricingDialog() {
        this.primaryStage = new Stage();
        this.root = new Group();
        this.scene = new Scene(root, 0x190, 0x1f4, Color.LIGHTGREY);
        
        makeDialog(root);
        
        //--------------------------------------------
        this.primaryStage.setTitle(TITLE);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }
    
    /**
     * 
     * @param root 
     */
    private void makeDialog(Group root) {
        
        makeSeperator(0, 0xc8, root);
        
        //LOGO
        logo.setLayoutX(0x64);
        logo.setLayoutY(0x14);
        root.getChildren().add(logo);
        
        //LBL TXT
        lblText = new Text(0x32, 0x82, LBLTXT);
        Font mFont = Font.font("Dialog", FontPosture.ITALIC, 0xf);
        lblText.setFont(mFont);
        lblText.setFill(Color.BLUEVIOLET);
        lblText.setWrappingWidth(0x12c);
        root.getChildren().add(lblText);
        
        //SINGLE FLD -----------------------------------------------------------
        this.singleTxt = new Text(0x32, 250, "Single Game");
        Font fnt = Font.font("Dialog", 0xc);
        singleTxt.setFont(fnt);
        singleTxt.setFill(Color.BLUEVIOLET);
        root.getChildren().add(singleTxt);
        
        this.singleField = new TextField();
        this.singleField.setLayoutX(165);
        this.singleField.setLayoutY(235);
        this.singleField.setMaxWidth(70);
        for (GamePricingInfo game : GamePricingPersistence.gameItems) {
            String n = "SINGLE";
            final GamePricingInfo g = (GamePricingInfo) game;
            if (n.equals(g.gameName))
                singleField.setText(g.gamePrice);
        }
        this.singleField.setPromptText("Price PKR");
        root.getChildren().add(singleField);
        
        this.singleSaveButt = new Button("Save");
        this.singleSaveButt.setLayoutX(280);
        this.singleSaveButt.setLayoutY(235);
        this.singleSaveButt.setDisable(true);
        this.singleSaveButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            }
        });
        root.getChildren().add(this.singleSaveButt);
        //----------------------------------------------------------------------
        
        makeSeperator(0, 275, root);
        
        //DOUBLE FLD -----------------------------------------------------------
        this.doubleTxt = new Text(0x32, 300, "Double Game");
        doubleTxt.setFont(fnt);
        doubleTxt.setFill(Color.BLUEVIOLET);
        root.getChildren().add(doubleTxt);
        
        this.doubleField = new TextField();
        this.doubleField.setLayoutX(165);
        this.doubleField.setLayoutY(285);
        this.doubleField.setMaxWidth(70);
        for (GamePricingInfo game : GamePricingPersistence.gameItems) {
            String n = "DOUBLE";
            final GamePricingInfo g = (GamePricingInfo) game;
            if (n.equals(g.gameName))
                doubleField.setText(g.gamePrice);
        }
        this.doubleField.setPromptText("Price PKR");
        root.getChildren().add(doubleField);
        
        this.doubleSaveButt = new Button("Save");
        this.doubleSaveButt.setLayoutX(280);
        this.doubleSaveButt.setLayoutY(285);
        this.doubleSaveButt.setDisable(true);
        this.doubleSaveButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            }
        });
        root.getChildren().add(this.doubleSaveButt);
        //----------------------------------------------------------------------
        
        makeSeperator(0, 325, root);
        
        //CENTURY FLD -----------------------------------------------------------
        this.centuryTxt = new Text(0x32, 350, "Century Game");
        centuryTxt.setFont(fnt);
        centuryTxt.setFill(Color.BLUEVIOLET);
        root.getChildren().add(centuryTxt);
        
        this.centuryField = new TextField();
        this.centuryField.setLayoutX(165);
        this.centuryField.setLayoutY(335);
        this.centuryField.setMaxWidth(70);
        for (GamePricingInfo game : GamePricingPersistence.gameItems) {
            String n = "CENTURY";
            final GamePricingInfo g = (GamePricingInfo) game;
            if (n.equals(g.gameName))
                centuryField.setText(g.gamePrice);
        }
        this.centuryField.setPromptText("Price PKR");
        root.getChildren().add(centuryField);
        
        this.centurySaveButt = new Button("Save");
        this.centurySaveButt.setLayoutX(280);
        this.centurySaveButt.setLayoutY(335);
        this.centurySaveButt.setDisable(true);
        this.centurySaveButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            }
        });
        root.getChildren().add(this.centurySaveButt);
        //----------------------------------------------------------------------
        
        makeSeperator(0, 375, root);
        
        //TIMER FLD -----------------------------------------------------------
        this.timerTxt = new Text(0x32, 400, "Timer Game");
        timerTxt.setFont(fnt);
        timerTxt.setFill(Color.BLUEVIOLET);
        root.getChildren().add(timerTxt);
        
        this.timerField = new TextField();
        this.timerField.setLayoutX(165);
        this.timerField.setLayoutY(385);
        this.timerField.setMaxWidth(70);
        for (GamePricingInfo game : GamePricingPersistence.gameItems) {
            String n = "TIMER";
            final GamePricingInfo g = (GamePricingInfo) game;
            if (n.equals(g.gameName))
                timerField.setText(g.gamePrice);
        }
        this.timerField.setPromptText("Price PKR");
        root.getChildren().add(timerField);
        
        this.timerSaveButt = new Button("Save");
        this.timerSaveButt.setLayoutX(280);
        this.timerSaveButt.setLayoutY(385);
        this.timerSaveButt.setDisable(true);
        this.timerSaveButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            }
        });
        root.getChildren().add(this.timerSaveButt);
        //----------------------------------------------------------------------
        
        makeSeperator(0, 425, root);
        
        //----------------------------------------------------------------------
        
        this.saveAllButt = new Button("Save");
        this.saveAllButt.setLayoutX(320);
        this.saveAllButt.setLayoutY(470);
        this.saveAllButt.setDefaultButton(true);
        this.saveAllButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                GamePricingPersistence.deleteGamePrices("SINGLE");
                GamePricingPersistence.addGamePrices("single".toUpperCase(), singleField.getText());
                GamePricingPersistence.deleteGamePrices("DOUBLE");
                GamePricingPersistence.addGamePrices("double".toUpperCase(), doubleField.getText());
                GamePricingPersistence.deleteGamePrices("CENTURY");
                GamePricingPersistence.addGamePrices("century".toUpperCase(), centuryField.getText());
                GamePricingPersistence.deleteGamePrices("TIMER");
                GamePricingPersistence.addGamePrices("timer".toUpperCase(), timerField.getText());
                primaryStage.close();
            }
        });
        root.getChildren().add(saveAllButt);
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param root 
     */
    private void makeSeperator(double x, double y, Group root) {
        this.separator = new Separator(Orientation.HORIZONTAL);
        separator.setLayoutX(x);
        separator.setLayoutY(y);
        separator.setEffect(new Reflection());
        separator.setMinWidth(0x190); 
        root.getChildren().add(separator);
    }
    
    /**
     * 
     * @return 
     */
    public static GamePricingDialog makeGamePricingDialog() {
        return new GamePricingDialog();
    }
    
}/** end class. */
