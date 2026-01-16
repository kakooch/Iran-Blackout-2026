package ir.nasim;

/* renamed from: ir.nasim.z01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C24665z01 {
    public final Object a;
    public final AbstractC24804zE0 b;
    public final UA2 c;
    public final Object d;
    public final Throwable e;

    public C24665z01(Object obj, AbstractC24804zE0 abstractC24804zE0, UA2 ua2, Object obj2, Throwable th) {
        this.a = obj;
        this.b = abstractC24804zE0;
        this.c = ua2;
        this.d = obj2;
        this.e = th;
    }

    public static /* synthetic */ C24665z01 b(C24665z01 c24665z01, Object obj, AbstractC24804zE0 abstractC24804zE0, UA2 ua2, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c24665z01.a;
        }
        if ((i & 2) != 0) {
            abstractC24804zE0 = c24665z01.b;
        }
        AbstractC24804zE0 abstractC24804zE02 = abstractC24804zE0;
        if ((i & 4) != 0) {
            ua2 = c24665z01.c;
        }
        UA2 ua22 = ua2;
        if ((i & 8) != 0) {
            obj2 = c24665z01.d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = c24665z01.e;
        }
        return c24665z01.a(obj, abstractC24804zE02, ua22, obj4, th);
    }

    public final C24665z01 a(Object obj, AbstractC24804zE0 abstractC24804zE0, UA2 ua2, Object obj2, Throwable th) {
        return new C24665z01(obj, abstractC24804zE0, ua2, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(IE0 ie0, Throwable th) {
        AbstractC24804zE0 abstractC24804zE0 = this.b;
        if (abstractC24804zE0 != null) {
            ie0.j(abstractC24804zE0, th);
        }
        UA2 ua2 = this.c;
        if (ua2 != null) {
            ie0.k(ua2, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24665z01)) {
            return false;
        }
        C24665z01 c24665z01 = (C24665z01) obj;
        return AbstractC13042fc3.d(this.a, c24665z01.a) && AbstractC13042fc3.d(this.b, c24665z01.b) && AbstractC13042fc3.d(this.c, c24665z01.c) && AbstractC13042fc3.d(this.d, c24665z01.d) && AbstractC13042fc3.d(this.e, c24665z01.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC24804zE0 abstractC24804zE0 = this.b;
        int iHashCode2 = (iHashCode + (abstractC24804zE0 == null ? 0 : abstractC24804zE0.hashCode())) * 31;
        UA2 ua2 = this.c;
        int iHashCode3 = (iHashCode2 + (ua2 == null ? 0 : ua2.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ C24665z01(Object obj, AbstractC24804zE0 abstractC24804zE0, UA2 ua2, Object obj2, Throwable th, int i, ED1 ed1) {
        this(obj, (i & 2) != 0 ? null : abstractC24804zE0, (i & 4) != 0 ? null : ua2, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
