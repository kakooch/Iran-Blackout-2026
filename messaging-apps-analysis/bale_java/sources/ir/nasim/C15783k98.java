package ir.nasim;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.k98, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15783k98 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final MaterialCardView b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final EditText f;
    public final ConstraintLayout g;
    public final TextView h;
    public final ImageView i;

    private C15783k98(LinearLayout linearLayout, MaterialCardView materialCardView, ImageView imageView, ImageView imageView2, TextView textView, EditText editText, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView3) {
        this.a = linearLayout;
        this.b = materialCardView;
        this.c = imageView;
        this.d = imageView2;
        this.e = textView;
        this.f = editText;
        this.g = constraintLayout;
        this.h = textView2;
        this.i = imageView3;
    }

    public static C15783k98 a(View view) {
        int i = AbstractC19354qC5.cardRoot;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = AbstractC19354qC5.endDrawableFirstImg;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC19354qC5.endDrawableSecondImg;
                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView2 != null) {
                    i = AbstractC19354qC5.hintTv;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = AbstractC19354qC5.inputEt;
                        EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                        if (editText != null) {
                            i = AbstractC19354qC5.mainLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                            if (constraintLayout != null) {
                                i = AbstractC19354qC5.postfixTxt;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = AbstractC19354qC5.startDrawableImg;
                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView3 != null) {
                                        return new C15783k98((LinearLayout) view, materialCardView, imageView, imageView2, textView, editText, constraintLayout, textView2, imageView3);
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

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
