package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserExInfoChanged;

/* renamed from: ir.nasim.dG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11594dG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C10830cG7 a(UsersOuterClass$UpdateUserExInfoChanged usersOuterClass$UpdateUserExInfoChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserExInfoChanged, "proto");
        return new C10830cG7(usersOuterClass$UpdateUserExInfoChanged.getUid(), usersOuterClass$UpdateUserExInfoChanged.hasExInfo() ? usersOuterClass$UpdateUserExInfoChanged.getExInfo() : null);
    }
}
