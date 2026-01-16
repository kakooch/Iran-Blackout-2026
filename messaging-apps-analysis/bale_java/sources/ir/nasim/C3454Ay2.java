package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Ay2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3454Ay2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppBarLayout b;
    public final CardView c;
    public final RecyclerView d;
    public final ImageView e;
    public final EditText f;
    public final LinearLayout g;
    public final TextView h;
    public final RecyclerView i;
    public final BaleToolbar j;

    private C3454Ay2(LinearLayout linearLayout, AppBarLayout appBarLayout, CardView cardView, RecyclerView recyclerView, ImageView imageView, EditText editText, LinearLayout linearLayout2, TextView textView, RecyclerView recyclerView2, BaleToolbar baleToolbar) {
        this.a = linearLayout;
        this.b = appBarLayout;
        this.c = cardView;
        this.d = recyclerView;
        this.e = imageView;
        this.f = editText;
        this.g = linearLayout2;
        this.h = textView;
        this.i = recyclerView2;
        this.j = baleToolbar;
    }

    public static C3454Ay2 a(View view) {
        int i = AbstractC14017hC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC14017hC5.card;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = AbstractC14017hC5.category_recycler;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = AbstractC14017hC5.clear;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = AbstractC14017hC5.editTxt;
                        EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                        if (editText != null) {
                            i = AbstractC14017hC5.nothingLayout;
                            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                            if (linearLayout != null) {
                                i = AbstractC14017hC5.nothingTitle;
                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView != null) {
                                    i = AbstractC14017hC5.search_suggestion_recycler;
                                    RecyclerView recyclerView2 = (RecyclerView) AbstractC11738dW7.a(view, i);
                                    if (recyclerView2 != null) {
                                        i = AbstractC14017hC5.toolbar;
                                        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                        if (baleToolbar != null) {
                                            return new C3454Ay2((LinearLayout) view, appBarLayout, cardView, recyclerView, imageView, editText, linearLayout, textView, recyclerView2, baleToolbar);
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

    public static C3454Ay2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.fragment_market_search, viewGroup, false);
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
