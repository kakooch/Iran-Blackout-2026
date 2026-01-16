package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class WG7 {
    private final long a;
    private final int b;
    private final int c;
    private final String d;
    private final String e;
    private final List f;

    public WG7(long j, int i, int i2, String str, String str2, List list) {
        AbstractC13042fc3.i(str, "uploadUrl");
        AbstractC13042fc3.i(str2, "fileDescriptor");
        AbstractC13042fc3.i(list, "remainingChunkIndices");
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = str2;
        this.f = list;
    }

    public final WG7 a(long j, int i, int i2, String str, String str2, List list) {
        AbstractC13042fc3.i(str, "uploadUrl");
        AbstractC13042fc3.i(str2, "fileDescriptor");
        AbstractC13042fc3.i(list, "remainingChunkIndices");
        return new WG7(j, i, i2, str, str2, list);
    }

    public final int c() {
        return this.b;
    }

    public final String d() {
        return this.e;
    }

    public final long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WG7)) {
            return false;
        }
        WG7 wg7 = (WG7) obj;
        return this.a == wg7.a && this.b == wg7.b && this.c == wg7.c && AbstractC13042fc3.d(this.d, wg7.d) && AbstractC13042fc3.d(this.e, wg7.e) && AbstractC13042fc3.d(this.f, wg7.f);
    }

    public final List f() {
        return this.f;
    }

    public final int g() {
        return this.c;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "UploadConfig(fileId=" + this.a + ", chunkSize=" + this.b + ", totalChunks=" + this.c + ", uploadUrl=" + this.d + ", fileDescriptor=" + this.e + ", remainingChunkIndices=" + this.f + Separators.RPAREN;
    }
}
