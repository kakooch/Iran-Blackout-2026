package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C12531em1;

/* renamed from: ir.nasim.Nl1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6402Nl1 {

    /* renamed from: ir.nasim.Nl1$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C12531em1 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C12531em1 c12531em1, SA2 sa2, androidx.compose.ui.e eVar, UA2 ua2, int i, int i2) {
            super(2);
            this.e = c12531em1;
            this.f = sa2;
            this.g = eVar;
            this.h = ua2;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6402Nl1.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nl1$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C12531em1 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12531em1 c12531em1, SA2 sa2, androidx.compose.ui.e eVar, UA2 ua2, int i, int i2) {
            super(2);
            this.e = c12531em1;
            this.f = sa2;
            this.g = eVar;
            this.h = ua2;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6402Nl1.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nl1$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C12531em1 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ androidx.compose.ui.e h;
        final /* synthetic */ boolean i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C12531em1 c12531em1, SA2 sa2, UA2 ua2, androidx.compose.ui.e eVar, boolean z, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = c12531em1;
            this.f = sa2;
            this.g = ua2;
            this.h = eVar;
            this.i = z;
            this.j = sa22;
            this.k = interfaceC14603iB2;
            this.l = i;
            this.m = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6402Nl1.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nl1$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ C12531em1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SA2 sa2, C12531em1 c12531em1) {
            super(1);
            this.e = sa2;
            this.f = c12531em1;
        }

        public final void a(long j) {
            this.e.invoke();
            this.f.b(new C12531em1.a.b(j, null));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    public static final void a(C12531em1 c12531em1, SA2 sa2, androidx.compose.ui.e eVar, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(645832757);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(c12531em1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if (interfaceC22053ub1J.o((i3 & 1171) != 1170, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(645832757, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.android.kt:73)");
            }
            C12531em1.a aVarA = c12531em1.a();
            if (!(aVarA instanceof C12531em1.a.b)) {
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new a(c12531em1, sa2, eVar, ua2, i, i2));
                    return;
                }
                return;
            }
            boolean zV = interfaceC22053ub1J.V(aVarA);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C9914am1(AbstractC22635va3.d(((C12531em1.a.b) aVarA).a()), null);
                interfaceC22053ub1J.s(objB);
            }
            AbstractC13758gm1.d((C9914am1) objB, sa2, eVar, ua2, interfaceC22053ub1J, (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 896) | (i3 & 7168), 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        androidx.compose.ui.e eVar2 = eVar;
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new b(c12531em1, sa2, eVar2, ua2, i, i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.C12531em1 r18, ir.nasim.SA2 r19, ir.nasim.UA2 r20, androidx.compose.ui.e r21, boolean r22, ir.nasim.SA2 r23, ir.nasim.InterfaceC14603iB2 r24, ir.nasim.InterfaceC22053ub1 r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6402Nl1.b(ir.nasim.em1, ir.nasim.SA2, ir.nasim.UA2, androidx.compose.ui.e, boolean, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* renamed from: ir.nasim.Nl1$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }
}
