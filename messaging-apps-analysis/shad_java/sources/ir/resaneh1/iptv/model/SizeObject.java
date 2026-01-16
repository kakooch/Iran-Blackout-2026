package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.DimensionHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class SizeObject {
    private float height;
    private float scaleSize = 100.0f;
    private float width;

    public int getWidthPx() {
        return AndroidUtilities.dp(this.width * DimensionHelper.getViewScaleSizePxt(r0));
    }

    public int getHeightPx() {
        return AndroidUtilities.dp(this.height * DimensionHelper.getViewScaleSizePxt(this.width));
    }

    public float changeAndGetScaleSizeByWidthPx(float f) {
        float fPxToDp = DimensionHelper.pxToDp(ApplicationLoader.applicationContext, f) / this.width;
        this.scaleSize = fPxToDp;
        return fPxToDp;
    }

    public float getHWRatio() {
        float f = this.width;
        if (f <= 0.0f) {
            return 1.0f;
        }
        return this.height / f;
    }
}
