package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.uZ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22034uZ1 extends AbstractC18385oa2 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final C11458d25 a;
    private final long b;
    private final String c;

    /* renamed from: ir.nasim.uZ1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22034uZ1(C11458d25 c11458d25, long j, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DRAFT);
        this.a = c11458d25;
        this.b = j;
        this.c = str;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "draft_change";
    }

    public final String b() {
        return this.c;
    }

    public final long c() {
        return this.b;
    }

    public final C11458d25 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22034uZ1)) {
            return false;
        }
        C22034uZ1 c22034uZ1 = (C22034uZ1) obj;
        return AbstractC13042fc3.d(this.a, c22034uZ1.a) && this.b == c22034uZ1.b && AbstractC13042fc3.d(this.c, c22034uZ1.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String toString() {
        return "draft_change{" + this.a + "," + this.b + "}";
    }
}
