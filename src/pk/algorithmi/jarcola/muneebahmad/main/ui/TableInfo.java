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
public class TableInfo {

    public String tableName;
    public String tableNo;
    public String player;
    public String cafe;
    public String debit;
    public String credit;
    public String total;
    
    public TableInfo() {}
    
    /**
     * 
     * @param tableName
     * @param tableNo 
     * @param player 
     * @param cafe 
     * @param debit 
     * @param credit 
     * @param total 
     */
    public TableInfo(String tableName, String tableNo, String player, String cafe, 
            String debit, String credit, String total) {
        this.tableName = tableName;
        this.tableNo = tableNo;
        this.player = player;
        this.cafe = cafe;
        this.debit = debit;
        this.credit = credit;
        this.total = total;
    }
    
    /**
     * 
     * @return 
     */
    public String getTableName() {
        return this.tableName;
    }
    
    /**
     * 
     * @return 
     */
    public String getTableNo() {
        return this.tableNo;
    }
    
}/** end class. */
