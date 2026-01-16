package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C21097t63;
import ir.nasim.C21097t63.a;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.w63, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22957w63 {

    /* renamed from: ir.nasim.w63$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Object e;
        final /* synthetic */ C21097t63.a f;
        final /* synthetic */ Object g;
        final /* synthetic */ C20494s63 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, C21097t63.a aVar, Object obj2, C20494s63 c20494s63) {
            super(0);
            this.e = obj;
            this.f = aVar;
            this.g = obj2;
            this.h = c20494s63;
        }

        public final void a() {
            if (AbstractC13042fc3.d(this.e, this.f.i()) && AbstractC13042fc3.d(this.g, this.f.j())) {
                return;
            }
            this.f.F(this.e, this.g, this.h);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w63$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21097t63 e;
        final /* synthetic */ C21097t63.a f;

        /* renamed from: ir.nasim.w63$b$a */
        public static final class a implements KV1 {
            final /* synthetic */ C21097t63 a;
            final /* synthetic */ C21097t63.a b;

            public a(C21097t63 c21097t63, C21097t63.a aVar) {
                this.a = c21097t63;
                this.b = aVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.l(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C21097t63 c21097t63, C21097t63.a aVar) {
            super(1);
            this.e = c21097t63;
            this.f = aVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.f(this.f);
            return new a(this.e, this.f);
        }
    }

    public static final InterfaceC9664aL6 a(C21097t63 c21097t63, float f, float f2, C20494s63 c20494s63, String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        String str2 = (i2 & 8) != 0 ? "FloatAnimation" : str;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-644770905, i, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:296)");
        }
        int i3 = i << 3;
        InterfaceC9664aL6 interfaceC9664aL6B = b(c21097t63, Float.valueOf(f), Float.valueOf(f2), PQ7.d(C9361Zp2.a), c20494s63, str2, interfaceC22053ub1, (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896) | (57344 & i3) | (i3 & 458752), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6B;
    }

    public static final InterfaceC9664aL6 b(C21097t63 c21097t63, Object obj, Object obj2, InterfaceC5342Ix7 interfaceC5342Ix7, C20494s63 c20494s63, String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 16) != 0) {
            str = "ValueAnimation";
        }
        String str2 = str;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1062847727, i, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:245)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = c21097t63.new a(obj, obj2, interfaceC5342Ix7, c20494s63, str2);
            interfaceC22053ub1.s(objB);
        }
        C21097t63.a aVar2 = (C21097t63.a) objB;
        boolean z = true;
        boolean z2 = ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.D(obj)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.D(obj2)) || (i & 384) == 256);
        if ((((57344 & i) ^ 24576) <= 16384 || !interfaceC22053ub1.D(c20494s63)) && (i & 24576) != 16384) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objB2 = interfaceC22053ub1.B();
        if (z3 || objB2 == aVar.a()) {
            objB2 = new a(obj, aVar2, obj2, c20494s63);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.i((SA2) objB2, interfaceC22053ub1, 0);
        boolean zD = interfaceC22053ub1.D(c21097t63);
        Object objB3 = interfaceC22053ub1.B();
        if (zD || objB3 == aVar.a()) {
            objB3 = new b(c21097t63, aVar2);
            interfaceC22053ub1.s(objB3);
        }
        AbstractC10721c52.a(aVar2, (UA2) objB3, interfaceC22053ub1, 6);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return aVar2;
    }

    public static final C21097t63 c(String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            str = "InfiniteTransition";
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1013651573, i, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = new C21097t63(str);
            interfaceC22053ub1.s(objB);
        }
        C21097t63 c21097t63 = (C21097t63) objB;
        c21097t63.m(interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c21097t63;
    }
}
