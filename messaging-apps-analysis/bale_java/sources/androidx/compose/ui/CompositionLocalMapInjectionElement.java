package androidx.compose.ui;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.InterfaceC11819dc1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/CompositionLocalMapInjectionElement;", "Lir/nasim/zg4;", "Landroidx/compose/ui/d;", "Lir/nasim/dc1;", "map", "<init>", "(Lir/nasim/dc1;)V", "l", "()Landroidx/compose/ui/d;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/ui/d;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/dc1;", "getMap", "()Lir/nasim/dc1;", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class CompositionLocalMapInjectionElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC11819dc1 map;

    public CompositionLocalMapInjectionElement(InterfaceC11819dc1 interfaceC11819dc1) {
        this.map = interfaceC11819dc1;
    }

    public boolean equals(Object other) {
        return (other instanceof CompositionLocalMapInjectionElement) && AbstractC13042fc3.d(((CompositionLocalMapInjectionElement) other).map, this.map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d f() {
        return new d(this.map);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(d node) {
        node.v2(this.map);
    }
}
