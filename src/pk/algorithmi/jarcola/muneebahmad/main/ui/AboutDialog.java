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
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author muneebahmad
 */
public class AboutDialog {

    private final ImageView logo = new ImageView(new Image(AboutDialog.class.getResourceAsStream("gfx/algo_logo3.png")));
    private final ImageView bgView = new ImageView(new Image(AboutDialog.class.getResourceAsStream("gfx/abt_dialog_bg.png")));
    private final ImageView java = new ImageView(new Image(AboutDialog.class.getResourceAsStream("gfx/java_powered.png")));
    private final Stage mStage;
    private final Group root;
    private final Scene mScene;
    
    public AboutDialog() {
        mStage = new Stage(StageStyle.UNDECORATED);
        root = new Group();
        mScene = new Scene(root, 500, 660, Color.BLACK);
        
        root.getChildren().add(bgView);
        //------------------------------------------
        makeAboutDialog(root);
        
        //--------------------------------------------
        mStage.setTitle("About Algorithmi Snooker Engine");
        mStage.setScene(mScene);
        mStage.setResizable(false);
        mStage.show();
    }

    /**
     * 
     * @param root 
     */
    private void makeAboutDialog(Group root) {
        logo.setLayoutX(150);
        logo.setLayoutY(20);
        Reflection mReflection = new Reflection();
        mReflection.setFraction(0.9f);
        mReflection.setTopOffset(-25);
        logo.setEffect(mReflection);
        root.getChildren().add(logo);
        renderContents(root);
    }

    /**
     * 
     * @param root 
     */
    private void renderContents(Group root) {
        Text abt = new Text(50, 150, "Algorithmi Snooker Engine is a cross platform Enterprise Application "
                + "which provides you persistence and data warehousing in an extremely efficient "
                + "and reliable environment, which lets your snooker business run smoothly using"
                + " this core technology. Very soon this application will be published on Apple App Store for "
                + " Mac OS X (Mavericks/Yosemite) and"
                + " Canonical for Ubuntu Linux Software Center, However for Windows the universal build "
                + "will be distributed"
                + " by the vendor itself.\n"
                + "\nThis Software is copyright protected, any after market distribution or piracy may"
                + " cause you legal demage. Please read the privacy policy before using this software.");
        Font font = Font.font("Dialog", 18);
        abt.setFont(font);
        abt.setWrappingWidth(400);
        abt.setFill(Color.YELLOW);
        root.getChildren().add(abt);
        
        Text name = new Text(300, 550, "Regards\nMuneeb Ahmad");
        name.setFont(font);
        name.setFill(Color.YELLOW);
        root.getChildren().add(name);
        
        Button butt = new Button("Agree");
        butt.setLayoutX(420);
        butt.setLayoutY(620);
        butt.setDefaultButton(true);
        root.getChildren().add(butt);
        butt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                mStage.close();
            }
        });
        
        java.setLayoutX(50);
        java.setLayoutY(500);
        java.setEffect(new Reflection());
        //java.getTransforms().add(new Scale(0.7, 0.7));
        root.getChildren().add(java);
    }
    
}/** end class. */
