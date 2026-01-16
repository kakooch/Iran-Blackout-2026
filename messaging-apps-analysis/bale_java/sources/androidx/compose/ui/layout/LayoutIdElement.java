package androidx.compose.ui.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C15040iu3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/layout/LayoutIdElement;", "Lir/nasim/zg4;", "Lir/nasim/iu3;", "", "layoutId", "<init>", "(Ljava/lang/Object;)V", "l", "()Lir/nasim/iu3;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/iu3;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final /* data */ class LayoutIdElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final Object layoutId;

    public LayoutIdElement(Object obj) {
        this.layoutId = obj;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LayoutIdElement) && AbstractC13042fc3.d(this.layoutId, ((LayoutIdElement) other).layoutId);
    }

    public int hashCode() {
        return this.layoutId.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C15040iu3 f() {
        return new C15040iu3(this.layoutId);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C15040iu3 node) {
        node.v2(this.layoutId);
    }

    public String toString() {
        return "LayoutIdElement(layoutId=" + this.layoutId + ')';
    }
}
