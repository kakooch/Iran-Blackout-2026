package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import org.rbmain.tgnet.TLObject;

/* loaded from: classes5.dex */
public class AvatarsImageView extends View {
    public final AvatarsDrawable avatarsDrawable;

    public AvatarsImageView(Context context) {
        super(context);
        this.avatarsDrawable = new AvatarsDrawable(this, false);
    }

    public AvatarsImageView(Context context, boolean z) {
        super(context);
        this.avatarsDrawable = new AvatarsDrawable(this, z);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.avatarsDrawable.width = getMeasuredWidth();
        this.avatarsDrawable.height = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarsDrawable.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.avatarsDrawable.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarsDrawable.onDetachedFromWindow();
    }

    public void setStyle(int i) {
        this.avatarsDrawable.setStyle(i);
    }

    public void setDelegate(Runnable runnable) {
        this.avatarsDrawable.setDelegate(runnable);
    }

    public void setObject(int i, int i2, TLObject tLObject) {
        this.avatarsDrawable.setObject(i, i2, tLObject);
    }

    public void setAvatarsTextSize(int i) {
        this.avatarsDrawable.setAvatarsTextSize(i);
    }

    public void setCount(int i) {
        this.avatarsDrawable.setCount(i);
    }

    public void commitTransition(boolean z) {
        this.avatarsDrawable.commitTransition(z);
    }

    public void updateAfterTransitionEnd() {
        this.avatarsDrawable.updateAfterTransitionEnd();
    }

    public void setCentered(boolean z) {
        this.avatarsDrawable.setCentered(z);
    }
}
