package androidx.compose.ui.input.key;

import ir.nasim.AbstractC25066zg4;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/input/key/b;", "Lkotlin/Function1;", "Lir/nasim/so3;", "", "onKeyEvent", "onPreKeyEvent", "<init>", "(Lir/nasim/UA2;Lir/nasim/UA2;)V", "l", "()Landroidx/compose/ui/input/key/b;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/input/key/b;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/UA2;", "getOnKeyEvent", "()Lir/nasim/UA2;", "c", "getOnPreKeyEvent", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final class KeyInputElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final UA2 onKeyEvent;

    /* renamed from: c, reason: from kotlin metadata */
    private final UA2 onPreKeyEvent;

    public KeyInputElement(UA2 ua2, UA2 ua22) {
        this.onKeyEvent = ua2;
        this.onPreKeyEvent = ua22;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) other;
        return this.onKeyEvent == keyInputElement.onKeyEvent && this.onPreKeyEvent == keyInputElement.onPreKeyEvent;
    }

    public int hashCode() {
        UA2 ua2 = this.onKeyEvent;
        int iHashCode = (ua2 != null ? ua2.hashCode() : 0) * 31;
        UA2 ua22 = this.onPreKeyEvent;
        return iHashCode + (ua22 != null ? ua22.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b f() {
        return new b(this.onKeyEvent, this.onPreKeyEvent);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(b node) {
        node.v2(this.onKeyEvent);
        node.w2(this.onPreKeyEvent);
    }
}
