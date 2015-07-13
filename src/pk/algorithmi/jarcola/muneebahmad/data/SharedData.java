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

import java.util.HashMap;

/**
 *
 * @author muneebahmad
 */
public class SharedData {

    static SharedData sInstance = null;
    
    private int index = 0;
    private int totalAmount = 0;
    private int finalAmount;
    
    private final HashMap<String, String> indexMap = new HashMap<>();;
    
    public SharedData() {
    }
    
    /**
     * 
     * @param index 
     */
    public void setIndex(int index) {
        this.index += index;
    }
    
    /**
     * 
     * @return 
     */
    public int getIndex() {
        return this.index;
    }
    
    /**
     * 
     * @param key
     * @param index 
     */
    public void addTables(String key, String index) {
        indexMap.put(key, index);
    }
    
    /**
     * 
     * @param key 
     */
    public void removeTables(String key) {
        indexMap.remove(key);
    }
    
    /**
     * 
     * @return 
     */
    public HashMap getIndexes() {
        return this.indexMap;
    }
    
    /**
     * 
     * @param totalAmount 
     */
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        finalAmount += this.totalAmount;
    }
    
    /**
     * 
     * @return 
     */
    public int getTotalAmount() {
        return this.totalAmount;
    }
    
    /**
     * 
     * @return 
     */
    public static SharedData getInstance() {
        synchronized (SharedData.class) {
            if (sInstance == null)  return new SharedData();
        }
        return sInstance;
    }
    
}/** end class. */
