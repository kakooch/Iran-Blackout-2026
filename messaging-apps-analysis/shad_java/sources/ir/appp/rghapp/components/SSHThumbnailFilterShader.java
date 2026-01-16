package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SSHThumbnailFilterShader {
    public int adenFilterSizeHandle;
    public int adenInputImage2Handle;
    public int adenInputTexCoordHandle;
    public int adenMatrixHandle;
    public int adenPositionHandle;
    public int adenProgram;
    public int adenSourceImageHandle;
    public int amaroFilterSizeHandle;
    public int amaroInputImage2Handle;
    public int amaroInputImage3Handle;
    public int amaroInputImage4Handle;
    public int amaroInputTexCoordHandle;
    public int amaroMatrixHandle;
    public int amaroPositionHandle;
    public int amaroProgram;
    public int amaroSourceImageHandle;
    private BlurProgram blurProgram;
    public int clarendonFilterSizeHandle;
    public int clarendonInputImage2Handle;
    public int clarendonInputImage3Handle;
    public int clarendonInputTexCoordHandle;
    public int clarendonMatrixHandle;
    public int clarendonPositionHandle;
    public int clarendonProgram;
    public int clarendonSourceImageHandle;
    private final Context context;
    public int cremaFilterSizeHandle;
    public int cremaInputImage2Handle;
    public int cremaInputTexCoordHandle;
    public int cremaMatrixHandle;
    public int cremaPositionHandle;
    public int cremaProgram;
    public int cremaSourceImageHandle;
    public int ginghamFilterSizeHandle;
    public int ginghamInputImage2Handle;
    public int ginghamInputImage3Handle;
    public int ginghamInputTexCoordHandle;
    public int ginghamMatrixHandle;
    public int ginghamPositionHandle;
    public int ginghamProgram;
    public int ginghamSourceImageHandle;
    public int hefeFilterSizeHandle;
    public int hefeInputImage2Handle;
    public int hefeInputImage3Handle;
    public int hefeInputTexCoordHandle;
    public int hefeMatrixHandle;
    public int hefePositionHandle;
    public int hefeProgram;
    public int hefeSourceImageHandle;
    public int hudsonFilterSizeHandle;
    public int hudsonInputImage2Handle;
    public int hudsonInputImage3Handle;
    public int hudsonInputImage4Handle;
    public int hudsonInputTexCoordHandle;
    public int hudsonMatrixHandle;
    public int hudsonPositionHandle;
    public int hudsonProgram;
    public int hudsonSourceImageHandle;
    public int inkWellFilterSizeHandle;
    public int inkWellInputImage2Handle;
    public int inkWellInputTexCoordHandle;
    public int inkWellPositionHandle;
    public int inkWellProgram;
    public int inkWellSourceImageHandle;
    public int inkwellMatrixHandle;
    private final boolean isBlur;
    private boolean isVideo;
    public int junoFilterSizeHandle;
    public int junoInputImage2Handle;
    public int junoInputTexCoordHandle;
    public int junoMatrixHandle;
    public int junoPositionHandle;
    public int junoProgram;
    public int junoSourceImageHandle;
    public int lofiFilterSizeHandle;
    public int lofiInputImage2Handle;
    public int lofiInputImage3Handle;
    public int lofiInputTexCoordHandle;
    public int lofiMatrixHandle;
    public int lofiPositionHandle;
    public int lofiProgram;
    public int lofiSourceImageHandle;
    public int mayfairFilterSizeHandle;
    public int mayfairInputImage2Handle;
    public int mayfairInputImage3Handle;
    public int mayfairInputImage4Handle;
    public int mayfairInputImage5Handle;
    public int mayfairInputTexCoordHandle;
    public int mayfairMatrixHandle;
    public int mayfairPositionHandle;
    public int mayfairProgram;
    public int mayfairSourceImageHandle;
    public int moonFilterSizeHandle;
    public int moonInputImage2Handle;
    public int moonInputImage3Handle;
    public int moonInputTexCoordHandle;
    public int moonMatrixHandle;
    public int moonPositionHandle;
    public int moonProgram;
    public int moonSourceImageHandle;
    public int nashvilleFilterSizeHandle;
    public int nashvilleInputImage2Handle;
    public int nashvilleInputTexCoordHandle;
    public int nashvilleMatrixHandle;
    public int nashvillePositionHandle;
    public int nashvilleProgram;
    public int nashvilleSourceImageHandle;
    public int normalInputTexCoordHandle;
    public int normalMatrixHandle;
    public int normalPositionHandle;
    public int normalProgram;
    public int normalSourceImageHandle;
    private final int orientation;
    private int renderBufferHeight;
    private int renderBufferWidth;
    private int[] renderFrameBuffer;
    public int riseFilterSizeHandle;
    public int riseInputImage2Handle;
    public int riseInputImage3Handle;
    public int riseInputImage4Handle;
    public int riseInputTexCoordHandle;
    public int riseMatrixHandle;
    public int risePositionHandle;
    public int riseProgram;
    public int riseSourceImageHandle;
    public int sierraFilterSizeHandle;
    public int sierraInputImage2Handle;
    public int sierraInputImage3Handle;
    public int sierraInputImage4Handle;
    public int sierraInputTexCoordHandle;
    public int sierraMatrixHandle;
    public int sierraPositionHandle;
    public int sierraProgram;
    public int sierraSourceImageHandle;
    private final FloatBuffer textureBuffer;
    public int valenciaFilterSizeHandle;
    public int valenciaInputImage2Handle;
    public int valenciaInputImage3Handle;
    public int valenciaInputTexCoordHandle;
    public int valenciaMatrixHandle;
    public int valenciaPositionHandle;
    public int valenciaProgram;
    public int valenciaSourceImageHandle;
    private final FloatBuffer vertexBuffer;
    private final FloatBuffer vertexInvertBuffer;
    public int willowFilterSizeHandle;
    public int willowInputImage2Handle;
    public int willowInputTexCoordHandle;
    public int willowMatrixHandle;
    public int willowPositionHandle;
    public int willowProgram;
    public int willowSourceImageHandle;
    public int xProIIFilterSizeHandle;
    public int xProIIInputImage2Handle;
    public int xProIIInputImage3Handle;
    public int xProIIInputTexCoordHandle;
    public int xProIIMatrixHandle;
    public int xProIIPositionHandle;
    public int xProIIProgram;
    public int xProIISourceImageHandle;
    public int filterId = 0;
    public float filterSize = 1.0f;
    public int[] amaroMapTexture = new int[1];
    public int[] riseMapTexture = new int[1];
    public int[] hudsonMapTexture = new int[2];
    public int[] valenciaMapTexture = new int[2];
    public int[] xProIIMapTexture = new int[1];
    public int[] sierraMapTexture = new int[2];
    private final int[] renderTexture = new int[2];
    public int[] lomoMapTexture = new int[1];
    public int[] edgeBurnMapTexture = new int[1];
    public int[] overlayMapTexture = new int[1];
    public int[] vignetteMapTexture = new int[1];
    public int[] blackboardMapTexture = new int[1];
    public int[] inkwellMapTexture = new int[1];
    public int[] nashvilleMapTexture = new int[1];
    public int[] junoMapTexture = new int[1];
    public int[] adenMapTexture = new int[1];
    public int[] cremaMapTexture = new int[1];
    public int[] mayfairMapTexture = new int[4];
    public int[] moonMapTexture = new int[2];
    public int[] ginghamMapTexture = new int[2];
    public int[] clarendonMapTexture = new int[1];
    private final int[] bitmapTextre = new int[1];
    public int[] hefeMapTexture = new int[2];

    public SSHThumbnailFilterShader(Context context, boolean z, int i, boolean z2) {
        this.context = context;
        this.orientation = i;
        this.isVideo = z;
        this.isBlur = z2;
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
        Log.e("loadShaderFailure", GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e("loadShaderFailure", "shader code:\n " + str);
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public boolean create() {
        String str;
        String str2;
        int iLoadShader;
        int[] iArr = new int[1];
        if (this.isBlur && !this.isVideo) {
            BlurProgram blurProgram = new BlurProgram(40.0f, 20.0f, false);
            this.blurProgram = blurProgram;
            if (!blurProgram.create()) {
                return false;
            }
        }
        boolean z = this.isVideo;
        String str3 = z ? "#extension GL_OES_EGL_image_external : require" : BuildConfig.FLAVOR;
        String str4 = z ? "samplerExternalOES" : "sampler2D";
        if (z) {
            int i = this.orientation;
            str = (i % 360 == 90 || i % 360 == 270) ? "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;vec2 tempTexCoord = vec2(videoMatrix * inputTexCoord).xy;texCoord = vec2(1.0 - tempTexCoord.x, tempTexCoord.y);}" : "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;vec2 tempTexCoord = vec2(videoMatrix * inputTexCoord).xy;texCoord = vec2(tempTexCoord.x,1.0 - tempTexCoord.y);}";
        } else {
            str = "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}";
        }
        Locale locale = Locale.US;
        int iLoadShader2 = loadShader(35632, String.format(locale, "%1$s\nvarying highp vec2 texCoord;uniform %2$s sourceImage;void main() {gl_FragColor = texture2D(sourceImage, texCoord);}", str3, str4));
        int iLoadShader3 = loadShader(35633, str);
        if (iLoadShader3 == 0 || iLoadShader2 == 0) {
            return false;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.normalProgram = iGlCreateProgram;
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader3);
        GLES20.glAttachShader(this.normalProgram, iLoadShader2);
        GLES20.glBindAttribLocation(this.normalProgram, 0, "position");
        GLES20.glBindAttribLocation(this.normalProgram, 1, "inputTexCoord");
        GLES20.glLinkProgram(this.normalProgram);
        GLES20.glGetProgramiv(this.normalProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(this.normalProgram);
            this.normalProgram = 0;
        } else {
            this.normalPositionHandle = GLES20.glGetAttribLocation(this.normalProgram, "position");
            this.normalInputTexCoordHandle = GLES20.glGetAttribLocation(this.normalProgram, "inputTexCoord");
            this.normalSourceImageHandle = GLES20.glGetUniformLocation(this.normalProgram, "sourceImage");
            if (this.isVideo) {
                this.normalMatrixHandle = GLES20.glGetUniformLocation(this.normalProgram, "videoMatrix");
            }
        }
        String str5 = this.isVideo ? "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = vec2(videoMatrix * inputTexCoord).xy;}" : "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}";
        int iLoadShader4 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform sampler2D inputImageTexture4;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec3 bbTexel = texture2D(inputImageTexture2, texCoord).rgb;texel = vec3(texture2D(inputImageTexture3, vec2(bbTexel.r, texel.r)).r,texture2D(inputImageTexture3, vec2(bbTexel.g, texel.g)).g,texture2D(inputImageTexture3, vec2(bbTexel.b, texel.b)).b);texel = vec3(texture2D(inputImageTexture4, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture4, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture4, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
        int iLoadShader5 = loadShader(35633, str5);
        if (iLoadShader5 == 0 || iLoadShader4 == 0) {
            return false;
        }
        int iGlCreateProgram2 = GLES20.glCreateProgram();
        this.amaroProgram = iGlCreateProgram2;
        GLES20.glAttachShader(iGlCreateProgram2, iLoadShader5);
        GLES20.glAttachShader(this.amaroProgram, iLoadShader4);
        GLES20.glBindAttribLocation(this.amaroProgram, 0, "position");
        GLES20.glBindAttribLocation(this.amaroProgram, 1, "inputTexCoord");
        GLES20.glLinkProgram(this.amaroProgram);
        GLES20.glGetProgramiv(this.amaroProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(this.amaroProgram);
            this.amaroProgram = 0;
        } else {
            this.amaroPositionHandle = GLES20.glGetAttribLocation(this.amaroProgram, "position");
            this.amaroInputTexCoordHandle = GLES20.glGetAttribLocation(this.amaroProgram, "inputTexCoord");
            this.amaroSourceImageHandle = GLES20.glGetUniformLocation(this.amaroProgram, "sourceImage");
            this.amaroInputImage2Handle = GLES20.glGetUniformLocation(this.amaroProgram, "inputImageTexture2");
            this.amaroInputImage3Handle = GLES20.glGetUniformLocation(this.amaroProgram, "inputImageTexture3");
            this.amaroInputImage4Handle = GLES20.glGetUniformLocation(this.amaroProgram, "inputImageTexture4");
            this.amaroFilterSizeHandle = GLES20.glGetUniformLocation(this.amaroProgram, "filterSize");
            if (this.isVideo) {
                this.amaroMatrixHandle = GLES20.glGetUniformLocation(this.amaroProgram, "videoMatrix");
            }
        }
        int iLoadShader6 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform sampler2D inputImageTexture4;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec3 bbTexel = texture2D(inputImageTexture2, texCoord).rgb;texel = vec3(texture2D(inputImageTexture3, vec2(bbTexel.r, texel.r)).r,texture2D(inputImageTexture3, vec2(bbTexel.g, texel.g)).g,texture2D(inputImageTexture3, vec2(bbTexel.b, texel.b)).b);texel = vec3(texture2D(inputImageTexture4, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture4, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture4, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
        int iLoadShader7 = loadShader(35633, str5);
        if (iLoadShader7 == 0 || iLoadShader6 == 0) {
            return false;
        }
        int iGlCreateProgram3 = GLES20.glCreateProgram();
        this.riseProgram = iGlCreateProgram3;
        GLES20.glAttachShader(iGlCreateProgram3, iLoadShader7);
        GLES20.glAttachShader(this.riseProgram, iLoadShader6);
        GLES20.glBindAttribLocation(this.riseProgram, 0, "position");
        GLES20.glBindAttribLocation(this.riseProgram, 1, "inputTexCoord");
        GLES20.glLinkProgram(this.riseProgram);
        GLES20.glGetProgramiv(this.riseProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(this.riseProgram);
            this.riseProgram = 0;
        } else {
            this.risePositionHandle = GLES20.glGetAttribLocation(this.riseProgram, "position");
            this.riseInputTexCoordHandle = GLES20.glGetAttribLocation(this.riseProgram, "inputTexCoord");
            this.riseSourceImageHandle = GLES20.glGetUniformLocation(this.riseProgram, "sourceImage");
            this.riseInputImage2Handle = GLES20.glGetUniformLocation(this.riseProgram, "inputImageTexture2");
            this.riseInputImage3Handle = GLES20.glGetUniformLocation(this.riseProgram, "inputImageTexture3");
            this.riseInputImage4Handle = GLES20.glGetUniformLocation(this.riseProgram, "inputImageTexture4");
            this.riseFilterSizeHandle = GLES20.glGetUniformLocation(this.riseProgram, "filterSize");
            if (this.isVideo) {
                str2 = "videoMatrix";
                this.riseMatrixHandle = GLES20.glGetUniformLocation(this.riseProgram, str2);
            }
            int iLoadShader8 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform sampler2D inputImageTexture4;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec3 bbTexel = texture2D(inputImageTexture2, texCoord).rgb;texel = vec3(texture2D(inputImageTexture3, vec2(bbTexel.r, texel.r)).r,texture2D(inputImageTexture3, vec2(bbTexel.g, texel.g)).g,texture2D(inputImageTexture3, vec2(bbTexel.b, texel.b)).b);texel = vec3(texture2D(inputImageTexture4, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture4, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture4, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
            iLoadShader = loadShader(35633, str5);
            if (iLoadShader == 0 && iLoadShader8 != 0) {
                int iGlCreateProgram4 = GLES20.glCreateProgram();
                this.hudsonProgram = iGlCreateProgram4;
                GLES20.glAttachShader(iGlCreateProgram4, iLoadShader);
                GLES20.glAttachShader(this.hudsonProgram, iLoadShader8);
                GLES20.glBindAttribLocation(this.hudsonProgram, 0, "position");
                GLES20.glBindAttribLocation(this.hudsonProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.hudsonProgram);
                GLES20.glGetProgramiv(this.hudsonProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.hudsonProgram);
                    this.hudsonProgram = 0;
                } else {
                    this.hudsonPositionHandle = GLES20.glGetAttribLocation(this.hudsonProgram, "position");
                    this.hudsonInputTexCoordHandle = GLES20.glGetAttribLocation(this.hudsonProgram, "inputTexCoord");
                    this.hudsonSourceImageHandle = GLES20.glGetUniformLocation(this.hudsonProgram, "sourceImage");
                    this.hudsonInputImage2Handle = GLES20.glGetUniformLocation(this.hudsonProgram, "inputImageTexture2");
                    this.hudsonInputImage3Handle = GLES20.glGetUniformLocation(this.hudsonProgram, "inputImageTexture3");
                    this.hudsonInputImage4Handle = GLES20.glGetUniformLocation(this.hudsonProgram, "inputImageTexture4");
                    this.hudsonFilterSizeHandle = GLES20.glGetUniformLocation(this.hudsonProgram, "filterSize");
                    if (this.isVideo) {
                        this.hudsonMatrixHandle = GLES20.glGetUniformLocation(this.hudsonProgram, str2);
                    }
                }
                int iLoadShader9 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform highp float filterSize;mat3 saturateMatrix = mat3(1.1402, -0.0598, -0.061,-0.1174, 1.0826, -0.1186,-0.0228, -0.0228, 1.1772);vec3 lumaCoeffs = vec3(.3, .59, .11);void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;texel = vec3(texture2D(inputImageTexture2, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture2, vec2(texel.g, .5)).g,texture2D(inputImageTexture2, vec2(texel.b, 0.83333)).b);texel = saturateMatrix * texel;float luma = dot(lumaCoeffs, texel);texel = vec3(texture2D(inputImageTexture3, vec2(luma, texel.r)).r,texture2D(inputImageTexture3, vec2(luma, texel.g)).g,texture2D(inputImageTexture3, vec2(luma, texel.b)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
                int iLoadShader10 = loadShader(35633, str5);
                if (iLoadShader10 == 0 || iLoadShader9 == 0) {
                    return false;
                }
                int iGlCreateProgram5 = GLES20.glCreateProgram();
                this.valenciaProgram = iGlCreateProgram5;
                GLES20.glAttachShader(iGlCreateProgram5, iLoadShader10);
                GLES20.glAttachShader(this.valenciaProgram, iLoadShader9);
                GLES20.glBindAttribLocation(this.valenciaProgram, 0, "position");
                GLES20.glBindAttribLocation(this.valenciaProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.valenciaProgram);
                GLES20.glGetProgramiv(this.valenciaProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.valenciaProgram);
                    this.valenciaProgram = 0;
                } else {
                    this.valenciaPositionHandle = GLES20.glGetAttribLocation(this.valenciaProgram, "position");
                    this.valenciaInputTexCoordHandle = GLES20.glGetAttribLocation(this.valenciaProgram, "inputTexCoord");
                    this.valenciaSourceImageHandle = GLES20.glGetUniformLocation(this.valenciaProgram, "sourceImage");
                    this.valenciaInputImage2Handle = GLES20.glGetUniformLocation(this.valenciaProgram, "inputImageTexture2");
                    this.valenciaInputImage3Handle = GLES20.glGetUniformLocation(this.valenciaProgram, "inputImageTexture3");
                    this.valenciaFilterSizeHandle = GLES20.glGetUniformLocation(this.valenciaProgram, "filterSize");
                    if (this.isVideo) {
                        this.valenciaMatrixHandle = GLES20.glGetUniformLocation(this.valenciaProgram, str2);
                    }
                }
                int iLoadShader11 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec2 tc = (2.0 * texCoord) - 1.0 ;float d = dot(tc, tc);texel = vec3(texture2D(inputImageTexture3, vec2(d, (texel.r))).r,texture2D(inputImageTexture3, vec2(d, (texel.g))).g,texture2D(inputImageTexture3, vec2(d, (texel.b))).b);texel = vec3(texture2D(inputImageTexture2, vec2(texel.r, 0.83333)).r,texture2D(inputImageTexture2, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture2, vec2(texel.b, 0.16666)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
                int iLoadShader12 = loadShader(35633, str5);
                if (iLoadShader12 == 0 || iLoadShader11 == 0) {
                    return false;
                }
                int iGlCreateProgram6 = GLES20.glCreateProgram();
                this.xProIIProgram = iGlCreateProgram6;
                GLES20.glAttachShader(iGlCreateProgram6, iLoadShader12);
                GLES20.glAttachShader(this.xProIIProgram, iLoadShader11);
                GLES20.glBindAttribLocation(this.xProIIProgram, 0, "position");
                GLES20.glBindAttribLocation(this.xProIIProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.xProIIProgram);
                GLES20.glGetProgramiv(this.xProIIProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.xProIIProgram);
                    this.xProIIProgram = 0;
                } else {
                    this.xProIIPositionHandle = GLES20.glGetAttribLocation(this.xProIIProgram, "position");
                    this.xProIIInputTexCoordHandle = GLES20.glGetAttribLocation(this.xProIIProgram, "inputTexCoord");
                    this.xProIISourceImageHandle = GLES20.glGetUniformLocation(this.xProIIProgram, "sourceImage");
                    this.xProIIInputImage2Handle = GLES20.glGetUniformLocation(this.xProIIProgram, "inputImageTexture2");
                    this.xProIIInputImage3Handle = GLES20.glGetUniformLocation(this.xProIIProgram, "inputImageTexture3");
                    this.xProIIFilterSizeHandle = GLES20.glGetUniformLocation(this.xProIIProgram, "filterSize");
                    if (this.isVideo) {
                        this.xProIIMatrixHandle = GLES20.glGetUniformLocation(this.xProIIProgram, str2);
                    }
                }
                int iLoadShader13 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform sampler2D inputImageTexture4;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec3 bbTexel = texture2D(inputImageTexture2, texCoord).rgb;texel = vec3(texture2D(inputImageTexture3, vec2(bbTexel.r, texel.r)).r,texture2D(inputImageTexture3, vec2(bbTexel.g, texel.g)).g,texture2D(inputImageTexture3, vec2(bbTexel.b, texel.b)).b);texel = vec3(texture2D(inputImageTexture4, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture4, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture4, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
                int iLoadShader14 = loadShader(35633, str5);
                if (iLoadShader14 == 0 || iLoadShader13 == 0) {
                    return false;
                }
                int iGlCreateProgram7 = GLES20.glCreateProgram();
                this.sierraProgram = iGlCreateProgram7;
                GLES20.glAttachShader(iGlCreateProgram7, iLoadShader14);
                GLES20.glAttachShader(this.sierraProgram, iLoadShader13);
                GLES20.glBindAttribLocation(this.sierraProgram, 0, "position");
                GLES20.glBindAttribLocation(this.sierraProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.sierraProgram);
                GLES20.glGetProgramiv(this.sierraProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.sierraProgram);
                    this.sierraProgram = 0;
                } else {
                    this.sierraPositionHandle = GLES20.glGetAttribLocation(this.sierraProgram, "position");
                    this.sierraInputTexCoordHandle = GLES20.glGetAttribLocation(this.sierraProgram, "inputTexCoord");
                    this.sierraSourceImageHandle = GLES20.glGetUniformLocation(this.sierraProgram, "sourceImage");
                    this.sierraInputImage2Handle = GLES20.glGetUniformLocation(this.sierraProgram, "inputImageTexture2");
                    this.sierraInputImage3Handle = GLES20.glGetUniformLocation(this.sierraProgram, "inputImageTexture3");
                    this.sierraInputImage4Handle = GLES20.glGetUniformLocation(this.sierraProgram, "inputImageTexture4");
                    this.sierraFilterSizeHandle = GLES20.glGetUniformLocation(this.sierraProgram, "filterSize");
                    if (this.isVideo) {
                        this.sierraMatrixHandle = GLES20.glGetUniformLocation(this.sierraProgram, str2);
                    }
                }
                int iLoadShader15 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;texel = vec3(texture2D(inputImageTexture2, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture2, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture2, vec2(texel.b, 0.83333)).b);vec2 tc = (2.0 * texCoord) - 1.0;float d = dot(tc, tc);texel = vec3(texture2D(inputImageTexture3, vec2(d, (texel.r))).r,texture2D(inputImageTexture3, vec2(d, (texel.g))).g,texture2D(inputImageTexture3, vec2(d, (texel.b))).b);gl_FragColor = mix(original, vec4(texel,1.0), filterSize);}", str3, str4));
                int iLoadShader16 = loadShader(35633, str5);
                if (iLoadShader16 == 0 || iLoadShader15 == 0) {
                    return false;
                }
                int iGlCreateProgram8 = GLES20.glCreateProgram();
                this.lofiProgram = iGlCreateProgram8;
                GLES20.glAttachShader(iGlCreateProgram8, iLoadShader16);
                GLES20.glAttachShader(this.lofiProgram, iLoadShader15);
                GLES20.glBindAttribLocation(this.lofiProgram, 0, "position");
                GLES20.glBindAttribLocation(this.lofiProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.lofiProgram);
                GLES20.glGetProgramiv(this.lofiProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.lofiProgram);
                    this.lofiProgram = 0;
                } else {
                    this.lofiPositionHandle = GLES20.glGetAttribLocation(this.lofiProgram, "position");
                    this.lofiInputTexCoordHandle = GLES20.glGetAttribLocation(this.lofiProgram, "inputTexCoord");
                    this.lofiSourceImageHandle = GLES20.glGetUniformLocation(this.lofiProgram, "sourceImage");
                    this.lofiInputImage2Handle = GLES20.glGetUniformLocation(this.lofiProgram, "inputImageTexture2");
                    this.lofiInputImage3Handle = GLES20.glGetUniformLocation(this.lofiProgram, "inputImageTexture3");
                    this.lofiFilterSizeHandle = GLES20.glGetUniformLocation(this.lofiProgram, "filterSize");
                    if (this.isVideo) {
                        this.lofiMatrixHandle = GLES20.glGetUniformLocation(this.lofiProgram, str2);
                    }
                }
                int iLoadShader17 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec3 edge = texture2D(inputImageTexture2, texCoord).rgb;texel = texel * edge;texel = vec3(texture2D(inputImageTexture3, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture3, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture3, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original, vec4(texel, 1.0), filterSize);}", str3, str4));
                int iLoadShader18 = loadShader(35633, str5);
                if (iLoadShader18 == 0 || iLoadShader17 == 0) {
                    return false;
                }
                int iGlCreateProgram9 = GLES20.glCreateProgram();
                this.hefeProgram = iGlCreateProgram9;
                GLES20.glAttachShader(iGlCreateProgram9, iLoadShader18);
                GLES20.glAttachShader(this.hefeProgram, iLoadShader17);
                GLES20.glBindAttribLocation(this.hefeProgram, 0, "position");
                GLES20.glBindAttribLocation(this.hefeProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.hefeProgram);
                GLES20.glGetProgramiv(this.hefeProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.hefeProgram);
                    this.hefeProgram = 0;
                } else {
                    this.hefePositionHandle = GLES20.glGetAttribLocation(this.hefeProgram, "position");
                    this.hefeInputTexCoordHandle = GLES20.glGetAttribLocation(this.hefeProgram, "inputTexCoord");
                    this.hefeSourceImageHandle = GLES20.glGetUniformLocation(this.hefeProgram, "sourceImage");
                    this.hefeInputImage2Handle = GLES20.glGetUniformLocation(this.hefeProgram, "inputImageTexture2");
                    this.hefeInputImage3Handle = GLES20.glGetUniformLocation(this.hefeProgram, "inputImageTexture3");
                    this.hefeFilterSizeHandle = GLES20.glGetUniformLocation(this.hefeProgram, "filterSize");
                    if (this.isVideo) {
                        this.hefeMatrixHandle = GLES20.glGetUniformLocation(this.hefeProgram, str2);
                    }
                }
                int iLoadShader19 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;texel = vec3(dot(vec3(0.3, 0.6, 0.1), texel));texel = vec3(texture2D(inputImageTexture2, vec2(texel.r,0.8333)).b);gl_FragColor = mix(original,vec4(texel,1.0), filterSize);}", str3, str4));
                int iLoadShader20 = loadShader(35633, str5);
                if (iLoadShader20 == 0 || iLoadShader19 == 0) {
                    return false;
                }
                int iGlCreateProgram10 = GLES20.glCreateProgram();
                this.inkWellProgram = iGlCreateProgram10;
                GLES20.glAttachShader(iGlCreateProgram10, iLoadShader20);
                GLES20.glAttachShader(this.inkWellProgram, iLoadShader19);
                GLES20.glBindAttribLocation(this.inkWellProgram, 0, "position");
                GLES20.glBindAttribLocation(this.inkWellProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.inkWellProgram);
                GLES20.glGetProgramiv(this.inkWellProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.inkWellProgram);
                    this.inkWellProgram = 0;
                } else {
                    this.inkWellPositionHandle = GLES20.glGetAttribLocation(this.inkWellProgram, "position");
                    this.inkWellInputTexCoordHandle = GLES20.glGetAttribLocation(this.inkWellProgram, "inputTexCoord");
                    this.inkWellSourceImageHandle = GLES20.glGetUniformLocation(this.inkWellProgram, "sourceImage");
                    this.inkWellInputImage2Handle = GLES20.glGetUniformLocation(this.inkWellProgram, "inputImageTexture2");
                    this.inkWellFilterSizeHandle = GLES20.glGetUniformLocation(this.inkWellProgram, "filterSize");
                    if (this.isVideo) {
                        this.inkwellMatrixHandle = GLES20.glGetUniformLocation(this.inkWellProgram, str2);
                    }
                }
                int iLoadShader21 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;texel= vec3(texture2D(inputImageTexture2, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture2, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture2, vec2(texel.b, 0.83333)).b);texel = vec3(dot(vec3(0.3, 0.6, 0.1), texel));gl_FragColor = mix(original,vec4(texel,1.0), filterSize);}", str3, str4));
                int iLoadShader22 = loadShader(35633, str5);
                if (iLoadShader22 == 0 || iLoadShader21 == 0) {
                    return false;
                }
                int iGlCreateProgram11 = GLES20.glCreateProgram();
                this.willowProgram = iGlCreateProgram11;
                GLES20.glAttachShader(iGlCreateProgram11, iLoadShader22);
                GLES20.glAttachShader(this.willowProgram, iLoadShader21);
                GLES20.glBindAttribLocation(this.willowProgram, 0, "position");
                GLES20.glBindAttribLocation(this.willowProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.willowProgram);
                GLES20.glGetProgramiv(this.willowProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.willowProgram);
                    this.willowProgram = 0;
                } else {
                    this.willowPositionHandle = GLES20.glGetAttribLocation(this.willowProgram, "position");
                    this.willowInputTexCoordHandle = GLES20.glGetAttribLocation(this.willowProgram, "inputTexCoord");
                    this.willowSourceImageHandle = GLES20.glGetUniformLocation(this.willowProgram, "sourceImage");
                    this.willowInputImage2Handle = GLES20.glGetUniformLocation(this.willowProgram, "inputImageTexture2");
                    this.willowFilterSizeHandle = GLES20.glGetUniformLocation(this.willowProgram, "filterSize");
                    if (this.isVideo) {
                        this.willowMatrixHandle = GLES20.glGetUniformLocation(this.willowProgram, str2);
                    }
                }
                int iLoadShader23 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;\nvarying highp vec2 texCoord;\nuniform %2$s sourceImage;\nuniform sampler2D inputImageTexture2;\nuniform highp float filterSize;\n\nvec4 ig_texture3D(sampler2D tex, vec3 texCoordRgb, float size) {\n    float sliceSize = 1.0 / size;\n    float slicePixelSize = sliceSize / size;\n    float sliceInnerSize = slicePixelSize * (size - 1.0);\n    float xOffset = 0.5 * sliceSize + texCoordRgb.x * (1.0 - sliceSize);\n    float yOffset = 0.5 * slicePixelSize + texCoordRgb.y * sliceInnerSize;\n    float zOffset = texCoordRgb.z * (size - 1.0);\n    float zSlice0 = floor(zOffset);\n    float zSlice1 = zSlice0 + 1.0;\n    float s0 = yOffset + (zSlice0 * sliceSize);\n    float s1 = yOffset + (zSlice1 * sliceSize);\n    vec4 slice0Color = texture2D(tex, vec2(xOffset, s0));\n    vec4 slice1Color = texture2D(tex, vec2(xOffset, s1));\n    return mix(slice0Color, slice1Color, zOffset - zSlice0);\n}\n\nvoid main() { \n    vec4 texel = texture2D(sourceImage, texCoord);\n    vec4 inputTexel = texel;\n    texel.rgb = ig_texture3D(inputImageTexture2, texel.rgb, 33.0).rgb;\n    texel.rgb = mix(inputTexel.rgb, texel.rgb, filterSize);\n    gl_FragColor = texel;\n}", str3, str4));
                int iLoadShader24 = loadShader(35633, str5);
                if (iLoadShader24 == 0 || iLoadShader23 == 0) {
                    return false;
                }
                int iGlCreateProgram12 = GLES20.glCreateProgram();
                this.junoProgram = iGlCreateProgram12;
                GLES20.glAttachShader(iGlCreateProgram12, iLoadShader24);
                GLES20.glAttachShader(this.junoProgram, iLoadShader23);
                GLES20.glBindAttribLocation(this.junoProgram, 0, "position");
                GLES20.glBindAttribLocation(this.junoProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.junoProgram);
                GLES20.glGetProgramiv(this.junoProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.junoProgram);
                    this.junoProgram = 0;
                } else {
                    this.junoPositionHandle = GLES20.glGetAttribLocation(this.junoProgram, "position");
                    this.junoInputTexCoordHandle = GLES20.glGetAttribLocation(this.junoProgram, "inputTexCoord");
                    this.junoSourceImageHandle = GLES20.glGetUniformLocation(this.junoProgram, "sourceImage");
                    this.junoInputImage2Handle = GLES20.glGetUniformLocation(this.junoProgram, "inputImageTexture2");
                    this.junoFilterSizeHandle = GLES20.glGetUniformLocation(this.junoProgram, "filterSize");
                    if (this.isVideo) {
                        this.junoMatrixHandle = GLES20.glGetUniformLocation(this.junoProgram, str2);
                    }
                }
                int iLoadShader25 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform highp float filterSize;vec4 ig_texture3D(sampler2D tex, vec3 texCoordRgb, float size) {    float sliceSize = 1.0 / size;    float slicePixelSize = sliceSize / size;    float sliceInnerSize = slicePixelSize * (size - 1.0);    float xOffset = 0.5 * sliceSize + texCoordRgb.x * (1.0 - sliceSize);    float yOffset = 0.5 * slicePixelSize + texCoordRgb.y * sliceInnerSize;    float zOffset = texCoordRgb.z * (size - 1.0);    float zSlice0 = floor(zOffset);    float zSlice1 = zSlice0 + 1.0;    float s0 = yOffset + (zSlice0 * sliceSize);    float s1 = yOffset + (zSlice1 * sliceSize);    vec4 slice0Color = texture2D(tex, vec2(xOffset, s0));    vec4 slice1Color = texture2D(tex, vec2(xOffset, s1));    return mix(slice0Color, slice1Color, zOffset - zSlice0);}void main() {     vec4 texel = texture2D(sourceImage, texCoord);    vec4 inputTexel = texel;    texel.rgb = ig_texture3D(inputImageTexture2, texel.rgb, 33.0).rgb;    texel.rgb = mix(inputTexel.rgb, texel.rgb, filterSize);    gl_FragColor = texel;}", str3, str4));
                int iLoadShader26 = loadShader(35633, str5);
                if (iLoadShader26 == 0 || iLoadShader25 == 0) {
                    return false;
                }
                int iGlCreateProgram13 = GLES20.glCreateProgram();
                this.adenProgram = iGlCreateProgram13;
                GLES20.glAttachShader(iGlCreateProgram13, iLoadShader26);
                GLES20.glAttachShader(this.adenProgram, iLoadShader25);
                GLES20.glBindAttribLocation(this.adenProgram, 0, "position");
                GLES20.glBindAttribLocation(this.adenProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.adenProgram);
                GLES20.glGetProgramiv(this.adenProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.adenProgram);
                    this.adenProgram = 0;
                } else {
                    this.adenPositionHandle = GLES20.glGetAttribLocation(this.adenProgram, "position");
                    this.adenInputTexCoordHandle = GLES20.glGetAttribLocation(this.adenProgram, "inputTexCoord");
                    this.adenSourceImageHandle = GLES20.glGetUniformLocation(this.adenProgram, "sourceImage");
                    this.adenInputImage2Handle = GLES20.glGetUniformLocation(this.adenProgram, "inputImageTexture2");
                    this.adenFilterSizeHandle = GLES20.glGetUniformLocation(this.adenProgram, "filterSize");
                    if (this.isVideo) {
                        this.adenMatrixHandle = GLES20.glGetUniformLocation(this.adenProgram, str2);
                    }
                }
                int iLoadShader27 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;\nvarying highp vec2 texCoord;\nuniform %2$s sourceImage; \nuniform sampler2D inputImageTexture2;\nuniform highp float filterSize;\n\nvec4 ig_texture3D(sampler2D tex, vec3 texCoordRgb, float size) {    float sliceSize = 1.0 / size;\n    float slicePixelSize = sliceSize / size;\n    float sliceInnerSize = slicePixelSize * (size - 1.0);\n    float xOffset = 0.5 * sliceSize + texCoordRgb.x * (1.0 - sliceSize);\n    float yOffset = 0.5 * slicePixelSize + texCoordRgb.y * sliceInnerSize;\n    float zOffset = texCoordRgb.z * (size - 1.0);\n    float zSlice0 = floor(zOffset);\n    float zSlice1 = zSlice0 + 1.0;\n    float s0 = yOffset + (zSlice0 * sliceSize);\n    float s1 = yOffset + (zSlice1 * sliceSize);\n    vec4 slice0Color = texture2D(tex, vec2(xOffset, s0));\n    vec4 slice1Color = texture2D(tex, vec2(xOffset, s1));\n    return mix(slice0Color, slice1Color, zOffset - zSlice0);}\nvoid main() { \n    vec4 texel = texture2D(sourceImage, texCoord);\n    vec4 inputTexel = texel;\n    texel.rgb = ig_texture3D(inputImageTexture2, texel.rgb, 33.0).rgb;\n    texel.rgb = mix(inputTexel.rgb, texel.rgb, filterSize);\n    gl_FragColor = texel;\n}", str3, str4));
                int iLoadShader28 = loadShader(35633, str5);
                if (iLoadShader28 == 0 || iLoadShader27 == 0) {
                    return false;
                }
                int iGlCreateProgram14 = GLES20.glCreateProgram();
                this.cremaProgram = iGlCreateProgram14;
                GLES20.glAttachShader(iGlCreateProgram14, iLoadShader28);
                GLES20.glAttachShader(this.cremaProgram, iLoadShader27);
                GLES20.glBindAttribLocation(this.cremaProgram, 0, "position");
                GLES20.glBindAttribLocation(this.cremaProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.cremaProgram);
                GLES20.glGetProgramiv(this.cremaProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.cremaProgram);
                    this.cremaProgram = 0;
                } else {
                    this.cremaPositionHandle = GLES20.glGetAttribLocation(this.cremaProgram, "position");
                    this.cremaInputTexCoordHandle = GLES20.glGetAttribLocation(this.cremaProgram, "inputTexCoord");
                    this.cremaSourceImageHandle = GLES20.glGetUniformLocation(this.cremaProgram, "sourceImage");
                    this.cremaInputImage2Handle = GLES20.glGetUniformLocation(this.cremaProgram, "inputImageTexture2");
                    this.cremaFilterSizeHandle = GLES20.glGetUniformLocation(this.cremaProgram, "filterSize");
                    if (this.isVideo) {
                        this.cremaMatrixHandle = GLES20.glGetUniformLocation(this.cremaProgram, str2);
                    }
                }
                int iLoadShader29 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;\nvarying highp vec2 texCoord;\nuniform highp float filterSize;\nuniform %2$s sourceImage;\nuniform sampler2D colorOverlay; \nuniform sampler2D inputImageTexture2;\nuniform sampler2D glowField;\nuniform sampler2D overlay;\nvoid main() {\n    vec4 texel = texture2D(sourceImage, texCoord);\n    vec4 inputTexel = texel;\n    float luma = dot(texel.rgb, vec3(0.2125, 0.7154, 0.0721));\n    texel.rgb = mix(vec3(luma), texel.rgb, 1.2);\n    vec2 lookup;\n    lookup.y = .5;\n    lookup.x = texel.r;\n    texel.r = texture2D(inputImageTexture2, lookup).r;\n    lookup.x = texel.g;\n    texel.g = texture2D(inputImageTexture2, lookup).g;\n    lookup.x = texel.b;\n    texel.b = texture2D(inputImageTexture2, lookup).b;\n    vec3 glowFieldTexel = texture2D(glowField, texCoord).rgb;\n    texel.rgb = vec3(\n        texture2D(overlay, vec2(glowFieldTexel.r, texel.r)).r,        texture2D(overlay, vec2(glowFieldTexel.g, texel.g)).g,        texture2D(overlay, vec2(glowFieldTexel.b, texel.b)).b    );\n    lookup.x = texel.r;\n    texel.r = texture2D(colorOverlay, lookup).r;\n    lookup.x = texel.g;\n    texel.g = texture2D(colorOverlay, lookup).g;\n    lookup.x = texel.b;\n    texel.b = texture2D(colorOverlay, lookup).b;\n    texel.rgb = mix(inputTexel.rgb, texel.rgb, filterSize);\n    gl_FragColor = texel;\n}", str3, str4));
                int iLoadShader30 = loadShader(35633, str5);
                if (iLoadShader30 == 0 || iLoadShader29 == 0) {
                    return false;
                }
                int iGlCreateProgram15 = GLES20.glCreateProgram();
                this.mayfairProgram = iGlCreateProgram15;
                GLES20.glAttachShader(iGlCreateProgram15, iLoadShader30);
                GLES20.glAttachShader(this.mayfairProgram, iLoadShader29);
                GLES20.glBindAttribLocation(this.mayfairProgram, 0, "position");
                GLES20.glBindAttribLocation(this.mayfairProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.mayfairProgram);
                GLES20.glGetProgramiv(this.mayfairProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.mayfairProgram);
                    this.mayfairProgram = 0;
                } else {
                    this.mayfairPositionHandle = GLES20.glGetAttribLocation(this.mayfairProgram, "position");
                    this.mayfairInputTexCoordHandle = GLES20.glGetAttribLocation(this.mayfairProgram, "inputTexCoord");
                    this.mayfairSourceImageHandle = GLES20.glGetUniformLocation(this.mayfairProgram, "sourceImage");
                    this.mayfairInputImage2Handle = GLES20.glGetUniformLocation(this.mayfairProgram, "inputImageTexture2");
                    this.mayfairInputImage3Handle = GLES20.glGetUniformLocation(this.mayfairProgram, "colorOverlay");
                    this.mayfairInputImage4Handle = GLES20.glGetUniformLocation(this.mayfairProgram, "glowField");
                    this.mayfairInputImage5Handle = GLES20.glGetUniformLocation(this.mayfairProgram, "overlay");
                    this.mayfairFilterSizeHandle = GLES20.glGetUniformLocation(this.mayfairProgram, "filterSize");
                    if (this.isVideo) {
                        this.mayfairMatrixHandle = GLES20.glGetUniformLocation(this.mayfairProgram, str2);
                    }
                }
                int iLoadShader31 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;\nvarying highp vec2 texCoord;\nuniform highp float filterSize;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform %2$s sourceImage;\n\nvoid main() {\n    vec4 texel = texture2D(sourceImage, texCoord);\n    vec4 inputTexel = texel;\n    texel.r = texture2D(inputImageTexture2, vec2(texel.r, 0.5)).r;\n    texel.g = texture2D(inputImageTexture2, vec2(texel.g, 0.5)).g;\n    texel.b = texture2D(inputImageTexture2, vec2(texel.b, 0.5)).b;\n    vec3 desat = vec3(dot(vec3(0.7, 0.2, 0.1), texel.rgb));\n    texel.rgb = mix(texel.rgb, desat, 0.79);\n    texel.rgb = vec3(min(1.0, 1.2 * dot(vec3(0.2, 0.7, 0.1), texel.rgb)));\n    texel.r = texture2D(inputImageTexture3, vec2(texel.r, 0.5)).r;\n    texel.g = texture2D(inputImageTexture3, vec2(texel.g, 0.5)).g;\n    texel.b = texture2D(inputImageTexture3, vec2(texel.b, 0.5)).b;\n    texel.rgb = mix(inputTexel.rgb, texel.rgb, filterSize);\n    gl_FragColor = texel;\n}", str3, str4));
                int iLoadShader32 = loadShader(35633, str5);
                if (iLoadShader32 == 0 || iLoadShader31 == 0) {
                    return false;
                }
                int iGlCreateProgram16 = GLES20.glCreateProgram();
                this.moonProgram = iGlCreateProgram16;
                GLES20.glAttachShader(iGlCreateProgram16, iLoadShader32);
                GLES20.glAttachShader(this.moonProgram, iLoadShader31);
                GLES20.glBindAttribLocation(this.moonProgram, 0, "position");
                GLES20.glBindAttribLocation(this.moonProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.moonProgram);
                GLES20.glGetProgramiv(this.moonProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.moonProgram);
                    this.moonProgram = 0;
                } else {
                    this.moonPositionHandle = GLES20.glGetAttribLocation(this.moonProgram, "position");
                    this.moonInputTexCoordHandle = GLES20.glGetAttribLocation(this.moonProgram, "inputTexCoord");
                    this.moonSourceImageHandle = GLES20.glGetUniformLocation(this.moonProgram, "sourceImage");
                    this.moonInputImage2Handle = GLES20.glGetUniformLocation(this.moonProgram, "inputImageTexture2");
                    this.moonInputImage3Handle = GLES20.glGetUniformLocation(this.moonProgram, "inputImageTexture3");
                    this.moonFilterSizeHandle = GLES20.glGetUniformLocation(this.moonProgram, "filterSize");
                    if (this.isVideo) {
                        this.moonMatrixHandle = GLES20.glGetUniformLocation(this.moonProgram, str2);
                    }
                }
                int iLoadShader33 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;varying highp vec2 textureCoordinate;uniform highp float filterSize;\nuniform %2$s sourceImage;\nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3;\n\nvoid main() { \n    vec4 texel = texture2D(sourceImage, texCoord);\n    vec4 inputTexel = texel;\n    // exposure adjust B'=B*2^(EV/2.2), EV = 0.4                \n    texel.rgb = min(texel.rgb * 1.1343, vec3(1.0));\n    // apply curves                     \n    texel.r = texture2D(inputImageTexture2, vec2(texel.r, 0.5)).r;                     \n    texel.g = texture2D(inputImageTexture2, vec2(texel.g, 0.5)).g;                    \n    texel.b = texture2D(inputImageTexture2, vec2(texel.b, 0.5)).b;\n    // color effects on shadows:\\n                     \n    vec3 shadowColor = vec3(0.956862, 0.0, 0.83529);                    \n    float luma = dot(vec3(0.309, 0.609, 0.082), texel.rgb);                  \n    vec3 shadowBlend = 2.0 * shadowColor * texel.rgb;                  \n    float shadowAmount = 0.6 * max(0.0, (1.0 - 4.0 * luma));                    \n    texel.rgb = mix(texel.rgb, shadowBlend, shadowAmount);                     \n    // apply map for lift-gamma-gain + ranged saturation                    \n    // by applying less lgg (desaturating) to shadows                     \n    vec3 lgg;                     \n    lgg.r = texture2D(inputImageTexture3, vec2(texel.r, 0.5)).r;                    \n    lgg.g = texture2D(inputImageTexture3, vec2(texel.g, 0.5)).g;                     \n    lgg.b = texture2D(inputImageTexture3, vec2(texel.b, 0.5)).b;                    \n    texel.rgb = mix(texel.rgb, lgg, min(1.0, 0.8 + luma));\n    texel.rgb = mix(inputTexel.rgb, texel.rgb, filterSize);\n    gl_FragColor = texel;\n}", str3, str4));
                int iLoadShader34 = loadShader(35633, str5);
                if (iLoadShader34 == 0 || iLoadShader33 == 0) {
                    return false;
                }
                int iGlCreateProgram17 = GLES20.glCreateProgram();
                this.ginghamProgram = iGlCreateProgram17;
                GLES20.glAttachShader(iGlCreateProgram17, iLoadShader34);
                GLES20.glAttachShader(this.ginghamProgram, iLoadShader33);
                GLES20.glBindAttribLocation(this.ginghamProgram, 0, "position");
                GLES20.glBindAttribLocation(this.ginghamProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.ginghamProgram);
                GLES20.glGetProgramiv(this.ginghamProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.ginghamProgram);
                    this.ginghamProgram = 0;
                } else {
                    this.ginghamPositionHandle = GLES20.glGetAttribLocation(this.ginghamProgram, "position");
                    this.ginghamInputTexCoordHandle = GLES20.glGetAttribLocation(this.ginghamProgram, "inputTexCoord");
                    this.ginghamSourceImageHandle = GLES20.glGetUniformLocation(this.ginghamProgram, "sourceImage");
                    this.ginghamInputImage2Handle = GLES20.glGetUniformLocation(this.ginghamProgram, "inputImageTexture2");
                    this.ginghamInputImage3Handle = GLES20.glGetUniformLocation(this.ginghamProgram, "inputImageTexture3");
                    this.ginghamFilterSizeHandle = GLES20.glGetUniformLocation(this.ginghamProgram, "filterSize");
                    if (this.isVideo) {
                        this.ginghamMatrixHandle = GLES20.glGetUniformLocation(this.ginghamProgram, str2);
                    }
                }
                int iLoadShader35 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;texel = vec3(texture2D(inputImageTexture2, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture2, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture2, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original,vec4(texel,1.0), filterSize);}", str3, str4));
                int iLoadShader36 = loadShader(35633, str5);
                if (iLoadShader36 == 0 || iLoadShader35 == 0) {
                    return false;
                }
                int iGlCreateProgram18 = GLES20.glCreateProgram();
                this.nashvilleProgram = iGlCreateProgram18;
                GLES20.glAttachShader(iGlCreateProgram18, iLoadShader36);
                GLES20.glAttachShader(this.nashvilleProgram, iLoadShader35);
                GLES20.glBindAttribLocation(this.nashvilleProgram, 0, "position");
                GLES20.glBindAttribLocation(this.nashvilleProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.nashvilleProgram);
                GLES20.glGetProgramiv(this.nashvilleProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.nashvilleProgram);
                    this.nashvilleProgram = 0;
                    return true;
                }
                this.nashvillePositionHandle = GLES20.glGetAttribLocation(this.nashvilleProgram, "position");
                this.nashvilleInputTexCoordHandle = GLES20.glGetAttribLocation(this.nashvilleProgram, "inputTexCoord");
                this.nashvilleSourceImageHandle = GLES20.glGetUniformLocation(this.nashvilleProgram, "sourceImage");
                this.nashvilleInputImage2Handle = GLES20.glGetUniformLocation(this.nashvilleProgram, "inputImageTexture2");
                this.nashvilleFilterSizeHandle = GLES20.glGetUniformLocation(this.nashvilleProgram, "filterSize");
                if (!this.isVideo) {
                    return true;
                }
                this.nashvilleMatrixHandle = GLES20.glGetUniformLocation(this.nashvilleProgram, str2);
                return true;
            }
        }
        str2 = "videoMatrix";
        int iLoadShader82 = loadShader(35632, String.format(locale, "%1$s\nprecision highp float;varying highp vec2 texCoord;uniform %2$s sourceImage;uniform sampler2D inputImageTexture2;uniform sampler2D inputImageTexture3;uniform sampler2D inputImageTexture4;uniform highp float filterSize;void main () {vec4 original = texture2D(sourceImage, texCoord);vec3 texel = texture2D(sourceImage, texCoord).rgb;vec3 bbTexel = texture2D(inputImageTexture2, texCoord).rgb;texel = vec3(texture2D(inputImageTexture3, vec2(bbTexel.r, texel.r)).r,texture2D(inputImageTexture3, vec2(bbTexel.g, texel.g)).g,texture2D(inputImageTexture3, vec2(bbTexel.b, texel.b)).b);texel = vec3(texture2D(inputImageTexture4, vec2(texel.r, 0.16666)).r,texture2D(inputImageTexture4, vec2(texel.g, 0.5)).g,texture2D(inputImageTexture4, vec2(texel.b, 0.83333)).b);gl_FragColor = mix(original,vec4(texel, 1.0), filterSize);}", str3, str4));
        iLoadShader = loadShader(35633, str5);
        return iLoadShader == 0 ? false : false;
    }

    public void setRenderData(Bitmap bitmap, int i, int i2, int i3) throws IOException {
        loadTexture(bitmap, i, i2, i3);
        loadFiltersTextures(this.context);
    }

    public void useFiltersProgram() {
        int i = this.filterId;
        if (i != 33) {
            switch (i) {
                case 0:
                    GLES20.glUseProgram(this.normalProgram);
                    GLES20.glUniform1i(this.normalSourceImageHandle, 0);
                    GLES20.glEnableVertexAttribArray(this.normalInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.normalInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.normalPositionHandle);
                    GLES20.glVertexAttribPointer(this.normalPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
                    break;
                case 1:
                    GLES20.glUseProgram(this.amaroProgram);
                    GLES20.glUniform1i(this.amaroSourceImageHandle, 0);
                    GLES20.glUniform1i(this.amaroInputImage2Handle, 1);
                    GLES20.glUniform1i(this.amaroInputImage3Handle, 2);
                    GLES20.glUniform1i(this.amaroInputImage4Handle, 3);
                    GLES20.glEnableVertexAttribArray(this.amaroInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.amaroInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.amaroPositionHandle);
                    GLES20.glVertexAttribPointer(this.amaroPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 2:
                    GLES20.glUseProgram(this.riseProgram);
                    GLES20.glUniform1i(this.riseSourceImageHandle, 0);
                    GLES20.glUniform1i(this.riseInputImage2Handle, 1);
                    GLES20.glUniform1i(this.riseInputImage3Handle, 2);
                    GLES20.glUniform1i(this.riseInputImage4Handle, 3);
                    GLES20.glEnableVertexAttribArray(this.riseInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.riseInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.risePositionHandle);
                    GLES20.glVertexAttribPointer(this.risePositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 3:
                    GLES20.glUseProgram(this.hudsonProgram);
                    GLES20.glUniform1i(this.hudsonSourceImageHandle, 0);
                    GLES20.glUniform1i(this.hudsonInputImage2Handle, 1);
                    GLES20.glUniform1i(this.hudsonInputImage3Handle, 2);
                    GLES20.glUniform1i(this.hudsonInputImage4Handle, 3);
                    GLES20.glEnableVertexAttribArray(this.hudsonInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.hudsonInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.hudsonPositionHandle);
                    GLES20.glVertexAttribPointer(this.hudsonPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 4:
                    GLES20.glUseProgram(this.valenciaProgram);
                    GLES20.glUniform1i(this.valenciaSourceImageHandle, 0);
                    GLES20.glUniform1i(this.valenciaInputImage2Handle, 1);
                    GLES20.glUniform1i(this.valenciaInputImage3Handle, 2);
                    GLES20.glEnableVertexAttribArray(this.valenciaInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.valenciaInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.valenciaPositionHandle);
                    GLES20.glVertexAttribPointer(this.valenciaPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 5:
                    GLES20.glUseProgram(this.sierraProgram);
                    GLES20.glUniform1i(this.sierraSourceImageHandle, 0);
                    GLES20.glUniform1i(this.sierraInputImage2Handle, 1);
                    GLES20.glUniform1i(this.sierraInputImage3Handle, 2);
                    GLES20.glUniform1i(this.sierraInputImage4Handle, 3);
                    GLES20.glEnableVertexAttribArray(this.sierraInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.sierraInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.sierraPositionHandle);
                    GLES20.glVertexAttribPointer(this.sierraPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 6:
                    GLES20.glUseProgram(this.xProIIProgram);
                    GLES20.glUniform1i(this.xProIISourceImageHandle, 0);
                    GLES20.glUniform1i(this.xProIIInputImage2Handle, 1);
                    GLES20.glUniform1i(this.xProIIInputImage3Handle, 2);
                    GLES20.glEnableVertexAttribArray(this.xProIIInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.xProIIInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.xProIIPositionHandle);
                    GLES20.glVertexAttribPointer(this.xProIIPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 7:
                    GLES20.glUseProgram(this.willowProgram);
                    GLES20.glUniform1i(this.willowSourceImageHandle, 0);
                    GLES20.glUniform1i(this.willowInputImage2Handle, 1);
                    GLES20.glEnableVertexAttribArray(this.willowInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.willowInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.willowPositionHandle);
                    GLES20.glVertexAttribPointer(this.willowPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 8:
                    GLES20.glUseProgram(this.lofiProgram);
                    GLES20.glUniform1i(this.lofiSourceImageHandle, 0);
                    GLES20.glUniform1i(this.lofiInputImage2Handle, 1);
                    GLES20.glUniform1i(this.lofiInputImage3Handle, 2);
                    GLES20.glEnableVertexAttribArray(this.lofiInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.lofiInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.lofiPositionHandle);
                    GLES20.glVertexAttribPointer(this.lofiPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 9:
                    GLES20.glUseProgram(this.inkWellProgram);
                    GLES20.glUniform1i(this.inkWellSourceImageHandle, 0);
                    GLES20.glUniform1i(this.inkWellInputImage2Handle, 1);
                    GLES20.glEnableVertexAttribArray(this.inkWellInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.inkWellInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.inkWellPositionHandle);
                    GLES20.glVertexAttribPointer(this.inkWellPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 10:
                    GLES20.glUseProgram(this.hefeProgram);
                    GLES20.glUniform1i(this.hefeSourceImageHandle, 0);
                    GLES20.glUniform1i(this.hefeInputImage2Handle, 1);
                    GLES20.glUniform1i(this.hefeInputImage3Handle, 2);
                    GLES20.glEnableVertexAttribArray(this.hefeInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.hefeInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.hefePositionHandle);
                    GLES20.glVertexAttribPointer(this.hefePositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 11:
                    GLES20.glUseProgram(this.junoProgram);
                    GLES20.glUniform1i(this.junoSourceImageHandle, 0);
                    GLES20.glUniform1i(this.junoInputImage2Handle, 1);
                    GLES20.glEnableVertexAttribArray(this.junoInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.junoInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.junoPositionHandle);
                    GLES20.glVertexAttribPointer(this.junoPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 12:
                    GLES20.glUseProgram(this.adenProgram);
                    GLES20.glUniform1i(this.adenSourceImageHandle, 0);
                    GLES20.glUniform1i(this.adenInputImage2Handle, 1);
                    GLES20.glEnableVertexAttribArray(this.adenInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.adenInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.adenPositionHandle);
                    GLES20.glVertexAttribPointer(this.adenPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 13:
                    GLES20.glUseProgram(this.cremaProgram);
                    GLES20.glUniform1i(this.cremaSourceImageHandle, 0);
                    GLES20.glUniform1i(this.cremaInputImage2Handle, 1);
                    GLES20.glEnableVertexAttribArray(this.cremaInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.cremaInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.cremaPositionHandle);
                    GLES20.glVertexAttribPointer(this.cremaPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 14:
                    GLES20.glUseProgram(this.mayfairProgram);
                    GLES20.glUniform1i(this.mayfairSourceImageHandle, 0);
                    GLES20.glUniform1i(this.mayfairInputImage2Handle, 1);
                    GLES20.glUniform1i(this.mayfairInputImage3Handle, 2);
                    GLES20.glUniform1i(this.mayfairInputImage4Handle, 3);
                    GLES20.glUniform1i(this.mayfairInputImage5Handle, 4);
                    GLES20.glEnableVertexAttribArray(this.mayfairInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.mayfairInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.mayfairPositionHandle);
                    GLES20.glVertexAttribPointer(this.mayfairPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 15:
                    GLES20.glUseProgram(this.moonProgram);
                    GLES20.glUniform1i(this.moonSourceImageHandle, 0);
                    GLES20.glUniform1i(this.moonInputImage2Handle, 1);
                    GLES20.glUniform1i(this.moonInputImage3Handle, 2);
                    GLES20.glEnableVertexAttribArray(this.moonInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.moonInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.moonPositionHandle);
                    GLES20.glVertexAttribPointer(this.moonPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 16:
                    GLES20.glUseProgram(this.ginghamProgram);
                    GLES20.glUniform1i(this.ginghamSourceImageHandle, 0);
                    GLES20.glUniform1i(this.ginghamInputImage2Handle, 1);
                    GLES20.glUniform1i(this.ginghamInputImage3Handle, 2);
                    GLES20.glEnableVertexAttribArray(this.ginghamInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.ginghamInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.ginghamPositionHandle);
                    GLES20.glVertexAttribPointer(this.ginghamPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
                case 17:
                    GLES20.glUseProgram(this.nashvilleProgram);
                    GLES20.glUniform1i(this.nashvilleSourceImageHandle, 0);
                    GLES20.glUniform1i(this.nashvilleInputImage2Handle, 1);
                    GLES20.glEnableVertexAttribArray(this.nashvilleInputTexCoordHandle);
                    GLES20.glVertexAttribPointer(this.nashvilleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.nashvillePositionHandle);
                    GLES20.glVertexAttribPointer(this.nashvillePositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
                    break;
            }
        }
        GLES20.glUseProgram(this.clarendonProgram);
        GLES20.glUniform1i(this.clarendonSourceImageHandle, 0);
        GLES20.glUniform1i(this.clarendonInputImage2Handle, 1);
        GLES20.glUniform1i(this.clarendonInputImage3Handle, 2);
        GLES20.glEnableVertexAttribArray(this.clarendonInputTexCoordHandle);
        GLES20.glVertexAttribPointer(this.clarendonInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(this.clarendonPositionHandle);
        GLES20.glVertexAttribPointer(this.clarendonPositionHandle, 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexBuffer : this.vertexInvertBuffer));
    }

    public boolean drawBlurPass(int i, int i2, int i3, int i4) {
        GLES20.glUseProgram(this.blurProgram.blurShaderProgram);
        GLES20.glUniform1i(this.blurProgram.blurSourceImageHandle, 0);
        GLES20.glEnableVertexAttribArray(this.blurProgram.blurInputTexCoordHandle);
        GLES20.glVertexAttribPointer(this.blurProgram.blurInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(this.blurProgram.blurPositionHandle);
        GLES20.glVertexAttribPointer(this.blurProgram.blurPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexInvertBuffer);
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i4);
        GLES20.glUniform1f(this.blurProgram.blurWidthHandle, 0.0f);
        GLES20.glUniform1f(this.blurProgram.blurHeightHandle, 1.0f / this.renderBufferHeight);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1f(this.blurProgram.blurWidthHandle, 1.0f / this.renderBufferWidth);
        GLES20.glUniform1f(this.blurProgram.blurHeightHandle, 0.0f);
        GLES20.glDrawArrays(5, 0, 4);
        return true;
    }

    public void drawFilters(int i, int i2, int i3, float[] fArr) {
        useFiltersProgram();
        int i4 = this.filterId;
        if (i4 != 33) {
            switch (i4) {
                case 0:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.normalMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 1:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.blackboardMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.overlayMapTexture[0]);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.amaroMapTexture[0]);
                    GLES20.glUniform1f(this.amaroFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.amaroMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 2:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.blackboardMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.overlayMapTexture[0]);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.riseMapTexture[0]);
                    GLES20.glUniform1f(this.riseFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.riseMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 3:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.hudsonMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.overlayMapTexture[0]);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.hudsonMapTexture[1]);
                    GLES20.glUniform1f(this.hudsonFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.hudsonMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 4:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.valenciaMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.valenciaMapTexture[1]);
                    GLES20.glUniform1f(this.valenciaFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.valenciaMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 5:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.sierraMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.overlayMapTexture[0]);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.sierraMapTexture[1]);
                    GLES20.glUniform1f(this.sierraFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.sierraMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 6:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.xProIIMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.vignetteMapTexture[0]);
                    GLES20.glUniform1f(this.xProIIFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.xProIIMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 7:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.sierraMapTexture[1]);
                    GLES20.glUniform1f(this.willowFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.willowMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 8:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.lomoMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.vignetteMapTexture[0]);
                    GLES20.glUniform1f(this.lofiFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.lofiMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 9:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.inkwellMapTexture[0]);
                    GLES20.glUniform1f(this.inkWellFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.inkwellMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 10:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.edgeBurnMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.hefeMapTexture[0]);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.hefeMapTexture[1]);
                    GLES20.glUniform1f(this.hefeFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.hefeMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 11:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.junoMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.junoMapTexture[0]);
                    GLES20.glUniform1f(this.junoFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.junoMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 12:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.adenMapTexture[0]);
                    GLES20.glUniform1f(this.adenFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.adenMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 13:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.cremaMapTexture[0]);
                    GLES20.glUniform1f(this.cremaFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.cremaMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 14:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.mayfairMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.mayfairMapTexture[1]);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.mayfairMapTexture[2]);
                    GLES20.glActiveTexture(33988);
                    GLES20.glBindTexture(3553, this.mayfairMapTexture[3]);
                    GLES20.glUniform1f(this.mayfairFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.mayfairMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 15:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.moonMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.moonMapTexture[1]);
                    GLES20.glUniform1f(this.moonFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.moonMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 16:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.ginghamMapTexture[0]);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(3553, this.ginghamMapTexture[1]);
                    GLES20.glUniform1f(this.ginghamFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.ginghamMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
                case 17:
                    GLES20.glBindFramebuffer(36160, i);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i3);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.nashvilleMapTexture[0]);
                    GLES20.glUniform1f(this.nashvilleFilterSizeHandle, this.filterSize);
                    if (this.isVideo) {
                        GLES20.glUniformMatrix4fv(this.nashvilleMatrixHandle, 1, false, fArr, 0);
                        break;
                    }
                    break;
            }
        } else {
            GLES20.glBindFramebuffer(36160, i);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i3);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.valenciaMapTexture[0]);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.clarendonMapTexture[0]);
            GLES20.glUniform1f(this.clarendonFilterSizeHandle, this.filterSize);
            if (this.isVideo) {
                GLES20.glUniformMatrix4fv(this.clarendonMatrixHandle, 1, false, fArr, 0);
            }
        }
        GLES20.glDrawArrays(5, 0, 4);
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
            int[] iArr = new int[2];
            this.renderFrameBuffer = iArr;
            GLES20.glGenFramebuffers(2, iArr, 0);
            GLES20.glGenTextures(2, this.renderTexture, 0);
        }
        if (bitmapCreateBitmap != null && !bitmap.isRecycled()) {
            GLES20.glGenTextures(1, this.bitmapTextre, 0);
            int i4 = this.renderBufferWidth;
            if (i4 > 1280.0f || this.renderBufferHeight > 1280.0f || i % 360 != 0) {
                float width = 1.0f;
                if (i4 > 1280.0f || this.renderBufferHeight > 1280.0f) {
                    width = 1280.0f / bitmap.getWidth();
                    float height = 1280.0f / bitmap.getHeight();
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
            GLES20.glBindTexture(3553, this.bitmapTextre[0]);
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

    private static Bitmap getImageFromAssetsFile(Context context, String str) throws IOException {
        Bitmap bitmapDecodeStream = null;
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    public void loadFiltersTextures(Context context) throws IOException {
        Bitmap imageFromAssetsFile = getImageFromAssetsFile(context, "filtersMap/inkwellMap.png");
        GLES20.glGenTextures(1, this.inkwellMapTexture, 0);
        GLES20.glBindTexture(3553, this.inkwellMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile, 0);
        imageFromAssetsFile.recycle();
        Bitmap imageFromAssetsFile2 = getImageFromAssetsFile(context, "filtersMap/xproMap.png");
        GLES20.glGenTextures(1, this.xProIIMapTexture, 0);
        GLES20.glBindTexture(3553, this.xProIIMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile2, 0);
        imageFromAssetsFile2.recycle();
        Bitmap imageFromAssetsFile3 = getImageFromAssetsFile(context, "filtersMap/amaroMap.png");
        GLES20.glGenTextures(1, this.amaroMapTexture, 0);
        GLES20.glBindTexture(3553, this.amaroMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile3, 0);
        imageFromAssetsFile3.recycle();
        Bitmap imageFromAssetsFile4 = getImageFromAssetsFile(context, "filtersMap/riseMap.png");
        GLES20.glGenTextures(1, this.riseMapTexture, 0);
        GLES20.glBindTexture(3553, this.riseMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile4, 0);
        imageFromAssetsFile4.recycle();
        Bitmap imageFromAssetsFile5 = getImageFromAssetsFile(context, "filtersMap/hudsonBackgroundMap.png");
        GLES20.glGenTextures(2, this.hudsonMapTexture, 0);
        GLES20.glBindTexture(3553, this.hudsonMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile5, 0);
        Bitmap imageFromAssetsFile6 = getImageFromAssetsFile(context, "filtersMap/hudsonMap.png");
        GLES20.glBindTexture(3553, this.hudsonMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile6, 0);
        imageFromAssetsFile5.recycle();
        imageFromAssetsFile6.recycle();
        Bitmap imageFromAssetsFile7 = getImageFromAssetsFile(context, "filtersMap/sierraVignetteMap.png");
        GLES20.glGenTextures(2, this.sierraMapTexture, 0);
        GLES20.glBindTexture(3553, this.sierraMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile7, 0);
        Bitmap imageFromAssetsFile8 = getImageFromAssetsFile(context, "filtersMap/sierraMap.png");
        GLES20.glBindTexture(3553, this.sierraMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile8, 0);
        imageFromAssetsFile7.recycle();
        imageFromAssetsFile8.recycle();
        Bitmap imageFromAssetsFile9 = getImageFromAssetsFile(context, "filtersMap/valenciaMap.png");
        GLES20.glGenTextures(2, this.valenciaMapTexture, 0);
        GLES20.glBindTexture(3553, this.valenciaMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile9, 0);
        Bitmap imageFromAssetsFile10 = getImageFromAssetsFile(context, "filtersMap/valenciaGradientMap.png");
        GLES20.glBindTexture(3553, this.valenciaMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile10, 0);
        imageFromAssetsFile9.recycle();
        imageFromAssetsFile10.recycle();
        Bitmap imageFromAssetsFile11 = getImageFromAssetsFile(context, "filtersMap/hefeMap.png");
        GLES20.glGenTextures(2, this.hefeMapTexture, 0);
        GLES20.glBindTexture(3553, this.hefeMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile11, 0);
        Bitmap imageFromAssetsFile12 = getImageFromAssetsFile(context, "filtersMap/hefeGradientMap.png");
        GLES20.glBindTexture(3553, this.hefeMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile12, 0);
        imageFromAssetsFile11.recycle();
        imageFromAssetsFile12.recycle();
        Bitmap imageFromAssetsFile13 = getImageFromAssetsFile(context, "filtersMap/lomoMap.png");
        GLES20.glGenTextures(1, this.lomoMapTexture, 0);
        GLES20.glBindTexture(3553, this.lomoMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile13, 0);
        imageFromAssetsFile13.recycle();
        Bitmap imageFromAssetsFile14 = getImageFromAssetsFile(context, "filtersMap/vignetteMap.png");
        GLES20.glGenTextures(1, this.vignetteMapTexture, 0);
        GLES20.glBindTexture(3553, this.vignetteMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile14, 0);
        imageFromAssetsFile14.recycle();
        Bitmap imageFromAssetsFile15 = getImageFromAssetsFile(context, "filtersMap/overlayMap.png");
        GLES20.glGenTextures(1, this.overlayMapTexture, 0);
        GLES20.glBindTexture(3553, this.overlayMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile15, 0);
        imageFromAssetsFile15.recycle();
        Bitmap imageFromAssetsFile16 = getImageFromAssetsFile(context, "filtersMap/edgeBurnMap.png");
        GLES20.glGenTextures(1, this.edgeBurnMapTexture, 0);
        GLES20.glBindTexture(3553, this.edgeBurnMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile16, 0);
        imageFromAssetsFile16.recycle();
        Bitmap imageFromAssetsFile17 = getImageFromAssetsFile(context, "filtersMap/blackboard1024Map.png");
        GLES20.glGenTextures(1, this.blackboardMapTexture, 0);
        GLES20.glBindTexture(3553, this.blackboardMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile17, 0);
        imageFromAssetsFile17.recycle();
        Bitmap imageFromAssetsFile18 = getImageFromAssetsFile(context, "filtersMap/junoMap.png");
        GLES20.glGenTextures(1, this.junoMapTexture, 0);
        GLES20.glBindTexture(3553, this.junoMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile18, 0);
        imageFromAssetsFile18.recycle();
        Bitmap imageFromAssetsFile19 = getImageFromAssetsFile(context, "filtersMap/adenMap.png");
        GLES20.glGenTextures(1, this.adenMapTexture, 0);
        GLES20.glBindTexture(3553, this.adenMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile19, 0);
        imageFromAssetsFile19.recycle();
        Bitmap imageFromAssetsFile20 = getImageFromAssetsFile(context, "filtersMap/cremaMap.png");
        GLES20.glGenTextures(1, this.cremaMapTexture, 0);
        GLES20.glBindTexture(3553, this.cremaMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile20, 0);
        imageFromAssetsFile20.recycle();
        Bitmap imageFromAssetsFile21 = getImageFromAssetsFile(context, "filtersMap/mayfairMap.png");
        GLES20.glGenTextures(4, this.mayfairMapTexture, 0);
        GLES20.glBindTexture(3553, this.mayfairMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile21, 0);
        Bitmap imageFromAssetsFile22 = getImageFromAssetsFile(context, "filtersMap/mayfairColorOverlay.png");
        GLES20.glBindTexture(3553, this.mayfairMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile22, 0);
        Bitmap imageFromAssetsFile23 = getImageFromAssetsFile(context, "filtersMap/mayfairGlowField.png");
        GLES20.glBindTexture(3553, this.mayfairMapTexture[2]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile23, 0);
        Bitmap imageFromAssetsFile24 = getImageFromAssetsFile(context, "filtersMap/mayfairOverlay.png");
        GLES20.glBindTexture(3553, this.mayfairMapTexture[3]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile24, 0);
        imageFromAssetsFile21.recycle();
        imageFromAssetsFile22.recycle();
        imageFromAssetsFile23.recycle();
        imageFromAssetsFile24.recycle();
        Bitmap imageFromAssetsFile25 = getImageFromAssetsFile(context, "filtersMap/bw_vintage_curves1.png");
        GLES20.glGenTextures(2, this.moonMapTexture, 0);
        GLES20.glBindTexture(3553, this.moonMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile25, 0);
        Bitmap imageFromAssetsFile26 = getImageFromAssetsFile(context, "filtersMap/bw_vintage_curves2.png");
        GLES20.glBindTexture(3553, this.moonMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile26, 0);
        imageFromAssetsFile25.recycle();
        imageFromAssetsFile26.recycle();
        Bitmap imageFromAssetsFile27 = getImageFromAssetsFile(context, "filtersMap/vintage_signature_curves1.png");
        GLES20.glGenTextures(2, this.ginghamMapTexture, 0);
        GLES20.glBindTexture(3553, this.ginghamMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile27, 0);
        Bitmap imageFromAssetsFile28 = getImageFromAssetsFile(context, "filtersMap/vintage_signature_lgg_curves.png");
        GLES20.glBindTexture(3553, this.ginghamMapTexture[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile28, 0);
        imageFromAssetsFile27.recycle();
        imageFromAssetsFile28.recycle();
        Bitmap imageFromAssetsFile29 = getImageFromAssetsFile(context, "filtersMap/nashvilleMap.png");
        GLES20.glGenTextures(1, this.nashvilleMapTexture, 0);
        GLES20.glBindTexture(3553, this.nashvilleMapTexture[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, imageFromAssetsFile29, 0);
        imageFromAssetsFile29.recycle();
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

    public int getBitmapTexture() {
        return this.bitmapTextre[0];
    }

    public int getRenderBufferHeight() {
        return this.renderBufferHeight;
    }

    public int getRenderTexture(int i) {
        return this.renderTexture[i];
    }

    public int getRenderFrameBuffer(int i) {
        return this.renderFrameBuffer[i];
    }

    public int getRenderFrameBuffer() {
        int[] iArr = this.renderFrameBuffer;
        if (iArr != null) {
            return iArr[1];
        }
        return 0;
    }

    public void setFilterType(int i, float f) {
        this.filterId = i;
        this.filterSize = f;
    }

    private static class BlurProgram {
        public int blurHeightHandle;
        public int blurInputTexCoordHandle;
        public int blurPositionHandle;
        public int blurShaderProgram;
        public int blurSourceImageHandle;
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
            this.fragmentShaderCode = SSHThumbnailFilterShader.fragmentShaderForOptimizedBlurOfRadius(i, f2);
            this.vertexShaderCode = SSHThumbnailFilterShader.vertexShaderForOptimizedBlurOfRadius(i, f2);
        }

        public boolean create() {
            int iLoadShader = SSHThumbnailFilterShader.loadShader(35633, this.vertexShaderCode);
            int iLoadShader2 = SSHThumbnailFilterShader.loadShader(35632, this.fragmentShaderCode);
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
            }
            return true;
        }
    }
}
