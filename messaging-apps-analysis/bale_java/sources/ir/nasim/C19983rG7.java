package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserNickChanged;

/* renamed from: ir.nasim.rG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19983rG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C19392qG7 a(UsersOuterClass$UpdateUserNickChanged usersOuterClass$UpdateUserNickChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserNickChanged, "proto");
        return new C19392qG7(usersOuterClass$UpdateUserNickChanged.getUid(), usersOuterClass$UpdateUserNickChanged.hasNickname() ? usersOuterClass$UpdateUserNickChanged.getNickname().getValue() : null);
    }
}
