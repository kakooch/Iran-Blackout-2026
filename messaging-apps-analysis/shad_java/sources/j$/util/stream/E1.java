package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.InterfaceC0103b;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class E1 implements A1 {
    private final Collection a;

    E1(Collection collection) {
        this.a = collection;
    }

    @Override // j$.util.stream.A1
    public void a(Consumer consumer) {
        AbstractC0102a.v(this.a, consumer);
    }

    @Override // j$.util.stream.A1
    public A1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.A1
    public long count() {
        return this.a.size();
    }

    @Override // j$.util.stream.A1
    public void j(Object[] objArr, int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ int q() {
        return 0;
    }

    @Override // j$.util.stream.A1
    public Object[] r(j$.util.function.m mVar) {
        Collection collection = this.a;
        return collection.toArray((Object[]) mVar.apply(collection.size()));
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ A1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.q(this, j, j2, mVar);
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        Collection collection = this.a;
        return (collection instanceof InterfaceC0103b ? ((InterfaceC0103b) collection).stream() : AbstractC0102a.i(collection)).spliterator();
    }

    public String toString() {
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.a.size()), this.a);
    }
}
