package ir.nasim;

/* loaded from: classes.dex */
final class ZJ6 implements ZQ7 {
    private final ZQ7 a;
    private final long b;

    public ZJ6(ZQ7 zq7, long j) {
        this.a = zq7;
        this.b = j;
    }

    @Override // ir.nasim.ZQ7
    public boolean a() {
        return this.a.a();
    }

    @Override // ir.nasim.ZQ7
    public long b(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.a.b(abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3) + this.b;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        long j2 = this.b;
        return j < j2 ? abstractC8151Ut : this.a.c(j - j2, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZJ6)) {
            return false;
        }
        ZJ6 zj6 = (ZJ6) obj;
        return zj6.b == this.b && AbstractC13042fc3.d(zj6.a, this.a);
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        long j2 = this.b;
        return j < j2 ? abstractC8151Ut3 : this.a.f(j - j2, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Long.hashCode(this.b);
    }
}
