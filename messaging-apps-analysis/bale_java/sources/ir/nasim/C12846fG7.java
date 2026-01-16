package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserExtChanged;

/* renamed from: ir.nasim.fG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12846fG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12237eG7 a(UsersOuterClass$UpdateUserExtChanged usersOuterClass$UpdateUserExtChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserExtChanged, "proto");
        return new C12237eG7(usersOuterClass$UpdateUserExtChanged.getUid(), usersOuterClass$UpdateUserExtChanged.hasExt() ? usersOuterClass$UpdateUserExtChanged.getExt() : null);
    }
}
