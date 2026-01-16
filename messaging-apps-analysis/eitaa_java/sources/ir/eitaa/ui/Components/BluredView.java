package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class BluredView extends View {
    public final BlurBehindDrawable drawable;

    public BluredView(Context context, View parentView, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        BlurBehindDrawable blurBehindDrawable = new BlurBehindDrawable(parentView, this, 1, resourcesProvider);
        this.drawable = blurBehindDrawable;
        blurBehindDrawable.setAnimateAlpha(false);
        blurBehindDrawable.show(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws InterruptedException {
        this.drawable.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) throws InterruptedException {
        super.onSizeChanged(w, h, oldw, oldh);
        this.drawable.checkSizes();
    }

    public void update() {
        this.drawable.invalidate();
    }

    public boolean fullyDrawing() {
        return this.drawable.isFullyDrawing() && getVisibility() == 0;
    }
}
