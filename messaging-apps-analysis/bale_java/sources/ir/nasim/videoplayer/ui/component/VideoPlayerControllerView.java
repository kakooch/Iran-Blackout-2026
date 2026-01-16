package ir.nasim.videoplayer.ui.component;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.exoplayer2.E0;
import com.google.android.exoplayer2.z0;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC24778zB5;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C12372eV7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8792Xi5;
import ir.nasim.DY6;
import ir.nasim.ED1;
import ir.nasim.EnumC23696xM4;
import ir.nasim.EnumC9274Zf5;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.JF5;
import ir.nasim.L93;
import ir.nasim.NT7;
import ir.nasim.O98;
import ir.nasim.UA2;
import ir.nasim.XY6;
import ir.nasim.videoplayer.ui.component.VideoPlayerControllerView;
import ir.nasim.videoplayer.ui.component.seekbar.VideoPlayerSeekbar;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002`aB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u0013\u0010\u0019\u001a\u00020\u0018*\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b+\u0010&J\u0015\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00102\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b8\u00109J-\u0010>\u001a\u00020\u00102\u0006\u0010;\u001a\u00020:2\u0016\b\u0002\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0010\u0018\u00010<¢\u0006\u0004\b>\u0010?J-\u0010C\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010@2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100<H\u0007¢\u0006\u0004\bC\u0010DJ\u001d\u0010I\u001a\u00020\u00102\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JJ\u0015\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0010H\u0014¢\u0006\u0004\bO\u0010\u001cR\u0014\u0010R\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lir/nasim/videoplayer/ui/component/VideoPlayerControllerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/google/android/exoplayer2/z0$d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "o0", "()Z", "previewWidth", "Lir/nasim/rB7;", "s0", "(I)V", "topMargin", "setupTopMargin", "bottomMargin", "setupBottomMargin", "", "", "r0", "(J)Ljava/lang/String;", "onAttachedToWindow", "()V", "Landroid/view/View;", "child", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "measureChild", "(Landroid/view/View;II)V", "Landroid/widget/SeekBar;", "seekBar", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "progress", "fromUser", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStopTrackingTouch", "Lir/nasim/videoplayer/ui/component/VideoPlayerControllerView$b;", "type", "setContentType", "(Lir/nasim/videoplayer/ui/component/VideoPlayerControllerView$b;)V", "Lcom/google/android/exoplayer2/E0;", "player", "setPlayer", "(Lcom/google/android/exoplayer2/E0;)V", "Lir/nasim/eV7;", "videoSize", "l", "(Lir/nasim/eV7;)V", "setOnSeekbarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "Lir/nasim/xM4;", "orientation", "Lkotlin/Function1;", "onResizeButtonClicked", "j0", "(Lir/nasim/xM4;Lir/nasim/UA2;)V", "Landroid/text/Spannable;", "caption", "onUserIsInteractingWithCaption", "h0", "(Landroid/text/Spannable;Lir/nasim/UA2;)V", "Lir/nasim/Zf5;", "playbackSpeed", "Landroid/view/View$OnClickListener;", "onClick", "m0", "(Lir/nasim/Zf5;Landroid/view/View$OnClickListener;)V", "Lir/nasim/Xi5;", "positionState", "n0", "(Lir/nasim/Xi5;)V", "onDetachedFromWindow", "y", TokenNames.I, "horizontalPadding", "Landroid/graphics/Rect;", "z", "Landroid/graphics/Rect;", "systemBarInsets", "A", "Lir/nasim/eV7;", "lastAppliedVideoSize", "B", "Lcom/google/android/exoplayer2/E0;", "Lir/nasim/NT7;", "D", "Lir/nasim/NT7;", "binding", "b", "c", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class VideoPlayerControllerView extends ConstraintLayout implements SeekBar.OnSeekBarChangeListener, z0.d {

    /* renamed from: A, reason: from kotlin metadata */
    private C12372eV7 lastAppliedVideoSize;

    /* renamed from: B, reason: from kotlin metadata */
    private E0 player;

    /* renamed from: D, reason: from kotlin metadata */
    private final NT7 binding;

    /* renamed from: y, reason: from kotlin metadata */
    private final int horizontalPadding;

    /* renamed from: z, reason: from kotlin metadata */
    private Rect systemBarInsets;

    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), AbstractC8943Xx1.c(5));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("VIDEO", 0);
        public static final b b = new b("GIF", 1);
        public static final b c = new b("IMAGE", 2);
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }
    }

    private static final class c implements SeekBar.OnSeekBarChangeListener {
        private final SeekBar.OnSeekBarChangeListener a;
        private final SeekBar.OnSeekBarChangeListener b;

        public c(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2) {
            AbstractC13042fc3.i(onSeekBarChangeListener, "changeListener1");
            AbstractC13042fc3.i(onSeekBarChangeListener2, "changeListener2");
            this.a = onSeekBarChangeListener;
            this.b = onSeekBarChangeListener2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.a.onProgressChanged(seekBar, i, z);
            this.b.onProgressChanged(seekBar, i, z);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            this.a.onStartTrackingTouch(seekBar);
            this.b.onStartTrackingTouch(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.a.onStopTrackingTouch(seekBar);
            this.b.onStopTrackingTouch(seekBar);
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23696xM4.values().length];
            try {
                iArr[EnumC23696xM4.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23696xM4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        final /* synthetic */ NT7 a;
        final /* synthetic */ AppCompatTextView b;

        public e(NT7 nt7, AppCompatTextView appCompatTextView) {
            this.a = nt7;
            this.b = appCompatTextView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            this.a.d.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), 0);
            AppCompatTextView appCompatTextView = this.a.d;
            AbstractC13042fc3.f(appCompatTextView);
            ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = Math.min(AbstractC8943Xx1.c(160), appCompatTextView.getMeasuredHeight());
            appCompatTextView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams2.height = Math.min(AbstractC8943Xx1.c(160), this.b.getMeasuredHeight());
            view.setLayoutParams(layoutParams2);
        }
    }

    public static final class f implements View.OnLayoutChangeListener {
        final /* synthetic */ NT7 a;

        public f(NT7 nt7) {
            this.a = nt7;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            FrameLayout frameLayout = this.a.b;
            AbstractC13042fc3.h(frameLayout, "captionContainer");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = Math.min(AbstractC8943Xx1.c(160), view.getHeight());
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    public static final class g implements View.OnLayoutChangeListener {
        final /* synthetic */ NT7 a;

        public g(NT7 nt7) {
            this.a = nt7;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            FrameLayout frameLayout = this.a.b;
            AbstractC13042fc3.h(frameLayout, "captionContainer");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = Math.min(AbstractC8943Xx1.c(80), view.getHeight());
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayerControllerView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i0(UA2 ua2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(ua2, "$onUserIsInteractingWithCaption");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                }
            }
            ua2.invoke(Boolean.FALSE);
            return false;
        }
        ua2.invoke(Boolean.TRUE);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(UA2 ua2, View view) {
        ua2.invoke(view);
    }

    private final boolean o0() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 p0(VideoPlayerControllerView videoPlayerControllerView, View view, O98 o98) {
        AbstractC13042fc3.i(videoPlayerControllerView, "this$0");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.i());
        videoPlayerControllerView.systemBarInsets.set(l93F.a, l93F.b, l93F.c, l93F.d);
        AbstractC13042fc3.h(l93F, "also(...)");
        int i = videoPlayerControllerView.horizontalPadding;
        view.setPadding(l93F.a + i, view.getPaddingTop(), i + l93F.c, l93F.d);
        return O98.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(TextureView textureView) {
        AbstractC13042fc3.i(textureView, "$this_with");
        textureView.setVisibility(8);
    }

    private final String r0(long j) {
        String str;
        long j2 = j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        long j3 = 3600;
        long j4 = j2 / j3;
        long j5 = 60;
        long j6 = (j2 % j3) / j5;
        long j7 = j2 % j5;
        if (j4 > 0) {
            DY6 dy6 = DY6.a;
            str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j6), Long.valueOf(j7)}, 3));
            AbstractC13042fc3.h(str, "format(...)");
        } else {
            DY6 dy62 = DY6.a;
            str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j6), Long.valueOf(j7)}, 2));
            AbstractC13042fc3.h(str, "format(...)");
        }
        return XY6.v(str);
    }

    private final void s0(int previewWidth) {
        NT7 nt7 = this.binding;
        float f2 = previewWidth;
        float width = nt7.g.getWidth() - f2;
        if (width >= 0.0f) {
            nt7.h.setTranslationX(AbstractC23053wG5.l(nt7.g.getThumb().getBounds().right - (f2 / 2.0f), 0.0f, width));
        }
    }

    private final void setupBottomMargin(int bottomMargin) {
        VideoPlayerSeekbar videoPlayerSeekbar = this.binding.g;
        AbstractC13042fc3.h(videoPlayerSeekbar, "positionSeekbar");
        ViewGroup.LayoutParams layoutParams = videoPlayerSeekbar.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, bottomMargin);
        videoPlayerSeekbar.setLayoutParams(layoutParams2);
    }

    private final void setupTopMargin(int topMargin) {
        NT7 nt7 = this.binding;
        FrameLayout frameLayout = nt7.b;
        AbstractC13042fc3.h(frameLayout, "captionContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, topMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        frameLayout.setLayoutParams(layoutParams2);
        for (View view : AbstractC10360bX0.p(nt7.i, nt7.k, nt7.e)) {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.w = topMargin;
            view.setLayoutParams(layoutParams4);
        }
    }

    static /* synthetic */ void t0(VideoPlayerControllerView videoPlayerControllerView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = videoPlayerControllerView.binding.h.getWidth();
        }
        videoPlayerControllerView.s0(i);
    }

    public final void h0(Spannable caption, final UA2 onUserIsInteractingWithCaption) {
        AbstractC13042fc3.i(onUserIsInteractingWithCaption, "onUserIsInteractingWithCaption");
        AppCompatTextView appCompatTextView = this.binding.d;
        appCompatTextView.setText(caption, TextView.BufferType.SPANNABLE);
        FrameLayout frameLayout = this.binding.b;
        AbstractC13042fc3.h(frameLayout, "captionContainer");
        frameLayout.setVisibility((caption == null || AbstractC20762sZ6.n0(caption)) ^ true ? 0 : 8);
        NT7 nt7 = this.binding;
        FrameLayout frameLayout2 = nt7.b;
        AbstractC13042fc3.h(frameLayout2, "captionContainer");
        if (!frameLayout2.isLaidOut() || frameLayout2.isLayoutRequested()) {
            frameLayout2.addOnLayoutChangeListener(new e(nt7, appCompatTextView));
        } else {
            nt7.d.measure(View.MeasureSpec.makeMeasureSpec(frameLayout2.getWidth(), 1073741824), 0);
            AppCompatTextView appCompatTextView2 = nt7.d;
            AbstractC13042fc3.f(appCompatTextView2);
            ViewGroup.LayoutParams layoutParams = appCompatTextView2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = Math.min(AbstractC8943Xx1.c(160), appCompatTextView2.getMeasuredHeight());
            appCompatTextView2.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams2.height = Math.min(AbstractC8943Xx1.c(160), appCompatTextView.getMeasuredHeight());
            frameLayout2.setLayoutParams(layoutParams2);
        }
        appCompatTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.LT7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return VideoPlayerControllerView.i0(onUserIsInteractingWithCaption, view, motionEvent);
            }
        });
    }

    public final void j0(EnumC23696xM4 orientation, final UA2 onResizeButtonClicked) {
        AbstractC13042fc3.i(orientation, "orientation");
        NT7 nt7 = this.binding;
        int i = d.a[orientation.ordinal()];
        if (i == 1) {
            nt7.i.setImageResource(AbstractC24778zB5.icon_maximize_screen);
            AppCompatTextView appCompatTextView = nt7.d;
            AbstractC13042fc3.h(appCompatTextView, "captionTextView");
            if (!appCompatTextView.isLaidOut() || appCompatTextView.isLayoutRequested()) {
                appCompatTextView.addOnLayoutChangeListener(new f(nt7));
            } else {
                FrameLayout frameLayout = nt7.b;
                AbstractC13042fc3.h(frameLayout, "captionContainer");
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = Math.min(AbstractC8943Xx1.c(160), appCompatTextView.getHeight());
                frameLayout.setLayoutParams(layoutParams);
            }
            View root = nt7.getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            Rect rect = this.systemBarInsets;
            int i2 = rect.left;
            int i3 = this.horizontalPadding;
            root.setPadding(i2 + i3, root.getPaddingTop(), rect.right + i3, root.getPaddingBottom());
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            nt7.i.setImageResource(AbstractC24778zB5.icon_minimize_screen);
            AppCompatTextView appCompatTextView2 = nt7.d;
            AbstractC13042fc3.h(appCompatTextView2, "captionTextView");
            if (!appCompatTextView2.isLaidOut() || appCompatTextView2.isLayoutRequested()) {
                appCompatTextView2.addOnLayoutChangeListener(new g(nt7));
            } else {
                FrameLayout frameLayout2 = nt7.b;
                AbstractC13042fc3.h(frameLayout2, "captionContainer");
                ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams2.height = Math.min(AbstractC8943Xx1.c(80), appCompatTextView2.getHeight());
                frameLayout2.setLayoutParams(layoutParams2);
            }
            View root2 = nt7.getRoot();
            AbstractC13042fc3.h(root2, "getRoot(...)");
            Rect rect2 = this.systemBarInsets;
            int i4 = rect2.left;
            int i5 = this.horizontalPadding;
            root2.setPadding(i4 + i5, root2.getPaddingTop(), rect2.right + i5, root2.getPaddingBottom());
        }
        setupTopMargin(AbstractC8943Xx1.c(6));
        setupBottomMargin(AbstractC8943Xx1.c(20));
        nt7.i.setOnClickListener(onResizeButtonClicked != null ? new View.OnClickListener() { // from class: ir.nasim.MT7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerControllerView.k0(onResizeButtonClicked, view);
            }
        } : null);
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void l(C12372eV7 videoSize) {
        int iD;
        int iD2;
        int i;
        AbstractC13042fc3.i(videoSize, "videoSize");
        if (AbstractC13042fc3.d(videoSize, this.lastAppliedVideoSize)) {
            return;
        }
        int i2 = videoSize.b;
        Float fValueOf = Float.valueOf((i2 == 0 || (i = videoSize.a) == 0) ? 0.0f : (i * videoSize.d) / i2);
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        if (fValueOf != null) {
            float fFloatValue = fValueOf.floatValue();
            if (fFloatValue > 1.0f) {
                iD = AbstractC8943Xx1.c(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                iD2 = AbstractC20723sV3.d(fFloatValue * iD);
            } else {
                int iC = AbstractC8943Xx1.c(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                iD = AbstractC20723sV3.d(iC / fFloatValue);
                iD2 = iC;
            }
            TextureView textureView = this.binding.h;
            AbstractC13042fc3.h(textureView, "previewTextureView");
            ViewGroup.LayoutParams layoutParams = textureView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = iD2;
            layoutParams.height = iD;
            textureView.setLayoutParams(layoutParams);
            this.lastAppliedVideoSize = videoSize;
            s0(iD2);
        }
    }

    public final void m0(EnumC9274Zf5 playbackSpeed, View.OnClickListener onClick) {
        AbstractC13042fc3.i(playbackSpeed, "playbackSpeed");
        AbstractC13042fc3.i(onClick, "onClick");
        AppCompatImageView appCompatImageView = this.binding.k;
        appCompatImageView.setImageResource(playbackSpeed.p());
        appCompatImageView.setOnClickListener(onClick);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        AbstractC13042fc3.i(child, "child");
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
        TextView textView = this.binding.e;
        if (child == textView) {
            textView.setMinWidth(Math.max(textView.getMinWidth(), textView.getMeasuredWidth()));
        }
    }

    public final void n0(C8792Xi5 positionState) {
        String str;
        AbstractC13042fc3.i(positionState, "positionState");
        NT7 nt7 = this.binding;
        String strR0 = r0(positionState.a());
        String strR02 = r0(positionState.c());
        TextView textView = nt7.e;
        if (getLayoutDirection() == 0) {
            str = strR0 + " / " + strR02;
        } else {
            str = strR02 + " / " + strR0;
        }
        textView.setText(str);
        nt7.g.b(positionState);
        t0(this, 0, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC12990fW7.E0(this, new InterfaceC22474vI4() { // from class: ir.nasim.JT7
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return VideoPlayerControllerView.p0(this.a, view, o98);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        E0 e0 = this.player;
        if (e0 != null) {
            e0.o(this);
            e0.d0(this.binding.h);
            this.player = null;
        }
        AbstractC12990fW7.E0(this, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        AbstractC13042fc3.i(seekBar, "seekBar");
        if (fromUser) {
            t0(this, 0, 1, null);
            TextureView textureView = this.binding.h;
            AbstractC13042fc3.h(textureView, "previewTextureView");
            textureView.setVisibility(0);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        E0 e0;
        C12372eV7 c12372eV7E0;
        AbstractC13042fc3.i(seekBar, "seekBar");
        TextureView textureView = this.binding.h;
        if ((textureView.getWidth() == 0 || textureView.getHeight() == 0) && (e0 = this.player) != null && (c12372eV7E0 = e0.e0()) != null) {
            l(c12372eV7E0);
        }
        AbstractC13042fc3.f(textureView);
        textureView.setVisibility(0);
        t0(this, 0, 1, null);
        textureView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        AbstractC13042fc3.i(seekBar, "seekBar");
        final TextureView textureView = this.binding.h;
        t0(this, 0, 1, null);
        textureView.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).withEndAction(new Runnable() { // from class: ir.nasim.KT7
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayerControllerView.q0(textureView);
            }
        }).setDuration(200L);
    }

    public final void setContentType(b type) {
        AbstractC13042fc3.i(type, "type");
        Group group = this.binding.f;
        AbstractC13042fc3.h(group, "playerGroup");
        group.setVisibility(type == b.a ? 0 : 8);
    }

    public final void setOnSeekbarChangeListener(SeekBar.OnSeekBarChangeListener l) {
        this.binding.g.setOnSeekBarChangeListener(l != null ? new c(this, l) : this);
    }

    public final void setPlayer(E0 player) {
        E0 e0 = this.player;
        if (e0 != null) {
            e0.o(this);
            e0.d0(this.binding.h);
        }
        if (player != null) {
            C12372eV7 c12372eV7E0 = player.e0();
            AbstractC13042fc3.h(c12372eV7E0, "getVideoSize(...)");
            l(c12372eV7E0);
            player.m0(this);
            player.R(this.binding.h);
        } else {
            player = null;
        }
        this.player = player;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayerControllerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ VideoPlayerControllerView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.horizontalPadding = AbstractC8943Xx1.c(10);
        this.systemBarInsets = new Rect();
        NT7 nt7B = NT7.b(LayoutInflater.from(context), this);
        AbstractC13042fc3.h(nt7B, "inflate(...)");
        this.binding = nt7B;
        AppCompatTextView appCompatTextView = nt7B.d;
        appCompatTextView.setFocusable(true);
        appCompatTextView.setClickable(true);
        appCompatTextView.setLinksClickable(true);
        appCompatTextView.setTypeface(C6011Lu2.k());
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView = nt7B.e;
        textView.setTypeface(C6011Lu2.i());
        textView.setTextAlignment(JF5.g() ? 6 : 5);
        textView.setMinWidth(AbstractC20723sV3.d(textView.getPaint().measureText("99:99:99 / 99:99:99")));
        TextureView textureView = nt7B.h;
        textureView.setOutlineProvider(new a());
        textureView.setClipToOutline(true);
        AppCompatImageView appCompatImageView = nt7B.i;
        AbstractC13042fc3.h(appCompatImageView, "resizeImageButton");
        appCompatImageView.setVisibility(o0() ^ true ? 0 : 8);
        setClipChildren(false);
        setClipToPadding(false);
    }
}
