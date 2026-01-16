package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserFullExtChanged;

/* renamed from: ir.nasim.hG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14055hG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C13464gG7 a(UsersOuterClass$UpdateUserFullExtChanged usersOuterClass$UpdateUserFullExtChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserFullExtChanged, "proto");
        return new C13464gG7(usersOuterClass$UpdateUserFullExtChanged.getUid(), usersOuterClass$UpdateUserFullExtChanged.hasExt() ? usersOuterClass$UpdateUserFullExtChanged.getExt() : null);
    }
}
