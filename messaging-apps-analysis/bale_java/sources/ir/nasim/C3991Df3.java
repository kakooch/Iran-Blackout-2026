package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Df3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3991Df3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final CardView c;
    public final CardView d;
    public final CardView e;
    public final CardView f;
    public final TextView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final C4225Ef3 k;
    public final C4225Ef3 l;
    public final C4225Ef3 m;
    public final TextView n;
    public final TextView o;

    private C3991Df3(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, C4225Ef3 c4225Ef3, C4225Ef3 c4225Ef32, C4225Ef3 c4225Ef33, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = cardView;
        this.d = cardView2;
        this.e = cardView3;
        this.f = cardView4;
        this.g = textView;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
        this.k = c4225Ef3;
        this.l = c4225Ef32;
        this.m = c4225Ef33;
        this.n = textView2;
        this.o = textView3;
    }

    public static C3991Df3 a(View view) {
        View viewA;
        int i = BC5.avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = BC5.card;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = BC5.card1;
                CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                if (cardView2 != null) {
                    i = BC5.card2;
                    CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                    if (cardView3 != null) {
                        i = BC5.card3;
                        CardView cardView4 = (CardView) AbstractC11738dW7.a(view, i);
                        if (cardView4 != null) {
                            i = BC5.discount;
                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView != null) {
                                i = BC5.img1;
                                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView != null) {
                                    i = BC5.img2;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        i = BC5.img3;
                                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView3 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.shimmer1))) != null) {
                                            C4225Ef3 c4225Ef3A = C4225Ef3.a(viewA);
                                            i = BC5.shimmer2;
                                            View viewA2 = AbstractC11738dW7.a(view, i);
                                            if (viewA2 != null) {
                                                C4225Ef3 c4225Ef3A2 = C4225Ef3.a(viewA2);
                                                i = BC5.shimmer3;
                                                View viewA3 = AbstractC11738dW7.a(view, i);
                                                if (viewA3 != null) {
                                                    C4225Ef3 c4225Ef3A3 = C4225Ef3.a(viewA3);
                                                    i = BC5.show;
                                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView2 != null) {
                                                        i = BC5.title;
                                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView3 != null) {
                                                            return new C3991Df3((ConstraintLayout) view, avatarViewGlide, cardView, cardView2, cardView3, cardView4, textView, imageView, imageView2, imageView3, c4225Ef3A, c4225Ef3A2, c4225Ef3A3, textView2, textView3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3991Df3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_preview, viewGroup, false);
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
