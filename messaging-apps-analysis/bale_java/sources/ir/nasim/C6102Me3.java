package ir.nasim;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Me3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6102Me3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageButton b;
    public final TextView c;

    private C6102Me3(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView) {
        this.a = constraintLayout;
        this.b = imageButton;
        this.c = textView;
    }

    public static C6102Me3 a(View view) {
        int i = BC5.delete;
        ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
        if (imageButton != null) {
            i = BC5.nameTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                return new C6102Me3((ConstraintLayout) view, imageButton, textView);
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
