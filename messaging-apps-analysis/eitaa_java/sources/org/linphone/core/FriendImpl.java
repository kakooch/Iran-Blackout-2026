package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Friend.java */
/* loaded from: classes3.dex */
class FriendImpl implements Friend {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addAddress(long j, Address address);

    private native void addListener(long j, FriendListener friendListener);

    private native void addPhoneNumber(long j, String str);

    private native void addPhoneNumberWithLabel(long j, FriendPhoneNumber friendPhoneNumber);

    private native boolean createVcard(long j, String str);

    private native void done(long j);

    private native void edit(long j);

    private native Address getAddress(long j);

    private native Address[] getAddresses(long j);

    private native int getCapabilities(long j);

    private native float getCapabilityVersion(long j, int i);

    private native int getConsolidatedPresence(long j);

    private native Core getCore(long j);

    private native int getIncSubscribePolicy(long j);

    private native String getName(long j);

    private native String getNativeUri(long j);

    private native String getOrganization(long j);

    private native String[] getPhoneNumbers(long j);

    private native FriendPhoneNumber[] getPhoneNumbersWithLabel(long j);

    private native String getPhoto(long j);

    private native PresenceModel getPresenceModel(long j);

    private native PresenceModel getPresenceModelForUriOrTel(long j, String str);

    private native String getRefKey(long j);

    private native boolean getStarred(long j);

    private native int getSubscriptionState(long j);

    private native Vcard getVcard(long j);

    private native boolean hasCapability(long j, int i);

    private native boolean hasCapabilityWithVersion(long j, int i, float f);

    private native boolean hasCapabilityWithVersionOrMore(long j, int i, float f);

    private native boolean hasPhoneNumber(long j, String str);

    private native boolean inList(long j);

    private native boolean isPresenceReceived(long j);

    private native boolean isSubscribesEnabled(long j);

    private native Friend newFromVcard(long j, Vcard vcard);

    private native void remove(long j);

    private native void removeAddress(long j, Address address);

    private native void removeListener(long j, FriendListener friendListener);

    private native void removePhoneNumber(long j, String str);

    private native void removePhoneNumberWithLabel(long j, FriendPhoneNumber friendPhoneNumber);

    private native void save(long j, Core core);

    private native int setAddress(long j, Address address);

    private native int setIncSubscribePolicy(long j, int i);

    private native int setName(long j, String str);

    private native void setNativeUri(long j, String str);

    private native void setOrganization(long j, String str);

    private native void setPhoto(long j, String str);

    private native void setPresenceModel(long j, PresenceModel presenceModel);

    private native void setPresenceModelForUriOrTel(long j, String str, PresenceModel presenceModel);

    private native void setRefKey(long j, String str);

    private native void setStarred(long j, boolean z);

    private native int setSubscribesEnabled(long j, boolean z);

    private native void setVcard(long j, Vcard vcard);

    private native boolean unref(long j, boolean z);

    protected FriendImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.Friend
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Friend
    public synchronized Address getAddress() {
        Address address;
        synchronized (this.core) {
            address = getAddress(this.nativePtr);
        }
        return address;
    }

    @Override // org.linphone.core.Friend
    public synchronized int setAddress(Address address) {
        int address2;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            address2 = setAddress(this.nativePtr, address);
        }
        return address2;
    }

    @Override // org.linphone.core.Friend
    public synchronized Address[] getAddresses() {
        Address[] addresses;
        synchronized (this.core) {
            addresses = getAddresses(this.nativePtr);
        }
        return addresses;
    }

    @Override // org.linphone.core.Friend
    public synchronized int getCapabilities() {
        int capabilities;
        synchronized (this.core) {
            capabilities = getCapabilities(this.nativePtr);
        }
        return capabilities;
    }

    @Override // org.linphone.core.Friend
    public synchronized ConsolidatedPresence getConsolidatedPresence() {
        ConsolidatedPresence consolidatedPresenceFromInt;
        synchronized (this.core) {
            consolidatedPresenceFromInt = ConsolidatedPresence.fromInt(getConsolidatedPresence(this.nativePtr));
        }
        return consolidatedPresenceFromInt;
    }

    @Override // org.linphone.core.Friend
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Friend
    public synchronized SubscribePolicy getIncSubscribePolicy() {
        SubscribePolicy subscribePolicyFromInt;
        synchronized (this.core) {
            subscribePolicyFromInt = SubscribePolicy.fromInt(getIncSubscribePolicy(this.nativePtr));
        }
        return subscribePolicyFromInt;
    }

    @Override // org.linphone.core.Friend
    public synchronized int setIncSubscribePolicy(SubscribePolicy subscribePolicy) {
        int incSubscribePolicy;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setIncSubscribePolicy() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            incSubscribePolicy = setIncSubscribePolicy(this.nativePtr, subscribePolicy.toInt());
        }
        return incSubscribePolicy;
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean isPresenceReceived() {
        boolean zIsPresenceReceived;
        synchronized (this.core) {
            zIsPresenceReceived = isPresenceReceived(this.nativePtr);
        }
        return zIsPresenceReceived;
    }

    @Override // org.linphone.core.Friend
    public synchronized String getName() {
        String name;
        synchronized (this.core) {
            name = getName(this.nativePtr);
        }
        return name;
    }

    @Override // org.linphone.core.Friend
    public synchronized int setName(String str) {
        int name;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setName() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            name = setName(this.nativePtr, str);
        }
        return name;
    }

    @Override // org.linphone.core.Friend
    public synchronized String getNativeUri() {
        String nativeUri;
        synchronized (this.core) {
            nativeUri = getNativeUri(this.nativePtr);
        }
        return nativeUri;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setNativeUri(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setNativeUri() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setNativeUri(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized String getOrganization() {
        String organization;
        synchronized (this.core) {
            organization = getOrganization(this.nativePtr);
        }
        return organization;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setOrganization(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setOrganization() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setOrganization(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized String[] getPhoneNumbers() {
        String[] phoneNumbers;
        synchronized (this.core) {
            phoneNumbers = getPhoneNumbers(this.nativePtr);
        }
        return phoneNumbers;
    }

    @Override // org.linphone.core.Friend
    public synchronized FriendPhoneNumber[] getPhoneNumbersWithLabel() {
        FriendPhoneNumber[] phoneNumbersWithLabel;
        synchronized (this.core) {
            phoneNumbersWithLabel = getPhoneNumbersWithLabel(this.nativePtr);
        }
        return phoneNumbersWithLabel;
    }

    @Override // org.linphone.core.Friend
    public synchronized String getPhoto() {
        String photo;
        synchronized (this.core) {
            photo = getPhoto(this.nativePtr);
        }
        return photo;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setPhoto(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPhoto() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPhoto(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized PresenceModel getPresenceModel() {
        PresenceModel presenceModel;
        synchronized (this.core) {
            presenceModel = getPresenceModel(this.nativePtr);
        }
        return presenceModel;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setPresenceModel(PresenceModel presenceModel) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPresenceModel() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPresenceModel(this.nativePtr, presenceModel);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized String getRefKey() {
        String refKey;
        synchronized (this.core) {
            refKey = getRefKey(this.nativePtr);
        }
        return refKey;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setRefKey(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRefKey() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setRefKey(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean getStarred() {
        boolean starred;
        synchronized (this.core) {
            starred = getStarred(this.nativePtr);
        }
        return starred;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setStarred(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setStarred() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setStarred(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean isSubscribesEnabled() {
        boolean zIsSubscribesEnabled;
        synchronized (this.core) {
            zIsSubscribesEnabled = isSubscribesEnabled(this.nativePtr);
        }
        return zIsSubscribesEnabled;
    }

    @Override // org.linphone.core.Friend
    public synchronized int setSubscribesEnabled(boolean z) {
        int subscribesEnabled;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setSubscribesEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            subscribesEnabled = setSubscribesEnabled(this.nativePtr, z);
        }
        return subscribesEnabled;
    }

    @Override // org.linphone.core.Friend
    public synchronized SubscriptionState getSubscriptionState() {
        SubscriptionState subscriptionStateFromInt;
        synchronized (this.core) {
            subscriptionStateFromInt = SubscriptionState.fromInt(getSubscriptionState(this.nativePtr));
        }
        return subscriptionStateFromInt;
    }

    @Override // org.linphone.core.Friend
    public synchronized Vcard getVcard() {
        Vcard vcard;
        synchronized (this.core) {
            vcard = getVcard(this.nativePtr);
        }
        return vcard;
    }

    @Override // org.linphone.core.Friend
    public synchronized void setVcard(Vcard vcard) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setVcard() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setVcard(this.nativePtr, vcard);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void addAddress(Address address) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addAddress(this.nativePtr, address);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void addPhoneNumber(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addPhoneNumber() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addPhoneNumber(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void addPhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addPhoneNumberWithLabel() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addPhoneNumberWithLabel(this.nativePtr, friendPhoneNumber);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean createVcard(String str) {
        boolean zCreateVcard;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createVcard() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zCreateVcard = createVcard(this.nativePtr, str);
        }
        return zCreateVcard;
    }

    @Override // org.linphone.core.Friend
    public synchronized void done() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call done() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            done(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void edit() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call edit() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            edit(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized float getCapabilityVersion(FriendCapability friendCapability) {
        float capabilityVersion;
        synchronized (this.core) {
            capabilityVersion = getCapabilityVersion(this.nativePtr, friendCapability.toInt());
        }
        return capabilityVersion;
    }

    @Override // org.linphone.core.Friend
    public synchronized PresenceModel getPresenceModelForUriOrTel(String str) {
        PresenceModel presenceModelForUriOrTel;
        synchronized (this.core) {
            presenceModelForUriOrTel = getPresenceModelForUriOrTel(this.nativePtr, str);
        }
        return presenceModelForUriOrTel;
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean hasCapability(FriendCapability friendCapability) {
        boolean zHasCapability;
        synchronized (this.core) {
            zHasCapability = hasCapability(this.nativePtr, friendCapability.toInt());
        }
        return zHasCapability;
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean hasCapabilityWithVersion(FriendCapability friendCapability, float f) {
        boolean zHasCapabilityWithVersion;
        synchronized (this.core) {
            zHasCapabilityWithVersion = hasCapabilityWithVersion(this.nativePtr, friendCapability.toInt(), f);
        }
        return zHasCapabilityWithVersion;
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean hasCapabilityWithVersionOrMore(FriendCapability friendCapability, float f) {
        boolean zHasCapabilityWithVersionOrMore;
        synchronized (this.core) {
            zHasCapabilityWithVersionOrMore = hasCapabilityWithVersionOrMore(this.nativePtr, friendCapability.toInt(), f);
        }
        return zHasCapabilityWithVersionOrMore;
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean hasPhoneNumber(String str) {
        boolean zHasPhoneNumber;
        synchronized (this.core) {
            zHasPhoneNumber = hasPhoneNumber(this.nativePtr, str);
        }
        return zHasPhoneNumber;
    }

    @Override // org.linphone.core.Friend
    public synchronized boolean inList() {
        boolean zInList;
        synchronized (this.core) {
            zInList = inList(this.nativePtr);
        }
        return zInList;
    }

    @Override // org.linphone.core.Friend
    public synchronized void remove() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call remove() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            remove(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void removeAddress(Address address) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removeAddress(this.nativePtr, address);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void removePhoneNumber(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removePhoneNumber() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removePhoneNumber(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void removePhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removePhoneNumberWithLabel() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removePhoneNumberWithLabel(this.nativePtr, friendPhoneNumber);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void save(Core core) {
        synchronized (core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call save() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            save(this.nativePtr, core);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized void setPresenceModelForUriOrTel(String str, PresenceModel presenceModel) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPresenceModelForUriOrTel() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPresenceModelForUriOrTel(this.nativePtr, str, presenceModel);
        }
    }

    @Override // org.linphone.core.Friend
    public synchronized Friend newFromVcard(Vcard vcard) {
        Friend friendNewFromVcard;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call newFromVcard() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            friendNewFromVcard = newFromVcard(this.nativePtr, vcard);
        }
        return friendNewFromVcard;
    }

    @Override // org.linphone.core.Friend
    public synchronized void addListener(FriendListener friendListener) {
        addListener(this.nativePtr, friendListener);
    }

    @Override // org.linphone.core.Friend
    public synchronized void removeListener(FriendListener friendListener) {
        removeListener(this.nativePtr, friendListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Friend
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Friend
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Friend
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
