package ir.nasim.features.media.components;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC7426Rr;

/* loaded from: classes6.dex */
public class SizeNotifierFrameLayoutPhoto extends FrameLayout {
    private android.graphics.Rect a;
    private int b;
    private SizeNotifierFrameLayoutPhotoDelegate c;

    public interface SizeNotifierFrameLayoutPhotoDelegate {
        void onSizeChanged(int i, boolean z);
    }

    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SizeNotifierFrameLayoutPhoto.this.c != null) {
                SizeNotifierFrameLayoutPhoto.this.c.onSizeChanged(SizeNotifierFrameLayoutPhoto.this.b, this.a);
            }
        }
    }

    public SizeNotifierFrameLayoutPhoto(Context context) {
        super(context);
        this.a = new android.graphics.Rect();
    }

    public int getKeyboardHeight() {
        View rootView = getRootView();
        getWindowVisibleDisplayFrame(this.a);
        int height = (AbstractC7426Rr.C().y - this.a.top) - (rootView.getHeight() - AbstractC7426Rr.J(rootView));
        if (height <= Math.max(AbstractC7426Rr.z(10.0f), AbstractC7426Rr.H())) {
            return 0;
        }
        return height;
    }

    public void notifyHeightChanged() {
        if (this.c != null) {
            this.b = getKeyboardHeight();
            post(new a(AbstractC7426Rr.C().x > AbstractC7426Rr.C().y));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        notifyHeightChanged();
    }

    public void setDelegate(SizeNotifierFrameLayoutPhotoDelegate sizeNotifierFrameLayoutPhotoDelegate) {
        this.c = sizeNotifierFrameLayoutPhotoDelegate;
    }
}
