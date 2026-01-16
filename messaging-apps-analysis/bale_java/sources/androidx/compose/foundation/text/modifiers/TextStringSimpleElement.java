package androidx.compose.foundation.text.modifiers;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC9998au2;
import ir.nasim.C9114Yn7;
import ir.nasim.C9348Zn7;
import ir.nasim.ED1;
import ir.nasim.VX0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleElement;", "Lir/nasim/zg4;", "Lir/nasim/Yn7;", "", ParameterNames.TEXT, "Lir/nasim/Zn7;", "style", "Lir/nasim/au2$b;", "fontFamilyResolver", "Lir/nasim/wn7;", "overflow", "", "softWrap", "", "maxLines", "minLines", "Lir/nasim/VX0;", "color", "<init>", "(Ljava/lang/String;Lir/nasim/Zn7;Lir/nasim/au2$b;IZIILir/nasim/VX0;Lir/nasim/ED1;)V", "l", "()Lir/nasim/Yn7;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/Yn7;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "b", "Ljava/lang/String;", "c", "Lir/nasim/Zn7;", "d", "Lir/nasim/au2$b;", "e", TokenNames.I, "f", "Z", "g", "h", "Lir/nasim/VX0;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class TextStringSimpleElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final String text;

    /* renamed from: c, reason: from kotlin metadata */
    private final C9348Zn7 style;
    private final VX0 color;

    /* renamed from: d, reason: from kotlin metadata */
    private final AbstractC9998au2.b fontFamilyResolver;

    /* renamed from: e, reason: from kotlin metadata */
    private final int overflow;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean softWrap;

    /* renamed from: g, reason: from kotlin metadata */
    private final int maxLines;

    /* renamed from: h, reason: from kotlin metadata */
    private final int minLines;

    public /* synthetic */ TextStringSimpleElement(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, VX0 vx0, ED1 ed1) {
        this(str, c9348Zn7, bVar, i, z, i2, i3, vx0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) other;
        return AbstractC13042fc3.d(this.color, textStringSimpleElement.color) && AbstractC13042fc3.d(this.text, textStringSimpleElement.text) && AbstractC13042fc3.d(this.style, textStringSimpleElement.style) && AbstractC13042fc3.d(this.fontFamilyResolver, textStringSimpleElement.fontFamilyResolver) && AbstractC23365wn7.g(this.overflow, textStringSimpleElement.overflow) && this.softWrap == textStringSimpleElement.softWrap && this.maxLines == textStringSimpleElement.maxLines && this.minLines == textStringSimpleElement.minLines;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + AbstractC23365wn7.h(this.overflow)) * 31) + Boolean.hashCode(this.softWrap)) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        VX0 vx0 = this.color;
        return iHashCode + (vx0 != null ? vx0.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C9114Yn7 f() {
        return new C9114Yn7(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.color, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C9114Yn7 node) {
        node.D2(node.J2(this.color, this.style), node.L2(this.text), node.K2(this.style, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow));
    }

    private TextStringSimpleElement(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, VX0 vx0) {
        this.text = str;
        this.style = c9348Zn7;
        this.fontFamilyResolver = bVar;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.color = vx0;
    }
}
