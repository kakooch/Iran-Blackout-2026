package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserLocalNameChanged;

/* renamed from: ir.nasim.nG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17619nG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C17028mG7 a(UsersOuterClass$UpdateUserLocalNameChanged usersOuterClass$UpdateUserLocalNameChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserLocalNameChanged, "proto");
        return new C17028mG7(usersOuterClass$UpdateUserLocalNameChanged.getUid(), usersOuterClass$UpdateUserLocalNameChanged.hasLocalName() ? usersOuterClass$UpdateUserLocalNameChanged.getLocalName().getValue() : null);
    }
}
