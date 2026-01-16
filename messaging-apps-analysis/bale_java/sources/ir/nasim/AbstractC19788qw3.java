package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.qw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19788qw3 {

    /* renamed from: ir.nasim.qw3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC20397rw3 e;
        final /* synthetic */ int f;
        final /* synthetic */ Object g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC20397rw3 interfaceC20397rw3, int i, Object obj) {
            super(2);
            this.e = interfaceC20397rw3;
            this.f = i;
            this.g = obj;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(980966366, i, -1, "androidx.compose.foundation.lazy.layout.SkippableItem.<anonymous> (LazyLayoutItemContentFactory.kt:129)");
            }
            this.e.i(this.f, this.g, interfaceC22053ub1, 0);
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

    /* renamed from: ir.nasim.qw3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC20397rw3 e;
        final /* synthetic */ Object f;
        final /* synthetic */ int g;
        final /* synthetic */ Object h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC20397rw3 interfaceC20397rw3, Object obj, int i, Object obj2, int i2) {
            super(2);
            this.e = interfaceC20397rw3;
            this.f = obj;
            this.g = i;
            this.h = obj2;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC19788qw3.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC20397rw3 interfaceC20397rw3, Object obj, int i, Object obj2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1439843069);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(interfaceC20397rw3) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(obj) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(obj2) ? 2048 : 1024;
        }
        if (interfaceC22053ub1J.o((i3 & 1171) != 1170, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1439843069, i3, -1, "androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:127)");
            }
            ((InterfaceC9809ab6) obj).b(obj2, AbstractC19242q11.e(980966366, true, new a(interfaceC20397rw3, i, obj2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(interfaceC20397rw3, obj, i, obj2, i2));
        }
    }
}
