package org.linphone.core;

import org.linphone.core.FriendList;

/* loaded from: classes3.dex */
public interface FriendListListener {
    void onContactCreated(FriendList friendList, Friend friend);

    void onContactDeleted(FriendList friendList, Friend friend);

    void onContactUpdated(FriendList friendList, Friend friend, Friend friend2);

    void onPresenceReceived(FriendList friendList, Friend[] friendArr);

    void onSyncStatusChanged(FriendList friendList, FriendList.SyncStatus syncStatus, String str);
}
