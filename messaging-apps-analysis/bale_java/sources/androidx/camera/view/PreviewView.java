package androidx.camera.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.view.i;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC14447hv7;
import ir.nasim.AbstractC16775lq5;
import ir.nasim.AbstractC17949np7;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4217Ee4;
import ir.nasim.C20298rm4;
import ir.nasim.C22022uX7;
import ir.nasim.C24677z13;
import ir.nasim.C8112Uo5;
import ir.nasim.InterfaceC14623iD0;
import ir.nasim.InterfaceC15221jD0;
import ir.nasim.LC0;
import ir.nasim.LN4;
import ir.nasim.Oc8;
import ir.nasim.PI3;
import ir.nasim.QE5;
import ir.nasim.Z27;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class PreviewView extends FrameLayout {
    private static final c p = c.PERFORMANCE;
    c a;
    i b;
    final ScreenFlashView c;
    final androidx.camera.view.e d;
    boolean e;
    final C20298rm4 f;
    final AtomicReference g;
    Executor h;
    j i;
    private final Oc8 j;
    InterfaceC14623iD0 k;
    private MotionEvent l;
    private final b m;
    private final View.OnLayoutChangeListener n;
    final C8112Uo5.c o;

    class a implements C8112Uo5.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Z27 z27) {
            PreviewView.this.o.a(z27);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(InterfaceC15221jD0 interfaceC15221jD0, Z27 z27, Z27.h hVar) {
            PreviewView previewView;
            i iVar;
            PI3.a("PreviewView", "Preview transformation info updated. " + hVar);
            PreviewView.this.d.r(hVar, z27.o(), interfaceC15221jD0.j().d() == 0);
            if (hVar.d() == -1 || ((iVar = (previewView = PreviewView.this).b) != null && (iVar instanceof n))) {
                PreviewView.this.e = true;
            } else {
                previewView.e = false;
            }
            PreviewView.this.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(androidx.camera.view.d dVar, InterfaceC15221jD0 interfaceC15221jD0) {
            if (AbstractC16775lq5.a(PreviewView.this.g, dVar, null)) {
                dVar.m(f.IDLE);
            }
            dVar.g();
            interfaceC15221jD0.o().b(dVar);
        }

        @Override // ir.nasim.C8112Uo5.c
        public void a(final Z27 z27) {
            i nVar;
            if (!AbstractC17949np7.c()) {
                AbstractC4043Dl1.i(PreviewView.this.getContext()).execute(new Runnable() { // from class: androidx.camera.view.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e(z27);
                    }
                });
                return;
            }
            PI3.a("PreviewView", "Surface requested by Preview.");
            final InterfaceC15221jD0 interfaceC15221jD0L = z27.l();
            PreviewView.this.k = interfaceC15221jD0L.j();
            PreviewView.this.i.c(interfaceC15221jD0L.b().c());
            z27.C(AbstractC4043Dl1.i(PreviewView.this.getContext()), new Z27.i() { // from class: androidx.camera.view.g
                @Override // ir.nasim.Z27.i
                public final void a(Z27.h hVar) {
                    this.a.f(interfaceC15221jD0L, z27, hVar);
                }
            });
            PreviewView previewView = PreviewView.this;
            if (!PreviewView.f(previewView.b, z27, previewView.a)) {
                PreviewView previewView2 = PreviewView.this;
                if (PreviewView.g(z27, previewView2.a)) {
                    PreviewView previewView3 = PreviewView.this;
                    nVar = new t(previewView3, previewView3.d);
                } else {
                    PreviewView previewView4 = PreviewView.this;
                    nVar = new n(previewView4, previewView4.d);
                }
                previewView2.b = nVar;
            }
            InterfaceC14623iD0 interfaceC14623iD0J = interfaceC15221jD0L.j();
            PreviewView previewView5 = PreviewView.this;
            final androidx.camera.view.d dVar = new androidx.camera.view.d(interfaceC14623iD0J, previewView5.f, previewView5.b);
            PreviewView.this.g.set(dVar);
            interfaceC15221jD0L.o().a(AbstractC4043Dl1.i(PreviewView.this.getContext()), dVar);
            PreviewView.this.b.g(z27, new i.a() { // from class: androidx.camera.view.h
                @Override // androidx.camera.view.i.a
                public final void a() {
                    this.a.g(dVar, interfaceC15221jD0L);
                }
            });
            PreviewView previewView6 = PreviewView.this;
            if (previewView6.indexOfChild(previewView6.c) == -1) {
                PreviewView previewView7 = PreviewView.this;
                previewView7.addView(previewView7.c);
            }
            PreviewView.this.getClass();
        }
    }

    class b implements DisplayManager.DisplayListener {
        b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            Display display = PreviewView.this.getDisplay();
            if (display == null || display.getDisplayId() != i) {
                return;
            }
            PreviewView.this.e();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public enum c {
        PERFORMANCE(0),
        COMPATIBLE(1);

        private final int a;

        c(int i) {
            this.a = i;
        }

        static c j(int i) {
            for (c cVar : values()) {
                if (cVar.a == i) {
                    return cVar;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i);
        }

        int p() {
            return this.a;
        }
    }

    public interface d {
    }

    public enum e {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);

        private final int a;

        e(int i) {
            this.a = i;
        }

        static e j(int i) {
            for (e eVar : values()) {
                if (eVar.a == i) {
                    return eVar;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i);
        }

        int p() {
            return this.a;
        }
    }

    public enum f {
        IDLE,
        STREAMING
    }

    public PreviewView(Context context) {
        this(context, null);
    }

    private void b(boolean z) {
        AbstractC17949np7.a();
        getViewPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
            return;
        }
        e();
        b(true);
    }

    static boolean f(i iVar, Z27 z27, c cVar) {
        return (iVar instanceof n) && !g(z27, cVar);
    }

    static boolean g(Z27 z27, c cVar) {
        boolean zEquals = z27.l().j().j().equals("androidx.camera.camera2.legacy");
        boolean z = (androidx.camera.view.internal.compat.quirk.a.b(SurfaceViewStretchedQuirk.class) == null && androidx.camera.view.internal.compat.quirk.a.b(SurfaceViewNotCroppedByParentQuirk.class) == null) ? false : true;
        if (Build.VERSION.SDK_INT <= 24 || zEquals || z) {
            return true;
        }
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1) {
            return true;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + cVar);
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private C24677z13.f getScreenFlashInternal() {
        return this.c.getScreenFlash();
    }

    private int getViewPortScaleType() {
        int iOrdinal = getScaleType().ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    throw new IllegalStateException("Unexpected scale type: " + getScaleType());
                }
            }
        }
        return i;
    }

    private void h() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.registerDisplayListener(this.m, new Handler(Looper.getMainLooper()));
    }

    private void i() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.m);
    }

    private void setScreenFlashUiInfo(C24677z13.f fVar) {
        PI3.a("PreviewView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public C22022uX7 c(int i) {
        AbstractC17949np7.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new C22022uX7.a(new Rational(getWidth(), getHeight()), i).c(getViewPortScaleType()).b(getLayoutDirection()).a();
    }

    void e() {
        AbstractC17949np7.a();
        if (this.b != null) {
            j();
            this.b.h();
        }
        this.i.b(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Bitmap getBitmap() {
        AbstractC17949np7.a();
        i iVar = this.b;
        if (iVar == null) {
            return null;
        }
        return iVar.a();
    }

    public LC0 getController() {
        AbstractC17949np7.a();
        return null;
    }

    public c getImplementationMode() {
        AbstractC17949np7.a();
        return this.a;
    }

    public AbstractC4217Ee4 getMeteringPointFactory() {
        AbstractC17949np7.a();
        return this.i;
    }

    public LN4 getOutputTransform() {
        Matrix matrixJ;
        AbstractC17949np7.a();
        try {
            matrixJ = this.d.j(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrixJ = null;
        }
        Rect rectI = this.d.i();
        if (matrixJ == null || rectI == null) {
            PI3.a("PreviewView", "Transform info is not ready");
            return null;
        }
        matrixJ.preConcat(AbstractC14447hv7.b(rectI));
        if (this.b instanceof t) {
            matrixJ.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            PI3.l("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        return new LN4(matrixJ, new Size(rectI.width(), rectI.height()));
    }

    public androidx.lifecycle.r getPreviewStreamState() {
        return this.f;
    }

    public e getScaleType() {
        AbstractC17949np7.a();
        return this.d.g();
    }

    public C24677z13.f getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        AbstractC17949np7.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return this.d.h(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public C8112Uo5.c getSurfaceProvider() {
        AbstractC17949np7.a();
        return this.o;
    }

    public C22022uX7 getViewPort() {
        AbstractC17949np7.a();
        if (getDisplay() == null) {
            return null;
        }
        return c(getDisplay().getRotation());
    }

    void j() {
        Display display;
        InterfaceC14623iD0 interfaceC14623iD0;
        if (!this.e || (display = getDisplay()) == null || (interfaceC14623iD0 = this.k) == null) {
            return;
        }
        this.d.o(interfaceC14623iD0.k(display.getRotation()), display.getRotation());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        addOnLayoutChangeListener(this.n);
        i iVar = this.b;
        if (iVar != null) {
            iVar.d();
        }
        b(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.n);
        i iVar = this.b;
        if (iVar != null) {
            iVar.e();
        }
        i();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        this.l = null;
        return super.performClick();
    }

    public void setController(LC0 lc0) {
        AbstractC17949np7.a();
        b(false);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setFrameUpdateListener(Executor executor, d dVar) {
        if (this.a == c.PERFORMANCE) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
        this.h = executor;
        i iVar = this.b;
        if (iVar != null) {
            iVar.i(executor, dVar);
        }
    }

    public void setImplementationMode(c cVar) {
        AbstractC17949np7.a();
        this.a = cVar;
        c cVar2 = c.PERFORMANCE;
    }

    public void setScaleType(e eVar) {
        AbstractC17949np7.a();
        this.d.q(eVar);
        e();
        b(false);
    }

    public void setScreenFlashOverlayColor(int i) {
        this.c.setBackgroundColor(i);
    }

    public void setScreenFlashWindow(Window window) {
        AbstractC17949np7.a();
        this.c.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        c cVar = p;
        this.a = cVar;
        androidx.camera.view.e eVar = new androidx.camera.view.e();
        this.d = eVar;
        this.e = true;
        this.f = new C20298rm4(f.IDLE);
        this.g = new AtomicReference();
        this.i = new j(eVar);
        this.m = new b();
        this.n = new View.OnLayoutChangeListener() { // from class: ir.nasim.cq5
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                this.a.d(view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        };
        this.o = new a();
        AbstractC17949np7.a();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, QE5.PreviewView, i, i2);
        AbstractC12990fW7.n0(this, context, QE5.PreviewView, attributeSet, typedArrayObtainStyledAttributes, i, i2);
        try {
            setScaleType(e.j(typedArrayObtainStyledAttributes.getInteger(QE5.PreviewView_scaleType, eVar.g().p())));
            setImplementationMode(c.j(typedArrayObtainStyledAttributes.getInteger(QE5.PreviewView_implementationMode, cVar.p())));
            typedArrayObtainStyledAttributes.recycle();
            this.j = new Oc8(context, new Oc8.b() { // from class: ir.nasim.eq5
            });
            if (getBackground() == null) {
                setBackgroundColor(AbstractC4043Dl1.c(getContext(), R.color.black));
            }
            ScreenFlashView screenFlashView = new ScreenFlashView(context);
            this.c = screenFlashView;
            screenFlashView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
