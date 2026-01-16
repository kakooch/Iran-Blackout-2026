package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserNameChanged;

/* renamed from: ir.nasim.pG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18801pG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C18210oG7 a(UsersOuterClass$UpdateUserNameChanged usersOuterClass$UpdateUserNameChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserNameChanged, "proto");
        int uid = usersOuterClass$UpdateUserNameChanged.getUid();
        String name = usersOuterClass$UpdateUserNameChanged.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return new C18210oG7(uid, name);
    }
}
