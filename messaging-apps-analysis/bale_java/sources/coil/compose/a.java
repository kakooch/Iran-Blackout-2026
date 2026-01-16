package coil.compose;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C20213re1;
import ir.nasim.DG7;
import ir.nasim.FV0;
import ir.nasim.GK;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.QJ5;
import ir.nasim.SA2;
import ir.nasim.T92;
import ir.nasim.U92;
import ir.nasim.UA2;
import ir.nasim.W23;
import ir.nasim.ZD6;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: coil.compose.a$a, reason: collision with other inner class name */
    static final class C0141a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
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
        final /* synthetic */ int p;
        final /* synthetic */ int q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0141a(GK gk, String str, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, boolean z, int i2, int i3) {
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
            this.p = i2;
            this.q = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            a.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, interfaceC22053ub1, QJ5.a(this.p | 1), QJ5.a(this.q));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            return this.e.invoke();
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ AsyncImagePainter f;
        final /* synthetic */ String g;
        final /* synthetic */ InterfaceC12529em h;
        final /* synthetic */ InterfaceC13157fl1 i;
        final /* synthetic */ float j;
        final /* synthetic */ AbstractC24975zX0 k;
        final /* synthetic */ boolean l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(androidx.compose.ui.e eVar, AsyncImagePainter asyncImagePainter, String str, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, boolean z, int i) {
            super(2);
            this.e = eVar;
            this.f = asyncImagePainter;
            this.g = str;
            this.h = interfaceC12529em;
            this.i = interfaceC13157fl1;
            this.j = f;
            this.k = abstractC24975zX0;
            this.l = z;
            this.m = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            a.c(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC22053ub1, QJ5.a(this.m | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GK gk, String str, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        int i4;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-421592773);
        if ((i2 & 14) == 0) {
            i4 = (interfaceC22053ub1J.V(gk) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= interfaceC22053ub1J.V(eVar) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 57344) == 0) {
            i4 |= interfaceC22053ub1J.D(ua22) ? 16384 : 8192;
        }
        if ((i2 & 458752) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC12529em) ? 131072 : 65536;
        }
        if ((i2 & 3670016) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC13157fl1) ? 1048576 : 524288;
        }
        if ((i2 & 29360128) == 0) {
            i4 |= interfaceC22053ub1J.c(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i2) == 0) {
            i4 |= interfaceC22053ub1J.V(abstractC24975zX0) ? 67108864 : 33554432;
        }
        if ((i2 & 1879048192) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 536870912 : 268435456;
        }
        if ((i3 & 14) == 0) {
            i5 = i3 | (interfaceC22053ub1J.a(z) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i4 & 1533916891) == 306783378 && (i5 & 11) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-421592773, i4, i5, "coil.compose.AsyncImage (AsyncImage.kt:213)");
            }
            W23 w23H = g.h(gk.b(), interfaceC13157fl1, interfaceC22053ub1J, ((i4 >> 15) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8);
            int i6 = i4 >> 3;
            int i7 = (i6 & 896) | 72 | (i6 & 7168);
            int i8 = i4 >> 6;
            int i9 = i8 & 57344;
            int i10 = i5;
            int i11 = i4;
            AsyncImagePainter asyncImagePainterC = coil.compose.b.c(w23H, gk.a(), ua2, ua22, interfaceC13157fl1, i, gk.c(), interfaceC22053ub1J, i7 | i9 | ((i4 >> 12) & 458752), 0);
            ZD6 zd6K = w23H.K();
            c(zd6K instanceof C20213re1 ? eVar.i((androidx.compose.ui.e) zd6K) : eVar, asyncImagePainterC, str, interfaceC12529em, interfaceC13157fl1, f, abstractC24975zX0, z, interfaceC22053ub1J, ((i11 << 3) & 896) | (i8 & 7168) | i9 | (i8 & 458752) | (i8 & 3670016) | ((i10 << 21) & 29360128));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new C0141a(gk, str, eVar, ua2, ua22, interfaceC12529em, interfaceC13157fl1, f, abstractC24975zX0, i, z, i2, i3));
        }
    }

    public static final void b(Object obj, String str, InterfaceC18663p23 interfaceC18663p23, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, boolean z, T92 t92, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3, int i4) {
        interfaceC22053ub1.A(2032051394);
        androidx.compose.ui.e eVar2 = (i4 & 8) != 0 ? androidx.compose.ui.e.a : eVar;
        UA2 ua2A = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.a() : ua2;
        UA2 ua23 = (i4 & 32) != 0 ? null : ua22;
        InterfaceC12529em interfaceC12529emE = (i4 & 64) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        InterfaceC13157fl1 interfaceC13157fl1E = (i4 & 128) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        AbstractC24975zX0 abstractC24975zX02 = (i4 & 512) != 0 ? null : abstractC24975zX0;
        int iB = (i4 & 1024) != 0 ? InterfaceC17460n02.i0.b() : i;
        boolean z2 = (i4 & 2048) != 0 ? true : z;
        T92 t92A = (i4 & 4096) != 0 ? U92.a() : t92;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(2032051394, i2, i3, "coil.compose.AsyncImage (AsyncImage.kt:157)");
        }
        int i5 = i2 >> 3;
        a(new GK(obj, t92A, interfaceC18663p23), str, eVar2, ua2A, ua23, interfaceC12529emE, interfaceC13157fl1E, f2, abstractC24975zX02, iB, z2, interfaceC22053ub1, (i5 & 234881024) | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | ((i3 << 27) & 1879048192), (i3 >> 3) & 14);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(androidx.compose.ui.e eVar, AsyncImagePainter asyncImagePainter, String str, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(777774312);
        if ((i & 14) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(asyncImagePainter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= interfaceC22053ub1J.V(interfaceC12529em) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(interfaceC13157fl1) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= interfaceC22053ub1J.c(f) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(abstractC24975zX0) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 8388608 : 4194304;
        }
        if ((23967451 & i2) == 4793490 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(777774312, i2, -1, "coil.compose.Content (AsyncImage.kt:259)");
            }
            androidx.compose.ui.e eVarC = g.c(eVar, str);
            if (z) {
                eVarC = FV0.b(eVarC);
            }
            androidx.compose.ui.e eVarI = eVarC.i(new ContentPainterElement(asyncImagePainter, interfaceC12529em, interfaceC13157fl1, f, abstractC24975zX0));
            c cVar = c.a;
            interfaceC22053ub1J.A(544976794);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            interfaceC22053ub1J.A(1405779621);
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(new b(sa2A));
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, cVar, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.U();
            interfaceC22053ub1J.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new d(eVar, asyncImagePainter, str, interfaceC12529em, interfaceC13157fl1, f, abstractC24975zX0, z, i));
        }
    }

    static final class c implements InterfaceC10970cW3 {
        public static final c a = new c();

        c() {
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.n(j), C17833ne1.m(j), null, C0142a.e, 4, null);
        }

        /* renamed from: coil.compose.a$c$a, reason: collision with other inner class name */
        static final class C0142a extends AbstractC8614Ws3 implements UA2 {
            public static final C0142a e = new C0142a();

            C0142a() {
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
