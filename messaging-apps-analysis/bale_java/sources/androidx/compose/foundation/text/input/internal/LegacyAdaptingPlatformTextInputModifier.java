package androidx.compose.foundation.text.input.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC5581Jy3;
import ir.nasim.C19101pm7;
import ir.nasim.C21005sy3;
import ir.nasim.C6542Ny3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifier;", "Lir/nasim/zg4;", "Lir/nasim/sy3;", "Lir/nasim/Jy3;", "serviceAdapter", "Lir/nasim/Ny3;", "legacyTextFieldState", "Lir/nasim/pm7;", "textFieldSelectionManager", "<init>", "(Lir/nasim/Jy3;Lir/nasim/Ny3;Lir/nasim/pm7;)V", "l", "()Lir/nasim/sy3;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/sy3;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Jy3;", "getServiceAdapter", "()Lir/nasim/Jy3;", "c", "Lir/nasim/Ny3;", "getLegacyTextFieldState", "()Lir/nasim/Ny3;", "d", "Lir/nasim/pm7;", "getTextFieldSelectionManager", "()Lir/nasim/pm7;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final /* data */ class LegacyAdaptingPlatformTextInputModifier extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final AbstractC5581Jy3 serviceAdapter;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final C6542Ny3 legacyTextFieldState;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final C19101pm7 textFieldSelectionManager;

    public LegacyAdaptingPlatformTextInputModifier(AbstractC5581Jy3 abstractC5581Jy3, C6542Ny3 c6542Ny3, C19101pm7 c19101pm7) {
        this.serviceAdapter = abstractC5581Jy3;
        this.legacyTextFieldState = c6542Ny3;
        this.textFieldSelectionManager = c19101pm7;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return false;
        }
        LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier = (LegacyAdaptingPlatformTextInputModifier) other;
        return AbstractC13042fc3.d(this.serviceAdapter, legacyAdaptingPlatformTextInputModifier.serviceAdapter) && AbstractC13042fc3.d(this.legacyTextFieldState, legacyAdaptingPlatformTextInputModifier.legacyTextFieldState) && AbstractC13042fc3.d(this.textFieldSelectionManager, legacyAdaptingPlatformTextInputModifier.textFieldSelectionManager);
    }

    public int hashCode() {
        return (((this.serviceAdapter.hashCode() * 31) + this.legacyTextFieldState.hashCode()) * 31) + this.textFieldSelectionManager.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C21005sy3 f() {
        return new C21005sy3(this.serviceAdapter, this.legacyTextFieldState, this.textFieldSelectionManager);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C21005sy3 node) {
        node.x2(this.serviceAdapter);
        node.w2(this.legacyTextFieldState);
        node.y2(this.textFieldSelectionManager);
    }

    public String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.serviceAdapter + ", legacyTextFieldState=" + this.legacyTextFieldState + ", textFieldSelectionManager=" + this.textFieldSelectionManager + ')';
    }
}
