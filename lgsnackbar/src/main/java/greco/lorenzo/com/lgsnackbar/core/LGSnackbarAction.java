package greco.lorenzo.com.lgsnackbar.core;

import android.view.View;

/**
 * Created by LoreGr on 20/05/2017.
 */
public class LGSnackbarAction {
    private final CharSequence text;
    private final View.OnClickListener listener;

    public LGSnackbarAction(CharSequence text, View.OnClickListener listener) {
        this.text = text;
        this.listener = listener;
    }

    public CharSequence getText() {
        return text;
    }

    public View.OnClickListener getListener() {
        return listener;
    }
}