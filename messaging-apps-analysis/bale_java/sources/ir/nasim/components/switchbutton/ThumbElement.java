package ir.nasim.components.switchbutton;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23431wu3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.InterfaceC23241wb3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lir/nasim/components/switchbutton/ThumbElement;", "Lir/nasim/zg4;", "Lir/nasim/components/switchbutton/c;", "Lir/nasim/wb3;", "interactionSource", "", "checked", "<init>", "(Lir/nasim/wb3;Z)V", "l", "()Lir/nasim/components/switchbutton/c;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/components/switchbutton/c;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/wb3;", "getInteractionSource", "()Lir/nasim/wb3;", "c", "Z", "getChecked", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final /* data */ class ThumbElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final InterfaceC23241wb3 interactionSource;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean checked;

    public ThumbElement(InterfaceC23241wb3 interfaceC23241wb3, boolean z) {
        AbstractC13042fc3.i(interfaceC23241wb3, "interactionSource");
        this.interactionSource = interfaceC23241wb3;
        this.checked = z;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) other;
        return AbstractC13042fc3.d(this.interactionSource, thumbElement.interactionSource) && this.checked == thumbElement.checked;
    }

    public int hashCode() {
        return (this.interactionSource.hashCode() * 31) + Boolean.hashCode(this.checked);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c f() {
        return new c(this.interactionSource, this.checked);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(c node) {
        AbstractC13042fc3.i(node, "node");
        node.E2(this.interactionSource);
        if (node.A2() != this.checked) {
            AbstractC23431wu3.b(node);
        }
        node.D2(this.checked);
        node.F2();
    }

    public String toString() {
        return "ThumbElement(interactionSource=" + this.interactionSource + ", checked=" + this.checked + Separators.RPAREN;
    }
}
