package org.linphone.core;

import org.linphone.core.FriendList;
import org.linphone.mediastream.Log;

/* compiled from: FriendList.java */
/* loaded from: classes3.dex */
class FriendListImpl implements FriendList {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int addFriend(long j, Friend friend);

    private native void addListener(long j, FriendListListener friendListListener);

    private native int addLocalFriend(long j, Friend friend);

    private native void exportFriendsAsVcard4File(long j, String str);

    private native Friend findFriendByAddress(long j, Address address);

    private native Friend findFriendByPhoneNumber(long j, String str);

    private native Friend findFriendByRefKey(long j, String str);

    private native Friend findFriendByUri(long j, String str);

    private native Friend[] findFriendsByAddress(long j, Address address);

    private native Friend[] findFriendsByUri(long j, String str);

    private native Core getCore(long j);

    private native String getDisplayName(long j);

    private native Friend[] getFriends(long j);

    private native Address getRlsAddress(long j);

    private native String getRlsUri(long j);

    private native int getType(long j);

    private native String getUri(long j);

    private native int importFriendsFromVcard4Buffer(long j, String str);

    private native int importFriendsFromVcard4File(long j, String str);

    private native boolean isSubscriptionBodyless(long j);

    private native boolean isSubscriptionsEnabled(long j);

    private native void notifyPresence(long j, PresenceModel presenceModel);

    private native int removeFriend(long j, Friend friend);

    private native void removeListener(long j, FriendListListener friendListListener);

    private native void setDisplayName(long j, String str);

    private native void setRlsAddress(long j, Address address);

    private native void setRlsUri(long j, String str);

    private native void setSubscriptionBodyless(long j, boolean z);

    private native void setSubscriptionsEnabled(long j, boolean z);

    private native void setType(long j, int i);

    private native void setUri(long j, String str);

    private native void synchronizeFriendsFromServer(long j);

    private native boolean unref(long j, boolean z);

    private native void updateDirtyFriends(long j);

    private native void updateRevision(long j, int i);

    private native void updateSubscriptions(long j);

    protected FriendListImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.FriendList
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.FriendList
    public synchronized String getDisplayName() {
        String displayName;
        synchronized (this.core) {
            displayName = getDisplayName(this.nativePtr);
        }
        return displayName;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setDisplayName(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setDisplayName() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setDisplayName(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend[] getFriends() {
        Friend[] friends;
        synchronized (this.core) {
            friends = getFriends(this.nativePtr);
        }
        return friends;
    }

    @Override // org.linphone.core.FriendList
    public synchronized boolean isSubscriptionBodyless() {
        boolean zIsSubscriptionBodyless;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isSubscriptionBodyless() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsSubscriptionBodyless = isSubscriptionBodyless(this.nativePtr);
        }
        return zIsSubscriptionBodyless;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Address getRlsAddress() {
        Address rlsAddress;
        synchronized (this.core) {
            rlsAddress = getRlsAddress(this.nativePtr);
        }
        return rlsAddress;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setRlsAddress(Address address) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRlsAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setRlsAddress(this.nativePtr, address);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized String getRlsUri() {
        String rlsUri;
        synchronized (this.core) {
            rlsUri = getRlsUri(this.nativePtr);
        }
        return rlsUri;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setRlsUri(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRlsUri() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setRlsUri(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setSubscriptionBodyless(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setSubscriptionBodyless() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setSubscriptionBodyless(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized boolean isSubscriptionsEnabled() {
        boolean zIsSubscriptionsEnabled;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isSubscriptionsEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsSubscriptionsEnabled = isSubscriptionsEnabled(this.nativePtr);
        }
        return zIsSubscriptionsEnabled;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setSubscriptionsEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setSubscriptionsEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setSubscriptionsEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized FriendListType getType() {
        FriendListType friendListTypeFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getType() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            friendListTypeFromInt = FriendListType.fromInt(getType(this.nativePtr));
        }
        return friendListTypeFromInt;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setType(FriendListType friendListType) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setType() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setType(this.nativePtr, friendListType.toInt());
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized String getUri() {
        String uri;
        synchronized (this.core) {
            uri = getUri(this.nativePtr);
        }
        return uri;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void setUri(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setUri() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setUri(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized FriendList.Status addFriend(Friend friend) {
        FriendList.Status statusFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addFriend() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            statusFromInt = FriendList.Status.fromInt(addFriend(this.nativePtr, friend));
        }
        return statusFromInt;
    }

    @Override // org.linphone.core.FriendList
    public synchronized FriendList.Status addLocalFriend(Friend friend) {
        FriendList.Status statusFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addLocalFriend() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            statusFromInt = FriendList.Status.fromInt(addLocalFriend(this.nativePtr, friend));
        }
        return statusFromInt;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void exportFriendsAsVcard4File(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call exportFriendsAsVcard4File() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            exportFriendsAsVcard4File(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend findFriendByAddress(Address address) {
        Friend friendFindFriendByAddress;
        synchronized (this.core) {
            friendFindFriendByAddress = findFriendByAddress(this.nativePtr, address);
        }
        return friendFindFriendByAddress;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend findFriendByPhoneNumber(String str) {
        Friend friendFindFriendByPhoneNumber;
        synchronized (this.core) {
            friendFindFriendByPhoneNumber = findFriendByPhoneNumber(this.nativePtr, str);
        }
        return friendFindFriendByPhoneNumber;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend findFriendByRefKey(String str) {
        Friend friendFindFriendByRefKey;
        synchronized (this.core) {
            friendFindFriendByRefKey = findFriendByRefKey(this.nativePtr, str);
        }
        return friendFindFriendByRefKey;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend findFriendByUri(String str) {
        Friend friendFindFriendByUri;
        synchronized (this.core) {
            friendFindFriendByUri = findFriendByUri(this.nativePtr, str);
        }
        return friendFindFriendByUri;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend[] findFriendsByAddress(Address address) {
        Friend[] friendArrFindFriendsByAddress;
        synchronized (this.core) {
            friendArrFindFriendsByAddress = findFriendsByAddress(this.nativePtr, address);
        }
        return friendArrFindFriendsByAddress;
    }

    @Override // org.linphone.core.FriendList
    public synchronized Friend[] findFriendsByUri(String str) {
        Friend[] friendArrFindFriendsByUri;
        synchronized (this.core) {
            friendArrFindFriendsByUri = findFriendsByUri(this.nativePtr, str);
        }
        return friendArrFindFriendsByUri;
    }

    @Override // org.linphone.core.FriendList
    public synchronized int importFriendsFromVcard4Buffer(String str) {
        int iImportFriendsFromVcard4Buffer;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call importFriendsFromVcard4Buffer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iImportFriendsFromVcard4Buffer = importFriendsFromVcard4Buffer(this.nativePtr, str);
        }
        return iImportFriendsFromVcard4Buffer;
    }

    @Override // org.linphone.core.FriendList
    public synchronized int importFriendsFromVcard4File(String str) {
        int iImportFriendsFromVcard4File;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call importFriendsFromVcard4File() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iImportFriendsFromVcard4File = importFriendsFromVcard4File(this.nativePtr, str);
        }
        return iImportFriendsFromVcard4File;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void notifyPresence(PresenceModel presenceModel) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call notifyPresence() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            notifyPresence(this.nativePtr, presenceModel);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized FriendList.Status removeFriend(Friend friend) {
        FriendList.Status statusFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeFriend() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            statusFromInt = FriendList.Status.fromInt(removeFriend(this.nativePtr, friend));
        }
        return statusFromInt;
    }

    @Override // org.linphone.core.FriendList
    public synchronized void synchronizeFriendsFromServer() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call synchronizeFriendsFromServer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            synchronizeFriendsFromServer(this.nativePtr);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized void updateDirtyFriends() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call updateDirtyFriends() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            updateDirtyFriends(this.nativePtr);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized void updateRevision(int i) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call updateRevision() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            updateRevision(this.nativePtr, i);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized void updateSubscriptions() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call updateSubscriptions() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            updateSubscriptions(this.nativePtr);
        }
    }

    @Override // org.linphone.core.FriendList
    public synchronized void addListener(FriendListListener friendListListener) {
        addListener(this.nativePtr, friendListListener);
    }

    @Override // org.linphone.core.FriendList
    public synchronized void removeListener(FriendListListener friendListListener) {
        removeListener(this.nativePtr, friendListListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.FriendList
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.FriendList
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.FriendList
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
