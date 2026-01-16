package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.px2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19205px2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ShapeableImageView c;
    public final ShapeableImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final BaleToolbar h;

    private C19205px2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, TextView textView, TextView textView2, TextView textView3, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = shapeableImageView;
        this.d = shapeableImageView2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = baleToolbar;
    }

    public static C19205px2 a(View view) {
        int i = BC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.imageViewClassic;
            ShapeableImageView shapeableImageView = (ShapeableImageView) AbstractC11738dW7.a(view, i);
            if (shapeableImageView != null) {
                i = BC5.imageViewDefault;
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) AbstractC11738dW7.a(view, i);
                if (shapeableImageView2 != null) {
                    i = BC5.textViewClassic;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.textViewDefault;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.textViewDescription;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null) {
                                i = BC5.toolbar;
                                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                if (baleToolbar != null) {
                                    return new C19205px2((ConstraintLayout) view, appBarLayout, shapeableImageView, shapeableImageView2, textView, textView2, textView3, baleToolbar);
                                }
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
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
