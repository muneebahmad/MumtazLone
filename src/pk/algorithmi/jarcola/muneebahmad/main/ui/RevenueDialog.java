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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class RevenueDialog {

    private final Stage primaryStage;
    
    public RevenueDialog() {
        this.primaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 350, 300, Color.BISQUE);
        //------------------------------------------
        
        makeDialog(root);
        //------------------------------------------
        primaryStage.setTitle("Revenue Details");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * 
     * @param root 
     */
    private void makeDialog(Group root) {
        int amnt = MainWindow.getTotalAmount();
        int staffAmnt = 0;
        for (StaffInfo wagesItem : StaffWagesPersistence.wagesItems) {
            final StaffInfo s = (StaffInfo) wagesItem;
            staffAmnt += Integer.parseInt(s.staffWages);
        }   
        int profitAmnt = amnt - staffAmnt;
        int staffNo = StaffWagesPersistence.wagesItems.size();
        int staffIndAmnt = staffAmnt / staffNo;
        
        Text totalAmount = new Text(30, 30, "Total Revenue");
        totalAmount.setFill(Color.DARKGRAY);
        root.getChildren().add(totalAmount);
        
        TextField totalField = new TextField();
        totalField.setLayoutX(30);
        totalField.setLayoutY(40);
        totalField.setEditable(false);
        totalField.setText(amnt + " Rs");
        root.getChildren().add(totalField);
        
        Text staff = new Text(30, 80, "Staff/Employee(s) Wages");
        staff.setFill(Color.DARKGRAY);
        root.getChildren().add(staff);
        
        TextField staffField = new TextField();
        staffField.setLayoutX(30);
        staffField.setLayoutY(90);
        staffField.setEditable(false);
        staffField.setText(staffAmnt + " Rs");
        root.getChildren().add(staffField);
        
        Text profit = new Text(30, 140, "Total Collectable Amount");
        profit.setFill(Color.DARKGRAY);
        root.getChildren().add(profit);
        
        TextField profitField = new TextField();
        profitField.setLayoutX(30);
        profitField.setLayoutY(150);
        profitField.setEditable(false);
        profitField.setText(profitAmnt + " Rs");
        root.getChildren().add(profitField);
        
        Text finalStatement = new Text(30, 200, "Collect 'Rs " + profitAmnt + "' from the cash counter. "
                + "Pay '" + staffNo + "' employee(s) 'Rs " + staffIndAmnt + "' each.");
        finalStatement.setFill(Color.RED);
        finalStatement.setWrappingWidth(250);
        root.getChildren().add(finalStatement);
        
        Button closeButt = new Button("Ok");
        closeButt.setLayoutX(300);
        closeButt.setLayoutY(270);
        closeButt.setDefaultButton(true);
        root.getChildren().add(closeButt);
        closeButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                primaryStage.close();
            }
        });
    }
    
    /**
     * 
     * @return 
     */
    public static RevenueDialog make() {
        return new RevenueDialog();
    }
    
}/** end class. */
