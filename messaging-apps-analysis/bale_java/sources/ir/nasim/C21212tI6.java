package ir.nasim;

/* renamed from: ir.nasim.tI6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21212tI6 {
    private int[] a;
    private boolean[] b;
    private int c;

    public C21212tI6() {
        this(10);
    }

    public boolean a(int i, boolean z) {
        int iA = AbstractC13147fk1.a(this.a, this.c, i);
        return iA < 0 ? z : this.b[iA];
    }

    public int b(int i) {
        return this.a[i];
    }

    public void c(int i, boolean z) {
        int iA = AbstractC13147fk1.a(this.a, this.c, i);
        if (iA >= 0) {
            this.b[iA] = z;
            return;
        }
        int i2 = ~iA;
        this.a = IS2.b(this.a, this.c, i2, i);
        this.b = IS2.c(this.b, this.c, i2, z);
        this.c++;
    }

    public int d() {
        return this.c;
    }

    public boolean e(int i) {
        return this.b[i];
    }

    public String toString() {
        if (d() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            sb.append(e(i));
        }
        sb.append('}');
        return sb.toString();
    }

    public C21212tI6(int i) {
        if (i == 0) {
            this.a = AbstractC13147fk1.b;
            this.b = AbstractC13147fk1.a;
        } else {
            int[] iArr = new int[i];
            this.a = iArr;
            this.b = new boolean[iArr.length];
        }
        this.c = 0;
    }
}
