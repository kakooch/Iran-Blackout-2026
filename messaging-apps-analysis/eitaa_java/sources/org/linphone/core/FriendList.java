package org.linphone.core;

/* loaded from: classes3.dex */
public interface FriendList {
    Status addFriend(Friend friend);

    void addListener(FriendListListener friendListListener);

    Status addLocalFriend(Friend friend);

    void exportFriendsAsVcard4File(String str);

    Friend findFriendByAddress(Address address);

    Friend findFriendByPhoneNumber(String str);

    Friend findFriendByRefKey(String str);

    Friend findFriendByUri(String str);

    Friend[] findFriendsByAddress(Address address);

    Friend[] findFriendsByUri(String str);

    Core getCore();

    String getDisplayName();

    Friend[] getFriends();

    long getNativePointer();

    Address getRlsAddress();

    @Deprecated
    String getRlsUri();

    FriendListType getType();

    String getUri();

    Object getUserData();

    int importFriendsFromVcard4Buffer(String str);

    int importFriendsFromVcard4File(String str);

    boolean isSubscriptionBodyless();

    boolean isSubscriptionsEnabled();

    void notifyPresence(PresenceModel presenceModel);

    Status removeFriend(Friend friend);

    void removeListener(FriendListListener friendListListener);

    void setDisplayName(String str);

    void setRlsAddress(Address address);

    @Deprecated
    void setRlsUri(String str);

    void setSubscriptionBodyless(boolean z);

    void setSubscriptionsEnabled(boolean z);

    void setType(FriendListType friendListType);

    void setUri(String str);

    void setUserData(Object obj);

    void synchronizeFriendsFromServer();

    String toString();

    void updateDirtyFriends();

    void updateRevision(int i);

    void updateSubscriptions();

    public enum SyncStatus {
        Started(0),
        Successful(1),
        Failure(2);

        protected final int mValue;

        SyncStatus(int i) {
            this.mValue = i;
        }

        public static SyncStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Started;
            }
            if (i == 1) {
                return Successful;
            }
            if (i == 2) {
                return Failure;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for SyncStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum Status {
        OK(0),
        NonExistentFriend(1),
        InvalidFriend(2);

        protected final int mValue;

        Status(int i) {
            this.mValue = i;
        }

        public static Status fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return OK;
            }
            if (i == 1) {
                return NonExistentFriend;
            }
            if (i == 2) {
                return InvalidFriend;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for Status");
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
