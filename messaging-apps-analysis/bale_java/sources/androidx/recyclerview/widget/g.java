package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.r;
import androidx.recyclerview.widget.z;
import ir.nasim.AbstractC4980Hj5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class g implements r.b {
    private final f a;
    private final C b;
    private List c = new ArrayList();
    private final IdentityHashMap d = new IdentityHashMap();
    private List e = new ArrayList();
    private a f = new a();
    private final f.a.b g;
    private final z h;

    static class a {
        r a;
        int b;
        boolean c;

        a() {
        }
    }

    g(f fVar, f.a aVar) {
        this.a = fVar;
        if (aVar.a) {
            this.b = new C.a();
        } else {
            this.b = new C.b();
        }
        f.a.b bVar = aVar.b;
        this.g = bVar;
        if (bVar == f.a.b.NO_STABLE_IDS) {
            this.h = new z.b();
        } else if (bVar == f.a.b.ISOLATED_STABLE_IDS) {
            this.h = new z.a();
        } else {
            if (bVar != f.a.b.SHARED_STABLE_IDS) {
                throw new IllegalArgumentException("unknown stable id mode");
            }
            this.h = new z.c();
        }
    }

    private void E(a aVar) {
        aVar.c = false;
        aVar.a = null;
        aVar.b = -1;
        this.f = aVar;
    }

    private void i() {
        RecyclerView.h.a aVarJ = j();
        if (aVarJ != this.a.getStateRestorationPolicy()) {
            this.a.C(aVarJ);
        }
    }

    private RecyclerView.h.a j() {
        for (r rVar : this.e) {
            RecyclerView.h.a stateRestorationPolicy = rVar.c.getStateRestorationPolicy();
            RecyclerView.h.a aVar = RecyclerView.h.a.PREVENT;
            if (stateRestorationPolicy == aVar) {
                return aVar;
            }
            if (stateRestorationPolicy == RecyclerView.h.a.PREVENT_WHEN_EMPTY && rVar.b() == 0) {
                return aVar;
            }
        }
        return RecyclerView.h.a.ALLOW;
    }

    private int k(r rVar) {
        r rVar2;
        Iterator it = this.e.iterator();
        int iB = 0;
        while (it.hasNext() && (rVar2 = (r) it.next()) != rVar) {
            iB += rVar2.b();
        }
        return iB;
    }

    private a l(int i) {
        a aVar = this.f;
        if (aVar.c) {
            aVar = new a();
        } else {
            aVar.c = true;
        }
        Iterator it = this.e.iterator();
        int iB = i;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            r rVar = (r) it.next();
            if (rVar.b() > iB) {
                aVar.a = rVar;
                aVar.b = iB;
                break;
            }
            iB -= rVar.b();
        }
        if (aVar.a != null) {
            return aVar;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i);
    }

    private r m(RecyclerView.h hVar) {
        int iU = u(hVar);
        if (iU == -1) {
            return null;
        }
        return (r) this.e.get(iU);
    }

    private r s(RecyclerView.C c) {
        r rVar = (r) this.d.get(c);
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("Cannot find wrapper for " + c + ", seems like it is not bound by this adapter: " + this);
    }

    private int u(RecyclerView.h hVar) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            if (((r) this.e.get(i)).c == hVar) {
                return i;
            }
        }
        return -1;
    }

    private boolean v(RecyclerView recyclerView) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public boolean A(RecyclerView.C c) {
        r rVar = (r) this.d.get(c);
        if (rVar != null) {
            boolean zOnFailedToRecycleView = rVar.c.onFailedToRecycleView(c);
            this.d.remove(c);
            return zOnFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + c + ", seems like it is not bound by this adapter: " + this);
    }

    public void B(RecyclerView.C c) {
        s(c).c.onViewAttachedToWindow(c);
    }

    public void C(RecyclerView.C c) {
        s(c).c.onViewDetachedFromWindow(c);
    }

    public void D(RecyclerView.C c) {
        r rVar = (r) this.d.get(c);
        if (rVar != null) {
            rVar.c.onViewRecycled(c);
            this.d.remove(c);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + c + ", seems like it is not bound by this adapter: " + this);
    }

    boolean F(RecyclerView.h hVar) {
        int iU = u(hVar);
        if (iU == -1) {
            return false;
        }
        r rVar = (r) this.e.get(iU);
        int iK = k(rVar);
        this.e.remove(iU);
        this.a.notifyItemRangeRemoved(iK, rVar.b());
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
            if (recyclerView != null) {
                hVar.onDetachedFromRecyclerView(recyclerView);
            }
        }
        rVar.a();
        i();
        return true;
    }

    @Override // androidx.recyclerview.widget.r.b
    public void a(r rVar, int i, int i2, Object obj) {
        this.a.notifyItemRangeChanged(i + k(rVar), i2, obj);
    }

    @Override // androidx.recyclerview.widget.r.b
    public void b(r rVar, int i, int i2) {
        this.a.notifyItemRangeInserted(i + k(rVar), i2);
    }

    @Override // androidx.recyclerview.widget.r.b
    public void c(r rVar, int i, int i2) {
        int iK = k(rVar);
        this.a.notifyItemMoved(i + iK, i2 + iK);
    }

    @Override // androidx.recyclerview.widget.r.b
    public void d(r rVar) {
        i();
    }

    @Override // androidx.recyclerview.widget.r.b
    public void e(r rVar) {
        this.a.notifyDataSetChanged();
        i();
    }

    @Override // androidx.recyclerview.widget.r.b
    public void f(r rVar, int i, int i2) {
        this.a.notifyItemRangeRemoved(i + k(rVar), i2);
    }

    boolean g(int i, RecyclerView.h hVar) {
        if (i < 0 || i > this.e.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.e.size() + ". Given:" + i);
        }
        if (t()) {
            AbstractC4980Hj5.b(hVar.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (hVar.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (m(hVar) != null) {
            return false;
        }
        r rVar = new r(hVar, this, this.b, this.h.a());
        this.e.add(i, rVar);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
            if (recyclerView != null) {
                hVar.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (rVar.b() > 0) {
            this.a.notifyItemRangeInserted(k(rVar), rVar.b());
        }
        i();
        return true;
    }

    boolean h(RecyclerView.h hVar) {
        return g(this.e.size(), hVar);
    }

    public List n() {
        if (this.e.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.e.size());
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(((r) it.next()).c);
        }
        return arrayList;
    }

    public long o(int i) {
        a aVarL = l(i);
        long jC = aVarL.a.c(aVarL.b);
        E(aVarL);
        return jC;
    }

    public int p(int i) {
        a aVarL = l(i);
        int iD = aVarL.a.d(aVarL.b);
        E(aVarL);
        return iD;
    }

    public int q(RecyclerView.h hVar, RecyclerView.C c, int i) {
        r rVar = (r) this.d.get(c);
        if (rVar == null) {
            return -1;
        }
        int iK = i - k(rVar);
        int itemCount = rVar.c.getItemCount();
        if (iK >= 0 && iK < itemCount) {
            return rVar.c.findRelativeAdapterPositionIn(hVar, c, iK);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + iK + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + c + "adapter:" + hVar);
    }

    public int r() {
        Iterator it = this.e.iterator();
        int iB = 0;
        while (it.hasNext()) {
            iB += ((r) it.next()).b();
        }
        return iB;
    }

    public boolean t() {
        return this.g != f.a.b.NO_STABLE_IDS;
    }

    public void w(RecyclerView recyclerView) {
        if (v(recyclerView)) {
            return;
        }
        this.c.add(new WeakReference(recyclerView));
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((r) it.next()).c.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void x(RecyclerView.C c, int i) {
        a aVarL = l(i);
        this.d.put(c, aVarL.a);
        aVarL.a.e(c, aVarL.b);
        E(aVarL);
    }

    public RecyclerView.C y(ViewGroup viewGroup, int i) {
        return this.b.a(i).f(viewGroup, i);
    }

    public void z(RecyclerView recyclerView) {
        int size = this.c.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = (WeakReference) this.c.get(size);
            if (weakReference.get() == null) {
                this.c.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.c.remove(size);
                break;
            }
            size--;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((r) it.next()).c.onDetachedFromRecyclerView(recyclerView);
        }
    }
}
