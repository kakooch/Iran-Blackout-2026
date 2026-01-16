package androidx.compose.foundation.text.handwriting;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.MZ6;
import ir.nasim.SA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingElement;", "Lir/nasim/zg4;", "Lir/nasim/MZ6;", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onHandwritingSlopExceeded", "<init>", "(Lir/nasim/SA2;)V", "l", "()Lir/nasim/MZ6;", "node", "m", "(Lir/nasim/MZ6;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/SA2;", "getOnHandwritingSlopExceeded", "()Lir/nasim/SA2;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final /* data */ class StylusHandwritingElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final SA2 onHandwritingSlopExceeded;

    public StylusHandwritingElement(SA2 sa2) {
        this.onHandwritingSlopExceeded = sa2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StylusHandwritingElement) && AbstractC13042fc3.d(this.onHandwritingSlopExceeded, ((StylusHandwritingElement) other).onHandwritingSlopExceeded);
    }

    public int hashCode() {
        return this.onHandwritingSlopExceeded.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public MZ6 f() {
        return new MZ6(this.onHandwritingSlopExceeded);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(MZ6 node) {
        node.D2(this.onHandwritingSlopExceeded);
    }

    public String toString() {
        return "StylusHandwritingElement(onHandwritingSlopExceeded=" + this.onHandwritingSlopExceeded + ')';
    }
}
