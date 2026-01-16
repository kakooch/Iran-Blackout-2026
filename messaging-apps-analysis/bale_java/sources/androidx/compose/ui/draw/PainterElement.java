package androidx.compose.ui.draw;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC23431wu3;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.EV4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.OD6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"Landroidx/compose/ui/draw/PainterElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/draw/PainterNode;", "Lir/nasim/EV4;", "painter", "", "sizeToIntrinsics", "Lir/nasim/em;", "alignment", "Lir/nasim/fl1;", "contentScale", "", "alpha", "Lir/nasim/zX0;", "colorFilter", "<init>", "(Lir/nasim/EV4;ZLir/nasim/em;Lir/nasim/fl1;FLir/nasim/zX0;)V", "l", "()Landroidx/compose/ui/draw/PainterNode;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/draw/PainterNode;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/EV4;", "getPainter", "()Lir/nasim/EV4;", "b", "Z", "getSizeToIntrinsics", "()Z", "c", "Lir/nasim/em;", "getAlignment", "()Lir/nasim/em;", "d", "Lir/nasim/fl1;", "getContentScale", "()Lir/nasim/fl1;", "e", TokenNames.F, "getAlpha", "()F", "f", "Lir/nasim/zX0;", "getColorFilter", "()Lir/nasim/zX0;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final /* data */ class PainterElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final boolean sizeToIntrinsics;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final InterfaceC12529em alignment;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final InterfaceC13157fl1 contentScale;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final AbstractC24975zX0 colorFilter;
    private final EV4 painter;

    public PainterElement(EV4 ev4, boolean z, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0) {
        this.painter = ev4;
        this.sizeToIntrinsics = z;
        this.alignment = interfaceC12529em;
        this.contentScale = interfaceC13157fl1;
        this.alpha = f;
        this.colorFilter = abstractC24975zX0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) other;
        return AbstractC13042fc3.d(this.painter, painterElement.painter) && this.sizeToIntrinsics == painterElement.sizeToIntrinsics && AbstractC13042fc3.d(this.alignment, painterElement.alignment) && AbstractC13042fc3.d(this.contentScale, painterElement.contentScale) && Float.compare(this.alpha, painterElement.alpha) == 0 && AbstractC13042fc3.d(this.colorFilter, painterElement.colorFilter);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.painter.hashCode() * 31) + Boolean.hashCode(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        AbstractC24975zX0 abstractC24975zX0 = this.colorFilter;
        return iHashCode + (abstractC24975zX0 == null ? 0 : abstractC24975zX0.hashCode());
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public PainterModifier f() {
        return new PainterModifier(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(PainterModifier node) {
        boolean sizeToIntrinsics = node.getSizeToIntrinsics();
        boolean z = this.sizeToIntrinsics;
        boolean z2 = sizeToIntrinsics != z || (z && !OD6.f(node.getPainter().l(), this.painter.l()));
        node.F2(this.painter);
        node.G2(this.sizeToIntrinsics);
        node.C2(this.alignment);
        node.E2(this.contentScale);
        node.c(this.alpha);
        node.D2(this.colorFilter);
        if (z2) {
            AbstractC23431wu3.b(node);
        }
        AbstractC16278l02.a(node);
    }

    public String toString() {
        return "PainterElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
