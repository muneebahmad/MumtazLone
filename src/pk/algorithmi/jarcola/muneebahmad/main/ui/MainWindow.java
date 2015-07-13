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

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import pk.algorithmi.jarcola.muneebahmad.main.MumtazLone;

/**
 *
 * @author muneebahmad
 */
public class MainWindow implements EventHandler<Event> {
    
    public static final String  TITLE =              "ALGORITHMI R2 Snooker Engine";
    
    public static final double  WIDTH =              0x500;
    public static final double  HEIGHT =             0x2d0;
    
    private Stage               primaryStage;
    private Stage               loginStage;
    private Stage               fileStage;
    private BorderPane          root;
    private BorderPane          topPane;
    
    private final MenuBar       menuBar =           new MenuBar();
    
    private Menu                appMenu;
    private MenuItem            aboutMenuItem;
    private MenuItem            prefsMenuItem;
    private Menu                servicesMenu;
    private MenuItem            externalMenuItem;
    private MenuItem            signOutMenuItem;
    private MenuItem            quitMenuItem;
    
    private Menu                fileMenu;
    private MenuItem            newMenuItem;
    private MenuItem            openMenuItem;
    private MenuItem            closeMenuItem;
    private MenuItem            saveMenuItem;
    
    private Menu                editMenu;
    private MenuItem            undoMenuItem;
    private MenuItem            redoMenuItem;
    private MenuItem            copyMenuItem;
    private MenuItem            cutMenuItem;
    private MenuItem            pasteMenuItem;
    
    private Menu                viewMenu;
    private MenuItem            balanceMenuItem;
    private MenuItem            logMenuItem;
    private MenuItem            licenseMenuItem;
    
    private Menu                gameMenu;
    private MenuItem            playerMenuItem;
    private MenuItem            defaulterMenuItem;
    private MenuItem            clearedMenuItem;
    
    private Menu                pricingMenu;
    private MenuItem            gamePricingMenuItem;
    private MenuItem            cafePricingMenuItem;
    private MenuItem            staffWagesMenuItem;
    private MenuItem            auditMenuItem;
    
    private Menu                appsMenu;
    private MenuItem            stopWatchMenuItem;
    private MenuItem            calculatorMenuItem;
    private MenuItem            jPlayerMenuItem;
    private MenuItem            jWebMenuItem;
    private Menu                gamesMenu;
    private MenuItem            mumtazGhostGameMenuItem;
    private MenuItem            algoBunnyMenuItem;
    private MenuItem            cubocyMenuItem;
    
    private Menu                helpMenu;
    private MenuItem            helpMenuItem;
    
    private final ImageView     undoIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_back.png")));;
    private final ImageView     redoIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_back2.png")));; 
    private final ImageView     newIc =                     new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_add.png")));
    private final ImageView     openIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_folder.png")));
    private final ImageView     closeIc =                   new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_delete.png")));
    private final ImageView     aboutIc =                   new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_info.png")));
    private final ImageView     prefIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic24_cog.png")));
    private final ImageView     servIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_run.png")));
    private final ImageView     cancelIc =                  new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_cancel.png")));
    private final ImageView     okIc =                      new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_ok.png")));
    private final ImageView     helpIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/ic_manual.png")));
    private final ImageView     saveIc =                    new ImageView(new Image(MainWindow.class.getResourceAsStream("gfx/save_ic.png")));
    
    private final FileChooser fileChooser = new FileChooser();
    
    private static int totalAmount = 0;

    /**
     * Default Constructor.
     */
    public MainWindow() {}
    
    /**
     * 
     * @param primaryStage 
     */
    public MainWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new BorderPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
        makeMenuBar();
        //-------------------------
        this.primaryStage.setTitle(TITLE);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(true);
        this.primaryStage.show();
        //---------------------------
        CafePricingPersistence.loadCafeItems();
        GamePricingPersistence.loadGamePrices();
        StaffWagesPersistence.loadStaff();
        TablePersistence.loadTable();
        GenericPersistence.loadGamePrices("defaulters.dat");
    }
    
    private void makeMenuBar() {
        makeAppMenu();
        makeFileMenu();
        makeEditMenu();
        makeViewMenu();
        makeGameMenu();
        makePricingMenu();
        makeAppsMenu();
        makeHelpMenu();
        //------------------
        topPane = new BorderPane();
        topPane.setTop(menuBar);
        topPane.setCenter(new TopIcnsPane(primaryStage));
        //------------------
        root.setTop(topPane);
        root.setCenter(new CenterPane(primaryStage));
        //--------------------
    }
    
    public void disposeWindow() {
        this.primaryStage.close();
    }

    @Override
    public void handle(Event event) {
        if (event.getTarget() == this.aboutMenuItem) {
            AboutDialog abt = new AboutDialog();
        } else if (event.getTarget() == this.prefsMenuItem) {
            
        } else if (event.getTarget() == this.externalMenuItem) {
            
        } else if (event.getTarget() == this.signOutMenuItem) {
            this.loginStage = new Stage();
            makeLoginStage(loginStage);
        } else if (event.getTarget() == this.quitMenuItem) {
            CafePricingPersistence.saveCafeItems();
            GamePricingPersistence.saveGamePrices();
            StaffWagesPersistence.saveStaff();
            TablePersistence.saveTable();
            GenericPersistence.saveGamePrices("defaulters.dat");
            System.exit(0);
        } else if (event.getTarget() == this.newMenuItem) {
            NewDialog.make("Create a new Table");
        } else if (event.getTarget() == this.openMenuItem) {
            //FileBrowser.make();
            makeFileChooser();
        } else if (event.getTarget() == this.closeMenuItem) {
            Table.removeAllChilds();
        } else if (event.getTarget() == this.saveMenuItem) {
            CafePricingPersistence.saveCafeItems();
            GamePricingPersistence.saveGamePrices();
            StaffWagesPersistence.saveStaff();
            TablePersistence.saveTable();
            GenericPersistence.saveGamePrices("defaulters.dat");
        } else if (event.getTarget() == this.undoMenuItem) {
            
        } else if (event.getTarget() == this.redoMenuItem) {
            
        } else if (event.getTarget() == this.copyMenuItem) {
            
        } else if (event.getTarget() == this.cutMenuItem) {
            
        } else if (event.getTarget() == this.pasteMenuItem) {
            
        } else if (event.getTarget() == this.balanceMenuItem) {
            RevenueDialog.make();
        } else if (event.getTarget() == this.logMenuItem) {
            JLog.make();
        } else if (event.getTarget() == this.licenseMenuItem) {
            
        } else if (event.getTarget() == this.playerMenuItem) {
            
        } else if (event.getTarget() == this.defaulterMenuItem) {
            DefaulterDialog.make();
        } else if (event.getTarget() == this.clearedMenuItem) {
            
        } else if (event.getTarget() == this.gamePricingMenuItem) {
            GamePricingDialog.makeGamePricingDialog();
        } else if (event.getTarget() == this.cafePricingMenuItem) {
            CafePricingDialog.make();
        } else if (event.getTarget() == this.staffWagesMenuItem) {
            StaffWagesDialog.make();
        } else if (event.getTarget() == this.auditMenuItem) {
            AuditorWindow.make();
        } else if (event.getTarget() == this.stopWatchMenuItem) {
            
        } else if (event.getTarget() == this.calculatorMenuItem) {
            Calculator.make();
        } else if (event.getTarget() == this.jPlayerMenuItem) {
            
        } else if (event.getTarget() == this.jWebMenuItem) {
            
        }
    }

    private void makeAppMenu() {
        //APP MENU
        this.appMenu = new Menu("Snooker Engine");
        this.aboutMenuItem = new MenuItem("About Snooker Engine", aboutIc);
        this.aboutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.META_DOWN));
        this.aboutMenuItem.addEventHandler(EventType.ROOT, this);
        
        this.appMenu.getItems().add(aboutMenuItem);
        
        this.prefsMenuItem = new MenuItem("Preferences... ", prefIc);
        this.prefsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.META_DOWN));
        this.prefsMenuItem.addEventHandler(EventType.ROOT, this);
        this.appMenu.getItems().add(prefsMenuItem);
        
        this.servicesMenu = new Menu("Services", servIc);
        this.externalMenuItem = new MenuItem("External Services");
        this.externalMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.SHIFT_DOWN));
        this.externalMenuItem.addEventHandler(EventType.ROOT, this);
        this.servicesMenu.getItems().add(externalMenuItem);
        this.appMenu.getItems().add(servicesMenu);
        
        this.signOutMenuItem = new MenuItem("Log out", okIc);
        this.signOutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN));
        this.signOutMenuItem.addEventHandler(EventType.ROOT, this);
        this.appMenu.getItems().add(signOutMenuItem);
        
        this.quitMenuItem = new MenuItem("Quit Snooker Engine", cancelIc);
        this.quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.META_DOWN));
        this.quitMenuItem.addEventHandler(EventType.ROOT, this);
        this.appMenu.getItems().add(quitMenuItem);
        
        //-------------------------------------------
        this.menuBar.getMenus().add(appMenu);
    }
    
    private void makeFileMenu() {
        //FILE MENU
        this.fileMenu = new Menu("File");
        //MENU ITEMS
        this.newMenuItem = new MenuItem("New", newIc);
        this.newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHIFT_DOWN, KeyCombination.META_DOWN));
        this.newMenuItem.addEventHandler(EventType.ROOT, this);
        this.fileMenu.getItems().add(newMenuItem);
        
        this.openMenuItem = new MenuItem("Open", openIc);
        this.openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHIFT_DOWN, KeyCombination.META_DOWN));
        this.openMenuItem.addEventHandler(EventType.ROOT, this);
        this.fileMenu.getItems().add(openMenuItem);
        
        this.closeMenuItem = new MenuItem("Close", closeIc);
        this.closeMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.SHIFT_DOWN, KeyCombination.META_DOWN));
        this.closeMenuItem.addEventHandler(EventType.ROOT, this);
        this.fileMenu.getItems().add(closeMenuItem);
        
        this.saveMenuItem = new MenuItem("Save All", saveIc);
        this.saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.META_DOWN));
        this.saveMenuItem.addEventHandler(EventType.ROOT, this);
        this.fileMenu.getItems().add(saveMenuItem);
        
        //-----------------------------------------
        this.menuBar.getMenus().add(fileMenu);
    }
    
    private void makeEditMenu() {
        //EDIT MENU
        this.editMenu = new Menu("Edit");
        //MENU ITEMS
        this.undoMenuItem = new MenuItem("Undo", undoIc);
        this.undoMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.META_DOWN));
        this.undoMenuItem.addEventHandler(EventType.ROOT, this);
        this.editMenu.getItems().add(undoMenuItem);
        
        this.redoMenuItem = new MenuItem("Redo", redoIc);
        this.redoMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Y, KeyCombination.META_DOWN));
        this.redoMenuItem.addEventHandler(EventType.ROOT, this);
        this.editMenu.getItems().add(redoMenuItem);
        
        this.copyMenuItem = new MenuItem("Copy");
        this.copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.META_DOWN));
        this.copyMenuItem.addEventHandler(EventType.ROOT, this);
        this.copyMenuItem.setDisable(true);
        this.editMenu.getItems().add(new SeparatorMenuItem());
        this.editMenu.getItems().add(copyMenuItem);
        
        this.cutMenuItem = new MenuItem("Cut");
        this.cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.META_DOWN));
        this.cutMenuItem.addEventHandler(EventType.ROOT, this);
        this.cutMenuItem.setDisable(true);
        this.editMenu.getItems().add(cutMenuItem);
        
        this.pasteMenuItem = new MenuItem("Paste");
        this.pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.META_DOWN));
        this.pasteMenuItem.addEventHandler(EventType.ROOT, this);
        this.pasteMenuItem.setDisable(true);
        this.editMenu.getItems().add(pasteMenuItem);
        
        //--------------------------------------------
        this.menuBar.getMenus().add(editMenu);
    }
    
    private void makeViewMenu() {
        //VIEW MENU
        this.viewMenu = new Menu("View");
        //MENU ITEMS
        this.balanceMenuItem = new MenuItem("Revenue Detalis");
        this.balanceMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHIFT_DOWN, KeyCombination.META_DOWN));
        this.balanceMenuItem.addEventHandler(EventType.ROOT, this);
        this.viewMenu.getItems().add(balanceMenuItem);
        
        this.logMenuItem = new MenuItem("Log");
        this.logMenuItem.addEventHandler(EventType.ROOT, this);
        this.viewMenu.getItems().add(logMenuItem);
        
        this.licenseMenuItem = new MenuItem("Licenses");
        this.licenseMenuItem.addEventHandler(EventType.ROOT, this);
        this.viewMenu.getItems().add(licenseMenuItem);
        
        //------------------------------------------
        this.menuBar.getMenus().add(viewMenu);
    }
    
    private void makeGameMenu() {
        //GAME MENU
        this.gameMenu = new Menu("Players");
        //MENU ITEMS
        this.playerMenuItem = new MenuItem("Players");
        this.playerMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHIFT_DOWN));
        this.playerMenuItem.addEventHandler(EventType.ROOT, this);
        this.playerMenuItem.setDisable(true);
        this.gameMenu.getItems().add(playerMenuItem);
        
        this.defaulterMenuItem = new MenuItem("Defaulters");
        this.defaulterMenuItem.addEventHandler(EventType.ROOT, this);
        this.gameMenu.getItems().add(defaulterMenuItem);
        
        this.clearedMenuItem = new MenuItem("Cleared");
        this.clearedMenuItem.addEventHandler(EventType.ROOT, this);
        this.clearedMenuItem.setDisable(true);
        this.gameMenu.getItems().add(clearedMenuItem);
        
        //-----------------------------------------------------
        this.menuBar.getMenus().add(gameMenu);
    }
    
    private void makePricingMenu() {
        //PRICING MENU
        this.pricingMenu = new Menu("Business");
        //MENU ITEMS
        this.gamePricingMenuItem = new MenuItem("Game Pricing");
        this.gamePricingMenuItem.addEventHandler(EventType.ROOT, this);
        this.pricingMenu.getItems().add(gamePricingMenuItem);
        
        this.cafePricingMenuItem = new MenuItem("Cafe Pricing");
        this.cafePricingMenuItem.addEventHandler(EventType.ROOT, this);
        this.pricingMenu.getItems().add(cafePricingMenuItem);
        
        this.staffWagesMenuItem = new MenuItem("Staff Wages");
        this.staffWagesMenuItem.addEventHandler(EventType.ROOT, this);
        this.pricingMenu.getItems().add(staffWagesMenuItem);
        
        this.auditMenuItem = new MenuItem("Audit");
        this.auditMenuItem.addEventHandler(EventType.ROOT, this);
        this.pricingMenu.getItems().add(new SeparatorMenuItem());
        this.pricingMenu.getItems().add(auditMenuItem);
        
        //------------------------------------------------
        this.menuBar.getMenus().add(pricingMenu);
    }
    
    private void makeAppsMenu() {
        //APPS MENU
        this.appsMenu = new Menu("Applications");
        //MENU ITEMS
        this.stopWatchMenuItem = new MenuItem("Stopwatch");
        this.stopWatchMenuItem.addEventHandler(EventType.ROOT, this);
        this.appsMenu.getItems().add(stopWatchMenuItem);
        
        this.calculatorMenuItem = new MenuItem("Calculator");
        this.calculatorMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN));
        this.calculatorMenuItem.addEventHandler(EventType.ROOT, this);
        this.appsMenu.getItems().add(calculatorMenuItem);
        
        this.jPlayerMenuItem = new MenuItem("jPlayer");
        this.jPlayerMenuItem.addEventHandler(EventType.ROOT, this);
        this.appsMenu.getItems().add(jPlayerMenuItem);
        
        this.jWebMenuItem = new MenuItem("jarcola Embedded Browser");
        this.jWebMenuItem.addEventHandler(EventType.ROOT, this);
        this.jWebMenuItem.setDisable(true);
        this.appsMenu.getItems().add(jWebMenuItem);
        
        this.gamesMenu = new Menu("Games");
        this.mumtazGhostGameMenuItem = new MenuItem("Mumtaz Ghost Game");
        this.mumtazGhostGameMenuItem.addEventHandler(EventType.ROOT, this);
        this.mumtazGhostGameMenuItem.setDisable(true);
        this.gamesMenu.getItems().add(mumtazGhostGameMenuItem);
        
        this.algoBunnyMenuItem = new MenuItem("Algo Bunny Game");
        this.algoBunnyMenuItem.addEventHandler(EventType.ROOT, this);
        this.algoBunnyMenuItem.setDisable(true);
        this.gamesMenu.getItems().add(algoBunnyMenuItem);
        
        this.cubocyMenuItem = new MenuItem("Cubocy Game");
        this.cubocyMenuItem.addEventHandler(EventType.ROOT, this);
        this.cubocyMenuItem.setDisable(true);
        this.gamesMenu.getItems().add(cubocyMenuItem);
        
        this.appsMenu.getItems().add(gamesMenu);
        
        //----------------------------------------------------
        this.menuBar.getMenus().add(appsMenu);
    }
    
    private void makeHelpMenu() {
        //HELP MENU
        this.helpMenu = new Menu("Help");
        //MENU ITEMS
        this.helpMenuItem = new MenuItem("Help", helpIc);
        this.helpMenuItem.addEventHandler(EventType.ROOT, this);
        this.helpMenu.getItems().add(helpMenuItem);
        
        //-------------------------------------------------
        this.menuBar.getMenus().add(helpMenu);
    }
    
    /**
     * 
     * @param loginStage 
     */
    private void makeLoginStage(Stage loginStage) {
        MumtazLone mL = new MumtazLone();
        mL.start(loginStage);
        primaryStage.close();
    }
    
    private void makeFileChooser() {
        this.fileStage = new Stage();
        fileChooser.setTitle("Algorithmi Open '.docset' files only");
        File file = fileChooser.showOpenDialog(fileStage);
        if (file != null) {
            try {
                if (Desktop.isDesktopSupported()) {
                    System.out.println("DESKTOP SUPPORTED");
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file);
                }
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * 
     * @param amount 
     */
    public static void setTotalAmount(int amount) {
        totalAmount += amount;
    }
    
    public static int getTotalAmount() {
        return totalAmount;
    }
    
}/** end class. */
