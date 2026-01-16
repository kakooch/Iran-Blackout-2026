package ir.appp.rghapp.rubinoPostSlider;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.GLMediaRenderer;
import ir.appp.rghapp.GLSceneState;
import ir.appp.rghapp.ImageCaptureListener;
import ir.appp.rghapp.RGHFilter;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class FilterShaders {
    public static int screenHeight;
    public static int screenWidth;
    public int aTextureCoordLocation;
    public int backgroundDarkColor;
    public int backgroundLightColor;
    public String backgroundPath;
    public int backgroundTextureId;
    public int backgroundTextureLocation;
    private int[] bitmapTextre;
    public float brightness;
    public float contrast;
    public SimpleExoPlayer exoMediaPlayer;
    public int filterChangeDirection;
    public int filterId;
    public float[] glBackgroundDarkColor;
    public float[] glBackgroundLightColor;
    private boolean hsvGenerated;
    public ImageCaptureListener imageCaptureListener;
    public String imageMediaFilePath;
    public boolean isBackgroundGenerated;
    public boolean isSceneCreated;
    public boolean isSupportingNPOT;
    public boolean isUpdatingState;
    public boolean isVideo;
    public boolean mCaptureEnabled;
    public int maxScreenWidth;
    public float mediaAspectRatio;
    String mediaPath;
    public float mediaRotation;
    public int mediaTextureId;
    public int mediaTextureLocation;
    public float newFilterXPositionRatio;
    public float nextBrightness;
    public float nextContrast;
    public float nextSaturation;
    public float originalMediaRotation;
    private int refBackgroundDarkColor;
    private int refBackgroundLightColor;
    private int refBrightness;
    private int refContrast;
    private int refFilterChangeDirection;
    private int refFilterId;
    private int refHasRotation;
    private int refIsBackgroundGenerated;
    private int refNewFilterPos;
    private int refNextBrightness;
    private int refNextContrast;
    private int refNextSaturation;
    private int refRotationMatrix;
    private int refSaturation;
    private int refScaleMatrix;
    private int refTranslationMatrix;
    private int renderBufferHeight;
    private int renderBufferWidth;
    private int[] renderFrameBuffer;
    private int[] renderTexture;

    @Keep
    private float[] rotationMatrix;
    public float saturation;
    private float[] scaleMatrix;
    public float scaleX;
    public float scaleXOriginal;
    public float scaleY;
    public float scaleYOriginal;
    private int[] storyInputTexCoordHandle;
    private int storyMatrixHandle;
    private int[] storyPositionHandle;
    private int[] storyShaderProgram;
    private int[] storySourceImageHandle;
    public SurfaceTexture surfaceTexture;
    public float sxRatio;
    public float syRatio;
    private float[] tempRotationMatrix2;
    private FloatBuffer textureBuffer;
    public FloatBuffer textureVertexBuffer;
    public float translateXinGlCoordination;
    public float translateYinGlCoordination;
    private float[] translationMatrix;
    public boolean updateSurface;
    private FloatBuffer vertexBuffer;
    private FloatBuffer vertexInvertBuffer;
    private float[] videoMatrix;
    public long videoPlaybackEndTime;
    public long videoPlaybackStartTime;
    public Surface videoSurface;
    private int videoTexture;
    public float xPosCorrection;
    public float xPosInNormalCoordination;
    public float xPosInNormalCoordinationOriginal;
    public float yPosCorrection;
    public float yPosInNormalCoordination;
    public float yPosInNormalCoordinationOriginal;

    public FilterShaders(String str) {
        this.storyShaderProgram = new int[2];
        this.storyPositionHandle = new int[2];
        this.storyInputTexCoordHandle = new int[2];
        this.storySourceImageHandle = new int[2];
        this.renderTexture = new int[2];
        this.bitmapTextre = new int[1];
        this.rotationMatrix = new float[16];
        this.tempRotationMatrix2 = new float[16];
        this.scaleMatrix = new float[16];
        this.translationMatrix = new float[16];
        this.mediaRotation = 0.0f;
        this.originalMediaRotation = 0.0f;
        this.filterId = 0;
        this.scaleX = 0.0f;
        this.scaleY = 0.0f;
        this.scaleXOriginal = 0.0f;
        this.scaleYOriginal = 0.0f;
        this.sxRatio = 1.0f;
        this.syRatio = 1.0f;
        this.xPosInNormalCoordination = 0.0f;
        this.yPosInNormalCoordination = 0.0f;
        this.xPosInNormalCoordinationOriginal = 0.0f;
        this.yPosInNormalCoordinationOriginal = 0.0f;
        this.xPosCorrection = 0.0f;
        this.yPosCorrection = 0.0f;
        this.newFilterXPositionRatio = 0.0f;
        this.mediaAspectRatio = 1.0f;
        this.filterChangeDirection = 1;
        this.saturation = 1.0f;
        this.contrast = 1.0f;
        this.brightness = 0.0f;
        this.nextSaturation = 1.0f;
        this.nextContrast = 1.0f;
        this.nextBrightness = 0.0f;
        this.mCaptureEnabled = false;
        this.videoPlaybackStartTime = -1L;
        this.videoPlaybackEndTime = -1L;
        this.glBackgroundDarkColor = new float[]{0.384f, 0.384f, 0.384f};
        this.glBackgroundLightColor = new float[]{0.678f, 0.678f, 0.678f};
        this.isUpdatingState = false;
        this.isSceneCreated = false;
        this.isBackgroundGenerated = false;
        this.isSupportingNPOT = true;
        this.isVideo = true;
        this.mediaPath = str;
        initCoordinates();
    }

    public FilterShaders(String str, int i, int i2) {
        this.storyShaderProgram = new int[2];
        this.storyPositionHandle = new int[2];
        this.storyInputTexCoordHandle = new int[2];
        this.storySourceImageHandle = new int[2];
        this.renderTexture = new int[2];
        this.bitmapTextre = new int[1];
        this.rotationMatrix = new float[16];
        this.tempRotationMatrix2 = new float[16];
        this.scaleMatrix = new float[16];
        this.translationMatrix = new float[16];
        this.mediaRotation = 0.0f;
        this.originalMediaRotation = 0.0f;
        this.filterId = 0;
        this.scaleX = 0.0f;
        this.scaleY = 0.0f;
        this.scaleXOriginal = 0.0f;
        this.scaleYOriginal = 0.0f;
        this.sxRatio = 1.0f;
        this.syRatio = 1.0f;
        this.xPosInNormalCoordination = 0.0f;
        this.yPosInNormalCoordination = 0.0f;
        this.xPosInNormalCoordinationOriginal = 0.0f;
        this.yPosInNormalCoordinationOriginal = 0.0f;
        this.xPosCorrection = 0.0f;
        this.yPosCorrection = 0.0f;
        this.newFilterXPositionRatio = 0.0f;
        this.mediaAspectRatio = 1.0f;
        this.filterChangeDirection = 1;
        this.saturation = 1.0f;
        this.contrast = 1.0f;
        this.brightness = 0.0f;
        this.nextSaturation = 1.0f;
        this.nextContrast = 1.0f;
        this.nextBrightness = 0.0f;
        this.mCaptureEnabled = false;
        this.videoPlaybackStartTime = -1L;
        this.videoPlaybackEndTime = -1L;
        this.glBackgroundDarkColor = new float[]{0.384f, 0.384f, 0.384f};
        this.glBackgroundLightColor = new float[]{0.678f, 0.678f, 0.678f};
        this.isUpdatingState = false;
        this.isSceneCreated = false;
        this.isBackgroundGenerated = false;
        this.isSupportingNPOT = true;
        this.isVideo = false;
        this.mediaPath = str;
        this.renderBufferWidth = i;
        this.renderBufferHeight = i2;
        initCoordinates();
    }

    private void initCoordinates() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.vertexBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f});
        this.vertexBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        this.vertexInvertBuffer = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.vertexInvertBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer3;
        floatBufferAsFloatBuffer3.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        this.textureBuffer.position(0);
    }

    public boolean create() throws IllegalArgumentException {
        int iLoadShader;
        int iLoadShader2;
        int[] iArr = new int[1];
        if (this.isVideo) {
            int videoRotation = GLMediaRenderer.getVideoRotation(this.mediaPath);
            if (videoRotation != -1) {
                this.originalMediaRotation = videoRotation;
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        new MediaMetadataRetriever().setDataSource(this.mediaPath);
                        this.originalMediaRotation = Integer.parseInt(r2.extractMetadata(24));
                    } else {
                        this.originalMediaRotation = 0.0f;
                    }
                } catch (Exception unused) {
                }
            }
            this.imageMediaFilePath = BuildConfig.FLAVOR;
        } else {
            this.imageMediaFilePath = this.mediaPath;
        }
        if (this.originalMediaRotation == 270.0f) {
            this.originalMediaRotation = -90.0f;
        }
        int i = 0;
        while (true) {
            boolean z = this.isVideo;
            if (i >= (z ? 2 : 1)) {
                return true;
            }
            if (i == 1 && z) {
                iLoadShader = loadShader(35633, "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = vec2(inputTexCoord.x,inputTexCoord.y);}");
                iLoadShader2 = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 texCoord;\n\nuniform samplerExternalOES sourceImage;\n\nuniform vec3 iResolution;\nuniform int filterType;\nuniform float newFilterPos;\nuniform float saturationValue;\nuniform float contrastValue;\nuniform float brightnessValue;\nuniform float saturationValueN;\nuniform float contrastValueN;\nuniform float brightnessValueN;\nuniform int filterChangeDirection;\nuniform mat4 rotationMatrix;\nuniform int hasRotation;\nuniform int isBackgroundGenerated;\nuniform mat4 scaleMatrix;\nuniform mat4 translationMatrix;\nuniform vec3 backgroundDarkColor;\nuniform vec3 backgroundLightColor;\n\nmediump float normpdf(in float x, in float sigma)\n{\n    return 0.39894*exp(-0.5*x*x/(sigma*sigma))/sigma;\n}\n\nmediump float getLuma(mediump vec3 rgbP) {\n    return (0.299 * rgbP.r) + (0.587 * rgbP.g) + (0.114 * rgbP.b);\n}\n\nmediump vec3 rgbToYuv(mediump vec3 inP) {\n    mediump float luma = getLuma(inP);\n    return vec3(luma, (1.0 / 1.772) * (inP.b - luma), (1.0 / 1.402) * (inP.r - luma));\n}\n\nlowp vec3 yuvToRgb(mediump vec3 inP) {\n    return vec3(1.402 * inP.b + inP.r, (inP.r - (0.299 * 1.402 / 0.587) * inP.b - (0.114 * 1.772 / 0.587) * inP.g), 1.772 * inP.g + inP.r);\n}\n\nvoid applyBlackAndWhiteFilter(vec3 scene){\n    float avg = (scene.r + scene.g + scene.b) / 3.0;\n    gl_FragColor = vec4(avg,avg,avg,1.0);\n}\n\nvoid applySepiaFilter(vec3 scene){\n    float rr = .3;\n    float rg = .769;\n    float rb = .189;\n\n    float gr = .3;\n    float gg = .686;\n    float gb = .168;\n\n    float br = .272;\n    float bg = .534;\n    float bb = .131;\n\n    float red = (rr * scene.r) + (rb * scene.b) + (rg * scene.g);\n    float green = (gr * scene.r) + (gb * scene.b) + (gg * scene.g);\n    float blue = (br * scene.r) + (bb * scene.b) + (bg * scene.g);\n\n    gl_FragColor = vec4(red,green,blue, 1.0);\n}\n\nvoid applyPinkyFilter(vec3 scene){\n    float adjust = 0.1;\n    scene = vec3(scene.r + (scene.r * 0.233) + adjust,scene.g + (scene.g * 0.03) + adjust,scene.b + (scene.b * 0.1)+ adjust);\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyGreishFilter(vec3 scene){\n    float adjust = 0.05;\n    gl_FragColor = vec4(scene.r - adjust,scene.g + adjust,scene.b + adjust, 1.0);\n}\n\nvoid applyMenegolFilter(vec3 scene){\n    float exppower = 2.0;\n    scene.r = 1.0- pow((1.0 - scene.r), exppower);\n    scene.g = 1.0- pow((1.0 - scene.g), exppower);\n    scene.b = 1.0- pow((1.0 - scene.b), exppower);\n    mediump vec3 yuvColor = rgbToYuv(scene);\n    yuvColor.g = (yuvColor.g * 1.2);\n    yuvColor.b = (yuvColor.b * 1.2);\n    scene = yuvToRgb(yuvColor);\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyTokyoFilter(vec3 scene){\n    float avg = (scene.r + scene.g + scene.b) / 3.0;\n    vec3 temp = vec3(avg,avg,avg + 0.02);\n    mediump vec3 yuvColor = rgbToYuv(temp);\n    yuvColor.r *= 1.1;\n    scene = yuvToRgb(yuvColor);\n    scene = vec3((scene.rgb - vec3(0.5)) * 1.85 + vec3(0.5));\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyBuenosAiresFilter(vec3 scene){\n    scene.r -= 0.113;\n    scene.g -= 0.05;\n    scene.b += 0.03;\n    mediump vec3 yuvColor = rgbToYuv(scene);\n    yuvColor.r += 0.03;\n    scene = yuvToRgb(yuvColor);\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyFilterParam(vec3 scene,float cv,float sv,float bv){\n    mediump vec3 yuvColor = rgbToYuv(scene);\n    // contrast effects on Y parameter (luma) of frame or Red Channel value\n    yuvColor.r = (yuvColor.r * cv);\n    // saturation effects u,v parameters or G and B Channels\n    yuvColor.g = (yuvColor.g * sv);\n    yuvColor.b = (yuvColor.b * sv);\n    scene = yuvToRgb(yuvColor);\n    // change brighness equal to colorLevel Filter in FFMPEG\n    // -1 = pure dark, 1 = pure white, 0 = default\n    scene.rgb += bv;\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyBlurEffect(float sigma,vec3 scene){\n    const int mSize = 11;\n    const int kSize = (mSize-1)/2;\n    float kernel[mSize];\n    vec3 final_colour = vec3(0.0);\n    float Z = 0.0;\n    for (int j = 0; j <= kSize; ++j)\n    {\n        kernel[kSize+j] = kernel[kSize-j] = normpdf(float(j), sigma);\n    }\n\n    for (int j = 0; j < mSize; ++j)\n    {\n        Z += kernel[j];\n    }\n\n    for (int i=-kSize; i <= kSize; ++i)\n    {\n        for (int j=-kSize; j <= kSize; ++j)\n        {\n//            final_colour += kernel[kSize+j]*kernel[kSize+i]*texture2D(sourceImage, (texCoord.xy+vec2(float(i),float(j)))).rgb;\n            final_colour += kernel[kSize+j]*kernel[kSize+i]*(scene.xyz).rgb;\n        }\n    }\n\n    gl_FragColor = vec4(final_colour/(Z*Z), 1.0);\n}\n\nvoid main() {\n    vec3 background2D = mix(backgroundDarkColor,backgroundLightColor,texCoord.y);\n\n    vec3 newCoord = vec3(texCoord.xy,1.0);\n    newCoord = (scaleMatrix * vec4(newCoord.x - 0.5, newCoord.y - 0.5,0.0,0.0)).xyz + vec3(0.5, 0.5, 0.0);\n    newCoord = (translationMatrix*vec4(newCoord.x,newCoord.y,1.0,0.0)).xyz;\n    if (hasRotation == 1){\n        newCoord = (rotationMatrix*vec4(newCoord.x - 0.5, newCoord.y - 0.5,0.0,0.0)).xyz + vec3(0.5, 0.5, 0.0);\n    }\n\n    vec3 videoTexture = texture2D(sourceImage, vec2(newCoord.x,newCoord.y)).rgb;\n\n    // overlay video\n    if (all(greaterThan(newCoord.xy, vec2(0.0))) &&\n    all(lessThan(newCoord.xy, vec2(1.0))))\n    {\n        background2D = mix(background2D, videoTexture, 1.0);\n    }else if (isBackgroundGenerated == 0){\n        background2D.rgb = mix(backgroundDarkColor,backgroundLightColor,texCoord.y);\n    }\n\n    if (filterType == 0){\n        if (filterChangeDirection == 1) {\n            if (texCoord.x > 1.0 - newFilterPos){\n                // next\n                applyBlackAndWhiteFilter(background2D);\n            }else{\n                //current\n                gl_FragColor = vec4(background2D, 1.0);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                //current\n                gl_FragColor = vec4(background2D, 1.0);\n            }else{\n                //prev\n                applySepiaFilter(background2D);\n            }\n        }\n    }else if (filterType == 1){\n        if (filterChangeDirection == 1) {\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyGreishFilter(background2D);\n            } else {\n                applyBlackAndWhiteFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyBlackAndWhiteFilter(background2D);\n            } else {\n                gl_FragColor = vec4(background2D, 1.0);\n            }\n        }\n    }else if (filterType == 2){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }else{\n                applyGreishFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyGreishFilter(background2D);\n            }else{\n                applyBlackAndWhiteFilter(background2D);\n            }\n        }\n    }else if (filterType == 3){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            } else {\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }else{\n                applyGreishFilter(background2D);\n            }\n        }\n    }else if (filterType == 4 && filterChangeDirection == 1){\n        if (texCoord.x > 1.0 - newFilterPos){\n            applyBuenosAiresFilter(background2D);\n        }else{\n            applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n        }\n    }else if (filterType == 5) {\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyTokyoFilter(background2D);\n            }else{\n                applyBuenosAiresFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyBuenosAiresFilter(background2D);\n            }else{\n                applyFilterParam(background2D,contrastValueN,saturationValueN,brightnessValueN);\n            }\n        }\n    }else if (filterType == 6){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyMenegolFilter(background2D);\n            }else{\n                applyTokyoFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyTokyoFilter(background2D);\n            }else{\n                applyBuenosAiresFilter(background2D);\n            }\n        }\n    }else if (filterType == 7) {\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }else{\n                applyMenegolFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyMenegolFilter(background2D);\n            }else{\n                applyTokyoFilter(background2D);\n            }\n        }\n    }else if (filterType == 8) {\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyPinkyFilter(background2D);\n            }else{\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }else{\n                applyMenegolFilter(background2D);\n            }\n        }\n    }else if (filterType == 9){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applySepiaFilter(background2D);\n            }else{\n                applyPinkyFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyPinkyFilter(background2D);\n            }else{\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }\n        }\n    }\n    else if (filterType == 10){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }else{\n                applySepiaFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applySepiaFilter(background2D);\n            }else{\n                applyPinkyFilter(background2D);\n            }\n        }\n    }\n    else{\n        if (filterChangeDirection == 1) {\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            } else {\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            } else {\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }\n        }\n    }\n}");
            } else {
                iLoadShader = loadShader(35633, "attribute vec4 position;attribute vec4 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = vec2(inputTexCoord.x,1.0 - inputTexCoord.y);}");
                iLoadShader2 = loadShader(35632, "precision mediump float;\nvarying vec2 texCoord;\n\nuniform sampler2D sourceImage;\n\nuniform vec3 iResolution;\nuniform int filterType;\nuniform float newFilterPos;\nuniform float saturationValue;\nuniform float contrastValue;\nuniform float brightnessValue;\nuniform float saturationValueN;\nuniform float contrastValueN;\nuniform float brightnessValueN;\nuniform int filterChangeDirection;\nuniform mat4 rotationMatrix;\nuniform int hasRotation;\nuniform int isBackgroundGenerated;\nuniform mat4 scaleMatrix;\nuniform mat4 translationMatrix;\nuniform vec3 backgroundDarkColor;\nuniform vec3 backgroundLightColor;\n\nmediump float normpdf(in float x, in float sigma)\n{\n    return 0.39894*exp(-0.5*x*x/(sigma*sigma))/sigma;\n}\n\nmediump float getLuma(mediump vec3 rgbP) {\n    return (0.299 * rgbP.r) + (0.587 * rgbP.g) + (0.114 * rgbP.b);\n}\n\nmediump vec3 rgbToYuv(mediump vec3 inP) {\n    mediump float luma = getLuma(inP);\n    return vec3(luma, (1.0 / 1.772) * (inP.b - luma), (1.0 / 1.402) * (inP.r - luma));\n}\n\nlowp vec3 yuvToRgb(mediump vec3 inP) {\n    return vec3(1.402 * inP.b + inP.r, (inP.r - (0.299 * 1.402 / 0.587) * inP.b - (0.114 * 1.772 / 0.587) * inP.g), 1.772 * inP.g + inP.r);\n}\n\nvoid applyBlackAndWhiteFilter(vec3 scene){\n    float avg = (scene.r + scene.g + scene.b) / 3.0;\n    gl_FragColor = vec4(avg,avg,avg,1.0);\n}\n\nvoid applySepiaFilter(vec3 scene){\n    float rr = .3;\n    float rg = .769;\n    float rb = .189;\n\n    float gr = .3;\n    float gg = .686;\n    float gb = .168;\n\n    float br = .272;\n    float bg = .534;\n    float bb = .131;\n\n    float red = (rr * scene.r) + (rb * scene.b) + (rg * scene.g);\n    float green = (gr * scene.r) + (gb * scene.b) + (gg * scene.g);\n    float blue = (br * scene.r) + (bb * scene.b) + (bg * scene.g);\n\n    gl_FragColor = vec4(red,green,blue, 1.0);\n}\n\nvoid applyPinkyFilter(vec3 scene){\n    float adjust = 0.1;\n    scene = vec3(scene.r + (scene.r * 0.233) + adjust,scene.g + (scene.g * 0.03) + adjust,scene.b + (scene.b * 0.1)+ adjust);\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyGreishFilter(vec3 scene){\n    float adjust = 0.05;\n    gl_FragColor = vec4(scene.r - adjust,scene.g + adjust,scene.b + adjust, 1.0);\n}\n\nvoid applyMenegolFilter(vec3 scene){\n    float exppower = 2.0;\n    scene.r = 1.0- pow((1.0 - scene.r), exppower);\n    scene.g = 1.0- pow((1.0 - scene.g), exppower);\n    scene.b = 1.0- pow((1.0 - scene.b), exppower);\n    mediump vec3 yuvColor = rgbToYuv(scene);\n    yuvColor.g = (yuvColor.g * 1.2);\n    yuvColor.b = (yuvColor.b * 1.2);\n    scene = yuvToRgb(yuvColor);\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyTokyoFilter(vec3 scene){\n    float avg = (scene.r + scene.g + scene.b) / 3.0;\n    vec3 temp = vec3(avg,avg,avg + 0.02);\n    mediump vec3 yuvColor = rgbToYuv(temp);\n    yuvColor.r *= 1.1;\n    scene = yuvToRgb(yuvColor);\n    scene = vec3((scene.rgb - vec3(0.5)) * 1.85 + vec3(0.5));\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyBuenosAiresFilter(vec3 scene){\n    scene.r -= 0.113;\n    scene.g -= 0.05;\n    scene.b += 0.03;\n    mediump vec3 yuvColor = rgbToYuv(scene);\n    yuvColor.r += 0.03;\n    scene = yuvToRgb(yuvColor);\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyFilterParam(vec3 scene,float cv,float sv,float bv){\n    mediump vec3 yuvColor = rgbToYuv(scene);\n    // contrast effects on Y parameter (luma) of frame or Red Channel value\n    yuvColor.r = (yuvColor.r * cv);\n    // saturation effects u,v parameters or G and B Channels\n    yuvColor.g = (yuvColor.g * sv);\n    yuvColor.b = (yuvColor.b * sv);\n    scene = yuvToRgb(yuvColor);\n    // change brighness equal to colorLevel Filter in FFMPEG\n    // -1 = pure dark, 1 = pure white, 0 = default\n    scene.rgb += bv;\n    gl_FragColor = vec4(scene, 1.0);\n}\n\nvoid applyBlurEffect(float sigma,vec3 scene){\n    const int mSize = 11;\n    const int kSize = (mSize-1)/2;\n    float kernel[mSize];\n    vec3 final_colour = vec3(0.0);\n    float Z = 0.0;\n    for (int j = 0; j <= kSize; ++j)\n    {\n        kernel[kSize+j] = kernel[kSize-j] = normpdf(float(j), sigma);\n    }\n\n    for (int j = 0; j < mSize; ++j)\n    {\n        Z += kernel[j];\n    }\n\n    for (int i=-kSize; i <= kSize; ++i)\n    {\n        for (int j=-kSize; j <= kSize; ++j)\n        {\n//            final_colour += kernel[kSize+j]*kernel[kSize+i]*texture2D(sourceImage, (texCoord.xy+vec2(float(i),float(j)))).rgb;\n            final_colour += kernel[kSize+j]*kernel[kSize+i]*(scene.xyz).rgb;\n        }\n    }\n\n    gl_FragColor = vec4(final_colour/(Z*Z), 1.0);\n}\n\nvoid main() {\n    vec3 background2D = mix(backgroundDarkColor,backgroundLightColor,texCoord.y);\n\n    vec3 newCoord = vec3(texCoord.xy,1.0);\n    newCoord = (scaleMatrix * vec4(newCoord.x - 0.5, newCoord.y - 0.5,0.0,0.0)).xyz + vec3(0.5, 0.5, 0.0);\n    newCoord = (translationMatrix*vec4(newCoord.x,newCoord.y,1.0,0.0)).xyz;\n    if (hasRotation == 1){\n        newCoord = (rotationMatrix*vec4(newCoord.x - 0.5, newCoord.y - 0.5,0.0,0.0)).xyz + vec3(0.5, 0.5, 0.0);\n    }\n\n    vec3 imageTexture = texture2D(sourceImage, vec2(newCoord.x,newCoord.y)).rgb;\n\n    // overlay video\n    if (all(greaterThan(newCoord.xy, vec2(0.0))) &&\n    all(lessThan(newCoord.xy, vec2(1.0))))\n    {\n        background2D = mix(background2D, imageTexture, 1.0);\n    }else if (isBackgroundGenerated == 0){\n        background2D.rgb = mix(backgroundDarkColor,backgroundLightColor,texCoord.y);\n    }\n\n    if (filterType == 0){\n        if (filterChangeDirection == 1) {\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyBlackAndWhiteFilter(background2D);\n            }else{\n                gl_FragColor = vec4(background2D, 1.0);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                gl_FragColor = vec4(background2D, 1.0);\n            }else{\n                applySepiaFilter(background2D);\n            }\n        }\n    }else if (filterType == 1){\n        if (filterChangeDirection == 1) {\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyGreishFilter(background2D);\n            } else {\n                applyBlackAndWhiteFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyBlackAndWhiteFilter(background2D);\n            } else {\n                gl_FragColor = vec4(background2D, 1.0);\n            }\n        }\n    }else if (filterType == 2){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }else{\n                applyGreishFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyGreishFilter(background2D);\n            }else{\n                applyBlackAndWhiteFilter(background2D);\n            }\n        }\n    }else if (filterType == 3){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            } else {\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }else{\n                applyGreishFilter(background2D);\n            }\n        }\n    }else if (filterType == 4 && filterChangeDirection == 1){\n        if (texCoord.x > 1.0 - newFilterPos){\n            applyBuenosAiresFilter(background2D);\n        }else{\n            applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n        }\n    }else if (filterType == 5) {\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyTokyoFilter(background2D);\n            }else{\n                applyBuenosAiresFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyBuenosAiresFilter(background2D);\n            }else{\n                applyFilterParam(background2D,contrastValueN,saturationValueN,brightnessValueN);\n            }\n        }\n    }else if (filterType == 6){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyMenegolFilter(background2D);\n            }else{\n                applyTokyoFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyTokyoFilter(background2D);\n            }else{\n                applyBuenosAiresFilter(background2D);\n            }\n        }\n    }else if (filterType == 7) {\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }else{\n                applyMenegolFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyMenegolFilter(background2D);\n            }else{\n                applyTokyoFilter(background2D);\n            }\n        }\n    }else if (filterType == 8) {\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyPinkyFilter(background2D);\n            }else{\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }else{\n                applyMenegolFilter(background2D);\n            }\n        }\n    }else if (filterType == 9){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applySepiaFilter(background2D);\n            }else{\n                applyPinkyFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyPinkyFilter(background2D);\n            }else{\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }\n        }\n    }\n    else if (filterType == 10){\n        if (filterChangeDirection == 1){\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }else{\n                applySepiaFilter(background2D);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applySepiaFilter(background2D);\n            }else{\n                applyPinkyFilter(background2D);\n            }\n        }\n    }\n    else{\n        if (filterChangeDirection == 1) {\n            if (texCoord.x > 1.0 - newFilterPos){\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            } else {\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            }\n        }else{\n            if (texCoord.x > newFilterPos){\n                applyFilterParam(background2D, contrastValue, saturationValue, brightnessValue);\n            } else {\n                applyFilterParam(background2D, contrastValueN, saturationValueN, brightnessValueN);\n            }\n        }\n    }\n}");
            }
            if (iLoadShader == 0 || iLoadShader2 == 0) {
                break;
            }
            this.storyShaderProgram[i] = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.storyShaderProgram[i], iLoadShader);
            GLES20.glAttachShader(this.storyShaderProgram[i], iLoadShader2);
            GLES20.glBindAttribLocation(this.storyShaderProgram[i], 0, "position");
            GLES20.glBindAttribLocation(this.storyShaderProgram[i], 1, "inputTexCoord");
            GLES20.glLinkProgram(this.storyShaderProgram[i]);
            GLES20.glGetProgramiv(this.storyShaderProgram[i], 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(this.storyShaderProgram[i]);
                this.storyShaderProgram[i] = 0;
            } else {
                this.storyPositionHandle[i] = GLES20.glGetAttribLocation(this.storyShaderProgram[i], "position");
                this.storyInputTexCoordHandle[i] = GLES20.glGetAttribLocation(this.storyShaderProgram[i], "inputTexCoord");
                this.storySourceImageHandle[i] = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "sourceImage");
                this.refFilterId = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "filterType");
                this.refNewFilterPos = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "newFilterPos");
                this.refSaturation = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "saturationValue");
                this.refContrast = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "contrastValue");
                this.refBrightness = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "brightnessValue");
                this.refNextSaturation = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "saturationValueN");
                this.refNextContrast = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "contrastValueN");
                this.refNextBrightness = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "brightnessValueN");
                this.refFilterChangeDirection = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "filterChangeDirection");
                this.refRotationMatrix = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "rotationMatrix");
                this.refHasRotation = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "hasRotation");
                this.refScaleMatrix = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "scaleMatrix");
                this.refTranslationMatrix = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "translationMatrix");
                this.refIsBackgroundGenerated = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "isBackgroundGenerated");
                this.refBackgroundDarkColor = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "backgroundDarkColor");
                this.refBackgroundLightColor = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "backgroundLightColor");
                if (i == 1) {
                    this.storyMatrixHandle = GLES20.glGetUniformLocation(this.storyShaderProgram[i], "videoMatrix");
                }
            }
            i++;
        }
        return false;
    }

    public void setRenderData(Bitmap bitmap, int i, int i2, int i3, int i4) {
        setRenderData(bitmap, i, i2, i3, i4, false);
    }

    public void setRenderData(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        loadTexture(bitmap, i, i3, i4, z);
        this.videoTexture = i2;
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

    public void drawEnhancePass() {
        char c;
        SimpleExoPlayer simpleExoPlayer;
        boolean z = this.isVideo;
        if (z ? true : !this.hsvGenerated) {
            if (z) {
                GLES20.glUseProgram(this.storyShaderProgram[1]);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, this.videoTexture);
                GLES20.glUniformMatrix4fv(this.storyMatrixHandle, 1, false, this.videoMatrix, 0);
                c = 1;
            } else {
                GLES20.glUseProgram(this.storyShaderProgram[0]);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.bitmapTextre[0]);
                c = 0;
            }
            GLES20.glUniform1i(this.refFilterId, this.filterId);
            GLES20.glUniform1i(this.refFilterChangeDirection, this.filterChangeDirection);
            GLES20.glUniform1f(this.refNewFilterPos, this.newFilterXPositionRatio);
            GLES20.glUniform1f(this.refSaturation, this.saturation);
            GLES20.glUniform1f(this.refContrast, this.contrast);
            GLES20.glUniform1f(this.refBrightness, this.brightness);
            GLES20.glUniform1f(this.refNextSaturation, this.nextSaturation);
            GLES20.glUniform1f(this.refNextContrast, this.nextContrast);
            GLES20.glUniform1f(this.refNextBrightness, this.nextBrightness);
            GLES20.glUniform1i(this.refHasRotation, this.mediaRotation + this.originalMediaRotation != 0.0f ? 1 : 0);
            GLES20.glUniform1i(this.refIsBackgroundGenerated, this.isBackgroundGenerated ? 1 : 0);
            GLES20.glUniformMatrix4fv(this.refRotationMatrix, 1, false, this.rotationMatrix, 0);
            GLES20.glUniformMatrix4fv(this.refScaleMatrix, 1, false, this.scaleMatrix, 0);
            GLES20.glUniformMatrix4fv(this.refTranslationMatrix, 1, false, this.translationMatrix, 0);
            GLES20.glUniform3fv(this.refBackgroundDarkColor, 1, this.glBackgroundDarkColor, 0);
            GLES20.glUniform3fv(this.refBackgroundLightColor, 1, this.glBackgroundLightColor, 0);
            GLES20.glUniform1i(this.storySourceImageHandle[c], 0);
            GLES20.glEnableVertexAttribArray(this.storyInputTexCoordHandle[c]);
            GLES20.glVertexAttribPointer(this.storyInputTexCoordHandle[c], 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.storyPositionHandle[c]);
            GLES20.glVertexAttribPointer(this.storyPositionHandle[c], 2, 5126, false, 8, (Buffer) (this.isVideo ? this.vertexInvertBuffer : this.vertexBuffer));
            GLES20.glBindFramebuffer(36160, this.renderFrameBuffer[!this.isVideo ? 1 : 0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.renderTexture[1 ^ (this.isVideo ? 1 : 0)], 0);
            GLES20.glDrawArrays(5, 0, 4);
            if (!this.isVideo || this.videoPlaybackEndTime == -1 || (simpleExoPlayer = this.exoMediaPlayer) == null || simpleExoPlayer.getCurrentPosition() < this.videoPlaybackEndTime) {
                return;
            }
            seekMediaPlayer(this.videoPlaybackStartTime);
        }
    }

    public void onVideoFrameUpdate(float[] fArr) {
        this.videoMatrix = fArr;
        this.hsvGenerated = false;
    }

    private Bitmap createBitmap(Bitmap bitmap, int i, float f) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private void loadTexture(Bitmap bitmap, int i, int i2, int i3, boolean z) {
        Bitmap bitmapCreateBitmap = bitmap;
        if (this.isVideo) {
            if (z) {
                this.renderBufferWidth = i2;
                this.renderBufferHeight = i3;
            } else {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                this.renderBufferWidth = (int) DimensionHelper.getStoryViewWidthPx(ApplicationLoader.applicationActivity);
                this.renderBufferHeight = (int) DimensionHelper.getStoryViewHeightPx(ApplicationLoader.applicationActivity);
            }
        }
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
            }
            GLES20.glBindTexture(3553, this.bitmapTextre[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmapCreateBitmap, 0);
        }
        for (int i5 = 0; i5 < 2; i5++) {
            GLES20.glBindTexture(3553, this.renderTexture[i5]);
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

    public GLSceneState getCurrentSceneState() {
        return new GLSceneState(this.filterId, this.saturation, this.contrast, this.brightness, this.nextSaturation, this.nextContrast, this.nextBrightness, this.mediaRotation, this.originalMediaRotation, isAdjustmentNeeded() ? this.scaleXOriginal : this.scaleX, isAdjustmentNeeded() ? this.scaleYOriginal : this.scaleY, isAdjustmentNeeded() ? this.xPosInNormalCoordinationOriginal : this.xPosInNormalCoordination, isAdjustmentNeeded() ? this.yPosInNormalCoordinationOriginal : this.yPosInNormalCoordination, this.isBackgroundGenerated, this.backgroundPath, !this.isVideo, this.mediaPath, this.videoPlaybackStartTime, this.videoPlaybackEndTime, this.backgroundDarkColor, this.backgroundLightColor);
    }

    public void initiateBackgroundColorArrays() {
        this.glBackgroundDarkColor[0] = Color.red(this.backgroundDarkColor) / 255.0f;
        this.glBackgroundDarkColor[1] = Color.green(this.backgroundDarkColor) / 255.0f;
        this.glBackgroundDarkColor[2] = Color.blue(this.backgroundDarkColor) / 255.0f;
        this.glBackgroundLightColor[0] = Color.red(this.backgroundLightColor) / 255.0f;
        this.glBackgroundLightColor[1] = Color.green(this.backgroundLightColor) / 255.0f;
        this.glBackgroundLightColor[2] = Color.blue(this.backgroundLightColor) / 255.0f;
    }

    public void setGradientBackground(int i, int i2) {
        this.backgroundDarkColor = i;
        this.backgroundLightColor = i2;
        initiateBackgroundColorArrays();
        this.isBackgroundGenerated = true;
    }

    public void setExoMediaPlayer(SimpleExoPlayer simpleExoPlayer) {
        this.exoMediaPlayer = simpleExoPlayer;
        simpleExoPlayer.setVideoScalingMode(1);
        this.exoMediaPlayer.addListener(new Player.EventListener() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterShaders.1
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
                Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                onLoadingChanged(z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsPlayingChanged(boolean z) {
                Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onLoadingChanged(boolean z) {
                Player.EventListener.CC.$default$onLoadingChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackStateChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
                Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPositionDiscontinuity(int i) {
                Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onRepeatModeChanged(int i) {
                Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onSeekProcessed() {
                Player.EventListener.CC.$default$onSeekProcessed(this);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerStateChanged(boolean z, int i) {
                if (i == 4) {
                    FilterShaders filterShaders = FilterShaders.this;
                    filterShaders.seekMediaPlayer(filterShaders.videoPlaybackStartTime);
                }
            }
        });
    }

    public void setVideoTimeLimit(long j, long j2) {
        if (this.isVideo) {
            this.videoPlaybackStartTime = j;
            this.videoPlaybackEndTime = j2;
        }
    }

    public void setMediaRotation(float f) {
        this.mediaRotation = f;
        if (this.isSceneCreated) {
            createCoordinationMatrices();
        }
    }

    public void setFilterType(RGHFilter.FilterType filterType) {
        if (filterType == RGHFilter.FilterType.None) {
            this.filterId = 0;
            return;
        }
        if (filterType == RGHFilter.FilterType.BlackAndWhite) {
            this.filterId = 1;
            return;
        }
        if (filterType == RGHFilter.FilterType.Greish) {
            this.filterId = 2;
            return;
        }
        if (filterType == RGHFilter.FilterType.Happy) {
            this.filterId = 3;
            return;
        }
        if (filterType == RGHFilter.FilterType.Dark) {
            this.filterId = 4;
            return;
        }
        if (filterType == RGHFilter.FilterType.BuenosAires) {
            this.filterId = 5;
            return;
        }
        if (filterType == RGHFilter.FilterType.Tokyo) {
            this.filterId = 6;
            return;
        }
        if (filterType == RGHFilter.FilterType.Menegol) {
            this.filterId = 7;
            return;
        }
        if (filterType == RGHFilter.FilterType.Cold) {
            this.filterId = 8;
        } else if (filterType == RGHFilter.FilterType.Pinky) {
            this.filterId = 9;
        } else if (filterType == RGHFilter.FilterType.Sepia) {
            this.filterId = 10;
        }
    }

    public void setScale(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
        if (!isAdjustmentNeeded()) {
            float f3 = this.scaleX;
            float f4 = this.scaleY;
            this.mediaAspectRatio = f3 / f4;
            int i = screenWidth;
            if (i != 0) {
                this.sxRatio = f3 / i;
                this.syRatio = f4 / screenHeight;
                computeGlCoordination();
            }
        } else {
            this.scaleXOriginal = f;
            this.scaleYOriginal = f2;
            makeAdjustmentForBaseRotation();
        }
        if (this.isSceneCreated) {
            createCoordinationMatrices();
        }
    }

    public void setMediaPosition(float f, float f2) {
        this.xPosInNormalCoordination = f;
        this.yPosInNormalCoordination = f2;
        if (isAdjustmentNeeded()) {
            float f3 = this.xPosInNormalCoordination;
            this.xPosInNormalCoordinationOriginal = f3;
            float f4 = this.yPosInNormalCoordination;
            this.yPosInNormalCoordinationOriginal = f4;
            this.xPosInNormalCoordination = f3 - this.xPosCorrection;
            this.yPosInNormalCoordination = f4 + this.yPosCorrection;
        }
        computeGlCoordination();
        if (this.isSceneCreated) {
            createCoordinationMatrices();
        }
    }

    public void updateFilterInfo(int i, float f) {
        double d = f;
        Double.isNaN(d);
        float f2 = (float) (d + 1.0E-4d);
        int i2 = screenWidth;
        this.newFilterXPositionRatio = ((f2 * i2) / 100.0f) / i2;
        this.filterChangeDirection = i > 0 ? 1 : 2;
    }

    public void setMediaCoordinationInfo(float f, float f2, float f3, float f4, float f5) {
        MyLog.e("RGHBug", "setMediaCoordinationInfo, scaleX= " + f + " - scaleY = " + f2 + " - x = " + f3 + " - y = " + f4 + " - rotation = " + f5);
        setScale(f, f2);
        setMediaPosition(f3, f4);
        setMediaRotation(f5);
    }

    public void setSaturation(float f) {
        this.saturation = f;
    }

    public void setContrast(float f) {
        this.contrast = f;
    }

    public void setBrightness(float f) {
        this.brightness = f / 255.0f;
    }

    public void setNextFilterValues(float f, float f2, float f3) {
        this.nextSaturation = f;
        this.nextContrast = f2;
        this.nextBrightness = f3 / 255.0f;
    }

    public void pauseMediaPlayback() {
        SimpleExoPlayer simpleExoPlayer = this.exoMediaPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void resumeMediaPlayback() {
        SimpleExoPlayer simpleExoPlayer = this.exoMediaPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public void createCoordinationMatrices() {
        float f = this.mediaRotation;
        float f2 = this.originalMediaRotation;
        if (f + f2 != 0.0f) {
            double d = ((f + f2) / 180.0f) * 3.14159f;
            double dCos = Math.cos(d);
            double dSin = Math.sin(d);
            float f3 = this.mediaAspectRatio;
            float[] fArr = {f3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            float[] fArr2 = {1.0f / f3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            float f4 = (float) dCos;
            android.opengl.Matrix.multiplyMM(this.tempRotationMatrix2, 0, fArr2, 0, new float[]{f4, (float) (-dSin), 0.0f, 0.0f, (float) dSin, f4, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0);
            android.opengl.Matrix.multiplyMM(this.rotationMatrix, 0, this.tempRotationMatrix2, 0, fArr, 0);
        }
        this.scaleMatrix = new float[]{1.0f / this.sxRatio, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f / this.syRatio, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.translationMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, this.translateXinGlCoordination, this.translateYinGlCoordination, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private void computeGlCoordination() {
        int i = screenWidth;
        if (i != 0) {
            float f = this.scaleX;
            if (f == 0.0f) {
                f = i;
            }
            float f2 = this.scaleY;
            if (f2 == 0.0f) {
                f2 = screenHeight;
            }
            float f3 = (this.xPosInNormalCoordination + (f / 2.0f)) / i;
            float f4 = this.sxRatio;
            this.translateXinGlCoordination = ((1.0f / f4) * 0.5f) - (f3 * (((1.0f / f4) * 0.5f) - ((1.0f / f4) * (-0.5f))));
            float f5 = (this.yPosInNormalCoordination + (f2 / 2.0f)) / screenHeight;
            float f6 = this.syRatio;
            this.translateYinGlCoordination = ((1.0f / f6) * 0.5f) - (f5 * (((1.0f / f6) * 0.5f) - ((1.0f / f6) * (-0.5f))));
        }
    }

    private void makeAdjustmentForBaseRotation() {
        float f = this.scaleX;
        float f2 = this.scaleY;
        float f3 = ((f - f2) / 2.0f) - (f - f2);
        this.xPosCorrection = f3;
        float f4 = (f2 - f) / 2.0f;
        this.yPosCorrection = f4;
        this.xPosInNormalCoordination = this.xPosInNormalCoordinationOriginal - f3;
        this.yPosInNormalCoordination = this.yPosInNormalCoordinationOriginal + f4;
        this.scaleX = f2;
        this.scaleY = f;
        this.mediaAspectRatio = f2 / f;
        int i = screenWidth;
        if (i != 0) {
            this.sxRatio = f2 / i;
            this.syRatio = f / screenHeight;
            computeGlCoordination();
        }
    }

    private boolean isAdjustmentNeeded() {
        float f = this.originalMediaRotation;
        return (f == 90.0f || f == -90.0f) && this.scaleX != this.scaleY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekMediaPlayer(long j) {
        try {
            this.exoMediaPlayer.seekTo(j);
        } catch (Exception unused) {
        }
    }

    public void onSurfaceSizeChanged(int i, int i2) {
        screenWidth = i;
        screenHeight = i2;
        float f = this.scaleX;
        if (f != 0.0f) {
            this.sxRatio = f / i;
            this.syRatio = this.scaleY / i2;
        }
        this.isSceneCreated = true;
        computeGlCoordination();
        createCoordinationMatrices();
    }

    public void setBackgroundImagePath(String str) {
        this.backgroundPath = str;
    }

    public void loadSceneFromState(GLSceneState gLSceneState) {
        this.updateSurface = false;
        this.isSceneCreated = false;
        this.filterId = gLSceneState.getFilterId();
        this.mediaPath = gLSceneState.getMediaPath();
        this.backgroundPath = gLSceneState.getBackgroundFilePath();
        this.originalMediaRotation = gLSceneState.getOriginalMediaRotation();
        this.videoPlaybackStartTime = gLSceneState.getVideoPlaybackStartTime();
        this.videoPlaybackEndTime = gLSceneState.getVideoPlaybackEndTime();
        this.saturation = gLSceneState.getSaturation();
        this.brightness = gLSceneState.getBrightness();
        this.contrast = gLSceneState.getContrast();
        this.nextBrightness = gLSceneState.getNextBrightness();
        this.nextContrast = gLSceneState.getNextContrast();
        this.nextSaturation = gLSceneState.getNextSaturation();
        this.isVideo = !gLSceneState.isImageMedia();
        setMediaCoordinationInfo(gLSceneState.getScaleX(), gLSceneState.getScaleY(), gLSceneState.getxPosInNormalCoordination(), gLSceneState.getyPosInNormalCoordination(), gLSceneState.getMediaRotation());
        this.backgroundDarkColor = gLSceneState.getBackgroundDarkColor();
        this.backgroundLightColor = gLSceneState.getBackgroundLightColor();
        initiateBackgroundColorArrays();
        createCoordinationMatrices();
        this.isSceneCreated = true;
        this.isUpdatingState = false;
        this.updateSurface = true;
    }

    public String toString() {
        return "FilterShaders{, storyMatrixHandle=" + this.storyMatrixHandle + ", videoTexture=" + this.videoTexture + ", renderFrameBuffer=" + Arrays.toString(this.renderFrameBuffer) + ", hsvGenerated=" + this.hsvGenerated + ", renderBufferWidth=" + this.renderBufferWidth + ", renderBufferHeight=" + this.renderBufferHeight + ", vertexInvertBuffer=" + this.vertexInvertBuffer + ", rotationMatrix=" + Arrays.toString(this.rotationMatrix) + ", scaleMatrix=" + Arrays.toString(this.scaleMatrix) + ", translationMatrix=" + Arrays.toString(this.translationMatrix) + ", textureVertexBuffer=" + this.textureVertexBuffer + ", mediaTextureLocation=" + this.mediaTextureLocation + ", aTextureCoordLocation=" + this.aTextureCoordLocation + ", mediaTextureId=" + this.mediaTextureId + ", backgroundTextureLocation=" + this.backgroundTextureLocation + ", backgroundTextureId=" + this.backgroundTextureId + ", surfaceTexture=" + this.surfaceTexture + ", videoSurface=" + this.videoSurface + ", exoMediaPlayer=" + this.exoMediaPlayer + ", updateSurface=" + this.updateSurface + ", maxScreenWidth=" + this.maxScreenWidth + ", mediaRotation=" + this.mediaRotation + ", originalMediaRotation=" + this.originalMediaRotation + ", filterId=" + this.filterId + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", scaleXOriginal=" + this.scaleXOriginal + ", scaleYOriginal=" + this.scaleYOriginal + ", sxRatio=" + this.sxRatio + ", syRatio=" + this.syRatio + ", translateXinGlCoordination=" + this.translateXinGlCoordination + ", translateYinGlCoordination=" + this.translateYinGlCoordination + ", xPosInNormalCoordination=" + this.xPosInNormalCoordination + ", yPosInNormalCoordination=" + this.yPosInNormalCoordination + ", xPosInNormalCoordinationOriginal=" + this.xPosInNormalCoordinationOriginal + ", yPosInNormalCoordinationOriginal=" + this.yPosInNormalCoordinationOriginal + ", xPosCorrection=" + this.xPosCorrection + ", yPosCorrection=" + this.yPosCorrection + ", newFilterXPositionRatio=" + this.newFilterXPositionRatio + ", mediaAspectRatio=" + this.mediaAspectRatio + ", filterChangeDirection=" + this.filterChangeDirection + ", saturation=" + this.saturation + ", contrast=" + this.contrast + ", brightness=" + this.brightness + ", nextSaturation=" + this.nextSaturation + ", nextContrast=" + this.nextContrast + ", nextBrightness=" + this.nextBrightness + ", imageMediaFilePath='" + this.imageMediaFilePath + "', mCaptureEnabled=" + this.mCaptureEnabled + ", imageCaptureListener=" + this.imageCaptureListener + ", videoPlaybackStartTime=" + this.videoPlaybackStartTime + ", videoPlaybackEndTime=" + this.videoPlaybackEndTime + ", backgroundDarkColor=" + this.backgroundDarkColor + ", backgroundLightColor=" + this.backgroundLightColor + ", glBackgroundDarkColor=" + Arrays.toString(this.glBackgroundDarkColor) + ", glBackgroundLightColor=" + Arrays.toString(this.glBackgroundLightColor) + ", isUpdatingState=" + this.isUpdatingState + ", isSceneCreated=" + this.isSceneCreated + ", isBackgroundGenerated=" + this.isBackgroundGenerated + ", isSupportingNPOT=" + this.isSupportingNPOT + ", mediaPath='" + this.mediaPath + "', isVideo=" + this.isVideo + '}';
    }
}
