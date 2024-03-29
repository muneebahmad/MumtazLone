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

import java.util.Calendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author muneebahmad
 */
public class Clock extends Parent {

    private Calendar calendar = Calendar.getInstance();
    private Digit[] digits;
    private Timeline delayTimeline;
    private Timeline secondTimeline;

    public Clock(Color onColor, Color offColor) {
        //create effect for an LED
        Glow onEffect = new Glow(1.7f);
        onEffect.setInput(new InnerShadow());
        //create effect for dot LEDs
        Glow onDotEffect = new Glow(1.7f);
        onDotEffect.setInput(new InnerShadow(5, Color.BLACK));
        //create effect for off LEDs
        InnerShadow offEffect = new InnerShadow();
        //create digits
        digits = new Digit[7];
        for (int i = 0; i < 6; i++) {
            Digit digit = new Digit(onColor, offColor, onEffect, offEffect);
            digit.setLayoutX(i * 80 + ((i + 1) % 2) * 20);
            digits[i] = digit;
            getChildren().add(digit);
        }
        //creates dots
        Group dots = new Group(
                new Circle(80 + 54 + 20, 44, 6, onColor),
                new Circle(80 + 54 + 17, 64, 6, onColor),
                new Circle((80 * 3) + 54 + 20, 44, 6, onColor),
                new Circle((80 * 3) + 54 + 17, 64, 6, onColor));
        dots.setEffect(onDotEffect);
        getChildren().add(dots);
        //update digits to current time and start timer to update every second
        refreshClocks();
        play();
    }

    public void play() {
        //wait till start of next second then start a timeline
        //to call refreshClocks() every second.
        delayTimeline = new Timeline();
        delayTimeline.getKeyFrames().add(
                new KeyFrame(new Duration(1000 - (System.currentTimeMillis() % 1000)), 
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (secondTimeline != null) {
                    secondTimeline.stop();
                }
                secondTimeline = new Timeline();
                secondTimeline.setCycleCount(Timeline.INDEFINITE);
                secondTimeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        refreshClocks();
                    }
                }));
                secondTimeline.play();
            }
        }));
        delayTimeline.play();
    }

    private void refreshClocks() {
        calendar.setTimeInMillis(System.currentTimeMillis());
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        digits[0].showNumber(hours / 10);
        digits[1].showNumber(hours % 10);
        digits[2].showNumber(minutes / 10);
        digits[3].showNumber(minutes % 10);
        digits[4].showNumber(seconds / 10);
        digits[5].showNumber(seconds % 10);
    }

    public void stop() {
        delayTimeline.stop();
        if (secondTimeline != null) {
            secondTimeline.stop();
        }
    }
}/** end class. */
