package ir.nasim;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: ir.nasim.Ia0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC5128Ia0 {
    final Context a;
    private C24792zC6 b;
    private C24792zC6 c;

    AbstractC5128Ia0(Context context) {
        this.a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof Y17)) {
            return menuItem;
        }
        Y17 y17 = (Y17) menuItem;
        if (this.b == null) {
            this.b = new C24792zC6();
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(y17);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC21752u44 menuItemC21752u44 = new MenuItemC21752u44(this.a, y17);
        this.b.put(y17, menuItemC21752u44);
        return menuItemC21752u44;
    }

    final void e() {
        C24792zC6 c24792zC6 = this.b;
        if (c24792zC6 != null) {
            c24792zC6.clear();
        }
        C24792zC6 c24792zC62 = this.c;
        if (c24792zC62 != null) {
            c24792zC62.clear();
        }
    }

    final void f(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.b.size()) {
            if (((Y17) this.b.g(i2)).getGroupId() == i) {
                this.b.i(i2);
                i2--;
            }
            i2++;
        }
    }

    final void g(int i) {
        if (this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (((Y17) this.b.g(i2)).getItemId() == i) {
                this.b.i(i2);
                return;
            }
        }
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }
}
