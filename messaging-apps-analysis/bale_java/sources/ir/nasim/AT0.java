package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes5.dex */
public final class AT0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final MaterialButton c;
    public final MaterialButton d;
    public final ImageView e;
    public final View f;
    public final View g;

    private AT0(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, ImageView imageView, View view, View view2) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = materialButton2;
        this.d = materialButton3;
        this.e = imageView;
        this.f = view;
        this.g = view2;
    }

    public static AT0 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.choose_speaker_bs_back_speaker;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.choose_speaker_bs_bluetooth_speaker;
            MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton2 != null) {
                i = BC5.choose_speaker_bs_ear_speaker;
                MaterialButton materialButton3 = (MaterialButton) AbstractC11738dW7.a(view, i);
                if (materialButton3 != null) {
                    i = BC5.choose_speaker_bs_holder;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider1))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.divider2))) != null) {
                        return new AT0((ConstraintLayout) view, materialButton, materialButton2, materialButton3, imageView, viewA, viewA2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AT0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static AT0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.choose_speaker_bottom_sheet, viewGroup, false);
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
