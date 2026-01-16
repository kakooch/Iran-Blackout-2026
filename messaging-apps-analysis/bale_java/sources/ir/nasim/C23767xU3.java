package ir.nasim;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: ir.nasim.xU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C23767xU3 {
    private static final float[] x = {2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};
    protected final int a;
    protected final boolean b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;
    protected final int g;
    protected final int h;
    protected final int i;
    protected final int j;
    protected final int k;
    protected final int l;
    protected final int m;
    protected final Typeface n;
    protected final Typeface o;
    protected final int p;
    protected final int q;
    protected final int r;
    protected final int s;
    protected final Typeface t;
    protected final float[] u;
    protected final int v;
    protected final int w;

    /* renamed from: ir.nasim.xU3$a */
    public static class a {
        private int a;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private Typeface n;
        private Typeface o;
        private int p;
        private int q;
        private int s;
        private Typeface t;
        private float[] u;
        private int v;
        private boolean b = true;
        private int r = -1;
        private int w = -1;

        a() {
        }

        public a A(int i) {
            this.g = i;
            return this;
        }

        public a B(int i) {
            this.m = i;
            return this;
        }

        public a C(int i) {
            this.r = i;
            return this;
        }

        public a D(int i) {
            this.w = i;
            return this;
        }

        public a x(int i) {
            this.c = i;
            return this;
        }

        public a y(int i) {
            this.d = i;
            return this;
        }

        public C23767xU3 z() {
            return new C23767xU3(this);
        }
    }

    protected C23767xU3(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
    }

    public static a d(Context context) {
        JT1 jt1A = JT1.a(context);
        return new a().B(jt1A.b(8)).x(jt1A.b(24)).y(jt1A.b(4)).A(jt1A.b(1)).C(jt1A.b(1)).D(jt1A.b(4));
    }

    public void a(Paint paint) {
        int iA = this.s;
        if (iA == 0) {
            iA = PY0.a(paint.getColor(), 75);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
        int i = this.r;
        if (i >= 0) {
            paint.setStrokeWidth(i);
        }
    }

    public void b(Paint paint, int i) {
        Typeface typeface = this.t;
        if (typeface == null) {
            paint.setFakeBoldText(true);
        } else {
            paint.setTypeface(typeface);
        }
        float[] fArr = this.u;
        if (fArr == null) {
            fArr = x;
        }
        if (fArr == null || fArr.length < i) {
            throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", Integer.valueOf(i), Arrays.toString(fArr)));
        }
        paint.setTextSize(paint.getTextSize() * fArr[i - 1]);
    }

    public void c(Paint paint) {
        int color = this.f;
        if (color == 0) {
            color = paint.getColor();
        }
        paint.setColor(color);
        int i = this.g;
        if (i != 0) {
            paint.setStrokeWidth(i);
        }
    }

    public int e() {
        return this.c;
    }

    public int f(int i) {
        int iMin = Math.min(this.c, i) / 2;
        int i2 = this.h;
        return (i2 == 0 || i2 > iMin) ? iMin : i2;
    }
}
