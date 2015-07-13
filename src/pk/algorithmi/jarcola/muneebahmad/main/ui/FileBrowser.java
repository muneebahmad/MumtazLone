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

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class FileBrowser {
    
    private Stage primaryStage;
    private Scene scene;
    
    private final ImageView     logo =                  new ImageView(new Image(NewDialog.class.getResourceAsStream("gfx/algo_logo3.png")));
    
    private Text fileFLbl;
    private TextField fileField;
    
    String path;
    String filePath;
    
    public FileBrowser() {
        this.primaryStage = new Stage();
        Group root = new Group();
        scene = new Scene(root, 600, 500, Color.LIGHTGRAY);
        
        makeDialog(root);
        
        //------------------------------
        this.primaryStage.setTitle("Open Dialog for only '.puppy' files");
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }
    
    /**
     * 
     * @param root 
     */
    private void makeDialog(Group root) {
        logo.setLayoutX(600 / 2 - 140 / 2);
        logo.setLayoutY(10);
        logo.getTransforms().add(new Scale(0.7, 0.7, 0, 0));
        root.getChildren().add(logo);
        
        /*******************************/
        /** TEXT FIELD LBL AND FIELD. **/
        /*******************************/
        fileFLbl = new Text(50, 150, "Directory: ");
        Font fnt = Font.font("Dialog", 15);
        fileFLbl.setFont(fnt);
        fileFLbl.setFill(Color.BLUEVIOLET);
        root.getChildren().add(fileFLbl);
        try {
            File temp = File.createTempFile("welcome", ".puppy");
            path = temp.getAbsolutePath();
            filePath = path.substring(0, path.lastIndexOf(File.separator));
        } catch (IOException ex) {
            Logger.getLogger(FileBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fileField = new TextField();
        fileField.setLayoutX(120);
        fileField.setLayoutY(135);
        fileField.setMinWidth(400);
        fileField.selectHome();
        fileField.setText(filePath);
        fileField.setPromptText("/usr/local/bin");
        root.getChildren().add(fileField);
    }
    
    /**
     * 
     * @param primaryStage
     * @return 
     */
    public static FileBrowser make() {
        return new FileBrowser();
    }

}/** end class. */
