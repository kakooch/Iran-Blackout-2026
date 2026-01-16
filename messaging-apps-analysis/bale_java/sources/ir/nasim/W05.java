package ir.nasim;

import java.util.Arrays;
import java.util.Vector;

/* loaded from: classes3.dex */
public class W05 {
    public double a;
    private Vector b;
    private int c;
    private float d;
    private InterfaceC13156fl0 e;

    public W05(C23293wg5 c23293wg5) {
        Vector vector = new Vector();
        this.b = vector;
        vector.add(c23293wg5);
    }

    public float a() {
        return this.d;
    }

    public InterfaceC13156fl0 b() {
        return this.e;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        Vector vector = this.b;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public C23293wg5[] e() {
        C23293wg5[] c23293wg5Arr = new C23293wg5[this.b.size()];
        this.b.toArray(c23293wg5Arr);
        return c23293wg5Arr;
    }

    public void f(int i, float f, InterfaceC13156fl0 interfaceC13156fl0) {
        this.c = i;
        this.d = f;
        this.e = interfaceC13156fl0;
    }

    public W05(C23293wg5[] c23293wg5Arr) {
        Vector vector = new Vector();
        this.b = vector;
        vector.addAll(Arrays.asList(c23293wg5Arr));
    }
}
