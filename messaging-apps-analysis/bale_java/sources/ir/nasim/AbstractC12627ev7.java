package ir.nasim;

import ir.nasim.ZG4;
import java.util.List;

/* renamed from: ir.nasim.ev7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12627ev7 {

    /* renamed from: ir.nasim.ev7$a */
    static final class a extends V06 implements InterfaceC14603iB2 {
        float a;
        float b;
        float c;
        long d;
        int e;
        int f;
        int g;
        private /* synthetic */ Object h;
        final /* synthetic */ boolean i;
        final /* synthetic */ InterfaceC16978mB2 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = z;
            this.j = interfaceC16978mB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.i, this.j, interfaceC20295rm1);
            aVar.h = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0199  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00c2 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x009d -> B:17:0x00a0). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 452
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12627ev7.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private static final float a(long j) {
        if (Float.intBitsToFloat((int) (j >> 32)) == 0.0f && Float.intBitsToFloat((int) (j & 4294967295L)) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Float.intBitsToFloat(r0), Float.intBitsToFloat((int) (j & 4294967295L))))) * 180.0f) / 3.1415927f;
    }

    public static final long b(C3534Bg5 c3534Bg5, boolean z) {
        long jC = ZG4.b.c();
        List listC = c3534Bg5.c();
        int size = listC.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C6616Og5 c6616Og5 = (C6616Og5) listC.get(i2);
            if (c6616Og5.i() && c6616Og5.l()) {
                jC = ZG4.q(jC, z ? c6616Og5.h() : c6616Og5.k());
                i++;
            }
        }
        return i == 0 ? ZG4.b.b() : ZG4.h(jC, i);
    }

    public static final float c(C3534Bg5 c3534Bg5, boolean z) {
        long jB = b(c3534Bg5, z);
        float fK = 0.0f;
        if (ZG4.j(jB, ZG4.b.b())) {
            return 0.0f;
        }
        List listC = c3534Bg5.c();
        int size = listC.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C6616Og5 c6616Og5 = (C6616Og5) listC.get(i2);
            if (c6616Og5.i() && c6616Og5.l()) {
                fK += ZG4.k(ZG4.p(z ? c6616Og5.h() : c6616Og5.k(), jB));
                i++;
            }
        }
        return fK / i;
    }

    public static final long d(C3534Bg5 c3534Bg5) {
        long jB = b(c3534Bg5, true);
        ZG4.a aVar = ZG4.b;
        return ZG4.j(jB, aVar.b()) ? aVar.c() : ZG4.p(jB, b(c3534Bg5, false));
    }

    public static final float e(C3534Bg5 c3534Bg5) {
        List listC = c3534Bg5.c();
        int size = listC.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            C6616Og5 c6616Og5 = (C6616Og5) listC.get(i);
            if (!c6616Og5.l() || !c6616Og5.i()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long jB = b(c3534Bg5, true);
        long jB2 = b(c3534Bg5, false);
        List listC2 = c3534Bg5.c();
        int size2 = listC2.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            C6616Og5 c6616Og52 = (C6616Og5) listC2.get(i4);
            if (c6616Og52.i() && c6616Og52.l()) {
                long jH = c6616Og52.h();
                long jP = ZG4.p(c6616Og52.k(), jB2);
                long jP2 = ZG4.p(jH, jB);
                float fA = a(jP2) - a(jP);
                float fK = ZG4.k(ZG4.q(jP2, jP)) / 2.0f;
                if (fA > 180.0f) {
                    fA -= 360.0f;
                } else if (fA < -180.0f) {
                    fA += 360.0f;
                }
                f2 += fA * fK;
                f += fK;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public static final float f(C3534Bg5 c3534Bg5) {
        float fC = c(c3534Bg5, true);
        float fC2 = c(c3534Bg5, false);
        if (fC == 0.0f || fC2 == 0.0f) {
            return 1.0f;
        }
        return fC / fC2;
    }

    public static final Object g(InterfaceC9049Yg5 interfaceC9049Yg5, boolean z, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new a(z, interfaceC16978mB2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    public static /* synthetic */ Object h(InterfaceC9049Yg5 interfaceC9049Yg5, boolean z, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return g(interfaceC9049Yg5, z, interfaceC16978mB2, interfaceC20295rm1);
    }
}
