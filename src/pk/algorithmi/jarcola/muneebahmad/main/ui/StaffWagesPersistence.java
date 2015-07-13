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
public class StaffWagesPersistence {

    public static ArrayList<StaffInfo> wagesItems = new ArrayList<>();
    
    /**
     * DEFAULT.
     */
    public StaffWagesPersistence() {}
    
    /**
     * 
     * @param gameName
     * @param gamePrice 
     */
    public static void addStaff(final String gameName, final String gamePrice) {
        StaffInfo g = new StaffInfo(gameName, gamePrice);
        wagesItems.add(g);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public static String searchStaff(String name) {
        String n = "";
        String p = "";
        for (StaffInfo game : wagesItems) {
            StaffInfo g = (StaffInfo) game;
            if (name.equals(g.staffName)) {
                n = g.staffName;
                p = g.staffWages;
            }
        }
        return "Game:" + n + " - Price: " + p;
    }
    
    /**
     * 
     * @param name 
     */
    public static void deleteStaff(String name) {
        for (int i = 0; i < wagesItems.size(); i++) {
            StaffInfo g = (StaffInfo) wagesItems.get(i);
            if (name.equals(g.staffName)) {
                wagesItems.remove(g);
            }
        }
    }
    
    public static void loadStaff() {
        String tokens[] = null;
        String gameName;
        String gamePrice;
        
        try {
            FileReader fr = new FileReader("staff.dat");
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while (line != null) {
                tokens = line.split(",");
                gameName = tokens[0];
                gamePrice = tokens[1];
                
                StaffInfo g = new StaffInfo(gameName, gamePrice);
                wagesItems.add(g);
                
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
    
    public static void saveStaff() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        StaffInfo g;
        String line;
        
        try {
            fw = new FileWriter("staff.dat");
            pw = new PrintWriter(fw);
            
            for (StaffInfo game : wagesItems) {
                g = game;
                line = g.staffName + "," + g.staffWages;
                
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
