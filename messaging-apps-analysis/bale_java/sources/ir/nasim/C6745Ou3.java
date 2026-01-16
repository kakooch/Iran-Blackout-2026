package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: ir.nasim.Ou3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6745Ou3 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ProgressBar b;
    public final MaterialTextView c;

    private C6745Ou3(FrameLayout frameLayout, ProgressBar progressBar, MaterialTextView materialTextView) {
        this.a = frameLayout;
        this.b = progressBar;
        this.c = materialTextView;
    }

    public static C6745Ou3 a(View view) {
        int i = AbstractC18763pC5.progressBar;
        ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
        if (progressBar != null) {
            i = AbstractC18763pC5.tvTitle;
            MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
            if (materialTextView != null) {
                return new C6745Ou3((FrameLayout) view, progressBar, materialTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6745Ou3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(SC5.layout_story_link, viewGroup, false);
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
