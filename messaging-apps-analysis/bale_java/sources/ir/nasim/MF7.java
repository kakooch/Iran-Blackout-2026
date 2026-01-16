package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserAboutChanged;

/* loaded from: classes5.dex */
public final class MF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NF7 a(UsersOuterClass$UpdateUserAboutChanged usersOuterClass$UpdateUserAboutChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserAboutChanged, "input");
        int uid = usersOuterClass$UpdateUserAboutChanged.getUid();
        String value = usersOuterClass$UpdateUserAboutChanged.getAbout().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return new NF7(uid, value);
    }
}
