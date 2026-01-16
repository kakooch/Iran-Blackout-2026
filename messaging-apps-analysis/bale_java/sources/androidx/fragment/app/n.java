package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import ir.nasim.AbstractC4980Hj5;

/* loaded from: classes2.dex */
public class n {
    private final p a;

    private n(p pVar) {
        this.a = pVar;
    }

    public static n b(p pVar) {
        return new n((p) AbstractC4980Hj5.h(pVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentManager fragmentManagerM = this.a.m();
        p pVar = this.a;
        fragmentManagerM.q(pVar, pVar, fragment);
    }

    public void c() {
        this.a.m().E();
    }

    public boolean d(MenuItem menuItem) {
        return this.a.m().H(menuItem);
    }

    public void e() {
        this.a.m().I();
    }

    public void f() {
        this.a.m().K();
    }

    public void g() {
        this.a.m().T();
    }

    public void h() {
        this.a.m().X();
    }

    public void i() {
        this.a.m().Y();
    }

    public void j() {
        this.a.m().a0();
    }

    public boolean k() {
        return this.a.m().h0(true);
    }

    public FragmentManager l() {
        return this.a.m();
    }

    public void m() {
        this.a.m().h1();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.m().E0().onCreateView(view, str, context, attributeSet);
    }
}
