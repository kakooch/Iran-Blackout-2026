package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.zf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25055zf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final CardView c;
    public final ImageView d;
    public final TextView e;

    private C25055zf3(ConstraintLayout constraintLayout, TextView textView, CardView cardView, ImageView imageView, TextView textView2) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = cardView;
        this.d = imageView;
        this.e = textView2;
    }

    public static C25055zf3 a(View view) {
        int i = BC5.badge;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.card;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = BC5.icon;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.title;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C25055zf3((ConstraintLayout) view, textView, cardView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C25055zf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_menu, viewGroup, false);
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
