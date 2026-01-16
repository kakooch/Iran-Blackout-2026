package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/* renamed from: ir.nasim.Zw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class DialogC9423Zw1 extends Dialog {
    private final String a;
    private final View.OnClickListener b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC9423Zw1(Context context, String str, View.OnClickListener onClickListener) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        this.a = str;
        this.b = onClickListener;
        setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogC9423Zw1 dialogC9423Zw1, View view) {
        AbstractC13042fc3.i(dialogC9423Zw1, "this$0");
        dialogC9423Zw1.b.onClick(view);
        dialogC9423Zw1.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(AbstractC12208eD5.custom_error_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
        if (window != null) {
            window.setGravity(17);
        }
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        ((TextView) findViewById(BC5.txt_dialog)).setText(this.a);
        ((Button) findViewById(BC5.btn_yes)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Yw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC9423Zw1.b(this.a, view);
            }
        });
    }
}
