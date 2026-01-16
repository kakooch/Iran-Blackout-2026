package ir.nasim;

import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class VV extends VW7 {
    private final String b = "SaveableStateHolder_BackStackEntryKey";
    private final UUID c;
    public WeakReference d;

    public VV(androidx.lifecycle.y yVar) {
        UUID uuidRandomUUID = (UUID) yVar.c("SaveableStateHolder_BackStackEntryKey");
        if (uuidRandomUUID == null) {
            uuidRandomUUID = UUID.randomUUID();
            yVar.g("SaveableStateHolder_BackStackEntryKey", uuidRandomUUID);
        }
        this.c = uuidRandomUUID;
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        super.L0();
        InterfaceC9809ab6 interfaceC9809ab6 = (InterfaceC9809ab6) R0().get();
        if (interfaceC9809ab6 != null) {
            interfaceC9809ab6.c(this.c);
        }
        R0().clear();
    }

    public final UUID P0() {
        return this.c;
    }

    public final WeakReference R0() {
        WeakReference weakReference = this.d;
        if (weakReference != null) {
            return weakReference;
        }
        AbstractC13042fc3.y("saveableStateHolderRef");
        return null;
    }

    public final void S0(WeakReference weakReference) {
        this.d = weakReference;
    }
}
