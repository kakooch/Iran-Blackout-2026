package ir.resaneh1.iptv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.JJTeamObject;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class MatchForecastDialog extends Dialog {
    public View button;
    public JJTeamObject guestTeam;
    public JJTeamObject hostTeam;
    public TextView leftName;
    public ImageView leftTeamImage;
    public NumberPicker numberGuest;
    public NumberPicker numberHost;
    public int pointGuest;
    public int pointHost;
    public TextView rightName;
    public ImageView rightTeamImage;

    public MatchForecastDialog(Context context, int i, int i2, JJTeamObject jJTeamObject, JJTeamObject jJTeamObject2) {
        super(context);
        this.pointGuest = i;
        this.pointHost = i2;
        this.hostTeam = jJTeamObject2;
        this.guestTeam = jJTeamObject;
        show();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.match_forecast_dialog);
        getWindow().setLayout(-1, -1);
        findViews();
        init();
    }

    private void findViews() {
        this.numberGuest = (NumberPicker) findViewById(R.id.numberPickerRight);
        this.numberHost = (NumberPicker) findViewById(R.id.numberPickerLeft);
        this.rightTeamImage = (ImageView) findViewById(R.id.imageViewRight);
        this.leftTeamImage = (ImageView) findViewById(R.id.imageViewLeft);
        this.rightName = (TextView) findViewById(R.id.textViewRightName);
        this.leftName = (TextView) findViewById(R.id.textViewLeftName);
        this.button = findViewById(R.id.button);
    }

    private void init() {
        this.numberGuest.setMaxValue(9);
        this.numberHost.setMaxValue(9);
        this.numberGuest.setValue(this.pointGuest);
        this.numberHost.setValue(this.pointHost);
        JJTeamObject jJTeamObject = this.guestTeam;
        if (jJTeamObject != null) {
            this.rightName.setText(jJTeamObject.getName());
            if (this.guestTeam.flag != null) {
                GlideHelper.loadFitCenter(ApplicationLoader.applicationContext, this.rightTeamImage, this.guestTeam.flag, R.color.transparent);
            } else {
                this.rightTeamImage.setImageResource(R.color.transparent);
            }
        }
        JJTeamObject jJTeamObject2 = this.hostTeam;
        if (jJTeamObject2 != null) {
            this.leftName.setText(jJTeamObject2.getName());
            if (this.hostTeam.flag != null) {
                GlideHelper.loadFitCenter(ApplicationLoader.applicationContext, this.leftTeamImage, this.hostTeam.flag, R.color.transparent);
            } else {
                this.leftTeamImage.setImageResource(R.color.transparent);
            }
        }
        setPersianFormatter(this.numberHost);
        setPersianFormatter(this.numberGuest);
    }

    public void setPersianFormatter(NumberPicker numberPicker) {
        numberPicker.setFormatter(new NumberPicker.Formatter(this) { // from class: ir.resaneh1.iptv.dialog.MatchForecastDialog.1
            @Override // android.widget.NumberPicker.Formatter
            public String format(int i) {
                return NumberUtils.toPersian(String.valueOf(i));
            }
        });
    }
}
