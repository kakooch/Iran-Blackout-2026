package androidx.compose.animation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC4788Go2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R+\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierElement;", "Lir/nasim/zg4;", "Landroidx/compose/animation/l;", "Lir/nasim/Go2;", "Lir/nasim/Fa3;", "animationSpec", "Lir/nasim/em;", "alignment", "Lkotlin/Function2;", "Lir/nasim/rB7;", "finishedListener", "<init>", "(Lir/nasim/Go2;Lir/nasim/em;Lir/nasim/iB2;)V", "l", "()Landroidx/compose/animation/l;", "node", "m", "(Landroidx/compose/animation/l;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Go2;", "getAnimationSpec", "()Lir/nasim/Go2;", "c", "Lir/nasim/em;", "getAlignment", "()Lir/nasim/em;", "d", "Lir/nasim/iB2;", "getFinishedListener", "()Lir/nasim/iB2;", "animation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final /* data */ class SizeAnimationModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final InterfaceC4788Go2 animationSpec;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final InterfaceC12529em alignment;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final InterfaceC14603iB2 finishedListener;

    public SizeAnimationModifierElement(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em interfaceC12529em, InterfaceC14603iB2 interfaceC14603iB2) {
        this.animationSpec = interfaceC4788Go2;
        this.alignment = interfaceC12529em;
        this.finishedListener = interfaceC14603iB2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeAnimationModifierElement)) {
            return false;
        }
        SizeAnimationModifierElement sizeAnimationModifierElement = (SizeAnimationModifierElement) other;
        return AbstractC13042fc3.d(this.animationSpec, sizeAnimationModifierElement.animationSpec) && AbstractC13042fc3.d(this.alignment, sizeAnimationModifierElement.alignment) && AbstractC13042fc3.d(this.finishedListener, sizeAnimationModifierElement.finishedListener);
    }

    public int hashCode() {
        int iHashCode = ((this.animationSpec.hashCode() * 31) + this.alignment.hashCode()) * 31;
        InterfaceC14603iB2 interfaceC14603iB2 = this.finishedListener;
        return iHashCode + (interfaceC14603iB2 == null ? 0 : interfaceC14603iB2.hashCode());
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public l f() {
        return new l(this.animationSpec, this.alignment, this.finishedListener);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(l node) {
        node.C2(this.animationSpec);
        node.D2(this.finishedListener);
        node.A2(this.alignment);
    }

    public String toString() {
        return "SizeAnimationModifierElement(animationSpec=" + this.animationSpec + ", alignment=" + this.alignment + ", finishedListener=" + this.finishedListener + ')';
    }
}
