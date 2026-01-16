package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class F10 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialCardView b;
    public final TextView c;
    public final AppCompatEditText d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    private F10(ConstraintLayout constraintLayout, MaterialCardView materialCardView, TextView textView, AppCompatEditText appCompatEditText, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4) {
        this.a = constraintLayout;
        this.b = materialCardView;
        this.c = textView;
        this.d = appCompatEditText;
        this.e = linearLayout;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static F10 a(View view) {
        int i = AbstractC19354qC5.card;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = AbstractC19354qC5.helper;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC19354qC5.input;
                AppCompatEditText appCompatEditText = (AppCompatEditText) AbstractC11738dW7.a(view, i);
                if (appCompatEditText != null) {
                    i = AbstractC19354qC5.input_layout;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        i = AbstractC19354qC5.prefix;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = AbstractC19354qC5.suffix;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null) {
                                i = AbstractC19354qC5.title;
                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView4 != null) {
                                    return new F10((ConstraintLayout) view, materialCardView, textView, appCompatEditText, linearLayout, textView2, textView3, textView4);
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
