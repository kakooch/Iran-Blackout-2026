package ir.nasim;

/* renamed from: ir.nasim.oL6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18254oL6 {

    /* renamed from: ir.nasim.oL6$b */
    private static class b extends AbstractC18254oL6 {
        private volatile boolean a;

        b() {
            super();
        }

        @Override // ir.nasim.AbstractC18254oL6
        public void b(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC18254oL6
        public void c() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private AbstractC18254oL6() {
    }

    public static AbstractC18254oL6 a() {
        return new b();
    }

    abstract void b(boolean z);

    public abstract void c();
}
