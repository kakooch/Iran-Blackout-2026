package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatRadioButton;

/* loaded from: classes.dex */
public final class QH5 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final AppCompatRadioButton b;

    private QH5(FrameLayout frameLayout, AppCompatRadioButton appCompatRadioButton) {
        this.a = frameLayout;
        this.b = appCompatRadioButton;
    }

    public static QH5 a(View view) {
        int i = AbstractC15217jC5.radioButton;
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) AbstractC11738dW7.a(view, i);
        if (appCompatRadioButton != null) {
            return new QH5((FrameLayout) view, appCompatRadioButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static QH5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(MC5.reaction_settings_option_holder, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
