package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputEditText;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.g38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13341g38 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BaleButton b;
    public final View c;
    public final TextInputEditText d;
    public final AppCompatTextView e;
    public final CardView f;
    public final ConstraintLayout g;
    public final ImageView h;
    public final TextView i;
    public final TextView j;

    private C13341g38(ConstraintLayout constraintLayout, BaleButton baleButton, View view, TextInputEditText textInputEditText, AppCompatTextView appCompatTextView, CardView cardView, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = baleButton;
        this.c = view;
        this.d = textInputEditText;
        this.e = appCompatTextView;
        this.f = cardView;
        this.g = constraintLayout2;
        this.h = imageView;
        this.i = textView;
        this.j = textView2;
    }

    public static C13341g38 a(View view) {
        View viewA;
        int i = BC5.enter_barcode_ok_button;
        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
        if (baleButton != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.enter_barcode_ok_button_shadow))) != null) {
            i = BC5.et_wallet_pay_wallet_id;
            TextInputEditText textInputEditText = (TextInputEditText) AbstractC11738dW7.a(view, i);
            if (textInputEditText != null) {
                i = BC5.wallet_pay_code;
                AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                if (appCompatTextView != null) {
                    i = BC5.wallet_pay_code_card_view;
                    CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                    if (cardView != null) {
                        i = BC5.wallet_pay_wallet_id_pay_with_scanner;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            i = BC5.wallet_pay_wallet_id_pay_with_scanner_icon;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                i = BC5.wallet_pay_wallet_id_pay_with_scanner_text;
                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView != null) {
                                    i = BC5.wallet_pay_wallet_id_title;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        return new C13341g38((ConstraintLayout) view, baleButton, viewA, textInputEditText, appCompatTextView, cardView, constraintLayout, imageView, textView, textView2);
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
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
