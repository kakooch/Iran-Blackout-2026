package androidx.compose.ui.focus;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/focus/p;", "Landroidx/compose/ui/focus/m;", "focusRequester", "<init>", "(Landroidx/compose/ui/focus/m;)V", "l", "()Landroidx/compose/ui/focus/p;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/focus/p;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Landroidx/compose/ui/focus/m;", "getFocusRequester", "()Landroidx/compose/ui/focus/m;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final /* data */ class FocusRequesterElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final m focusRequester;

    public FocusRequesterElement(m mVar) {
        this.focusRequester = mVar;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FocusRequesterElement) && AbstractC13042fc3.d(this.focusRequester, ((FocusRequesterElement) other).focusRequester);
    }

    public int hashCode() {
        return this.focusRequester.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public p f() {
        return new p(this.focusRequester);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(p node) {
        node.v2().e().t(node);
        node.w2(this.focusRequester);
        node.v2().e().d(node);
    }

    public String toString() {
        return "FocusRequesterElement(focusRequester=" + this.focusRequester + ')';
    }
}
