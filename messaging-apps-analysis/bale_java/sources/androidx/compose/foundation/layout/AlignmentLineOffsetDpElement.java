package androidx.compose.foundation.layout;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13165fm;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C17784nZ1;
import ir.nasim.ED1;
import ir.nasim.K73;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0006\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u0007\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetDpElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/b;", "Lir/nasim/fm;", "alignmentLine", "Lir/nasim/nZ1;", "before", "after", "Lkotlin/Function1;", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(Lir/nasim/fm;FFLir/nasim/UA2;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/layout/b;", "node", "m", "(Landroidx/compose/foundation/layout/b;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/fm;", "getAlignmentLine", "()Lir/nasim/fm;", "c", TokenNames.F, "getBefore-D9Ej5fM", "()F", "d", "getAfter-D9Ej5fM", "e", "Lir/nasim/UA2;", "getInspectorInfo", "()Lir/nasim/UA2;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class AlignmentLineOffsetDpElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final AbstractC13165fm alignmentLine;

    /* renamed from: c, reason: from kotlin metadata */
    private final float before;

    /* renamed from: d, reason: from kotlin metadata */
    private final float after;

    /* renamed from: e, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public /* synthetic */ AlignmentLineOffsetDpElement(AbstractC13165fm abstractC13165fm, float f, float f2, UA2 ua2, ED1 ed1) {
        this(abstractC13165fm, f, f2, ua2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        AlignmentLineOffsetDpElement alignmentLineOffsetDpElement = other instanceof AlignmentLineOffsetDpElement ? (AlignmentLineOffsetDpElement) other : null;
        if (alignmentLineOffsetDpElement == null) {
            return false;
        }
        return AbstractC13042fc3.d(this.alignmentLine, alignmentLineOffsetDpElement.alignmentLine) && C17784nZ1.s(this.before, alignmentLineOffsetDpElement.before) && C17784nZ1.s(this.after, alignmentLineOffsetDpElement.after);
    }

    public int hashCode() {
        return (((this.alignmentLine.hashCode() * 31) + C17784nZ1.t(this.before)) * 31) + C17784nZ1.t(this.after);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b f() {
        return new b(this.alignmentLine, this.before, this.after, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(b node) {
        node.w2(this.alignmentLine);
        node.x2(this.before);
        node.v2(this.after);
    }

    private AlignmentLineOffsetDpElement(AbstractC13165fm abstractC13165fm, float f, float f2, UA2 ua2) {
        this.alignmentLine = abstractC13165fm;
        this.before = f;
        this.after = f2;
        this.inspectorInfo = ua2;
        boolean z = true;
        boolean z2 = f >= 0.0f || Float.isNaN(f);
        if (f2 < 0.0f && !Float.isNaN(f2)) {
            z = false;
        }
        if (!z2 || !z) {
            K73.a("Padding from alignment line must be a non-negative number");
        }
    }
}
