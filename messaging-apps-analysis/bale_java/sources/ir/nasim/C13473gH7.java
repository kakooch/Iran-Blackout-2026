package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Map;

/* renamed from: ir.nasim.gH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13473gH7 {
    public static final a c = new a(null);
    private final long a;
    private final int b;

    /* renamed from: ir.nasim.gH7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C13473gH7(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public final Map a() {
        return AbstractC20051rO3.n(AbstractC4616Fw7.a("file_size", Long.valueOf(this.a)), AbstractC4616Fw7.a("duration", Integer.valueOf(this.b)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13473gH7)) {
            return false;
        }
        C13473gH7 c13473gH7 = (C13473gH7) obj;
        return this.a == c13473gH7.a && this.b == c13473gH7.b;
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "UploadLastPutEvent(fileSize=" + this.a + ", durationInMillis=" + this.b + Separators.RPAREN;
    }
}
