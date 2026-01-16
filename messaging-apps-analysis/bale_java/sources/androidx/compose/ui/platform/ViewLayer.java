package androidx.compose.ui.platform;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.graphics.a;
import ir.nasim.AV3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11654dN4;
import ir.nasim.C19938rB7;
import ir.nasim.C21226tK2;
import ir.nasim.C21853uF0;
import ir.nasim.C22045ua3;
import ir.nasim.C6908Pm4;
import ir.nasim.C7390Rn;
import ir.nasim.C7448Rt3;
import ir.nasim.DX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC23124wO4;
import ir.nasim.MK5;
import ir.nasim.SA2;
import ir.nasim.UE0;
import ir.nasim.V05;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002$8BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001fJ!\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020&H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010*J7\u00101\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020,H\u0014¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b3\u0010*J\u000f\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u0010*J\u000f\u00105\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u0010*J\"\u00108\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:2\u0006\u00107\u001a\u00020\u0015H\u0016¢\u0006\u0004\b<\u0010=J9\u00100\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¢\u0006\u0004\b0\u0010>J\u001a\u0010A\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020?H\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020?H\u0016ø\u0001\u0000¢\u0006\u0004\bC\u0010BJ\u000f\u0010D\u001a\u00020\u000bH\u0002¢\u0006\u0004\bD\u0010*J\u000f\u0010E\u001a\u00020\u000bH\u0002¢\u0006\u0004\bE\u0010*R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bA\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b0\u0010I\u001a\u0004\bJ\u0010KR,\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010LR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010MR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010OR\u0016\u0010R\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010TR*\u0010Z\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010Q\u001a\u0004\bW\u0010\u0017\"\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010QR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010]R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00010_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010`R\u001c\u0010d\u001a\u00020b8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b-\u0010cR\u0016\u0010f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010QR\u001a\u0010k\u001a\u00020g8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bh\u0010c\u001a\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u001a\u0010q\u001a\u00020?8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020g8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010jR$\u0010y\u001a\u00020t2\u0006\u0010V\u001a\u00020t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0016\u0010}\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u007f"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Lir/nasim/wO4;", "", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "Landroidx/compose/ui/platform/DrawChildContainer;", "container", "Lkotlin/Function2;", "Lir/nasim/UE0;", "Lir/nasim/tK2;", "Lir/nasim/rB7;", "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lir/nasim/iB2;Lir/nasim/SA2;)V", "Landroidx/compose/ui/graphics/d;", "scope", "h", "(Landroidx/compose/ui/graphics/d;)V", "", "hasOverlappingRendering", "()Z", "Lir/nasim/ZG4;", "position", "g", "(J)Z", "Lir/nasim/Fa3;", "size", "e", "(J)V", "Lir/nasim/ua3;", "j", "canvas", "parentLayer", "c", "(Lir/nasim/UE0;Lir/nasim/tK2;)V", "Landroid/graphics/Canvas;", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "invalidate", "()V", "changed", "", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "destroy", "k", "forceLayout", "point", "inverse", "d", "(JZ)J", "Lir/nasim/Pm4;", "rect", "f", "(Lir/nasim/Pm4;Z)V", "(Lir/nasim/iB2;Lir/nasim/SA2;)V", "Lir/nasim/AV3;", "matrix", "a", "([F)V", "i", "w", "v", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroidx/compose/ui/platform/DrawChildContainer;", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "Lir/nasim/iB2;", "Lir/nasim/SA2;", "Lir/nasim/dN4;", "Lir/nasim/dN4;", "outlineResolver", "Z", "clipToBounds", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "clipBoundsCache", "value", "u", "setInvalidated", "(Z)V", "isInvalidated", "drawnWithZ", "Lir/nasim/uF0;", "Lir/nasim/uF0;", "canvasHolder", "Lir/nasim/Rt3;", "Lir/nasim/Rt3;", "matrixCache", "Landroidx/compose/ui/graphics/f;", "J", "mTransformOrigin", "m", "mHasOverlappingRendering", "", "n", "getLayerId", "()J", "layerId", "o", TokenNames.I, "mutatedFields", "getUnderlyingMatrix-sQKQjiQ", "()[F", "underlyingMatrix", "getOwnerViewId", "ownerViewId", "", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "cameraDistancePx", "Lir/nasim/V05;", "getManualClipPath", "()Lir/nasim/V05;", "manualClipPath", "p", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ViewLayer extends View implements InterfaceC23124wO4 {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q = 8;
    private static final InterfaceC14603iB2 r = b.e;
    private static final ViewOutlineProvider s = new a();
    private static Method t;
    private static Field u;
    private static boolean v;
    private static boolean w;

    /* renamed from: a, reason: from kotlin metadata */
    private final AndroidComposeView ownerView;

    /* renamed from: b, reason: from kotlin metadata */
    private final DrawChildContainer container;

    /* renamed from: c, reason: from kotlin metadata */
    private InterfaceC14603iB2 drawBlock;

    /* renamed from: d, reason: from kotlin metadata */
    private SA2 invalidateParentLayer;

    /* renamed from: e, reason: from kotlin metadata */
    private final C11654dN4 outlineResolver;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean clipToBounds;

    /* renamed from: g, reason: from kotlin metadata */
    private Rect clipBoundsCache;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isInvalidated;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean drawnWithZ;

    /* renamed from: j, reason: from kotlin metadata */
    private final C21853uF0 canvasHolder;

    /* renamed from: k, reason: from kotlin metadata */
    private final C7448Rt3 matrixCache;

    /* renamed from: l, reason: from kotlin metadata */
    private long mTransformOrigin;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean mHasOverlappingRendering;

    /* renamed from: n, reason: from kotlin metadata */
    private final long layerId;

    /* renamed from: o, reason: from kotlin metadata */
    private int mutatedFields;

    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            Outline outlineB = ((ViewLayer) view).outlineResolver.b();
            AbstractC13042fc3.f(outlineB);
            outline.set(outlineB);
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        public final void a(View view, Matrix matrix) {
            matrix.set(view.getMatrix());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((View) obj, (Matrix) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: androidx.compose.ui.platform.ViewLayer$c, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final boolean a() {
            return ViewLayer.v;
        }

        public final boolean b() {
            return ViewLayer.w;
        }

        public final void c(boolean z) {
            ViewLayer.w = z;
        }

        public final void d(View view) {
            try {
                if (!a()) {
                    ViewLayer.v = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.t = View.class.getDeclaredMethod("updateDisplayListIfDirty", null);
                        ViewLayer.u = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.t = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.u = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.t;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.u;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.u;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.t;
                if (method2 != null) {
                    method2.invoke(view, null);
                }
            } catch (Throwable unused) {
                c(true);
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private static final class d {
        public static final d a = new d();

        private d() {
        }

        public static final long a(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
        super(androidComposeView.getContext());
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = interfaceC14603iB2;
        this.invalidateParentLayer = sa2;
        this.outlineResolver = new C11654dN4();
        this.canvasHolder = new C21853uF0();
        this.matrixCache = new C7448Rt3(r);
        this.mTransformOrigin = androidx.compose.ui.graphics.f.b.a();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final V05 getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.e()) {
            return null;
        }
        return this.outlineResolver.d();
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.H0(this, z);
        }
    }

    private final void v() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                AbstractC13042fc3.f(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void w() {
        setOutlineProvider(this.outlineResolver.b() != null ? s : null);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void a(float[] matrix) {
        AV3.l(matrix, this.matrixCache.b(this));
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void b(InterfaceC14603iB2 drawBlock, SA2 invalidateParentLayer) {
        this.container.addView(this);
        this.matrixCache.h();
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = androidx.compose.ui.graphics.f.b.a();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        setInvalidated(false);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void c(UE0 canvas, C21226tK2 parentLayer) {
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.k();
        }
        this.container.a(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.p();
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public long d(long point, boolean inverse) {
        return inverse ? this.matrixCache.g(this, point) : this.matrixCache.e(this, point);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void destroy() {
        setInvalidated(false);
        this.ownerView.S0();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.Q0(this);
        this.container.removeViewInLayout(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z;
        C21853uF0 c21853uF0 = this.canvasHolder;
        Canvas canvasA = c21853uF0.a().a();
        c21853uF0.a().y(canvas);
        C7390Rn c7390RnA = c21853uF0.a();
        if (getManualClipPath() == null && canvas.isHardwareAccelerated()) {
            z = false;
        } else {
            c7390RnA.n();
            this.outlineResolver.a(c7390RnA);
            z = true;
        }
        InterfaceC14603iB2 interfaceC14603iB2 = this.drawBlock;
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(c7390RnA, null);
        }
        if (z) {
            c7390RnA.i();
        }
        c21853uF0.a().y(canvasA);
        setInvalidated(false);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void e(long size) {
        int i = (int) (size >> 32);
        int i2 = (int) (size & 4294967295L);
        if (i == getWidth() && i2 == getHeight()) {
            return;
        }
        setPivotX(androidx.compose.ui.graphics.f.f(this.mTransformOrigin) * i);
        setPivotY(androidx.compose.ui.graphics.f.g(this.mTransformOrigin) * i2);
        w();
        layout(getLeft(), getTop(), getLeft() + i, getTop() + i2);
        v();
        this.matrixCache.c();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void f(C6908Pm4 rect, boolean inverse) {
        if (inverse) {
            this.matrixCache.f(this, rect);
        } else {
            this.matrixCache.d(this, rect);
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public boolean g(long position) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & position));
        if (this.clipToBounds) {
            return 0.0f <= fIntBitsToFloat && fIntBitsToFloat < ((float) getWidth()) && 0.0f <= fIntBitsToFloat2 && fIntBitsToFloat2 < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.f(position);
        }
        return true;
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public long getLayerId() {
        return this.layerId;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return d.a(this.ownerView);
        }
        return -1L;
    }

    @Override // ir.nasim.InterfaceC23124wO4
    /* renamed from: getUnderlyingMatrix-sQKQjiQ, reason: not valid java name */
    public float[] mo2getUnderlyingMatrixsQKQjiQ() {
        return this.matrixCache.b(this);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void h(androidx.compose.ui.graphics.d scope) {
        SA2 sa2;
        int iZ = scope.z() | this.mutatedFields;
        if ((iZ & 4096) != 0) {
            long jZ0 = scope.z0();
            this.mTransformOrigin = jZ0;
            setPivotX(androidx.compose.ui.graphics.f.f(jZ0) * getWidth());
            setPivotY(androidx.compose.ui.graphics.f.g(this.mTransformOrigin) * getHeight());
        }
        if ((iZ & 1) != 0) {
            setScaleX(scope.A());
        }
        if ((iZ & 2) != 0) {
            setScaleY(scope.K());
        }
        if ((iZ & 4) != 0) {
            setAlpha(scope.b());
        }
        if ((iZ & 8) != 0) {
            setTranslationX(scope.H());
        }
        if ((iZ & 16) != 0) {
            setTranslationY(scope.G());
        }
        if ((iZ & 32) != 0) {
            setElevation(scope.F());
        }
        if ((iZ & 1024) != 0) {
            setRotation(scope.s());
        }
        if ((iZ & 256) != 0) {
            setRotationX(scope.I());
        }
        if ((iZ & 512) != 0) {
            setRotationY(scope.r());
        }
        if ((iZ & 2048) != 0) {
            setCameraDistancePx(scope.w());
        }
        boolean z = false;
        boolean z2 = getManualClipPath() != null;
        boolean z3 = scope.o() && scope.J() != MK5.a();
        if ((iZ & 24576) != 0) {
            this.clipToBounds = scope.o() && scope.J() == MK5.a();
            v();
            setClipToOutline(z3);
        }
        boolean zH = this.outlineResolver.h(scope.C(), scope.b(), z3, scope.F(), scope.d());
        if (this.outlineResolver.c()) {
            w();
        }
        boolean z4 = getManualClipPath() != null;
        if (z2 != z4 || (z4 && zH)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (sa2 = this.invalidateParentLayer) != null) {
            sa2.invoke();
        }
        if ((iZ & 7963) != 0) {
            this.matrixCache.c();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            if ((iZ & 64) != 0) {
                w.a.a(this, DX0.k(scope.h()));
            }
            if ((iZ & 128) != 0) {
                w.a.b(this, DX0.k(scope.M()));
            }
        }
        if (i >= 31 && (131072 & iZ) != 0) {
            x xVar = x.a;
            scope.E();
            xVar.a(this, null);
        }
        if ((iZ & 32768) != 0) {
            int iP = scope.p();
            a.C0063a c0063a = androidx.compose.ui.graphics.a.a;
            if (androidx.compose.ui.graphics.a.e(iP, c0063a.c())) {
                setLayerType(2, null);
            } else if (androidx.compose.ui.graphics.a.e(iP, c0063a.b())) {
                setLayerType(0, null);
                this.mHasOverlappingRendering = z;
            } else {
                setLayerType(0, null);
            }
            z = true;
            this.mHasOverlappingRendering = z;
        }
        this.mutatedFields = scope.z();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void i(float[] matrix) {
        float[] fArrA = this.matrixCache.a(this);
        if (fArrA != null) {
            AV3.l(matrix, fArrA);
        }
    }

    @Override // android.view.View, ir.nasim.InterfaceC23124wO4
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void j(long position) {
        int iK = C22045ua3.k(position);
        if (iK != getLeft()) {
            offsetLeftAndRight(iK - getLeft());
            this.matrixCache.c();
        }
        int iL = C22045ua3.l(position);
        if (iL != getTop()) {
            offsetTopAndBottom(iL - getTop());
            this.matrixCache.c();
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void k() {
        if (!this.isInvalidated || w) {
            return;
        }
        INSTANCE.d(this);
        setInvalidated(false);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t2, int r2, int b2) {
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * getResources().getDisplayMetrics().densityDpi);
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }
}
