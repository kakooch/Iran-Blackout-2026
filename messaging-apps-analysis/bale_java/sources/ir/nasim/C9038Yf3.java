package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

/* renamed from: ir.nasim.Yf3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9038Yf3 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final CardView b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;

    private C9038Yf3(FrameLayout frameLayout, CardView cardView, ImageView imageView, ImageView imageView2, TextView textView) {
        this.a = frameLayout;
        this.b = cardView;
        this.c = imageView;
        this.d = imageView2;
        this.e = textView;
    }

    public static C9038Yf3 a(View view) {
        int i = AbstractC14017hC5.card;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = AbstractC14017hC5.close_icon;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC14017hC5.icon;
                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView2 != null) {
                    i = AbstractC14017hC5.title;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        return new C9038Yf3((FrameLayout) view, cardView, imageView, imageView2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C9038Yf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.item_search_suggestion, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
