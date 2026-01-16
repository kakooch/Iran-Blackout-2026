package ir.nasim;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: ir.nasim.hq4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14394hq4 extends androidx.appcompat.view.menu.e {
    private final Class B;
    private final int C;

    public C14394hq4(Context context, Class cls, int i) {
        super(context);
        this.B = cls;
        this.C = i;
    }

    @Override // androidx.appcompat.view.menu.e
    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= this.C) {
            h0();
            MenuItem menuItemA = super.a(i, i2, i3, charSequence);
            if (menuItemA instanceof androidx.appcompat.view.menu.g) {
                ((androidx.appcompat.view.menu.g) menuItemA).t(true);
            }
            g0();
            return menuItemA;
        }
        String simpleName = this.B.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.C + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.B.getSimpleName() + " does not support submenus");
    }
}
