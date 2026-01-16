package ir.nasim;

import ir.nasim.C5203Ii3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Gy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4883Gy7 {
    public static final Object a(InterfaceC8551Wl3 interfaceC8551Wl3, Object obj, boolean z) {
        AbstractC13042fc3.i(interfaceC8551Wl3, "<this>");
        AbstractC13042fc3.i(obj, "possiblyPrimitiveType");
        return z ? interfaceC8551Wl3.b(obj) : obj;
    }

    public static final Object b(InterfaceC5819Ky7 interfaceC5819Ky7, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC8551Wl3 interfaceC8551Wl3, C21696ty7 c21696ty7) {
        AbstractC13042fc3.i(interfaceC5819Ky7, "<this>");
        AbstractC13042fc3.i(interfaceC5050Hr3, "type");
        AbstractC13042fc3.i(interfaceC8551Wl3, "typeFactory");
        AbstractC13042fc3.i(c21696ty7, "mode");
        InterfaceC14475hy7 interfaceC14475hy7G = interfaceC5819Ky7.g(interfaceC5050Hr3);
        if (!interfaceC5819Ky7.A(interfaceC14475hy7G)) {
            return null;
        }
        EnumC4809Gq5 enumC4809Gq5S = interfaceC5819Ky7.S(interfaceC14475hy7G);
        if (enumC4809Gq5S != null) {
            return a(interfaceC8551Wl3, interfaceC8551Wl3.e(enumC4809Gq5S), interfaceC5819Ky7.P(interfaceC5050Hr3) || AbstractC16855ly7.b(interfaceC5819Ky7, interfaceC5050Hr3));
        }
        EnumC4809Gq5 enumC4809Gq5O = interfaceC5819Ky7.O(interfaceC14475hy7G);
        if (enumC4809Gq5O != null) {
            return interfaceC8551Wl3.a(AbstractC13042fc3.q("[", EnumC7376Rl3.j(enumC4809Gq5O).q()));
        }
        if (interfaceC5819Ky7.r(interfaceC14475hy7G)) {
            C10027ax2 c10027ax2N = interfaceC5819Ky7.N(interfaceC14475hy7G);
            C24948zU0 c24948zU0O = c10027ax2N == null ? null : C5203Ii3.a.o(c10027ax2N);
            if (c24948zU0O != null) {
                if (!c21696ty7.a()) {
                    List listJ = C5203Ii3.a.j();
                    if (!(listJ instanceof Collection) || !listJ.isEmpty()) {
                        Iterator it = listJ.iterator();
                        while (it.hasNext()) {
                            if (AbstractC13042fc3.d(((C5203Ii3.a) it.next()).d(), c24948zU0O)) {
                                return null;
                            }
                        }
                    }
                }
                String strF = C4996Hl3.b(c24948zU0O).f();
                AbstractC13042fc3.h(strF, "byClassId(classId).internalName");
                return interfaceC8551Wl3.d(strF);
            }
        }
        return null;
    }
}
