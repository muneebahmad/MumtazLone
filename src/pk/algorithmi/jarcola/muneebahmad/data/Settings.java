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

package pk.algorithmi.jarcola.muneebahmad.data;

/**
 *
 * @author muneebahmad
 */
public class Settings {

    public static Settings sInstance = null;
    
    private String pass;
    
    public Settings() {
        this.pass = "nigran786";
    }

    public String getPass() {
        return pass;
    }
    
    /**
     * 
     * @return New Instance of {@link pk.algorithmi.jarcola.muneebahmad.data.Settings}
     */
    public static Settings getInstance() {
        synchronized(Settings.class) {
            if (sInstance == null) {
                return new Settings();
            }
        }
        return sInstance;
    }
    
}/** end class. */
