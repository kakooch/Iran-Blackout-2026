package ir.nasim;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes8.dex */
class GJ6 implements QH1 {
    private final char a;
    private int b = 0;
    private LinkedList c = new LinkedList();

    GJ6(char c) {
        this.a = c;
    }

    private QH1 g(int i) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            QH1 qh1 = (QH1) it.next();
            if (qh1.c() <= i) {
                return qh1;
            }
        }
        return (QH1) this.c.getFirst();
    }

    @Override // ir.nasim.QH1
    public void a(C5693Kk7 c5693Kk7, C5693Kk7 c5693Kk72, int i) {
        g(i).a(c5693Kk7, c5693Kk72, i);
    }

    @Override // ir.nasim.QH1
    public char b() {
        return this.a;
    }

    @Override // ir.nasim.QH1
    public int c() {
        return this.b;
    }

    @Override // ir.nasim.QH1
    public char d() {
        return this.a;
    }

    @Override // ir.nasim.QH1
    public int e(RH1 rh1, RH1 rh12) {
        return g(rh1.length()).e(rh1, rh12);
    }

    void f(QH1 qh1) {
        int iC = qh1.c();
        ListIterator listIterator = this.c.listIterator();
        while (listIterator.hasNext()) {
            int iC2 = ((QH1) listIterator.next()).c();
            if (iC > iC2) {
                listIterator.previous();
                listIterator.add(qh1);
                return;
            } else if (iC == iC2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.a + "' and minimum length " + iC);
            }
        }
        this.c.add(qh1);
        this.b = iC;
    }
}
