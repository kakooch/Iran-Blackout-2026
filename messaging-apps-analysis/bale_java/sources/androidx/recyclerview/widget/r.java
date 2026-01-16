package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.C;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z;
import ir.nasim.AbstractC4980Hj5;

/* loaded from: classes2.dex */
class r {
    private final C.c a;
    private final z.d b;
    public final RecyclerView.h c;
    final b d;
    int e;
    private RecyclerView.j f = new a();

    class a extends RecyclerView.j {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            r rVar = r.this;
            rVar.e = rVar.c.getItemCount();
            r rVar2 = r.this;
            rVar2.d.e(rVar2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void b(int i, int i2) {
            r rVar = r.this;
            rVar.d.a(rVar, i, i2, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i, int i2, Object obj) {
            r rVar = r.this;
            rVar.d.a(rVar, i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            r rVar = r.this;
            rVar.e += i2;
            rVar.d.b(rVar, i, i2);
            r rVar2 = r.this;
            if (rVar2.e <= 0 || rVar2.c.getStateRestorationPolicy() != RecyclerView.h.a.PREVENT_WHEN_EMPTY) {
                return;
            }
            r rVar3 = r.this;
            rVar3.d.d(rVar3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2, int i3) {
            AbstractC4980Hj5.b(i3 == 1, "moving more than 1 item is not supported in RecyclerView");
            r rVar = r.this;
            rVar.d.c(rVar, i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f(int i, int i2) {
            r rVar = r.this;
            rVar.e -= i2;
            rVar.d.f(rVar, i, i2);
            r rVar2 = r.this;
            if (rVar2.e >= 1 || rVar2.c.getStateRestorationPolicy() != RecyclerView.h.a.PREVENT_WHEN_EMPTY) {
                return;
            }
            r rVar3 = r.this;
            rVar3.d.d(rVar3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void g() {
            r rVar = r.this;
            rVar.d.d(rVar);
        }
    }

    interface b {
        void a(r rVar, int i, int i2, Object obj);

        void b(r rVar, int i, int i2);

        void c(r rVar, int i, int i2);

        void d(r rVar);

        void e(r rVar);

        void f(r rVar, int i, int i2);
    }

    r(RecyclerView.h hVar, b bVar, C c, z.d dVar) {
        this.c = hVar;
        this.d = bVar;
        this.a = c.b(this);
        this.b = dVar;
        this.e = hVar.getItemCount();
        hVar.registerAdapterDataObserver(this.f);
    }

    void a() {
        this.c.unregisterAdapterDataObserver(this.f);
        this.a.dispose();
    }

    int b() {
        return this.e;
    }

    public long c(int i) {
        return this.b.a(this.c.getItemId(i));
    }

    int d(int i) {
        return this.a.b(this.c.getItemViewType(i));
    }

    void e(RecyclerView.C c, int i) {
        this.c.bindViewHolder(c, i);
    }

    RecyclerView.C f(ViewGroup viewGroup, int i) {
        return this.c.onCreateViewHolder(viewGroup, this.a.a(i));
    }
}
