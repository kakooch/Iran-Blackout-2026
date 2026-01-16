package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ja.burhanrashid52.photoeditor.DrawingView;

/* renamed from: ir.nasim.Ik0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5218Ik0 {
    private final ViewGroup a;
    private final C24159y85 b;

    public C5218Ik0(ViewGroup viewGroup, C24159y85 c24159y85) {
        AbstractC13042fc3.i(viewGroup, "mViewGroup");
        AbstractC13042fc3.i(c24159y85, "mViewState");
        this.a = viewGroup;
        this.b = c24159y85;
    }

    public final void a(DrawingView drawingView) {
        int iG = this.b.g();
        if (iG > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                this.a.removeView(this.b.f(i));
                if (i2 >= iG) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        if (drawingView != null && this.b.e(drawingView)) {
            this.a.addView(drawingView);
        }
        this.b.b();
        this.b.d();
        if (drawingView == null) {
            return;
        }
        drawingView.b();
    }

    public final void b() {
        int childCount = this.a.getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = this.a.getChildAt(i);
                FrameLayout frameLayout = (FrameLayout) childAt.findViewById(AbstractC20554sC5.frmBorder);
                if (frameLayout != null) {
                    frameLayout.setBackgroundResource(0);
                }
                ImageView imageView = (ImageView) childAt.findViewById(AbstractC20554sC5.imgPhotoEditorClose);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (i2 >= childCount) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        this.b.c();
    }
}
