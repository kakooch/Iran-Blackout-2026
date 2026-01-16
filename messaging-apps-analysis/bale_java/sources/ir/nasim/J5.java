package ir.nasim;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class J5 {
    private final Context a;
    private a b;
    private b c;

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public J5(Context context) {
        this.a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.c = null;
        this.b = null;
    }

    public void h(a aVar) {
        this.b = aVar;
    }

    public abstract void i(b bVar);

    public void j(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(z);
        }
    }
}
