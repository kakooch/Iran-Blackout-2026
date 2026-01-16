package ir.aaap.messengercore;

import ir.aaap.messengercore.model.Chat;
import java.util.Set;

/* loaded from: classes3.dex */
public interface GetGroupDefaultAccessListListener {
    void onAccessDidLoad(String str, Set<Chat.EnumSetGroupMemberAccess> set);

    void onAccessLoadingFailed();
}
