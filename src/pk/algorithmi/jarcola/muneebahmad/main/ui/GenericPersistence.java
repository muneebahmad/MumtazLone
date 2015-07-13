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
public class GenericPersistence {
    
    public static ArrayList<GenericInfo> genericItems = new ArrayList<>();
    
    /**
     * DEFAULT.
     */
    public GenericPersistence() {}
    
    /**
     * 
     * @param date
     * @param name
     * @param number 
     */
    public static void addGamePrices(final String date, final String name, final String number) {
        GenericInfo g = new GenericInfo(date, name, number);
        genericItems.add(g);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public static String searchGamePrices(String name) {
        String d = "";
        String n = "";
        String p = "";
        for (GenericInfo game : genericItems) {
            GenericInfo g = (GenericInfo) game;
            if (name.equals(g.name)) {
                d = g.date;
                n = g.name;
                p = g.number;
            }
        }
        return "Game:" + n + " - Price: " + p;
    }
    
    /**
     * 
     * @param name 
     */
    public static void deleteGamePrices(String name) {
        for (int i = 0; i < genericItems.size(); i++) {
            GenericInfo g = (GenericInfo) genericItems.get(i);
            if (name.equals(g.date)) {
                genericItems.remove(g);
            }
        }
    }
    
    public static void loadGamePrices(String fileName) {
        String tokens[] = null;
        String date;
        String name;
        String number;
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while (line != null) {
                tokens = line.split(",");
                date = tokens[0];
                name = tokens[1];
                number = tokens[2];
                
                GenericInfo g = new GenericInfo(date, name, number);
                genericItems.add(g);
                
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
    
    public static void saveGamePrices(String fileName) {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        GenericInfo g;
        String line;
        
        try {
            fw = new FileWriter(fileName);
            pw = new PrintWriter(fw);
            
            for (GenericInfo game : genericItems) {
                g = game;
                line = g.date + "," + g.name + "," + g.number;
                
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
