package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.uz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22290uz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final RecyclerView b;

    private C22290uz2(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = recyclerView;
    }

    public static C22290uz2 a(View view) {
        int i = BC5.statementRecycler;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            return new C22290uz2((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C22290uz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_statement_list, viewGroup, false);
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
