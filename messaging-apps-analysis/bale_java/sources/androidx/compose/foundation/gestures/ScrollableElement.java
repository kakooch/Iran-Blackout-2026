package androidx.compose.foundation.gestures;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC11049ce6;
import ir.nasim.InterfaceC14124hO4;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC7645Sp2;
import ir.nasim.InterfaceC8539Wk0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\"\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/gestures/f;", "Lir/nasim/ce6;", "state", "Lir/nasim/yM4;", "orientation", "Lir/nasim/hO4;", "overscrollEffect", "", "enabled", "reverseDirection", "Lir/nasim/Sp2;", "flingBehavior", "Lir/nasim/om4;", "interactionSource", "Lir/nasim/Wk0;", "bringIntoViewSpec", "<init>", "(Lir/nasim/ce6;Lir/nasim/yM4;Lir/nasim/hO4;ZZLir/nasim/Sp2;Lir/nasim/om4;Lir/nasim/Wk0;)V", "l", "()Landroidx/compose/foundation/gestures/f;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/gestures/f;)V", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/ce6;", "getState", "()Lir/nasim/ce6;", "c", "Lir/nasim/yM4;", "getOrientation", "()Lir/nasim/yM4;", "d", "Lir/nasim/hO4;", "getOverscrollEffect", "()Lir/nasim/hO4;", "e", "Z", "getEnabled", "()Z", "f", "getReverseDirection", "g", "Lir/nasim/Sp2;", "getFlingBehavior", "()Lir/nasim/Sp2;", "h", "Lir/nasim/om4;", "getInteractionSource", "()Lir/nasim/om4;", "i", "Lir/nasim/Wk0;", "getBringIntoViewSpec", "()Lir/nasim/Wk0;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class ScrollableElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC11049ce6 state;

    /* renamed from: c, reason: from kotlin metadata */
    private final EnumC24286yM4 orientation;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC14124hO4 overscrollEffect;

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean enabled;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean reverseDirection;

    /* renamed from: g, reason: from kotlin metadata */
    private final InterfaceC7645Sp2 flingBehavior;

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC18507om4 interactionSource;

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC8539Wk0 bringIntoViewSpec;

    public ScrollableElement(InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, InterfaceC14124hO4 interfaceC14124hO4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0) {
        this.state = interfaceC11049ce6;
        this.orientation = enumC24286yM4;
        this.overscrollEffect = interfaceC14124hO4;
        this.enabled = z;
        this.reverseDirection = z2;
        this.flingBehavior = interfaceC7645Sp2;
        this.interactionSource = interfaceC18507om4;
        this.bringIntoViewSpec = interfaceC8539Wk0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) other;
        return AbstractC13042fc3.d(this.state, scrollableElement.state) && this.orientation == scrollableElement.orientation && AbstractC13042fc3.d(this.overscrollEffect, scrollableElement.overscrollEffect) && this.enabled == scrollableElement.enabled && this.reverseDirection == scrollableElement.reverseDirection && AbstractC13042fc3.d(this.flingBehavior, scrollableElement.flingBehavior) && AbstractC13042fc3.d(this.interactionSource, scrollableElement.interactionSource) && AbstractC13042fc3.d(this.bringIntoViewSpec, scrollableElement.bringIntoViewSpec);
    }

    public int hashCode() {
        int iHashCode = ((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31;
        InterfaceC14124hO4 interfaceC14124hO4 = this.overscrollEffect;
        int iHashCode2 = (((((iHashCode + (interfaceC14124hO4 != null ? interfaceC14124hO4.hashCode() : 0)) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.reverseDirection)) * 31;
        InterfaceC7645Sp2 interfaceC7645Sp2 = this.flingBehavior;
        int iHashCode3 = (iHashCode2 + (interfaceC7645Sp2 != null ? interfaceC7645Sp2.hashCode() : 0)) * 31;
        InterfaceC18507om4 interfaceC18507om4 = this.interactionSource;
        int iHashCode4 = (iHashCode3 + (interfaceC18507om4 != null ? interfaceC18507om4.hashCode() : 0)) * 31;
        InterfaceC8539Wk0 interfaceC8539Wk0 = this.bringIntoViewSpec;
        return iHashCode4 + (interfaceC8539Wk0 != null ? interfaceC8539Wk0.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f f() {
        return new f(this.state, this.overscrollEffect, this.flingBehavior, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.bringIntoViewSpec);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(f node) {
        node.e3(this.state, this.orientation, this.overscrollEffect, this.enabled, this.reverseDirection, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }
}
