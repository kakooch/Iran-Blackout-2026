package ir.aaap.messengercore;

import ir.aaap.messengercore.model.Chat;
import java.util.Set;

/* loaded from: classes3.dex */
public interface GetChannelAdminAccessListListener {
    void onAccessDidLoad(String str, String str2, Set<Chat.EnumSetChannelAdminAccess> set);

    void onAccessLoadingFailed();
}
