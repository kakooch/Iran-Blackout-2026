package ir.aaap.messengercore;

import ir.aaap.messengercore.model.Chat;
import java.util.Set;

/* loaded from: classes3.dex */
public interface GetGroupAdminAccessListListener {
    void onAccessDidLoad(String str, String str2, Set<Chat.EnumSetGroupAdminAccess> set);

    void onAccessLoadingFailed();
}
