package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

/* renamed from: ir.nasim.Mf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6111Mf3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final CardView b;
    public final TextView c;

    private C6111Mf3(LinearLayout linearLayout, CardView cardView, TextView textView) {
        this.a = linearLayout;
        this.b = cardView;
        this.c = textView;
    }

    public static C6111Mf3 a(View view) {
        int i = BC5.card;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.text;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                return new C6111Mf3((LinearLayout) view, cardView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6111Mf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_row_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
