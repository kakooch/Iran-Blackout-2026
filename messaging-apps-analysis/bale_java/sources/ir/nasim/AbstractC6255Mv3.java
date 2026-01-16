package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Mv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6255Mv3 {
    private static final C23441wv3 a;

    /* renamed from: ir.nasim.Mv3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final List a(int i) {
            return AbstractC10360bX0.m();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.Mv3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2) {
            super(0);
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6021Lv3 invoke() {
            return new C6021Lv3(this.e, this.f);
        }
    }

    static {
        a aVar = new a();
        List listM = AbstractC10360bX0.m();
        EnumC24286yM4 enumC24286yM4 = EnumC24286yM4.a;
        a = new C23441wv3(null, 0, false, 0.0f, aVar, 0.0f, false, AbstractC20906so1.a(C18712p72.a), YH1.b(1.0f, 0.0f, 2, null), 0, b.e, listM, 0, 0, 0, false, enumC24286yM4, 0, 0);
    }

    public static final C6021Lv3 b(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(29186956, i3, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:74)");
        }
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = C6021Lv3.x.a();
        boolean z = ((((i3 & 14) ^ 6) > 4 && interfaceC22053ub1.e(i)) || (i3 & 6) == 4) | ((((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i2)) || (i3 & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new c(i, i2);
            interfaceC22053ub1.s(objB);
        }
        C6021Lv3 c6021Lv3 = (C6021Lv3) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c6021Lv3;
    }

    /* renamed from: ir.nasim.Mv3$a */
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
