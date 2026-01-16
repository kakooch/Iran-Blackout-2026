package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* renamed from: ir.nasim.my2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17441my2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppBarLayout b;
    public final AppCompatImageButton c;
    public final AppCompatImageButton d;
    public final ViewPager2 e;
    public final TextView f;
    public final TabLayout g;

    private C17441my2(LinearLayout linearLayout, AppBarLayout appBarLayout, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, ViewPager2 viewPager2, TextView textView, TabLayout tabLayout) {
        this.a = linearLayout;
        this.b = appBarLayout;
        this.c = appCompatImageButton;
        this.d = appCompatImageButton2;
        this.e = viewPager2;
        this.f = textView;
        this.g = tabLayout;
    }

    public static C17441my2 a(View view) {
        int i = AbstractC12808fC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC12808fC5.back_input_search;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) AbstractC11738dW7.a(view, i);
            if (appCompatImageButton != null) {
                i = AbstractC12808fC5.close_input_search;
                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) AbstractC11738dW7.a(view, i);
                if (appCompatImageButton2 != null) {
                    i = AbstractC12808fC5.pager;
                    ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                    if (viewPager2 != null) {
                        i = AbstractC12808fC5.search_text;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = AbstractC12808fC5.tab_layout;
                            TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                            if (tabLayout != null) {
                                return new C17441my2((LinearLayout) view, appBarLayout, appCompatImageButton, appCompatImageButton2, viewPager2, textView, tabLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
