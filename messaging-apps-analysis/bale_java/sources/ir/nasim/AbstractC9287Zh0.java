package ir.nasim;

import androidx.compose.foundation.BorderModifierNodeElement;

/* renamed from: ir.nasim.Zh0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9287Zh0 {

    /* renamed from: ir.nasim.Zh0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zh0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC12520el0 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ AbstractC18051o02 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC12520el0 abstractC12520el0, long j, long j2, AbstractC18051o02 abstractC18051o02) {
            super(1);
            this.e = abstractC12520el0;
            this.f = j;
            this.g = j2;
            this.h = abstractC18051o02;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
            InterfaceC17460n02.y0(interfaceC23919xk1, this.e, this.f, this.g, 0.0f, this.h, null, 0, 104, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, C10493bi0 c10493bi0, InterfaceC10031ax6 interfaceC10031ax6) {
        return g(eVar, c10493bi0.b(), c10493bi0.a(), interfaceC10031ax6);
    }

    public static final androidx.compose.ui.e f(androidx.compose.ui.e eVar, float f, long j, InterfaceC10031ax6 interfaceC10031ax6) {
        return g(eVar, f, new CH6(j, null), interfaceC10031ax6);
    }

    public static final androidx.compose.ui.e g(androidx.compose.ui.e eVar, float f, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6) {
        return eVar.i(new BorderModifierNodeElement(f, abstractC12520el0, interfaceC10031ax6, null));
    }

    private static final I46 h(float f, I46 i46) {
        return new I46(f, f, i46.j() - f, i46.d() - f, l(i46.h(), f), l(i46.i(), f), l(i46.c(), f), l(i46.b(), f), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V05 i(V05 v05, I46 i46, float f, boolean z) {
        v05.reset();
        V05.p(v05, i46, null, 2, null);
        if (!z) {
            V05 v05A = AbstractC21611tq.a();
            V05.p(v05A, h(f, i46), null, 2, null);
            v05.m(v05, v05A, AbstractC19837r15.a.a());
        }
        return v05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16869m02 j(C14988ip0 c14988ip0) {
        return c14988ip0.h(a.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16869m02 k(C14988ip0 c14988ip0, AbstractC12520el0 abstractC12520el0, long j, long j2, boolean z, float f) {
        return c14988ip0.h(new b(abstractC12520el0, z ? ZG4.b.c() : j, z ? c14988ip0.d() : j2, z ? C8568Wn2.a : new C23815xZ6(f, 0.0f, 0, 0, null, 30, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j, float f) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return AbstractC8567Wn1.b((Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L));
    }
}
