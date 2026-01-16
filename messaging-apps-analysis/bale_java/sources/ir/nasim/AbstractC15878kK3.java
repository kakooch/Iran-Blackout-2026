package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.InterfaceC22053ub1;
import java.util.Map;

/* renamed from: ir.nasim.kK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15878kK3 {

    /* renamed from: ir.nasim.kK3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C23677xK3 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ boolean j;
        final /* synthetic */ boolean k;
        final /* synthetic */ QN5 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ InterfaceC12529em n;
        final /* synthetic */ InterfaceC13157fl1 o;
        final /* synthetic */ boolean p;
        final /* synthetic */ boolean q;
        final /* synthetic */ Map r;
        final /* synthetic */ GL s;
        final /* synthetic */ boolean t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C23677xK3 c23677xK3, SA2 sa2, androidx.compose.ui.e eVar, boolean z, boolean z2, boolean z3, boolean z4, QN5 qn5, boolean z5, RK3 rk3, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, boolean z6, boolean z7, Map map, GL gl, boolean z8, int i, int i2, int i3) {
            super(2);
            this.e = c23677xK3;
            this.f = sa2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = z3;
            this.k = z4;
            this.l = qn5;
            this.m = z5;
            this.n = interfaceC12529em;
            this.o = interfaceC13157fl1;
            this.p = z6;
            this.q = z7;
            this.r = map;
            this.s = gl;
            this.t = z8;
            this.u = i;
            this.v = i2;
            this.w = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC15878kK3.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, null, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v), this.w);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Rect e;
        final /* synthetic */ InterfaceC13157fl1 f;
        final /* synthetic */ InterfaceC12529em g;
        final /* synthetic */ Matrix h;
        final /* synthetic */ com.airbnb.lottie.q i;
        final /* synthetic */ boolean j;
        final /* synthetic */ boolean k;
        final /* synthetic */ QN5 l;
        final /* synthetic */ GL m;
        final /* synthetic */ C23677xK3 n;
        final /* synthetic */ Map o;
        final /* synthetic */ boolean p;
        final /* synthetic */ boolean q;
        final /* synthetic */ boolean r;
        final /* synthetic */ boolean s;
        final /* synthetic */ boolean t;
        final /* synthetic */ boolean u;
        final /* synthetic */ Context v;
        final /* synthetic */ SA2 w;
        final /* synthetic */ InterfaceC9102Ym4 x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Rect rect, InterfaceC13157fl1 interfaceC13157fl1, InterfaceC12529em interfaceC12529em, Matrix matrix, com.airbnb.lottie.q qVar, boolean z, boolean z2, QN5 qn5, GL gl, C23677xK3 c23677xK3, Map map, RK3 rk3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Context context, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            super(1);
            this.e = rect;
            this.f = interfaceC13157fl1;
            this.g = interfaceC12529em;
            this.h = matrix;
            this.i = qVar;
            this.j = z;
            this.k = z2;
            this.l = qn5;
            this.m = gl;
            this.n = c23677xK3;
            this.o = map;
            this.p = z3;
            this.q = z4;
            this.r = z5;
            this.s = z6;
            this.t = z7;
            this.u = z8;
            this.v = context;
            this.w = sa2;
            this.x = interfaceC9102Ym4;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
            Rect rect = this.e;
            InterfaceC13157fl1 interfaceC13157fl1 = this.f;
            InterfaceC12529em interfaceC12529em = this.g;
            Matrix matrix = this.h;
            com.airbnb.lottie.q qVar = this.i;
            boolean z = this.j;
            boolean z2 = this.k;
            QN5 qn5 = this.l;
            GL gl = this.m;
            C23677xK3 c23677xK3 = this.n;
            Map map = this.o;
            boolean z3 = this.p;
            boolean z4 = this.q;
            boolean z5 = this.r;
            boolean z6 = this.s;
            boolean z7 = this.t;
            boolean z8 = this.u;
            Context context = this.v;
            SA2 sa2 = this.w;
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.x;
            UE0 ue0E = interfaceC17460n02.z1().e();
            long jA = UD6.a(rect.width(), rect.height());
            long jA2 = AbstractC4663Ga3.a(AbstractC20723sV3.d(OD6.i(interfaceC17460n02.d())), AbstractC20723sV3.d(OD6.g(interfaceC17460n02.d())));
            long jA3 = interfaceC13157fl1.a(jA, interfaceC17460n02.d());
            long jA4 = interfaceC12529em.a(AbstractC15878kK3.h(jA, jA3), jA2, interfaceC17460n02.getLayoutDirection());
            matrix.reset();
            matrix.preTranslate(C22045ua3.k(jA4), C22045ua3.l(jA4));
            matrix.preScale(AbstractC16045kc6.b(jA3), AbstractC16045kc6.c(jA3));
            qVar.E(SK3.MergePathsApi19, z);
            qVar.o1(z2);
            qVar.l1(qn5);
            qVar.M0(gl);
            qVar.P0(c23677xK3);
            qVar.S0(map);
            AbstractC15878kK3.e(interfaceC9102Ym4);
            qVar.i1(z3);
            qVar.K0(z4);
            qVar.L0(z5);
            qVar.X0(z6);
            qVar.O0(z7);
            qVar.N0(z8);
            NO3 no3V = qVar.V();
            if (qVar.u(context) || no3V == null) {
                qVar.k1(((Number) sa2.invoke()).floatValue());
            } else {
                qVar.k1(no3V.b);
            }
            qVar.setBounds(0, 0, rect.width(), rect.height());
            qVar.B(AbstractC7624Sn.d(ue0E), matrix);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK3$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C23677xK3 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ boolean j;
        final /* synthetic */ boolean k;
        final /* synthetic */ QN5 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ InterfaceC12529em n;
        final /* synthetic */ InterfaceC13157fl1 o;
        final /* synthetic */ boolean p;
        final /* synthetic */ boolean q;
        final /* synthetic */ Map r;
        final /* synthetic */ GL s;
        final /* synthetic */ boolean t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23677xK3 c23677xK3, SA2 sa2, androidx.compose.ui.e eVar, boolean z, boolean z2, boolean z3, boolean z4, QN5 qn5, boolean z5, RK3 rk3, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, boolean z6, boolean z7, Map map, GL gl, boolean z8, int i, int i2, int i3) {
            super(2);
            this.e = c23677xK3;
            this.f = sa2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = z3;
            this.k = z4;
            this.l = qn5;
            this.m = z5;
            this.n = interfaceC12529em;
            this.o = interfaceC13157fl1;
            this.p = z6;
            this.q = z7;
            this.r = map;
            this.s = gl;
            this.t = z8;
            this.u = i;
            this.v = i2;
            this.w = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC15878kK3.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, null, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v), this.w);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kK3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC17651nK3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC17651nK3 interfaceC17651nK3) {
            super(0);
            this.e = interfaceC17651nK3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(AbstractC15878kK3.d(this.e));
        }
    }

    /* renamed from: ir.nasim.kK3$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int A;
        final /* synthetic */ int B;
        final /* synthetic */ C23677xK3 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;
        final /* synthetic */ float i;
        final /* synthetic */ int j;
        final /* synthetic */ boolean k;
        final /* synthetic */ boolean l;
        final /* synthetic */ boolean m;
        final /* synthetic */ boolean n;
        final /* synthetic */ QN5 o;
        final /* synthetic */ boolean p;
        final /* synthetic */ boolean q;
        final /* synthetic */ InterfaceC12529em r;
        final /* synthetic */ InterfaceC13157fl1 s;
        final /* synthetic */ boolean t;
        final /* synthetic */ boolean u;
        final /* synthetic */ Map v;
        final /* synthetic */ boolean w;
        final /* synthetic */ GL x;
        final /* synthetic */ int y;
        final /* synthetic */ int z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C23677xK3 c23677xK3, androidx.compose.ui.e eVar, boolean z, boolean z2, AbstractC23087wK3 abstractC23087wK3, float f, int i, boolean z3, boolean z4, boolean z5, boolean z6, QN5 qn5, boolean z7, boolean z8, RK3 rk3, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, boolean z9, boolean z10, Map map, boolean z11, GL gl, int i2, int i3, int i4, int i5) {
            super(2);
            this.e = c23677xK3;
            this.f = eVar;
            this.g = z;
            this.h = z2;
            this.i = f;
            this.j = i;
            this.k = z3;
            this.l = z4;
            this.m = z5;
            this.n = z6;
            this.o = qn5;
            this.p = z7;
            this.q = z8;
            this.r = interfaceC12529em;
            this.s = interfaceC13157fl1;
            this.t = z9;
            this.u = z10;
            this.v = map;
            this.w = z11;
            this.x = gl;
            this.y = i2;
            this.z = i3;
            this.A = i4;
            this.B = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC15878kK3.a(this.e, this.f, this.g, this.h, null, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, null, this.r, this.s, this.t, this.u, this.v, this.w, this.x, interfaceC22053ub1, QJ5.a(this.y | 1), QJ5.a(this.z), QJ5.a(this.A), this.B);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(C23677xK3 c23677xK3, androidx.compose.ui.e eVar, boolean z, boolean z2, AbstractC23087wK3 abstractC23087wK3, float f, int i, boolean z3, boolean z4, boolean z5, boolean z6, QN5 qn5, boolean z7, boolean z8, RK3 rk3, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, boolean z9, boolean z10, Map map, boolean z11, GL gl, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3, int i4, int i5) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1331239405);
        androidx.compose.ui.e eVar2 = (i5 & 2) != 0 ? androidx.compose.ui.e.a : eVar;
        boolean z12 = (i5 & 4) != 0 ? true : z;
        boolean z13 = (i5 & 8) != 0 ? true : z2;
        AbstractC23087wK3 abstractC23087wK32 = (i5 & 16) != 0 ? null : abstractC23087wK3;
        float f2 = (i5 & 32) != 0 ? 1.0f : f;
        int i6 = (i5 & 64) != 0 ? 1 : i;
        boolean z14 = (i5 & 128) != 0 ? false : z3;
        boolean z15 = (i5 & 256) != 0 ? false : z4;
        boolean z16 = (i5 & 512) != 0 ? true : z5;
        boolean z17 = (i5 & 1024) != 0 ? false : z6;
        QN5 qn52 = (i5 & 2048) != 0 ? QN5.AUTOMATIC : qn5;
        boolean z18 = (i5 & 4096) != 0 ? false : z7;
        boolean z19 = (i5 & 8192) != 0 ? false : z8;
        RK3 rk32 = (i5 & 16384) != 0 ? null : rk3;
        InterfaceC12529em interfaceC12529emE = (i5 & 32768) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        InterfaceC13157fl1 interfaceC13157fl1E = (i5 & 65536) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        boolean z20 = (i5 & 131072) != 0 ? true : z9;
        boolean z21 = (i5 & 262144) != 0 ? false : z10;
        Map map2 = (i5 & 524288) != 0 ? null : map;
        boolean z22 = (1048576 & i5) != 0 ? false : z11;
        GL gl2 = (2097152 & i5) != 0 ? GL.AUTOMATIC : gl;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1331239405, i2, i3, "com.airbnb.lottie.compose.LottieAnimation (LottieAnimation.kt:224)");
        }
        int i7 = i2 >> 3;
        InterfaceC17651nK3 interfaceC17651nK3C = AbstractC4821Gs.c(c23677xK3, z12, z13, z18, abstractC23087wK32, f2, i6, null, false, false, interfaceC22053ub1J, (i7 & 896) | (i7 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8 | ((i3 << 3) & 7168) | (i2 & 57344) | (i2 & 458752) | (i2 & 3670016), 896);
        interfaceC22053ub1J.A(185157769);
        boolean zV = interfaceC22053ub1J.V(interfaceC17651nK3C);
        Object objB = interfaceC22053ub1J.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new d(interfaceC17651nK3C);
            interfaceC22053ub1J.s(objB);
        }
        interfaceC22053ub1J.U();
        int i8 = i2 >> 12;
        int i9 = ((i2 << 3) & 896) | 1073741832 | (i8 & 7168) | (57344 & i8) | (i8 & 458752);
        int i10 = i3 << 18;
        int i11 = i9 | (i10 & 3670016) | (i10 & 29360128) | ((i3 << 15) & 234881024);
        int i12 = i3 >> 15;
        b(c23677xK3, (SA2) objB, eVar2, z14, z15, z16, z17, qn52, z19, rk32, interfaceC12529emE, interfaceC13157fl1E, z20, z21, map2, gl2, z22, interfaceC22053ub1J, i11, (i12 & 7168) | (i12 & 14) | 32768 | (i12 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i12 & 896) | ((i4 << 12) & 458752) | ((i4 << 18) & 3670016), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new e(c23677xK3, eVar2, z12, z13, abstractC23087wK32, f2, i6, z14, z15, z16, z17, qn52, z18, z19, rk32, interfaceC12529emE, interfaceC13157fl1E, z20, z21, map2, z22, gl2, i2, i3, i4, i5));
        }
    }

    public static final void b(C23677xK3 c23677xK3, SA2 sa2, androidx.compose.ui.e eVar, boolean z, boolean z2, boolean z3, boolean z4, QN5 qn5, boolean z5, RK3 rk3, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, boolean z6, boolean z7, Map map, GL gl, boolean z8, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3) {
        AbstractC13042fc3.i(sa2, "progress");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(382909894);
        androidx.compose.ui.e eVar2 = (i3 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        boolean z9 = (i3 & 8) != 0 ? false : z;
        boolean z10 = (i3 & 16) != 0 ? false : z2;
        boolean z11 = (i3 & 32) != 0 ? true : z3;
        boolean z12 = (i3 & 64) != 0 ? false : z4;
        QN5 qn52 = (i3 & 128) != 0 ? QN5.AUTOMATIC : qn5;
        boolean z13 = (i3 & 256) != 0 ? false : z5;
        RK3 rk32 = (i3 & 512) != 0 ? null : rk3;
        InterfaceC12529em interfaceC12529emE = (i3 & 1024) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        InterfaceC13157fl1 interfaceC13157fl1E = (i3 & 2048) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        boolean z14 = (i3 & 4096) != 0 ? true : z6;
        boolean z15 = (i3 & 8192) != 0 ? false : z7;
        Map map2 = (i3 & 16384) != 0 ? null : map;
        GL gl2 = (32768 & i3) != 0 ? GL.AUTOMATIC : gl;
        boolean z16 = (65536 & i3) != 0 ? false : z8;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(382909894, i, i2, "com.airbnb.lottie.compose.LottieAnimation (LottieAnimation.kt:97)");
        }
        interfaceC22053ub1J.A(185152185);
        Object objB = interfaceC22053ub1J.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = new com.airbnb.lottie.q();
            interfaceC22053ub1J.s(objB);
        }
        com.airbnb.lottie.q qVar = (com.airbnb.lottie.q) objB;
        interfaceC22053ub1J.U();
        interfaceC22053ub1J.A(185152232);
        Object objB2 = interfaceC22053ub1J.B();
        if (objB2 == aVar.a()) {
            objB2 = new Matrix();
            interfaceC22053ub1J.s(objB2);
        }
        Matrix matrix = (Matrix) objB2;
        interfaceC22053ub1J.U();
        interfaceC22053ub1J.A(185152312);
        boolean zV = interfaceC22053ub1J.V(c23677xK3);
        Object objB3 = interfaceC22053ub1J.B();
        if (zV || objB3 == aVar.a()) {
            objB3 = AbstractC13472gH6.d(null, null, 2, null);
            interfaceC22053ub1J.s(objB3);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB3;
        interfaceC22053ub1J.U();
        interfaceC22053ub1J.A(185152364);
        if (c23677xK3 == null || c23677xK3.d() == 0.0f) {
            androidx.compose.ui.e eVar3 = eVar2;
            androidx.compose.foundation.layout.f.a(eVar3, interfaceC22053ub1J, (i >> 6) & 14);
            interfaceC22053ub1J.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new a(c23677xK3, sa2, eVar3, z9, z10, z11, z12, qn52, z13, rk32, interfaceC12529emE, interfaceC13157fl1E, z14, z15, map2, gl2, z16, i, i2, i3));
                return;
            }
            return;
        }
        interfaceC22053ub1J.U();
        Rect rectB = c23677xK3.b();
        androidx.compose.ui.e eVar4 = eVar2;
        AbstractC22443vF0.a(AbstractC17060mK3.a(eVar2, rectB.width(), rectB.height()), new b(rectB, interfaceC13157fl1E, interfaceC12529emE, matrix, qVar, z12, z16, qn52, gl2, c23677xK3, map2, rk32, z9, z10, z11, z13, z14, z15, (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g()), sa2, interfaceC9102Ym4), interfaceC22053ub1J, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new c(c23677xK3, sa2, eVar4, z9, z10, z11, z12, qn52, z13, rk32, interfaceC12529emE, interfaceC13157fl1E, z14, z15, map2, gl2, z16, i, i2, i3));
        }
    }

    private static final RK3 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC18350oW3.a(interfaceC9102Ym4.getValue());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(InterfaceC17651nK3 interfaceC17651nK3) {
        return ((Number) interfaceC17651nK3.getValue()).floatValue();
    }

    public static final /* synthetic */ RK3 e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        c(interfaceC9102Ym4);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h(long j, long j2) {
        return AbstractC4663Ga3.a((int) (OD6.i(j) * AbstractC16045kc6.b(j2)), (int) (OD6.g(j) * AbstractC16045kc6.c(j2)));
    }
}
