package ir.nasim;

import android.content.SharedPreferences;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;

/* loaded from: classes7.dex */
public class C4 {
    private static volatile C4[] b = new C4[1];
    private int a;

    public C4(int i) {
        this.a = i;
    }

    public static C4 b(int i) {
        C4 c4 = b[i];
        if (c4 == null) {
            synchronized (C4.class) {
                try {
                    c4 = b[i];
                    if (c4 == null) {
                        C4[] c4Arr = b;
                        C4 c42 = new C4(i);
                        c4Arr[i] = c42;
                        c4 = c42;
                    }
                } finally {
                }
            }
        }
        return c4;
    }

    public ConnectionsManager a() {
        return ConnectionsManager.k(this.a);
    }

    public ir.nasim.tgwidgets.editor.messenger.C c() {
        return ir.nasim.tgwidgets.editor.messenger.C.n(this.a);
    }

    public ir.nasim.tgwidgets.editor.messenger.D d() {
        return ir.nasim.tgwidgets.editor.messenger.D.F(this.a);
    }

    public ir.nasim.tgwidgets.editor.messenger.E e() {
        return ir.nasim.tgwidgets.editor.messenger.E.k(this.a);
    }

    public ir.nasim.tgwidgets.editor.messenger.F f() {
        return ir.nasim.tgwidgets.editor.messenger.F.o(this.a);
    }

    public SharedPreferences g() {
        return ir.nasim.tgwidgets.editor.messenger.C.p(this.a);
    }

    public C22477vI7 h() {
        return C22477vI7.j(this.a);
    }
}
