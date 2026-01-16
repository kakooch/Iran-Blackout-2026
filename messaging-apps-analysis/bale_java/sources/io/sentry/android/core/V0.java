package io.sentry.android.core;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.sentry.C3155n3;
import io.sentry.Q2;
import io.sentry.W2;
import io.sentry.Y2;
import io.sentry.Z1;
import io.sentry.protocol.C3171f;

/* loaded from: classes3.dex */
public final class V0 extends AlertDialog {
    private boolean a;
    private io.sentry.protocol.v b;
    private final io.sentry.protocol.v c;
    private DialogInterface.OnDismissListener d;

    public static class a {
        io.sentry.protocol.v a;
        final Context b;
        final int c;

        public a(Context context) {
            this(context, 0);
        }

        public V0 a() {
            return new V0(this.b, this.c, this.a, null, null);
        }

        public a(Context context, int i) {
            this(context, i, null);
        }

        public a(Context context, int i, b bVar) {
            this.b = context;
            this.c = i;
        }
    }

    public interface b {
    }

    V0(Context context, int i, io.sentry.protocol.v vVar, b bVar, Q2.b bVar2) {
        super(context, i);
        this.a = false;
        this.c = vVar;
        W2.d().a("UserFeedbackWidget");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(EditText editText, EditText editText2, EditText editText3, Q2 q2, TextView textView, TextView textView2, TextView textView3, View view) {
        String strTrim = editText.getText().toString().trim();
        String strTrim2 = editText2.getText().toString().trim();
        String strTrim3 = editText3.getText().toString().trim();
        if (strTrim.isEmpty() && q2.q()) {
            editText.setError(textView.getText());
            return;
        }
        if (strTrim2.isEmpty() && q2.p()) {
            editText2.setError(textView2.getText());
            return;
        }
        if (strTrim3.isEmpty()) {
            editText3.setError(textView3.getText());
            return;
        }
        C3171f c3171f = new C3171f(strTrim3);
        c3171f.m(strTrim);
        c3171f.k(strTrim2);
        io.sentry.protocol.v vVar = this.c;
        if (vVar != null) {
            c3171f.j(vVar);
        }
        io.sentry.protocol.v vVar2 = this.b;
        if (vVar2 != null) {
            c3171f.n(vVar2);
        }
        if (Z1.i(c3171f).equals(io.sentry.protocol.v.b)) {
            q2.l();
        } else {
            Toast.makeText(getContext(), q2.o(), 0).show();
            q2.m();
        }
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Runnable runnable, DialogInterface dialogInterface) {
        runnable.run();
        this.b = null;
        DialogInterface.OnDismissListener onDismissListener = this.d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        io.sentry.protocol.G user;
        super.onCreate(bundle);
        setContentView(H0.sentry_dialog_user_feedback);
        setCancelable(this.a);
        final Q2 q2 = new Q2(Z1.r().e().getFeedbackOptions());
        TextView textView = (TextView) findViewById(G0.sentry_dialog_user_feedback_title);
        ImageView imageView = (ImageView) findViewById(G0.sentry_dialog_user_feedback_logo);
        final TextView textView2 = (TextView) findViewById(G0.sentry_dialog_user_feedback_txt_name);
        final EditText editText = (EditText) findViewById(G0.sentry_dialog_user_feedback_edt_name);
        final TextView textView3 = (TextView) findViewById(G0.sentry_dialog_user_feedback_txt_email);
        final EditText editText2 = (EditText) findViewById(G0.sentry_dialog_user_feedback_edt_email);
        final TextView textView4 = (TextView) findViewById(G0.sentry_dialog_user_feedback_txt_description);
        final EditText editText3 = (EditText) findViewById(G0.sentry_dialog_user_feedback_edt_description);
        Button button = (Button) findViewById(G0.sentry_dialog_user_feedback_btn_send);
        Button button2 = (Button) findViewById(G0.sentry_dialog_user_feedback_btn_cancel);
        if (q2.r()) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (q2.t() || q2.q()) {
            textView2.setVisibility(0);
            editText.setVisibility(0);
            textView2.setText(q2.h());
            editText.setHint(q2.i());
            if (q2.q()) {
                textView2.append(q2.e());
            }
        } else {
            textView2.setVisibility(8);
            editText.setVisibility(8);
        }
        if (q2.s() || q2.p()) {
            textView3.setVisibility(0);
            editText2.setVisibility(0);
            textView3.setText(q2.b());
            editText2.setHint(q2.c());
            if (q2.p()) {
                textView3.append(q2.e());
            }
        } else {
            textView3.setVisibility(8);
            editText2.setVisibility(8);
        }
        if (q2.u() && (user = Z1.r().getScope().getUser()) != null) {
            editText.setText(user.k());
            editText2.setText(user.h());
        }
        textView4.setText(q2.f());
        textView4.append(q2.e());
        editText3.setHint(q2.g());
        textView.setText(q2.d());
        button.setText(q2.n());
        button.setOnClickListener(new View.OnClickListener() { // from class: io.sentry.android.core.S0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.d(editText, editText2, editText3, q2, textView2, textView3, textView4, view);
            }
        });
        button2.setText(q2.a());
        button2.setOnClickListener(new View.OnClickListener() { // from class: io.sentry.android.core.T0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.e(view);
            }
        });
        setOnDismissListener(this.d);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        C3155n3 c3155n3E = Z1.r().e();
        Runnable runnableK = c3155n3E.getFeedbackOptions().k();
        if (runnableK != null) {
            runnableK.run();
        }
        c3155n3E.getReplayController().y(Boolean.FALSE);
        this.b = c3155n3E.getReplayController().j();
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.a = z;
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.d = onDismissListener;
        final Runnable runnableJ = Z1.r().e().getFeedbackOptions().j();
        if (runnableJ != null) {
            super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: io.sentry.android.core.U0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.a.f(runnableJ, dialogInterface);
                }
            });
        } else {
            super.setOnDismissListener(this.d);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        io.sentry.Z zR = Z1.r();
        C3155n3 c3155n3E = zR.e();
        if (zR.isEnabled() && c3155n3E.isEnabled()) {
            super.show();
        } else {
            c3155n3E.getLogger().c(Y2.WARNING, "Sentry is disabled. Feedback dialog won't be shown.", new Object[0]);
        }
    }
}
