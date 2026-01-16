package io.antmedia.android.broadcaster.encoder.gles;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class Texture2dProgram {
    public static final List<ProgramType> EFFECTS;
    private float mColorAdjust;
    private float[] mKernel = new float[9];
    private int mProgramHandle;
    private ProgramType mProgramType;
    private float[] mResolution;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muResolutionLoc;
    private int muTexMatrixLoc;
    private int muTexOffsetLoc;

    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_NO_VIDEO,
        TEXTURE_EXT_TOGGLE_VIDEO_OFF,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT,
        TEXTURE_EXT_SEPIA,
        TEXTURE_EXT_CROSSPROCESS,
        TEXTURE_EXT_POSTERIZE,
        TEXTURE_EXT_GRAYSCALE
    }

    static {
        ArrayList arrayList = new ArrayList();
        EFFECTS = arrayList;
        arrayList.add(ProgramType.TEXTURE_EXT);
        arrayList.add(ProgramType.TEXTURE_EXT_CROSSPROCESS);
        arrayList.add(ProgramType.TEXTURE_EXT_POSTERIZE);
        arrayList.add(ProgramType.TEXTURE_EXT_SEPIA);
        arrayList.add(ProgramType.TEXTURE_EXT_GRAYSCALE);
    }

    public Texture2dProgram(ProgramType programType) {
        this.mProgramType = programType;
        switch (AnonymousClass1.$SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[programType.ordinal()]) {
            case 1:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                break;
            case 2:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                break;
            case 3:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\n#define CHAR_SIZE vec2(6, 7)\n#define CHAR_SPACING vec2(6, 9)\n\n#define STRWIDTH(c) (c * CHAR_SPACING.x)\n#define STRHEIGHT(c) (c * CHAR_SPACING.y)\n\n#define DOWN_SCALE 4.0\n\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 u_resolution;\n\nvec2 ch_spc = vec2(0.0,0.0);\nvec2 ch_D = vec2(1983764.0,665788.0);\nvec2 ch_E = vec2(2048263.0,1181758.0);\nvec2 ch_I = vec2(921665.0,33308.0);\nvec2 ch_N = vec2(1140052.0,1714338.0);\nvec2 ch_O = vec2(935188.0,665756.0);\nvec2 ch_V = vec2(1131796.0,664840.0);\nvec2 ch_dsh = vec2(7.0,1572864.0);\nvec2 res;\nvec2 print_pos = vec2(0);\n\n//Extracts bit b from the given number.\n//Shifts bits right (num / 2^bit) then ANDs the result with 1 (mod(result,2.0)).\nfloat extract_bit(float n, float b)\n{\n    b = clamp(b,-1.0,22.0); //Fixes small artefacts on my nexus 7\n    return floor(mod(floor(n / pow(2.0,floor(b))),2.0));   \n}\n\n//Returns the pixel at uv in the given bit-packed sprite.\nfloat sprite(vec2 spr, vec2 size, vec2 uv)\n{\n    uv = floor(uv);\n    //Calculate the bit to extract (x + y * width) (flipped on x-axis)\n    float bit = (size.x-uv.x-1.0) + uv.y * size.x;\n    \n    //Clipping bound to remove garbage outside the sprite's boundaries.\n    bool bounds = all(greaterThanEqual(uv,vec2(0)));\n    bounds = bounds && all(lessThan(uv,size));\n    \n    return bounds ? extract_bit(spr.x, bit - 21.0)+extract_bit(spr.y, bit) : 0.0;\n\n}\n\n//Prints a character and moves the print position forward by 1 character width.\nfloat char(vec2 ch, vec2 uv)\n{\n    float px = sprite(ch, CHAR_SIZE, uv - print_pos);\n    print_pos.x += CHAR_SPACING.x;\n    return px;\n}\n\nfloat Text(vec2 uv)\n{\n    float col = 0.0;\n    \n    print_pos = vec2(res.x/2.0 - STRWIDTH(8.0)/2.0,2.0*res.y/3.0 - STRHEIGHT(1.0)/2.0);\n    print_pos = floor(print_pos);\n       \n    col += char(ch_N,uv);\n    col += char(ch_O,uv);\n    \n    col += char(ch_dsh,uv);\n    \n    col += char(ch_V,uv);\n    col += char(ch_I,uv);\n    col += char(ch_D,uv);\n    col += char(ch_E,uv);\n    col += char(ch_O,uv);\n    \n    return col;\n}\n\nvoid main()\n{\n    res = u_resolution.xy / DOWN_SCALE;\n    vec2 uv = gl_FragCoord.xy / DOWN_SCALE;\n    vec2 duv = floor(gl_FragCoord.xy / DOWN_SCALE);\n    \n    float pixel = Text(duv);\n    \n    vec3 col = vec3(1);\n    col *= (1.-distance(mod(uv,vec2(1.0)),vec2(0.65)))*1.2;\n    col *= mix(vec3(0.0),vec3(1,1,1),pixel);\n\nvec4 tc = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = vec4(vec3(col), tc.a);\n}");
                break;
            case 4:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\n#define CHAR_SIZE vec2(6, 7)\n#define CHAR_SPACING vec2(6, 9)\n\n#define STRWIDTH(c) (c * CHAR_SPACING.x)\n#define STRHEIGHT(c) (c * CHAR_SPACING.y)\n\n#define DOWN_SCALE 4.0\n\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 u_resolution;\n\nvec2 ch_spc = vec2(0.0,0.0);\nvec2 ch_D = vec2(1983764.0,665788.0);\nvec2 ch_E = vec2(2048263.0,1181758.0);\nvec2 ch_I = vec2(921665.0,33308.0);\nvec2 ch_F = vec2(2048263.0,1181728.0);\nvec2 ch_O = vec2(935188.0,665756.0);\nvec2 ch_V = vec2(1131796.0,664840.0);\nvec2 ch_dsh = vec2(7.0,1572864.0);\nvec2 res;\nvec2 print_pos = vec2(0);\n\n//Extracts bit b from the given number.\n//Shifts bits right (num / 2^bit) then ANDs the result with 1 (mod(result,2.0)).\nfloat extract_bit(float n, float b)\n{\n    b = clamp(b,-1.0,22.0); //Fixes small artefacts on my nexus 7\n    return floor(mod(floor(n / pow(2.0,floor(b))),2.0));   \n}\n\n//Returns the pixel at uv in the given bit-packed sprite.\nfloat sprite(vec2 spr, vec2 size, vec2 uv)\n{\n    uv = floor(uv);\n    //Calculate the bit to extract (x + y * width) (flipped on x-axis)\n    float bit = (size.x-uv.x-1.0) + uv.y * size.x;\n    \n    //Clipping bound to remove garbage outside the sprite's boundaries.\n    bool bounds = all(greaterThanEqual(uv,vec2(0)));\n    bounds = bounds && all(lessThan(uv,size));\n    \n    return bounds ? extract_bit(spr.x, bit - 21.0)+extract_bit(spr.y, bit) : 0.0;\n\n}\n\n//Prints a character and moves the print position forward by 1 character width.\nfloat char(vec2 ch, vec2 uv)\n{\n    float px = sprite(ch, CHAR_SIZE, uv - print_pos);\n    print_pos.x += CHAR_SPACING.x;\n    return px;\n}\n\nfloat Text(vec2 uv)\n{\n    float col = 0.0;\n    \n    print_pos = vec2(res.x/2.0 - STRWIDTH(9.0)/2.0,2.0*res.y/3.0 - STRHEIGHT(1.0)/2.0);\n    print_pos = floor(print_pos);\n       \n    col += char(ch_V,uv);\n    col += char(ch_I,uv);\n    col += char(ch_D,uv);\n    col += char(ch_E,uv);\n    col += char(ch_O,uv);\n    \n    col += char(ch_dsh,uv);\n    \n    \n    col += char(ch_O,uv);\n    col += char(ch_F,uv);\n    col += char(ch_F,uv);\n    \n    return col;\n}\n\nvoid main()\n{\n    res = u_resolution.xy / DOWN_SCALE;\n    vec2 uv = gl_FragCoord.xy / DOWN_SCALE;\n    vec2 duv = floor(gl_FragCoord.xy / DOWN_SCALE);\n    \n    float pixel = Text(duv);\n    \n    vec3 col = vec3(1);\n    col *= (1.-distance(mod(uv,vec2(1.0)),vec2(0.65)))*1.2;\n    col *= mix(vec3(0.0),vec3(1,1,1),pixel);\n\nvec4 tc = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = vec4(vec3(col), tc.a);\n}");
                break;
            case 5:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
                break;
            case 6:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float y = dot(color, vec4(0.299, 0.587, 0.114, 0));\n  gl_FragColor = vec4(y, y, y, color.a);\n}\n");
                break;
            case 7:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = vec4(tc.x, tc.y, tc.z, 1.0);\n    gl_FragColor.r = dot(tc, vec4(.393, .769, .189, 0));\n    gl_FragColor.g = dot(tc, vec4(.349, .686, .168, 0));\n    gl_FragColor.b = dot(tc, vec4(.272, .534, .131, 0));\n}\n");
                break;
            case 8:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 color = texture2D(sTexture, vTextureCoord).rgb;\n   color = pow(color, vec3(0.6, 0.6, 0.6));\n   color = color * 8.0;\n   color = floor(color);\n   color = color / 8.0;\n   color = pow(color, vec3(1.0/0.6));\n   gl_FragColor = vec4(color, 1.0);\n}\n");
                break;
            case 9:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  vec3 ncolor = vec3(0.0, 0.0, 0.0);\n  float value;\n  if (color.r < 0.5) {\n    value = color.r;\n  } else {\n    value = 1.0 - color.r;\n  }\n  float red = 4.0 * value * value * value;\n  if (color.r < 0.5) {\n    ncolor.r = red;\n  } else {\n    ncolor.r = 1.0 - red;\n  }\n  if (color.g < 0.5) {\n    value = color.g;\n  } else {\n    value = 1.0 - color.g;\n  }\n  float green = 2.0 * value * value;\n  if (color.g < 0.5) {\n    ncolor.g = green;\n  } else {\n    ncolor.g = 1.0 - green;\n  }\n  ncolor.b = color.b * 0.5 + 0.25;\n  gl_FragColor = vec4(ncolor.rgb, color.a);\n}\n");
                break;
            case 10:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n");
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Log.d("Grafika", "Created program " + this.mProgramHandle + " (" + programType + ")");
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        this.maPositionLoc = iGlGetAttribLocation;
        GlUtil.checkLocation(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        this.maTextureCoordLoc = iGlGetAttribLocation2;
        GlUtil.checkLocation(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        this.muMVPMatrixLoc = iGlGetUniformLocation;
        GlUtil.checkLocation(iGlGetUniformLocation, "uMVPMatrix");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.muTexMatrixLoc = iGlGetUniformLocation2;
        GlUtil.checkLocation(iGlGetUniformLocation2, "uTexMatrix");
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
        this.muKernelLoc = iGlGetUniformLocation3;
        if (iGlGetUniformLocation3 < 0) {
            this.muKernelLoc = -1;
            this.muTexOffsetLoc = -1;
            this.muColorAdjustLoc = -1;
        } else {
            int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
            this.muTexOffsetLoc = iGlGetUniformLocation4;
            GlUtil.checkLocation(iGlGetUniformLocation4, "uTexOffset");
            int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
            this.muColorAdjustLoc = iGlGetUniformLocation5;
            GlUtil.checkLocation(iGlGetUniformLocation5, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(Factory.DEVICE_HAS_CRAPPY_OPENSLES, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
        }
        this.muResolutionLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "u_resolution");
    }

    /* renamed from: io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType;

        static {
            int[] iArr = new int[ProgramType.values().length];
            $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_NO_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_TOGGLE_VIDEO_OFF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_BW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_GRAYSCALE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_SEPIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_POSTERIZE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_CROSSPROCESS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public void release() {
        Log.d("Grafika", "deleting program " + this.mProgramHandle);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i);
        GlUtil.checkGlError("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return i;
    }

    public void setKernel(float[] values, float colorAdj) {
        if (values.length != 9) {
            throw new IllegalArgumentException("Kernel size is " + values.length + " vs. 9");
        }
        System.arraycopy(values, 0, this.mKernel, 0, 9);
        this.mColorAdjust = colorAdj;
    }

    public void setTexSize(int width, int height) {
        float f = 1.0f / width;
        float f2 = 1.0f / height;
        float f3 = -f;
        float f4 = -f2;
        this.mTexOffset = new float[]{f3, f4, 0.0f, f4, f, f4, f3, 0.0f, 0.0f, 0.0f, f, 0.0f, f3, f2, 0.0f, f2, f, f2};
    }

    public void setPreviewResolution(int width, int height) {
        if (this.mResolution == null) {
            this.mResolution = new float[2];
        }
        float[] fArr = this.mResolution;
        fArr[0] = width;
        fArr[1] = height;
    }

    public void draw(float[] mvpMatrix, FloatBuffer vertexBuffer, int firstVertex, int vertexCount, int coordsPerVertex, int vertexStride, float[] texMatrix, FloatBuffer texBuffer, int textureId, int texStride) {
        float[] fArr;
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, textureId);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, mvpMatrix, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, texMatrix, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, coordsPerVertex, 5126, false, vertexStride, (Buffer) vertexBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, texStride, (Buffer) texBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        int i = this.muKernelLoc;
        if (i >= 0) {
            GLES20.glUniform1fv(i, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        int i2 = this.muResolutionLoc;
        if (i2 >= 0 && (fArr = this.mResolution) != null) {
            GLES20.glUniform2f(i2, fArr[0], fArr[1]);
        }
        GLES20.glDrawArrays(5, firstVertex, vertexCount);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }
}
