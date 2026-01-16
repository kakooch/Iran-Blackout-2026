package ir.nasim;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: ir.nasim.qo3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19708qo3 {
    private AbstractC6522Nw1 a;
    private b b;
    private String c;
    private int d = 0;
    private String e = null;
    public int f = 0;
    ArrayList g = new ArrayList();

    /* renamed from: ir.nasim.qo3$a */
    class a implements Comparator {
        a() {
        }

        public int a(c cVar, c cVar2) {
            throw null;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            AbstractC18350oW3.a(obj2);
            return a(null, null);
        }
    }

    /* renamed from: ir.nasim.qo3$b */
    static class b {
        private final int a;
        BM4 b;
        private final int c;
        private final int d;
        private final int e;
        float[] f;
        double[] g;
        float[] h;
        float[] i;
        float[] j;
        float[] k;
        int l;
        AbstractC6522Nw1 m;
        double[] n;
        double[] o;
        float p;

        b(int i, String str, int i2, int i3) {
            BM4 bm4 = new BM4();
            this.b = bm4;
            this.c = 0;
            this.d = 1;
            this.e = 2;
            this.l = i;
            this.a = i2;
            bm4.g(i, str);
            this.f = new float[i3];
            this.g = new double[i3];
            this.h = new float[i3];
            this.i = new float[i3];
            this.j = new float[i3];
            this.k = new float[i3];
        }

        public double a(float f) {
            AbstractC6522Nw1 abstractC6522Nw1 = this.m;
            if (abstractC6522Nw1 != null) {
                double d = f;
                abstractC6522Nw1.g(d, this.o);
                this.m.d(d, this.n);
            } else {
                double[] dArr = this.o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d2 = f;
            double dE = this.b.e(d2, this.n[1]);
            double d3 = this.b.d(d2, this.n[1], this.o[1]);
            double[] dArr2 = this.o;
            return dArr2[0] + (dE * dArr2[2]) + (d3 * this.n[2]);
        }

        public double b(float f) {
            AbstractC6522Nw1 abstractC6522Nw1 = this.m;
            if (abstractC6522Nw1 != null) {
                abstractC6522Nw1.d(f, this.n);
            } else {
                double[] dArr = this.n;
                dArr[0] = this.i[0];
                dArr[1] = this.j[0];
                dArr[2] = this.f[0];
            }
            double[] dArr2 = this.n;
            return dArr2[0] + (this.b.e(f, dArr2[1]) * this.n[2]);
        }

        public void c(float f) {
            this.p = f;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.g.length, 3);
            float[] fArr = this.f;
            this.n = new double[fArr.length + 2];
            this.o = new double[fArr.length + 2];
            if (this.g[0] > 0.0d) {
                this.b.a(0.0d, this.h[0]);
            }
            double[] dArr2 = this.g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.b.a(1.0d, this.h[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                double[] dArr3 = dArr[i];
                dArr3[0] = this.i[i];
                dArr3[1] = this.j[i];
                dArr3[2] = this.f[i];
                this.b.a(this.g[i], this.h[i]);
            }
            this.b.f();
            double[] dArr4 = this.g;
            if (dArr4.length > 1) {
                this.m = AbstractC6522Nw1.a(0, dArr4, dArr);
            } else {
                this.m = null;
            }
        }
    }

    /* renamed from: ir.nasim.qo3$c */
    static class c {
    }

    public float a(float f) {
        return (float) this.b.b(f);
    }

    public float b(float f) {
        return (float) this.b.a(f);
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(float f) {
        int size = this.g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.b = new b(this.d, this.e, this.f, size);
        Iterator it = this.g.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        this.b.c(f);
        this.a = AbstractC6522Nw1.a(0, dArr, dArr2);
    }

    public boolean e() {
        return this.f == 1;
    }

    public String toString() {
        String str = this.c;
        new DecimalFormat("##.##");
        Iterator it = this.g.iterator();
        if (!it.hasNext()) {
            return str;
        }
        AbstractC18350oW3.a(it.next());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("[");
        throw null;
    }
}
