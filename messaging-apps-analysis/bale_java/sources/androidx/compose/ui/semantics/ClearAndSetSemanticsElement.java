package androidx.compose.ui.semantics;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C7626Sn1;
import ir.nasim.InterfaceC6685On6;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/ui/semantics/ClearAndSetSemanticsElement;", "Lir/nasim/zg4;", "Lir/nasim/Sn1;", "Lir/nasim/On6;", "Lkotlin/Function1;", "Lir/nasim/do6;", "Lir/nasim/rB7;", "properties", "<init>", "(Lir/nasim/UA2;)V", "l", "()Lir/nasim/Sn1;", "node", "m", "(Lir/nasim/Sn1;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/UA2;", "getProperties", "()Lir/nasim/UA2;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "e", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "semanticsConfiguration", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final /* data */ class ClearAndSetSemanticsElement extends AbstractC25066zg4 implements InterfaceC6685On6 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final UA2 properties;

    public ClearAndSetSemanticsElement(UA2 ua2) {
        this.properties = ua2;
    }

    @Override // ir.nasim.InterfaceC6685On6
    public SemanticsConfiguration e() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.I(false);
        semanticsConfiguration.F(true);
        this.properties.invoke(semanticsConfiguration);
        return semanticsConfiguration;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ClearAndSetSemanticsElement) && AbstractC13042fc3.d(this.properties, ((ClearAndSetSemanticsElement) other).properties);
    }

    public int hashCode() {
        return this.properties.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C7626Sn1 f() {
        return new C7626Sn1(false, true, this.properties);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C7626Sn1 node) {
        node.w2(this.properties);
    }

    public String toString() {
        return "ClearAndSetSemanticsElement(properties=" + this.properties + ')';
    }
}
