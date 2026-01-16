package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.List$EL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class N3 extends F3 {
    private ArrayList d;

    N3(InterfaceC0192m3 interfaceC0192m3, Comparator comparator) {
        super(interfaceC0192m3, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.d.add(obj);
    }

    @Override // j$.util.stream.AbstractC0168i3, j$.util.stream.InterfaceC0192m3
    public void n() {
        List$EL.sort(this.d, this.b);
        this.a.o(this.d.size());
        if (this.c) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.a.p()) {
                    break;
                } else {
                    this.a.accept((InterfaceC0192m3) next);
                }
            }
        } else {
            ArrayList arrayList = this.d;
            InterfaceC0192m3 interfaceC0192m3 = this.a;
            interfaceC0192m3.getClass();
            AbstractC0102a.v(arrayList, new C0122b(interfaceC0192m3));
        }
        this.a.n();
        this.d = null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.d = j >= 0 ? new ArrayList((int) j) : new ArrayList();
    }
}
