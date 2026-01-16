package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC22223us1;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.us1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC22223us1 {

    /* renamed from: ir.nasim.us1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ String b;

        /* renamed from: ir.nasim.us1$a$a, reason: collision with other inner class name */
        static final class C1640a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C1640a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                G10 g10 = G10.a;
                int i2 = G10.b;
                C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1, i2).b();
                AbstractC9339Zm7.b(this.a, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, c9348Zn7B, interfaceC22053ub1, 0, 0, 65018);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, String str) {
            this.a = sa2;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onButtonClicked");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarZ = androidx.compose.foundation.layout.t.z(androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().c(), 0.0f, 2, null), C17784nZ1.q(336), C17784nZ1.q(406));
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i2 = AbstractC24800zD5.OK;
            InterfaceC14603iB2 interfaceC14603iB2A = Z31.a.a();
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(558446812, true, new C1640a(this.b), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-170951196);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ts1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC22223us1.a.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, eVarZ, c1454b, (SA2) objB, i2, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final String str, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "bodyText");
        AbstractC13042fc3.i(sa2, "onButtonClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(341505860);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-2073461911);
            boolean z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.rs1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC22223us1.d(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC6687Oo.a((SA2) objB, new C18876pP1(false, false, false, 3, (ED1) null), AbstractC19242q11.e(600998285, true, new a(sa2, str), interfaceC22053ub1J, 54), interfaceC22053ub1J, 432, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ss1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22223us1.e(str, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onButtonClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(String str, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$bodyText");
        AbstractC13042fc3.i(sa2, "$onButtonClicked");
        c(str, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
