package ir.nasim;

/* renamed from: ir.nasim.Xb3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC8727Xb3 {

    /* renamed from: ir.nasim.Xb3$a */
    public static final class a {
        private final int a;
        private final int b;
        private final Object c;

        public a(int i, int i2, Object obj) {
            this.a = i;
            this.b = i2;
            this.c = obj;
            if (!(i >= 0)) {
                P73.a("startIndex should be >= 0");
            }
            if (i2 > 0) {
                return;
            }
            P73.a("size should be > 0");
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public final Object c() {
            return this.c;
        }
    }

    void a(int i, int i2, UA2 ua2);

    int f();

    a get(int i);
}
