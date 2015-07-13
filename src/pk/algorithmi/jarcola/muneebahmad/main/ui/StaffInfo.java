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
public class StaffInfo {
    
    public String staffName;
    public String staffWages;
    
    public StaffInfo() {}
    
    /**
     * 
     * @param staffName
     * @param staffWages 
     */
    public StaffInfo(String staffName, String staffWages) {
        this.staffName = staffName;
        this.staffWages = staffWages;
    }
    
    public String getStaffName() {
        return this.staffName;
    }
    
    public String getStaffWages() {
        return this.staffWages;
    }
    
}/** end class. */
