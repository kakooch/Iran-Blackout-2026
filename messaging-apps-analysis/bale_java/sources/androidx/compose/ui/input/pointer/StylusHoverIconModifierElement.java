package androidx.compose.ui.input.pointer;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C20757sZ1;
import ir.nasim.InterfaceC4953Hg5;
import ir.nasim.OZ6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "Lir/nasim/zg4;", "Lir/nasim/OZ6;", "Lir/nasim/Hg5;", ParameterNames.ICON, "", "overrideDescendants", "Lir/nasim/sZ1;", "touchBoundsExpansion", "<init>", "(Lir/nasim/Hg5;ZLir/nasim/sZ1;)V", "l", "()Lir/nasim/OZ6;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/OZ6;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Hg5;", "getIcon", "()Lir/nasim/Hg5;", "c", "Z", "getOverrideDescendants", "()Z", "d", "Lir/nasim/sZ1;", "getTouchBoundsExpansion", "()Lir/nasim/sZ1;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final /* data */ class StylusHoverIconModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final InterfaceC4953Hg5 icon;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean overrideDescendants;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final C20757sZ1 touchBoundsExpansion;

    public StylusHoverIconModifierElement(InterfaceC4953Hg5 interfaceC4953Hg5, boolean z, C20757sZ1 c20757sZ1) {
        this.icon = interfaceC4953Hg5;
        this.overrideDescendants = z;
        this.touchBoundsExpansion = c20757sZ1;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StylusHoverIconModifierElement)) {
            return false;
        }
        StylusHoverIconModifierElement stylusHoverIconModifierElement = (StylusHoverIconModifierElement) other;
        return AbstractC13042fc3.d(this.icon, stylusHoverIconModifierElement.icon) && this.overrideDescendants == stylusHoverIconModifierElement.overrideDescendants && AbstractC13042fc3.d(this.touchBoundsExpansion, stylusHoverIconModifierElement.touchBoundsExpansion);
    }

    public int hashCode() {
        int iHashCode = ((this.icon.hashCode() * 31) + Boolean.hashCode(this.overrideDescendants)) * 31;
        C20757sZ1 c20757sZ1 = this.touchBoundsExpansion;
        return iHashCode + (c20757sZ1 == null ? 0 : c20757sZ1.hashCode());
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public OZ6 f() {
        return new OZ6(this.icon, this.overrideDescendants, this.touchBoundsExpansion);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(OZ6 node) {
        node.J2(this.icon);
        node.K2(this.overrideDescendants);
        node.I2(this.touchBoundsExpansion);
    }

    public String toString() {
        return "StylusHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ", touchBoundsExpansion=" + this.touchBoundsExpansion + ')';
    }
}
