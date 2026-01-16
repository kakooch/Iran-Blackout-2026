package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC11436d03;
import ir.nasim.AbstractC11500d67;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC24131y57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C13010fZ0;
import ir.nasim.C16463lJ6;
import ir.nasim.C19526qV6;
import ir.nasim.C19938rB7;
import ir.nasim.C21447tg2;
import ir.nasim.C4278El2;
import ir.nasim.C4347Et;
import ir.nasim.C5579Jy1;
import ir.nasim.EnumC4024Dj0;
import ir.nasim.FH3;
import ir.nasim.InterfaceC13589gU6;
import ir.nasim.InterfaceC18899pR6;
import ir.nasim.InterfaceC19490qR6;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.O98;
import ir.nasim.QY0;
import ir.nasim.RunnableC16553lT6;
import ir.nasim.RunnableC20708sT6;
import ir.nasim.SA2;
import ir.nasim.TD5;
import ir.nasim.UA2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.messenger.camera.CameraView;
import ir.nasim.tgwidgets.editor.messenger.camera.a;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.SimpleTextView;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.Bulletin;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterBlurControl;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterCurvesControl;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayout;
import ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView;
import ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView;
import ir.nasim.tgwidgets.editor.ui.Components.ZoomControlView;
import ir.nasim.tgwidgets.editor.ui.Components.m;
import ir.nasim.tgwidgets.editor.ui.stories.RecordControl;
import ir.nasim.tgwidgets.editor.ui.stories.StoryWaveEffectView;
import ir.nasim.tgwidgets.editor.ui.stories.bale.views.StoryLinkCustomView;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.DownloadButton;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewButtons;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes7.dex */
public class StoryRecorder implements E.d {
    private static StoryRecorder h2;
    private boolean A;
    private FrameLayout A0;
    private boolean B;
    private FrameLayout B0;
    private FrameLayout C0;
    private boolean D;
    private FrameLayout D0;
    private FrameLayout E0;
    private StoryLinkCustomView F0;
    private float F1;
    private int G;
    private ImageView G0;
    private int H;
    private SimpleTextView H0;
    private boolean H1;
    private ImageView I0;
    private int J;
    private DualCameraView J0;
    private AnimatorSet J1;
    private int K0;
    private boolean K1;
    private ImageView L0;
    private ToggleButton M0;
    private Runnable M1;
    private VideoTimerView N0;
    private AnimatorSet N1;
    private boolean O0;
    private Runnable O1;
    private GalleryListView P0;
    private boolean P1;
    private DraftSavedHint Q0;
    private AnimatorSet Q1;
    private RecordControl R0;
    private ValueAnimator R1;
    private PhotoVideoSwitcherView S0;
    private HintTextView T0;
    private ZoomControlView U0;
    private Parcelable U1;
    private HintView2 V0;
    private MediaController.h V1;
    private PreviewView W0;
    private ValueAnimator W1;
    private FrameLayout X0;
    private C16463lJ6 X1;
    private int Y;
    private VideoTimelinePlayView Y0;
    private Boolean Y1;
    private VideoTimeView Z0;
    private Runnable Z1;
    private PreviewButtons a1;
    private AnimatorSet a2;
    private Activity b;
    private DownloadButton b1;
    private boolean b2;
    private int c;
    private RLottieDrawable c1;
    private u c2;
    private boolean d;
    private RLottieImageView d1;
    private boolean d2;
    private boolean e;
    private HintView2 e1;
    private Runnable e2;
    WindowManager f;
    private HintView2 f1;
    private boolean f2;
    private final WindowManager.LayoutParams g;
    private HintView2 g1;
    private boolean g2;
    private WindowView h;
    private PreviewHighlightView h1;
    private s i;
    private TrashView i1;
    private boolean j;
    private Bitmap j1;
    private ValueAnimator k;
    private PaintView k1;
    private float l;
    private View l1;
    private View m1;
    private float n;
    private View n1;
    private int o;
    private View o1;
    private float p;
    private View p1;
    private Float q;
    private Bitmap q1;
    private C19526qV6 r;
    private PhotoFilterView r1;
    private PhotoFilterView.EnhanceView s1;
    private StoryWaveEffectView t;
    private TextureView t1;
    private InterfaceC13589gU6 u;
    private PhotoFilterBlurControl u1;
    private PhotoFilterCurvesControl v1;
    private Runnable w;
    private File w1;
    private int x;
    private ir.nasim.tgwidgets.editor.ui.stories.recorder.l x1;
    private int y;
    private boolean y1;
    private int z;
    private boolean z1;
    private final m.h a = new C5579Jy1();
    private RectF m = new RectF();
    private C4347Et s = new C4347Et();
    private long v = 0;
    private int Z = 0;
    private int z0 = -1;
    private boolean A1 = false;
    private boolean B1 = false;
    private boolean C1 = false;
    private boolean D1 = false;
    private boolean E1 = false;
    private int G1 = -3;
    private final RecordControl.a I1 = new r();
    private boolean L1 = true;
    private boolean S1 = true;

    public class WindowView extends SizeNotifierFrameLayout {
        private ir.nasim.tgwidgets.editor.ui.Components.m Q0;
        private ScaleGestureDetector R0;
        private RectF S0;
        private RectF T0;
        private Path U0;
        private Rect V0;
        private boolean W0;
        private boolean X0;
        private float Y0;
        private float Z0;
        private float a1;
        private boolean b1;
        private boolean c1;

        private final class a extends m.c {
            @Override // ir.nasim.tgwidgets.editor.ui.Components.m.c
            public boolean a(MotionEvent motionEvent) {
                return (StoryRecorder.this.Z != 0 || StoryRecorder.this.J0 == null || StoryRecorder.this.E1 || !StoryRecorder.this.J0.r0() || StoryRecorder.this.B1 || StoryRecorder.this.R0.i() || StoryRecorder.this.J2() || StoryRecorder.this.Y1 != null) ? false : true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (StoryRecorder.this.J0 == null || StoryRecorder.this.E1 || StoryRecorder.this.B1 || !StoryRecorder.this.J0.r0() || StoryRecorder.this.Z != 0) {
                    return false;
                }
                StoryRecorder.this.J0.N0();
                StoryRecorder.this.R0.o(180.0f);
                StoryRecorder storyRecorder = StoryRecorder.this;
                storyRecorder.Y3(storyRecorder.J0.q0());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (StoryRecorder.this.J0 == null) {
                    return false;
                }
                StoryRecorder.this.J0.W0();
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                WindowView.this.Z0 = 0.0f;
                WindowView.this.a1 = 0.0f;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) throws Resources.NotFoundException {
                boolean z;
                if ((StoryRecorder.this.k != null && StoryRecorder.this.k.isRunning()) || StoryRecorder.this.R0.i() || ((StoryRecorder.this.J0 != null && StoryRecorder.this.J0.c1()) || WindowView.this.X0 || (StoryRecorder.this.U0 != null && StoryRecorder.this.U0.f()))) {
                    return false;
                }
                boolean z2 = true;
                WindowView.this.W0 = true;
                WindowView.this.b1 = true;
                if (StoryRecorder.this.B) {
                    if (Math.abs(StoryRecorder.this.i.a()) < AbstractC21455b.F(1.0f)) {
                        if (StoryRecorder.this.P0 != null) {
                            if (Math.abs(f2) <= 200.0f || (StoryRecorder.this.P0.d.canScrollVertically(-1) && StoryRecorder.this.O0)) {
                                StoryRecorder storyRecorder = StoryRecorder.this;
                                storyRecorder.L2(!storyRecorder.C1 && StoryRecorder.this.P0.getTranslationY() < ((float) StoryRecorder.this.P0.getPadding()));
                            } else {
                                StoryRecorder storyRecorder2 = StoryRecorder.this;
                                storyRecorder2.L2(!storyRecorder2.C1 && f2 < 0.0f);
                            }
                        }
                        z = false;
                    } else if ((f2 <= 0.0f || Math.abs(f2) <= 2000.0f || Math.abs(f2) <= Math.abs(f)) && StoryRecorder.this.p <= 0.4f) {
                        StoryRecorder.this.j2();
                    } else {
                        StoryRecorder.this.r2(true);
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (StoryRecorder.this.D) {
                    if (!StoryRecorder.this.S0.d(f) && !z) {
                        z2 = false;
                    }
                    z = z2;
                }
                StoryRecorder.this.B = false;
                StoryRecorder.this.D = false;
                return z;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onScroll(android.view.MotionEvent r4, android.view.MotionEvent r5, float r6, float r7) {
                /*
                    Method dump skipped, instructions count: 566
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder.WindowView.a.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (StoryRecorder.this.J0 == null) {
                    return false;
                }
                StoryRecorder.this.J0.U0();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) throws Resources.NotFoundException {
                StoryRecorder.this.B = false;
                StoryRecorder.this.D = false;
                if (!a(motionEvent) && onSingleTapConfirmed(motionEvent)) {
                    return true;
                }
                if (!StoryRecorder.this.J2() || motionEvent.getY() >= StoryRecorder.this.P0.A()) {
                    return false;
                }
                StoryRecorder.this.L2(false);
                return true;
            }

            private a() {
            }
        }

        private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (!WindowView.this.X0 || StoryRecorder.this.J0 == null || StoryRecorder.this.Z != 0 || StoryRecorder.this.J0.c1()) {
                    return false;
                }
                StoryRecorder.this.F1 += (scaleGestureDetector.getScaleFactor() - 1.0f) * 0.75f;
                StoryRecorder storyRecorder = StoryRecorder.this;
                storyRecorder.F1 = Utilities.c(storyRecorder.F1, 1.0f, 0.0f);
                StoryRecorder.this.J0.setZoom(StoryRecorder.this.F1);
                if (StoryRecorder.this.U0 != null) {
                    StoryRecorder.this.U0.setZoom(StoryRecorder.this.F1, false);
                }
                StoryRecorder.this.l4(true, true);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                if (StoryRecorder.this.J0 == null || StoryRecorder.this.Z != 0 || StoryRecorder.this.O0) {
                    return false;
                }
                WindowView.this.X0 = true;
                return super.onScaleBegin(scaleGestureDetector);
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) throws Resources.NotFoundException {
                WindowView.this.X0 = false;
                StoryRecorder.this.L2(false);
                StoryRecorder.this.j2();
                super.onScaleEnd(scaleGestureDetector);
            }

            private b() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public WindowView(Context context) {
            super(context);
            this.S0 = new RectF();
            this.T0 = new RectF();
            this.U0 = new Path();
            this.V0 = new Rect();
            this.X0 = false;
            this.b1 = true;
            this.Q0 = new ir.nasim.tgwidgets.editor.ui.Components.m(context, new a());
            this.R0 = new ScaleGestureDetector(context, new b());
        }

        public int P(boolean z) {
            return (getHeight() - StoryRecorder.this.i.getBottom()) + (z ? StoryRecorder.this.z : 0);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            boolean z;
            float fFloatValue = StoryRecorder.this.q != null ? StoryRecorder.this.q.floatValue() : StoryRecorder.this.p;
            if (StoryRecorder.this.o == 0) {
                canvas.drawColor(QY0.k(-16777216, (int) (StoryRecorder.this.n * 255.0f * (1.0f - fFloatValue))));
            }
            float fT0 = AbstractC21455b.T0(StoryRecorder.this.l, 0.0f, StoryRecorder.this.n);
            if (StoryRecorder.this.n != 1.0f) {
                z = true;
                if (StoryRecorder.this.o == 0) {
                    this.T0.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.T0.offset(StoryRecorder.this.i.getTranslationX(), StoryRecorder.this.i.getTranslationY());
                    AbstractC21455b.W0(StoryRecorder.this.m, this.T0, StoryRecorder.this.n, this.S0);
                    canvas.save();
                    this.U0.rewind();
                    this.U0.addRoundRect(this.S0, fT0, fT0, Path.Direction.CW);
                    canvas.clipPath(this.U0);
                    canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (Utilities.c(StoryRecorder.this.n * 3.0f, 1.0f, 0.0f) * 255.0f), 31);
                    RectF rectF = this.S0;
                    canvas.translate(rectF.left, rectF.top - (StoryRecorder.this.i.getTranslationY() * StoryRecorder.this.n));
                    float fMax = Math.max(this.S0.width() / getWidth(), this.S0.height() / getHeight());
                    canvas.scale(fMax, fMax);
                } else {
                    if (StoryRecorder.this.o == 1) {
                        this.T0.set(StoryRecorder.this.A0.getLeft(), StoryRecorder.this.A0.getTop(), StoryRecorder.this.A0.getMeasuredWidth(), StoryRecorder.this.A0.getMeasuredHeight());
                        this.T0.offset(StoryRecorder.this.i.getX(), StoryRecorder.this.i.getY());
                        AbstractC21455b.W0(StoryRecorder.this.m, this.T0, StoryRecorder.this.n, this.S0);
                        StoryRecorder.this.A0.setAlpha(StoryRecorder.this.n);
                        StoryRecorder.this.A0.setTranslationX((this.S0.left - StoryRecorder.this.A0.getLeft()) - StoryRecorder.this.i.getX());
                        StoryRecorder.this.A0.setTranslationY((this.S0.top - StoryRecorder.this.A0.getTop()) - StoryRecorder.this.i.getY());
                        StoryRecorder.p0(StoryRecorder.this);
                        StoryRecorder.this.A0.setScaleX(this.S0.width() / StoryRecorder.this.A0.getMeasuredWidth());
                        StoryRecorder.this.A0.setScaleY(this.S0.height() / StoryRecorder.this.A0.getMeasuredHeight());
                        StoryRecorder.this.B0.setAlpha(StoryRecorder.this.n);
                        StoryRecorder.this.C0.setAlpha(StoryRecorder.this.n);
                        StoryRecorder.this.D0.setAlpha(StoryRecorder.this.n);
                    }
                    z = false;
                }
            } else {
                z = false;
            }
            super.dispatchDraw(canvas);
            if (z) {
                canvas.restore();
                canvas.restore();
                StoryRecorder.p0(StoryRecorder.this);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) throws Resources.NotFoundException {
            if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            StoryRecorder.this.D3();
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
            this.W0 = false;
            this.R0.onTouchEvent(motionEvent);
            this.Q0.a(motionEvent);
            if (motionEvent.getAction() == 1 && !this.W0) {
                this.b1 = true;
                if (StoryRecorder.this.i.getTranslationY() > 0.0f) {
                    if (StoryRecorder.this.p > 0.4f) {
                        StoryRecorder.this.r2(true);
                    } else {
                        StoryRecorder.this.j2();
                    }
                } else if (StoryRecorder.this.P0 != null && StoryRecorder.this.P0.getTranslationY() > 0.0f) {
                    StoryRecorder storyRecorder = StoryRecorder.this;
                    storyRecorder.L2(!storyRecorder.C1 && StoryRecorder.this.P0.getTranslationY() < ((float) StoryRecorder.this.P0.getPadding()));
                }
                StoryRecorder.this.S0.d(0.0f);
                StoryRecorder.this.B = false;
                StoryRecorder.this.D = false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.ViewParent
        public int getLayoutDirection() {
            return 0;
        }

        public int getPaddingUnderContainer() {
            return (getHeight() - StoryRecorder.this.Y) - StoryRecorder.this.i.getBottom();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5;
            if (this.c1) {
                return;
            }
            int i6 = i3 - i;
            int i7 = i4 - i2;
            int i8 = StoryRecorder.this.H;
            int measuredHeight = StoryRecorder.this.E0.getMeasuredHeight();
            if (StoryRecorder.this.A) {
                i8 = 0;
            }
            int i9 = StoryRecorder.this.G + (((i6 - StoryRecorder.this.J) - StoryRecorder.this.x) / 2);
            int i10 = StoryRecorder.this.G + (((i6 - StoryRecorder.this.J) + StoryRecorder.this.x) / 2);
            if (StoryRecorder.this.A) {
                i5 = StoryRecorder.this.y;
            } else {
                int i11 = (((((i7 - i8) - StoryRecorder.this.Y) - StoryRecorder.this.y) - measuredHeight) / 2) + i8;
                if (StoryRecorder.this.o == 1 && StoryRecorder.this.m.top + StoryRecorder.this.y + measuredHeight < i7 - StoryRecorder.this.Y) {
                    i8 = (int) StoryRecorder.this.m.top;
                } else if (i11 - i8 >= AbstractC21455b.F(40.0f)) {
                    i8 = i11;
                }
                i5 = StoryRecorder.this.y;
            }
            StoryRecorder.this.i.layout(i9, i8, i10, i5 + i8 + measuredHeight);
            if (StoryRecorder.this.P0 != null) {
                StoryRecorder.this.P0.layout((i6 - StoryRecorder.this.P0.getMeasuredWidth()) / 2, 0, (StoryRecorder.this.P0.getMeasuredWidth() + i6) / 2, i7);
            }
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt instanceof DownloadButton.PreparingVideoToast) {
                    childAt.layout(0, 0, i6, i7);
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = (size - StoryRecorder.this.G) - StoryRecorder.this.J;
            int i4 = StoryRecorder.this.H;
            int i5 = StoryRecorder.this.Y;
            int iCeil = (int) Math.ceil((i3 / 9.0f) * 16.0f);
            StoryRecorder.this.z = AbstractC21455b.F(48.0f);
            int i6 = size2 - i5;
            if (StoryRecorder.this.z + iCeil <= i6) {
                StoryRecorder.this.x = i3;
                StoryRecorder.this.y = iCeil;
                StoryRecorder storyRecorder = StoryRecorder.this;
                storyRecorder.A = storyRecorder.y + StoryRecorder.this.z > i6 - i4;
            } else {
                StoryRecorder.this.A = false;
                StoryRecorder storyRecorder2 = StoryRecorder.this;
                storyRecorder2.y = ((size2 - storyRecorder2.z) - i5) - i4;
                StoryRecorder.this.x = (int) Math.ceil((r2.y * 9.0f) / 16.0f);
            }
            StoryRecorder storyRecorder3 = StoryRecorder.this;
            int i7 = size2 - storyRecorder3.y;
            if (StoryRecorder.this.A) {
                i4 = 0;
            }
            storyRecorder3.z = Utilities.d(i7 - i4, AbstractC21455b.F(68.0f), AbstractC21455b.F(48.0f));
            int systemUiVisibility = getSystemUiVisibility();
            setSystemUiVisibility(StoryRecorder.this.A ? systemUiVisibility | 4 : systemUiVisibility & (-5));
            StoryRecorder.this.i.measure(View.MeasureSpec.makeMeasureSpec(StoryRecorder.this.x, 1073741824), View.MeasureSpec.makeMeasureSpec(StoryRecorder.this.y + StoryRecorder.this.z, 1073741824));
            if (StoryRecorder.this.P0 != null) {
                StoryRecorder.this.P0.measure(View.MeasureSpec.makeMeasureSpec(StoryRecorder.this.x, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt = getChildAt(i8);
                if (childAt instanceof DownloadButton.PreparingVideoToast) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                }
            }
            setMeasuredDimension(size, size2);
        }
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                StoryRecorder.this.G0.setVisibility(8);
            }
            if (this.a || StoryRecorder.this.Z != 0) {
                StoryRecorder.this.L0.setVisibility(8);
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                StoryRecorder.this.U0.setVisibility(8);
            }
            StoryRecorder.this.N1 = null;
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StoryRecorder.this.F3(this.a, this.b);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StoryRecorder.this.R1 = null;
            StoryRecorder.this.i.setTranslationY(0.0f);
            StoryRecorder.this.i.d(0.0f);
        }
    }

    class e extends GalleryListView {
        e(int i, Context context, m.h hVar, MediaController.h hVar2, boolean z) {
            super(i, context, hVar, hVar2, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F() {
            StoryRecorder.this.x2(true);
            StoryRecorder.this.I0.setImageDrawable(StoryRecorder.this.D2());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.GalleryListView
        public void o() {
            StoryRecorder.this.P0.setTranslationY(StoryRecorder.this.h.getMeasuredHeight() - StoryRecorder.this.P0.A());
            if (StoryRecorder.this.Z1 != null) {
                StoryRecorder.this.Z1.run();
                StoryRecorder.this.Z1 = null;
            }
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (StoryRecorder.this.S1) {
                float fC = Utilities.c(1.0f - (f / (StoryRecorder.this.h.getMeasuredHeight() - StoryRecorder.this.P0.A())), 1.0f, 0.0f);
                StoryRecorder.this.i.d(AbstractC21455b.F(-32.0f) * fC);
                StoryRecorder.this.i.setAlpha(1.0f - (0.6f * fC));
                StoryRecorder.this.B0.setAlpha(1.0f - fC);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.GalleryListView
        protected void w(boolean z) {
            if (StoryRecorder.this.Z == 0 && z) {
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.F();
                    }
                });
            }
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StoryRecorder.this.h.removeView(StoryRecorder.this.P0);
            StoryRecorder.this.P0 = null;
            StoryRecorder.this.W1 = null;
            StoryRecorder.this.Y1 = null;
        }
    }

    class g extends AnimatorListenerAdapter {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        g(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StoryRecorder.this.O3(this.a, this.b);
        }
    }

    class h extends PaintView {
        h(Context context, WindowView windowView, Activity activity, int i, Bitmap bitmap, Bitmap bitmap2, int i2, ArrayList arrayList, int i3, int i4, MediaController.i iVar, Runnable runnable, m.h hVar) {
            super(context, windowView, activity, i, bitmap, bitmap2, i2, arrayList, i3, i4, iVar, runnable, hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o3() {
            StoryRecorder.this.i1.setVisibility(8);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView
        public void K1() {
            StoryRecorder.this.m4(-1, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView
        protected void M1() {
            StoryRecorder.this.m4(0, true);
            super.M1();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView
        protected void N2(boolean z) {
            if (StoryRecorder.this.W0 != null) {
                StoryRecorder.this.W0.O(6, z);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView, ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
        public void h(boolean z) {
            StoryRecorder.this.D0.clearAnimation();
            ViewPropertyAnimator duration = StoryRecorder.this.D0.animate().alpha(1.0f).setDuration(180L);
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.g;
            duration.setInterpolator(interpolatorC12631ew1).start();
            StoryRecorder.this.i1.a(false, z);
            StoryRecorder.this.i1.clearAnimation();
            StoryRecorder.this.i1.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.o3();
                }
            }).setDuration(180L).setInterpolator(interpolatorC12631ew1).setStartDelay(z ? 500L : 0L).start();
            if (z) {
                W2();
            }
            super.h(z);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
        public void l(boolean z) {
            StoryRecorder.this.i1.a(z, false);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
        public void s(boolean z) {
            StoryRecorder.this.h1.b(true, z, StoryRecorder.this.B0);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView, ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
        public void u() {
            StoryRecorder.this.D0.clearAnimation();
            ViewPropertyAnimator duration = StoryRecorder.this.D0.animate().alpha(0.0f).setDuration(180L);
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.g;
            duration.setInterpolator(interpolatorC12631ew1).start();
            StoryRecorder.this.i1.setVisibility(0);
            StoryRecorder.this.i1.setAlpha(0.0f);
            StoryRecorder.this.i1.clearAnimation();
            StoryRecorder.this.i1.animate().alpha(1.0f).setDuration(180L).setInterpolator(interpolatorC12631ew1).start();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
        public void z(boolean z) {
        }
    }

    class i extends DualCameraView {
        i(Context context, boolean z, boolean z2) {
            super(context, z, z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s1() {
            if (StoryRecorder.this.C1 || StoryRecorder.this.B1 || StoryRecorder.this.J0 == null || StoryRecorder.this.Z != 0 || StoryRecorder.this.g1 == null) {
                return;
            }
            String strC = FH3.C(q0() ? TD5.tgwidget_StoryCameraSavedDualBackHint : TD5.tgwidget_StoryCameraSavedDualFrontHint);
            StoryRecorder.this.g1.y(HintView2.i(strC, StoryRecorder.this.g1.getTextPaint()));
            StoryRecorder.this.g1.B(strC);
            StoryRecorder.this.g1.G();
            C.m().edit().putInt("storysvddualhint", C.m().getInt("storysvddualhint", 0) + 1).apply();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.DualCameraView, ir.nasim.tgwidgets.editor.messenger.camera.CameraView
        public void O0() {
            super.O0();
            StoryRecorder.this.M0.setValue(p0());
            StoryRecorder.this.b4((p0() || getCameraSession() == null || q0()) ? null : getCameraSession().r(), true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.DualCameraView
        public void j1(boolean z) {
            StoryRecorder.this.h1.b(false, z, StoryRecorder.this.C0);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.DualCameraView
        public void k1(boolean z) {
            StoryRecorder.this.h1.b(true, z, StoryRecorder.this.B0);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.DualCameraView
        protected void l1() {
            if (C.m().getInt("storysvddualhint", 0) < 2) {
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.s1();
                    }
                }, 340L);
            }
            StoryRecorder.this.M0.setValue(p0());
        }
    }

    class j extends AnimatorListenerAdapter {
        final /* synthetic */ float a;
        final /* synthetic */ Runnable b;

        j(float f, Runnable runnable) {
            this.a = f;
            this.b = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StoryRecorder.this.q = null;
            StoryRecorder.this.n = this.a;
            StoryRecorder.this.i.invalidate();
            StoryRecorder.this.h.invalidate();
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
            StoryRecorder.p0(StoryRecorder.this);
            StoryRecorder.this.s.b();
            E.j().s(E.e1, 512);
            E.j().v();
            StoryRecorder.this.q2();
        }
    }

    class k implements View.OnApplyWindowInsetsListener {
        k() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                Insets insets = windowInsets.getInsets(O98.m.c() | O98.m.i());
                StoryRecorder.this.H = insets.top;
                StoryRecorder.this.Y = insets.bottom;
                StoryRecorder.this.G = insets.left;
                StoryRecorder.this.J = insets.right;
            } else {
                StoryRecorder.this.H = windowInsets.getStableInsetTop();
                StoryRecorder.this.Y = windowInsets.getStableInsetBottom();
                StoryRecorder.this.G = windowInsets.getStableInsetLeft();
                StoryRecorder.this.J = windowInsets.getStableInsetRight();
            }
            StoryRecorder.this.h.requestLayout();
            return i >= 30 ? WindowInsets.CONSUMED : windowInsets.consumeSystemWindowInsets();
        }
    }

    class l extends FrameLayout {
        l(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (StoryRecorder.this.v1 != null) {
                StoryRecorder.this.v1.setActualArea(0.0f, 0.0f, StoryRecorder.this.v1.getMeasuredWidth(), StoryRecorder.this.v1.getMeasuredHeight());
            }
            if (StoryRecorder.this.u1 != null) {
                StoryRecorder.this.u1.setActualAreaSize(StoryRecorder.this.u1.getMeasuredWidth(), StoryRecorder.this.u1.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (StoryRecorder.this.c2 == null) {
                return super.onTouchEvent(motionEvent);
            }
            StoryRecorder.this.c2.c(motionEvent);
            return true;
        }
    }

    class m extends FrameLayout {
        m(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
        }
    }

    class n implements Bulletin.a {
        n() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.a
        public int b(int i) {
            return (int) (AbstractC21455b.F(56.0f) + (AbstractC21455b.F(46.0f) * StoryRecorder.this.d1.getAlpha()));
        }
    }

    class o extends ViewOutlineProvider {
        o() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), AbstractC21455b.F(12.0f));
        }
    }

    class p extends PreviewView {
        p(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R() {
            StoryRecorder.this.i1.setVisibility(8);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public void E(boolean z) {
            StoryRecorder.this.C0.clearAnimation();
            ViewPropertyAnimator duration = StoryRecorder.this.C0.animate().alpha(1.0f).setDuration(180L);
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.g;
            duration.setInterpolator(interpolatorC12631ew1).start();
            StoryRecorder.this.i1.a(false, z);
            StoryRecorder.this.i1.clearAnimation();
            StoryRecorder.this.i1.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.R();
                }
            }).setDuration(180L).setInterpolator(interpolatorC12631ew1).setStartDelay(z ? 500L : 0L).start();
            if (z) {
                u();
            }
            super.E(z);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public void F(AbstractC11436d03 abstractC11436d03) {
            StoryRecorder.this.C0.clearAnimation();
            ViewPropertyAnimator duration = StoryRecorder.this.C0.animate().alpha(0.0f).setDuration(180L);
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.g;
            duration.setInterpolator(interpolatorC12631ew1).start();
            if (abstractC11436d03.e) {
                StoryRecorder.this.i1.setVisibility(0);
                StoryRecorder.this.i1.setAlpha(0.0f);
                StoryRecorder.this.i1.clearAnimation();
                StoryRecorder.this.i1.animate().alpha(1.0f).setDuration(180L).setInterpolator(interpolatorC12631ew1).start();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public void G(boolean z) {
            StoryRecorder.this.i1.a(z, false);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public void H(boolean z) {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public void I(boolean z) {
            StoryRecorder.this.h1.b(true, z, StoryRecorder.this.B0);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        protected void J(boolean z, long j, boolean z2) {
            StoryRecorder.this.Z0.setTime(j, !z);
            StoryRecorder.this.Z0.a(!z2, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public boolean s(MotionEvent motionEvent) {
            return StoryRecorder.this.s1.c(motionEvent);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView
        public void t() {
            super.t();
            StoryRecorder.this.o2();
        }
    }

    class q implements InterfaceC18899pR6 {
        q() {
        }

        @Override // ir.nasim.InterfaceC18899pR6
        public void a() {
            StoryRecorder.this.u.g(StoryRecorder.this.x1.f);
        }

        @Override // ir.nasim.InterfaceC18899pR6
        public void edit() {
            StoryRecorder.this.u.f(StoryRecorder.this.x1.f);
        }

        @Override // ir.nasim.InterfaceC18899pR6
        public void remove() {
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = StoryRecorder.this.x1;
            InterfaceC19490qR6.a aVar = InterfaceC19490qR6.a.a;
            lVar.f = aVar;
            StoryRecorder.this.F0.p(aVar);
        }
    }

    class r implements RecordControl.a {
        r() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Integer num) throws Resources.NotFoundException {
            int i;
            StoryRecorder.this.B1 = false;
            if (StoryRecorder.this.w1 == null) {
                return;
            }
            int i2 = -1;
            int i3 = num.intValue() == -1 ? 0 : 90;
            if (num.intValue() == -1) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(StoryRecorder.this.w1.getAbsolutePath(), options);
                    i = options.outWidth;
                    try {
                        i2 = options.outHeight;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = -1;
                }
                if (i > i2) {
                    i3 = 270;
                }
            }
            StoryRecorder storyRecorder = StoryRecorder.this;
            storyRecorder.x1 = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.s(storyRecorder.w1, i3);
            StoryRecorder.this.y1 = false;
            StoryRecorder.this.z1 = true;
            StoryRecorder.this.B3(1, true);
            StoryRecorder.this.u.c(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q() {
            if (StoryRecorder.this.C1 && StoryRecorder.this.D1 && StoryRecorder.this.J0 != null) {
                StoryRecorder.this.l4(false, true);
                ir.nasim.tgwidgets.editor.messenger.camera.a.x().X(StoryRecorder.this.J0.getCameraSessionRecording(), false, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r() throws Resources.NotFoundException {
            StoryRecorder.this.B3(1, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(String str, long j) {
            if (StoryRecorder.this.R0 != null) {
                StoryRecorder.this.R0.u(true);
            }
            if (StoryRecorder.this.w1 == null || StoryRecorder.this.J0 == null) {
                return;
            }
            StoryRecorder.this.C1 = false;
            StoryRecorder.this.D1 = false;
            if (j > 800) {
                StoryRecorder.this.k4(false, true);
                StoryRecorder storyRecorder = StoryRecorder.this;
                storyRecorder.x1 = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.t(storyRecorder.w1, str, j, StoryRecorder.this.v);
                StoryRecorder.this.y1 = false;
                StoryRecorder.this.z1 = true;
                int videoWidth = StoryRecorder.this.J0.getVideoWidth();
                int videoHeight = StoryRecorder.this.J0.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    StoryRecorder.this.x1.b = videoWidth;
                    StoryRecorder.this.x1.c = videoHeight;
                    StoryRecorder.this.x1.K();
                }
                StoryRecorder.this.C3(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.u
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        this.a.r();
                    }
                }, 0L);
                StoryRecorder.this.u.c(true);
                return;
            }
            StoryRecorder.this.m2(false, true);
            StoryRecorder.this.a4(false);
            StoryRecorder.this.N0.setRecording(false, true);
            if (StoryRecorder.this.R0 != null) {
                StoryRecorder.this.R0.u(true);
            }
            try {
                StoryRecorder.this.w1.delete();
                StoryRecorder.this.w1 = null;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            if (str != null) {
                try {
                    new File(str).delete();
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(Runnable runnable, boolean z) {
            String str;
            int i;
            runnable.run();
            HintTextView hintTextView = StoryRecorder.this.T0;
            if (z) {
                str = "StoryHintSwipeToZoom";
                i = TD5.tgwidget_StoryHintSwipeToZoom;
            } else {
                str = "StoryHintPinchToZoom";
                i = TD5.tgwidget_StoryHintPinchToZoom;
            }
            hintTextView.setText(FH3.E(str, i), false);
            StoryRecorder.this.m2(true, true);
            StoryRecorder.this.a4(true);
            StoryRecorder.this.N0.setRecording(true, true);
            StoryRecorder.this.k4(true, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void a() {
            StoryRecorder.this.T0.setText(FH3.E("StoryHintPinchToZoom", TD5.tgwidget_StoryHintPinchToZoom), true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public boolean b() {
            return StoryRecorder.this.V3();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void c(boolean z) {
            if (StoryRecorder.this.D1 || !StoryRecorder.this.C1) {
                return;
            }
            StoryRecorder.this.D1 = true;
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q();
                }
            }, z ? 0L : 400L);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void d() {
            if (StoryRecorder.this.J0 != null) {
                StoryRecorder.this.J0.O0();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void e() throws Resources.NotFoundException {
            if (StoryRecorder.this.Z == 0 && StoryRecorder.this.X3()) {
                StoryRecorder.this.L2(true);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void f(long j) {
            StoryRecorder.this.N0.setDuration(j, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void g(final boolean z, final Runnable runnable) {
            if (StoryRecorder.this.C1 || StoryRecorder.this.D1 || StoryRecorder.this.E1 || StoryRecorder.this.Z != 0 || StoryRecorder.this.J0 == null || StoryRecorder.this.J0.getCameraSession() == null) {
                return;
            }
            if (StoryRecorder.this.f1 != null) {
                StoryRecorder.this.f1.k();
            }
            if (StoryRecorder.this.g1 != null) {
                StoryRecorder.this.g1.k();
            }
            StoryRecorder.this.V0.k();
            StoryRecorder.this.C1 = true;
            if (StoryRecorder.this.w1 != null) {
                try {
                    StoryRecorder.this.w1.delete();
                } catch (Exception unused) {
                }
                StoryRecorder.this.w1 = null;
            }
            StoryRecorder storyRecorder = StoryRecorder.this;
            storyRecorder.w1 = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.I(storyRecorder.c, true);
            ir.nasim.tgwidgets.editor.messenger.camera.a.x().U(StoryRecorder.this.J0.getCameraSession(), StoryRecorder.this.w1, false, new a.d() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.q
                @Override // ir.nasim.tgwidgets.editor.messenger.camera.a.d
                public final void a(String str, long j) {
                    this.a.s(str, j);
                }
            }, new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t(runnable, z);
                }
            }, StoryRecorder.this.J0, false);
            if (StoryRecorder.this.A1) {
                return;
            }
            StoryRecorder.this.A1 = true;
            StoryRecorder storyRecorder2 = StoryRecorder.this;
            storyRecorder2.k4(storyRecorder2.A1, true);
            StoryRecorder.this.S0.e(StoryRecorder.this.A1);
            StoryRecorder.this.R0.r(StoryRecorder.this.A1);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void h() {
            if (StoryRecorder.this.J0 == null || StoryRecorder.this.E1 || StoryRecorder.this.B1 || !StoryRecorder.this.J0.r0() || StoryRecorder.this.Z != 0) {
                return;
            }
            if (StoryRecorder.this.g1 != null) {
                StoryRecorder.this.g1.k();
            }
            StoryRecorder.this.J0.N0();
            StoryRecorder storyRecorder = StoryRecorder.this;
            storyRecorder.Y3(storyRecorder.J0.q0());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        public void i(float f) {
            StoryRecorder.this.U0.setZoom(f, true);
            StoryRecorder.this.l4(false, true);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
        @Override // ir.nasim.tgwidgets.editor.ui.stories.RecordControl.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void j() throws android.content.res.Resources.NotFoundException, java.io.IOException {
            /*
                Method dump skipped, instructions count: 294
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder.r.j():void");
        }
    }

    private class s extends FrameLayout {
        private float a;
        private float b;
        private final Paint c;
        private LinearGradient d;

        public s(Context context) {
            super(context);
            this.c = new Paint(1);
        }

        private void c(View view, int i, int i2) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        }

        public float a() {
            return this.a;
        }

        public float b() {
            return this.b;
        }

        public void d(float f) {
            float f2 = this.a;
            this.b = f;
            super.setTranslationY(f2 + f);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            boolean zDrawChild = super.drawChild(canvas, view, j);
            if (view == StoryRecorder.this.A0) {
                float f = StoryRecorder.this.A ? AbstractC21455b.d : 0.0f;
                if (this.d == null) {
                    LinearGradient linearGradient = new LinearGradient(0.0f, f, 0.0f, f + AbstractC21455b.F(72.0f), new int[]{1073741824, 0}, new float[]{f / (AbstractC21455b.F(72.0f) + f), 1.0f}, Shader.TileMode.CLAMP);
                    this.d = linearGradient;
                    this.c.setShader(linearGradient);
                }
                this.c.setAlpha((int) (StoryRecorder.this.n * 255.0f));
                canvas.drawRect(0.0f, 0.0f, getWidth(), AbstractC21455b.F(72.0f) + f, this.c);
            }
            return zDrawChild;
        }

        public void e() {
            if (StoryRecorder.this.o == 0) {
                setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(12.0f), -16777216));
            } else {
                setBackground(null);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = StoryRecorder.this.A ? StoryRecorder.this.H : 0;
            StoryRecorder.this.A0.layout(0, 0, StoryRecorder.this.x, StoryRecorder.this.y);
            StoryRecorder.this.A0.setPivotX(StoryRecorder.this.x * 0.5f);
            StoryRecorder.this.B0.layout(0, i5, StoryRecorder.this.x, StoryRecorder.this.B0.getMeasuredHeight() + i5);
            StoryRecorder.this.C0.layout(0, StoryRecorder.this.y - StoryRecorder.this.C0.getMeasuredHeight(), StoryRecorder.this.x, StoryRecorder.this.y);
            StoryRecorder.this.E0.layout(0, StoryRecorder.this.y, StoryRecorder.this.x, StoryRecorder.this.y + StoryRecorder.this.E0.getMeasuredHeight());
            StoryRecorder.this.D0.layout(0, 0, StoryRecorder.this.x, StoryRecorder.this.y);
            StoryRecorder.this.F0.layout(0, StoryRecorder.this.y - StoryLinkCustomView.INSTANCE.a(), StoryRecorder.this.x, StoryRecorder.this.y);
            if (StoryRecorder.this.r1 != null) {
                StoryRecorder.this.r1.layout(0, 0, StoryRecorder.this.r1.getMeasuredWidth(), StoryRecorder.this.r1.getMeasuredHeight());
            }
            if (StoryRecorder.this.k1 != null) {
                StoryRecorder.this.k1.layout(0, 0, StoryRecorder.this.k1.getMeasuredWidth(), StoryRecorder.this.k1.getMeasuredHeight());
            }
            setPivotX((i3 - i) / 2.0f);
            setPivotY((-(i4 - i2)) * 0.2f);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            c(StoryRecorder.this.A0, StoryRecorder.this.x, StoryRecorder.this.y);
            c(StoryRecorder.this.B0, StoryRecorder.this.x, AbstractC21455b.F(150.0f));
            c(StoryRecorder.this.C0, StoryRecorder.this.x, AbstractC21455b.F(220.0f));
            c(StoryRecorder.this.E0, StoryRecorder.this.x, StoryRecorder.this.z);
            c(StoryRecorder.this.D0, StoryRecorder.this.x, StoryRecorder.this.y);
            c(StoryRecorder.this.F0, StoryRecorder.this.x, StoryLinkCustomView.INSTANCE.a());
            if (StoryRecorder.this.r1 != null) {
                c(StoryRecorder.this.r1, size, size2);
            }
            if (StoryRecorder.this.k1 != null) {
                c(StoryRecorder.this.k1, size, size2);
            }
            setMeasuredDimension(size, size2);
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            this.a = f;
            super.setTranslationY(this.b + f);
            StoryRecorder.this.p = Utilities.c((f / getMeasuredHeight()) * 4.0f, 1.0f, 0.0f);
            StoryRecorder.this.q2();
            StoryRecorder.this.h.invalidate();
            float fC = 1.0f - (Utilities.c(getTranslationY() / AbstractC21455b.F(320.0f), 1.0f, 0.0f) * 0.1f);
            setScaleX(fC);
            setScaleY(fC);
        }
    }

    public static class t {
    }

    public interface u {
        boolean c(MotionEvent motionEvent);
    }

    public StoryRecorder(Activity activity, int i2) {
        this.b = activity;
        this.c = i2;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.g = layoutParams;
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.format = -3;
        layoutParams.gravity = 51;
        layoutParams.type = 99;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        layoutParams.flags = Integer.MIN_VALUE | 134283520;
        layoutParams.softInputMode = 16;
        this.f = (WindowManager) activity.getSystemService("window");
        I2();
    }

    private void A2() {
        PhotoFilterView photoFilterView = this.r1;
        if (photoFilterView == null) {
            return;
        }
        photoFilterView.z0();
        this.s1.setFilterView(null);
        this.i.removeView(this.r1);
        TextureView textureView = this.t1;
        if (textureView != null) {
            this.A0.removeView(textureView);
            this.t1 = null;
        }
        this.W0.setFilterTextureView(null);
        PhotoFilterBlurControl photoFilterBlurControl = this.u1;
        if (photoFilterBlurControl != null) {
            this.A0.removeView(photoFilterBlurControl);
            this.u1 = null;
        }
        PhotoFilterCurvesControl photoFilterCurvesControl = this.v1;
        if (photoFilterCurvesControl != null) {
            this.A0.removeView(photoFilterCurvesControl);
            this.v1 = null;
        }
        this.r1 = null;
        Bitmap bitmap = this.q1;
        if (bitmap != null) {
            bitmap.recycle();
            this.q1 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 A3(final boolean z, Boolean bool) {
        if (!bool.booleanValue()) {
            return C19938rB7.a;
        }
        this.x1 = null;
        this.j = true;
        this.g2 = true;
        q2();
        new Runnable() { // from class: ir.nasim.eT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z3(z);
            }
        }.run();
        C.m().edit().putInt("storyhint2", 2).apply();
        return C19938rB7.a;
    }

    private void B2() {
        PaintView paintView = this.k1;
        if (paintView == null) {
            return;
        }
        paintView.r();
        this.k1.shutdown();
        this.i.removeView(this.k1);
        Bitmap bitmap = this.j1;
        if (bitmap != null) {
            bitmap.recycle();
            this.j1 = null;
        }
        this.k1 = null;
        View view = this.l1;
        if (view != null) {
            this.A0.removeView(view);
            this.l1 = null;
        }
        View view2 = this.n1;
        if (view2 != null) {
            this.A0.removeView(view2);
            this.n1 = null;
        }
        View view3 = this.m1;
        if (view3 != null) {
            this.A0.removeView(view3);
            this.m1 = null;
        }
        View view4 = this.o1;
        if (view4 != null) {
            this.A0.removeView(view4);
            this.o1 = null;
        }
        View view5 = this.p1;
        if (view5 != null) {
            this.A0.removeView(view5);
            this.p1 = null;
        }
    }

    private boolean C2() {
        return C.m().getBoolean("stories_camera", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable D2() throws Resources.NotFoundException {
        Bitmap bitmapDecodeFile;
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(new File(AbstractC14047hG.b(), "cthumb.jpg").getAbsolutePath());
        } catch (Throwable unused) {
            bitmapDecodeFile = null;
        }
        return bitmapDecodeFile != null ? new BitmapDrawable(bitmapDecodeFile) : E2().getResources().getDrawable(AbstractC23598xB5.icplaceholder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E3() {
        this.d = false;
        AbstractC21455b.F1(this.b);
        if (this.J0 != null) {
            if (this.C1) {
                ir.nasim.tgwidgets.editor.messenger.camera.a.x().W(this.J0.getCameraSession(), false);
            }
            x2(false);
        }
        PreviewView previewView = this.W0;
        if (previewView != null) {
            previewView.set(null);
        }
        B2();
        A2();
        File file = this.w1;
        if (file != null && !this.j) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
        this.w1 = null;
        AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.zT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m3();
            }
        }, 16L);
        if (this.e2 != null) {
            this.e2 = null;
        }
        this.U1 = null;
        StoryRecorder storyRecorder = h2;
        if (storyRecorder != null) {
            storyRecorder.r2(false);
        }
        h2 = null;
        Runnable runnable = this.w;
        if (runnable != null) {
            runnable.run();
            this.w = null;
        }
        WindowView windowView = this.h;
        if (windowView != null) {
            Bulletin.l(windowView);
        }
    }

    private DraftSavedHint F2() {
        if (this.Q0 == null) {
            DraftSavedHint draftSavedHint = new DraftSavedHint(E2());
            this.Q0 = draftSavedHint;
            this.C0.addView(draftSavedHint, AbstractC13840gu3.c(-1, -2.0f, 87, 0.0f, 0.0f, 0.0f, 78.0f));
        }
        return this.Q0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3(int i2, int i3) {
        int i4;
        boolean z = false;
        int i5 = 8;
        if (i2 == 0) {
            x2(false);
            this.R0.setVisibility(8);
            this.U0.setVisibility(8);
            this.S0.setVisibility(8);
            this.M0.setVisibility(8);
            m2(false, false);
            a4(false);
        }
        this.I0.setClickable(i3 == 0);
        if (i2 == 1) {
            this.a1.setVisibility(8);
            this.W0.setVisibility(8);
            this.D0.setVisibility(8);
            this.d1.setVisibility(8);
            this.b1.setVisibility(8);
            this.W0.setVisibility(8);
            this.Y0.setVisibility(8);
            B2();
            A2();
            this.H0.setVisibility(8);
            y2();
            this.i1.setAlpha(0.0f);
            this.i1.setVisibility(8);
            this.Z0.setVisibility(8);
        }
        if (i3 == 1) {
            w2();
            H2();
            t2();
            this.W0.O(2, false);
            this.W0.O(3, false);
            this.W0.O(4, false);
            this.W0.O(5, false);
            VideoTimeView videoTimeView = this.Z0;
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
            if (lVar != null && lVar.y >= 30000) {
                i5 = 0;
            }
            videoTimeView.setVisibility(i5);
        }
        if (i3 == 0 && this.H1) {
            F2().setVisibility(0);
            F2().d();
            this.R0.v();
        }
        this.H1 = false;
        PhotoFilterView.EnhanceView enhanceView = this.s1;
        if (enhanceView != null) {
            if (i3 == 1 && ((i4 = this.z0) == -1 || i4 == 1)) {
                z = true;
            }
            enhanceView.setAllowTouch(z);
        }
    }

    public static StoryRecorder G2(Activity activity, int i2) {
        StoryRecorder storyRecorder = h2;
        if (storyRecorder != null && (storyRecorder.b != activity || storyRecorder.c != i2)) {
            storyRecorder.r2(false);
            h2 = null;
        }
        if (h2 == null) {
            h2 = new StoryRecorder(activity, i2);
        }
        return h2;
    }

    private void G3(int i2, int i3) throws Resources.NotFoundException {
        String str;
        int i4;
        VideoEditTextureView textureView;
        if (i3 == 0) {
            W3(false);
            this.R0.setVisibility(0);
            RecordControl recordControl = this.R0;
            if (recordControl != null) {
                recordControl.u(false);
            }
            this.S0.setVisibility(0);
            this.U0.setVisibility(0);
            this.U0.setAlpha(0.0f);
            this.N0.setDuration(0L, true);
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
            if (lVar != null) {
                lVar.p(false);
                this.x1 = null;
            }
        }
        if (i2 == 0) {
            b4(null, true);
            Z3(new Runnable() { // from class: ir.nasim.qT6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n3();
                }
            });
            DraftSavedHint draftSavedHint = this.Q0;
            if (draftSavedHint != null) {
                draftSavedHint.setVisibility(8);
            }
            this.V0.k();
            HintView2 hintView2 = this.f1;
            if (hintView2 != null) {
                hintView2.k();
            }
        }
        if (i3 == 1 || i2 == 1) {
            this.b1.setEntry(i3 == 1 ? this.x1 : null);
            if (this.A1) {
                this.d1.setVisibility(0);
                ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2 = this.x1;
                c4(lVar2 != null && lVar2.t, false);
                this.H0.setRightPadding(AbstractC21455b.F(96.0f));
            } else {
                this.H0.setRightPadding(AbstractC21455b.F(48.0f));
            }
            this.b1.setVisibility(0);
            this.a1.setVisibility(0);
            this.W0.setVisibility(0);
            this.D0.setVisibility(0);
            this.D0.clearFocus();
        }
        if (i3 == 1) {
            PreviewButtons previewButtons = this.a1;
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar3 = this.x1;
            if (lVar3 == null || !lVar3.l) {
                str = "Next";
                i4 = TD5.tgwidget_Next;
            } else {
                str = "Done";
                i4 = TD5.tgwidget_Done;
            }
            previewButtons.setShareText(FH3.E(str, i4));
            this.a1.setShareEnabled(true);
            if (!this.P1) {
                this.W0.set(this.x1);
            }
            this.P1 = false;
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar4 = this.x1;
            if (lVar4 != null && lVar4.j) {
                if (lVar4.K != null) {
                    B2();
                    w2();
                    H2();
                }
                if (this.x1.P != null) {
                    A2();
                    t2();
                }
                ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar5 = this.x1;
                if (lVar5.p && lVar5.P != null && (textureView = this.W0.getTextureView()) != null) {
                    textureView.setDelegate(new VideoEditTextureView.a() { // from class: ir.nasim.rT6
                        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView.a
                        public final void a(ir.nasim.tgwidgets.editor.ui.Components.k kVar) {
                            this.a.o3(kVar);
                        }
                    });
                }
            }
            RLottieImageView rLottieImageView = this.d1;
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar6 = this.x1;
            rLottieImageView.setImageResource((lVar6 == null || !lVar6.t) ? AbstractC23598xB5.media_mute : AbstractC23598xB5.media_unmute);
            this.W0.setVisibility(0);
            this.Y0.setVisibility(this.A1 ? 0 : 8);
            this.H0.setVisibility(0);
            SimpleTextView simpleTextView = this.H0;
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar7 = this.x1;
            simpleTextView.i(FH3.C((lVar7 == null || !lVar7.l) ? TD5.tgwidget_RecorderNewStory : TD5.tgwidget_RecorderEditStory));
        }
        if (i2 == 1) {
            this.e1.k();
        }
        PhotoFilterView.EnhanceView enhanceView = this.s1;
        if (enhanceView != null) {
            enhanceView.setAllowTouch(false);
        }
        this.I0.setClickable(false);
        HintView2 hintView22 = this.g1;
        if (hintView22 != null) {
            hintView22.k();
        }
    }

    private void H2() {
        PaintView paintView = this.k1;
        if (paintView == null) {
            return;
        }
        this.c2 = null;
        paintView.getTopLayout().setAlpha(0.0f);
        this.k1.getTopLayout().setTranslationY(-AbstractC21455b.F(16.0f));
        this.k1.getBottomLayout().setAlpha(0.0f);
        this.k1.getBottomLayout().setTranslationY(AbstractC21455b.F(48.0f));
        this.k1.getWeightChooserView().setTranslationX(-AbstractC21455b.F(32.0f));
        this.k1.setVisibility(8);
        this.k1.y1.h(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H3() throws Resources.NotFoundException {
        this.d = true;
        this.j = false;
        if (this.o == 1) {
            this.A0.setAlpha(1.0f);
            this.A0.setTranslationX(0.0f);
            this.A0.setTranslationY(0.0f);
            this.B0.setAlpha(1.0f);
            this.C0.setAlpha(1.0f);
            this.h.setBackgroundColor(-16777216);
        }
        Runnable runnable = this.e2;
        if (runnable == null) {
            N3();
        } else {
            runnable.run();
            this.e2 = null;
        }
    }

    private void I2() {
        Context contextE2 = E2();
        WindowView windowView = new WindowView(contextE2);
        this.h = windowView;
        windowView.setFitsSystemWindows(true);
        this.h.setOnApplyWindowInsetsListener(new k());
        this.h.setFocusable(true);
        WindowView windowView2 = this.h;
        s sVar = new s(contextE2);
        this.i = sVar;
        windowView2.addView(sVar);
        s sVar2 = this.i;
        l lVar = new l(contextE2);
        this.A0 = lVar;
        sVar2.addView(lVar);
        s sVar3 = this.i;
        FrameLayout frameLayout = new FrameLayout(contextE2);
        this.B0 = frameLayout;
        sVar3.addView(frameLayout);
        s sVar4 = this.i;
        FrameLayout frameLayout2 = new FrameLayout(contextE2);
        this.C0 = frameLayout2;
        sVar4.addView(frameLayout2);
        s sVar5 = this.i;
        m mVar = new m(contextE2);
        this.D0 = mVar;
        sVar5.addView(mVar);
        this.D0.setVisibility(8);
        this.D0.setAlpha(0.0f);
        s sVar6 = this.i;
        FrameLayout frameLayout3 = new FrameLayout(contextE2);
        this.E0 = frameLayout3;
        sVar6.addView(frameLayout3);
        Bulletin.a(this.h, new n());
        ImageView imageView = new ImageView(contextE2);
        this.I0 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.I0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.a.f3(view);
            }
        });
        this.I0.setClickable(true);
        this.A0.addView(this.I0, AbstractC13840gu3.d(-1, -1, 119));
        this.A0.setBackgroundColor(this.o == 1 ? 0 : -14737633);
        this.A0.setOutlineProvider(new o());
        this.A0.setClipToOutline(true);
        this.s1 = new PhotoFilterView.EnhanceView(contextE2, new Runnable() { // from class: ir.nasim.GT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t2();
            }
        });
        p pVar = new p(contextE2);
        this.W0 = pVar;
        pVar.setOnTapListener(new Runnable() { // from class: ir.nasim.HT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g3();
            }
        });
        this.W0.setVisibility(8);
        this.W0.P(new Runnable() { // from class: ir.nasim.IT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h3();
            }
        });
        this.A0.addView(this.W0, AbstractC13840gu3.d(-1, -1, 119));
        this.A0.addView(this.s1, AbstractC13840gu3.d(-1, -1, 119));
        VideoTimelinePlayView timelineView = this.W0.getTimelineView();
        this.Y0 = timelineView;
        timelineView.setVisibility(8);
        this.Y0.setAlpha(0.0f);
        FrameLayout frameLayout4 = new FrameLayout(contextE2);
        this.X0 = frameLayout4;
        frameLayout4.addView(this.Y0, AbstractC13840gu3.c(-1, 58.0f, 87, 0.0f, 0.0f, 0.0f, 0.0f));
        VideoTimeView videoTimeView = new VideoTimeView(contextE2);
        this.Z0 = videoTimeView;
        videoTimeView.setVisibility(8);
        this.Z0.a(false, false);
        this.X0.addView(this.Z0, AbstractC13840gu3.c(-1, 25.0f, 55, 0.0f, 0.0f, 0.0f, 0.0f));
        this.D0.addView(this.X0, AbstractC13840gu3.c(-1, 83.0f, 87, 0.0f, 0.0f, 0.0f, 64.0f));
        ImageView imageView2 = new ImageView(contextE2);
        this.G0 = imageView2;
        imageView2.setContentDescription(FH3.E("AccDescrGoBack", TD5.tgwidget_AccDescrGoBack));
        ImageView imageView3 = this.G0;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView3.setScaleType(scaleType);
        this.G0.setImageResource(AbstractC23598xB5.msg_photo_back);
        ImageView imageView4 = this.G0;
        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        imageView4.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.G0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(553648127));
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.a.i3(view);
            }
        });
        this.B0.addView(this.G0, AbstractC13840gu3.d(56, 56, 51));
        SimpleTextView simpleTextView = new SimpleTextView(contextE2);
        this.H0 = simpleTextView;
        simpleTextView.setTextSize(20);
        this.H0.setGravity(19);
        this.H0.setTextColor(-1);
        this.H0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.H0.i(FH3.E("RecorderNewStory", TD5.tgwidget_RecorderNewStory));
        this.H0.getPaint().setShadowLayer(AbstractC21455b.H(1.0f), 0.0f, 1.0f, 1073741824);
        this.H0.setAlpha(0.0f);
        this.H0.setVisibility(8);
        this.H0.setEllipsizeByGradient(true);
        this.H0.setRightPadding(AbstractC21455b.F(96.0f));
        this.B0.addView(this.H0, AbstractC13840gu3.c(-1, 56.0f, 55, 71.0f, 0.0f, 0.0f, 0.0f));
        DownloadButton downloadButton = new DownloadButton(contextE2, new Utilities.b() { // from class: ir.nasim.KT6
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.j3((Runnable) obj);
            }
        }, this.c, this.h, this.a);
        this.b1 = downloadButton;
        this.B0.addView(downloadButton, AbstractC13840gu3.d(56, 56, 53));
        HintView2 hintView2S = new HintView2(this.b, 1).w(1.0f, -68.0f).v(2000L).t(false).s(true, true, false);
        this.e1 = hintView2S;
        hintView2S.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.B0.addView(this.e1, AbstractC13840gu3.c(-1, -1.0f, 48, 0.0f, 52.0f, 0.0f, 0.0f));
        RLottieImageView rLottieImageView = new RLottieImageView(contextE2);
        this.d1 = rLottieImageView;
        rLottieImageView.setScaleType(scaleType);
        RLottieImageView rLottieImageView2 = this.d1;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2 = this.x1;
        rLottieImageView2.setImageResource((lVar2 == null || !lVar2.t) ? AbstractC23598xB5.media_mute : AbstractC23598xB5.media_unmute);
        this.d1.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.d1.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(553648127));
        this.d1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.MT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.k3(view);
            }
        });
        this.d1.setVisibility(8);
        this.d1.setAlpha(0.0f);
        this.B0.addView(this.d1, AbstractC13840gu3.c(56, 56.0f, 53, 0.0f, 0.0f, 48.0f, 0.0f));
        ImageView imageView5 = new ImageView(contextE2);
        this.L0 = imageView5;
        imageView5.setScaleType(scaleType);
        this.L0.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.L0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(553648127));
        this.L0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Y2(view);
            }
        });
        this.L0.setVisibility(8);
        this.L0.setAlpha(0.0f);
        this.B0.addView(this.L0, AbstractC13840gu3.d(56, 56, 53));
        ToggleButton toggleButton = new ToggleButton(contextE2, AbstractC23598xB5.media_dual_camera2_shadow, AbstractC23598xB5.media_dual_camera2);
        this.M0 = toggleButton;
        toggleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.OT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z2(view);
            }
        });
        this.M0.setVisibility(DualCameraView.Z0(contextE2) ? 0 : 8);
        this.B0.addView(this.M0, AbstractC13840gu3.d(56, 56, 53));
        HintView2 hintView2A = new HintView2(this.b, 1).w(1.0f, -20.0f).v(5000L).u(true).B(FH3.C(TD5.tgwidget_StoryCameraDualHint)).A(new Runnable() { // from class: ir.nasim.PT6
            @Override // java.lang.Runnable
            public final void run() {
                StoryRecorder.a3();
            }
        });
        this.f1 = hintView2A;
        hintView2A.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.B0.addView(this.f1, AbstractC13840gu3.c(-1, -1.0f, 48, 0.0f, 52.0f, 0.0f, 0.0f));
        HintView2 hintView2Z = new HintView2(this.b, 2).w(0.0f, 28.0f).v(5000L).z(true);
        this.g1 = hintView2Z;
        this.B0.addView(hintView2Z, AbstractC13840gu3.c(-1, -1.0f, 48, 0.0f, 0.0f, 52.0f, 0.0f));
        this.N0 = new VideoTimerView(contextE2);
        k4(false, false);
        this.B0.addView(this.N0, AbstractC13840gu3.c(-1, 45.0f, 55, 56.0f, 0.0f, 56.0f, 0.0f));
        MediaController.x0(0);
        RecordControl recordControl = new RecordControl(contextE2);
        this.R0 = recordControl;
        recordControl.setDelegate(this.I1);
        this.R0.r(this.A1);
        this.C0.addView(this.R0, AbstractC13840gu3.d(-1, 100, 87));
        HintView2 hintView2D = new HintView2(this.b, 3).z(true).B(FH3.C(TD5.tgwidget_StoryCameraHint2)).x(320.0f).v(5000L).D(Layout.Alignment.ALIGN_CENTER);
        this.V0 = hintView2D;
        this.C0.addView(hintView2D, AbstractC13840gu3.c(-1, -1.0f, 80, 0.0f, 0.0f, 0.0f, 100.0f));
        ZoomControlView zoomControlView = new ZoomControlView(contextE2);
        this.U0 = zoomControlView;
        zoomControlView.w = false;
        zoomControlView.setAlpha(0.0f);
        this.C0.addView(this.U0, AbstractC13840gu3.c(-1, 50.0f, 81, 0.0f, 0.0f, 0.0f, 108.0f));
        this.U0.setDelegate(new ZoomControlView.c() { // from class: ir.nasim.CT6
            @Override // ir.nasim.tgwidgets.editor.ui.Components.ZoomControlView.c
            public final void a(float f2) {
                this.a.b3(f2);
            }
        });
        ZoomControlView zoomControlView2 = this.U0;
        this.F1 = 0.0f;
        zoomControlView2.setZoom(0.0f, false);
        PhotoVideoSwitcherView photoVideoSwitcherView = new PhotoVideoSwitcherView(contextE2);
        this.S0 = photoVideoSwitcherView;
        photoVideoSwitcherView.setOnSwitchModeListener(new Utilities.b() { // from class: ir.nasim.DT6
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.c3((Boolean) obj);
            }
        });
        this.S0.setOnSwitchingModeListener(new Utilities.b() { // from class: ir.nasim.ET6
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.d3((Float) obj);
            }
        });
        this.E0.addView(this.S0, AbstractC13840gu3.d(-1, -1, 87));
        HintTextView hintTextView = new HintTextView(contextE2);
        this.T0 = hintTextView;
        this.E0.addView(hintTextView, AbstractC13840gu3.c(-1, 32.0f, 17, 8.0f, 0.0f, 8.0f, 8.0f));
        PreviewButtons previewButtons = new PreviewButtons(contextE2);
        this.a1 = previewButtons;
        previewButtons.setVisibility(8);
        this.a1.setOnClickListener(new Utilities.b() { // from class: ir.nasim.FT6
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.e3((Integer) obj);
            }
        });
        this.E0.addView(this.a1, AbstractC13840gu3.d(-1, AbstractC21455b.F(116.0f), 23));
        StoryLinkCustomView storyLinkCustomView = new StoryLinkCustomView(contextE2);
        this.F0 = storyLinkCustomView;
        storyLinkCustomView.setVisibility(8);
        this.F0.setEditable(true);
        this.F0.setListener(new q());
        this.i.addView(this.F0, AbstractC13840gu3.d(-1, StoryLinkCustomView.INSTANCE.a(), 55));
        TrashView trashView = new TrashView(contextE2);
        this.i1 = trashView;
        trashView.setAlpha(0.0f);
        this.i1.setVisibility(8);
        this.A0.addView(this.i1, AbstractC13840gu3.c(-1, 120.0f, 81, 0.0f, 0.0f, 0.0f, 16.0f));
        PreviewHighlightView previewHighlightView = new PreviewHighlightView(contextE2, this.c, this.a);
        this.h1 = previewHighlightView;
        this.A0.addView(previewHighlightView, AbstractC13840gu3.d(-1, -1, 119));
    }

    public static void I3() {
        StoryRecorder storyRecorder = h2;
        if (storyRecorder != null) {
            storyRecorder.J3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J2() {
        GalleryListView galleryListView;
        return (this.B || (galleryListView = this.P0) == null || galleryListView.getTranslationY() >= ((float) ((this.h.getMeasuredHeight() - ((int) (((float) AbstractC21455b.h.y) * 0.35f))) - (AbstractC21455b.d + ActionBar.getCurrentActionBarHeight())))) ? false : true;
    }

    private void J3() {
        x2(false);
        PreviewView previewView = this.W0;
        if (previewView != null) {
            previewView.O(0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(float f2, float f3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.i.setTranslationY(f2 * fFloatValue);
        this.i.d(f3 * fFloatValue);
    }

    public static void K3(int i2, String[] strArr, int[] iArr) throws Resources.NotFoundException {
        StoryRecorder storyRecorder = h2;
        if (storyRecorder != null) {
            storyRecorder.L3(i2, strArr, iArr);
        }
    }

    private void L3(int i2, String[] strArr, int[] iArr) throws Resources.NotFoundException {
        boolean z = iArr != null && iArr.length == 1 && iArr[0] == 0;
        if (i2 == 111) {
            this.b2 = !z;
            if (z && this.Z == 0) {
                this.I0.setImageDrawable(null);
                if (ir.nasim.tgwidgets.editor.messenger.camera.a.x().B()) {
                    s2();
                    return;
                } else {
                    ir.nasim.tgwidgets.editor.messenger.camera.a.x().z(new RunnableC16553lT6(this));
                    return;
                }
            }
            return;
        }
        if (i2 == 114) {
            if (z) {
                MediaController.x0(0);
                L2(true);
                return;
            }
            return;
        }
        if (i2 != 112 || z) {
            return;
        }
        new AlertDialog.i(E2()).k(AbstractC19363qD5.permission_request_camera, 72, false, ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.x4)).e(AbstractC21455b.k1(FH3.E("PermissionNoCameraMicVideo", TD5.tgwidget_PermissionNoCameraMicVideo))).i(FH3.E("PermissionOpenSettings", TD5.tgwidget_PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.nasim.yT6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.a.p3(dialogInterface, i3);
            }
        }).f(FH3.E("ContactsPermissionAlertNotNow", TD5.tgwidget_ContactsPermissionAlertNotNow), null).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(float f2, AbstractC12098e22 abstractC12098e22, boolean z, float f3, float f4) {
        if (z) {
            return;
        }
        this.P0.setTranslationY(f2);
        this.P0.l = false;
        this.X1 = null;
        this.Y1 = null;
    }

    public static void M3() throws Resources.NotFoundException {
        StoryRecorder storyRecorder = h2;
        if (storyRecorder != null) {
            storyRecorder.N3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N2(ValueAnimator valueAnimator) {
        this.P0.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void N3() throws Resources.NotFoundException {
        if (this.Z == 0) {
            ValueAnimator valueAnimator = this.k;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                W3(false);
            } else {
                this.e2 = new Runnable() { // from class: ir.nasim.jT6
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        this.a.q3();
                    }
                };
            }
        }
        RecordControl recordControl = this.R0;
        if (recordControl != null) {
            recordControl.v();
        }
        PreviewHighlightView previewHighlightView = this.h1;
        if (previewHighlightView != null) {
            previewHighlightView.c();
        }
        PaintView paintView = this.k1;
        if (paintView != null) {
            paintView.O2();
        }
        PreviewView previewView = this.W0;
        if (previewView != null) {
            previewView.O(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O2(ValueAnimator valueAnimator) {
        StoryWaveEffectView storyWaveEffectView;
        this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        q2();
        this.i.invalidate();
        this.h.invalidate();
        if (this.n >= 0.3f || (storyWaveEffectView = this.t) == null) {
            return;
        }
        storyWaveEffectView.j();
        this.t = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O3(int i2, int i3) {
        PaintView paintView;
        PaintView paintView2;
        boolean z = true;
        if (i2 == 1 && i3 == -1) {
            A2();
        }
        if (i3 == 0) {
            this.G0.setVisibility(8);
        }
        if (i2 == 0 && (paintView2 = this.k1) != null) {
            paintView2.setVisibility(8);
        }
        if (i2 == -1) {
            this.D0.setVisibility(8);
            this.d1.setVisibility(8);
            this.b1.setVisibility(8);
            this.Y0.setVisibility(8);
            this.H0.setVisibility(8);
        }
        this.W0.setAllowCropping(i3 == -1);
        if ((i3 == 0 || i2 == 0) && (paintView = this.k1) != null) {
            paintView.m(false);
        }
        PhotoFilterView.EnhanceView enhanceView = this.s1;
        if (enhanceView != null) {
            if (i3 != 1 && i3 != -1) {
                z = false;
            }
            enhanceView.setAllowTouch(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P2() {
        String strR = this.J0.getCameraSession().r();
        if (TextUtils.equals(strR, this.J0.getCameraSession().v())) {
            strR = null;
        }
        b4(this.Z == 0 ? strR : null, true);
        ZoomControlView zoomControlView = this.U0;
        if (zoomControlView != null) {
            this.F1 = 0.0f;
            zoomControlView.setZoom(0.0f, false);
        }
    }

    private void P3(int i2, int i3) {
        PaintView paintView;
        PaintView paintView2;
        if (i3 == -1) {
            this.G0.setVisibility(0);
            this.D0.setVisibility(0);
            PaintView paintView3 = this.k1;
            if (paintView3 != null) {
                paintView3.E1();
            }
            this.b1.setVisibility(0);
            this.H0.setVisibility(0);
            if (this.A1) {
                this.d1.setVisibility(0);
            }
            this.Y0.setVisibility(0);
        }
        if (i3 == 0 && (paintView2 = this.k1) != null) {
            paintView2.setVisibility(0);
        }
        if ((i3 == 0 || i2 == 0) && (paintView = this.k1) != null) {
            paintView.m(true);
        }
        PaintView paintView4 = this.k1;
        if (paintView4 != null) {
            paintView4.y1.h(i3 != 0);
        }
        if (this.r1 != null && i3 == 1) {
            n2(null);
        }
        PhotoFilterView.EnhanceView enhanceView = this.s1;
        if (enhanceView != null) {
            enhanceView.setAllowTouch(false);
        }
        this.e1.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(View view) {
        n2(null);
        m4(-1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(View view) {
        m4(-1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2() throws Resources.NotFoundException {
        L2(false);
        this.V1 = null;
    }

    private void S3() {
        View view = this.l1;
        if (view != null) {
            view.bringToFront();
        }
        View view2 = this.m1;
        if (view2 != null) {
            view2.bringToFront();
        }
        View view3 = this.n1;
        if (view3 != null) {
            view3.bringToFront();
        }
        View view4 = this.o1;
        if (view4 != null) {
            view4.bringToFront();
        }
        View view5 = this.p1;
        if (view5 != null) {
            view5.bringToFront();
        }
        TrashView trashView = this.i1;
        if (trashView != null) {
            trashView.bringToFront();
        }
        PhotoFilterView.EnhanceView enhanceView = this.s1;
        if (enhanceView != null) {
            enhanceView.bringToFront();
        }
        PhotoFilterBlurControl photoFilterBlurControl = this.u1;
        if (photoFilterBlurControl != null) {
            photoFilterBlurControl.bringToFront();
        }
        PhotoFilterCurvesControl photoFilterCurvesControl = this.v1;
        if (photoFilterCurvesControl != null) {
            photoFilterCurvesControl.bringToFront();
        }
        PreviewHighlightView previewHighlightView = this.h1;
        if (previewHighlightView != null) {
            previewHighlightView.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T2(boolean z, Object obj, Bitmap bitmap) throws Resources.NotFoundException {
        if (obj == null || this.Y1 != null || this.B || !J2()) {
            return;
        }
        if (!z) {
            if (obj instanceof MediaController.m) {
                MediaController.m mVar = (MediaController.m) obj;
                this.A1 = mVar.D;
                ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVarR = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.r(mVar, this.v);
                this.x1 = lVarR;
                lVarR.H = bitmap;
                this.y1 = true;
                this.z1 = false;
            } else if (obj instanceof ir.nasim.tgwidgets.editor.ui.stories.recorder.l) {
                ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = (ir.nasim.tgwidgets.editor.ui.stories.recorder.l) obj;
                if (lVar.q == null) {
                    this.b1.w(AbstractC19363qD5.error, "Failed to load draft");
                    return;
                }
                this.A1 = lVar.p;
                this.x1 = lVar;
                lVar.H = bitmap;
                this.y1 = false;
                this.z1 = false;
            }
            k4(false, true);
            this.S0.e(this.A1);
            this.R0.r(this.A1);
            L2(false);
            B3(1, true);
        } else {
            if (this.x1 == null || !(obj instanceof MediaController.m)) {
                return;
            }
            w2();
            this.x1.n = true;
            PaintView paintView = this.k1;
            paintView.x1(paintView.F1(((MediaController.m) obj).A, false));
            L2(false);
        }
        GalleryListView galleryListView = this.P0;
        if (galleryListView != null) {
            this.U1 = galleryListView.e.g1();
            this.V1 = this.P0.getSelectedAlbum();
        }
    }

    private File T3(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, boolean z) {
        if (lVar == null || this.W0.getWidth() <= 0 || this.W0.getHeight() <= 0) {
            return null;
        }
        if (!z && !lVar.O() && !lVar.l) {
            return null;
        }
        File file = z ? lVar.J : lVar.I;
        if (file != null) {
            file.delete();
        }
        float f2 = z ? 0.33333334f : 1.0f;
        int width = (int) (this.W0.getWidth() * f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, (int) (this.W0.getHeight() * f2), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.scale(f2, f2);
        this.W0.draw(canvas);
        canvas.restore();
        Paint paint = new Paint(2);
        VideoEditTextureView textureView = this.W0.getTextureView();
        if (lVar.p && textureView != null) {
            Bitmap bitmap = textureView.getBitmap();
            Matrix transform = textureView.getTransform(null);
            if (transform != null) {
                Matrix matrix = new Matrix(transform);
                matrix.postScale(f2, f2);
                transform = matrix;
            }
            canvas.drawBitmap(bitmap, transform, paint);
            bitmap.recycle();
        }
        File file2 = lVar.K;
        if (file2 != null) {
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file2.getPath());
                canvas.save();
                float width2 = width / bitmapDecodeFile.getWidth();
                canvas.scale(width2, width2);
                canvas.drawBitmap(bitmapDecodeFile, 0.0f, 0.0f, paint);
                canvas.restore();
                bitmapDecodeFile.recycle();
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
        }
        PaintView paintView = this.k1;
        if (paintView != null && paintView.H != null) {
            canvas.save();
            canvas.scale(f2, f2);
            this.k1.H.draw(canvas);
            canvas.restore();
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 40, 22, true);
        File fileI = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.I(this.c, false);
        try {
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, z ? 95 : 75, new FileOutputStream(fileI));
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        bitmapCreateBitmap.recycle();
        if (z) {
            lVar.J = fileI;
        } else {
            lVar.I = fileI;
        }
        lVar.Q = bitmapCreateScaledBitmap;
        return fileI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2() {
        m4(-1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V2() {
        m4(-1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V3() {
        Activity activity = this.b;
        if (activity == null || activity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            return true;
        }
        this.u.i(new String[]{"android.permission.RECORD_AUDIO"}, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W2() {
        this.I0.setImageDrawable(D2());
        DualCameraView dualCameraView = this.J0;
        if (dualCameraView != null) {
            dualCameraView.h0(true, null);
            this.A0.removeView(this.J0);
            this.J0 = null;
        }
    }

    private void W3(boolean z) throws Resources.NotFoundException {
        if (!this.d2 || z) {
            this.b2 = false;
            Activity activity = this.b;
            if (activity != null) {
                boolean z2 = activity.checkSelfPermission("android.permission.CAMERA") != 0;
                this.b2 = z2;
                if (z2) {
                    Drawable drawableMutate = E2().getResources().getDrawable(AbstractC23598xB5.story_camera).mutate();
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(1040187391, PorterDuff.Mode.MULTIPLY));
                    C13010fZ0 c13010fZ0 = new C13010fZ0(new ColorDrawable(-14540254), drawableMutate);
                    c13010fZ0.e(AbstractC21455b.F(64.0f), AbstractC21455b.F(64.0f));
                    this.I0.setImageDrawable(c13010fZ0);
                    if (this.b.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                        new AlertDialog.i(E2()).k(AbstractC19363qD5.permission_request_camera, 72, false, ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.x4)).e(AbstractC21455b.k1(FH3.E("PermissionNoCameraWithHint", TD5.tgwidget_PermissionNoCameraWithHint))).i(FH3.E("PermissionOpenSettings", TD5.tgwidget_PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.nasim.kT6
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.a.s3(dialogInterface, i2);
                            }
                        }).f(FH3.E("ContactsPermissionAlertNotNow", TD5.tgwidget_ContactsPermissionAlertNotNow), null).a().show();
                        return;
                    } else {
                        this.u.a(new String[]{"android.permission.CAMERA"}, WKSRecord.Service.SUNRPC);
                        this.d2 = true;
                    }
                }
            }
            if (this.b2) {
                return;
            }
            if (ir.nasim.tgwidgets.editor.messenger.camera.a.x().B()) {
                s2();
            } else {
                ir.nasim.tgwidgets.editor.messenger.camera.a.x().z(new RunnableC16553lT6(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X2() {
        this.I0.setImageDrawable(D2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X3() {
        Activity activity = this.b;
        if (activity == null) {
            return true;
        }
        boolean z = activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0;
        if (z) {
            this.u.b(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 114);
        }
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y2(View view) {
        ir.nasim.tgwidgets.editor.messenger.camera.c cameraSession;
        DualCameraView dualCameraView = this.J0;
        if (dualCameraView == null || this.E1 || (cameraSession = dualCameraView.getCameraSession()) == null) {
            return;
        }
        String strR = cameraSession.r();
        String strV = cameraSession.v();
        if (strR.equals(strV)) {
            return;
        }
        this.J0.getCameraSession().C(strV);
        b4(strV, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y3(boolean z) {
        C.m().edit().putBoolean("stories_camera", z).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z2(View view) {
        DualCameraView dualCameraView = this.J0;
        if (dualCameraView == null || this.Z != 0) {
            return;
        }
        dualCameraView.O0();
        this.M0.setValue(this.J0.p0());
        this.f1.k();
        C.m().edit().putInt("storydualhint", 2).apply();
        if (this.g1.H()) {
            C.m().edit().putInt("storysvddualhint", 2).apply();
        }
        this.g1.k();
    }

    private void Z3(final Runnable runnable) {
        DualCameraView dualCameraView = this.J0;
        if (dualCameraView == null || dualCameraView.getTextureView() == null) {
            return;
        }
        try {
            final Bitmap bitmap = this.J0.getTextureView().getBitmap();
            Utilities.g.i(new Runnable() { // from class: ir.nasim.mT6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t3(bitmap, runnable);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a3() {
        C.m().edit().putInt("storydualhint", C.m().getInt("storydualhint", 0) + 1).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a4(boolean z) {
        if (z) {
            this.g.flags |= 128;
        } else {
            this.g.flags &= -129;
        }
        try {
            this.f.updateViewLayout(this.h, this.g);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(float f2) {
        DualCameraView dualCameraView = this.J0;
        if (dualCameraView != null) {
            this.F1 = f2;
            dualCameraView.setZoom(f2);
        }
        l4(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b4(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.L0
            r0.clearAnimation()
            ir.nasim.tgwidgets.editor.ui.stories.recorder.DualCameraView r0 = r4.J0
            if (r0 == 0) goto Lf
            boolean r0 = r0.p0()
            if (r0 != 0) goto L13
        Lf:
            boolean r0 = r4.K1
            if (r0 == 0) goto L14
        L13:
            r5 = 0
        L14:
            r0 = 0
            if (r5 != 0) goto L43
            r5 = 0
            if (r6 == 0) goto L36
            android.widget.ImageView r6 = r4.L0
            r6.setVisibility(r0)
            android.widget.ImageView r6 = r4.L0
            android.view.ViewPropertyAnimator r6 = r6.animate()
            android.view.ViewPropertyAnimator r5 = r6.alpha(r5)
            ir.nasim.gT6 r6 = new ir.nasim.gT6
            r6.<init>()
            android.view.ViewPropertyAnimator r5 = r5.withEndAction(r6)
            r5.start()
            goto L42
        L36:
            android.widget.ImageView r6 = r4.L0
            r0 = 8
            r6.setVisibility(r0)
            android.widget.ImageView r6 = r4.L0
            r6.setAlpha(r5)
        L42:
            return
        L43:
            int r1 = r5.hashCode()
            r2 = 3551(0xddf, float:4.976E-42)
            r3 = 1
            if (r1 == r2) goto L6b
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 == r2) goto L61
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 == r2) goto L57
            goto L75
        L57:
            java.lang.String r1 = "auto"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L75
            r5 = r3
            goto L76
        L61:
            java.lang.String r1 = "off"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L75
            r5 = 3
            goto L76
        L6b:
            java.lang.String r1 = "on"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L75
            r5 = r0
            goto L76
        L75:
            r5 = -1
        L76:
            if (r5 == 0) goto L9a
            if (r5 == r3) goto L8a
            int r5 = ir.nasim.AbstractC23598xB5.media_photo_flash_off2
            android.widget.ImageView r1 = r4.L0
            java.lang.String r2 = "AccDescrCameraFlashOff"
            int r3 = ir.nasim.TD5.tgwidget_AccDescrCameraFlashOff
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
            r1.setContentDescription(r2)
            goto La9
        L8a:
            int r5 = ir.nasim.AbstractC23598xB5.media_photo_flash_auto2
            android.widget.ImageView r1 = r4.L0
            java.lang.String r2 = "AccDescrCameraFlashAuto"
            int r3 = ir.nasim.TD5.tgwidget_AccDescrCameraFlashAuto
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
            r1.setContentDescription(r2)
            goto La9
        L9a:
            int r5 = ir.nasim.AbstractC23598xB5.media_photo_flash_on2
            android.widget.ImageView r1 = r4.L0
            java.lang.String r2 = "AccDescrCameraFlashOn"
            int r3 = ir.nasim.TD5.tgwidget_AccDescrCameraFlashOn
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
            r1.setContentDescription(r2)
        La9:
            if (r6 == 0) goto Lb7
            int r1 = r4.K0
            if (r1 == r5) goto Lb7
            android.widget.ImageView r1 = r4.L0
            r4.K0 = r5
            ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.G1(r1, r5)
            goto Lbe
        Lb7:
            android.widget.ImageView r1 = r4.L0
            r4.K0 = r5
            r1.setImageResource(r5)
        Lbe:
            android.widget.ImageView r5 = r4.L0
            r5.setVisibility(r0)
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto Ld5
            android.widget.ImageView r6 = r4.L0
            android.view.ViewPropertyAnimator r6 = r6.animate()
            android.view.ViewPropertyAnimator r5 = r6.alpha(r5)
            r5.start()
            goto Lda
        Ld5:
            android.widget.ImageView r6 = r4.L0
            r6.setAlpha(r5)
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder.b4(java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c3(Boolean bool) {
        if (this.B1 || this.C1) {
            return;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.A1 = zBooleanValue;
        k4(zBooleanValue, true);
        this.S0.e(this.A1);
        this.R0.r(this.A1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d3(Float f2) {
        this.R0.s(f2.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3(Integer num) {
        if (this.x1 == null) {
            return;
        }
        if (num.intValue() == 5) {
            if (!this.a1.h()) {
                this.b1.v();
                EnumC4024Dj0.APP_ERROR.p();
                PreviewButtons.b bVar = this.a1.d;
                int i2 = -this.G1;
                this.G1 = i2;
                AbstractC21455b.y1(bVar, i2);
                return;
            }
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
            if (!lVar.l) {
                this.W0.O(3, true);
                n4(true);
                return;
            } else {
                lVar.o = false;
                n2(null);
                n4(true);
                return;
            }
        }
        if (num.intValue() == 1) {
            m4(0, true);
            PaintView paintView = this.k1;
            if (paintView != null) {
                paintView.z = false;
                paintView.R2();
                return;
            }
            return;
        }
        if (num.intValue() == 2) {
            m4(0, true);
            PaintView paintView2 = this.k1;
            if (paintView2 != null) {
                paintView2.U2();
                this.k1.z = true;
                return;
            }
            return;
        }
        if (num.intValue() == 6) {
            this.u.f(this.x1.f);
            return;
        }
        if (num.intValue() == 0) {
            this.u.h(this.r);
            return;
        }
        if (num.intValue() != 3) {
            if (num.intValue() == 4) {
                m4(1, true);
            }
        } else {
            w2();
            H2();
            PaintView paintView3 = this.k1;
            if (paintView3 != null) {
                paintView3.S2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f3(View view) throws Resources.NotFoundException {
        if (this.b2) {
            W3(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g3() {
        if (this.z0 == -1 && this.Z == 1) {
            m4(0, true);
            PaintView paintView = this.k1;
            if (paintView != null) {
                paintView.U2();
                this.k1.z = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h3() {
        this.a1.setShareEnabled(false);
        this.b1.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(View view) throws Resources.NotFoundException {
        if (this.E1) {
            return;
        }
        D3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2() {
        ValueAnimator valueAnimator = this.R1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.R1 = null;
        }
        this.S1 = false;
        final float fA = this.i.a();
        final float fB = this.i.b();
        this.i.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.R1 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.pT6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.K2(fA, fB, valueAnimator2);
            }
        });
        this.R1.setDuration(340L);
        this.R1.setInterpolator(InterpolatorC12631ew1.h);
        this.R1.addListener(new d());
        this.R1.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(Runnable runnable) {
        p2(true);
        n2(runnable);
    }

    private void j4() {
        String str;
        int i2;
        AlertDialog.i iVar = new AlertDialog.i(E2(), this.a);
        iVar.j(FH3.E("DiscardChanges", TD5.tgwidget_DiscardChanges));
        iVar.e(FH3.E("PhotoEditorDiscardAlert", TD5.tgwidget_PhotoEditorDiscardAlert));
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        if (lVar == null || !lVar.j) {
            str = "Discard";
            i2 = TD5.tgwidget_Discard;
        } else {
            str = "StoryDeleteDraft";
            i2 = TD5.tgwidget_StoryDeleteDraft;
        }
        iVar.i(FH3.E(str, i2), new DialogInterface.OnClickListener() { // from class: ir.nasim.tT6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) throws Resources.NotFoundException {
                this.a.v3(dialogInterface, i3);
            }
        });
        iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), null);
        AlertDialog alertDialogA = iVar.a();
        alertDialogA.show();
        View viewW0 = alertDialogA.w0(-1);
        if (viewW0 instanceof TextView) {
            int i3 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y5;
            ((TextView) viewW0).setTextColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i3, this.a));
            viewW0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.U(QY0.k(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i3, this.a), 51), 6, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k2, reason: merged with bridge method [inline-methods] */
    public void L2(final boolean z) throws Resources.NotFoundException {
        DraftSavedHint draftSavedHint;
        this.O0 = z;
        Boolean bool = this.Y1;
        if (bool == null || bool.booleanValue() != z) {
            if (this.P0 == null) {
                if (z) {
                    u2();
                }
                if (this.P0 == null) {
                    return;
                }
            }
            if (this.P0.o) {
                this.Z1 = new Runnable() { // from class: ir.nasim.AT6
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        this.a.L2(z);
                    }
                };
                return;
            }
            ValueAnimator valueAnimator = this.W1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.W1 = null;
            }
            C16463lJ6 c16463lJ6 = this.X1;
            if (c16463lJ6 != null) {
                c16463lJ6.d();
                this.X1 = null;
            }
            if (this.P0 == null) {
                if (z) {
                    u2();
                }
                if (this.P0 == null) {
                    return;
                }
            }
            GalleryListView galleryListView = this.P0;
            if (galleryListView != null) {
                galleryListView.l = false;
            }
            if (z && (draftSavedHint = this.Q0) != null) {
                draftSavedHint.b(true);
            }
            this.Y1 = Boolean.valueOf(z);
            float translationY = this.P0.getTranslationY();
            final float height = z ? 0.0f : (this.h.getHeight() - this.P0.A()) + (AbstractC21455b.e * 2.5f);
            Math.max(1, this.h.getHeight());
            this.P0.l = !z;
            this.S1 = this.R1 == null;
            if (z) {
                C16463lJ6 c16463lJ62 = new C16463lJ6(this.P0, AbstractC12098e22.n, height);
                this.X1 = c16463lJ62;
                c16463lJ62.x().d(0.75f);
                this.X1.x().f(350.0f);
                this.X1.b(new AbstractC12098e22.q() { // from class: ir.nasim.LT6
                    @Override // ir.nasim.AbstractC12098e22.q
                    public final void a(AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
                        this.a.M2(height, abstractC12098e22, z2, f2, f3);
                    }
                });
                this.X1.s();
            } else {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(translationY, height);
                this.W1 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.TT6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.a.N2(valueAnimator2);
                    }
                });
                this.W1.addListener(new f());
                this.W1.setDuration(450L);
                this.W1.setInterpolator(InterpolatorC12631ew1.h);
                this.W1.start();
            }
            if (!z && !this.E1) {
                this.U1 = null;
            }
            if (z || this.Z != 0 || this.b2) {
                return;
            }
            s2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k3(View view) {
        String str;
        int i2;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        if (lVar == null || this.E1) {
            return;
        }
        boolean z = !lVar.t;
        lVar.t = z;
        HintView2 hintView2 = this.e1;
        if (z) {
            str = "StorySoundMuted";
            i2 = TD5.tgwidget_StorySoundMuted;
        } else {
            str = "StorySoundNotMuted";
            i2 = TD5.tgwidget_StorySoundNotMuted;
        }
        hintView2.C(FH3.E(str, i2), this.e1.H());
        this.e1.G();
        c4(this.x1.t, true);
        this.W0.D(this.x1.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k4(final boolean z, boolean z2) {
        if (this.L1 == z) {
            return;
        }
        this.L1 = z;
        if (z2) {
            this.N0.animate().alpha(z ? 1.0f : 0.0f).setDuration(350L).setInterpolator(InterpolatorC12631ew1.h).withEndAction(new Runnable() { // from class: ir.nasim.XT6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.w3(z);
                }
            }).start();
            return;
        }
        this.N0.clearAnimation();
        this.N0.setAlpha(z ? 1.0f : 0.0f);
        if (z) {
            return;
        }
        this.N0.setRecording(false, false);
    }

    private void l2(float f2, boolean z, Runnable runnable) {
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.k = null;
        }
        if (!z) {
            this.q = null;
            this.n = f2;
            this.i.invalidate();
            this.h.invalidate();
            if (runnable != null) {
                runnable.run();
            }
            q2();
            return;
        }
        this.s.a();
        E.j().s(E.d1, 512);
        this.q = Float.valueOf(this.p);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.n, f2);
        this.k = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.xT6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.O2(valueAnimator2);
            }
        });
        this.k.addListener(new j(f2, runnable));
        if (f2 < 1.0f && this.j) {
            this.k.setDuration(250L);
            this.k.setInterpolator(InterpolatorC12631ew1.h);
        } else if (f2 > 0.0f || this.i.a() < AbstractC21455b.F(20.0f)) {
            this.k.setDuration(270L);
            this.k.setInterpolator(new C21447tg2());
        } else {
            this.k.setDuration(400L);
            this.k.setInterpolator(InterpolatorC12631ew1.h);
        }
        this.k.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3(Runnable runnable) throws Resources.NotFoundException {
        L2(false);
        AbstractC21455b.t(this.O1);
        this.O1 = null;
        this.E1 = false;
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l4(boolean z, boolean z2) {
        if ((this.U0.getTag() != null && z) || (this.U0.getTag() == null && !z)) {
            if (z) {
                Runnable runnable = this.M1;
                if (runnable != null) {
                    AbstractC21455b.t(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: ir.nasim.QT6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.x3();
                    }
                };
                this.M1 = runnable2;
                AbstractC21455b.n1(runnable2, 2000L);
                return;
            }
            return;
        }
        AnimatorSet animatorSet = this.N1;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.U0.setTag(z ? 1 : null);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.N1 = animatorSet2;
        animatorSet2.setDuration(180L);
        if (z) {
            this.U0.setVisibility(0);
        }
        this.N1.playTogether(ObjectAnimator.ofFloat(this.U0, (Property<ZoomControlView, Float>) View.ALPHA, z ? 1.0f : 0.0f));
        this.N1.addListener(new b(z));
        this.N1.start();
        if (z) {
            Runnable runnable3 = new Runnable() { // from class: ir.nasim.RT6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.y3();
                }
            };
            this.M1 = runnable3;
            AbstractC21455b.n1(runnable3, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(boolean z, boolean z2) {
        DualCameraView dualCameraView;
        DualCameraView dualCameraView2;
        if (z) {
            HintView2 hintView2 = this.f1;
            if (hintView2 != null) {
                hintView2.k();
            }
            HintView2 hintView22 = this.g1;
            if (hintView22 != null) {
                hintView22.k();
            }
            HintView2 hintView23 = this.e1;
            if (hintView23 != null) {
                hintView23.k();
            }
            HintView2 hintView24 = this.V0;
            if (hintView24 != null) {
                hintView24.k();
            }
        }
        if (this.K1 == z) {
            return;
        }
        AnimatorSet animatorSet = this.J1;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.J1 = null;
        }
        this.K1 = z;
        int i2 = 8;
        if (!z2) {
            this.G0.setAlpha(z ? 0.0f : 1.0f);
            this.G0.setVisibility(z ? 8 : 0);
            this.L0.setAlpha((z || this.Z != 0) ? 0.0f : 1.0f);
            this.L0.setVisibility((z || this.Z != 0) ? 8 : 0);
            this.M0.setAlpha((z || this.Z != 0) ? 0.0f : 1.0f);
            this.M0.setVisibility((z || this.Z != 0 || (dualCameraView = this.J0) == null || !dualCameraView.X0()) ? 8 : 0);
            this.T0.setAlpha((z && this.Z == 0) ? 1.0f : 0.0f);
            this.T0.setTranslationY((z || this.Z != 0) ? 0.0f : AbstractC21455b.F(16.0f));
            this.S0.setAlpha((z || this.Z != 0) ? 0.0f : 1.0f);
            this.S0.setTranslationY((z || this.Z != 0) ? AbstractC21455b.F(16.0f) : 0.0f);
            return;
        }
        this.G0.setVisibility(0);
        this.L0.setVisibility(0);
        ToggleButton toggleButton = this.M0;
        DualCameraView dualCameraView3 = this.J0;
        if (dualCameraView3 != null && dualCameraView3.X0()) {
            i2 = 0;
        }
        toggleButton.setVisibility(i2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.J1 = animatorSet2;
        ImageView imageView = this.G0;
        Property property = View.ALPHA;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, z ? 0.0f : 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.L0, (Property<ImageView, Float>) property, (z || this.Z != 0) ? 0.0f : 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.M0, (Property<ToggleButton, Float>) property, (z || this.Z != 0 || (dualCameraView2 = this.J0) == null || !dualCameraView2.X0()) ? 0.0f : 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.T0, (Property<HintTextView, Float>) property, (z && this.Z == 0) ? 1.0f : 0.0f);
        HintTextView hintTextView = this.T0;
        Property property2 = View.TRANSLATION_Y;
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, ObjectAnimator.ofFloat(hintTextView, (Property<HintTextView, Float>) property2, (z || this.Z != 0) ? 0.0f : AbstractC21455b.F(16.0f)), ObjectAnimator.ofFloat(this.S0, (Property<PhotoVideoSwitcherView, Float>) property, (z || this.Z != 0) ? 0.0f : 1.0f), ObjectAnimator.ofFloat(this.S0, (Property<PhotoVideoSwitcherView, Float>) property2, (z || this.Z != 0) ? AbstractC21455b.F(16.0f) : 0.0f));
        this.J1.addListener(new a(z));
        this.J1.setDuration(260L);
        this.J1.setInterpolator(InterpolatorC12631ew1.h);
        this.J1.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m3() {
        WindowView windowView;
        if (this.f == null || (windowView = this.h) == null || windowView.getParent() == null) {
            return;
        }
        this.f.removeView(this.h);
    }

    private void n2(Runnable runnable) {
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar;
        PreviewView previewView;
        PhotoFilterView photoFilterView = this.r1;
        if (photoFilterView == null || (lVar = this.x1) == null) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        lVar.n = photoFilterView.n0() | lVar.n;
        this.x1.N(this.r1, runnable);
        if (runnable == null) {
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2 = this.x1;
            if (lVar2.p || (previewView = this.W0) == null) {
                return;
            }
            previewView.set(lVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n3() {
        this.I0.setImageDrawable(D2());
    }

    private void n4(final boolean z) {
        p2(true);
        if (this.x1 == null) {
            r2(true);
            return;
        }
        A2();
        T3(this.x1, false);
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        lVar.g = this.r;
        this.u.e(lVar, new UA2() { // from class: ir.nasim.ST6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.A3(z, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2() {
        if (this.x1 == null || this.t1 == null) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        if (this.x1.w != 0) {
            matrix.postRotate(-r1, this.A0.getMeasuredWidth() / 2.0f, this.A0.getMeasuredHeight() / 2.0f);
            if ((this.x1.w / 90) % 2 == 1) {
                matrix.postScale(this.A0.getMeasuredWidth() / this.A0.getMeasuredHeight(), this.A0.getMeasuredHeight() / this.A0.getMeasuredWidth(), this.A0.getMeasuredWidth() / 2.0f, this.A0.getMeasuredHeight() / 2.0f);
            }
        }
        matrix.postScale((1.0f / this.A0.getMeasuredWidth()) * this.x1.b, (1.0f / this.A0.getMeasuredHeight()) * this.x1.c);
        matrix.postConcat(this.x1.d);
        matrix.postScale(this.A0.getMeasuredWidth() / this.x1.z, this.A0.getMeasuredHeight() / this.x1.A);
        this.t1.setTransform(matrix);
        this.t1.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o3(ir.nasim.tgwidgets.editor.ui.Components.k kVar) {
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar;
        MediaController.n nVar;
        if (kVar == null || (lVar = this.x1) == null || (nVar = lVar.P) == null) {
            return;
        }
        kVar.n0(ir.nasim.tgwidgets.editor.ui.Components.l.k(nVar));
    }

    static /* bridge */ /* synthetic */ t p0(StoryRecorder storyRecorder) {
        storyRecorder.getClass();
        return null;
    }

    private void p2(boolean z) {
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar;
        if (this.k1 == null || (lVar = this.x1) == null) {
            return;
        }
        lVar.n();
        this.x1.n |= this.k1.x();
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2 = this.x1;
        ArrayList arrayList = lVar2.M;
        if (arrayList == null) {
            lVar2.M = new ArrayList();
        } else {
            arrayList.clear();
        }
        PaintView paintView = this.k1;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar3 = this.x1;
        paintView.O1(lVar3.M, lVar3.z, lVar3.A, false, false);
        ArrayList arrayList2 = new ArrayList();
        PaintView paintView2 = this.k1;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar4 = this.x1;
        Bitmap bitmapO1 = paintView2.O1(arrayList2, lVar4.z, lVar4.A, true, z && !lVar4.O());
        List<AbstractC24131y57> masks = this.k1.getMasks();
        this.x1.N = masks != null ? new ArrayList(masks) : null;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar5 = this.x1;
        AbstractC11500d67 abstractC11500d67J0 = C21457d.J0(bitmapO1, compressFormat, lVar5.z, lVar5.A, 87, false, 101, 101);
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar6 = this.x1;
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        lVar6.M = arrayList2;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar7 = this.x1;
        if (!lVar7.p) {
            lVar7.L = Utilities.e(this.k1.getLcm(), 7500L, 5000L);
        }
        this.x1.K = C4278El2.H(this.c).Q(abstractC11500d67J0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p3(DialogInterface dialogInterface, int i2) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + AbstractC14047hG.a.getPackageName()));
            this.b.startActivity(intent);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        boolean z = this.p != 0.0f || this.n < 1.0f || this.g2;
        if (z == this.f2) {
            return;
        }
        this.f2 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q3() throws Resources.NotFoundException {
        W3(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(boolean z) {
        l2(1.0f, z, new RunnableC20708sT6(this));
        this.a1.f(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2() throws Resources.NotFoundException {
        if (this.J0 != null || E2() == null) {
            return;
        }
        i iVar = new i(E2(), C2(), false);
        this.J0 = iVar;
        iVar.b = true;
        iVar.setThumbDrawable(D2());
        this.J0.o0();
        this.J0.setDelegate(new CameraView.f() { // from class: ir.nasim.UT6
            @Override // ir.nasim.tgwidgets.editor.messenger.camera.CameraView.f
            public final void a() {
                this.a.P2();
            }
        });
        this.M0.setVisibility((this.J0.X0() && this.Z == 0) ? 0 : 8);
        this.L0.setTranslationX(this.J0.X0() ? -AbstractC21455b.F(46.0f) : 0.0f);
        this.A0.addView(this.J0, AbstractC13840gu3.d(-1, -1, 119));
        if (C.m().getInt("storyhint2", 0) < 1) {
            this.V0.G();
            C.m().edit().putInt("storyhint2", C.m().getInt("storyhint2", 0) + 1).apply();
        } else {
            if (this.J0.e1() || !this.J0.X0() || C.m().getInt("storydualhint", 0) >= 2) {
                return;
            }
            this.f1.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s3(DialogInterface dialogInterface, int i2) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + AbstractC14047hG.a.getPackageName()));
            this.b.startActivity(intent);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        Bitmap photoBitmap;
        if (this.r1 != null || this.x1 == null || (photoBitmap = this.W0.getPhotoBitmap()) == null) {
            return;
        }
        Activity activity = this.b;
        VideoEditTextureView textureView = this.W0.getTextureView();
        int orientation = this.W0.getOrientation();
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        PhotoFilterView photoFilterView = new PhotoFilterView(activity, textureView, photoBitmap, orientation, lVar == null ? null : lVar.P, null, 0, false, false, this.a);
        this.r1 = photoFilterView;
        this.i.addView(photoFilterView);
        PhotoFilterView.EnhanceView enhanceView = this.s1;
        if (enhanceView != null) {
            enhanceView.setFilterView(this.r1);
        }
        TextureView myTextureView = this.r1.getMyTextureView();
        this.t1 = myTextureView;
        if (myTextureView != null) {
            myTextureView.setOpaque(false);
        }
        this.W0.setFilterTextureView(this.t1);
        TextureView textureView2 = this.t1;
        if (textureView2 != null) {
            textureView2.setAlpha(0.0f);
            this.t1.animate().alpha(1.0f).setDuration(220L).start();
        }
        o2();
        PhotoFilterBlurControl blurControl = this.r1.getBlurControl();
        this.u1 = blurControl;
        if (blurControl != null) {
            this.A0.addView(blurControl);
        }
        PhotoFilterCurvesControl curveControl = this.r1.getCurveControl();
        this.v1 = curveControl;
        if (curveControl != null) {
            this.A0.addView(curveControl);
        }
        S3();
        this.r1.getDoneTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q2(view);
            }
        });
        this.r1.getCancelTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oT6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R2(view);
            }
        });
        this.r1.getToolsView().setVisibility(8);
        this.r1.getToolsView().setAlpha(0.0f);
        this.r1.getToolsView().setTranslationY(AbstractC21455b.F(186.0f));
        this.r1.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t3(Bitmap bitmap, Runnable runnable) {
        if (bitmap != null) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.J0.getMatrix(), true);
                bitmap.recycle();
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 80, (int) (bitmapCreateBitmap.getHeight() / (bitmapCreateBitmap.getWidth() / 80.0f)), true);
                if (bitmapCreateScaledBitmap != null) {
                    if (bitmapCreateScaledBitmap != bitmapCreateBitmap) {
                        bitmapCreateBitmap.recycle();
                    }
                    Utilities.blurBitmap(bitmapCreateScaledBitmap, 7, 1, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), bitmapCreateScaledBitmap.getRowBytes());
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(AbstractC14047hG.b(), "cthumb.jpg"));
                    bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 87, fileOutputStream);
                    bitmapCreateScaledBitmap.recycle();
                    fileOutputStream.close();
                }
            } catch (Throwable unused) {
            }
        }
        AbstractC21455b.m1(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2() {
        v2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u3() {
        this.L0.setVisibility(8);
    }

    private void v2(final boolean z) {
        if (this.P0 != null || E2() == null) {
            return;
        }
        e eVar = new e(this.c, E2(), this.a, this.V1, z);
        this.P0 = eVar;
        eVar.setOnBackClickListener(new Runnable() { // from class: ir.nasim.VT6
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.a.S2();
            }
        });
        this.P0.setOnSelectListener(new Utilities.a() { // from class: ir.nasim.WT6
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.a
            public final void a(Object obj, Object obj2) throws Resources.NotFoundException {
                this.a.T2(z, obj, (Bitmap) obj2);
            }
        });
        Parcelable parcelable = this.U1;
        if (parcelable != null) {
            this.P0.e.f1(parcelable);
        }
        this.h.addView(this.P0, AbstractC13840gu3.d(-1, -1, 119));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v3(DialogInterface dialogInterface, int i2) throws Resources.NotFoundException {
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        if (lVar != null && lVar.j) {
            this.x1 = null;
        }
        if (this.y1 || this.z1) {
            B3(0, true);
        } else {
            r2(true);
        }
    }

    private void w2() {
        File file;
        if (this.k1 != null) {
            return;
        }
        Pair<Integer, Integer> paintSize = this.W0.getPaintSize();
        Bitmap bitmap = this.j1;
        if (bitmap != null) {
            bitmap.recycle();
            this.j1 = null;
        }
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        if (lVar != null && lVar.j && (file = lVar.K) != null) {
            this.j1 = BitmapFactory.decodeFile(file.getPath());
        }
        if (this.j1 == null) {
            this.j1 = Bitmap.createBitmap(((Integer) paintSize.first).intValue(), ((Integer) paintSize.second).intValue(), Bitmap.Config.ARGB_8888);
        }
        Activity activity = this.b;
        WindowView windowView = this.h;
        int i2 = this.c;
        Bitmap bitmap2 = this.j1;
        int orientation = this.W0.getOrientation();
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2 = this.x1;
        h hVar = new h(activity, windowView, activity, i2, bitmap2, null, orientation, lVar2 == null ? null : lVar2.M, this.A0.getMeasuredWidth(), this.A0.getMeasuredHeight(), new MediaController.i(), null, this.a);
        this.k1 = hVar;
        this.i.addView(hVar);
        RenderView renderView = this.k1.getRenderView();
        this.l1 = renderView;
        if (renderView != null) {
            this.A0.addView(renderView);
        }
        View renderInputView = this.k1.getRenderInputView();
        this.m1 = renderInputView;
        if (renderInputView != null) {
            this.A0.addView(renderInputView);
        }
        View textDimView = this.k1.getTextDimView();
        this.n1 = textDimView;
        if (textDimView != null) {
            this.A0.addView(textDimView);
        }
        View entitiesView = this.k1.getEntitiesView();
        this.o1 = entitiesView;
        if (entitiesView != null) {
            this.A0.addView(entitiesView);
        }
        View selectionEntitiesView = this.k1.getSelectionEntitiesView();
        this.p1 = selectionEntitiesView;
        if (selectionEntitiesView != null) {
            this.A0.addView(selectionEntitiesView);
        }
        S3();
        this.k1.setOnDoneButtonClickedListener(new Runnable() { // from class: ir.nasim.YT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.U2();
            }
        });
        this.k1.setOnCancelButtonClickedListener(new Runnable() { // from class: ir.nasim.fT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.V2();
            }
        });
        this.k1.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w3(boolean z) {
        if (z) {
            return;
        }
        this.N0.setRecording(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(boolean z) {
        if (this.J0 != null) {
            if (z) {
                Z3(new Runnable() { // from class: ir.nasim.hT6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.W2();
                    }
                });
                return;
            }
            Z3(new Runnable() { // from class: ir.nasim.iT6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.X2();
                }
            });
            this.J0.h0(true, null);
            this.A0.removeView(this.J0);
            this.J0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x3() {
        l4(false, true);
        this.M1 = null;
    }

    private void y2() {
        GalleryListView galleryListView = this.P0;
        if (galleryListView == null) {
            return;
        }
        this.h.removeView(galleryListView);
        this.P0 = null;
        ValueAnimator valueAnimator = this.W1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.W1 = null;
        }
        C16463lJ6 c16463lJ6 = this.X1;
        if (c16463lJ6 != null) {
            c16463lJ6.d();
            this.X1 = null;
        }
        this.Y1 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y3() {
        l4(false, true);
        this.M1 = null;
    }

    public static void z2() {
        StoryRecorder storyRecorder = h2;
        if (storyRecorder != null) {
            storyRecorder.r2(false);
        }
        h2 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z3(boolean z) {
        if (z) {
            r2(true);
        } else {
            r2(true);
        }
    }

    public void B3(int i2, boolean z) throws Resources.NotFoundException {
        DualCameraView dualCameraView;
        DualCameraView dualCameraView2;
        int i3 = this.Z;
        if (i2 == i3) {
            return;
        }
        this.Z = i2;
        AnimatorSet animatorSet = this.Q1;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        G3(i3, i2);
        PreviewButtons previewButtons = this.a1;
        if (previewButtons != null) {
            previewButtons.l(this.u.d());
            this.a1.f(i2 == 1 && this.n > 0.0f, z);
        }
        StoryLinkCustomView storyLinkCustomView = this.F0;
        if (storyLinkCustomView != null) {
            if (i2 != 1 || this.n <= 0.0f) {
                storyLinkCustomView.setVisibility(8);
            } else {
                storyLinkCustomView.p(this.x1.f);
            }
        }
        k4(i2 == 0 && this.A1, z);
        if (i2 != 1) {
            this.Z0.a(false, z);
        }
        if (!z) {
            DualCameraView dualCameraView3 = this.J0;
            if (dualCameraView3 != null) {
                dualCameraView3.setAlpha(i2 == 0 ? 1.0f : 0.0f);
            }
            this.I0.setAlpha(i2 == 0 ? 1.0f : 0.0f);
            this.I0.setVisibility(i2 == 0 ? 0 : 8);
            this.W0.setAlpha(i2 == 1 ? 1.0f : 0.0f);
            this.L0.setAlpha(i2 == 0 ? 1.0f : 0.0f);
            this.M0.setAlpha((i2 == 0 && (dualCameraView = this.J0) != null && dualCameraView.X0()) ? 1.0f : 0.0f);
            this.R0.setAlpha(i2 == 0 ? 1.0f : 0.0f);
            this.R0.setTranslationY(i2 == 0 ? 0.0f : AbstractC21455b.F(16.0f));
            this.S0.setAlpha(i2 == 0 ? 1.0f : 0.0f);
            this.S0.setTranslationY(i2 == 0 ? 0.0f : AbstractC21455b.F(16.0f));
            this.G0.setVisibility(0);
            this.G0.setAlpha(1.0f);
            this.T0.setAlpha((i2 == 0 && this.K1) ? 1.0f : 0.0f);
            this.D0.setAlpha(i2 == 1 ? 1.0f : 0.0f);
            this.D0.setTranslationY(i2 == 1 ? 0.0f : AbstractC21455b.F(12.0f));
            this.d1.setAlpha((i2 == 1 && this.A1) ? 1.0f : 0.0f);
            this.b1.setAlpha(i2 == 1 ? 1.0f : 0.0f);
            this.Y0.setAlpha((i2 == 1 && this.A1) ? 1.0f : 0.0f);
            this.H0.setAlpha(i2 == 1 ? 1.0f : 0.0f);
            F3(i3, i2);
            return;
        }
        this.Q1 = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        DualCameraView dualCameraView4 = this.J0;
        if (dualCameraView4 != null) {
            arrayList.add(ObjectAnimator.ofFloat(dualCameraView4, (Property<DualCameraView, Float>) View.ALPHA, i2 == 0 ? 1.0f : 0.0f));
        }
        this.I0.setVisibility(0);
        ImageView imageView = this.I0;
        Property property = View.ALPHA;
        arrayList.add(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, i2 == 0 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.W0, (Property<PreviewView, Float>) property, i2 == 1 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.R0, (Property<RecordControl, Float>) property, i2 == 0 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.L0, (Property<ImageView, Float>) property, i2 == 0 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.M0, (Property<ToggleButton, Float>) property, (i2 == 0 && (dualCameraView2 = this.J0) != null && dualCameraView2.X0()) ? 1.0f : 0.0f));
        RecordControl recordControl = this.R0;
        Property property2 = View.TRANSLATION_Y;
        arrayList.add(ObjectAnimator.ofFloat(recordControl, (Property<RecordControl, Float>) property2, i2 == 0 ? 0.0f : AbstractC21455b.F(24.0f)));
        arrayList.add(ObjectAnimator.ofFloat(this.S0, (Property<PhotoVideoSwitcherView, Float>) property, i2 == 0 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.S0, (Property<PhotoVideoSwitcherView, Float>) property2, i2 == 0 ? 0.0f : AbstractC21455b.F(24.0f)));
        this.G0.setVisibility(0);
        arrayList.add(ObjectAnimator.ofFloat(this.G0, (Property<ImageView, Float>) property, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.T0, (Property<HintTextView, Float>) property, (i2 == 0 && this.K1) ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.D0, (Property<FrameLayout, Float>) property, i2 == 1 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.D0, (Property<FrameLayout, Float>) property2, i2 == 1 ? 0.0f : AbstractC21455b.F(12.0f)));
        arrayList.add(ObjectAnimator.ofFloat(this.H0, (Property<SimpleTextView, Float>) property, i2 == 1 ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.Y0, (Property<VideoTimelinePlayView, Float>) property, (i2 == 1 && this.A1) ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.d1, (Property<RLottieImageView, Float>) property, (i2 == 1 && this.A1) ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.b1, (Property<DownloadButton, Float>) property, i2 != 1 ? 0.0f : 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.U0, (Property<ZoomControlView, Float>) property, 0.0f));
        this.Q1.playTogether(arrayList);
        this.Q1.addListener(new c(i3, i2));
        this.Q1.setDuration(460L);
        this.Q1.setInterpolator(InterpolatorC12631ew1.h);
        this.Q1.start();
    }

    public void C3(final Runnable runnable, long j2) {
        if (this.E1 || this.x1 == null) {
            return;
        }
        Runnable runnable2 = this.O1;
        if (runnable2 != null) {
            AbstractC21455b.t(runnable2);
        }
        this.P1 = true;
        this.E1 = true;
        this.O1 = new Runnable() { // from class: ir.nasim.wT6
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.a.l3(runnable);
            }
        };
        this.W0.setAlpha(0.0f);
        this.W0.setVisibility(0);
        this.W0.set(this.x1, this.O1, j2);
        AbstractC21455b.n1(this.O1, 400L);
    }

    public boolean D3() throws Resources.NotFoundException {
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar;
        PaintView paintView;
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2;
        PaintView paintView2;
        if (this.C1) {
            this.R0.t();
            return false;
        }
        if (this.B1) {
            return false;
        }
        if (this.P0 != null) {
            L2(false);
            this.V1 = null;
            return false;
        }
        if (this.z0 == 0 && (paintView2 = this.k1) != null && paintView2.a()) {
            return false;
        }
        if (this.z0 > -1) {
            m4(-1, true);
            return false;
        }
        if (this.Z != 1 || ((lVar = this.x1) != null && lVar.l)) {
            r2(true);
            return true;
        }
        if ((!this.y1 || (((paintView = this.k1) != null && paintView.x()) || !((lVar2 = this.x1) == null || lVar2.O == null))) && this.a1.h()) {
            j4();
        } else {
            B3(0, true);
        }
        return false;
    }

    public Context E2() {
        return this.b;
    }

    public void Q3(t tVar, boolean z) throws Resources.NotFoundException {
        WindowView windowView;
        if (this.d) {
            return;
        }
        this.e = false;
        this.g2 = false;
        if (this.f != null && (windowView = this.h) != null && windowView.getParent() == null) {
            this.f.addView(this.h, this.g);
        }
        this.I0.setImageDrawable(D2());
        B3(0, false);
        m4(-1, false);
        this.o = 0;
        this.m.set(0.0f, AbstractC21455b.F(100.0f), AbstractC21455b.h.x, AbstractC21455b.F(100.0f) + AbstractC21455b.h.y);
        this.l = AbstractC21455b.F(8.0f);
        this.i.e();
        this.A0.setBackgroundColor(this.o != 1 ? -14737633 : 0);
        this.i.setTranslationX(0.0f);
        this.i.setTranslationY(0.0f);
        this.i.d(0.0f);
        this.i.setScaleX(1.0f);
        this.i.setScaleY(1.0f);
        this.p = 0.0f;
        AbstractC21455b.Y0(this.b, 1);
        l2(1.0f, z, new RunnableC20708sT6(this));
        i2();
    }

    public void R3(t tVar, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, long j2, final boolean z) throws Resources.NotFoundException {
        WindowView windowView;
        if (this.d) {
            return;
        }
        this.e = false;
        this.g2 = false;
        if (this.f != null && (windowView = this.h) != null && windowView.getParent() == null) {
            this.f.addView(this.h, this.g);
        }
        this.x1 = lVar;
        this.A1 = lVar != null && lVar.p;
        this.o = 0;
        this.m.set(0.0f, AbstractC21455b.F(100.0f), AbstractC21455b.h.x, AbstractC21455b.F(100.0f) + AbstractC21455b.h.y);
        this.l = AbstractC21455b.F(8.0f);
        this.i.e();
        this.A0.setBackgroundColor(this.o == 1 ? 0 : -14737633);
        this.i.setTranslationX(0.0f);
        this.i.setTranslationY(0.0f);
        this.i.d(0.0f);
        this.i.setScaleX(1.0f);
        this.i.setScaleY(1.0f);
        this.p = 0.0f;
        AbstractC21455b.Y0(this.b, 1);
        C3(new Runnable() { // from class: ir.nasim.uT6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r3(z);
            }
        }, j2);
        B3(1, false);
        m4(-1, false);
        i2();
        this.a1.l(this.u.d());
        this.a1.m(this.r);
    }

    public void U3() {
        E.j().u(this, E.d2);
        E.k(this.c).u(this, E.W3);
    }

    public void c4(boolean z, boolean z2) {
        if (this.c1 == null) {
            RLottieDrawable rLottieDrawable = new RLottieDrawable(AbstractC19363qD5.media_mute_unmute, "media_mute_unmute", AbstractC21455b.F(28.0f), AbstractC21455b.F(28.0f), true, (int[]) null);
            this.c1 = rLottieDrawable;
            rLottieDrawable.Q(1.5f);
        }
        this.d1.setAnimation(this.c1);
        if (!z2) {
            this.c1.h0(z ? 20 : 0, false);
            return;
        }
        if (z) {
            if (this.c1.H() > 20) {
                this.c1.h0(0, false);
            }
            this.c1.l0(20);
            this.c1.start();
            return;
        }
        if (this.c1.H() == 0 || this.c1.H() >= 43) {
            return;
        }
        this.c1.l0(43);
        this.c1.start();
    }

    public void d4(InterfaceC19490qR6 interfaceC19490qR6) {
        ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
        if (lVar == null) {
            return;
        }
        lVar.f = interfaceC19490qR6;
        this.F0.p(interfaceC19490qR6);
    }

    public void e4(Runnable runnable) {
        this.w = runnable;
    }

    public StoryRecorder f4(long j2) {
        this.v = j2;
        PreviewView.a1 = j2;
        return this;
    }

    public StoryRecorder g4(InterfaceC13589gU6 interfaceC13589gU6) {
        this.u = interfaceC13589gU6;
        return this;
    }

    public void h4(C19526qV6 c19526qV6) {
        this.r = c19526qV6;
        this.a1.m(c19526qV6);
    }

    public void i2() {
        E.j().e(this, E.d2);
        E.k(this.c).e(this, E.W3);
    }

    public void i4(String str, SA2 sa2) {
        this.a1.setTagTooltip(str, sa2);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0333 A[LOOP:0: B:91:0x0333->B:93:0x0339, LOOP_START, PHI: r4
      0x0333: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:86:0x0300, B:93:0x0339] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m4(int r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder.m4(int, boolean):void");
    }

    public void r2(boolean z) {
        if (this.d) {
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar = this.x1;
            if (lVar != null) {
                if (this.j && lVar.l) {
                    lVar.n = false;
                }
                lVar.p(false);
                this.x1 = null;
            }
            PreviewView previewView = this.W0;
            if (previewView != null && !z) {
                previewView.set(null);
            }
            l2(0.0f, z, new Runnable() { // from class: ir.nasim.vT6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.E3();
                }
            });
            if (this.o == 1) {
                this.h.setBackgroundColor(0);
                this.a1.f(false, true);
            }
            U3();
        }
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i2, int i3, Object... objArr) {
        RecordControl recordControl;
        if (i2 != E.d2) {
            if (i2 != E.W3 || (recordControl = this.R0) == null || this.H1) {
                return;
            }
            recordControl.v();
            return;
        }
        RecordControl recordControl2 = this.R0;
        if (recordControl2 != null) {
            recordControl2.v();
        }
        if (this.V1 == null || MediaController.M0 == null) {
            return;
        }
        for (int i4 = 0; i4 < MediaController.M0.size(); i4++) {
            MediaController.h hVar = (MediaController.h) MediaController.M0.get(i4);
            int i5 = hVar.a;
            MediaController.h hVar2 = this.V1;
            if (i5 == hVar2.a && hVar.b == hVar2.b) {
                this.V1 = hVar;
                return;
            }
        }
    }
}
