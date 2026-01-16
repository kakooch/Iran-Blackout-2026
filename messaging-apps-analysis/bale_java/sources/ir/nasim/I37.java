package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes6.dex */
public final class I37 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final MaterialButton b;
    public final TextView c;
    public final TextView d;
    public final LottieAnimationView e;

    private I37(LinearLayout linearLayout, MaterialButton materialButton, TextView textView, TextView textView2, LottieAnimationView lottieAnimationView) {
        this.a = linearLayout;
        this.b = materialButton;
        this.c = textView;
        this.d = textView2;
        this.e = lottieAnimationView;
    }

    public static I37 a(View view) {
        int i = AbstractC12808fC5.swipe_action_button;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = AbstractC12808fC5.swipe_action_label;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC12808fC5.swipe_action_text;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = AbstractC12808fC5.swipe_lottie_animation;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                    if (lottieAnimationView != null) {
                        return new I37((LinearLayout) view, materialButton, textView, textView2, lottieAnimationView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
