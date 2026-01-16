package ir.nasim;

import android.view.View;
import android.widget.ProgressBar;

/* renamed from: ir.nasim.oo0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18523oo0 implements InterfaceC9764aW7 {
    private final ProgressBar a;
    public final ProgressBar b;

    private C18523oo0(ProgressBar progressBar, ProgressBar progressBar2) {
        this.a = progressBar;
        this.b = progressBar2;
    }

    public static C18523oo0 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ProgressBar progressBar = (ProgressBar) view;
        return new C18523oo0(progressBar, progressBar);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ProgressBar getRoot() {
        return this.a;
    }
}
