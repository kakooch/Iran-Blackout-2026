package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.YD;

/* loaded from: classes.dex */
public class a extends YD implements DialogInterface {
    final AlertController f;

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0011a {
        private final AlertController.b a;
        private final int b;

        public C0011a(Context context) {
            this(context, a.k(context, 0));
        }

        public C0011a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.w = listAdapter;
            bVar.x = onClickListener;
            return this;
        }

        public C0011a b(View view) {
            this.a.g = view;
            return this;
        }

        public C0011a c(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a create() {
            a aVar = new a(this.a.a, this.b);
            this.a.a(aVar.f);
            aVar.setCancelable(this.a.r);
            if (this.a.r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.a.s);
            aVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                aVar.setOnKeyListener(onKeyListener);
            }
            return aVar;
        }

        public C0011a d(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.v = charSequenceArr;
            bVar.x = onClickListener;
            return this;
        }

        public C0011a e(int i) {
            AlertController.b bVar = this.a;
            bVar.h = bVar.a.getText(i);
            return this;
        }

        public C0011a f(CharSequence charSequence) {
            this.a.h = charSequence;
            return this;
        }

        public C0011a g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.l = charSequence;
            bVar.n = onClickListener;
            return this;
        }

        public Context getContext() {
            return this.a.a;
        }

        public C0011a h(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public C0011a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.i = charSequence;
            bVar.k = onClickListener;
            return this;
        }

        public C0011a j(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.w = listAdapter;
            bVar.x = onClickListener;
            bVar.I = i;
            bVar.H = true;
            return this;
        }

        public a k() {
            a aVarCreate = create();
            aVarCreate.show();
            return aVarCreate;
        }

        public C0011a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.l = bVar.a.getText(i);
            this.a.n = onClickListener;
            return this;
        }

        public C0011a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.i = bVar.a.getText(i);
            this.a.k = onClickListener;
            return this;
        }

        public C0011a setTitle(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public C0011a setView(View view) {
            AlertController.b bVar = this.a;
            bVar.z = view;
            bVar.y = 0;
            bVar.E = false;
            return this;
        }

        public C0011a(Context context, int i) {
            this.a = new AlertController.b(new ContextThemeWrapper(context, a.k(context, i)));
            this.b = i;
        }
    }

    protected a(Context context, int i) {
        super(context, k(context, i));
        this.f = new AlertController(getContext(), this, getWindow());
    }

    static int k(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC15790kA5.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button i(int i) {
        return this.f.c(i);
    }

    public ListView j() {
        return this.f.e();
    }

    @Override // ir.nasim.YD, ir.nasim.V01, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f.g(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f.h(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // ir.nasim.YD, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f.q(charSequence);
    }
}
