package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.v54, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22352v54 implements InterfaceC9764aW7 {
    private final View a;
    public final ImageView b;
    public final CircleProgressBar c;

    private C22352v54(View view, ImageView imageView, CircleProgressBar circleProgressBar) {
        this.a = view;
        this.b = imageView;
        this.c = circleProgressBar;
    }

    public static C22352v54 a(View view) {
        int i = BC5.image;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.progress_bar;
            CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
            if (circleProgressBar != null) {
                return new C22352v54(view, imageView, circleProgressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C22352v54 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(AbstractC12208eD5.message_button, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
