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
public class TablePersistence {

    public static ArrayList<TableInfo> tableItems = new ArrayList<>();
    
    /**
     * DEFAULT.
     */
    public TablePersistence() {}
    
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
    public static void addTable(final String tableName, final String tableNo, final String player, final String cafe,
            final String debit, final String credit, final String total) {
        TableInfo g = new TableInfo(tableName, tableNo, player, cafe, debit, credit, total);
        tableItems.add(g);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public static String searchTable(String name) {
        String n = "";
        String p = "";
        for (TableInfo game : tableItems) {
            TableInfo g = (TableInfo) game;
            if (name.equals(g.tableName)) {
                n = g.tableName;
                p = g.tableNo;
            }
        }
        return "Game:" + n + " - Price: " + p;
    }
    
    /**
     * 
     * @param name 
     */
    public static void deleteTable(String name) {
        for (int i = 0; i < tableItems.size(); i++) {
            TableInfo g = (TableInfo) tableItems.get(i);
            if (name.equals(g.tableName)) {
                tableItems.remove(g);
            }
        }
    }
    
    public static void loadTable() {
        String tokens[] = null;
        String tableName;
        String tablePrice;
        String player;
        String cafe;
        String debit;
        String credit;
        String total;
        
        try {
            FileReader fr = new FileReader("auditor.dat");
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while (line != null) {
                tokens = line.split(",");
                tableName = tokens[0];
                tablePrice = tokens[1];
                player = tokens[2];
                cafe = tokens[3];
                debit = tokens[4];
                credit = tokens[5];
                total = tokens[6];
                
                TableInfo g = new TableInfo(tableName, tablePrice, player, cafe, debit, credit, total);
                tableItems.add(g);
                
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
    
    public static void saveTable() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        TableInfo g;
        String line;
        
        try {
            fw = new FileWriter("auditor.dat");
            pw = new PrintWriter(fw);
            
            for (TableInfo game : tableItems) {
                g = game;
                line = g.tableName + "," + g.tableNo + "," + g.player + "," + g.cafe + "," + 
                        g.debit + "," + g.credit + "," + g.total;
                
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
