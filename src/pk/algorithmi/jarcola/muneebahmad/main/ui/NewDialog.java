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

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
public class NewDialog {
    
    private final Stage         primaryStage =          new Stage();
    private Button              createButt;
    private Button              cancelButt;
    private Text                lblText;
    private Text                player1FieldLbl;
    private TextField           player1Field;
    private Text                player2FieldLbl;
    private TextField           player2Field;
    private Text                indexBoxLbl;
    private ChoiceBox           indexBox;
    
    private RadioButton         singleBox;
    private RadioButton         doubleBox;
    private RadioButton         centuryBox;
    private RadioButton         timedBox;
    private final ToggleGroup   tGroup =                new ToggleGroup();
    
    private Separator separator;
    
    private final ImageView     logo =                  new ImageView(new Image(NewDialog.class.getResourceAsStream("gfx/algo_logo3.png")));
    private static final String LBLTEXT =                 "This dialog creates and adds a new "
                                                        + "table to the table(s) stack, Just provide "
                                                        + "the correct name/title for your player(s)"
                                                        + " for example 'Mumtaz'";
    
    static TableListener        tableListen;
    private int                 index;
    

    public NewDialog() {}
    
    /**
     * 
     * @param title 
     */
    public NewDialog(String title) {
        Group root = new Group();
        Scene scene = new Scene(root, 0x190, 0x1f4, Color.BISQUE);
        
        
        //separator.getTransforms().add(new Scale(150, 2, 0, 0));
        
        //LOGO
        logo.setLayoutX(0x64);
        logo.setLayoutY(0x14);
        root.getChildren().add(logo);
        
        //LBL TXT
        lblText = new Text(0x32, 0x82, LBLTEXT);
        Font mFont = Font.font("Dialog", FontPosture.ITALIC, 0xf);
        lblText.setFont(mFont);
        lblText.setFill(Color.BLUEVIOLET);
        lblText.setWrappingWidth(0x12c);
        root.getChildren().add(lblText);
        
        makeSeperator(0, 0xc8, root);
        makeSeperator(0, 0x136, root);
        makeSeperator(0, 0x1c2, root);
        
        //Player1 FIELD TEXT
        player1FieldLbl = new Text(0x32, 0xdc, "Enter first player(s) name");
        Font tbFont = Font.font("Dialog", FontPosture.REGULAR, 0xc);
        player1FieldLbl.setFont(tbFont);
        player1FieldLbl.setFill(Color.DARKGREY);
        root.getChildren().add(player1FieldLbl);
        
        //Player2 FLD
        player1Field = new TextField();
        player1Field.setLayoutX(0x32);
        player1Field.setLayoutY(0xe6);
        player1Field.setPromptText("1st player name");
        root.getChildren().add(player1Field);
        
        //Player2 FIELD TXT
        player2FieldLbl = new Text(0x32, 0x10e, "Enter second player(s) name");
        player2FieldLbl.setFont(tbFont);
        player2FieldLbl.setFill(Color.DARKGREY);
        root.getChildren().add(player2FieldLbl);
        
        //Player2 FLD
        player2Field = new TextField();
        player2Field.setLayoutX(0x32);
        player2Field.setLayoutY(0x118);
        player2Field.setPromptText("2nd player name");
        root.getChildren().add(player2Field);
        
        //INDX BOX LBL
        this.indexBoxLbl = new Text(0x10e, 0x10e, "Select table number");
        indexBoxLbl.setFont(tbFont);
        indexBoxLbl.setFill(Color.DARKGREY);
        root.getChildren().add(indexBoxLbl);
        
        //INDX BOX
        this.indexBox = new ChoiceBox(FXCollections.observableArrayList(
                0x01, 0x02, 0x03, 0x04, 0x05, 
                0x06, 0x07, 0x08, 0x09, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15,
                0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x20, 0x21, 0x22, 0x23, 0x24,
                0x25, 0x26, 0x27, 0x28, 0x29, 0x2a, 0x2b, 0x2c, 0x2d, 0x2e, 0x2f, 0x30, 0x31, 0x32
                ));
        indexBox.setLayoutX(0x10e);
        indexBox.setLayoutY(0x118);
        indexBox.setValue(0x01);
        root.getChildren().add(indexBox);
        
        /***************/
        /** CHK BOXES **/
        /***************/
        
        this.singleBox = new RadioButton("Single Game");
        this.singleBox.setSelected(true);
        this.singleBox.setLayoutX(0x32);
        this.singleBox.setLayoutY(0x14a);
        this.singleBox.setUserData("Single");
        this.singleBox.setToggleGroup(tGroup);
        root.getChildren().add(singleBox);
        
        this.doubleBox = new RadioButton("Double Game");
        this.doubleBox.setLayoutX(0x32);
        this.doubleBox.setLayoutY(0x168);
        this.doubleBox.setUserData("Double");
        this.doubleBox.setToggleGroup(tGroup);
        root.getChildren().add(doubleBox);
        
        this.centuryBox = new RadioButton("Century Game");
        this.centuryBox.setLayoutX(0x32);
        this.centuryBox.setLayoutY(0x186);
        this.centuryBox.setUserData("Century");
        this.centuryBox.setToggleGroup(tGroup);
        root.getChildren().add(centuryBox);
        
        this.timedBox = new RadioButton("Timer Game");
        this.timedBox.setLayoutX(50);
        this.timedBox.setLayoutY(0x1a4);
        this.timedBox.setUserData("Timed");
        this.timedBox.setToggleGroup(tGroup);
        root.getChildren().add(timedBox);
        
        this.createButt = new Button("Create");
        this.createButt.setLayoutX(0x140);
        this.createButt.setLayoutY(0x1d6);
        this.createButt.setDefaultButton(true);
        this.createButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (tGroup.getSelectedToggle() == singleBox) {
                    Table.setTableContents(Table.GAME_TYPE_SINGLE);
                } else if (tGroup.getSelectedToggle() == doubleBox) {
                    Table.setTableContents(Table.GAME_TYPE_DOUBLE);
                } else if (tGroup.getSelectedToggle() == centuryBox) {
                    Table.setTableContents(Table.GAME_TYPE_CENTURY);
                } else if (tGroup.getSelectedToggle() == timedBox) {
                    Table.setTableContents(Table.GAME_TYPE_TIMED);
                }
                
                String title = player1Field.getText().toString();
                String idx = player2Field.getText().toString();
                index = 0x00;
                if (title != null && idx != null) {
                    index = indexBox.getSelectionModel().getSelectedIndex() + 0x01;
                    CenterPane.addTableAtIndex(title, idx, index);
                }
                primaryStage.close();
            }
        });
        root.getChildren().add(createButt);
        
        this.cancelButt = new Button("Cancel");
        this.cancelButt.setLayoutX(0xf5);
        this.cancelButt.setLayoutY(0x1d6);
        this.cancelButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                primaryStage.close();
            }
        });
        root.getChildren().add(cancelButt);
        
        //-----------------------------------
        primaryStage.setTitle(title);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
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
        separator.setMinWidth(0x190); 
        root.getChildren().add(separator);
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public static NewDialog make(String title) {
        return new NewDialog(title);
    }
    
    /**
     * 
     * @param tableListener 
     */
    public static void addTableListener(TableListener tableListener) {
        tableListen = tableListener;
    }
    
}/** end class. */
