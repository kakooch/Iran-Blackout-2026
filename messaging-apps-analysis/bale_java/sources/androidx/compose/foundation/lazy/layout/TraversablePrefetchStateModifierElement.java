package androidx.compose.foundation.lazy.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateModifierElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/lazy/layout/j;", "Landroidx/compose/foundation/lazy/layout/d;", "prefetchState", "<init>", "(Landroidx/compose/foundation/lazy/layout/d;)V", "l", "()Landroidx/compose/foundation/lazy/layout/j;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/lazy/layout/j;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Landroidx/compose/foundation/lazy/layout/d;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final /* data */ class TraversablePrefetchStateModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final d prefetchState;

    public TraversablePrefetchStateModifierElement(d dVar) {
        this.prefetchState = dVar;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TraversablePrefetchStateModifierElement) && AbstractC13042fc3.d(this.prefetchState, ((TraversablePrefetchStateModifierElement) other).prefetchState);
    }

    public int hashCode() {
        return this.prefetchState.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public j f() {
        return new j(this.prefetchState);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(j node) {
        node.x2(this.prefetchState);
    }

    public String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.prefetchState + ')';
    }
}
