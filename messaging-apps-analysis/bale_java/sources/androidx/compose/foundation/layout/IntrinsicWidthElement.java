package androidx.compose.foundation.layout;

import ir.nasim.AbstractC25066zg4;
import ir.nasim.EnumC11821dc3;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/m;", "Lir/nasim/dc3;", "width", "", "enforceIncoming", "Lkotlin/Function1;", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(Lir/nasim/dc3;ZLir/nasim/UA2;)V", "l", "()Landroidx/compose/foundation/layout/m;", "node", "m", "(Landroidx/compose/foundation/layout/m;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/dc3;", "getWidth", "()Lir/nasim/dc3;", "c", "Z", "getEnforceIncoming", "()Z", "d", "Lir/nasim/UA2;", "getInspectorInfo", "()Lir/nasim/UA2;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class IntrinsicWidthElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final EnumC11821dc3 width;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean enforceIncoming;

    /* renamed from: d, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public IntrinsicWidthElement(EnumC11821dc3 enumC11821dc3, boolean z, UA2 ua2) {
        this.width = enumC11821dc3;
        this.enforceIncoming = z;
        this.inspectorInfo = ua2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        IntrinsicWidthElement intrinsicWidthElement = other instanceof IntrinsicWidthElement ? (IntrinsicWidthElement) other : null;
        if (intrinsicWidthElement == null) {
            return false;
        }
        return this.width == intrinsicWidthElement.width && this.enforceIncoming == intrinsicWidthElement.enforceIncoming;
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + Boolean.hashCode(this.enforceIncoming);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public m f() {
        return new m(this.width, this.enforceIncoming);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(m node) {
        node.y2(this.width);
        node.x2(this.enforceIncoming);
    }
}
