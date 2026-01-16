package ir.resaneh1.iptv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class JustLinearLayoutDialog extends Dialog {
    public View content;
    public LinearLayout linearLayout;

    public JustLinearLayoutDialog(Context context, View view) {
        super(context);
        this.content = view;
        show();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.just_linearlayout_dialog);
        setCancelable(true);
        findViews();
        init();
    }

    private void findViews() {
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    private void init() {
        this.linearLayout.addView(this.content);
    }
}
