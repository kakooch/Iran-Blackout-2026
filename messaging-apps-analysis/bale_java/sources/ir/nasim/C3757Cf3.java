package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Cf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3757Cf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final ImageView c;
    public final TextView d;

    private C3757Cf3(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, TextView textView) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = imageView;
        this.d = textView;
    }

    public static C3757Cf3 a(View view) {
        int i = BC5.card;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.moreItemsImg;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.moreItemsTxt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    return new C3757Cf3((ConstraintLayout) view, cardView, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3757Cf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_more_product_items, viewGroup, false);
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
