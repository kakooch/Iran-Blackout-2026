package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserAvatarChanged;

/* loaded from: classes5.dex */
public final class PF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public OF7 a(UsersOuterClass$UpdateUserAvatarChanged usersOuterClass$UpdateUserAvatarChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserAvatarChanged, "proto");
        return new OF7(usersOuterClass$UpdateUserAvatarChanged.getUid(), usersOuterClass$UpdateUserAvatarChanged.hasAvatar() ? usersOuterClass$UpdateUserAvatarChanged.getAvatar() : null, usersOuterClass$UpdateUserAvatarChanged.hasAvatars() ? usersOuterClass$UpdateUserAvatarChanged.getAvatars() : null);
    }
}
