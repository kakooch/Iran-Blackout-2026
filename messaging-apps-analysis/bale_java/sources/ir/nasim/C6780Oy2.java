package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.Oy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6780Oy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FullWidthButtonPrimary b;
    public final ConstraintLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ConstraintLayout h;
    public final ComposeView i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final TextView m;
    public final EditText n;
    public final CardView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final ConstraintLayout v;

    private C6780Oy2(ConstraintLayout constraintLayout, FullWidthButtonPrimary fullWidthButtonPrimary, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout3, ComposeView composeView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5, EditText editText, CardView cardView, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ConstraintLayout constraintLayout4) {
        this.a = constraintLayout;
        this.b = fullWidthButtonPrimary;
        this.c = constraintLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = constraintLayout3;
        this.i = composeView;
        this.j = linearLayout;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.m = textView5;
        this.n = editText;
        this.o = cardView;
        this.p = textView6;
        this.q = textView7;
        this.r = textView8;
        this.s = textView9;
        this.t = textView10;
        this.u = textView11;
        this.v = constraintLayout4;
    }

    public static C6780Oy2 a(View view) {
        int i = BC5.button_continue;
        FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
        if (fullWidthButtonPrimary != null) {
            i = BC5.code_activation;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = BC5.code_count_down_hint;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.code_not_received;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.count_down_timer;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.edit_phone_number;
                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView4 != null) {
                                i = BC5.email_login_form;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout2 != null) {
                                    i = BC5.img_telegram_bot;
                                    ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
                                    if (composeView != null) {
                                        i = BC5.linear_call_support;
                                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                        if (linearLayout != null) {
                                            i = BC5.linear_login_problem_alert;
                                            LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                            if (linearLayout2 != null) {
                                                i = BC5.linear_telegram_bot;
                                                LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                if (linearLayout3 != null) {
                                                    i = BC5.phone_sign_hint;
                                                    TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView5 != null) {
                                                        i = BC5.pinEditText;
                                                        EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                                        if (editText != null) {
                                                            i = BC5.pinEditText_cardView;
                                                            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                                            if (cardView != null) {
                                                                i = BC5.request_send_next_code;
                                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView6 != null) {
                                                                    i = BC5.sendHint;
                                                                    TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView7 != null) {
                                                                        i = BC5.txt_call_support;
                                                                        TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView8 != null) {
                                                                            i = BC5.txt_login_problem_alert;
                                                                            TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView9 != null) {
                                                                                i = BC5.txt_login_problem_alert_guidance;
                                                                                TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = BC5.txt_telegram_bot;
                                                                                    TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView11 != null) {
                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                                                                        return new C6780Oy2(constraintLayout3, fullWidthButtonPrimary, constraintLayout, textView, textView2, textView3, textView4, constraintLayout2, composeView, linearLayout, linearLayout2, linearLayout3, textView5, editText, cardView, textView6, textView7, textView8, textView9, textView10, textView11, constraintLayout3);
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

    public static C6780Oy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_new_validate_code, viewGroup, false);
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
