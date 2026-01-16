package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.components.appbar.view.DrawerToolbar;
import ir.nasim.jaryan.JaryanSwipeToRefresh;

/* renamed from: ir.nasim.ly2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16850ly2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final CollapsingToolbarLayout c;
    public final MaterialButton d;
    public final ConstraintLayout e;
    public final CoordinatorLayout f;
    public final TabLayout g;
    public final ViewPager2 h;
    public final MaterialCardView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final AppBarLayout m;
    public final FrameLayout n;
    public final JaryanSwipeToRefresh o;
    public final ConstraintLayout p;
    public final DrawerToolbar q;
    public final ImageView r;

    private C16850ly2(ConstraintLayout constraintLayout, FrameLayout frameLayout, CollapsingToolbarLayout collapsingToolbarLayout, MaterialButton materialButton, ConstraintLayout constraintLayout2, CoordinatorLayout coordinatorLayout, TabLayout tabLayout, ViewPager2 viewPager2, MaterialCardView materialCardView, TextView textView, TextView textView2, View view, AppBarLayout appBarLayout, FrameLayout frameLayout2, JaryanSwipeToRefresh jaryanSwipeToRefresh, ConstraintLayout constraintLayout3, DrawerToolbar drawerToolbar, ImageView imageView) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = collapsingToolbarLayout;
        this.d = materialButton;
        this.e = constraintLayout2;
        this.f = coordinatorLayout;
        this.g = tabLayout;
        this.h = viewPager2;
        this.i = materialCardView;
        this.j = textView;
        this.k = textView2;
        this.l = view;
        this.m = appBarLayout;
        this.n = frameLayout2;
        this.o = jaryanSwipeToRefresh;
        this.p = constraintLayout3;
        this.q = drawerToolbar;
        this.r = imageView;
    }

    public static C16850ly2 a(View view) {
        View viewA;
        int i = AbstractC12808fC5.arbaeenContainer;
        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
        if (frameLayout != null) {
            i = AbstractC12808fC5.collapsing_toolbar;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) AbstractC11738dW7.a(view, i);
            if (collapsingToolbarLayout != null) {
                i = AbstractC12808fC5.filter_fab;
                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                if (materialButton != null) {
                    i = AbstractC12808fC5.jaryan_constraint;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = AbstractC12808fC5.jaryan_coordinator;
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) AbstractC11738dW7.a(view, i);
                        if (coordinatorLayout != null) {
                            i = AbstractC12808fC5.jaryan_tab_layout;
                            TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                            if (tabLayout != null) {
                                i = AbstractC12808fC5.jaryan_view_pager;
                                ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                                if (viewPager2 != null) {
                                    i = AbstractC12808fC5.search_container;
                                    MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                    if (materialCardView != null) {
                                        i = AbstractC12808fC5.search_hint_tv;
                                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView != null) {
                                            i = AbstractC12808fC5.selected_dialogs_counter;
                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView2 != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.snack_bar_anchor_view))) != null) {
                                                i = AbstractC12808fC5.story_appbar;
                                                AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                if (appBarLayout != null) {
                                                    i = AbstractC12808fC5.storyFragmentContainer;
                                                    FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                    if (frameLayout2 != null) {
                                                        i = AbstractC12808fC5.story_refresh_layout;
                                                        JaryanSwipeToRefresh jaryanSwipeToRefresh = (JaryanSwipeToRefresh) AbstractC11738dW7.a(view, i);
                                                        if (jaryanSwipeToRefresh != null) {
                                                            i = AbstractC12808fC5.storyView;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                            if (constraintLayout2 != null) {
                                                                i = AbstractC12808fC5.toolbar;
                                                                DrawerToolbar drawerToolbar = (DrawerToolbar) AbstractC11738dW7.a(view, i);
                                                                if (drawerToolbar != null) {
                                                                    i = AbstractC12808fC5.toolbar_search_image;
                                                                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                                                    if (imageView != null) {
                                                                        return new C16850ly2((ConstraintLayout) view, frameLayout, collapsingToolbarLayout, materialButton, constraintLayout, coordinatorLayout, tabLayout, viewPager2, materialCardView, textView, textView2, viewA, appBarLayout, frameLayout2, jaryanSwipeToRefresh, constraintLayout2, drawerToolbar, imageView);
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

    public static C16850ly2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.fragment_jaryan, viewGroup, false);
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
