package ir.nasim;

/* renamed from: ir.nasim.iv5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15052iv5 {

    /* renamed from: ir.nasim.iv5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ InterfaceC10351bW0 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, InterfaceC10351bW0 interfaceC10351bW0, int i) {
            super(1);
            this.e = f;
            this.f = interfaceC10351bW0;
            this.g = i;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.o0(interfaceC11943do6, new C7932Tu5(((Number) AbstractC23053wG5.p(Float.valueOf(this.e), this.f)).floatValue(), this.f, this.g));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iv5$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.o0(interfaceC11943do6, C7932Tu5.d.a());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar) {
        return AbstractC6919Pn6.c(eVar, true, b.e);
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, float f, InterfaceC10351bW0 interfaceC10351bW0, int i) {
        return AbstractC6919Pn6.c(eVar, true, new a(f, interfaceC10351bW0, i));
    }

    public static /* synthetic */ androidx.compose.ui.e c(androidx.compose.ui.e eVar, float f, InterfaceC10351bW0 interfaceC10351bW0, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC10351bW0 = AbstractC22457vG5.b(0.0f, 1.0f);
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return b(eVar, f, interfaceC10351bW0, i);
    }
}
