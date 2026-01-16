package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Ff3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4459Ff3 implements InterfaceC9764aW7 {
    private final CardView a;
    public final AvatarViewGlide b;
    public final CardView c;
    public final CardView d;
    public final CardView e;
    public final TextView f;
    public final ImageView g;
    public final ImageView h;
    public final C4225Ef3 i;
    public final C4225Ef3 j;
    public final TextView k;

    private C4459Ff3(CardView cardView, AvatarViewGlide avatarViewGlide, CardView cardView2, CardView cardView3, CardView cardView4, TextView textView, ImageView imageView, ImageView imageView2, C4225Ef3 c4225Ef3, C4225Ef3 c4225Ef32, TextView textView2) {
        this.a = cardView;
        this.b = avatarViewGlide;
        this.c = cardView2;
        this.d = cardView3;
        this.e = cardView4;
        this.f = textView;
        this.g = imageView;
        this.h = imageView2;
        this.i = c4225Ef3;
        this.j = c4225Ef32;
        this.k = textView2;
    }

    public static C4459Ff3 a(View view) {
        View viewA;
        int i = BC5.avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            CardView cardView = (CardView) view;
            i = BC5.card1;
            CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView2 != null) {
                i = BC5.card2;
                CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                if (cardView3 != null) {
                    i = BC5.discount;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.img1;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            i = BC5.img2;
                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.shimmer1))) != null) {
                                C4225Ef3 c4225Ef3A = C4225Ef3.a(viewA);
                                i = BC5.shimmer2;
                                View viewA2 = AbstractC11738dW7.a(view, i);
                                if (viewA2 != null) {
                                    C4225Ef3 c4225Ef3A2 = C4225Ef3.a(viewA2);
                                    i = BC5.title;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        return new C4459Ff3(cardView, avatarViewGlide, cardView, cardView2, cardView3, textView, imageView, imageView2, c4225Ef3A, c4225Ef3A2, textView2);
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

    public static C4459Ff3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_preview_pair_compact, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
