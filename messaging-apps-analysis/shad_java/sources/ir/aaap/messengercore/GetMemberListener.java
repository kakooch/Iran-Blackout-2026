package ir.aaap.messengercore;

import ir.aaap.messengercore.model.InChatMember;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public interface GetMemberListener {
    void onMembersDidLoad(ArrayList<InChatMember> arrayList, boolean z, String str);

    void onMembersLoadingFailed();
}
