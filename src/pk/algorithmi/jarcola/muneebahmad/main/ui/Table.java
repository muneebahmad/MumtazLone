/**
 * copyright ©2013-2014 ®Algorithmi™.
 *
 * @author ¶muneebahmad¶ (ahmadgallian@yahoo.com) NetBeans IDE
 * http://www.netbeans.org
 *
 * The following source - code IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
  * *
 */
package pk.algorithmi.jarcola.muneebahmad.main.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import pk.algorithmi.jarcola.muneebahmad.data.SharedData;

/**
 *
 * @author muneebahmad
 */
public class Table extends Group implements EventHandler<Event>, TableListener {

    static Table sInstance = null;

    private final SharedData sharedData = SharedData.getInstance();

    private ImageView tableView;
    private Text titleText;
    private Text gameTypeText;
    private String gameTxt;

    public static final int GAME_TYPE_SINGLE = 0x02;
    public static final int GAME_TYPE_DOUBLE = 0x5b;
    public static final int GAME_TYPE_CENTURY = 0x2f;
    public static final int GAME_TYPE_TIMED = 0x906;

    public static final String GAME_SINGLE = "Single";
    public static final String GAME_DOUBLE = "Double";
    public static final String GAME_CENTURY = "Century";
    public static final String GAME_TIMED = "Timer";

    private static int gameType;

    private final ImageView bgViewGreen     = new ImageView(new Image(Table.class.getResourceAsStream("gfx/table-green2.png")));
    private final ImageView bgViewBlue      = new ImageView(new Image(Table.class.getResourceAsStream("gfx/table-blue.png")));
    private final ImageView fileView        = new ImageView(new Image(Table.class.getResourceAsStream("gfx/ic_file.png")));
    private final ImageView bgViewMeroon    = new ImageView(new Image(Table.class.getResourceAsStream("gfx/table-meroon.png")));

    private Button closeButt;
    private Button replayButt;

    static int ind;

    private int cafePrice;

    private ChoiceBox cafeItemsBox;

    private ArrayList<String> itemPrices;

    private Text cafePriceTxt;

    private int gamePrice = 0;
    private Text gamePriceTxt;
    private int totalPrice = 0;
    private Text totalPriceTxt;
    private int p = 0;
    private int defaulted = 0;

    public Table() {
    }

    /**
     *
     * @param title
     * @param player2
     * @param index
     */
    public Table(String title, String player2, int index) {
        sharedData.setIndex(0x1);
        NewDialog.addTableListener(this);
        makeTable(title, player2, index);
    }

    /**
     *
     * @param title
     * @param index
     */
    private void makeTable(final String title, final String player2, final int index) {
        ind = index;
        if (index % 2 == 0) {
            this.tableView = bgViewBlue;
        } else if (index % 3 == 0) {
            this.tableView = bgViewMeroon;
        } else {
            this.tableView = bgViewGreen;
        }

        switch (gameType) {
            case GAME_TYPE_SINGLE:
                this.gameTxt = GAME_SINGLE;
                for (GamePricingInfo game : GamePricingPersistence.gameItems) {
                    String n = "SINGLE";
                    final GamePricingInfo g = (GamePricingInfo) game;
                    if (n.equals(g.gameName)) {
                        totalPrice = (Integer.parseInt(g.gamePrice));
                        gamePrice = (Integer.parseInt(g.gamePrice));
                    }
                }
                break;
            case GAME_TYPE_DOUBLE:
                this.gameTxt = GAME_DOUBLE;
                for (GamePricingInfo game : GamePricingPersistence.gameItems) {
                    String n = "DOUBLE";
                    final GamePricingInfo g = (GamePricingInfo) game;
                    if (n.equals(g.gameName)) {
                        totalPrice = (Integer.parseInt(g.gamePrice));
                        gamePrice = (Integer.parseInt(g.gamePrice));
                    }
                }
                break;
            case GAME_TYPE_CENTURY:
                this.gameTxt = GAME_CENTURY;
                for (GamePricingInfo game : GamePricingPersistence.gameItems) {
                    String n = "CENTURY";
                    final GamePricingInfo g = (GamePricingInfo) game;
                    if (n.equals(g.gameName)) {
                        totalPrice = (Integer.parseInt(g.gamePrice));
                        gamePrice = (Integer.parseInt(g.gamePrice));
                    }
                }
                break;
            case GAME_TYPE_TIMED:
                this.gameTxt = GAME_TIMED;
                for (GamePricingInfo game : GamePricingPersistence.gameItems) {
                    String n = "TIMER";
                    final GamePricingInfo g = (GamePricingInfo) game;
                    if (n.equals(g.gameName)) {
                        totalPrice = (Integer.parseInt(g.gamePrice));
                        gamePrice = (Integer.parseInt(g.gamePrice));
                    }
                }
                break;
            default:
                break;
        }

        //bgView
        tableView.getTransforms().add(new Scale(1.6, 1.6, 0, 0));
        tableView.addEventHandler(EventType.ROOT, this);
        fileView.setLayoutX(270);
        fileView.getTransforms().add(new Scale(1, 30, 0, 0));

        ScaleTransition st = new ScaleTransition(Duration.millis(200), tableView);
        st.setFromX(0.5);
        st.setFromY(0.5);
        st.setToX(1.0);
        st.setToY(1.0);
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.play();

        titleText = new Text(0, 50, "[Table - " + index + "]\n" + title + "\n" + "VS\n" + player2);
        Font mFont = Font.loadFont(Table.class.getResourceAsStream("gfx/cheri.ttf"), 24);
        titleText.setFont(mFont);
        titleText.setX(40);
        titleText.setFill(Color.WHITE);

        gameTypeText = new Text(40, 170, "Game: " + gameTxt);
        gameTypeText.setFont(mFont);
        gameTypeText.setFill(Color.YELLOW);

        cafePrice = 0;
        cafePriceTxt = new Text(40, 205, "Cafe: " + cafePrice + " Rs");
        cafePriceTxt.setFont(mFont);
        cafePriceTxt.setFill(Color.WHITE);

        cafeItemsBox = new ChoiceBox();
        List<String> itemNames = new ArrayList();
        itemPrices = new ArrayList<>();
        for (CafeItemsInfo cafeItem : CafePricingPersistence.cafeItems) {
            itemNames.add(cafeItem.itemName);
            itemPrices.add(cafeItem.itemPrice);
        }
        ObservableList obList = FXCollections.observableList(itemNames);
        cafeItemsBox.setItems(obList);
        cafeItemsBox.setLayoutX(40);
        cafeItemsBox.setLayoutY(230);

        Button addPriceButt = new Button("+");
        addPriceButt.setLayoutX(180);
        addPriceButt.setLayoutY(230);
        addPriceButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int i = cafeItemsBox.getSelectionModel().getSelectedIndex();
                cafePrice += Integer.parseInt(itemPrices.get(i));
                cafePriceTxt.setText("Cafe: " + cafePrice + " Rs");
                totalPrice += cafePrice;
                totalPriceTxt.setText("Total: " + totalPrice + " Rs");
            }
        });
        
        gamePriceTxt = new Text(40, 290, "Game: " + gamePrice + " Rs");
        gamePriceTxt.setFont(mFont);
        gamePriceTxt.setFill(Color.YELLOW);
        
        totalPriceTxt = new Text(40, 325, "Total: " + totalPrice + " Rs");
        totalPriceTxt.setFont(mFont);
        totalPriceTxt.setFill(Color.YELLOW);

        this.replayButt = new Button("Replay");
        this.replayButt.setLayoutX(100);
        this.replayButt.setLayoutY(490);
        this.replayButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                totalPrice += gamePrice;
                gamePrice += gamePrice;
                gamePriceTxt.setText("Game: " + gamePrice + " Rs");
                totalPriceTxt.setText("Total: " + totalPrice + " Rs");
            }
        });

        this.closeButt = new Button("Clear");
        this.closeButt.setLayoutX(170);
        this.closeButt.setLayoutY(490);
        this.closeButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                System.out.println("REMOVING TABLE " + index + " FROM SCREEN.");
                CenterPane.removeChildAtIndex(Table.this);
                makeClearenceDialog(title, player2, index);
            }
        });

        this.getChildren().addAll(tableView, fileView, titleText, gameTypeText, cafePriceTxt, cafeItemsBox, addPriceButt,
                gamePriceTxt, totalPriceTxt, replayButt, closeButt);
    }
    
    private void makeClearenceDialog(final String player1, final String player2, final int index) {
        final Stage stage = new Stage();
        final Group grp = new Group();
        final Scene scene = new Scene(grp, 300, 350, Color.BISQUE);
        Font mFont = Font.loadFont(Table.class.getResourceAsStream("gfx/cheri.ttf"), 24);
        //----------------------------------------
            Text label = new Text(30, 40, "On Table: " + index + " which player lost the game?");
            label.setFill(Color.DARKGRAY);
            grp.getChildren().add(label);
            
            final Text finalStatement = new Text(30, 300, "");
            finalStatement.setFill(Color.RED);
            grp.getChildren().add(finalStatement);
        
            final ToggleGroup tGroup = new ToggleGroup();
            RadioButton player1Box = new RadioButton(player1);
            player1Box.setLayoutX(30);
            player1Box.setLayoutY(50);
            player1Box.setUserData(player1);
            player1Box.setTooltip(new Tooltip("Select either " + player1 + " lost the game."));
            player1Box.setToggleGroup(tGroup);
            grp.getChildren().add(player1Box);
            
            RadioButton player2Box = new RadioButton(player2);
            player2Box.setLayoutX(150);
            player2Box.setLayoutY(50);
            player2Box.setUserData(player2);
            player2Box.setSelected(true);
            player2Box.setTooltip(new Tooltip("Select either " + player2 + " lost the game."));
            player2Box.setToggleGroup(tGroup);
            grp.getChildren().add(player2Box);
            
            Text totalLabel = new Text(30, 90, "Total Collectable Amount");
            totalLabel.setFill(Color.DARKGRAY);
            grp.getChildren().add(totalLabel);
            
            TextField totalAmountField = new TextField(totalPrice + " Rs.");
            totalAmountField.setEditable(false);
            totalAmountField.setLayoutX(30);
            totalAmountField.setLayoutY(100);
            grp.getChildren().add(totalAmountField);
            
            Text gameLabel = new Text(30, 140, "Game Charges");
            gameLabel.setFill(Color.DARKGRAY);
            grp.getChildren().add(gameLabel);
            
            TextField tableAmountField = new TextField(gamePrice + " Rs.");
            tableAmountField.setEditable(false);
            tableAmountField.setLayoutX(30);
            tableAmountField.setLayoutY(150);
            grp.getChildren().add(tableAmountField);
            
            Text cafeLabel = new Text(30, 190, "Cafe Charges");
            cafeLabel.setFill(Color.DARKGRAY);
            grp.getChildren().add(cafeLabel);
            
            TextField cafeAmountField = new TextField(cafePrice + " Rs.");
            cafeAmountField.setEditable(false);
            cafeAmountField.setLayoutX(30);
            cafeAmountField.setLayoutY(200);
            grp.getChildren().add(cafeAmountField);
            
            tGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

                @Override
                public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                    if (t1.getUserData().equals(player1)) {
                        p = totalPrice - defaulted;
                        finalStatement.setText("Collect " + p + " Rs from '" + player1 + "'.");
                    } else if (t1.getUserData().equals(player2)) {
                        p = totalPrice - defaulted;
                        finalStatement.setText("Collect " + p + " Rs from '" + player2 + "'.");
                    }
                }
            });
            
            Text finalLabel = new Text(30, 240, "Enter Credit/Defaulted Amount if any");
            finalLabel.setFill(Color.DARKGRAY);
            grp.getChildren().add(finalLabel);
            
            final TextField defaulterAmountField = new TextField();
            defaulterAmountField.setLayoutX(30);
            defaulterAmountField.setLayoutY(250);
            defaulterAmountField.setMaxWidth(100);
            defaulterAmountField.setPromptText("Credit Amount");
            grp.getChildren().add(defaulterAmountField);
            
            Button addButt = new Button("+");
            addButt.setLayoutX(140);
            addButt.setLayoutY(250);
            grp.getChildren().add(addButt);
            addButt.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    defaulted = Integer.parseInt(defaulterAmountField.getText());
                    p = totalPrice - defaulted;
                    finalStatement.setText("Collect " + p + " Rs from '" + 
                            tGroup.getSelectedToggle().getUserData() + "'.");
                }
            });
            
            Button clearButt = new Button("Clear");
            clearButt.setLayoutX(230);
            clearButt.setLayoutY(320);
            clearButt.setDefaultButton(true);
            grp.getChildren().add(clearButt);
            clearButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                p = totalPrice - defaulted;
                MainWindow.setTotalAmount(p);
                if (defaulted > 0) {
                    GenericPersistence.addGamePrices(Calendar.getInstance().getTime() + "", 
                            tGroup.getSelectedToggle().getUserData().toString().toUpperCase() + "", defaulted + "");
                }
                TablePersistence.addTable( 
                        Calendar.getInstance().getTime() + "", "table" + index, 
                        tGroup.getSelectedToggle().getUserData().toString().toUpperCase() + "", cafePrice + "", p + 
                        "", defaulted + "", totalPrice + "");
                stage.close();
            }
        });
            
        //----------------------------------------
        stage.setTitle("Clearence Report");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param title
     * @param player2
     * @param index
     * @return
     */
    public static Table make(String title, String player2, int index) {
        return new Table(title, player2, index);
    }

    /**
     *
     * @param title
     * @param index
     * @return
     */
    public static Table getInstance(final String title, String player2, final int index) {
        synchronized (Table.class) {
            if (sInstance == null) {
                sInstance = new Table(title, player2, index);
            }
        }
        return sInstance;
    }

    /**
     *
     * @param event
     */
    @Override
    public void handle(Event event) {
    }

    /**
     *
     * @param title
     * @param index
     */
    @Override
    public void addTable(String title, int index) {

    }

    /**
     *
     * @param gameTyp
     */
    @Override
    public void addTableContents(int gameTyp) {
        gameType = gameTyp;
    }

    /**
     *
     * @param gameTyp
     */
    public static void setTableContents(int gameTyp) {
        gameType = gameTyp;
    }

    public static void removeAllChilds() {
    }

}/** end class. */
