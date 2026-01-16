package androidx.compose.foundation;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/c;", "Lir/nasim/yX0;", "color", "Lir/nasim/el0;", "brush", "", "alpha", "Lir/nasim/ax6;", "shape", "Lkotlin/Function1;", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(JLir/nasim/el0;FLir/nasim/ax6;Lir/nasim/UA2;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/c;", "node", "m", "(Landroidx/compose/foundation/c;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "J", "c", "Lir/nasim/el0;", "d", TokenNames.F, "e", "Lir/nasim/ax6;", "f", "Lir/nasim/UA2;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class BackgroundElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final long color;

    /* renamed from: c, reason: from kotlin metadata */
    private final AbstractC12520el0 brush;

    /* renamed from: d, reason: from kotlin metadata */
    private final float alpha;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC10031ax6 shape;

    /* renamed from: f, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public /* synthetic */ BackgroundElement(long j, AbstractC12520el0 abstractC12520el0, float f, InterfaceC10031ax6 interfaceC10031ax6, UA2 ua2, ED1 ed1) {
        this(j, abstractC12520el0, f, interfaceC10031ax6, ua2);
    }

    public boolean equals(Object other) {
        BackgroundElement backgroundElement = other instanceof BackgroundElement ? (BackgroundElement) other : null;
        return backgroundElement != null && C24381yX0.q(this.color, backgroundElement.color) && AbstractC13042fc3.d(this.brush, backgroundElement.brush) && this.alpha == backgroundElement.alpha && AbstractC13042fc3.d(this.shape, backgroundElement.shape);
    }

    public int hashCode() {
        int iW = C24381yX0.w(this.color) * 31;
        AbstractC12520el0 abstractC12520el0 = this.brush;
        return ((((iW + (abstractC12520el0 != null ? abstractC12520el0.hashCode() : 0)) * 31) + Float.hashCode(this.alpha)) * 31) + this.shape.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c f() {
        return new c(this.color, this.brush, this.alpha, this.shape, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(c node) {
        node.B2(this.color);
        node.A2(this.brush);
        node.c(this.alpha);
        node.V(this.shape);
    }

    public /* synthetic */ BackgroundElement(long j, AbstractC12520el0 abstractC12520el0, float f, InterfaceC10031ax6 interfaceC10031ax6, UA2 ua2, int i, ED1 ed1) {
        this((i & 1) != 0 ? C24381yX0.b.i() : j, (i & 2) != 0 ? null : abstractC12520el0, f, interfaceC10031ax6, ua2, null);
    }

    private BackgroundElement(long j, AbstractC12520el0 abstractC12520el0, float f, InterfaceC10031ax6 interfaceC10031ax6, UA2 ua2) {
        this.color = j;
        this.brush = abstractC12520el0;
        this.alpha = f;
        this.shape = interfaceC10031ax6;
        this.inspectorInfo = ua2;
    }
}
