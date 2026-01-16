package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ug0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22102ug0 {
    public static final a e = new a(null);
    private final int a;
    private final int b;
    private final float c;
    private final float d;

    /* renamed from: ir.nasim.ug0$a */
    public static final class a {
        private a() {
        }

        public final List a() {
            return AbstractC10360bX0.p(new C22102ug0(1080, 6800000, 1.0f, 1.0f), new C22102ug0(720, 2600000, 1.0f, 1.0f), new C22102ug0(480, 1000000, 0.75f, 0.9f), new C22102ug0(0, 750000, 0.6f, 0.7f));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22102ug0(int i, int i2, float f, float f2) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
    }

    public static final List a() {
        return e.a();
    }

    public final float b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public final float d() {
        return this.d;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22102ug0)) {
            return false;
        }
        C22102ug0 c22102ug0 = (C22102ug0) obj;
        return this.a == c22102ug0.a && this.b == c22102ug0.b && Float.compare(this.c, c22102ug0.c) == 0 && Float.compare(this.d, c22102ug0.d) == 0;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public String toString() {
        return "BitrateSetting(minDimension=" + this.a + ", maxBitrate=" + this.b + ", compressFactor=" + this.c + ", minCompressFactor=" + this.d + Separators.RPAREN;
    }
}
