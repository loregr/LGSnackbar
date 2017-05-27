package greco.lorenzo.com.lgsnackbar;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;

import greco.lorenzo.com.lgsnackbar.core.LGSnackbarAction;
import greco.lorenzo.com.lgsnackbar.core.LGSnackbar;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarStyle;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarThemeManager;
import static greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme.SnackbarStyle.SUCCESS;

/**
 * Created by LoreGr on 20/05/2017.
 */
public class LGSnackbarManager {

    private static final String TAG = "LGSnackbar";

    public static final int NO_ICON_ID = -1;

    private static LGSnackbarManager instance = null;

    private Context appContext;
    private LGSnackBarTheme selectedTheme;

    public static void prepare(Context context) {
       prepare(context, null, null);
    }

    public static void prepare(Context context, LGSnackBarThemeManager.LGSnackbarThemeName themeName) {
        prepare(context, themeName, null);
    }

    public static void prepare(Context context, LGSnackBarTheme theme) {
        prepare(context, null, theme);
    }

    public static void prepare(Context context, LGSnackBarThemeManager.LGSnackbarThemeName themeName, LGSnackBarTheme theme) {
        if(instance == null) {
            instance = new LGSnackbarManager(context, themeName, theme);
        }else{
            Log.w(TAG, "prepare: Instance already initialised");
        }
    }

    public static void setTheme (LGSnackBarTheme theme) {
        if (instance == null){
            Log.e(TAG, "getInstance: you need to call LGSnackbar.prepare() first!");
            return;
        }
        instance.selectedTheme = theme;
    }

    public static void setThemeName (LGSnackBarThemeManager.LGSnackbarThemeName themeName) {
        setTheme(LGSnackBarThemeManager.getTheme(instance.appContext, themeName));
    }

    private LGSnackbarManager(Context context, LGSnackBarThemeManager.LGSnackbarThemeName themeName, LGSnackBarTheme theme) {
        appContext = context;
        if (theme==null) {
            selectedTheme = LGSnackBarThemeManager.getTheme(appContext, themeName);
        }else{
            selectedTheme = theme;
        }
    }

    public static void show(LGSnackBarTheme.SnackbarStyle barStyle, CharSequence text){
        show(barStyle, text, null, null);
    }

    public static void show(LGSnackBarTheme.SnackbarStyle barStyle, CharSequence text, Snackbar.Callback callback){
        show(barStyle, text, callback, null);
    }

    public static void show(LGSnackBarTheme.SnackbarStyle barStyle, CharSequence text, LGSnackbarAction action){
        show(barStyle, text, null, action);
    }

    public static void show(LGSnackBarTheme.SnackbarStyle barStyle, CharSequence text, Snackbar.Callback callback, LGSnackbarAction action){
        if (instance == null){
            Log.e(TAG, "getInstance: you need to call LGSnackbar.prepare() first!");
            return;
        }
        showSnackbar(text, instance.selectedTheme.getStyle(barStyle), instance.selectedTheme.getDuration(), instance.selectedTheme.getMinHeight(), callback, action);
    }


    private static void showSnackbar(CharSequence text, LGSnackBarStyle style, int duration, int minHeight, Snackbar.Callback callback, LGSnackbarAction action) {
        new LGSnackbar(instance.appContext, style, text, duration, minHeight, callback, action).show();
    }
}
