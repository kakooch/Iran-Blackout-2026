package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19815qz3;
import ir.nasim.C18145o96;
import ir.nasim.C22104ug2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC18042nz3;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC9336Zm4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class p extends j {
    public static final a k = new a(null);
    private final boolean b;
    private C22104ug2 c;
    private j.b d;
    private final WeakReference e;
    private int f;
    private boolean g;
    private boolean h;
    private ArrayList i;
    private final InterfaceC9336Zm4 j;

    public static final class a {
        private a() {
        }

        public final p a(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            return new p(interfaceC18633oz3, false, null);
        }

        public final j.b b(j.b bVar, j.b bVar2) {
            AbstractC13042fc3.i(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private j.b a;
        private n b;

        public b(InterfaceC18042nz3 interfaceC18042nz3, j.b bVar) {
            AbstractC13042fc3.i(bVar, "initialState");
            AbstractC13042fc3.f(interfaceC18042nz3);
            this.b = q.f(interfaceC18042nz3);
            this.a = bVar;
        }

        public final void a(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            AbstractC13042fc3.i(aVar, "event");
            j.b bVarJ = aVar.j();
            this.a = p.k.b(this.a, bVarJ);
            n nVar = this.b;
            AbstractC13042fc3.f(interfaceC18633oz3);
            nVar.s(interfaceC18633oz3, aVar);
            this.a = bVarJ;
        }

        public final j.b b() {
            return this.a;
        }
    }

    public /* synthetic */ p(InterfaceC18633oz3 interfaceC18633oz3, boolean z, ED1 ed1) {
        this(interfaceC18633oz3, z);
    }

    private final void e(InterfaceC18633oz3 interfaceC18633oz3) {
        Iterator itDescendingIterator = this.c.descendingIterator();
        AbstractC13042fc3.h(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            AbstractC13042fc3.h(entry, "next()");
            InterfaceC18042nz3 interfaceC18042nz3 = (InterfaceC18042nz3) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.d) > 0 && !this.h && this.c.contains(interfaceC18042nz3)) {
                j.a aVarA = j.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                m(aVarA.j());
                bVar.a(interfaceC18633oz3, aVarA);
                l();
            }
        }
    }

    private final j.b f(InterfaceC18042nz3 interfaceC18042nz3) {
        b bVar;
        Map.Entry entryV = this.c.v(interfaceC18042nz3);
        j.b bVar2 = null;
        j.b bVarB = (entryV == null || (bVar = (b) entryV.getValue()) == null) ? null : bVar.b();
        if (!this.i.isEmpty()) {
            bVar2 = (j.b) this.i.get(r0.size() - 1);
        }
        a aVar = k;
        return aVar.b(aVar.b(this.d, bVarB), bVar2);
    }

    private final void g(String str) {
        if (!this.b || AbstractC19815qz3.a()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void h(InterfaceC18633oz3 interfaceC18633oz3) {
        C18145o96.d dVarI = this.c.i();
        AbstractC13042fc3.h(dVarI, "observerMap.iteratorWithAdditions()");
        while (dVarI.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) dVarI.next();
            InterfaceC18042nz3 interfaceC18042nz3 = (InterfaceC18042nz3) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.d) < 0 && !this.h && this.c.contains(interfaceC18042nz3)) {
                m(bVar.b());
                j.a aVarB = j.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(interfaceC18633oz3, aVarB);
                l();
            }
        }
    }

    private final boolean j() {
        if (this.c.size() == 0) {
            return true;
        }
        Map.Entry entryF = this.c.f();
        AbstractC13042fc3.f(entryF);
        j.b bVarB = ((b) entryF.getValue()).b();
        Map.Entry entryJ = this.c.j();
        AbstractC13042fc3.f(entryJ);
        j.b bVarB2 = ((b) entryJ.getValue()).b();
        return bVarB == bVarB2 && this.d == bVarB2;
    }

    private final void k(j.b bVar) {
        j.b bVar2 = this.d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == j.b.INITIALIZED && bVar == j.b.DESTROYED) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + bVar + ", but was " + this.d + " in component " + this.e.get()).toString());
        }
        this.d = bVar;
        if (this.g || this.f != 0) {
            this.h = true;
            return;
        }
        this.g = true;
        o();
        this.g = false;
        if (this.d == j.b.DESTROYED) {
            this.c = new C22104ug2();
        }
    }

    private final void l() {
        this.i.remove(r0.size() - 1);
    }

    private final void m(j.b bVar) {
        this.i.add(bVar);
    }

    private final void o() {
        InterfaceC18633oz3 interfaceC18633oz3 = (InterfaceC18633oz3) this.e.get();
        if (interfaceC18633oz3 == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.h = false;
            j.b bVar = this.d;
            Map.Entry entryF = this.c.f();
            AbstractC13042fc3.f(entryF);
            if (bVar.compareTo(((b) entryF.getValue()).b()) < 0) {
                e(interfaceC18633oz3);
            }
            Map.Entry entryJ = this.c.j();
            if (!this.h && entryJ != null && this.d.compareTo(((b) entryJ.getValue()).b()) > 0) {
                h(interfaceC18633oz3);
            }
        }
        this.h = false;
        this.j.setValue(b());
    }

    @Override // androidx.lifecycle.j
    public void a(InterfaceC18042nz3 interfaceC18042nz3) {
        InterfaceC18633oz3 interfaceC18633oz3;
        AbstractC13042fc3.i(interfaceC18042nz3, "observer");
        g("addObserver");
        j.b bVar = this.d;
        j.b bVar2 = j.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = j.b.INITIALIZED;
        }
        b bVar3 = new b(interfaceC18042nz3, bVar2);
        if (((b) this.c.r(interfaceC18042nz3, bVar3)) == null && (interfaceC18633oz3 = (InterfaceC18633oz3) this.e.get()) != null) {
            boolean z = this.f != 0 || this.g;
            j.b bVarF = f(interfaceC18042nz3);
            this.f++;
            while (bVar3.b().compareTo(bVarF) < 0 && this.c.contains(interfaceC18042nz3)) {
                m(bVar3.b());
                j.a aVarB = j.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(interfaceC18633oz3, aVarB);
                l();
                bVarF = f(interfaceC18042nz3);
            }
            if (!z) {
                o();
            }
            this.f--;
        }
    }

    @Override // androidx.lifecycle.j
    public j.b b() {
        return this.d;
    }

    @Override // androidx.lifecycle.j
    public void d(InterfaceC18042nz3 interfaceC18042nz3) {
        AbstractC13042fc3.i(interfaceC18042nz3, "observer");
        g("removeObserver");
        this.c.t(interfaceC18042nz3);
    }

    public void i(j.a aVar) {
        AbstractC13042fc3.i(aVar, "event");
        g("handleLifecycleEvent");
        k(aVar.j());
    }

    public void n(j.b bVar) {
        AbstractC13042fc3.i(bVar, "state");
        g("setCurrentState");
        k(bVar);
    }

    private p(InterfaceC18633oz3 interfaceC18633oz3, boolean z) {
        this.b = z;
        this.c = new C22104ug2();
        j.b bVar = j.b.INITIALIZED;
        this.d = bVar;
        this.i = new ArrayList();
        this.e = new WeakReference(interfaceC18633oz3);
        this.j = AbstractC12281eL6.a(bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(InterfaceC18633oz3 interfaceC18633oz3) {
        this(interfaceC18633oz3, true);
        AbstractC13042fc3.i(interfaceC18633oz3, "provider");
    }
}
