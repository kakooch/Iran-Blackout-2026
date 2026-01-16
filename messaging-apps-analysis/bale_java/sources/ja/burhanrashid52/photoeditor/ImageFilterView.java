package ja.burhanrashid52.photoeditor;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.media.effect.Effect;
import android.media.effect.EffectContext;
import android.media.effect.EffectFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8934Xw1;
import ir.nasim.C16079kg0;
import ir.nasim.C20321ro7;
import ir.nasim.ED1;
import ir.nasim.I85;
import ir.nasim.VJ4;
import ir.nasim.ZB2;
import ja.burhanrashid52.photoeditor.ImageFilterView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0000\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001,B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\"\u0010&J\u0017\u0010)\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00106R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00109R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010=¨\u0006K"}, d2 = {"Lja/burhanrashid52/photoeditor/ImageFilterView;", "Landroid/opengl/GLSurfaceView;", "Landroid/opengl/GLSurfaceView$Renderer;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "d", "()V", "c", "b", "f", "Landroid/graphics/Bitmap;", "sourceBitmap", "setSourceBitmap", "(Landroid/graphics/Bitmap;)V", "Ljavax/microedition/khronos/opengles/GL10;", "gl", "Ljavax/microedition/khronos/egl/EGLConfig;", "config", "onSurfaceCreated", "(Ljavax/microedition/khronos/opengles/GL10;Ljavax/microedition/khronos/egl/EGLConfig;)V", "", "width", "height", "onSurfaceChanged", "(Ljavax/microedition/khronos/opengles/GL10;II)V", "onDrawFrame", "(Ljavax/microedition/khronos/opengles/GL10;)V", "Lir/nasim/I85;", "effect", "setFilterEffect", "(Lir/nasim/I85;)V", "Lir/nasim/Xw1;", "customEffect", "(Lir/nasim/Xw1;)V", "Lir/nasim/VJ4;", "onSaveBitmap", "g", "(Lir/nasim/VJ4;)V", "", "a", "[I", "mTextures", "Landroid/media/effect/EffectContext;", "Landroid/media/effect/EffectContext;", "mEffectContext", "Landroid/media/effect/Effect;", "Landroid/media/effect/Effect;", "mEffect", "Lir/nasim/ro7;", "Lir/nasim/ro7;", "mTexRenderer", "e", TokenNames.I, "mImageWidth", "mImageHeight", "", "Z", "mInitialized", "h", "Lir/nasim/I85;", "mCurrentEffect", "i", "Landroid/graphics/Bitmap;", "mSourceBitmap", "j", "Lir/nasim/VJ4;", "mOnSaveBitmap", "k", "isSaveImage", "l", "photoeditor_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class ImageFilterView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: from kotlin metadata */
    private final int[] mTextures;

    /* renamed from: b, reason: from kotlin metadata */
    private EffectContext mEffectContext;

    /* renamed from: c, reason: from kotlin metadata */
    private Effect mEffect;

    /* renamed from: d, reason: from kotlin metadata */
    private final C20321ro7 mTexRenderer;

    /* renamed from: e, reason: from kotlin metadata */
    private int mImageWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private int mImageHeight;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean mInitialized;

    /* renamed from: h, reason: from kotlin metadata */
    private I85 mCurrentEffect;

    /* renamed from: i, reason: from kotlin metadata */
    private Bitmap mSourceBitmap;

    /* renamed from: j, reason: from kotlin metadata */
    private VJ4 mOnSaveBitmap;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isSaveImage;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[I85.values().length];
            iArr[I85.AUTO_FIX.ordinal()] = 1;
            iArr[I85.BLACK_WHITE.ordinal()] = 2;
            iArr[I85.BRIGHTNESS.ordinal()] = 3;
            iArr[I85.CONTRAST.ordinal()] = 4;
            iArr[I85.CROSS_PROCESS.ordinal()] = 5;
            iArr[I85.DOCUMENTARY.ordinal()] = 6;
            iArr[I85.DUE_TONE.ordinal()] = 7;
            iArr[I85.FILL_LIGHT.ordinal()] = 8;
            iArr[I85.FISH_EYE.ordinal()] = 9;
            iArr[I85.FLIP_HORIZONTAL.ordinal()] = 10;
            iArr[I85.FLIP_VERTICAL.ordinal()] = 11;
            iArr[I85.GRAIN.ordinal()] = 12;
            iArr[I85.GRAY_SCALE.ordinal()] = 13;
            iArr[I85.LOMISH.ordinal()] = 14;
            iArr[I85.NEGATIVE.ordinal()] = 15;
            iArr[I85.NONE.ordinal()] = 16;
            iArr[I85.POSTERIZE.ordinal()] = 17;
            iArr[I85.ROTATE.ordinal()] = 18;
            iArr[I85.SATURATE.ordinal()] = 19;
            iArr[I85.SEPIA.ordinal()] = 20;
            iArr[I85.SHARPEN.ordinal()] = 21;
            iArr[I85.TEMPERATURE.ordinal()] = 22;
            iArr[I85.TINT.ordinal()] = 23;
            iArr[I85.VIGNETTE.ordinal()] = 24;
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageFilterView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(context, "context");
    }

    private final void b() {
        Effect effect = this.mEffect;
        if (effect == null) {
            return;
        }
        int[] iArr = this.mTextures;
        effect.apply(iArr[0], this.mImageWidth, this.mImageHeight, iArr[1]);
    }

    private final void c() {
        EffectFactory factory;
        EffectContext effectContext = this.mEffectContext;
        if (effectContext == null || (factory = effectContext.getFactory()) == null) {
            return;
        }
        Effect effect = this.mEffect;
        if (effect != null) {
            effect.release();
        }
        I85 i85 = this.mCurrentEffect;
        switch (i85 == null ? -1 : b.a[i85.ordinal()]) {
            case 1:
                Effect effectCreateEffect = factory.createEffect("android.media.effect.effects.AutoFixEffect");
                this.mEffect = effectCreateEffect;
                if (effectCreateEffect != null) {
                    effectCreateEffect.setParameter("scale", Float.valueOf(0.5f));
                    break;
                }
                break;
            case 2:
                Effect effectCreateEffect2 = factory.createEffect("android.media.effect.effects.BlackWhiteEffect");
                this.mEffect = effectCreateEffect2;
                if (effectCreateEffect2 != null) {
                    effectCreateEffect2.setParameter("black", Float.valueOf(0.1f));
                }
                Effect effect2 = this.mEffect;
                if (effect2 != null) {
                    effect2.setParameter("white", Float.valueOf(0.7f));
                    break;
                }
                break;
            case 3:
                Effect effectCreateEffect3 = factory.createEffect("android.media.effect.effects.BrightnessEffect");
                this.mEffect = effectCreateEffect3;
                if (effectCreateEffect3 != null) {
                    effectCreateEffect3.setParameter("brightness", Float.valueOf(2.0f));
                    break;
                }
                break;
            case 4:
                Effect effectCreateEffect4 = factory.createEffect("android.media.effect.effects.ContrastEffect");
                this.mEffect = effectCreateEffect4;
                if (effectCreateEffect4 != null) {
                    effectCreateEffect4.setParameter("contrast", Float.valueOf(1.4f));
                    break;
                }
                break;
            case 5:
                this.mEffect = factory.createEffect("android.media.effect.effects.CrossProcessEffect");
                break;
            case 6:
                this.mEffect = factory.createEffect("android.media.effect.effects.DocumentaryEffect");
                break;
            case 7:
                Effect effectCreateEffect5 = factory.createEffect("android.media.effect.effects.DuotoneEffect");
                this.mEffect = effectCreateEffect5;
                if (effectCreateEffect5 != null) {
                    effectCreateEffect5.setParameter("first_color", -256);
                }
                Effect effect3 = this.mEffect;
                if (effect3 != null) {
                    effect3.setParameter("second_color", -12303292);
                    break;
                }
                break;
            case 8:
                Effect effectCreateEffect6 = factory.createEffect("android.media.effect.effects.FillLightEffect");
                this.mEffect = effectCreateEffect6;
                if (effectCreateEffect6 != null) {
                    effectCreateEffect6.setParameter("strength", Float.valueOf(0.8f));
                    break;
                }
                break;
            case 9:
                Effect effectCreateEffect7 = factory.createEffect("android.media.effect.effects.FisheyeEffect");
                this.mEffect = effectCreateEffect7;
                if (effectCreateEffect7 != null) {
                    effectCreateEffect7.setParameter("scale", Float.valueOf(0.5f));
                    break;
                }
                break;
            case 10:
                Effect effectCreateEffect8 = factory.createEffect("android.media.effect.effects.FlipEffect");
                this.mEffect = effectCreateEffect8;
                if (effectCreateEffect8 != null) {
                    effectCreateEffect8.setParameter("horizontal", Boolean.TRUE);
                    break;
                }
                break;
            case 11:
                Effect effectCreateEffect9 = factory.createEffect("android.media.effect.effects.FlipEffect");
                this.mEffect = effectCreateEffect9;
                if (effectCreateEffect9 != null) {
                    effectCreateEffect9.setParameter("vertical", Boolean.TRUE);
                    break;
                }
                break;
            case 12:
                Effect effectCreateEffect10 = factory.createEffect("android.media.effect.effects.GrainEffect");
                this.mEffect = effectCreateEffect10;
                if (effectCreateEffect10 != null) {
                    effectCreateEffect10.setParameter("strength", Float.valueOf(1.0f));
                    break;
                }
                break;
            case 13:
                this.mEffect = factory.createEffect("android.media.effect.effects.GrayscaleEffect");
                break;
            case 14:
                this.mEffect = factory.createEffect("android.media.effect.effects.LomoishEffect");
                break;
            case 15:
                this.mEffect = factory.createEffect("android.media.effect.effects.NegativeEffect");
                break;
            case 17:
                this.mEffect = factory.createEffect("android.media.effect.effects.PosterizeEffect");
                break;
            case 18:
                Effect effectCreateEffect11 = factory.createEffect("android.media.effect.effects.RotateEffect");
                this.mEffect = effectCreateEffect11;
                if (effectCreateEffect11 != null) {
                    effectCreateEffect11.setParameter("angle", Integer.valueOf(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER));
                    break;
                }
                break;
            case 19:
                Effect effectCreateEffect12 = factory.createEffect("android.media.effect.effects.SaturateEffect");
                this.mEffect = effectCreateEffect12;
                if (effectCreateEffect12 != null) {
                    effectCreateEffect12.setParameter("scale", Float.valueOf(0.5f));
                    break;
                }
                break;
            case 20:
                this.mEffect = factory.createEffect("android.media.effect.effects.SepiaEffect");
                break;
            case 21:
                this.mEffect = factory.createEffect("android.media.effect.effects.SharpenEffect");
                break;
            case 22:
                Effect effectCreateEffect13 = factory.createEffect("android.media.effect.effects.ColorTemperatureEffect");
                this.mEffect = effectCreateEffect13;
                if (effectCreateEffect13 != null) {
                    effectCreateEffect13.setParameter("scale", Float.valueOf(0.9f));
                    break;
                }
                break;
            case 23:
                Effect effectCreateEffect14 = factory.createEffect("android.media.effect.effects.TintEffect");
                this.mEffect = effectCreateEffect14;
                if (effectCreateEffect14 != null) {
                    effectCreateEffect14.setParameter("tint", -65281);
                    break;
                }
                break;
            case 24:
                Effect effectCreateEffect15 = factory.createEffect("android.media.effect.effects.VignetteEffect");
                this.mEffect = effectCreateEffect15;
                if (effectCreateEffect15 != null) {
                    effectCreateEffect15.setParameter("scale", Float.valueOf(0.5f));
                    break;
                }
                break;
        }
    }

    private final void d() {
        GLES20.glGenTextures(2, this.mTextures, 0);
        Bitmap bitmap = this.mSourceBitmap;
        if (bitmap == null) {
            return;
        }
        this.mImageWidth = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.mImageHeight = height;
        this.mTexRenderer.d(this.mImageWidth, height);
        GLES20.glBindTexture(3553, this.mTextures[0]);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        ZB2.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ImageFilterView imageFilterView, Bitmap bitmap) {
        AbstractC13042fc3.i(imageFilterView, "this$0");
        VJ4 vj4 = imageFilterView.mOnSaveBitmap;
        if (vj4 == null) {
            return;
        }
        vj4.b(bitmap);
    }

    private final void f() {
        if (this.mCurrentEffect == I85.NONE) {
            this.mTexRenderer.c(this.mTextures[0]);
        } else {
            this.mTexRenderer.c(this.mTextures[1]);
        }
    }

    public final void g(VJ4 onSaveBitmap) {
        this.mOnSaveBitmap = onSaveBitmap;
        this.isSaveImage = true;
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl) {
        AbstractC13042fc3.i(gl, "gl");
        if (!this.mInitialized) {
            this.mEffectContext = EffectContext.createWithCurrentGlContext();
            this.mTexRenderer.b();
            d();
            this.mInitialized = true;
        }
        if (this.mCurrentEffect != I85.NONE) {
            c();
            b();
        }
        f();
        if (this.isSaveImage) {
            final Bitmap bitmapA = C16079kg0.a.a(this, gl);
            Log.e("ImageFilterView", AbstractC13042fc3.q("onDrawFrame: ", bitmapA));
            this.isSaveImage = false;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.Q13
                @Override // java.lang.Runnable
                public final void run() {
                    ImageFilterView.e(this.a, bitmapA);
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        AbstractC13042fc3.i(gl, "gl");
        this.mTexRenderer.e(width, height);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        AbstractC13042fc3.i(gl, "gl");
        AbstractC13042fc3.i(config, "config");
    }

    public final void setFilterEffect(I85 effect) {
        this.mCurrentEffect = effect;
        requestRender();
    }

    public final void setSourceBitmap(Bitmap sourceBitmap) {
        this.mSourceBitmap = sourceBitmap;
        this.mInitialized = false;
    }

    public /* synthetic */ ImageFilterView(Context context, AttributeSet attributeSet, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.mTextures = new int[2];
        this.mTexRenderer = new C20321ro7();
        setEGLContextClientVersion(2);
        setRenderer(this);
        setRenderMode(0);
        setFilterEffect(I85.NONE);
    }

    public final void setFilterEffect(AbstractC8934Xw1 customEffect) {
        requestRender();
    }
}
