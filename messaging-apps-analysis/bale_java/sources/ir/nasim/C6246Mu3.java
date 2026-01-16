package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* renamed from: ir.nasim.Mu3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6246Mu3 implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final FrameLayout d;
    public final TabLayout e;
    public final ViewPager2 f;

    private C6246Mu3(CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.a = coordinatorLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = frameLayout;
        this.e = tabLayout;
        this.f = viewPager2;
    }

    public static C6246Mu3 a(View view) {
        int i = BC5.btnBackspace;
        AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
        if (appCompatImageView != null) {
            i = BC5.btnSearch;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
            if (appCompatImageView2 != null) {
                i = BC5.flBottom;
                FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout != null) {
                    i = BC5.tlSmilesPanel;
                    TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                    if (tabLayout != null) {
                        i = BC5.vpSmilesPanel;
                        ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                        if (viewPager2 != null) {
                            return new C6246Mu3((CoordinatorLayout) view, appCompatImageView, appCompatImageView2, frameLayout, tabLayout, viewPager2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6246Mu3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C6246Mu3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.layout_smiles_panel, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
