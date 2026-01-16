package ir.nasim.features.scanner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import me.dm7.barcodescanner.core.ViewFinderView;

/* loaded from: classes6.dex */
class CustomViewFinderView extends ViewFinderView {
    public CustomViewFinderView(Context context) {
        super(context);
        d();
    }

    private void d() {
        setSquareViewFinder(true);
        setBorderColor(-1);
        setBorderCornerRadius(19);
        setBorderCornerRounded(true);
        setBorderStrokeWidth(10);
        setBorderLineLength(150);
        setLaserEnabled(true);
        setLaserColor(-1);
        setViewFinderOffset(-30);
    }

    @Override // me.dm7.barcodescanner.core.ViewFinderView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public CustomViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }
}
