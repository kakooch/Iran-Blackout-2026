package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.j6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15153j6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ComposeView c;
    public final ImageButton d;
    public final ImageView e;
    public final BaleToolbar f;

    private C15153j6(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ComposeView composeView, ImageButton imageButton, ImageView imageView, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = composeView;
        this.d = imageButton;
        this.e = imageView;
        this.f = baleToolbar;
    }

    public static C15153j6 a(View view) {
        int i = BC5.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.buttonOk;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                i = BC5.enableLocationBtn;
                ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                if (imageButton != null) {
                    i = BC5.imageView11;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.map_appbar;
                        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                        if (baleToolbar != null) {
                            return new C15153j6((ConstraintLayout) view, appBarLayout, composeView, imageButton, imageView, baleToolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15153j6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C15153j6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_map, viewGroup, false);
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
