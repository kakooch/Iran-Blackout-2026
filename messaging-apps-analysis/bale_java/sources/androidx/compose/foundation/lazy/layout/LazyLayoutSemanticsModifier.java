package androidx.compose.foundation.lazy.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC6030Lw3;
import ir.nasim.SA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifier;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/lazy/layout/g;", "Lkotlin/Function0;", "Lir/nasim/rw3;", "itemProviderLambda", "Lir/nasim/Lw3;", "state", "Lir/nasim/yM4;", "orientation", "", "userScrollEnabled", "reverseScrolling", "<init>", "(Lir/nasim/SA2;Lir/nasim/Lw3;Lir/nasim/yM4;ZZ)V", "l", "()Landroidx/compose/foundation/lazy/layout/g;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/lazy/layout/g;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/SA2;", "getItemProviderLambda", "()Lir/nasim/SA2;", "c", "Lir/nasim/Lw3;", "getState", "()Lir/nasim/Lw3;", "d", "Lir/nasim/yM4;", "getOrientation", "()Lir/nasim/yM4;", "e", "Z", "getUserScrollEnabled", "()Z", "f", "getReverseScrolling", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class LazyLayoutSemanticsModifier extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final SA2 itemProviderLambda;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC6030Lw3 state;

    /* renamed from: d, reason: from kotlin metadata */
    private final EnumC24286yM4 orientation;

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean userScrollEnabled;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean reverseScrolling;

    public LazyLayoutSemanticsModifier(SA2 sa2, InterfaceC6030Lw3 interfaceC6030Lw3, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2) {
        this.itemProviderLambda = sa2;
        this.state = interfaceC6030Lw3;
        this.orientation = enumC24286yM4;
        this.userScrollEnabled = z;
        this.reverseScrolling = z2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyLayoutSemanticsModifier)) {
            return false;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = (LazyLayoutSemanticsModifier) other;
        return this.itemProviderLambda == lazyLayoutSemanticsModifier.itemProviderLambda && AbstractC13042fc3.d(this.state, lazyLayoutSemanticsModifier.state) && this.orientation == lazyLayoutSemanticsModifier.orientation && this.userScrollEnabled == lazyLayoutSemanticsModifier.userScrollEnabled && this.reverseScrolling == lazyLayoutSemanticsModifier.reverseScrolling;
    }

    public int hashCode() {
        return (((((((this.itemProviderLambda.hashCode() * 31) + this.state.hashCode()) * 31) + this.orientation.hashCode()) * 31) + Boolean.hashCode(this.userScrollEnabled)) * 31) + Boolean.hashCode(this.reverseScrolling);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public g f() {
        return new g(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(g node) {
        node.z2(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
    }
}
