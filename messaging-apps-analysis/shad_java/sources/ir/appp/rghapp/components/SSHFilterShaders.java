package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class SSHFilterShaders {
    private BlurProgram blurProgram;
    private boolean blurTextureCreated;
    private int brightnessHandle;
    private int contrastHandle;
    private FilterShadersDelegate delegate;
    private int fadeAmountHandle;
    private final SSHThumbnailFilterShader filtersShaderCode;
    private int heightHandle;
    private int highlightsHandle;
    private int highlightsTintColorHandle;
    private int highlightsTintIntensityHandle;
    private boolean hsvGenerated;
    private int inputTexCoordHandle;
    private boolean isVideo;
    private int linearBlurAngleHandle;
    private int linearBlurAspectRatioHandle;
    private int linearBlurExcludeBlurSizeHandle;
    private int linearBlurExcludePointHandle;
    private int linearBlurExcludeSizeHandle;
    private int linearBlurInputTexCoordHandle;
    private int linearBlurPositionHandle;
    private int linearBlurShaderProgram;
    private int linearBlurSourceImage2Handle;
    private int linearBlurSourceImageHandle;
    private int luxInputImageTexture2Handle;
    private int luxInputTexCoordHandle;
    private int luxIntensityHandle;
    private int luxPositionHandle;
    private int luxShaderProgram;
    private int luxSourceImageHandle;
    private boolean needUpdateBlurTexture;
    private int positionHandle;
    private int radialBlurAspectRatioHandle;
    private int radialBlurExcludeBlurSizeHandle;
    private int radialBlurExcludePointHandle;
    private int radialBlurExcludeSizeHandle;
    private int radialBlurInputTexCoordHandle;
    private int radialBlurPositionHandle;
    private int radialBlurShaderProgram;
    private int radialBlurSourceImage2Handle;
    private int radialBlurSourceImageHandle;
    private int renderBufferHeight;
    private int renderBufferWidth;
    private int[] renderFrameBuffer;
    private int rgbToHsvInputTexCoordHandle;
    private int rgbToHsvPositionHandle;
    private int rgbToHsvShaderProgram;
    private int rgbToHsvSourceImageHandle;
    private int saturationHandle;
    private boolean scaleMaxSize;
    private int shadowsHandle;
    private int shadowsTintColorHandle;
    private int shadowsTintIntensityHandle;
    private int sharpenHandle;
    private int sharpenHeightHandle;
    private int sharpenInputTexCoordHandle;
    private int sharpenPositionHandle;
    private int sharpenShaderProgram;
    private int sharpenSourceImageHandle;
    private int sharpenWidthHandle;
    private int sourceImageHandle;
    private final FloatBuffer textureBuffer;
    private int toolsShaderProgram;
    private final FloatBuffer vertexBuffer;
    private final FloatBuffer vertexInvertBuffer;
    private float[] videoMatrix;
    private int videoTexture;
    private int vignetteHandle;
    private int warmthHandle;
    private int widthHandle;
    private final int[] luxTextures = new int[2];
    private final int[] luxFrameBuffer = new int[1];
    private final int[] sharpenTextures = new int[1];
    private final int[] sharpenFrameBuffer = new int[1];
    private final int[] renderTexture = new int[3];
    private final int[] bitmapTexture = new int[1];

    public interface FilterShadersDelegate {
        int filterId();

        float filterSize();

        float getBlurAngle();

        float getBlurExcludeBlurSize();

        Point getBlurExcludePoint();

        float getBlurExcludeSize();

        int getBlurType();

        float getBrightnessValue();

        float getContrastValue();

        float getFadeValue();

        float getHighlightsValue();

        float getLuxValue();

        float getSaturationValue();

        float getShadowsValue();

        float getSharpenValue();

        int getTintHighlightsColor();

        float getTintHighlightsIntensityValue();

        int getTintShadowsColor();

        float getTintShadowsIntensityValue();

        float getVignetteValue();

        float getWarmthValue();

        float getWhiteSurfaceAlphaSize();

        boolean shouldShowOriginal();
    }

    public SSHFilterShaders(Context context, boolean z, int i) {
        this.isVideo = z;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.vertexBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f});
        floatBufferAsFloatBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        this.vertexInvertBuffer = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer2.position(0);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer3;
        floatBufferAsFloatBuffer3.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer3.position(0);
        this.filtersShaderCode = new SSHThumbnailFilterShader(context, this.isVideo, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String vertexShaderForOptimizedBlurOfRadius(int i, float f) {
        int i2 = i + 1;
        float[] fArr = new float[i2];
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            double d = f;
            fArr[i3] = (float) ((1.0d / Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i3, 2.0d)) / (Math.pow(d, 2.0d) * 2.0d)));
            if (i3 == 0) {
                f2 += fArr[i3];
            } else {
                double d2 = f2;
                double d3 = fArr[i3];
                Double.isNaN(d3);
                Double.isNaN(d2);
                f2 = (float) (d2 + (d3 * 2.0d));
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            fArr[i4] = fArr[i4] / f2;
        }
        int iMin = Math.min((i / 2) + (i % 2), 7);
        float[] fArr2 = new float[iMin];
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = i5 * 2;
            int i7 = i6 + 1;
            float f3 = fArr[i7];
            int i8 = i6 + 2;
            float f4 = fArr[i8];
            fArr2[i5] = ((f3 * i7) + (f4 * i8)) / (f3 + f4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("attribute vec4 position;\n");
        sb.append("attribute vec4 inputTexCoord;\n");
        sb.append("uniform float texelWidthOffset;\n");
        sb.append("uniform float texelHeightOffset;\n");
        sb.append(String.format(Locale.US, "varying vec2 blurCoordinates[%d];\n", Integer.valueOf((iMin * 2) + 1)));
        sb.append("void main()\n");
        sb.append("{\n");
        sb.append("gl_Position = position;\n");
        sb.append("vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n");
        sb.append("blurCoordinates[0] = inputTexCoord.xy;\n");
        for (int i9 = 0; i9 < iMin; i9++) {
            int i10 = i9 * 2;
            sb.append(String.format(Locale.US, "blurCoordinates[%d] = inputTexCoord.xy + singleStepOffset * %f;\nblurCoordinates[%d] = inputTexCoord.xy - singleStepOffset * %f;\n", Integer.valueOf(i10 + 1), Float.valueOf(fArr2[i9]), Integer.valueOf(i10 + 2), Float.valueOf(fArr2[i9])));
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fragmentShaderForOptimizedBlurOfRadius(int i, float f) {
        int i2 = i + 1;
        float[] fArr = new float[i2];
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            double d = f;
            fArr[i3] = (float) ((1.0d / Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i3, 2.0d)) / (Math.pow(d, 2.0d) * 2.0d)));
            if (i3 == 0) {
                f2 += fArr[i3];
            } else {
                double d2 = f2;
                double d3 = fArr[i3];
                Double.isNaN(d3);
                Double.isNaN(d2);
                f2 = (float) (d2 + (d3 * 2.0d));
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            fArr[i4] = fArr[i4] / f2;
        }
        int i5 = (i / 2) + (i % 2);
        int iMin = Math.min(i5, 7);
        StringBuilder sb = new StringBuilder();
        sb.append("uniform sampler2D sourceImage;\n");
        sb.append("uniform highp float texelWidthOffset;\n");
        sb.append("uniform highp float texelHeightOffset;\n");
        sb.append("uniform highp float alpha;\n");
        Locale locale = Locale.US;
        sb.append(String.format(locale, "varying highp vec2 blurCoordinates[%d];\n", Integer.valueOf((iMin * 2) + 1)));
        sb.append("void main()\n");
        sb.append("{\n");
        sb.append("lowp vec4 sum = vec4(0.0);\n");
        sb.append(String.format(locale, "sum += texture2D(sourceImage, blurCoordinates[0]) * %f;\n", Float.valueOf(fArr[0])));
        for (int i6 = 0; i6 < iMin; i6++) {
            int i7 = i6 * 2;
            int i8 = i7 + 1;
            int i9 = i7 + 2;
            float f3 = fArr[i8] + fArr[i9];
            Locale locale2 = Locale.US;
            sb.append(String.format(locale2, "sum += texture2D(sourceImage, blurCoordinates[%d]) * %f;\n", Integer.valueOf(i8), Float.valueOf(f3)));
            sb.append(String.format(locale2, "sum += texture2D(sourceImage, blurCoordinates[%d]) * %f;\n", Integer.valueOf(i9), Float.valueOf(f3)));
        }
        if (i5 > iMin) {
            sb.append("highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n");
            while (iMin < i5) {
                int i10 = iMin * 2;
                int i11 = i10 + 1;
                float f4 = fArr[i11];
                int i12 = i10 + 2;
                float f5 = fArr[i12];
                float f6 = f4 + f5;
                float f7 = ((f4 * i11) + (f5 * i12)) / f6;
                Locale locale3 = Locale.US;
                sb.append(String.format(locale3, "sum += texture2D(sourceImage, blurCoordinates[0] + singleStepOffset * %f) * %f;\n", Float.valueOf(f7), Float.valueOf(f6)));
                sb.append(String.format(locale3, "sum += texture2D(sourceImage, blurCoordinates[0] - singleStepOffset * %f) * %f;\n", Float.valueOf(f7), Float.valueOf(f6)));
                iMin++;
            }
        }
        sb.append("sum = mix(sum,vec4(1.0,1.0,1.0,1.0),alpha);\n");
        sb.append("gl_FragColor = sum;\n");
        sb.append("}\n");
        return sb.toString();
    }

    public static int loadShader(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e(GLES20.glGetShaderInfoLog(iGlCreateShader));
            FileLog.e("shader code:\n " + str);
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static FilterShadersDelegate getFilterShadersDelegate(final RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState) {
        return new FilterShadersDelegate() { // from class: ir.appp.rghapp.components.SSHFilterShaders.1
            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public boolean shouldShowOriginal() {
                return false;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getShadowsValue() {
                return ((rGHMediaHelper$SavedFilterState.shadowsValue * 0.55f) + 100.0f) / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getHighlightsValue() {
                return ((rGHMediaHelper$SavedFilterState.highlightsValue * 0.75f) + 100.0f) / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getLuxValue() {
                return rGHMediaHelper$SavedFilterState.luxValue / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getBrightnessValue() {
                return rGHMediaHelper$SavedFilterState.brightnessValue / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getContrastValue() {
                return ((rGHMediaHelper$SavedFilterState.contrastValue / 100.0f) * 0.3f) + 1.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getWarmthValue() {
                return rGHMediaHelper$SavedFilterState.warmthValue / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public int filterId() {
                return rGHMediaHelper$SavedFilterState.filterId;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float filterSize() {
                return rGHMediaHelper$SavedFilterState.filterSize / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getVignetteValue() {
                return rGHMediaHelper$SavedFilterState.vignetteValue / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getSharpenValue() {
                return (rGHMediaHelper$SavedFilterState.sharpenValue / 100.0f) + 0.11f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getFadeValue() {
                return rGHMediaHelper$SavedFilterState.fadeValue / 100.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getTintHighlightsIntensityValue() {
                if (rGHMediaHelper$SavedFilterState.tintHighlightsColor == 0) {
                    return 0.0f;
                }
                return r0.tintHighlightsIntensity / 75.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getTintShadowsIntensityValue() {
                if (rGHMediaHelper$SavedFilterState.tintShadowsColor == 0) {
                    return 0.0f;
                }
                return r0.tintShadowsIntensity / 75.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getSaturationValue() {
                float f = rGHMediaHelper$SavedFilterState.saturationValue / 100.0f;
                if (f > 0.0f) {
                    f *= 1.05f;
                }
                return f + 1.0f;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public int getTintHighlightsColor() {
                return rGHMediaHelper$SavedFilterState.tintHighlightsColor;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public int getTintShadowsColor() {
                return rGHMediaHelper$SavedFilterState.tintShadowsColor;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public int getBlurType() {
                return rGHMediaHelper$SavedFilterState.blurType;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getWhiteSurfaceAlphaSize() {
                return rGHMediaHelper$SavedFilterState.whiteSurfaceAlphaSize;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getBlurExcludeSize() {
                return rGHMediaHelper$SavedFilterState.blurExcludeSize;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getBlurExcludeBlurSize() {
                return rGHMediaHelper$SavedFilterState.blurExcludeBlurSize;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public float getBlurAngle() {
                return rGHMediaHelper$SavedFilterState.blurAngle;
            }

            @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
            public Point getBlurExcludePoint() {
                return rGHMediaHelper$SavedFilterState.blurExcludePoint;
            }
        };
    }

    public void setDelegate(FilterShadersDelegate filterShadersDelegate) {
        this.delegate = filterShadersDelegate;
    }

    public boolean create() {
        GLES20.glGenTextures(2, this.luxTextures, 0);
        GLES20.glGenTextures(1, this.sharpenTextures, 0);
        GLES20.glGenFramebuffers(1, this.luxFrameBuffer, 0);
        GLES20.glGenFramebuffers(1, this.sharpenFrameBuffer, 0);
        GLES20.glBindTexture(3553, this.luxTextures[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int[] iArr = new int[1];
        int iLoadShader = loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
        int iLoadShader2 = loadShader(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;uniform highp float width;uniform highp float height;uniform lowp float shadows;const mediump vec3 hsLuminanceWeighting = vec3(0.3, 0.3, 0.3);uniform lowp float highlights;uniform lowp float contrast;uniform lowp float fadeAmount;const mediump vec3 satLuminanceWeighting = vec3(0.2126, 0.7152, 0.0722);uniform lowp float saturation;uniform lowp float shadowsTintIntensity;uniform lowp float highlightsTintIntensity;uniform lowp vec3 shadowsTintColor;uniform lowp vec3 highlightsTintColor;uniform lowp float brightness;uniform lowp float warmth;const lowp float permTexUnit = 1.0 / 256.0;const lowp float permTexUnitHalf = 0.5 / 256.0;uniform lowp float vignette;highp float getLuma(highp vec3 rgbP) {return (0.299 * rgbP.r) + (0.587 * rgbP.g) + (0.114 * rgbP.b);}lowp vec3 rgbToHsv(lowp vec3 c) {highp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);highp vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);highp vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);highp float d = q.x - min(q.w, q.y);highp float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}lowp vec3 hsvToRgb(lowp vec3 c) {highp vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);highp vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);}highp vec3 rgbToHsl(highp vec3 color) {highp vec3 hsl;highp float fmin = min(min(color.r, color.g), color.b);highp float fmax = max(max(color.r, color.g), color.b);highp float delta = fmax - fmin;hsl.z = (fmax + fmin) / 2.0;if (delta == 0.0) {hsl.x = 0.0;hsl.y = 0.0;} else {if (hsl.z < 0.5) {hsl.y = delta / (fmax + fmin);} else {hsl.y = delta / (2.0 - fmax - fmin);}highp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;highp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;highp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;if (color.r == fmax) {hsl.x = deltaB - deltaG;} else if (color.g == fmax) {hsl.x = (1.0 / 3.0) + deltaR - deltaB;} else if (color.b == fmax) {hsl.x = (2.0 / 3.0) + deltaG - deltaR;}if (hsl.x < 0.0) {hsl.x += 1.0;} else if (hsl.x > 1.0) {hsl.x -= 1.0;}}return hsl;}highp float hueToRgb(highp float f1, highp float f2, highp float hue) {if (hue < 0.0) {hue += 1.0;} else if (hue > 1.0) {hue -= 1.0;}highp float res;if ((6.0 * hue) < 1.0) {res = f1 + (f2 - f1) * 6.0 * hue;} else if ((2.0 * hue) < 1.0) {res = f2;} else if ((3.0 * hue) < 2.0) {res = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;} else {res = f1;}return res;}highp vec3 hslToRgb(highp vec3 hsl) {if (hsl.y == 0.0) {return vec3(hsl.z);} else {highp float f2;if (hsl.z < 0.5) {f2 = hsl.z * (1.0 + hsl.y);} else {f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z);}highp float f1 = 2.0 * hsl.z - f2;return vec3(hueToRgb(f1, f2, hsl.x + (1.0/3.0)), hueToRgb(f1, f2, hsl.x), hueToRgb(f1, f2, hsl.x - (1.0/3.0)));}}highp vec3 rgbToYuv(highp vec3 inP) {highp float luma = getLuma(inP);return vec3(luma, (1.0 / 1.772) * (inP.b - luma), (1.0 / 1.402) * (inP.r - luma));}lowp vec3 yuvToRgb(highp vec3 inP) {return vec3(1.402 * inP.b + inP.r, (inP.r - (0.299 * 1.402 / 0.587) * inP.b - (0.114 * 1.772 / 0.587) * inP.g), 1.772 * inP.g + inP.r);}lowp float easeInOutSigmoid(lowp float value, lowp float strength) {if (value > 0.5) {return 1.0 - pow(2.0 - 2.0 * value, 1.0 / (1.0 - strength)) * 0.5;} else {return pow(2.0 * value, 1.0 / (1.0 - strength)) * 0.5;}}highp vec3 fadeAdjust(highp vec3 color, highp float fadeVal) {return (color * (1.0 - fadeVal)) + ((color + (vec3(-0.9772) * pow(vec3(color), vec3(3.0)) + vec3(1.708) * pow(vec3(color), vec3(2.0)) + vec3(-0.1603) * vec3(color) + vec3(0.2878) - color * vec3(0.9))) * fadeVal);}lowp vec3 tintRaiseShadowsCurve(lowp vec3 color) {return vec3(-0.003671) * pow(color, vec3(3.0)) + vec3(0.3842) * pow(color, vec3(2.0)) + vec3(0.3764) * color + vec3(0.2515);}lowp vec3 tintShadows(lowp vec3 texel, lowp vec3 tintColor, lowp float tintAmount) {return clamp(mix(texel, mix(texel, tintRaiseShadowsCurve(texel), tintColor), tintAmount), 0.0, 1.0);} lowp vec3 tintHighlights(lowp vec3 texel, lowp vec3 tintColor, lowp float tintAmount) {return clamp(mix(texel, mix(texel, vec3(1.0) - tintRaiseShadowsCurve(vec3(1.0) - texel), (vec3(1.0) - tintColor)), tintAmount), 0.0, 1.0);}highp vec4 rnm(in highp vec2 tc) {highp float noise = sin(dot(tc, vec2(12.9898, 78.233))) * 43758.5453;return vec4(fract(noise), fract(noise * 1.2154), fract(noise * 1.3453), fract(noise * 1.3647)) * 2.0 - 1.0;}highp float fade(in highp float t) {return t * t * t * (t * (t * 6.0 - 15.0) + 10.0);}highp float pnoise3D(in highp vec3 p) {highp vec3 pi = permTexUnit * floor(p) + permTexUnitHalf;highp vec3 pf = fract(p);highp float perm = rnm(pi.xy).a;highp float n000 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf);highp float n001 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(0.0, 0.0, 1.0));perm = rnm(pi.xy + vec2(0.0, permTexUnit)).a;highp float n010 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(0.0, 1.0, 0.0));highp float n011 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(0.0, 1.0, 1.0));perm = rnm(pi.xy + vec2(permTexUnit, 0.0)).a;highp float n100 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(1.0, 0.0, 0.0));highp float n101 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(1.0, 0.0, 1.0));perm = rnm(pi.xy + vec2(permTexUnit, permTexUnit)).a;highp float n110 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(1.0, 1.0, 0.0));highp float n111 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(1.0, 1.0, 1.0));highp vec4 n_x = mix(vec4(n000, n001, n010, n011), vec4(n100, n101, n110, n111), fade(pf.x));highp vec2 n_xy = mix(n_x.xy, n_x.zw, fade(pf.y));return mix(n_xy.x, n_xy.y, fade(pf.z));}lowp vec2 coordRot(in lowp vec2 tc, in lowp float angle) {return vec2(((tc.x * 2.0 - 1.0) * cos(angle) - (tc.y * 2.0 - 1.0) * sin(angle)) * 0.5 + 0.5, ((tc.y * 2.0 - 1.0) * cos(angle) + (tc.x * 2.0 - 1.0) * sin(angle)) * 0.5 + 0.5);}void main() {lowp vec4 source = texture2D(sourceImage, texCoord);lowp vec4 result = source;const lowp float toolEpsilon = 0.005;mediump float hsLuminance = dot(result.rgb, hsLuminanceWeighting);mediump float shadow = clamp((pow(hsLuminance, 1.0 / shadows) + (-0.76) * pow(hsLuminance, 2.0 / shadows)) - hsLuminance, 0.0, 1.0);mediump float highlight = clamp((1.0 - (pow(1.0 - hsLuminance, 1.0 / (2.0 - highlights)) + (-0.8) * pow(1.0 - hsLuminance, 2.0 / (2.0 - highlights)))) - hsLuminance, -1.0, 0.0);lowp vec3 hsresult = vec3(0.0, 0.0, 0.0) + ((hsLuminance + shadow + highlight) - 0.0) * ((result.rgb - vec3(0.0, 0.0, 0.0)) / (hsLuminance - 0.0));mediump float contrastedLuminance = ((hsLuminance - 0.5) * 1.5) + 0.5;mediump float whiteInterp = contrastedLuminance * contrastedLuminance * contrastedLuminance;mediump float whiteTarget = clamp(highlights, 1.0, 2.0) - 1.0;hsresult = mix(hsresult, vec3(1.0), whiteInterp * whiteTarget);mediump float invContrastedLuminance = 1.0 - contrastedLuminance;mediump float blackInterp = invContrastedLuminance * invContrastedLuminance * invContrastedLuminance;mediump float blackTarget = 1.0 - clamp(shadows, 0.0, 1.0);hsresult = mix(hsresult, vec3(0.0), blackInterp * blackTarget);result = vec4(hsresult.rgb, result.a);result = vec4(clamp(((result.rgb - vec3(0.5)) * contrast + vec3(0.5)), 0.0, 1.0), result.a);if (abs(fadeAmount) > toolEpsilon) {result.rgb = fadeAdjust(result.rgb, fadeAmount);}lowp float satLuminance = dot(result.rgb, satLuminanceWeighting);lowp vec3 greyScaleColor = vec3(satLuminance);result = vec4(clamp(mix(greyScaleColor, result.rgb, saturation), 0.0, 1.0), result.a);if (abs(shadowsTintIntensity) > toolEpsilon) {result.rgb = tintShadows(result.rgb, shadowsTintColor, shadowsTintIntensity * 2.0);}if (abs(highlightsTintIntensity) > toolEpsilon) {result.rgb = tintHighlights(result.rgb, highlightsTintColor, highlightsTintIntensity * 2.0);}if (abs(brightness) > toolEpsilon) {mediump float mag = brightness * 1.045;mediump float brightnessPower = 1.0 + abs(mag);if (mag < 0.0) {brightnessPower = 1.0 / brightnessPower;}result.r = 1.0 - pow((1.0 - result.r), brightnessPower);result.g = 1.0 - pow((1.0 - result.g), brightnessPower);result.b = 1.0 - pow((1.0 - result.b), brightnessPower);}if (abs(warmth) > toolEpsilon) {highp vec3 yuvVec;if (warmth > 0.0 ) {yuvVec = vec3(0.1765, -0.1255, 0.0902);} else {yuvVec = -vec3(0.0588, 0.1569, -0.1255);}highp vec3 yuvColor = rgbToYuv(result.rgb);highp float luma = yuvColor.r;highp float curveScale = sin(luma * 3.14159);yuvColor += 0.375 * warmth * curveScale * yuvVec;result.rgb = yuvToRgb(yuvColor);}if (abs(vignette) > toolEpsilon) {const lowp float midpoint = 0.7;const lowp float fuzziness = 0.62;lowp float radDist = length(texCoord - 0.5) / sqrt(0.5);lowp float mag = easeInOutSigmoid(radDist * midpoint, fuzziness) * vignette * 0.645;result.rgb = mix(pow(result.rgb, vec3(1.0 / (1.0 - mag))), vec3(0.0), mag * mag);}gl_FragColor = result;}");
        if (iLoadShader != 0 && iLoadShader2 != 0) {
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.toolsShaderProgram = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            GLES20.glAttachShader(this.toolsShaderProgram, iLoadShader2);
            GLES20.glBindAttribLocation(this.toolsShaderProgram, 0, "position");
            GLES20.glBindAttribLocation(this.toolsShaderProgram, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.toolsShaderProgram);
            GLES20.glGetProgramiv(this.toolsShaderProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(this.toolsShaderProgram);
                this.toolsShaderProgram = 0;
            } else {
                this.positionHandle = GLES20.glGetAttribLocation(this.toolsShaderProgram, "position");
                this.inputTexCoordHandle = GLES20.glGetAttribLocation(this.toolsShaderProgram, "inputTexCoord");
                this.sourceImageHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "sourceImage");
                this.shadowsHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "shadows");
                this.highlightsHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "highlights");
                this.brightnessHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "brightness");
                this.contrastHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "contrast");
                this.saturationHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "saturation");
                this.warmthHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "warmth");
                this.vignetteHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "vignette");
                this.widthHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "width");
                this.heightHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "height");
                this.fadeAmountHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "fadeAmount");
                this.shadowsTintIntensityHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "shadowsTintIntensity");
                this.highlightsTintIntensityHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "highlightsTintIntensity");
                this.shadowsTintColorHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "shadowsTintColor");
                this.highlightsTintColorHandle = GLES20.glGetUniformLocation(this.toolsShaderProgram, "highlightsTintColor");
            }
            int iLoadShader3 = loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;uniform highp float inputWidth;uniform highp float inputHeight;varying vec2 leftTexCoord;varying vec2 rightTexCoord;varying vec2 topTexCoord;varying vec2 bottomTexCoord;void main() {gl_Position = position;texCoord = inputTexCoord;highp vec2 widthStep = vec2(1.0 / inputWidth, 0.0);highp vec2 heightStep = vec2(0.0, 1.0 / inputHeight);leftTexCoord = inputTexCoord - widthStep;rightTexCoord = inputTexCoord + widthStep;topTexCoord = inputTexCoord + heightStep;bottomTexCoord = inputTexCoord - heightStep;}");
            int iLoadShader4 = loadShader(35632, "precision highp float;varying vec2 texCoord;varying vec2 leftTexCoord;varying vec2 rightTexCoord;varying vec2 topTexCoord;varying vec2 bottomTexCoord;uniform sampler2D sourceImage;uniform float sharpen;void main() {vec4 result = texture2D(sourceImage, texCoord);vec3 leftTextureColor = texture2D(sourceImage, leftTexCoord).rgb;vec3 rightTextureColor = texture2D(sourceImage, rightTexCoord).rgb;vec3 topTextureColor = texture2D(sourceImage, topTexCoord).rgb;vec3 bottomTextureColor = texture2D(sourceImage, bottomTexCoord).rgb;result.rgb = result.rgb * (1.0 + 4.0 * sharpen) - (leftTextureColor + rightTextureColor + topTextureColor + bottomTextureColor) * sharpen;gl_FragColor = result;}");
            if (iLoadShader3 != 0 && iLoadShader4 != 0) {
                int iGlCreateProgram2 = GLES20.glCreateProgram();
                this.sharpenShaderProgram = iGlCreateProgram2;
                GLES20.glAttachShader(iGlCreateProgram2, iLoadShader3);
                GLES20.glAttachShader(this.sharpenShaderProgram, iLoadShader4);
                GLES20.glBindAttribLocation(this.sharpenShaderProgram, 0, "position");
                GLES20.glBindAttribLocation(this.sharpenShaderProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.sharpenShaderProgram);
                GLES20.glGetProgramiv(this.sharpenShaderProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.sharpenShaderProgram);
                    this.sharpenShaderProgram = 0;
                } else {
                    this.sharpenPositionHandle = GLES20.glGetAttribLocation(this.sharpenShaderProgram, "position");
                    this.sharpenInputTexCoordHandle = GLES20.glGetAttribLocation(this.sharpenShaderProgram, "inputTexCoord");
                    this.sharpenSourceImageHandle = GLES20.glGetUniformLocation(this.sharpenShaderProgram, "sourceImage");
                    this.sharpenWidthHandle = GLES20.glGetUniformLocation(this.sharpenShaderProgram, "inputWidth");
                    this.sharpenHeightHandle = GLES20.glGetUniformLocation(this.sharpenShaderProgram, "inputHeight");
                    this.sharpenHandle = GLES20.glGetUniformLocation(this.sharpenShaderProgram, "sharpen");
                }
                BlurProgram blurProgram = new BlurProgram(8.0f, 3.0f, false);
                this.blurProgram = blurProgram;
                if (!blurProgram.create()) {
                    return false;
                }
                int iLoadShader5 = loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
                int iLoadShader6 = loadShader(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;uniform sampler2D inputImageTexture2;uniform lowp float excludeSize;uniform lowp vec2 excludePoint;uniform lowp float excludeBlurSize;uniform highp float angle;uniform highp float aspectRatio;void main() {lowp vec4 sharpImageColor = texture2D(sourceImage, texCoord);lowp vec4 blurredImageColor = texture2D(inputImageTexture2, texCoord);highp vec2 texCoordToUse = vec2(texCoord.x, (texCoord.y * aspectRatio + 0.5 - 0.5 * aspectRatio));highp float distanceFromCenter = abs((texCoordToUse.x - excludePoint.x) * aspectRatio * cos(angle) + (texCoordToUse.y - excludePoint.y) * sin(angle));gl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeSize - excludeBlurSize, excludeSize, distanceFromCenter));}");
                if (iLoadShader5 != 0 && iLoadShader6 != 0) {
                    int iGlCreateProgram3 = GLES20.glCreateProgram();
                    this.linearBlurShaderProgram = iGlCreateProgram3;
                    GLES20.glAttachShader(iGlCreateProgram3, iLoadShader5);
                    GLES20.glAttachShader(this.linearBlurShaderProgram, iLoadShader6);
                    GLES20.glBindAttribLocation(this.linearBlurShaderProgram, 0, "position");
                    GLES20.glBindAttribLocation(this.linearBlurShaderProgram, 1, "inputTexCoord");
                    GLES20.glLinkProgram(this.linearBlurShaderProgram);
                    GLES20.glGetProgramiv(this.linearBlurShaderProgram, 35714, iArr, 0);
                    if (iArr[0] == 0) {
                        GLES20.glDeleteProgram(this.linearBlurShaderProgram);
                        this.linearBlurShaderProgram = 0;
                    } else {
                        this.linearBlurPositionHandle = GLES20.glGetAttribLocation(this.linearBlurShaderProgram, "position");
                        this.linearBlurInputTexCoordHandle = GLES20.glGetAttribLocation(this.linearBlurShaderProgram, "inputTexCoord");
                        this.linearBlurSourceImageHandle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "sourceImage");
                        this.linearBlurSourceImage2Handle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "inputImageTexture2");
                        this.linearBlurExcludeSizeHandle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "excludeSize");
                        this.linearBlurExcludePointHandle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "excludePoint");
                        this.linearBlurExcludeBlurSizeHandle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "excludeBlurSize");
                        this.linearBlurAngleHandle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "angle");
                        this.linearBlurAspectRatioHandle = GLES20.glGetUniformLocation(this.linearBlurShaderProgram, "aspectRatio");
                    }
                    int iLoadShader7 = loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
                    int iLoadShader8 = loadShader(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;uniform sampler2D inputImageTexture2;uniform lowp float excludeSize;uniform lowp vec2 excludePoint;uniform lowp float excludeBlurSize;uniform highp float aspectRatio;void main() {lowp vec4 sharpImageColor = texture2D(sourceImage, texCoord);lowp vec4 blurredImageColor = texture2D(inputImageTexture2, texCoord);highp vec2 texCoordToUse = vec2(texCoord.x, (texCoord.y * aspectRatio + 0.5 - 0.5 * aspectRatio));highp float distanceFromCenter = distance(excludePoint, texCoordToUse);gl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeSize - excludeBlurSize, excludeSize, distanceFromCenter));}");
                    if (iLoadShader7 != 0 && iLoadShader8 != 0) {
                        int iGlCreateProgram4 = GLES20.glCreateProgram();
                        this.radialBlurShaderProgram = iGlCreateProgram4;
                        GLES20.glAttachShader(iGlCreateProgram4, iLoadShader7);
                        GLES20.glAttachShader(this.radialBlurShaderProgram, iLoadShader8);
                        GLES20.glBindAttribLocation(this.radialBlurShaderProgram, 0, "position");
                        GLES20.glBindAttribLocation(this.radialBlurShaderProgram, 1, "inputTexCoord");
                        GLES20.glLinkProgram(this.radialBlurShaderProgram);
                        GLES20.glGetProgramiv(this.radialBlurShaderProgram, 35714, iArr, 0);
                        if (iArr[0] == 0) {
                            GLES20.glDeleteProgram(this.radialBlurShaderProgram);
                            this.radialBlurShaderProgram = 0;
                        } else {
                            this.radialBlurPositionHandle = GLES20.glGetAttribLocation(this.radialBlurShaderProgram, "position");
                            this.radialBlurInputTexCoordHandle = GLES20.glGetAttribLocation(this.radialBlurShaderProgram, "inputTexCoord");
                            this.radialBlurSourceImageHandle = GLES20.glGetUniformLocation(this.radialBlurShaderProgram, "sourceImage");
                            this.radialBlurSourceImage2Handle = GLES20.glGetUniformLocation(this.radialBlurShaderProgram, "inputImageTexture2");
                            this.radialBlurExcludeSizeHandle = GLES20.glGetUniformLocation(this.radialBlurShaderProgram, "excludeSize");
                            this.radialBlurExcludePointHandle = GLES20.glGetUniformLocation(this.radialBlurShaderProgram, "excludePoint");
                            this.radialBlurExcludeBlurSizeHandle = GLES20.glGetUniformLocation(this.radialBlurShaderProgram, "excludeBlurSize");
                            this.radialBlurAspectRatioHandle = GLES20.glGetUniformLocation(this.radialBlurShaderProgram, "aspectRatio");
                        }
                        int iLoadShader9 = loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
                        int iLoadShader10 = loadShader(35632, "precision highp float;varying vec2 texCoord;uniform sampler2D sourceImage;uniform sampler2D inputImageTexture2;uniform float intensity;float lux(float value) {const vec2 offset = vec2(0.001953125, 0.03125);value = value + offset.x;vec2 coord = (clamp(texCoord, 0.125, 1.0 - 0.125001) - 0.125) * 4.0;vec2 frac = fract(coord);coord = floor(coord);float p00 = float(coord.y * 4.0 + coord.x) * 0.0625 + offset.y;float p01 = float(coord.y * 4.0 + coord.x + 1.0) * 0.0625 + offset.y;float p10 = float((coord.y + 1.0) * 4.0 + coord.x) * 0.0625 + offset.y;float p11 = float((coord.y + 1.0) * 4.0 + coord.x + 1.0) * 0.0625 + offset.y;vec3 c00 = texture2D(inputImageTexture2, vec2(value, p00)).rgb;vec3 c01 = texture2D(inputImageTexture2, vec2(value, p01)).rgb;vec3 c10 = texture2D(inputImageTexture2, vec2(value, p10)).rgb;vec3 c11 = texture2D(inputImageTexture2, vec2(value, p11)).rgb;float c1 = ((c00.r - c00.g) / (c00.b - c00.g));float c2 = ((c01.r - c01.g) / (c01.b - c01.g));float c3 = ((c10.r - c10.g) / (c10.b - c10.g));float c4 = ((c11.r - c11.g) / (c11.b - c11.g));float c1_2 = mix(c1, c2, frac.x);float c3_4 = mix(c3, c4, frac.x);return mix(c1_2, c3_4, frac.y);}vec3 hsv_to_rgb(vec3 c) {vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);}void main() {vec4 texel = texture2D(sourceImage, texCoord);vec4 hsv = texel;hsv.y = min(1.0, hsv.y * 1.2);hsv.z = min(1.0, lux(hsv.z) * 1.1);gl_FragColor = vec4(hsv_to_rgb(mix(texel.xyz, hsv.xyz, intensity)), texel.w);}");
                        if (iLoadShader9 != 0 && iLoadShader10 != 0) {
                            int iGlCreateProgram5 = GLES20.glCreateProgram();
                            this.luxShaderProgram = iGlCreateProgram5;
                            GLES20.glAttachShader(iGlCreateProgram5, iLoadShader9);
                            GLES20.glAttachShader(this.luxShaderProgram, iLoadShader10);
                            GLES20.glBindAttribLocation(this.luxShaderProgram, 0, "position");
                            GLES20.glBindAttribLocation(this.luxShaderProgram, 1, "inputTexCoord");
                            GLES20.glLinkProgram(this.luxShaderProgram);
                            GLES20.glGetProgramiv(this.luxShaderProgram, 35714, iArr, 0);
                            if (iArr[0] == 0) {
                                GLES20.glDeleteProgram(this.luxShaderProgram);
                                this.luxShaderProgram = 0;
                            } else {
                                this.luxPositionHandle = GLES20.glGetAttribLocation(this.luxShaderProgram, "position");
                                this.luxInputTexCoordHandle = GLES20.glGetAttribLocation(this.luxShaderProgram, "inputTexCoord");
                                this.luxIntensityHandle = GLES20.glGetUniformLocation(this.luxShaderProgram, "intensity");
                                this.luxSourceImageHandle = GLES20.glGetUniformLocation(this.luxShaderProgram, "sourceImage");
                                this.luxInputImageTexture2Handle = GLES20.glGetUniformLocation(this.luxShaderProgram, "inputImageTexture2");
                            }
                            int iLoadShader11 = loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
                            int iLoadShader12 = loadShader(35632, "precision highp float;varying vec2 texCoord;uniform sampler2D sourceImage;vec3 rgb_to_hsv(vec3 c) {vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);float d = q.x - min(q.w, q.y);float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}void main() {vec4 texel = texture2D(sourceImage, texCoord);gl_FragColor = vec4(rgb_to_hsv(texel.rgb), texel.a);}");
                            if (iLoadShader11 != 0 && iLoadShader12 != 0) {
                                int iGlCreateProgram6 = GLES20.glCreateProgram();
                                this.rgbToHsvShaderProgram = iGlCreateProgram6;
                                GLES20.glAttachShader(iGlCreateProgram6, iLoadShader11);
                                GLES20.glAttachShader(this.rgbToHsvShaderProgram, iLoadShader12);
                                GLES20.glBindAttribLocation(this.rgbToHsvShaderProgram, 0, "position");
                                GLES20.glBindAttribLocation(this.rgbToHsvShaderProgram, 1, "inputTexCoord");
                                GLES20.glLinkProgram(this.rgbToHsvShaderProgram);
                                GLES20.glGetProgramiv(this.rgbToHsvShaderProgram, 35714, iArr, 0);
                                if (iArr[0] == 0) {
                                    GLES20.glDeleteProgram(this.rgbToHsvShaderProgram);
                                    this.rgbToHsvShaderProgram = 0;
                                } else {
                                    this.rgbToHsvPositionHandle = GLES20.glGetAttribLocation(this.rgbToHsvShaderProgram, "position");
                                    this.rgbToHsvInputTexCoordHandle = GLES20.glGetAttribLocation(this.rgbToHsvShaderProgram, "inputTexCoord");
                                    this.rgbToHsvSourceImageHandle = GLES20.glGetUniformLocation(this.rgbToHsvShaderProgram, "sourceImage");
                                }
                                return this.filtersShaderCode.create();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setRenderData(Context context, Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) throws IOException {
        this.scaleMaxSize = z;
        loadTexture(bitmap, i, i3, i4);
        this.filtersShaderCode.loadFiltersTextures(context);
        this.videoTexture = i2;
        this.hsvGenerated = false;
        GLES20.glBindTexture(3553, this.luxTextures[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, this.renderBufferWidth, this.renderBufferHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, this.sharpenTextures[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, this.renderBufferWidth, this.renderBufferHeight, 0, 6408, 5121, null);
    }

    public void drawLuxPass() {
        if (this.isVideo || this.delegate.shouldShowOriginal()) {
            return;
        }
        if (!this.hsvGenerated) {
            GLES20.glBindFramebuffer(36160, this.luxFrameBuffer[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.luxTextures[0], 0);
            GLES20.glUseProgram(this.rgbToHsvShaderProgram);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.bitmapTexture[0]);
            GLES20.glUniform1i(this.rgbToHsvSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.rgbToHsvInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.rgbToHsvInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.rgbToHsvPositionHandle);
            GLES20.glVertexAttribPointer(this.rgbToHsvPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
            GLES20.glDrawArrays(5, 0, 4);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.renderBufferWidth * this.renderBufferHeight * 4);
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
            ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(32896);
            GLES20.glReadPixels(0, 0, this.renderBufferWidth, this.renderBufferHeight, 6408, 5121, byteBufferAllocateDirect);
            Utilities.calcCDT(byteBufferAllocateDirect, this.renderBufferWidth, this.renderBufferHeight, byteBufferAllocateDirect2, byteBufferAllocateDirect3);
            GLES20.glBindTexture(3553, this.luxTextures[1]);
            GLES20.glTexImage2D(3553, 0, 6408, 256, 16, 0, 6408, 5121, byteBufferAllocateDirect2);
            this.hsvGenerated = true;
        }
        GLES20.glBindFramebuffer(36160, this.sharpenFrameBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.sharpenTextures[0], 0);
        GLES20.glUseProgram(this.luxShaderProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.luxTextures[0]);
        GLES20.glUniform1i(this.luxSourceImageHandle, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.luxTextures[1]);
        GLES20.glUniform1i(this.luxInputImageTexture2Handle, 1);
        FilterShadersDelegate filterShadersDelegate = this.delegate;
        if (filterShadersDelegate == null || filterShadersDelegate.shouldShowOriginal()) {
            GLES20.glUniform1f(this.luxIntensityHandle, 0.0f);
        } else {
            GLES20.glUniform1f(this.luxIntensityHandle, this.delegate.getLuxValue());
        }
        GLES20.glEnableVertexAttribArray(this.luxInputTexCoordHandle);
        GLES20.glVertexAttribPointer(this.luxInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(this.luxPositionHandle);
        GLES20.glVertexAttribPointer(this.luxPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void drawSharpenPass() {
        if (this.isVideo || this.delegate.shouldShowOriginal()) {
            return;
        }
        GLES20.glBindFramebuffer(36160, this.renderFrameBuffer[1]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.renderTexture[1], 0);
        GLES20.glUseProgram(this.sharpenShaderProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.sharpenTextures[0]);
        GLES20.glUniform1i(this.sharpenSourceImageHandle, 0);
        FilterShadersDelegate filterShadersDelegate = this.delegate;
        if (filterShadersDelegate == null || filterShadersDelegate.shouldShowOriginal()) {
            GLES20.glUniform1f(this.sharpenHandle, 0.0f);
        } else {
            GLES20.glUniform1f(this.sharpenHandle, this.delegate.getSharpenValue());
        }
        GLES20.glUniform1f(this.sharpenWidthHandle, this.renderBufferWidth);
        GLES20.glUniform1f(this.sharpenHeightHandle, this.renderBufferHeight);
        GLES20.glEnableVertexAttribArray(this.sharpenInputTexCoordHandle);
        GLES20.glVertexAttribPointer(this.sharpenInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(this.sharpenPositionHandle);
        GLES20.glVertexAttribPointer(this.sharpenPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void drawCustomParamsPass() {
        FilterShadersDelegate filterShadersDelegate = this.delegate;
        if (filterShadersDelegate != null) {
            if (!this.isVideo) {
                if (!filterShadersDelegate.shouldShowOriginal()) {
                    this.filtersShaderCode.setFilterType(this.delegate.filterId(), this.delegate.filterSize());
                    SSHThumbnailFilterShader sSHThumbnailFilterShader = this.filtersShaderCode;
                    int i = this.renderFrameBuffer[0];
                    int[] iArr = this.renderTexture;
                    sSHThumbnailFilterShader.drawFilters(i, iArr[0], iArr[1], null);
                }
                GLES20.glBindFramebuffer(36160, this.renderFrameBuffer[1]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.renderTexture[1], 0);
                GLES20.glUseProgram(this.toolsShaderProgram);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.delegate.shouldShowOriginal() ? this.bitmapTexture[0] : this.renderTexture[0]);
                GLES20.glUniform1i(this.sourceImageHandle, 0);
                FilterShadersDelegate filterShadersDelegate2 = this.delegate;
                if (filterShadersDelegate2 == null || filterShadersDelegate2.shouldShowOriginal()) {
                    GLES20.glUniform1f(this.shadowsHandle, 1.0f);
                    GLES20.glUniform1f(this.highlightsHandle, 1.0f);
                    GLES20.glUniform1f(this.brightnessHandle, 0.0f);
                    GLES20.glUniform1f(this.contrastHandle, 1.0f);
                    GLES20.glUniform1f(this.saturationHandle, 1.0f);
                    GLES20.glUniform1f(this.warmthHandle, 0.0f);
                    GLES20.glUniform1f(this.vignetteHandle, 0.0f);
                    GLES20.glUniform1f(this.fadeAmountHandle, 0.0f);
                    GLES20.glUniform3f(this.highlightsTintColorHandle, 0.0f, 0.0f, 0.0f);
                    GLES20.glUniform1f(this.highlightsTintIntensityHandle, 0.0f);
                    GLES20.glUniform3f(this.shadowsTintColorHandle, 0.0f, 0.0f, 0.0f);
                    GLES20.glUniform1f(this.shadowsTintIntensityHandle, 0.0f);
                } else {
                    GLES20.glUniform1f(this.shadowsHandle, this.delegate.getShadowsValue());
                    GLES20.glUniform1f(this.highlightsHandle, this.delegate.getHighlightsValue());
                    GLES20.glUniform1f(this.brightnessHandle, this.delegate.getBrightnessValue());
                    GLES20.glUniform1f(this.contrastHandle, this.delegate.getContrastValue());
                    GLES20.glUniform1f(this.saturationHandle, this.delegate.getSaturationValue());
                    GLES20.glUniform1f(this.warmthHandle, this.delegate.getWarmthValue());
                    GLES20.glUniform1f(this.vignetteHandle, this.delegate.getVignetteValue());
                    GLES20.glUniform1f(this.fadeAmountHandle, this.delegate.getFadeValue());
                    int tintHighlightsColor = this.delegate.getTintHighlightsColor();
                    int tintShadowsColor = this.delegate.getTintShadowsColor();
                    GLES20.glUniform3f(this.highlightsTintColorHandle, ((tintHighlightsColor >> 16) & 255) / 255.0f, ((tintHighlightsColor >> 8) & 255) / 255.0f, (tintHighlightsColor & 255) / 255.0f);
                    GLES20.glUniform1f(this.highlightsTintIntensityHandle, this.delegate.getTintHighlightsIntensityValue());
                    GLES20.glUniform3f(this.shadowsTintColorHandle, ((tintShadowsColor >> 16) & 255) / 255.0f, ((tintShadowsColor >> 8) & 255) / 255.0f, (tintShadowsColor & 255) / 255.0f);
                    GLES20.glUniform1f(this.shadowsTintIntensityHandle, this.delegate.getTintShadowsIntensityValue());
                }
                GLES20.glUniform1f(this.widthHandle, this.renderBufferWidth);
                GLES20.glUniform1f(this.heightHandle, this.renderBufferHeight);
                GLES20.glEnableVertexAttribArray(this.inputTexCoordHandle);
                GLES20.glVertexAttribPointer(this.inputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                GLES20.glEnableVertexAttribArray(this.positionHandle);
                GLES20.glVertexAttribPointer(this.positionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
                GLES20.glDrawArrays(5, 0, 4);
                return;
            }
            this.filtersShaderCode.setFilterType(filterShadersDelegate.filterId(), this.delegate.filterSize());
            this.filtersShaderCode.drawFilters(this.renderFrameBuffer[0], this.renderTexture[0], this.videoTexture, this.videoMatrix);
        }
    }

    public boolean drawBlurPass() {
        FilterShadersDelegate filterShadersDelegate;
        FilterShadersDelegate filterShadersDelegate2 = this.delegate;
        int blurType = filterShadersDelegate2 != null ? filterShadersDelegate2.getBlurType() : 0;
        if (this.isVideo || (filterShadersDelegate = this.delegate) == null || filterShadersDelegate.shouldShowOriginal() || blurType == 0) {
            return false;
        }
        if (this.needUpdateBlurTexture) {
            if (!this.blurTextureCreated) {
                GLES20.glBindTexture(3553, this.renderTexture[2]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, this.renderBufferWidth, this.renderBufferHeight, 0, 6408, 5121, null);
                this.blurTextureCreated = true;
            }
            GLES20.glUseProgram(this.blurProgram.blurShaderProgram);
            GLES20.glUniform1i(this.blurProgram.blurSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.blurProgram.blurInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.blurProgram.blurInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.blurProgram.blurPositionHandle);
            GLES20.glVertexAttribPointer(this.blurProgram.blurPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
            GLES20.glBindFramebuffer(36160, this.renderFrameBuffer[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.renderTexture[0], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.renderTexture[1]);
            GLES20.glUniform1f(this.blurProgram.blurWidthHandle, 0.0f);
            GLES20.glUniform1f(this.blurProgram.blurHeightHandle, 1.0f / this.renderBufferHeight);
            GLES20.glUniform1f(this.blurProgram.blurWhiteSurfaceAlphaHandle, this.delegate.getWhiteSurfaceAlphaSize());
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindFramebuffer(36160, this.renderFrameBuffer[2]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.renderTexture[2], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.renderTexture[0]);
            GLES20.glUniform1f(this.blurProgram.blurWidthHandle, 1.0f / this.renderBufferWidth);
            GLES20.glUniform1f(this.blurProgram.blurHeightHandle, 0.0f);
            GLES20.glUniform1f(this.blurProgram.blurWhiteSurfaceAlphaHandle, this.delegate.getWhiteSurfaceAlphaSize());
            GLES20.glDrawArrays(5, 0, 4);
            this.needUpdateBlurTexture = false;
        }
        GLES20.glBindFramebuffer(36160, this.renderFrameBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.renderTexture[0], 0);
        if (blurType == 1) {
            GLES20.glUseProgram(this.radialBlurShaderProgram);
            GLES20.glUniform1i(this.radialBlurSourceImageHandle, 0);
            GLES20.glUniform1i(this.radialBlurSourceImage2Handle, 1);
            GLES20.glUniform1f(this.radialBlurExcludeSizeHandle, this.delegate.getBlurExcludeSize());
            GLES20.glUniform1f(this.radialBlurExcludeBlurSizeHandle, this.delegate.getBlurExcludeBlurSize());
            Point blurExcludePoint = this.delegate.getBlurExcludePoint();
            GLES20.glUniform2f(this.radialBlurExcludePointHandle, blurExcludePoint.x, blurExcludePoint.y);
            GLES20.glUniform1f(this.radialBlurAspectRatioHandle, this.renderBufferHeight / this.renderBufferWidth);
            GLES20.glEnableVertexAttribArray(this.radialBlurInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.radialBlurInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.radialBlurPositionHandle);
            GLES20.glVertexAttribPointer(this.radialBlurPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
        } else if (blurType == 2) {
            GLES20.glUseProgram(this.linearBlurShaderProgram);
            GLES20.glUniform1i(this.linearBlurSourceImageHandle, 0);
            GLES20.glUniform1i(this.linearBlurSourceImage2Handle, 1);
            GLES20.glUniform1f(this.linearBlurExcludeSizeHandle, this.delegate.getBlurExcludeSize());
            GLES20.glUniform1f(this.linearBlurExcludeBlurSizeHandle, this.delegate.getBlurExcludeBlurSize());
            GLES20.glUniform1f(this.linearBlurAngleHandle, this.delegate.getBlurAngle());
            Point blurExcludePoint2 = this.delegate.getBlurExcludePoint();
            GLES20.glUniform2f(this.linearBlurExcludePointHandle, blurExcludePoint2.x, blurExcludePoint2.y);
            GLES20.glUniform1f(this.linearBlurAspectRatioHandle, this.renderBufferHeight / this.renderBufferWidth);
            GLES20.glEnableVertexAttribArray(this.linearBlurInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.linearBlurInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.linearBlurPositionHandle);
            GLES20.glVertexAttribPointer(this.linearBlurPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.renderTexture[1]);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.renderTexture[2]);
        GLES20.glDrawArrays(5, 0, 4);
        return true;
    }

    public void onVideoFrameUpdate(float[] fArr) {
        this.videoMatrix = fArr;
    }

    private Bitmap createBitmap(Bitmap bitmap, int i, float f) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public void loadTexture(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap bitmapCreateBitmap = bitmap;
        this.renderBufferWidth = i2;
        this.renderBufferHeight = i3;
        if (this.renderFrameBuffer == null) {
            int[] iArr = new int[3];
            this.renderFrameBuffer = iArr;
            GLES20.glGenFramebuffers(3, iArr, 0);
            GLES20.glGenTextures(3, this.renderTexture, 0);
        } else {
            int[] iArr2 = new int[3];
            this.renderFrameBuffer = iArr2;
            GLES20.glDeleteFramebuffers(3, iArr2, 0);
            GLES20.glDeleteTextures(3, this.renderFrameBuffer, 0);
            GLES20.glGenFramebuffers(3, this.renderFrameBuffer, 0);
            GLES20.glGenTextures(3, this.renderTexture, 0);
        }
        if (bitmapCreateBitmap != null && !bitmap.isRecycled()) {
            GLES20.glGenTextures(1, this.bitmapTexture, 0);
            float photoSize = AndroidUtilities.getPhotoSize();
            if (this.scaleMaxSize) {
                int i4 = this.renderBufferWidth;
                if (i4 > photoSize || this.renderBufferHeight > photoSize || i % 360 != 0) {
                    float width = 1.0f;
                    if (i4 > photoSize || this.renderBufferHeight > photoSize) {
                        width = photoSize / bitmap.getWidth();
                        float height = photoSize / bitmap.getHeight();
                        if (width >= height) {
                            width = height;
                        }
                    }
                    bitmapCreateBitmap = createBitmap(bitmapCreateBitmap, i, width);
                    this.renderBufferWidth = bitmapCreateBitmap.getWidth();
                    int height2 = bitmapCreateBitmap.getHeight();
                    this.renderBufferHeight = height2;
                    int i5 = i % 360;
                    if (i5 == 90 || i5 == 270) {
                        int i6 = this.renderBufferWidth;
                        this.renderBufferWidth = height2;
                        this.renderBufferHeight = i6;
                    }
                }
            }
            GLES20.glBindTexture(3553, this.bitmapTexture[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmapCreateBitmap, 0);
        }
        for (int i7 = 0; i7 < 2; i7++) {
            GLES20.glBindTexture(3553, this.renderTexture[i7]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6408, this.renderBufferWidth, this.renderBufferHeight, 0, 6408, 5121, null);
        }
    }

    public FloatBuffer getTextureBuffer() {
        return this.textureBuffer;
    }

    public FloatBuffer getVertexBuffer() {
        return this.vertexBuffer;
    }

    public int getRenderBufferWidth() {
        return this.renderBufferWidth;
    }

    public int getRenderBufferHeight() {
        return this.renderBufferHeight;
    }

    public int getRenderTexture(int i) {
        if (this.isVideo) {
            return this.renderTexture[i == 0 ? (char) 1 : (char) 0];
        }
        return this.renderTexture[i];
    }

    public int getRenderFrameBuffer() {
        int[] iArr = this.renderFrameBuffer;
        if (iArr != null) {
            return iArr[!this.isVideo ? 1 : 0];
        }
        return 0;
    }

    public void requestUpdateBlurTexture() {
        this.needUpdateBlurTexture = true;
    }

    private static class BlurProgram {
        public int blurHeightHandle;
        public int blurInputTexCoordHandle;
        public int blurPositionHandle;
        public int blurShaderProgram;
        public int blurSourceImageHandle;
        public int blurWhiteSurfaceAlphaHandle;
        public int blurWidthHandle;
        private final String fragmentShaderCode;
        private final String vertexShaderCode;

        public BlurProgram(float f, float f2, boolean z) {
            int i;
            if (z) {
                f2 = Math.round(f);
                i = 0;
                if (f2 >= 1.0f) {
                    double d = f2;
                    double dPow = Math.pow(d, 2.0d) * (-2.0d);
                    double d2 = 0.00390625f;
                    double dSqrt = Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d);
                    Double.isNaN(d2);
                    int iFloor = (int) Math.floor(Math.sqrt(dPow * Math.log(d2 * dSqrt)));
                    i = iFloor + (iFloor % 2);
                }
            } else {
                i = (int) f;
            }
            this.fragmentShaderCode = SSHFilterShaders.fragmentShaderForOptimizedBlurOfRadius(i, f2);
            this.vertexShaderCode = SSHFilterShaders.vertexShaderForOptimizedBlurOfRadius(i, f2);
        }

        public boolean create() {
            int iLoadShader = SSHFilterShaders.loadShader(35633, this.vertexShaderCode);
            int iLoadShader2 = SSHFilterShaders.loadShader(35632, this.fragmentShaderCode);
            if (iLoadShader == 0 || iLoadShader2 == 0) {
                return false;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.blurShaderProgram = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            GLES20.glAttachShader(this.blurShaderProgram, iLoadShader2);
            GLES20.glBindAttribLocation(this.blurShaderProgram, 0, "position");
            GLES20.glBindAttribLocation(this.blurShaderProgram, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.blurShaderProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.blurShaderProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(this.blurShaderProgram);
                this.blurShaderProgram = 0;
            } else {
                this.blurPositionHandle = GLES20.glGetAttribLocation(this.blurShaderProgram, "position");
                this.blurInputTexCoordHandle = GLES20.glGetAttribLocation(this.blurShaderProgram, "inputTexCoord");
                this.blurSourceImageHandle = GLES20.glGetUniformLocation(this.blurShaderProgram, "sourceImage");
                this.blurWidthHandle = GLES20.glGetUniformLocation(this.blurShaderProgram, "texelWidthOffset");
                this.blurHeightHandle = GLES20.glGetUniformLocation(this.blurShaderProgram, "texelHeightOffset");
                this.blurWhiteSurfaceAlphaHandle = GLES20.glGetUniformLocation(this.blurShaderProgram, "alpha");
            }
            return true;
        }
    }
}
