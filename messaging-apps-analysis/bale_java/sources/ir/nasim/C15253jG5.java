package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.jG5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15253jG5 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final ConstraintLayout c;
    public final ImageView d;

    private C15253jG5(ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ImageView imageView) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = constraintLayout2;
        this.d = imageView;
    }

    public static C15253jG5 a(View view) {
        int i = BC5.menu_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.more_options_header;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = BC5.more_options_header_image;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    return new C15253jG5((ConstraintLayout) view, linearLayout, constraintLayout, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15253jG5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.ramz_rial_more_options_layout, viewGroup, false);
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
