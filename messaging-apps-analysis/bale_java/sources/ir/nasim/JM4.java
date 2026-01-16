package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes5.dex */
public final class JM4 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final TextInputLayout c;
    public final EditText d;
    public final ConstraintLayout e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public final ProgressBar i;
    public final LinearLayout j;
    public final TextView k;

    private JM4(ConstraintLayout constraintLayout, CardView cardView, TextInputLayout textInputLayout, EditText editText, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, TextView textView2, ProgressBar progressBar, LinearLayout linearLayout, TextView textView3) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = textInputLayout;
        this.d = editText;
        this.e = constraintLayout2;
        this.f = textView;
        this.g = imageView;
        this.h = textView2;
        this.i = progressBar;
        this.j = linearLayout;
        this.k = textView3;
    }

    public static JM4 a(View view) {
        int i = BC5.card_pin2_container;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.et_card_cvv2_input_layout;
            TextInputLayout textInputLayout = (TextInputLayout) AbstractC11738dW7.a(view, i);
            if (textInputLayout != null) {
                i = BC5.et_card_pin2;
                EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                if (editText != null) {
                    i = BC5.otp_constraint_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = BC5.otp_help_button;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.otp_icon_container;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                i = BC5.otp_info_message_text_view;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = BC5.otp_progressbar;
                                    ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                                    if (progressBar != null) {
                                        i = BC5.otp_section;
                                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                        if (linearLayout != null) {
                                            i = BC5.request_receive_new_otp_pass_button;
                                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView3 != null) {
                                                return new JM4((ConstraintLayout) view, cardView, textInputLayout, editText, constraintLayout, textView, imageView, textView2, progressBar, linearLayout, textView3);
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

    public static JM4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.otp_pin2_view, viewGroup, false);
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
