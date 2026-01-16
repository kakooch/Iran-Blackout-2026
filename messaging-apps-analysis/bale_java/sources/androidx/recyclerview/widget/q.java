package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C1977c;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.i;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class q extends RecyclerView.h {
    final d d;
    private final d.b e;

    class a implements d.b {
        a() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public void a(List list, List list2) {
            q.this.B(list, list2);
        }
    }

    protected q(i.f fVar) {
        a aVar = new a();
        this.e = aVar;
        d dVar = new d(new C1976b(this), new C1977c.a(fVar).a());
        this.d = dVar;
        dVar.a(aVar);
    }

    protected Object A(int i) {
        return this.d.b().get(i);
    }

    public void B(List list, List list2) {
    }

    public void C(List list) {
        this.d.e(list);
    }

    public void D(List list, Runnable runnable) {
        this.d.f(list, runnable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.b().size();
    }

    public List z() {
        return this.d.b();
    }
}
