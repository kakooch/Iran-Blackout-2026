package ir.nasim;

import ai.bale.proto.CollectionsStruct$MapValueItem;
import ai.bale.proto.UsersOuterClass$UpdateContactsAdded;
import java.util.List;

/* renamed from: ir.nasim.hD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14028hD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C13437gD7 a(UsersOuterClass$UpdateContactsAdded usersOuterClass$UpdateContactsAdded) {
        List<CollectionsStruct$MapValueItem> listM;
        AbstractC13042fc3.i(usersOuterClass$UpdateContactsAdded, "input");
        List<Integer> uidsList = usersOuterClass$UpdateContactsAdded.getUidsList();
        AbstractC13042fc3.h(uidsList, "getUidsList(...)");
        if (usersOuterClass$UpdateContactsAdded.hasPhones()) {
            listM = usersOuterClass$UpdateContactsAdded.getPhones().getItemsList();
            AbstractC13042fc3.h(listM, "getItemsList(...)");
        } else {
            listM = AbstractC10360bX0.m();
        }
        return new C13437gD7(uidsList, new C19811qz(C18732p92.y0(listM)));
    }
}
