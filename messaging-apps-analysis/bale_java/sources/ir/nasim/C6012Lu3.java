package ir.nasim;

/* renamed from: ir.nasim.Lu3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C6012Lu3 {
    public static final C6012Lu3 f = new b().b(1.0f).d(0.0f).e(0.0f).f(1.0f).c(1.0f).a();
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;

    /* renamed from: ir.nasim.Lu3$b */
    public static final class b {
        private float a = 1.0f;
        private float b = 0.0f;
        private float c = 0.0f;
        private float d = 0.0f;
        private float e = 0.0f;

        public C6012Lu3 a() {
            return new C6012Lu3(this.a, this.b, this.c, this.d, this.e);
        }

        public b b(float f) {
            this.a = f;
            return this;
        }

        public b c(float f) {
            this.e = f;
            return this;
        }

        public b d(float f) {
            this.b = f;
            return this;
        }

        public b e(float f) {
            this.c = f;
            return this;
        }

        public b f(float f) {
            this.d = f;
            return this;
        }
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.e;
    }

    public float c() {
        return this.b;
    }

    public float d() {
        return this.c;
    }

    public float e() {
        return this.d;
    }

    private C6012Lu3(float f2, float f3, float f4, float f5, float f6) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f6;
    }
}
