package ir.nasim;

import android.content.Context;
import android.view.View;

/* renamed from: ir.nasim.w54, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC22948w54 {
    static /* synthetic */ void d(InterfaceC22948w54 interfaceC22948w54, C8967Xz7 c8967Xz7, Boolean bool, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSelected");
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        interfaceC22948w54.o(c8967Xz7, bool);
    }

    static /* synthetic */ boolean i(InterfaceC22948w54 interfaceC22948w54, View view, C8967Xz7 c8967Xz7, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDoubleTapped");
        }
        if ((i & 4) != 0) {
            str = c8967Xz7.k();
        }
        return interfaceC22948w54.j(view, c8967Xz7, str);
    }

    void a(int i);

    void b(J44 j44, C17532n74 c17532n74);

    void c(Context context, J44 j44, C11458d25 c11458d25);

    void e(View view, C8967Xz7 c8967Xz7);

    void f(C10240bJ6 c10240bJ6);

    void g(C8967Xz7 c8967Xz7, String str, View view);

    boolean h(C8967Xz7 c8967Xz7, String str);

    boolean j(View view, C8967Xz7 c8967Xz7, String str);

    void k(C8967Xz7 c8967Xz7);

    void l(C8967Xz7 c8967Xz7);

    boolean m(C8967Xz7 c8967Xz7);

    void n(C8967Xz7 c8967Xz7, String str);

    void o(C8967Xz7 c8967Xz7, Boolean bool);

    void p(C8967Xz7 c8967Xz7, C4602Fv2 c4602Fv2);

    void q(String str);

    void r(C8967Xz7 c8967Xz7, G73 g73);

    void s(C8967Xz7 c8967Xz7);

    void t(C8967Xz7 c8967Xz7, String str, boolean z);
}
