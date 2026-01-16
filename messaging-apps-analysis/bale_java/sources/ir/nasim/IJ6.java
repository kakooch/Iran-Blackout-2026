package ir.nasim;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import ir.nasim.H5;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class IJ6 extends H5 implements e.a {
    private Context c;
    private ActionBarContextView d;
    private H5.a e;
    private WeakReference f;
    private boolean g;
    private boolean h;
    private androidx.appcompat.view.menu.e i;

    public IJ6(Context context, ActionBarContextView actionBarContextView, H5.a aVar, boolean z) {
        this.c = context;
        this.d = actionBarContextView;
        this.e = aVar;
        androidx.appcompat.view.menu.e eVarW = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).W(1);
        this.i = eVarW;
        eVarW.V(this);
        this.h = z;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.e.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.d.l();
    }

    @Override // ir.nasim.H5
    public void c() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.e.d(this);
    }

    @Override // ir.nasim.H5
    public View d() {
        WeakReference weakReference = this.f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // ir.nasim.H5
    public Menu e() {
        return this.i;
    }

    @Override // ir.nasim.H5
    public MenuInflater f() {
        return new X17(this.d.getContext());
    }

    @Override // ir.nasim.H5
    public CharSequence g() {
        return this.d.getSubtitle();
    }

    @Override // ir.nasim.H5
    public CharSequence i() {
        return this.d.getTitle();
    }

    @Override // ir.nasim.H5
    public void k() {
        this.e.b(this, this.i);
    }

    @Override // ir.nasim.H5
    public boolean l() {
        return this.d.j();
    }

    @Override // ir.nasim.H5
    public void m(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference(view) : null;
    }

    @Override // ir.nasim.H5
    public void n(int i) {
        o(this.c.getString(i));
    }

    @Override // ir.nasim.H5
    public void o(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    @Override // ir.nasim.H5
    public void q(int i) {
        r(this.c.getString(i));
    }

    @Override // ir.nasim.H5
    public void r(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    @Override // ir.nasim.H5
    public void s(boolean z) {
        super.s(z);
        this.d.setTitleOptional(z);
    }
}
