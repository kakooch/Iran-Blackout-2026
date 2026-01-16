package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes5.dex */
public final class PZ implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialCardView b;
    public final AppCompatEditText c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    private PZ(ConstraintLayout constraintLayout, MaterialCardView materialCardView, AppCompatEditText appCompatEditText, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = materialCardView;
        this.c = appCompatEditText;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static PZ a(View view) {
        int i = BC5.card;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.editText;
            AppCompatEditText appCompatEditText = (AppCompatEditText) AbstractC11738dW7.a(view, i);
            if (appCompatEditText != null) {
                i = BC5.title_editText;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.tv_counter;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.tv_error;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            return new PZ((ConstraintLayout) view, materialCardView, appCompatEditText, textView, textView2, textView3);
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
