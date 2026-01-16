package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Hf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4942Hf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final CardView c;
    public final TextView d;
    public final ImageView e;
    public final C4225Ef3 f;

    private C4942Hf3(ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, TextView textView, ImageView imageView, C4225Ef3 c4225Ef3) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = cardView2;
        this.d = textView;
        this.e = imageView;
        this.f = c4225Ef3;
    }

    public static C4942Hf3 a(View view) {
        View viewA;
        int i = BC5.card;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.cardView3;
            CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView2 != null) {
                i = BC5.discount;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.img;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.shimmer))) != null) {
                        return new C4942Hf3((ConstraintLayout) view, cardView, cardView2, textView, imageView, C4225Ef3.a(viewA));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4942Hf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_product_bale_compact, viewGroup, false);
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
