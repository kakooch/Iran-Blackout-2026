package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.dy2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12059dy2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final FrameLayout b;
    public final RecyclerView c;
    public final O50 d;
    public final LinearLayout e;
    public final ConstraintLayout f;
    public final View g;

    private C12059dy2(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, O50 o50, LinearLayout linearLayout, ConstraintLayout constraintLayout, View view) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = recyclerView;
        this.d = o50;
        this.e = linearLayout;
        this.f = constraintLayout;
        this.g = view;
    }

    public static C12059dy2 a(View view) {
        View viewA;
        View viewA2;
        FrameLayout frameLayout = (FrameLayout) view;
        int i = AbstractC12808fC5.discover_rv;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.progress_bar_view))) != null) {
            O50 o50A = O50.a(viewA);
            i = AbstractC12808fC5.progressLayout;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC12808fC5.root_rv;
                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                if (constraintLayout != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.snack_bar_anchor_view))) != null) {
                    return new C12059dy2(frameLayout, frameLayout, recyclerView, o50A, linearLayout, constraintLayout, viewA2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C12059dy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.fragment_discover, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
