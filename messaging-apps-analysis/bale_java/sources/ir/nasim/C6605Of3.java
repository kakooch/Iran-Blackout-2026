package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Of3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6605Of3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final ImageView c;

    private C6605Of3(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = imageView;
    }

    public static C6605Of3 a(View view) {
        int i = BC5.card;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.image;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                return new C6605Of3((ConstraintLayout) view, cardView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6605Of3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_slide, viewGroup, false);
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
