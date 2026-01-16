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
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.zz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25250zz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FullWidthButtonPrimary b;
    public final TextView c;
    public final RecyclerView d;
    public final TextView e;
    public final ImageView f;
    public final EditText g;
    public final AppBarLayout h;
    public final BaleToolbar i;
    public final MaterialCardView j;
    public final ConstraintLayout k;

    private C25250zz2(ConstraintLayout constraintLayout, FullWidthButtonPrimary fullWidthButtonPrimary, TextView textView, RecyclerView recyclerView, TextView textView2, ImageView imageView, EditText editText, AppBarLayout appBarLayout, BaleToolbar baleToolbar, MaterialCardView materialCardView, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = fullWidthButtonPrimary;
        this.c = textView;
        this.d = recyclerView;
        this.e = textView2;
        this.f = imageView;
        this.g = editText;
        this.h = appBarLayout;
        this.i = baleToolbar;
        this.j = materialCardView;
        this.k = constraintLayout2;
    }

    public static C25250zz2 a(View view) {
        int i = BC5.button_done;
        FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
        if (fullWidthButtonPrimary != null) {
            i = BC5.privacy_selection_title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.recycler_view_contacts;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = BC5.search_empty_state;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.search_icon;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            i = BC5.search_text;
                            EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                            if (editText != null) {
                                i = BC5.story_privacy_selection_appbar;
                                AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                if (appBarLayout != null) {
                                    i = BC5.story_privacy_selection_toolbar;
                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                    if (baleToolbar != null) {
                                        i = BC5.story_search;
                                        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView != null) {
                                            i = BC5.story_search_inner_container;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                            if (constraintLayout != null) {
                                                return new C25250zz2((ConstraintLayout) view, fullWidthButtonPrimary, textView, recyclerView, textView2, imageView, editText, appBarLayout, baleToolbar, materialCardView, constraintLayout);
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

    public static C25250zz2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C25250zz2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_story_privacy_selection, viewGroup, false);
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
