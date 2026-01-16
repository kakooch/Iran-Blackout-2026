package androidx.compose.foundation.layout;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C8164Uu3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Lir/nasim/zg4;", "Lir/nasim/Uu3;", "", "weight", "", "fill", "<init>", "(FZ)V", "l", "()Lir/nasim/Uu3;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/Uu3;)V", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", TokenNames.F, "getWeight", "()F", "c", "Z", "getFill", "()Z", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class LayoutWeightElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final float weight;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean fill;

    public LayoutWeightElement(float f, boolean z) {
        this.weight = f;
        this.fill = z;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = other instanceof LayoutWeightElement ? (LayoutWeightElement) other : null;
        if (layoutWeightElement == null) {
            return false;
        }
        return this.weight == layoutWeightElement.weight && this.fill == layoutWeightElement.fill;
    }

    public int hashCode() {
        return (Float.hashCode(this.weight) * 31) + Boolean.hashCode(this.fill);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C8164Uu3 f() {
        return new C8164Uu3(this.weight, this.fill);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C8164Uu3 node) {
        node.x2(this.weight);
        node.w2(this.fill);
    }
}
