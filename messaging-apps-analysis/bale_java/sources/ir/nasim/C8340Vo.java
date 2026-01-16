package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Vo, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8340Vo implements InterfaceC14124hO4 {
    private final WH1 a;
    private long b;
    private final C10085b32 c;
    private final InterfaceC9102Ym4 d;
    private boolean e;
    private boolean f;
    private long g;
    private long h;
    private final InterfaceC22335v37 i;
    private final JG1 j;

    /* renamed from: ir.nasim.Vo$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C8340Vo.this.c(0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Vo$b */
    static final class b implements PointerInputEventHandler {

        /* renamed from: ir.nasim.Vo$b$a */
        static final class a extends V06 implements InterfaceC14603iB2 {
            int a;
            private /* synthetic */ Object b;
            final /* synthetic */ C8340Vo c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8340Vo c8340Vo, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8340Vo;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.c, interfaceC20295rm1);
                aVar.b = obj;
                return aVar;
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00ad A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005c -> B:17:0x005f). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    Method dump skipped, instructions count: 226
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8340Vo.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b() {
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new a(C8340Vo.this, null), interfaceC20295rm1);
            return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
        }
    }

    public /* synthetic */ C8340Vo(Context context, WH1 wh1, long j, TS4 ts4, ED1 ed1) {
        this(context, wh1, j, ts4);
    }

    private final void g() {
        boolean z;
        C10085b32 c10085b32 = this.c;
        EdgeEffect edgeEffect = c10085b32.d;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = c10085b32.e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = c10085b32.f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = c10085b32.g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            k();
        }
    }

    private final float l(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (i() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g & 4294967295L));
        EdgeEffect edgeEffectG = this.c.g();
        Z22 z22 = Z22.a;
        return z22.c(edgeEffectG) == 0.0f ? (-z22.e(edgeEffectG, -fIntBitsToFloat2, 1 - fIntBitsToFloat)) * Float.intBitsToFloat((int) (this.g & 4294967295L)) : Float.intBitsToFloat(i);
    }

    private final float m(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (i() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g >> 32));
        EdgeEffect edgeEffectI = this.c.i();
        Z22 z22 = Z22.a;
        return z22.c(edgeEffectI) == 0.0f ? z22.e(edgeEffectI, fIntBitsToFloat2, 1 - fIntBitsToFloat) * Float.intBitsToFloat((int) (this.g >> 32)) : Float.intBitsToFloat(i);
    }

    private final float n(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (i() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g >> 32));
        EdgeEffect edgeEffectK = this.c.k();
        Z22 z22 = Z22.a;
        return z22.c(edgeEffectK) == 0.0f ? (-z22.e(edgeEffectK, -fIntBitsToFloat2, fIntBitsToFloat)) * Float.intBitsToFloat((int) (this.g >> 32)) : Float.intBitsToFloat(i);
    }

    private final float o(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (i() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g & 4294967295L));
        EdgeEffect edgeEffectM = this.c.m();
        Z22 z22 = Z22.a;
        return z22.c(edgeEffectM) == 0.0f ? z22.e(edgeEffectM, fIntBitsToFloat2, fIntBitsToFloat) * Float.intBitsToFloat((int) (this.g & 4294967295L)) : Float.intBitsToFloat(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean p(long r11) {
        /*
            r10 = this;
            ir.nasim.b32 r0 = r10.c
            boolean r0 = r0.s()
            r1 = 32
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L2d
            long r4 = r11 >> r1
            int r0 = (int) r4
            float r4 = java.lang.Float.intBitsToFloat(r0)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L2d
            ir.nasim.Z22 r4 = ir.nasim.Z22.a
            ir.nasim.b32 r5 = r10.c
            android.widget.EdgeEffect r5 = r5.i()
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r4.f(r5, r0)
            ir.nasim.b32 r0 = r10.c
            boolean r0 = r0.s()
            goto L2e
        L2d:
            r0 = r3
        L2e:
            ir.nasim.b32 r4 = r10.c
            boolean r4 = r4.v()
            r5 = 1
            if (r4 == 0) goto L5f
            long r6 = r11 >> r1
            int r1 = (int) r6
            float r4 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 <= 0) goto L5f
            ir.nasim.Z22 r4 = ir.nasim.Z22.a
            ir.nasim.b32 r6 = r10.c
            android.widget.EdgeEffect r6 = r6.k()
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r4.f(r6, r1)
            if (r0 != 0) goto L5e
            ir.nasim.b32 r0 = r10.c
            boolean r0 = r0.v()
            if (r0 == 0) goto L5c
            goto L5e
        L5c:
            r0 = r3
            goto L5f
        L5e:
            r0 = r5
        L5f:
            ir.nasim.b32 r1 = r10.c
            boolean r1 = r1.z()
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r1 == 0) goto L94
            long r8 = r11 & r6
            int r1 = (int) r8
            float r4 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L94
            ir.nasim.Z22 r4 = ir.nasim.Z22.a
            ir.nasim.b32 r8 = r10.c
            android.widget.EdgeEffect r8 = r8.m()
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r4.f(r8, r1)
            if (r0 != 0) goto L93
            ir.nasim.b32 r0 = r10.c
            boolean r0 = r0.z()
            if (r0 == 0) goto L91
            goto L93
        L91:
            r0 = r3
            goto L94
        L93:
            r0 = r5
        L94:
            ir.nasim.b32 r1 = r10.c
            boolean r1 = r1.p()
            if (r1 == 0) goto Lc1
            long r11 = r11 & r6
            int r11 = (int) r11
            float r12 = java.lang.Float.intBitsToFloat(r11)
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 <= 0) goto Lc1
            ir.nasim.Z22 r12 = ir.nasim.Z22.a
            ir.nasim.b32 r1 = r10.c
            android.widget.EdgeEffect r1 = r1.g()
            float r11 = java.lang.Float.intBitsToFloat(r11)
            r12.f(r1, r11)
            if (r0 != 0) goto Lbf
            ir.nasim.b32 r11 = r10.c
            boolean r11 = r11.p()
            if (r11 == 0) goto Lc0
        Lbf:
            r3 = r5
        Lc0:
            r0 = r3
        Lc1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8340Vo.p(long):boolean");
    }

    @Override // ir.nasim.InterfaceC14124hO4
    public boolean a() {
        C10085b32 c10085b32 = this.c;
        EdgeEffect edgeEffect = c10085b32.d;
        if (edgeEffect != null && Z22.a.c(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = c10085b32.e;
        if (edgeEffect2 != null && Z22.a.c(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = c10085b32.f;
        if (edgeEffect3 != null && Z22.a.c(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = c10085b32.g;
        return (edgeEffect4 == null || Z22.a.c(edgeEffect4) == 0.0f) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[PHI: r11
      0x00b8: PHI (r11v9 float) = (r11v8 float), (r11v12 float) binds: [B:43:0x00e9, B:32:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0132 A[PHI: r14
      0x0132: PHI (r14v9 float) = (r14v8 float), (r14v12 float) binds: [B:67:0x0162, B:56:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0207  */
    @Override // ir.nasim.InterfaceC14124hO4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long b(long r18, int r20, ir.nasim.UA2 r21) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8340Vo.b(long, int, ir.nasim.UA2):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC14124hO4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(long r12, ir.nasim.InterfaceC14603iB2 r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8340Vo.c(long, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC14124hO4
    public JG1 h() {
        return this.j;
    }

    public final long i() {
        long jB = this.b;
        if ((9223372034707292159L & jB) == 9205357640488583168L) {
            jB = UD6.b(this.g);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32)) / Float.intBitsToFloat((int) (this.g >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jB & 4294967295L)) / Float.intBitsToFloat((int) (this.g & 4294967295L));
        return ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final InterfaceC9102Ym4 j() {
        return this.d;
    }

    public final void k() {
        if (this.e) {
            this.d.setValue(C19938rB7.a);
        }
    }

    public final void q(long j) {
        boolean zF = OD6.f(this.g, OD6.b.b());
        boolean z = !OD6.f(j, this.g);
        this.g = j;
        if (z) {
            this.c.C(C4414Fa3.c((AbstractC20723sV3.d(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (AbstractC20723sV3.d(Float.intBitsToFloat((int) (j >> 32))) << 32)));
        }
        if (zF || !z) {
            return;
        }
        g();
    }

    private C8340Vo(Context context, WH1 wh1, long j, TS4 ts4) {
        this.a = wh1;
        this.b = ZG4.b.b();
        C10085b32 c10085b32 = new C10085b32(context, DX0.k(j));
        this.c = c10085b32;
        this.d = AbstractC10222bH6.h(C19938rB7.a, AbstractC10222bH6.j());
        this.e = true;
        this.g = OD6.b.b();
        this.h = AbstractC6122Mg5.a(-1L);
        InterfaceC22335v37 interfaceC22335v37A = AbstractC21071t37.a(new b());
        this.i = interfaceC22335v37A;
        this.j = Build.VERSION.SDK_INT >= 31 ? new C23806xY6(interfaceC22335v37A, this, c10085b32) : new C24851zJ2(interfaceC22335v37A, this, c10085b32, ts4);
    }
}
