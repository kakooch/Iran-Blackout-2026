package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.vx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22871vx5 {
    private final String a;
    private final com.google.protobuf.P b;
    private com.google.protobuf.P c;

    public C22871vx5(String str, com.google.protobuf.P p, com.google.protobuf.P p2) {
        AbstractC13042fc3.i(str, "method");
        AbstractC13042fc3.i(p, "request");
        AbstractC13042fc3.i(p2, "response");
        this.a = str;
        this.b = p;
        this.c = p2;
    }

    public final String a() {
        return this.a;
    }

    public final com.google.protobuf.P b() {
        return this.b;
    }

    public final com.google.protobuf.P c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22871vx5)) {
            return false;
        }
        C22871vx5 c22871vx5 = (C22871vx5) obj;
        return AbstractC13042fc3.d(this.a, c22871vx5.a) && AbstractC13042fc3.d(this.b, c22871vx5.b) && AbstractC13042fc3.d(this.c, c22871vx5.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ProtoRpc(method=" + this.a + ", request=" + this.b + ", response=" + this.c + Separators.RPAREN;
    }
}
