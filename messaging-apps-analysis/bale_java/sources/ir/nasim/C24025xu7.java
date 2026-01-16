package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.Date;

/* renamed from: ir.nasim.xu7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24025xu7 {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final long e;
    private final long f;

    public C24025xu7(String str, String str2, String str3, boolean z, long j, long j2) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(str2, ParameterNames.TEXT);
        AbstractC13042fc3.i(str3, "language");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = j;
        this.f = j2;
    }

    public final boolean a() {
        return this.d;
    }

    public final long b() {
        return this.e;
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24025xu7)) {
            return false;
        }
        C24025xu7 c24025xu7 = (C24025xu7) obj;
        return AbstractC13042fc3.d(this.a, c24025xu7.a) && AbstractC13042fc3.d(this.b, c24025xu7.b) && AbstractC13042fc3.d(this.c, c24025xu7.c) && this.d == c24025xu7.d && this.e == c24025xu7.e && this.f == c24025xu7.f;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TranscriptionSegment(id=" + this.a + ", text=" + this.b + ", language=" + this.c + ", final=" + this.d + ", firstReceivedTime=" + this.e + ", lastReceivedTime=" + this.f + ')';
    }

    public /* synthetic */ C24025xu7(String str, String str2, String str3, boolean z, long j, long j2, int i, ED1 ed1) {
        this(str, str2, str3, z, (i & 16) != 0 ? new Date().getTime() : j, (i & 32) != 0 ? new Date().getTime() : j2);
    }
}
