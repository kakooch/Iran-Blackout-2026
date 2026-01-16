package ir.nasim;

import java.security.MessageDigest;

/* renamed from: ir.nasim.vG4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22456vG4 implements InterfaceC14373ho3 {
    private final Object b;

    public C22456vG4(Object obj) {
        this.b = AbstractC3322Aj5.d(obj);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(InterfaceC14373ho3.a));
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (obj instanceof C22456vG4) {
            return this.b.equals(((C22456vG4) obj).b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
