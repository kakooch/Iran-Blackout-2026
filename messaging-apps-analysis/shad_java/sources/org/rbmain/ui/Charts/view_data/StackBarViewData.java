package org.rbmain.ui.Charts.view_data;

import android.graphics.Paint;
import androidx.core.graphics.ColorUtils;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Charts.data.ChartData;

/* loaded from: classes4.dex */
public class StackBarViewData extends LineViewData {
    public int blendColor;
    public final Paint unselectedPaint;

    @Override // org.rbmain.ui.Charts.view_data.LineViewData
    public void updateColors() {
        super.updateColors();
        this.blendColor = ColorUtils.blendARGB(Theme.getColor(Theme.key_windowBackgroundWhite), this.lineColor, 0.3f);
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
