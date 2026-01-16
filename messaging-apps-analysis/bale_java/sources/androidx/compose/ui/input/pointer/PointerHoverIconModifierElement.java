package androidx.compose.ui.input.pointer;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C4719Gg5;
import ir.nasim.InterfaceC4953Hg5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Lir/nasim/zg4;", "Lir/nasim/Gg5;", "Lir/nasim/Hg5;", ParameterNames.ICON, "", "overrideDescendants", "<init>", "(Lir/nasim/Hg5;Z)V", "l", "()Lir/nasim/Gg5;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/Gg5;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Hg5;", "getIcon", "()Lir/nasim/Hg5;", "c", "Z", "getOverrideDescendants", "()Z", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final /* data */ class PointerHoverIconModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final InterfaceC4953Hg5 icon;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean overrideDescendants;

    public PointerHoverIconModifierElement(InterfaceC4953Hg5 interfaceC4953Hg5, boolean z) {
        this.icon = interfaceC4953Hg5;
        this.overrideDescendants = z;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerHoverIconModifierElement)) {
            return false;
        }
        PointerHoverIconModifierElement pointerHoverIconModifierElement = (PointerHoverIconModifierElement) other;
        return AbstractC13042fc3.d(this.icon, pointerHoverIconModifierElement.icon) && this.overrideDescendants == pointerHoverIconModifierElement.overrideDescendants;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + Boolean.hashCode(this.overrideDescendants);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C4719Gg5 f() {
        return new C4719Gg5(this.icon, this.overrideDescendants);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C4719Gg5 node) {
        node.J2(this.icon);
        node.K2(this.overrideDescendants);
    }

    public String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ')';
    }
}
