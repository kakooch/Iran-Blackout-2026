package androidx.compose.foundation.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.TS4;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/s;", "Lir/nasim/TS4;", "paddingValues", "Lkotlin/Function1;", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(Lir/nasim/TS4;Lir/nasim/UA2;)V", "l", "()Landroidx/compose/foundation/layout/s;", "node", "m", "(Landroidx/compose/foundation/layout/s;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/TS4;", "getPaddingValues", "()Lir/nasim/TS4;", "c", "Lir/nasim/UA2;", "getInspectorInfo", "()Lir/nasim/UA2;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class PaddingValuesElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final TS4 paddingValues;

    /* renamed from: c, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public PaddingValuesElement(TS4 ts4, UA2 ua2) {
        this.paddingValues = ts4;
        this.inspectorInfo = ua2;
    }

    public boolean equals(Object other) {
        PaddingValuesElement paddingValuesElement = other instanceof PaddingValuesElement ? (PaddingValuesElement) other : null;
        if (paddingValuesElement == null) {
            return false;
        }
        return AbstractC13042fc3.d(this.paddingValues, paddingValuesElement.paddingValues);
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public s f() {
        return new s(this.paddingValues);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(s node) {
        node.v2(this.paddingValues);
    }
}
