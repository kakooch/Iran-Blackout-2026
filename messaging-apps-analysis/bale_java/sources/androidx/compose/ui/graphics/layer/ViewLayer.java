package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import ir.nasim.C20576sF0;
import ir.nasim.C21226tK2;
import ir.nasim.C21853uF0;
import ir.nasim.C7390Rn;
import ir.nasim.EnumC12613eu3;
import ir.nasim.OD6;
import ir.nasim.UA2;
import ir.nasim.UE0;
import ir.nasim.WH1;
import ir.nasim.YZ1;
import ir.nasim.ZZ1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b&\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001'B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J7\u0010(\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010\u001bR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b'\u0010/\u001a\u0004\b0\u00101R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00102R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b'\u0010\u001d\"\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R*\u0010?\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u00104\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u00106R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006I"}, d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/view/View;", "ownerView", "Lir/nasim/uF0;", "canvasHolder", "Lir/nasim/sF0;", "canvasDrawScope", "<init>", "(Landroid/view/View;Lir/nasim/uF0;Lir/nasim/sF0;)V", "Landroid/graphics/Outline;", "outline", "", "c", "(Landroid/graphics/Outline;)Z", "Lir/nasim/WH1;", "density", "Lir/nasim/eu3;", "layoutDirection", "Lir/nasim/tK2;", "parentLayer", "Lkotlin/Function1;", "Lir/nasim/n02;", "Lir/nasim/rB7;", "drawBlock", "setDrawParams", "(Lir/nasim/WH1;Lir/nasim/eu3;Lir/nasim/tK2;Lir/nasim/UA2;)V", "invalidate", "()V", "hasOverlappingRendering", "()Z", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "changed", "", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "forceLayout", "a", "Landroid/view/View;", "getOwnerView", "()Landroid/view/View;", "Lir/nasim/uF0;", "getCanvasHolder", "()Lir/nasim/uF0;", "Lir/nasim/sF0;", "d", "Z", "setInvalidated", "(Z)V", "isInvalidated", "e", "Landroid/graphics/Outline;", "layerOutline", "value", "f", "getCanUseCompositingLayer$ui_graphics_release", "setCanUseCompositingLayer$ui_graphics_release", "canUseCompositingLayer", "g", "Lir/nasim/WH1;", "h", "Lir/nasim/eu3;", "i", "Lir/nasim/UA2;", "j", "Lir/nasim/tK2;", "k", "ui-graphics_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ViewLayer extends View {
    private static final ViewOutlineProvider l = new a();

    /* renamed from: a, reason: from kotlin metadata */
    private final View ownerView;

    /* renamed from: b, reason: from kotlin metadata */
    private final C21853uF0 canvasHolder;

    /* renamed from: c, reason: from kotlin metadata */
    private final C20576sF0 canvasDrawScope;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isInvalidated;

    /* renamed from: e, reason: from kotlin metadata */
    private Outline layerOutline;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean canUseCompositingLayer;

    /* renamed from: g, reason: from kotlin metadata */
    private WH1 density;

    /* renamed from: h, reason: from kotlin metadata */
    private EnumC12613eu3 layoutDirection;

    /* renamed from: i, reason: from kotlin metadata */
    private UA2 drawBlock;

    /* renamed from: j, reason: from kotlin metadata */
    private C21226tK2 parentLayer;

    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Outline outline2;
            if (!(view instanceof ViewLayer) || (outline2 = ((ViewLayer) view).layerOutline) == null) {
                return;
            }
            outline.set(outline2);
        }
    }

    public ViewLayer(View view, C21853uF0 c21853uF0, C20576sF0 c20576sF0) {
        super(view.getContext());
        this.ownerView = view;
        this.canvasHolder = c21853uF0;
        this.canvasDrawScope = c20576sF0;
        setOutlineProvider(l);
        this.canUseCompositingLayer = true;
        this.density = ZZ1.a();
        this.layoutDirection = EnumC12613eu3.a;
        this.drawBlock = androidx.compose.ui.graphics.layer.a.a.a();
        setWillNotDraw(false);
        setClipBounds(null);
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    public final boolean c(Outline outline) {
        this.layerOutline = outline;
        return b.a.a(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        C21853uF0 c21853uF0 = this.canvasHolder;
        Canvas canvasA = c21853uF0.a().a();
        c21853uF0.a().y(canvas);
        C7390Rn c7390RnA = c21853uF0.a();
        C20576sF0 c20576sF0 = this.canvasDrawScope;
        WH1 wh1 = this.density;
        EnumC12613eu3 enumC12613eu3 = this.layoutDirection;
        float width = getWidth();
        float height = getHeight();
        long jD = OD6.d((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32));
        C21226tK2 c21226tK2 = this.parentLayer;
        UA2 ua2 = this.drawBlock;
        WH1 density = c20576sF0.z1().getDensity();
        EnumC12613eu3 layoutDirection = c20576sF0.z1().getLayoutDirection();
        UE0 ue0E = c20576sF0.z1().e();
        long jD2 = c20576sF0.z1().d();
        C21226tK2 c21226tK2I = c20576sF0.z1().i();
        YZ1 yz1Z1 = c20576sF0.z1();
        yz1Z1.f(wh1);
        yz1Z1.c(enumC12613eu3);
        yz1Z1.a(c7390RnA);
        yz1Z1.g(jD);
        yz1Z1.h(c21226tK2);
        c7390RnA.n();
        try {
            ua2.invoke(c20576sF0);
            c7390RnA.i();
            YZ1 yz1Z12 = c20576sF0.z1();
            yz1Z12.f(density);
            yz1Z12.c(layoutDirection);
            yz1Z12.a(ue0E);
            yz1Z12.g(jD2);
            yz1Z12.h(c21226tK2I);
            c21853uF0.a().y(canvasA);
            this.isInvalidated = false;
        } catch (Throwable th) {
            c7390RnA.i();
            YZ1 yz1Z13 = c20576sF0.z1();
            yz1Z13.f(density);
            yz1Z13.c(layoutDirection);
            yz1Z13.a(ue0E);
            yz1Z13.g(jD2);
            yz1Z13.h(c21226tK2I);
            throw th;
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    /* renamed from: getCanUseCompositingLayer$ui_graphics_release, reason: from getter */
    public final boolean getCanUseCompositingLayer() {
        return this.canUseCompositingLayer;
    }

    public final C21853uF0 getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        this.isInvalidated = true;
        super.invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l2, int t, int r, int b) {
    }

    public final void setCanUseCompositingLayer$ui_graphics_release(boolean z) {
        if (this.canUseCompositingLayer != z) {
            this.canUseCompositingLayer = z;
            invalidate();
        }
    }

    public final void setDrawParams(WH1 density, EnumC12613eu3 layoutDirection, C21226tK2 parentLayer, UA2 drawBlock) {
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = drawBlock;
        this.parentLayer = parentLayer;
    }

    public final void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }
}
