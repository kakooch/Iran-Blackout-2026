package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/* renamed from: ir.nasim.zi1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25083zi1 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ProgressBar b;

    private C25083zi1(FrameLayout frameLayout, ProgressBar progressBar) {
        this.a = frameLayout;
        this.b = progressBar;
    }

    public static C25083zi1 a(View view) {
        int i = BC5.progress_bar;
        ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
        if (progressBar != null) {
            return new C25083zi1((FrameLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C25083zi1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.contacts_load_state, viewGroup, false);
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
