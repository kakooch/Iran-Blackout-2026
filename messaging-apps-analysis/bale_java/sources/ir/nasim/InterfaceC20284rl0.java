package ir.nasim;

import android.view.View;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.rl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC20284rl0 extends InterfaceC9437Zx6, InterfaceC7879To6 {
    static /* synthetic */ void h(InterfaceC20284rl0 interfaceC20284rl0, C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
        }
        if ((i & 4) != 0) {
            enumC8893Xt7 = null;
        }
        interfaceC20284rl0.o(c8967Xz7, xv4, enumC8893Xt7);
    }

    void a();

    @Override // ir.nasim.InterfaceC9437Zx6
    default C8948Xx6 b() {
        return null;
    }

    View d();

    void i();

    void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7);

    default void t(InterfaceC20875sl0 interfaceC20875sl0) {
        AbstractC13042fc3.i(interfaceC20875sl0, "listener");
    }

    default void w(View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
    }

    void z(N15 n15);
}
