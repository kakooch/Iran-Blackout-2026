package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/* loaded from: classes5.dex */
public final class HN1 implements InterfaceC9764aW7 {
    private final RadioGroup a;
    public final RadioButton b;
    public final RadioButton c;
    public final RadioButton d;
    public final RadioButton e;

    private HN1(RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4) {
        this.a = radioGroup;
        this.b = radioButton;
        this.c = radioButton2;
        this.d = radioButton3;
        this.e = radioButton4;
    }

    public static HN1 a(View view) {
        int i = BC5.radio_arabic;
        RadioButton radioButton = (RadioButton) AbstractC11738dW7.a(view, i);
        if (radioButton != null) {
            i = BC5.radio_english;
            RadioButton radioButton2 = (RadioButton) AbstractC11738dW7.a(view, i);
            if (radioButton2 != null) {
                i = BC5.radio_farsi;
                RadioButton radioButton3 = (RadioButton) AbstractC11738dW7.a(view, i);
                if (radioButton3 != null) {
                    i = BC5.radio_torki;
                    RadioButton radioButton4 = (RadioButton) AbstractC11738dW7.a(view, i);
                    if (radioButton4 != null) {
                        return new HN1((RadioGroup) view, radioButton, radioButton2, radioButton3, radioButton4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HN1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static HN1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.dialog_language_select, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RadioGroup getRoot() {
        return this.a;
    }
}
