package ir.nasim;

import ir.nasim.AbstractC15520jj2;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.List;

/* renamed from: ir.nasim.fj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC13138fj2 {
    void A(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2);

    void B(C5886Lg2 c5886Lg2);

    default void C(C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c8755Xe4, "itemMid");
    }

    void b(long j, String str, long j2, long j3);

    default void c(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c8755Xe4, "itemMid");
        AbstractC13042fc3.i(c5886Lg2, "feed");
    }

    boolean d();

    boolean e(String str);

    void f(J44 j44, C11458d25 c11458d25, C5886Lg2 c5886Lg2);

    void g(AbstractC15520jj2.h hVar, AbstractC13019fa0 abstractC13019fa0);

    void h(C11458d25 c11458d25, List list, XH6 xh6, C5886Lg2 c5886Lg2, C4743Gj2 c4743Gj2);

    void i(C5886Lg2 c5886Lg2);

    void j(J44 j44);

    void k(C11458d25 c11458d25, long j, C8755Xe4 c8755Xe4);

    void l(int i);

    void m(boolean z, C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2);

    void n();

    void o();

    default InterfaceC13730gj3 p(AbstractC15520jj2.h hVar) {
        AbstractC13042fc3.i(hVar, "feedVideoMessage");
        return null;
    }

    boolean q();

    void r(FileReference fileReference, int i, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22);

    void s(String str);

    void t();

    void u();

    void v(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2);

    void w(C4743Gj2 c4743Gj2);

    void x(C11458d25 c11458d25, J44 j44, C5886Lg2 c5886Lg2);

    void y(int i, C8755Xe4 c8755Xe4);

    void z(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2);

    default void a() {
    }
}
