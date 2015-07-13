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
public class GamePricingPersistence {

    public static ArrayList<GamePricingInfo> gameItems = new ArrayList<>();
    
    /**
     * DEFAULT.
     */
    public GamePricingPersistence() {}
    
    /**
     * 
     * @param gameName
     * @param gamePrice 
     */
    public static void addGamePrices(final String gameName, final String gamePrice) {
        GamePricingInfo g = new GamePricingInfo(gameName, gamePrice);
        gameItems.add(g);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public static String searchGamePrices(String name) {
        String n = "";
        String p = "";
        for (GamePricingInfo game : gameItems) {
            GamePricingInfo g = (GamePricingInfo) game;
            if (name.equals(g.gameName)) {
                n = g.gameName;
                p = g.gamePrice;
            }
        }
        return "Game:" + n + " - Price: " + p;
    }
    
    /**
     * 
     * @param name 
     */
    public static void deleteGamePrices(String name) {
        for (int i = 0; i < gameItems.size(); i++) {
            GamePricingInfo g = (GamePricingInfo) gameItems.get(i);
            if (name.equals(g.gameName)) {
                gameItems.remove(g);
            }
        }
    }
    
    public static void loadGamePrices() {
        String tokens[] = null;
        String gameName;
        String gamePrice;
        
        try {
            FileReader fr = new FileReader("game.dat");
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while (line != null) {
                tokens = line.split(",");
                gameName = tokens[0];
                gamePrice = tokens[1];
                
                GamePricingInfo g = new GamePricingInfo(gameName, gamePrice);
                gameItems.add(g);
                
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
    
    public static void saveGamePrices() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        GamePricingInfo g;
        String line;
        
        try {
            fw = new FileWriter("game.dat");
            pw = new PrintWriter(fw);
            
            for (GamePricingInfo game : gameItems) {
                g = game;
                line = g.gameName + "," + g.gamePrice;
                
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
