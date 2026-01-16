package ir.appp.rghapp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.rbmain.messenger.MediaController;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class RGHMediaHelper$SavedFilterState {
    public float blurAngle;
    public float blurExcludeBlurSize;
    public Point blurExcludePoint;
    public float blurExcludeSize;
    public int blurType;
    public float brightnessValue;
    public float fadeValue;
    public int filterId;
    public float filterSize;
    public float luxValue;
    public int tintHighlightsColor;
    public int tintHighlightsIntensity;
    public int tintShadowsColor;
    public int tintShadowsIntensity;
    public float vignetteValue;
    public float warmthValue;
    public float whiteSurfaceAlphaSize;
    public float contrastValue = 1.0f;
    public float saturationValue = 1.0f;
    public float highlightsValue = 1.0f;
    public float shadowsValue = 1.0f;
    public float sharpenValue = 6.6E-4f;

    public RGHMediaHelper$SavedFilterState() {
        new Object() { // from class: ir.appp.rghapp.components.RGHPhotoFilterView$CurvesToolValue
            public ByteBuffer curveBuffer;

            {
                new Object() { // from class: ir.appp.rghapp.components.RGHPhotoFilterView$CurvesValue
                };
                new Object() { // from class: ir.appp.rghapp.components.RGHPhotoFilterView$CurvesValue
                };
                new Object() { // from class: ir.appp.rghapp.components.RGHPhotoFilterView$CurvesValue
                };
                new Object() { // from class: ir.appp.rghapp.components.RGHPhotoFilterView$CurvesValue
                };
                this.curveBuffer = null;
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(MediaController.MAX_WIDTH_HEIGHT_SIZE);
                this.curveBuffer = byteBufferAllocateDirect;
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            }
        };
    }
}
