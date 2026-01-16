package androidx.compose.foundation.lazy.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C14453hw3;
import ir.nasim.InterfaceC4788Go2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001d¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemElement;", "Lir/nasim/zg4;", "Lir/nasim/hw3;", "Lir/nasim/Go2;", "", "fadeInSpec", "Lir/nasim/ua3;", "placementSpec", "fadeOutSpec", "<init>", "(Lir/nasim/Go2;Lir/nasim/Go2;Lir/nasim/Go2;)V", "l", "()Lir/nasim/hw3;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/hw3;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Go2;", "c", "d", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final /* data */ class LazyLayoutAnimateItemElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final InterfaceC4788Go2 fadeInSpec;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final InterfaceC4788Go2 placementSpec;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final InterfaceC4788Go2 fadeOutSpec;

    public LazyLayoutAnimateItemElement(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC4788Go2 interfaceC4788Go22, InterfaceC4788Go2 interfaceC4788Go23) {
        this.fadeInSpec = interfaceC4788Go2;
        this.placementSpec = interfaceC4788Go22;
        this.fadeOutSpec = interfaceC4788Go23;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyLayoutAnimateItemElement)) {
            return false;
        }
        LazyLayoutAnimateItemElement lazyLayoutAnimateItemElement = (LazyLayoutAnimateItemElement) other;
        return AbstractC13042fc3.d(this.fadeInSpec, lazyLayoutAnimateItemElement.fadeInSpec) && AbstractC13042fc3.d(this.placementSpec, lazyLayoutAnimateItemElement.placementSpec) && AbstractC13042fc3.d(this.fadeOutSpec, lazyLayoutAnimateItemElement.fadeOutSpec);
    }

    public int hashCode() {
        InterfaceC4788Go2 interfaceC4788Go2 = this.fadeInSpec;
        int iHashCode = (interfaceC4788Go2 == null ? 0 : interfaceC4788Go2.hashCode()) * 31;
        InterfaceC4788Go2 interfaceC4788Go22 = this.placementSpec;
        int iHashCode2 = (iHashCode + (interfaceC4788Go22 == null ? 0 : interfaceC4788Go22.hashCode())) * 31;
        InterfaceC4788Go2 interfaceC4788Go23 = this.fadeOutSpec;
        return iHashCode2 + (interfaceC4788Go23 != null ? interfaceC4788Go23.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C14453hw3 f() {
        return new C14453hw3(this.fadeInSpec, this.placementSpec, this.fadeOutSpec);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C14453hw3 node) {
        node.y2(this.fadeInSpec);
        node.A2(this.placementSpec);
        node.z2(this.fadeOutSpec);
    }

    public String toString() {
        return "LazyLayoutAnimateItemElement(fadeInSpec=" + this.fadeInSpec + ", placementSpec=" + this.placementSpec + ", fadeOutSpec=" + this.fadeOutSpec + ')';
    }
}
