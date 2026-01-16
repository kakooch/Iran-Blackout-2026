package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.focus.m;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C18600ov7;
import ir.nasim.C19101pm7;
import ir.nasim.C23945xm7;
import ir.nasim.C6542Ny3;
import ir.nasim.C8099Un1;
import ir.nasim.InterfaceC11600dH4;
import ir.nasim.T33;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b'\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u00106R\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b\f\u00106R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006J"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifier;", "Lir/nasim/zg4;", "Lir/nasim/Un1;", "Lir/nasim/ov7;", "transformedText", "Lir/nasim/xm7;", "value", "Lir/nasim/Ny3;", "state", "", "readOnly", "enabled", "isPassword", "Lir/nasim/dH4;", "offsetMapping", "Lir/nasim/pm7;", "manager", "Lir/nasim/T33;", "imeOptions", "Landroidx/compose/ui/focus/m;", "focusRequester", "<init>", "(Lir/nasim/ov7;Lir/nasim/xm7;Lir/nasim/Ny3;ZZZLir/nasim/dH4;Lir/nasim/pm7;Lir/nasim/T33;Landroidx/compose/ui/focus/m;)V", "l", "()Lir/nasim/Un1;", "node", "Lir/nasim/rB7;", "m", "(Lir/nasim/Un1;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/ov7;", "getTransformedText", "()Lir/nasim/ov7;", "c", "Lir/nasim/xm7;", "getValue", "()Lir/nasim/xm7;", "d", "Lir/nasim/Ny3;", "getState", "()Lir/nasim/Ny3;", "e", "Z", "getReadOnly", "()Z", "f", "getEnabled", "g", "h", "Lir/nasim/dH4;", "getOffsetMapping", "()Lir/nasim/dH4;", "i", "Lir/nasim/pm7;", "getManager", "()Lir/nasim/pm7;", "j", "Lir/nasim/T33;", "getImeOptions", "()Lir/nasim/T33;", "k", "Landroidx/compose/ui/focus/m;", "getFocusRequester", "()Landroidx/compose/ui/focus/m;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final /* data */ class CoreTextFieldSemanticsModifier extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final C18600ov7 transformedText;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final C23945xm7 value;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final C6542Ny3 state;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final boolean readOnly;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final boolean enabled;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final boolean isPassword;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private final InterfaceC11600dH4 offsetMapping;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private final C19101pm7 manager;

    /* renamed from: j, reason: from kotlin metadata and from toString */
    private final T33 imeOptions;

    /* renamed from: k, reason: from kotlin metadata and from toString */
    private final m focusRequester;

    public CoreTextFieldSemanticsModifier(C18600ov7 c18600ov7, C23945xm7 c23945xm7, C6542Ny3 c6542Ny3, boolean z, boolean z2, boolean z3, InterfaceC11600dH4 interfaceC11600dH4, C19101pm7 c19101pm7, T33 t33, m mVar) {
        this.transformedText = c18600ov7;
        this.value = c23945xm7;
        this.state = c6542Ny3;
        this.readOnly = z;
        this.enabled = z2;
        this.isPassword = z3;
        this.offsetMapping = interfaceC11600dH4;
        this.manager = c19101pm7;
        this.imeOptions = t33;
        this.focusRequester = mVar;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreTextFieldSemanticsModifier)) {
            return false;
        }
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = (CoreTextFieldSemanticsModifier) other;
        return AbstractC13042fc3.d(this.transformedText, coreTextFieldSemanticsModifier.transformedText) && AbstractC13042fc3.d(this.value, coreTextFieldSemanticsModifier.value) && AbstractC13042fc3.d(this.state, coreTextFieldSemanticsModifier.state) && this.readOnly == coreTextFieldSemanticsModifier.readOnly && this.enabled == coreTextFieldSemanticsModifier.enabled && this.isPassword == coreTextFieldSemanticsModifier.isPassword && AbstractC13042fc3.d(this.offsetMapping, coreTextFieldSemanticsModifier.offsetMapping) && AbstractC13042fc3.d(this.manager, coreTextFieldSemanticsModifier.manager) && AbstractC13042fc3.d(this.imeOptions, coreTextFieldSemanticsModifier.imeOptions) && AbstractC13042fc3.d(this.focusRequester, coreTextFieldSemanticsModifier.focusRequester);
    }

    public int hashCode() {
        return (((((((((((((((((this.transformedText.hashCode() * 31) + this.value.hashCode()) * 31) + this.state.hashCode()) * 31) + Boolean.hashCode(this.readOnly)) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.isPassword)) * 31) + this.offsetMapping.hashCode()) * 31) + this.manager.hashCode()) * 31) + this.imeOptions.hashCode()) * 31) + this.focusRequester.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C8099Un1 f() {
        return new C8099Un1(this.transformedText, this.value, this.state, this.readOnly, this.enabled, this.isPassword, this.offsetMapping, this.manager, this.imeOptions, this.focusRequester);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(C8099Un1 node) {
        node.L2(this.transformedText, this.value, this.state, this.readOnly, this.enabled, this.isPassword, this.offsetMapping, this.manager, this.imeOptions, this.focusRequester);
    }

    public String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.transformedText + ", value=" + this.value + ", state=" + this.state + ", readOnly=" + this.readOnly + ", enabled=" + this.enabled + ", isPassword=" + this.isPassword + ", offsetMapping=" + this.offsetMapping + ", manager=" + this.manager + ", imeOptions=" + this.imeOptions + ", focusRequester=" + this.focusRequester + ')';
    }
}
