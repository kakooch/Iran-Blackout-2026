package ir.nasim;

/* loaded from: classes8.dex */
public interface JH6 {
    public static final JH6 a = new a();

    static class a implements JH6 {
        a() {
        }

        private static /* synthetic */ void d(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // ir.nasim.JH6
        public KH6 b() {
            KH6 kh6 = KH6.a;
            if (kh6 == null) {
                d(0);
            }
            return kh6;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    KH6 b();
}
