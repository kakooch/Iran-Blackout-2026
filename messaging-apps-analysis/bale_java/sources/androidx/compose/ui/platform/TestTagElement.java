package androidx.compose.ui.platform;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/TestTagElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/platform/u;", "", ParameterNames.TAG, "<init>", "(Ljava/lang/String;)V", "l", "()Landroidx/compose/ui/platform/u;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/platform/u;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
final class TestTagElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final String tag;

    public TestTagElement(String str) {
        this.tag = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TestTagElement) {
            return AbstractC13042fc3.d(this.tag, ((TestTagElement) other).tag);
        }
        return false;
    }

    public int hashCode() {
        return this.tag.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public u f() {
        return new u(this.tag);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(u node) {
        node.v2(this.tag);
    }
}
