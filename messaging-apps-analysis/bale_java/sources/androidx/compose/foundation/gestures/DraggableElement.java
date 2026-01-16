package androidx.compose.foundation.gestures;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C6616Og5;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.OZ1;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u008d\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012(\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f\u0012(\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f\u0012\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010(R6\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R6\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010(¨\u00061"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/gestures/c;", "Lir/nasim/OZ1;", "state", "Lir/nasim/yM4;", "orientation", "", "enabled", "Lir/nasim/om4;", "interactionSource", "startDragImmediately", "Lkotlin/Function3;", "Lir/nasim/ro1;", "Lir/nasim/ZG4;", "Lir/nasim/rm1;", "Lir/nasim/rB7;", "", "onDragStarted", "", "onDragStopped", "reverseDirection", "<init>", "(Lir/nasim/OZ1;Lir/nasim/yM4;ZLir/nasim/om4;ZLir/nasim/kB2;Lir/nasim/kB2;Z)V", "l", "()Landroidx/compose/foundation/gestures/c;", "node", "m", "(Landroidx/compose/foundation/gestures/c;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/OZ1;", "c", "Lir/nasim/yM4;", "d", "Z", "e", "Lir/nasim/om4;", "f", "g", "Lir/nasim/kB2;", "h", "i", "j", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DraggableElement extends AbstractC25066zg4 {
    private static final UA2 k = a.e;

    /* renamed from: b, reason: from kotlin metadata */
    private final OZ1 state;

    /* renamed from: c, reason: from kotlin metadata */
    private final EnumC24286yM4 orientation;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean enabled;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC18507om4 interactionSource;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean startDragImmediately;

    /* renamed from: g, reason: from kotlin metadata */
    private final InterfaceC15796kB2 onDragStarted;

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC15796kB2 onDragStopped;

    /* renamed from: i, reason: from kotlin metadata */
    private final boolean reverseDirection;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C6616Og5 c6616Og5) {
            return Boolean.TRUE;
        }
    }

    public DraggableElement(OZ1 oz1, EnumC24286yM4 enumC24286yM4, boolean z, InterfaceC18507om4 interfaceC18507om4, boolean z2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, boolean z3) {
        this.state = oz1;
        this.orientation = enumC24286yM4;
        this.enabled = z;
        this.interactionSource = interfaceC18507om4;
        this.startDragImmediately = z2;
        this.onDragStarted = interfaceC15796kB2;
        this.onDragStopped = interfaceC15796kB22;
        this.reverseDirection = z3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || DraggableElement.class != other.getClass()) {
            return false;
        }
        DraggableElement draggableElement = (DraggableElement) other;
        return AbstractC13042fc3.d(this.state, draggableElement.state) && this.orientation == draggableElement.orientation && this.enabled == draggableElement.enabled && AbstractC13042fc3.d(this.interactionSource, draggableElement.interactionSource) && this.startDragImmediately == draggableElement.startDragImmediately && AbstractC13042fc3.d(this.onDragStarted, draggableElement.onDragStarted) && AbstractC13042fc3.d(this.onDragStopped, draggableElement.onDragStopped) && this.reverseDirection == draggableElement.reverseDirection;
    }

    public int hashCode() {
        int iHashCode = ((((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31;
        InterfaceC18507om4 interfaceC18507om4 = this.interactionSource;
        return ((((((((iHashCode + (interfaceC18507om4 != null ? interfaceC18507om4.hashCode() : 0)) * 31) + Boolean.hashCode(this.startDragImmediately)) * 31) + this.onDragStarted.hashCode()) * 31) + this.onDragStopped.hashCode()) * 31) + Boolean.hashCode(this.reverseDirection);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c f() {
        return new c(this.state, k, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(c node) {
        node.d3(this.state, k, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }
}
