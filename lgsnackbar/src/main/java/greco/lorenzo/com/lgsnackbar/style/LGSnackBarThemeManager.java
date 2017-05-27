package greco.lorenzo.com.lgsnackbar.style;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

import greco.lorenzo.com.lgsnackbar.R;

import static greco.lorenzo.com.lgsnackbar.style.LGSnackBarThemeManager.LGSnackbarThemeName.MATERIAL;

/**
 * Created by LoreGr on 20/05/2017.
 */
public class LGSnackBarThemeManager {

    private static final String TAG = "LGSnackBarThemeManager";

    public enum LGSnackbarThemeName {
        MATERIAL,
        RETRO,
        SHINE
    }

    public static LGSnackBarTheme getTheme(Context context, LGSnackbarThemeName themeName) {
        if (themeName==null){
            themeName = MATERIAL;
        }
        switch (themeName) {
            case MATERIAL:
                return materialTheme(context);
            case RETRO:
                return retroTheme(context);
            case SHINE:
                return shineTheme(context);
        }
        return null;
    }

    static LGSnackBarTheme materialTheme(Context context) {
        LGSnackBarStyle successStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.successMaterial),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionSuccessMaterial),
                R.drawable.ic_success_material);

        LGSnackBarStyle warningStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.warningMaterial),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionWarningMaterial),
                R.drawable.ic_warning_material);

        LGSnackBarStyle errorStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.errorMaterial),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionErrorMaterial),
                R.drawable.ic_error_material);

        LGSnackBarStyle infoStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.infoMaterial),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionInfoMaterial),
                R.drawable.ic_info_material);

        return new LGSnackBarTheme(successStyle, warningStyle, errorStyle, infoStyle, 48, Snackbar.LENGTH_LONG);
    }

    static LGSnackBarTheme retroTheme(Context context) {
        LGSnackBarStyle successStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.successRetro),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionSuccessRetro),
                R.drawable.ic_success_retro);

        LGSnackBarStyle warningStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.warningRetro),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionWarningRetro),
                R.drawable.ic_warning_retro);

        LGSnackBarStyle errorStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.errorRetro),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionErrorRetro),
                R.drawable.ic_error_retro);

        LGSnackBarStyle infoStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.infoRetro),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionInfoRetro),
                R.drawable.ic_info_retro);

        return new LGSnackBarTheme(successStyle, warningStyle, errorStyle, infoStyle, 55, Snackbar.LENGTH_LONG);
    }

    static LGSnackBarTheme shineTheme(Context context) {
        LGSnackBarStyle successStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.successShine),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionSuccessShine),
                R.drawable.ic_success_shine);

        LGSnackBarStyle warningStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.warningShine),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionWarningShine),
                R.drawable.ic_warning_shine);

        LGSnackBarStyle errorStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.errorShine),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionErrorShine),
                R.drawable.ic_error_shine);

        LGSnackBarStyle infoStyle = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.infoShine),
                Color.WHITE,
                ContextCompat.getColor(context, R.color.actionInfoShine),
                R.drawable.ic_info_shine);

        return new LGSnackBarTheme(successStyle, warningStyle, errorStyle, infoStyle, 70, Snackbar.LENGTH_LONG);
    }

}
