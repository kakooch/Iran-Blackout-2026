package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC23457wx1;

/* renamed from: ir.nasim.wx1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23457wx1 {
    private static final float a = C17784nZ1.q(56);
    private static final float b = C17784nZ1.q(125);

    /* renamed from: ir.nasim.wx1$a */
    static final class a implements PointerInputEventHandler {
        final /* synthetic */ SA2 a;

        a(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(SA2 sa2, ZG4 zg4) {
            AbstractC13042fc3.i(sa2, "$onDismiss");
            sa2.invoke();
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final SA2 sa2 = this.a;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.vx1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC23457wx1.a.b(sa2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    public static final void e(final long j, final SA2 sa2, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        androidx.compose.ui.e eVarC;
        AbstractC13042fc3.i(sa2, "onDismiss");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-552018023);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.f(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (j != 16) {
            final InterfaceC9664aL6 interfaceC9664aL6D = AbstractC4572Fs.d(z ? 1.0f : 0.0f, new C7479Rw7(0, 0, null, 7, null), 0.0f, null, null, interfaceC22053ub1J, 48, 28);
            interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.f());
            final Resources resources = ((Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g())).getResources();
            interfaceC22053ub1J.W(916397008);
            if (z) {
                e.a aVar = androidx.compose.ui.e.a;
                interfaceC22053ub1J.W(916399075);
                int i4 = i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                boolean z2 = i4 == 32;
                Object objB = interfaceC22053ub1J.B();
                if (z2 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new a(sa2);
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarC2 = AbstractC21071t37.c(aVar, sa2, (PointerInputEventHandler) objB);
                interfaceC22053ub1J.W(916402137);
                boolean zD = (i4 == 32) | interfaceC22053ub1J.D(resources);
                Object objB2 = interfaceC22053ub1J.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.rx1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC23457wx1.g(resources, sa2, (InterfaceC11943do6) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                eVarC = AbstractC6919Pn6.c(eVarC2, true, (UA2) objB2);
            } else {
                eVarC = androidx.compose.ui.e.a;
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null).i(eVarC);
            interfaceC22053ub1J.W(916414381);
            boolean zV = ((i3 & 14) == 4) | interfaceC22053ub1J.V(interfaceC9664aL6D);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.sx1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC23457wx1.i(j, interfaceC9664aL6D, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC22443vF0.a(eVarI, (UA2) objB3, interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.tx1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23457wx1.j(j, sa2, z, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float f(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(Resources resources, final SA2 sa2, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(sa2, "$onDismiss");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.e0(interfaceC11943do6, resources.getString(WD5.close_sheet));
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.ux1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC23457wx1.h(sa2));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDismiss");
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(long j, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$alpha$delegate");
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        InterfaceC17460n02.C1(interfaceC17460n02, j, 0L, 0L, AbstractC23053wG5.l(f(interfaceC9664aL6), 0.0f, 1.0f), null, null, 0, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(long j, SA2 sa2, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDismiss");
        e(j, sa2, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
