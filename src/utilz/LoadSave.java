package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.GamePanel;

public class LoadSave {
    
    public static final String NUMBERS_IMG = "Image/numbers_img.png";
    public static final String BACKGROUND_IMG = "Image/background_img.png";
    public static final String MENU_BUTTON_IMG = "Image/menu_buttons_img.png";
    
    public static BufferedImage getSpriteAtlas(String path) {
        InputStream is = LoadSave.class.getResourceAsStream("/" + path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(is);
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }
}
