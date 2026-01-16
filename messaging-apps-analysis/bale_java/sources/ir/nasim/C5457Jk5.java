package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.Jk5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5457Jk5 {
    private static final a e = new a(null);
    private final long a;
    private final String b;
    private final int c;
    private final byte[] d;

    /* renamed from: ir.nasim.Jk5$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5457Jk5(long j, String str, int i, byte[] bArr) {
        AbstractC13042fc3.i(str, "url");
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = bArr;
    }

    public final long a() {
        return this.a;
    }

    public final byte[] b() {
        return this.d;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C5457Jk5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.database.entity.PremiumBadgeEntity");
        C5457Jk5 c5457Jk5 = (C5457Jk5) obj;
        if (this.a != c5457Jk5.a || !AbstractC13042fc3.d(this.b, c5457Jk5.b) || this.c != c5457Jk5.c) {
            return false;
        }
        byte[] bArr = this.d;
        if (bArr != null) {
            byte[] bArr2 = c5457Jk5.d;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (c5457Jk5.d != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        byte[] bArr = this.d;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "PremiumBadgeEntity(badgeId=" + this.a + ", url=" + this.b + ", mediaFormat=" + this.c + ", downloadedContent=" + Arrays.toString(this.d) + Separators.RPAREN;
    }
}
