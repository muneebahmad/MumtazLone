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

import javafx.scene.Parent;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Shear;

/**
 *
 * @author muneebahmad
 */
public final class Digit extends Parent {

    private static final boolean[][] DIGIT_COMBINATION = new boolean[][] {
        new boolean[] {true, false, true, true, true, true, true},
        new boolean[] {false, false, false, false, true, false, true},
        new boolean[] {true, true, true, false, true, true, false},
        new boolean[] {true, true, true, false, true, false, true},
        new boolean[] {false, true, false, true, true, false, true},
        new boolean[] {true, true, true, true, false, false, true},
        new boolean[] {true, true, true, true, false, true, true},
        new boolean[] {true, false, false, false, true, false, true},
        new boolean[] {true, true, true, true, true, true, true},
        new boolean[] {true, true, true, true, true, false, true}
    };
    private final Polygon[] polygons = new Polygon[] {
      new Polygon(2, 0, 52, 0, 42, 10, 12, 10),
      new Polygon(12, 49, 42, 49, 52, 54, 42, 59, 12f, 59f, 2f, 54f),
      new Polygon(12, 98, 42, 98, 52, 108, 12, 108),
      new Polygon(0, 2, 10, 12, 10, 47, 0, 52),
      new Polygon(44, 12, 54, 2, 54, 52, 44, 47),
      new Polygon(0, 56, 10, 61, 10, 96, 0, 106),
      new Polygon(44, 61, 54, 56, 54, 106, 44, 96),
    };
    private final Color onColor;
    private final Color offColor;
    private final Effect onEffect;
    private final Effect offEffect;
    
    public Digit(Color onColor, Color offColor, Effect onEffect, Effect offEffect) {
        this.onColor = onColor;
        this.offColor = offColor;
        this.onEffect = onEffect;
        this.offEffect = offEffect;
        getChildren().addAll(polygons);
        getTransforms().add(new Shear(-0.1, 0));
        showNumber(0);
    }

    public void showNumber(Integer i) {
        if (i < 0 || i > 9) i = 0;
        for (int j = 0; j < 7; j++) {
            polygons[j].setFill(DIGIT_COMBINATION[i][j] ? onColor : offColor);
            polygons[j].setEffect(DIGIT_COMBINATION[i][j] ? onEffect : offEffect);
        }
    }
    
}/** end class. */
