package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: ir.nasim.Jy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5580Jy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final O50 c;
    public final AppBarLayout d;
    public final FrameLayout e;

    private C5580Jy2(ConstraintLayout constraintLayout, View view, O50 o50, AppBarLayout appBarLayout, FrameLayout frameLayout) {
        this.a = constraintLayout;
        this.b = view;
        this.c = o50;
        this.d = appBarLayout;
        this.e = frameLayout;
    }

    public static C5580Jy2 a(View view) {
        View viewA;
        int i = BC5.loading_shadow;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view))) != null) {
            O50 o50A = O50.a(viewA);
            i = BC5.story_privacy_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null) {
                i = BC5.webviewLayout;
                FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout != null) {
                    return new C5580Jy2((ConstraintLayout) view, viewA2, o50A, appBarLayout, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5580Jy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_my_bank_web_view_cache, viewGroup, false);
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
