package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC20375ru1;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.Rp4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7413Rp4 {

    /* renamed from: ir.nasim.Rp4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9809ab6 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9809ab6 interfaceC9809ab6, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = interfaceC9809ab6;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-52928304, i, -1, "androidx.navigation.compose.LocalOwnersProvider.<anonymous> (NavBackStackEntryProvider.kt:51)");
            }
            AbstractC7413Rp4.b(this.e, this.f, interfaceC22053ub1, ((this.g >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 8);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Rp4$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.navigation.d e;
        final /* synthetic */ InterfaceC9809ab6 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.navigation.d dVar, InterfaceC9809ab6 interfaceC9809ab6, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = dVar;
            this.f = interfaceC9809ab6;
            this.g = interfaceC14603iB2;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7413Rp4.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Rp4$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9809ab6 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9809ab6 interfaceC9809ab6, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = interfaceC9809ab6;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7413Rp4.b(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.navigation.d dVar, InterfaceC9809ab6 interfaceC9809ab6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1579360880);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1579360880, i, -1, "androidx.navigation.compose.LocalOwnersProvider (NavBackStackEntryProvider.kt:45)");
        }
        AbstractC11024cc1.b(new C7252Qx5[]{C24834zH3.a.b(dVar), AndroidCompositionLocals_androidKt.getLocalLifecycleOwner().d(dVar), AndroidCompositionLocals_androidKt.j().d(dVar)}, AbstractC19242q11.b(interfaceC22053ub1J, -52928304, true, new a(interfaceC9809ab6, interfaceC14603iB2, i)), interfaceC22053ub1J, 56);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M == null) {
            return;
        }
        interfaceC20208rd6M.a(new b(dVar, interfaceC9809ab6, interfaceC14603iB2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(InterfaceC9809ab6 interfaceC9809ab6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1211832233);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1211832233, i, -1, "androidx.navigation.compose.SaveableStateProvider (NavBackStackEntryProvider.kt:56)");
        }
        interfaceC22053ub1J.A(1729797275);
        InterfaceC15408jX7 interfaceC15408jX7A = C24834zH3.a.a(interfaceC22053ub1J, 6);
        if (interfaceC15408jX7A == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        VW7 vw7E = ZW7.e(VV.class, interfaceC15408jX7A, null, null, interfaceC15408jX7A instanceof androidx.lifecycle.h ? ((androidx.lifecycle.h) interfaceC15408jX7A).p3() : AbstractC20375ru1.a.b, interfaceC22053ub1J, 36936, 0);
        interfaceC22053ub1J.U();
        VV vv = (VV) vw7E;
        vv.S0(new WeakReference(interfaceC9809ab6));
        interfaceC9809ab6.b(vv.P0(), interfaceC14603iB2, interfaceC22053ub1J, (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 520);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M == null) {
            return;
        }
        interfaceC20208rd6M.a(new c(interfaceC9809ab6, interfaceC14603iB2, i));
    }
}
