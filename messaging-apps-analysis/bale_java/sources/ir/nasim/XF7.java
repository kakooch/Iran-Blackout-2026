package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserDefaultBankAccountChanged;

/* loaded from: classes5.dex */
public final class XF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WF7 a(UsersOuterClass$UpdateUserDefaultBankAccountChanged usersOuterClass$UpdateUserDefaultBankAccountChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserDefaultBankAccountChanged, "input");
        return new WF7(usersOuterClass$UpdateUserDefaultBankAccountChanged.getUid(), usersOuterClass$UpdateUserDefaultBankAccountChanged.hasDefaultBankAccount() ? usersOuterClass$UpdateUserDefaultBankAccountChanged.getDefaultBankAccount().getValue() : null);
    }
}
