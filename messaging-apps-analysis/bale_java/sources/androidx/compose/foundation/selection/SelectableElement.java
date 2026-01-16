package androidx.compose.foundation.selection;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.B26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.SA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/selection/SelectableElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/selection/b;", "", "selected", "Lir/nasim/om4;", "interactionSource", "Lir/nasim/n63;", "indicationNodeFactory", "enabled", "Lir/nasim/B26;", "role", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onClick", "<init>", "(ZLir/nasim/om4;Lir/nasim/n63;ZLir/nasim/B26;Lir/nasim/SA2;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/selection/b;", "node", "m", "(Landroidx/compose/foundation/selection/b;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Z", "c", "Lir/nasim/om4;", "d", "Lir/nasim/n63;", "e", "f", "Lir/nasim/B26;", "g", "Lir/nasim/SA2;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class SelectableElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean selected;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC18507om4 interactionSource;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC17521n63 indicationNodeFactory;

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean enabled;

    /* renamed from: f, reason: from kotlin metadata */
    private final B26 role;

    /* renamed from: g, reason: from kotlin metadata */
    private final SA2 onClick;

    public /* synthetic */ SelectableElement(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, SA2 sa2, ED1 ed1) {
        this(z, interfaceC18507om4, interfaceC17521n63, z2, b26, sa2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || SelectableElement.class != other.getClass()) {
            return false;
        }
        SelectableElement selectableElement = (SelectableElement) other;
        return this.selected == selectableElement.selected && AbstractC13042fc3.d(this.interactionSource, selectableElement.interactionSource) && AbstractC13042fc3.d(this.indicationNodeFactory, selectableElement.indicationNodeFactory) && this.enabled == selectableElement.enabled && AbstractC13042fc3.d(this.role, selectableElement.role) && this.onClick == selectableElement.onClick;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.selected) * 31;
        InterfaceC18507om4 interfaceC18507om4 = this.interactionSource;
        int iHashCode2 = (iHashCode + (interfaceC18507om4 != null ? interfaceC18507om4.hashCode() : 0)) * 31;
        InterfaceC17521n63 interfaceC17521n63 = this.indicationNodeFactory;
        int iHashCode3 = (((iHashCode2 + (interfaceC17521n63 != null ? interfaceC17521n63.hashCode() : 0)) * 31) + Boolean.hashCode(this.enabled)) * 31;
        B26 b26 = this.role;
        return ((iHashCode3 + (b26 != null ? B26.n(b26.p()) : 0)) * 31) + this.onClick.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b f() {
        return new b(this.selected, this.interactionSource, this.indicationNodeFactory, this.enabled, this.role, this.onClick, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(b node) {
        node.b3(this.selected, this.interactionSource, this.indicationNodeFactory, this.enabled, this.role, this.onClick);
    }

    private SelectableElement(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, SA2 sa2) {
        this.selected = z;
        this.interactionSource = interfaceC18507om4;
        this.indicationNodeFactory = interfaceC17521n63;
        this.enabled = z2;
        this.role = b26;
        this.onClick = sa2;
    }
}
