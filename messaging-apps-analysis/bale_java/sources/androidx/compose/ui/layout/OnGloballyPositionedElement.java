package androidx.compose.ui.layout;

import ir.nasim.AbstractC25066zg4;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/layout/OnGloballyPositionedElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/layout/d;", "Lkotlin/Function1;", "Lir/nasim/cu3;", "Lir/nasim/rB7;", "onGloballyPositioned", "<init>", "(Lir/nasim/UA2;)V", "l", "()Landroidx/compose/ui/layout/d;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "node", "m", "(Landroidx/compose/ui/layout/d;)V", "b", "Lir/nasim/UA2;", "getOnGloballyPositioned", "()Lir/nasim/UA2;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final class OnGloballyPositionedElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final UA2 onGloballyPositioned;

    public OnGloballyPositionedElement(UA2 ua2) {
        this.onGloballyPositioned = ua2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OnGloballyPositionedElement) && this.onGloballyPositioned == ((OnGloballyPositionedElement) other).onGloballyPositioned;
    }

    public int hashCode() {
        return this.onGloballyPositioned.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d f() {
        return new d(this.onGloballyPositioned);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(d node) {
        node.v2(this.onGloballyPositioned);
    }
}
