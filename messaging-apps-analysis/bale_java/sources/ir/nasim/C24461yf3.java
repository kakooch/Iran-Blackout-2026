package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.yf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24461yf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;

    private C24461yf3(ConstraintLayout constraintLayout, ImageView imageView) {
        this.a = constraintLayout;
        this.b = imageView;
    }

    public static C24461yf3 a(View view) {
        int i = BC5.dot_indicator;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            return new C24461yf3((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24461yf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_indicator, viewGroup, false);
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
