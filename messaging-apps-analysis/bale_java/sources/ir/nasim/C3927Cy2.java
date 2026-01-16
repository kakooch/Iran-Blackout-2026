package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Cy2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3927Cy2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final RecyclerView f;
    public final TextView g;

    private C3927Cy2(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, RecyclerView recyclerView, TextView textView3) {
        this.a = linearLayout;
        this.b = constraintLayout;
        this.c = textView;
        this.d = linearLayout2;
        this.e = textView2;
        this.f = recyclerView;
        this.g = textView3;
    }

    public static C3927Cy2 a(View view) {
        int i = AbstractC14017hC5.countBar;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = AbstractC14017hC5.countResults;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC14017hC5.nothingLayout;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = AbstractC14017hC5.nothingTitle;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = AbstractC14017hC5.recycler;
                        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                        if (recyclerView != null) {
                            i = AbstractC14017hC5.title;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null) {
                                return new C3927Cy2((LinearLayout) view, constraintLayout, textView, linearLayout, textView2, recyclerView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3927Cy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.fragment_market_search_result_markets, viewGroup, false);
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
