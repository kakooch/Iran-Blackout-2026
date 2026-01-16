package coil.compose;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C20213re1;
import ir.nasim.EV4;
import ir.nasim.GK;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16978mB2;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC5920Lk0;
import ir.nasim.QJ5;
import ir.nasim.RZ6;
import ir.nasim.SA2;
import ir.nasim.T92;
import ir.nasim.U92;
import ir.nasim.UA2;
import ir.nasim.V91;
import ir.nasim.ZD6;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class f {

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ ZD6 e;
        final /* synthetic */ InterfaceC15796kB2 f;
        final /* synthetic */ AsyncImagePainter g;
        final /* synthetic */ String h;
        final /* synthetic */ InterfaceC12529em i;
        final /* synthetic */ InterfaceC13157fl1 j;
        final /* synthetic */ float k;
        final /* synthetic */ AbstractC24975zX0 l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ZD6 zd6, InterfaceC15796kB2 interfaceC15796kB2, AsyncImagePainter asyncImagePainter, String str, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, boolean z) {
            super(3);
            this.e = zd6;
            this.f = interfaceC15796kB2;
            this.g = asyncImagePainter;
            this.h = str;
            this.i = interfaceC12529em;
            this.j = interfaceC13157fl1;
            this.k = f;
            this.l = abstractC24975zX0;
            this.m = z;
        }

        public final void a(InterfaceC5920Lk0 interfaceC5920Lk0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 14) == 0) {
                i |= interfaceC22053ub1.V(interfaceC5920Lk0) ? 4 : 2;
            }
            if ((i & 91) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(748478484, i, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:274)");
            }
            ((C20213re1) this.e).k(interfaceC5920Lk0.d());
            this.f.q(new coil.compose.c(interfaceC5920Lk0, this.g, this.h, this.i, this.j, this.k, this.l, this.m), interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC5920Lk0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ GK e;
        final /* synthetic */ String f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ InterfaceC12529em j;
        final /* synthetic */ InterfaceC13157fl1 k;
        final /* synthetic */ float l;
        final /* synthetic */ AbstractC24975zX0 m;
        final /* synthetic */ int n;
        final /* synthetic */ boolean o;
        final /* synthetic */ InterfaceC15796kB2 p;
        final /* synthetic */ int q;
        final /* synthetic */ int r;
        final /* synthetic */ int s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(GK gk, String str, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, boolean z, InterfaceC15796kB2 interfaceC15796kB2, int i2, int i3, int i4) {
            super(2);
            this.e = gk;
            this.f = str;
            this.g = eVar;
            this.h = ua2;
            this.i = ua22;
            this.j = interfaceC12529em;
            this.k = interfaceC13157fl1;
            this.l = f;
            this.m = abstractC24975zX0;
            this.n = i;
            this.o = z;
            this.p = interfaceC15796kB2;
            this.q = i2;
            this.r = i3;
            this.s = i4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            f.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, interfaceC22053ub1, QJ5.a(this.q | 1), QJ5.a(this.r), this.s);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            return this.e.invoke();
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ RZ6 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ EV4 g;
        final /* synthetic */ String h;
        final /* synthetic */ InterfaceC12529em i;
        final /* synthetic */ InterfaceC13157fl1 j;
        final /* synthetic */ float k;
        final /* synthetic */ AbstractC24975zX0 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(RZ6 rz6, androidx.compose.ui.e eVar, EV4 ev4, String str, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, boolean z, int i, int i2) {
            super(2);
            this.e = rz6;
            this.f = eVar;
            this.g = ev4;
            this.h = str;
            this.i = interfaceC12529em;
            this.j = interfaceC13157fl1;
            this.k = f;
            this.l = abstractC24975zX0;
            this.m = z;
            this.n = i;
            this.o = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            f.c(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, interfaceC22053ub1, QJ5.a(this.n | 1), this.o);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: coil.compose.f$f, reason: collision with other inner class name */
    static final class C0143f extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC16978mB2 e;
        final /* synthetic */ InterfaceC16978mB2 f;
        final /* synthetic */ InterfaceC16978mB2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0143f(InterfaceC16978mB2 interfaceC16978mB2, InterfaceC16978mB2 interfaceC16978mB22, InterfaceC16978mB2 interfaceC16978mB23) {
            super(3);
            this.e = interfaceC16978mB2;
            this.f = interfaceC16978mB22;
            this.g = interfaceC16978mB23;
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(ir.nasim.RZ6 r14, ir.nasim.InterfaceC22053ub1 r15, int r16) {
            /*
                Method dump skipped, instructions count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: coil.compose.f.C0143f.a(ir.nasim.RZ6, ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((RZ6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Object obj, String str, InterfaceC18663p23 interfaceC18663p23, androidx.compose.ui.e eVar, UA2 ua2, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC16978mB2 interfaceC16978mB22, InterfaceC16978mB2 interfaceC16978mB23, UA2 ua22, UA2 ua23, UA2 ua24, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, boolean z, T92 t92, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3, int i4) {
        AbstractC24975zX0 abstractC24975zX02;
        interfaceC22053ub1.A(428575962);
        androidx.compose.ui.e eVar2 = (i4 & 8) != 0 ? androidx.compose.ui.e.a : eVar;
        UA2 ua2A = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.a() : ua2;
        InterfaceC16978mB2 interfaceC16978mB24 = (i4 & 32) != 0 ? null : interfaceC16978mB2;
        InterfaceC16978mB2 interfaceC16978mB25 = (i4 & 64) != 0 ? null : interfaceC16978mB22;
        InterfaceC16978mB2 interfaceC16978mB26 = (i4 & 128) != 0 ? null : interfaceC16978mB23;
        UA2 ua25 = (i4 & 256) != 0 ? null : ua22;
        UA2 ua26 = (i4 & 512) != 0 ? null : ua23;
        UA2 ua27 = (i4 & 1024) != 0 ? null : ua24;
        InterfaceC12529em interfaceC12529emE = (i4 & 2048) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        InterfaceC13157fl1 interfaceC13157fl1E = (i4 & 4096) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        AbstractC24975zX0 abstractC24975zX03 = (i4 & 16384) != 0 ? null : abstractC24975zX0;
        int iB = (i4 & 32768) != 0 ? InterfaceC17460n02.i0.b() : i;
        boolean z2 = (i4 & 65536) != 0 ? true : z;
        T92 t92A = (i4 & 131072) != 0 ? U92.a() : t92;
        if (AbstractC5138Ib1.I()) {
            abstractC24975zX02 = abstractC24975zX03;
            AbstractC5138Ib1.Q(428575962, i2, i3, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:75)");
        } else {
            abstractC24975zX02 = abstractC24975zX03;
        }
        int i5 = i2 >> 3;
        int i6 = i3 << 12;
        androidx.compose.ui.e eVar3 = eVar2;
        UA2 ua28 = ua2A;
        InterfaceC12529em interfaceC12529em2 = interfaceC12529emE;
        InterfaceC13157fl1 interfaceC13157fl12 = interfaceC13157fl1E;
        b(new GK(obj, t92A, interfaceC18663p23), str, eVar3, ua28, g.f(ua25, ua26, ua27), interfaceC12529em2, interfaceC13157fl12, f2, abstractC24975zX02, iB, z2, e(interfaceC16978mB24, interfaceC16978mB25, interfaceC16978mB26), interfaceC22053ub1, (i5 & 7168) | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i5 & 896) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i3 >> 18) & 14, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.GK r25, java.lang.String r26, androidx.compose.ui.e r27, ir.nasim.UA2 r28, ir.nasim.UA2 r29, ir.nasim.InterfaceC12529em r30, ir.nasim.InterfaceC13157fl1 r31, float r32, ir.nasim.AbstractC24975zX0 r33, int r34, boolean r35, ir.nasim.InterfaceC15796kB2 r36, ir.nasim.InterfaceC22053ub1 r37, int r38, int r39, int r40) {
        /*
            Method dump skipped, instructions count: 814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.f.b(ir.nasim.GK, java.lang.String, androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.em, ir.nasim.fl1, float, ir.nasim.zX0, int, boolean, ir.nasim.kB2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(ir.nasim.RZ6 r21, androidx.compose.ui.e r22, ir.nasim.EV4 r23, java.lang.String r24, ir.nasim.InterfaceC12529em r25, ir.nasim.InterfaceC13157fl1 r26, float r27, ir.nasim.AbstractC24975zX0 r28, boolean r29, ir.nasim.InterfaceC22053ub1 r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.f.c(ir.nasim.RZ6, androidx.compose.ui.e, ir.nasim.EV4, java.lang.String, ir.nasim.em, ir.nasim.fl1, float, ir.nasim.zX0, boolean, ir.nasim.ub1, int, int):void");
    }

    private static final InterfaceC15796kB2 e(InterfaceC16978mB2 interfaceC16978mB2, InterfaceC16978mB2 interfaceC16978mB22, InterfaceC16978mB2 interfaceC16978mB23) {
        return (interfaceC16978mB2 == null && interfaceC16978mB22 == null && interfaceC16978mB23 == null) ? V91.a.a() : AbstractC19242q11.c(-1302781228, true, new C0143f(interfaceC16978mB2, interfaceC16978mB22, interfaceC16978mB23));
    }

    static final class d implements InterfaceC10970cW3 {
        public static final d a = new d();

        d() {
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.n(j), C17833ne1.m(j), null, a.e, 4, null);
        }

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }

            public final void a(AbstractC21430te5.a aVar) {
            }
        }
    }
}
