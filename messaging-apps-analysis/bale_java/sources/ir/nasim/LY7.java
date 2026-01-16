package ir.nasim;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.LY7;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class LY7 {
    private long a;
    private boolean b;
    private final ArrayList c;
    private final ArrayList d;
    private final double e;
    private int f;
    private Handler g;
    private boolean h;
    private final a i;

    public static final class a implements Runnable {
        final /* synthetic */ RecyclerView b;

        a(RecyclerView recyclerView) {
            this.b = recyclerView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "it");
            return C19938rB7.a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LY7.this.h) {
                RecyclerView.p layoutManager = this.b.getLayoutManager();
                AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (LY7.this.f == ((LinearLayoutManager) layoutManager).d2()) {
                    if (System.currentTimeMillis() - LY7.this.a >= 1000) {
                        LY7.this.n(this.b, new UA2() { // from class: ir.nasim.KY7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return LY7.a.b((C5886Lg2) obj);
                            }
                        });
                    } else {
                        LY7.this.g.postDelayed(this, 200L);
                    }
                }
            }
        }
    }

    public static final class b extends RecyclerView.t {
        final /* synthetic */ RecyclerView b;
        final /* synthetic */ UA2 c;

        b(RecyclerView recyclerView, UA2 ua2) {
            this.b = recyclerView;
            this.c = ua2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            C4743Gj2 c4743Gj2F3;
            C5886Lg2 c5886Lg2E;
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i == 0) {
                LY7.this.a = System.currentTimeMillis();
                RecyclerView.p layoutManager = recyclerView.getLayoutManager();
                AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                RecyclerView.C cFindViewHolderForAdapterPosition = this.b.findViewHolderForAdapterPosition(((LinearLayoutManager) layoutManager).d2());
                AbstractC10505bj2 abstractC10505bj2 = cFindViewHolderForAdapterPosition instanceof AbstractC10505bj2 ? (AbstractC10505bj2) cFindViewHolderForAdapterPosition : null;
                if (abstractC10505bj2 == null || (c4743Gj2F3 = abstractC10505bj2.f3()) == null || (c5886Lg2E = c4743Gj2F3.e()) == null) {
                    return;
                }
                this.c.invoke(c5886Lg2E);
            }
        }
    }

    public LY7(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 51.0d;
        this.f = -1;
        this.g = new Handler(Looper.getMainLooper());
        this.i = new a(recyclerView);
    }

    private final void h(int i, int i2, RecyclerView recyclerView) {
        if (i > i2) {
            return;
        }
        while (true) {
            C19406qI3.g("View being considered", String.valueOf(i), new Object[0]);
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            if (j(layoutManager != null ? layoutManager.D(i) : null) >= this.e) {
                this.c.add(Integer.valueOf(i));
            }
            if (i == i2) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void i(RecyclerView recyclerView, UA2 ua2) {
        C4743Gj2 c4743Gj2F3;
        C5886Lg2 c5886Lg2E;
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        Integer numValueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.d2()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
            AbstractC10505bj2 abstractC10505bj2 = cFindViewHolderForAdapterPosition instanceof AbstractC10505bj2 ? (AbstractC10505bj2) cFindViewHolderForAdapterPosition : null;
            if (abstractC10505bj2 == null || (c4743Gj2F3 = abstractC10505bj2.f3()) == null || (c5886Lg2E = c4743Gj2F3.e()) == null) {
                return;
            }
            ua2.invoke(c5886Lg2E);
        }
    }

    private final double j(View view) {
        if (view == null) {
            return 0.0d;
        }
        view.getLocalVisibleRect(new Rect());
        return (r0.height() / view.getMeasuredHeight()) * 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LY7 ly7, RecyclerView recyclerView, UA2 ua2) {
        AbstractC13042fc3.i(ly7, "this$0");
        AbstractC13042fc3.i(recyclerView, "$myRecyclerView");
        AbstractC13042fc3.i(ua2, "$onFeedVisible");
        if (!ly7.b) {
            ly7.a = System.currentTimeMillis();
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int iD2 = ((LinearLayoutManager) layoutManager).d2();
            RecyclerView.p layoutManager2 = recyclerView.getLayoutManager();
            AbstractC13042fc3.g(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ly7.h(iD2, ((LinearLayoutManager) layoutManager2).g2(), recyclerView);
            ly7.b = true;
            ly7.m(recyclerView);
        }
        ly7.i(recyclerView, ua2);
    }

    private final void m(RecyclerView recyclerView) {
        this.h = true;
        this.g.post(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(RecyclerView recyclerView, UA2 ua2) {
        C4743Gj2 c4743Gj2F3;
        C5886Lg2 c5886Lg2E;
        RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this.f);
        AbstractC10505bj2 abstractC10505bj2 = cFindViewHolderForAdapterPosition instanceof AbstractC10505bj2 ? (AbstractC10505bj2) cFindViewHolderForAdapterPosition : null;
        if (abstractC10505bj2 == null || (c4743Gj2F3 = abstractC10505bj2.f3()) == null || (c5886Lg2E = c4743Gj2F3.e()) == null) {
            return;
        }
        ua2.invoke(c5886Lg2E);
    }

    public final void k(final RecyclerView recyclerView, final UA2 ua2) {
        AbstractC13042fc3.i(recyclerView, "myRecyclerView");
        AbstractC13042fc3.i(ua2, "onFeedVisible");
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.JY7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                LY7.l(this.a, recyclerView, ua2);
            }
        });
        recyclerView.addOnScrollListener(new b(recyclerView, ua2));
    }
}
