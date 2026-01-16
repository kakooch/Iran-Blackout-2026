package j$.util.stream;

import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class P2<T> extends H2<T> {
    private ArrayList d;

    P2(C2 c2, Comparator comparator) {
        super(c2, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.d.add(obj);
    }

    @Override // j$.util.stream.C2.d, j$.util.stream.C2
    public void l() {
        j$.time.a.C(this.d, this.b);
        this.a.m(this.d.size());
        if (this.c) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.a.o()) {
                    break;
                } else {
                    this.a.accept(next);
                }
            }
        } else {
            ArrayList arrayList = this.d;
            final C2 c2 = this.a;
            c2.getClass();
            j$.time.a.u(arrayList, new Consumer() { // from class: j$.util.stream.b
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    c2.accept(obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
        }
        this.a.l();
        this.d = null;
    }

    @Override // j$.util.stream.C2.d, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.d = j >= 0 ? new ArrayList((int) j) : new ArrayList();
    }
}
