package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.xy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24057xy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final TextView c;
    public final ImageView d;
    public final FullWidthButtonPrimary e;
    public final ConstraintLayout f;
    public final CardView g;
    public final TextView h;
    public final TextView i;
    public final AppBarLayout j;
    public final RecyclerView k;
    public final TextView l;
    public final BaleToolbar m;

    private C24057xy2(ConstraintLayout constraintLayout, CardView cardView, TextView textView, ImageView imageView, FullWidthButtonPrimary fullWidthButtonPrimary, ConstraintLayout constraintLayout2, CardView cardView2, TextView textView2, TextView textView3, AppBarLayout appBarLayout, RecyclerView recyclerView, TextView textView4, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = textView;
        this.d = imageView;
        this.e = fullWidthButtonPrimary;
        this.f = constraintLayout2;
        this.g = cardView2;
        this.h = textView2;
        this.i = textView3;
        this.j = appBarLayout;
        this.k = recyclerView;
        this.l = textView4;
        this.m = baleToolbar;
    }

    public static C24057xy2 a(View view) {
        int i = BC5.badgeCardView;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.badgeCount;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.badgeDone;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.continueCard;
                    FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
                    if (fullWidthButtonPrimary != null) {
                        i = BC5.countBar;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            i = BC5.countBarCard;
                            CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                            if (cardView2 != null) {
                                i = BC5.counter;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = BC5.description;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        i = BC5.market_category_appbar;
                                        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                        if (appBarLayout != null) {
                                            i = BC5.recycler;
                                            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                            if (recyclerView != null) {
                                                i = BC5.title;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    i = BC5.toolbar;
                                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                    if (baleToolbar != null) {
                                                        return new C24057xy2((ConstraintLayout) view, cardView, textView, imageView, fullWidthButtonPrimary, constraintLayout, cardView2, textView2, textView3, appBarLayout, recyclerView, textView4, baleToolbar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24057xy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_market_category_selector, viewGroup, false);
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
