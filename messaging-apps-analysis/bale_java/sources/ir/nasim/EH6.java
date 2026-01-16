package ir.nasim;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class EH6 implements Comparable {
    private static int r = 1;
    public boolean a;
    private String b;
    public float f;
    a j;
    public int c = -1;
    int d = -1;
    public int e = 0;
    public boolean g = false;
    float[] h = new float[9];
    float[] i = new float[9];
    OJ[] k = new OJ[16];
    int l = 0;
    public int m = 0;
    boolean n = false;
    int o = -1;
    float p = 0.0f;
    HashSet q = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public EH6(a aVar, String str) {
        this.j = aVar;
    }

    static void i() {
        r++;
    }

    public final void a(OJ oj) {
        int i = 0;
        while (true) {
            int i2 = this.l;
            if (i >= i2) {
                OJ[] ojArr = this.k;
                if (i2 >= ojArr.length) {
                    this.k = (OJ[]) Arrays.copyOf(ojArr, ojArr.length * 2);
                }
                OJ[] ojArr2 = this.k;
                int i3 = this.l;
                ojArr2[i3] = oj;
                this.l = i3 + 1;
                return;
            }
            if (this.k[i] == oj) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(EH6 eh6) {
        return this.c - eh6.c;
    }

    public final void j(OJ oj) {
        int i = this.l;
        int i2 = 0;
        while (i2 < i) {
            if (this.k[i2] == oj) {
                while (i2 < i - 1) {
                    OJ[] ojArr = this.k;
                    int i3 = i2 + 1;
                    ojArr[i2] = ojArr[i3];
                    i2 = i3;
                }
                this.l--;
                return;
            }
            i2++;
        }
    }

    public void o() {
        this.b = null;
        this.j = a.UNKNOWN;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        this.n = false;
        this.o = -1;
        this.p = 0.0f;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = null;
        }
        this.l = 0;
        this.m = 0;
        this.a = false;
        Arrays.fill(this.i, 0.0f);
    }

    public void p(C8963Xz3 c8963Xz3, float f) {
        this.f = f;
        this.g = true;
        this.n = false;
        this.o = -1;
        this.p = 0.0f;
        int i = this.l;
        this.d = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].A(c8963Xz3, this, false);
        }
        this.l = 0;
    }

    public void q(a aVar, String str) {
        this.j = aVar;
    }

    public final void r(C8963Xz3 c8963Xz3, OJ oj) {
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].B(c8963Xz3, oj, false);
        }
        this.l = 0;
    }

    public String toString() {
        if (this.b != null) {
            return "" + this.b;
        }
        return "" + this.c;
    }
}
