package androidx.compose.foundation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.B26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.SA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/ClickableElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/f;", "Lir/nasim/om4;", "interactionSource", "Lir/nasim/n63;", "indicationNodeFactory", "", "enabled", "", "onClickLabel", "Lir/nasim/B26;", "role", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onClick", "<init>", "(Lir/nasim/om4;Lir/nasim/n63;ZLjava/lang/String;Lir/nasim/B26;Lir/nasim/SA2;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/f;", "node", "m", "(Landroidx/compose/foundation/f;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/om4;", "c", "Lir/nasim/n63;", "d", "Z", "e", "Ljava/lang/String;", "f", "Lir/nasim/B26;", "g", "Lir/nasim/SA2;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class ClickableElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC18507om4 interactionSource;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC17521n63 indicationNodeFactory;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean enabled;

    /* renamed from: e, reason: from kotlin metadata */
    private final String onClickLabel;

    /* renamed from: f, reason: from kotlin metadata */
    private final B26 role;

    /* renamed from: g, reason: from kotlin metadata */
    private final SA2 onClick;

    public /* synthetic */ ClickableElement(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2, ED1 ed1) {
        this(interfaceC18507om4, interfaceC17521n63, z, str, b26, sa2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || ClickableElement.class != other.getClass()) {
            return false;
        }
        ClickableElement clickableElement = (ClickableElement) other;
        return AbstractC13042fc3.d(this.interactionSource, clickableElement.interactionSource) && AbstractC13042fc3.d(this.indicationNodeFactory, clickableElement.indicationNodeFactory) && this.enabled == clickableElement.enabled && AbstractC13042fc3.d(this.onClickLabel, clickableElement.onClickLabel) && AbstractC13042fc3.d(this.role, clickableElement.role) && this.onClick == clickableElement.onClick;
    }

    public int hashCode() {
        InterfaceC18507om4 interfaceC18507om4 = this.interactionSource;
        int iHashCode = (interfaceC18507om4 != null ? interfaceC18507om4.hashCode() : 0) * 31;
        InterfaceC17521n63 interfaceC17521n63 = this.indicationNodeFactory;
        int iHashCode2 = (((iHashCode + (interfaceC17521n63 != null ? interfaceC17521n63.hashCode() : 0)) * 31) + Boolean.hashCode(this.enabled)) * 31;
        String str = this.onClickLabel;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        B26 b26 = this.role;
        return ((iHashCode3 + (b26 != null ? B26.n(b26.p()) : 0)) * 31) + this.onClick.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f f() {
        return new f(this.interactionSource, this.indicationNodeFactory, this.enabled, this.onClickLabel, this.role, this.onClick, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(f node) {
        node.a3(this.interactionSource, this.indicationNodeFactory, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    private ClickableElement(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2) {
        this.interactionSource = interfaceC18507om4;
        this.indicationNodeFactory = interfaceC17521n63;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = b26;
        this.onClick = sa2;
    }
}
