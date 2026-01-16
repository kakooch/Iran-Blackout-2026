package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.sI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20606sI3 {
    private final String a;
    private final EnumC24843zI3 b;
    private final String c;
    private final Throwable d;

    public C20606sI3(String str, EnumC24843zI3 enumC24843zI3, String str2, Throwable th) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(enumC24843zI3, "logLevel");
        this.a = str;
        this.b = enumC24843zI3;
        this.c = str2;
        this.d = th;
    }

    public final Throwable a() {
        return this.d;
    }

    public final EnumC24843zI3 b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20606sI3)) {
            return false;
        }
        C20606sI3 c20606sI3 = (C20606sI3) obj;
        return AbstractC13042fc3.d(this.a, c20606sI3.a) && this.b == c20606sI3.b && AbstractC13042fc3.d(this.c, c20606sI3.c) && AbstractC13042fc3.d(this.d, c20606sI3.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Throwable th = this.d;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "LogData(tag=" + this.a + ", logLevel=" + this.b + ", message=" + this.c + ", exception=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C20606sI3(String str, EnumC24843zI3 enumC24843zI3, String str2, Throwable th, int i, ED1 ed1) {
        this(str, enumC24843zI3, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : th);
    }
}
