package androidx.compose.foundation.layout;

import ir.nasim.AbstractC25066zg4;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00038\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 ¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/OffsetPxElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/p;", "Lkotlin/Function1;", "Lir/nasim/WH1;", "Lir/nasim/ua3;", "offset", "", "rtlAware", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(Lir/nasim/UA2;ZLir/nasim/UA2;)V", "l", "()Landroidx/compose/foundation/layout/p;", "node", "m", "(Landroidx/compose/foundation/layout/p;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "b", "Lir/nasim/UA2;", "getOffset", "()Lir/nasim/UA2;", "c", "Z", "getRtlAware", "()Z", "d", "getInspectorInfo", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* renamed from: androidx.compose.foundation.layout.OffsetPxElement, reason: from toString */
/* loaded from: classes.dex */
final class OffsetPxModifier extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final UA2 offset;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean rtlAware;

    /* renamed from: d, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public OffsetPxModifier(UA2 ua2, boolean z, UA2 ua22) {
        this.offset = ua2;
        this.rtlAware = z;
        this.inspectorInfo = ua22;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        OffsetPxModifier offsetPxModifier = other instanceof OffsetPxModifier ? (OffsetPxModifier) other : null;
        if (offsetPxModifier == null) {
            return false;
        }
        return this.offset == offsetPxModifier.offset && this.rtlAware == offsetPxModifier.rtlAware;
    }

    public int hashCode() {
        return (this.offset.hashCode() * 31) + Boolean.hashCode(this.rtlAware);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public p f() {
        return new p(this.offset, this.rtlAware);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(p node) {
        node.x2(this.offset, this.rtlAware);
    }

    public String toString() {
        return "OffsetPxModifier(offset=" + this.offset + ", rtlAware=" + this.rtlAware + ')';
    }
}
