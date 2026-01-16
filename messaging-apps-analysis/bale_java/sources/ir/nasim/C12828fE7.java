package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersUpdateObsolete;
import ai.bale.proto.GroupsStruct$Member;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.fE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12828fE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12219eE7 a(GroupsOuterClass$UpdateGroupMembersUpdateObsolete groupsOuterClass$UpdateGroupMembersUpdateObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupMembersUpdateObsolete, "input");
        int groupId = groupsOuterClass$UpdateGroupMembersUpdateObsolete.getGroupId();
        List<GroupsStruct$Member> membersList = groupsOuterClass$UpdateGroupMembersUpdateObsolete.getMembersList();
        AbstractC13042fc3.h(membersList, "getMembersList(...)");
        List<GroupsStruct$Member> list = membersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (GroupsStruct$Member groupsStruct$Member : list) {
            int uid = groupsStruct$Member.getUid();
            int inviterUid = groupsStruct$Member.getInviterUid();
            long date = groupsStruct$Member.getDate();
            BoolValue isAdmin = groupsStruct$Member.getIsAdmin();
            Boolean boolValueOf = isAdmin != null ? Boolean.valueOf(isAdmin.getValue()) : null;
            Int32Value promoterUserId = groupsStruct$Member.getPromoterUserId();
            Integer numValueOf = promoterUserId != null ? Integer.valueOf(promoterUserId.getValue()) : null;
            CollectionsStruct$Int64Value promotedAt = groupsStruct$Member.getPromotedAt();
            Long lValueOf = promotedAt != null ? Long.valueOf(promotedAt.getValue()) : null;
            DA daK0 = C18732p92.K0(groupsStruct$Member.getPermissions());
            StringValue title = groupsStruct$Member.getTitle();
            arrayList.add(new C22883vz(uid, inviterUid, date, boolValueOf, numValueOf, lValueOf, daK0, title != null ? title.getValue() : null));
        }
        return new C12219eE7(groupId, arrayList);
    }
}
