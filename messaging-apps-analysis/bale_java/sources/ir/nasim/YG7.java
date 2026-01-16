package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class YG7 {
    private final C11458d25 a;
    private final long b;
    private final float c;
    private final String d;

    public YG7(C11458d25 c11458d25, long j, float f, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "fileName");
        this.a = c11458d25;
        this.b = j;
        this.c = f;
        this.d = str;
    }

    public final String a() {
        return this.d;
    }

    public final long b() {
        return this.b;
    }

    public final C11458d25 c() {
        return this.a;
    }

    public final float d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YG7)) {
            return false;
        }
        YG7 yg7 = (YG7) obj;
        return AbstractC13042fc3.d(this.a, yg7.a) && this.b == yg7.b && Float.compare(this.c, yg7.c) == 0 && AbstractC13042fc3.d(this.d, yg7.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "UploadDetails(peer=" + this.a + ", messageId=" + this.b + ", progress=" + this.c + ", fileName=" + this.d + Separators.RPAREN;
    }
}
