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

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class CenterPane extends FlowPane {
    
    private final ImageView     bgView =                new ImageView(new Image(CenterPane.class.getResourceAsStream("gfx/bg.png")));
    private ScrollPane          mScrollPane =           new ScrollPane();
    private static              FlowPane fp =           new FlowPane();

    public CenterPane() {
    }
    
    /**
     * 
     * @param primaryStage 
     */
    public CenterPane(Stage primaryStage) {
        fp.setPadding(new Insets(30));
        fp.setHgap(20);
        fp.setMinWidth(1500);
        mScrollPane.setPrefViewportWidth(1200);
        mScrollPane.setPrefViewportHeight(600);
        mScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        //mScrollPane.setHmax(1100);
        this.setPadding(new Insets(40));
        
        Text testText = new Text(0, 50, "HELLO THIS IS UNDER CONSTRUCTION");
        Font mFont = Font.font("Dialog", 15);
        testText.setFont(mFont);
        testText.setFill(Color.WHITE);
        
       // grp.getChildren().addAll();
        
        //---------------------------------------
         
        //--------------------------------------
        
        mScrollPane.setContent(fp);
        this.setPadding(new Insets(40));
        //this.getChildren().add(Table.make("Puppy vs Kutta", 2));
        //this.getChildren().add(Table.make("Ayaz Vs Fyaz", 3));
        //this.getChildren().add(Table.make("Ayaz Vs Fyaz", 4));
        
        this.getChildren().add(mScrollPane);
    }
    
    /**
     * 
     * @param title
     * @param index 
     */
    public static void addTableAtIndex(String player1, String player2, int index) {
        System.out.println("PRINRING TABLE ON SCREEN, Table No. " + index + " Child of fp @ ");
        fp.getChildren().add(Table.make(player1, player2, index));
    }
    
    /**
     * 
     * @param child 
     */
    public static void removeChildAtIndex(Node child) {
        fp.getChildren().remove(child);
    }
    
    /**
     * 
     */
    public static void removeAllChildren() {
    }

}/** end class. */
