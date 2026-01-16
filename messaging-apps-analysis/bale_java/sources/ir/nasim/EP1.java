package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes5.dex */
public final class EP1 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final TextView b;

    private EP1(FrameLayout frameLayout, TextView textView) {
        this.a = frameLayout;
        this.b = textView;
    }

    public static EP1 a(View view) {
        int i = BC5.tv_dialog_tab_title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new EP1((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static EP1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.dialog_tab_type_item_call_logs, viewGroup, false);
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
