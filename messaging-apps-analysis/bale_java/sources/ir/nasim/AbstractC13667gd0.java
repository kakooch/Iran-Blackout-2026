package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C11044ce1;
import ir.nasim.IY2;
import ir.nasim.InterfaceC14163hS7;
import ir.nasim.InterfaceC22053ub1;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.gd0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13667gd0 {

    /* renamed from: ir.nasim.gd0$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C15395jW3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C15395jW3 c15395jW3) {
            super(1);
            this.e = c15395jW3;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC5756Kr7.a(interfaceC11943do6, this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$b */
    public static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ C11044ce1 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ String i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;
        final /* synthetic */ String l;
        final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11044ce1 c11044ce1, int i, SA2 sa2, SA2 sa22, String str, int i2, int i3, String str2, String str3) {
            super(2);
            this.f = c11044ce1;
            this.g = sa2;
            this.h = sa22;
            this.i = str;
            this.j = i2;
            this.k = i3;
            this.l = str2;
            this.m = str3;
            this.e = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (((i & 11) ^ 2) == 0 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int iF = this.f.f();
            this.f.g();
            C11044ce1 c11044ce1 = this.f;
            interfaceC22053ub1.W(-1934008976);
            C11044ce1.b bVarK = c11044ce1.k();
            C7773Td1 c7773Td1A = bVarK.a();
            C7773Td1 c7773Td1B = bVarK.b();
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(1461635432);
            boolean zV = interfaceC22053ub1.V(c7773Td1B);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new c(c7773Td1B);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarI = c11044ce1.i(aVar, c7773Td1A, (UA2) objB);
            interfaceC22053ub1.A(-270267587);
            interfaceC22053ub1.A(-3687241);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB2 == aVar2.a()) {
                objB2 = new C15395jW3();
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.U();
            C15395jW3 c15395jW3 = (C15395jW3) objB2;
            interfaceC22053ub1.A(-3687241);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar2.a()) {
                objB3 = new C11044ce1();
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.U();
            C11044ce1 c11044ce12 = (C11044ce1) objB3;
            interfaceC22053ub1.A(-3687241);
            Object objB4 = interfaceC22053ub1.B();
            if (objB4 == aVar2.a()) {
                objB4 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.U();
            XV4 xv4F = AbstractC9834ae1.f(Type.CAA, c11044ce12, (InterfaceC9102Ym4) objB4, c15395jW3, interfaceC22053ub1, 4544);
            AbstractC19768qu3.a(AbstractC6919Pn6.d(eVarI, false, new h(c15395jW3), 1, null), AbstractC19242q11.b(interfaceC22053ub1, -819894182, true, new i(c11044ce12, 0, (SA2) xv4F.b(), this.k, this.j, this.l, this.m)), (InterfaceC10970cW3) xv4F.a(), interfaceC22053ub1, 48, 0);
            interfaceC22053ub1.U();
            interfaceC22053ub1.W(1461686948);
            Object objB5 = interfaceC22053ub1.B();
            if (objB5 == aVar2.a()) {
                objB5 = g.a;
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarI2 = c11044ce1.i(aVar, c7773Td1B, (UA2) objB5);
            SA2 sa2 = this.h;
            String str = this.i;
            int i2 = this.j;
            AbstractC21592to0.b(eVarI2, sa2, str, false, interfaceC22053ub1, ((i2 >> 9) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i2 >> 3) & 896), 8);
            interfaceC22053ub1.Q();
            if (this.f.f() != iF) {
                this.g.invoke();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$c */
    static final class c implements UA2 {
        final /* synthetic */ C7773Td1 a;

        c(C7773Td1 c7773Td1) {
            this.a = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.b(), this.a.e(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$d */
    static final class d implements UA2 {
        public static final d a = new d();

        d() {
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$e */
    static final class e implements UA2 {
        final /* synthetic */ C7773Td1 a;

        e(C7773Td1 c7773Td1) {
            this.a = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), this.a.a(), C17784nZ1.q(32), 0.0f, 4, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$f */
    static final class f implements UA2 {
        final /* synthetic */ C7773Td1 a;

        f(C7773Td1 c7773Td1) {
            this.a = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), this.a.a(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$g */
    static final class g implements UA2 {
        public static final g a = new g();

        g() {
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.b(), c7536Sd1.e().a(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$h */
    public static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C15395jW3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(C15395jW3 c15395jW3) {
            super(1);
            this.e = c15395jW3;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC5756Kr7.a(interfaceC11943do6, this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gd0$i */
    public static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ C11044ce1 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ String j;
        final /* synthetic */ String k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(C11044ce1 c11044ce1, int i, SA2 sa2, int i2, int i3, String str, String str2) {
            super(2);
            this.f = c11044ce1;
            this.g = sa2;
            this.h = i2;
            this.i = i3;
            this.j = str;
            this.k = str2;
            this.e = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (((i & 11) ^ 2) == 0 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int iF = this.f.f();
            this.f.g();
            C11044ce1 c11044ce1 = this.f;
            interfaceC22053ub1.W(-43754711);
            C11044ce1.b bVarK = c11044ce1.k();
            C7773Td1 c7773Td1A = bVarK.a();
            C7773Td1 c7773Td1B = bVarK.b();
            C7773Td1 c7773Td1C = bVarK.c();
            int i2 = this.h;
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(414233901);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = d.a;
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC13667gd0.e(i2, c11044ce1.i(aVar, c7773Td1A, (UA2) objB), interfaceC22053ub1, this.i & 14, 0);
            interfaceC22053ub1.W(414241663);
            boolean zV = interfaceC22053ub1.V(c7773Td1A);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar2.a()) {
                objB2 = new e(c7773Td1A);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarI = c11044ce1.i(aVar, c7773Td1B, (UA2) objB2);
            C15386jV3 c15386jV3 = C15386jV3.a;
            int i3 = C15386jV3.b;
            AbstractC9339Zm7.b(this.j, eVarI, WX0.a(IA5.color9, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c15386jV3.c(interfaceC22053ub1, i3).h(), interfaceC22053ub1, (this.i >> 3) & 14, 0, 65528);
            C9348Zn7 c9348Zn7O = c15386jV3.c(interfaceC22053ub1, i3).o();
            interfaceC22053ub1.W(414259103);
            boolean zV2 = interfaceC22053ub1.V(c7773Td1B);
            Object objB3 = interfaceC22053ub1.B();
            if (zV2 || objB3 == aVar2.a()) {
                objB3 = new f(c7773Td1B);
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC9339Zm7.b(this.k, androidx.compose.foundation.layout.q.i(c11044ce1.i(aVar, c7773Td1C, (UA2) objB3), C17784nZ1.q(16)), WX0.a(IA5.color8, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, c9348Zn7O, interfaceC22053ub1, (this.i >> 6) & 14, 0, 65016);
            interfaceC22053ub1.Q();
            if (this.f.f() != iF) {
                this.g.invoke();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final int i2, final String str, final String str2, final String str3, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i3) {
        int i4;
        AbstractC13042fc3.i(str, "titleTxt");
        AbstractC13042fc3.i(str2, "descriptionTxt");
        AbstractC13042fc3.i(str3, "buttonText");
        AbstractC13042fc3.i(sa2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1139032392);
        if ((i3 & 6) == 0) {
            i4 = (interfaceC22053ub1J.e(i2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(str3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        int i5 = i4;
        if ((i5 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, WX0.a(IA5.color4, interfaceC22053ub1J, 0), null, 2, null);
            interfaceC22053ub1J.A(-270267587);
            interfaceC22053ub1J.A(-3687241);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C15395jW3();
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.U();
            C15395jW3 c15395jW3 = (C15395jW3) objB;
            interfaceC22053ub1J.A(-3687241);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new C11044ce1();
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.U();
            C11044ce1 c11044ce1 = (C11044ce1) objB2;
            interfaceC22053ub1J.A(-3687241);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.U();
            XV4 xv4F = AbstractC9834ae1.f(Type.CAA, c11044ce1, (InterfaceC9102Ym4) objB3, c15395jW3, interfaceC22053ub1J, 4544);
            AbstractC19768qu3.a(AbstractC6919Pn6.d(eVarD, false, new a(c15395jW3), 1, null), AbstractC19242q11.b(interfaceC22053ub1J, -819894182, true, new b(c11044ce1, 0, (SA2) xv4F.b(), sa2, str3, i5, i2, str, str2)), (InterfaceC10970cW3) xv4F.a(), interfaceC22053ub1J, 48, 0);
            interfaceC22053ub1J.U();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ed0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13667gd0.d(i2, str, str2, str3, sa2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(int i2, String str, String str2, String str3, SA2 sa2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$titleTxt");
        AbstractC13042fc3.i(str2, "$descriptionTxt");
        AbstractC13042fc3.i(str3, "$buttonText");
        AbstractC13042fc3.i(sa2, "$onClick");
        c(i2, str, str2, str3, sa2, interfaceC22053ub1, QJ5.a(i3 | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final int r24, androidx.compose.ui.e r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13667gd0.e(int, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i2, androidx.compose.ui.e eVar, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        e(i2, eVar, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }
}
