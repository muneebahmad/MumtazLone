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

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class JLog {

    private final Stage primaryStage = new Stage();
    
    public JLog() {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BLACK);
        /////////////////////////////////////////////////////
            makeDialog(root);
        //----------------------------------
        primaryStage.setTitle("Debugger Log");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * 
     * @return 
     */
    public static JLog make() {
        return new JLog();
    }

    /**
     * 
     * @param root 
     */
    private void makeDialog(Group root) {
       Text logTxt = new Text(0, 10, ">cmp=~/.pk.algorithmi.jarcola.muneebahmad.main\n"
               + ">cmp=~/.pk.algorithmi.jarcola.muneebahmad.main.audio\n"
               + ">cmp=~/.pk.algorithmi.jarcola.muneebahmad.main.data\n"
               + ">cmp=~/.pk.algorithmi.jarcola.muneebahmad.main.images\n"
               + ">cmp=~/.pk.algorithmi.jarcola.muneebahmad.main.ui\n"
               + ">cmp=~/.pk.algorithmi.jarcola.muneebahmad.main.ui.gfx\n"
               + "\n>Loaded 35 classes successfully\n"
               + ">" + System.console());
       logTxt.setFill(Color.WHITE);
       root.getChildren().add(logTxt);
    }
    
}/** end class. */
