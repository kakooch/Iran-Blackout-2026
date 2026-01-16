package ir.nasim;

/* loaded from: classes3.dex */
final class HD6 extends AbstractC14535i43 {
    final transient Object c;

    HD6(Object obj) {
        this.c = AbstractC4029Dj5.j(obj);
    }

    @Override // ir.nasim.Z33
    boolean D() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: V */
    public DB7 iterator() {
        return AbstractC17855ng3.p(this.c);
    }

    @Override // ir.nasim.Z33, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.c.equals(obj);
    }

    @Override // ir.nasim.AbstractC14535i43, ir.nasim.Z33
    public AbstractC12710f43 f() {
        return AbstractC12710f43.W(this.c);
    }

    @Override // ir.nasim.AbstractC14535i43, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // ir.nasim.Z33
    int j(Object[] objArr, int i) {
        objArr[i] = this.c;
        return i + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String string = this.c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }
}
