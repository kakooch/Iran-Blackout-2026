package ir.nasim;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.i38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14530i38 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextInputEditText b;
    public final EditText c;
    public final BaleButton d;
    public final View e;
    public final TextInputLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final CardView l;
    public final CardView m;
    public final ConstraintLayout n;
    public final TextView o;
    public final TextView p;
    public final CardView q;
    public final TextView r;
    public final CardView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;

    private C14530i38(ConstraintLayout constraintLayout, TextInputEditText textInputEditText, EditText editText, BaleButton baleButton, View view, TextInputLayout textInputLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CardView cardView, CardView cardView2, ConstraintLayout constraintLayout2, TextView textView6, TextView textView7, CardView cardView3, TextView textView8, CardView cardView4, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.a = constraintLayout;
        this.b = textInputEditText;
        this.c = editText;
        this.d = baleButton;
        this.e = view;
        this.f = textInputLayout;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = cardView;
        this.m = cardView2;
        this.n = constraintLayout2;
        this.o = textView6;
        this.p = textView7;
        this.q = cardView3;
        this.r = textView8;
        this.s = cardView4;
        this.t = textView9;
        this.u = textView10;
        this.v = textView11;
        this.w = textView12;
    }

    public static C14530i38 a(View view) {
        View viewA;
        int i = BC5.et_card_pin2;
        TextInputEditText textInputEditText = (TextInputEditText) AbstractC11738dW7.a(view, i);
        if (textInputEditText != null) {
            i = BC5.et_wallet_pay_regarding;
            EditText editText = (EditText) AbstractC11738dW7.a(view, i);
            if (editText != null) {
                i = BC5.ok_button87;
                BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
                if (baleButton != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.ok_button_shadow))) != null) {
                    i = BC5.pin2_text_input_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) AbstractC11738dW7.a(view, i);
                    if (textInputLayout != null) {
                        i = BC5.wallet_pay_regarding;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.wallet_pay_verify_amount_title;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.wallet_pay_verify_amount_value;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.wallet_pay_verify_bottomsheet_close;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = BC5.wallet_pay_verify_bottomsheet_title;
                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView5 != null) {
                                            i = BC5.wallet_pay_verify_description_view;
                                            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                            if (cardView != null) {
                                                i = BC5.wallet_pay_verify_details;
                                                CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                                if (cardView2 != null) {
                                                    i = BC5.wallet_pay_verify_header;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                    if (constraintLayout != null) {
                                                        i = BC5.wallet_pay_verify_owner_title;
                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView6 != null) {
                                                            i = BC5.wallet_pay_verify_owner_value;
                                                            TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView7 != null) {
                                                                i = BC5.wallet_pay_verify_pass;
                                                                CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                                                                if (cardView3 != null) {
                                                                    i = BC5.wallet_pay_verify_source_title;
                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView8 != null) {
                                                                        i = BC5.wallet_pay_verify_source_view;
                                                                        CardView cardView4 = (CardView) AbstractC11738dW7.a(view, i);
                                                                        if (cardView4 != null) {
                                                                            i = BC5.wallet_pay_verify_source_wallet;
                                                                            TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView9 != null) {
                                                                                i = BC5.wallet_pay_verify_transfer_fee_description;
                                                                                TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = BC5.wallet_pay_verify_wallet_id_title;
                                                                                    TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView11 != null) {
                                                                                        i = BC5.wallet_pay_verify_wallet_id_title_value;
                                                                                        TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView12 != null) {
                                                                                            return new C14530i38((ConstraintLayout) view, textInputEditText, editText, baleButton, viewA, textInputLayout, textView, textView2, textView3, textView4, textView5, cardView, cardView2, constraintLayout, textView6, textView7, cardView3, textView8, cardView4, textView9, textView10, textView11, textView12);
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
