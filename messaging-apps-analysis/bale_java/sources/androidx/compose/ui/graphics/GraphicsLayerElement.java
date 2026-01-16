package androidx.compose.ui.graphics;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.ON5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b+\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00100R\u0017\u0010\t\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u00100R\u0017\u0010\n\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u00100R\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b=\u0010.\u001a\u0004\b>\u00100R\u0017\u0010\f\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b?\u0010.\u001a\u0004\b@\u00100R\u0017\u0010\r\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bA\u0010.\u001a\u0004\bB\u00100R\u001d\u0010\u000f\u001a\u00020\u000e8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b!\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001d\u0010\u0017\u001a\u00020\u00168\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bM\u0010C\u001a\u0004\bN\u0010ER\u001d\u0010\u0018\u001a\u00020\u00168\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bO\u0010C\u001a\u0004\bP\u0010ER\u001d\u0010\u001a\u001a\u00020\u00198\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/graphics/e;", "", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "Landroidx/compose/ui/graphics/f;", "transformOrigin", "Lir/nasim/ax6;", "shape", "", "clip", "Lir/nasim/ON5;", "renderEffect", "Lir/nasim/yX0;", "ambientShadowColor", "spotShadowColor", "Landroidx/compose/ui/graphics/a;", "compositingStrategy", "<init>", "(FFFFFFFFFFJLir/nasim/ax6;ZLir/nasim/ON5;JJILir/nasim/ED1;)V", "l", "()Landroidx/compose/ui/graphics/e;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/graphics/e;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", TokenNames.F, "getScaleX", "()F", "c", "getScaleY", "d", "getAlpha", "e", "getTranslationX", "f", "getTranslationY", "g", "getShadowElevation", "h", "getRotationX", "i", "getRotationY", "j", "getRotationZ", "k", "getCameraDistance", "J", "getTransformOrigin-SzJe1aQ", "()J", "Lir/nasim/ax6;", "getShape", "()Lir/nasim/ax6;", "n", "Z", "getClip", "()Z", "o", "getAmbientShadowColor-0d7_KjU", "p", "getSpotShadowColor-0d7_KjU", "q", TokenNames.I, "getCompositingStrategy--NrFUSI", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final /* data */ class GraphicsLayerElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final float scaleX;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final float scaleY;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final float translationX;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final float translationY;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final float shadowElevation;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private final float rotationX;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private final float rotationY;

    /* renamed from: j, reason: from kotlin metadata and from toString */
    private final float rotationZ;

    /* renamed from: k, reason: from kotlin metadata and from toString */
    private final float cameraDistance;

    /* renamed from: l, reason: from kotlin metadata and from toString */
    private final long transformOrigin;

    /* renamed from: m, reason: from kotlin metadata and from toString */
    private final InterfaceC10031ax6 shape;

    /* renamed from: n, reason: from kotlin metadata and from toString */
    private final boolean clip;

    /* renamed from: o, reason: from kotlin metadata and from toString */
    private final long ambientShadowColor;

    /* renamed from: p, reason: from kotlin metadata and from toString */
    private final long spotShadowColor;

    /* renamed from: q, reason: from kotlin metadata and from toString */
    private final int compositingStrategy;

    public /* synthetic */ GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, InterfaceC10031ax6 interfaceC10031ax6, boolean z, ON5 on5, long j2, long j3, int i, ED1 ed1) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, interfaceC10031ax6, z, on5, j2, j3, i);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) other;
        return Float.compare(this.scaleX, graphicsLayerElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerElement.alpha) == 0 && Float.compare(this.translationX, graphicsLayerElement.translationX) == 0 && Float.compare(this.translationY, graphicsLayerElement.translationY) == 0 && Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) == 0 && Float.compare(this.rotationX, graphicsLayerElement.rotationX) == 0 && Float.compare(this.rotationY, graphicsLayerElement.rotationY) == 0 && Float.compare(this.rotationZ, graphicsLayerElement.rotationZ) == 0 && Float.compare(this.cameraDistance, graphicsLayerElement.cameraDistance) == 0 && f.e(this.transformOrigin, graphicsLayerElement.transformOrigin) && AbstractC13042fc3.d(this.shape, graphicsLayerElement.shape) && this.clip == graphicsLayerElement.clip && AbstractC13042fc3.d(null, null) && C24381yX0.q(this.ambientShadowColor, graphicsLayerElement.ambientShadowColor) && C24381yX0.q(this.spotShadowColor, graphicsLayerElement.spotShadowColor) && a.e(this.compositingStrategy, graphicsLayerElement.compositingStrategy);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Float.hashCode(this.scaleX) * 31) + Float.hashCode(this.scaleY)) * 31) + Float.hashCode(this.alpha)) * 31) + Float.hashCode(this.translationX)) * 31) + Float.hashCode(this.translationY)) * 31) + Float.hashCode(this.shadowElevation)) * 31) + Float.hashCode(this.rotationX)) * 31) + Float.hashCode(this.rotationY)) * 31) + Float.hashCode(this.rotationZ)) * 31) + Float.hashCode(this.cameraDistance)) * 31) + f.h(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31) + Boolean.hashCode(this.clip)) * 961) + C24381yX0.w(this.ambientShadowColor)) * 31) + C24381yX0.w(this.spotShadowColor)) * 31) + a.f(this.compositingStrategy);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e f() {
        return new e(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, null, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(e node) {
        node.g(this.scaleX);
        node.m(this.scaleY);
        node.c(this.alpha);
        node.n(this.translationX);
        node.e(this.translationY);
        node.B(this.shadowElevation);
        node.j(this.rotationX);
        node.k(this.rotationY);
        node.l(this.rotationZ);
        node.i(this.cameraDistance);
        node.C0(this.transformOrigin);
        node.V(this.shape);
        node.x(this.clip);
        node.f(null);
        node.v(this.ambientShadowColor);
        node.y(this.spotShadowColor);
        node.q(this.compositingStrategy);
        node.E2();
    }

    public String toString() {
        return "GraphicsLayerElement(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha=" + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + ((Object) f.i(this.transformOrigin)) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=" + ((Object) null) + ", ambientShadowColor=" + ((Object) C24381yX0.x(this.ambientShadowColor)) + ", spotShadowColor=" + ((Object) C24381yX0.x(this.spotShadowColor)) + ", compositingStrategy=" + ((Object) a.g(this.compositingStrategy)) + ')';
    }

    private GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, InterfaceC10031ax6 interfaceC10031ax6, boolean z, ON5 on5, long j2, long j3, int i) {
        this.scaleX = f;
        this.scaleY = f2;
        this.alpha = f3;
        this.translationX = f4;
        this.translationY = f5;
        this.shadowElevation = f6;
        this.rotationX = f7;
        this.rotationY = f8;
        this.rotationZ = f9;
        this.cameraDistance = f10;
        this.transformOrigin = j;
        this.shape = interfaceC10031ax6;
        this.clip = z;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
        this.compositingStrategy = i;
    }
}
