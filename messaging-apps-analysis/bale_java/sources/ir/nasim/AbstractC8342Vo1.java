package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.Vo1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8342Vo1 {

    /* renamed from: ir.nasim.Vo1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ C6399Nk7 b;
        final /* synthetic */ C9348Zn7 c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ long g;

        a(androidx.compose.ui.e eVar, C6399Nk7 c6399Nk7, C9348Zn7 c9348Zn7, String str, String str2, String str3, long j) {
            this.a = eVar;
            this.b = c6399Nk7;
            this.c = c9348Zn7;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = j;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVar = this.a;
            InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
            C6399Nk7 c6399Nk7 = this.b;
            C9348Zn7 c9348Zn7 = this.c;
            String str = this.d;
            String str2 = this.e;
            String str3 = this.f;
            long j = this.g;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC9339Zm7.b(AbstractC12152e76.d("88:88:88", interfaceC22053ub1, 6), null, C24381yX0.b.h(), 0L, null, null, null, 0L, null, c6399Nk7, 0L, 0, false, 0, 0, null, c9348Zn7, interfaceC22053ub1, 384, 0, 65018);
            AbstractC9339Zm7.b(AbstractC12152e76.d(str + ":" + str2 + ":" + str3, interfaceC22053ub1, 0), null, j, 0L, null, null, null, 0L, null, c6399Nk7, 0L, 0, false, 0, 0, null, c9348Zn7, interfaceC22053ub1, 0, 0, 65018);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vo1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC23352wm4 c;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC23352wm4 interfaceC23352wm4, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC23352wm4;
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            while (this.c.getLongValue() > 0) {
                InterfaceC23352wm4 interfaceC23352wm4 = this.c;
                interfaceC23352wm4.w(AbstractC23053wG5.f(interfaceC23352wm4.getLongValue() - this.d, 0L));
                long j = this.d;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final long r26, androidx.compose.ui.e r28, ir.nasim.C9348Zn7 r29, ir.nasim.C6399Nk7 r30, long r31, final ir.nasim.SA2 r33, ir.nasim.InterfaceC22053ub1 r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8342Vo1.c(long, androidx.compose.ui.e, ir.nasim.Zn7, ir.nasim.Nk7, long, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    public static final void d(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(377698346);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, S31.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.To1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8342Vo1.e(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        d(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final long f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(long j, androidx.compose.ui.e eVar, C9348Zn7 c9348Zn7, C6399Nk7 c6399Nk7, long j2, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onCountdownEnded");
        c(j, eVar, c9348Zn7, c6399Nk7, j2, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final InterfaceC9102Ym4 h(long j, long j2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        interfaceC22053ub1.W(1298136712);
        if ((i2 & 2) != 0) {
            j2 = 1000;
        }
        interfaceC22053ub1.W(-1587344098);
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = WG6.a(j);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC23352wm4 interfaceC23352wm4 = (InterfaceC23352wm4) objB;
        interfaceC22053ub1.Q();
        Long lValueOf = Long.valueOf(j);
        Long lValueOf2 = Long.valueOf(j2);
        interfaceC22053ub1.W(-1587340431);
        int i3 = i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        boolean z = ((i3 ^ 48) > 32 && interfaceC22053ub1.f(j2)) || (i & 48) == 32;
        Object objB2 = interfaceC22053ub1.B();
        if (z || objB2 == aVar.a()) {
            objB2 = new b(interfaceC23352wm4, j2, null);
            interfaceC22053ub1.s(objB2);
        }
        interfaceC22053ub1.Q();
        AbstractC10721c52.f(lValueOf, lValueOf2, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i & 14) | i3);
        interfaceC22053ub1.Q();
        return interfaceC23352wm4;
    }
}
