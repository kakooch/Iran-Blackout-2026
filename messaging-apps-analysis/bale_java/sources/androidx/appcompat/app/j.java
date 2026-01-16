package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.Toolbar;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.PB1;
import java.util.ArrayList;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
class j extends ActionBar {
    final PB1 a;
    final Window.Callback b;
    final c.f c;
    boolean d;
    private boolean e;
    private boolean f;
    private ArrayList g = new ArrayList();
    private final Runnable h = new a();
    private final Toolbar.g i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.w();
        }
    }

    class b implements Toolbar.g {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            return j.this.b.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements j.a {
        private boolean a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (this.a) {
                return;
            }
            this.a = true;
            j.this.a.o();
            j.this.b.onPanelClosed(Type.EUI48, eVar);
            this.a = false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            j.this.b.onMenuOpened(Type.EUI48, eVar);
            return true;
        }
    }

    private final class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (j.this.a.d()) {
                j.this.b.onPanelClosed(Type.EUI48, eVar);
            } else if (j.this.b.onPreparePanel(0, null, eVar)) {
                j.this.b.onMenuOpened(Type.EUI48, eVar);
            }
        }
    }

    private class e implements c.f {
        e() {
        }

        @Override // androidx.appcompat.app.c.f
        public boolean a(int i) {
            if (i != 0) {
                return false;
            }
            j jVar = j.this;
            if (jVar.d) {
                return false;
            }
            jVar.a.setMenuPrepared();
            j.this.d = true;
            return false;
        }

        @Override // androidx.appcompat.app.c.f
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(j.this.a.getContext());
            }
            return null;
        }
    }

    j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.i = bVar;
        AbstractC4980Hj5.g(toolbar);
        D d2 = new D(toolbar, false);
        this.a = d2;
        this.b = (Window.Callback) AbstractC4980Hj5.g(callback);
        d2.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        d2.setWindowTitle(charSequence);
        this.c = new e();
    }

    private Menu v() {
        if (!this.e) {
            this.a.r(new c(), new d());
            this.e = true;
        }
        return this.a.h();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean g() {
        return this.a.b();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        if (!this.a.f()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        if (this.g.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(this.g.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.a.s();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean l() {
        this.a.k().removeCallbacks(this.h);
        AbstractC12990fW7.h0(this.a.k(), this.h);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    void n() {
        this.a.k().removeCallbacks(this.h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuV = v();
        if (menuV == null) {
            return false;
        }
        menuV.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuV.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean q() {
        return this.a.c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    void w() {
        Menu menuV = v();
        androidx.appcompat.view.menu.e eVar = menuV instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menuV : null;
        if (eVar != null) {
            eVar.h0();
        }
        try {
            menuV.clear();
            if (!this.b.onCreatePanelMenu(0, menuV) || !this.b.onPreparePanel(0, null, menuV)) {
                menuV.clear();
            }
            if (eVar != null) {
                eVar.g0();
            }
        } catch (Throwable th) {
            if (eVar != null) {
                eVar.g0();
            }
            throw th;
        }
    }
}
