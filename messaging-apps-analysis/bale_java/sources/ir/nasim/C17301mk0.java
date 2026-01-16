package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.mk0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17301mk0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final BaleButton c;
    public final FrameLayout d;
    public final ImageView e;
    public final TextView f;
    public final PZ g;
    public final PZ h;
    public final TextView i;

    private C17301mk0(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, BaleButton baleButton, FrameLayout frameLayout, ImageView imageView, TextView textView, PZ pz, PZ pz2, TextView textView2) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = baleButton;
        this.d = frameLayout;
        this.e = imageView;
        this.f = textView;
        this.g = pz;
        this.h = pz2;
        this.i = textView2;
    }

    public static C17301mk0 a(View view) {
        View viewA;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = BC5.confirm_button;
        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
        if (baleButton != null) {
            i = BC5.confirm_button_container;
            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
            if (frameLayout != null) {
                i = BC5.header_image;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.layout_title;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.link_description_layout))) != null) {
                        PZ pzA = PZ.a(viewA);
                        i = BC5.link_layout;
                        View viewA2 = AbstractC11738dW7.a(view, i);
                        if (viewA2 != null) {
                            PZ pzA2 = PZ.a(viewA2);
                            i = BC5.link_title;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                return new C17301mk0(constraintLayout, constraintLayout, baleButton, frameLayout, imageView, textView, pzA, pzA2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C17301mk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.bottom_sheet_story_link, viewGroup, false);
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
