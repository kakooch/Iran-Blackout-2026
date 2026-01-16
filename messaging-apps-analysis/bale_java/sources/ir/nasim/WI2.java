package ir.nasim;

/* loaded from: classes2.dex */
public abstract class WI2 {

    class a implements b {
        private volatile Object a;
        final /* synthetic */ b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // ir.nasim.WI2.b
        public Object get() {
            if (this.a == null) {
                synchronized (this) {
                    try {
                        if (this.a == null) {
                            this.a = AbstractC3322Aj5.d(this.b.get());
                        }
                    } finally {
                    }
                }
            }
            return this.a;
        }
    }

    public interface b {
        Object get();
    }

    public static b a(b bVar) {
        return new a(bVar);
    }
}
