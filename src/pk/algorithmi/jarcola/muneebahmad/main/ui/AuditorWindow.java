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

import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class AuditorWindow {

    private final ImageView logo = new ImageView(new Image(AboutDialog.class.getResourceAsStream("gfx/algo_logo3.png")));
    private static final String TITLE = "Auditor/Worksheet Window";
    private static final String LBLTXT = "View the earnings of every table with respect to date and time.";

    private final HashMap<String, String> priceMap;

    private final ScrollPane scrollPane;
    private final FlowPane fp = new FlowPane(Orientation.VERTICAL);
    private final BorderPane bp = new BorderPane();

    private final Stage primaryStage;
    private final Group root;
    private final BorderPane logoChildBP = new BorderPane();
    private final BorderPane labelChildBP = new BorderPane();

    private final Scene scene;

    private Text lblText;

    private Button addButt;

    private Separator separator;

    /**
     * DEFAULT.
     */
    public AuditorWindow() {
        this.priceMap = new HashMap<>();
        this.primaryStage = new Stage();
        this.root = new Group();
        this.scrollPane = new ScrollPane();
        this.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.scene = new Scene(scrollPane, 1000, 700, Color.LIGHTGREY);

        makeDialog(fp);

        fp.setMinSize(900, 690);
        fp.setAlignment(Pos.TOP_CENTER);

        bp.setTop(logoChildBP);
        bp.setCenter(labelChildBP);
        bp.setBottom(fp);

        root.getChildren().add(bp);

        scrollPane.setContent(root);

        //--------------------------------------------
        this.primaryStage.setTitle(TITLE);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }

    /**
     *
     * @param fp
     */
    private void makeDialog(FlowPane fp) {

        Separator sp = new Separator();

        //LOGO
        logoChildBP.setCenter(logo);

        //LBL TXT
        lblText = new Text(LBLTXT);
        Font mFont = Font.font("Dialog", FontPosture.ITALIC, 0xf);
        lblText.setFont(mFont);
        lblText.setFill(Color.BLUEVIOLET);
        lblText.setWrappingWidth(0x12c);
        labelChildBP.setCenter(lblText);

        //----------------------------------------------------------------------
        addItems(fp, "DATE & TIME", "TABLE", "PLAYER", "CAFE", "DEBIT", "CREDIT", "TOTAL");
        for (TableInfo tableInfo : TablePersistence.tableItems) {
            final TableInfo table = (TableInfo) tableInfo;
            addItems(fp, table.tableName, table.tableNo, table.player, table.cafe, 
                    table.debit, table.credit, table.total);
        }
        //----------------------------------------------------------------------
        this.addButt = new Button("ADD NEW");
        this.addButt.setDefaultButton(true);
        this.addButt.setAlignment(Pos.TOP_RIGHT);
        this.addButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                addNewItemsDialog();
                primaryStage.close();
            }
        });
        fp.getChildren().add(addButt);
    }

    /**
     *
     * @param fp
     */
    private void addItems(FlowPane fp, final String date, String table, String player, 
            String cafe, String debit, String credit, String total) {

        
            FlowPane horizontalPane = new FlowPane(Orientation.HORIZONTAL);
            horizontalPane.setMinWidth(800);
            horizontalPane.setHgap(2);
            horizontalPane.setAlignment(Pos.TOP_CENTER);
            
            //Items FLD -----------------------------------------------------------
            TextField itemName = new TextField();
            itemName.setMinWidth(210);
            itemName.setText(date);
            itemName.setEditable(false);
            itemName.setPromptText("Item Name");
            horizontalPane.getChildren().add(itemName);
            
            TextField itemPrice = new TextField();
            itemPrice.setMaxWidth(70);
            itemPrice.setText(table);
            itemPrice.setEditable(false);
            itemPrice.setPromptText("Price PKR");
            horizontalPane.getChildren().add(itemPrice);
            
            TextField playerName = new TextField();
            playerName.setMaxWidth(70);
            playerName.setText(player);
            playerName.setEditable(false);
            playerName.setPromptText("Price PKR");
            horizontalPane.getChildren().add(playerName);
            
            TextField cafeItem = new TextField();
            cafeItem.setMaxWidth(70);
            cafeItem.setText(cafe);
            cafeItem.setEditable(false);
            cafeItem.setPromptText("Price PKR");
            horizontalPane.getChildren().add(cafeItem);
            
            TextField debitName = new TextField();
            debitName.setMaxWidth(70);
            debitName.setText(debit);
            debitName.setEditable(false);
            debitName.setPromptText("Price PKR");
            horizontalPane.getChildren().add(debitName);
            
            TextField creditI = new TextField();
            creditI.setMaxWidth(70);
            creditI.setText(credit);
            creditI.setEditable(false);
            creditI.setPromptText("Price PKR");
            horizontalPane.getChildren().add(creditI);
            
            TextField totalN = new TextField();
            totalN.setMaxWidth(70);
            totalN.setText(total);
            totalN.setEditable(false);
            totalN.setPromptText("Price PKR");
            horizontalPane.getChildren().add(totalN);
            
            
            Button saveButt = new Button("Delete");
            horizontalPane.getChildren().add(saveButt);
            saveButt.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    TablePersistence.deleteTable(date);
                    primaryStage.close();
                    new AuditorWindow();
                }
            });
            fp.getChildren().add(horizontalPane);
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
    public static AuditorWindow make() {
        return new AuditorWindow();
    }

    private void addNewItemsDialog() {
        final Stage secondaryStage = new Stage();
        final Group grp = new Group();
        final Scene secondaryScene = new Scene(grp, 300, 200, Color.BISQUE);
        //------------------------------------
        Font fnt = Font.font("Dialog", 0xc);

        Text nameTxt = new Text(30, 30, "NOTHING TO PERSIST");
        nameTxt.setFont(fnt);
        nameTxt.setFill(Color.DARKGRAY);
        grp.getChildren().add(nameTxt);

        final TextField nameField = new TextField();
        nameField.setLayoutX(30);
        nameField.setLayoutY(40);
        nameField.setMinWidth(240);
        nameField.setPromptText("NOTHING TO PERSIST");
        grp.getChildren().add(nameField);

        Text priceTxt = new Text(30, 90, "NOTHING TO PERSIST");
        priceTxt.setFont(fnt);
        priceTxt.setFill(Color.DARKGRAY);
        grp.getChildren().add(priceTxt);

        final TextField priceField = new TextField();
        priceField.setLayoutX(30);
        priceField.setLayoutY(100);
        priceField.setMinWidth(240);
        priceField.setPromptText("NOTHING TO PERSIST");
        grp.getChildren().add(priceField);

        Button saveButton = new Button("Close");
        saveButton.setLayoutX(230);
        saveButton.setLayoutY(170);
        saveButton.setDefaultButton(true);
        grp.getChildren().add(saveButton);
        saveButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                //TablePersistence.addTable(nameField.getText().toUpperCase(), priceField.getText());
                secondaryStage.close();
                new AuditorWindow();
            }
        });

        //------------------------------------
        secondaryStage.setScene(secondaryScene);
        secondaryStage.setResizable(false);
        secondaryStage.setTitle("Add Info");
        secondaryStage.show();
    }
    
}/** end class. */
