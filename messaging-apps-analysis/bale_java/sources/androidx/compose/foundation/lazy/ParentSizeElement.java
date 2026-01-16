package androidx.compose.foundation.lazy;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9664aL6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/ParentSizeElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/lazy/b;", "", "fraction", "Lir/nasim/aL6;", "", "widthState", "heightState", "", "inspectorName", "<init>", "(FLir/nasim/aL6;Lir/nasim/aL6;Ljava/lang/String;)V", "l", "()Landroidx/compose/foundation/lazy/b;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/lazy/b;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "b", TokenNames.F, "getFraction", "()F", "c", "Lir/nasim/aL6;", "getWidthState", "()Lir/nasim/aL6;", "d", "getHeightState", "e", "Ljava/lang/String;", "getInspectorName", "()Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class ParentSizeElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final float fraction;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC9664aL6 widthState;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC9664aL6 heightState;

    /* renamed from: e, reason: from kotlin metadata */
    private final String inspectorName;

    public /* synthetic */ ParentSizeElement(float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, String str, int i, ED1 ed1) {
        this(f, (i & 2) != 0 ? null : interfaceC9664aL6, (i & 4) != 0 ? null : interfaceC9664aL62, str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParentSizeElement)) {
            return false;
        }
        ParentSizeElement parentSizeElement = (ParentSizeElement) other;
        return this.fraction == parentSizeElement.fraction && AbstractC13042fc3.d(this.widthState, parentSizeElement.widthState) && AbstractC13042fc3.d(this.heightState, parentSizeElement.heightState);
    }

    public int hashCode() {
        InterfaceC9664aL6 interfaceC9664aL6 = this.widthState;
        int iHashCode = (interfaceC9664aL6 != null ? interfaceC9664aL6.hashCode() : 0) * 31;
        InterfaceC9664aL6 interfaceC9664aL62 = this.heightState;
        return ((iHashCode + (interfaceC9664aL62 != null ? interfaceC9664aL62.hashCode() : 0)) * 31) + Float.hashCode(this.fraction);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b f() {
        return new b(this.fraction, this.widthState, this.heightState);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(b node) {
        node.v2(this.fraction);
        node.x2(this.widthState);
        node.w2(this.heightState);
    }

    public ParentSizeElement(float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, String str) {
        this.fraction = f;
        this.widthState = interfaceC9664aL6;
        this.heightState = interfaceC9664aL62;
        this.inspectorName = str;
    }
}
