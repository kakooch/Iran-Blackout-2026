package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Lf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5878Lf3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final RecyclerView c;

    private C5878Lf3(LinearLayout linearLayout, TextView textView, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = textView;
        this.c = recyclerView;
    }

    public static C5878Lf3 a(View view) {
        int i = BC5.menuTitle;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.menus;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                return new C5878Lf3((LinearLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5878Lf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_row_menu, viewGroup, false);
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
