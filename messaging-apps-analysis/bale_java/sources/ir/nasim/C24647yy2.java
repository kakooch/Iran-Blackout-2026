package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.yy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24647yy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FullWidthButtonPrimary b;
    public final TextView c;
    public final AppBarLayout d;
    public final RecyclerView e;
    public final BaleToolbar f;

    private C24647yy2(ConstraintLayout constraintLayout, FullWidthButtonPrimary fullWidthButtonPrimary, TextView textView, AppBarLayout appBarLayout, RecyclerView recyclerView, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = fullWidthButtonPrimary;
        this.c = textView;
        this.d = appBarLayout;
        this.e = recyclerView;
        this.f = baleToolbar;
    }

    public static C24647yy2 a(View view) {
        int i = BC5.continueCard;
        FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
        if (fullWidthButtonPrimary != null) {
            i = BC5.description;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.market_gender_appbar;
                AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                if (appBarLayout != null) {
                    i = BC5.recycler;
                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                    if (recyclerView != null) {
                        i = BC5.toolbar;
                        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                        if (baleToolbar != null) {
                            return new C24647yy2((ConstraintLayout) view, fullWidthButtonPrimary, textView, appBarLayout, recyclerView, baleToolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24647yy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_market_gender_selector, viewGroup, false);
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
