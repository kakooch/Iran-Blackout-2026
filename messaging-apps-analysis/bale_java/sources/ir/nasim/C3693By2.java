package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.By2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3693By2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppBarLayout b;
    public final CardView c;
    public final ImageView d;
    public final EditText e;
    public final TabLayout f;
    public final BaleToolbar g;
    public final ViewPager2 h;

    private C3693By2(LinearLayout linearLayout, AppBarLayout appBarLayout, CardView cardView, ImageView imageView, EditText editText, TabLayout tabLayout, BaleToolbar baleToolbar, ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.b = appBarLayout;
        this.c = cardView;
        this.d = imageView;
        this.e = editText;
        this.f = tabLayout;
        this.g = baleToolbar;
        this.h = viewPager2;
    }

    public static C3693By2 a(View view) {
        int i = AbstractC14017hC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC14017hC5.card;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = AbstractC14017hC5.clear;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC14017hC5.editTxt;
                    EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                    if (editText != null) {
                        i = AbstractC14017hC5.tabLayout;
                        TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                        if (tabLayout != null) {
                            i = AbstractC14017hC5.toolbar;
                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                            if (baleToolbar != null) {
                                i = AbstractC14017hC5.viewPager;
                                ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                                if (viewPager2 != null) {
                                    return new C3693By2((LinearLayout) view, appBarLayout, cardView, imageView, editText, tabLayout, baleToolbar, viewPager2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3693By2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.fragment_market_search_result, viewGroup, false);
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
