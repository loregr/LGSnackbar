package greco.lorenzo.com.lgsnackbar.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import greco.lorenzo.com.lgsnackbar.LGSnackbarManager;
import greco.lorenzo.com.lgsnackbar.core.LGSnackbar;
import greco.lorenzo.com.lgsnackbar.core.LGSnackbarAction;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarStyle;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme;
import greco.lorenzo.com.lgsnackbar.style.LGSnackBarThemeManager;

import static greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme.SnackbarStyle.ERROR;
import static greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme.SnackbarStyle.INFO;
import static greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme.SnackbarStyle.SUCCESS;
import static greco.lorenzo.com.lgsnackbar.style.LGSnackBarTheme.SnackbarStyle.WARNING;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    LGSnackBarThemeManager.LGSnackbarThemeName themeName;
    LGSnackbarAction mainAction;

    @BindColor(R.color.colorPrimary)
    int primaryColor;
    @BindColor(R.color.colorAccent)
    int accentColor;

    @BindColor(R.color.successCustom)
    int successCustomColor;
    @BindColor(R.color.warningCustom)
    int warningCustomColor;
    @BindColor(R.color.errorCustom)
    int errorCustomColor;
    @BindColor(R.color.infoCustom)
    int infoCustomColor;
    @BindColor(R.color.actionSuccessCustom)
    int actionSuccessCustomColor;
    @BindColor(R.color.actionWarningCustom)
    int actionWarningCustomColor;
    @BindColor(R.color.actionErrorCustom)
    int actionErrorCustomColor;
    @BindColor(R.color.actionInfoCustom)
    int actionInfoCustomColor;

    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LGSnackbarManager.prepare(getApplicationContext(), LGSnackBarThemeManager.LGSnackbarThemeName.SHINE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.themes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @OnItemSelected (R.id.spinner)
    public void onThemeSelected (Spinner spinner, int position) {
        switch (position) {
            case 0:
                themeName = LGSnackBarThemeManager.LGSnackbarThemeName.SHINE;
                LGSnackbarManager.setThemeName(themeName);
                break;
            case 1:
                themeName = LGSnackBarThemeManager.LGSnackbarThemeName.MATERIAL;
                LGSnackbarManager.setThemeName(themeName);
                break;
            case 2:
                themeName = LGSnackBarThemeManager.LGSnackbarThemeName.RETRO;
                LGSnackbarManager.setThemeName(themeName);
                break;
            case 3:
                LGSnackbarManager.setTheme(customTheme());
                break;
        }
        Log.d(TAG, "onItemSelected: " + position);
    }

    @OnCheckedChanged(R.id.action_switch)
    public void checkboxToggled (boolean isChecked) {
        if (isChecked){
            mainAction = new LGSnackbarAction("Action", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Action fired", Toast.LENGTH_LONG).show();
                }
            });
        }else{
            mainAction = null;
        }
    }

    @OnClick({R.id.show_success_btn, R.id.show_warning_btn, R.id.show_error_btn, R.id.show_info_btn, R.id.show_custom_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.show_success_btn:
                LGSnackbarManager.show(SUCCESS, "Everything is looking good! Awesome!", null, mainAction);
                break;
            case R.id.show_warning_btn:
                LGSnackbarManager.show(WARNING, "Mmmm, maybe we can do something better", null, mainAction);
                break;
            case R.id.show_error_btn:
                LGSnackbarManager.show(ERROR, "Big problems here! Please have a look ASAP", null, mainAction);
                break;
            case R.id.show_info_btn:
                LGSnackbarManager.show(INFO, "You look beautiful today :-)", null, mainAction);
                break;
            case R.id.show_custom_btn:
                new LGSnackbar.LGSnackbarBuilder(getApplicationContext(), "This is a custom bar")
                        .backgroundColor(primaryColor)
                        .minHeightDp(50)
                        .textColor(accentColor)
                        .show();
                break;
        }
    }


    LGSnackBarTheme customTheme() {
        LGSnackBarStyle successStyle = new LGSnackBarStyle(successCustomColor,
                Color.WHITE,
                actionSuccessCustomColor,
                R.drawable.ic_done_white);

        LGSnackBarStyle warningStyle = new LGSnackBarStyle(warningCustomColor,
                Color.WHITE,
                actionWarningCustomColor,
                R.drawable.ic_warning_white);

        LGSnackBarStyle errorStyle = new LGSnackBarStyle(errorCustomColor,
                Color.WHITE,
                actionErrorCustomColor,
                R.drawable.ic_error_outline_white);

        LGSnackBarStyle infoStyle = new LGSnackBarStyle(infoCustomColor,
                Color.WHITE,
                actionInfoCustomColor,
               R.drawable.ic_info_outline_white);

        return new LGSnackBarTheme(successStyle, warningStyle, errorStyle, infoStyle, 60, Snackbar.LENGTH_LONG);
    }
}
