package androidx.lifecycle;

import ir.nasim.C18145o96;
import ir.nasim.C20298rm4;
import ir.nasim.QG4;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class s extends C20298rm4 {
    private C18145o96 l;

    private static class a implements QG4 {
        final r a;
        final QG4 b;
        int c = -1;

        a(r rVar, QG4 qg4) {
            this.a = rVar;
            this.b = qg4;
        }

        @Override // ir.nasim.QG4
        public void a(Object obj) {
            if (this.c != this.a.g()) {
                this.c = this.a.g();
                this.b.a(obj);
            }
        }

        void b() {
            this.a.k(this);
        }

        void c() {
            this.a.o(this);
        }
    }

    public s() {
        this.l = new C18145o96();
    }

    @Override // androidx.lifecycle.r
    protected void l() {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).b();
        }
    }

    @Override // androidx.lifecycle.r
    protected void m() {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).c();
        }
    }

    public void q(r rVar, QG4 qg4) {
        if (rVar == null) {
            throw new NullPointerException("source cannot be null");
        }
        a aVar = new a(rVar, qg4);
        a aVar2 = (a) this.l.r(rVar, aVar);
        if (aVar2 != null && aVar2.b != qg4) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVar2 == null && h()) {
            aVar.b();
        }
    }

    public void r(r rVar) {
        a aVar = (a) this.l.t(rVar);
        if (aVar != null) {
            aVar.c();
        }
    }

    public s(Object obj) {
        super(obj);
        this.l = new C18145o96();
    }
}
