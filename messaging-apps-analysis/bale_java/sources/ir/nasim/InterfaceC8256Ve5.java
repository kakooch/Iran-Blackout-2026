package ir.nasim;

/* renamed from: ir.nasim.Ve5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC8256Ve5 {

    /* renamed from: ir.nasim.Ve5$a */
    public static final class a implements InterfaceC8256Ve5 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.InterfaceC8256Ve5
        public boolean c(InterfaceC21331tU0 interfaceC21331tU0, JC6 jc6) {
            AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
            AbstractC13042fc3.i(jc6, "functionDescriptor");
            return true;
        }
    }

    /* renamed from: ir.nasim.Ve5$b */
    public static final class b implements InterfaceC8256Ve5 {
        public static final b a = new b();

        private b() {
        }

        @Override // ir.nasim.InterfaceC8256Ve5
        public boolean c(InterfaceC21331tU0 interfaceC21331tU0, JC6 jc6) {
            AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
            AbstractC13042fc3.i(jc6, "functionDescriptor");
            return !jc6.getAnnotations().M1(AbstractC8490We5.a());
        }
    }

    boolean c(InterfaceC21331tU0 interfaceC21331tU0, JC6 jc6);
}
