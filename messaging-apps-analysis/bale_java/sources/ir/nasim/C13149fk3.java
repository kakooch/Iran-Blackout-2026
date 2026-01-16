package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.fk3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13149fk3 extends AbstractC22735vk3 implements Iterable {
    private final ArrayList a = new ArrayList();

    private AbstractC22735vk3 F() {
        int size = this.a.size();
        if (size == 1) {
            return (AbstractC22735vk3) this.a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    public void C(AbstractC22735vk3 abstractC22735vk3) {
        if (abstractC22735vk3 == null) {
            abstractC22735vk3 = C8074Uk3.a;
        }
        this.a.add(abstractC22735vk3);
    }

    public void D(String str) {
        this.a.add(str == null ? C8074Uk3.a : new C9906al3(str));
    }

    public AbstractC22735vk3 E(int i) {
        return (AbstractC22735vk3) this.a.get(i);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C13149fk3) && ((C13149fk3) obj).a.equals(this.a));
    }

    @Override // ir.nasim.AbstractC22735vk3
    public boolean f() {
        return F().f();
    }

    @Override // ir.nasim.AbstractC22735vk3
    public double h() {
        return F().h();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.AbstractC22735vk3
    public int i() {
        return F().i();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.a.iterator();
    }

    public int size() {
        return this.a.size();
    }

    @Override // ir.nasim.AbstractC22735vk3
    public long t() {
        return F().t();
    }

    @Override // ir.nasim.AbstractC22735vk3
    public String v() {
        return F().v();
    }
}
