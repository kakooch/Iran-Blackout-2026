package ir.nasim;

/* renamed from: ir.nasim.f70, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC12737f70 {
    static /* synthetic */ void a(InterfaceC12737f70 interfaceC12737f70, String str, String str2, String str3, String str4, SA2 sa2, SA2 sa22, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showConfirmDialogWithCustomButtons");
        }
        interfaceC12737f70.b(str, str2, str3, str4, (i3 & 16) != 0 ? null : sa2, (i3 & 32) != 0 ? null : sa22, (i3 & 64) != 0 ? TA5.c9 : i, (i3 & 128) != 0 ? TA5.secondary : i2);
    }

    static /* synthetic */ void c(InterfaceC12737f70 interfaceC12737f70, CharSequence charSequence, String str, String str2, SA2 sa2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInfoDialogWithCustomButtonWithTextAlignment");
        }
        if ((i2 & 8) != 0) {
            sa2 = null;
        }
        SA2 sa22 = sa2;
        if ((i2 & 16) != 0) {
            i = 4;
        }
        interfaceC12737f70.g(charSequence, str, str2, sa22, i);
    }

    static /* synthetic */ void f(InterfaceC12737f70 interfaceC12737f70, int i, int i2, SA2 sa2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNegativeDialog");
        }
        if ((i3 & 4) != 0) {
            sa2 = null;
        }
        interfaceC12737f70.e(i, i2, sa2);
    }

    static /* synthetic */ void k(InterfaceC12737f70 interfaceC12737f70, int i, int i2, SA2 sa2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPositiveDialog");
        }
        if ((i3 & 4) != 0) {
            sa2 = null;
        }
        interfaceC12737f70.j(i, i2, sa2);
    }

    static /* synthetic */ void l(InterfaceC12737f70 interfaceC12737f70, String str, String str2, SA2 sa2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNegativeDialog");
        }
        if ((i & 4) != 0) {
            sa2 = null;
        }
        interfaceC12737f70.h(str, str2, sa2);
    }

    void b(String str, String str2, String str3, String str4, SA2 sa2, SA2 sa22, int i, int i2);

    void d(String str, String str2, String str3, SA2 sa2);

    void e(int i, int i2, SA2 sa2);

    void g(CharSequence charSequence, String str, String str2, SA2 sa2, int i);

    void h(String str, String str2, SA2 sa2);

    void i(int i, int i2, SA2 sa2);

    void j(int i, int i2, SA2 sa2);
}
