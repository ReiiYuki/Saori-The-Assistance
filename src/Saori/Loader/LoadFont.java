package Saori.Loader;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URL;

/**
 * LoadFont is use for Import Font.
 * @author Voraton Lertrattanapaisal
 *
 */
public class LoadFont {
	public static Font WAFFLEREGULAR;
	/**
	 * Loading Font and setup and return font.
	 * @return new font.
	 */
	public static Font loadFont(){
		URL fontUrl = ClassLoader.getSystemResource("Resource/Font/WaffleRegular.otf");
        try {
        	WAFFLEREGULAR = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(WAFFLEREGULAR);
        return WAFFLEREGULAR;
	}
}
