package coil.compose;

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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcoil/compose/ContentPainterElement;", "Lir/nasim/zg4;", "Lcoil/compose/ContentPainterNode;", "Lir/nasim/EV4;", "painter", "Lir/nasim/em;", "alignment", "Lir/nasim/fl1;", "contentScale", "", "alpha", "Lir/nasim/zX0;", "colorFilter", "<init>", "(Lir/nasim/EV4;Lir/nasim/em;Lir/nasim/fl1;FLir/nasim/zX0;)V", "l", "()Lcoil/compose/ContentPainterNode;", "node", "Lir/nasim/rB7;", "m", "(Lcoil/compose/ContentPainterNode;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/EV4;", "b", "Lir/nasim/em;", "c", "Lir/nasim/fl1;", "d", TokenNames.F, "e", "Lir/nasim/zX0;", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final /* data */ class ContentPainterElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final InterfaceC12529em alignment;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final InterfaceC13157fl1 contentScale;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final AbstractC24975zX0 colorFilter;
    private final EV4 painter;

    public ContentPainterElement(EV4 ev4, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0) {
        this.painter = ev4;
        this.alignment = interfaceC12529em;
        this.contentScale = interfaceC13157fl1;
        this.alpha = f;
        this.colorFilter = abstractC24975zX0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPainterElement)) {
            return false;
        }
        ContentPainterElement contentPainterElement = (ContentPainterElement) other;
        return AbstractC13042fc3.d(this.painter, contentPainterElement.painter) && AbstractC13042fc3.d(this.alignment, contentPainterElement.alignment) && AbstractC13042fc3.d(this.contentScale, contentPainterElement.contentScale) && Float.compare(this.alpha, contentPainterElement.alpha) == 0 && AbstractC13042fc3.d(this.colorFilter, contentPainterElement.colorFilter);
    }

    public int hashCode() {
        int iHashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        AbstractC24975zX0 abstractC24975zX0 = this.colorFilter;
        return iHashCode + (abstractC24975zX0 == null ? 0 : abstractC24975zX0.hashCode());
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public ContentPainterNode f() {
        return new ContentPainterNode(this.painter, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(ContentPainterNode node) {
        boolean z = !OD6.f(node.getPainter().getIntrinsicSize(), this.painter.getIntrinsicSize());
        node.B2(this.painter);
        node.y2(this.alignment);
        node.A2(this.contentScale);
        node.c(this.alpha);
        node.z2(this.colorFilter);
        if (z) {
            AbstractC23431wu3.b(node);
        }
        AbstractC16278l02.a(node);
    }

    public String toString() {
        return "ContentPainterElement(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
