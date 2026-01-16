package ir.nasim;

import android.content.Context;
import android.view.SubMenu;

/* renamed from: ir.nasim.jq4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15592jq4 extends androidx.appcompat.view.menu.e {
    public C15592jq4(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) a(i, i2, i3, charSequence);
        C16774lq4 c16774lq4 = new C16774lq4(w(), this, gVar);
        gVar.x(c16774lq4);
        return c16774lq4;
    }
}
