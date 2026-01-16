package ir.resaneh1.iptv.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class BotAlertDialog extends AlertDialog {
    public BotAlertDialog(Context context, String str, String str2) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_textview_bot, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.textView)).setText(str);
        ((TextView) viewInflate.findViewById(R.id.textViewMessage)).setText(str2);
        viewInflate.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.BotAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BotAlertDialog.this.dismiss();
            }
        });
        setView(viewInflate);
    }
}
