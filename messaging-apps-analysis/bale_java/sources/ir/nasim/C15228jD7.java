package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateContactsRemoved;
import java.util.List;

/* renamed from: ir.nasim.jD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15228jD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14630iD7 a(UsersOuterClass$UpdateContactsRemoved usersOuterClass$UpdateContactsRemoved) {
        AbstractC13042fc3.i(usersOuterClass$UpdateContactsRemoved, "input");
        List<Integer> uidsList = usersOuterClass$UpdateContactsRemoved.getUidsList();
        AbstractC13042fc3.h(uidsList, "getUidsList(...)");
        return new C14630iD7(uidsList);
    }
}
