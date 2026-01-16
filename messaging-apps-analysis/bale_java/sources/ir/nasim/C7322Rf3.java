package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.droidkit.progress.CircularView;
import com.github.chrisbanes.photoview.PhotoView;

/* renamed from: ir.nasim.Rf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7322Rf3 implements InterfaceC9764aW7 {
    private final RelativeLayout a;
    public final RelativeLayout b;
    public final ImageView c;
    public final TextView d;
    public final CircularView e;
    public final FrameLayout f;
    public final PhotoView g;

    private C7322Rf3(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView, CircularView circularView, FrameLayout frameLayout, PhotoView photoView) {
        this.a = relativeLayout;
        this.b = relativeLayout2;
        this.c = imageView;
        this.d = textView;
        this.e = circularView;
        this.f = frameLayout;
        this.g = photoView;
    }

    public static C7322Rf3 a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = BC5.downloadIcon;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.downloadPercent;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.downloadProgress;
                CircularView circularView = (CircularView) AbstractC11738dW7.a(view, i);
                if (circularView != null) {
                    i = BC5.downloadView;
                    FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                    if (frameLayout != null) {
                        i = BC5.image;
                        PhotoView photoView = (PhotoView) AbstractC11738dW7.a(view, i);
                        if (photoView != null) {
                            return new C7322Rf3(relativeLayout, relativeLayout, imageView, textView, circularView, frameLayout, photoView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7322Rf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
