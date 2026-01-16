package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.qx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19797qx3 {
    private static final C11408cx3 a;

    /* renamed from: ir.nasim.qx3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2) {
            super(0);
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19206px3 invoke() {
            return new C19206px3(this.e, this.f);
        }
    }

    static {
        a aVar = new a();
        List listM = AbstractC10360bX0.m();
        EnumC24286yM4 enumC24286yM4 = EnumC24286yM4.a;
        int i = 0;
        boolean z = false;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z2 = false;
        a = new C11408cx3(null, i, z, f, aVar, f2, z2, AbstractC20906so1.a(C18712p72.a), YH1.b(1.0f, 0.0f, 2, null), AbstractC19606qe1.b(0, 0, 0, 0, 15, null), listM, 0, 0, 0, false, enumC24286yM4, 0, 0, null);
    }

    public static final C19206px3 b(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1470655220, i3, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:74)");
        }
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = C19206px3.x.a();
        boolean z = ((((i3 & 14) ^ 6) > 4 && interfaceC22053ub1.e(i)) || (i3 & 6) == 4) | ((((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i2)) || (i3 & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new b(i, i2);
            interfaceC22053ub1.s(objB);
        }
        C19206px3 c19206px3 = (C19206px3) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c19206px3;
    }

    /* renamed from: ir.nasim.qx3$a */
    public static final class a implements InterfaceC11734dW3 {
        private final int a;
        private final int b;
        private final Map c = AbstractC20051rO3.k();

        a() {
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public int getHeight() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public int getWidth() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public Map t() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public void j() {
        }
    }
}
