package ir.nasim;

import java.util.HashSet;

/* renamed from: ir.nasim.se2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20807se2 {
    public static final InterfaceC5050Hr3 a(InterfaceC5819Ky7 interfaceC5819Ky7, InterfaceC5050Hr3 interfaceC5050Hr3) {
        AbstractC13042fc3.i(interfaceC5819Ky7, "<this>");
        AbstractC13042fc3.i(interfaceC5050Hr3, "inlineClassType");
        return b(interfaceC5819Ky7, interfaceC5050Hr3, new HashSet());
    }

    private static final InterfaceC5050Hr3 b(InterfaceC5819Ky7 interfaceC5819Ky7, InterfaceC5050Hr3 interfaceC5050Hr3, HashSet hashSet) {
        InterfaceC5050Hr3 interfaceC5050Hr3B;
        InterfaceC14475hy7 interfaceC14475hy7G = interfaceC5819Ky7.g(interfaceC5050Hr3);
        if (!hashSet.add(interfaceC14475hy7G)) {
            return null;
        }
        InterfaceC24062xy7 interfaceC24062xy7J = interfaceC5819Ky7.j(interfaceC14475hy7G);
        if (interfaceC24062xy7J != null) {
            interfaceC5050Hr3B = b(interfaceC5819Ky7, interfaceC5819Ky7.p(interfaceC24062xy7J), hashSet);
            if (interfaceC5050Hr3B == null) {
                return null;
            }
            if (!interfaceC5819Ky7.P(interfaceC5050Hr3B) && interfaceC5819Ky7.f(interfaceC5050Hr3)) {
                return interfaceC5819Ky7.x(interfaceC5050Hr3B);
            }
        } else {
            if (!interfaceC5819Ky7.c0(interfaceC14475hy7G)) {
                return interfaceC5050Hr3;
            }
            InterfaceC5050Hr3 interfaceC5050Hr3D = interfaceC5819Ky7.D(interfaceC5050Hr3);
            if (interfaceC5050Hr3D == null || (interfaceC5050Hr3B = b(interfaceC5819Ky7, interfaceC5050Hr3D, hashSet)) == null) {
                return null;
            }
            if (interfaceC5819Ky7.P(interfaceC5050Hr3)) {
                return interfaceC5819Ky7.P(interfaceC5050Hr3B) ? interfaceC5050Hr3 : ((interfaceC5050Hr3B instanceof ZC6) && interfaceC5819Ky7.Z((ZC6) interfaceC5050Hr3B)) ? interfaceC5050Hr3 : interfaceC5819Ky7.x(interfaceC5050Hr3B);
            }
        }
        return interfaceC5050Hr3B;
    }
}
