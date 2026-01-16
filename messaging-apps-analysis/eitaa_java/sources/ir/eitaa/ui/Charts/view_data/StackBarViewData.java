package ir.eitaa.ui.Charts.view_data;

import android.graphics.Paint;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Charts.data.ChartData;

/* loaded from: classes3.dex */
public class StackBarViewData extends LineViewData {
    public int blendColor;
    public final Paint unselectedPaint;

    @Override // ir.eitaa.ui.Charts.view_data.LineViewData
    public void updateColors() {
        super.updateColors();
        this.blendColor = ColorUtils.blendARGB(Theme.getColor("windowBackgroundWhite"), this.lineColor, 0.3f);
    }

    public StackBarViewData(ChartData.Line line) {
        super(line);
        Paint paint = new Paint();
        this.unselectedPaint = paint;
        this.blendColor = 0;
        this.paint.setStrokeWidth(AndroidUtilities.dpf2(1.0f));
        this.paint.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(false);
    }
}
