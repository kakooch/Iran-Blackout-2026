package androidx.compose.foundation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C8248Vd6;
import ir.nasim.C9023Yd6;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u0007\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "Lir/nasim/zg4;", "Lir/nasim/Vd6;", "Lir/nasim/Yd6;", "scrollState", "", "reverseScrolling", "isVertical", "<init>", "(Lir/nasim/Yd6;ZZ)V", "l", "()Lir/nasim/Vd6;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/Vd6;)V", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Yd6;", "getScrollState", "()Lir/nasim/Yd6;", "c", "Z", "getReverseScrolling", "()Z", "d", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class ScrollingLayoutElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final C9023Yd6 scrollState;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean reverseScrolling;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean isVertical;

    public ScrollingLayoutElement(C9023Yd6 c9023Yd6, boolean z, boolean z2) {
        this.scrollState = c9023Yd6;
        this.reverseScrolling = z;
        this.isVertical = z2;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) other;
        return AbstractC13042fc3.d(this.scrollState, scrollingLayoutElement.scrollState) && this.reverseScrolling == scrollingLayoutElement.reverseScrolling && this.isVertical == scrollingLayoutElement.isVertical;
    }

    public int hashCode() {
        return (((this.scrollState.hashCode() * 31) + Boolean.hashCode(this.reverseScrolling)) * 31) + Boolean.hashCode(this.isVertical);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C8248Vd6 f() {
        return new C8248Vd6(this.scrollState, this.reverseScrolling, this.isVertical);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C8248Vd6 node) {
        node.z2(this.scrollState);
        node.y2(this.reverseScrolling);
        node.A2(this.isVertical);
    }
}
