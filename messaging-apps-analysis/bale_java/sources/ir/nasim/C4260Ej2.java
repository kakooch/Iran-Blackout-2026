package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.Ej2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4260Ej2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final TextView b;
    public final FrameLayout c;

    private C4260Ej2(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.b = textView;
        this.c = frameLayout2;
    }

    public static C4260Ej2 a(View view) {
        int i = AbstractC12808fC5.feed_text;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new C4260Ej2(frameLayout, textView, frameLayout);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
