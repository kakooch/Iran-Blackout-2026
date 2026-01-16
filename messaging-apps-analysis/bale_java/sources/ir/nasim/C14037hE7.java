package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupMessagePinned;
import ai.bale.proto.MessagingStruct$MessageContainer;

/* renamed from: ir.nasim.hE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14037hE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C13446gE7 a(GroupsOuterClass$UpdateGroupMessagePinned groupsOuterClass$UpdateGroupMessagePinned) {
        C25247zz c25247zzC0;
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupMessagePinned, "input");
        int groupId = groupsOuterClass$UpdateGroupMessagePinned.getGroupId();
        if (groupsOuterClass$UpdateGroupMessagePinned.hasMessage()) {
            C18732p92 c18732p92 = C18732p92.a;
            MessagingStruct$MessageContainer message = groupsOuterClass$UpdateGroupMessagePinned.getMessage();
            AbstractC13042fc3.h(message, "getMessage(...)");
            c25247zzC0 = c18732p92.C0(message);
        } else {
            c25247zzC0 = null;
        }
        return new C13446gE7(groupId, c25247zzC0);
    }
}
