package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupPinRemoved;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* renamed from: ir.nasim.nE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17601nE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C17010mE7 a(GroupsOuterClass$UpdateGroupPinRemoved groupsOuterClass$UpdateGroupPinRemoved) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupPinRemoved, "input");
        int groupId = groupsOuterClass$UpdateGroupPinRemoved.getGroupId();
        if (groupsOuterClass$UpdateGroupPinRemoved.hasMessageId()) {
            return new C17010mE7(groupId, new MessageIdentifier(groupsOuterClass$UpdateGroupPinRemoved.getMessageId().getRid(), groupsOuterClass$UpdateGroupPinRemoved.getMessageId().getDate(), groupsOuterClass$UpdateGroupPinRemoved.getMessageId().getSeq()));
        }
        return null;
    }
}
