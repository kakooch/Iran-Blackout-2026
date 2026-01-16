package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Ax2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3445Ax2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final BaleToolbar b;
    public final TextView c;
    public final RecyclerView d;

    private C3445Ax2(LinearLayout linearLayout, BaleToolbar baleToolbar, TextView textView, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = baleToolbar;
        this.c = textView;
        this.d = recyclerView;
    }

    public static C3445Ax2 a(View view) {
        int i = BC5.block_list_toolbar;
        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
        if (baleToolbar != null) {
            i = BC5.emptyView;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.listView;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    return new C3445Ax2((LinearLayout) view, baleToolbar, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3445Ax2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_blocked_settings, viewGroup, false);
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
