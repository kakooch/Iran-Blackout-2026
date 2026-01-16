package androidx.compose.foundation;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C17784nZ1;
import ir.nasim.C9873ai0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10031ax6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/BorderModifierNodeElement;", "Lir/nasim/zg4;", "Lir/nasim/ai0;", "Lir/nasim/nZ1;", "width", "Lir/nasim/el0;", "brush", "Lir/nasim/ax6;", "shape", "<init>", "(FLir/nasim/el0;Lir/nasim/ax6;Lir/nasim/ED1;)V", "l", "()Lir/nasim/ai0;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/ai0;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", TokenNames.F, "getWidth-D9Ej5fM", "()F", "c", "Lir/nasim/el0;", "getBrush", "()Lir/nasim/el0;", "d", "Lir/nasim/ax6;", "getShape", "()Lir/nasim/ax6;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final /* data */ class BorderModifierNodeElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final float width;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final AbstractC12520el0 brush;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final InterfaceC10031ax6 shape;

    public /* synthetic */ BorderModifierNodeElement(float f, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6, ED1 ed1) {
        this(f, abstractC12520el0, interfaceC10031ax6);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) other;
        return C17784nZ1.s(this.width, borderModifierNodeElement.width) && AbstractC13042fc3.d(this.brush, borderModifierNodeElement.brush) && AbstractC13042fc3.d(this.shape, borderModifierNodeElement.shape);
    }

    public int hashCode() {
        return (((C17784nZ1.t(this.width) * 31) + this.brush.hashCode()) * 31) + this.shape.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C9873ai0 f() {
        return new C9873ai0(this.width, this.brush, this.shape, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C9873ai0 node) {
        node.J2(this.width);
        node.I2(this.brush);
        node.V(this.shape);
    }

    public String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) C17784nZ1.u(this.width)) + ", brush=" + this.brush + ", shape=" + this.shape + ')';
    }

    private BorderModifierNodeElement(float f, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6) {
        this.width = f;
        this.brush = abstractC12520el0;
        this.shape = interfaceC10031ax6;
    }
}
