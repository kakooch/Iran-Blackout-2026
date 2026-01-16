package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.rv6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20390rv6 {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;
    private final UA2 d;
    private final SA2 e;

    public C20390rv6(SA2 sa2, SA2 sa22, SA2 sa23, UA2 ua2, SA2 sa24) {
        AbstractC13042fc3.i(sa2, "sendLogs");
        AbstractC13042fc3.i(sa22, "sendLastLogs");
        AbstractC13042fc3.i(sa23, "clearLogs");
        AbstractC13042fc3.i(ua2, "setWebViewDebuggingEnabled");
        AbstractC13042fc3.i(sa24, "disableLogSending");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
        this.d = ua2;
        this.e = sa24;
    }

    public final SA2 a() {
        return this.c;
    }

    public final SA2 b() {
        return this.e;
    }

    public final SA2 c() {
        return this.b;
    }

    public final SA2 d() {
        return this.a;
    }

    public final UA2 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20390rv6)) {
            return false;
        }
        C20390rv6 c20390rv6 = (C20390rv6) obj;
        return AbstractC13042fc3.d(this.a, c20390rv6.a) && AbstractC13042fc3.d(this.b, c20390rv6.b) && AbstractC13042fc3.d(this.c, c20390rv6.c) && AbstractC13042fc3.d(this.d, c20390rv6.d) && AbstractC13042fc3.d(this.e, c20390rv6.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "SettingLogSendingCallback(sendLogs=" + this.a + ", sendLastLogs=" + this.b + ", clearLogs=" + this.c + ", setWebViewDebuggingEnabled=" + this.d + ", disableLogSending=" + this.e + Separators.RPAREN;
    }
}
