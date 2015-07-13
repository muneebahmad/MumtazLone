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
public class DefaulterInfo {

    public String date;
    public String defaulterName;
    public String defaulterAmnt;
    
    public DefaulterInfo() {}
    
    /**
     * 
     * @param date
     * @param defaulterName
     * @param defaulterAmnt 
     */
    public DefaulterInfo(String date, String defaulterName, String defaulterAmnt) {
        this.date = date;
        this.defaulterName = defaulterName;
        this.defaulterAmnt = defaulterAmnt;
    }
    
}/** end class. */
