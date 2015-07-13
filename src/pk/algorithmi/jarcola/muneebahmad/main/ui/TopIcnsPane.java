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
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author muneebahmad
 */
public class TopIcnsPane extends BorderPane {

    private final ImageView     clockBg =           new ImageView(new Image(TopIcnsPane.class.getResourceAsStream("gfx/clock_bg.png")));
    private final ImageView     logo =              new ImageView(new Image(TopIcnsPane.class.getResourceAsStream("gfx/algo_logo3.png")));
    private final ImageView     snk =               new ImageView(new Image(TopIcnsPane.class.getResourceAsStream("gfx/snooker.jpg")));

    private Clock               clock;
    
    /**
     * Default Constructor.
     */
    public TopIcnsPane() {}
    
    /**
     * 
     * @param primaryStage 
     */
    public TopIcnsPane(Stage primaryStage) {
        clock = new Clock(Color.AQUA, Color.rgb(50, 50, 50));
        clock.setLayoutX(8);
        clock.setLayoutY(21);
        clock.getTransforms().add(new Scale(0.2f, 0.2f, 0, 0));
        
        clockBg.getTransforms().add(new Scale(0.25f, 0.25f, 0.0f, 0.0f));
        
        Reflection ref = new Reflection();
        ref.setFraction(0.4f);
        ref.setTopOffset(2);
      
        clock.setEffect(ref);
        
        Group grp = new Group();
        grp.getChildren().addAll(clockBg, clock);
        
        this.setRight(grp);
        this.setCenter(snk);
        this.setLeft(logo);
    }
    
}/** end class. */
