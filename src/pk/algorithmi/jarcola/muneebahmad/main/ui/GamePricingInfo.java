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

/**
 *
 * @author muneebahmad
 */
public class GamePricingInfo {

    public String gameName;
    public String gamePrice;
    
    public GamePricingInfo() {}
    
    /**
     * 
     * @param gameName
     * @param gamePrice 
     */
    public GamePricingInfo(String gameName, String gamePrice) {
       this.gameName = gameName;
       this.gamePrice = gamePrice;
    }
    
    /**
     * 
     * @return 
     */
    public String getGameName() {
        return this.gameName;
    }
    
    /**
     * 
     * @return 
     */
    public String getGamePrice() {
        return this.gamePrice;
    }
    
}/** end class. */
