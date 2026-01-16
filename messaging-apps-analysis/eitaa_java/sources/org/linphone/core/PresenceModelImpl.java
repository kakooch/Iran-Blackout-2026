package org.linphone.core;

import org.linphone.core.PresenceActivity;
import org.linphone.mediastream.Log;

/* compiled from: PresenceModel.java */
/* loaded from: classes3.dex */
class PresenceModelImpl implements PresenceModel {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int addActivity(long j, PresenceActivity presenceActivity);

    private native int addNote(long j, String str, String str2);

    private native int addPerson(long j, PresencePerson presencePerson);

    private native int addService(long j, PresenceService presenceService);

    private native int clearActivities(long j);

    private native int clearNotes(long j);

    private native int clearPersons(long j);

    private native int clearServices(long j);

    private native PresenceActivity getActivity(long j);

    private native int getBasicStatus(long j);

    private native int getCapabilities(long j);

    private native float getCapabilityVersion(long j, int i);

    private native int getConsolidatedPresence(long j);

    private native String getContact(long j);

    private native long getLatestActivityTimestamp(long j);

    private native int getNbActivities(long j);

    private native int getNbPersons(long j);

    private native int getNbServices(long j);

    private native PresenceNote getNote(long j, String str);

    private native PresenceActivity getNthActivity(long j, int i);

    private native PresencePerson getNthPerson(long j, int i);

    private native PresenceService getNthService(long j, int i);

    private native Address getPresentity(long j);

    private native long getTimestamp(long j);

    private native boolean hasCapability(long j, int i);

    private native boolean hasCapabilityWithVersion(long j, int i, float f);

    private native boolean hasCapabilityWithVersionOrMore(long j, int i, float f);

    private native boolean isOnline(long j);

    private native PresenceModel newWithActivity(long j, int i, String str);

    private native PresenceModel newWithActivityAndNote(long j, int i, String str, String str2, String str3);

    private native int setActivity(long j, int i, String str);

    private native int setBasicStatus(long j, int i);

    private native int setContact(long j, String str);

    private native int setPresentity(long j, Address address);

    private native boolean unref(long j, boolean z);

    protected PresenceModelImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PresenceModel
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceActivity getActivity() {
        return getActivity(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceBasicStatus getBasicStatus() {
        return PresenceBasicStatus.fromInt(getBasicStatus(this.nativePtr));
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int setBasicStatus(PresenceBasicStatus presenceBasicStatus) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBasicStatus() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setBasicStatus(this.nativePtr, presenceBasicStatus.toInt());
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int getCapabilities() {
        return getCapabilities(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized ConsolidatedPresence getConsolidatedPresence() {
        return ConsolidatedPresence.fromInt(getConsolidatedPresence(this.nativePtr));
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized String getContact() {
        return getContact(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int setContact(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setContact() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setContact(this.nativePtr, str);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized boolean isOnline() {
        return isOnline(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized long getLatestActivityTimestamp() {
        return getLatestActivityTimestamp(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int getNbActivities() {
        return getNbActivities(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int getNbPersons() {
        return getNbPersons(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int getNbServices() {
        return getNbServices(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized Address getPresentity() {
        return getPresentity(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int setPresentity(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPresentity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setPresentity(this.nativePtr, address);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized long getTimestamp() {
        return getTimestamp(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int addActivity(PresenceActivity presenceActivity) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addActivity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addActivity(this.nativePtr, presenceActivity);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int addNote(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addNote() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addNote(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int addPerson(PresencePerson presencePerson) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addPerson() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addPerson(this.nativePtr, presencePerson);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int addService(PresenceService presenceService) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addService() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addService(this.nativePtr, presenceService);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int clearActivities() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearActivities() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearActivities(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int clearNotes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearNotes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearNotes(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int clearPersons() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearPersons() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearPersons(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int clearServices() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearServices() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearServices(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized float getCapabilityVersion(FriendCapability friendCapability) {
        return getCapabilityVersion(this.nativePtr, friendCapability.toInt());
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceNote getNote(String str) {
        return getNote(this.nativePtr, str);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceActivity getNthActivity(int i) {
        return getNthActivity(this.nativePtr, i);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresencePerson getNthPerson(int i) {
        return getNthPerson(this.nativePtr, i);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceService getNthService(int i) {
        return getNthService(this.nativePtr, i);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized boolean hasCapability(FriendCapability friendCapability) {
        return hasCapability(this.nativePtr, friendCapability.toInt());
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized boolean hasCapabilityWithVersion(FriendCapability friendCapability, float f) {
        return hasCapabilityWithVersion(this.nativePtr, friendCapability.toInt(), f);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized boolean hasCapabilityWithVersionOrMore(FriendCapability friendCapability, float f) {
        return hasCapabilityWithVersionOrMore(this.nativePtr, friendCapability.toInt(), f);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized int setActivity(PresenceActivity.Type type, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setActivity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setActivity(this.nativePtr, type.toInt(), str);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceModel newWithActivity(PresenceActivity.Type type, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newWithActivity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newWithActivity(this.nativePtr, type.toInt(), str);
    }

    @Override // org.linphone.core.PresenceModel
    public synchronized PresenceModel newWithActivityAndNote(PresenceActivity.Type type, String str, String str2, String str3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newWithActivityAndNote() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newWithActivityAndNote(this.nativePtr, type.toInt(), str, str2, str3);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PresenceModel
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PresenceModel
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PresenceModel
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
