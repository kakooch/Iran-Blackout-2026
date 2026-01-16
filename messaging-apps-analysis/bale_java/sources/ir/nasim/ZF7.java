package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserDefaultCardNumberChanged;

/* loaded from: classes5.dex */
public final class ZF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public YF7 a(UsersOuterClass$UpdateUserDefaultCardNumberChanged usersOuterClass$UpdateUserDefaultCardNumberChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserDefaultCardNumberChanged, "input");
        return new YF7(usersOuterClass$UpdateUserDefaultCardNumberChanged.getUid(), usersOuterClass$UpdateUserDefaultCardNumberChanged.hasDefaultCardNumber() ? usersOuterClass$UpdateUserDefaultCardNumberChanged.getDefaultCardNumber().getValue() : null);
    }
}
