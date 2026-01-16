package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.wy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23467wy2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final O50 c;
    public final LinearLayout d;
    public final RecyclerView e;
    public final View f;

    private C23467wy2(LinearLayout linearLayout, LinearLayout linearLayout2, O50 o50, LinearLayout linearLayout3, RecyclerView recyclerView, View view) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = o50;
        this.d = linearLayout3;
        this.e = recyclerView;
        this.f = view;
    }

    public static C23467wy2 a(View view) {
        View viewA;
        LinearLayout linearLayout = (LinearLayout) view;
        int i = BC5.progress_bar_view;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null) {
            O50 o50A = O50.a(viewA2);
            i = BC5.progressLayout;
            LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout2 != null) {
                i = BC5.rows;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.snack_bar_anchor_view))) != null) {
                    return new C23467wy2(linearLayout, linearLayout, o50A, linearLayout2, recyclerView, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23467wy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_market, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
