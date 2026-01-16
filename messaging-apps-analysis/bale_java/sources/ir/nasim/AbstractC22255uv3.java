package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.uv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22255uv3 {
    public static final int a(InterfaceC21665tv3 interfaceC21665tv3) {
        boolean z = interfaceC21665tv3.a() == EnumC24286yM4.a;
        List listI = interfaceC21665tv3.i();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < listI.size()) {
            int iB = b(z, interfaceC21665tv3, i);
            if (iB == -1) {
                i++;
            } else {
                int iMax = 0;
                while (i < listI.size() && b(z, interfaceC21665tv3, i) == iB) {
                    iMax = Math.max(iMax, (int) (z ? ((InterfaceC16823lv3) listI.get(i)).a() & 4294967295L : ((InterfaceC16823lv3) listI.get(i)).a() >> 32));
                    i++;
                }
                i2 += iMax;
                i3++;
            }
        }
        return (i2 / i3) + interfaceC21665tv3.h();
    }

    private static final int b(boolean z, InterfaceC21665tv3 interfaceC21665tv3, int i) {
        return z ? ((InterfaceC16823lv3) interfaceC21665tv3.i().get(i)).f() : ((InterfaceC16823lv3) interfaceC21665tv3.i().get(i)).b();
    }
}
