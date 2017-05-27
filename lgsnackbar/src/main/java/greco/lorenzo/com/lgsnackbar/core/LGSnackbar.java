package greco.lorenzo.com.lgsnackbar.core;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

import greco.lorenzo.com.lgsnackbar.R;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarStyle;

/**
 * Created by LoreGr on 20/05/2017.
 */
public class LGSnackbar {

    public static final int NO_ICON_ID = -1;

    private final Context context;

    private final LGSnackBarStyle style;

    private final CharSequence text;
    private final int duration;
    private final float minHeight;

    private final Snackbar.Callback callback;
    private final LGSnackbarAction action;

    public LGSnackbar(Context context, LGSnackBarStyle style, CharSequence text, int duration, float minHeight, Snackbar.Callback callback, LGSnackbarAction action) {
        this.context = context;
        this.style = style;
        this.text = text;
        this.duration = duration;
        this.minHeight = LGUtils.convertDpToPixel(minHeight, context);
        this.callback = callback;
        this.action = action;
    }

    public LGSnackbar(LGSnackbarBuilder builder) {
        this.context = builder.context;
        this.text = builder.text;
        this.duration = builder.duration;
        this.minHeight = builder.minHeight;
        this.callback = builder.callback;
        this.action = builder.action;
        this.style = builder.style;
    }

    Context getContext() {
        return context;
    }

    public CharSequence getText() {
        return text;
    }

    int getDuration() {
        return duration;
    }

    int getBackgroundColor() {
        return style.backgroundColor;
    }

    int getActionTextColor() {
        return style.actionTextColor;
    }

    int getTextColor() {
        return style.textColor;
    }

    float getMinHeight() {
        return minHeight;
    }

    int getIconID() {
        return style.iconID;
    }

    Snackbar.Callback getCallback() {
        return callback;
    }

    LGSnackbarAction getAction() {
        return action;
    }

    public void show() {
        new LGSnackbarPresenter(this).show();
    }

    public static class LGSnackbarBuilder {

        private final Context context;

        private LGSnackBarStyle style;

        private final CharSequence text;
        private int duration;
        private float minHeight;

        private Snackbar.Callback callback;
        private LGSnackbarAction action;

        public LGSnackbarBuilder(Context context, CharSequence text) {
            this.context = context;
            this.text = text;
            this.style = new LGSnackBarStyle(ContextCompat.getColor(context, R.color.defaultBgColor),
                    Color.WHITE,
                    ContextCompat.getColor(context, R.color.defaultActionColor),
                    NO_ICON_ID);
            this.duration = Snackbar.LENGTH_LONG;
            this.minHeight = context.getResources().getDimension(R.dimen.default_sb_height);
            this.callback = null;
            this.action = null;
        }

        public LGSnackbarBuilder style(LGSnackBarStyle style) {
            this.style = style;
            return this;
        }

        public LGSnackbarBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public LGSnackbarBuilder backgroundColor(int backgroundColor) {
            this.style.backgroundColor = backgroundColor;
            return this;
        }

        public LGSnackbarBuilder actionTextColor(int actionTextColor) {
            this.style.actionTextColor = actionTextColor;
            return this;
        }

        public LGSnackbarBuilder textColor(int textColor) {
            this.style.textColor = textColor;
            return this;
        }

        public LGSnackbarBuilder minHeightDp(float minHeight) {
            this.minHeight = LGUtils.convertDpToPixel(minHeight, context);
            return this;
        }

        public LGSnackbarBuilder iconID(int iconID) {
            this.style.iconID = iconID;
            return this;
        }

        public LGSnackbarBuilder callback(Snackbar.Callback callback) {
            this.callback = callback;
            return this;
        }

        public LGSnackbarBuilder action(LGSnackbarAction action) {
            this.action = action;
            return this;
        }


        LGSnackbar build() {
            return new LGSnackbar(this);
        }

        public void show() {
            build().show();
        }
    }
}
