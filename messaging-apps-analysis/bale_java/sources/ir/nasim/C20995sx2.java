package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.sx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20995sx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final RecyclerView c;
    public final TextView d;
    public final BaleToolbar e;

    private C20995sx2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, RecyclerView recyclerView, TextView textView, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = recyclerView;
        this.d = textView;
        this.e = baleToolbar;
    }

    public static C20995sx2 a(View view) {
        int i = BC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.arbaeen_suggestion_recycler;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                i = BC5.title;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.toolbar;
                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                    if (baleToolbar != null) {
                        return new C20995sx2((ConstraintLayout) view, appBarLayout, recyclerView, textView, baleToolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C20995sx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_arbaeen_last_viewer_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
