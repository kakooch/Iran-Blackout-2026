package ir.nasim;

/* renamed from: ir.nasim.gZ0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13628gZ0 {
    private final AbstractC13460gG3 a;
    private final AbstractC13460gG3 b;
    private final AbstractC13460gG3 c;
    private final C14653iG3 d;
    private final C14653iG3 e;
    private final boolean f;
    private final boolean g;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C13628gZ0(ir.nasim.AbstractC13460gG3 r2, ir.nasim.AbstractC13460gG3 r3, ir.nasim.AbstractC13460gG3 r4, ir.nasim.C14653iG3 r5, ir.nasim.C14653iG3 r6) {
        /*
            r1 = this;
            java.lang.String r0 = "refresh"
            ir.nasim.AbstractC13042fc3.i(r2, r0)
            java.lang.String r0 = "prepend"
            ir.nasim.AbstractC13042fc3.i(r3, r0)
            java.lang.String r0 = "append"
            ir.nasim.AbstractC13042fc3.i(r4, r0)
            java.lang.String r0 = "source"
            ir.nasim.AbstractC13042fc3.i(r5, r0)
            r1.<init>()
            r1.a = r2
            r1.b = r3
            r1.c = r4
            r1.d = r5
            r1.e = r6
            boolean r2 = r5.h()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L35
            if (r6 == 0) goto L30
            boolean r2 = r6.h()
            goto L31
        L30:
            r2 = r4
        L31:
            if (r2 == 0) goto L35
            r2 = r4
            goto L36
        L35:
            r2 = r3
        L36:
            r1.f = r2
            boolean r2 = r5.g()
            if (r2 != 0) goto L48
            if (r6 == 0) goto L45
            boolean r2 = r6.g()
            goto L46
        L45:
            r2 = r3
        L46:
            if (r2 == 0) goto L49
        L48:
            r3 = r4
        L49:
            r1.g = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13628gZ0.<init>(ir.nasim.gG3, ir.nasim.gG3, ir.nasim.gG3, ir.nasim.iG3, ir.nasim.iG3):void");
    }

    public final AbstractC13460gG3 a() {
        return this.c;
    }

    public final C14653iG3 b() {
        return this.e;
    }

    public final AbstractC13460gG3 c() {
        return this.b;
    }

    public final AbstractC13460gG3 d() {
        return this.a;
    }

    public final C14653iG3 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C13628gZ0.class != obj.getClass()) {
            return false;
        }
        C13628gZ0 c13628gZ0 = (C13628gZ0) obj;
        return AbstractC13042fc3.d(this.a, c13628gZ0.a) && AbstractC13042fc3.d(this.b, c13628gZ0.b) && AbstractC13042fc3.d(this.c, c13628gZ0.c) && AbstractC13042fc3.d(this.d, c13628gZ0.d) && AbstractC13042fc3.d(this.e, c13628gZ0.e);
    }

    public int hashCode() {
        int iHashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        C14653iG3 c14653iG3 = this.e;
        return iHashCode + (c14653iG3 != null ? c14653iG3.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.a + ", prepend=" + this.b + ", append=" + this.c + ", source=" + this.d + ", mediator=" + this.e + ')';
    }

    public /* synthetic */ C13628gZ0(AbstractC13460gG3 abstractC13460gG3, AbstractC13460gG3 abstractC13460gG32, AbstractC13460gG3 abstractC13460gG33, C14653iG3 c14653iG3, C14653iG3 c14653iG32, int i, ED1 ed1) {
        this(abstractC13460gG3, abstractC13460gG32, abstractC13460gG33, c14653iG3, (i & 16) != 0 ? null : c14653iG32);
    }
}
