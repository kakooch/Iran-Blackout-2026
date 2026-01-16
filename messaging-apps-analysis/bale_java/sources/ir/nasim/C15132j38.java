package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.j38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15132j38 implements InterfaceC9764aW7 {
    private final ScrollView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final CardView g;
    public final TextView h;
    public final CardView i;
    public final ConstraintLayout j;
    public final TextView k;

    private C15132j38(ScrollView scrollView, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout, TextView textView3, CardView cardView, TextView textView4, CardView cardView2, ConstraintLayout constraintLayout2, TextView textView5) {
        this.a = scrollView;
        this.b = textView;
        this.c = textView2;
        this.d = imageView;
        this.e = constraintLayout;
        this.f = textView3;
        this.g = cardView;
        this.h = textView4;
        this.i = cardView2;
        this.j = constraintLayout2;
        this.k = textView5;
    }

    public static C15132j38 a(View view) {
        int i = BC5.qr_code_number_text_view;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.wallet_pay_my_barcode_description;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                i = BC5.wallet_pay_my_barcode_image;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.wallet_pay_my_barcode_image_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = BC5.wallet_pay_my_barcode_link;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.wallet_pay_my_barcode_link_card_view;
                            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                            if (cardView != null) {
                                i = BC5.wallet_pay_my_barcode_link_share;
                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView4 != null) {
                                    i = BC5.wallet_pay_my_barcode_link_share_card_view;
                                    CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                    if (cardView2 != null) {
                                        i = BC5.wallet_pay__my_barcode_link_share_container;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                        if (constraintLayout2 != null) {
                                            i = BC5.wallet_pay_my_barcode_link_title;
                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView5 != null) {
                                                return new C15132j38((ScrollView) view, textView, textView2, imageView, constraintLayout, textView3, cardView, textView4, cardView2, constraintLayout2, textView5);
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

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }
}
