package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC21595to3;
import ir.nasim.H5;

/* loaded from: classes.dex */
public class YD extends V01 implements OD {
    private androidx.appcompat.app.b d;
    private final AbstractC21595to3.a e;

    public YD(Context context, int i) {
        super(context, f(context, i));
        this.e = new AbstractC21595to3.a() { // from class: ir.nasim.XD
            @Override // ir.nasim.AbstractC21595to3.a
            public final boolean m(KeyEvent keyEvent) {
                return this.a.g(keyEvent);
            }
        };
        androidx.appcompat.app.b bVarE = e();
        bVarE.Q(f(context, i));
        bVarE.z(null);
    }

    private static int f(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC15790kA5.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // ir.nasim.V01, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().A();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC21595to3.e(this.e, getWindow().getDecorView(), this, keyEvent);
    }

    public androidx.appcompat.app.b e() {
        if (this.d == null) {
            this.d = androidx.appcompat.app.b.k(this, this);
        }
        return this.d;
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        return e().l(i);
    }

    boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean h(int i) {
        return e().I(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        e().v();
    }

    @Override // ir.nasim.OD
    public H5 n(H5.a aVar) {
        return null;
    }

    @Override // ir.nasim.V01, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        e().u();
        super.onCreate(bundle);
        e().z(bundle);
    }

    @Override // ir.nasim.V01, android.app.Dialog
    protected void onStop() {
        super.onStop();
        e().F();
    }

    @Override // ir.nasim.V01, android.app.Dialog
    public void setContentView(int i) {
        e().K(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().R(charSequence);
    }

    @Override // ir.nasim.V01, android.app.Dialog
    public void setContentView(View view) {
        e().L(view);
    }

    @Override // ir.nasim.V01, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e().M(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        e().R(getContext().getString(i));
    }

    @Override // ir.nasim.OD
    public void E(H5 h5) {
    }

    @Override // ir.nasim.OD
    public void I(H5 h5) {
    }
}
