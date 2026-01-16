package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C11044ce1;
import ir.nasim.C6399Nk7;
import ir.nasim.IY2;
import ir.nasim.InterfaceC14163hS7;

/* renamed from: ir.nasim.a00, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC9459a00 {

    /* renamed from: ir.nasim.a00$a */
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

    /* renamed from: ir.nasim.a00$b */
    public static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ C11044ce1 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ String h;
        final /* synthetic */ int i;
        final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11044ce1 c11044ce1, int i, SA2 sa2, String str, int i2, String str2) {
            super(2);
            this.f = c11044ce1;
            this.g = sa2;
            this.h = str;
            this.i = i2;
            this.j = str2;
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
            interfaceC22053ub1.W(-422020155);
            C11044ce1.b bVarK = c11044ce1.k();
            C7773Td1 c7773Td1A = bVarK.a();
            C7773Td1 c7773Td1B = bVarK.b();
            G10 g10 = G10.a;
            C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1, 6).o();
            long jD = g10.a(interfaceC22053ub1, 6).D();
            C6399Nk7.a aVar = C6399Nk7.b;
            int iB = aVar.b();
            e.a aVar2 = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(-567793760);
            boolean zV = interfaceC22053ub1.V(c7773Td1B);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new c(c7773Td1B);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC9339Zm7.b(this.h, c11044ce1.i(aVar2, c7773Td1A, (UA2) objB), jD, 0L, null, null, null, 0L, null, C6399Nk7.h(iB), 0L, 0, false, 1, 0, null, c9348Zn7O, interfaceC22053ub1, (this.i >> 6) & 14, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 56824);
            C9348Zn7 c9348Zn7O2 = g10.d(interfaceC22053ub1, 6).o();
            long jD2 = g10.a(interfaceC22053ub1, 6).D();
            int iF2 = aVar.f();
            int iB2 = AbstractC23365wn7.a.b();
            interfaceC22053ub1.W(-567774973);
            boolean zV2 = interfaceC22053ub1.V(c7773Td1A);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new d(c7773Td1A);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC9339Zm7.b(this.j, c11044ce1.i(aVar2, c7773Td1B, (UA2) objB2), jD2, 0L, null, null, null, 0L, null, C6399Nk7.h(iF2), 0L, iB2, false, 0, 0, null, c9348Zn7O2, interfaceC22053ub1, (this.i >> 3) & 14, 48, 62968);
            c11044ce1.e(new C7773Td1[]{c7773Td1A, c7773Td1B}, C14066hI0.c.a(0.5f));
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

    /* renamed from: ir.nasim.a00$c */
    static final class c implements UA2 {
        final /* synthetic */ C7773Td1 a;

        c(C7773Td1 c7773Td1) {
            this.a = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.b(), c7536Sd1.e().a(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), this.a.d(), C17784nZ1.q(8), 0.0f, 4, null);
            c7536Sd1.h(DT1.a.b());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.a00$d */
    static final class d implements UA2 {
        final /* synthetic */ C7773Td1 a;

        d(C7773Td1 c7773Td1) {
            this.a = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            InterfaceC14163hS7.a.a(c7536Sd1.f(), this.a.b(), C17784nZ1.q(8), 0.0f, 4, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.b(), c7536Sd1.e().a(), 0.0f, 0.0f, 6, null);
            c7536Sd1.h(DT1.a.a());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.compose.ui.e r23, java.lang.String r24, java.lang.String r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9459a00.c(androidx.compose.ui.e, java.lang.String, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.compose.ui.e eVar, String str, String str2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        c(eVar, str, str2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-460700621);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C15706k21.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.YZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9459a00.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
