package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.Qe3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7079Qe3 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final ImageView b;
    public final TextView c;
    public final ImageButton d;
    public final TextView e;

    private C7079Qe3(MaterialCardView materialCardView, ImageView imageView, TextView textView, ImageButton imageButton, TextView textView2) {
        this.a = materialCardView;
        this.b = imageView;
        this.c = textView;
        this.d = imageButton;
        this.e = textView2;
    }

    public static C7079Qe3 a(View view) {
        int i = BC5.bankLogo;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.cardNumberTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.delete;
                ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                if (imageButton != null) {
                    i = BC5.nameTxt;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C7079Qe3((MaterialCardView) view, imageView, textView, imageButton, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7079Qe3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_card_payment_select_card_saved, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.a;
    }
}
