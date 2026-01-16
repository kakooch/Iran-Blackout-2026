package ir.nasim;

import ir.nasim.InterfaceC18557or4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.pr4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19148pr4 {
    public static final a d = new a(null);
    private final int a;
    private final int b;
    private final BJ c;

    /* renamed from: ir.nasim.pr4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C19148pr4(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = new BJ(i);
    }

    private final double d(InterfaceC18557or4.b bVar) {
        return bVar.c() / (bVar.b() / 1.0E9d);
    }

    public final void a(InterfaceC18557or4 interfaceC18557or4) {
        AbstractC13042fc3.i(interfaceC18557or4, "sample");
        if (this.c.size() >= this.a) {
            this.c.removeFirst();
        }
        this.c.addLast(interfaceC18557or4);
    }

    public final double b() {
        BJ bj = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : bj) {
            if (obj instanceof InterfaceC18557or4.b) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        double d2 = 0.0d;
        while (it.hasNext()) {
            d2 += d((InterfaceC18557or4.b) it.next()) / this.c.size();
        }
        return d2;
    }

    public final double c() {
        BJ bj = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : bj) {
            if (obj instanceof InterfaceC18557or4.b) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        double dB = 0.0d;
        while (it.hasNext()) {
            dB += ((InterfaceC18557or4.b) it.next()).b() / this.c.size();
        }
        return dB;
    }

    public final double e() {
        BJ bj = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : bj) {
            if (obj instanceof InterfaceC18557or4.b) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long jB = ((InterfaceC18557or4.b) next).b();
            do {
                Object next2 = it.next();
                long jB2 = ((InterfaceC18557or4.b) next2).b();
                if (jB > jB2) {
                    next = next2;
                    jB = jB2;
                }
            } while (it.hasNext());
        }
        return ((InterfaceC18557or4.b) next).b();
    }

    public final boolean f() {
        return this.c.size() >= this.b;
    }

    public /* synthetic */ C19148pr4(int i, int i2, int i3, ED1 ed1) {
        this(i, (i3 & 2) != 0 ? 4 : i2);
    }
}
