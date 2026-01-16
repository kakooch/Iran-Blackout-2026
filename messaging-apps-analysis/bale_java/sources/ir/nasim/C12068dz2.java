package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.dz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12068dz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialCardView b;
    public final Button c;
    public final TextView d;
    public final LottieAnimationView e;

    private C12068dz2(ConstraintLayout constraintLayout, MaterialCardView materialCardView, Button button, TextView textView, LottieAnimationView lottieAnimationView) {
        this.a = constraintLayout;
        this.b = materialCardView;
        this.c = button;
        this.d = textView;
        this.e = lottieAnimationView;
    }

    public static C12068dz2 a(View view) {
        int i = BC5.animationCard;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.confirmButton;
            Button button = (Button) AbstractC11738dW7.a(view, i);
            if (button != null) {
                i = BC5.descriptionTxt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.lottieAnimationView;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                    if (lottieAnimationView != null) {
                        return new C12068dz2((ConstraintLayout) view, materialCardView, button, textView, lottieAnimationView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C12068dz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_refresh_dialog, viewGroup, false);
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
