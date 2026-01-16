package ir.nasim;

import java.util.Random;

/* renamed from: ir.nasim.ve2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22674ve2 {
    private final int b;
    private final int c;
    private final int d;
    private final Random a = new Random();
    private int e = 1;

    public C22674ve2(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public synchronized long a() {
        int i;
        i = this.b;
        return (long) (this.a.nextFloat() * (i + (((this.c - i) / this.d) * this.e)));
    }

    public synchronized void b() {
        int i = this.e + 1;
        this.e = i;
        int i2 = this.d;
        if (i > i2) {
            this.e = i2;
        }
    }

    public synchronized void c() {
        d();
    }

    public synchronized void d() {
        this.e = 0;
    }
}
