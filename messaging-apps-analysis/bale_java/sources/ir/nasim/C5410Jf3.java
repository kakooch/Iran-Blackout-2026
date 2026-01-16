package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Jf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5410Jf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final CardView c;
    public final TextView d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final ImageView j;
    public final C4225Ef3 k;
    public final TextView l;

    private C5410Jf3(ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, ImageView imageView3, C4225Ef3 c4225Ef3, TextView textView5) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = cardView2;
        this.d = textView;
        this.e = imageView;
        this.f = imageView2;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = imageView3;
        this.k = c4225Ef3;
        this.l = textView5;
    }

    public static C5410Jf3 a(View view) {
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
                    if (imageView != null) {
                        i = BC5.money;
                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView2 != null) {
                            i = BC5.price;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.rate;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.rate_count;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = BC5.rate_star;
                                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView3 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.shimmer))) != null) {
                                            C4225Ef3 c4225Ef3A = C4225Ef3.a(viewA);
                                            i = BC5.title;
                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView5 != null) {
                                                return new C5410Jf3((ConstraintLayout) view, cardView, cardView2, textView, imageView, imageView2, textView2, textView3, textView4, imageView3, c4225Ef3A, textView5);
                                            }
                                        }
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

    public static C5410Jf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_product_basalam_compact, viewGroup, false);
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
