package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.Vy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8433Vy2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final BaleToolbar b;
    public final ImageView c;
    public final BaleToolbar d;
    public final ViewPager2 e;
    public final FrameLayout f;
    public final AppBarLayout g;
    public final LinearLayout h;
    public final RelativeLayout i;
    public final ConstraintLayout j;
    public final AppBarLayout k;
    public final ProgressBar l;
    public final FullWidthButtonPrimary m;
    public final TabLayout n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;

    private C8433Vy2(FrameLayout frameLayout, BaleToolbar baleToolbar, ImageView imageView, BaleToolbar baleToolbar2, ViewPager2 viewPager2, FrameLayout frameLayout2, AppBarLayout appBarLayout, LinearLayout linearLayout, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, AppBarLayout appBarLayout2, ProgressBar progressBar, FullWidthButtonPrimary fullWidthButtonPrimary, TabLayout tabLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.a = frameLayout;
        this.b = baleToolbar;
        this.c = imageView;
        this.d = baleToolbar2;
        this.e = viewPager2;
        this.f = frameLayout2;
        this.g = appBarLayout;
        this.h = linearLayout;
        this.i = relativeLayout;
        this.j = constraintLayout;
        this.k = appBarLayout2;
        this.l = progressBar;
        this.m = fullWidthButtonPrimary;
        this.n = tabLayout;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
    }

    public static C8433Vy2 a(View view) {
        int i = BC5.empty_toolbar;
        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
        if (baleToolbar != null) {
            i = BC5.imageView_default;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.main_toolbar;
                BaleToolbar baleToolbar2 = (BaleToolbar) AbstractC11738dW7.a(view, i);
                if (baleToolbar2 != null) {
                    i = BC5.pager;
                    ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                    if (viewPager2 != null) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        i = BC5.pfm_empty_appbar;
                        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                        if (appBarLayout != null) {
                            i = BC5.pfm_empty_layout_default;
                            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                            if (linearLayout != null) {
                                i = BC5.pfm_empty_layout_expanded;
                                RelativeLayout relativeLayout = (RelativeLayout) AbstractC11738dW7.a(view, i);
                                if (relativeLayout != null) {
                                    i = BC5.pfm_layout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                    if (constraintLayout != null) {
                                        i = BC5.pfm_main_appbar;
                                        AppBarLayout appBarLayout2 = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                        if (appBarLayout2 != null) {
                                            i = BC5.pfm_pb;
                                            ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                                            if (progressBar != null) {
                                                i = BC5.report_btn;
                                                FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
                                                if (fullWidthButtonPrimary != null) {
                                                    i = BC5.tab_layout;
                                                    TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                                                    if (tabLayout != null) {
                                                        i = BC5.textView_how_active;
                                                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView != null) {
                                                            i = BC5.txt_1;
                                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView2 != null) {
                                                                i = BC5.txt2;
                                                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView3 != null) {
                                                                    i = BC5.txt_3;
                                                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView4 != null) {
                                                                        i = BC5.txt_4;
                                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView5 != null) {
                                                                            return new C8433Vy2(frameLayout, baleToolbar, imageView, baleToolbar2, viewPager2, frameLayout, appBarLayout, linearLayout, relativeLayout, constraintLayout, appBarLayout2, progressBar, fullWidthButtonPrimary, tabLayout, textView, textView2, textView3, textView4, textView5);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C8433Vy2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C8433Vy2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_pfm_container, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
