package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.u16, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21724u16 {
    private final int a;
    private boolean b;
    private int c;

    public C21724u16(int i) {
        this.a = i;
    }

    public final int a() {
        return this.c;
    }

    public final boolean b() {
        return this.c >= this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public final C21724u16 d() {
        this.b = false;
        this.c = 0;
        return this;
    }

    public final C21724u16 e() {
        this.c++;
        return this;
    }

    public final C21724u16 f() {
        this.b = true;
        this.c = 0;
        return this;
    }

    public int hashCode() {
        return (this.a * 31) + Boolean.hashCode(this.b) + this.c;
    }

    public String toString() {
        return "RetryPolicy(maxRetryCount=" + this.a + ", isTrying=" + this.b + ", retryCount=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C21724u16(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 5 : i);
    }
}
