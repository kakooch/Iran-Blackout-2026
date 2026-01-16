package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public final class U80 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final RecyclerView b;
    public final RecyclerView c;

    private U80(LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.a = linearLayout;
        this.b = recyclerView;
        this.c = recyclerView2;
    }

    public static U80 a(View view) {
        int i = AbstractC12808fC5.banner_slider_rv;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC12808fC5.indicator;
            RecyclerView recyclerView2 = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView2 != null) {
                return new U80((LinearLayout) view, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static U80 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.banner_row_holder, viewGroup, false);
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
