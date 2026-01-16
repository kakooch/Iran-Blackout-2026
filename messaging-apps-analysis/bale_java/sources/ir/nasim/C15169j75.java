package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.j75, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15169j75 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FullWidthButtonPrimary b;
    public final AppBarLayout c;
    public final CollapsingToolbarLayout d;
    public final MaterialCardView e;
    public final ConstraintLayout f;
    public final TextView g;
    public final RecyclerView h;
    public final AppBarLayout i;
    public final BaleToolbar j;
    public final TextView k;
    public final EditText l;
    public final ImageView m;
    public final TextView n;

    private C15169j75(ConstraintLayout constraintLayout, FullWidthButtonPrimary fullWidthButtonPrimary, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, MaterialCardView materialCardView, ConstraintLayout constraintLayout2, TextView textView, RecyclerView recyclerView, AppBarLayout appBarLayout2, BaleToolbar baleToolbar, TextView textView2, EditText editText, ImageView imageView, TextView textView3) {
        this.a = constraintLayout;
        this.b = fullWidthButtonPrimary;
        this.c = appBarLayout;
        this.d = collapsingToolbarLayout;
        this.e = materialCardView;
        this.f = constraintLayout2;
        this.g = textView;
        this.h = recyclerView;
        this.i = appBarLayout2;
        this.j = baleToolbar;
        this.k = textView2;
        this.l = editText;
        this.m = imageView;
        this.n = textView3;
    }

    public static C15169j75 a(View view) {
        int i = BC5.button_done;
        FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
        if (fullWidthButtonPrimary != null) {
            i = BC5.pfm_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null) {
                i = BC5.pfm_ct;
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) AbstractC11738dW7.a(view, i);
                if (collapsingToolbarLayout != null) {
                    i = BC5.pfm_search;
                    MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                    if (materialCardView != null) {
                        i = BC5.pfm_search_inner_container;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            i = BC5.pfm_sub_tag_selection_detail;
                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView != null) {
                                i = BC5.recycler_view_tags;
                                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                if (recyclerView != null) {
                                    i = BC5.set_sub_tag_appbar;
                                    AppBarLayout appBarLayout2 = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                    if (appBarLayout2 != null) {
                                        i = BC5.set_sub_tag_toolbar;
                                        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                        if (baleToolbar != null) {
                                            i = BC5.tag_not_found;
                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView2 != null) {
                                                i = BC5.tag_search;
                                                EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                                if (editText != null) {
                                                    i = BC5.tag_search_icon;
                                                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView != null) {
                                                        i = BC5.transaction_tag_title;
                                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView3 != null) {
                                                            return new C15169j75((ConstraintLayout) view, fullWidthButtonPrimary, appBarLayout, collapsingToolbarLayout, materialCardView, constraintLayout, textView, recyclerView, appBarLayout2, baleToolbar, textView2, editText, imageView, textView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15169j75 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.pfm_set_sub_tag_fragment, viewGroup, false);
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
