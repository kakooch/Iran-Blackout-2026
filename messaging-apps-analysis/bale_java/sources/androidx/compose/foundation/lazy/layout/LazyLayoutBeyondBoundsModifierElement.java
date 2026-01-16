package androidx.compose.foundation.lazy.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C15060iw3;
import ir.nasim.C15651jw3;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC16242kw3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierElement;", "Lir/nasim/zg4;", "Lir/nasim/jw3;", "Lir/nasim/kw3;", "state", "Lir/nasim/iw3;", "beyondBoundsInfo", "", "reverseLayout", "Lir/nasim/yM4;", "orientation", "<init>", "(Lir/nasim/kw3;Lir/nasim/iw3;ZLir/nasim/yM4;)V", "l", "()Lir/nasim/jw3;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/jw3;)V", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/kw3;", "getState", "()Lir/nasim/kw3;", "c", "Lir/nasim/iw3;", "getBeyondBoundsInfo", "()Lir/nasim/iw3;", "d", "Z", "getReverseLayout", "()Z", "e", "Lir/nasim/yM4;", "getOrientation", "()Lir/nasim/yM4;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class LazyLayoutBeyondBoundsModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC16242kw3 state;

    /* renamed from: c, reason: from kotlin metadata */
    private final C15060iw3 beyondBoundsInfo;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean reverseLayout;

    /* renamed from: e, reason: from kotlin metadata */
    private final EnumC24286yM4 orientation;

    public LazyLayoutBeyondBoundsModifierElement(InterfaceC16242kw3 interfaceC16242kw3, C15060iw3 c15060iw3, boolean z, EnumC24286yM4 enumC24286yM4) {
        this.state = interfaceC16242kw3;
        this.beyondBoundsInfo = c15060iw3;
        this.reverseLayout = z;
        this.orientation = enumC24286yM4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyLayoutBeyondBoundsModifierElement)) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierElement lazyLayoutBeyondBoundsModifierElement = (LazyLayoutBeyondBoundsModifierElement) other;
        return AbstractC13042fc3.d(this.state, lazyLayoutBeyondBoundsModifierElement.state) && AbstractC13042fc3.d(this.beyondBoundsInfo, lazyLayoutBeyondBoundsModifierElement.beyondBoundsInfo) && this.reverseLayout == lazyLayoutBeyondBoundsModifierElement.reverseLayout && this.orientation == lazyLayoutBeyondBoundsModifierElement.orientation;
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + this.beyondBoundsInfo.hashCode()) * 31) + Boolean.hashCode(this.reverseLayout)) * 31) + this.orientation.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C15651jw3 f() {
        return new C15651jw3(this.state, this.beyondBoundsInfo, this.reverseLayout, this.orientation);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C15651jw3 node) {
        node.A2(this.state, this.beyondBoundsInfo, this.reverseLayout, this.orientation);
    }
}
