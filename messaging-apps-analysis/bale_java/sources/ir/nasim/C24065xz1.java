package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.xz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24065xz1 {
    public static final C24065xz1 a = new C24065xz1();

    private C24065xz1() {
    }

    public final InterfaceC23475wz1 a(InterfaceC25168zq6 interfaceC25168zq6, KO5 ko5, List list, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC25168zq6, "serializer");
        AbstractC13042fc3.i(list, "migrations");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(sa2, "produceFile");
        return new C23027wD6(sa2, interfaceC25168zq6, AbstractC9766aX0.e(AbstractC12067dz1.a.b(list)), new KA4(), interfaceC20315ro1);
    }
}
