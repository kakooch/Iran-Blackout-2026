package ir.resaneh1.iptv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.WindowManager;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;

/* loaded from: classes3.dex */
public class ThreeButtonDialog extends Dialog {
    public TextView button1;
    public TextView button2;
    public TextView button3;
    public SpannableString spannableString;
    public TextView textView;

    public ThreeButtonDialog(Context context, String str) {
        super(context);
        this.spannableString = new SpannableString(str);
        try {
            show();
        } catch (WindowManager.BadTokenException e) {
            MyLog.handleException(e);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.three_button_dialog);
        getWindow().setLayout(-1, -1);
        findViews();
        init();
    }

    private void findViews() {
        this.button1 = (TextView) findViewById(R.id.button1);
        this.button2 = (TextView) findViewById(R.id.button2);
        this.button3 = (TextView) findViewById(R.id.button3);
        this.textView = (TextView) findViewById(R.id.textView);
    }

    private void init() {
        this.textView.setText(this.spannableString);
    }
}
