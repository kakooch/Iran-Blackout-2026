package coil.compose;

import ir.nasim.AbstractC22917w23;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.T92;
import ir.nasim.TG3;
import ir.nasim.U92;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public abstract class e {
    public static final AsyncImagePainter a(Object obj, UA2 ua2, UA2 ua22, InterfaceC13157fl1 interfaceC13157fl1, int i, T92 t92, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        interfaceC22053ub1.A(236159766);
        UA2 ua2A = (i3 & 2) != 0 ? AsyncImagePainter.INSTANCE.a() : ua2;
        UA2 ua23 = (i3 & 4) != 0 ? null : ua22;
        InterfaceC13157fl1 interfaceC13157fl1E = (i3 & 8) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        int iB = (i3 & 16) != 0 ? InterfaceC17460n02.i0.b() : i;
        T92 t92A = (i3 & 32) != 0 ? U92.a() : t92;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(236159766, i2, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:133)");
        }
        int i4 = i2 << 3;
        AsyncImagePainter asyncImagePainterC = b.c(obj, AbstractC22917w23.c(TG3.a(), interfaceC22053ub1, 6), ua2A, ua23, interfaceC13157fl1E, iB, t92A, interfaceC22053ub1, (i4 & 896) | 72 | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (i4 & 3670016), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return asyncImagePainterC;
    }
}
