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
import java.io.File;
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
public class BufferedPwdWriterReader {

    static FileWriter fw;
    static PrintWriter pw;
    static FileReader fr;
    static BufferedReader br;
    static String read = null;
    
    public BufferedPwdWriterReader() {}
    
    /**
     * 
     * @param pwd 
     */
    public static void writePwd(String pwd) {
        try {
            fw = new FileWriter("pfj.puppy");
            pw = new PrintWriter(fw);
            pw.println(pwd);
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("\nEXCEPTION WRITING BUFFERS --- " + e);
        }
    }
    
    /**
     * 
     */
    public static String readPwd() {
        try {
            fr = new FileReader("pfj.puppy");
            br = new BufferedReader(fr);
            read = br.readLine();
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BufferedPwdWriterReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BufferedPwdWriterReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return read;
    }
    
    /**
     * 
     * @param pwd
     * @param newPwd 
     */
    public static void changePwd(String pwd, String newPwd) {
        if (pwd.equals(BufferedPwdWriterReader.readPwd())) {
            File file = new File("pfj.puppy");
            file.delete();
            try {
                fw = new FileWriter("pfj.puppy");
                pw = new PrintWriter(fw);
                pw.println(newPwd);
                pw.flush();
                pw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(BufferedPwdWriterReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}/** end class. */
