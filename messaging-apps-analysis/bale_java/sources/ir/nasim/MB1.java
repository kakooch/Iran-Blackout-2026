package ir.nasim;

/* loaded from: classes2.dex */
public final class MB1 {
    public final String a;
    public final com.google.android.exoplayer2.X b;
    public final com.google.android.exoplayer2.X c;
    public final int d;
    public final int e;

    public MB1(String str, com.google.android.exoplayer2.X x, com.google.android.exoplayer2.X x2, int i, int i2) {
        AbstractC20011rK.a(i == 0 || i2 == 0);
        this.a = AbstractC20011rK.d(str);
        this.b = (com.google.android.exoplayer2.X) AbstractC20011rK.e(x);
        this.c = (com.google.android.exoplayer2.X) AbstractC20011rK.e(x2);
        this.d = i;
        this.e = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MB1.class != obj.getClass()) {
            return false;
        }
        MB1 mb1 = (MB1) obj;
        return this.d == mb1.d && this.e == mb1.e && this.a.equals(mb1.a) && this.b.equals(mb1.b) && this.c.equals(mb1.c);
    }

    public int hashCode() {
        return ((((((((527 + this.d) * 31) + this.e) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
