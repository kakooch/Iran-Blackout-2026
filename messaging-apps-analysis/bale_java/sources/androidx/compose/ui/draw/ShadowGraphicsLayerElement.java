package androidx.compose.ui.draw;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C13116fh0;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u0010\n\u001a\u00020\t8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u0010\u000b\u001a\u00020\t8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "Lir/nasim/zg4;", "Lir/nasim/fh0;", "Lir/nasim/nZ1;", "elevation", "Lir/nasim/ax6;", "shape", "", "clip", "Lir/nasim/yX0;", "ambientColor", "spotColor", "<init>", "(FLir/nasim/ax6;ZJJLir/nasim/ED1;)V", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/c;", "Lir/nasim/rB7;", "m", "()Lir/nasim/UA2;", "l", "()Lir/nasim/fh0;", "node", "v", "(Lir/nasim/fh0;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", TokenNames.F, "r", "()F", "c", "Lir/nasim/ax6;", "s", "()Lir/nasim/ax6;", "d", "Z", "q", "()Z", "e", "J", "n", "()J", "f", "t", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final /* data */ class ShadowGraphicsLayerElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final float elevation;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final InterfaceC10031ax6 shape;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final boolean clip;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final long ambientColor;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final long spotColor;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            cVar.B(cVar.w1(ShadowGraphicsLayerElement.this.getElevation()));
            cVar.V(ShadowGraphicsLayerElement.this.getShape());
            cVar.x(ShadowGraphicsLayerElement.this.getClip());
            cVar.v(ShadowGraphicsLayerElement.this.getAmbientColor());
            cVar.y(ShadowGraphicsLayerElement.this.getSpotColor());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ ShadowGraphicsLayerElement(float f, InterfaceC10031ax6 interfaceC10031ax6, boolean z, long j, long j2, ED1 ed1) {
        this(f, interfaceC10031ax6, z, j, j2);
    }

    private final UA2 m() {
        return new a();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) other;
        return C17784nZ1.s(this.elevation, shadowGraphicsLayerElement.elevation) && AbstractC13042fc3.d(this.shape, shadowGraphicsLayerElement.shape) && this.clip == shadowGraphicsLayerElement.clip && C24381yX0.q(this.ambientColor, shadowGraphicsLayerElement.ambientColor) && C24381yX0.q(this.spotColor, shadowGraphicsLayerElement.spotColor);
    }

    public int hashCode() {
        return (((((((C17784nZ1.t(this.elevation) * 31) + this.shape.hashCode()) * 31) + Boolean.hashCode(this.clip)) * 31) + C24381yX0.w(this.ambientColor)) * 31) + C24381yX0.w(this.spotColor);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C13116fh0 f() {
        return new C13116fh0(m());
    }

    /* renamed from: n, reason: from getter */
    public final long getAmbientColor() {
        return this.ambientColor;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    /* renamed from: r, reason: from getter */
    public final float getElevation() {
        return this.elevation;
    }

    /* renamed from: s, reason: from getter */
    public final InterfaceC10031ax6 getShape() {
        return this.shape;
    }

    /* renamed from: t, reason: from getter */
    public final long getSpotColor() {
        return this.spotColor;
    }

    public String toString() {
        return "ShadowGraphicsLayerElement(elevation=" + ((Object) C17784nZ1.u(this.elevation)) + ", shape=" + this.shape + ", clip=" + this.clip + ", ambientColor=" + ((Object) C24381yX0.x(this.ambientColor)) + ", spotColor=" + ((Object) C24381yX0.x(this.spotColor)) + ')';
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void k(C13116fh0 node) {
        node.x2(m());
        node.w2();
    }

    private ShadowGraphicsLayerElement(float f, InterfaceC10031ax6 interfaceC10031ax6, boolean z, long j, long j2) {
        this.elevation = f;
        this.shape = interfaceC10031ax6;
        this.clip = z;
        this.ambientColor = j;
        this.spotColor = j2;
    }
}
