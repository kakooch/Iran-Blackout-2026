package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes6.dex */
public final class F80 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;

    private F80(ConstraintLayout constraintLayout, ImageView imageView) {
        this.a = constraintLayout;
        this.b = imageView;
    }

    public static F80 a(View view) {
        int i = AbstractC12808fC5.banner_item_iv;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            return new F80((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static F80 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.banner_item_holder, viewGroup, false);
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
