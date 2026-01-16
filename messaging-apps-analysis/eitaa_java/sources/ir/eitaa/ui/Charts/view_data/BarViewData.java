package ir.eitaa.ui.Charts.view_data;

import android.graphics.Paint;
import ir.eitaa.ui.Charts.data.ChartData;

/* loaded from: classes3.dex */
public class BarViewData extends LineViewData {
    public int blendColor;
    public final Paint unselectedPaint;

    public BarViewData(ChartData.Line line) {
        super(line);
        Paint paint = new Paint();
        this.unselectedPaint = paint;
        this.blendColor = 0;
        this.paint.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(false);
    }

    @Override // ir.eitaa.ui.Charts.view_data.LineViewData
    public void updateColors() {
        super.updateColors();
    }
}
