package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.DrawerToolbar;

/* renamed from: ir.nasim.Iy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5346Iy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final AppBarLayout c;
    public final DrawerToolbar d;
    public final ComposeView e;
    public final ImageView f;
    public final TextView g;
    public final ConstraintLayout h;
    public final ImageView i;

    private C5346Iy2(ConstraintLayout constraintLayout, View view, AppBarLayout appBarLayout, DrawerToolbar drawerToolbar, ComposeView composeView, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = appBarLayout;
        this.d = drawerToolbar;
        this.e = composeView;
        this.f = imageView;
        this.g = textView;
        this.h = constraintLayout2;
        this.i = imageView2;
    }

    public static C5346Iy2 a(View view) {
        int i = BC5.anchor_toast;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = BC5.bank_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null) {
                i = BC5.bank_toolbar;
                DrawerToolbar drawerToolbar = (DrawerToolbar) AbstractC11738dW7.a(view, i);
                if (drawerToolbar != null) {
                    i = BC5.compose_view;
                    ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
                    if (composeView != null) {
                        i = BC5.toolbar_iv;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            i = BC5.toolbar_text;
                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView != null) {
                                i = BC5.toolbar_text_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout != null) {
                                    i = BC5.toolbar_text_drawable;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        return new C5346Iy2((ConstraintLayout) view, viewA, appBarLayout, drawerToolbar, composeView, imageView, textView, constraintLayout, imageView2);
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

    public static C5346Iy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_my_bank_new, viewGroup, false);
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
