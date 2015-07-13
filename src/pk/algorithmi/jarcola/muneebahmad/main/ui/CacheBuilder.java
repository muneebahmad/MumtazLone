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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muneebahmad
 */
public class CacheBuilder {

    static FileWriter fw;
    static PrintWriter pw;
    static FileReader fr;
    static BufferedReader br;
    static String read = null;
    
    static String tokens[] = null;
    static String key = null;
    static String val = null;
    
    public CacheBuilder() {}
    
    /**
     * 
     * @param fileName 
     */
    public static void writeBuffers(String fileName) {
        
    }
    
    /**
     * 
     * @param fileName
     * @return 
     */
    public static void readBuffers(String fileName) {
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            read = br.readLine();
            
            while (read != null) {
                tokens = read.split(",");
                
                key = tokens[0];
                val = tokens[1];
                
                //MIME TYPE PERSON INFO TYPE
                //TODO
                //---------------------------
                read = br.readLine();
            }
            
            br.close();
            fr.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CacheBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CacheBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}/** end class. */
