package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Event.java */
/* loaded from: classes3.dex */
class EventImpl implements Event {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int acceptSubscription(long j);

    private native void addCustomHeader(long j, String str, String str2);

    private native void addListener(long j, EventListener eventListener);

    private native int denySubscription(long j, int i);

    private native Core getCore(long j);

    private native String getCustomHeader(long j, String str);

    private native ErrorInfo getErrorInfo(long j);

    private native Address getFrom(long j);

    private native String getName(long j);

    private native int getPublishState(long j);

    private native int getReason(long j);

    private native Address getRemoteContact(long j);

    private native Address getResource(long j);

    private native int getSubscriptionDir(long j);

    private native int getSubscriptionState(long j);

    private native Address getTo(long j);

    private native int notify(long j, Content content);

    private native void pausePublish(long j);

    private native int refreshPublish(long j);

    private native int refreshSubscribe(long j);

    private native void removeCustomHeader(long j, String str);

    private native void removeListener(long j, EventListener eventListener);

    private native int sendPublish(long j, Content content);

    private native int sendSubscribe(long j, Content content);

    private native void terminate(long j);

    private native boolean unref(long j, boolean z);

    private native int updatePublish(long j, Content content);

    private native int updateSubscribe(long j, Content content);

    protected EventImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.Event
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Event
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Event
    public synchronized ErrorInfo getErrorInfo() {
        ErrorInfo errorInfo;
        synchronized (this.core) {
            errorInfo = getErrorInfo(this.nativePtr);
        }
        return errorInfo;
    }

    @Override // org.linphone.core.Event
    public synchronized Address getFrom() {
        Address from;
        synchronized (this.core) {
            from = getFrom(this.nativePtr);
        }
        return from;
    }

    @Override // org.linphone.core.Event
    public synchronized String getName() {
        String name;
        synchronized (this.core) {
            name = getName(this.nativePtr);
        }
        return name;
    }

    @Override // org.linphone.core.Event
    public synchronized PublishState getPublishState() {
        PublishState publishStateFromInt;
        synchronized (this.core) {
            publishStateFromInt = PublishState.fromInt(getPublishState(this.nativePtr));
        }
        return publishStateFromInt;
    }

    @Override // org.linphone.core.Event
    public synchronized Reason getReason() {
        Reason reasonFromInt;
        synchronized (this.core) {
            reasonFromInt = Reason.fromInt(getReason(this.nativePtr));
        }
        return reasonFromInt;
    }

    @Override // org.linphone.core.Event
    public synchronized Address getRemoteContact() {
        Address remoteContact;
        synchronized (this.core) {
            remoteContact = getRemoteContact(this.nativePtr);
        }
        return remoteContact;
    }

    @Override // org.linphone.core.Event
    public synchronized Address getResource() {
        Address resource;
        synchronized (this.core) {
            resource = getResource(this.nativePtr);
        }
        return resource;
    }

    @Override // org.linphone.core.Event
    public synchronized SubscriptionDir getSubscriptionDir() {
        SubscriptionDir subscriptionDirFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getSubscriptionDir() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            subscriptionDirFromInt = SubscriptionDir.fromInt(getSubscriptionDir(this.nativePtr));
        }
        return subscriptionDirFromInt;
    }

    @Override // org.linphone.core.Event
    public synchronized SubscriptionState getSubscriptionState() {
        SubscriptionState subscriptionStateFromInt;
        synchronized (this.core) {
            subscriptionStateFromInt = SubscriptionState.fromInt(getSubscriptionState(this.nativePtr));
        }
        return subscriptionStateFromInt;
    }

    @Override // org.linphone.core.Event
    public synchronized Address getTo() {
        Address to;
        synchronized (this.core) {
            to = getTo(this.nativePtr);
        }
        return to;
    }

    @Override // org.linphone.core.Event
    public synchronized int acceptSubscription() {
        int iAcceptSubscription;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call acceptSubscription() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iAcceptSubscription = acceptSubscription(this.nativePtr);
        }
        return iAcceptSubscription;
    }

    @Override // org.linphone.core.Event
    public synchronized void addCustomHeader(String str, String str2) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addCustomHeader() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addCustomHeader(this.nativePtr, str, str2);
        }
    }

    @Override // org.linphone.core.Event
    public synchronized int denySubscription(Reason reason) {
        int iDenySubscription;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call denySubscription() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iDenySubscription = denySubscription(this.nativePtr, reason.toInt());
        }
        return iDenySubscription;
    }

    @Override // org.linphone.core.Event
    public synchronized String getCustomHeader(String str) {
        String customHeader;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getCustomHeader() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            customHeader = getCustomHeader(this.nativePtr, str);
        }
        return customHeader;
    }

    @Override // org.linphone.core.Event
    public synchronized int notify(Content content) {
        int iNotify;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call notify() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iNotify = notify(this.nativePtr, content);
        }
        return iNotify;
    }

    @Override // org.linphone.core.Event
    public synchronized void pausePublish() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call pausePublish() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            pausePublish(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Event
    public synchronized int refreshPublish() {
        int iRefreshPublish;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call refreshPublish() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iRefreshPublish = refreshPublish(this.nativePtr);
        }
        return iRefreshPublish;
    }

    @Override // org.linphone.core.Event
    public synchronized int refreshSubscribe() {
        int iRefreshSubscribe;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call refreshSubscribe() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iRefreshSubscribe = refreshSubscribe(this.nativePtr);
        }
        return iRefreshSubscribe;
    }

    @Override // org.linphone.core.Event
    public synchronized void removeCustomHeader(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeCustomHeader() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removeCustomHeader(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.Event
    public synchronized int sendPublish(Content content) {
        int iSendPublish;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call sendPublish() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iSendPublish = sendPublish(this.nativePtr, content);
        }
        return iSendPublish;
    }

    @Override // org.linphone.core.Event
    public synchronized int sendSubscribe(Content content) {
        int iSendSubscribe;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call sendSubscribe() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iSendSubscribe = sendSubscribe(this.nativePtr, content);
        }
        return iSendSubscribe;
    }

    @Override // org.linphone.core.Event
    public synchronized void terminate() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call terminate() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            terminate(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Event
    public synchronized int updatePublish(Content content) {
        int iUpdatePublish;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call updatePublish() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iUpdatePublish = updatePublish(this.nativePtr, content);
        }
        return iUpdatePublish;
    }

    @Override // org.linphone.core.Event
    public synchronized int updateSubscribe(Content content) {
        int iUpdateSubscribe;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call updateSubscribe() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iUpdateSubscribe = updateSubscribe(this.nativePtr, content);
        }
        return iUpdateSubscribe;
    }

    @Override // org.linphone.core.Event
    public synchronized void addListener(EventListener eventListener) {
        addListener(this.nativePtr, eventListener);
    }

    @Override // org.linphone.core.Event
    public synchronized void removeListener(EventListener eventListener) {
        removeListener(this.nativePtr, eventListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Event
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Event
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Event
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
