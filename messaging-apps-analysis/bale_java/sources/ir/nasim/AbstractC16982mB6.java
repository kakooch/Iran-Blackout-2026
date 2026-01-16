package ir.nasim;

/* renamed from: ir.nasim.mB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16982mB6 {

    /* renamed from: ir.nasim.mB6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C16391lB6 invoke(C16391lB6 c16391lB6) {
            AbstractC13042fc3.i(c16391lB6, "$this$update");
            return c16391lB6.a(null, null, null, null, false, null);
        }
    }

    /* renamed from: ir.nasim.mB6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C16391lB6 invoke(C16391lB6 c16391lB6) {
            AbstractC13042fc3.i(c16391lB6, "$this$update");
            return C16391lB6.b(c16391lB6, null, null, null, null, false, null, 15, null);
        }
    }

    public static final void a(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "<this>");
        d(interfaceC9102Ym4, a.e);
    }

    public static final void b(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "<this>");
        d(interfaceC9102Ym4, b.e);
    }

    public static final boolean c(String str) {
        return AbstractC13042fc3.d(str, "COMPONENTS_IN_A_GROUP") || AbstractC13042fc3.d(str, "COLORS_IN_A_GROUP") || AbstractC13042fc3.d(str, "TYPOGRAPHY_IN_A_GROUP");
    }

    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "<this>");
        AbstractC13042fc3.i(ua2, "block");
        interfaceC9102Ym4.setValue(ua2.invoke(interfaceC9102Ym4.x()));
    }
}
