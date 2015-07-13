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

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class Calculator implements javafx.event.EventHandler<KeyEvent> {

    private final Stage primaryStage                = new Stage();
    private final Group root                        = new Group();
    
    private Scene scene;
    
    public static Calculator sInstance              = null;
    
    private final TextField displayFld              = new TextField();
    
    private Separator separator;
    
    private Button equalButt;
    
    int i;
    
    public static final int OPR_ADDITION            = 0x001;
    public static final int OPR_SUBTRACTION         = 0x002;
    public static final int OPR_MULTIPLICATION      = 0x00a;
    public static final int OPR_DIVISION            = 0x003;
    public static final int OPR_NULL                = 0x00;
    
    private int operatorType;
    
    private boolean decimalUsed                     = false;
    private String memResult;
    
    private double firstResult;
    private double secondResult;
    private double finalResult;
    
    public Calculator() {
        displayFld.setOnKeyPressed(this);
        this.operatorType = OPR_NULL;
        this.scene = new Scene(root, 175, 260, Color.LIGHTGREY);
        //-----------------------------------
            renderNumButts();
        //-----------------------------------
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void renderNumButts() {
        FlowPane fldPane = new FlowPane();
        fldPane.setMinWidth(170);
        fldPane.setLayoutX(2.5);
        fldPane.setLayoutY(2.5);
        
        displayFld.setMinWidth(170);
        displayFld.setTooltip(new Tooltip("Calculator I/O Field"));
        displayFld.setPromptText("0.00");
        displayFld.setAlignment(Pos.BASELINE_RIGHT);
        displayFld.setEditable(false);
        fldPane.getChildren().add(displayFld);
        
        root.getChildren().add(fldPane);
        
        //----------------------------------
        makeSeperator(0, 40, root);
        
        Button memButt = new Button("MEM");
        memButt.setLayoutX(175 / 2 - 75);
        memButt.setLayoutY(55);
        root.getChildren().add(memButt);
        memButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                displayFld.setText(memResult);
            }
        });
        
        Button resetButt = new Button("AC");
        resetButt.setLayoutX(175 / 2 - 20);
        resetButt.setLayoutY(55);
        root.getChildren().add(resetButt);
        resetButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                displayFld.setText("");
            }
        });
        
        makeSeperator(0, 90, root);
        //-----------------------------------
        
        FlowPane fp = new FlowPane();
        fp.setPrefWrapLength(125);
        fp.setLayoutX(175 / 2 - 75);
        fp.setLayoutY(100);
        fp.setHgap(10);
        fp.setVgap(10);
        final ArrayList<Button> buttonList = new ArrayList<Button>();
        
        for (i = 0; i < 10; i++) {
            buttonList.add(new Button("" + i));
           // numButts[i] = new Button("" + i);
            buttonList.get(i).setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    try {
                        for (int j = 0; j < buttonList.size(); j++) {
                            if (t.getTarget() == buttonList.get(j)) {
                                displayFld.appendText(buttonList.get(j).getText());
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        
                    }
                }
            });
            try {
                fp.getChildren().add(buttonList.get(i));
            } catch (IndexOutOfBoundsException e) {
                
            }
        }
        
        root.getChildren().add(fp);
        
        addOperatorButts();
    }
    
    /**
     * 
     * @param rt 
     */
    private void addOperatorButts() {
        Button divideButt = new Button("/");
        divideButt.setLayoutX(163 - 30);
        divideButt.setLayoutY(100);
        root.getChildren().add(divideButt);
        divideButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                operatorType = OPR_DIVISION;
                if (displayFld.getText().toString() != null) {
                    firstResult = Double.parseDouble(displayFld.getText().toString());
                } else {
                    displayFld.setText("PLEASE ENTER A VALID NUMBER");
                }
                displayFld.setText("");
                equalButt.setDisable(false);
                decimalUsed = false;
            }
        });
        
        Button minusButt = new Button("-");
        minusButt.setLayoutX(163 - 30);
        minusButt.setLayoutY(132);
        root.getChildren().add(minusButt);
        minusButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                operatorType = OPR_SUBTRACTION;
                if (displayFld.getText().toString() != null) {
                    firstResult = Double.parseDouble(displayFld.getText().toString());
                } else {
                    displayFld.setText("PLEASE ENTER A VALID NUMBER");
                }
                displayFld.setText("");
                equalButt.setDisable(false);
                decimalUsed = false;
            }
        });
        
        Button multiplyButt = new Button("x");
        multiplyButt.setLayoutX(163 - 30);
        multiplyButt.setLayoutY(162);
        root.getChildren().add(multiplyButt);
        multiplyButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                operatorType = OPR_MULTIPLICATION;
                if (displayFld.getText().toString() != null) {
                    firstResult = Double.parseDouble(displayFld.getText().toString());
                } else {
                    displayFld.setText("PLEASE ENTER A VALID NUMBER");
                }
                displayFld.setText("");
                equalButt.setDisable(false);
                decimalUsed = false;
            }
        });
        
        
        Button plusButt = new Button("+");
        plusButt.setLayoutX(163 - 30);
        plusButt.setLayoutY(192);
        plusButt.setMinHeight(50);
        root.getChildren().add(plusButt);
        plusButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                operatorType = OPR_ADDITION;
                if (displayFld.getText().toString() != null) {
                    firstResult = Double.parseDouble(displayFld.getText().toString());
                } else {
                    displayFld.setText("PLEASE ENTER A VALID NUMBER");
                }
                displayFld.setText("");
                equalButt.setDisable(false);
                decimalUsed = false;
            }
        });
        
        Button decimalButt = new Button(".");
        decimalButt.setLayoutX(52);
        decimalButt.setLayoutY(193);
        decimalButt.setMinWidth(73);
        root.getChildren().add(decimalButt);
        decimalButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (!decimalUsed) {
                    displayFld.appendText(".");
                    decimalUsed = true;
                }
            }
        });
        
        equalButt = new Button("=");
        equalButt.setLayoutX(175 / 2 - 75);
        equalButt.setLayoutY(221);
        equalButt.setMinWidth(113);
        equalButt.setDefaultButton(true);
        equalButt.setDisable(true);
        root.getChildren().add(equalButt);
        equalButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                decimalUsed = false;
                equalButt.setDisable(true);
                if (displayFld.getText().toString() != null) {
                    secondResult = Double.parseDouble(displayFld.getText().toString());
                } else {
                    displayFld.setText("PLEASE ENTER A VALID NUMBER");
                }
                
                if (operatorType == OPR_ADDITION) {
                    finalResult = firstResult + secondResult;
                    displayFld.setText("" + finalResult);
                    memResult = "" + finalResult; 
                } else if (operatorType == OPR_DIVISION) {
                    finalResult = firstResult / secondResult;
                    displayFld.setText("" + finalResult);
                    memResult = "" + finalResult;
                } else if (operatorType == OPR_MULTIPLICATION) {
                    finalResult = firstResult * secondResult;
                    displayFld.setText("" + finalResult);
                    memResult = "" + finalResult;
                }  else if (operatorType == OPR_SUBTRACTION) {
                    finalResult = firstResult - secondResult;
                    displayFld.setText("" + finalResult);
                    memResult = "" + finalResult;
                }
                
                operatorType = OPR_NULL;
            }
        });
        
        
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
        separator.setMinWidth(175); 
        root.getChildren().add(separator);
    }
    
    /**
     * 
     * @return new instance of {@link pk.algorithmi.jarcola.muneebahmad.main.ui.Calculator}
     */
    public static Calculator make() {
        return new Calculator();
    }

    @Override
    public void handle(KeyEvent t) {
        if (t.getCode() == KeyCode.NUMPAD0) {
            displayFld.appendText("0");
        } else if (t.getCode() == KeyCode.NUMPAD1) {
            displayFld.appendText("1");
        } else if (t.getCode() == KeyCode.NUMPAD2) {
            displayFld.appendText("2");
        } else if (t.getCode() == KeyCode.NUMPAD3) {
            displayFld.appendText("3");
        } else if (t.getCode() == KeyCode.NUMPAD4) {
            displayFld.appendText("4");
        } else if (t.getCode() == KeyCode.NUMPAD5) {
            displayFld.appendText("5");
        } else if (t.getCode() == KeyCode.NUMPAD6) {
            displayFld.appendText("6");
        } else if (t.getCode() == KeyCode.NUMPAD7) {
            displayFld.appendText("7");
        } else if (t.getCode() == KeyCode.NUMPAD8) {
            displayFld.appendText("8");
        } else if (t.getCode() == KeyCode.NUMPAD9) {
            displayFld.appendText("9");
        }
    }
    
}/** end class. */
