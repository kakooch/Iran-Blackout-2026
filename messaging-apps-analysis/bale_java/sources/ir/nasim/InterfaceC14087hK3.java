package ir.nasim;

/* renamed from: ir.nasim.hK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC14087hK3 extends InterfaceC17651nK3 {

    /* renamed from: ir.nasim.hK3$a */
    public static final class a {
        public static /* synthetic */ Object a(InterfaceC14087hK3 interfaceC14087hK3, C23677xK3 c23677xK3, int i, int i2, boolean z, float f, AbstractC23087wK3 abstractC23087wK3, float f2, boolean z2, EnumC22491vK3 enumC22491vK3, boolean z3, boolean z4, InterfaceC20295rm1 interfaceC20295rm1, int i3, Object obj) {
            AbstractC23087wK3 abstractC23087wK32;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animate");
            }
            int iT = (i3 & 2) != 0 ? interfaceC14087hK3.t() : i;
            int iQ = (i3 & 4) != 0 ? interfaceC14087hK3.q() : i2;
            boolean zP = (i3 & 8) != 0 ? interfaceC14087hK3.p() : z;
            float fR = (i3 & 16) != 0 ? interfaceC14087hK3.r() : f;
            if ((i3 & 32) != 0) {
                interfaceC14087hK3.v();
                abstractC23087wK32 = null;
            } else {
                abstractC23087wK32 = abstractC23087wK3;
            }
            return interfaceC14087hK3.g(c23677xK3, iT, iQ, zP, fR, abstractC23087wK32, (i3 & 64) != 0 ? AbstractC15287jK3.c(c23677xK3, abstractC23087wK32, fR) : f2, (i3 & 128) != 0 ? false : z2, (i3 & 256) != 0 ? EnumC22491vK3.a : enumC22491vK3, (i3 & 512) != 0 ? false : z3, (i3 & 1024) != 0 ? false : z4, interfaceC20295rm1);
        }

        public static /* synthetic */ Object b(InterfaceC14087hK3 interfaceC14087hK3, C23677xK3 c23677xK3, float f, int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: snapTo");
            }
            if ((i2 & 1) != 0) {
                c23677xK3 = interfaceC14087hK3.u();
            }
            C23677xK3 c23677xK32 = c23677xK3;
            if ((i2 & 2) != 0) {
                f = interfaceC14087hK3.b();
            }
            float f2 = f;
            if ((i2 & 4) != 0) {
                i = interfaceC14087hK3.t();
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z = !(f2 == interfaceC14087hK3.b());
            }
            return interfaceC14087hK3.k(c23677xK32, f2, i3, z, interfaceC20295rm1);
        }
    }

    Object g(C23677xK3 c23677xK3, int i, int i2, boolean z, float f, AbstractC23087wK3 abstractC23087wK3, float f2, boolean z2, EnumC22491vK3 enumC22491vK3, boolean z3, boolean z4, InterfaceC20295rm1 interfaceC20295rm1);

    Object k(C23677xK3 c23677xK3, float f, int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1);
}
