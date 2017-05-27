package greco.lorenzo.com.lgsnackbar.style;

import android.support.annotation.NonNull;

/**
 * Created by LoreGr on 20/05/2017.
 */
public class LGSnackBarTheme {

    private static final String TAG = "LGSnackBarTheme";

    public enum SnackbarStyle {
        SUCCESS,
        WARNING,
        ERROR,
        INFO
    }

    private LGSnackBarStyle successStyle;
    private LGSnackBarStyle warningStyle;
    private LGSnackBarStyle errorStyle;
    private LGSnackBarStyle infoStyle;

    private int minHeight;
    private int duration;

    public LGSnackBarTheme(@NonNull LGSnackBarStyle successStyle, @NonNull LGSnackBarStyle warningStyle, @NonNull LGSnackBarStyle errorStyle, @NonNull LGSnackBarStyle infoStyle, @NonNull int minHeight,@NonNull int duration) {
        this.successStyle = successStyle;
        this.warningStyle = warningStyle;
        this.errorStyle = errorStyle;
        this.infoStyle = infoStyle;
        this.minHeight = minHeight;
        this.duration = duration;
    }

    public LGSnackBarStyle getStyle(SnackbarStyle barStyle){
        switch (barStyle) {
            case SUCCESS:
                return successStyle;
            case WARNING:
                return warningStyle;
            case ERROR:
                return errorStyle;
            case INFO:
                return infoStyle;
        }
        return null;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getDuration() {
        return duration;
    }
}
