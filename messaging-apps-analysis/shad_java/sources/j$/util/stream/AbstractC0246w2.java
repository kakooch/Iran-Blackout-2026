package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.w2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0246w2 extends CountedCompleter {
    protected final A1 a;
    protected final int b;

    AbstractC0246w2(A1 a1, int i) {
        this.a = a1;
        this.b = i;
    }

    AbstractC0246w2(AbstractC0246w2 abstractC0246w2, A1 a1, int i) {
        super(abstractC0246w2);
        this.a = a1;
        this.b = i;
    }

    abstract void a();

    abstract AbstractC0246w2 b(int i, int i2);

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        AbstractC0246w2 abstractC0246w2B = this;
        while (abstractC0246w2B.a.q() != 0) {
            abstractC0246w2B.setPendingCount(abstractC0246w2B.a.q() - 1);
            int i = 0;
            int iCount = 0;
            while (i < abstractC0246w2B.a.q() - 1) {
                AbstractC0246w2 abstractC0246w2B2 = abstractC0246w2B.b(i, abstractC0246w2B.b + iCount);
                iCount = (int) (iCount + abstractC0246w2B2.a.count());
                abstractC0246w2B2.fork();
                i++;
            }
            abstractC0246w2B = abstractC0246w2B.b(i, abstractC0246w2B.b + iCount);
        }
        abstractC0246w2B.a();
        abstractC0246w2B.propagateCompletion();
    }
}
