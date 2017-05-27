package greco.lorenzo.com.lgsnackbar.style;

/**
 * Created by LoreGr on 20/05/2017.
 */
public class LGSnackBarStyle {

    private static final String TAG = "LGSnackBarStyle";

    public int backgroundColor;
    public int textColor;
    public int actionTextColor;
    public int iconID;

    public LGSnackBarStyle(int backgroundColor, int textColor, int actionTextColor, int iconID) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.actionTextColor = actionTextColor;
        this.iconID = iconID;
    }
}
