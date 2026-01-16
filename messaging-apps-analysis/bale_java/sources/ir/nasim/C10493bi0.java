package ir.nasim;

/* renamed from: ir.nasim.bi0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C10493bi0 {
    private final float a;
    private final AbstractC12520el0 b;

    public /* synthetic */ C10493bi0(float f, AbstractC12520el0 abstractC12520el0, ED1 ed1) {
        this(f, abstractC12520el0);
    }

    public final AbstractC12520el0 a() {
        return this.b;
    }

    public final float b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10493bi0)) {
            return false;
        }
        C10493bi0 c10493bi0 = (C10493bi0) obj;
        return C17784nZ1.s(this.a, c10493bi0.a) && AbstractC13042fc3.d(this.b, c10493bi0.b);
    }

    public int hashCode() {
        return (C17784nZ1.t(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "BorderStroke(width=" + ((Object) C17784nZ1.u(this.a)) + ", brush=" + this.b + ')';
    }

    private C10493bi0(float f, AbstractC12520el0 abstractC12520el0) {
        this.a = f;
        this.b = abstractC12520el0;
    }
}
