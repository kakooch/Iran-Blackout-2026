package ir.nasim;

import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: ir.nasim.Mk7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6160Mk7 {
    private final SA2 a;
    private CK5 b;
    private SA2 c;
    private SA2 d;
    private SA2 e;
    private SA2 f;
    private SA2 g;

    public C6160Mk7(SA2 sa2, CK5 ck5, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26) {
        this.a = sa2;
        this.b = ck5;
        this.c = sa22;
        this.d = sa23;
        this.e = sa24;
        this.f = sa25;
        this.g = sa26;
    }

    private final void b(Menu menu, EnumC21078t44 enumC21078t44, SA2 sa2) {
        if (sa2 != null && menu.findItem(enumC21078t44.j()) == null) {
            a(menu, enumC21078t44);
        } else {
            if (sa2 != null || menu.findItem(enumC21078t44.j()) == null) {
                return;
            }
            menu.removeItem(enumC21078t44.j());
        }
    }

    public final void a(Menu menu, EnumC21078t44 enumC21078t44) {
        menu.add(0, enumC21078t44.j(), enumC21078t44.p(), enumC21078t44.q()).setShowAsAction(1);
    }

    public final CK5 c() {
        return this.b;
    }

    public final boolean d(ActionMode actionMode, MenuItem menuItem) {
        AbstractC13042fc3.f(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == EnumC21078t44.c.j()) {
            SA2 sa2 = this.c;
            if (sa2 != null) {
                sa2.invoke();
            }
        } else if (itemId == EnumC21078t44.d.j()) {
            SA2 sa22 = this.d;
            if (sa22 != null) {
                sa22.invoke();
            }
        } else if (itemId == EnumC21078t44.e.j()) {
            SA2 sa23 = this.e;
            if (sa23 != null) {
                sa23.invoke();
            }
        } else if (itemId == EnumC21078t44.f.j()) {
            SA2 sa24 = this.f;
            if (sa24 != null) {
                sa24.invoke();
            }
        } else {
            if (itemId != EnumC21078t44.g.j()) {
                return false;
            }
            SA2 sa25 = this.g;
            if (sa25 != null) {
                sa25.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final boolean e(ActionMode actionMode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null menu".toString());
        }
        if (actionMode == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode".toString());
        }
        if (this.c != null) {
            a(menu, EnumC21078t44.c);
        }
        if (this.d != null) {
            a(menu, EnumC21078t44.d);
        }
        if (this.e != null) {
            a(menu, EnumC21078t44.e);
        }
        if (this.f != null) {
            a(menu, EnumC21078t44.f);
        }
        if (this.g == null || Build.VERSION.SDK_INT < 26) {
            return true;
        }
        a(menu, EnumC21078t44.g);
        return true;
    }

    public final void f() {
        SA2 sa2 = this.a;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final boolean g(ActionMode actionMode, Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        n(menu);
        return true;
    }

    public final void h(SA2 sa2) {
        this.g = sa2;
    }

    public final void i(SA2 sa2) {
        this.c = sa2;
    }

    public final void j(SA2 sa2) {
        this.e = sa2;
    }

    public final void k(SA2 sa2) {
        this.d = sa2;
    }

    public final void l(SA2 sa2) {
        this.f = sa2;
    }

    public final void m(CK5 ck5) {
        this.b = ck5;
    }

    public final void n(Menu menu) {
        b(menu, EnumC21078t44.c, this.c);
        b(menu, EnumC21078t44.d, this.d);
        b(menu, EnumC21078t44.e, this.e);
        b(menu, EnumC21078t44.f, this.f);
        b(menu, EnumC21078t44.g, this.g);
    }

    public /* synthetic */ C6160Mk7(SA2 sa2, CK5 ck5, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : sa2, (i & 2) != 0 ? CK5.e.a() : ck5, (i & 4) != 0 ? null : sa22, (i & 8) != 0 ? null : sa23, (i & 16) != 0 ? null : sa24, (i & 32) != 0 ? null : sa25, (i & 64) != 0 ? null : sa26);
    }
}
