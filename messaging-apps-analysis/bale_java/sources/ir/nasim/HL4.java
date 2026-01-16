package ir.nasim;

import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class HL4 implements InterfaceC14373ho3 {
    private final KJ b = new C8620Wt0();

    private static void g(C23097wL4 c23097wL4, Object obj, MessageDigest messageDigest) {
        c23097wL4.g(obj, messageDigest);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); i++) {
            g((C23097wL4) this.b.g(i), this.b.k(i), messageDigest);
        }
    }

    public Object c(C23097wL4 c23097wL4) {
        return this.b.containsKey(c23097wL4) ? this.b.get(c23097wL4) : c23097wL4.c();
    }

    public void d(HL4 hl4) {
        this.b.h(hl4.b);
    }

    public HL4 e(C23097wL4 c23097wL4) {
        this.b.remove(c23097wL4);
        return this;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (obj instanceof HL4) {
            return this.b.equals(((HL4) obj).b);
        }
        return false;
    }

    public HL4 f(C23097wL4 c23097wL4, Object obj) {
        this.b.put(c23097wL4, obj);
        return this;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }
}
