package androidx.compose.ui.input.nestedscroll;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C25166zq4;
import ir.nasim.C3857Cq4;
import ir.nasim.InterfaceC24572yq4;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollElement;", "Lir/nasim/zg4;", "Lir/nasim/Cq4;", "Lir/nasim/yq4;", "connection", "Lir/nasim/zq4;", "dispatcher", "<init>", "(Lir/nasim/yq4;Lir/nasim/zq4;)V", "l", "()Lir/nasim/Cq4;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/Cq4;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/yq4;", "getConnection", "()Lir/nasim/yq4;", "c", "Lir/nasim/zq4;", "getDispatcher", "()Lir/nasim/zq4;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final class NestedScrollElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC24572yq4 connection;

    /* renamed from: c, reason: from kotlin metadata */
    private final C25166zq4 dispatcher;

    public NestedScrollElement(InterfaceC24572yq4 interfaceC24572yq4, C25166zq4 c25166zq4) {
        this.connection = interfaceC24572yq4;
        this.dispatcher = c25166zq4;
    }

    public boolean equals(Object other) {
        if (!(other instanceof NestedScrollElement)) {
            return false;
        }
        NestedScrollElement nestedScrollElement = (NestedScrollElement) other;
        return AbstractC13042fc3.d(nestedScrollElement.connection, this.connection) && AbstractC13042fc3.d(nestedScrollElement.dispatcher, this.dispatcher);
    }

    public int hashCode() {
        int iHashCode = this.connection.hashCode() * 31;
        C25166zq4 c25166zq4 = this.dispatcher;
        return iHashCode + (c25166zq4 != null ? c25166zq4.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C3857Cq4 f() {
        return new C3857Cq4(this.connection, this.dispatcher);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C3857Cq4 node) {
        node.C2(this.connection, this.dispatcher);
    }
}
