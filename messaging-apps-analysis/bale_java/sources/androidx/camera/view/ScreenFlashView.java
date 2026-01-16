package androidx.camera.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import ir.nasim.AbstractC17949np7;
import ir.nasim.C24677z13;
import ir.nasim.LC0;
import ir.nasim.PI3;

/* loaded from: classes.dex */
public final class ScreenFlashView extends View {
    private Window a;
    private C24677z13.f b;

    class a implements C24677z13.f {
        private float a;
        private ValueAnimator b;

        a() {
        }

        @Override // ir.nasim.C24677z13.f
        public void clear() {
            PI3.a("ScreenFlashView", "ScreenFlash#clearScreenFlashUi");
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.b = null;
            }
            ScreenFlashView.this.setAlpha(0.0f);
            ScreenFlashView.this.setBrightness(this.a);
        }
    }

    public ScreenFlashView(Context context) {
        this(context, null);
    }

    private void b(Window window) {
        if (this.a != window) {
            this.b = window == null ? null : new a();
        }
    }

    private float getBrightness() {
        Window window = this.a;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        PI3.c("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f) {
        if (this.a == null) {
            PI3.c("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f)) {
            PI3.c("ScreenFlashView", "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.a.getAttributes();
        attributes.screenBrightness = f;
        this.a.setAttributes(attributes);
        PI3.a("ScreenFlashView", "Brightness set to " + attributes.screenBrightness);
    }

    private void setScreenFlashUiInfo(C24677z13.f fVar) {
        PI3.a("ScreenFlashView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public C24677z13.f getScreenFlash() {
        return this.b;
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    public void setController(LC0 lc0) {
        AbstractC17949np7.a();
    }

    public void setScreenFlashWindow(Window window) {
        AbstractC17949np7.a();
        b(window);
        this.a = window;
        setScreenFlashUiInfo(getScreenFlash());
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setBackgroundColor(-1);
        setAlpha(0.0f);
        setElevation(Float.MAX_VALUE);
    }
}
