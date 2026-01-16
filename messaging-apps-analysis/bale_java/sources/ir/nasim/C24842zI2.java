package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.zI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24842zI2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final TextView d;

    private C24842zI2(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = imageView;
        this.d = textView;
    }

    public static C24842zI2 a(View view) {
        int i = BC5.gift_packet_result_empty_state_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = BC5.gift_packet_result_empty_state_image;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.gift_packet_result_empty_state_message;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    return new C24842zI2((ConstraintLayout) view, constraintLayout, imageView, textView);
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
