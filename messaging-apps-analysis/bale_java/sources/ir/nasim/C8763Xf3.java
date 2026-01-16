package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Xf3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8763Xf3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final ConstraintLayout c;
    public final RecyclerView d;
    public final TextView e;

    private C8763Xf3(LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = constraintLayout;
        this.d = recyclerView;
        this.e = textView2;
    }

    public static C8763Xf3 a(View view) {
        int i = AbstractC14017hC5.action;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = AbstractC14017hC5.bar;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = AbstractC14017hC5.recycler;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = AbstractC14017hC5.title;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C8763Xf3((LinearLayout) view, textView, constraintLayout, recyclerView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C8763Xf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.item_search_row_suggestion, viewGroup, false);
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
