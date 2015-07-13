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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muneebahmad
 */
public class CafePricingPersistence {

    public static ArrayList<CafeItemsInfo> cafeItems = new ArrayList<>();
    
    /**
     * DEFAULT.
     */
    public CafePricingPersistence() {}
    
    /**
     * 
     * @param itemName
     * @param itemPrice 
     */
    public static void addCafeItems(final String itemName, final String itemPrice) {
        CafeItemsInfo c = new CafeItemsInfo(itemName, itemPrice);
        cafeItems.add(c);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public static String searchCafeItems(String name) {
        String n = "";
        String p = "";
        for (CafeItemsInfo cafe : cafeItems) {
            CafeItemsInfo c = (CafeItemsInfo) cafe;
            if (name.equals(c.itemName)) {
                n = c.itemName;
                p = c.itemPrice;
            }
        }
        return "Item:" + n + " - Price: " + p;
    }
    
    /**
     * 
     * @param name 
     */
    public static void deleteCafeItems(String name) {
        for (int i = 0; i < cafeItems.size(); i++) {
            CafeItemsInfo c = (CafeItemsInfo) cafeItems.get(i);
            if (name.equals(c.itemName)) {
                cafeItems.remove(c);
            }
        }
    }
    
    public static void loadCafeItems() {
        String tokens[] = null;
        String itemName;
        String itemPrice;
        
        try {
            FileReader fr = new FileReader("cafe.dat");
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while (line != null) {
                tokens = line.split(",");
                itemName = tokens[0];
                itemPrice = tokens[1];
                
                CafeItemsInfo c = new CafeItemsInfo(itemName, itemPrice);
                cafeItems.add(c);
                
                line = br.readLine();
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CafePricingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CafePricingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveCafeItems() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        CafeItemsInfo c;
        String line;
        
        try {
            fw = new FileWriter("cafe.dat");
            pw = new PrintWriter(fw);
            
            for (CafeItemsInfo cafe : cafeItems) {
                c = cafe;
                line = c.itemName + "," + c.itemPrice;
                
                pw.println(line);
            }
            fw.flush();
            fw.close();
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(CafePricingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}/** end class. */
