package ir.nasim;

/* loaded from: classes.dex */
public abstract class T22 {
    private static final K22 a = new C11397cw1(0.4f, 0.0f, 0.2f, 1.0f);
    private static final K22 b = new C11397cw1(0.0f, 0.0f, 0.2f, 1.0f);
    private static final K22 c = new C11397cw1(0.4f, 0.0f, 1.0f, 1.0f);
    private static final K22 d = new K22() { // from class: ir.nasim.S22
        @Override // ir.nasim.K22
        public final float a(float f) {
            return T22.b(f);
        }
    };

    public static final K22 c() {
        return c;
    }

    public static final K22 d() {
        return a;
    }

    public static final K22 e() {
        return d;
    }

    public static final K22 f() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(float f) {
        return f;
    }
}
