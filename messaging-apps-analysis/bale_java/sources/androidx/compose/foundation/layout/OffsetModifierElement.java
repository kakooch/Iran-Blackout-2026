package androidx.compose.foundation.layout;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C17784nZ1;
import ir.nasim.ED1;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0005\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/o;", "Lir/nasim/nZ1;", "x", "y", "", "rtlAware", "Lkotlin/Function1;", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(FFZLir/nasim/UA2;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/layout/o;", "node", "m", "(Landroidx/compose/foundation/layout/o;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", TokenNames.F, "getX-D9Ej5fM", "()F", "c", "getY-D9Ej5fM", "d", "Z", "getRtlAware", "()Z", "e", "Lir/nasim/UA2;", "getInspectorInfo", "()Lir/nasim/UA2;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* renamed from: androidx.compose.foundation.layout.OffsetElement, reason: from toString */
/* loaded from: classes.dex */
final class OffsetModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final float x;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final float y;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final boolean rtlAware;

    /* renamed from: e, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public /* synthetic */ OffsetModifierElement(float f, float f2, boolean z, UA2 ua2, ED1 ed1) {
        this(f, f2, z, ua2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        OffsetModifierElement offsetModifierElement = other instanceof OffsetModifierElement ? (OffsetModifierElement) other : null;
        if (offsetModifierElement == null) {
            return false;
        }
        return C17784nZ1.s(this.x, offsetModifierElement.x) && C17784nZ1.s(this.y, offsetModifierElement.y) && this.rtlAware == offsetModifierElement.rtlAware;
    }

    public int hashCode() {
        return (((C17784nZ1.t(this.x) * 31) + C17784nZ1.t(this.y)) * 31) + Boolean.hashCode(this.rtlAware);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public o f() {
        return new o(this.x, this.y, this.rtlAware, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(o node) {
        node.y2(this.x, this.y, this.rtlAware);
    }

    public String toString() {
        return "OffsetModifierElement(x=" + ((Object) C17784nZ1.u(this.x)) + ", y=" + ((Object) C17784nZ1.u(this.y)) + ", rtlAware=" + this.rtlAware + ')';
    }

    private OffsetModifierElement(float f, float f2, boolean z, UA2 ua2) {
        this.x = f;
        this.y = f2;
        this.rtlAware = z;
        this.inspectorInfo = ua2;
    }
}
