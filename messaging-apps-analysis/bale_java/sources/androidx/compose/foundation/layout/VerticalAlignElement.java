package androidx.compose.foundation.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C13572gS7;
import ir.nasim.InterfaceC12529em;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/VerticalAlignElement;", "Lir/nasim/zg4;", "Lir/nasim/gS7;", "Lir/nasim/em$c;", "alignment", "<init>", "(Lir/nasim/em$c;)V", "l", "()Lir/nasim/gS7;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/gS7;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/em$c;", "getAlignment", "()Lir/nasim/em$c;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class VerticalAlignElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC12529em.c alignment;

    public VerticalAlignElement(InterfaceC12529em.c cVar) {
        this.alignment = cVar;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        VerticalAlignElement verticalAlignElement = other instanceof VerticalAlignElement ? (VerticalAlignElement) other : null;
        if (verticalAlignElement == null) {
            return false;
        }
        return AbstractC13042fc3.d(this.alignment, verticalAlignElement.alignment);
    }

    public int hashCode() {
        return this.alignment.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C13572gS7 f() {
        return new C13572gS7(this.alignment);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C13572gS7 node) {
        node.w2(this.alignment);
    }
}
