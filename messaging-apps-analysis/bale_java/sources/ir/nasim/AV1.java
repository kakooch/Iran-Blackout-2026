package ir.nasim;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C;
import ir.nasim.AbstractC17902nl0;
import ir.nasim.AbstractC22588vV1;
import ir.nasim.HB3;
import ir.nasim.YR1;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes5.dex */
public abstract class AV1<T extends AbstractC17902nl0 & HB3, V extends RecyclerView.C> extends C22042ua0 implements AbstractC22588vV1.e, YR1.e {
    private RecyclerView c1;
    private LinearLayoutManager d1;
    private C19024pf0 e1;
    private AbstractC21435tf0 f1;
    private boolean g1 = false;
    private boolean h1 = false;
    private boolean i1 = false;
    private RecyclerView.t j1;
    private RecyclerView.t k1;

    class a extends RecyclerView.t {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            for (int i3 = 0; i3 < AV1.this.c1.getChildCount(); i3++) {
                View childAt = recyclerView.getChildAt(i3);
                RecyclerView.C childViewHolder = recyclerView.getChildViewHolder(childAt);
                if (childViewHolder instanceof C20649sN1) {
                    C20649sN1 c20649sN1 = (C20649sN1) childViewHolder;
                    if (childAt.getGlobalVisibleRect(new Rect())) {
                        c20649sN1.Y0();
                    }
                }
            }
        }
    }

    class b extends LinearLayoutManager {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public void L1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
            C8697Wz3 c8697Wz3 = new C8697Wz3(recyclerView.getContext());
            c8697Wz3.p(i);
            M1(c8697Wz3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public boolean P1() {
            return false;
        }
    }

    class c extends RecyclerView.t {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                recyclerView.removeOnScrollListener(this);
            } else {
                recyclerView.removeOnScrollListener(this);
                if (AV1.this.ha()) {
                    AV1.this.c1.scrollToPosition(0);
                }
            }
        }
    }

    private void R9(RecyclerView.h hVar, View view) {
        if (hVar instanceof RU2) {
            ((RU2) hVar).A(view);
            return;
        }
        RU2 ru2 = new RU2(this.f1);
        ru2.A(view);
        this.c1.setAdapter(ru2);
    }

    private void T9(RecyclerView.h hVar, View view, boolean z) {
        if (hVar instanceof RU2) {
            RU2 ru2 = (RU2) hVar;
            ru2.I(z);
            ru2.B(view);
        } else {
            RU2 ru22 = new RU2(this.f1, z);
            ru22.B(view);
            this.c1.setAdapter(ru22);
        }
    }

    private void U9() {
        this.c1.addOnScrollListener(new a());
    }

    private void Z9() {
        if (!this.i1 || this.h1) {
            AbstractC21435tf0 abstractC21435tf0 = this.f1;
            if (abstractC21435tf0 != null) {
                abstractC21435tf0.H();
            }
            C19024pf0 c19024pf0 = this.e1;
            if (c19024pf0 != null) {
                c19024pf0.u(this);
            }
        }
    }

    private void aa() {
        if (this.i1) {
            return;
        }
        ja();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ha() {
        RecyclerView recyclerView = this.c1;
        return (recyclerView == null || recyclerView.getAdapter() == null || this.c1.getAdapter().getItemCount() <= 0) ? false : true;
    }

    private Boolean na() {
        return Boolean.valueOf(getUnbindOnPause() || getUnSubscribeOnPause());
    }

    @Override // ir.nasim.YR1.e
    public void C0() {
        if (ha()) {
            if (this.j1 == null) {
                this.j1 = new c();
            }
            this.c1.removeOnScrollListener(this.j1);
            this.c1.addOnScrollListener(this.j1);
            this.c1.smoothScrollToPosition(0);
        }
    }

    protected void Q9(View view) {
        RecyclerView.h adapter = this.c1.getAdapter();
        if (!(adapter instanceof androidx.recyclerview.widget.f)) {
            R9(adapter, view);
            return;
        }
        androidx.recyclerview.widget.f fVar = (androidx.recyclerview.widget.f) adapter;
        RecyclerView.h hVar = (RecyclerView.h) fVar.B().get(0);
        if (hVar instanceof RU2) {
            ((RU2) hVar).B(view);
            return;
        }
        RU2 ru2 = new RU2(this.f1);
        ru2.A(view);
        fVar.D(hVar);
        fVar.z(0, ru2);
        this.c1.setAdapter(fVar);
    }

    protected void S9(View view, boolean z) {
        RecyclerView.h adapter = this.c1.getAdapter();
        if (!(adapter instanceof androidx.recyclerview.widget.f)) {
            T9(adapter, view, z);
            return;
        }
        androidx.recyclerview.widget.f fVar = (androidx.recyclerview.widget.f) adapter;
        RecyclerView.h hVar = (RecyclerView.h) fVar.B().get(0);
        if (hVar instanceof RU2) {
            RU2 ru2 = (RU2) hVar;
            ru2.I(z);
            ru2.B(view);
        } else {
            RU2 ru22 = new RU2(this.f1, z);
            ru22.B(view);
            fVar.D(hVar);
            fVar.z(0, ru22);
            this.c1.setAdapter(fVar);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        if (!na().booleanValue()) {
            Z9();
        }
        AbstractC21435tf0 abstractC21435tf0 = this.f1;
        if (abstractC21435tf0 != null) {
            if (!abstractC21435tf0.E()) {
                this.f1.B();
            }
            this.f1 = null;
        }
        C19024pf0 c19024pf0 = this.e1;
        if (c19024pf0 != null) {
            c19024pf0.u(this);
            this.e1.j();
        }
        RecyclerView recyclerView = this.c1;
        if (recyclerView != null) {
            RecyclerView.t tVar = this.j1;
            if (tVar != null) {
                recyclerView.removeOnScrollListener(tVar);
                this.j1 = null;
            }
            this.c1.setAdapter(null);
        }
        this.c1 = null;
    }

    protected void V9(View view, C19024pf0 c19024pf0) {
        W9(view, c19024pf0, A5(), new RecyclerView.h[0]);
    }

    protected void W9(View view, C19024pf0 c19024pf0, Context context, RecyclerView.h... hVarArr) {
        this.c1 = (RecyclerView) view.findViewById(BC5.collection);
        if (c19024pf0.r() == 0 && hVarArr.length == 0) {
            this.c1.setVisibility(4);
        } else {
            this.c1.setVisibility(0);
        }
        ka(true);
        la(c19024pf0);
        Y9(this.c1);
        AbstractC21435tf0 abstractC21435tf0Ia = ia(c19024pf0, context);
        this.f1 = abstractC21435tf0Ia;
        if (hVarArr.length > 0) {
            ArrayList arrayList = new ArrayList(AbstractC22311v13.a(hVarArr));
            arrayList.add(0, this.f1);
            this.c1.setAdapter(new androidx.recyclerview.widget.f(arrayList));
        } else {
            this.c1.setAdapter(abstractC21435tf0Ia);
        }
        RecyclerView.t tVar = this.k1;
        if (tVar != null) {
            this.c1.addOnScrollListener(tVar);
        }
    }

    public void X0() {
        if (this.e1.r() == 0) {
            e9(this.c1, false);
        } else {
            L9(this.c1, false);
        }
    }

    protected void X9(View view, C19024pf0 c19024pf0, RecyclerView.h... hVarArr) {
        W9(view, c19024pf0, A5(), hVarArr);
    }

    protected void Y9(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        if (!this.g1) {
            b bVar = new b(A5());
            this.d1 = bVar;
            bVar.G2(false);
            this.d1.I2(false);
            recyclerView.setLayoutManager(this.d1);
            recyclerView.setHorizontalScrollBarEnabled(false);
            recyclerView.setVerticalScrollBarEnabled(true);
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(G5(), C17045mI6.c(), 1, false);
        this.d1 = gridLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new C10231bI6(C17045mI6.a.a()));
        if (JF5.g()) {
            JF5.b(recyclerView);
        }
    }

    public AbstractC21435tf0 ba() {
        return this.f1;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        if (na().booleanValue()) {
            Z9();
        }
    }

    public RecyclerView ca() {
        return this.c1;
    }

    public C19024pf0 da() {
        return this.e1;
    }

    protected void ea() {
        if (this.e1.r() == 0) {
            e9(this.c1, false);
        } else {
            L9(this.c1, false);
        }
    }

    protected View fa(LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C19024pf0 c19024pf0, boolean z) {
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        if (c19024pf0 != null) {
            V9(viewInflate, c19024pf0);
        }
        this.g1 = z;
        return viewInflate;
    }

    protected View ga(LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C19024pf0 c19024pf0, boolean z, boolean z2, RecyclerView.h... hVarArr) {
        B8(z2);
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        if (c19024pf0 != null) {
            X9(viewInflate, c19024pf0, hVarArr);
        }
        this.g1 = z;
        return viewInflate;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        if (na().booleanValue()) {
            aa();
        }
    }

    protected abstract AbstractC21435tf0 ia(C19024pf0 c19024pf0, Context context);

    protected void ja() {
        AbstractC21435tf0 abstractC21435tf0 = this.f1;
        if (abstractC21435tf0 == null || this.e1 == null) {
            return;
        }
        abstractC21435tf0.I();
        this.e1.i(this);
        ea();
    }

    protected void ka(boolean z) {
        if (!z) {
            this.c1.setItemAnimator(null);
            return;
        }
        androidx.recyclerview.widget.h hVar = new androidx.recyclerview.widget.h();
        hVar.V(false);
        hVar.z(200L);
        hVar.w(150L);
        hVar.A(200L);
        this.c1.setItemAnimator(hVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        super.l7(view, bundle);
        U9();
        if (na().booleanValue()) {
            return;
        }
        aa();
    }

    public void la(C19024pf0 c19024pf0) {
        this.e1 = c19024pf0;
    }

    public void ma(RecyclerView.t tVar) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView.t tVar2 = this.k1;
        if (tVar2 != null && (recyclerView2 = this.c1) != null) {
            recyclerView2.removeOnScrollListener(tVar2);
        }
        this.k1 = tVar;
        if (tVar == null || (recyclerView = this.c1) == null) {
            return;
        }
        recyclerView.addOnScrollListener(tVar);
    }
}
