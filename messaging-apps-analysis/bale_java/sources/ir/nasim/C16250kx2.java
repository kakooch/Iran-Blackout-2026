package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.material.button.MaterialButton;
import ir.nasim.components.textfield.view.CustomInputView;

/* renamed from: ir.nasim.kx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16250kx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final CustomInputView c;
    public final CustomInputView d;
    public final TextView e;
    public final Guideline f;
    public final CustomInputView g;
    public final ImageView h;
    public final TextView i;
    public final View j;
    public final CustomInputView k;

    private C16250kx2(ConstraintLayout constraintLayout, MaterialButton materialButton, CustomInputView customInputView, CustomInputView customInputView2, TextView textView, Guideline guideline, CustomInputView customInputView3, ImageView imageView, TextView textView2, View view, CustomInputView customInputView4) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = customInputView;
        this.d = customInputView2;
        this.e = textView;
        this.f = guideline;
        this.g = customInputView3;
        this.h = imageView;
        this.i = textView2;
        this.j = view;
        this.k = customInputView4;
    }

    public static C16250kx2 a(View view) {
        View viewA;
        int i = BC5.add;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.cardNumber;
            CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
            if (customInputView != null) {
                i = BC5.cvv2Input;
                CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                if (customInputView2 != null) {
                    i = BC5.dateDividerTxt;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.guideline6;
                        Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                        if (guideline != null) {
                            i = BC5.monthInput;
                            CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                            if (customInputView3 != null) {
                                i = BC5.swipeIcon;
                                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView != null) {
                                    i = BC5.title;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.view))) != null) {
                                        i = BC5.yearInput;
                                        CustomInputView customInputView4 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                        if (customInputView4 != null) {
                                            return new C16250kx2((ConstraintLayout) view, materialButton, customInputView, customInputView2, textView, guideline, customInputView3, imageView, textView2, viewA, customInputView4);
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

    public static C16250kx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_add_card_new, viewGroup, false);
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
