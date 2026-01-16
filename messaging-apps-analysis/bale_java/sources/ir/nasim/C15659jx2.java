package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.components.textfield.view.CustomInputView;

/* renamed from: ir.nasim.jx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15659jx2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final MaterialButton b;
    public final MaterialButton c;
    public final CustomInputView d;
    public final TextView e;

    private C15659jx2(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, CustomInputView customInputView, TextView textView) {
        this.a = linearLayout;
        this.b = materialButton;
        this.c = materialButton2;
        this.d = customInputView;
        this.e = textView;
    }

    public static C15659jx2 a(View view) {
        int i = BC5.add;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.cancel;
            MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton2 != null) {
                i = BC5.cardNumber;
                CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
                if (customInputView != null) {
                    i = BC5.title;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        return new C15659jx2((LinearLayout) view, materialButton, materialButton2, customInputView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15659jx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_add_card, viewGroup, false);
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
