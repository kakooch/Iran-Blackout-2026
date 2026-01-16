package androidx.compose.material3.internal;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C8822Xm;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC14603iB2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002BI\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012*\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00000\t0\u0006\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR8\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00000\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/material3/internal/DraggableAnchorsElement;", TokenNames.T, "Lir/nasim/zg4;", "Landroidx/compose/material3/internal/c;", "Lir/nasim/Xm;", "state", "Lkotlin/Function2;", "Lir/nasim/Fa3;", "Lir/nasim/ne1;", "Lir/nasim/XV4;", "Lir/nasim/JZ1;", "anchors", "Lir/nasim/yM4;", "orientation", "<init>", "(Lir/nasim/Xm;Lir/nasim/iB2;Lir/nasim/yM4;)V", "l", "()Landroidx/compose/material3/internal/c;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/material3/internal/c;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/Xm;", "c", "Lir/nasim/iB2;", "d", "Lir/nasim/yM4;", "material3_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class DraggableAnchorsElement<T> extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final C8822Xm state;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC14603iB2 anchors;

    /* renamed from: d, reason: from kotlin metadata */
    private final EnumC24286yM4 orientation;

    public DraggableAnchorsElement(C8822Xm c8822Xm, InterfaceC14603iB2 interfaceC14603iB2, EnumC24286yM4 enumC24286yM4) {
        this.state = c8822Xm;
        this.anchors = interfaceC14603iB2;
        this.orientation = enumC24286yM4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DraggableAnchorsElement)) {
            return false;
        }
        DraggableAnchorsElement draggableAnchorsElement = (DraggableAnchorsElement) other;
        return AbstractC13042fc3.d(this.state, draggableAnchorsElement.state) && this.anchors == draggableAnchorsElement.anchors && this.orientation == draggableAnchorsElement.orientation;
    }

    public int hashCode() {
        return (((this.state.hashCode() * 31) + this.anchors.hashCode()) * 31) + this.orientation.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c f() {
        return new c(this.state, this.anchors, this.orientation);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(c node) {
        node.z2(this.state);
        node.x2(this.anchors);
        node.y2(this.orientation);
    }
}
