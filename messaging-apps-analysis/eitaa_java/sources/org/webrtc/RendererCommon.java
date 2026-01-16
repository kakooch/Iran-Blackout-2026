package org.webrtc;

import android.graphics.Point;
import android.opengl.Matrix;

/* loaded from: classes3.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    public interface GlDrawer {
        void drawOes(int oesTextureId, int originalWidth, int originalHeight, int rotatedWidth, int rotatedHeight, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, boolean blur);

        void drawRgb(int textureId, int originalWidth, int originalHeight, int rotatedWidth, int rotatedHeight, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, boolean blur);

        void drawYuv(int[] yuvTextures, int originalWidth, int originalHeight, int rotatedWidth, int rotatedHeight, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, boolean blur);

        void release();
    }

    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int videoWidth, int videoHeight, int rotation);
    }

    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    public static class VideoLayoutMeasure {
        private float visibleFractionMatchOrientation;
        private float visibleFractionMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
        }

        public void setScalingType(ScalingType scalingType) {
            setScalingType(scalingType, scalingType);
        }

        public void setScalingType(ScalingType scalingTypeMatchOrientation, ScalingType scalingTypeMismatchOrientation) {
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingTypeMatchOrientation);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingTypeMismatchOrientation);
        }

        public void setVisibleFraction(float visibleFractionMatchOrientation, float visibleFractionMismatchOrientation) {
            this.visibleFractionMatchOrientation = visibleFractionMatchOrientation;
            this.visibleFractionMismatchOrientation = visibleFractionMismatchOrientation;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.graphics.Point measure(boolean r8, int r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                r0 = 2147483647(0x7fffffff, float:NaN)
                int r1 = android.view.View.getDefaultSize(r0, r9)
                int r0 = android.view.View.getDefaultSize(r0, r10)
                if (r11 == 0) goto L5b
                if (r12 == 0) goto L5b
                if (r1 == 0) goto L5b
                if (r0 != 0) goto L14
                goto L5b
            L14:
                float r11 = (float) r11
                float r12 = (float) r12
                float r11 = r11 / r12
                float r12 = (float) r1
                float r2 = (float) r0
                float r12 = r12 / r2
                r2 = 1
                r3 = 0
                r4 = 1065353216(0x3f800000, float:1.0)
                int r5 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r5 <= 0) goto L24
                r5 = 1
                goto L25
            L24:
                r5 = 0
            L25:
                int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
                if (r6 <= 0) goto L2b
                r6 = 1
                goto L2c
            L2b:
                r6 = 0
            L2c:
                if (r5 != r6) goto L31
                float r5 = r7.visibleFractionMatchOrientation
                goto L33
            L31:
                float r5 = r7.visibleFractionMismatchOrientation
            L33:
                android.graphics.Point r5 = org.webrtc.RendererCommon.getDisplaySize(r5, r11, r1, r0)
                if (r8 != 0) goto L5a
                int r8 = android.view.View.MeasureSpec.getMode(r9)
                r9 = 1073741824(0x40000000, float:2.0)
                if (r8 != r9) goto L43
                r5.x = r1
            L43:
                int r8 = android.view.View.MeasureSpec.getMode(r10)
                if (r8 == r9) goto L58
                int r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r8 <= 0) goto L4f
                r8 = 1
                goto L50
            L4f:
                r8 = 0
            L50:
                int r9 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
                if (r9 <= 0) goto L55
                goto L56
            L55:
                r2 = 0
            L56:
                if (r8 != r2) goto L5a
            L58:
                r5.y = r0
            L5a:
                return r5
            L5b:
                android.graphics.Point r8 = new android.graphics.Point
                r8.<init>(r1, r0)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: org.webrtc.RendererCommon.VideoLayoutMeasure.measure(boolean, int, int, int, int):android.graphics.Point");
        }
    }

    public static float[] getLayoutMatrix(boolean mirror, float videoAspectRatio, float displayAspectRatio) {
        float f;
        float f2;
        if (displayAspectRatio > videoAspectRatio) {
            f2 = videoAspectRatio / displayAspectRatio;
            f = 1.0f;
        } else {
            f = displayAspectRatio / videoAspectRatio;
            f2 = 1.0f;
        }
        if (mirror) {
            f *= -1.0f;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }

    public static android.graphics.Matrix convertMatrixToAndroidGraphicsMatrix(float[] matrix4x4) {
        float[] fArr = {matrix4x4[0], matrix4x4[4], matrix4x4[12], matrix4x4[1], matrix4x4[5], matrix4x4[13], matrix4x4[3], matrix4x4[7], matrix4x4[15]};
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(android.graphics.Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
    }

    public static Point getDisplaySize(ScalingType scalingType, float videoAspectRatio, int maxDisplayWidth, int maxDisplayHeight) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), videoAspectRatio, maxDisplayWidth, maxDisplayHeight);
    }

    private static void adjustOrigin(float[] matrix) {
        matrix[12] = matrix[12] - ((matrix[0] + matrix[4]) * 0.5f);
        matrix[13] = matrix[13] - ((matrix[1] + matrix[5]) * 0.5f);
        matrix[12] = matrix[12] + 0.5f;
        matrix[13] = matrix[13] + 0.5f;
    }

    /* renamed from: org.webrtc.RendererCommon$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[ScalingType.values().length];
            $SwitchMap$org$webrtc$RendererCommon$ScalingType = iArr;
            try {
                iArr[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int i = AnonymousClass1.$SwitchMap$org$webrtc$RendererCommon$ScalingType[scalingType.ordinal()];
        if (i == 1) {
            return 1.0f;
        }
        if (i == 2) {
            return 0.0f;
        }
        if (i == 3) {
            return BALANCED_VISIBLE_FRACTION;
        }
        throw new IllegalArgumentException();
    }

    public static Point getDisplaySize(float minVisibleFraction, float videoAspectRatio, int maxDisplayWidth, int maxDisplayHeight) {
        if (minVisibleFraction == 0.0f || videoAspectRatio == 0.0f) {
            return new Point(maxDisplayWidth, maxDisplayHeight);
        }
        return new Point(Math.min(maxDisplayWidth, Math.round((maxDisplayHeight / minVisibleFraction) * videoAspectRatio)), Math.min(maxDisplayHeight, Math.round((maxDisplayWidth / minVisibleFraction) / videoAspectRatio)));
    }
}
