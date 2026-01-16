package ir.nasim.tgwidgets.editor.ui;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.util.FloatProperty;
import android.util.Pair;
import android.util.Property;
import android.util.Range;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManagerTgwidget;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10736c67;
import ir.nasim.AbstractC11500d67;
import ir.nasim.AbstractC11908dl0;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC12724f57;
import ir.nasim.AbstractC12972fU7;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC14392hq2;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC18697p57;
import ir.nasim.AbstractC18973pa;
import ir.nasim.AbstractC20488s57;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC25089zi7;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8443Vz3;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C12154e78;
import ir.nasim.C13010fZ0;
import ir.nasim.C13450gF2;
import ir.nasim.C15381jU7;
import ir.nasim.C15404jX3;
import ir.nasim.C16046kc7;
import ir.nasim.C16463lJ6;
import ir.nasim.C17645nJ6;
import ir.nasim.C18727p87;
import ir.nasim.C18981pa7;
import ir.nasim.C19001pc7;
import ir.nasim.C19026pf2;
import ir.nasim.C19136pq2;
import ir.nasim.C19406qI3;
import ir.nasim.C20782sb7;
import ir.nasim.C22069uc7;
import ir.nasim.C22477vI7;
import ir.nasim.C23255wc7;
import ir.nasim.C24365yV2;
import ir.nasim.C24687z23;
import ir.nasim.C3270Ad7;
import ir.nasim.C3417Au1;
import ir.nasim.C4211Ed7;
import ir.nasim.C4278El2;
import ir.nasim.C4347Et;
import ir.nasim.C5153Ic7;
import ir.nasim.C6564Oa7;
import ir.nasim.C7083Qe7;
import ir.nasim.C7501Rz2;
import ir.nasim.C8006Uc7;
import ir.nasim.C8265Vf5;
import ir.nasim.C9151Ys;
import ir.nasim.CW7;
import ir.nasim.CX1;
import ir.nasim.FH3;
import ir.nasim.FT7;
import ir.nasim.HU1;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.KJ;
import ir.nasim.L57;
import ir.nasim.L93;
import ir.nasim.M57;
import ir.nasim.N77;
import ir.nasim.NP0;
import ir.nasim.O98;
import ir.nasim.QY0;
import ir.nasim.R62;
import ir.nasim.RD6;
import ir.nasim.TD5;
import ir.nasim.U00;
import ir.nasim.W57;
import ir.nasim.YZ2;
import ir.nasim.ZO1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21456c;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenu;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuSubItem;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet;
import ir.nasim.tgwidgets.editor.ui.ActionBar.SimpleTextView;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.C21506a;
import ir.nasim.tgwidgets.editor.ui.Cells.PhotoPickerPhotoCell;
import ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;
import ir.nasim.tgwidgets.editor.ui.Components.BackupImageView;
import ir.nasim.tgwidgets.editor.ui.Components.Bulletin;
import ir.nasim.tgwidgets.editor.ui.Components.C21470i;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBox;
import ir.nasim.tgwidgets.editor.ui.Components.ClippingImageView;
import ir.nasim.tgwidgets.editor.ui.Components.Crop.CropAreaView;
import ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView;
import ir.nasim.tgwidgets.editor.ui.Components.I;
import ir.nasim.tgwidgets.editor.ui.Components.LinkSpanDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.LPhotoPaintView;
import ir.nasim.tgwidgets.editor.ui.Components.PaintingOverlay;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterView;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerCaptionEnterView;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerWebView;
import ir.nasim.tgwidgets.editor.ui.Components.PickerBottomLayoutViewer;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RadialProgressView;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;
import ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto;
import ir.nasim.tgwidgets.editor.ui.Components.TextViewSwitcher;
import ir.nasim.tgwidgets.editor.ui.Components.Tooltip;
import ir.nasim.tgwidgets.editor.ui.Components.URLSpanReplacement;
import ir.nasim.tgwidgets.editor.ui.Components.UndoView;
import ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView;
import ir.nasim.tgwidgets.editor.ui.Components.VideoSeekPreviewImage;
import ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView;
import ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView;
import ir.nasim.tgwidgets.editor.ui.O;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import livekit.org.webrtc.MediaStreamTrack;
import org.xbill.DNS.Type;

/* loaded from: classes7.dex */
public class PhotoViewer implements E.d, C13450gF2.c, C13450gF2.b {
    private static Drawable[] l7;
    private static DecelerateInterpolator m7;
    private static Paint n7;
    private static final Property o7 = new p0("progress");
    private static volatile PhotoViewer p7 = null;
    private static volatile PhotoViewer q7 = null;
    private PhotoViewerWebView A;
    private ActionBarMenuItem A0;
    private boolean A2;
    private boolean A3;
    private boolean A4;
    private float A5;
    private AnimatorSet A6;
    public FrameLayout B;
    private ir.nasim.tgwidgets.editor.ui.Components.n B0;
    private boolean B2;
    private int B3;
    private W57 B4;
    private float B5;
    private ObjectAnimator B6;
    private ActionBarMenuSubItem C0;
    private MediaController.i C1;
    private boolean C2;
    private float C3;
    private ImageReceiver.b C4;
    private float C5;
    private ClippingImageView D;
    private ActionBarMenuSubItem D0;
    private MediaController.i D1;
    private float D2;
    private boolean D4;
    private float D5;
    private ActionBarPopupWindow.GapView E0;
    private PhotoFilterView E1;
    private String E2;
    private boolean E4;
    private float E5;
    private ActionBarMenu F0;
    private YZ2 F1;
    private String F2;
    private TextView F3;
    boolean F4;
    private float F5;
    private volatile int F6;
    private FrameLayout G;
    private ActionBarMenuItem G0;
    private AlertDialog G1;
    private Drawable G3;
    private long G4;
    private float G5;
    private View H;
    private ActionBarMenuItem H0;
    private s0 H1;
    private long H2;
    private CharSequence H3;
    private boolean H4;
    private float H5;
    private int H6;
    private ActionBarMenuItem I0;
    private r0 I1;
    private float I2;
    private boolean I4;
    private int I6;
    private int J;
    private ActionBarMenuItem J0;
    private FrameLayout J1;
    private boolean J2;
    private int J4;
    private boolean J5;
    private volatile int J6;
    private LinearLayout K0;
    public PhotoViewerCaptionEnterView K1;
    private long K2;
    private int K4;
    private boolean K5;
    private volatile int K6;
    C21506a L0;
    private int L1;
    private boolean L2;
    private long L4;
    private boolean L5;
    private volatile int L6;
    private boolean M1;
    private I0 M2;
    private NP0 M3;
    private long M4;
    private int M5;
    private volatile int M6;
    private boolean N1;
    private String N2;
    private RecyclerListView N3;
    private int N4;
    private boolean N5;
    private volatile int N6;
    private boolean O1;
    private Animator O2;
    private LinearLayoutManagerTgwidget O3;
    private int O4;
    private boolean O5;
    private volatile int O6;
    private CheckBox P0;
    public AnimatedFileDrawable P1;
    private C16463lJ6 P3;
    private int P4;
    private float P6;
    private CounterView Q0;
    private boolean Q1;
    private boolean Q3;
    private boolean Q4;
    private boolean Q5;
    private int Q6;
    private FrameLayout R0;
    private boolean R1;
    private boolean R3;
    private boolean R4;
    private boolean R5;
    private volatile boolean R6;
    private ImageView S0;
    private boolean S1;
    private SimpleTextView S2;
    private int S3;
    private boolean S4;
    private int S5;
    private volatile boolean S6;
    private PickerBottomLayoutViewer T0;
    private ImageView T2;
    private long T3;
    private VelocityTracker T5;
    private long T6;
    private TextView U0;
    private boolean U1;
    private C15381jU7 U2;
    private Runnable U3;
    private Scroller U5;
    private long U6;
    private View V2;
    private D0 V3;
    private boolean V4;
    private float V6;
    private RadialProgressView W0;
    private boolean W1;
    private VideoSeekPreviewImage W2;
    private D0 W3;
    private boolean W4;
    private float W6;
    private ImageView X0;
    private Object X1;
    private AnimatorSet X2;
    public boolean X3;
    private boolean X4;
    private long X6;
    private TextView Y;
    private ImageView Y0;
    private boolean Y1;
    private boolean Y2;
    private CharSequence Y3;
    private boolean Y4;
    private long Y6;
    private TextView Z;
    private ImageView Z0;
    private boolean Z1;
    private int Z2;
    private boolean Z3;
    private boolean Z4;
    private long Z6;
    private int a;
    private ImageView a1;
    boolean a2;
    private TextureView a3;
    private int a4;
    private boolean a5;
    private long a7;
    private C0 b;
    private ImageView b1;
    private m.h b2;
    private ImageView b3;
    private float b5;
    private long b7;
    private boolean c;
    private ImageView c1;
    private int c4;
    private float c5;
    private long c7;
    private ImageView d1;
    private boolean d3;
    private String d4;
    private float d5;
    private float d7;
    private ImageView e1;
    private AspectRatioFrameLayout e2;
    private PaintingOverlay e4;
    private Runnable e7;
    private boolean f;
    private ImageView f1;
    private View f2;
    private boolean f3;
    private PaintingOverlay f4;
    private C10743c74 f7;
    private boolean g;
    private GroupedPhotosListView g1;
    private AnimatorSet g2;
    private Bitmap g3;
    private PaintingOverlay g4;
    private boolean g7;
    private int h;
    private Tooltip h1;
    private TextureView h2;
    private boolean h3;
    private float h5;
    private boolean h7;
    private String i;
    private UndoView i1;
    private v0 i2;
    private int i3;
    private float i5;
    private boolean i7;
    private int j;
    private H0 j1;
    private FT7 j2;
    private boolean j3;
    private float j5;
    private boolean j7;
    private AnimatorSet k;
    private x0 k1;
    private boolean k2;
    private boolean k3;
    private boolean k4;
    private float k5;
    private String k7;
    private AnimatorSet l1;
    private Runnable l2;
    private boolean l3;
    private boolean l4;
    private float l5;
    public Activity m;
    private ImageReceiver m1;
    private boolean m2;
    private boolean m4;
    private float m5;
    private ir.nasim.tgwidgets.editor.ui.O m6;
    private Context n;
    private boolean n1;
    private float n2;
    private boolean n3;
    private float n5;
    private ValueAnimator n6;
    public ActionBar o;
    private float o2;
    private boolean o3;
    private boolean o5;
    public boolean o6;
    private float p1;
    private float p2;
    private float p3;
    private int p4;
    private long p5;
    public CharSequence p6;
    private boolean q;
    private long q1;
    private float q2;
    private long q3;
    private int q4;
    private boolean q6;
    private AnimatorSet r;
    private float r2;
    private boolean r3;
    private C10743c74 r4;
    private AnimatorSet r5;
    private int r6;
    private B0 s;
    private float s2;
    private boolean s3;
    private Uri s4;
    private AnimatorSet s5;
    float s6;
    private z0 t;
    private boolean t2;
    private boolean t3;
    private C13450gF2 t5;
    private int u1;
    private int u2;
    private long u3;
    private C24687z23 u4;
    private boolean u5;
    private int v;
    private boolean v1;
    private FT7 v2;
    private View v3;
    private C24687z23 v4;
    private E0 v6;
    private int w;
    private ir.nasim.tgwidgets.editor.ui.Components.I w1;
    private SurfaceTexture w2;
    private float w5;
    private PickerBottomLayoutViewer w6;
    private int x;
    private AnimatorSet x1;
    private boolean x2;
    private OrientationEventListener x3;
    private D0 x4;
    private RadialProgressView x6;
    private WindowManager.LayoutParams y;
    private PhotoCropView y1;
    private boolean y2;
    public String y4;
    private float y5;
    private VideoTimelinePlayView y6;
    private w0 z;
    private TextView z0;
    private boolean z2;
    private int z3;
    private String z4;
    private float z5;
    private TextView z6;
    private int d = -1;
    private boolean e = true;
    private Runnable l = new Runnable() { // from class: ir.nasim.T95
        @Override // java.lang.Runnable
        public final void run() {
            this.a.Z8();
        }
    };
    private boolean p = true;
    public boolean u = true;
    private Map M0 = new HashMap(3);
    private BackgroundDrawable N0 = new BackgroundDrawable(-16777216);
    private Paint O0 = new Paint();
    private A0[] V0 = new A0[3];
    private Runnable o1 = new Runnable() { // from class: ir.nasim.V95
        @Override // java.lang.Runnable
        public final void run() {
            this.a.na();
        }
    };
    private GradientDrawable[] r1 = new GradientDrawable[2];
    private boolean[] s1 = new boolean[2];
    private float[] t1 = new float[2];
    private C3417Au1 z1 = new C3417Au1();
    private C3417Au1 A1 = new C3417Au1();
    private C3417Au1 B1 = new C3417Au1();
    private Paint V1 = new Paint(2);
    private Runnable c2 = new RunnableC21490k();
    private Runnable d2 = new RunnableC21501v();
    private KJ G2 = new KJ();
    private boolean P2 = true;
    private int[] Q2 = new int[2];
    private int[] R2 = new int[2];
    private ImageView[] c3 = new ImageView[3];
    private int[] e3 = new int[2];
    private boolean m3 = true;
    private int w3 = -1;
    private int y3 = -10;
    AbstractC12972fU7 D3 = new F();
    public final Property E3 = new Q("flashViewAlpha");
    private Runnable I3 = new RunnableC21474b0();
    private Runnable J3 = new m0();
    private TextureView.SurfaceTextureListener K3 = new n0();
    private float[][] L3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 13);
    private final Runnable b4 = new Runnable() { // from class: ir.nasim.W95
        @Override // java.lang.Runnable
        public final void run() {
            this.a.a9();
        }
    };
    private ImageReceiver h4 = new ImageReceiver();
    private ImageReceiver i4 = new ImageReceiver();
    private ImageReceiver j4 = new ImageReceiver();
    private Paint n4 = new Paint();
    private Bitmap o4 = null;
    private t0 t4 = new t0();
    private String[] w4 = new String[3];
    private boolean[] T4 = {false, true};
    private boolean U4 = false;
    private float e5 = 1.0f;
    private float f5 = 0.0f;
    private float g5 = 0.0f;
    private int q5 = -1;
    private DecelerateInterpolator v5 = new DecelerateInterpolator(1.5f);
    private float x5 = 1.0f;
    private boolean I5 = true;
    private boolean P5 = true;
    private boolean V5 = false;
    private boolean W5 = false;
    private boolean X5 = true;
    private ArrayList Y5 = new ArrayList();
    private SparseArray[] Z5 = {new SparseArray(), new SparseArray()};
    private ArrayList a6 = new ArrayList();
    private SparseArray[] b6 = {new SparseArray(), new SparseArray()};
    private ArrayList c6 = new ArrayList();
    private ArrayList d6 = new ArrayList();
    private ArrayList e6 = new ArrayList();
    private ArrayList f6 = new ArrayList();
    private ArrayList g6 = new ArrayList();
    private ArrayList h6 = new ArrayList();
    private C24687z23 i6 = null;
    private F0 j6 = null;
    private Rect k6 = new Rect();
    private C4347Et l6 = new C4347Et(new int[]{ir.nasim.tgwidgets.editor.messenger.E.u, ir.nasim.tgwidgets.editor.messenger.E.v, ir.nasim.tgwidgets.editor.messenger.E.U, ir.nasim.tgwidgets.editor.messenger.E.T, ir.nasim.tgwidgets.editor.messenger.E.Z});
    Runnable t6 = new Runnable() { // from class: ir.nasim.X95
        @Override // java.lang.Runnable
        public final void run() {
            this.a.ha();
        }
    };
    private int[] u6 = new int[2];
    private long C6 = -1;
    private long D6 = -1;
    private long E6 = -1;
    private volatile int G6 = -1;

    class A extends SpoilersTextView {
        private LinkSpanDrawable o;
        private LinkSpanDrawable.a p;
        private Layout q;
        private AnimatedEmojiSpan.b r;
        private final ColorFilter s;

        A(Context context) {
            super(context);
            this.p = new LinkSpanDrawable.a(this);
            this.s = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A() {
            this.p.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(LinkSpanDrawable linkSpanDrawable) {
            LinkSpanDrawable linkSpanDrawable2 = this.o;
            if (linkSpanDrawable == linkSpanDrawable2 && linkSpanDrawable2 != null && (linkSpanDrawable2.c() instanceof URLSpan)) {
                PhotoViewer.this.ga((URLSpan) this.o.c(), this, new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.A();
                    }
                });
                this.o = null;
            }
        }

        @Override // android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            canvas.clipRect(0.0f, getScrollY(), getWidth() - getPaddingRight(), (getHeight() + getScrollY()) - (getPaddingBottom() * 0.75f));
            AnimatedEmojiSpan.e(canvas, getLayout(), this.r, 0.0f, null, 0.0f, 0.0f, 0.0f, 1.0f);
            canvas.restore();
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AnimatedEmojiSpan.i(this, this.r);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView, android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.save();
            canvas.translate(getPaddingLeft(), 0.0f);
            if (this.p.g(canvas)) {
                invalidate();
            }
            canvas.restore();
            super.onDraw(canvas);
            if (this.q != getLayout()) {
                this.r = AnimatedEmojiSpan.l(0, this, this.r, getLayout());
                this.q = getLayout();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
        protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            super.onTextChanged(charSequence, i, i2, i3);
            this.r = AnimatedEmojiSpan.l(0, this, this.r, getLayout());
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
        @Override // android.widget.TextView, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r10) {
            /*
                Method dump skipped, instructions count: 314
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.A.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        public void setPressed(boolean z) {
            boolean z2 = z != isPressed();
            super.setPressed(z);
            if (z2) {
                invalidate();
            }
        }
    }

    private class A0 {
        private View i;
        private boolean p;
        private final C13010fZ0 q;
        private final C8265Vf5 r;
        private long a = 0;
        private float b = 0.0f;
        private float c = 0.0f;
        private float d = 0.0f;
        private long e = 0;
        private float f = 0.0f;
        private RectF g = new RectF();
        private int h = -1;
        private int j = AbstractC21455b.F(64.0f);
        private int k = -2;
        private float l = 1.0f;
        private float[] m = new float[3];
        private float[] n = new float[3];
        private float o = 1.0f;

        public A0(View view) {
            if (PhotoViewer.m7 == null) {
                PhotoViewer.m7 = new DecelerateInterpolator(1.5f);
                PhotoViewer.n7 = new Paint(1);
                PhotoViewer.n7.setStyle(Paint.Style.STROKE);
                PhotoViewer.n7.setStrokeCap(Paint.Cap.ROUND);
                PhotoViewer.n7.setStrokeWidth(AbstractC21455b.F(3.0f));
                PhotoViewer.n7.setColor(-1);
            }
            this.i = view;
            m();
            C8265Vf5 c8265Vf5 = new C8265Vf5(28);
            this.r = c8265Vf5;
            c8265Vf5.a(200);
            this.q = new C13010fZ0(AbstractC4043Dl1.f(PhotoViewer.this.m, AbstractC23598xB5.circle_big).mutate(), c8265Vf5);
        }

        private float e() {
            float interpolation = 1.0f;
            int i = 0;
            while (true) {
                float[] fArr = this.m;
                if (i >= fArr.length) {
                    return interpolation;
                }
                interpolation *= i == 2 ? AbstractC21455b.u.getInterpolation(fArr[i]) : fArr[i];
                i++;
            }
        }

        private void f() {
            boolean z = false;
            int i = 0;
            while (true) {
                float[] fArr = this.n;
                if (i >= fArr.length) {
                    z = true;
                    break;
                } else if (fArr[i] != 1.0f) {
                    break;
                } else {
                    i++;
                }
            }
            if (z != this.p) {
                this.p = z;
                l(z);
            }
        }

        private void s(boolean z) {
            boolean z2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.a;
            if (j > 18) {
                j = 18;
            }
            this.a = jCurrentTimeMillis;
            int i = 0;
            if (z) {
                if (this.f == 1.0f && this.c == 1.0f) {
                    z2 = false;
                } else {
                    this.b += (360 * j) / 3000.0f;
                    float f = this.c - this.d;
                    if (Math.abs(f) > 0.0f) {
                        long j2 = this.e + j;
                        this.e = j2;
                        if (j2 >= 300) {
                            float f2 = this.c;
                            this.f = f2;
                            this.d = f2;
                            this.e = 0L;
                        } else {
                            this.f = this.d + (f * PhotoViewer.m7.getInterpolation(this.e / 300.0f));
                        }
                    }
                    z2 = true;
                }
                float f3 = this.l;
                if (f3 > 0.0f && this.k != -2) {
                    float f4 = f3 - (j / 200.0f);
                    this.l = f4;
                    if (f4 <= 0.0f) {
                        this.l = 0.0f;
                        this.k = -2;
                    }
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            while (true) {
                float[] fArr = this.n;
                if (i >= fArr.length) {
                    break;
                }
                float f5 = fArr[i];
                float[] fArr2 = this.m;
                float f6 = fArr2[i];
                if (f5 > f6) {
                    fArr2[i] = Math.min(1.0f, f6 + (j / 200.0f));
                } else if (f5 < f6) {
                    fArr2[i] = Math.max(0.0f, f6 - (j / 200.0f));
                } else {
                    i++;
                }
                z2 = true;
                i++;
            }
            if (z2) {
                this.i.postInvalidateOnAnimation();
            }
        }

        public int g() {
            return (PhotoViewer.this.z.getWidth() - ((int) (this.j * this.o))) / 2;
        }

        public int h() {
            int i = (int) ((((AbstractC21455b.h.y + (PhotoViewer.this.A8() ? AbstractC21455b.d : 0)) - ((int) (this.j * this.o))) / 2) + PhotoViewer.this.C3);
            return PhotoViewer.this.L1 == 1 ? i - AbstractC21455b.F(38.0f) : i;
        }

        public boolean i() {
            return this.p;
        }

        protected abstract void j(int i);

        public void k(Canvas canvas) {
            int i;
            int i2 = (int) (this.j * this.o);
            int iG = g();
            int iH = h();
            float fE = e();
            int i3 = this.k;
            if (i3 >= 0 && i3 < PhotoViewer.l7.length + 2) {
                Drawable drawable = this.k < PhotoViewer.l7.length ? PhotoViewer.l7[this.k] : this.q;
                if (drawable != null) {
                    drawable.setAlpha((int) (this.l * 255.0f * fE));
                    drawable.setBounds(iG, iH, iG + i2, iH + i2);
                    drawable.draw(canvas);
                }
            }
            int i4 = this.h;
            if (i4 >= 0 && i4 < PhotoViewer.l7.length + 2) {
                Drawable drawable2 = this.h < PhotoViewer.l7.length ? PhotoViewer.l7[this.h] : this.q;
                if (drawable2 != null) {
                    if (this.k != -2) {
                        drawable2.setAlpha((int) ((1.0f - this.l) * 255.0f * fE));
                    } else {
                        drawable2.setAlpha((int) (fE * 255.0f));
                    }
                    drawable2.setBounds(iG, iH, iG + i2, iH + i2);
                    drawable2.draw(canvas);
                }
            }
            int i5 = this.h;
            if (i5 != 0 && i5 != 1 && (i = this.k) != 0 && i != 1) {
                s(false);
                return;
            }
            int iF = AbstractC21455b.F(4.0f);
            if (this.k != -2) {
                PhotoViewer.n7.setAlpha((int) (this.l * 255.0f * fE));
            } else {
                PhotoViewer.n7.setAlpha((int) (fE * 255.0f));
            }
            this.g.set(iG + iF, iH + iF, (iG + i2) - iF, (iH + i2) - iF);
            canvas.drawArc(this.g, this.b - 90.0f, Math.max(4.0f, this.f * 360.0f), false, PhotoViewer.n7);
            s(true);
        }

        protected abstract void l(boolean z);

        public void m() {
            int i = 0;
            while (true) {
                float[] fArr = this.n;
                if (i >= fArr.length) {
                    f();
                    return;
                } else {
                    this.m[i] = 1.0f;
                    fArr[i] = 1.0f;
                    i++;
                }
            }
        }

        public void n(float f) {
            p(0, f, false);
        }

        public void o(int i, boolean z, boolean z2) {
            int i2;
            int i3 = this.h;
            if (i3 == i) {
                return;
            }
            C8265Vf5 c8265Vf5 = this.r;
            if (c8265Vf5 != null) {
                boolean z3 = z2 && (i3 == 3 || i3 == 4);
                if (i == 3) {
                    c8265Vf5.c(false, z3);
                } else if (i == 4) {
                    c8265Vf5.c(true, z3);
                }
                this.r.b(this.i);
                this.r.invalidateSelf();
            }
            this.a = System.currentTimeMillis();
            if (!z || (i2 = this.h) == i) {
                this.k = -2;
            } else {
                this.k = i2;
                this.l = 1.0f;
            }
            this.h = i;
            j(i);
            this.i.invalidate();
        }

        public void p(int i, float f, boolean z) {
            float[] fArr = this.n;
            if (fArr[i] != f) {
                fArr[i] = f;
                if (!z) {
                    this.m[i] = f;
                }
                f();
                this.i.invalidate();
            }
        }

        public void q(float f, boolean z) {
            if (z) {
                this.d = this.f;
            } else {
                this.f = f;
                this.d = f;
            }
            this.c = f;
            this.e = 0L;
            this.i.invalidate();
        }

        public void r(float f) {
            this.o = f;
        }
    }

    class B extends AnimatorListenerAdapter {
        B() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.r5 = null;
            if (PhotoViewer.this.y1 == null) {
                return;
            }
            if (PhotoViewer.this.y1.l()) {
                PhotoViewer.this.Z0.setColorFilter(new PorterDuffColorFilter(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
            } else {
                PhotoViewer.this.Z0.setColorFilter((ColorFilter) null);
            }
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.l5 = 0.0f;
            photoViewer.g5 = 0.0f;
            PhotoViewer.this.z.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class B0 extends FrameLayout implements E.d {
        private FrameLayout a;
        private FrameLayout b;
        SimpleTextView[] c;
        AnimatedTextView d;
        private AnimatorSet e;
        private AnimatorSet f;
        private boolean g;
        private ValueAnimator h;
        private float i;
        int j;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (B0.this.e == animator) {
                    B0.this.c[1].setVisibility(8);
                    B0.this.e = null;
                }
            }
        }

        class b extends AnimatorListenerAdapter {
            final /* synthetic */ float a;

            b(float f) {
                this.a = f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                B0.this.l(this.a, false);
            }
        }

        public B0(Context context) {
            super(context);
            FrameLayout frameLayout = new FrameLayout(context);
            this.a = frameLayout;
            frameLayout.setPadding(AbstractC21455b.F((AbstractC21455b.F0() ? 80 : 72) - 16), 0, 0, 0);
            addView(this.a, AbstractC13840gu3.d(-1, -1, 119));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.b = frameLayout2;
            frameLayout2.setPivotX(0.0f);
            this.b.setPadding(AbstractC21455b.F(16.0f), 0, 0, 0);
            this.b.setClipToPadding(false);
            this.a.addView(this.b, AbstractC13840gu3.d(-1, -1, 119));
            this.c = new SimpleTextView[2];
            for (int i = 0; i < 2; i++) {
                this.c[i] = new SimpleTextView(context);
                this.c[i].setGravity(19);
                this.c[i].setTextColor(-1);
                this.c[i].setTextSize(20);
                this.c[i].setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                this.c[i].setDrawablePadding(AbstractC21455b.F(4.0f));
                this.c[i].setScrollNonFitText(true);
                this.b.addView(this.c[i], AbstractC13840gu3.d(-1, -2, 19));
            }
            AnimatedTextView animatedTextView = new AnimatedTextView(context, true, false, false);
            this.d = animatedTextView;
            animatedTextView.setAnimationProperties(0.4f, 0L, 320L, InterpolatorC12631ew1.h);
            this.d.setTextSize(AbstractC21455b.F(14.0f));
            this.d.setGravity(19);
            this.d.setTextColor(-1);
            this.d.setEllipsizeByGradient(true);
            this.a.addView(this.d, AbstractC13840gu3.c(-1, 20.0f, 51, 16.0f, 0.0f, 0.0f, 0.0f));
        }

        private boolean d(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            if ((charSequence == null) != (charSequence2 == null)) {
                return false;
            }
            return TextUtils.equals(charSequence.toString(), charSequence2.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(float f, ValueAnimator valueAnimator) {
            this.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = (int) f;
            this.c[0].setRightPadding(i);
            this.c[1].setRightPadding(i);
            this.d.setRightPadding(f);
        }

        public CharSequence e() {
            return this.c[0].getText();
        }

        public void g(CharSequence charSequence) {
            h(charSequence, true);
        }

        public void h(CharSequence charSequence, boolean z) {
            boolean z2 = !TextUtils.isEmpty(charSequence);
            if (z2 != this.g) {
                this.g = z2;
                AnimatorSet animatorSet = this.f;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                Point point = AbstractC21455b.h;
                int iF = AbstractC21455b.F((z2 ? 30 : 33) - (point.x > point.y ? 6 : 0));
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(ObjectAnimator.ofFloat(this.d, (Property<AnimatedTextView, Float>) View.ALPHA, z2 ? 1.0f : 0.0f));
                    AnimatedTextView animatedTextView = this.d;
                    Property property = View.TRANSLATION_Y;
                    arrayList.add(ObjectAnimator.ofFloat(animatedTextView, (Property<AnimatedTextView, Float>) property, iF));
                    arrayList.add(ObjectAnimator.ofFloat(this.b, (Property<FrameLayout, Float>) property, z2 ? AbstractC21455b.F(-9.0f) : 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(this.b, (Property<FrameLayout, Float>) View.SCALE_X, z2 ? 0.95f : 1.0f));
                    arrayList.add(ObjectAnimator.ofFloat(this.b, (Property<FrameLayout, Float>) View.SCALE_Y, z2 ? 0.95f : 1.0f));
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.f = animatorSet2;
                    animatorSet2.playTogether(arrayList);
                    this.f.setInterpolator(InterpolatorC12631ew1.h);
                    this.f.start();
                } else {
                    this.d.setAlpha(z2 ? 1.0f : 0.0f);
                    this.d.setTranslationY(iF);
                    this.b.setTranslationY(z2 ? AbstractC21455b.F(-9.0f) : 0.0f);
                    this.b.setScaleX(z2 ? 0.95f : 1.0f);
                    this.b.setScaleY(z2 ? 0.95f : 1.0f);
                }
            }
            this.d.setText(charSequence, z);
        }

        public void i(CharSequence charSequence) {
            this.c[1].setAlpha(0.0f);
            this.c[1].setVisibility(8);
            if (!d(this.c[0].getText(), charSequence)) {
                this.c[0].h();
            }
            this.c[0].i(charSequence);
            this.c[0].setAlpha(1.0f);
            this.c[0].setTranslationX(0.0f);
            this.c[0].setTranslationY(0.0f);
        }

        public void j(CharSequence charSequence, boolean z, boolean z2) {
            if (d(this.c[0].getText(), charSequence)) {
                return;
            }
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.e = null;
            }
            SimpleTextView[] simpleTextViewArr = this.c;
            simpleTextViewArr[1].c(simpleTextViewArr[0]);
            SimpleTextView[] simpleTextViewArr2 = this.c;
            simpleTextViewArr2[1].i(simpleTextViewArr2[0].getText());
            this.c[1].setRightPadding((int) this.i);
            this.c[0].h();
            this.c[0].i(charSequence);
            float F = AbstractC21455b.F(8.0f) * (z2 ? 1 : -1);
            this.c[1].setTranslationX(0.0f);
            this.c[1].setTranslationY(0.0f);
            if (z) {
                this.c[0].setTranslationX(0.0f);
                this.c[0].setTranslationY(-F);
            } else {
                this.c[0].setTranslationX(-F);
                this.c[0].setTranslationY(0.0f);
            }
            this.c[0].setAlpha(0.0f);
            this.c[1].setAlpha(1.0f);
            this.c[0].setVisibility(0);
            this.c[1].setVisibility(0);
            ArrayList arrayList = new ArrayList();
            SimpleTextView simpleTextView = this.c[1];
            Property property = View.ALPHA;
            arrayList.add(ObjectAnimator.ofFloat(simpleTextView, (Property<SimpleTextView, Float>) property, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.c[0], (Property<SimpleTextView, Float>) property, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.c[1], (Property<SimpleTextView, Float>) (z ? View.TRANSLATION_Y : View.TRANSLATION_X), F));
            arrayList.add(ObjectAnimator.ofFloat(this.c[0], (Property<SimpleTextView, Float>) (z ? View.TRANSLATION_Y : View.TRANSLATION_X), 0.0f));
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.e = animatorSet2;
            animatorSet2.playTogether(arrayList);
            this.e.addListener(new a());
            this.e.setDuration(320L);
            this.e.setInterpolator(InterpolatorC12631ew1.h);
            this.e.start();
        }

        public void k() {
            this.g = !this.g;
            h(this.d.getText(), false);
        }

        public void l(final float f, boolean z) {
            ValueAnimator valueAnimator = this.h;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.h = null;
            }
            if (!z) {
                this.i = f;
                this.c[0].setRightPadding((int) f);
                this.d.setRightPadding(f);
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.i, f);
            this.h = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.M
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.f(f, valueAnimator2);
                }
            });
            this.h.addListener(new b(f));
            this.h.setDuration(320L);
            this.h.setInterpolator(InterpolatorC12631ew1.h);
            this.h.start();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            ir.nasim.tgwidgets.editor.messenger.E.j().e(this, ir.nasim.tgwidgets.editor.messenger.E.K2);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            ir.nasim.tgwidgets.editor.messenger.E.j().u(this, ir.nasim.tgwidgets.editor.messenger.E.K2);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            this.a.layout(0, AbstractC21455b.d, i3 - i, i4 - i2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = AbstractC21455b.d;
            int i4 = this.j;
            int i5 = AbstractC21455b.h.y;
            if (i4 != i5) {
                this.j = i5;
                k();
            }
            this.a.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - i3, 1073741824));
            setMeasuredDimension(size, size2);
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.E.d
        public void t(int i, int i2, Object... objArr) {
            if (i == ir.nasim.tgwidgets.editor.messenger.E.K2) {
                this.c[0].invalidate();
                this.c[1].invalidate();
                this.d.invalidate();
            }
        }
    }

    private class BackgroundDrawable extends ColorDrawable {
        private final RectF a;
        private final RectF b;
        private final Paint c;
        private Runnable d;

        public BackgroundDrawable(int i) {
            super(i);
            this.a = new RectF();
            this.b = new RectF();
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setColor(i);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Runnable runnable;
            if (PhotoViewer.this.S3 == 0 || AbstractC21455b.F0() || PhotoViewer.this.x4 == null || PhotoViewer.this.x4.animatingImageView == null) {
                super.draw(canvas);
            } else {
                PhotoViewer.this.D.a(this.b);
                if (!this.b.isEmpty()) {
                    this.b.inset(AbstractC21455b.F(1.0f), AbstractC21455b.F(1.0f));
                    Rect bounds = getBounds();
                    float f = bounds.right;
                    float f2 = bounds.bottom;
                    for (int i = 0; i < 4; i++) {
                        if (i == 0) {
                            RectF rectF = this.a;
                            RectF rectF2 = this.b;
                            rectF.set(0.0f, rectF2.top, rectF2.left, rectF2.bottom);
                        } else if (i == 1) {
                            this.a.set(0.0f, 0.0f, f, this.b.top);
                        } else if (i == 2) {
                            RectF rectF3 = this.a;
                            RectF rectF4 = this.b;
                            rectF3.set(rectF4.right, rectF4.top, f, rectF4.bottom);
                        } else if (i == 3) {
                            this.a.set(0.0f, this.b.bottom, f, f2);
                        }
                        canvas.drawRect(this.a, this.c);
                    }
                }
            }
            if (getAlpha() == 0 || (runnable = this.d) == null) {
                return;
            }
            AbstractC21455b.m1(runnable);
            this.d = null;
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        @Keep
        public void setAlpha(int i) {
            super.setAlpha(i);
            this.c.setAlpha(i);
        }
    }

    class C extends AnimatorListenerAdapter {
        final /* synthetic */ float a;
        final /* synthetic */ Runnable b;

        C(float f, Runnable runnable) {
            this.a = f;
            this.b = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.r5 = null;
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.k5 = 0.0f;
            photoViewer.f5 = 0.0f;
            PhotoViewer photoViewer2 = PhotoViewer.this;
            photoViewer2.l5 = 0.0f;
            photoViewer2.g5 = 0.0f;
            PhotoViewer photoViewer3 = PhotoViewer.this;
            photoViewer3.j5 = 1.0f;
            photoViewer3.e5 = 1.0f;
            PhotoViewer.this.z.invalidate();
            PhotoViewer.this.y1.c.a.setRotationScaleTranslation(0.0f, 1.0f, 0.0f, 0.0f);
            PhotoViewer.this.y1.d.setRotated(false);
            if (Math.abs(this.a) > 0.0f) {
                if (PhotoViewer.this.y1.s(this.a)) {
                    PhotoViewer.this.a1.setColorFilter(new PorterDuffColorFilter(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
                } else {
                    PhotoViewer.this.a1.setColorFilter((ColorFilter) null);
                }
            }
            if (PhotoViewer.this.t4.c != null) {
                MediaController.i iVar = PhotoViewer.this.t4.c;
                PhotoViewer.this.t4.c.b = 0.0f;
                iVar.a = 0.0f;
                MediaController.i iVar2 = PhotoViewer.this.t4.c;
                PhotoViewer.this.t4.c.f = 1.0f;
                iVar2.e = 1.0f;
            }
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public interface C0 {
        boolean allowCaption();

        boolean canCaptureMorePhotos();

        default boolean canLoadMoreAvatars() {
            return true;
        }

        boolean canScrollAway();

        boolean cancelButtonPressed();

        boolean closeKeyboard();

        String getDeleteMessageString();

        int getPhotoIndex(int i);

        D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z);

        int getSelectedCount();

        HashMap getSelectedPhotos();

        ArrayList getSelectedPhotosOrder();

        ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i);

        int getTotalImageCount();

        boolean isPhotoChecked(int i);

        boolean loadMore();

        void needAddMorePhotos();

        void onApplyCaption(CharSequence charSequence);

        void onCaptionChanged(CharSequence charSequence);

        void onClose();

        default boolean onDeletePhoto(int i) {
            return true;
        }

        default void onIndexChanged(int i) {
        }

        void onOpen();

        default void onPathChanged(String str, MediaController.l lVar) {
        }

        default void onPreClose() {
        }

        default void onPreOpen() {
        }

        void openPhotoForEdit(String str, String str2, boolean z);

        void replaceButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h);

        boolean scaleToFill();

        void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h, boolean z, int i2, boolean z2);

        int setPhotoChecked(int i, ir.nasim.tgwidgets.editor.messenger.H h);

        int setPhotoUnchecked(Object obj);

        void updatePhotoAtIndex(int i);

        void willHidePhotoViewer();

        void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i);
    }

    private static class CounterView extends View {
        private StaticLayout a;
        private TextPaint b;
        private Paint c;
        private int d;
        private int e;
        private RectF f;
        private int g;
        private float h;

        public CounterView(Context context) {
            super(context);
            this.g = 0;
            TextPaint textPaint = new TextPaint(1);
            this.b = textPaint;
            textPaint.setTextSize(AbstractC21455b.F(15.0f));
            this.b.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.b.setColor(-1);
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setColor(-1);
            this.c.setStrokeWidth(AbstractC21455b.F(2.0f));
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeJoin(Paint.Join.ROUND);
            this.f = new RectF();
            a(0);
        }

        public void a(int i) {
            StaticLayout staticLayout = new StaticLayout("" + Math.max(1, i), this.b, AbstractC21455b.F(100.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.a = staticLayout;
            this.d = (int) Math.ceil((double) staticLayout.getLineWidth(0));
            this.e = this.a.getLineBottom(0);
            AnimatorSet animatorSet = new AnimatorSet();
            if (i == 0) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.0f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.0f);
                Paint paint = this.c;
                Property property = AbstractC21469h.a;
                animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, ObjectAnimator.ofInt(paint, (Property<Paint, Integer>) property, 0), ObjectAnimator.ofInt(this.b, (Property<TextPaint, Integer>) property, 0));
                animatorSet.setInterpolator(new DecelerateInterpolator());
            } else {
                int i2 = this.g;
                if (i2 == 0) {
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.0f, 1.0f);
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.0f, 1.0f);
                    Paint paint2 = this.c;
                    Property property2 = AbstractC21469h.a;
                    animatorSet.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, ObjectAnimator.ofInt(paint2, (Property<Paint, Integer>) property2, 0, 255), ObjectAnimator.ofInt(this.b, (Property<TextPaint, Integer>) property2, 0, 255));
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                } else if (i < i2) {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 1.1f, 1.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 1.1f, 1.0f));
                    animatorSet.setInterpolator(new OvershootInterpolator());
                } else {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.9f, 1.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.9f, 1.0f));
                    animatorSet.setInterpolator(new OvershootInterpolator());
                }
            }
            animatorSet.setDuration(180L);
            animatorSet.start();
            requestLayout();
            this.g = i;
        }

        @Override // android.view.View
        public float getRotationX() {
            return this.h;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int measuredHeight = getMeasuredHeight() / 2;
            this.c.setAlpha(255);
            this.f.set(AbstractC21455b.F(1.0f), measuredHeight - AbstractC21455b.F(14.0f), getMeasuredWidth() - AbstractC21455b.F(1.0f), measuredHeight + AbstractC21455b.F(14.0f));
            canvas.drawRoundRect(this.f, AbstractC21455b.F(15.0f), AbstractC21455b.F(15.0f), this.c);
            if (this.a != null) {
                this.b.setAlpha((int) ((1.0f - this.h) * 255.0f));
                canvas.save();
                canvas.translate((getMeasuredWidth() - this.d) / 2, ((getMeasuredHeight() - this.e) / 2) + AbstractC21455b.H(0.2f) + (this.h * AbstractC21455b.F(5.0f)));
                this.a.draw(canvas);
                canvas.restore();
                this.c.setAlpha((int) (this.h * 255.0f));
                int iCenterX = (int) this.f.centerX();
                int iCenterY = (int) (((int) this.f.centerY()) - (AbstractC21455b.F(5.0f) * (1.0f - this.h)));
                canvas.drawLine(AbstractC21455b.F(5.0f) + iCenterX, iCenterY - AbstractC21455b.F(5.0f), iCenterX - AbstractC21455b.F(5.0f), AbstractC21455b.F(5.0f) + iCenterY, this.c);
                canvas.drawLine(iCenterX - AbstractC21455b.F(5.0f), iCenterY - AbstractC21455b.F(5.0f), iCenterX + AbstractC21455b.F(5.0f), iCenterY + AbstractC21455b.F(5.0f), this.c);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.d + AbstractC21455b.F(20.0f), AbstractC21455b.F(30.0f)), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(40.0f), 1073741824));
        }

        @Override // android.view.View
        @Keep
        public void setRotationX(float f) {
            this.h = f;
            invalidate();
        }

        @Override // android.view.View
        @Keep
        public void setScaleX(float f) {
            super.setScaleX(f);
            invalidate();
        }
    }

    class D extends AnimatorListenerAdapter {
        D() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.X2 = null;
        }
    }

    public static class D0 {
        public ClippingImageView animatingImageView;
        public int animatingImageViewYOffset;
        public boolean canEdit;
        public int clipBottomAddition;
        public int clipTopAddition;
        public long dialogId;
        public ImageReceiver imageReceiver;
        public int index;
        public boolean isEvent;
        public View parentView;
        public int[] radius;
        public long size;
        public int starOffset;
        public ImageReceiver.b thumb;
        public int viewX;
        public int viewY;
        public int viewY2;
        public float scale = 1.0f;
        public boolean allowTakeAnimation = true;
    }

    class E implements C15381jU7.a {
        E() {
        }

        @Override // ir.nasim.C15381jU7.a
        public void a(float f) {
            if (PhotoViewer.this.j2 != null || (PhotoViewer.this.A != null && PhotoViewer.this.A.H())) {
                if (!PhotoViewer.this.i7 && PhotoViewer.this.y6.getVisibility() == 0) {
                    f = PhotoViewer.this.y6.getLeftProgress() + ((PhotoViewer.this.y6.getRightProgress() - PhotoViewer.this.y6.getLeftProgress()) * f);
                }
                if (PhotoViewer.this.o8() == -9223372036854775807L) {
                    PhotoViewer.this.D2 = f;
                } else {
                    PhotoViewer.this.Ha((int) (f * r0));
                }
                PhotoViewer.this.nb(false);
                PhotoViewer.this.Y2 = false;
            }
        }

        @Override // ir.nasim.C15381jU7.a
        public void b(float f) {
            if (PhotoViewer.this.A != null && PhotoViewer.this.A.L() && PhotoViewer.this.W2 != null) {
                PhotoViewer.this.W2.setProgressForYouTube(PhotoViewer.this.A, f, PhotoViewer.this.U2.i());
            } else if (PhotoViewer.this.j2 != null && PhotoViewer.this.W2 != null) {
                PhotoViewer.this.W2.setProgress(f, PhotoViewer.this.U2.i());
            }
            PhotoViewer.this.nb(true);
            PhotoViewer.this.Pb();
        }
    }

    private class E0 extends View {
        private Paint a;
        private TextPaint b;
        private int c;
        private int d;
        private int e;
        private int f;
        private String g;
        private String h;
        private int i;

        public E0(Context context) {
            super(context);
            this.a = new Paint(1);
            TextPaint textPaint = new TextPaint(1);
            this.b = textPaint;
            textPaint.setTextSize(AbstractC21455b.F(14.0f));
            this.b.setColor(-3289651);
            this.g = FH3.E("AccDescrVideoCompressLow", TD5.tgwidget_AccDescrVideoCompressLow);
            this.h = FH3.E("AccDescrVideoCompressHigh", TD5.tgwidget_AccDescrVideoCompressHigh);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (PhotoViewer.this.G6 != 1) {
                this.f = (((getMeasuredWidth() - (this.c * PhotoViewer.this.G6)) - (this.d * ((PhotoViewer.this.G6 * 2) - 2))) - (this.e * 2)) / (PhotoViewer.this.G6 - 1);
            } else {
                this.f = ((getMeasuredWidth() - (this.c * PhotoViewer.this.G6)) - (this.d * 2)) - (this.e * 2);
            }
            int measuredHeight = (getMeasuredHeight() / 2) + AbstractC21455b.F(6.0f);
            int i = 0;
            while (i < PhotoViewer.this.G6) {
                int i2 = this.e;
                int i3 = this.f + (this.d * 2);
                int i4 = this.c;
                int i5 = i2 + ((i3 + i4) * i) + (i4 / 2);
                if (i <= PhotoViewer.this.F6) {
                    this.a.setColor(-11292945);
                } else {
                    this.a.setColor(1728053247);
                }
                canvas.drawCircle(i5, measuredHeight, i == PhotoViewer.this.F6 ? AbstractC21455b.F(6.0f) : this.c / 2, this.a);
                if (i != 0) {
                    canvas.drawRect((i == PhotoViewer.this.F6 + 1 ? AbstractC21455b.H(2.0f) : 0.0f) + (((i5 - (this.c / 2)) - this.d) - this.f), measuredHeight - AbstractC21455b.F(1.0f), (r0 + this.f) - (i == PhotoViewer.this.F6 ? AbstractC21455b.H(2.0f) : 0.0f), AbstractC21455b.F(2.0f) + measuredHeight, this.a);
                }
                i++;
            }
            canvas.drawText(this.g, this.e, measuredHeight - AbstractC21455b.F(16.0f), this.b);
            canvas.drawText(this.h, (getMeasuredWidth() - this.e) - this.b.measureText(this.h), measuredHeight - AbstractC21455b.F(16.0f), this.b);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.c = AbstractC21455b.F(8.0f);
            this.d = AbstractC21455b.F(2.0f);
            this.e = AbstractC21455b.F(18.0f);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) throws IOException {
            float x = motionEvent.getX();
            if (motionEvent.getAction() == 0) {
                this.i = PhotoViewer.this.F6;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                int i = 0;
                while (true) {
                    if (i >= PhotoViewer.this.G6) {
                        break;
                    }
                    int i2 = this.e;
                    int i3 = this.f;
                    int i4 = this.d;
                    int i5 = this.c;
                    int i6 = i2 + (((i4 * 2) + i3 + i5) * i) + (i5 / 2);
                    int i7 = (i3 / 2) + (i5 / 2) + i4;
                    if (x <= i6 - i7 || x >= i6 + i7) {
                        i++;
                    } else if (PhotoViewer.this.F6 != i) {
                        PhotoViewer.this.F6 = i;
                        PhotoViewer.this.M7(false);
                        invalidate();
                    }
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (PhotoViewer.this.F6 != this.i) {
                    PhotoViewer.this.Ca(1);
                }
                PhotoViewer.this.L5 = false;
            }
            return true;
        }
    }

    class F extends AbstractC12972fU7 {
        F() {
        }

        @Override // ir.nasim.AbstractC12972fU7
        protected void A(long j, float f, boolean z) {
            PhotoViewer.this.w1.i(Math.abs(j));
            if (z) {
                PhotoViewer.this.U2.s(f);
                PhotoViewer.this.V2.invalidate();
            }
            ir.nasim.tgwidgets.editor.ui.Components.w.c1(j, f, z);
        }

        @Override // ir.nasim.AbstractC12972fU7
        protected void u() {
            PhotoViewer.this.ma(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
            PhotoViewer.this.w1.h(false);
            ir.nasim.tgwidgets.editor.ui.Components.w.Y0();
        }

        @Override // ir.nasim.AbstractC12972fU7
        protected void v(boolean z) {
            PhotoViewer.this.w1.f(false);
            PhotoViewer.this.w1.e(!z);
            PhotoViewer.this.w1.h(true);
            PhotoViewer.this.z.invalidate();
            ir.nasim.tgwidgets.editor.ui.Components.w.a1(z);
        }
    }

    private class F0 {
        private int a;
        private ArrayList b;
        private C0 c;

        public F0(int i, ArrayList arrayList, C0 c0) {
            this.b = arrayList;
            this.a = i;
            this.c = c0;
        }

        public void a() throws InterruptedException, Resources.NotFoundException {
            PhotoViewer.this.b = this.c;
            PhotoViewer.this.y.flags = -2147286784;
            PhotoViewer.this.y.softInputMode = (PhotoViewer.this.v1 ? 32 : 16) | 256;
            PhotoViewer.this.B.setFocusable(false);
            PhotoViewer.this.z.setFocusable(false);
            PhotoViewer.this.N0.setAlpha(255);
            PhotoViewer.this.z.setAlpha(1.0f);
            PhotoViewer photoViewer = PhotoViewer.this;
            ArrayList arrayList = this.b;
            int i = this.a;
            photoViewer.ja(null, null, null, null, arrayList, null, i, this.c.getPlaceForPhoto((C10743c74) arrayList.get(i), null, this.a, true));
        }
    }

    class G extends AbstractC14392hq2 {
        final /* synthetic */ C15381jU7.a e;

        G(C15381jU7.a aVar) {
            this.e = aVar;
        }

        @Override // ir.nasim.AbstractC14392hq2
        public float n() {
            return PhotoViewer.this.U2.g();
        }

        @Override // ir.nasim.AbstractC14392hq2
        public void o(float f) {
            this.e.a(f);
            PhotoViewer.this.U2.s(f);
            PhotoViewer.this.V2.invalidate();
        }

        @Override // ir.nasim.AbstractC21558tk6
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public String f(View view) {
            return FH3.r("AccDescrPlayerDuration", TD5.tgwidget_AccDescrPlayerDuration, FH3.o("Minutes", PhotoViewer.this.Q2[0], new Object[0]) + ' ' + FH3.o("Seconds", PhotoViewer.this.Q2[1], new Object[0]), FH3.o("Minutes", PhotoViewer.this.R2[0], new Object[0]) + ' ' + FH3.o("Seconds", PhotoViewer.this.R2[1], new Object[0]));
        }
    }

    private static class G0 {
        public final float a;
        public final long b;

        public G0(float f, long j) {
            this.a = f;
            this.b = j;
        }
    }

    class H extends View {
        H(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            PhotoViewer.this.U2.d(canvas, this);
        }
    }

    private static class H0 extends RecyclerListView {
        private Drawable T2;
        private Paint U2;
        private RectF V2;

        public H0(Context context) {
            super(context);
            this.U2 = new Paint(1);
            this.V2 = new RectF();
            setWillNotDraw(false);
            setClipToPadding(false);
            setTranslationY(-AbstractC21455b.F(10.0f));
            setPadding(AbstractC21455b.F(12.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(6.0f));
            this.U2.setColor(2130706432);
            this.T2 = context.getResources().getDrawable(AbstractC23598xB5.photo_tooltip2).mutate();
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int childCount = getChildCount();
            if (childCount > 0) {
                int measuredWidth = getMeasuredWidth() - AbstractC21455b.F(87.0f);
                Drawable drawable = this.T2;
                drawable.setBounds(measuredWidth, 0, drawable.getIntrinsicWidth() + measuredWidth, AbstractC21455b.F(6.0f));
                this.T2.draw(canvas);
                int iMax = Integer.MIN_VALUE;
                int iMin = Integer.MAX_VALUE;
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    iMin = (int) Math.min(iMin, Math.floor(childAt.getX()));
                    iMax = (int) Math.max(iMax, Math.ceil(childAt.getX() + childAt.getMeasuredWidth()));
                }
                if (iMin == Integer.MAX_VALUE || iMax == Integer.MIN_VALUE) {
                    return;
                }
                this.V2.set(iMin - AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f), iMax + AbstractC21455b.F(6.0f), AbstractC21455b.F(103.0f));
                canvas.drawRoundRect(this.V2, AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), this.U2);
            }
        }
    }

    class I extends VideoSeekPreviewImage {
        I(Context context, VideoSeekPreviewImage.a aVar) {
            super(context, aVar);
        }

        @Override // android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            PhotoViewer.this.Pb();
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            super.setVisibility(i);
            if (i == 0) {
                PhotoViewer.this.Pb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class I0 extends FrameLayout {
        private float a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private int g;
        private C19136pq2 h;
        private C16463lJ6 i;

        public I0(Context context) {
            super(context);
            this.a = 1.0f;
            this.c = true;
            this.h = new C19136pq2(0.0f);
            this.i = (C16463lJ6) new C16463lJ6(this.h).A(new C17645nJ6(0.0f).f(750.0f).d(1.0f)).c(new AbstractC12098e22.r() { // from class: ir.nasim.tgwidgets.editor.ui.N
                @Override // ir.nasim.AbstractC12098e22.r
                public final void a(AbstractC12098e22 abstractC12098e22, float f, float f2) {
                    this.a.e(abstractC12098e22, f, f2);
                }
            });
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(AbstractC12098e22 abstractC12098e22, float f, float f2) {
            PhotoViewer.this.U2.u((int) (((getMeasuredWidth() - AbstractC21455b.F(16.0f)) - f) - (this.e > this.f ? AbstractC21455b.F(48.0f) : 0)), getMeasuredHeight());
        }

        private void f(float f) {
            PhotoViewer.this.S2.setAlpha(f);
            PhotoViewer.this.T2.setAlpha(f);
            if (!this.b) {
                if (this.c) {
                    setTranslationY(AbstractC21455b.H(24.0f) * (1.0f - f));
                }
                PhotoViewer.this.V2.setAlpha(f);
                return;
            }
            PhotoViewer.this.S2.setPivotX(PhotoViewer.this.S2.getWidth());
            PhotoViewer.this.S2.setPivotY(PhotoViewer.this.S2.getHeight());
            float f2 = 1.0f - f;
            float f3 = 1.0f - (0.1f * f2);
            PhotoViewer.this.S2.setScaleX(f3);
            PhotoViewer.this.S2.setScaleY(f3);
            PhotoViewer.this.U2.v(f2);
        }

        public float d() {
            return this.a;
        }

        public void g(float f) {
            if (this.a != f) {
                this.a = f;
                f(f);
            }
        }

        public void h(boolean z) {
            if (this.b != z) {
                this.b = z;
                if (z) {
                    setTranslationY(0.0f);
                    PhotoViewer.this.V2.setAlpha(1.0f);
                } else {
                    PhotoViewer.this.S2.setScaleX(1.0f);
                    PhotoViewer.this.S2.setScaleY(1.0f);
                    PhotoViewer.this.U2.v(0.0f);
                }
                f(this.a);
            }
        }

        public void i(boolean z) {
            if (this.c != z) {
                this.c = z;
                if (!z) {
                    setTranslationY(0.0f);
                }
                f(this.a);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.h.b(0.0f);
            this.g = 0;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            float fS1 = PhotoViewer.this.j2 != null ? PhotoViewer.this.j2.s1() / PhotoViewer.this.j2.u1() : 0.0f;
            if (PhotoViewer.this.z2) {
                PhotoViewer.this.U2.s(fS1);
            }
            PhotoViewer.this.y6.setProgress(fS1);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x011d  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r9, int r10) {
            /*
                Method dump skipped, instructions count: 320
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.I0.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.a < 1.0f) {
                return false;
            }
            if (PhotoViewer.this.U2.m(motionEvent.getAction(), motionEvent.getX() - AbstractC21455b.F(2.0f), motionEvent.getY())) {
                getParent().requestDisallowInterceptTouchEvent(true);
                PhotoViewer.this.V2.invalidate();
            }
            return true;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.d) {
                return;
            }
            super.requestLayout();
        }
    }

    class J extends OrientationEventListener {
        J(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (PhotoViewer.this.x3 == null || PhotoViewer.this.e2 == null || PhotoViewer.this.e2.getVisibility() != 0) {
                return;
            }
            PhotoViewer photoViewer = PhotoViewer.this;
            if (photoViewer.m == null || photoViewer.z3 == 0) {
                return;
            }
            if (PhotoViewer.this.z3 != 1) {
                if (i > 0 && (i >= 330 || i <= 30)) {
                    PhotoViewer.this.A3 = true;
                    return;
                }
                if (!PhotoViewer.this.A3 || i < 240 || i > 300) {
                    return;
                }
                PhotoViewer photoViewer2 = PhotoViewer.this;
                photoViewer2.m.setRequestedOrientation(photoViewer2.y3);
                PhotoViewer.this.z3 = 0;
                PhotoViewer.this.A3 = false;
                return;
            }
            if (i >= 240 && i <= 300) {
                PhotoViewer.this.A3 = true;
                return;
            }
            if (!PhotoViewer.this.A3 || i <= 0) {
                return;
            }
            if (i >= 330 || i <= 30) {
                PhotoViewer photoViewer3 = PhotoViewer.this;
                photoViewer3.m.setRequestedOrientation(photoViewer3.y3);
                PhotoViewer.this.z3 = 0;
                PhotoViewer.this.A3 = false;
            }
        }
    }

    class K extends FT7 {
        K() {
        }

        @Override // ir.nasim.FT7
        public void D1() {
            super.D1();
            if (PhotoViewer.this.a4 == 0) {
                PhotoViewer.this.ta(false);
            }
        }

        @Override // ir.nasim.FT7
        public void E1() {
            super.E1();
            PhotoViewer.this.ta(true);
        }

        @Override // ir.nasim.FT7
        public void I1(long j) throws InterruptedException {
            super.I1(j);
            if (PhotoViewer.this.n1) {
                PhotoViewer.this.Ga(j);
            }
        }
    }

    class L implements FT7.d {
        L() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            PhotoViewer.this.i2.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            PhotoViewer.this.i2.g();
        }

        @Override // ir.nasim.FT7.d
        public void b(InterfaceC6170Mm.a aVar) {
            if (aVar.e == PhotoViewer.this.E6) {
                PhotoViewer.this.D6 = aVar.e;
                PhotoViewer.this.E6 = -1L;
                PhotoViewer.this.r7();
            }
            if (PhotoViewer.this.i2 != null) {
                if (PhotoViewer.this.j2 == null || !PhotoViewer.this.j2.y1()) {
                    AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.i();
                        }
                    }, 64L);
                }
            }
        }

        @Override // ir.nasim.FT7.d
        public void c(boolean z, int i) {
            PhotoViewer.this.Kb(z, i);
        }

        @Override // ir.nasim.FT7.d
        public void e(int i, int i2, int i3, float f) {
            if (PhotoViewer.this.e2 != null) {
                if (i3 == 90 || i3 == 270) {
                    i2 = i;
                    i = i2;
                }
                float f2 = i * f;
                int i4 = (int) f2;
                PhotoViewer.this.w = i4;
                float f3 = i2;
                PhotoViewer.this.x = (int) (f * f3);
                PhotoViewer.this.e2.setAspectRatio(i2 == 0 ? 1.0f : f2 / f3);
                if (PhotoViewer.this.h2 instanceof VideoEditTextureView) {
                    ((VideoEditTextureView) PhotoViewer.this.h2).setVideoSize(i4, i2);
                    if (PhotoViewer.this.L1 == 1) {
                        PhotoViewer.this.Oa();
                    }
                }
                PhotoViewer.this.k3 = true;
            }
        }

        @Override // ir.nasim.FT7.d
        public void s() {
            if (!PhotoViewer.this.j3) {
                PhotoViewer.this.j3 = true;
                PhotoViewer.this.z.invalidate();
            }
            if (PhotoViewer.this.i2 != null) {
                if (PhotoViewer.this.j2 == null || !PhotoViewer.this.j2.y1()) {
                    AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.h();
                        }
                    }, 64L);
                }
            }
        }
    }

    class M extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        M(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            PhotoViewer.this.M2.setVisibility(8);
        }
    }

    class N implements PhotoCropView.g {
        N() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            PhotoViewer.this.k2 = false;
            if (PhotoViewer.this.j2 != null) {
                PhotoViewer.this.j2.E1();
            }
            PhotoViewer.this.l2 = null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public void a() {
            PhotoViewer.this.z.invalidate();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public void b() {
            if (PhotoViewer.this.L1 == 1) {
                PhotoViewer.this.k2 = true;
                PhotoViewer.this.Bb();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public void c(boolean z) {
            PhotoViewer.this.Lb(!z);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public boolean d() {
            return PhotoViewer.this.G7();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public void e() {
            if (PhotoViewer.this.j2 == null) {
                return;
            }
            PhotoViewer.this.j2.I1((long) (PhotoViewer.this.j2.u1() * PhotoViewer.this.d7));
            PhotoViewer.this.j2.D1();
            PhotoViewer.this.y6.setProgress(PhotoViewer.this.d7);
            PhotoViewer.this.q7();
            PhotoViewer photoViewer = PhotoViewer.this;
            Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i();
                }
            };
            photoViewer.l2 = runnable;
            AbstractC21455b.n1(runnable, 860L);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public int f() {
            return (int) (AbstractC21455b.F(16.0f) + ((PhotoViewer.this.y6.getMeasuredWidth() - AbstractC21455b.F(32.0f)) * PhotoViewer.this.d7));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoCropView.g
        public boolean g() {
            return PhotoViewer.this.H7(-90.0f);
        }
    }

    class O extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PhotoViewer.this.R6 && PhotoViewer.this.n1) {
                    PhotoViewer.this.Nb();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PhotoViewer.this.m6.d().setVisibility(0);
                PhotoViewer.this.R0.setVisibility(0);
                if (PhotoViewer.this.Sb()) {
                    PhotoViewer.this.z0.setVisibility(0);
                } else {
                    PhotoViewer.this.S0.setVisibility(0);
                }
                PhotoViewer.this.o.setVisibility(0);
                if (PhotoViewer.this.O1) {
                    PhotoViewer.this.H1.setVisibility(PhotoViewer.this.H1.getTag() != null ? 0 : 4);
                }
                if (PhotoViewer.this.L1 == 0 || PhotoViewer.this.L1 == 4 || ((PhotoViewer.this.L1 == 2 || PhotoViewer.this.L1 == 5) && PhotoViewer.this.h6.size() > 1 && PhotoViewer.this.L1 != 99)) {
                    PhotoViewer.this.P0.setVisibility(0);
                    PhotoViewer.this.Q0.setVisibility(0);
                    PhotoViewer.this.Db();
                }
            }
        }

        O(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws InterruptedException, Resources.NotFoundException {
            if (PhotoViewer.this.a4 == 1) {
                PhotoViewer.this.y1.o();
                PhotoViewer.this.y1.p();
                PhotoViewer.this.T0.setVisibility(8);
                PhotoViewer.this.y1.setVisibility(8);
                PhotoViewer.this.y1.c.a.setRotationScaleTranslation(0.0f, 1.0f, 0.0f, 0.0f);
            } else if (PhotoViewer.this.a4 == 2) {
                try {
                    PhotoViewer.this.z.removeView(PhotoViewer.this.E1);
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
                PhotoViewer.this.E1 = null;
            } else if (PhotoViewer.this.a4 == 3) {
                PhotoViewer.this.F1.m(false);
                try {
                    PhotoViewer.this.z.removeView(PhotoViewer.this.F1.getView());
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
                PhotoViewer.this.F1 = null;
            }
            PhotoViewer.this.r5 = null;
            PhotoViewer.this.a4 = this.a;
            PhotoViewer.this.q5 = -1;
            PhotoViewer.this.o5 = false;
            if (PhotoViewer.this.L1 == 1) {
                PhotoViewer.this.y1.setVisibility(0);
            }
            PhotoViewer.this.j5 = 1.0f;
            PhotoViewer.this.h5 = 0.0f;
            PhotoViewer.this.i5 = 0.0f;
            PhotoViewer.this.e5 = 1.0f;
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.Ib(photoViewer.e5);
            PhotoViewer.this.z.invalidate();
            if (PhotoViewer.this.j6 != null) {
                PhotoViewer.this.j6.a();
                PhotoViewer.this.j6 = null;
                q0 q0VarA = new q0().a(false);
                PhotoViewer.this.wb(false, false, q0VarA);
                PhotoViewer.this.wb(true, true, q0VarA);
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroupD = PhotoViewer.this.m6.d();
            Property property = View.TRANSLATION_Y;
            arrayList.add(ObjectAnimator.ofFloat(viewGroupD, (Property<ViewGroup, Float>) property, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.R0, (Property<FrameLayout, Float>) property, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.S0, (Property<ImageView, Float>) property, 0.0f));
            if (PhotoViewer.this.L1 != 1) {
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.o, (Property<ActionBar, Float>) property, 0.0f));
            }
            if (PhotoViewer.this.O1) {
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.H1, (Property<s0, Float>) property, 0.0f));
            }
            if (PhotoViewer.this.L1 == 0 || PhotoViewer.this.L1 == 4) {
                CheckBox checkBox = PhotoViewer.this.P0;
                Property property2 = View.ALPHA;
                arrayList.add(ObjectAnimator.ofFloat(checkBox, (Property<CheckBox, Float>) property2, 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.Q0, (Property<CounterView, Float>) property2, 1.0f));
            } else if (PhotoViewer.this.L1 == 1) {
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.y1, (Property<PhotoCropView, Float>) View.ALPHA, 1.0f));
            }
            if (PhotoViewer.this.b1.getTag() != null) {
                PhotoViewer.this.b1.setVisibility(0);
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.b1, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            }
            if (PhotoViewer.this.e1.getTag() != null) {
                PhotoViewer.this.e1.setVisibility(0);
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.e1, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            }
            if (PhotoViewer.this.H != null) {
                PhotoViewer.this.H.setVisibility(0);
                arrayList.add(ObjectAnimator.ofFloat(PhotoViewer.this.H, (Property<View, Float>) View.ALPHA, 1.0f));
            }
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(200L);
            animatorSet.addListener(new a());
            animatorSet.start();
        }
    }

    class P extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.y1.n();
                PhotoViewer.this.y1.q();
                PhotoViewer.this.r5 = null;
                P p = P.this;
                PhotoViewer.this.a4 = p.a;
                PhotoViewer.this.q5 = -1;
                PhotoViewer.this.j5 = 1.0f;
                PhotoViewer.this.h5 = 0.0f;
                PhotoViewer.this.i5 = 0.0f;
                PhotoViewer.this.e5 = 1.0f;
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.Ib(photoViewer.e5);
                PhotoViewer.this.Y1 = true;
                PhotoViewer.this.z.invalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PhotoViewer.this.T0.setVisibility(0);
                PhotoViewer.this.y1.setVisibility(0);
            }
        }

        P(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.s5 = null;
            PhotoViewer.this.m6.d().setVisibility(8);
            PhotoViewer.this.R0.setVisibility(8);
            PhotoViewer.this.S0.setVisibility(8);
            PhotoViewer.this.z0.setVisibility(8);
            PhotoViewer.this.b1.setVisibility(8);
            PhotoViewer.this.e1.setVisibility(8);
            PhotoViewer.this.j1.setVisibility(8);
            PhotoViewer.this.j1.setAlpha(0.0f);
            PhotoViewer.this.j1.setTranslationY(-AbstractC21455b.F(10.0f));
            PhotoViewer.this.Q0.setRotationX(0.0f);
            PhotoViewer.this.j1.setEnabled(false);
            PhotoViewer.this.q = false;
            if (PhotoViewer.this.O1) {
                PhotoViewer.this.H1.setVisibility(4);
            }
            if (PhotoViewer.this.L1 == 0 || PhotoViewer.this.L1 == 4 || (((PhotoViewer.this.L1 == 2 || PhotoViewer.this.L1 == 5) && PhotoViewer.this.h6.size() > 1) || PhotoViewer.this.L1 == 99)) {
                PhotoViewer.this.P0.setVisibility(8);
                PhotoViewer.this.Q0.setVisibility(8);
                PhotoViewer.this.Db();
            }
            Bitmap bitmapL = PhotoViewer.this.i4.l();
            if (bitmapL != null || PhotoViewer.this.n1) {
                PhotoViewer.this.y1.setBitmap(bitmapL, PhotoViewer.this.i4.Q(), PhotoViewer.this.L1 != 1, false, PhotoViewer.this.e4, PhotoViewer.this.z1, PhotoViewer.this.n1 ? (VideoEditTextureView) PhotoViewer.this.h2 : null, PhotoViewer.this.t4.c);
                PhotoViewer.this.y1.o();
                int iO = PhotoViewer.this.i4.o();
                int iM = PhotoViewer.this.i4.m();
                if (PhotoViewer.this.t4.c != null) {
                    if (PhotoViewer.this.t4.c.i == 90 || PhotoViewer.this.t4.c.i == 270) {
                        iM = iO;
                        iO = iM;
                    }
                    iO = (int) (iO * PhotoViewer.this.t4.c.e);
                    iM = (int) (iM * PhotoViewer.this.t4.c.f);
                }
                float f = iO;
                float f2 = iM;
                float fMin = Math.min(PhotoViewer.this.Z7() / f, PhotoViewer.this.W7() / f2);
                float fMin2 = Math.min(PhotoViewer.this.a8(1) / f, PhotoViewer.this.X7(1) / f2);
                if (PhotoViewer.this.L1 == 1) {
                    float fMin3 = Math.min(PhotoViewer.this.a8(1), PhotoViewer.this.X7(1));
                    fMin2 = Math.max(fMin3 / f, fMin3 / f2);
                }
                PhotoViewer.this.j5 = fMin2 / fMin;
                PhotoViewer.this.h5 = (r3.l8() / 2) - (PhotoViewer.this.m8() / 2);
                PhotoViewer.this.i5 = (-AbstractC21455b.F(56.0f)) + (PhotoViewer.this.A8() ? AbstractC21455b.d / 2 : 0);
                PhotoViewer.this.p5 = System.currentTimeMillis();
                PhotoViewer.this.Q5 = true;
            }
            PhotoViewer.this.r5 = new AnimatorSet();
            PhotoViewer.this.r5.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.T0, (Property<PickerBottomLayoutViewer, Float>) View.TRANSLATION_Y, AbstractC21455b.F(48.0f), 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this, (Property<PhotoViewer, Float>) AbstractC21469h.d, 0.0f, 1.0f), ObjectAnimator.ofFloat(PhotoViewer.this.y1, (Property<PhotoCropView, Float>) View.ALPHA, 0.0f, 1.0f));
            PhotoViewer.this.r5.setDuration(200L);
            PhotoViewer.this.r5.addListener(new a());
            PhotoViewer.this.r5.start();
        }
    }

    class Q extends AbstractC21469h.e {
        Q(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getAlpha());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setAlpha(f);
            if (PhotoViewer.this.y1 != null) {
                PhotoViewer.this.y1.setVideoThumbFlashAlpha(f);
            }
        }
    }

    class R extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.E1.o0();
                PhotoViewer.this.r5 = null;
                R r = R.this;
                PhotoViewer.this.a4 = r.a;
                PhotoViewer.this.q5 = -1;
                PhotoViewer.this.j5 = 1.0f;
                PhotoViewer.this.h5 = 0.0f;
                PhotoViewer.this.i5 = 0.0f;
                PhotoViewer.this.e5 = 1.0f;
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.Ib(photoViewer.e5);
                PhotoViewer.this.Y1 = true;
                PhotoViewer.this.z.invalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        R(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            float fMin;
            PhotoViewer.this.s5 = null;
            PhotoViewer.this.m6.d().setVisibility(8);
            PhotoViewer.this.R0.setVisibility(8);
            PhotoViewer.this.S0.setVisibility(8);
            PhotoViewer.this.z0.setVisibility(8);
            PhotoViewer.this.o.setVisibility(8);
            PhotoViewer.this.b1.setVisibility(8);
            PhotoViewer.this.e1.setVisibility(8);
            if (PhotoViewer.this.y1 != null) {
                PhotoViewer.this.y1.setVisibility(4);
            }
            PhotoViewer.this.j1.setVisibility(8);
            PhotoViewer.this.j1.setAlpha(0.0f);
            PhotoViewer.this.j1.setTranslationY(-AbstractC21455b.F(10.0f));
            PhotoViewer.this.Q0.setRotationX(0.0f);
            PhotoViewer.this.j1.setEnabled(false);
            PhotoViewer.this.q = false;
            if (PhotoViewer.this.O1) {
                PhotoViewer.this.H1.setVisibility(4);
            }
            if (PhotoViewer.this.L1 == 0 || PhotoViewer.this.L1 == 4 || (((PhotoViewer.this.L1 == 2 || PhotoViewer.this.L1 == 5) && PhotoViewer.this.h6.size() > 1) || PhotoViewer.this.L1 == 99)) {
                PhotoViewer.this.P0.setVisibility(8);
                PhotoViewer.this.Q0.setVisibility(8);
                PhotoViewer.this.Db();
            }
            if (PhotoViewer.this.i4.l() != null) {
                float fO = PhotoViewer.this.i4.o();
                float fM = PhotoViewer.this.i4.m();
                float fMin2 = Math.min(PhotoViewer.this.a8(2) / fO, PhotoViewer.this.X7(2) / fM);
                if (PhotoViewer.this.L1 == 1) {
                    PhotoViewer.this.i5 = -AbstractC21455b.F(36.0f);
                    fMin = PhotoViewer.this.b8(false);
                } else {
                    PhotoViewer.this.i5 = (-AbstractC21455b.F(93.0f)) + (PhotoViewer.this.A8() ? AbstractC21455b.d / 2 : 0);
                    fMin = (PhotoViewer.this.t4.c == null || !(PhotoViewer.this.t4.c.i == 90 || PhotoViewer.this.t4.c.i == 270)) ? Math.min(PhotoViewer.this.Z7() / fO, PhotoViewer.this.W7() / fM) : Math.min(PhotoViewer.this.Z7() / fM, PhotoViewer.this.W7() / fO);
                }
                PhotoViewer.this.j5 = fMin2 / fMin;
                PhotoViewer.this.h5 = (r2.l8() / 2) - (PhotoViewer.this.m8() / 2);
                PhotoViewer.this.p5 = System.currentTimeMillis();
                PhotoViewer.this.Q5 = true;
            }
            PhotoViewer.this.r5 = new AnimatorSet();
            PhotoViewer.this.r5.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this, (Property<PhotoViewer, Float>) AbstractC21469h.d, 0.0f, 1.0f), ObjectAnimator.ofFloat(PhotoViewer.this.E1.getToolsView(), (Property<FrameLayout, Float>) View.TRANSLATION_Y, AbstractC21455b.F(186.0f), 0.0f));
            PhotoViewer.this.r5.setDuration(200L);
            PhotoViewer.this.r5.addListener(new a());
            PhotoViewer.this.r5.start();
        }
    }

    class S extends AnimatorListenerAdapter {
        S() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.tb();
        }
    }

    class T extends LPhotoPaintView {
        T(Context context, Activity activity, int i, Bitmap bitmap, Bitmap bitmap2, int i2, ArrayList arrayList, MediaController.i iVar, Runnable runnable, m.h hVar) {
            super(context, activity, i, bitmap, bitmap2, i2, arrayList, iVar, runnable, hVar);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.LPhotoPaintView
        protected void E1(RLottieDrawable rLottieDrawable) throws InterruptedException {
            if (PhotoViewer.this.j2 == null) {
                return;
            }
            rLottieDrawable.t0(PhotoViewer.this.j2.s1() - (PhotoViewer.this.T6 > 0 ? PhotoViewer.this.T6 / 1000 : 0L));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.LPhotoPaintView
        protected void x2() {
            PhotoViewer.this.B.isFocusable();
        }
    }

    class U extends AnimatorListenerAdapter {
        U() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.F1.m(false);
            PhotoViewer.this.F1.init();
            PhotoViewer.this.e4.c();
            PhotoViewer.this.r5 = null;
            PhotoViewer.this.a4 = 3;
            PhotoViewer.this.q5 = -1;
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.e5 = 1.0f;
            photoViewer.j5 = 1.0f;
            PhotoViewer.this.h5 = 0.0f;
            PhotoViewer.this.i5 = 0.0f;
            PhotoViewer photoViewer2 = PhotoViewer.this;
            photoViewer2.Ib(photoViewer2.e5);
            PhotoViewer.this.Y1 = true;
            PhotoViewer.this.z.invalidate();
        }
    }

    class V extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        V(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (animator.equals(PhotoViewer.this.k)) {
                PhotoViewer.this.k = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator.equals(PhotoViewer.this.k)) {
                if (!this.a) {
                    PhotoViewer.this.W0.setVisibility(4);
                }
                PhotoViewer.this.k = null;
            }
        }
    }

    class W extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        W(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (animator.equals(PhotoViewer.this.r)) {
                PhotoViewer.this.r = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator.equals(PhotoViewer.this.r)) {
                if (!this.a) {
                    PhotoViewer.this.o.setVisibility(4);
                    if (PhotoViewer.this.G.getTag() != null) {
                        PhotoViewer.this.G.setVisibility(4);
                    }
                    if (PhotoViewer.this.H1.getTag() != null) {
                        PhotoViewer.this.H1.setVisibility(4);
                    }
                }
                PhotoViewer.this.r = null;
            }
        }
    }

    class X extends AnimatorListenerAdapter {
        X() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PhotoViewer.this.x1 == null || !PhotoViewer.this.x1.equals(animator)) {
                return;
            }
            PhotoViewer.this.j1.setVisibility(8);
            PhotoViewer.this.x1 = null;
        }
    }

    class Y extends Fade {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.I1.K0 = 1.0f;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Y(int i, boolean z, boolean z2) {
            super(i);
            this.a = z;
            this.b = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(ValueAnimator valueAnimator) {
            PhotoViewer.this.I1.K0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PhotoViewer.this.I1.invalidate();
        }

        @Override // android.transition.Fade, android.transition.Visibility
        public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
            Animator animatorOnAppear = super.onAppear(viewGroup, view, transitionValues, transitionValues2);
            if (this.a && !this.b && view == PhotoViewer.this.H1) {
                animatorOnAppear.addListener(new a());
                ((ObjectAnimator) animatorOnAppear).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.w
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.a.c(valueAnimator);
                    }
                });
            }
            return animatorOnAppear;
        }
    }

    class Z extends Fade {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.I1.setVisibility(4);
                PhotoViewer.this.I1.K0 = 1.0f;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Z(int i, boolean z, boolean z2) {
            super(i);
            this.a = z;
            this.b = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(ValueAnimator valueAnimator) {
            PhotoViewer.this.I1.K0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PhotoViewer.this.I1.invalidate();
        }

        @Override // android.transition.Fade, android.transition.Visibility
        public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
            Animator animatorOnDisappear = super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
            if (!this.a && this.b && view == PhotoViewer.this.H1) {
                animatorOnDisappear.addListener(new a());
                ((ObjectAnimator) animatorOnDisappear).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.x
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.a.c(valueAnimator);
                    }
                });
            }
            return animatorOnDisappear;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$a, reason: case insensitive filesystem */
    class C21471a implements O.a {
        final /* synthetic */ ir.nasim.tgwidgets.editor.ui.O a;

        C21471a(ir.nasim.tgwidgets.editor.ui.O o) {
            this.a = o;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void a() {
            PhotoViewer.this.P0.animate().alpha(1.0f).setDuration(220L).start();
            PhotoViewer.this.Q0.animate().alpha(1.0f).setDuration(220L).start();
            if (PhotoViewer.this.Y3 != null) {
                PhotoViewer.this.s.j(PhotoViewer.this.Y3, true, false);
                PhotoViewer.this.Y3 = null;
            }
            PhotoViewer.this.x7(true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void b() {
            if (PhotoViewer.this.n1) {
                if (!PhotoViewer.this.R6 || !(PhotoViewer.this.h2 instanceof VideoEditTextureView)) {
                    return;
                }
                VideoEditTextureView videoEditTextureView = (VideoEditTextureView) PhotoViewer.this.h2;
                if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                    return;
                }
            }
            PhotoViewer.this.rb(1);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void c() throws InterruptedException, IOException {
            PhotoViewer.this.Ka(true, 0);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void d() {
            if (PhotoViewer.this.n1) {
                if (!PhotoViewer.this.R6 || !(PhotoViewer.this.h2 instanceof VideoEditTextureView)) {
                    return;
                }
                VideoEditTextureView videoEditTextureView = (VideoEditTextureView) PhotoViewer.this.h2;
                if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                    return;
                }
            }
            PhotoViewer.this.rb(3);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void e() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void f() {
            if (PhotoViewer.this.B.isFocusable()) {
                return;
            }
            PhotoViewer.this.Y9();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void g() {
            String str;
            int i;
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.a2 = true;
            photoViewer.j1.setEnabled(false);
            PhotoViewer.this.Q0.setRotationX(0.0f);
            PhotoViewer.this.q = false;
            PhotoViewer photoViewer2 = PhotoViewer.this;
            photoViewer2.Y3 = photoViewer2.s.e();
            if (PhotoViewer.this.n1) {
                B0 b0 = PhotoViewer.this.s;
                if (PhotoViewer.this.f) {
                    str = "GifCaption";
                    i = TD5.tgwidget_GifCaption;
                } else {
                    str = "VideoCaption";
                    i = TD5.tgwidget_VideoCaption;
                }
                b0.j(FH3.E(str, i), true, false);
            } else {
                PhotoViewer.this.s.j(FH3.E("PhotoCaption", TD5.tgwidget_PhotoCaption), true, false);
            }
            PhotoViewer.this.P0.animate().alpha(0.0f).setDuration(220L).start();
            PhotoViewer.this.Q0.animate().alpha(0.0f).setDuration(220L).start();
            PhotoViewer.this.j1.animate().alpha(0.0f).translationY(-AbstractC21455b.F(10.0f)).setDuration(220L).start();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void onCaptionChanged(CharSequence charSequence) {
            PhotoViewer.this.b.onCaptionChanged(charSequence);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.O.a
        public void onDoneButtonClicked() {
            this.a.h();
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$a0, reason: case insensitive filesystem */
    class C21472a0 extends Transition {

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$a0$a */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.H1.getNextView().setText((CharSequence) null);
                PhotoViewer.this.I1.f0();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                PhotoViewer.this.I1.k0();
            }
        }

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$a0$b */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.H1.setTranslationY(0.0f);
            }
        }

        C21472a0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(ValueAnimator valueAnimator) {
            PhotoViewer.this.I1.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            if (transitionValues.view == PhotoViewer.this.H1) {
                transitionValues.values.put("translationY", Integer.valueOf(PhotoViewer.this.I1.getPendingMarginTopDiff()));
            }
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            if (transitionValues.view == PhotoViewer.this.I1) {
                transitionValues.values.put("scrollY", Integer.valueOf(PhotoViewer.this.I1.getScrollY()));
            }
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            int iIntValue;
            if (transitionValues.view == PhotoViewer.this.I1) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(((Integer) transitionValues.values.get("scrollY")).intValue(), 0);
                valueAnimatorOfInt.addListener(new a());
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.y
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.a.c(valueAnimator);
                    }
                });
                return valueAnimatorOfInt;
            }
            if (transitionValues2.view != PhotoViewer.this.H1 || (iIntValue = ((Integer) transitionValues2.values.get("translationY")).intValue()) == 0) {
                return null;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(PhotoViewer.this.H1, (Property<s0, Float>) View.TRANSLATION_Y, 0.0f, iIntValue);
            objectAnimatorOfFloat.addListener(new b());
            return objectAnimatorOfFloat;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$b, reason: case insensitive filesystem */
    class C21473b extends FrameLayout {
        C21473b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PhotoViewer.this.P0.getLayoutParams();
            ((WindowManager) AbstractC14047hG.a.getSystemService("window")).getDefaultDisplay().getRotation();
            int currentActionBarHeight = ((ActionBar.getCurrentActionBarHeight() - AbstractC21455b.F(34.0f)) / 2) + (PhotoViewer.this.A8() ? AbstractC21455b.d : 0);
            if (currentActionBarHeight != layoutParams.topMargin) {
                layoutParams.topMargin = currentActionBarHeight;
                PhotoViewer.this.P0.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) PhotoViewer.this.Q0.getLayoutParams();
            int currentActionBarHeight2 = ((ActionBar.getCurrentActionBarHeight() - AbstractC21455b.F(40.0f)) / 2) + (PhotoViewer.this.A8() ? AbstractC21455b.d : 0);
            if (layoutParams2.topMargin != currentActionBarHeight2) {
                layoutParams2.topMargin = currentActionBarHeight2;
                PhotoViewer.this.Q0.setLayoutParams(layoutParams2);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            keyEvent.getKeyCode();
            if (!PhotoViewer.this.f && PhotoViewer.this.L1 != 1 && PhotoViewer.this.n1 && PhotoViewer.this.j2 != null && keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0 && (keyEvent.getKeyCode() == 24 || keyEvent.getKeyCode() == 25)) {
                PhotoViewer.this.j2.S1(1.0f);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            if (PhotoViewer.this.m6.i()) {
                PhotoViewer.this.x7(true);
                return false;
            }
            PhotoViewer.k8().z7(true, false);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean dispatchTouchEvent(android.view.MotionEvent r3) {
            /*
                r2 = this;
                ir.nasim.tgwidgets.editor.ui.PhotoViewer r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.this
                boolean r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.z3(r0)
                if (r0 == 0) goto L32
                ir.nasim.tgwidgets.editor.ui.PhotoViewer r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.this
                boolean r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.W1(r0)
                if (r0 == 0) goto L32
                int r0 = r3.getActionMasked()
                if (r0 == 0) goto L29
                r1 = 1
                if (r0 == r1) goto L23
                r1 = 3
                if (r0 == r1) goto L23
                r1 = 5
                if (r0 == r1) goto L29
                r1 = 6
                if (r0 == r1) goto L23
                goto L32
            L23:
                ir.nasim.tgwidgets.editor.ui.PhotoViewer r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.this
                ir.nasim.tgwidgets.editor.ui.PhotoViewer.n6(r0)
                goto L32
            L29:
                ir.nasim.tgwidgets.editor.ui.PhotoViewer r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.this
                java.lang.Runnable r0 = ir.nasim.tgwidgets.editor.ui.PhotoViewer.J1(r0)
                ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.t(r0)
            L32:
                boolean r3 = super.dispatchTouchEvent(r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.C21473b.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            try {
                return super.drawChild(canvas, view, j);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.view.View, android.view.ViewParent
        public int getLayoutDirection() {
            return 0;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() throws InterruptedException {
            super.onAttachedToWindow();
            PhotoViewer.this.i4.q0();
            PhotoViewer.this.h4.q0();
            PhotoViewer.this.j4.q0();
            PhotoViewer.this.X4 = true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() throws InterruptedException {
            super.onDetachedFromWindow();
            PhotoViewer.this.i4.s0();
            PhotoViewer.this.h4.s0();
            PhotoViewer.this.j4.s0();
            PhotoViewer.this.X4 = false;
            PhotoViewer.this.Y4 = false;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (!PhotoViewer.this.c || PhotoViewer.this.X1 == null) {
                return;
            }
            WindowInsets windowInsets = (WindowInsets) PhotoViewer.this.X1;
            PhotoViewer.this.O0.setAlpha(PhotoViewer.this.N0.getAlpha());
            canvas.drawRect(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight() + windowInsets.getSystemWindowInsetBottom(), PhotoViewer.this.O0);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.c && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            PhotoViewer.this.D.layout(getPaddingLeft(), 0, getPaddingLeft() + PhotoViewer.this.D.getMeasuredWidth(), PhotoViewer.this.D.getMeasuredHeight());
            PhotoViewer.this.z.layout(getPaddingLeft(), 0, getPaddingLeft() + PhotoViewer.this.z.getMeasuredWidth(), PhotoViewer.this.z.getMeasuredHeight());
            PhotoViewer.this.H.layout(getPaddingLeft(), PhotoViewer.this.z.getMeasuredHeight(), PhotoViewer.this.H.getMeasuredWidth(), PhotoViewer.this.z.getMeasuredHeight() + PhotoViewer.this.H.getMeasuredHeight());
            PhotoViewer.this.Y4 = true;
            if (z) {
                if (!PhotoViewer.this.Z4) {
                    PhotoViewer.this.e5 = 1.0f;
                    PhotoViewer.this.c5 = 0.0f;
                    PhotoViewer.this.d5 = 0.0f;
                    PhotoViewer photoViewer = PhotoViewer.this;
                    photoViewer.Ib(photoViewer.e5);
                }
                if (PhotoViewer.this.P0 != null) {
                    PhotoViewer.this.P0.post(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b();
                        }
                    });
                }
            }
            if (PhotoViewer.this.Z4) {
                PhotoViewer.this.fb();
                PhotoViewer.this.Z4 = false;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int i3;
            int stableInsetBottom;
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (PhotoViewer.this.X1 != null) {
                WindowInsets windowInsets = (WindowInsets) PhotoViewer.this.X1;
                if (!PhotoViewer.this.g) {
                    if (AbstractC21455b.n) {
                        int i4 = AbstractC21455b.h.y;
                        if (size2 > i4) {
                            size2 = i4;
                        }
                        size2 += AbstractC21455b.d;
                    } else if (windowInsets.getStableInsetBottom() >= 0 && (i3 = AbstractC21455b.d) >= 0 && (stableInsetBottom = (size2 - i3) - windowInsets.getStableInsetBottom()) > 0 && stableInsetBottom < 4096) {
                        AbstractC21455b.h.y = stableInsetBottom;
                    }
                }
                int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                if (PhotoViewer.this.K1.L()) {
                    systemWindowInsetBottom -= PhotoViewer.this.z.getKeyboardHeight();
                }
                size2 -= systemWindowInsetBottom;
            } else {
                int i5 = AbstractC21455b.h.y;
                if (size2 > i5) {
                    size2 = i5;
                }
            }
            int paddingLeft = size - (getPaddingLeft() + getPaddingRight());
            int paddingBottom = size2 - getPaddingBottom();
            setMeasuredDimension(paddingLeft, paddingBottom);
            ViewGroup.LayoutParams layoutParams = PhotoViewer.this.D.getLayoutParams();
            PhotoViewer.this.D.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(layoutParams.height, RecyclerView.UNDEFINED_DURATION));
            PhotoViewer.this.z.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824));
            PhotoViewer.this.H.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(PhotoViewer.this.J, 1073741824));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.c && PhotoViewer.this.ma(motionEvent);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$b0, reason: case insensitive filesystem */
    class RunnableC21474b0 implements Runnable {
        RunnableC21474b0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(float f) {
            AbstractC14047hG.a.getSharedPreferences("media_saved_pos", 0).edit().putFloat(PhotoViewer.this.E2, f).commit();
        }

        @Override // java.lang.Runnable
        public void run() {
            float fX;
            if (PhotoViewer.this.j2 != null || (PhotoViewer.this.A != null && PhotoViewer.this.A.H())) {
                if (!PhotoViewer.this.n1) {
                    final float fD8 = PhotoViewer.this.d8() / PhotoViewer.this.o8();
                    if (PhotoViewer.this.V5 && !PhotoViewer.this.W5) {
                        fD8 = 0.0f;
                    }
                    if (PhotoViewer.this.A4) {
                        fX = 1.0f;
                    } else {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (Math.abs(jElapsedRealtime - PhotoViewer.this.u3) >= 500) {
                            if (PhotoViewer.this.A != null && PhotoViewer.this.A.H()) {
                                fX = PhotoViewer.this.A.getBufferedPosition();
                            } else if (PhotoViewer.this.s3) {
                                fX = C4278El2.H(PhotoViewer.this.v).x(PhotoViewer.this.D2 != 0.0f ? PhotoViewer.this.D2 : fD8, PhotoViewer.this.w4[0]);
                            } else {
                                fX = 1.0f;
                            }
                            PhotoViewer.this.u3 = jElapsedRealtime;
                        } else {
                            fX = -1.0f;
                        }
                    }
                    if (PhotoViewer.this.i7 || PhotoViewer.this.y6.getVisibility() != 0) {
                        if (PhotoViewer.this.D2 == 0.0f) {
                            PhotoViewer photoViewer = PhotoViewer.this;
                            AbstractC12972fU7 abstractC12972fU7 = photoViewer.D3;
                            if (abstractC12972fU7.a == 0 || !abstractC12972fU7.c) {
                                photoViewer.U2.t(fD8, false);
                            }
                        }
                        if (fX != -1.0f) {
                            PhotoViewer.this.U2.n(fX);
                            ir.nasim.tgwidgets.editor.ui.Components.w.h1(fX);
                        }
                    } else if (fD8 >= PhotoViewer.this.y6.getRightProgress()) {
                        PhotoViewer.this.k2 = false;
                        PhotoViewer.this.sa();
                        PhotoViewer.this.U2.s(0.0f);
                        PhotoViewer.this.Ha((int) (r1.y6.getLeftProgress() * PhotoViewer.this.o8()));
                        PhotoViewer.this.z.invalidate();
                    } else {
                        float leftProgress = fD8 - PhotoViewer.this.y6.getLeftProgress();
                        if (leftProgress < 0.0f) {
                            leftProgress = 0.0f;
                        }
                        fD8 = leftProgress / (PhotoViewer.this.y6.getRightProgress() - PhotoViewer.this.y6.getLeftProgress());
                        if (fD8 > 1.0f) {
                            fD8 = 1.0f;
                        }
                        PhotoViewer.this.U2.s(fD8);
                    }
                    PhotoViewer.this.V2.invalidate();
                    if (PhotoViewer.this.E2 != null && fD8 >= 0.0f && SystemClock.elapsedRealtime() - PhotoViewer.this.H2 >= 1000) {
                        String unused = PhotoViewer.this.E2;
                        PhotoViewer.this.H2 = SystemClock.elapsedRealtime();
                        Utilities.e.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.v
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.b(fD8);
                            }
                        });
                    }
                    PhotoViewer.this.Ob();
                } else if (!PhotoViewer.this.y6.k()) {
                    float fD82 = (!PhotoViewer.this.V5 || PhotoViewer.this.W5) ? PhotoViewer.this.d8() / PhotoViewer.this.o8() : 0.0f;
                    if (PhotoViewer.this.i7 || (PhotoViewer.this.a4 == 0 && PhotoViewer.this.y6.getVisibility() != 0)) {
                        if (PhotoViewer.this.L1 != 1) {
                            PhotoViewer.this.y6.setProgress(fD82);
                        }
                    } else if (fD82 >= PhotoViewer.this.y6.getRightProgress()) {
                        PhotoViewer.this.y6.setProgress(PhotoViewer.this.y6.getLeftProgress());
                        PhotoViewer.this.j2.I1((int) (PhotoViewer.this.y6.getLeftProgress() * PhotoViewer.this.o8()));
                        PhotoViewer.this.k2 = false;
                        PhotoViewer.this.q7();
                        if (PhotoViewer.this.f || PhotoViewer.this.L1 == 1 || PhotoViewer.this.a4 != 0 || PhotoViewer.this.q5 > 0) {
                            PhotoViewer.this.ua();
                        } else {
                            PhotoViewer.this.sa();
                        }
                        PhotoViewer.this.z.invalidate();
                    } else {
                        PhotoViewer.this.y6.setProgress(fD82);
                    }
                    PhotoViewer.this.Ob();
                }
            }
            if (PhotoViewer.this.i2 != null) {
                PhotoViewer.this.i2.g();
            }
            if (PhotoViewer.this.r3) {
                AbstractC21455b.n1(PhotoViewer.this.I3, 17L);
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$c, reason: case insensitive filesystem */
    class C21475c extends w0 {
        private Bulletin.a m;

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$c$a */
        class a implements Bulletin.a {
            a() {
            }
        }

        C21475c(Context context, Activity activity) {
            super(context, activity);
            this.m = new a();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.w0, android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            Bulletin.a(this, this.m);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.w0, android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            Bulletin.l(this);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$c0, reason: case insensitive filesystem */
    class C21476c0 extends u0 {
        private final ImageReceiver.b a;
        final /* synthetic */ C0 b;
        final /* synthetic */ C10743c74 c;
        final /* synthetic */ MediaController.m d;
        final /* synthetic */ boolean e;

        C21476c0(C0 c0, C10743c74 c10743c74, MediaController.m mVar, boolean z) {
            this.b = c0;
            this.c = c10743c74;
            this.d = mVar;
            this.e = z;
            this.a = PhotoViewer.this.i4.n();
        }

        private void a(ir.nasim.tgwidgets.editor.messenger.H h, boolean z, int i, boolean z2, boolean z3) {
            if (PhotoViewer.this.M3 != null) {
                C10743c74 c10743c74 = z2 ? this.c : null;
                if (c10743c74 == null || TextUtils.isEmpty(this.d.a)) {
                    return;
                }
                MediaController.m mVar = this.d;
                c10743c74.K = mVar.a;
                c10743c74.L = mVar.h;
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean canCaptureMorePhotos() {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z) {
            C0 c0 = this.b;
            if (c0 != null) {
                return c0.getPlaceForPhoto(this.c, null, 0, z);
            }
            return null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
            return this.a;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void replaceButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
            MediaController.m mVar = this.d;
            if (mVar.q || mVar.p || mVar.o || h != null || !TextUtils.isEmpty(mVar.a)) {
                a(h, false, 0, true, false);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h, boolean z, int i2, boolean z2) {
            a(h, z, i2, false, z2);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$d, reason: case insensitive filesystem */
    class C21477d extends ActionBar {
        C21477d(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            PhotoViewer.this.z.invalidate();
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$d0, reason: case insensitive filesystem */
    class ViewTreeObserverOnPreDrawListenerC21478d0 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ClippingImageView[] a;
        final /* synthetic */ ViewGroup.LayoutParams b;
        final /* synthetic */ float c;
        final /* synthetic */ D0 d;
        final /* synthetic */ float e;
        final /* synthetic */ C0 f;
        final /* synthetic */ ArrayList g;
        final /* synthetic */ Integer h;

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$d0$a */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                PhotoViewer.this.l6.b();
                if (PhotoViewer.this.U3 != null) {
                    PhotoViewer.this.U3.run();
                    PhotoViewer.this.U3 = null;
                }
                PhotoViewer.this.Ma(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.D
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
        }

        ViewTreeObserverOnPreDrawListenerC21478d0(ClippingImageView[] clippingImageViewArr, ViewGroup.LayoutParams layoutParams, float f, D0 d0, float f2, y0 y0Var, C0 c0, ArrayList arrayList, Integer num) {
            this.a = clippingImageViewArr;
            this.b = layoutParams;
            this.c = f;
            this.d = d0;
            this.e = f2;
            this.f = c0;
            this.g = arrayList;
            this.h = num;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(ClippingImageView[] clippingImageViewArr, ArrayList arrayList, Integer num, C0 c0) throws InterruptedException, Resources.NotFoundException {
            PhotoViewer.this.U3 = null;
            if (PhotoViewer.this.z != null) {
                PhotoViewer photoViewer = PhotoViewer.this;
                if (photoViewer.B == null) {
                    return;
                }
                photoViewer.z.setLayerType(0, null);
                PhotoViewer.this.S3 = 0;
                PhotoViewer.this.T3 = 0L;
                PhotoViewer.this.C1 = null;
                PhotoViewer.this.A1.o(false);
                PhotoViewer.this.D1 = null;
                PhotoViewer.this.B1.o(false);
                PhotoViewer.this.Ta();
                PhotoViewer.this.Oa();
                PhotoViewer.this.z.invalidate();
                for (ClippingImageView clippingImageView : clippingImageViewArr) {
                    clippingImageView.setVisibility(8);
                }
                if (PhotoViewer.this.V3 != null) {
                    PhotoViewer.this.V3.imageReceiver.t1(true, true);
                }
                if (PhotoViewer.this.W3 != null) {
                    PhotoViewer.this.W3.imageReceiver.t1(false, true);
                }
                if (arrayList != null && PhotoViewer.this.L1 != 3 && PhotoViewer.this.L1 != 1 && (PhotoViewer.this.b == null || !PhotoViewer.this.b.closeKeyboard())) {
                    PhotoViewer.this.Y9();
                }
                if (PhotoViewer.this.j2 != null && PhotoViewer.this.j2.A1() && PhotoViewer.this.n1 && !PhotoViewer.this.h6.isEmpty()) {
                    PhotoViewer photoViewer2 = PhotoViewer.this;
                    photoViewer2.Ga(photoViewer2.j2.s1());
                    PhotoViewer.this.ta(true);
                }
                if (PhotoViewer.this.Z3) {
                    PhotoViewer.this.w8(num.intValue());
                }
                if (c0 != null) {
                    c0.onOpen();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(ValueAnimator valueAnimator) {
            PhotoViewer.this.n5 = 1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(AnimatorSet animatorSet) {
            PhotoViewer.this.l6.a();
            animatorSet.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(D0 d0) {
            PhotoViewer.this.X3 = false;
            d0.imageReceiver.t1(false, true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            float fMin;
            float f;
            float measuredWidth;
            ClippingImageView[] clippingImageViewArr;
            ClippingImageView[] clippingImageViewArr2 = this.a;
            if (clippingImageViewArr2.length > 1) {
                clippingImageViewArr2[1].setAlpha(1.0f);
                this.a[1].setAdditionalTranslationX(-PhotoViewer.this.l8());
            }
            int i = 0;
            ClippingImageView clippingImageView = this.a[0];
            clippingImageView.setTranslationX(clippingImageView.getTranslationX() + PhotoViewer.this.l8());
            PhotoViewer.this.B.getViewTreeObserver().removeOnPreDrawListener(this);
            if (PhotoViewer.this.L1 == 1) {
                float f2 = PhotoViewer.this.A8() ? AbstractC21455b.d : 0;
                float measuredHeight = (PhotoViewer.this.y1.getMeasuredHeight() - AbstractC21455b.F(64.0f)) - f2;
                float measuredWidth2 = PhotoViewer.this.y1.getMeasuredWidth() / 2.0f;
                float f3 = f2 + (measuredHeight / 2.0f);
                float fMin2 = (Math.min(PhotoViewer.this.y1.getMeasuredWidth(), measuredHeight) - (AbstractC21455b.F(16.0f) * 2)) / 2.0f;
                float f4 = f3 - fMin2;
                ViewGroup.LayoutParams layoutParams = this.b;
                float f5 = (f3 + fMin2) - f4;
                fMin = Math.max(((measuredWidth2 + fMin2) - (measuredWidth2 - fMin2)) / layoutParams.width, f5 / layoutParams.height);
                f = f4 + ((f5 - (this.b.height * fMin)) / 2.0f);
                measuredWidth = ((((PhotoViewer.this.B.getMeasuredWidth() - PhotoViewer.this.l8()) - PhotoViewer.this.m8()) - (this.b.width * fMin)) / 2.0f) + PhotoViewer.this.l8();
            } else {
                fMin = Math.min(PhotoViewer.this.B.getMeasuredWidth() / this.b.width, (AbstractC21455b.h.y + (PhotoViewer.this.A8() ? AbstractC21455b.d : 0)) / this.b.height);
                f = ((AbstractC21455b.h.y + (PhotoViewer.this.A8() ? AbstractC21455b.d : 0)) - (this.b.height * fMin)) / 2.0f;
                measuredWidth = (PhotoViewer.this.B.getMeasuredWidth() - (this.b.width * fMin)) / 2.0f;
            }
            int iAbs = (int) Math.abs(this.c - this.d.imageReceiver.F());
            int iAbs2 = (int) Math.abs(this.e - this.d.imageReceiver.G());
            int[] iArr = new int[2];
            this.d.parentView.getLocationInWindow(iArr);
            int i2 = iArr[1];
            int i3 = this.d.viewY;
            float f6 = this.e;
            int i4 = (int) ((i2 - (i3 + f6)) + r13.clipTopAddition);
            if (i4 < 0) {
                i4 = 0;
            }
            int height = (int) ((((i3 + f6) + this.b.height) - (i2 + r13.parentView.getHeight())) + this.d.clipBottomAddition);
            if (height < 0) {
                height = 0;
            }
            int iMax = Math.max(i4, iAbs2);
            int iMax2 = Math.max(height, iAbs2);
            PhotoViewer.this.L3[0][0] = PhotoViewer.this.D.getScaleX();
            PhotoViewer.this.L3[0][1] = PhotoViewer.this.D.getScaleY();
            PhotoViewer.this.L3[0][2] = PhotoViewer.this.D.getTranslationX();
            PhotoViewer.this.L3[0][3] = PhotoViewer.this.D.getTranslationY();
            float f7 = iAbs;
            PhotoViewer.this.L3[0][4] = this.d.scale * f7;
            PhotoViewer.this.L3[0][5] = iMax * this.d.scale;
            PhotoViewer.this.L3[0][6] = iMax2 * this.d.scale;
            int[] radius = PhotoViewer.this.D.getRadius();
            int i5 = 0;
            while (true) {
                float f8 = 0.0f;
                if (i5 >= 4) {
                    break;
                }
                float[] fArr = PhotoViewer.this.L3[0];
                int i6 = i5 + 7;
                if (radius != null) {
                    f8 = radius[i5];
                }
                fArr[i6] = f8;
                i5++;
            }
            PhotoViewer.this.L3[0][11] = iAbs2 * this.d.scale;
            PhotoViewer.this.L3[0][12] = f7 * this.d.scale;
            PhotoViewer.this.L3[1][0] = fMin;
            PhotoViewer.this.L3[1][1] = fMin;
            PhotoViewer.this.L3[1][2] = measuredWidth;
            PhotoViewer.this.L3[1][3] = f;
            PhotoViewer.this.L3[1][4] = 0.0f;
            PhotoViewer.this.L3[1][5] = 0.0f;
            PhotoViewer.this.L3[1][6] = 0.0f;
            PhotoViewer.this.L3[1][7] = 0.0f;
            PhotoViewer.this.L3[1][8] = 0.0f;
            PhotoViewer.this.L3[1][9] = 0.0f;
            PhotoViewer.this.L3[1][10] = 0.0f;
            PhotoViewer.this.L3[1][11] = 0.0f;
            PhotoViewer.this.L3[1][12] = 0.0f;
            int i7 = 0;
            while (true) {
                ClippingImageView[] clippingImageViewArr3 = this.a;
                if (i7 >= clippingImageViewArr3.length) {
                    break;
                }
                clippingImageViewArr3[i7].setAnimationProgress(0.0f);
                i7++;
            }
            PhotoViewer.this.N0.setAlpha(0);
            PhotoViewer.this.z.setAlpha(0.0f);
            PhotoViewer.this.H.setAlpha(0.0f);
            C0 c0 = this.f;
            if (c0 != null) {
                c0.onPreOpen();
            }
            PhotoViewer photoViewer = PhotoViewer.this;
            final ClippingImageView[] clippingImageViewArr4 = this.a;
            final ArrayList arrayList = this.g;
            final Integer num = this.h;
            final C0 c02 = this.f;
            photoViewer.U3 = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.z
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException, Resources.NotFoundException {
                    this.a.e(clippingImageViewArr4, arrayList, num, c02);
                }
            };
            if (PhotoViewer.this.R1) {
                if (PhotoViewer.this.U3 != null) {
                    PhotoViewer.this.U3.run();
                    PhotoViewer.this.U3 = null;
                }
                PhotoViewer.this.z.setAlpha(1.0f);
                PhotoViewer.this.N0.setAlpha(255);
                while (true) {
                    ClippingImageView[] clippingImageViewArr5 = this.a;
                    if (i >= clippingImageViewArr5.length) {
                        break;
                    }
                    clippingImageViewArr5[i].setAnimationProgress(1.0f);
                    i++;
                }
                if (PhotoViewer.this.L1 == 1) {
                    PhotoViewer.this.y1.setAlpha(1.0f);
                }
            } else {
                final AnimatorSet animatorSet = new AnimatorSet();
                int i8 = PhotoViewer.this.L1 != 1 ? 2 : 3;
                ClippingImageView[] clippingImageViewArr6 = this.a;
                ArrayList arrayList2 = new ArrayList(i8 + clippingImageViewArr6.length + (clippingImageViewArr6.length > 1 ? 1 : 0));
                int i9 = 0;
                while (true) {
                    clippingImageViewArr = this.a;
                    if (i9 >= clippingImageViewArr.length) {
                        break;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(clippingImageViewArr[i9], (Property<ClippingImageView, Float>) AbstractC21469h.c, 0.0f, 1.0f);
                    if (i9 == 0) {
                        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.A
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                this.a.f(valueAnimator);
                            }
                        });
                    }
                    arrayList2.add(objectAnimatorOfFloat);
                    i9++;
                }
                if (clippingImageViewArr.length > 1) {
                    arrayList2.add(ObjectAnimator.ofFloat(PhotoViewer.this.D, (Property<ClippingImageView, Float>) View.ALPHA, 0.0f, 1.0f));
                }
                arrayList2.add(ObjectAnimator.ofInt(PhotoViewer.this.N0, (Property<BackgroundDrawable, Integer>) AbstractC21469h.b, 0, 255));
                w0 w0Var = PhotoViewer.this.z;
                Property property = View.ALPHA;
                arrayList2.add(ObjectAnimator.ofFloat(w0Var, (Property<w0, Float>) property, 0.0f, 1.0f));
                arrayList2.add(ObjectAnimator.ofFloat(PhotoViewer.this.H, (Property<View, Float>) property, 0.0f, 1.0f));
                if (PhotoViewer.this.L1 == 1) {
                    arrayList2.add(ObjectAnimator.ofFloat(PhotoViewer.this.y1, (Property<PhotoCropView, Float>) property, 0.0f, 1.0f));
                }
                animatorSet.playTogether(arrayList2);
                animatorSet.setDuration(200L);
                animatorSet.addListener(new a());
                PhotoViewer.this.z.setLayerType(2, null);
                PhotoViewer.this.Ma(false);
                PhotoViewer.this.T3 = System.currentTimeMillis();
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.B
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g(animatorSet);
                    }
                });
            }
            BackgroundDrawable backgroundDrawable = PhotoViewer.this.N0;
            final D0 d0 = this.d;
            backgroundDrawable.d = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.C
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(d0);
                }
            };
            return true;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$e, reason: case insensitive filesystem */
    class C21479e extends ActionBar.e {
        final /* synthetic */ m.h a;

        C21479e(m.h hVar) {
            this.a = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(boolean z, Uri uri) {
            C21470i.e(PhotoViewer.this.z, z, -115203550, -1).m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(boolean z, Uri uri) {
            C21470i.e(PhotoViewer.this.z, z, -115203550, -1).m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(DialogInterface dialogInterface, int i) {
            if (!PhotoViewer.this.b.onDeletePhoto(PhotoViewer.this.p4)) {
                PhotoViewer.this.z7(false, false);
                return;
            }
            if (PhotoViewer.this.a6.isEmpty() || PhotoViewer.this.p4 < 0 || PhotoViewer.this.p4 >= PhotoViewer.this.a6.size()) {
                return;
            }
            C10743c74 c10743c74 = (C10743c74) PhotoViewer.this.a6.get(PhotoViewer.this.p4);
            if (c10743c74.W0()) {
                PhotoViewer.this.z7(false, false);
                ArrayList arrayList = new ArrayList();
                if (PhotoViewer.this.h != 0) {
                    arrayList.add(Integer.valueOf(PhotoViewer.this.h));
                } else {
                    arrayList.add(Integer.valueOf(c10743c74.T()));
                }
                if (ZO1.c(c10743c74.F()) && c10743c74.e.O != 0) {
                    new ArrayList().add(Long.valueOf(c10743c74.e.O));
                }
                U00.e(PhotoViewer.this.m);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(DialogInterface dialogInterface, int i) {
            File fileR;
            if (PhotoViewer.this.r4 == null) {
                return;
            }
            if ((C10743c74.W(PhotoViewer.this.r4.e) instanceof C5153Ic7) && C10743c74.W(PhotoViewer.this.r4.e).B != null && C10743c74.W(PhotoViewer.this.r4.e).B.r == null) {
                PhotoViewer photoViewer = PhotoViewer.this;
                fileR = C4278El2.H(PhotoViewer.this.v).Q(photoViewer.f8(photoViewer.p4, null), true);
            } else {
                fileR = C4278El2.H(PhotoViewer.this.v).R(PhotoViewer.this.r4.e);
            }
            final boolean zC1 = PhotoViewer.this.r4.c1();
            if (fileR == null || !fileR.exists()) {
                PhotoViewer.this.kb();
                return;
            }
            MediaController.D0(fileR.toString(), PhotoViewer.this.m, zC1 ? 1 : 0, null, null, new Utilities.b() { // from class: ir.nasim.tgwidgets.editor.ui.d
                @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                public final void a(Object obj) {
                    this.a.o(zC1, (Uri) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(int[] iArr, int[] iArr2, boolean z) {
            int i = iArr[0] + 1;
            iArr[0] = i;
            if (i == iArr2[0]) {
                C21470i.d(PhotoViewer.this.z, iArr2[0], z, -115203550, -1).m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(final boolean z, ArrayList arrayList, DialogInterface dialogInterface, int i) {
            File fileR;
            final int[] iArr = new int[1];
            final int[] iArr2 = new int[1];
            final Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.r(iArr2, iArr, z);
                }
            };
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                C10743c74 c10743c74 = (C10743c74) arrayList.get(i2);
                if (c10743c74 != null) {
                    if ((C10743c74.W(c10743c74.e) instanceof C5153Ic7) && C10743c74.W(c10743c74.e).B != null && C10743c74.W(c10743c74.e).B.r == null) {
                        C4278El2 c4278El2H = C4278El2.H(PhotoViewer.this.v);
                        PhotoViewer photoViewer = PhotoViewer.this;
                        fileR = c4278El2H.Q(photoViewer.f8(photoViewer.p4, null), true);
                    } else {
                        fileR = C4278El2.H(PhotoViewer.this.v).R(c10743c74.e);
                    }
                    boolean zC1 = c10743c74.c1();
                    if (fileR != null && fileR.exists()) {
                        iArr[0] = iArr[0] + 1;
                        MediaController.D0(fileR.toString(), PhotoViewer.this.m, zC1 ? 1 : 0, null, null, new Utilities.b() { // from class: ir.nasim.tgwidgets.editor.ui.m
                            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                            public final void a(Object obj) {
                                AbstractC21455b.m1(runnable);
                            }
                        });
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(DialogInterface dialogInterface, int i) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(PhotoViewer.this.r4);
            PhotoViewer.this.mb(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(ArrayList arrayList, DialogInterface dialogInterface, int i) {
            PhotoViewer.this.mb(arrayList);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar.e
        public boolean a() {
            if (PhotoViewer.this.r4 != null) {
                return true;
            }
            if (PhotoViewer.this.v4 != null) {
                File fileO = C4278El2.H(PhotoViewer.this.v).O(PhotoViewer.g8(PhotoViewer.this.v4), PhotoViewer.h8(PhotoViewer.this.v4), PhotoViewer.this.G4 != 0 || PhotoViewer.this.I4);
                return fileO.exists() || new File(C4278El2.B(4), fileO.getName()).exists();
            }
            PhotoViewer.y2(PhotoViewer.this);
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v19, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v20 */
        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar.e
        public void b(int i) {
            Object[] objArr;
            final ?? r4;
            File fileR;
            boolean z = true;
            if (i == -1) {
                if (PhotoViewer.this.F1 == null || !PhotoViewer.this.F1.a()) {
                    if (PhotoViewer.this.O1 && PhotoViewer.this.m6.i()) {
                        PhotoViewer.this.x7(false);
                        return;
                    } else {
                        PhotoViewer.this.z7(true, false);
                        return;
                    }
                }
                return;
            }
            File fileO = null;
            if (i == 1) {
                if ((Build.VERSION.SDK_INT <= 28 || AbstractC8814Xl0.e) && PhotoViewer.this.m.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    PhotoViewer.this.m.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
                    return;
                }
                final ArrayList arrayList = new ArrayList(1);
                arrayList.add(PhotoViewer.this.r4);
                if (arrayList.size() > 1) {
                    final boolean z2 = false;
                    for (int i2 = 0; i2 < arrayList.size() && !z2; i2++) {
                        if (((C10743c74) arrayList.get(i2)).c1()) {
                            z2 = true;
                        }
                    }
                    AlertDialog alertDialogA = new AlertDialog.i(PhotoViewer.this.m, this.a).j(FH3.E("SaveGroupMedia", TD5.tgwidget_SaveGroupMedia)).e(FH3.E("SaveGroupMediaMessage", TD5.tgwidget_SaveGroupMediaMessage)).c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.je).f(!z2 ? FH3.E("ThisPhoto", TD5.tgwidget_ThisPhoto) : FH3.E("ThisMedia", TD5.tgwidget_ThisMedia), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.e
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.a.q(dialogInterface, i3);
                        }
                    }).i(!z2 ? FH3.o("AllNPhotos", arrayList.size(), new Object[0]) : FH3.o("AllNMedia", arrayList.size(), new Object[0]), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.f
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.a.t(z2, arrayList, dialogInterface, i3);
                        }
                    }).g(FH3.E("Cancel", TD5.tgwidget_Cancel), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.g
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            dialogInterface.dismiss();
                        }
                    }).a();
                    alertDialogA.I0(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.oe));
                    alertDialogA.show();
                    View viewW0 = alertDialogA.w0(-3);
                    if (viewW0 instanceof TextView) {
                        PhotoViewer photoViewer = PhotoViewer.this;
                        int i3 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y5;
                        ((TextView) viewW0).setTextColor(photoViewer.n8(i3));
                        viewW0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.r0(PhotoViewer.this.n8(i3)));
                        if ((alertDialogA.x0() instanceof LinearLayout) && ((LinearLayout) alertDialogA.x0()).getOrientation() == 1) {
                            viewW0.bringToFront();
                        }
                    }
                    alertDialogA.L0(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.be));
                    return;
                }
                if (PhotoViewer.this.r4 != null) {
                    if ((C10743c74.W(PhotoViewer.this.r4.e) instanceof C5153Ic7) && C10743c74.W(PhotoViewer.this.r4.e).B != null && C10743c74.W(PhotoViewer.this.r4.e).B.r == null) {
                        PhotoViewer photoViewer2 = PhotoViewer.this;
                        fileR = C4278El2.H(PhotoViewer.this.v).Q(photoViewer2.f8(photoViewer2.p4, null), true);
                        if (!fileR.exists()) {
                            fileR = new File(C4278El2.B(4), fileR.getName());
                        }
                    } else {
                        fileR = C4278El2.H(PhotoViewer.this.v).R(PhotoViewer.this.r4.e);
                    }
                    fileO = fileR;
                    zC1 = PhotoViewer.this.r4.c1();
                } else {
                    if (PhotoViewer.this.v4 != null) {
                        String strH8 = PhotoViewer.h8(PhotoViewer.this.v4);
                        fileO = C4278El2.H(PhotoViewer.this.v).O(PhotoViewer.g8(PhotoViewer.this.v4), strH8, PhotoViewer.this.G4 != 0 || PhotoViewer.this.I4);
                        if (strH8 != null) {
                            strH8 = strH8.toLowerCase();
                        }
                        if (strH8 == null || (!strH8.equals("webm") && !strH8.equals("mp4") && !strH8.equals("gif"))) {
                            z = false;
                        }
                        r4 = z;
                        if (fileO != null && !fileO.exists()) {
                            fileO = new File(C4278El2.B(4), fileO.getName());
                        }
                        if (fileO == null && fileO.exists()) {
                            MediaController.D0(fileO.toString(), PhotoViewer.this.m, r4, null, null, new Utilities.b() { // from class: ir.nasim.tgwidgets.editor.ui.c
                                @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                                public final void a(Object obj) {
                                    this.a.n(r4, (Uri) obj);
                                }
                            });
                            return;
                        } else {
                            PhotoViewer.this.kb();
                            return;
                        }
                    }
                    PhotoViewer.y2(PhotoViewer.this);
                }
                r4 = zC1;
                if (fileO != null) {
                    fileO = new File(C4278El2.B(4), fileO.getName());
                }
                if (fileO == null) {
                }
                PhotoViewer.this.kb();
                return;
            }
            if (i == 2) {
                if (PhotoViewer.this.L4 != 0) {
                    PhotoViewer.this.X3 = true;
                    new Bundle().putLong("dialog_id", PhotoViewer.this.L4);
                    PhotoViewer.this.z7(false, false);
                    return;
                }
                return;
            }
            if (i == 4) {
                if (PhotoViewer.this.r4 == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                long jF = PhotoViewer.this.L4;
                if (PhotoViewer.this.r4 != null) {
                    jF = PhotoViewer.this.r4.F();
                }
                if (ZO1.c(jF)) {
                    bundle.putInt("enc_id", ZO1.a(jF));
                } else if (ZO1.e(jF)) {
                    bundle.putLong("user_id", jF);
                }
                U00.e(PhotoViewer.this.m);
                PhotoViewer.this.z7(false, false);
                PhotoViewer.this.r4 = null;
                return;
            }
            if (i == 3) {
                if (PhotoViewer.this.r4 == null) {
                    return;
                }
                ZO1.b(PhotoViewer.this.r4.F());
                final ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(PhotoViewer.this.r4);
                if (arrayList2.size() <= 1) {
                    U00.d(PhotoViewer.this.n, "send batch files?");
                    PhotoViewer.this.z7(false, false);
                    return;
                }
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    if (!((C10743c74) arrayList2.get(i4)).P0() || ((C10743c74) arrayList2.get(i4)).c1()) {
                        objArr = false;
                        break;
                    }
                }
                objArr = true;
                AlertDialog alertDialogA2 = new AlertDialog.i(PhotoViewer.this.m, this.a).j(FH3.E("ForwardGroupMedia", TD5.tgwidget_ForwardGroupMedia)).e(FH3.E("ForwardGroupMediaMessage", TD5.tgwidget_ForwardGroupMediaMessage)).c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.je).f(objArr != false ? FH3.E("ThisPhoto", TD5.tgwidget_ThisPhoto) : FH3.E("ThisMedia", TD5.tgwidget_ThisMedia), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.a.v(dialogInterface, i5);
                    }
                }).i(objArr != false ? FH3.o("AllNPhotos", arrayList2.size(), new Object[0]) : FH3.o("AllNMedia", arrayList2.size(), new Object[0]), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.i
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.a.w(arrayList2, dialogInterface, i5);
                    }
                }).g(FH3.E("Cancel", TD5.tgwidget_Cancel), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.j
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        dialogInterface.dismiss();
                    }
                }).a();
                alertDialogA2.I0(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.oe));
                alertDialogA2.show();
                View viewW02 = alertDialogA2.w0(-3);
                if (viewW02 instanceof TextView) {
                    PhotoViewer photoViewer3 = PhotoViewer.this;
                    int i5 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y5;
                    ((TextView) viewW02).setTextColor(photoViewer3.n8(i5));
                    viewW02.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.r0(PhotoViewer.this.n8(i5)));
                    if ((alertDialogA2.x0() instanceof LinearLayout) && ((LinearLayout) alertDialogA2.x0()).getOrientation() == 1) {
                        viewW02.bringToFront();
                    }
                }
                alertDialogA2.L0(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.be));
                return;
            }
            if (i == 20) {
                PhotoViewer.this.oa();
                return;
            }
            if (i == 6) {
                PhotoViewer photoViewer4 = PhotoViewer.this;
                if (photoViewer4.m == null || photoViewer4.b == null) {
                    return;
                }
                ZO1.b(PhotoViewer.this.r4.F());
                AlertDialog.i iVar = new AlertDialog.i(PhotoViewer.this.m);
                String deleteMessageString = PhotoViewer.this.b.getDeleteMessageString();
                if (deleteMessageString != null) {
                    iVar.j(FH3.E("AreYouSureDeletePhotoTitle", TD5.tgwidget_AreYouSureDeletePhotoTitle));
                    iVar.e(deleteMessageString);
                } else if (PhotoViewer.this.Z3 || (!(PhotoViewer.this.v4 == null || PhotoViewer.this.v4 == PhotoViewer.this.u4) || (PhotoViewer.this.r4 != null && PhotoViewer.this.r4.c1()))) {
                    iVar.j(FH3.E("AreYouSureDeleteVideoTitle", TD5.tgwidget_AreYouSureDeleteVideoTitle));
                    iVar.e(FH3.r("AreYouSureDeleteVideo", TD5.tgwidget_AreYouSureDeleteVideo, new Object[0]));
                } else if (PhotoViewer.this.r4 == null || !PhotoViewer.this.r4.t0()) {
                    iVar.j(FH3.E("AreYouSureDeletePhotoTitle", TD5.tgwidget_AreYouSureDeletePhotoTitle));
                    iVar.e(FH3.r("AreYouSureDeletePhoto", TD5.tgwidget_AreYouSureDeletePhoto, new Object[0]));
                } else {
                    iVar.j(FH3.E("AreYouSureDeleteGIFTitle", TD5.tgwidget_AreYouSureDeleteGIFTitle));
                    iVar.e(FH3.r("AreYouSureDeleteGIF", TD5.tgwidget_AreYouSureDeleteGIF, new Object[0]));
                }
                ZO1.c(PhotoViewer.this.r4.F());
                iVar.i(FH3.E("Delete", TD5.tgwidget_Delete), new DialogInterface.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        this.a.p(dialogInterface, i6);
                    }
                });
                iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), null);
                AlertDialog alertDialogA3 = iVar.a();
                PhotoViewer.this.jb(iVar);
                TextView textView = (TextView) alertDialogA3.w0(-1);
                if (textView != null) {
                    textView.setTextColor(PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y5));
                    return;
                }
                return;
            }
            if (i == 10 || i == 18) {
                PhotoViewer.this.ka();
                return;
            }
            if (i == 11) {
                try {
                    if (PhotoViewer.this.Z3) {
                        PhotoViewer photoViewer5 = PhotoViewer.this;
                        AbstractC11908dl0.h(photoViewer5.m, C10743c74.W(photoViewer5.r4.e).B.d);
                        PhotoViewer.this.z7(false, false);
                    } else if (PhotoViewer.this.r4 == null) {
                        PhotoViewer.y2(PhotoViewer.this);
                    } else if (AbstractC21455b.d1(PhotoViewer.this.r4, PhotoViewer.this.m, this.a)) {
                        PhotoViewer.this.z7(false, false);
                    } else {
                        PhotoViewer.this.kb();
                    }
                    return;
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                    return;
                }
            }
            if (i == 13 || i == 15) {
                PhotoViewer photoViewer6 = PhotoViewer.this;
                if (photoViewer6.m == null || photoViewer6.r4 == null) {
                    return;
                }
                if (C10743c74.W(PhotoViewer.this.r4.e) instanceof C23255wc7) {
                    AbstractC10736c67 abstractC10736c67 = C10743c74.W(PhotoViewer.this.r4.e).f;
                } else if (!(C10743c74.W(PhotoViewer.this.r4.e) instanceof C16046kc7)) {
                    return;
                } else {
                    AbstractC18106o57 abstractC18106o57 = C10743c74.W(PhotoViewer.this.r4.e).s;
                }
                U00.e(PhotoViewer.this.m);
                return;
            }
            if (i == 5) {
                if (PhotoViewer.this.I0.getAlpha() != 1.0f) {
                    return;
                }
                if (!PhotoViewer.this.Z3) {
                    PhotoViewer.this.ub(false);
                    return;
                }
                if (PhotoViewer.this.A.O()) {
                    if (PhotoViewer.q7 != null) {
                        PhotoViewer.q7.J7();
                    }
                    PhotoViewer.this.l3 = true;
                    PhotoViewer.q7 = PhotoViewer.p7;
                    PhotoViewer.p7 = null;
                    PhotoViewer.this.c = false;
                    if (PhotoViewer.this.x4 != null && !PhotoViewer.this.x4.imageReceiver.d0()) {
                        PhotoViewer.this.x4.imageReceiver.t1(true, true);
                    }
                    PhotoViewer.this.n5 = 1.0f;
                    PhotoViewer.this.z.invalidate();
                    PhotoViewer.this.N7();
                    return;
                }
                return;
            }
            if (i == 7) {
                if (PhotoViewer.this.r4 == null) {
                    return;
                }
                C4278El2.H(PhotoViewer.this.v).j(PhotoViewer.this.r4.I());
                PhotoViewer.this.Aa(false);
                PhotoViewer.this.G.setTag(1);
                PhotoViewer.this.G.setVisibility(0);
                return;
            }
            if (i == 14) {
                U00.e(PhotoViewer.this.m);
                return;
            }
            if (i == 16) {
                U00.e(PhotoViewer.this.m);
            } else if (i == 17) {
                File fileO2 = C4278El2.H(PhotoViewer.this.v).O(PhotoViewer.g8(PhotoViewer.this.v4), PhotoViewer.h8(PhotoViewer.this.v4), true);
                zC1 = PhotoViewer.this.v4.o == 2;
                PhotoViewer.this.b.openPhotoForEdit(fileO2.getAbsolutePath(), zC1 ? C4278El2.H(PhotoViewer.this.v).O(PhotoViewer.g8(PhotoViewer.this.u4), PhotoViewer.h8(PhotoViewer.this.u4), true).getAbsolutePath() : null, zC1);
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$e0, reason: case insensitive filesystem */
    class ViewTreeObserverOnPreDrawListenerC21480e0 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ C0 a;
        final /* synthetic */ Integer b;

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$e0$a */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PhotoViewer.this.S3 = 0;
                PhotoViewer.this.N0.setAlpha(255);
                PhotoViewer.this.z.invalidate();
                PhotoViewer.this.m6.d().setTranslationY(0.0f);
                PhotoViewer.this.R0.setTranslationY(0.0f);
                if (PhotoViewer.this.Z3) {
                    ViewTreeObserverOnPreDrawListenerC21480e0 viewTreeObserverOnPreDrawListenerC21480e0 = ViewTreeObserverOnPreDrawListenerC21480e0.this;
                    PhotoViewer.this.w8(viewTreeObserverOnPreDrawListenerC21480e0.b.intValue());
                }
                C0 c0 = ViewTreeObserverOnPreDrawListenerC21480e0.this.a;
                if (c0 != null) {
                    c0.onOpen();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                C0 c0 = ViewTreeObserverOnPreDrawListenerC21480e0.this.a;
                if (c0 != null) {
                    c0.onPreOpen();
                }
            }
        }

        ViewTreeObserverOnPreDrawListenerC21480e0(C0 c0, Integer num) {
            this.a = c0;
            this.b = num;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            PhotoViewer.this.B.getViewTreeObserver().removeOnPreDrawListener(this);
            PhotoViewer.this.o.setTranslationY(-AbstractC21455b.F(32.0f));
            ViewPropertyAnimator duration = PhotoViewer.this.o.animate().alpha(1.0f).translationY(0.0f).setDuration(150L);
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
            duration.setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.P0.setTranslationY(-AbstractC21455b.F(32.0f));
            PhotoViewer.this.P0.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.Q0.setTranslationY(-AbstractC21455b.F(32.0f));
            PhotoViewer.this.Q0.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.m6.d().setTranslationY(AbstractC21455b.F(32.0f));
            PhotoViewer.this.m6.d().animate().alpha(1.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.R0.setTranslationY(AbstractC21455b.F(32.0f));
            PhotoViewer.this.R0.animate().alpha(1.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.S0.setTranslationY(AbstractC21455b.F(32.0f));
            PhotoViewer.this.S0.setAlpha(0.0f);
            PhotoViewer.this.S0.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.b1.setTranslationY(AbstractC21455b.F(32.0f));
            PhotoViewer.this.b1.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.W2.setTranslationY(AbstractC21455b.F(32.0f));
            PhotoViewer.this.W2.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(interpolatorC12631ew1).start();
            PhotoViewer.this.z.setAlpha(0.0f);
            PhotoViewer.this.N0.setAlpha(0);
            PhotoViewer.this.S3 = 4;
            PhotoViewer.this.z.invalidate();
            AnimatorSet animatorSet = new AnimatorSet();
            ViewGroup viewGroupD = PhotoViewer.this.m6.d();
            Property property = View.TRANSLATION_Y;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(viewGroupD, (Property<ViewGroup, Float>) property, PhotoViewer.this.m6.d().getTranslationY(), 0.0f).setDuration(220L);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(PhotoViewer.this.R0, (Property<FrameLayout, Float>) property, PhotoViewer.this.R0.getTranslationY(), 0.0f).setDuration(220L);
            duration2.setInterpolator(interpolatorC12631ew1);
            duration3.setInterpolator(interpolatorC12631ew1);
            w0 w0Var = PhotoViewer.this.z;
            Property property2 = View.ALPHA;
            animatorSet.playTogether(ObjectAnimator.ofFloat(w0Var, (Property<w0, Float>) property2, 0.0f, 1.0f).setDuration(220L), ObjectAnimator.ofFloat(PhotoViewer.this.H, (Property<View, Float>) property2, 0.0f, 1.0f).setDuration(220L), duration2, duration3);
            animatorSet.addListener(new a());
            animatorSet.start();
            return true;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$f, reason: case insensitive filesystem */
    class C21481f implements C21506a.c {
        C21481f() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.C21506a.c
        public void a(float f, boolean z, boolean z2) {
            if (f != PhotoViewer.this.p1) {
                PhotoViewer.this.p1 = f;
                if (PhotoViewer.this.r4 != null) {
                    SharedPreferences sharedPreferences = AbstractC14047hG.a.getSharedPreferences("playback_speed", 0);
                    if (Math.abs(PhotoViewer.this.p1 - 1.0f) < 0.001f) {
                        sharedPreferences.edit().remove("speed" + PhotoViewer.this.r4.F() + "_" + PhotoViewer.this.r4.T()).commit();
                    } else {
                        sharedPreferences.edit().putFloat("speed" + PhotoViewer.this.r4.F() + "_" + PhotoViewer.this.r4.T(), PhotoViewer.this.p1).commit();
                    }
                }
                if (PhotoViewer.this.j2 != null) {
                    PhotoViewer.this.j2.O1(PhotoViewer.this.p1);
                }
                if (PhotoViewer.this.A != null) {
                    PhotoViewer.this.A.setPlaybackSpeed(PhotoViewer.this.p1);
                }
            }
            PhotoViewer.this.ab(true, z);
            if (z2) {
                PhotoViewer.this.A0.p0();
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$f0, reason: case insensitive filesystem */
    class C21482f0 extends PhotoViewerWebView {
        Rect w;

        C21482f0(PhotoViewer photoViewer, Context context, View view) {
            super(photoViewer, context, view);
            this.w = new Rect();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerWebView
        protected void A(Canvas canvas, int i, int i2) {
            Bitmap bitmapL = PhotoViewer.this.i4.l();
            if (bitmapL != null) {
                float fMin = Math.min(i / bitmapL.getWidth(), i2 / bitmapL.getHeight());
                int width = (int) (bitmapL.getWidth() * fMin);
                int height = (int) (bitmapL.getHeight() * fMin);
                int i3 = (i2 - height) / 2;
                int i4 = (i - width) / 2;
                this.w.set(i4, i3, width + i4, height + i3);
                canvas.drawBitmap(bitmapL, (Rect) null, this.w, (Paint) null);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerWebView
        protected void R(MotionEvent motionEvent) {
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$g, reason: case insensitive filesystem */
    class C21483g implements ActionBarMenuItem.m {
        C21483g() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem.m
        public void a() {
            if (PhotoViewer.this.P2 && PhotoViewer.this.r3) {
                PhotoViewer.this.Ea();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem.m
        public void b() {
            if (PhotoViewer.this.P2 && PhotoViewer.this.r3) {
                AbstractC21455b.t(PhotoViewer.this.d2);
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$g0, reason: case insensitive filesystem */
    class C21484g0 extends AnimatorListenerAdapter {
        C21484g0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (PhotoViewer.this.U3 != null) {
                PhotoViewer.this.U3.run();
                PhotoViewer.this.U3 = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.E
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$h, reason: case insensitive filesystem */
    class C21485h implements GroupedPhotosListView.c {
        C21485h() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public ArrayList a() {
            return PhotoViewer.this.c6;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public int b() {
            return PhotoViewer.this.h;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public void c(int i) throws InterruptedException, Resources.NotFoundException {
            PhotoViewer.this.p4 = -1;
            if (PhotoViewer.this.C4 != null) {
                PhotoViewer.this.C4.d();
                PhotoViewer.this.C4 = null;
            }
            PhotoViewer.this.E4 = true;
            PhotoViewer.this.Ra(i);
            PhotoViewer.this.E4 = false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public void d() {
            PhotoViewer.this.z.requestLayout();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public ArrayList e() {
            return PhotoViewer.this.a6;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public Object f() {
            PhotoViewer.y2(PhotoViewer.this);
            return null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public int g() {
            return PhotoViewer.this.v;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public int h() {
            return PhotoViewer.this.p4;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public List i() {
            PhotoViewer.y2(PhotoViewer.this);
            return null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public void j() {
            PhotoViewer photoViewer = PhotoViewer.this;
            if (photoViewer.ib(photoViewer.r4)) {
                PhotoViewer.this.B2 = true;
                PhotoViewer.this.ca(true);
                PhotoViewer.this.w7(0, false, true);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.c
        public long k() {
            return PhotoViewer.this.G4;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$h0, reason: case insensitive filesystem */
    class C21486h0 extends AnimatorListenerAdapter {
        C21486h0() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.n5 = 1.0f;
            if (PhotoViewer.this.U3 != null) {
                PhotoViewer.this.U3.run();
                PhotoViewer.this.U3 = null;
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$i, reason: case insensitive filesystem */
    class C21487i extends A0 {
        C21487i(View view) {
            super(view);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.A0
        protected void j(int i) {
            if (this == PhotoViewer.this.V0[0]) {
                PhotoViewer.this.Cb();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.A0
        protected void l(boolean z) {
            if (this == PhotoViewer.this.V0[0]) {
                PhotoViewer.this.Cb();
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$i0, reason: case insensitive filesystem */
    class C21488i0 extends AnimatorListenerAdapter {
        C21488i0() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.r5 = null;
            PhotoViewer.this.z.invalidate();
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$j, reason: case insensitive filesystem */
    class C21489j extends RadialProgressView {
        C21489j(Context context, m.h hVar) {
            super(context, hVar);
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            if (PhotoViewer.this.z != null) {
                PhotoViewer.this.z.invalidate();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RadialProgressView, android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            if (PhotoViewer.this.z != null) {
                PhotoViewer.this.z.invalidate();
            }
        }
    }

    class j0 extends AnimatorListenerAdapter {
        j0() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.c3[0].setTag(null);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$k, reason: case insensitive filesystem */
    class RunnableC21490k implements Runnable {
        RunnableC21490k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.r4 == null) {
                return;
            }
            C4278El2.H(PhotoViewer.this.r4.N).f0(PhotoViewer.this.r4.I(), true, false);
        }
    }

    class k0 extends AnimatorListenerAdapter {
        k0() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.c3[0].setTag(null);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$l, reason: case insensitive filesystem */
    class C21491l implements I.a {
        C21491l() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.I.a
        public void a() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.I.a
        public void invalidate() {
            PhotoViewer.this.z.invalidate();
        }
    }

    class l0 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(PhotoViewer.this.A6)) {
                    PhotoViewer.this.A6 = null;
                }
            }
        }

        l0(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            PhotoViewer.this.A6 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator.equals(PhotoViewer.this.A6)) {
                PhotoViewer.this.A6 = new AnimatorSet();
                if (this.a) {
                    PhotoViewer.this.v6.setVisibility(0);
                    PhotoViewer.this.w6.setVisibility(0);
                    AnimatorSet animatorSet = PhotoViewer.this.A6;
                    E0 e0 = PhotoViewer.this.v6;
                    Property property = View.TRANSLATION_Y;
                    animatorSet.playTogether(ObjectAnimator.ofFloat(e0, (Property<E0, Float>) property, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.w6, (Property<PickerBottomLayoutViewer, Float>) property, 0.0f));
                } else {
                    PhotoViewer.this.v6.setVisibility(4);
                    PhotoViewer.this.w6.setVisibility(4);
                    AnimatorSet animatorSet2 = PhotoViewer.this.A6;
                    ViewGroup viewGroupD = PhotoViewer.this.m6.d();
                    Property property2 = View.TRANSLATION_Y;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(viewGroupD, (Property<ViewGroup, Float>) property2, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.R0, (Property<FrameLayout, Float>) property2, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.S0, (Property<ImageView, Float>) property2, 0.0f));
                }
                PhotoViewer.this.A6.addListener(new a());
                PhotoViewer.this.A6.setDuration(200L);
                PhotoViewer.this.A6.setInterpolator(AbstractC21455b.t);
                PhotoViewer.this.A6.start();
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$m, reason: case insensitive filesystem */
    class C21492m extends FrameLayout {
        final /* synthetic */ Paint a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21492m(Context context, Paint paint) {
            super(context);
            this.a = paint;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (PhotoViewer.this.z0.getVisibility() == 0) {
                canvas.drawRect(0.0f, getMeasuredHeight() - AbstractC21455b.F(48.0f), getMeasuredWidth(), getMeasuredHeight(), this.a);
            } else {
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.a);
            }
            super.dispatchDraw(canvas);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.X5 && super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.X5 && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (PhotoViewer.this.K0.getVisibility() != 8) {
                int iF = (((i3 - i) - (PhotoViewer.this.S0.getVisibility() == 0 ? AbstractC21455b.F(70.0f) : 0)) - PhotoViewer.this.K0.getMeasuredWidth()) / 2;
                PhotoViewer.this.K0.layout(iF, PhotoViewer.this.K0.getTop(), PhotoViewer.this.K0.getMeasuredWidth() + iF, PhotoViewer.this.K0.getTop() + PhotoViewer.this.K0.getMeasuredHeight());
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            ((FrameLayout.LayoutParams) PhotoViewer.this.K0.getLayoutParams()).rightMargin = PhotoViewer.this.S0.getVisibility() == 0 ? AbstractC21455b.F(70.0f) : 0;
            super.onMeasure(i, i2);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.X5 && super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            if (PhotoViewer.this.y6 == null || PhotoViewer.this.y6.getVisibility() == 8) {
                return;
            }
            PhotoViewer.this.y6.setAlpha(f);
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (PhotoViewer.this.y6 != null && PhotoViewer.this.y6.getVisibility() != 8) {
                PhotoViewer.this.y6.setTranslationY(f);
                PhotoViewer.this.z6.setTranslationY(f);
            }
            if (PhotoViewer.this.z6 == null || PhotoViewer.this.z6.getVisibility() == 8) {
                return;
            }
            PhotoViewer.this.z6.setTranslationY(f);
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            super.setVisibility(i);
            if (PhotoViewer.this.y6 == null || PhotoViewer.this.y6.getVisibility() == 8) {
                return;
            }
            PhotoViewer.this.y6.setVisibility(i == 0 ? 0 : 4);
        }
    }

    class m0 implements Runnable {
        m0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ir.nasim.tgwidgets.editor.ui.Components.w.J0()) {
                ir.nasim.tgwidgets.editor.ui.Components.w.w0();
                AbstractC21455b.n1(this, 250L);
                return;
            }
            PhotoViewer.this.n3 = false;
            if (PhotoViewer.this.g3 != null) {
                PhotoViewer.this.g3.recycle();
                PhotoViewer.this.g3 = null;
            }
            PhotoViewer.this.h3 = true;
            if (PhotoViewer.this.b3 != null) {
                try {
                    PhotoViewer photoViewer = PhotoViewer.this;
                    photoViewer.g3 = AbstractC21456c.a(photoViewer.h2.getWidth(), PhotoViewer.this.h2.getHeight(), Bitmap.Config.ARGB_8888);
                    PhotoViewer.this.h2.getBitmap(PhotoViewer.this.g3);
                } catch (Throwable th) {
                    if (PhotoViewer.this.g3 != null) {
                        PhotoViewer.this.g3.recycle();
                        PhotoViewer.this.g3 = null;
                    }
                    AbstractC6403Nl2.d(th);
                }
                if (PhotoViewer.this.g3 != null) {
                    PhotoViewer.this.b3.setVisibility(0);
                    PhotoViewer.this.b3.setImageBitmap(PhotoViewer.this.g3);
                } else {
                    PhotoViewer.this.b3.setImageDrawable(null);
                }
            }
            PhotoViewer.this.l3 = true;
            PhotoViewer.this.a3 = new TextureView(PhotoViewer.this.m);
            PhotoViewer photoViewer2 = PhotoViewer.this;
            if (ir.nasim.tgwidgets.editor.ui.Components.w.j1(false, photoViewer2.m, photoViewer2.a3, PhotoViewer.this.w, PhotoViewer.this.x, PhotoViewer.this.m3)) {
                ir.nasim.tgwidgets.editor.ui.Components.w.i1(PhotoViewer.this);
            }
            PhotoViewer.this.m3 = true;
            PhotoViewer.this.a3.setVisibility(4);
            if (PhotoViewer.this.e2 != null) {
                PhotoViewer.this.e2.removeView(PhotoViewer.this.h2);
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$n, reason: case insensitive filesystem */
    class C21493n extends VideoTimelinePlayView {
        C21493n(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            if (getTranslationY() != f) {
                super.setTranslationY(f);
                PhotoViewer.this.z.invalidate();
            }
        }
    }

    class n0 implements TextureView.SurfaceTextureListener {

        class a implements ViewTreeObserver.OnPreDrawListener {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c() {
                PhotoViewer.this.b3.setVisibility(4);
                PhotoViewer.this.b3.setImageDrawable(null);
                if (PhotoViewer.this.g3 != null) {
                    PhotoViewer.this.g3.recycle();
                    PhotoViewer.this.g3 = null;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d() {
                if (PhotoViewer.this.l3) {
                    PhotoViewer.this.N7();
                }
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                PhotoViewer.this.a3.getViewTreeObserver().removeOnPreDrawListener(this);
                if (PhotoViewer.this.b3 != null) {
                    if (PhotoViewer.this.l3) {
                        AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.F
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.c();
                            }
                        }, 300L);
                    } else {
                        PhotoViewer.this.b3.setVisibility(4);
                        PhotoViewer.this.b3.setImageDrawable(null);
                        if (PhotoViewer.this.g3 != null) {
                            PhotoViewer.this.g3.recycle();
                            PhotoViewer.this.g3 = null;
                        }
                    }
                }
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.G
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d();
                    }
                });
                PhotoViewer.this.i3 = 0;
                return true;
            }
        }

        n0() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (PhotoViewer.this.h2 == null || !PhotoViewer.this.h3) {
                return true;
            }
            if (PhotoViewer.this.n3) {
                PhotoViewer.this.i3 = 2;
            }
            PhotoViewer.this.h2.setSurfaceTexture(surfaceTexture);
            PhotoViewer.this.h2.setVisibility(0);
            PhotoViewer.this.h3 = false;
            PhotoViewer.this.z.invalidate();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (PhotoViewer.this.i3 == 1) {
                PhotoViewer.this.a3.getViewTreeObserver().addOnPreDrawListener(new a());
                PhotoViewer.this.a3.invalidate();
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$o, reason: case insensitive filesystem */
    class C21494o implements VideoTimelinePlayView.c {
        private Runnable a;
        private int b;
        private boolean c;

        C21494o() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            PhotoViewer.this.Ha(this.b);
            if (PhotoViewer.this.L1 == 1) {
                PhotoViewer.this.E6 = this.b;
                if (PhotoViewer.this.D6 != PhotoViewer.this.E6) {
                    PhotoViewer.this.D6 = -1L;
                }
            }
            this.a = null;
        }

        private void h(float f) {
            this.b = (int) (PhotoViewer.this.P6 * f);
            if (AbstractC8662Wx6.h() != 2) {
                if (this.a == null) {
                    Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.g();
                        }
                    };
                    this.a = runnable;
                    AbstractC21455b.n1(runnable, 100L);
                    return;
                }
                return;
            }
            PhotoViewer.this.Ha(this.b);
            if (PhotoViewer.this.L1 == 1) {
                PhotoViewer.this.E6 = this.b;
                if (PhotoViewer.this.D6 != PhotoViewer.this.E6) {
                    PhotoViewer.this.D6 = -1L;
                }
            }
            this.a = null;
        }

        private void i(int i) {
            if (PhotoViewer.this.L1 != 1) {
                return;
            }
            if (i == 0) {
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.d7 = photoViewer.y6.getProgress();
                PhotoViewer photoViewer2 = PhotoViewer.this;
                photoViewer2.c7 = (long) (photoViewer2.P6 * 1000.0f * PhotoViewer.this.d7);
                return;
            }
            if (PhotoViewer.this.y1 != null) {
                if (PhotoViewer.this.y6.getLeftProgress() > PhotoViewer.this.d7 || PhotoViewer.this.y6.getRightProgress() < PhotoViewer.this.d7) {
                    PhotoViewer.this.y1.setVideoThumbVisible(false);
                    if (i == 1) {
                        PhotoViewer photoViewer3 = PhotoViewer.this;
                        photoViewer3.c7 = (long) (photoViewer3.P6 * 1000.0f * PhotoViewer.this.y6.getLeftProgress());
                    } else {
                        PhotoViewer photoViewer4 = PhotoViewer.this;
                        photoViewer4.c7 = (long) (photoViewer4.P6 * 1000.0f * PhotoViewer.this.y6.getRightProgress());
                    }
                    PhotoViewer.this.C6 = -1L;
                }
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void a(float f) {
            if (PhotoViewer.this.j2 == null) {
                return;
            }
            if (PhotoViewer.this.j2.A1()) {
                PhotoViewer.this.k2 = false;
                PhotoViewer.this.j2.D1();
                PhotoViewer.this.z.invalidate();
            }
            i(2);
            h(f);
            PhotoViewer.this.U2.s(1.0f);
            PhotoViewer.this.y6.setProgress(f);
            PhotoViewer.this.Nb();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void b(int i) {
            if (i == VideoTimelinePlayView.J) {
                PhotoViewer.this.q7();
                if (PhotoViewer.this.L1 == 1) {
                    PhotoViewer.this.o7();
                    PhotoViewer.this.C6 = -1L;
                }
                boolean zB8 = PhotoViewer.this.B8();
                this.c = zB8;
                if (zB8) {
                    PhotoViewer.this.k2 = false;
                    PhotoViewer.this.sa();
                    PhotoViewer.this.z.invalidate();
                }
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void c(int i) {
            Runnable runnable = this.a;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
                this.a.run();
            }
            PhotoViewer.this.q7();
            if (PhotoViewer.this.L1 != 1 || PhotoViewer.this.f2 == null || i != VideoTimelinePlayView.J) {
                if (PhotoViewer.this.L1 == 1 || this.c) {
                    PhotoViewer.this.k2 = false;
                    PhotoViewer.this.ua();
                    return;
                }
                return;
            }
            PhotoViewer.this.o7();
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.C6 = photoViewer.c7;
            if (PhotoViewer.this.D6 == this.b) {
                PhotoViewer.this.r7();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void d(float f) {
            if (PhotoViewer.this.j2 == null) {
                return;
            }
            if (PhotoViewer.this.j2.A1()) {
                PhotoViewer.this.k2 = false;
                PhotoViewer.this.j2.D1();
                PhotoViewer.this.z.invalidate();
            }
            i(1);
            h(f);
            PhotoViewer.this.U2.s(0.0f);
            PhotoViewer.this.y6.setProgress(f);
            PhotoViewer.this.Nb();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void e(float f) {
            if (PhotoViewer.this.j2 == null) {
                return;
            }
            if (PhotoViewer.this.L1 == 1) {
                i(0);
            }
            h(f);
        }
    }

    class o0 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        o0(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Runnable runnable, int[] iArr) throws IOException {
            PhotoViewer photoViewer = PhotoViewer.this;
            if (photoViewer.m == null || runnable != photoViewer.e7) {
                return;
            }
            PhotoViewer.this.e7 = null;
            PhotoViewer.this.X6 = iArr[5];
            PhotoViewer.this.P6 = iArr[4];
            PhotoViewer.this.Q6 = iArr[7];
            PhotoViewer.this.Y6 = (long) (((r5.N6 / 8) * PhotoViewer.this.P6) / 1000.0f);
            if (PhotoViewer.this.R6) {
                PhotoViewer.this.I6 = iArr[8];
                PhotoViewer.this.Rb();
                if (PhotoViewer.this.F6 > PhotoViewer.this.G6 - 1) {
                    PhotoViewer photoViewer2 = PhotoViewer.this;
                    photoViewer2.F6 = photoViewer2.G6 - 1;
                }
                PhotoViewer photoViewer3 = PhotoViewer.this;
                photoViewer3.Na(photoViewer3.G6 > 1, true);
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("compressionsCount = " + PhotoViewer.this.G6 + " w = " + PhotoViewer.this.J6 + " h = " + PhotoViewer.this.K6 + " r = " + PhotoViewer.this.I6);
                }
                PhotoViewer.this.v6.invalidate();
            } else {
                PhotoViewer.this.Na(false, true);
                PhotoViewer.this.G6 = 0;
            }
            PhotoViewer.this.Nb();
            PhotoViewer.this.Jb();
        }

        @Override // java.lang.Runnable
        public void run() throws IOException, IllegalArgumentException {
            if (PhotoViewer.this.e7 != this) {
                return;
            }
            int iA0 = MediaController.a0(this.a);
            final int[] iArr = new int[11];
            AnimatedFileDrawable.G0(this.a, iArr);
            boolean z = false;
            boolean z2 = iArr[10] != 0;
            PhotoViewer photoViewer = PhotoViewer.this;
            if (iArr[0] != 0 && (!z2 || iArr[9] != 0)) {
                z = true;
            }
            photoViewer.R6 = z;
            PhotoViewer photoViewer2 = PhotoViewer.this;
            if (iA0 == -1) {
                iA0 = iArr[3];
            }
            photoViewer2.N6 = iA0;
            photoViewer2.O6 = iA0;
            if (PhotoViewer.this.R6) {
                PhotoViewer photoViewer3 = PhotoViewer.this;
                int i = iArr[1];
                photoViewer3.J6 = i;
                photoViewer3.L6 = i;
                PhotoViewer photoViewer4 = PhotoViewer.this;
                int i2 = iArr[2];
                photoViewer4.K6 = i2;
                photoViewer4.M6 = i2;
                PhotoViewer photoViewer5 = PhotoViewer.this;
                photoViewer5.Gb(photoViewer5.J6, PhotoViewer.this.K6);
                PhotoViewer photoViewer6 = PhotoViewer.this;
                int iJa = this.b;
                if (iJa == -1) {
                    iJa = photoViewer6.Ja();
                }
                photoViewer6.F6 = iJa;
                PhotoViewer.this.xa();
                PhotoViewer.this.S6 = MediaController.c0(this.a);
            }
            if (PhotoViewer.this.e7 != this) {
                return;
            }
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.H
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.a.b(this, iArr);
                }
            });
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$p, reason: case insensitive filesystem */
    class C21495p extends AppCompatImageView {
        C21495p(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.X5 && super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.X5 && super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            PhotoViewer.this.F3.setAlpha(f);
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            PhotoViewer.this.F3.setTranslationY(f);
        }

        @Override // android.widget.ImageView, android.view.View
        public void setVisibility(int i) {
            super.setVisibility(i);
            if (PhotoViewer.this.K1.getCaptionLimitOffset() < 0) {
                PhotoViewer.this.F3.setVisibility(i);
            } else {
                PhotoViewer.this.F3.setVisibility(8);
            }
        }
    }

    class p0 extends FloatProperty {
        p0(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(I0 i0) {
            return Float.valueOf(i0.d());
        }

        @Override // android.util.FloatProperty
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(I0 i0, float f) {
            i0.g(f);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$q, reason: case insensitive filesystem */
    class C21496q extends LinearLayout {
        boolean a;

        C21496q(Context context) {
            super(context);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                if (getChildAt(i4).getVisibility() == 0) {
                    i3++;
                }
            }
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (i3 == 0) {
                setMeasuredDimension(size, size2);
                return;
            }
            int iMin = Math.min(AbstractC21455b.F(70.0f), size / i3);
            if (PhotoViewer.this.f1.getVisibility() == 0) {
                this.a = true;
                int iMax = Math.max(0, (iMin - AbstractC21455b.F(PhotoViewer.this.F6 < 2 ? 48 : 64)) / 2);
                PhotoViewer.this.f1.setPadding(iMax, 0, iMax, 0);
                this.a = false;
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                }
            }
            setMeasuredDimension(iMin * i3, size2);
        }
    }

    private static class q0 {
        public static final q0 e = new q0();
        public Interpolator b;
        public int a = 200;
        public boolean c = true;
        public boolean d = true;

        public q0 a(boolean z) {
            this.c = z;
            return this;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$r, reason: case insensitive filesystem */
    class C21497r extends CheckBox {
        C21497r(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.X5 && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class r0 extends NestedScrollView {
        private final C16463lJ6 A0;
        private boolean B0;
        private float C0;
        private float D0;
        private float E0;
        private Method F0;
        private OverScroller G0;
        private boolean H0;
        private int I0;
        private int J0;
        private float K0;
        private boolean L0;
        private int M0;
        private final Paint z0;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.c3[0].setTag(null);
            }
        }

        public r0(Context context) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
            super(context);
            Paint paint = new Paint(1);
            this.z0 = paint;
            this.K0 = 1.0f;
            this.M0 = -1;
            setClipChildren(false);
            setOverScrollMode(2);
            paint.setColor(-16777216);
            setFadingEdgeLength(AbstractC21455b.F(12.0f));
            setVerticalFadingEdgeEnabled(true);
            setWillNotDraw(false);
            C16463lJ6 c16463lJ6 = new C16463lJ6(PhotoViewer.this.H1, AbstractC12098e22.n, 0.0f);
            this.A0 = c16463lJ6;
            c16463lJ6.x().f(100.0f);
            c16463lJ6.n(1.0f);
            c16463lJ6.c(new AbstractC12098e22.r() { // from class: ir.nasim.tgwidgets.editor.ui.I
                @Override // ir.nasim.AbstractC12098e22.r
                public final void a(AbstractC12098e22 abstractC12098e22, float f, float f2) {
                    this.a.h0(abstractC12098e22, f, f2);
                }
            });
            c16463lJ6.x().d(1.0f);
            try {
                Method declaredMethod = NestedScrollView.class.getDeclaredMethod("a", null);
                this.F0 = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                this.F0 = null;
                AbstractC6403Nl2.d(e);
            }
            try {
                Field declaredField = NestedScrollView.class.getDeclaredField("d");
                declaredField.setAccessible(true);
                this.G0 = (OverScroller) declaredField.get(this);
            } catch (Exception e2) {
                this.G0 = null;
                AbstractC6403Nl2.d(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h0(AbstractC12098e22 abstractC12098e22, float f, float f2) {
            this.C0 = f;
            this.E0 = f2;
        }

        private void j0(float f) {
            if (this.A0.h()) {
                return;
            }
            this.A0.q(f);
            this.A0.s();
        }

        private void m0(int i, int i2) {
            int iG0 = g0(i, i2);
            if (iG0 >= 0) {
                if (this.L0) {
                    this.M0 = iG0;
                } else {
                    ((ViewGroup.MarginLayoutParams) PhotoViewer.this.J1.getLayoutParams()).topMargin = iG0;
                    this.M0 = -1;
                }
            }
        }

        @Override // androidx.core.widget.NestedScrollView
        public boolean Z(int i, int i2) {
            if (i2 == 0) {
                this.A0.d();
                this.B0 = true;
                this.C0 = PhotoViewer.this.H1.getTranslationY();
            }
            return true;
        }

        @Override // androidx.core.widget.NestedScrollView
        public void b0(int i) {
            OverScroller overScroller;
            if (this.B0 && i == 0) {
                this.B0 = false;
                if (this.C0 == 0.0f || (overScroller = this.G0) == null || !overScroller.isFinished()) {
                    return;
                }
                j0(this.E0);
            }
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public void computeScroll() {
            OverScroller overScroller;
            super.computeScroll();
            if (this.B0 || this.C0 == 0.0f || (overScroller = this.G0) == null || !overScroller.isFinished()) {
                return;
            }
            j0(0.0f);
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public void draw(Canvas canvas) {
            int width = getWidth();
            int height = getHeight();
            int scrollY = getScrollY();
            int iSave = canvas.save();
            int i = height + scrollY;
            canvas.clipRect(0, scrollY, width, i);
            this.z0.setAlpha((int) (this.K0 * 127.0f));
            canvas.drawRect(0.0f, PhotoViewer.this.J1.getTop() + PhotoViewer.this.H1.getTranslationY(), width, i, this.z0);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
        }

        public void f0() {
            this.L0 = false;
            if (this.M0 >= 0) {
                ((ViewGroup.MarginLayoutParams) PhotoViewer.this.J1.getLayoutParams()).topMargin = this.M0;
                this.M0 = -1;
                requestLayout();
            }
        }

        public int g0(int i, int i2) {
            int iF;
            if (i == 0 || i2 == 0) {
                return -1;
            }
            TextView currentView = PhotoViewer.this.H1.getCurrentView();
            CharSequence text = currentView.getText();
            int iHashCode = text.hashCode();
            Point point = AbstractC21455b.h;
            boolean z = point.x > point.y;
            if (this.I0 == iHashCode && this.H0 == z && this.J0 == i2) {
                return -1;
            }
            this.I0 = iHashCode;
            this.H0 = z;
            this.J0 = i2;
            currentView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, RecyclerView.UNDEFINED_DURATION));
            Layout layout = currentView.getLayout();
            int lineCount = layout.getLineCount();
            if ((!z || lineCount > 2) && (z || lineCount > 5)) {
                int iMin = Math.min(z ? 2 : 5, lineCount);
                loop0: while (iMin > 1) {
                    int i3 = iMin - 1;
                    for (int lineStart = layout.getLineStart(i3); lineStart < layout.getLineEnd(i3); lineStart++) {
                        if (!Character.isWhitespace(text.charAt(lineStart))) {
                            break loop0;
                        }
                    }
                    iMin--;
                }
                i2 -= currentView.getPaint().getFontMetricsInt(null) * iMin;
                iF = AbstractC21455b.F(8.0f);
            } else {
                iF = currentView.getMeasuredHeight();
            }
            return i2 - iF;
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        protected float getBottomFadingEdgeStrength() {
            return 1.0f;
        }

        public int getPendingMarginTopDiff() {
            int i = this.M0;
            if (i >= 0) {
                return i - ((ViewGroup.MarginLayoutParams) PhotoViewer.this.J1.getLayoutParams()).topMargin;
            }
            return 0;
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        protected float getTopFadingEdgeStrength() {
            return 1.0f;
        }

        public void i0() {
            scrollTo(0, 0);
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            if (PhotoViewer.this.p) {
                int scrollY = getScrollY();
                float translationY = PhotoViewer.this.H1.getTranslationY();
                boolean z = scrollY == 0 && translationY == 0.0f;
                boolean z2 = scrollY == 0 && translationY == 0.0f;
                if (!z) {
                    int iH = PhotoViewer.this.V0[0].h() + PhotoViewer.this.V0[0].j;
                    int top = (((PhotoViewer.this.J1.getTop() + ((int) translationY)) - scrollY) + ((PhotoViewer.this.A8() ? AbstractC21455b.d : 0) + ActionBar.getCurrentActionBarHeight())) - AbstractC21455b.F(12.0f);
                    z2 = top > ((int) PhotoViewer.this.c3[0].getY()) + AbstractC21455b.F(32.0f);
                    z = top > iH;
                }
                if (PhotoViewer.this.d3) {
                    if (PhotoViewer.this.c3[0].getTag() != null && ((Integer) PhotoViewer.this.c3[0].getTag()).intValue() == 3 && z2) {
                        PhotoViewer.this.c3[0].setTag(2);
                        PhotoViewer.this.c3[0].animate().alpha(1.0f).setDuration(150L).setListener(new a()).start();
                    } else if (PhotoViewer.this.c3[0].getTag() == null && !z2) {
                        PhotoViewer.this.c3[0].setTag(3);
                        PhotoViewer.this.c3[0].animate().alpha(0.0f).setListener(null).setDuration(150L).start();
                    }
                }
                PhotoViewer.this.V0[0].p(2, z ? 1.0f : 0.0f, true);
            }
        }

        @Override // androidx.core.widget.NestedScrollView
        public boolean j(int i, int i2, int[] iArr, int[] iArr2, int i3) {
            iArr[1] = 0;
            if (this.B0) {
                float f = this.C0;
                if ((f > 0.0f && i2 > 0) || (f < 0.0f && i2 < 0)) {
                    float f2 = i2;
                    float f3 = f - f2;
                    if (f > 0.0f) {
                        if (f3 < 0.0f) {
                            this.C0 = 0.0f;
                            iArr[1] = (int) (0 + f2 + f3);
                        } else {
                            this.C0 = f3;
                            iArr[1] = i2;
                        }
                    } else if (f3 > 0.0f) {
                        this.C0 = 0.0f;
                        iArr[1] = (int) (0 + f2 + f3);
                    } else {
                        this.C0 = f3;
                        iArr[1] = i2;
                    }
                    PhotoViewer.this.H1.setTranslationY(this.C0);
                    return true;
                }
            }
            return false;
        }

        public void k0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.F0;
            if (method != null) {
                try {
                    method.invoke(this, null);
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
            }
        }

        @Override // androidx.core.widget.NestedScrollView
        public void l(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
            float f;
            if (i4 != 0) {
                int iRound = Math.round(i4 * (1.0f - Math.abs((-this.C0) / (PhotoViewer.this.J1.getTop() - ((PhotoViewer.this.A8() ? AbstractC21455b.d : 0) + ActionBar.getCurrentActionBarHeight())))));
                if (iRound != 0) {
                    if (this.B0) {
                        this.C0 -= iRound;
                        PhotoViewer.this.H1.setTranslationY(this.C0);
                        return;
                    }
                    if (this.A0.h()) {
                        return;
                    }
                    OverScroller overScroller = this.G0;
                    float currVelocity = overScroller != null ? overScroller.getCurrVelocity() : Float.NaN;
                    if (Float.isNaN(currVelocity)) {
                        f = 0.0f;
                    } else {
                        Point point = AbstractC21455b.h;
                        float fMin = Math.min(point.x > point.y ? 3000.0f : 5000.0f, currVelocity);
                        iRound = (int) ((iRound * fMin) / currVelocity);
                        f = fMin * (-this.D0);
                    }
                    if (iRound != 0) {
                        this.C0 -= iRound;
                        PhotoViewer.this.H1.setTranslationY(this.C0);
                    }
                    j0(f);
                }
            }
        }

        public void l0() {
            m0(getWidth(), getHeight());
        }

        @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            m0(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            super.onMeasure(i, i2);
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || motionEvent.getY() >= (PhotoViewer.this.J1.getTop() - getScrollY()) + PhotoViewer.this.H1.getTranslationY()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }

        @Override // androidx.core.widget.NestedScrollView
        public void u(int i) {
            super.u(i);
            this.D0 = Math.signum(i);
            this.E0 = 0.0f;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$s, reason: case insensitive filesystem */
    class C21498s extends LinearLayoutManagerTgwidget {

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$s$a */
        class a extends AbstractC8443Vz3 {
            a(Context context) {
                super(context);
            }

            @Override // ir.nasim.AbstractC8443Vz3
            protected int t(int i) {
                return Math.max(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, super.t(i));
            }
        }

        C21498s(Context context, int i, boolean z) {
            super(context, i, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManagerTgwidget, androidx.recyclerview.widget.RecyclerView.p
        public void L1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
            a aVar = new a(recyclerView.getContext());
            aVar.p(i);
            M1(aVar);
        }
    }

    private class s0 extends TextViewSwitcher {
        private boolean a;
        private float b;

        public s0(Context context) {
            super(context);
            this.a = false;
            this.b = 1.0f;
        }

        public void b(int i, boolean z) {
            super.setVisibility(i);
            if (this.a && z) {
                PhotoViewer.this.I1.setVisibility(i);
            }
        }

        @Override // android.view.View
        public float getAlpha() {
            return this.a ? this.b : super.getAlpha();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (PhotoViewer.this.J1 == null || getParent() != PhotoViewer.this.J1) {
                return;
            }
            this.a = true;
            PhotoViewer.this.I1.setVisibility(getVisibility());
            PhotoViewer.this.I1.setAlpha(this.b);
            super.setAlpha(1.0f);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.a) {
                this.a = false;
                PhotoViewer.this.I1.setVisibility(8);
                super.setAlpha(this.b);
            }
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            this.b = f;
            if (this.a) {
                PhotoViewer.this.I1.setAlpha(f);
            } else {
                super.setAlpha(f);
            }
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (this.a) {
                PhotoViewer.this.I1.invalidate();
            }
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            b(i, true);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$t, reason: case insensitive filesystem */
    class C21499t extends PhotoViewerCaptionEnterView {
        C21499t(PhotoViewer photoViewer, Context context, SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto, View view, m.h hVar) {
            super(photoViewer, context, sizeNotifierFrameLayoutPhoto, view, hVar);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerCaptionEnterView
        protected void F(ActionMode actionMode, Menu menu) {
            U00.f(getContext(), "extendActionMode");
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            try {
                if (PhotoViewer.this.X5) {
                    return false;
                }
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return false;
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            try {
                if (PhotoViewer.this.X5) {
                    return false;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return false;
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (PhotoViewer.this.X5 && motionEvent.getAction() == 0) {
                PhotoViewer.this.a2 = true;
            }
            return !PhotoViewer.this.X5 && super.onTouchEvent(motionEvent);
        }
    }

    public static class t0 {
        public String a;
        public String b;
        public MediaController.i c;
        public MediaController.n d;
        public ArrayList e;
        public ArrayList f;
        public long g;

        public void a() {
            this.a = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.b = null;
            this.f = null;
            this.g = 0L;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$u, reason: case insensitive filesystem */
    class C21500u implements PhotoViewerCaptionEnterView.d {
        C21500u() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerCaptionEnterView.d
        public void a() {
            PhotoViewer.this.x7(true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerCaptionEnterView.d
        public void b(CharSequence charSequence) {
            int iN8 = PhotoViewer.this.n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.H4);
            if (PhotoViewer.this.K1.getCaptionLimitOffset() < 0) {
                PhotoViewer.this.F3.setText(Integer.toString(PhotoViewer.this.K1.getCaptionLimitOffset()));
                PhotoViewer.this.F3.setVisibility(PhotoViewer.this.S0.getVisibility());
                PhotoViewer.this.S0.setColorFilter(new PorterDuffColorFilter(QY0.k(iN8, (int) (Color.alpha(iN8) * 0.58f)), PorterDuff.Mode.MULTIPLY));
            } else {
                PhotoViewer.this.S0.setColorFilter(new PorterDuffColorFilter(iN8, PorterDuff.Mode.MULTIPLY));
                PhotoViewer.this.F3.setVisibility(8);
            }
            if (PhotoViewer.this.b != null) {
                PhotoViewer.this.b.onCaptionChanged(charSequence);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerCaptionEnterView.d
        public void c(int i) {
            if (i - (ActionBar.getCurrentActionBarHeight() * 2) < 108) {
                PhotoViewer.this.R3 = false;
                if (PhotoViewer.this.N3 == null || PhotoViewer.this.N3.getVisibility() != 0) {
                    return;
                }
                PhotoViewer.this.N3.setVisibility(4);
                return;
            }
            PhotoViewer.this.R3 = true;
            if (PhotoViewer.this.N3 == null || PhotoViewer.this.N3.getVisibility() != 4) {
                return;
            }
            PhotoViewer.this.N3.setVisibility(0);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$v, reason: case insensitive filesystem */
    class RunnableC21501v implements Runnable {
        RunnableC21501v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.P2 && PhotoViewer.this.r3 && !AbstractC14047hG.c) {
                if (PhotoViewer.this.A0 == null || !PhotoViewer.this.A0.U()) {
                    if (PhotoViewer.this.I1 == null || PhotoViewer.this.I1.getScrollY() == 0) {
                        if (PhotoViewer.this.W0 == null || PhotoViewer.this.W0.getVisibility() != 0) {
                            PhotoViewer photoViewer = PhotoViewer.q7;
                            PhotoViewer photoViewer2 = PhotoViewer.this;
                            if (photoViewer == photoViewer2) {
                                return;
                            }
                            photoViewer2.vb(false, true);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class v0 extends AppCompatImageView {
        private int d;
        private boolean e;
        private boolean f;
        private boolean g;
        private final TimeInterpolator h;
        private ValueAnimator i;

        public v0(Context context) {
            super(context);
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
            this.h = InterpolatorC12631ew1.i;
            setAlpha(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(ValueAnimator valueAnimator) {
            setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            if (PhotoViewer.this.j2 == null || PhotoViewer.this.j2.u1() == -9223372036854775807L) {
                ValueAnimator valueAnimator = this.i;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.i = null;
                }
                setAlpha(0.0f);
                return;
            }
            long jMax = Math.max(0L, PhotoViewer.this.j2.u1() - PhotoViewer.this.j2.s1());
            float fMax = 1.0f - Math.max(Math.min(jMax / 250.0f, 1.0f), 0.0f);
            if (fMax <= 0.0f) {
                ValueAnimator valueAnimator2 = this.i;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                    this.i = null;
                }
                setAlpha(0.0f);
                return;
            }
            if (!PhotoViewer.this.j2.A1()) {
                ValueAnimator valueAnimator3 = this.i;
                if (valueAnimator3 != null) {
                    valueAnimator3.cancel();
                    this.i = null;
                }
                setAlpha(fMax);
                return;
            }
            if (this.i == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fMax, 1.0f);
                this.i = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.J
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        this.a.f(valueAnimator4);
                    }
                });
                this.i.setDuration(jMax);
                this.i.setInterpolator(this.h);
                this.i.start();
                setAlpha(fMax);
            }
        }

        public void e() {
            this.f = false;
            this.g = false;
            if (this.e) {
                this.d++;
                this.e = false;
            }
            setImageResource(android.R.color.transparent);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$w, reason: case insensitive filesystem */
    class C21502w extends RecyclerListView {
        C21502w(Context context, m.h hVar) {
            super(context, hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void X1(AbstractC12098e22 abstractC12098e22, boolean z, float f, float f2) {
            if (PhotoViewer.this.P3 == abstractC12098e22) {
                PhotoViewer.this.P3 = null;
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return !PhotoViewer.this.X5 && super.dispatchTouchEvent(motionEvent);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return !PhotoViewer.this.X5 && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (PhotoViewer.this.Q3 && getVisibility() == 0 && PhotoViewer.this.P3 == null) {
                setTranslationY(i2 - i4);
                PhotoViewer.this.N3.setTranslationY(AbstractC22000uV3.a(PhotoViewer.this.N3.getTranslationY(), Math.min(r4, 0), Math.max(r4, 0)));
                PhotoViewer.this.P3 = ((C16463lJ6) ((C16463lJ6) new C16463lJ6(this, AbstractC12098e22.n).m(Math.min(r4, 0))).l(Math.max(r4, 0))).A(new C17645nJ6(0.0f).f(750.0f).d(1.0f));
                PhotoViewer.this.P3.b(new AbstractC12098e22.q() { // from class: ir.nasim.tgwidgets.editor.ui.o
                    @Override // ir.nasim.AbstractC12098e22.q
                    public final void a(AbstractC12098e22 abstractC12098e22, boolean z, float f, float f2) {
                        this.a.X1(abstractC12098e22, z, f, f2);
                    }
                });
                PhotoViewer.this.P3.s();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return !PhotoViewer.this.X5 && super.onTouchEvent(motionEvent);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            invalidate();
            if (getParent() != null) {
                ((View) getParent()).invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class w0 extends SizeNotifierFrameLayoutPhoto {
        private Paint g;
        private boolean h;
        private boolean i;
        AbstractC18973pa j;
        private ArrayList k;

        class a extends AbstractC18973pa {
            a(View view, boolean z) {
                super(view, z);
            }

            @Override // ir.nasim.AbstractC18973pa
            protected boolean m() {
                if (!PhotoViewer.this.K1.L()) {
                    PhotoViewer photoViewer = PhotoViewer.this;
                    if (photoViewer.a2 && photoViewer.a4 != 3) {
                        return true;
                    }
                }
                return false;
            }

            @Override // ir.nasim.AbstractC18973pa
            protected void q(float f, float f2, boolean z) {
                PhotoViewer.this.C3 = f;
                if (PhotoViewer.this.a4 != 3) {
                    PhotoViewer.this.o.setTranslationY(f);
                    if (PhotoViewer.this.t != null) {
                        PhotoViewer.this.t.setTranslationY(f);
                    }
                }
                if (PhotoViewer.this.W0 != null) {
                    PhotoViewer.this.W0.setTranslationY(f);
                }
                if (PhotoViewer.this.x6 != null) {
                    PhotoViewer.this.x6.setTranslationY(f);
                }
                if (PhotoViewer.this.P0 != null) {
                    PhotoViewer.this.P0.setTranslationY(f);
                }
                if (PhotoViewer.this.Q0 != null) {
                    PhotoViewer.this.Q0.setTranslationY(f);
                }
                if (PhotoViewer.this.j1 != null) {
                    PhotoViewer.this.j1.setTranslationY(f);
                }
                if (PhotoViewer.this.e2 != null) {
                    PhotoViewer.this.e2.setTranslationY(f);
                }
                if (PhotoViewer.this.b3 != null) {
                    PhotoViewer.this.b3.setTranslationY(f);
                }
                if (PhotoViewer.this.y1 != null) {
                    PhotoViewer.this.y1.setTranslationY(f);
                }
                if (PhotoViewer.this.E1 != null) {
                    PhotoViewer.this.E1.setTranslationY(f);
                }
                if (PhotoViewer.this.R0 != null) {
                    PhotoViewer.this.R0.setTranslationY(f);
                }
                if (PhotoViewer.this.S0 != null) {
                    PhotoViewer.this.S0.setTranslationY(f);
                }
                if (PhotoViewer.this.a4 == 3) {
                    PhotoViewerCaptionEnterView photoViewerCaptionEnterView = PhotoViewer.this.K1;
                    if (photoViewerCaptionEnterView != null) {
                        photoViewerCaptionEnterView.setTranslationY(f);
                    }
                    YZ2 unused = PhotoViewer.this.F1;
                } else {
                    if (PhotoViewer.this.F1 != null) {
                        PhotoViewer.this.F1.getView().setTranslationY(f);
                    }
                    PhotoViewerCaptionEnterView photoViewerCaptionEnterView2 = PhotoViewer.this.K1;
                    if (photoViewerCaptionEnterView2 != null) {
                        photoViewerCaptionEnterView2.setAlpha(f2 < 0.5f ? 0.0f : (f2 - 0.5f) / 0.5f);
                        PhotoViewer.this.K1.setTranslationY((f - this.q) + (AbstractC21455b.F(r0 / 2.0f) * (1.0f - f2)));
                    }
                }
                if (PhotoViewer.this.e1 != null) {
                    PhotoViewer.this.e1.setTranslationY(f);
                }
                if (PhotoViewer.this.b1 != null) {
                    PhotoViewer.this.b1.setTranslationY(f);
                }
                if (PhotoViewer.this.F3 != null) {
                    PhotoViewer.this.F3.setTranslationY(f);
                }
                w0.this.invalidate();
            }

            @Override // ir.nasim.AbstractC18973pa
            protected void r() {
                super.r();
                PhotoViewer.this.H.setVisibility(PhotoViewer.this.a4 != 2 ? 0 : 4);
                if (PhotoViewer.this.K1.getTag() == null) {
                    PhotoViewer.this.K1.setVisibility(8);
                }
                PhotoViewer.this.K1.setTranslationY(0.0f);
            }

            @Override // ir.nasim.AbstractC18973pa
            protected void s(boolean z, int i) {
                String str;
                int i2;
                PhotoViewer.this.H.setVisibility(4);
                PhotoViewer.this.d7(-16777216);
                if (PhotoViewer.this.K1.getTag() == null || !z) {
                    PhotoViewer.this.P0.animate().alpha(1.0f).setDuration(220L).start();
                    PhotoViewer.this.Q0.animate().alpha(1.0f).setDuration(220L).start();
                    if (PhotoViewer.this.Y3 == null || PhotoViewer.this.n1) {
                        return;
                    }
                    PhotoViewer.this.s.j(PhotoViewer.this.Y3, true, false);
                    PhotoViewer.this.Y3 = null;
                    return;
                }
                if (PhotoViewer.this.n1) {
                    if (PhotoViewer.this.f) {
                        str = "GifCaption";
                        i2 = TD5.tgwidget_GifCaption;
                    } else {
                        str = "VideoCaption";
                        i2 = TD5.tgwidget_VideoCaption;
                    }
                    PhotoViewer.this.s.j(FH3.E(str, i2), true, false);
                } else {
                    PhotoViewer.this.s.j(FH3.E("PhotoCaption", TD5.tgwidget_PhotoCaption), true, false);
                }
                PhotoViewer.this.K1.setAlpha(0.0f);
                PhotoViewer.this.P0.animate().alpha(0.0f).setDuration(220L).start();
                PhotoViewer.this.Q0.animate().alpha(0.0f).setDuration(220L).start();
                PhotoViewer.this.j1.animate().alpha(0.0f).translationY(-AbstractC21455b.F(10.0f)).setDuration(220L).start();
            }
        }

        class b implements Bulletin.a {
            b() {
            }
        }

        public w0(Context context, Activity activity) {
            super(context, activity, false);
            this.g = new Paint();
            this.j = new a(this, false);
            setWillNotDraw(false);
            this.g.setColor(855638016);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto
        public void H() {
            super.H();
            if (PhotoViewer.this.n1) {
                PhotoViewer.this.V0[0].p(2, getKeyboardHeight() <= AbstractC21455b.F(20.0f) ? 1.0f : 0.0f, true);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00f2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected boolean I(android.graphics.Canvas r7, android.view.View r8, long r9) {
            /*
                Method dump skipped, instructions count: 524
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.w0.I(android.graphics.Canvas, android.view.View, long):boolean");
        }

        public void J() {
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                this.k.clear();
                if (PhotoViewer.this.a4 == 1 || PhotoViewer.this.q5 == 1) {
                    int measuredHeight = getMeasuredHeight();
                    int measuredWidth = getMeasuredWidth();
                    this.k.add(new Rect(0, (measuredHeight - AbstractC21455b.F(200.0f)) / 2, AbstractC21455b.F(100.0f), (AbstractC21455b.F(200.0f) + measuredHeight) / 2));
                    this.k.add(new Rect(measuredWidth - AbstractC21455b.F(100.0f), (measuredHeight - AbstractC21455b.F(200.0f)) / 2, measuredWidth, (measuredHeight + AbstractC21455b.F(200.0f)) / 2));
                }
                setSystemGestureExclusionRects(this.k);
                invalidate();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0, 0, getWidth(), getHeight());
            super.dispatchDraw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (PhotoViewer.this.A == null || !PhotoViewer.this.A.H() || PhotoViewer.this.w1 == null || !PhotoViewer.this.w1.c()) {
                return;
            }
            int measuredHeight = ((int) (PhotoViewer.this.A.getWebView().getMeasuredHeight() * (PhotoViewer.this.e5 - 1.0f))) / 2;
            PhotoViewer.this.w1.setBounds(PhotoViewer.this.A.getLeft(), (PhotoViewer.this.A.getWebView().getTop() - measuredHeight) + ((int) (PhotoViewer.this.d5 / PhotoViewer.this.e5)), PhotoViewer.this.A.getRight(), PhotoViewer.this.A.getWebView().getBottom() + measuredHeight + ((int) (PhotoViewer.this.d5 / PhotoViewer.this.e5)));
            PhotoViewer.this.w1.draw(canvas);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            if (view == PhotoViewer.this.f4 || view == PhotoViewer.this.g4) {
                return false;
            }
            if (view != PhotoViewer.this.H) {
                canvas.save();
                canvas.clipRect(0, 0, getWidth(), getHeight());
            }
            boolean zI = I(canvas, view, j);
            if (view != PhotoViewer.this.H) {
                canvas.restore();
            }
            return zI;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.j.u(PhotoViewer.this.B);
            this.j.o();
            Bulletin.a(this, new b());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.j.p();
            Bulletin.l(this);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            ActionBar actionBar;
            PhotoViewer.this.da(canvas);
            if (!PhotoViewer.this.A8() || AbstractC21455b.d == 0 || (actionBar = PhotoViewer.this.o) == null) {
                return;
            }
            this.g.setAlpha((int) (actionBar.getAlpha() * 255.0f * 0.498f));
            if (getPaddingRight() > 0) {
                canvas.drawRect(getMeasuredWidth() - getPaddingRight(), 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.g);
            }
            if (getPaddingLeft() > 0) {
                canvas.drawRect(0.0f, 0.0f, getPaddingLeft(), getMeasuredHeight(), this.g);
            }
            if (getPaddingBottom() > 0) {
                float fH = AbstractC21455b.H(24.0f) * (1.0f - PhotoViewer.this.o.getAlpha());
                canvas.drawRect(0.0f, (getMeasuredHeight() - getPaddingBottom()) + fH, getMeasuredWidth(), getMeasuredHeight() + fH, this.g);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
        @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r16, int r17, int r18, int r19, int r20) {
            /*
                Method dump skipped, instructions count: 439
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.w0.onLayout(boolean, int, int, int, int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0293  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0296  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r19, int r20) {
            /*
                Method dump skipped, instructions count: 719
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.w0.onMeasure(int, int):void");
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.h) {
                return;
            }
            super.requestLayout();
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$x, reason: case insensitive filesystem */
    class C21503x extends LinearLayoutManagerTgwidget {
        C21503x(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManagerTgwidget, androidx.recyclerview.widget.RecyclerView.p
        public boolean P1() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class x0 extends RecyclerListView.n {
        private Context d;

        public x0(Context context) {
            this.d = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C(View view) {
            Object tag = ((View) view.getParent()).getTag();
            int iIndexOf = PhotoViewer.this.h6.indexOf(tag);
            if (iIndexOf < 0) {
                int photoUnchecked = PhotoViewer.this.b.setPhotoUnchecked(tag);
                if (photoUnchecked >= 0) {
                    PhotoViewer.this.k1.notifyItemRemoved(photoUnchecked);
                    if (photoUnchecked == 0) {
                        PhotoViewer.this.k1.notifyItemChanged(0);
                    }
                    PhotoViewer.this.Mb();
                    return;
                }
                return;
            }
            int photoChecked = PhotoViewer.this.b.setPhotoChecked(iIndexOf, PhotoViewer.this.c8());
            boolean zIsPhotoChecked = PhotoViewer.this.b.isPhotoChecked(iIndexOf);
            if (iIndexOf == PhotoViewer.this.p4) {
                PhotoViewer.this.P0.setChecked(-1, zIsPhotoChecked, true);
            }
            if (photoChecked >= 0) {
                PhotoViewer.this.k1.notifyItemRemoved(photoChecked);
                if (photoChecked == 0) {
                    PhotoViewer.this.k1.notifyItemChanged(0);
                }
            }
            PhotoViewer.this.Mb();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.n
        public boolean A(RecyclerView.C c) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            if (PhotoViewer.this.b == null || PhotoViewer.this.b.getSelectedPhotosOrder() == null) {
                return 0;
            }
            return PhotoViewer.this.b.getSelectedPhotosOrder().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(RecyclerView.C c, int i) {
            PhotoPickerPhotoCell photoPickerPhotoCell = (PhotoPickerPhotoCell) c.a;
            photoPickerPhotoCell.setItemWidth(AbstractC21455b.F(85.0f), i != 0 ? AbstractC21455b.F(6.0f) : 0);
            BackupImageView backupImageView = photoPickerPhotoCell.a;
            backupImageView.setOrientation(0, true);
            Object obj = PhotoViewer.this.b.getSelectedPhotos().get(PhotoViewer.this.b.getSelectedPhotosOrder().get(i));
            if (obj instanceof MediaController.m) {
                MediaController.m mVar = (MediaController.m) obj;
                photoPickerPhotoCell.setTag(mVar);
                photoPickerPhotoCell.e.setVisibility(4);
                String str = mVar.b;
                if (str != null) {
                    backupImageView.setImage(str, null, this.d.getResources().getDrawable(AbstractC23598xB5.nophotos));
                } else if (mVar.A != null) {
                    backupImageView.setOrientation(mVar.B, mVar.C, true);
                    if (mVar.D) {
                        photoPickerPhotoCell.e.setVisibility(0);
                        photoPickerPhotoCell.d.setText(AbstractC21455b.O(mVar.w));
                        backupImageView.setImage("vthumb://" + mVar.u + ":" + mVar.A, null, this.d.getResources().getDrawable(AbstractC23598xB5.nophotos));
                    } else {
                        backupImageView.setImage("thumb://" + mVar.u + ":" + mVar.A, null, this.d.getResources().getDrawable(AbstractC23598xB5.nophotos));
                    }
                } else {
                    backupImageView.setImageResource(AbstractC23598xB5.nophotos);
                }
                photoPickerPhotoCell.setChecked(-1, true, false);
                photoPickerPhotoCell.c.setVisibility(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
            PhotoPickerPhotoCell photoPickerPhotoCell = new PhotoPickerPhotoCell(this.d);
            photoPickerPhotoCell.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.L
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.C(view);
                }
            });
            return new RecyclerListView.g(photoPickerPhotoCell);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$y, reason: case insensitive filesystem */
    class C21504y extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        C21504y(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.O0.setColor(this.a);
            FrameLayout frameLayout = PhotoViewer.this.B;
            if (frameLayout != null) {
                frameLayout.invalidate();
            }
        }
    }

    public interface y0 {
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$z, reason: case insensitive filesystem */
    class C21505z extends AnimatorListenerAdapter {
        final /* synthetic */ Bitmap a;

        /* renamed from: ir.nasim.tgwidgets.editor.ui.PhotoViewer$z$a */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                PhotoViewer.this.k2 = false;
                if (PhotoViewer.this.j2 != null) {
                    PhotoViewer.this.j2.E1();
                }
                PhotoViewer.this.l2 = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PhotoViewer.this.g2 = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PhotoViewer.this.g2 == null) {
                    return;
                }
                PhotoViewer photoViewer = PhotoViewer.this;
                Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                };
                photoViewer.l2 = runnable;
                AbstractC21455b.n1(runnable, 860L);
            }
        }

        C21505z(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.this.y1.setVideoThumb(this.a, 0);
            PhotoViewer.this.g2 = new AnimatorSet();
            PhotoViewer.this.g2.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.f2, (Property<View, Float>) PhotoViewer.this.E3, 0.0f));
            PhotoViewer.this.g2.setDuration(85L);
            PhotoViewer.this.g2.setInterpolator(InterpolatorC12631ew1.g);
            PhotoViewer.this.g2.addListener(new a());
            PhotoViewer.this.g2.start();
        }
    }

    private static class z0 extends View {
        Paint a;
        AnimatedTextView.a b;
        TextPaint c;
        StaticLayout d;
        float e;
        float f;
        AnimatedTextView.a g;
        private String h;
        private boolean i;
        private C9151Ys j;
        private boolean k;
        private int l;

        public z0(Context context) {
            super(context);
            this.a = new Paint(1);
            this.c = new TextPaint(1);
            this.i = false;
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
            this.j = new C9151Ys(this, 0L, 350L, interpolatorC12631ew1);
            this.a.setColor(2130706432);
            AnimatedTextView.a aVar = new AnimatedTextView.a(false, true, true);
            this.b = aVar;
            aVar.G(0.3f, 0L, 320L, interpolatorC12631ew1);
            this.b.R(-1);
            this.b.S(AbstractC21455b.F(14.0f));
            this.b.T(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.b.setCallback(this);
            this.b.O("0");
            this.b.L(AbstractC21455b.h.x);
            this.c.setColor(-1);
            this.c.setTextSize(AbstractC21455b.F(14.0f));
            this.c.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            d();
            AnimatedTextView.a aVar2 = new AnimatedTextView.a(false, true, true);
            this.g = aVar2;
            aVar2.G(0.3f, 0L, 320L, interpolatorC12631ew1);
            this.g.R(-1);
            this.g.S(AbstractC21455b.F(14.0f));
            this.g.T(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.g.setCallback(this);
            this.g.O("0");
            this.g.L(AbstractC21455b.h.x);
        }

        private String a() {
            this.h = FH3.w().v().c;
            return FH3.E("Of", TD5.tgwidget_Of).replace("%1$d", "").replace("%2$d", "");
        }

        private void d() {
            StaticLayout staticLayout = new StaticLayout(a(), this.c, AbstractC21455b.F(200.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            this.d = staticLayout;
            if (staticLayout.getLineCount() >= 1) {
                this.e = this.d.getLineWidth(0);
                this.f = this.d.getLineDescent(0);
            } else {
                this.e = 0.0f;
                this.f = 0.0f;
            }
        }

        public void b(int i, int i2) {
            c(i, i2, true);
        }

        public void c(int i, int i2, boolean z) {
            boolean z2 = false;
            int iMax = Math.max(0, i);
            int iMax2 = Math.max(iMax, i2);
            if (FH3.w().v() != null && !TextUtils.equals(this.h, FH3.w().v().c)) {
                d();
            }
            this.b.P(String.format("%d", Integer.valueOf(FH3.D ? iMax2 : iMax)), (!z || this.k || FH3.D) ? false : true);
            AnimatedTextView.a aVar = this.g;
            if (!FH3.D) {
                iMax = iMax2;
            }
            String str = String.format("%d", Integer.valueOf(iMax));
            if (z && !this.k && !FH3.D) {
                z2 = true;
            }
            aVar.P(str, z2);
            this.k = !z;
        }

        public void e(boolean z, boolean z2) {
            if (this.i != z) {
                this.i = z;
                if (!z) {
                    this.k = true;
                }
                if (!z2) {
                    this.j.d(z ? 1.0f : 0.0f, true);
                }
                invalidate();
            }
        }

        @Override // android.view.View
        public boolean isShown() {
            return this.i;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float fC = this.j.c(this.i ? 1.0f : 0.0f);
            if (fC <= 0.0f) {
                return;
            }
            float fT = this.b.t() + this.e + this.g.t() + AbstractC21455b.F(18.0f);
            float f = this.l + ((1.0f - fC) * (-AbstractC21455b.F(8.0f)));
            RectF rectF = AbstractC21455b.x;
            rectF.set((getWidth() - fT) / 2.0f, AbstractC21455b.H(10.0f) + f, (getWidth() + fT) / 2.0f, AbstractC21455b.H(33.0f) + f);
            int alpha = this.a.getAlpha();
            this.a.setAlpha((int) (alpha * fC));
            canvas.drawRoundRect(rectF, AbstractC21455b.H(12.0f), AbstractC21455b.H(12.0f), this.a);
            this.a.setAlpha(alpha);
            canvas.save();
            canvas.translate(((getWidth() - fT) / 2.0f) + AbstractC21455b.F(9.0f), f + AbstractC21455b.F(10.0f));
            AnimatedTextView.a aVar = this.b;
            aVar.setBounds(0, 0, (int) aVar.t(), AbstractC21455b.F(23.0f));
            int i = (int) (fC * 255.0f);
            this.b.setAlpha(i);
            this.b.draw(canvas);
            canvas.translate(this.b.t(), 0.0f);
            canvas.save();
            canvas.translate((-(this.d.getWidth() - this.e)) / 2.0f, ((AbstractC21455b.F(23.0f) - this.d.getHeight()) + (this.f / 2.0f)) / 2.0f);
            this.c.setAlpha(i);
            this.d.draw(canvas);
            canvas.restore();
            canvas.translate(this.e, 0.0f);
            AnimatedTextView.a aVar2 = this.g;
            aVar2.setBounds(0, 0, (int) aVar2.t(), AbstractC21455b.F(23.0f));
            this.g.setAlpha(i);
            this.g.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            this.l = ActionBar.getCurrentActionBarHeight() + AbstractC21455b.d;
            this.b.L(size);
            this.g.L(size);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.l + AbstractC21455b.F(43.0f), 1073741824));
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            return this.b == drawable || this.g == drawable || super.verifyDrawable(drawable);
        }
    }

    public PhotoViewer() {
        this.O0.setColor(-16777216);
        this.n4.setColor(-1);
        this.i4.K0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A7, reason: merged with bridge method [inline-methods] */
    public TextView L9() {
        A a = new A(this.n);
        CW7.a(a, 16.0f, 8.0f, 16.0f, 8.0f);
        a.setLinkTextColor(-8796932);
        a.setTextColor(-1);
        a.setHighlightColor(872415231);
        a.setGravity(AbstractC13840gu3.q() | 16);
        a.setTextSize(1, 16.0f);
        a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ia5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewer.O8(view);
            }
        });
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A8() {
        return !this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A9() {
        this.y1.r(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa(boolean z) {
        if (this.j2 != null) {
            q7();
            AbstractC21455b.t(this.c2);
            AbstractC21455b.t(this.d2);
            if (this.F2 != null) {
                this.G2.put(this.F2, new G0(this.j2.s1() / this.j2.u1(), SystemClock.elapsedRealtime()));
            }
            this.j2.H1(true);
            this.j2 = null;
        } else {
            this.A2 = false;
        }
        if (this.A != null) {
            AbstractC21455b.t(this.d2);
            if (this.F2 != null) {
                this.G2.put(this.F2, new G0(d8() / o8(), SystemClock.elapsedRealtime()));
            }
        }
        OrientationEventListener orientationEventListener = this.x3;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.x3 = null;
        }
        this.W2.g();
        yb(false, false);
        this.W1 = false;
        this.x2 = false;
        if (this.I0.isEnabled()) {
            this.I0.setEnabled(false);
            this.I0.animate().alpha(0.5f).setDuration(175L).withEndAction(null).start();
        }
        if (this.L2) {
            try {
                this.m.getWindow().clearFlags(128);
                this.L2 = false;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.e2;
        if (aspectRatioFrameLayout != null) {
            try {
                this.z.removeView(aspectRatioFrameLayout);
            } catch (Throwable unused) {
            }
            this.e2 = null;
        }
        o7();
        this.f2 = null;
        TextureView textureView = this.h2;
        if (textureView != null) {
            if (textureView instanceof VideoEditTextureView) {
                ((VideoEditTextureView) textureView).f();
            }
            this.h2 = null;
        }
        if (this.r3) {
            this.r3 = false;
            AbstractC21455b.t(this.I3);
        }
        if (!z && !this.i7 && !this.j7) {
            gb(false, true);
        }
        this.V0[0].m();
    }

    private void Ab(boolean z, boolean z2) {
        if (z == this.q) {
            return;
        }
        if (z) {
            this.j1.setVisibility(0);
        }
        this.q = z;
        this.j1.setEnabled(z);
        if (!z2) {
            this.j1.setAlpha(z ? 1.0f : 0.0f);
            this.j1.setTranslationY(z ? 0.0f : -AbstractC21455b.F(10.0f));
            this.Q0.setRotationX(z ? 1.0f : 0.0f);
            if (z) {
                return;
            }
            this.j1.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.j1, (Property<H0, Float>) View.ALPHA, z ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.j1, (Property<H0, Float>) View.TRANSLATION_Y, z ? 0.0f : -AbstractC21455b.F(10.0f)));
        arrayList.add(ObjectAnimator.ofFloat(this.Q0, (Property<CounterView, Float>) View.ROTATION_X, z ? 1.0f : 0.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        this.x1 = animatorSet;
        animatorSet.playTogether(arrayList);
        if (!z) {
            this.x1.addListener(new X());
        }
        this.x1.setDuration(200L);
        this.x1.start();
    }

    private void B7() {
        if (this.y1 != null) {
            return;
        }
        PhotoCropView photoCropView = new PhotoCropView(this.n, this.b2);
        this.y1 = photoCropView;
        photoCropView.setVisibility(8);
        this.y1.o();
        this.z.addView(this.y1, this.z.indexOfChild(this.y6) - 1, AbstractC13840gu3.c(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        this.y1.setDelegate(new N());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B8() {
        PhotoViewerWebView photoViewerWebView = this.A;
        if (photoViewerWebView != null && photoViewerWebView.H()) {
            return this.A.K();
        }
        FT7 ft7 = this.j2;
        return ft7 != null && ft7.A1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B9(View view) {
        float f = -this.y1.c.getStateOrientation();
        if (Math.abs(f) > 180.0f) {
            f = f < 0.0f ? f + 360.0f : -(360.0f - f);
        }
        I7(f, this.y1.c.getStateMirror(), new Runnable() { // from class: ir.nasim.Sa5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A9();
            }
        });
    }

    private void Ba() {
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.N1);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.M1);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.L1);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.U);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.T);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.Z);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.w);
        ir.nasim.tgwidgets.editor.messenger.E.j().u(this, ir.nasim.tgwidgets.editor.messenger.E.K2);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.Q1);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.v).u(this, ir.nasim.tgwidgets.editor.messenger.E.P1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        FT7 ft7;
        FT7 ft72;
        PhotoViewerWebView photoViewerWebView;
        if (this.j2 != null || ((photoViewerWebView = this.A) != null && photoViewerWebView.H())) {
            boolean zK = this.j2 != null ? this.r3 : this.A.K();
            q7();
            AbstractC21455b.t(this.d2);
            if (zK) {
                sa();
            } else {
                if (!this.n1) {
                    if (Math.abs(this.U2.g() - this.y6.getRightProgress()) < 0.01f || ((ft7 = this.j2) != null && ft7.s1() == this.j2.u1())) {
                        Ia(0.0f);
                    }
                    Ea();
                } else if (Math.abs(this.y6.getProgress() - this.y6.getRightProgress()) < 0.01f || ((ft72 = this.j2) != null && ft72.s1() == this.j2.u1())) {
                    Ia(this.y6.getLeftProgress());
                }
                ua();
            }
            this.z.invalidate();
        }
    }

    private Bitmap C7(Bitmap bitmap, MediaController.i iVar, int[] iArr, boolean z) {
        int i;
        int i2;
        try {
            int i3 = 0;
            int i4 = (iVar.i + (iArr != null ? iArr[0] : 0)) % 360;
            if (iArr != null && iArr.length > 1) {
                i3 = iArr[1];
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i4 == 90 || i4 == 270) {
                i = width;
                i2 = height;
            } else {
                i2 = width;
                i = height;
            }
            float f = i2;
            float f2 = i;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (iVar.e * f), (int) (iVar.f * f2), Bitmap.Config.ARGB_8888);
            Matrix matrix = new Matrix();
            matrix.postTranslate((-width) / 2, (-height) / 2);
            if (z && iVar.j) {
                if (i4 == 90 || i4 == 270) {
                    matrix.postScale(1.0f, -1.0f);
                } else {
                    matrix.postScale(-1.0f, 1.0f);
                }
            }
            if (i3 == 1) {
                matrix.postScale(-1.0f, 1.0f);
            } else if (i3 == 2) {
                matrix.postScale(1.0f, -1.0f);
            }
            matrix.postRotate(iVar.d + i4);
            matrix.postTranslate(iVar.a * f, iVar.b * f2);
            float f3 = iVar.c;
            matrix.postScale(f3, f3);
            matrix.postTranslate(r10 / 2, r11 / 2);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(2));
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        C0 c0;
        Bitmap bitmapL;
        if (imageReceiver == this.i4 && z && !z2) {
            if (!this.n1 && ((this.a4 == 1 || this.L1 == 1) && this.y1 != null && (bitmapL = imageReceiver.l()) != null)) {
                this.y1.setBitmap(bitmapL, imageReceiver.Q(), this.L1 != 1, true, this.e4, this.z1, null, null);
            }
            if (this.e4.getVisibility() == 0) {
                this.z.requestLayout();
            }
            K7();
        }
        if (imageReceiver != this.i4 || !z || (c0 = this.b) == null || !c0.scaleToFill() || this.D4 || this.L1 == 1) {
            return;
        }
        if (this.Y4) {
            fb();
        } else {
            this.Z4 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca(int i) {
        if (this.f7 != null) {
            MediaController.Y().P(this.f7);
        }
        boolean z = this.j7 && !this.g7;
        this.j7 = false;
        this.h7 = false;
        this.x6.setVisibility(4);
        if (i != 1) {
            this.g7 = false;
            this.V0[0].o(3, false, true);
            if (i == 2) {
                wa(this.s4, false, false, this.t4.d);
                this.j2.I1((long) (this.y6.getLeftProgress() * this.P6));
            }
        } else if (this.M6 == this.K6 && this.L6 == this.J6) {
            this.g7 = false;
            A0 a0 = this.V0[0];
            a0.q(0.0f, a0.h == 0 || this.V0[0].k == 0);
            this.V0[0].o(3, false, true);
            if (z) {
                this.h7 = true;
            } else {
                wa(this.s4, false, false, this.t4.d);
                this.j2.I1((long) (this.y6.getLeftProgress() * this.P6));
            }
        } else {
            Aa(false);
            if (this.f7 == null) {
                C18981pa7 c18981pa7 = new C18981pa7();
                c18981pa7.b = 0;
                c18981pa7.g = "";
                c18981pa7.h = new C19001pc7();
                c18981pa7.f = new C6564Oa7();
                c18981pa7.Q = this.L4;
                C10743c74 c10743c74 = new C10743c74(C22477vI7.f, c18981pa7, false, false);
                this.f7 = c10743c74;
                c10743c74.e.M = new File(C4278El2.B(4), "video_preview.mp4").getAbsolutePath();
                this.f7.D = new ir.nasim.tgwidgets.editor.messenger.H();
                ir.nasim.tgwidgets.editor.messenger.H h = this.f7.D;
                h.g = this.I6;
                h.h = this.J6;
                this.f7.D.i = this.K6;
                ir.nasim.tgwidgets.editor.messenger.H h2 = this.f7.D;
                h2.n = this.Q6;
                h2.o = this.s4.getPath();
            }
            ir.nasim.tgwidgets.editor.messenger.H h3 = this.f7.D;
            long j = this.T6;
            h3.a = j;
            long j2 = this.U6;
            h3.b = j2;
            if (j == -1) {
                j = 0;
            }
            if (j2 == -1) {
                j2 = (long) (this.P6 * 1000.0f);
            }
            if (j2 - j > 5000000) {
                h3.b = j + 5000000;
            }
            h3.m = this.N6;
            this.f7.D.k = this.L6;
            this.f7.D.l = this.M6;
            ir.nasim.tgwidgets.editor.messenger.H h4 = this.f7.D;
            h4.L = true;
            h4.t = (long) (this.P6 * 1000.0f);
            if (!MediaController.Y().H0(this.f7, true, true)) {
                this.g7 = true;
            }
            this.j7 = true;
            A0 a02 = this.V0[0];
            a02.q(0.0f, a02.h == 0 || this.V0[0].k == 0);
            this.V0[0].o(0, false, true);
        }
        this.z.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        if (this.v3 != null) {
            int i = this.V0[0].h;
            if (!this.V0[0].i() || (i != 3 && i != 4 && i != 2 && i != 1)) {
                this.v3.setVisibility(4);
                return;
            }
            if (i == 3) {
                this.v3.setContentDescription(FH3.E("AccActionPlay", TD5.tgwidget_AccActionPlay));
            } else if (i == 2) {
                this.v3.setContentDescription(FH3.E("AccActionDownload", TD5.tgwidget_AccActionDownload));
            } else if (i == 1) {
                this.v3.setContentDescription(FH3.E("AccActionCancelDownload", TD5.tgwidget_AccActionCancelDownload));
            } else {
                this.v3.setContentDescription(FH3.E("AccActionPause", TD5.tgwidget_AccActionPause));
            }
            this.v3.setVisibility(0);
        }
    }

    private void D7() {
        int iO;
        int iM;
        MediaController.i iVar;
        if (this.F1 == null) {
            TextureView textureView = this.h2;
            if (textureView != null) {
                VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
                iO = videoEditTextureView.getVideoWidth();
                iM = videoEditTextureView.getVideoHeight();
                while (true) {
                    if (iO <= 1280 && iM <= 1280) {
                        break;
                    }
                    iO /= 2;
                    iM /= 2;
                }
            } else {
                iO = this.i4.o();
                iM = this.i4.m();
            }
            Bitmap bitmap = this.e4.getBitmap();
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(iO, iM, Bitmap.Config.ARGB_8888);
            }
            Bitmap bitmap2 = bitmap;
            if (this.L1 == 1) {
                iVar = new MediaController.i();
                iVar.i = this.z1.i();
            } else {
                iVar = this.t4.c;
            }
            MediaController.i iVar2 = iVar;
            Activity activity = this.m;
            T t = new T(activity, activity, this.v, bitmap2, this.n1 ? null : this.i4.l(), this.i4.Q(), this.t4.e, iVar2, new Runnable() { // from class: ir.nasim.ab5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.P8();
                }
            }, this.b2);
            this.F1 = t;
            this.z.addView(t.getView(), AbstractC13840gu3.b(-1, -1.0f));
            this.F1.setOnDoneButtonClickedListener(new Runnable() { // from class: ir.nasim.bb5
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException, FileNotFoundException {
                    this.a.Q8();
                }
            });
            this.F1.getCancelView().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cb5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.R8(view);
                }
            });
            this.F1.setOffsetTranslationY(AbstractC21455b.F(126.0f), 0.0f, 0, false);
            this.F1.setOffsetTranslationX(-AbstractC21455b.F(12.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D8(int i, int i2, ValueAnimator valueAnimator) {
        this.O0.setColor(QY0.c(i, i2, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D9(View view) {
        if (this.K1.getTag() != null) {
            return;
        }
        eb();
    }

    private void Da() throws InterruptedException, Resources.NotFoundException {
        Object objK = this.i4.K();
        if (objK == null || !objK.equals(1)) {
            return;
        }
        Ua(this.i4, this.p4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Db() {
        if (this.F0 == null || this.s == null) {
            return;
        }
        float fMax = 0.0f;
        for (int i = 0; i < this.F0.getChildCount(); i++) {
            View childAt = this.F0.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                fMax += Math.min(0.5f, childAt.getAlpha()) * 2.0f * childAt.getWidth();
            }
        }
        CheckBox checkBox = this.P0;
        if (checkBox != null && checkBox.getVisibility() == 0) {
            fMax = Math.max(fMax, AbstractC21455b.F(48.0f));
        }
        CounterView counterView = this.Q0;
        if (counterView != null && counterView.getVisibility() == 0) {
            fMax = Math.max(fMax, AbstractC21455b.F(100.0f));
        }
        this.s.l(fMax, false);
    }

    private void E7() {
        I0 i0 = new I0(this.z.getContext());
        this.M2 = i0;
        this.z.addView(i0, AbstractC13840gu3.d(-1, 48, 83));
        E e = new E();
        G g = new G(e);
        H h = new H(this.z.getContext());
        this.V2 = h;
        h.setAccessibilityDelegate(g);
        this.V2.setImportantForAccessibility(1);
        this.M2.addView(this.V2, AbstractC13840gu3.b(-1, -1.0f));
        C15381jU7 c15381jU7 = new C15381jU7(this.V2);
        this.U2 = c15381jU7;
        c15381jU7.q(AbstractC21455b.F(2.0f));
        this.U2.o(872415231, 872415231, -1, -1, -1, 1509949439);
        this.U2.p(e);
        I i = new I(this.z.getContext(), new VideoSeekPreviewImage.a() { // from class: ir.nasim.Ta5
            @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoSeekPreviewImage.a
            public final void a() {
                this.a.S8();
            }
        });
        this.W2 = i;
        i.setAlpha(0.0f);
        this.z.addView(this.W2, AbstractC13840gu3.c(-2, -2.0f, 83, 0.0f, 0.0f, 0.0f, 58.0f));
        SimpleTextView simpleTextView = new SimpleTextView(this.z.getContext());
        this.S2 = simpleTextView;
        simpleTextView.setTextColor(-1);
        this.S2.setGravity(53);
        this.S2.setTextSize(14);
        this.S2.setImportantForAccessibility(2);
        this.M2.addView(this.S2, AbstractC13840gu3.c(-2, -2.0f, 53, 0.0f, 15.0f, 12.0f, 0.0f));
        ImageView imageView = new ImageView(this.z.getContext());
        this.T2 = imageView;
        imageView.setImageResource(AbstractC23598xB5.msg_minvideo);
        this.T2.setContentDescription(FH3.E("AccExitFullscreen", TD5.tgwidget_AccExitFullscreen));
        this.T2.setScaleType(ImageView.ScaleType.CENTER);
        this.T2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.T2.setVisibility(4);
        this.M2.addView(this.T2, AbstractC13840gu3.d(48, 48, 53));
        this.T2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ua5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.T8(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ File E8(AbstractC12724f57 abstractC12724f57) {
        return C4278El2.H(this.v).Q(abstractC12724f57, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E9(View view) {
        C0 c0;
        if (this.K1.getTag() != null || (c0 = this.b) == null || c0.getSelectedPhotosOrder() == null || this.b.getSelectedPhotosOrder().isEmpty()) {
            return;
        }
        Ab(!this.q, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
        Fa(3000);
    }

    private void Eb(Object obj) {
        CharSequence charSequence = this.o6 ? this.p6 : obj instanceof MediaController.m ? ((MediaController.m) obj).a : null;
        if (TextUtils.isEmpty(charSequence)) {
            this.m6.e("");
            this.K1.setFieldText("");
        } else {
            this.m6.e(charSequence);
            this.K1.setFieldText(charSequence);
        }
        this.K1.setAllowTextEntitiesIntersection(qb());
    }

    private void F7(final MediaController.n nVar) {
        if (this.h2 != null) {
            return;
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.m);
        this.e2 = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setWillNotDraw(false);
        this.e2.setVisibility(4);
        this.z.addView(this.e2, 0, AbstractC13840gu3.d(-1, -1, 17));
        if (this.h6.isEmpty()) {
            this.h2 = new TextureView(this.m);
        } else {
            VideoEditTextureView videoEditTextureView = new VideoEditTextureView(this.m, this.j2);
            if (nVar != null) {
                videoEditTextureView.setDelegate(new VideoEditTextureView.a() { // from class: ir.nasim.hb5
                    @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView.a
                    public final void a(ir.nasim.tgwidgets.editor.ui.Components.k kVar) {
                        PhotoViewer.U8(nVar, kVar);
                    }
                });
            }
            this.h2 = videoEditTextureView;
        }
        SurfaceTexture surfaceTexture = this.w2;
        if (surfaceTexture != null) {
            this.h2.setSurfaceTexture(surfaceTexture);
            this.j3 = true;
            this.k3 = true;
            this.w2 = null;
        }
        this.h2.setPivotX(0.0f);
        this.h2.setPivotY(0.0f);
        this.h2.setOpaque(false);
        this.e2.addView(this.h2, AbstractC13840gu3.d(-1, -1, 17));
        v0 v0Var = new v0(this.m);
        this.i2 = v0Var;
        v0Var.setPivotX(0.0f);
        this.i2.setPivotY(0.0f);
        this.i2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e2.addView(this.i2, AbstractC13840gu3.d(-1, -1, 17));
        if (this.L1 == 1) {
            View view = new View(this.m);
            this.f2 = view;
            view.setBackgroundColor(-1);
            this.f2.setAlpha(0.0f);
            this.e2.addView(this.f2, AbstractC13840gu3.d(-1, -1, 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ File F8(L57 l57) {
        return C4278El2.H(this.v).R(l57);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9(View view, int i) throws InterruptedException, Resources.NotFoundException {
        int i2;
        if (!this.h6.isEmpty() && (i2 = this.p4) >= 0 && i2 < this.h6.size()) {
            Object obj = this.h6.get(this.p4);
            if (obj instanceof MediaController.l) {
                ((MediaController.l) obj).m = c8();
            }
        }
        this.D4 = true;
        int iIndexOf = this.h6.indexOf(view.getTag());
        if (iIndexOf >= 0) {
            this.p4 = -1;
            Ra(iIndexOf);
        }
        this.D4 = false;
    }

    private void Fa(int i) {
        if (y8()) {
            return;
        }
        AbstractC21455b.t(this.d2);
        AbstractC21455b.n1(this.d2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G7() {
        if (this.r5 != null || this.y1 == null) {
            return false;
        }
        this.g5 = 0.0f;
        this.l5 = 1.0f;
        this.p5 = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.r5 = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<PhotoViewer, Float>) AbstractC21469h.d, 0.0f, 1.0f));
        this.r5.setDuration(250L);
        this.r5.setInterpolator(InterpolatorC12631ew1.f);
        this.r5.addListener(new B());
        this.r5.start();
        return !this.y1.c.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G8(int i, File file, File file2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = false;
        if (this.V5 && !this.W5 && this.r3) {
            this.V0[i].o(3, false, false);
            return;
        }
        if (!(file == null && file2 == null) && (z || z2)) {
            if (i != 0 || !this.r3) {
                if (!z3 || (z4 && !(i == 0 && this.A2))) {
                    this.V0[i].o(-1, z5, true);
                } else {
                    this.V0[i].o(3, z5, true);
                }
            }
            if (i == 0 && !this.A0.U()) {
                if (z || !C4278El2.H(this.v).T(this.w4[i])) {
                    this.A0.R(7);
                } else {
                    this.A0.m0(7);
                }
            }
        } else {
            if (!z3) {
                this.V0[i].o(0, z5, true);
            } else if (C4278El2.H(this.v).T(this.w4[i])) {
                this.V0[i].o(1, false, true);
            } else {
                this.V0[i].o(2, false, true);
            }
            Float fB0 = C21457d.g0().b0(this.w4[i]);
            if (fB0 == null) {
                fB0 = Float.valueOf(0.0f);
            }
            this.V0[i].q(fB0.floatValue(), false);
        }
        if (i == 0) {
            if (!this.Z3 && (!this.h6.isEmpty() || (this.w4[0] != null && this.V0[0].h != 0))) {
                z6 = true;
            }
            this.I5 = z6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets G9(View view, WindowInsets windowInsets) {
        windowInsets.getSystemWindowInsetTop();
        WindowInsets windowInsets2 = (WindowInsets) this.X1;
        this.X1 = windowInsets;
        if (windowInsets2 == null || !windowInsets2.toString().equals(windowInsets.toString())) {
            int i = this.S3;
            if (i == 1 || i == 3) {
                ClippingImageView clippingImageView = this.D;
                clippingImageView.setTranslationX(clippingImageView.getTranslationX() - l8());
                this.L3[0][2] = this.D.getTranslationX();
            }
            FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                frameLayout.requestLayout();
            }
        }
        if (this.H != null) {
            this.J = windowInsets.getSystemWindowInsetBottom();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.H.getLayoutParams();
            int i2 = this.J;
            marginLayoutParams.height = i2;
            marginLayoutParams.bottomMargin = (-i2) / 2;
            this.H.setLayoutParams(marginLayoutParams);
        }
        this.z.setPadding(windowInsets.getSystemWindowInsetLeft(), 0, windowInsets.getSystemWindowInsetRight(), 0);
        if (this.o != null) {
            AbstractC21455b.t(this.b4);
            if (this.c && this.S3 == 0) {
                AbstractC21455b.n1(this.b4, 200L);
            }
        }
        return Build.VERSION.SDK_INT >= 30 ? WindowInsets.CONSUMED : windowInsets.consumeSystemWindowInsets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(long j) throws InterruptedException {
        RLottieDrawable rLottieDrawableJ;
        ArrayList arrayList = this.t4.e;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                H.b bVar = (H.b) this.t4.e.get(i);
                if (bVar.a == 0 && (bVar.b & 1) != 0) {
                    View view = bVar.C;
                    if ((view instanceof BackupImageView) && (rLottieDrawableJ = ((BackupImageView) view).getImageReceiver().J()) != null) {
                        long j2 = this.T6;
                        rLottieDrawableJ.t0(j - (j2 > 0 ? j2 / 1000 : 0L));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb(int i, int i2) {
        int iMax = Math.max(i, i2);
        if (iMax > 1280) {
            this.G6 = 4;
            return;
        }
        if (iMax > 854) {
            this.G6 = 3;
        } else if (iMax > 640) {
            this.G6 = 2;
        } else {
            this.G6 = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H7(float f) {
        return I7(f, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H8(boolean z, final File file, File file2, C4278El2.a aVar, final int i, C10743c74 c10743c74, final boolean z2, final boolean z3, final boolean z4, final boolean z5) {
        final File fileA;
        AbstractC18106o57 abstractC18106o57I;
        boolean zExists = (z || file == null) ? z : file.exists();
        if (file2 != null || aVar == null) {
            fileA = aVar != null ? aVar.a() : null;
            fileA = file2;
        } else {
            fileA = aVar.a();
        }
        if (!zExists && fileA != null) {
            zExists = fileA.exists();
        }
        if (!zExists && fileA != null) {
            zExists = fileA.exists();
        }
        final boolean z6 = zExists;
        if (!z6 && i != 0 && c10743c74 != null && z2 && CX1.e(this.v).b(c10743c74.e) != 0 && (abstractC18106o57I = c10743c74.I()) != null) {
            C4278El2.H(this.v).a0(abstractC18106o57I, c10743c74, 0, 10);
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.Va5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.G8(i, file, fileA, z6, z2, z3, z4, z5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ O98 H9(View view, O98 o98) {
        int i = o98.f(O98.m.d()).d - o98.f(O98.m.g()).d;
        C19406qI3.a("PhotoViewer", "height: " + i, new Object[0]);
        ir.nasim.tgwidgets.editor.ui.O o = this.m6;
        if (o == null || this.a4 != 0) {
            return o98;
        }
        o.g(i);
        return new O98.b(o98).b(O98.m.d(), L93.e).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(long j) {
        PhotoViewerWebView photoViewerWebView = this.A;
        if (photoViewerWebView == null || !photoViewerWebView.H()) {
            FT7 ft7 = this.j2;
            if (ft7 != null) {
                ft7.I1(j);
            }
        } else {
            this.A.V(j);
        }
        Ob();
    }

    private void Hb(boolean z) {
        w0 w0Var;
        if (this.L1 == 1 || (w0Var = this.z) == null) {
            return;
        }
        this.z.setSystemUiVisibility(!z ? (w0Var.getPaddingLeft() > 0 || this.z.getPaddingRight() > 0) ? 5894 : 1796 : 1792);
    }

    private boolean I7(final float f, boolean z, Runnable runnable) {
        PhotoCropView photoCropView;
        if (this.r5 != null || (photoCropView = this.y1) == null) {
            return false;
        }
        photoCropView.c.L(true);
        this.f5 = 0.0f;
        this.k5 = 0.0f + f;
        if (z) {
            this.g5 = 0.0f;
            this.l5 = 1.0f;
        }
        this.p5 = System.currentTimeMillis();
        this.r5 = new AnimatorSet();
        if (this.L1 == 1) {
            this.j5 = 1.0f;
        } else {
            ImageReceiver imageReceiver = this.i4;
            if (imageReceiver != null) {
                int iO = imageReceiver.o();
                int iM = this.i4.m();
                if (Math.abs((((int) this.y1.c.getStateOrientation()) / 90) % 2) == 1) {
                    iM = iO;
                    iO = iM;
                }
                MediaController.i iVar = this.t4.c;
                if (iVar != null) {
                    iO = (int) (iO * iVar.e);
                    iM = (int) (iM * iVar.f);
                }
                float f2 = iO;
                float f3 = iM;
                float fMin = Math.min(a8(1) / f2, X7(1) / f3);
                this.j5 = (Math.abs((f / 90.0f) % 2.0f) == 1.0f ? Math.min(a8(1) / f3, X7(1) / f2) : fMin) / fMin;
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float rotation = this.y1.d.getRotation();
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Ha5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.V8(f, rotation, valueAnimator);
            }
        });
        this.r5.playTogether(ObjectAnimator.ofFloat(this, (Property<PhotoViewer, Float>) AbstractC21469h.d, 0.0f, 1.0f), valueAnimatorOfFloat);
        this.r5.setDuration(250L);
        this.r5.setInterpolator(InterpolatorC12631ew1.f);
        this.r5.addListener(new C(f, runnable));
        this.r5.start();
        return Math.abs(this.y1.c.getStateOrientation() + f) > 0.01f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I8() {
        rb(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(View view) {
        z7(true, false);
    }

    private void Ia(float f) {
        FT7 ft7 = this.j2;
        if (ft7 != null) {
            ft7.I1((long) (f * ft7.u1()));
        } else {
            this.A.V((long) (f * r0.getVideoDuration()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib(float f) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.e2;
        if (aspectRatioFrameLayout != null && aspectRatioFrameLayout.getVisibility() == 0 && this.j3) {
            f *= Math.min(Z7() / this.h2.getMeasuredWidth(), W7() / this.h2.getMeasuredHeight());
        }
        float fE = this.i4.E();
        float fB = this.i4.B();
        MediaController.i iVar = this.t4.c;
        if (iVar != null) {
            fE *= iVar.e;
            fB *= iVar.f;
        }
        int iZ7 = ((int) ((fE * f) - Z7())) / 2;
        int iW7 = ((int) ((fB * f) - W7())) / 2;
        if (iZ7 > 0) {
            this.E5 = -iZ7;
            this.F5 = iZ7;
        } else {
            this.F5 = 0.0f;
            this.E5 = 0.0f;
        }
        if (iW7 > 0) {
            this.G5 = -iW7;
            this.H5 = iW7;
        } else {
            this.H5 = 0.0f;
            this.G5 = 0.0f;
        }
        YZ2 yz2 = this.F1;
        if (yz2 != null) {
            yz2.e(f <= 1.1f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J8(ValueAnimator valueAnimator) {
        this.n5 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(Boolean bool) {
        w7(0, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ja() {
        if (this.b7 > 1048576000) {
            return this.G6 - 1;
        }
        SharedPreferences sharedPreferencesM = ir.nasim.tgwidgets.editor.messenger.C.m();
        int i = this.G6;
        while (i < 5) {
            int i2 = sharedPreferencesM.getInt(String.format(Locale.US, "compress_video_%d", Integer.valueOf(i)), -1);
            if (i2 >= 0) {
                return Math.min(i2, 2);
            }
            i++;
        }
        return Math.min(2, Math.round(CX1.e(this.v).f() / (100.0f / i)) - 1);
    }

    private void K7() {
        if (this.i4.k() != null || this.h6.isEmpty() || this.L1 == 1) {
            return;
        }
        String strC = this.i4.C();
        String str = this.d4;
        if (str == null || !str.equals(strC)) {
            this.c4 = 0;
            L7(strC, this.i4.n(), this.i4.Q());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K8(ValueAnimator valueAnimator) {
        this.n5 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(View view) {
        Activity activity = this.m;
        if (activity == null) {
            return;
        }
        this.A3 = false;
        this.z3 = 1;
        if (this.y3 == -10) {
            this.y3 = activity.getRequestedOrientation();
        }
        if (((WindowManager) this.m.getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
            this.m.setRequestedOrientation(8);
        } else {
            this.m.setRequestedOrientation(0);
        }
        vb(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka(boolean z, int i) throws InterruptedException, IOException {
        La(z, i, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:180:0x027d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Kb(boolean r22, int r23) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.Kb(boolean, int):void");
    }

    private void L7(final String str, final ImageReceiver.b bVar, final int i) {
        if (str == null || bVar == null || bVar.c == null) {
            return;
        }
        Utilities.e.i(new Runnable() { // from class: ir.nasim.Ka5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Y8(bVar, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L8(D0 d0) throws InterruptedException {
        this.U3 = null;
        this.z.setLayerType(0, null);
        this.S3 = 0;
        ia(d0);
        MediaController.Y().M0();
    }

    private void La(boolean z, int i, boolean z2, boolean z3, boolean z4) throws InterruptedException, IOException {
        int i2;
        if (this.K1.getTag() != null || this.b == null || this.Z1) {
            return;
        }
        if (this.L1 == 1) {
            i7();
        }
        ir.nasim.tgwidgets.editor.messenger.H hC8 = c8();
        if (!this.h6.isEmpty() && (i2 = this.p4) >= 0 && i2 < this.h6.size()) {
            Object obj = this.h6.get(this.p4);
            if (obj instanceof MediaController.l) {
                ((MediaController.l) obj).m = hC8;
            }
        }
        this.Z1 = true;
        if (z2) {
            this.b.replaceButtonPressed(this.p4, hC8);
        } else {
            this.b.sendButtonPressed(this.p4, hC8, z, i, z3);
        }
        if (this.u) {
            z7(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lb(final boolean z) {
        if (this.U0.isClickable() != z) {
            this.U0.setClickable(z);
            this.U0.setVisibility(0);
            this.U0.clearAnimation();
            this.U0.animate().alpha(z ? 1.0f : 0.0f).setInterpolator(InterpolatorC12631ew1.f).setDuration(150L).withEndAction(new Runnable() { // from class: ir.nasim.ib5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.X9(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M7(boolean z) throws IOException {
        SharedPreferences.Editor editorEdit = ir.nasim.tgwidgets.editor.messenger.C.m().edit();
        editorEdit.putInt(String.format("compress_video_%d", Integer.valueOf(this.G6)), this.F6);
        editorEdit.commit();
        Rb();
        Nb();
        if (z) {
            Ca(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M8(ValueAnimator valueAnimator) {
        this.n5 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(ValueAnimator valueAnimator) {
        this.M2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma(boolean z) {
        if (this.U1 != z) {
            this.U1 = z;
            this.H1.setLayerType(2, null);
            this.H1.getCurrentView().setLayerType(2, null);
            this.H1.getNextView().setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mb() {
        C0 c0 = this.b;
        if (c0 == null) {
            return;
        }
        int selectedCount = c0.getSelectedCount();
        this.Q0.a(selectedCount);
        if (selectedCount == 0) {
            Ab(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N7() {
        try {
            if (this.B.getParent() != null) {
                ((WindowManager) this.m.getSystemService("window")).removeView(this.B);
                ea();
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N8(D0 d0) throws InterruptedException {
        this.U3 = null;
        w0 w0Var = this.z;
        if (w0Var == null) {
            return;
        }
        w0Var.setLayerType(0, null);
        this.S3 = 0;
        ia(d0);
        this.z.setScaleX(1.0f);
        this.z.setScaleY(1.0f);
        MediaController.Y().M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(DialogInterface dialogInterface) {
        this.G1 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Na(boolean z, boolean z2) {
        ImageView imageView = this.f1;
        if (imageView == null) {
            return;
        }
        if (!z || imageView.getTag() == null) {
            if (z || this.f1.getTag() != null) {
                this.f1.setTag(z ? 1 : null);
                AnimatorSet animatorSet = this.l1;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.l1 = null;
                }
                if (!z2) {
                    this.f1.setAlpha(z ? 1.0f : 0.5f);
                    return;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.l1 = animatorSet2;
                ImageView imageView2 = this.f1;
                Property property = View.ALPHA;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, z ? 1.0f : 0.5f), ObjectAnimator.ofFloat(this.X0, (Property<ImageView, Float>) property, this.R6 ? 1.0f : 0.5f), ObjectAnimator.ofFloat(this.c1, (Property<ImageView, Float>) property, this.R6 ? 1.0f : 0.5f), ObjectAnimator.ofFloat(this.Y0, (Property<ImageView, Float>) property, this.R6 ? 1.0f : 0.5f));
                this.l1.setDuration(180L);
                this.l1.setInterpolator(m7);
                this.l1.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nb() {
        int i;
        if (this.o == null) {
            return;
        }
        if (this.G6 == 0) {
            this.s.g(null);
            return;
        }
        if (this.F6 < 2) {
            this.f1.setImageResource(AbstractC23598xB5.video_quality1);
        } else if (this.F6 == 2) {
            this.f1.setImageResource(AbstractC23598xB5.video_quality2);
        } else if (this.F6 == 3) {
            this.f1.setImageResource(AbstractC23598xB5.video_quality3);
        }
        this.K0.requestLayout();
        this.a7 = (long) Math.ceil((this.y6.getRightProgress() - this.y6.getLeftProgress()) * this.P6);
        this.V6 = this.y6.getLeftProgress();
        this.W6 = this.y6.getRightProgress();
        int i2 = this.I6;
        int i3 = (i2 == 90 || i2 == 270) ? this.M6 : this.L6;
        int i4 = this.I6;
        int i5 = (i4 == 90 || i4 == 270) ? this.L6 : this.M6;
        boolean zBa = ba();
        if (this.f) {
            if (this.L1 == 1) {
                long j = this.a7;
                i = j <= 2000 ? 2600000 : j <= 5000 ? 2200000 : 1560000;
            } else {
                i = 921600;
            }
            long j2 = (long) ((i / 8) * (this.a7 / 1000.0f));
            this.Z6 = j2 + ((j2 / 32768) * 16);
        } else {
            k7(zBa, this.L1 == 1);
        }
        float f = this.V6;
        if (f == 0.0f) {
            this.T6 = -1L;
        } else {
            this.T6 = ((long) (f * this.P6)) * 1000;
        }
        float f2 = this.W6;
        if (f2 == 1.0f) {
            this.U6 = -1L;
        } else {
            this.U6 = ((long) (f2 * this.P6)) * 1000;
        }
        this.k7 = String.format("%dx%d", Integer.valueOf(i3), Integer.valueOf(i5));
        this.o.h();
        if (this.H3 == null) {
            this.s.g(this.f ? FH3.E("SoundMuted", TD5.tgwidget_SoundMuted) : this.k7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void O7(android.graphics.Canvas r9, float r10, float r11, float r12, float r13) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.O7(android.graphics.Canvas, float, float, float, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O8(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(ValueAnimator valueAnimator) {
        this.y1.c.a.setRotationScaleTranslation(0.0f, AbstractC21455b.T0(this.e5, this.j5, this.m5), AbstractC21455b.T0(this.c5, this.h5, this.m5), AbstractC21455b.T0(this.d5, this.i5, this.m5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        VideoEditTextureView videoEditTextureView;
        if (this.M1 || this.L1 != 1) {
            return;
        }
        if (!this.n1 || ((videoEditTextureView = (VideoEditTextureView) this.h2) != null && videoEditTextureView.getVideoWidth() > 0 && videoEditTextureView.getVideoHeight() > 0)) {
            this.M1 = true;
            Bitmap bitmapL = this.i4.l();
            int iQ = this.i4.Q();
            if (bitmapL == null) {
                bitmapL = this.D.getBitmap();
                iQ = this.D.getOrientation();
            }
            Bitmap bitmap = bitmapL;
            int i = iQ;
            if (bitmap == null && this.h2 == null) {
                return;
            }
            this.y1.setBitmap(bitmap, i, false, false, this.e4, this.z1, this.n1 ? (VideoEditTextureView) this.h2 : null, this.t4.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ob() {
        Arrays.fill(this.Q2, 0);
        Arrays.fill(this.R2, 0);
        FT7 ft7 = this.j2;
        if (ft7 != null) {
            long jMax = Math.max(0L, ft7.s1());
            if (this.V5 && !this.W5) {
                jMax = 0;
            }
            long jMax2 = Math.max(0L, this.j2.u1());
            if (!this.i7 && this.y6.getVisibility() == 0) {
                jMax2 = (long) (jMax2 * (this.y6.getRightProgress() - this.y6.getLeftProgress()));
                jMax = (long) (jMax - (this.y6.getLeftProgress() * jMax2));
                if (jMax > jMax2) {
                    jMax = jMax2;
                }
            }
            long j = jMax / 1000;
            long j2 = jMax2 / 1000;
            int[] iArr = this.Q2;
            iArr[0] = (int) (j / 60);
            iArr[1] = (int) (j % 60);
            int[] iArr2 = this.R2;
            iArr2[0] = (int) (j2 / 60);
            iArr2[1] = (int) (j2 % 60);
        } else {
            PhotoViewerWebView photoViewerWebView = this.A;
            if (photoViewerWebView != null && photoViewerWebView.H()) {
                long jMax3 = (!this.V5 || this.W5) ? Math.max(0, this.A.getCurrentPosition()) : 0L;
                long jMax4 = Math.max(0, this.A.getVideoDuration());
                if (!this.i7 && this.y6.getVisibility() == 0) {
                    jMax4 = (long) (jMax4 * (this.y6.getRightProgress() - this.y6.getLeftProgress()));
                    jMax3 = (long) (jMax3 - (this.y6.getLeftProgress() * jMax4));
                    if (jMax3 > jMax4) {
                        jMax3 = jMax4;
                    }
                }
                long j3 = jMax3 / 1000;
                long j4 = jMax4 / 1000;
                int[] iArr3 = this.Q2;
                iArr3[0] = (int) (j3 / 60);
                iArr3[1] = (int) (j3 % 60);
                int[] iArr4 = this.R2;
                iArr4[0] = (int) (j4 / 60);
                iArr4[1] = (int) (j4 % 60);
            }
        }
        int i = this.Q2[0];
        String str = i >= 60 ? String.format(Locale.ROOT, "%02d:%02d:%02d", Integer.valueOf(i / 60), Integer.valueOf(this.Q2[0] % 60), Integer.valueOf(this.Q2[1])) : String.format(Locale.ROOT, "%02d:%02d", Integer.valueOf(i), Integer.valueOf(this.Q2[1]));
        int i2 = this.R2[0];
        String str2 = i2 >= 60 ? String.format(Locale.ROOT, "%02d:%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(this.R2[0] % 60), Integer.valueOf(this.R2[1])) : String.format(Locale.ROOT, "%02d:%02d", Integer.valueOf(i2), Integer.valueOf(this.R2[1]));
        this.S2.i(String.format(Locale.ROOT, "%s / %s", str, str2));
        if (Objects.equals(this.N2, str2)) {
            return;
        }
        this.N2 = str2;
        this.M2.requestLayout();
    }

    private boolean P7() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P8() {
        this.e4.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(ValueAnimator valueAnimator) {
        this.F1.setOffsetTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f, 0, false);
    }

    private void Pa(C10743c74 c10743c74, CharSequence charSequence, boolean z) {
        int i;
        boolean z2;
        CharSequence charSequenceS;
        CharSequence charSequenceD = AnimatedEmojiSpan.d(charSequence);
        boolean z3 = true;
        if (!this.O1) {
            if (this.I1 == null) {
                this.I1 = new r0(this.z.getContext());
                FrameLayout frameLayout = new FrameLayout(this.z.getContext());
                this.J1 = frameLayout;
                frameLayout.setClipChildren(false);
                this.I1.addView(this.J1, new ViewGroup.LayoutParams(-1, -2));
                this.z.addView(this.I1, AbstractC13840gu3.d(-1, -1, 80));
            }
            if (this.H1.getParent() != this.J1) {
                this.R0.removeView(this.H1);
                this.H1.setMeasureAllChildren(true);
                this.J1.addView(this.H1, -1, -2);
                this.W2.bringToFront();
            }
        } else if (this.H1.getParent() != this.R0) {
            FrameLayout frameLayout2 = this.J1;
            if (frameLayout2 != null) {
                frameLayout2.removeView(this.H1);
            }
            this.H1.setMeasureAllChildren(false);
            this.R0.addView(this.H1, AbstractC13840gu3.c(-1, -2.0f, 83, 0.0f, 0.0f, 76.0f, 48.0f));
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequenceD);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.H1.getCurrentView().getText());
        s0 s0Var = this.H1;
        TextView nextView = z ? s0Var.getNextView() : s0Var.getCurrentView();
        if (!this.n1) {
            int maxLines = nextView.getMaxLines();
            if (maxLines == 1) {
                this.H1.getCurrentView().setSingleLine(false);
                this.H1.getNextView().setSingleLine(false);
            }
            if (this.O1) {
                Point point = AbstractC21455b.h;
                i = point.x > point.y ? 5 : 10;
            } else {
                i = Integer.MAX_VALUE;
            }
            if (maxLines != i) {
                this.H1.getCurrentView().setMaxLines(i);
                this.H1.getNextView().setMaxLines(i);
                this.H1.getCurrentView().setEllipsize(null);
                this.H1.getNextView().setEllipsize(null);
            }
        } else if (nextView.getMaxLines() != 1) {
            this.H1.getCurrentView().setMaxLines(1);
            this.H1.getNextView().setMaxLines(1);
            this.H1.getCurrentView().setSingleLine(true);
            this.H1.getNextView().setSingleLine(true);
            TextView currentView = this.H1.getCurrentView();
            TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
            currentView.setEllipsize(truncateAt);
            this.H1.getNextView().setEllipsize(truncateAt);
        }
        nextView.setScrollX(0);
        boolean z4 = this.O1;
        this.S1 = !z4 && z && zIsEmpty;
        if (!z4) {
            this.I1.L0 = false;
        }
        if (z) {
            TransitionManager.endTransitions(this.m6.d());
            if (this.O1) {
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.setOrdering(0);
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addTransition(new Fade(2));
                transitionSet.addTransition(new Fade(1));
                transitionSet.setDuration(200L);
                TransitionManager.beginDelayedTransition(this.m6.d(), transitionSet);
            } else {
                TransitionSet duration = new TransitionSet().addTransition(new Z(2, zIsEmpty2, zIsEmpty)).addTransition(new Y(1, zIsEmpty2, zIsEmpty)).setDuration(200L);
                if (!zIsEmpty2) {
                    this.I1.L0 = true;
                    duration.addTransition(new C21472a0());
                }
                if (zIsEmpty2 && !zIsEmpty) {
                    duration.addTarget((View) this.H1);
                }
                TransitionManager.beginDelayedTransition(this.I1, duration);
            }
            z2 = true;
        } else {
            this.H1.getCurrentView().setText((CharSequence) null);
            r0 r0Var = this.I1;
            if (r0Var != null) {
                r0Var.scrollTo(0, 0);
            }
            z2 = false;
        }
        if (zIsEmpty) {
            if (this.O1) {
                this.H1.setText(FH3.E("AddCaption", TD5.tgwidget_AddCaption), z);
                this.H1.getCurrentView().setTextColor(-1291845633);
                this.H1.setTag("empty");
                this.H1.setVisibility(0);
                return;
            }
            this.H1.setText(null, z);
            this.H1.getCurrentView().setTextColor(-1);
            s0 s0Var2 = this.H1;
            if (z2 && !zIsEmpty2) {
                z3 = false;
            }
            s0Var2.b(4, z3);
            this.H1.setTag(null);
            return;
        }
        if (c10743c74 == null || c10743c74.e.n.isEmpty()) {
            charSequenceS = R62.S(new SpannableStringBuilder(charSequenceD), nextView.getPaint().getFontMetricsInt(), AbstractC21455b.F(20.0f), false);
        } else {
            SpannableString spannableString = new SpannableString(charSequenceD);
            c10743c74.d(spannableString, true, false);
            if (c10743c74.c1()) {
                C10743c74.e(c10743c74.O0(), spannableString, false, 3, (int) c10743c74.M(), false);
            }
            charSequenceS = R62.S(spannableString, nextView.getPaint().getFontMetricsInt(), AbstractC21455b.F(20.0f), false);
        }
        this.H1.setTag(charSequenceS);
        try {
            this.H1.setText(charSequenceS, z);
            r0 r0Var2 = this.I1;
            if (r0Var2 != null) {
                r0Var2.l0();
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        nextView.setScrollY(0);
        nextView.setTextColor(-1);
        if (!this.p || (this.n1 && this.R0.getVisibility() != 0)) {
            z3 = false;
        }
        this.H1.setVisibility(z3 ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pb() {
        int iH = (this.U2.h() + AbstractC21455b.F(2.0f)) - (this.W2.getMeasuredWidth() / 2);
        int iF = AbstractC21455b.F(10.0f);
        int measuredWidth = (this.M2.getMeasuredWidth() - AbstractC21455b.F(10.0f)) - (this.W2.getMeasuredWidth() / 2);
        if (iH < iF) {
            iH = iF;
        } else if (iH >= measuredWidth) {
            iH = measuredWidth;
        }
        this.W2.setTranslationX(iH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q8() throws InterruptedException, FileNotFoundException {
        this.j6 = null;
        i7();
        rb(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(ValueAnimator valueAnimator) {
        this.F1.setOffsetTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void Qa(boolean z) {
        this.u5 = z;
        this.t5.n(z ? this : null);
    }

    private int[] R7(int i, int i2) {
        int[] iArr = {i, i2};
        MediaCodec mediaCodecCreateEncoderByType = null;
        try {
            mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
            MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecCreateEncoderByType.getCodecInfo().getCapabilitiesForType("video/avc").getVideoCapabilities();
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
            iArr[0] = Math.max(((Integer) supportedWidths.getLower()).intValue(), Math.round(i / 16.0f) * 16);
            iArr[1] = Math.max(((Integer) supportedHeights.getLower()).intValue(), Math.round(i2 / 16.0f) * 16);
        } catch (Exception unused) {
            if (mediaCodecCreateEncoderByType != null) {
            }
        } catch (Throwable th) {
            if (mediaCodecCreateEncoderByType != null) {
                try {
                    mediaCodecCreateEncoderByType.release();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            mediaCodecCreateEncoderByType.release();
        } catch (Exception unused3) {
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R8(View view) {
        y7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9(View view) throws InterruptedException, FileNotFoundException {
        i7();
        rb(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ra(int i) throws InterruptedException, Resources.NotFoundException {
        Sa(i, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rb() throws IOException {
        int iW;
        if (this.G6 <= 0) {
            return;
        }
        if (this.F6 >= this.G6) {
            this.F6 = this.G6 - 1;
        }
        if (this.L1 == 1) {
            float fMax = Math.max(800.0f / this.J6, 800.0f / this.K6);
            this.L6 = Math.round((this.J6 * fMax) / 2.0f) * 2;
            this.M6 = Math.round((this.K6 * fMax) / 2.0f) * 2;
        } else {
            RD6 rd6L7 = l7();
            this.L6 = rd6L7.b();
            this.M6 = rd6L7.a();
        }
        if (this.N6 != 0) {
            if (this.L1 == 1) {
                this.N6 = 1560000;
                iW = this.N6;
            } else if (this.L6 == this.J6 && this.M6 == this.K6) {
                this.N6 = this.O6;
                iW = MediaController.W(this.L6, this.M6, this.N6, false);
            } else {
                this.N6 = MediaController.y0(this.K6, this.J6, this.O6, this.M6, this.L6);
                iW = MediaController.W(this.L6, this.M6, this.N6, false);
            }
            this.Y6 = (long) (((iW / 8) * this.P6) / 1000.0f);
        }
    }

    private int S7() {
        int i = this.a4;
        if (i == 1 || (i == 0 && this.L1 == 1)) {
            return AbstractC21455b.F(16.0f);
        }
        if (i == 0 || i == 3) {
            return 0;
        }
        return AbstractC21455b.F(14.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S8() {
        if (this.Y2) {
            nb(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(DialogInterface dialogInterface, int i) {
        rb(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sa(int r32, boolean r33, boolean r34) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.Sa(int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sb() {
        return false;
    }

    private int T7() {
        int i = this.a4;
        if (i == 1 || (i == 0 && this.L1 == 1)) {
            return AbstractC21455b.F(16.0f) + (A8() ? AbstractC21455b.d : 0);
        }
        if (i == 3) {
            return AbstractC21455b.F(8.0f) + (A8() ? AbstractC21455b.d : 0) + this.F1.getAdditionalTop();
        }
        if (i != 0) {
            return AbstractC21455b.F(14.0f) + (A8() ? AbstractC21455b.d : 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T8(View view) {
        Activity activity = this.m;
        if (activity == null) {
            return;
        }
        this.A3 = false;
        this.z3 = 2;
        if (this.y3 == -10) {
            this.y3 = activity.getRequestedOrientation();
        }
        this.m.setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(View view) {
        if (!this.E1.n0()) {
            rb(0);
            return;
        }
        Activity activity = this.m;
        if (activity == null) {
            return;
        }
        AlertDialog.i iVar = new AlertDialog.i(activity, this.b2);
        iVar.e(FH3.E("PhotoEditorDiscardAlert", TD5.tgwidget_PhotoEditorDiscardAlert));
        iVar.j(FH3.E("DiscardChanges", TD5.tgwidget_DiscardChanges));
        iVar.i(FH3.E("OK", TD5.tgwidget_OK), new DialogInterface.OnClickListener() { // from class: ir.nasim.Xa5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.S9(dialogInterface, i);
            }
        });
        iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), null);
        jb(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() throws InterruptedException, Resources.NotFoundException {
        if (this.S3 == 0) {
            Ua(this.i4, this.p4, null);
            Va(this.p4, this.e4);
            Ua(this.j4, this.p4 + 1, this.B1);
            Va(this.p4 + 1, this.g4);
            Ua(this.h4, this.p4 - 1, this.A1);
            Va(this.p4 - 1, this.f4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if ((r4 & 4) == 0) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032 A[EDGE_INSN: B:20:0x0032->B:16:0x0032 BREAK  A[LOOP:0: B:5:0x000c->B:17:0x0034], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int U7(boolean r7) {
        /*
            r6 = this;
            ir.nasim.tgwidgets.editor.ui.PhotoViewer$t0 r0 = r6.t4
            java.util.ArrayList r0 = r0.e
            r1 = 0
            if (r0 == 0) goto L37
            int r0 = r0.size()
            r2 = r1
        Lc:
            if (r1 >= r0) goto L32
            ir.nasim.tgwidgets.editor.ui.PhotoViewer$t0 r3 = r6.t4
            java.util.ArrayList r3 = r3.e
            java.lang.Object r3 = r3.get(r1)
            ir.nasim.tgwidgets.editor.messenger.H$b r3 = (ir.nasim.tgwidgets.editor.messenger.H.b) r3
            byte r4 = r3.a
            if (r4 != 0) goto L26
            byte r4 = r3.b
            r5 = r4 & 1
            if (r5 != 0) goto L2e
            r4 = r4 & 4
            if (r4 != 0) goto L2e
        L26:
            java.util.ArrayList r3 = r3.i
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L34
        L2e:
            int r2 = r2 + 1
            if (r7 == 0) goto L34
        L32:
            r1 = r2
            goto L37
        L34:
            int r1 = r1 + 1
            goto Lc
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.U7(boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U8(MediaController.n nVar, ir.nasim.tgwidgets.editor.ui.Components.k kVar) {
        kVar.n0(ir.nasim.tgwidgets.editor.ui.Components.l.k(nVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(ValueAnimator valueAnimator) {
        this.F1.setOffsetTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f, 0, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Ua(ir.nasim.tgwidgets.editor.messenger.ImageReceiver r30, int r31, ir.nasim.C3417Au1 r32) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1075
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.Ua(ir.nasim.tgwidgets.editor.messenger.ImageReceiver, int, ir.nasim.Au1):void");
    }

    private ClippingImageView[] V7(D0 d0) {
        int i = (AbstractC21455b.F0() || d0 == null || d0.animatingImageView == null) ? 0 : 1;
        ClippingImageView[] clippingImageViewArr = new ClippingImageView[i + 1];
        clippingImageViewArr[0] = this.D;
        if (i != 0) {
            ClippingImageView clippingImageView = d0.animatingImageView;
            clippingImageViewArr[1] = clippingImageView;
            clippingImageView.setAdditionalTranslationY(d0.animatingImageViewYOffset);
        }
        return clippingImageViewArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V8(float f, float f2, ValueAnimator valueAnimator) {
        CropAreaView cropAreaView = this.y1.c.a;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * f;
        float f3 = this.e5;
        cropAreaView.setRotationScaleTranslation(fFloatValue, f3 + ((this.j5 - f3) * this.m5), 0.0f, 0.0f);
        this.y1.d.setRotation(AbstractC21455b.T0(f2, 0.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9(ValueAnimator valueAnimator) {
        this.F1.setOffsetTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void Va(int i, PaintingOverlay paintingOverlay) {
        String str;
        boolean z;
        ArrayList<H.b> arrayList;
        if (paintingOverlay == null) {
            return;
        }
        paintingOverlay.e();
        paintingOverlay.setVisibility(8);
        if (this.h6.isEmpty() || i < 0 || i >= this.h6.size()) {
            return;
        }
        Object obj = this.h6.get(i);
        if (obj instanceof MediaController.m) {
            MediaController.m mVar = (MediaController.m) obj;
            z = mVar.D;
            str = mVar.e;
            arrayList = mVar.j;
        } else {
            str = null;
            z = false;
            arrayList = null;
        }
        paintingOverlay.setVisibility(0);
        paintingOverlay.setData(str, arrayList, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W7() {
        return X7(this.a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W8(String str, boolean z) {
        if (str.equals(this.i4.C())) {
            this.c4 = z ? 1 : 0;
            this.d4 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W9(ValueAnimator valueAnimator) {
        this.V0[0].p(1, ((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X7(int i) {
        return Y7(false, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X8(ImageReceiver.b bVar, String str) throws InterruptedException {
        bVar.d();
        if (str.equals(this.i4.C())) {
            this.c4 = 2;
            this.d4 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X9(boolean z) {
        if (z) {
            return;
        }
        this.U0.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x09e6  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v7, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r1v139 */
    /* JADX WARN: Type inference failed for: r1v140, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r1v32, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v33, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v34, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v36, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v37, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v40, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v46, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v49, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r2v37, types: [ir.nasim.tgwidgets.editor.ui.PhotoViewer$B0] */
    /* JADX WARN: Type inference failed for: r2v38, types: [ir.nasim.tgwidgets.editor.ui.PhotoViewer$B0] */
    /* JADX WARN: Type inference failed for: r2v39, types: [ir.nasim.tgwidgets.editor.ui.PhotoViewer$B0] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.graphics.ColorFilter] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v79, types: [ir.nasim.tgwidgets.editor.ui.PhotoViewer$z0] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Xa(int r36, boolean r37, boolean r38) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 2590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.Xa(int, boolean, boolean):void");
    }

    private int Y7(boolean z, int i) {
        int measuredHeight;
        int iF;
        if (z || this.g) {
            measuredHeight = this.z.getMeasuredHeight();
        } else {
            measuredHeight = AbstractC21455b.h.y;
            if (i == 0 && this.L1 != 1 && A8()) {
                measuredHeight += AbstractC21455b.d;
            }
        }
        if ((i == 0 && this.L1 == 1) || i == 1) {
            iF = AbstractC21455b.F(144.0f);
        } else if (i == 2) {
            iF = AbstractC21455b.F(214.0f);
        } else {
            if (i != 3) {
                return measuredHeight;
            }
            iF = AbstractC21455b.F(48.0f) + this.F1.getAdditionalBottom() + ActionBar.getCurrentActionBarHeight() + this.F1.getAdditionalTop();
        }
        return measuredHeight - iF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y8(final ImageReceiver.b bVar, int i, final String str) {
        C19026pf2 c19026pf2A = null;
        try {
            try {
                final boolean z = false;
                c19026pf2A = new C19026pf2.a(AbstractC14047hG.a).c(0).b(0).d(false).a();
                if (c19026pf2A.c()) {
                    SparseArray sparseArrayB = c19026pf2A.b(new C7501Rz2.a().b(bVar.c).c(i).a());
                    if (sparseArrayB != null && sparseArrayB.size() != 0) {
                        z = true;
                    }
                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.Ya5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.W8(str, z);
                        }
                    });
                } else {
                    if (AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.b("face detection is not operational");
                    }
                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.Za5
                        @Override // java.lang.Runnable
                        public final void run() throws InterruptedException {
                            this.a.X8(bVar, str);
                        }
                    });
                }
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                if (0 == 0) {
                    return;
                }
            }
            c19026pf2A.a();
        } catch (Throwable th) {
            if (0 != 0) {
                c19026pf2A.a();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9() {
        WindowManager.LayoutParams layoutParams = this.y;
        layoutParams.flags = -2147417856;
        layoutParams.softInputMode = (this.v1 ? 32 : 16) | 256;
        try {
            ((WindowManager) this.m.getSystemService("window")).updateViewLayout(this.B, this.y);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        this.B.setFocusable(true);
        this.z.setFocusable(true);
    }

    private void Ya(View view, boolean z, boolean z2) {
        Za(view, z, z2, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z7() {
        return a8(this.a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z8() {
        zb(true);
    }

    private void Z9() {
        WindowManager.LayoutParams layoutParams = this.y;
        layoutParams.flags = -2147417856;
        layoutParams.softInputMode = (this.v1 ? 32 : 16) | 256;
        try {
            ((WindowManager) this.m.getSystemService("window")).updateViewLayout(this.B, this.y);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        this.B.setFocusable(false);
        this.z.setFocusable(false);
    }

    private void Za(final View view, final boolean z, boolean z2, float f) {
        Boolean bool = (Boolean) this.M0.get(view);
        if (bool == null || bool.booleanValue() != z) {
            this.M0.put(view, Boolean.valueOf(z));
            view.animate().cancel();
            float f2 = (z ? 1.0f : 0.0f) * f;
            if (!z2 || bool == null) {
                view.setVisibility(z ? 0 : 8);
                view.setAlpha(f2);
                Db();
            } else {
                if (z) {
                    view.setVisibility(0);
                }
                view.animate().alpha(f2).setDuration(100L).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Ea5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.a.i9(valueAnimator);
                    }
                }).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: ir.nasim.Fa5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j9(z, view);
                    }
                }).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a8(int i) {
        int iF;
        int width = this.z.getWidth();
        if (i == 1 || (i == 0 && this.L1 == 1)) {
            iF = AbstractC21455b.F(32.0f);
        } else {
            if (i == 0 || i == 3) {
                return width;
            }
            iF = AbstractC21455b.F(28.0f);
        }
        return width - iF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a9() {
        if (this.c && this.S3 == 0) {
            Hb(this.p);
        }
    }

    private void aa(String str, String str2, Bitmap bitmap, Bitmap bitmap2, float f, boolean z) {
        boolean z2;
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeFile(str2);
                z2 = true;
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
                return;
            }
        } else {
            z2 = false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = width;
        if (f2 > f || height > f) {
            float fMax = Math.max(width, height) / f;
            height = (int) (height / fMax);
            width = (int) (f2 / fMax);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, width, height);
        if (z) {
            canvas.drawBitmap(bitmap2, (Rect) null, rect, this.V1);
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.V1);
        } else {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.V1);
            canvas.drawBitmap(bitmap2, (Rect) null, rect, this.V1);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, f == 512.0f ? 83 : 87, fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        if (z2) {
            bitmap.recycle();
        }
        bitmapCreateBitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(boolean z, boolean z2) {
        if (this.D0.getVisibility() != 0) {
            this.B0.a(null, z);
            return;
        }
        this.B0.a(Math.abs(this.p1 - 1.0f) >= 0.001f ? Float.valueOf(this.p1) : null, z);
        if (z2) {
            if (Math.abs(this.p1 - 0.2f) < 0.05f) {
                this.D0.setSubtext(FH3.E("VideoSpeedVerySlow", TD5.tgwidget_VideoSpeedVerySlow));
            } else if (Math.abs(this.p1 - 0.5f) < 0.05f) {
                this.D0.setSubtext(FH3.E("VideoSpeedSlow", TD5.tgwidget_VideoSpeedSlow));
            } else if (Math.abs(this.p1 - 1.0f) < 0.05f) {
                this.D0.setSubtext(FH3.E("VideoSpeedNormal", TD5.tgwidget_VideoSpeedNormal));
            } else if (Math.abs(this.p1 - 1.5f) < 0.05f) {
                this.D0.setSubtext(FH3.E("VideoSpeedFast", TD5.tgwidget_VideoSpeedFast));
            } else if (Math.abs(this.p1 - 2.0f) < 0.05f) {
                this.D0.setSubtext(FH3.E("VideoSpeedVeryFast", TD5.tgwidget_VideoSpeedVeryFast));
            } else {
                this.D0.setSubtext(FH3.r("VideoSpeedCustom", TD5.tgwidget_VideoSpeedCustom, ir.nasim.tgwidgets.editor.ui.Components.F.a(this.p1) + "x"));
            }
        }
        this.L0.o(this.p1, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float b8(boolean z) {
        ImageReceiver imageReceiver = this.i4;
        int iM = z ? imageReceiver.m() : imageReceiver.o();
        int iO = z ? this.i4.o() : this.i4.m();
        float fMin = Math.min(this.y1.getMeasuredWidth(), (this.y1.getMeasuredHeight() - AbstractC21455b.F(64.0f)) - (A8() ? AbstractC21455b.d : 0)) - (AbstractC21455b.F(16.0f) * 2);
        return Math.max(fMin / iM, fMin / iO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b9() throws InterruptedException, Resources.NotFoundException {
        sb(1, false);
    }

    private boolean ba() {
        t0 t0Var = this.t4;
        ArrayList arrayList = null;
        if (t0Var.b != null) {
            ArrayList arrayList2 = t0Var.f;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                arrayList = this.t4.f;
            }
        } else {
            ArrayList arrayList3 = t0Var.e;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                arrayList = this.t4.e;
            }
        }
        t0 t0Var2 = this.t4;
        String str = t0Var2.b;
        if (str == null) {
            str = t0Var2.a;
        }
        if (!this.S6 || this.V6 != 0.0f || this.I6 != 0 || this.L6 != this.J6 || this.M6 != this.K6) {
            return true;
        }
        t0 t0Var3 = this.t4;
        return (t0Var3.c == null && arrayList == null && str == null && t0Var3.d == null && this.L1 != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ir.nasim.tgwidgets.editor.messenger.H c8() throws IOException {
        int i;
        long j;
        ArrayList arrayList = null;
        if (!this.n1 && t8() && this.i4.o() > 0) {
            float f = this.L1 == 1 ? 800.0f : 854.0f;
            ir.nasim.tgwidgets.editor.messenger.H h = new ir.nasim.tgwidgets.editor.messenger.H();
            h.a = 0L;
            h.d = 0L;
            h.b = Math.min(3000L, this.t4.g);
            while (true) {
                j = h.b;
                if (j <= 0 || j >= 1000) {
                    break;
                }
                h.b = j * 2;
            }
            h.e = j;
            h.f = this.F6;
            h.g = 0;
            h.o = this.z4;
            long j2 = h.b;
            h.p = (int) ((j2 / 1000.0f) * 115200.0f);
            h.q = j2;
            h.n = 30;
            h.t = j2;
            t0 t0Var = this.t4;
            h.x = t0Var.d;
            String str = t0Var.b;
            if (str != null) {
                h.y = str;
                ArrayList arrayList2 = t0Var.f;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    arrayList = this.t4.f;
                }
                h.z = arrayList;
            } else {
                h.y = t0Var.a;
                h.z = t0Var.e;
            }
            h.B = true;
            int iO = this.i4.o();
            int iM = this.i4.m();
            MediaController.i iVar = this.t4.c;
            if (iVar != null) {
                int i2 = iVar.i;
                if (i2 == 90 || i2 == 270) {
                    iM = iO;
                    iO = iM;
                }
                iO = (int) (iO * iVar.e);
                iM = (int) (iM * iVar.f);
            }
            if (this.L1 == 1) {
                iO = iM;
            }
            float f2 = iO;
            float f3 = iM;
            float fMax = Math.max(f2 / f, f3 / f);
            if (fMax < 1.0f) {
                fMax = 1.0f;
            }
            int iMax = (int) (f2 / fMax);
            int iMax2 = (int) (f3 / fMax);
            if (iMax % 16 != 0) {
                iMax = Math.max(1, Math.round(iMax / 16.0f)) * 16;
            }
            if (iMax2 % 16 != 0) {
                iMax2 = Math.max(1, Math.round(iMax2 / 16.0f)) * 16;
            }
            h.k = iMax;
            h.h = iMax;
            h.l = iMax2;
            h.i = iMax2;
            h.m = -1;
            h.s = true;
            h.c = 0L;
            return h;
        }
        if (!this.n1 || this.s4 == null || this.G6 == 0) {
            return null;
        }
        ir.nasim.tgwidgets.editor.messenger.H h2 = new ir.nasim.tgwidgets.editor.messenger.H();
        h2.a = this.T6;
        h2.b = this.U6;
        h2.d = this.V6;
        h2.e = this.W6;
        h2.f = this.F6;
        h2.g = this.I6;
        h2.h = this.J6;
        h2.i = this.K6;
        h2.m = this.N6;
        h2.o = this.y4;
        long j3 = this.Z6;
        if (j3 == 0) {
            j3 = 1;
        }
        h2.p = j3;
        h2.q = this.a7;
        h2.n = this.Q6;
        h2.t = (long) (this.P6 * 1000.0f);
        t0 t0Var2 = this.t4;
        h2.x = t0Var2.d;
        String str2 = t0Var2.b;
        if (str2 != null) {
            h2.y = str2;
            ArrayList arrayList3 = t0Var2.f;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                arrayList = this.t4.f;
            }
            h2.z = arrayList;
        } else {
            h2.y = t0Var2.a;
            ArrayList arrayList4 = t0Var2.e;
            if (arrayList4 != null && !arrayList4.isEmpty()) {
                arrayList = this.t4.e;
            }
            h2.z = arrayList;
        }
        if (this.L1 == 1 || this.f || !(this.f1.getTag() == null || (h2.k == this.J6 && h2.l == this.K6))) {
            if (this.f || this.L1 == 1) {
                this.F6 = 1;
                Rb();
            }
            h2.k = this.L6;
            h2.l = this.M6;
            if (!this.f && this.L1 != 1) {
                i = this.N6;
            }
            h2.m = i;
        } else {
            h2.k = this.J6;
            h2.l = this.K6;
            h2.m = this.f ? -1 : this.O6;
        }
        MediaController.i iVar2 = this.t4.c;
        h2.A = iVar2;
        if (iVar2 != null) {
            h2.g += iVar2.i;
            while (true) {
                i = h2.g;
                if (i < 360) {
                    break;
                }
                h2.g = i - 360;
            }
            if (i == 90 || i == 270) {
                MediaController.i iVar3 = h2.A;
                iVar3.g = (int) (h2.k * iVar3.f);
                iVar3.h = (int) (h2.l * iVar3.e);
            } else {
                MediaController.i iVar4 = h2.A;
                iVar4.g = (int) (h2.k * iVar4.e);
                iVar4.h = (int) (h2.l * iVar4.f);
            }
            if (this.L1 == 1) {
                MediaController.i iVar5 = h2.A;
                if (iVar5.g > 800) {
                    iVar5.g = 800;
                }
                if (iVar5.h > 800) {
                    iVar5.h = 800;
                }
                int iMin = Math.min(iVar5.g, iVar5.h);
                iVar5.h = iMin;
                iVar5.g = iMin;
            }
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.a("original transformed w = " + h2.A.g + " h = " + h2.A.h + " r = " + h2.g);
            }
            MediaController.i iVar6 = h2.A;
            int[] iArrR7 = R7(iVar6.g, iVar6.h);
            MediaController.i iVar7 = h2.A;
            iVar7.g = iArrR7[0];
            iVar7.h = iArrR7[1];
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.a("fixed transformed w = " + h2.A.g + " h = " + h2.A.h);
            }
        }
        if (this.L1 == 1) {
            h2.c = this.c7;
            h2.j = this.O6;
        }
        h2.s = this.f || this.L1 == 1;
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c9() throws InterruptedException, Resources.NotFoundException {
        sb(-1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012c A[PHI: r1
      0x012c: PHI (r1v6 java.io.File) = (r1v5 java.io.File), (r1v13 java.io.File), (r1v16 java.io.File) binds: [B:47:0x0152, B:16:0x0031, B:18:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ca(boolean r10) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.ca(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d7(int i) {
        e7(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long d8() {
        PhotoViewerWebView photoViewerWebView = this.A;
        if (photoViewerWebView != null && photoViewerWebView.H()) {
            return this.A.getCurrentPosition();
        }
        FT7 ft7 = this.j2;
        if (ft7 == null) {
            return 0L;
        }
        return ft7.s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void d9(android.text.style.URLSpan r2, android.widget.TextView r3, int r4, android.content.DialogInterface r5, int r6) {
        /*
            r1 = this;
            if (r6 != 0) goto L7
            r1.fa(r2, r3)
            goto Le9
        L7:
            r3 = 1
            if (r6 != r3) goto Le9
            java.lang.String r5 = r2.getURL()
            java.lang.String r6 = "mailto:"
            boolean r6 = r5.startsWith(r6)
            r0 = 0
            if (r6 == 0) goto L1f
            r2 = 7
            java.lang.String r5 = r5.substring(r2)
        L1c:
            r3 = r0
            goto L9a
        L1f:
            java.lang.String r6 = "tel:"
            boolean r6 = r5.startsWith(r6)
            if (r6 == 0) goto L2e
            r2 = 4
            java.lang.String r5 = r5.substring(r2)
            goto L9a
        L2e:
            if (r4 < 0) goto L1c
            ir.nasim.c74 r3 = r1.r4
            boolean r4 = r3.c1()
            if (r4 != 0) goto L58
            ir.nasim.c74 r4 = r1.r4
            boolean r4 = r4.R0()
            if (r4 != 0) goto L58
            ir.nasim.c74 r4 = r1.r4
            boolean r4 = r4.i1()
            if (r4 != 0) goto L58
            ir.nasim.c74 r4 = r1.r4
            boolean r4 = r4.G0()
            if (r4 == 0) goto L51
            goto L58
        L51:
            ir.nasim.c74 r4 = r1.r4
            ir.nasim.c74 r4 = r4.l
            if (r4 == 0) goto L58
            r3 = r4
        L58:
            r3.F()
            r3.T()
            ir.nasim.L57 r4 = r3.e
            ir.nasim.P57 r4 = r4.A
            if (r4 == 0) goto L7f
            ir.nasim.Z57 r6 = r4.i
            if (r6 == 0) goto L72
            ir.nasim.C10743c74.a0(r6)
            ir.nasim.L57 r3 = r3.e
            ir.nasim.P57 r3 = r3.A
            int r3 = r3.j
            goto L7f
        L72:
            ir.nasim.Z57 r4 = r4.d
            if (r4 == 0) goto L7f
            ir.nasim.C10743c74.a0(r4)
            ir.nasim.L57 r3 = r3.e
            ir.nasim.P57 r3 = r3.A
            int r3 = r3.g
        L7f:
            android.content.Context r3 = r1.n
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "onLinkLongPress: = "
            r4.append(r6)
            java.lang.String r2 = r2.getURL()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            ir.nasim.U00.f(r3, r2)
            goto L1c
        L9a:
            ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.p(r5)
            if (r3 == 0) goto La8
            java.lang.String r2 = "PhoneCopied"
            int r3 = ir.nasim.TD5.tgwidget_PhoneCopied
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
            goto Ld2
        La8:
            java.lang.String r2 = "#"
            boolean r2 = r5.startsWith(r2)
            if (r2 == 0) goto Lb9
            java.lang.String r2 = "HashtagCopied"
            int r3 = ir.nasim.TD5.tgwidget_HashtagCopied
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
            goto Ld2
        Lb9:
            java.lang.String r2 = "@"
            boolean r2 = r5.startsWith(r2)
            if (r2 == 0) goto Lca
            java.lang.String r2 = "UsernameCopied"
            int r3 = ir.nasim.TD5.tgwidget_UsernameCopied
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
            goto Ld2
        Lca:
            java.lang.String r2 = "LinkCopied"
            int r3 = ir.nasim.TD5.tgwidget_LinkCopied
            java.lang.String r2 = ir.nasim.FH3.E(r2, r3)
        Ld2:
            boolean r3 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.A1()
            if (r3 == 0) goto Le9
            ir.nasim.tgwidgets.editor.ui.PhotoViewer$w0 r3 = r1.z
            ir.nasim.tgwidgets.editor.ui.ActionBar.m$h r4 = r1.b2
            ir.nasim.tgwidgets.editor.ui.Components.i r3 = ir.nasim.tgwidgets.editor.ui.Components.C21470i.h(r3, r4)
            int r4 = ir.nasim.AbstractC19363qD5.voip_invite
            ir.nasim.tgwidgets.editor.ui.Components.Bulletin r2 = r3.f(r4, r2)
            r2.m()
        Le9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.d9(android.text.style.URLSpan, android.widget.TextView, int, android.content.DialogInterface, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0856  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x093a  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x094f  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0958  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0995  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x09c5  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x09da  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x09fb  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0a02  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0a0a  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0a23  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0a30  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0a38  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0a3d  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x0abb  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0ac5  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0acb  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0b12  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0bc8  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0c5f  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0c64  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x0ccf  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x0d29  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0d3c  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0d97  */
    /* JADX WARN: Removed duplicated region for block: B:656:0x0bb4 A[EDGE_INSN: B:656:0x0bb4->B:571:0x0bb4 BREAK  A[LOOP:1: B:544:0x0b0d->B:570:0x0bb0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f7  */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void da(android.graphics.Canvas r46) {
        /*
            Method dump skipped, instructions count: 3552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.da(android.graphics.Canvas):void");
    }

    private void e7(final int i, boolean z) {
        ValueAnimator valueAnimator = this.n6;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final int color = this.O0.getColor();
        AbstractC21455b.o1(this.B, ((double) AbstractC21455b.z(i)) >= 0.721d);
        if (!z) {
            this.n6 = null;
            this.O0.setColor(i);
            this.B.invalidate();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n6 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.nb5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.D8(color, i, valueAnimator2);
            }
        });
        this.n6.addListener(new C21504y(i));
        this.n6.setInterpolator(InterpolatorC12631ew1.f);
        this.n6.setDuration(200L);
        this.n6.start();
    }

    private void ea() {
    }

    private void eb() {
        C0 c0 = this.b;
        if (c0 != null) {
            if (c0.getSelectedPhotos() == null || this.d <= 0 || this.b.getSelectedPhotos().size() < this.d || this.b.isPhotoChecked(this.p4)) {
                int photoChecked = this.b.setPhotoChecked(this.p4, c8());
                boolean zIsPhotoChecked = this.b.isPhotoChecked(this.p4);
                this.P0.setChecked(zIsPhotoChecked, true);
                if (photoChecked >= 0) {
                    if (zIsPhotoChecked) {
                        this.k1.notifyItemInserted(photoChecked);
                        this.j1.smoothScrollToPosition(photoChecked);
                    } else {
                        this.k1.notifyItemRemoved(photoChecked);
                        if (photoChecked == 0) {
                            this.k1.notifyItemChanged(0);
                        }
                    }
                }
                Mb();
            }
        }
    }

    private void f7(float f, float f2, float f3, boolean z) {
        g7(f, f2, f3, z, Type.TSIG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractC12724f57 f8(int i, long[] jArr) {
        if (i < 0) {
            return null;
        }
        if (!this.c6.isEmpty()) {
            if (i >= this.c6.size()) {
                return null;
            }
            if (jArr != null) {
                jArr[0] = ((Long) this.e6.get(i)).longValue();
            }
            return ((C24687z23) this.d6.get(i)).f;
        }
        if (this.a6.isEmpty() || i >= this.a6.size()) {
            return null;
        }
        C10743c74 c10743c74 = (C10743c74) this.a6.get(i);
        L57 l57 = c10743c74.e;
        if (l57 instanceof C8006Uc7) {
            M57 m57 = l57.f;
            if (m57 instanceof C20782sb7) {
                return m57.l.f;
            }
            AbstractC11500d67 abstractC11500d67Y = C4278El2.y(c10743c74.B, AbstractC21455b.g0());
            if (abstractC11500d67Y != null) {
                if (jArr != null) {
                    long j = abstractC11500d67Y.f;
                    jArr[0] = j;
                    if (j == 0) {
                        jArr[0] = -1;
                    }
                }
                return abstractC11500d67Y;
            }
            if (jArr != null) {
                jArr[0] = -1;
            }
        } else if (((C10743c74.W(l57) instanceof C23255wc7) && C10743c74.W(c10743c74.e).f != null) || ((C10743c74.W(c10743c74.e) instanceof C5153Ic7) && C10743c74.W(c10743c74.e).B != null)) {
            AbstractC11500d67 abstractC11500d67A = C4278El2.A(c10743c74.B, AbstractC21455b.g0(), false, null, true);
            if (abstractC11500d67A != null) {
                if (jArr != null) {
                    long j2 = abstractC11500d67A.f;
                    jArr[0] = j2;
                    if (j2 == 0) {
                        jArr[0] = -1;
                    }
                }
                return abstractC11500d67A;
            }
            if (jArr != null) {
                jArr[0] = -1;
            }
        } else {
            if (C10743c74.W(c10743c74.e) instanceof C22069uc7) {
                return ((C22069uc7) C10743c74.W(c10743c74.e)).f;
            }
            if (c10743c74.I() != null && C10743c74.r0(c10743c74.I())) {
                AbstractC11500d67 abstractC11500d67Y2 = C4278El2.y(c10743c74.I().k, 90);
                if (jArr != null) {
                    long j3 = abstractC11500d67Y2.f;
                    jArr[0] = j3;
                    if (j3 == 0) {
                        jArr[0] = -1;
                    }
                }
                return abstractC11500d67Y2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f9(D0 d0) {
        ClippingImageView clippingImageView;
        this.D.setImageBitmap(null);
        if (d0 != null && !AbstractC21455b.F0() && (clippingImageView = d0.animatingImageView) != null) {
            clippingImageView.setImageBitmap(null);
        }
        try {
            if (this.B.getParent() != null) {
                ((WindowManager) this.m.getSystemService("window")).removeView(this.B);
                ea();
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(ClickableSpan clickableSpan, TextView textView) {
        if (textView == null || !(clickableSpan instanceof URLSpan)) {
            clickableSpan.onClick(textView);
            return;
        }
        String url = ((URLSpan) clickableSpan).getURL();
        if (url.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND)) {
            if (this.j2 == null || this.r4 == null) {
                return;
            }
            int iIntValue = Utilities.h(url).intValue();
            if (this.j2.u1() == -9223372036854775807L) {
                this.D2 = iIntValue / ((float) this.r4.M());
                return;
            }
            long j = iIntValue * 1000;
            this.j2.I1(j);
            this.U2.t(j / this.j2.u1(), true);
            this.V2.invalidate();
            return;
        }
        if (url.startsWith(Separators.POUND)) {
            U00.e(this.n);
            return;
        }
        if (this.M3 == null || !((clickableSpan instanceof URLSpanReplacement) || AbstractC21455b.B1(url))) {
            clickableSpan.onClick(textView);
            return;
        }
        U00.f(this.n, "openUrl: = " + url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb() {
        float fO = this.i4.o();
        float fM = this.i4.m();
        if (fO == 0.0f || fM == 0.0f) {
            return;
        }
        float fZ7 = Z7();
        float fW7 = W7();
        float fMin = Math.min(fW7 / fM, fZ7 / fO);
        float fMax = Math.max(fZ7 / ((int) (fO * fMin)), fW7 / ((int) (fM * fMin)));
        this.e5 = fMax;
        Ib(fMax);
    }

    private void g7(float f, float f2, float f3, boolean z, int i) {
        if (this.e5 == f && this.c5 == f2 && this.d5 == f3) {
            return;
        }
        this.Q5 = z;
        this.j5 = f;
        this.h5 = f2;
        this.i5 = f3;
        this.p5 = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.r5 = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<PhotoViewer, Float>) AbstractC21469h.d, 0.0f, 1.0f));
        this.r5.setInterpolator(this.v5);
        this.r5.setDuration(i);
        this.r5.addListener(new C21488i0());
        this.r5.start();
    }

    public static AbstractC20488s57 g8(C24687z23 c24687z23) {
        if (c24687z23 == null) {
            return null;
        }
        return c24687z23.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g9(File file, boolean z, C10743c74 c10743c74, boolean z2) throws InterruptedException, Resources.NotFoundException {
        Pair pairZ = AbstractC21455b.Z(file);
        int i = this.w3;
        this.w3 = i - 1;
        MediaController.m mVarC = new MediaController.m(0, i, 0L, file.getAbsolutePath(), z ? 0 : ((Integer) pairZ.first).intValue(), z, 0, 0, 0L).c(pairZ);
        this.L1 = 2;
        this.Z1 = false;
        this.b = new C21476c0(this.b, c10743c74, mVarC, z2);
        this.k1.notifyDataSetChanged();
        if (this.T5 == null) {
            this.T5 = VelocityTracker.obtain();
        }
        this.r6 = 3;
        Ab(false, false);
        vb(true, false);
        NP0 np0 = this.M3;
        if (np0 != null) {
            np0.c();
        }
        Y9();
        this.N0.setAlpha(255);
        this.z.setAlpha(1.0f);
        ja(null, null, null, null, null, Collections.singletonList(mVarC), 0, null);
        this.m6.d().setTranslationY(this.m6.d().getHeight());
        this.R0.setTranslationY(AbstractC21455b.F(this.n1 ? 154.0f : 96.0f));
        this.S0.setTranslationY(AbstractC21455b.F(this.n1 ? 154.0f : 96.0f));
        this.o.setTranslationY(-r0.getHeight());
        this.H1.setTranslationY(AbstractC21455b.F(this.n1 ? 154.0f : 96.0f));
        D7();
        tb();
        this.r6 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(final URLSpan uRLSpan, final TextView textView, final Runnable runnable) {
        final int i;
        BottomSheet.i iVar = new BottomSheet.i(this.m, false, this.b2, -14933463);
        if (uRLSpan.getURL().startsWith("video?")) {
            try {
                i = Integer.parseInt(uRLSpan.getURL().substring(uRLSpan.getURL().indexOf(63) + 1));
            } catch (Throwable unused) {
            }
        } else {
            i = -1;
        }
        if (i >= 0) {
            iVar.d(AbstractC21455b.L(i, false));
        } else {
            iVar.d(uRLSpan.getURL());
        }
        iVar.b(new CharSequence[]{FH3.E("Open", TD5.tgwidget_Open), FH3.E("Copy", TD5.tgwidget_Copy)}, new DialogInterface.OnClickListener() { // from class: ir.nasim.lb5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.d9(uRLSpan, textView, i, dialogInterface, i2);
            }
        });
        iVar.c(new DialogInterface.OnDismissListener() { // from class: ir.nasim.mb5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        BottomSheet bottomSheetA = iVar.a();
        bottomSheetA.i = true;
        bottomSheetA.show();
        try {
            this.z.performHapticFeedback(0, 2);
        } catch (Exception unused2) {
        }
        bottomSheetA.w0(0, -1, -1);
        bottomSheetA.w0(1, -1, -1);
        bottomSheetA.t0(-14933463);
        bottomSheetA.B0(-7697782);
        bottomSheetA.u0(true);
        AbstractC21455b.t1(bottomSheetA.getWindow(), -14933463, false);
        AbstractC21455b.p1(bottomSheetA.getWindow(), false);
        bottomSheetA.i = true;
    }

    private void gb(boolean z, boolean z2) {
        if (this.P2 != z) {
            if (z) {
                this.G.setTag(1);
            } else {
                this.G.setTag(null);
            }
            Animator animator = this.O2;
            if (animator != null) {
                animator.cancel();
            }
            this.P2 = z;
            if (z2) {
                if (z) {
                    this.M2.setVisibility(0);
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.M2.getAlpha(), z ? 1.0f : 0.0f);
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Ca5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.a.M9(valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new M(z));
                this.O2 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.start();
            } else {
                this.M2.setVisibility(z ? 0 : 8);
                this.M2.setAlpha(z ? 1.0f : 0.0f);
            }
            if (this.Q1) {
                if (z) {
                    this.A0.m0(10);
                } else {
                    this.A0.R(10);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] h7(android.graphics.Canvas r23, int r24, int r25, int r26, int r27, float r28, ir.nasim.C3417Au1 r29, ir.nasim.tgwidgets.editor.messenger.MediaController.i r30) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.h7(android.graphics.Canvas, int, int, int, int, float, ir.nasim.Au1, ir.nasim.tgwidgets.editor.messenger.MediaController$i):int[]");
    }

    public static String h8(C24687z23 c24687z23) {
        if (c24687z23 == null || c24687z23.o != 2) {
            return null;
        }
        return "mp4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h9(int i) {
        za(i + 1);
    }

    private boolean hb(int i) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07cd  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0864  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c8  */
    /* JADX WARN: Type inference failed for: r13v2, types: [ir.nasim.tgwidgets.editor.messenger.MediaController$n] */
    /* JADX WARN: Type inference failed for: r4v49, types: [ir.nasim.tgwidgets.editor.messenger.MediaController$n] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i7() throws java.lang.InterruptedException, java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 2179
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.i7():void");
    }

    private String i8(int i) {
        if (i < 0) {
            return null;
        }
        if (this.c6.isEmpty() && this.a6.isEmpty()) {
            if (this.h6.isEmpty() || i >= this.h6.size()) {
                return null;
            }
            this.h6.get(i);
            return null;
        }
        if (this.c6.isEmpty()) {
            if (i >= this.a6.size()) {
                return null;
            }
            return C4278El2.J(((C10743c74) this.a6.get(i)).e);
        }
        if (i >= this.c6.size()) {
            return null;
        }
        C24687z23 c24687z23 = (C24687z23) this.c6.get(i);
        C24687z23 c24687z232 = (C24687z23) this.d6.get(i);
        if (c24687z23 == null) {
            return null;
        }
        if (c24687z232 != c24687z23) {
            return c24687z232.f.c + "_" + c24687z232.f.d + ".mp4";
        }
        return c24687z23.f.c + "_" + c24687z23.f.d + ".jpg";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i9(ValueAnimator valueAnimator) {
        Db();
    }

    private void ia(final D0 d0) throws InterruptedException {
        if (this.Z1) {
            Aa(true);
        }
        C10743c74 c10743c74 = this.r4;
        if (c10743c74 != null && !c10743c74.n) {
            C4278El2.H(this.v).j(this.r4.I());
        }
        this.c = false;
        this.M1 = false;
        this.X3 = true;
        this.r4 = null;
        this.u4 = null;
        this.v4 = null;
        this.B4 = null;
        this.y4 = null;
        if (this.M2 != null) {
            gb(false, false);
        }
        r0 r0Var = this.I1;
        if (r0Var != null) {
            r0Var.i0();
        }
        this.L1 = 0;
        this.N1 = false;
        ImageReceiver.b bVar = this.C4;
        if (bVar != null) {
            bVar.d();
            this.C4 = null;
        }
        AnimatedFileDrawable animatedFileDrawable = this.P1;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.Q0(this.z);
            this.P1 = null;
        }
        for (int i = 0; i < 3; i++) {
            A0 a0 = this.V0[i];
            if (a0 != null) {
                a0.o(-1, false, true);
            }
        }
        Ca(0);
        VideoTimelinePlayView videoTimelinePlayView = this.y6;
        if (videoTimelinePlayView != null) {
            videoTimelinePlayView.setBackgroundColor(2130706432);
            this.y6.i();
        }
        this.i1.f(false, 0);
        this.i4.V0(null);
        this.h4.V0(null);
        this.j4.V0(null);
        this.z.post(new Runnable() { // from class: ir.nasim.Ja5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f9(d0);
            }
        });
        C0 c0 = this.b;
        if (c0 != null) {
            c0.willHidePhotoViewer();
        }
        this.g1.h();
        C0 c02 = this.b;
        if (c02 != null) {
            c02.onClose();
        }
        this.b = null;
        this.k1.notifyDataSetChanged();
        this.X3 = false;
        this.V5 = false;
        this.V6 = 0.0f;
        this.W6 = 1.0f;
        if (d0 != null) {
            d0.imageReceiver.t1(true, true);
        }
        Bitmap bitmap = this.o4;
        if (bitmap != null) {
            bitmap.recycle();
            this.o4 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ib(C10743c74 c10743c74) {
        return c10743c74 != null && c10743c74.c1() && (c10743c74.G || c10743c74.F || (c10743c74.m() && AbstractC8662Wx6.a0)) && AbstractC8662Wx6.j();
    }

    private void j7() {
        ir.nasim.tgwidgets.editor.ui.O o = this.m6;
        if (o == null) {
            return;
        }
        ViewGroup viewGroupD = o.d();
        if (viewGroupD.getParent() != null) {
            if (viewGroupD.getParent() == this.z) {
                return;
            } else {
                ((ViewGroup) viewGroupD.getParent()).removeView(viewGroupD);
            }
        }
        w0 w0Var = this.z;
        if (w0Var != null) {
            w0Var.addView(viewGroupD, AbstractC13840gu3.d(-1, -2, 83));
        }
    }

    private C24687z23 j8(int i, long[] jArr) {
        if (i < 0) {
            return null;
        }
        if (!this.c6.isEmpty()) {
            if (i >= this.c6.size()) {
                return null;
            }
            if (jArr != null) {
                jArr[0] = ((Long) this.e6.get(i)).longValue();
            }
            return (C24687z23) this.d6.get(i);
        }
        if (this.a6.isEmpty() || i >= this.a6.size()) {
            return null;
        }
        C10743c74 c10743c74 = (C10743c74) this.a6.get(i);
        L57 l57 = c10743c74.e;
        if (l57 instanceof C8006Uc7) {
            if (l57.f instanceof C20782sb7) {
                return null;
            }
            AbstractC11500d67 abstractC11500d67Y = C4278El2.y(c10743c74.B, AbstractC21455b.g0());
            if (abstractC11500d67Y != null) {
                if (jArr != null) {
                    long j = abstractC11500d67Y.f;
                    jArr[0] = j;
                    if (j == 0) {
                        jArr[0] = -1;
                    }
                }
                return C24687z23.f(abstractC11500d67Y, c10743c74.z);
            }
            if (jArr != null) {
                jArr[0] = -1;
            }
        } else if ((!(C10743c74.W(l57) instanceof C23255wc7) || C10743c74.W(c10743c74.e).f == null) && (!(C10743c74.W(c10743c74.e) instanceof C5153Ic7) || C10743c74.W(c10743c74.e).B == null)) {
            if (C10743c74.W(c10743c74.e) instanceof C22069uc7) {
                return C24687z23.l(C12154e78.d(((C22069uc7) C10743c74.W(c10743c74.e)).N));
            }
            if (c10743c74.I() != null) {
                AbstractC18106o57 abstractC18106o57I = c10743c74.I();
                if (this.J4 == 5) {
                    return C24687z23.b(abstractC18106o57I);
                }
                if (C10743c74.r0(c10743c74.I())) {
                    AbstractC11500d67 abstractC11500d67Y2 = C4278El2.y(abstractC18106o57I.k, 90);
                    if (jArr != null) {
                        long j2 = abstractC11500d67Y2.f;
                        jArr[0] = j2;
                        if (j2 == 0) {
                            jArr[0] = -1;
                        }
                    }
                    return C24687z23.c(abstractC11500d67Y2, abstractC18106o57I);
                }
            }
        } else {
            if (c10743c74.t0()) {
                return C24687z23.b(c10743c74.I());
            }
            AbstractC11500d67 abstractC11500d67A = C4278El2.A(c10743c74.B, AbstractC21455b.g0(), false, null, true);
            if (abstractC11500d67A != null) {
                if (jArr != null) {
                    long j3 = abstractC11500d67A.f;
                    jArr[0] = j3;
                    if (j3 == 0) {
                        jArr[0] = -1;
                    }
                }
                return C24687z23.f(abstractC11500d67A, c10743c74.z);
            }
            if (jArr != null) {
                jArr[0] = -1;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j9(boolean z, View view) {
        if (!z) {
            view.setVisibility(8);
        }
        Db();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.animation.AnimatorSet, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v10 */
    public void ja(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, C24687z23 c24687z23, C24687z23 c24687z232, ArrayList arrayList, List list, int i, D0 d0) throws InterruptedException, Resources.NotFoundException {
        ?? r10;
        boolean z;
        C0 c0;
        M57 m57;
        PhotoViewerWebView photoViewerWebView;
        AbstractC25089zi7 abstractC25089zi7;
        String str;
        L57 l57;
        this.a = 0;
        this.H3 = null;
        this.r4 = null;
        this.u4 = null;
        this.v4 = null;
        this.y4 = null;
        this.B4 = null;
        this.F4 = false;
        this.d7 = 0.0f;
        this.c7 = 0L;
        this.p4 = -1;
        String[] strArr = this.w4;
        strArr[0] = null;
        strArr[1] = null;
        strArr[2] = null;
        this.G4 = 0L;
        this.H4 = false;
        this.N4 = 0;
        this.P4 = 0;
        this.a4 = 0;
        this.Q4 = true;
        this.R4 = false;
        this.S4 = false;
        boolean[] zArr = this.T4;
        zArr[0] = false;
        zArr[1] = this.M4 == 0;
        this.V4 = false;
        this.W4 = false;
        this.O1 = false;
        this.z.setTag(1);
        this.B2 = false;
        this.n1 = false;
        this.V5 = false;
        this.a6.clear();
        this.c6.clear();
        this.e6.clear();
        this.d6.clear();
        this.f6.clear();
        this.g6.clear();
        this.h6.clear();
        this.o.setElevation(0.0f);
        for (int i2 = 0; i2 < 2; i2++) {
            this.b6[i2].clear();
            this.Z5[i2].clear();
        }
        this.Y5.clear();
        this.i6 = null;
        this.z.setPadding(0, 0, 0, 0);
        ImageReceiver.b bVar = this.C4;
        if (bVar != null) {
            bVar.d();
        }
        VideoTimelinePlayView videoTimelinePlayView = this.y6;
        if (videoTimelinePlayView != null) {
            if (this.L1 == 1) {
                videoTimelinePlayView.setBackground(null);
            } else {
                videoTimelinePlayView.setBackgroundColor(2130706432);
            }
        }
        this.C4 = d0 != null ? d0.thumb : null;
        this.I4 = d0 != null && d0.isEvent;
        this.J4 = 0;
        this.C0.setText(FH3.E("ShowAllMedia", TD5.tgwidget_ShowAllMedia));
        Ya(this.G0, false, false);
        Ya(this.I0, false, true);
        PhotoCropView photoCropView = this.y1;
        if (photoCropView != null) {
            photoCropView.setSubtitle(null);
        }
        this.o.setBackgroundColor(2130706432);
        this.b1.setVisibility(8);
        this.b1.setTag(null);
        this.G.setVisibility(8);
        this.G.setTag(0);
        z0 z0Var = this.t;
        if (z0Var != null) {
            z0Var.e(false, false);
        }
        this.G.setTranslationY(0.0f);
        this.H1.setTranslationY(0.0f);
        Ya(this.H0, false, false);
        E0 e0 = this.v6;
        if (e0 != null) {
            e0.setVisibility(4);
            this.w6.setVisibility(4);
            r10 = 0;
            this.v6.setTag(null);
        } else {
            r10 = 0;
        }
        AnimatorSet animatorSet = this.A6;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.A6 = r10;
        }
        Qa(true);
        this.Q1 = false;
        this.h = 0;
        this.i = r10;
        this.j = 0;
        this.A0.R(2);
        this.A0.R(4);
        this.A0.R(10);
        this.A0.R(11);
        this.A0.R(14);
        this.A0.R(15);
        this.A0.R(17);
        this.A0.R(16);
        this.A0.R(6);
        this.D0.setVisibility(8);
        this.E0.setVisibility(8);
        this.o.setTranslationY(0.0f);
        this.P0.setAlpha(1.0f);
        this.P0.setTranslationY(0.0f);
        this.P0.setVisibility(8);
        this.o.setTitleRightMargin(0);
        this.Q0.setAlpha(1.0f);
        this.Q0.setTranslationY(0.0f);
        this.Q0.setVisibility(8);
        Db();
        this.m6.c(true, true);
        this.m6.d().setVisibility(8);
        this.R0.setVisibility(8);
        this.S0.setVisibility(8);
        this.z0.setVisibility(8);
        this.S0.setTranslationY(0.0f);
        this.m6.d().setAlpha(1.0f);
        this.R0.setAlpha(1.0f);
        this.S0.setAlpha(1.0f);
        this.m6.d().setTranslationY(0.0f);
        this.R0.setTranslationY(0.0f);
        this.X0.setVisibility(8);
        this.X0.setTag(null);
        this.Y0.setVisibility(8);
        this.c1.setVisibility(8);
        this.c1.setTag(null);
        this.d1.setVisibility(8);
        this.a1.setVisibility(8);
        this.Z0.setVisibility(8);
        this.R0.getLayoutParams().height = -2;
        this.Z.setVisibility(8);
        this.Y.setVisibility(8);
        ob(false, false);
        this.z6.setVisibility(8);
        this.f1.setVisibility(8);
        this.K1.setVisibility(8);
        this.N3.setVisibility(8);
        AbstractC21455b.J1(this.e1, false, 1.0f, false);
        this.s.g(null);
        Ya(this.J0, false, true);
        this.f = false;
        this.e1.setImageResource(AbstractC23598xB5.video_send_unmute);
        this.T0.setVisibility(8);
        this.H1.setTag(null);
        this.H1.setVisibility(4);
        PhotoCropView photoCropView2 = this.y1;
        if (photoCropView2 != null) {
            photoCropView2.setVisibility(8);
        }
        PhotoFilterView photoFilterView = this.E1;
        if (photoFilterView != null) {
            photoFilterView.setVisibility(8);
        }
        for (int i3 = 0; i3 < 3; i3++) {
            A0 a0 = this.V0[i3];
            if (a0 != null) {
                a0.o(-1, false, true);
            }
        }
        GroupedPhotosListView groupedPhotosListView = this.g1;
        if (groupedPhotosListView != null) {
            groupedPhotosListView.n();
            this.g1.setAnimateBackground(!AbstractC14047hG.c());
        }
        C0 c02 = this.b;
        if (c02 != null && c02.getTotalImageCount() > 0) {
            this.N4 = this.b.getTotalImageCount();
        }
        if (c10743c74 != null) {
            this.p1 = AbstractC14047hG.a.getSharedPreferences("playback_speed", 0).getFloat("speed" + c10743c74.F() + "_" + c10743c74.T(), 1.0f);
        } else {
            this.p1 = 1.0f;
        }
        ab(false, true);
        boolean z2 = c10743c74 != null && (ir.nasim.tgwidgets.editor.messenger.C.n(this.v).w(c10743c74.E()) || (((l57 = c10743c74.e) != null && l57.I) || c10743c74.i0()));
        if (c10743c74 != null && arrayList == null) {
            L57 l572 = c10743c74.e;
            if (l572 != null && (C10743c74.W(l572) instanceof C5153Ic7) && C10743c74.W(c10743c74.e).B != null && (str = (abstractC25089zi7 = C10743c74.W(c10743c74.e).B).h) != null) {
                String lowerCase = str.toLowerCase();
                if (lowerCase.equals("instagram") || lowerCase.equals("twitter") || "telegram_album".equals(abstractC25089zi7.g)) {
                    if (!TextUtils.isEmpty(abstractC25089zi7.q)) {
                        this.i = abstractC25089zi7.q;
                    }
                    if (abstractC25089zi7.s instanceof C3270Ad7) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= abstractC25089zi7.s.f.size()) {
                                break;
                            }
                            W57 w57 = (W57) abstractC25089zi7.s.f.get(i4);
                            if (w57 instanceof C4211Ed7) {
                                this.j = ((C4211Ed7) w57).f;
                                break;
                            }
                            i4++;
                        }
                    }
                    ArrayList arrayListE0 = c10743c74.e0(null, null);
                    if (!arrayListE0.isEmpty()) {
                        this.h = c10743c74.T();
                        this.R4 = false;
                        this.a6.addAll(arrayListE0);
                        this.N4 = this.a6.size();
                        int iIndexOf = this.a6.indexOf(c10743c74);
                        if (iIndexOf < 0) {
                            iIndexOf = 0;
                        }
                        Ra(iIndexOf);
                    }
                }
            }
            if (c10743c74.k()) {
                this.J4 = 1;
                this.C0.setText(FH3.E("ShowAllFiles", TD5.tgwidget_ShowAllFiles));
            } else if (c10743c74.t0()) {
                this.J4 = 5;
                this.C0.setText(FH3.E("ShowAllGIFs", TD5.tgwidget_ShowAllGIFs));
            }
            if (this.Z3 && ((photoViewerWebView = this.A) == null || !photoViewerWebView.H())) {
                this.G.setTag(null);
                this.G.setVisibility(8);
            }
            if (this.h == 0) {
                this.a6.add(c10743c74);
                if (c10743c74.p != 0) {
                    this.R4 = false;
                } else if (this.P1 != null) {
                    this.R4 = false;
                    if (c10743c74.j() && !z2) {
                        Ya(this.G0, true, false);
                    }
                } else if (!(C10743c74.W(c10743c74.e) instanceof C22069uc7) && !(C10743c74.W(c10743c74.e) instanceof C5153Ic7) && ((m57 = c10743c74.e.f) == null || (m57 instanceof C6564Oa7))) {
                    this.R4 = true;
                    this.b6[0].put(c10743c74.T(), c10743c74);
                    this.A0.m0(4);
                    this.A0.m0(2);
                    Ya(this.G0, !z2, false);
                } else if (this.Z3 && c10743c74.p == 0) {
                    Ya(this.G0, true, false);
                }
                Ra(0);
            }
        } else if (abstractC20488s57 != null) {
            long j = d0 != null ? d0.dialogId : 0L;
            this.G4 = j;
            this.H4 = d0 != null && d0.canEdit;
            C24687z23 c24687z23K = (c24687z23 != null || j == 0) ? c24687z23 : j > 0 ? C24687z23.k(ir.nasim.tgwidgets.editor.messenger.C.n(this.v).s(Long.valueOf(this.G4)), 0) : C24687z23.k(ir.nasim.tgwidgets.editor.messenger.C.n(this.v).i(Long.valueOf(-this.G4)), 0);
            if (c24687z23K == null) {
                return;
            }
            this.c6.add(c24687z23K);
            this.d6.add(c24687z232 != null ? c24687z232 : c24687z23K);
            this.i6 = c24687z23K;
            this.e6.add(Long.valueOf(d0 != null ? d0.size : 0L));
            this.f6.add(null);
            this.g6.add(new C7083Qe7());
            this.Q1 = true;
            this.A0.R(2);
            this.A0.m0(10);
            Ra(0);
            if (this.L1 == 1) {
                if (Sb()) {
                    this.z0.setVisibility(0);
                } else {
                    this.S0.setVisibility(0);
                }
                this.S0.setTranslationY(0.0f);
                this.S0.setAlpha(1.0f);
                View view = this.H;
                if (view != null) {
                    view.setVisibility(0);
                    this.H.setAlpha(1.0f);
                }
                this.G.setVisibility(8);
                this.G.setTag(null);
                this.z.setTag(null);
            }
        } else if (arrayList != null) {
            this.a6.addAll(arrayList);
            for (int i5 = 0; i5 < this.a6.size(); i5++) {
                C10743c74 c10743c742 = (C10743c74) this.a6.get(i5);
                this.b6[c10743c742.F() == this.L4 ? (char) 0 : (char) 1].put(c10743c742.T(), c10743c742);
            }
            C10743c74 c10743c743 = (C10743c74) this.a6.get(i);
            this.V4 = this.M3 == null;
            if (d0 != null) {
                this.O4 = d0.starOffset;
            }
            this.A0.m0(4);
            if (c10743c743.j() && !z2) {
                Ya(this.G0, true, false);
            }
            if (c10743c743.k()) {
                this.J4 = 1;
                this.C0.setText(FH3.E("ShowAllFiles", TD5.tgwidget_ShowAllFiles));
            } else if (c10743c743.t0()) {
                this.J4 = 5;
                this.C0.setText(FH3.E("ShowAllGIFs", TD5.tgwidget_ShowAllGIFs));
            }
            Ra(i);
        } else if (list != null) {
            int i6 = this.L1;
            if (i6 != -1 && ((i6 == 0 || i6 == 4 || ((i6 == 2 || i6 == 5) && list.size() > 1)) && this.L1 != 99)) {
                this.P0.setVisibility(0);
                this.Q0.setVisibility(0);
                Db();
            }
            int i7 = this.L1;
            if (i7 != -1 && ((i7 == 2 || i7 == 5) && this.b.canCaptureMorePhotos())) {
                this.b1.setVisibility(0);
                this.b1.setTag(1);
            }
            this.A0.setVisibility(8);
            this.h6.addAll(list);
            Object obj = this.h6.get(i);
            int i8 = this.L1;
            if (i8 == -1 || !(obj instanceof MediaController.m)) {
                this.Y0.setVisibility(8);
                this.a1.setVisibility(8);
                this.Z0.setVisibility(8);
                z = this.Y0.getVisibility() == 0;
            } else {
                if (i8 == 10) {
                    this.Y0.setVisibility(8);
                    this.a1.setVisibility(8);
                    this.Z0.setVisibility(8);
                } else if (this.N1) {
                    this.Y0.setVisibility(8);
                    this.a1.setVisibility(8);
                    this.Z0.setVisibility(8);
                    this.Z.setVisibility(0);
                    this.Y.setVisibility(0);
                    this.R0.getLayoutParams().height = AbstractC21455b.F(84.0f);
                } else if (((MediaController.m) obj).D) {
                    this.Y0.setVisibility(8);
                    this.a1.setVisibility(8);
                    this.Z0.setVisibility(8);
                    this.G.setVisibility(0);
                    this.G.setTag(1);
                    this.G.setTranslationY(-AbstractC21455b.F(48.0f));
                } else {
                    this.Y0.setVisibility(i8 != 1 ? 0 : 8);
                    this.a1.setVisibility(this.L1 != 1 ? 8 : 0);
                    this.Z0.setVisibility(this.L1 != 1 ? 8 : 0);
                }
                z = !this.N1;
            }
            if (this.M3 != null) {
                boolean z3 = z && ((c0 = this.b) == null || c0.allowCaption());
                this.O1 = z3;
                this.K1.setVisibility(z3 ? 0 : 8);
                if (this.O1) {
                    this.K1.W();
                }
            }
            if (this.L1 != -1) {
                this.m6.d().setVisibility(0);
                this.R0.setVisibility(0);
                if (Sb()) {
                    this.z0.setVisibility(0);
                } else {
                    this.S0.setVisibility(0);
                    this.S0.setTranslationY(0.0f);
                    this.S0.setAlpha(1.0f);
                }
                View view2 = this.H;
                if (view2 != null) {
                    view2.setVisibility(0);
                    this.H.setAlpha(1.0f);
                }
                this.G.setVisibility(8);
                this.G.setTag(null);
                this.z.setTag(null);
            }
            Ra(i);
            int i9 = this.L1;
            if (i9 == 1) {
                this.X0.setVisibility(0);
                this.c1.setVisibility(0);
            } else if (i9 == 4 || i9 == 5) {
                this.X0.setVisibility(8);
                this.c1.setVisibility(8);
            } else {
                ImageView imageView = this.X0;
                imageView.setVisibility(imageView.getTag() != null ? 0 : 8);
                ImageView imageView2 = this.c1;
                imageView2.setVisibility(imageView2.getTag() != null ? 0 : 8);
            }
            Mb();
        } else {
            Ra(i);
        }
        if (this.P1 == null && !this.I4) {
            if (this.L4 == 0 || this.N4 != 0) {
                if (this.G4 != 0 && this.b.canLoadMoreAvatars()) {
                    ir.nasim.tgwidgets.editor.messenger.C.n(this.v).z(this.G4, 80, 0, true, this.a);
                }
            } else if (C15404jX3.c(this.r4.e) == this.J4) {
                C15404jX3.a(this.v).b(this.L4, this.K4, this.J4, this.a, true);
                if (this.M4 != 0) {
                    C15404jX3.a(this.v).b(this.M4, this.K4, this.J4, this.a, true);
                }
            }
        }
        C10743c74 c10743c744 = this.r4;
        if ((c10743c744 != null && c10743c744.c1()) || (this.L1 == -1 && ((MediaController.m) this.h6.get(i)).D)) {
            this.B2 = true;
            ca(false);
        }
        u7();
    }

    private void k7(boolean z, boolean z2) {
        if (z) {
            long j = (long) (((z2 ? 0L : this.X6) + this.Y6) * (this.a7 / this.P6));
            this.Z6 = j + ((j / 32768) * 16);
            return;
        }
        float f = this.b7;
        long j2 = this.a7;
        float f2 = this.P6;
        long j3 = (long) (f * (j2 / f2));
        this.Z6 = j3;
        if (z2) {
            this.Z6 = j3 - ((long) (this.X6 * (j2 / f2)));
        }
    }

    public static PhotoViewer k8() {
        PhotoViewer photoViewer = p7;
        if (photoViewer == null) {
            synchronized (PhotoViewer.class) {
                try {
                    photoViewer = p7;
                    if (photoViewer == null) {
                        photoViewer = new PhotoViewer();
                        p7 = photoViewer;
                    }
                } finally {
                }
            }
        }
        return photoViewer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k9(View view) throws IOException {
        this.F6 = this.H6;
        M7(false);
        lb(false);
        Ca(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        boolean zC1;
        if (this.m == null || !this.Q1) {
            return;
        }
        try {
            C10743c74 c10743c74 = this.r4;
            File fileO = null;
            if (c10743c74 != null) {
                zC1 = c10743c74.c1();
                if (!TextUtils.isEmpty(this.r4.e.M)) {
                    File file = new File(this.r4.e.M);
                    if (file.exists()) {
                        fileO = file;
                    }
                }
                if (fileO == null) {
                    fileO = C4278El2.H(this.v).R(this.r4.e);
                }
            } else {
                if (this.v4 != null) {
                    fileO = C4278El2.H(this.v).O(g8(this.v4), h8(this.v4), this.G4 != 0 || this.I4);
                }
                zC1 = false;
            }
            if (fileO != null && !fileO.exists()) {
                fileO = new File(C4278El2.B(4), fileO.getName());
            }
            if (fileO == null || !fileO.exists()) {
                kb();
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (zC1) {
                intent.setType("video/mp4");
            } else {
                C10743c74 c10743c742 = this.r4;
                if (c10743c742 != null) {
                    intent.setType(c10743c742.Z());
                } else {
                    intent.setType("image/jpeg");
                }
            }
            try {
                intent.putExtra("android.intent.extra.STREAM", FileProvider.h(this.m, AbstractC14047hG.a() + ".provider", fileO));
                intent.setFlags(1);
            } catch (Exception unused) {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(fileO));
            }
            this.m.startActivityForResult(Intent.createChooser(intent, FH3.E("ShareFile", TD5.tgwidget_ShareFile)), SIPTransactionStack.BASE_TIMER_INTERVAL);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        AlertDialog.i iVar = new AlertDialog.i(this.m, this.b2);
        iVar.j(FH3.E("AppName", TD5.tgwidget_AppName));
        iVar.i(FH3.E("OK", TD5.tgwidget_OK), null);
        C10743c74 c10743c74 = this.r4;
        if (c10743c74 != null && c10743c74.c1() && C4278El2.H(this.r4.N).T(this.w4[0])) {
            iVar.e(FH3.E("PleaseStreamDownload", TD5.tgwidget_PleaseStreamDownload));
        } else {
            iVar.e(FH3.E("PleaseDownload", TD5.tgwidget_PleaseDownload));
        }
        jb(iVar);
    }

    private RD6 l7() {
        int iRound;
        int i;
        if (this.G6 == 1) {
            return new RD6(this.J6, this.K6);
        }
        int i2 = this.F6;
        float f = (i2 != 0 ? i2 != 1 ? i2 != 2 ? 1920.0f : 1280.0f : 854.0f : 480.0f) / (this.J6 > this.K6 ? this.J6 : this.K6);
        if (this.F6 != this.G6 - 1 || f < 1.0f) {
            int iRound2 = Math.round((this.J6 * f) / 2.0f) * 2;
            iRound = Math.round((this.K6 * f) / 2.0f) * 2;
            i = iRound2;
        } else {
            i = this.J6;
            iRound = this.K6;
        }
        return new RD6(i, iRound);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l8() {
        Object obj = this.X1;
        if (obj != null) {
            return ((WindowInsets) obj).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l9(View view) throws IOException {
        Object obj = this.h6.get(this.p4);
        if (obj instanceof MediaController.l) {
            ((MediaController.l) obj).m = c8();
        }
        lb(false);
        Ca(2);
    }

    private void la() {
    }

    private void lb(boolean z) {
        TextureView textureView;
        if (z && this.j3 && this.k3 && !this.h3 && (textureView = this.h2) != null) {
            this.o4 = textureView.getBitmap();
        }
        if (z) {
            this.H6 = this.F6;
        }
        AnimatorSet animatorSet = this.A6;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.A6 = new AnimatorSet();
        if (z) {
            this.v6.setTag(1);
            AnimatorSet animatorSet2 = this.A6;
            ViewGroup viewGroupD = this.m6.d();
            Property property = View.TRANSLATION_Y;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(viewGroupD, (Property<ViewGroup, Float>) property, 0.0f, this.m6.d().getHeight()), ObjectAnimator.ofFloat(this.R0, (Property<FrameLayout, Float>) property, 0.0f, AbstractC21455b.F(152.0f)), ObjectAnimator.ofFloat(this.S0, (Property<ImageView, Float>) property, 0.0f, AbstractC21455b.F(152.0f)));
        } else {
            this.v6.setTag(null);
            AnimatorSet animatorSet3 = this.A6;
            E0 e0 = this.v6;
            Property property2 = View.TRANSLATION_Y;
            animatorSet3.playTogether(ObjectAnimator.ofFloat(e0, (Property<E0, Float>) property2, 0.0f, AbstractC21455b.F(166.0f)), ObjectAnimator.ofFloat(this.w6, (Property<PickerBottomLayoutViewer, Float>) property2, 0.0f, AbstractC21455b.F(166.0f)));
        }
        this.A6.addListener(new l0(z));
        this.A6.setDuration(200L);
        this.A6.setInterpolator(AbstractC21455b.u);
        this.A6.start();
        if (this.b1.getVisibility() == 0) {
            this.b1.animate().scaleX(z ? 0.25f : 1.0f).scaleY(z ? 0.25f : 1.0f).alpha(z ? 0.0f : 1.0f).setDuration(200L);
        }
        if (this.e1.getVisibility() == 0) {
            this.e1.animate().scaleX(z ? 0.25f : 1.0f).scaleY(z ? 0.25f : 1.0f).alpha(z ? 0.0f : 1.0f).setDuration(200L);
        }
    }

    private boolean m7(MotionEvent motionEvent) {
        PhotoViewerWebView photoViewerWebView;
        if (this.j2 == null && ((photoViewerWebView = this.A) == null || !photoViewerWebView.H())) {
            return false;
        }
        boolean z = motionEvent.getX() >= ((float) ((Z7() / 3) * 2));
        long jD8 = d8();
        long jO8 = o8();
        if (jD8 == -9223372036854775807L || jO8 <= 15000) {
            return false;
        }
        return !z || jO8 - jD8 > 10000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m8() {
        Object obj = this.X1;
        if (obj != null) {
            return ((WindowInsets) obj).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m9(View view) throws InterruptedException, IOException {
        Ka(false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:182:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0423 A[PHI: r3
      0x0423: PHI (r3v63 float) = (r3v58 float), (r3v59 float) binds: [B:217:0x0421, B:220:0x0429] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0432 A[PHI: r3
      0x0432: PHI (r3v62 float) = (r3v60 float), (r3v61 float) binds: [B:223:0x0430, B:226:0x0438] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0457 A[PHI: r4
      0x0457: PHI (r4v28 float) = (r4v23 float), (r4v24 float) binds: [B:232:0x0455, B:235:0x045d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0468 A[PHI: r4
      0x0468: PHI (r4v27 float) = (r4v25 float), (r4v26 float) binds: [B:238:0x0466, B:241:0x046e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0547 A[PHI: r4
      0x0547: PHI (r4v15 float) = (r4v10 float), (r4v11 float) binds: [B:288:0x0545, B:291:0x054d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0558 A[PHI: r4
      0x0558: PHI (r4v14 float) = (r4v12 float), (r4v13 float) binds: [B:294:0x0556, B:297:0x055e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x055a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean ma(android.view.MotionEvent r20) {
        /*
            Method dump skipped, instructions count: 1662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.ma(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(ArrayList arrayList) {
        U00.f(this.m, "showShareAlert");
    }

    private boolean n7() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n8(int i) {
        m.h hVar = this.b2;
        return hVar != null ? hVar.getColor(i) : ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n9(View view) throws InterruptedException, IOException {
        if (this.K1.getCaptionLimitOffset() >= 0) {
            Ka(true, 0);
            return;
        }
        AbstractC21455b.x1(this.F3);
        try {
            this.F3.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        if (this.I0.getAlpha() == 1.0f && AbstractC21455b.x(this.m) && !ir.nasim.tgwidgets.editor.ui.Components.w.J0() && this.r3) {
            if (!this.Z3) {
                this.m3 = false;
                ub(false);
                return;
            }
            PhotoViewerWebView photoViewerWebView = this.A;
            if (photoViewerWebView == null || photoViewerWebView.I() || !this.A.O()) {
                return;
            }
            this.m3 = false;
            if (q7 != null) {
                q7.J7();
            }
            this.l3 = true;
            q7 = p7;
            p7 = null;
            this.c = false;
            D0 d0 = this.x4;
            if (d0 != null && !d0.imageReceiver.d0()) {
                this.x4.imageReceiver.t1(true, true);
            }
            this.n5 = 1.0f;
            this.z.invalidate();
            N7();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb(boolean z) {
        PhotoViewerWebView photoViewerWebView;
        if (!z || this.W2.getTag() == null) {
            if (z || this.W2.getTag() != null) {
                if (z && !this.W2.h() && ((photoViewerWebView = this.A) == null || !photoViewerWebView.L() || !this.A.E())) {
                    this.Y2 = true;
                    return;
                }
                AnimatorSet animatorSet = this.X2;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                this.W2.setTag(z ? 1 : null);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.X2 = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.W2, (Property<VideoSeekPreviewImage, Float>) View.ALPHA, z ? 1.0f : 0.0f));
                this.X2.addListener(new D());
                this.X2.setDuration(180L);
                this.X2.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o7() {
        View view = this.f2;
        if (view != null) {
            view.animate().setListener(null).cancel();
            this.f2.setAlpha(0.0f);
        }
        AnimatorSet animatorSet = this.g2;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.g2 = null;
        }
        PhotoCropView photoCropView = this.y1;
        if (photoCropView != null) {
            photoCropView.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long o8() {
        PhotoViewerWebView photoViewerWebView = this.A;
        if (photoViewerWebView != null && photoViewerWebView.H()) {
            return this.A.getVideoDuration();
        }
        FT7 ft7 = this.j2;
        if (ft7 == null) {
            return 0L;
        }
        return ft7.u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o9(View view) {
        if (this.K1.getTag() != null) {
            return;
        }
        if (this.n1) {
            if (!this.R6) {
                return;
            }
            TextureView textureView = this.h2;
            if (!(textureView instanceof VideoEditTextureView)) {
                return;
            }
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                return;
            }
        }
        rb(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa() {
        final File file;
        final C10743c74 c10743c74;
        final boolean z;
        final boolean z2;
        if (n7()) {
            C10743c74 c10743c742 = this.r4;
            File fileR = null;
            if (c10743c742 != null) {
                boolean z3 = c10743c742.i() && !this.r4.p0();
                boolean zC1 = this.r4.c1();
                if (!TextUtils.isEmpty(this.r4.e.M)) {
                    File file2 = new File(this.r4.e.M);
                    if (file2.exists()) {
                        fileR = file2;
                    }
                }
                if (fileR == null) {
                    fileR = C4278El2.H(this.v).R(this.r4.e);
                }
                c10743c74 = c10743c742;
                file = fileR;
                z2 = z3;
                z = zC1;
            } else {
                file = null;
                c10743c74 = null;
                z = false;
                z2 = false;
            }
            if (file == null || !file.exists()) {
                kb();
                return;
            }
            this.j6 = new F0(this.p4, new ArrayList(this.a6), this.b);
            wb(false, true, new q0().a(false));
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.db5
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException, Resources.NotFoundException {
                    this.a.g9(file, z, c10743c74, z2);
                }
            }, r0.a);
        }
    }

    private void ob(boolean z, boolean z2) {
        if (!z2) {
            this.y6.animate().setListener(null).cancel();
            this.y6.setVisibility(z ? 0 : 8);
            this.y6.setTranslationY(0.0f);
            this.y6.setAlpha(this.R0.getAlpha());
        } else if (z && this.y6.getTag() == null) {
            if (this.y6.getVisibility() != 0) {
                this.y6.setVisibility(0);
                this.y6.setAlpha(this.R0.getAlpha());
                this.y6.setTranslationY(AbstractC21455b.F(58.0f));
            }
            ObjectAnimator objectAnimator = this.B6;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.B6.cancel();
            }
            VideoTimelinePlayView videoTimelinePlayView = this.y6;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(videoTimelinePlayView, (Property<VideoTimelinePlayView, Float>) View.TRANSLATION_Y, videoTimelinePlayView.getTranslationY(), 0.0f);
            this.B6 = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(220L);
            this.B6.setInterpolator(InterpolatorC12631ew1.f);
            this.B6.start();
        } else if (!z && this.y6.getTag() != null) {
            ObjectAnimator objectAnimator2 = this.B6;
            if (objectAnimator2 != null) {
                objectAnimator2.removeAllListeners();
                this.B6.cancel();
            }
            VideoTimelinePlayView videoTimelinePlayView2 = this.y6;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(videoTimelinePlayView2, (Property<VideoTimelinePlayView, Float>) View.TRANSLATION_Y, videoTimelinePlayView2.getTranslationY(), AbstractC21455b.F(58.0f));
            this.B6 = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.addListener(new C24365yV2(this.y6));
            this.B6.setDuration(220L);
            this.B6.setInterpolator(InterpolatorC12631ew1.f);
            this.B6.start();
        }
        this.y6.setTag(z ? 1 : null);
    }

    private void p7() {
        AnimatorSet animatorSet = this.r5;
        if (animatorSet == null) {
            return;
        }
        float f = this.e5;
        float f2 = this.j5 - f;
        float f3 = this.m5;
        float f4 = f + (f2 * f3);
        float f5 = this.c5;
        float f6 = f5 + ((this.h5 - f5) * f3);
        float f7 = this.d5;
        float f8 = f7 + ((this.i5 - f7) * f3);
        float f9 = this.f5;
        float f10 = f9 + ((this.k5 - f9) * f3);
        animatorSet.cancel();
        this.e5 = f4;
        this.c5 = f6;
        this.d5 = f8;
        this.p5 = 0L;
        this.f5 = f10;
        Ib(f4);
        this.Q5 = false;
        this.z.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p9(View view) {
        H7(-90.0f);
    }

    private void pb() {
        FT7 ft7;
        if (!this.n1 || (ft7 = this.j2) == null || ft7.A1()) {
            return;
        }
        if (!this.f || this.L1 == 1) {
            this.j2.S1(0.0f);
        }
        this.k2 = false;
        Bb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q7() {
        Runnable runnable = this.l2;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
            this.l2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q9(View view) {
        G7();
    }

    private boolean qb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r7() {
        TextureView textureView;
        if (this.C6 == -1 || (textureView = this.h2) == null) {
            return;
        }
        this.C6 = -1L;
        this.f2.animate().alpha(1.0f).setInterpolator(InterpolatorC12631ew1.j).setDuration(85L).setListener(new C21505z(textureView.getBitmap())).start();
    }

    private void r8() {
        float fZ7 = this.e5 != 1.0f ? ((Z7() - this.i4.E()) / 2.0f) * this.e5 : 0.0f;
        this.S5 = 1;
        f7(this.e5, ((this.E5 - Z7()) - fZ7) - (AbstractC21455b.F(30.0f) / 2), this.d5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r9(View view) {
        if (this.K1.getTag() != null) {
            return;
        }
        if (this.n1) {
            if (!this.R6) {
                return;
            }
            TextureView textureView = this.h2;
            if (!(textureView instanceof VideoEditTextureView)) {
                return;
            }
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                return;
            }
        }
        rb(3);
    }

    private boolean s7() {
        if (this.S3 != 0 && Math.abs(this.T3 - System.currentTimeMillis()) >= 500) {
            Runnable runnable = this.U3;
            if (runnable != null) {
                runnable.run();
                this.U3 = null;
            }
            this.S3 = 0;
        }
        return this.S3 != 0;
    }

    private void s8() {
        float fZ7 = this.e5 != 1.0f ? ((Z7() - this.i4.E()) / 2.0f) * this.e5 : 0.0f;
        this.S5 = 2;
        f7(this.e5, this.F5 + Z7() + fZ7 + (AbstractC21455b.F(30.0f) / 2), this.d5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s9(View view) throws IOException {
        if (this.K1.getTag() != null) {
            return;
        }
        this.f = !this.f;
        Jb();
        Nb();
        if (this.f && !this.P0.g()) {
            this.P0.callOnClick();
            return;
        }
        Object obj = this.h6.get(this.p4);
        if (obj instanceof MediaController.l) {
            ((MediaController.l) obj).m = c8();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa() {
        FT7 ft7 = this.j2;
        if (ft7 != null) {
            ft7.D1();
        } else {
            this.A.P();
        }
    }

    private void sb(int i, boolean z) throws InterruptedException, Resources.NotFoundException {
        if (this.r4 != null) {
            Aa(false);
            C4278El2.H(this.v).j(this.r4.I());
        } else if (this.B4 != null) {
            throw null;
        }
        GroupedPhotosListView groupedPhotosListView = this.g1;
        if (groupedPhotosListView != null) {
            groupedPhotosListView.setAnimateBackground(true);
        }
        this.B2 = false;
        Sa(this.p4 + i, z, true);
        if (ib(this.r4) || hb(this.p4)) {
            this.B2 = true;
            ca(true);
            w7(0, false, true);
        }
        u7();
    }

    private void t7(float f) {
        C10743c74 c10743c74;
        if (!this.s3 || this.m == null || this.J2 || this.j2 == null || (c10743c74 = this.r4) == null || c10743c74.I() == null) {
            return;
        }
        this.r4.M();
    }

    private boolean t8() {
        return U7(true) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t9(View view) {
        if (this.b == null || this.K1.getTag() != null) {
            return;
        }
        this.b.needAddMorePhotos();
        z7(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta(boolean z) {
        RLottieDrawable rLottieDrawableJ;
        ArrayList arrayList = this.t4.e;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                H.b bVar = (H.b) this.t4.e.get(i);
                if (bVar.a == 0 && (bVar.b & 1) != 0) {
                    View view = bVar.C;
                    if ((view instanceof BackupImageView) && (rLottieDrawableJ = ((BackupImageView) view).getImageReceiver().J()) != null) {
                        if (z) {
                            rLottieDrawableJ.start();
                        } else {
                            rLottieDrawableJ.stop();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        Z9();
        this.s5 = null;
        this.m6.d().setVisibility(8);
        this.R0.setVisibility(8);
        this.S0.setVisibility(8);
        this.z0.setVisibility(8);
        this.b1.setVisibility(8);
        this.e1.setVisibility(8);
        PhotoCropView photoCropView = this.y1;
        if (photoCropView != null) {
            photoCropView.setVisibility(4);
        }
        this.j1.setVisibility(8);
        this.j1.setAlpha(0.0f);
        this.j1.setTranslationY(-AbstractC21455b.F(10.0f));
        this.Q0.setRotationX(0.0f);
        this.j1.setEnabled(false);
        this.q = false;
        if (this.O1) {
            this.H1.setVisibility(4);
        }
        int i = this.L1;
        if (i == 0 || i == 4 || (((i == 2 || i == 5) && this.h6.size() > 1) || this.L1 == 99)) {
            this.P0.setVisibility(8);
            this.Q0.setVisibility(8);
            Db();
        }
        if (this.i4.l() != null) {
            int iO = this.i4.o();
            int iM = this.i4.m();
            if (this.L1 == 1) {
                float F2 = AbstractC21455b.F(12.0f);
                this.i5 = F2;
                if (this.F1 != null) {
                    this.i5 = F2 + (r13.getAdditionalTop() / 2.0f);
                }
                if (this.z1.i() == 90 || this.z1.i() == 270) {
                    iM = iO;
                    iO = iM;
                }
            } else {
                float f = (-AbstractC21455b.F(44.0f)) + (A8() ? AbstractC21455b.d / 2 : 0);
                this.i5 = f;
                if (this.F1 != null) {
                    float additionalTop = f + (r13.getAdditionalTop() / 2.0f);
                    this.i5 = additionalTop;
                    this.i5 = additionalTop - (this.F1.getAdditionalBottom() / 2.0f);
                }
                MediaController.i iVar = this.t4.c;
                if (iVar != null) {
                    int i2 = iVar.i;
                    if (i2 == 90 || i2 == 270) {
                        iM = iO;
                        iO = iM;
                    }
                    iO = (int) (iO * iVar.e);
                    iM = (int) (iM * iVar.f);
                }
            }
            float f2 = iO;
            float f3 = iM;
            this.j5 = Math.min(a8(3) / f2, X7(3) / f3) / Math.min(Z7() / f2, W7() / f3);
            this.h5 = (l8() / 2) - (m8() / 2);
            this.p5 = System.currentTimeMillis();
            this.Q5 = true;
        }
        this.B.setClipChildren(true);
        this.H.setVisibility(4);
        this.r5 = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(AbstractC21455b.F(126.0f), 0.0f);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(-AbstractC21455b.F(12.0f), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.jb5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.U9(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.kb5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.V9(valueAnimator);
            }
        });
        this.r5.playTogether(ObjectAnimator.ofFloat(this, (Property<PhotoViewer, Float>) AbstractC21469h.d, 0.0f, 1.0f), valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.F1.m(true);
        this.r5.setDuration(200L);
        this.r5.addListener(new U());
        this.r5.start();
    }

    private void u8() {
        boolean[] zArr = this.s1;
        zArr[1] = false;
        zArr[0] = false;
        this.z.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u9(View view) {
        if (this.K1.getTag() != null) {
            return;
        }
        if (this.n1) {
            if (!this.R6) {
                return;
            }
            TextureView textureView = this.h2;
            if (!(textureView instanceof VideoEditTextureView)) {
                return;
            }
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                return;
            }
        }
        rb(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua() {
        FT7 ft7 = this.j2;
        if (ft7 != null) {
            ft7.E1();
        } else {
            this.A.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(boolean z) {
        U00.f(this.n, "switchToPip");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[PHI: r3
      0x0022: PHI (r3v4 float) = (r3v2 float), (r3v3 float) binds: [B:9:0x0020, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011 A[PHI: r3
      0x0011: PHI (r3v5 float) = (r3v0 float), (r3v1 float) binds: [B:3:0x000f, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void v7(boolean r6) {
        /*
            r5 = this;
            float r0 = r5.c5
            float r1 = r5.d5
            float r2 = r5.e5
            r5.Ib(r2)
            float r2 = r5.c5
            float r3 = r5.E5
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L13
        L11:
            r0 = r3
            goto L1a
        L13:
            float r3 = r5.F5
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L1a
            goto L11
        L1a:
            float r2 = r5.d5
            float r3 = r5.G5
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
        L22:
            r1 = r3
            goto L2b
        L24:
            float r3 = r5.H5
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L2b
            goto L22
        L2b:
            float r2 = r5.e5
            r5.f7(r2, r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.v7(boolean):void");
    }

    private void v8() {
        PhotoCropView photoCropView = this.y1;
        if (photoCropView == null) {
            return;
        }
        photoCropView.setBitmap(null, 0, false, false, null, null, null, null);
        if (this.L1 != 1) {
            return;
        }
        this.y1.m();
        this.y1.setVisibility(0);
        this.y1.setAlpha(1.0f);
        this.y1.n();
        this.Y1 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v9(Activity activity, View view) {
        if (this.K1.getTag() != null || this.f) {
            return;
        }
        if (this.f1.getTag() != null) {
            lb(true);
            Ca(1);
        } else if (this.R6) {
            if (this.h1 == null) {
                this.h1 = new Tooltip(activity, this.z, -871296751, -1);
            }
            this.h1.setText(FH3.E("VideoQualityIsTooLow", TD5.tgwidget_VideoQualityIsTooLow));
            this.h1.u(this.f1);
        }
    }

    private void va(Uri uri, boolean z, boolean z2) {
        wa(uri, z, z2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(boolean z, boolean z2) {
        wb(z, z2, q0.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w7(final int i, boolean z, final boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        final File file;
        File file2;
        C10743c74 c10743c74;
        C4278El2.a aVar;
        AnimatedFileDrawable animatedFileDrawable;
        int i2 = this.p4;
        int i3 = i == 1 ? i2 + 1 : i == 2 ? i2 - 1 : i2;
        boolean z6 = false;
        if (this.w4[i] == null) {
            if (!this.h6.isEmpty() && i3 >= 0 && i3 < this.h6.size()) {
                Object obj = this.h6.get(i3);
                if (obj instanceof MediaController.m) {
                    z6 = ((MediaController.m) obj).D;
                }
            }
            if (z6) {
                this.V0[i].o(3, z2, true);
                return;
            } else {
                this.V0[i].o(-1, z2, true);
                return;
            }
        }
        boolean zH0 = (i == 0 && i2 == 0 && (animatedFileDrawable = this.P1) != null) ? animatedFileDrawable.H0() : false;
        C4278El2.a aVar2 = null;
        if (this.r4 == null) {
            if (this.u4 != null) {
                if (i3 < 0 || i3 >= this.d6.size()) {
                    this.V0[i].o(-1, z2, true);
                    return;
                }
                C24687z23 c24687z23 = (C24687z23) this.d6.get(i3);
                File fileO = C4278El2.H(this.v).O(c24687z23.f, h8(c24687z23), false);
                file = C4278El2.H(this.v).O(c24687z23.f, h8(c24687z23), true);
                file2 = fileO;
            } else if (this.y4 != null) {
                file2 = new File(C4278El2.B(3), this.w4[i]);
                file = new File(C4278El2.B(4), this.w4[i]);
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
                file = null;
                file2 = null;
                c10743c74 = null;
            }
            z3 = false;
            z4 = false;
            z5 = false;
            c10743c74 = null;
        } else {
            if (i3 < 0 || i3 >= this.a6.size()) {
                this.V0[i].o(-1, z2, true);
                return;
            }
            C10743c74 c10743c742 = (C10743c74) this.a6.get(i3);
            boolean zIb = ib(c10743c742);
            if (this.J4 == 1 && !c10743c742.k()) {
                this.V0[i].o(-1, z2, true);
                return;
            }
            file2 = !TextUtils.isEmpty(c10743c742.e.M) ? new File(c10743c742.e.M) : null;
            if ((C10743c74.W(c10743c742.e) instanceof C5153Ic7) && C10743c74.W(c10743c742.e).B != null && C10743c74.W(c10743c742.e).B.r == null) {
                final AbstractC12724f57 abstractC12724f57F8 = f8(i3, null);
                aVar = new C4278El2.a() { // from class: ir.nasim.ob5
                    @Override // ir.nasim.C4278El2.a
                    public final File a() {
                        return this.a.E8(abstractC12724f57F8);
                    }
                };
            } else {
                final L57 l57 = c10743c742.e;
                aVar = new C4278El2.a() { // from class: ir.nasim.pb5
                    @Override // ir.nasim.C4278El2.a
                    public final File a() {
                        return this.a.F8(l57);
                    }
                };
            }
            if (c10743c742.c1()) {
                z5 = true;
                z4 = AbstractC8662Wx6.a0 && c10743c742.m() && !ZO1.c(c10743c742.F());
            } else {
                z4 = false;
                z5 = false;
            }
            C4278El2.a aVar3 = aVar;
            c10743c74 = c10743c742;
            z3 = zIb;
            file = null;
            aVar2 = aVar3;
        }
        final boolean z7 = zH0;
        final File file3 = file2;
        final C4278El2.a aVar4 = aVar2;
        final C10743c74 c10743c743 = c10743c74;
        final boolean z8 = z4;
        final boolean z9 = z5;
        final boolean z10 = !(i == 0 && this.E4) && z3;
        Utilities.e.i(new Runnable() { // from class: ir.nasim.qb5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.H8(z7, file3, file, aVar4, i, c10743c743, z8, z9, z10, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w8(int i) {
        if (this.Z3) {
            C21482f0 c21482f0 = new C21482f0(this, this.m, this.I0);
            this.A = c21482f0;
            c21482f0.G(i, C10743c74.W(this.r4.e).B);
            this.A.setPlaybackSpeed(this.p1);
            this.z.addView(this.A, 0, AbstractC13840gu3.b(-1, -1.0f));
            if (this.A.H()) {
                gb(true, true);
            }
            this.U2.c();
            Ob();
            this.E2 = null;
            this.F2 = null;
            this.H2 = 0L;
            this.D2 = this.I2;
            this.U2.s(0.0f);
            this.y6.setProgress(0.0f);
            this.U2.n(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w9(View view) {
        U00.e(this.m);
    }

    private void wa(Uri uri, boolean z, boolean z2, MediaController.n nVar) {
        boolean z3;
        if (!z2) {
            this.s4 = uri;
        }
        if (this.m == null) {
            return;
        }
        this.J2 = false;
        this.K2 = SystemClock.elapsedRealtime();
        this.A4 = false;
        this.u3 = 0L;
        this.t3 = true;
        this.i7 = z2;
        Aa(false);
        G0 g0 = null;
        if (this.h6.isEmpty()) {
            F7(null);
        }
        if (this.b3 == null) {
            ImageView imageView = new ImageView(this.m);
            this.b3 = imageView;
            imageView.setBackgroundColor(-65536);
            this.b3.setPivotX(0.0f);
            this.b3.setPivotY(0.0f);
            this.b3.setVisibility(4);
            this.z.addView(this.b3);
        }
        u7();
        if (this.x3 == null) {
            J j = new J(AbstractC14047hG.a);
            this.x3 = j;
            if (j.canDetectOrientation()) {
                this.x3.enable();
            } else {
                this.x3.disable();
                this.x3 = null;
            }
        }
        this.j3 = false;
        this.k3 = false;
        this.o3 = false;
        this.z2 = false;
        this.A2 = false;
        this.D6 = -1L;
        this.C6 = -1L;
        this.E6 = -1L;
        if (this.j2 == null) {
            FT7 ft7 = this.v2;
            if (ft7 != null) {
                this.j2 = ft7;
                this.v2 = null;
                this.x2 = true;
                Kb(ft7.w1(), this.j2.x1());
                z3 = false;
            } else {
                this.j2 = new K();
                z3 = true;
            }
            TextureView textureView = this.h2;
            if (textureView != null) {
                this.j2.R1(textureView);
            }
            v0 v0Var = this.i2;
            if (v0Var != null) {
                v0Var.e();
            }
            this.j2.K1(new L());
        } else {
            z3 = false;
        }
        if (!this.h6.isEmpty()) {
            F7(nVar);
        }
        TextureView textureView2 = this.h2;
        this.p3 = 0.0f;
        textureView2.setAlpha(0.0f);
        PaintingOverlay paintingOverlay = this.e4;
        if (paintingOverlay != null) {
            paintingOverlay.setAlpha(this.p3);
        }
        this.E2 = null;
        this.F2 = null;
        this.H2 = 0L;
        if (z3) {
            this.D2 = this.I2;
            this.U2.s(0.0f);
            this.y6.setProgress(0.0f);
            this.U2.n(0.0f);
            C10743c74 c10743c74 = this.r4;
            if (c10743c74 != null) {
                int iM = (int) c10743c74.M();
                String strN = this.r4.N();
                if (!TextUtils.isEmpty(strN)) {
                    if (iM >= 600) {
                        if (this.r4.t < 0.0f) {
                            float f = AbstractC14047hG.a.getSharedPreferences("media_saved_pos", 0).getFloat(strN, -1.0f);
                            if (f > 0.0f && f < 0.999f) {
                                this.r4.t = f;
                                this.U2.s(f);
                            }
                        }
                        this.E2 = strN;
                    } else if (iM >= 10) {
                        for (int size = this.G2.size() - 1; size >= 0; size--) {
                            G0 g02 = (G0) this.G2.k(size);
                            if (g02.b < SystemClock.elapsedRealtime() - 5000) {
                                this.G2.i(size);
                            } else if (g0 == null && ((String) this.G2.g(size)).equals(strN)) {
                                g0 = g02;
                            }
                        }
                        C10743c74 c10743c742 = this.r4;
                        if (c10743c742 != null && c10743c742.t < 0.0f && g0 != null) {
                            float f2 = g0.a;
                            if (f2 > 0.0f && f2 < 0.999f) {
                                c10743c742.t = f2;
                                this.U2.s(f2);
                            }
                        }
                        this.F2 = strN;
                    }
                }
            }
            this.j2.F1(uri, "other");
            this.j2.N1(z);
        }
        C10743c74 c10743c743 = this.r4;
        boolean z4 = c10743c743 != null && c10743c743.M() <= 30.0d;
        this.C2 = z4;
        this.M2.h(z4);
        this.j2.L1(this.C2);
        C10743c74 c10743c744 = this.r4;
        if (c10743c744 != null) {
            float f3 = c10743c744.t;
            if (f3 >= 0.0f) {
                this.D2 = f3;
                c10743c744.t = -1.0f;
            }
        }
        this.G.setPadding(0, 0, 0, 0);
        gb(!this.n1, true);
        if (!this.n1) {
            Fa(this.B2 ? 3000 : AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
        if (this.r4 != null) {
            this.j2.O1(this.p1);
        }
        this.i7 = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb(boolean z, boolean z2, q0 q0Var) {
        r0 r0Var;
        r0 r0Var2;
        if (this.a4 == 0) {
            int i = this.q5;
            if (i == 0 || i == -1) {
                AnimatorSet animatorSet = this.r;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                if (z) {
                    this.o.setVisibility(0);
                    if (this.G.getTag() != null) {
                        this.G.setVisibility(0);
                    }
                    if (this.H1.getTag() != null) {
                        this.H1.setVisibility(0);
                        VideoSeekPreviewImage videoSeekPreviewImage = this.W2;
                        if (videoSeekPreviewImage != null) {
                            videoSeekPreviewImage.requestLayout();
                        }
                    }
                }
                this.p = z;
                PhotoViewerWebView photoViewerWebView = this.A;
                if (photoViewerWebView != null) {
                    photoViewerWebView.setTouchDisabled(z);
                }
                if (q0Var.c) {
                    Hb(z);
                }
                if (this.P2 && this.r3 && z) {
                    Ea();
                } else {
                    AbstractC21455b.t(this.d2);
                }
                if (!z) {
                    Bulletin.f(this.z);
                }
                float fH = AbstractC21455b.H(24.0f);
                this.M2.h(q0Var.d && this.C2);
                this.M2.i(q0Var.d);
                if (!z2) {
                    this.o.setAlpha(z ? 1.0f : 0.0f);
                    if (this.c3[0].getTranslationX() != 0.0f && this.d3) {
                        this.c3[0].setAlpha(z ? 1.0f : 0.0f);
                    }
                    for (int i2 = 0; i2 < 3; i2++) {
                        this.c3[i2].setTranslationY(z ? 0.0f : fH);
                    }
                    this.o.setTranslationY(z ? 0.0f : -fH);
                    z0 z0Var = this.t;
                    if (z0Var != null) {
                        z0Var.setAlpha(z ? 1.0f : 0.0f);
                        this.t.setTranslationY(z ? 0.0f : -fH);
                    }
                    this.G.setAlpha(z ? 1.0f : 0.0f);
                    this.G.setTranslationY(z ? 0.0f : fH);
                    this.H.setAlpha(z ? 1.0f : 0.0f);
                    this.g1.setAlpha((!z || this.r6 == 3) ? 0.0f : 1.0f);
                    this.g1.setTranslationY((!z || this.r6 == 3) ? fH : 0.0f);
                    if (!this.O1 && (r0Var = this.I1) != null) {
                        r0Var.setAlpha(z ? 1.0f : 0.0f);
                        r0 r0Var3 = this.I1;
                        if (z) {
                            fH = 0.0f;
                        }
                        r0Var3.setTranslationY(fH);
                    }
                    this.M2.g(z ? 1.0f : 0.0f);
                    if (this.e1.getTag() != null) {
                        this.e1.setAlpha(z ? 1.0f : 0.0f);
                    }
                    if (this.P2 && this.r3) {
                        this.V0[0].p(1, z ? 1.0f : 0.0f, false);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ActionBar actionBar = this.o;
                Property property = View.ALPHA;
                arrayList.add(ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, z ? 1.0f : 0.0f));
                if (q0Var.d) {
                    arrayList.add(ObjectAnimator.ofFloat(this.o, (Property<ActionBar, Float>) View.TRANSLATION_Y, z ? 0.0f : -fH));
                } else {
                    this.o.setTranslationY(0.0f);
                }
                if (this.d3) {
                    arrayList.add(ObjectAnimator.ofFloat(this.c3[0], (Property<ImageView, Float>) property, z ? 1.0f : 0.0f));
                }
                for (int i3 = 1; i3 < 3; i3++) {
                    this.c3[i3].setTranslationY(z ? 0.0f : fH);
                }
                if (q0Var.d) {
                    arrayList.add(ObjectAnimator.ofFloat(this.c3[0], (Property<ImageView, Float>) View.TRANSLATION_Y, z ? 0.0f : fH));
                } else {
                    this.c3[0].setTranslationY(0.0f);
                }
                FrameLayout frameLayout = this.G;
                if (frameLayout != null) {
                    arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) View.ALPHA, z ? 1.0f : 0.0f));
                    if (q0Var.d) {
                        arrayList.add(ObjectAnimator.ofFloat(this.G, (Property<FrameLayout, Float>) View.TRANSLATION_Y, z ? 0.0f : fH));
                    } else {
                        this.G.setTranslationY(0.0f);
                    }
                }
                z0 z0Var2 = this.t;
                if (z0Var2 != null) {
                    arrayList.add(ObjectAnimator.ofFloat(z0Var2, (Property<z0, Float>) View.ALPHA, z ? 1.0f : 0.0f));
                    if (q0Var.d) {
                        arrayList.add(ObjectAnimator.ofFloat(this.t, (Property<z0, Float>) View.TRANSLATION_Y, z ? 0.0f : -fH));
                    } else {
                        this.t.setTranslationY(0.0f);
                    }
                }
                View view = this.H;
                if (view != null) {
                    arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, z ? 1.0f : 0.0f));
                }
                if (this.P2) {
                    arrayList.add(ObjectAnimator.ofFloat(this.M2, (Property<I0, Float>) o7, z ? 1.0f : 0.0f));
                } else {
                    this.M2.g(z ? 1.0f : 0.0f);
                }
                GroupedPhotosListView groupedPhotosListView = this.g1;
                Property property2 = View.ALPHA;
                arrayList.add(ObjectAnimator.ofFloat(groupedPhotosListView, (Property<GroupedPhotosListView, Float>) property2, z ? 1.0f : 0.0f));
                if (q0Var.d) {
                    arrayList.add(ObjectAnimator.ofFloat(this.g1, (Property<GroupedPhotosListView, Float>) View.TRANSLATION_Y, z ? 0.0f : fH));
                } else {
                    this.g1.setTranslationY(0.0f);
                }
                if (!this.O1 && (r0Var2 = this.I1) != null) {
                    arrayList.add(ObjectAnimator.ofFloat(r0Var2, (Property<r0, Float>) property2, z ? 1.0f : 0.0f));
                    if (q0Var.d) {
                        r0 r0Var4 = this.I1;
                        Property property3 = View.TRANSLATION_Y;
                        if (z) {
                            fH = 0.0f;
                        }
                        arrayList.add(ObjectAnimator.ofFloat(r0Var4, (Property<r0, Float>) property3, fH));
                    } else {
                        this.I1.setTranslationY(0.0f);
                    }
                }
                if (this.P2 && this.r3) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.V0[0].m[1], z ? 1.0f : 0.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Wa5
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.a.W9(valueAnimator);
                        }
                    });
                    arrayList.add(valueAnimatorOfFloat);
                }
                if (this.e1.getTag() != null) {
                    arrayList.add(ObjectAnimator.ofFloat(this.e1, (Property<ImageView, Float>) property2, z ? 1.0f : 0.0f));
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.r = animatorSet2;
                animatorSet2.playTogether(arrayList);
                this.r.setDuration(q0Var.a);
                this.r.setInterpolator(q0Var.b);
                this.r.addListener(new W(z));
                this.r.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x9() {
        this.z1.p(this.m2, this.n2, this.o2, this.s2, this.u2, this.r2, 1.0f, 1.0f, this.p2, this.q2, 0.0f, 0.0f, this.t2);
        rb(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() throws IOException {
        if (this.N6 == 0 || this.L1 == 1) {
            return;
        }
        RD6 rd6L7 = l7();
        if (rd6L7.b() == this.J6 && rd6L7.a() == this.K6) {
            MediaController.W(rd6L7.b(), rd6L7.a(), this.O6, false);
        } else {
            MediaController.W(rd6L7.b(), rd6L7.a(), MediaController.y0(this.K6, this.J6, this.O6, rd6L7.a(), rd6L7.b()), false);
        }
    }

    private void xb(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        float fH = AbstractC21455b.H(24.0f);
        ViewGroup viewGroupD = this.m6.d();
        Property property = View.ALPHA;
        arrayList.add(ObjectAnimator.ofFloat(viewGroupD, (Property<ViewGroup, Float>) property, z ? 1.0f : 0.0f));
        ViewGroup viewGroupD2 = this.m6.d();
        Property property2 = View.TRANSLATION_Y;
        arrayList.add(ObjectAnimator.ofFloat(viewGroupD2, (Property<ViewGroup, Float>) property2, z ? 0.0f : fH));
        arrayList.add(ObjectAnimator.ofFloat(this.R0, (Property<FrameLayout, Float>) property, z ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.R0, (Property<FrameLayout, Float>) property2, z ? 0.0f : fH));
        arrayList.add(ObjectAnimator.ofFloat(this.S0, (Property<ImageView, Float>) property, z ? 1.0f : 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.S0, (Property<ImageView, Float>) property2, z ? 0.0f : fH));
        int i = this.L1;
        if (i == 0 || i == 4) {
            arrayList.add(ObjectAnimator.ofFloat(this.P0, (Property<CheckBox, Float>) property, z ? 1.0f : 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.P0, (Property<CheckBox, Float>) property2, z ? 0.0f : -fH));
            arrayList.add(ObjectAnimator.ofFloat(this.Q0, (Property<CounterView, Float>) property, z ? 1.0f : 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.Q0, (Property<CounterView, Float>) property2, z ? 0.0f : -fH));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    static /* bridge */ /* synthetic */ y0 y2(PhotoViewer photoViewer) {
        photoViewer.getClass();
        return null;
    }

    private void y7() {
        this.F1.o(this, this.m, new Runnable() { // from class: ir.nasim.Ga5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.I8();
            }
        });
    }

    private boolean y8() {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.n.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                return accessibilityManager.isTouchExplorationEnabled();
            }
            return false;
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y9(View view) {
        if (this.r5 != null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.nasim.Ra5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x9();
            }
        };
        if (this.m2) {
            runnable.run();
            return;
        }
        float stateOrientation = this.u2 - this.y1.c.getStateOrientation();
        if (Math.abs(stateOrientation) > 180.0f) {
            stateOrientation = stateOrientation < 0.0f ? stateOrientation + 360.0f : -(360.0f - stateOrientation);
        }
        I7(stateOrientation, this.y1.c.getStateMirror(), runnable);
    }

    private void ya(String str, boolean z, float f, float f2, int i) throws InterruptedException {
        if (this.e7 != null) {
            Utilities.e.b(this.e7);
            this.e7 = null;
        }
        this.y6.setVideoPath(str, f, f2);
        this.f7 = null;
        boolean z2 = true;
        if (!z && this.L1 != 1) {
            z2 = false;
        }
        this.f = z2;
        this.G6 = -1;
        this.I6 = 0;
        this.Q6 = 25;
        this.b7 = new File(str).length();
        HU1 hu1 = Utilities.e;
        o0 o0Var = new o0(str, i);
        this.e7 = o0Var;
        hu1.i(o0Var);
    }

    private void yb(boolean z, boolean z2) {
        AbstractC21455b.t(this.l);
        if (!z2) {
            AnimatorSet animatorSet = this.k;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.k = null;
            }
            this.W0.setAlpha(z ? 1.0f : 0.0f);
            this.W0.setVisibility(z ? 0 : 4);
            return;
        }
        zb(z);
        if (!z) {
            AnimatorSet animatorSet2 = this.k;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                zb(false);
                return;
            }
            return;
        }
        AnimatorSet animatorSet3 = this.k;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
            this.k = null;
        }
        if (!this.t3) {
            AbstractC21455b.n1(this.l, 500L);
        } else {
            this.t3 = false;
            zb(true);
        }
    }

    private boolean z8() {
        int i;
        if (this.i6 != null && (i = this.p4) >= 0 && i < this.g6.size()) {
            AbstractC10736c67 abstractC10736c67 = (AbstractC10736c67) this.g6.get(this.p4);
            C24687z23 c24687z23 = (C24687z23) this.c6.get(this.p4);
            if (abstractC10736c67 instanceof C7083Qe7) {
                abstractC10736c67 = null;
            }
            if (abstractC10736c67 != null) {
                int size = abstractC10736c67.h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AbstractC20488s57 abstractC20488s57 = ((AbstractC11500d67) abstractC10736c67.h.get(i2)).c;
                    if (abstractC20488s57 != null) {
                        int i3 = abstractC20488s57.d;
                        C18727p87 c18727p87 = this.i6.f;
                        if (i3 == c18727p87.d && abstractC20488s57.c == c18727p87.c) {
                            return true;
                        }
                    }
                }
            } else {
                C18727p87 c18727p872 = c24687z23.f;
                int i4 = c18727p872.d;
                C18727p87 c18727p873 = this.i6.f;
                if (i4 == c18727p873.d && c18727p872.c == c18727p873.c) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z9(View view) throws InterruptedException, FileNotFoundException {
        if (this.a4 != 1 || this.y1.j()) {
            i7();
            rb(0);
        }
    }

    private void zb(boolean z) {
        if (z) {
            this.W0.setVisibility(0);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.k = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.W0, (Property<RadialProgressView, Float>) View.ALPHA, z ? 1.0f : 0.0f));
        this.k.setDuration(200L);
        this.k.addListener(new V(z));
        this.k.start();
    }

    public boolean C8() {
        return this.c && this.b != null;
    }

    public void Fb() {
        int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4;
        int iN8 = n8(i);
        ImageView imageView = this.S0;
        if (imageView != null) {
            Drawable background = imageView.getBackground();
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.g1(background, iN8, false);
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.g1(background, n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.G4), true);
            this.S0.setColorFilter(new PorterDuffColorFilter(n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.H4), PorterDuff.Mode.MULTIPLY));
        }
        CheckBox checkBox = this.P0;
        if (checkBox != null) {
            checkBox.setColor(n8(i), -1);
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(iN8, PorterDuff.Mode.MULTIPLY);
        ImageView imageView2 = this.d1;
        if (imageView2 != null && imageView2.getColorFilter() != null) {
            this.d1.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView3 = this.X0;
        if (imageView3 != null && imageView3.getColorFilter() != null) {
            this.X0.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView4 = this.Y0;
        if (imageView4 != null && imageView4.getColorFilter() != null) {
            this.Y0.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView5 = this.c1;
        if (imageView5 != null && imageView5.getColorFilter() != null) {
            this.c1.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView6 = this.a1;
        if (imageView6 != null && imageView6.getColorFilter() != null) {
            this.a1.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView7 = this.Z0;
        if (imageView7 != null && imageView7.getColorFilter() != null) {
            this.Z0.setColorFilter(porterDuffColorFilter);
        }
        PickerBottomLayoutViewer pickerBottomLayoutViewer = this.T0;
        if (pickerBottomLayoutViewer != null) {
            pickerBottomLayoutViewer.b.setTextColor(iN8);
        }
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = this.w6;
        if (pickerBottomLayoutViewer2 != null) {
            pickerBottomLayoutViewer2.b.setTextColor(iN8);
        }
        YZ2 yz2 = this.F1;
        if (yz2 != null) {
            yz2.B();
        }
        PhotoFilterView photoFilterView = this.E1;
        if (photoFilterView != null) {
            photoFilterView.B0();
        }
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.K1;
        if (photoViewerCaptionEnterView != null) {
            photoViewerCaptionEnterView.d0();
        }
        VideoTimelinePlayView videoTimelinePlayView = this.y6;
        if (videoTimelinePlayView != null) {
            videoTimelinePlayView.invalidate();
        }
        H0 h0 = this.j1;
        if (h0 != null) {
            int childCount = h0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.j1.getChildAt(i2);
                if (childAt instanceof PhotoPickerPhotoCell) {
                    ((PhotoPickerPhotoCell) childAt).a();
                }
            }
        }
    }

    public void J7() {
        if (this.m == null || this.B == null) {
            return;
        }
        if (ir.nasim.tgwidgets.editor.ui.Components.w.J0()) {
            ir.nasim.tgwidgets.editor.ui.Components.w.w0();
        }
        Ba();
        Aa(false);
        try {
            if (this.B.getParent() != null) {
                ((WindowManager) this.m.getSystemService("window")).removeViewImmediate(this.B);
                ea();
            }
            this.B = null;
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        ImageReceiver.b bVar = this.C4;
        if (bVar != null) {
            bVar.d();
            this.C4 = null;
        }
        this.D.setImageBitmap(null);
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.K1;
        if (photoViewerCaptionEnterView != null) {
            photoViewerCaptionEnterView.X();
        }
        if (this == q7) {
            q7 = null;
        } else {
            p7 = null;
        }
        ea();
    }

    public void Jb() {
        FT7 ft7 = this.j2;
        if (ft7 != null) {
            ft7.M1(this.f);
        }
        if (!this.R6) {
            this.e1.setEnabled(false);
            this.e1.setClickable(false);
            this.e1.animate().alpha(0.5f).setDuration(180L).start();
            this.y6.setMode(0);
            return;
        }
        this.e1.setEnabled(true);
        this.e1.setClickable(true);
        this.e1.animate().alpha(1.0f).setDuration(180L).start();
        if (!this.f) {
            this.s.g(this.k7);
            this.e1.setImageResource(AbstractC23598xB5.video_send_unmute);
            this.e1.setContentDescription(FH3.E("Sound", TD5.tgwidget_Sound));
            if (this.f1.getTag() != null) {
                this.f1.setAlpha(1.0f);
                this.f1.setEnabled(true);
            }
            this.y6.setMaxProgressDiff(1.0f);
            this.y6.setMode(0);
            return;
        }
        if (this.H3 == null) {
            this.s.g(FH3.E("SoundMuted", TD5.tgwidget_SoundMuted));
        }
        this.e1.setImageResource(AbstractC23598xB5.video_send_mute);
        if (this.f1.getTag() != null) {
            this.f1.setAlpha(0.5f);
            this.f1.setEnabled(false);
        }
        if (this.L1 == 1) {
            this.y6.setMaxProgressDiff(9600.0f / this.P6);
            this.y6.setMode(1);
            Nb();
        } else {
            this.y6.setMaxProgressDiff(1.0f);
            this.y6.setMode(0);
        }
        this.e1.setContentDescription(FH3.E("NoSound", TD5.tgwidget_NoSound));
    }

    public void Q7() {
        U00.f(this.n, "exitFromPip");
    }

    public void Qb(boolean z, int i) {
        Kb(z, i);
    }

    public void Tb() {
        f7(1.0f, 0.0f, 0.0f, false);
    }

    public void Wa(ir.nasim.tgwidgets.editor.ui.O o) {
        this.m6 = o;
        j7();
        o.f(new C21471a(o));
    }

    @Override // ir.nasim.C13450gF2.c
    public void a(MotionEvent motionEvent) {
        u8();
    }

    @Override // ir.nasim.C13450gF2.b
    public boolean b(MotionEvent motionEvent) {
        C10743c74 c10743c74;
        PhotoViewerWebView photoViewerWebView;
        if (this.P0.getVisibility() == 0) {
            return true;
        }
        boolean[] zArr = this.s1;
        if (zArr[0] || zArr[1]) {
            return true;
        }
        float x = motionEvent.getX();
        if ((x < Math.min(135, this.z.getMeasuredWidth() / 8) || x > this.z.getMeasuredWidth() - r3) && (c10743c74 = this.r4) != null) {
            return (c10743c74.c1() || ((photoViewerWebView = this.A) != null && photoViewerWebView.H())) && SystemClock.elapsedRealtime() - this.q1 >= 500 && m7(motionEvent);
        }
        return true;
    }

    public void bb(Activity activity) {
        cb(activity, null, null);
    }

    public void cb(final Activity activity, ir.nasim.tgwidgets.editor.ui.ActionBar.c cVar, m.h hVar) {
        activity.getClass();
        ir.nasim.tgwidgets.editor.ui.ActionBar.m.J(activity, false);
        this.b2 = hVar;
        int i = C22477vI7.f;
        this.v = i;
        this.i4.F0(i);
        this.h4.F0(this.v);
        this.j4.F0(this.v);
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.K1;
        if (photoViewerCaptionEnterView != null) {
            photoViewerCaptionEnterView.H = C22477vI7.f;
        }
        if (this.m == activity) {
            Fb();
            return;
        }
        this.g = false;
        this.m = activity;
        this.n = activity;
        this.u1 = ViewConfiguration.get(activity).getScaledTouchSlop();
        if (l7 == null) {
            l7 = new Drawable[]{AbstractC4043Dl1.f(this.m, AbstractC23598xB5.circle_big), AbstractC4043Dl1.f(this.m, AbstractC23598xB5.cancel_big), AbstractC4043Dl1.f(this.m, AbstractC23598xB5.load_big)};
        }
        this.U5 = new Scroller(activity);
        C21473b c21473b = new C21473b(activity);
        this.B = c21473b;
        c21473b.setBackgroundDrawable(this.N0);
        this.B.setFocusable(false);
        ClippingImageView clippingImageView = new ClippingImageView(activity);
        this.D = clippingImageView;
        clippingImageView.setAnimationValues(this.L3);
        this.B.addView(this.D, AbstractC13840gu3.b(40, 40.0f));
        C21475c c21475c = new C21475c(activity, activity);
        this.z = c21475c;
        c21475c.setFocusable(false);
        this.z.setClipChildren(true);
        this.z.setClipToPadding(true);
        this.B.setClipChildren(false);
        this.B.setClipToPadding(false);
        this.B.addView(this.z, AbstractC13840gu3.d(-1, -1, 51));
        int i2 = Build.VERSION.SDK_INT;
        this.z.setFitsSystemWindows(true);
        this.z.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.nasim.Y95
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.a.G9(view, windowInsets);
            }
        });
        this.z.setSystemUiVisibility(1792);
        AbstractC12990fW7.E0(this.B, new InterfaceC22474vI4() { // from class: ir.nasim.ka5
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return this.a.H9(view, o98);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.y = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 51;
        layoutParams.type = 99;
        if (i2 >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        this.y.flags = -2147286784;
        PaintingOverlay paintingOverlay = new PaintingOverlay(this.m);
        this.e4 = paintingOverlay;
        this.z.addView(paintingOverlay, AbstractC13840gu3.b(-2, -2.0f));
        PaintingOverlay paintingOverlay2 = new PaintingOverlay(this.m);
        this.f4 = paintingOverlay2;
        this.z.addView(paintingOverlay2, AbstractC13840gu3.b(-2, -2.0f));
        PaintingOverlay paintingOverlay3 = new PaintingOverlay(this.m);
        this.g4 = paintingOverlay3;
        this.z.addView(paintingOverlay3, AbstractC13840gu3.b(-2, -2.0f));
        C21477d c21477d = new C21477d(activity);
        this.o = c21477d;
        c21477d.setOverlayTitleAnimation(true);
        this.o.setTitleColor(-1);
        this.o.setSubtitleColor(-1);
        this.o.setBackgroundColor(2130706432);
        this.o.setOccupyStatusBar(A8());
        this.o.setItemsBackgroundColor(1090519039, false);
        this.o.setBackButtonImage(AbstractC23598xB5.ic_ab_back);
        this.o.getBackButton().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ua5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I9(view);
            }
        });
        B0 b0 = new B0(activity);
        this.s = b0;
        this.o.addView(b0, AbstractC13840gu3.d(-1, -1, 119));
        this.z.addView(this.o, AbstractC13840gu3.b(-1, -2.0f));
        z0 z0Var = new z0(activity);
        this.t = z0Var;
        this.z.addView(z0Var, AbstractC13840gu3.d(-1, -2, 55));
        this.o.setActionBarMenuOnItemClick(new C21479e(hVar));
        ActionBarMenu actionBarMenuL = this.o.l();
        this.F0 = actionBarMenuL;
        actionBarMenuL.setOnLayoutListener(new Runnable() { // from class: ir.nasim.va5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Db();
            }
        });
        ActionBarMenuItem actionBarMenuItemB = this.F0.b(13, AbstractC23598xB5.msg_mask);
        this.J0 = actionBarMenuItemB;
        actionBarMenuItemB.setContentDescription(FH3.E("Masks", TD5.tgwidget_Masks));
        ActionBarMenuItem actionBarMenuItemB2 = this.F0.b(5, AbstractC23598xB5.ic_goinline);
        this.I0 = actionBarMenuItemB2;
        actionBarMenuItemB2.setContentDescription(FH3.E("AccDescrPipMode", TD5.tgwidget_AccDescrPipMode));
        ActionBarMenuItem actionBarMenuItemB3 = this.F0.b(20, AbstractC23598xB5.msg_header_draw);
        this.H0 = actionBarMenuItemB3;
        actionBarMenuItemB3.setContentDescription(FH3.E("AccDescrPhotoEditor", TD5.tgwidget_AccDescrPhotoEditor));
        ActionBarMenuItem actionBarMenuItemB4 = this.F0.b(3, AbstractC23598xB5.msg_header_share);
        this.G0 = actionBarMenuItemB4;
        actionBarMenuItemB4.setContentDescription(FH3.E("Forward", TD5.tgwidget_Forward));
        ActionBarMenu actionBarMenu = this.F0;
        ir.nasim.tgwidgets.editor.ui.Components.n nVar = new ir.nasim.tgwidgets.editor.ui.Components.n();
        this.B0 = nVar;
        ActionBarMenuItem actionBarMenuItemF = actionBarMenu.f(0, nVar);
        this.A0 = actionBarMenuItemF;
        actionBarMenuItemF.setOnMenuDismiss(new Utilities.b() { // from class: ir.nasim.wa5
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.J9((Boolean) obj);
            }
        });
        this.A0.getPopupLayout().b = true;
        this.L0 = new C21506a(this.n, this.A0.getPopupLayout().getSwipeBack(), new C21481f());
        this.D0 = this.A0.I(AbstractC23598xB5.msg_speed, null, FH3.E("Speed", TD5.tgwidget_Speed), this.L0.a);
        this.A0.getPopupLayout().setSwipeBackForegroundColor(-14540254);
        this.D0.setSubtext(FH3.E("SpeedNormal", TD5.tgwidget_SpeedNormal));
        this.D0.d(-328966, -328966);
        ActionBarPopupWindow.GapView gapViewB = this.A0.B();
        this.E0 = gapViewB;
        gapViewB.setColor(-15198184);
        this.A0.getPopupLayout().setFitItems(true);
        this.A0.H(11, AbstractC23598xB5.msg_openin, FH3.E("OpenInExternalApp", TD5.tgwidget_OpenInExternalApp)).d(-328966, -328966);
        this.A0.setContentDescription(FH3.E("AccDescrMoreOptions", TD5.tgwidget_AccDescrMoreOptions));
        ActionBarMenuSubItem actionBarMenuSubItemH = this.A0.H(2, AbstractC23598xB5.msg_media, FH3.E("ShowAllMedia", TD5.tgwidget_ShowAllMedia));
        this.C0 = actionBarMenuSubItemH;
        actionBarMenuSubItemH.d(-328966, -328966);
        this.A0.H(14, AbstractC23598xB5.msg_gif, FH3.E("SaveToGIFs", TD5.tgwidget_SaveToGIFs)).d(-328966, -328966);
        this.A0.H(4, AbstractC23598xB5.msg_message, FH3.E("ShowInChat", TD5.tgwidget_ShowInChat)).d(-328966, -328966);
        this.A0.H(15, AbstractC23598xB5.msg_sticker, FH3.E("ShowStickers", TD5.tgwidget_ShowStickers)).d(-328966, -328966);
        this.A0.H(10, AbstractC23598xB5.msg_shareout, FH3.E("ShareFile", TD5.tgwidget_ShareFile)).d(-328966, -328966);
        this.A0.H(1, AbstractC23598xB5.msg_gallery, FH3.E("SaveToGallery", TD5.tgwidget_SaveToGallery)).d(-328966, -328966);
        this.A0.H(16, AbstractC23598xB5.msg_openprofile, FH3.E("SetAsMain", TD5.tgwidget_SetAsMain)).d(-328966, -328966);
        this.A0.H(6, AbstractC23598xB5.msg_delete, FH3.E("Delete", TD5.tgwidget_Delete)).d(-328966, -328966);
        this.A0.H(7, AbstractC23598xB5.msg_cancel, FH3.E("StopDownload", TD5.tgwidget_StopDownload)).d(-328966, -328966);
        this.A0.k0(-115203550);
        ab(false, true);
        this.A0.setPopupItemsSelectorColor(268435455);
        this.A0.setSubMenuDelegate(new C21483g());
        FrameLayout frameLayout = new FrameLayout(this.n);
        this.G = frameLayout;
        frameLayout.setBackgroundColor(2130706432);
        this.z.addView(this.G, AbstractC13840gu3.d(-1, 48, 83));
        View view = new View(this.n);
        this.H = view;
        view.setBackgroundColor(2130706432);
        this.B.addView(this.H, AbstractC13840gu3.a(-1.0f, this.J / AbstractC21455b.g, 87));
        this.r1[0] = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{838860800, 0});
        this.r1[0].setShape(0);
        this.r1[1] = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{838860800, 0});
        this.r1[1].setShape(0);
        GroupedPhotosListView groupedPhotosListView = new GroupedPhotosListView(this.n, AbstractC21455b.F(10.0f));
        this.g1 = groupedPhotosListView;
        this.z.addView(groupedPhotosListView, AbstractC13840gu3.d(-1, 68, 83));
        this.g1.setDelegate(new C21485h());
        for (int i3 = 0; i3 < 3; i3++) {
            this.c3[i3] = new ImageView(this.m);
            this.c3[i3].setImageResource(AbstractC23598xB5.msg_maxvideo);
            this.c3[i3].setContentDescription(FH3.E("AccSwitchToFullscreen", TD5.tgwidget_AccSwitchToFullscreen));
            this.c3[i3].setScaleType(ImageView.ScaleType.CENTER);
            this.c3[i3].setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
            this.c3[i3].setVisibility(4);
            this.c3[i3].setAlpha(1.0f);
            this.z.addView(this.c3[i3], AbstractC13840gu3.b(48, 48.0f));
            this.c3[i3].setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xa5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.K9(view2);
                }
            });
        }
        s0 s0Var = new s0(this.z.getContext());
        this.H1 = s0Var;
        s0Var.setFactory(new ViewSwitcher.ViewFactory() { // from class: ir.nasim.ya5
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                return this.a.L9();
            }
        });
        this.H1.setVisibility(4);
        Ma(true);
        for (int i4 = 0; i4 < 3; i4++) {
            this.V0[i4] = new C21487i(this.z);
            this.V0[i4].o(0, false, true);
        }
        C21489j c21489j = new C21489j(this.n, hVar);
        this.W0 = c21489j;
        c21489j.setUseSelfAlpha(true);
        this.W0.setProgressColor(-1);
        this.W0.setSize(AbstractC21455b.F(54.0f));
        this.W0.setBackgroundResource(AbstractC23598xB5.circle_big);
        this.W0.setVisibility(4);
        this.W0.setAlpha(0.0f);
        this.z.addView(this.W0, AbstractC13840gu3.d(64, 64, 17));
        E7();
        RadialProgressView radialProgressView = new RadialProgressView(this.m, hVar);
        this.x6 = radialProgressView;
        radialProgressView.setProgressColor(-1);
        this.x6.setBackgroundResource(AbstractC23598xB5.circle_big);
        this.x6.setVisibility(4);
        this.z.addView(this.x6, AbstractC13840gu3.d(54, 54, 17));
        PickerBottomLayoutViewer pickerBottomLayoutViewer = new PickerBottomLayoutViewer(this.m);
        this.w6 = pickerBottomLayoutViewer;
        pickerBottomLayoutViewer.setBackgroundColor(2130706432);
        this.w6.a(0, false);
        this.w6.setTranslationY(AbstractC21455b.F(120.0f));
        this.w6.b.setText(FH3.E("Done", TD5.tgwidget_Done).toUpperCase());
        TextView textView = this.w6.b;
        int i5 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4;
        textView.setTextColor(n8(i5));
        this.z.addView(this.w6, AbstractC13840gu3.d(-1, 48, 83));
        this.w6.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.za5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IOException {
                this.a.k9(view2);
            }
        });
        this.w6.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ba5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IOException {
                this.a.l9(view2);
            }
        });
        ir.nasim.tgwidgets.editor.ui.Components.I i6 = new ir.nasim.tgwidgets.editor.ui.Components.I(false);
        this.w1 = i6;
        i6.d(new C21491l());
        E0 e0 = new E0(this.m);
        this.v6 = e0;
        e0.setTranslationY(AbstractC21455b.F(120.0f));
        this.v6.setVisibility(4);
        this.v6.setBackgroundColor(2130706432);
        this.z.addView(this.v6, AbstractC13840gu3.c(-1, 70.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        Paint paint = new Paint();
        paint.setColor(2130706432);
        C21492m c21492m = new C21492m(this.n, paint);
        this.R0 = c21492m;
        c21492m.setLayoutParams(AbstractC13840gu3.d(-1, -2, 83));
        j7();
        TextView textView2 = new TextView(this.z.getContext());
        this.Y = textView2;
        textView2.setTextSize(1, 15.0f);
        this.Y.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.Y.setSingleLine(true);
        this.Y.setMaxLines(1);
        TextView textView3 = this.Y;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView3.setEllipsize(truncateAt);
        this.Y.setTextColor(-1);
        this.Y.setGravity(3);
        this.R0.addView(this.Y, AbstractC13840gu3.c(-1, -2.0f, 51, 20.0f, 23.0f, 84.0f, 0.0f));
        TextView textView4 = new TextView(this.z.getContext());
        this.Z = textView4;
        textView4.setTextSize(1, 14.0f);
        this.Z.setSingleLine(true);
        this.Z.setMaxLines(1);
        this.Z.setEllipsize(truncateAt);
        this.Z.setTextColor(-1);
        this.Z.setGravity(3);
        this.R0.addView(this.Z, AbstractC13840gu3.c(-1, -2.0f, 51, 20.0f, 46.0f, 84.0f, 0.0f));
        TextView textView5 = new TextView(this.z.getContext());
        this.z0 = textView5;
        int i7 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Df;
        textView5.setBackground(m.e.e(n8(i7), 6.0f));
        TextView textView6 = this.z0;
        int i8 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Gf;
        textView6.setTextColor(n8(i8));
        this.z0.setEllipsize(truncateAt);
        this.z0.setGravity(17);
        this.z0.setLines(1);
        this.z0.setSingleLine(true);
        this.z0.setText(FH3.E("SetAsMyPhoto", TD5.tgwidget_SetAsMyPhoto));
        this.z0.setTextSize(1, 15.0f);
        this.z0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.z0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Z95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws InterruptedException, IOException {
                this.a.m9(view2);
            }
        });
        this.z0.setVisibility(8);
        this.R0.addView(this.z0, AbstractC13840gu3.c(-1, 48.0f, 51, 20.0f, 0.0f, 20.0f, 64.0f));
        C21493n c21493n = new C21493n(this.m);
        this.y6 = c21493n;
        c21493n.setDelegate(new C21494o());
        ob(false, false);
        this.y6.setBackgroundColor(2130706432);
        this.y6.setLayoutParams(AbstractC13840gu3.c(-1, 58.0f, 83, 0.0f, 8.0f, 0.0f, 0.0f));
        TextView textView7 = new TextView(this.m);
        this.z6 = textView7;
        textView7.setSingleLine(true);
        this.z6.setVisibility(8);
        this.z6.setText(FH3.E("ChooseCover", TD5.tgwidget_ChooseCover));
        this.z6.setGravity(1);
        this.z6.setTextSize(1, 14.0f);
        this.z6.setTextColor(-7566196);
        this.z.addView(this.z6, AbstractC13840gu3.c(-1, -2.0f, 83, 0.0f, 8.0f, 0.0f, 0.0f));
        C21495p c21495p = new C21495p(this.m);
        this.S0 = c21495p;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        c21495p.setScaleType(scaleType);
        Drawable drawableB0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.b0(AbstractC21455b.F(56.0f), n8(i5), n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.G4));
        this.G3 = drawableB0;
        this.S0.setBackgroundDrawable(drawableB0);
        ImageView imageView = this.S0;
        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        imageView.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.S0.setImageResource(AbstractC23598xB5.attach_send);
        this.S0.setColorFilter(new PorterDuffColorFilter(n8(ir.nasim.tgwidgets.editor.ui.ActionBar.m.H4), mode));
        this.S0.setLayoutParams(AbstractC13840gu3.c(56, 56.0f, 85, 0.0f, 0.0f, 14.0f, 14.0f));
        this.S0.setContentDescription(FH3.E("Send", TD5.tgwidget_Send));
        this.S0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.aa5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws InterruptedException, IOException {
                this.a.n9(view2);
            }
        });
        TextView textView8 = new TextView(this.m);
        this.F3 = textView8;
        textView8.setTextSize(1, 15.0f);
        this.F3.setTextColor(-1280137);
        this.F3.setGravity(17);
        this.F3.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.z.addView(this.F3, AbstractC13840gu3.c(56, 20.0f, 85, 3.0f, 0.0f, 14.0f, 78.0f));
        C21496q c21496q = new C21496q(this.m);
        this.K0 = c21496q;
        c21496q.setOrientation(0);
        this.R0.addView(this.K0, AbstractC13840gu3.c(-2, 48.0f, 81, 0.0f, 0.0f, 70.0f, 18.0f));
        ImageView imageView2 = new ImageView(this.m);
        this.Y0 = imageView2;
        imageView2.setScaleType(scaleType);
        this.Y0.setImageResource(AbstractC23598xB5.msg_photo_crop);
        this.Y0.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.K0.addView(this.Y0, AbstractC13840gu3.g(48, 48));
        this.Y0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ba5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.o9(view2);
            }
        });
        this.Y0.setContentDescription(FH3.E("CropImage", TD5.tgwidget_CropImage));
        ImageView imageView3 = new ImageView(this.m);
        this.a1 = imageView3;
        imageView3.setScaleType(scaleType);
        this.a1.setImageResource(AbstractC23598xB5.msg_photo_rotate);
        this.a1.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.K0.addView(this.a1, AbstractC13840gu3.g(48, 48));
        this.a1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ca5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.p9(view2);
            }
        });
        this.a1.setContentDescription(FH3.E("AccDescrRotate", TD5.tgwidget_AccDescrRotate));
        ImageView imageView4 = new ImageView(this.m);
        this.Z0 = imageView4;
        imageView4.setScaleType(scaleType);
        this.Z0.setImageResource(AbstractC23598xB5.msg_photo_flip);
        this.Z0.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.K0.addView(this.Z0, AbstractC13840gu3.g(48, 48));
        this.Z0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.da5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.q9(view2);
            }
        });
        this.Z0.setContentDescription(FH3.E("AccDescrMirror", TD5.tgwidget_AccDescrMirror));
        ImageView imageView5 = new ImageView(this.m);
        this.X0 = imageView5;
        imageView5.setScaleType(scaleType);
        this.X0.setImageResource(AbstractC23598xB5.msg_photo_text2);
        this.X0.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.K0.addView(this.X0, AbstractC13840gu3.g(48, 48));
        this.X0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fa5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.r9(view2);
            }
        });
        this.X0.setContentDescription(FH3.E("AccDescrPhotoEditor", TD5.tgwidget_AccDescrPhotoEditor));
        ImageView imageView6 = new ImageView(this.m);
        this.e1 = imageView6;
        imageView6.setScaleType(scaleType);
        this.e1.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.e1.setLayoutParams(AbstractC13840gu3.c(48, 48.0f, 83, 16.0f, 0.0f, 0.0f, 0.0f));
        this.e1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ga5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IOException {
                this.a.s9(view2);
            }
        });
        ImageView imageView7 = new ImageView(this.m);
        this.b1 = imageView7;
        imageView7.setScaleType(scaleType);
        this.b1.setImageResource(AbstractC23598xB5.photo_add);
        this.b1.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.b1.setContentDescription(FH3.E("AccDescrTakeMorePics", TD5.tgwidget_AccDescrTakeMorePics));
        this.z.addView(this.b1, AbstractC13840gu3.c(48, 48.0f, 85, 0.0f, 0.0f, 16.0f, 0.0f));
        this.b1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ha5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.t9(view2);
            }
        });
        ImageView imageView8 = new ImageView(this.m);
        this.c1 = imageView8;
        imageView8.setScaleType(scaleType);
        this.c1.setImageResource(AbstractC23598xB5.msg_photo_settings);
        this.c1.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.c1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ia5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.u9(view2);
            }
        });
        this.c1.setContentDescription(FH3.E("AccDescrPhotoAdjust", TD5.tgwidget_AccDescrPhotoAdjust));
        ImageView imageView9 = new ImageView(this.m);
        this.f1 = imageView9;
        imageView9.setTag(1);
        this.f1.setScaleType(scaleType);
        this.f1.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.F6 = Ja();
        if (this.F6 <= 1) {
            this.f1.setImageResource(AbstractC23598xB5.video_quality1);
        } else if (this.F6 == 2) {
            this.f1.setImageResource(AbstractC23598xB5.video_quality2);
        } else {
            this.F6 = this.G6 - 1;
            this.f1.setImageResource(AbstractC23598xB5.video_quality3);
        }
        this.f1.setContentDescription(FH3.E("AccDescrVideoQuality", TD5.tgwidget_AccDescrVideoQuality));
        this.K0.addView(this.f1, AbstractC13840gu3.g(48, 48));
        this.f1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ja5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.v9(activity, view2);
            }
        });
        ImageView imageView10 = new ImageView(this.m);
        this.d1 = imageView10;
        imageView10.setScaleType(scaleType);
        this.d1.setImageResource(AbstractC23598xB5.msg_autodelete);
        this.d1.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.d1.setContentDescription(FH3.E("SetTimer", TD5.tgwidget_SetTimer));
        this.K0.addView(this.d1, AbstractC13840gu3.g(48, 48));
        this.d1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.la5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.w9(view2);
            }
        });
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = new PickerBottomLayoutViewer(this.n);
        this.T0 = pickerBottomLayoutViewer2;
        pickerBottomLayoutViewer2.setBackgroundColor(-872415232);
        this.T0.a(0, false);
        this.T0.setVisibility(8);
        this.z.addView(this.T0, AbstractC13840gu3.d(-1, 48, 83));
        this.T0.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ma5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.y9(view2);
            }
        });
        this.T0.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.na5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws InterruptedException, FileNotFoundException {
                this.a.z9(view2);
            }
        });
        TextView textView9 = new TextView(this.n);
        this.U0 = textView9;
        textView9.setClickable(false);
        this.U0.setVisibility(8);
        this.U0.setTextSize(1, 14.0f);
        this.U0.setTextColor(-1);
        this.U0.setGravity(17);
        this.U0.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(-12763843, 0));
        this.U0.setPadding(AbstractC21455b.F(20.0f), 0, AbstractC21455b.F(20.0f), 0);
        this.U0.setText(FH3.E("Reset", TD5.tgwidget_CropReset).toUpperCase());
        this.U0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.T0.addView(this.U0, AbstractC13840gu3.d(-2, -1, 49));
        this.U0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oa5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.B9(view2);
            }
        });
        C13450gF2 c13450gF2 = new C13450gF2(this.z.getContext(), this);
        this.t5 = c13450gF2;
        c13450gF2.m(false);
        Qa(true);
        ImageReceiver.c cVar2 = new ImageReceiver.c() { // from class: ir.nasim.qa5
            @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver.c
            public final void a(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
                this.a.C9(imageReceiver, z, z2, z3);
            }
        };
        this.i4.j1(this.z);
        this.i4.D0((byte) 2);
        this.i4.c1(true);
        this.i4.H0(cVar2);
        this.h4.j1(this.z);
        this.h4.D0((byte) 2);
        this.h4.c1(true);
        this.h4.H0(cVar2);
        this.j4.j1(this.z);
        this.j4.D0((byte) 2);
        this.j4.c1(true);
        this.j4.H0(cVar2);
        int rotation = ((WindowManager) AbstractC14047hG.a.getSystemService("window")).getDefaultDisplay().getRotation();
        C21497r c21497r = new C21497r(this.z.getContext(), AbstractC23598xB5.selectphoto_large);
        this.P0 = c21497r;
        c21497r.setDrawBackground(true);
        this.P0.setHasBorder(true);
        this.P0.setSize(34);
        this.P0.setCheckOffset(AbstractC21455b.F(1.0f));
        this.P0.setColor(n8(i5), -1);
        this.P0.setVisibility(8);
        this.z.addView(this.P0, AbstractC13840gu3.c(34, 34.0f, 53, 0.0f, (rotation == 3 || rotation == 1) ? 61.0f : 71.0f, 11.0f, 0.0f));
        if (A8()) {
            ((FrameLayout.LayoutParams) this.P0.getLayoutParams()).topMargin += AbstractC21455b.d;
        }
        this.P0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ra5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.D9(view2);
            }
        });
        CounterView counterView = new CounterView(this.m);
        this.Q0 = counterView;
        this.z.addView(counterView, AbstractC13840gu3.c(40, 40.0f, 53, 0.0f, (rotation == 3 || rotation == 1) ? 58.0f : 68.0f, 64.0f, 0.0f));
        if (A8()) {
            ((FrameLayout.LayoutParams) this.Q0.getLayoutParams()).topMargin += AbstractC21455b.d;
        }
        this.Q0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sa5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.E9(view2);
            }
        });
        H0 h0 = new H0(this.m);
        this.j1 = h0;
        h0.setVisibility(8);
        this.j1.setAlpha(0.0f);
        this.j1.setLayoutManager(new C21498s(this.m, 0, true));
        H0 h02 = this.j1;
        x0 x0Var = new x0(this.m);
        this.k1 = x0Var;
        h02.setAdapter(x0Var);
        this.z.addView(this.j1, AbstractC13840gu3.d(-1, 103, 51));
        this.j1.setOnItemClickListener(new RecyclerListView.i() { // from class: ir.nasim.ta5
            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.i
            public final void a(View view2, int i9) throws InterruptedException, Resources.NotFoundException {
                this.a.F9(view2, i9);
            }
        });
        C21499t c21499t = new C21499t(this, this.n, this.z, this.B, hVar);
        this.K1 = c21499t;
        c21499t.setDelegate(new C21500u());
        this.K1.setImportantForAccessibility(4);
        this.K1.setVisibility(8);
        this.K1.setLayoutParams(AbstractC13840gu3.d(-1, -2, 83));
        C21502w c21502w = new C21502w(this.n, hVar);
        this.N3 = c21502w;
        c21502w.setTag(5);
        C21503x c21503x = new C21503x(this.n);
        this.O3 = c21503x;
        c21503x.J2(1);
        this.N3.setLayoutManager(this.O3);
        this.N3.setVisibility(8);
        this.N3.setClipToPadding(true);
        this.N3.setOverScrollMode(2);
        this.z.addView(this.N3, AbstractC13840gu3.d(-1, 110, 83));
        UndoView undoView = new UndoView(this.n, null, false, hVar);
        this.i1 = undoView;
        undoView.setAdditionalTranslationY(AbstractC21455b.F(112.0f));
        this.i1.setColors(-115203550, -1);
        this.z.addView(this.i1, AbstractC13840gu3.c(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        if (AbstractC21455b.v0()) {
            View view2 = new View(this.n);
            this.v3 = view2;
            view2.setContentDescription(FH3.E("AccActionPlay", TD5.tgwidget_AccActionPlay));
            this.v3.setFocusable(true);
            this.z.addView(this.v3, AbstractC13840gu3.d(64, 64, 17));
        }
        this.z0.setBackground(m.e.e(n8(i7), 6.0f));
        this.z0.setTextColor(n8(i8));
    }

    public void db(NP0 np0) {
        this.M3 = np0;
    }

    public float e8() {
        return this.p1;
    }

    @Keep
    public float getAnimationValue() {
        return this.m5;
    }

    public void ha() {
        boolean z;
        FT7 ft7 = this.j2;
        if (ft7 == null || !this.P2 || this.e5 > 1.1f) {
            return;
        }
        long jS1 = ft7.s1();
        long jU1 = this.j2.u1();
        if (jS1 == -9223372036854775807L || jU1 < 15000) {
            return;
        }
        float f = this.s6;
        int iZ7 = Z7() / 3;
        if (f >= iZ7 * 2) {
            z = true;
        } else if (f >= iZ7) {
            return;
        } else {
            z = false;
        }
        this.D3.y(this.j2, z, this.p1);
    }

    public void jb(AlertDialog.i iVar) {
        if (this.m == null) {
            return;
        }
        try {
            AlertDialog alertDialog = this.G1;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.G1 = null;
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        try {
            AlertDialog alertDialogQ = iVar.q();
            this.G1 = alertDialogQ;
            alertDialogQ.setCanceledOnTouchOutside(true);
            this.G1.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.eb5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.a.N9(dialogInterface);
                }
            });
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0156 A[PHI: r3
      0x0156: PHI (r3v19 float) = (r3v14 float), (r3v15 float) binds: [B:63:0x0154, B:66:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0165 A[PHI: r3
      0x0165: PHI (r3v18 float) = (r3v16 float), (r3v17 float) binds: [B:69:0x0163, B:72:0x016b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0167  */
    @Override // ir.nasim.C13450gF2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onDoubleTap(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.onDoubleTap(android.view.MotionEvent):boolean");
    }

    @Override // ir.nasim.C13450gF2.b
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // ir.nasim.C13450gF2.c
    public boolean onDown(MotionEvent motionEvent) {
        if (!this.N5 && this.P0.getVisibility() != 0) {
            boolean[] zArr = this.s1;
            if (!zArr[0] && !zArr[1]) {
                float x = motionEvent.getX();
                if (x < Math.min(135, this.z.getMeasuredWidth() / 8)) {
                    if (this.h4.f0()) {
                        this.s1[0] = true;
                        this.z.invalidate();
                    }
                } else if (x > this.z.getMeasuredWidth() - r0 && this.j4.f0()) {
                    this.s1[1] = true;
                    this.z.invalidate();
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.C13450gF2.c
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.e5 == 1.0f) {
            return false;
        }
        this.U5.abortAnimation();
        this.U5.fling(Math.round(this.c5), Math.round(this.d5), Math.round(f), Math.round(f2), (int) this.E5, (int) this.F5, (int) this.G5, (int) this.H5);
        this.z.postInvalidate();
        return false;
    }

    @Override // ir.nasim.C13450gF2.c
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // ir.nasim.C13450gF2.c
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // ir.nasim.C13450gF2.c
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // ir.nasim.C13450gF2.b
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) throws InterruptedException, Resources.NotFoundException {
        PhotoViewerWebView photoViewerWebView;
        C10743c74 c10743c74;
        if (this.R5) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.P0.getVisibility() != 0 && AbstractC8662Wx6.T && y > ActionBar.getCurrentActionBarHeight() + AbstractC21455b.d + AbstractC21455b.F(40.0f)) {
            if (x < Math.min(135, this.z.getMeasuredWidth() / 8)) {
                if (this.h4.f0()) {
                    sb(-1, true);
                    return true;
                }
            } else if (x > this.z.getMeasuredWidth() - r3 && this.j4.f0()) {
                sb(1, true);
                return true;
            }
        }
        PhotoViewerWebView photoViewerWebView2 = this.A;
        if (photoViewerWebView2 != null && photoViewerWebView2.H() && this.p) {
            WebView webView = this.A.getWebView();
            if (x >= webView.getX() && x <= webView.getX() + webView.getWidth() && y >= webView.getY() && y <= webView.getY() + webView.getHeight()) {
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setAction(0);
                motionEventObtain.offsetLocation(-webView.getX(), -webView.getY());
                webView.dispatchTouchEvent(motionEventObtain);
                motionEventObtain.setAction(1);
                webView.dispatchTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                Ea();
                return true;
            }
        }
        if (this.z.getTag() != null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = this.e2;
            boolean z = (aspectRatioFrameLayout != null && aspectRatioFrameLayout.getVisibility() == 0) || ((photoViewerWebView = this.A) != null && photoViewerWebView.H());
            if (this.J4 != 1 || (c10743c74 = this.r4) == null) {
                A0 a0 = this.V0[0];
                if (a0 != null && this.z != null) {
                    int i = a0.h;
                    if (x >= (Z7() - AbstractC21455b.F(100.0f)) / 2.0f && x <= (Z7() + AbstractC21455b.F(100.0f)) / 2.0f && y >= (W7() - AbstractC21455b.F(100.0f)) / 2.0f && y <= (W7() + AbstractC21455b.F(100.0f)) / 2.0f) {
                        if (z) {
                            if ((i == 3 || i == 4) && this.V0[0].i()) {
                                this.k2 = true;
                                Bb();
                                return true;
                            }
                        } else if (i > 0 && i <= 3) {
                            ca(true);
                            w7(0, false, true);
                            return true;
                        }
                    }
                }
            } else if (!c10743c74.k()) {
                float fW7 = (W7() - AbstractC21455b.F(360.0f)) / 2.0f;
                if (y >= fW7 && y <= fW7 + AbstractC21455b.F(360.0f)) {
                    ca(true);
                    return true;
                }
            }
            PhotoViewerWebView photoViewerWebView3 = this.A;
            if (photoViewerWebView3 == null || !photoViewerWebView3.H() || this.A.K() || !this.p) {
                vb(!this.p, true);
            }
        } else {
            int i2 = this.L1;
            if (i2 == 0 || i2 == 4) {
                if (this.n1) {
                    FT7 ft7 = this.j2;
                    if (ft7 != null && !this.f && i2 != 1) {
                        ft7.S1(1.0f);
                    }
                    this.k2 = true;
                    Bb();
                } else {
                    this.P0.performClick();
                }
            } else if (i2 == 2) {
                if (this.n1) {
                    this.k2 = true;
                    Bb();
                }
            } else if (this.n1) {
                this.k2 = true;
                Bb();
            }
        }
        return true;
    }

    @Override // ir.nasim.C13450gF2.c
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.I5 && !this.u5) {
            return onSingleTapConfirmed(motionEvent);
        }
        w0 w0Var = this.z;
        if (w0Var != null && w0Var.getTag() != null && this.V0[0] != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((x < ((float) (Z7() - AbstractC21455b.F(100.0f))) / 2.0f || x > ((float) (Z7() + AbstractC21455b.F(100.0f))) / 2.0f || y < ((float) (W7() - AbstractC21455b.F(100.0f))) / 2.0f || y > ((float) (W7() + AbstractC21455b.F(100.0f))) / 2.0f) ? false : onSingleTapConfirmed(motionEvent)) {
                this.R5 = true;
                return true;
            }
        }
        return false;
    }

    public FT7 p8() {
        return this.j2;
    }

    public boolean pa(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, C24687z23 c24687z23, C24687z23 c24687z232, ArrayList arrayList, Void r22, ArrayList arrayList2, int i, C0 c0, NP0 np0, long j, long j2, int i2, boolean z, y0 y0Var, Integer num) throws InterruptedException, Resources.NotFoundException {
        C0 c02;
        int i3 = 0;
        if (this.m != null && !this.c && ((c0 != null || !s7()) && (c10743c74 != null || abstractC20488s57 != null || arrayList != null || arrayList2 != null || c24687z23 != null || y0Var != null))) {
            D0 placeForPhoto = c0.getPlaceForPhoto(c10743c74, abstractC20488s57, i, true);
            this.X1 = null;
            WindowManager windowManager = (WindowManager) this.m.getSystemService("window");
            if (this.X4) {
                try {
                    windowManager.removeView(this.B);
                    ea();
                } catch (Exception unused) {
                }
            }
            try {
                WindowManager.LayoutParams layoutParams = this.y;
                layoutParams.type = 99;
                layoutParams.flags = -2147286784;
                layoutParams.softInputMode = (this.v1 ? 32 : 16) | 256;
                this.B.setFocusable(false);
                this.z.setFocusable(false);
                windowManager.addView(this.B, this.y);
                la();
                this.o6 = false;
                this.Z1 = false;
                this.u = true;
                this.d3 = true;
                this.M3 = np0;
                this.Y3 = null;
                this.Z3 = num != null;
                this.s.i("");
                this.s.h("", false);
                z0 z0Var = this.t;
                if (z0Var != null) {
                    z0Var.c(0, 0, false);
                    this.t.e(false, false);
                }
                this.o.setTitleScrollNonFitText(false);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.N1);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.M1);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.L1);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.U);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.T);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.Z);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.w);
                ir.nasim.tgwidgets.editor.messenger.E.j().e(this, ir.nasim.tgwidgets.editor.messenger.E.K2);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.Q1);
                ir.nasim.tgwidgets.editor.messenger.E.k(this.v).e(this, ir.nasim.tgwidgets.editor.messenger.E.P1);
                this.b = c0;
                this.M4 = j2;
                this.L4 = j;
                this.K4 = i2;
                this.k1.notifyDataSetChanged();
                if (this.T5 == null) {
                    this.T5 = VelocityTracker.obtain();
                }
                this.c = true;
                Ab(false, false);
                boolean z2 = !z;
                this.R1 = z2;
                if (z2) {
                    vb(false, false);
                } else if (this.L1 == 1) {
                    B7();
                    vb(false, false);
                } else {
                    vb(true, false);
                }
                this.B.setClipChildren(false);
                this.H.setVisibility(0);
                this.I2 = 0.0f;
                this.y2 = false;
                this.x2 = false;
                if (placeForPhoto != null) {
                    this.X3 = true;
                    this.S3 = 1;
                    if (c10743c74 != null) {
                        AnimatedFileDrawable animatedFileDrawableK = placeForPhoto.allowTakeAnimation ? placeForPhoto.imageReceiver.k() : null;
                        this.P1 = animatedFileDrawableK;
                        if (animatedFileDrawableK != null) {
                            if (c10743c74.c1()) {
                                placeForPhoto.imageReceiver.w0(false);
                                placeForPhoto.imageReceiver.v1();
                                if (MediaController.Y().e0(c10743c74)) {
                                    this.I2 = c10743c74.s;
                                }
                                this.y2 = this.v2 == null && !C4278El2.H(c10743c74.N).U(c10743c74.I(), true) && (this.P1.H0() || !C4278El2.H(c10743c74.N).U(c10743c74.I(), false));
                                this.P1 = null;
                            } else if (c10743c74.e0(null, null).size() > 1) {
                                this.P1 = null;
                            }
                        }
                    } else if (y0Var != null) {
                        this.P1 = placeForPhoto.imageReceiver.k();
                    }
                    float f = 0.0f;
                    ja(c10743c74, abstractC20488s57, c24687z23, c24687z232, arrayList, arrayList2, i, placeForPhoto);
                    if (this.L1 == 1) {
                        this.y1.setVisibility(0);
                        this.y1.setAlpha(0.0f);
                        this.y1.setFreeform(false);
                    }
                    RectF rectFU = placeForPhoto.imageReceiver.u();
                    float f2 = rectFU.left;
                    float f3 = rectFU.top;
                    int iQ = placeForPhoto.imageReceiver.Q();
                    int iJ = placeForPhoto.imageReceiver.j();
                    if (iJ != 0) {
                        iQ = iJ;
                    }
                    ClippingImageView[] clippingImageViewArrV7 = V7(placeForPhoto);
                    this.n5 = 1.0f;
                    for (int i4 = 0; i4 < clippingImageViewArrV7.length; i4++) {
                        clippingImageViewArrV7[i4].setAnimationValues(this.L3);
                        clippingImageViewArrV7[i4].setVisibility(0);
                        clippingImageViewArrV7[i4].setRadius(placeForPhoto.radius);
                        clippingImageViewArrV7[i4].setOrientation(iQ, placeForPhoto.imageReceiver.H());
                        clippingImageViewArrV7[i4].setImageBitmap(placeForPhoto.thumb);
                    }
                    v8();
                    if (this.L1 == 1) {
                        this.y1.setAspectRatio(1.0f);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
                    layoutParams2.width = (int) rectFU.width();
                    int iHeight = (int) rectFU.height();
                    layoutParams2.height = iHeight;
                    if (layoutParams2.width <= 0) {
                        layoutParams2.width = 100;
                    }
                    if (iHeight <= 0) {
                        layoutParams2.height = 100;
                    }
                    while (i3 < clippingImageViewArrV7.length) {
                        if (clippingImageViewArrV7.length > 1) {
                            clippingImageViewArrV7[i3].setAlpha(f);
                        } else {
                            clippingImageViewArrV7[i3].setAlpha(1.0f);
                        }
                        clippingImageViewArrV7[i3].setPivotX(f);
                        clippingImageViewArrV7[i3].setPivotY(f);
                        clippingImageViewArrV7[i3].setScaleX(placeForPhoto.scale);
                        clippingImageViewArrV7[i3].setScaleY(placeForPhoto.scale);
                        clippingImageViewArrV7[i3].setTranslationX(placeForPhoto.viewX + (rectFU.left * placeForPhoto.scale));
                        clippingImageViewArrV7[i3].setTranslationY(placeForPhoto.viewY + (rectFU.top * placeForPhoto.scale));
                        clippingImageViewArrV7[i3].setLayoutParams(layoutParams2);
                        i3++;
                        f = 0.0f;
                    }
                    this.B.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC21478d0(clippingImageViewArrV7, layoutParams2, f2, placeForPhoto, f3, y0Var, c0, arrayList2, num));
                } else {
                    if (arrayList2 != null && this.L1 != 3 && ((c02 = this.b) == null || !c02.closeKeyboard())) {
                        Y9();
                    }
                    this.z.setAlpha(1.0f);
                    ja(c10743c74, abstractC20488s57, c24687z23, c24687z232, arrayList, arrayList2, i, placeForPhoto);
                    v8();
                    Oa();
                    this.B.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC21480e0(c0, num));
                }
                AccessibilityManager accessibilityManager = (AccessibilityManager) this.m.getSystemService("accessibility");
                if (accessibilityManager.isTouchExplorationEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(16384);
                    accessibilityEventObtain.getText().add(FH3.E("AccDescrPhotoViewer", TD5.tgwidget_AccDescrPhotoViewer));
                    accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
                }
                return true;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
        return false;
    }

    public AbstractC12972fU7 q8() {
        return this.D3;
    }

    public boolean qa(AbstractC20488s57 abstractC20488s57, C24687z23 c24687z23, ArrayList arrayList, int i, int i2, boolean z, C0 c0, NP0 np0) throws InterruptedException, Resources.NotFoundException {
        this.N1 = z;
        ImageView imageView = this.S0;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            if (i2 == 4 || i2 == 5) {
                this.S0.setImageResource(AbstractC23598xB5.attach_send);
                layoutParams.bottomMargin = AbstractC21455b.F(19.0f);
            } else if (i2 == 1 || i2 == 3 || i2 == 10) {
                this.S0.setImageResource(AbstractC23598xB5.floating_check);
                this.S0.setPadding(0, AbstractC21455b.F(1.0f), 0, 0);
                layoutParams.bottomMargin = AbstractC21455b.F(19.0f);
            } else {
                this.S0.setImageResource(AbstractC23598xB5.attach_send);
                layoutParams.bottomMargin = AbstractC21455b.F(14.0f);
            }
            this.S0.setLayoutParams(layoutParams);
        }
        if (this.L1 == 1 || i2 != 1 || !this.c) {
            this.L1 = i2;
            return pa(null, abstractC20488s57, c24687z23, null, null, null, arrayList, i, c0, np0, 0L, 0L, 0, true, null, null);
        }
        this.L1 = i2;
        this.Z1 = false;
        this.s.i("");
        this.s.h("", false);
        this.b = c0;
        this.M4 = 0L;
        this.L4 = 0L;
        this.k1.notifyDataSetChanged();
        if (this.T5 == null) {
            this.T5 = VelocityTracker.obtain();
        }
        this.c = true;
        Ab(false, false);
        this.R1 = false;
        B7();
        vb(false, false);
        this.I2 = 0.0f;
        this.y2 = false;
        this.x2 = false;
        Y9();
        this.N0.setAlpha(255);
        this.z.setAlpha(1.0f);
        ja(null, abstractC20488s57, c24687z23, null, null, arrayList, i, null);
        v8();
        Oa();
        return true;
    }

    public boolean ra(ArrayList arrayList, int i, int i2, boolean z, C0 c0, NP0 np0) {
        return qa(null, null, arrayList, i, i2, z, c0, np0);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void rb(int r31) {
        /*
            Method dump skipped, instructions count: 2562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.PhotoViewer.rb(int):void");
    }

    @Keep
    public void setAnimationValue(float f) {
        this.m5 = f;
        this.z.invalidate();
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) throws InterruptedException, Resources.NotFoundException {
        float fX;
        C10743c74 c10743c74;
        int i3 = 3;
        float f = 1.0f;
        int i4 = 2;
        int i5 = 0;
        if (i == ir.nasim.tgwidgets.editor.messenger.E.N1) {
            String str = (String) objArr[0];
            int i6 = 0;
            while (true) {
                if (i6 >= 3) {
                    break;
                }
                String str2 = this.w4[i6];
                if (str2 == null || !str2.equals(str)) {
                    i6++;
                } else {
                    this.V0[i6].q(1.0f, i6 == 0 || (i6 == 1 && this.m1 == this.j4) || (i6 == 2 && this.m1 == this.h4));
                    w7(i6, false, true);
                }
            }
        } else if (i == ir.nasim.tgwidgets.editor.messenger.E.M1) {
            String str3 = (String) objArr[0];
            int i7 = 0;
            while (true) {
                if (i7 >= 3) {
                    break;
                }
                String str4 = this.w4[i7];
                if (str4 == null || !str4.equals(str3)) {
                    i7++;
                } else {
                    boolean z = i7 == 0 || (i7 == 1 && this.m1 == this.j4) || (i7 == 2 && this.m1 == this.h4);
                    this.V0[i7].q(1.0f, z);
                    w7(i7, false, z);
                    if (this.j2 == null && i7 == 0 && (c10743c74 = this.r4) != null && c10743c74.c1()) {
                        ca(false);
                    }
                    if (i7 == 0 && this.j2 != null) {
                        this.A4 = true;
                    }
                }
            }
        } else if (i == ir.nasim.tgwidgets.editor.messenger.E.L1) {
            String str5 = (String) objArr[0];
            int i8 = 0;
            while (i8 < i3) {
                String str6 = this.w4[i8];
                if (str6 != null && str6.equals(str5)) {
                    float fMin = Math.min(f, ((Long) objArr[1]).longValue() / ((Long) objArr[i4]).longValue());
                    this.V0[i8].q(fMin, i8 == 0 || (i8 == 1 && this.m1 == this.j4) || (i8 == i4 && this.m1 == this.h4));
                    if (i8 == 0 && this.j2 != null && this.U2 != null) {
                        if (this.A4) {
                            fX = f;
                        } else {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            if (Math.abs(jElapsedRealtime - this.u3) >= 500) {
                                float f2 = this.D2;
                                if (f2 == 0.0f) {
                                    long jU1 = this.j2.u1();
                                    long jS1 = this.j2.s1();
                                    f2 = (jU1 < 0 || jU1 == -9223372036854775807L || jS1 < 0) ? 0.0f : jS1 / jU1;
                                }
                                fX = this.s3 ? C4278El2.H(this.v).x(f2, this.w4[0]) : 1.0f;
                                this.u3 = jElapsedRealtime;
                            } else {
                                fX = -1.0f;
                            }
                        }
                        if (fX != -1.0f) {
                            this.U2.n(fX);
                            ir.nasim.tgwidgets.editor.ui.Components.w.h1(fX);
                            this.V2.invalidate();
                        }
                        t7(fMin);
                    }
                }
                i8++;
                i3 = 3;
                f = 1.0f;
                i4 = 2;
            }
        }
        if (i == ir.nasim.tgwidgets.editor.messenger.E.K2) {
            s0 s0Var = this.H1;
            if (s0Var != null) {
                s0Var.a();
                return;
            }
            return;
        }
        if (i == ir.nasim.tgwidgets.editor.messenger.E.Q1) {
            C10743c74 c10743c742 = (C10743c74) objArr[0];
            if (this.h7) {
                this.h7 = false;
                this.x6.setVisibility(4);
                wa(this.s4, false, false, this.t4.d);
                return;
            } else if (this.g7) {
                Aa(false);
                this.g7 = !MediaController.Y().H0(this.f7, true, true);
                return;
            } else {
                if (c10743c742 == this.f7) {
                    this.j7 = false;
                    this.x6.setVisibility(4);
                    return;
                }
                return;
            }
        }
        if (i == ir.nasim.tgwidgets.editor.messenger.E.P1) {
            if (((C10743c74) objArr[0]) == this.f7) {
                String str7 = (String) objArr[1];
                long jLongValue = ((Long) objArr[3]).longValue();
                this.V0[0].q(((Float) objArr[4]).floatValue(), true);
                if (jLongValue != 0) {
                    this.j7 = false;
                    this.V0[0].q(1.0f, true);
                    this.V0[0].o(3, true, true);
                    wa(Uri.fromFile(new File(str7)), false, true, this.t4.d);
                    return;
                }
                return;
            }
            return;
        }
        if (i == ir.nasim.tgwidgets.editor.messenger.E.w) {
            int i9 = 2;
            if (((Boolean) objArr[2]).booleanValue()) {
                return;
            }
            long jLongValue2 = ((Long) objArr[1]).longValue();
            ArrayList arrayList = (ArrayList) objArr[0];
            int i10 = 0;
            boolean z2 = false;
            boolean z3 = false;
            while (i10 < i9) {
                ArrayList arrayList2 = i10 == 0 ? this.a6 : this.Y5;
                SparseArray[] sparseArrayArr = i10 == 0 ? this.b6 : this.Z5;
                if (!arrayList2.isEmpty()) {
                    int i11 = i5;
                    while (i11 < 2) {
                        if (sparseArrayArr[i11].size() > 0 && ((C10743c74) sparseArrayArr[i11].valueAt(i5)).e.d.d == jLongValue2) {
                            int size = arrayList.size();
                            for (int i12 = i5; i12 < size; i12++) {
                                int iIntValue = ((Integer) arrayList.get(i12)).intValue();
                                C10743c74 c10743c743 = (C10743c74) sparseArrayArr[i11].get(((Integer) arrayList.get(i12)).intValue());
                                if (c10743c743 != null) {
                                    sparseArrayArr[i11].remove(iIntValue);
                                    arrayList2.remove(c10743c743);
                                    if (i11 == 0) {
                                        this.N4--;
                                    } else {
                                        this.P4--;
                                    }
                                    if (c10743c743 == this.r4) {
                                        z3 = true;
                                    }
                                    z2 = true;
                                }
                            }
                        }
                        i11++;
                        i5 = 0;
                    }
                }
                i10++;
                i9 = 2;
                i5 = 0;
            }
            if (z2) {
                if (z3 && this == q7) {
                    J7();
                    return;
                }
                if (this.a6.isEmpty()) {
                    z7(false, true);
                    return;
                }
                int size2 = this.p4;
                this.p4 = -1;
                if (size2 >= this.a6.size()) {
                    size2 = this.a6.size() - 1;
                }
                Ra(size2);
            }
        }
    }

    public void u7() {
        TextureView textureView;
        TextureView textureView2;
        float f;
        C10743c74 c10743c74;
        if (this.a6.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                this.c3[i].setVisibility(4);
            }
            return;
        }
        int i2 = 0;
        while (i2 < 3) {
            int i3 = this.p4;
            if (i2 == 1) {
                i3++;
            } else if (i2 == 2) {
                i3--;
            }
            if (i3 < 0 || i3 >= this.a6.size()) {
                this.c3[i2].setVisibility(4);
            } else {
                C10743c74 c10743c742 = (C10743c74) this.a6.get(i3);
                if (c10743c742.c1() || c10743c742.o1()) {
                    boolean z = c10743c742.o1() && (c10743c74 = this.r4) != null && c10743c74.T() == c10743c742.T();
                    int measuredWidth = z ? c10743c742.e.h.B.n : (i2 != 0 || (textureView = this.h2) == null) ? 0 : textureView.getMeasuredWidth();
                    int measuredHeight = z ? c10743c742.e.h.B.o : (i2 != 0 || (textureView2 = this.h2) == null) ? 0 : textureView2.getMeasuredHeight();
                    AbstractC18106o57 abstractC18106o57I = c10743c742.I();
                    if (abstractC18106o57I != null) {
                        int size = abstractC18106o57I.p.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                break;
                            }
                            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57I.p.get(i4);
                            if (abstractC18697p57 instanceof N77) {
                                measuredWidth = abstractC18697p57.j;
                                measuredHeight = abstractC18697p57.k;
                                break;
                            }
                            i4++;
                        }
                    }
                    Point point = AbstractC21455b.h;
                    if (point.y > point.x && measuredWidth > measuredHeight) {
                        if (this.c3[i2].getVisibility() != 0) {
                            this.c3[i2].setVisibility(0);
                        }
                        if (this.p) {
                            this.c3[i2].setAlpha(1.0f);
                        }
                        ((FrameLayout.LayoutParams) this.c3[i2].getLayoutParams()).topMargin = ((this.z.getMeasuredHeight() + ((int) (measuredHeight / (measuredWidth / this.z.getMeasuredWidth())))) / 2) - AbstractC21455b.F(48.0f);
                    } else if (this.c3[i2].getVisibility() != 4) {
                        this.c3[i2].setVisibility(4);
                    }
                    if (this.r5 != null) {
                        float f2 = this.c5;
                        f = f2 + ((this.h5 - f2) * this.m5);
                    } else {
                        f = this.c5;
                    }
                    float F2 = 0.0f;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            F2 = ((-AbstractC21455b.h.x) - AbstractC21455b.F(15.0f)) + (f - this.F5);
                        } else {
                            float f3 = this.E5;
                            if (f < f3) {
                                F2 = f - f3;
                            }
                        }
                    }
                    this.c3[i2].setTranslationX((F2 + AbstractC21455b.h.x) - AbstractC21455b.F(48.0f));
                } else {
                    this.c3[i2].setVisibility(4);
                }
            }
            i2++;
        }
    }

    public void x7(boolean z) {
        int i = this.p4;
        if (i < 0 || i >= this.h6.size()) {
            return;
        }
        Object obj = this.h6.get(this.p4);
        if (z) {
            CharSequence charSequenceA = this.m6.a();
            CharSequence[] charSequenceArr = {charSequenceA};
            if (this.o6 && !TextUtils.equals(this.p6, charSequenceA) && this.b.getPhotoIndex(this.p4) != 0 && this.b.getSelectedCount() > 0) {
                this.o6 = false;
            }
            this.p6 = charSequenceA;
            if (obj instanceof MediaController.m) {
                ((MediaController.m) obj).a = charSequenceArr[0];
            }
            if (charSequenceA != null && charSequenceA.length() != 0 && !this.b.isPhotoChecked(this.p4)) {
                eb();
            }
            C0 c0 = this.b;
            if (c0 != null) {
                c0.onApplyCaption(charSequenceA);
            }
            Pa(null, charSequenceArr[0], false);
        }
        this.K1.setTag(null);
        if (this.n1 && this.H3 == null) {
            this.s.j(this.Y3, true, true);
            this.s.g(this.f ? FH3.E("SoundMuted", TD5.tgwidget_SoundMuted) : this.k7);
        }
        Eb(obj);
        this.m6.h();
    }

    public void x8(FT7 ft7) {
        this.v2 = ft7;
    }

    public void z7(boolean z, boolean z2) {
        AnimatedFileDrawable animatedFileDrawable;
        RectF rectFU;
        float fMin;
        AnimatedFileDrawable animatedFileDrawableK;
        Bitmap bitmapU0;
        int i;
        int i2;
        if (this.m6.i()) {
            x7(true);
            return;
        }
        if (!z2 && (i2 = this.a4) != 0) {
            if (i2 == 3 && this.F1 != null) {
                y7();
                return;
            }
            if (i2 == 1) {
                this.z1.p(this.m2, this.n2, this.o2, this.s2, this.u2, this.r2, 1.0f, 1.0f, this.p2, this.q2, 0.0f, 0.0f, this.t2);
            }
            rb(0);
            return;
        }
        E0 e0 = this.v6;
        if (e0 != null && e0.getTag() != null) {
            this.w6.a.callOnClick();
            return;
        }
        this.R1 = false;
        try {
            AlertDialog alertDialog = this.G1;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.G1 = null;
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        if (this.z != null) {
            AbstractC21455b.t(this.b4);
            Hb(true);
        }
        int i3 = this.a4;
        if (i3 != 0) {
            if (i3 == 2) {
                this.E1.z0();
                this.z.removeView(this.E1);
                this.E1 = null;
            } else if (i3 == 1) {
                this.T0.setVisibility(8);
                this.y1.setVisibility(8);
            } else if (i3 == 3) {
                this.F1.shutdown();
                this.z.removeView(this.F1.getView());
                this.F1 = null;
                this.j6 = null;
            }
            this.a4 = 0;
        }
        View view = this.H;
        if (view != null) {
            view.setVisibility(0);
        }
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.setClipChildren(false);
        }
        if (this.m != null) {
            if ((!this.l3 && !this.c) || s7() || this.b == null) {
                return;
            }
            if (!this.K1.H() || z2) {
                Activity activity = this.m;
                if (activity != null && this.z3 != 0) {
                    activity.setRequestedOrientation(this.y3);
                    this.z3 = 0;
                    this.A3 = false;
                }
                if (!this.Z1 && !this.h6.isEmpty() && (i = this.p4) >= 0 && i < this.h6.size()) {
                    Object obj = this.h6.get(this.p4);
                    if (obj instanceof MediaController.l) {
                        ((MediaController.l) obj).m = c8();
                    }
                }
                final D0 placeForPhoto = this.b.getPlaceForPhoto(this.r4, g8(this.u4), this.p4, true);
                if (this.j2 != null && placeForPhoto != null && (animatedFileDrawableK = placeForPhoto.imageReceiver.k()) != null) {
                    if (this.j3 && (bitmapU0 = animatedFileDrawableK.u0()) != null) {
                        try {
                            Bitmap bitmap = this.h2.getBitmap(bitmapU0.getWidth(), bitmapU0.getHeight());
                            new Canvas(bitmapU0).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                            bitmap.recycle();
                        } catch (Throwable th) {
                            AbstractC6403Nl2.d(th);
                        }
                    }
                    if (this.r4 != null) {
                        long jF0 = animatedFileDrawableK.F0();
                        long jS1 = this.j2.s1();
                        if (jF0 <= 0) {
                            jF0 = 0;
                        }
                        animatedFileDrawableK.T0(jS1 + jF0, !C4278El2.H(this.r4.N).U(this.r4.I(), true));
                    }
                    placeForPhoto.imageReceiver.w0(true);
                    placeForPhoto.imageReceiver.u1();
                }
                if (!this.Z1) {
                    Aa(true);
                }
                PhotoViewerWebView photoViewerWebView = this.A;
                if (photoViewerWebView != null) {
                    photoViewerWebView.T();
                    this.z.removeView(this.A);
                    this.A = null;
                }
                this.K1.X();
                this.M3 = null;
                Ba();
                this.p = false;
                VelocityTracker velocityTracker = this.T5;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.T5 = null;
                }
                if (this.l3) {
                    this.l3 = false;
                    this.S3 = 0;
                    ia(placeForPhoto);
                    this.z.setScaleX(1.0f);
                    this.z.setScaleY(1.0f);
                    return;
                }
                if (z) {
                    ClippingImageView[] clippingImageViewArrV7 = V7(placeForPhoto);
                    for (int i4 = 0; i4 < clippingImageViewArrV7.length; i4++) {
                        clippingImageViewArrV7[i4].setAnimationValues(this.L3);
                        clippingImageViewArrV7[i4].setVisibility(0);
                    }
                    this.S3 = 3;
                    this.z.invalidate();
                    AnimatorSet animatorSet = new AnimatorSet();
                    ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
                    if (placeForPhoto != null) {
                        rectFU = placeForPhoto.imageReceiver.u();
                        layoutParams.width = (int) rectFU.width();
                        layoutParams.height = (int) rectFU.height();
                        int iQ = placeForPhoto.imageReceiver.Q();
                        int iJ = placeForPhoto.imageReceiver.j();
                        if (iJ != 0) {
                            iQ = iJ;
                        }
                        for (int i5 = 0; i5 < clippingImageViewArrV7.length; i5++) {
                            clippingImageViewArrV7[i5].setOrientation(iQ, placeForPhoto.imageReceiver.H());
                            clippingImageViewArrV7[i5].setImageBitmap(placeForPhoto.thumb);
                        }
                    } else {
                        layoutParams.width = (int) this.i4.E();
                        layoutParams.height = (int) this.i4.B();
                        for (int i6 = 0; i6 < clippingImageViewArrV7.length; i6++) {
                            clippingImageViewArrV7[i6].setOrientation(this.i4.Q(), this.i4.H());
                            clippingImageViewArrV7[i6].setImageBitmap(this.i4.n());
                        }
                        rectFU = null;
                    }
                    if (layoutParams.width <= 0) {
                        layoutParams.width = 100;
                    }
                    if (layoutParams.height <= 0) {
                        layoutParams.height = 100;
                    }
                    if (this.L1 == 1) {
                        float fMin2 = Math.min(this.y1.getMeasuredWidth(), (this.y1.getMeasuredHeight() - AbstractC21455b.F(64.0f)) - (A8() ? AbstractC21455b.d : 0)) - (AbstractC21455b.F(16.0f) * 2);
                        fMin = Math.max(fMin2 / layoutParams.width, fMin2 / layoutParams.height);
                    } else {
                        fMin = Math.min(this.B.getMeasuredWidth() / layoutParams.width, (AbstractC21455b.h.y + (A8() ? AbstractC21455b.d : 0)) / layoutParams.height);
                    }
                    float f = layoutParams.width;
                    float f2 = this.e5;
                    float f3 = layoutParams.height * f2 * fMin;
                    float measuredWidth = (this.B.getMeasuredWidth() - ((f * f2) * fMin)) / 2.0f;
                    float measuredHeight = this.L1 == 1 ? ((this.y1.getMeasuredHeight() - (A8() ? AbstractC21455b.d : 0)) - f3) / 2.0f : ((AbstractC21455b.h.y + (A8() ? AbstractC21455b.d : 0)) - f3) / 2.0f;
                    for (int i7 = 0; i7 < clippingImageViewArrV7.length; i7++) {
                        clippingImageViewArrV7[i7].setLayoutParams(layoutParams);
                        clippingImageViewArrV7[i7].setTranslationX(this.c5 + measuredWidth);
                        clippingImageViewArrV7[i7].setTranslationY(this.d5 + measuredHeight);
                        clippingImageViewArrV7[i7].setScaleX(this.e5 * fMin);
                        clippingImageViewArrV7[i7].setScaleY(this.e5 * fMin);
                    }
                    if (placeForPhoto != null) {
                        placeForPhoto.imageReceiver.t1(false, true);
                        int iAbs = (int) Math.abs(rectFU.left - placeForPhoto.imageReceiver.F());
                        int iAbs2 = (int) Math.abs(rectFU.top - placeForPhoto.imageReceiver.G());
                        int[] iArr = new int[2];
                        placeForPhoto.parentView.getLocationInWindow(iArr);
                        int i8 = iArr[1];
                        int i9 = placeForPhoto.viewY;
                        float f4 = rectFU.top;
                        int i10 = (int) ((i8 - (i9 + f4)) + placeForPhoto.clipTopAddition);
                        if (i10 < 0) {
                            i10 = 0;
                        }
                        int height = (int) ((((i9 + f4) + (rectFU.bottom - f4)) - (i8 + placeForPhoto.parentView.getHeight())) + placeForPhoto.clipBottomAddition);
                        if (height < 0) {
                            height = 0;
                        }
                        int iMax = Math.max(i10, iAbs2);
                        int iMax2 = Math.max(height, iAbs2);
                        this.L3[0][0] = this.D.getScaleX();
                        this.L3[0][1] = this.D.getScaleY();
                        this.L3[0][2] = this.D.getTranslationX();
                        this.L3[0][3] = this.D.getTranslationY();
                        float[][] fArr = this.L3;
                        float[] fArr2 = fArr[0];
                        fArr2[4] = 0.0f;
                        fArr2[5] = 0.0f;
                        fArr2[6] = 0.0f;
                        fArr2[7] = 0.0f;
                        fArr2[8] = 0.0f;
                        fArr2[9] = 0.0f;
                        fArr2[10] = 0.0f;
                        fArr2[11] = 0.0f;
                        fArr2[12] = 0.0f;
                        float[] fArr3 = fArr[1];
                        float f5 = placeForPhoto.scale;
                        fArr3[0] = f5;
                        fArr3[1] = f5;
                        fArr3[2] = placeForPhoto.viewX + (rectFU.left * f5);
                        fArr3[3] = placeForPhoto.viewY + (rectFU.top * f5);
                        float f6 = iAbs;
                        fArr3[4] = f6 * f5;
                        fArr3[5] = iMax * f5;
                        fArr3[6] = iMax2 * f5;
                        int i11 = 0;
                        for (int i12 = 4; i11 < i12; i12 = 4) {
                            this.L3[1][i11 + 7] = placeForPhoto.radius != null ? r11[i11] : 0.0f;
                            i11++;
                        }
                        float[] fArr4 = this.L3[1];
                        float f7 = placeForPhoto.scale;
                        fArr4[11] = iAbs2 * f7;
                        fArr4[12] = f6 * f7;
                        ArrayList arrayList = new ArrayList((this.L1 != 1 ? 2 : 3) + clippingImageViewArrV7.length + (clippingImageViewArrV7.length > 1 ? 1 : 0));
                        for (int i13 = 0; i13 < clippingImageViewArrV7.length; i13++) {
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(clippingImageViewArrV7[i13], (Property<ClippingImageView, Float>) AbstractC21469h.c, 0.0f, 1.0f);
                            if (i13 == 0) {
                                objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.R95
                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        this.a.J8(valueAnimator);
                                    }
                                });
                            }
                            arrayList.add(objectAnimatorOfFloat);
                        }
                        if (clippingImageViewArrV7.length > 1) {
                            arrayList.add(ObjectAnimator.ofFloat(this.D, (Property<ClippingImageView, Float>) View.ALPHA, 0.0f));
                            clippingImageViewArrV7[1].setAdditionalTranslationX(-l8());
                        }
                        arrayList.add(ObjectAnimator.ofInt(this.N0, (Property<BackgroundDrawable, Integer>) AbstractC21469h.b, 0));
                        w0 w0Var = this.z;
                        Property property = View.ALPHA;
                        arrayList.add(ObjectAnimator.ofFloat(w0Var, (Property<w0, Float>) property, 0.0f));
                        arrayList.add(ObjectAnimator.ofFloat(this.H, (Property<View, Float>) property, 0.0f));
                        if (this.L1 == 1) {
                            arrayList.add(ObjectAnimator.ofFloat(this.y1, (Property<PhotoCropView, Float>) property, 0.0f));
                        }
                        animatorSet.playTogether(arrayList);
                    } else {
                        int i14 = AbstractC21455b.h.y + (A8() ? AbstractC21455b.d : 0);
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.U95
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                this.a.K8(valueAnimator);
                            }
                        });
                        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.N0, (Property<BackgroundDrawable, Integer>) AbstractC21469h.b, 0);
                        ClippingImageView clippingImageView = this.D;
                        Property property2 = View.ALPHA;
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(clippingImageView, (Property<ClippingImageView, Float>) property2, 0.0f);
                        ClippingImageView clippingImageView2 = this.D;
                        Property property3 = View.TRANSLATION_Y;
                        if (this.d5 < 0.0f) {
                            i14 = -i14;
                        }
                        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfInt, objectAnimatorOfFloat2, ObjectAnimator.ofFloat(clippingImageView2, (Property<ClippingImageView, Float>) property3, i14), ObjectAnimator.ofFloat(this.z, (Property<w0, Float>) property2, 0.0f), ObjectAnimator.ofFloat(this.H, (Property<View, Float>) property2, 0.0f));
                    }
                    C0 c0 = this.b;
                    if (c0 != null) {
                        c0.onPreClose();
                    }
                    this.U3 = new Runnable() { // from class: ir.nasim.pa5
                        @Override // java.lang.Runnable
                        public final void run() throws InterruptedException {
                            this.a.L8(placeForPhoto);
                        }
                    };
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new C21484g0());
                    this.T3 = System.currentTimeMillis();
                    this.z.setLayerType(2, null);
                    animatorSet.start();
                    animatedFileDrawable = null;
                } else {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Aa5
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.a.M8(valueAnimator);
                        }
                    });
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.z, (Property<w0, Float>) View.SCALE_X, 0.9f);
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.z, (Property<w0, Float>) View.SCALE_Y, 0.9f);
                    ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.N0, (Property<BackgroundDrawable, Integer>) AbstractC21469h.b, 0);
                    w0 w0Var2 = this.z;
                    Property property4 = View.ALPHA;
                    animatorSet2.playTogether(valueAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfInt2, ObjectAnimator.ofFloat(w0Var2, (Property<w0, Float>) property4, 0.0f), ObjectAnimator.ofFloat(this.H, (Property<View, Float>) property4, 0.0f));
                    C0 c02 = this.b;
                    if (c02 != null) {
                        c02.onPreClose();
                    }
                    this.S3 = 2;
                    this.U3 = new Runnable() { // from class: ir.nasim.La5
                        @Override // java.lang.Runnable
                        public final void run() throws InterruptedException {
                            this.a.N8(placeForPhoto);
                        }
                    };
                    animatorSet2.setDuration(200L);
                    animatorSet2.addListener(new C21486h0());
                    this.T3 = System.currentTimeMillis();
                    animatedFileDrawable = null;
                    this.z.setLayerType(2, null);
                    animatorSet2.start();
                    if (placeForPhoto != null) {
                        placeForPhoto.imageReceiver.t1(true, true);
                    }
                }
                AnimatedFileDrawable animatedFileDrawable2 = this.P1;
                if (animatedFileDrawable2 != null) {
                    animatedFileDrawable2.Q0(this.z);
                    this.P1 = animatedFileDrawable;
                    this.i4.W0(animatedFileDrawable);
                }
                C0 c03 = this.b;
                if (c03 == null || c03.canScrollAway()) {
                    return;
                }
                this.b.cancelButtonPressed();
            }
        }
    }

    public void za(final int i) {
        w0 w0Var;
        if (i >= 6 || (w0Var = this.z) == null) {
            return;
        }
        w0Var.invalidate();
        AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.Da5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h9(i);
            }
        }, 100L);
    }

    public static class u0 implements C0 {
        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean allowCaption() {
            return true;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean canScrollAway() {
            return true;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean cancelButtonPressed() {
            return true;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean closeKeyboard() {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public String getDeleteMessageString() {
            return null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int getPhotoIndex(int i) {
            return -1;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int getSelectedCount() {
            return 0;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public HashMap getSelectedPhotos() {
            return null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public ArrayList getSelectedPhotosOrder() {
            return null;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int getTotalImageCount() {
            return -1;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean isPhotoChecked(int i) {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean loadMore() {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void needAddMorePhotos() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onApplyCaption(CharSequence charSequence) {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onCaptionChanged(CharSequence charSequence) {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onClose() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onOpen() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void openPhotoForEdit(String str, String str2, boolean z) {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean scaleToFill() {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int setPhotoChecked(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
            return -1;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int setPhotoUnchecked(Object obj) {
            return -1;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void updatePhotoAtIndex(int i) {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void willHidePhotoViewer() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
        }
    }
}
