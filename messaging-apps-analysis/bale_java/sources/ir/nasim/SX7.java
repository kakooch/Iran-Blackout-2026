package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC15520jj2;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class SX7 {
    private long a;
    private long b;
    private boolean c;
    private final ArrayList d = new ArrayList();
    private final ArrayList e = new ArrayList();
    private final double f = 51.0d;

    public static final class a extends RecyclerView.t {
        final /* synthetic */ RecyclerView b;
        final /* synthetic */ InterfaceC16978mB2 c;
        final /* synthetic */ InterfaceC14603iB2 d;

        a(RecyclerView recyclerView, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.b = recyclerView;
            this.c = interfaceC16978mB2;
            this.d = interfaceC14603iB2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            C4743Gj2 c4743Gj2F3;
            C5886Lg2 c5886Lg2E;
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i == 1) {
                SX7.this.b = System.currentTimeMillis();
                Iterator it = SX7.this.d.iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    AbstractC13042fc3.h(next, "next(...)");
                    RecyclerView.C cFindViewHolderForAdapterPosition = this.b.findViewHolderForAdapterPosition(((Number) next).intValue());
                    AbstractC10505bj2 abstractC10505bj2 = cFindViewHolderForAdapterPosition instanceof AbstractC10505bj2 ? (AbstractC10505bj2) cFindViewHolderForAdapterPosition : null;
                    long j = SX7.this.b - SX7.this.a;
                    if (abstractC10505bj2 != null && (c4743Gj2F3 = abstractC10505bj2.f3()) != null && (c5886Lg2E = c4743Gj2F3.e()) != null) {
                        InterfaceC16978mB2 interfaceC16978mB2 = this.c;
                        InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                        if (c5886Lg2E.i() instanceof AbstractC15520jj2.h) {
                            interfaceC16978mB2.e(Integer.valueOf((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), Integer.valueOf(((AbstractC15520jj2.h) c5886Lg2E.i()).h()), Integer.valueOf(((int) C24480yh2.a.c().D0()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), c5886Lg2E);
                        } else {
                            interfaceC14603iB2.invoke(Integer.valueOf((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), c5886Lg2E);
                        }
                    }
                }
                SX7.this.d.clear();
            }
            if (i == 0) {
                SX7.this.a = System.currentTimeMillis();
                RecyclerView.p layoutManager = recyclerView.getLayoutManager();
                AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int iD2 = ((LinearLayoutManager) layoutManager).d2();
                RecyclerView.p layoutManager2 = recyclerView.getLayoutManager();
                AbstractC13042fc3.g(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                SX7.this.h(iD2, ((LinearLayoutManager) layoutManager2).g2(), this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int i, int i2, RecyclerView recyclerView) {
        if (i > i2) {
            return;
        }
        while (true) {
            C19406qI3.g("View being considered", String.valueOf(i), new Object[0]);
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            if (i(layoutManager != null ? layoutManager.D(i) : null) >= this.f) {
                this.d.add(Integer.valueOf(i));
            }
            if (i == i2) {
                return;
            } else {
                i++;
            }
        }
    }

    private final double i(View view) {
        if (view == null) {
            return 0.0d;
        }
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        double dHeight = rect.height();
        double measuredHeight = view.getMeasuredHeight();
        C19406qI3.g("Visible Height", String.valueOf(dHeight), new Object[0]);
        C19406qI3.g("Measured Height", String.valueOf(measuredHeight), new Object[0]);
        double d = (dHeight / measuredHeight) * 100;
        C19406qI3.g("Percentage visible", String.valueOf(d), new Object[0]);
        C19406qI3.g("___", "___", new Object[0]);
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SX7 sx7, RecyclerView recyclerView) {
        AbstractC13042fc3.i(sx7, "this$0");
        AbstractC13042fc3.i(recyclerView, "$myRecyclerView");
        if (sx7.c) {
            return;
        }
        sx7.a = System.currentTimeMillis();
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iD2 = ((LinearLayoutManager) layoutManager).d2();
        RecyclerView.p layoutManager2 = recyclerView.getLayoutManager();
        AbstractC13042fc3.g(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        sx7.h(iD2, ((LinearLayoutManager) layoutManager2).g2(), recyclerView);
        sx7.c = true;
    }

    public final void j(final RecyclerView recyclerView, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(recyclerView, "myRecyclerView");
        AbstractC13042fc3.i(interfaceC16978mB2, "sendPostDurationEventVideo");
        AbstractC13042fc3.i(interfaceC14603iB2, "sendPostDurationEventSimple");
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.RX7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                SX7.k(this.a, recyclerView);
            }
        });
        recyclerView.addOnScrollListener(new a(recyclerView, interfaceC16978mB2, interfaceC14603iB2));
    }

    public final void l(RecyclerView recyclerView, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC14603iB2 interfaceC14603iB2) {
        C4743Gj2 c4743Gj2F3;
        C5886Lg2 c5886Lg2E;
        AbstractC13042fc3.i(recyclerView, "myRecyclerView");
        AbstractC13042fc3.i(interfaceC16978mB2, "sendPostDurationEventVideo");
        AbstractC13042fc3.i(interfaceC14603iB2, "sendPostDurationEventSimple");
        this.b = System.currentTimeMillis();
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).d2();
        RecyclerView.p layoutManager2 = recyclerView.getLayoutManager();
        AbstractC13042fc3.g(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager2).g2();
        Iterator it = this.d.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(((Number) next).intValue());
            AbstractC10505bj2 abstractC10505bj2 = cFindViewHolderForAdapterPosition instanceof AbstractC10505bj2 ? (AbstractC10505bj2) cFindViewHolderForAdapterPosition : null;
            long j = this.b - this.a;
            if (abstractC10505bj2 != null && (c4743Gj2F3 = abstractC10505bj2.f3()) != null && (c5886Lg2E = c4743Gj2F3.e()) != null) {
                if (c5886Lg2E.i() instanceof AbstractC15520jj2.h) {
                    interfaceC16978mB2.e(Integer.valueOf((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), Integer.valueOf(((AbstractC15520jj2.h) c5886Lg2E.i()).h()), Integer.valueOf(((int) C24480yh2.a.c().D0()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), c5886Lg2E);
                } else {
                    interfaceC14603iB2.invoke(Integer.valueOf((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), c5886Lg2E);
                }
            }
        }
        this.d.clear();
        this.a = System.currentTimeMillis();
    }
}
