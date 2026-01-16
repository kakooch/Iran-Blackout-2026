package ir.nasim;

import android.util.Rational;

/* renamed from: ir.nasim.uX7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22022uX7 {
    private int a;
    private Rational b;
    private int c;
    private int d;

    /* renamed from: ir.nasim.uX7$a */
    public static final class a {
        private final Rational b;
        private final int c;
        private int a = 1;
        private int d = 0;

        public a(Rational rational, int i) {
            this.b = rational;
            this.c = i;
        }

        public C22022uX7 a() {
            AbstractC4980Hj5.h(this.b, "The crop aspect ratio must be set.");
            return new C22022uX7(this.a, this.b, this.c, this.d);
        }

        public a b(int i) {
            this.d = i;
            return this;
        }

        public a c(int i) {
            this.a = i;
            return this;
        }
    }

    C22022uX7(int i, Rational rational, int i2, int i3) {
        this.a = i;
        this.b = rational;
        this.c = i2;
        this.d = i3;
    }

    public Rational a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.a;
    }
}
