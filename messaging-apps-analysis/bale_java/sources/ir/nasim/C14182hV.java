package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import com.droidkit.progress.IndeterminateView;
import com.github.chrisbanes.photoview.PhotoView;

/* renamed from: ir.nasim.hV, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14182hV implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final PhotoView b;
    public final IndeterminateView c;

    private C14182hV(FrameLayout frameLayout, PhotoView photoView, IndeterminateView indeterminateView) {
        this.a = frameLayout;
        this.b = photoView;
        this.c = indeterminateView;
    }

    public static C14182hV a(View view) {
        int i = BC5.avatar;
        PhotoView photoView = (PhotoView) AbstractC11738dW7.a(view, i);
        if (photoView != null) {
            i = BC5.uploadProgress;
            IndeterminateView indeterminateView = (IndeterminateView) AbstractC11738dW7.a(view, i);
            if (indeterminateView != null) {
                return new C14182hV((FrameLayout) view, photoView, indeterminateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
