package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C17111mQ0;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: ir.nasim.mQ0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17111mQ0 extends RecyclerView.t {
    private final Rect a = new Rect();
    private final HashSet b = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.mQ0$a */
    static final class a {
        private final InterfaceC7879To6 a;
        private final RecyclerView.C b;

        public a(InterfaceC7879To6 interfaceC7879To6, RecyclerView.C c) {
            AbstractC13042fc3.i(c, "viewHolder");
            this.a = interfaceC7879To6;
            this.b = c;
        }

        public final InterfaceC7879To6 a() {
            return this.a;
        }

        public final RecyclerView.C b() {
            return this.b;
        }

        public final InterfaceC7879To6 c() {
            return this.a;
        }

        public final RecyclerView.C d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            InterfaceC7879To6 interfaceC7879To6 = this.a;
            return ((interfaceC7879To6 == null ? 0 : interfaceC7879To6.hashCode()) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "VisibleContent(sensitiveHolder=" + this.a + ", viewHolder=" + this.b + Separators.RPAREN;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final a d(int i, RecyclerView recyclerView) {
        RecyclerView.C childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
        InterfaceC7879To6 interfaceC7879To6 = childViewHolder instanceof InterfaceC7879To6 ? (InterfaceC7879To6) childViewHolder : null;
        if (interfaceC7879To6 == null) {
            AbstractC13042fc3.f(childViewHolder);
            return new a(null, childViewHolder);
        }
        childViewHolder.a.getGlobalVisibleRect(this.a);
        return new a(interfaceC7879To6.l().intersect(this.a) ? interfaceC7879To6 : null, childViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(C24411ya3 c24411ya3, a aVar) {
        AbstractC13042fc3.i(c24411ya3, "$positionRange");
        AbstractC13042fc3.i(aVar, "<destruct>");
        InterfaceC7879To6 interfaceC7879To6A = aVar.a();
        RecyclerView.C cB = aVar.b();
        int iO = c24411ya3.o();
        int iT = c24411ya3.t();
        int iK = cB.K();
        boolean z = false;
        if (iO <= iK && iK <= iT) {
            z = true;
        }
        boolean z2 = !z;
        if (z2 && interfaceC7879To6A != null) {
            interfaceC7879To6A.f();
        }
        return z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i, int i2) {
        InterfaceC7879To6 interfaceC7879To6C;
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        super.b(recyclerView, i, i2);
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            a aVarD = d(i3, recyclerView);
            if (!this.b.contains(aVarD) && (interfaceC7879To6C = aVarD.c()) != null) {
                interfaceC7879To6C.v();
                this.b.add(aVarD);
            }
        }
        a aVarD2 = d(0, recyclerView);
        a aVarD3 = d(childCount - 1, recyclerView);
        int iK = aVarD2.c() == null ? aVarD2.d().K() + 1 : aVarD2.d().K();
        int iK2 = aVarD3.c() == null ? aVarD3.d().K() - 1 : aVarD3.d().K();
        if (iK <= iK2) {
            final C24411ya3 c24411ya3 = new C24411ya3(iK, iK2);
            AbstractC13610gX0.I(this.b, new UA2() { // from class: ir.nasim.lQ0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C17111mQ0.e(c24411ya3, (C17111mQ0.a) obj));
                }
            });
            return;
        }
        Iterator it = this.b.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            InterfaceC7879To6 interfaceC7879To6A = ((a) next).a();
            if (interfaceC7879To6A != null) {
                interfaceC7879To6A.f();
            }
        }
        this.b.clear();
    }
}
