package ir.nasim;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: ir.nasim.je2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15470je2 {
    private final View a;
    private boolean b = false;
    private int c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public C15470je2(InterfaceC14881ie2 interfaceC14881ie2) {
        this.a = (View) interfaceC14881ie2;
    }

    private void a() {
        ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).l(this.a);
        }
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void f(int i) {
        this.c = i;
    }
}
