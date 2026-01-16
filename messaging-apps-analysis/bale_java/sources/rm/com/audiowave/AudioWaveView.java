package rm.com.audiowave;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15434ja6;
import ir.nasim.AbstractC20623sK2;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14845ia6;
import ir.nasim.C19938rB7;
import ir.nasim.C24411ya3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.PE5;
import ir.nasim.QJ4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UJ4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\"\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0015¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b%\u0010&J\u001d\u0010+\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J'\u0010+\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130-H\u0007¢\u0006\u0004\b+\u0010.R4\u00106\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00130/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R.\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R.\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R*\u0010J\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR*\u0010N\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR*\u0010R\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010E\u001a\u0004\bP\u0010G\"\u0004\bQ\u0010IR*\u0010V\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010E\u001a\u0004\bT\u0010G\"\u0004\bU\u0010IR*\u0010Y\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010E\u001a\u0004\bW\u0010G\"\u0004\bX\u0010IR*\u0010\\\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010E\u001a\u0004\bZ\u0010G\"\u0004\b[\u0010IR*\u0010c\u001a\u00020\r2\u0006\u0010C\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR*\u0010i\u001a\u00020'2\u0006\u0010C\u001a\u00020'8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR*\u0010q\u001a\u00020j2\u0006\u0010C\u001a\u00020j8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010v\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010r\u001a\u0004\b]\u0010s\"\u0004\bt\u0010uR\"\u0010x\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010r\u001a\u0004\bx\u0010s\"\u0004\by\u0010uR*\u0010|\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020\u001c8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010r\u001a\u0004\b|\u0010s\"\u0004\b}\u0010uR\u0014\u0010\u007f\u001a\u00020j8\u0002X\u0082D¢\u0006\u0006\n\u0004\b~\u0010lR\"\u0010\u0084\u0001\u001a\r \u0081\u0001*\u0005\u0018\u00010\u0080\u00010\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0087\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010ER\u0017\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010ER\u0016\u0010\u0093\u0001\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010GR\u0016\u0010\u0095\u0001\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010GR\u0016\u0010\u0097\u0001\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010`R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0013\u0010 \u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010G¨\u0006¡\u0001"}, d2 = {"Lrm/com/audiowave/AudioWaveView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "", "m", "(Landroid/view/MotionEvent;)F", "Landroid/graphics/Canvas;", "canvas", "factor", "Lir/nasim/rB7;", "k", "(Landroid/graphics/Canvas;F)V", "h", "()V", "i", "(Landroid/util/AttributeSet;)V", "onDraw", "(Landroid/graphics/Canvas;)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "raw", "Lir/nasim/UJ4;", "callback", "setRawData", "([BLir/nasim/UJ4;)V", "Lkotlin/Function0;", "([BLir/nasim/SA2;)V", "Lkotlin/Function2;", "a", "Lir/nasim/iB2;", "getOnProgressChanged", "()Lir/nasim/iB2;", "setOnProgressChanged", "(Lir/nasim/iB2;)V", "onProgressChanged", "Lkotlin/Function1;", "b", "Lir/nasim/UA2;", "getOnStartTracking", "()Lir/nasim/UA2;", "setOnStartTracking", "(Lir/nasim/UA2;)V", "onStartTracking", "c", "getOnStopTracking", "setOnStopTracking", "onStopTracking", "value", "d", TokenNames.I, "getChunkHeight", "()I", "setChunkHeight", "(I)V", "chunkHeight", "e", "getChunkWidth", "setChunkWidth", "chunkWidth", "f", "getChunkSpacing", "setChunkSpacing", "chunkSpacing", "g", "getChunkRadius", "setChunkRadius", "chunkRadius", "getMinChunkHeight", "setMinChunkHeight", "minChunkHeight", "getWaveColor", "setWaveColor", "waveColor", "j", TokenNames.F, "getProgress", "()F", "setProgress", "(F)V", "progress", "[B", "getScaledData", "()[B", "setScaledData", "([B)V", "scaledData", "", "l", "J", "getExpansionDuration", "()J", "setExpansionDuration", "(J)V", "expansionDuration", "Z", "()Z", "setExpansionAnimated", "(Z)V", "isExpansionAnimated", "n", "isTouchable", "setTouchable", "<set-?>", "o", "isTouched", "setTouched", "p", "initialDelay", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "q", "Landroid/animation/ValueAnimator;", "expansionAnimator", "Landroid/graphics/Paint;", "r", "Landroid/graphics/Paint;", "wavePaint", "s", "waveFilledPaint", "Landroid/graphics/Bitmap;", "t", "Landroid/graphics/Bitmap;", "waveBitmap", "u", "w", "v", "getChunkStep", "chunkStep", "getCenterY", "centerY", "getProgressFactor", "progressFactor", "Lir/nasim/QJ4;", "onProgressListener", "Lir/nasim/QJ4;", "getOnProgressListener", "()Lir/nasim/QJ4;", "setOnProgressListener", "(Lir/nasim/QJ4;)V", "getChunksCount", "chunksCount", "audiowave_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes8.dex */
public final class AudioWaveView extends View {

    /* renamed from: a, reason: from kotlin metadata */
    private InterfaceC14603iB2 onProgressChanged;

    /* renamed from: b, reason: from kotlin metadata */
    private UA2 onStartTracking;

    /* renamed from: c, reason: from kotlin metadata */
    private UA2 onStopTracking;

    /* renamed from: d, reason: from kotlin metadata */
    private int chunkHeight;

    /* renamed from: e, reason: from kotlin metadata */
    private int chunkWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private int chunkSpacing;

    /* renamed from: g, reason: from kotlin metadata */
    private int chunkRadius;

    /* renamed from: h, reason: from kotlin metadata */
    private int minChunkHeight;

    /* renamed from: i, reason: from kotlin metadata */
    private int waveColor;

    /* renamed from: j, reason: from kotlin metadata */
    private float progress;

    /* renamed from: k, reason: from kotlin metadata */
    private byte[] scaledData;

    /* renamed from: l, reason: from kotlin metadata */
    private long expansionDuration;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isExpansionAnimated;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isTouchable;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isTouched;

    /* renamed from: p, reason: from kotlin metadata */
    private final long initialDelay;

    /* renamed from: q, reason: from kotlin metadata */
    private final ValueAnimator expansionAnimator;

    /* renamed from: r, reason: from kotlin metadata */
    private Paint wavePaint;

    /* renamed from: s, reason: from kotlin metadata */
    private Paint waveFilledPaint;

    /* renamed from: t, reason: from kotlin metadata */
    private Bitmap waveBitmap;

    /* renamed from: u, reason: from kotlin metadata */
    private int w;

    /* renamed from: v, reason: from kotlin metadata */
    private int h;

    static final class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AudioWaveView audioWaveView = AudioWaveView.this;
            AbstractC13042fc3.e(valueAnimator, "it");
            AudioWaveView.l(audioWaveView, null, valueAnimator.getAnimatedFraction(), 1, null);
        }
    }

    static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AudioWaveView audioWaveView = AudioWaveView.this;
            AbstractC13042fc3.e(valueAnimator, "it");
            AudioWaveView.l(audioWaveView, null, valueAnimator.getAnimatedFraction(), 1, null);
        }
    }

    static final class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AudioWaveView audioWaveView = AudioWaveView.this;
            AbstractC13042fc3.e(valueAnimator, "it");
            AudioWaveView.l(audioWaveView, null, valueAnimator.getAnimatedFraction(), 1, null);
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        public final void a(float f, boolean z) {
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).floatValue(), ((Boolean) obj2).booleanValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final void a(float f) {
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        public final void a(float f) {
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC8614Ws3 implements SA2 {
        g(UJ4 uj4) {
            super(0);
        }

        public final void a() {
            throw null;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        public static final h e = new h();

        h() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class i implements Runnable {
        final /* synthetic */ byte[] b;
        final /* synthetic */ SA2 c;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            a() {
                super(1);
            }

            public final void a(byte[] bArr) {
                AbstractC13042fc3.j(bArr, "it");
                AudioWaveView.this.setScaledData(bArr);
                i.this.c.invoke();
                if (AudioWaveView.this.getIsExpansionAnimated()) {
                    AudioWaveView.this.h();
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((byte[]) obj);
                return C19938rB7.a;
            }
        }

        i(byte[] bArr, SA2 sa2) {
            this.b = bArr;
            this.c = sa2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C14845ia6.a.b(this.b, AudioWaveView.this.getChunksCount(), new a());
        }
    }

    public AudioWaveView(Context context) {
        super(context);
        this.onProgressChanged = d.e;
        this.onStartTracking = e.e;
        this.onStopTracking = f.e;
        this.chunkWidth = AbstractC20623sK2.b(this, 2);
        this.chunkSpacing = AbstractC20623sK2.b(this, 1);
        this.minChunkHeight = AbstractC20623sK2.b(this, 2);
        this.waveColor = -16777216;
        this.scaledData = new byte[0];
        this.expansionDuration = 400L;
        this.isExpansionAnimated = true;
        this.isTouchable = true;
        this.initialDelay = 50L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.expansionDuration);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new a());
        this.expansionAnimator = valueAnimatorOfFloat;
        this.wavePaint = AbstractC20623sK2.j(AbstractC20623sK2.k(this.waveColor, 170));
        this.waveFilledPaint = AbstractC20623sK2.d(this.waveColor);
        setWillNotDraw(false);
    }

    private final int getCenterY() {
        return this.h / 2;
    }

    private final int getChunkStep() {
        return this.chunkWidth + this.chunkSpacing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getProgressFactor() {
        return this.progress / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.expansionAnimator.start();
    }

    private final void i(AttributeSet attrs) {
        Context context = getContext();
        AbstractC13042fc3.e(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, PE5.AudioWaveView, 0, 0);
        if (typedArrayObtainStyledAttributes != null) {
            setChunkHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(PE5.AudioWaveView_chunkHeight, getChunkHeight()));
            setChunkWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(PE5.AudioWaveView_chunkWidth, this.chunkWidth));
            setChunkSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(PE5.AudioWaveView_chunkSpacing, this.chunkSpacing));
            setMinChunkHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(PE5.AudioWaveView_minChunkHeight, this.minChunkHeight));
            setChunkRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(PE5.AudioWaveView_chunkRadius, this.chunkRadius));
            this.isTouchable = typedArrayObtainStyledAttributes.getBoolean(PE5.AudioWaveView_touchable, this.isTouchable);
            setWaveColor(typedArrayObtainStyledAttributes.getColor(PE5.AudioWaveView_waveColor, this.waveColor));
            setProgress(typedArrayObtainStyledAttributes.getFloat(PE5.AudioWaveView_progress, this.progress));
            this.isExpansionAnimated = typedArrayObtainStyledAttributes.getBoolean(PE5.AudioWaveView_animateExpansion, this.isExpansionAnimated);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final void k(Canvas canvas, float factor) {
        Bitmap bitmap = this.waveBitmap;
        if (bitmap == null || canvas == null) {
            return;
        }
        AbstractC20623sK2.f(bitmap);
        int length = this.scaledData.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            int iMax = (int) ((Math.max((int) ((AbstractC15434ja6.a(r0[i2]) / 127) * getChunkHeight()), this.minChunkHeight) - this.minChunkHeight) * factor);
            RectF rectFH = AbstractC20623sK2.h((this.chunkSpacing / 2) + (getChunkStep() * i3), (getCenterY() - this.minChunkHeight) - iMax, (this.chunkSpacing / 2) + (i3 * getChunkStep()) + this.chunkWidth, getCenterY() + this.minChunkHeight + iMax);
            int i5 = this.chunkRadius;
            canvas.drawRoundRect(rectFH, i5, i5, this.wavePaint);
            i2++;
            i3 = i4;
        }
        postInvalidate();
    }

    static /* bridge */ /* synthetic */ void l(AudioWaveView audioWaveView, Canvas canvas, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            Bitmap bitmap = audioWaveView.waveBitmap;
            canvas = bitmap != null ? AbstractC20623sK2.g(bitmap) : null;
        }
        if ((i2 & 2) != 0) {
            f2 = 1.0f;
        }
        audioWaveView.k(canvas, f2);
    }

    private final float m(MotionEvent motionEvent) {
        return (AbstractC20623sK2.a(motionEvent.getX(), 0.0f, this.w) / this.w) * 100.0f;
    }

    public static /* bridge */ /* synthetic */ void setRawData$default(AudioWaveView audioWaveView, byte[] bArr, SA2 sa2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sa2 = h.e;
        }
        audioWaveView.setRawData(bArr, sa2);
    }

    private final void setTouched(boolean z) {
        this.isTouched = z;
    }

    public final int getChunkHeight() {
        int i2 = this.chunkHeight;
        return i2 == 0 ? this.h : Math.abs(i2);
    }

    public final int getChunkRadius() {
        return this.chunkRadius;
    }

    public final int getChunkSpacing() {
        return this.chunkSpacing;
    }

    public final int getChunkWidth() {
        return this.chunkWidth;
    }

    public final int getChunksCount() {
        return this.w / getChunkStep();
    }

    public final long getExpansionDuration() {
        return this.expansionDuration;
    }

    public final int getMinChunkHeight() {
        return this.minChunkHeight;
    }

    public final InterfaceC14603iB2 getOnProgressChanged() {
        return this.onProgressChanged;
    }

    public final QJ4 getOnProgressListener() {
        return null;
    }

    public final UA2 getOnStartTracking() {
        return this.onStartTracking;
    }

    public final UA2 getOnStopTracking() {
        return this.onStopTracking;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final byte[] getScaledData() {
        return this.scaledData;
    }

    public final int getWaveColor() {
        return this.waveColor;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsExpansionAnimated() {
        return this.isExpansionAnimated;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.save();
            canvas.clipRect(0, 0, this.w, this.h);
            canvas.drawBitmap(this.waveBitmap, 0.0f, 0.0f, this.wavePaint);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0.0f, 0.0f, this.w * getProgressFactor(), this.h);
            canvas.drawBitmap(this.waveBitmap, 0.0f, 0.0f, this.waveFilledPaint);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i2 = right - left;
        this.w = i2;
        int i3 = bottom - top;
        this.h = i3;
        if (!AbstractC20623sK2.e(this.waveBitmap, i2, i3) && changed) {
            AbstractC20623sK2.i(this.waveBitmap);
            this.waveBitmap = Bitmap.createBitmap(this.w, this.h, Bitmap.Config.ARGB_8888);
            byte[] bArr = this.scaledData;
            if (bArr.length == 0) {
                bArr = new byte[0];
            }
            setScaledData(bArr);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null) {
            return super.onTouchEvent(event);
        }
        if (!this.isTouchable || !isEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.isTouched = true;
            setProgress(m(event));
            this.onStartTracking.invoke(Float.valueOf(this.progress));
            return true;
        }
        if (action == 1) {
            this.isTouched = false;
            this.onStopTracking.invoke(Float.valueOf(this.progress));
            return false;
        }
        if (action != 2) {
            this.isTouched = false;
            return super.onTouchEvent(event);
        }
        this.isTouched = true;
        setProgress(m(event));
        return true;
    }

    public final void setChunkHeight(int i2) {
        this.chunkHeight = i2;
        l(this, null, 0.0f, 3, null);
    }

    public final void setChunkRadius(int i2) {
        this.chunkRadius = Math.abs(i2);
        l(this, null, 0.0f, 3, null);
    }

    public final void setChunkSpacing(int i2) {
        this.chunkSpacing = Math.abs(i2);
        l(this, null, 0.0f, 3, null);
    }

    public final void setChunkWidth(int i2) {
        this.chunkWidth = Math.abs(i2);
        l(this, null, 0.0f, 3, null);
    }

    public final void setExpansionAnimated(boolean z) {
        this.isExpansionAnimated = z;
    }

    public final void setExpansionDuration(long j) {
        this.expansionDuration = Math.max(400L, j);
        ValueAnimator valueAnimator = this.expansionAnimator;
        AbstractC13042fc3.e(valueAnimator, "expansionAnimator");
        valueAnimator.setDuration(this.expansionDuration);
    }

    public final void setMinChunkHeight(int i2) {
        this.minChunkHeight = Math.abs(i2);
        l(this, null, 0.0f, 3, null);
    }

    public final void setOnProgressChanged(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.j(interfaceC14603iB2, "<set-?>");
        this.onProgressChanged = interfaceC14603iB2;
    }

    public final void setOnStartTracking(UA2 ua2) {
        AbstractC13042fc3.j(ua2, "<set-?>");
        this.onStartTracking = ua2;
    }

    public final void setOnStopTracking(UA2 ua2) {
        AbstractC13042fc3.j(ua2, "<set-?>");
        this.onStopTracking = ua2;
    }

    public final void setProgress(float f2) {
        if (!AbstractC23053wG5.s(new C24411ya3(0, 100), f2)) {
            throw new IllegalArgumentException("Progress must be in 0..100".toString());
        }
        float fAbs = Math.abs(f2);
        this.progress = fAbs;
        this.onProgressChanged.invoke(Float.valueOf(fAbs), Boolean.valueOf(this.isTouched));
        postInvalidate();
    }

    public final void setRawData(byte[] bArr) {
        setRawData$default(this, bArr, null, 2, null);
    }

    public final void setScaledData(byte[] bArr) {
        AbstractC13042fc3.j(bArr, "value");
        if (bArr.length <= getChunksCount()) {
            bArr = AbstractC15434ja6.d(new byte[getChunksCount()], bArr);
        }
        this.scaledData = bArr;
        l(this, null, 0.0f, 3, null);
    }

    public final void setTouchable(boolean z) {
        this.isTouchable = z;
    }

    public final void setWaveColor(int i2) {
        this.wavePaint = AbstractC20623sK2.j(AbstractC20623sK2.k(i2, 170));
        this.waveFilledPaint = AbstractC20623sK2.d(i2);
        l(this, null, 0.0f, 3, null);
    }

    public final void setRawData(byte[] raw, UJ4 callback) {
        AbstractC13042fc3.j(raw, "raw");
        AbstractC13042fc3.j(callback, "callback");
        setRawData(raw, new g(callback));
    }

    public final void setRawData(byte[] raw, SA2 callback) {
        AbstractC13042fc3.j(raw, "raw");
        AbstractC13042fc3.j(callback, "callback");
        AbstractC15434ja6.b().postDelayed(new i(raw, callback), this.initialDelay);
    }

    public AudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onProgressChanged = d.e;
        this.onStartTracking = e.e;
        this.onStopTracking = f.e;
        this.chunkWidth = AbstractC20623sK2.b(this, 2);
        this.chunkSpacing = AbstractC20623sK2.b(this, 1);
        this.minChunkHeight = AbstractC20623sK2.b(this, 2);
        this.waveColor = -16777216;
        this.scaledData = new byte[0];
        this.expansionDuration = 400L;
        this.isExpansionAnimated = true;
        this.isTouchable = true;
        this.initialDelay = 50L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.expansionDuration);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new b());
        this.expansionAnimator = valueAnimatorOfFloat;
        this.wavePaint = AbstractC20623sK2.j(AbstractC20623sK2.k(this.waveColor, 170));
        this.waveFilledPaint = AbstractC20623sK2.d(this.waveColor);
        setWillNotDraw(false);
        i(attributeSet);
    }

    public final void setOnProgressListener(QJ4 qj4) {
    }

    public AudioWaveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.onProgressChanged = d.e;
        this.onStartTracking = e.e;
        this.onStopTracking = f.e;
        this.chunkWidth = AbstractC20623sK2.b(this, 2);
        this.chunkSpacing = AbstractC20623sK2.b(this, 1);
        this.minChunkHeight = AbstractC20623sK2.b(this, 2);
        this.waveColor = -16777216;
        this.scaledData = new byte[0];
        this.expansionDuration = 400L;
        this.isExpansionAnimated = true;
        this.isTouchable = true;
        this.initialDelay = 50L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.expansionDuration);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new c());
        this.expansionAnimator = valueAnimatorOfFloat;
        this.wavePaint = AbstractC20623sK2.j(AbstractC20623sK2.k(this.waveColor, 170));
        this.waveFilledPaint = AbstractC20623sK2.d(this.waveColor);
        setWillNotDraw(false);
        i(attributeSet);
    }
}
