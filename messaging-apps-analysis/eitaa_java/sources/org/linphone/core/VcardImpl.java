package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Vcard.java */
/* loaded from: classes3.dex */
class VcardImpl implements Vcard {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addExtendedProperty(long j, String str, String str2);

    private native void addPhoneNumber(long j, String str);

    private native void addPhoneNumberWithLabel(long j, FriendPhoneNumber friendPhoneNumber);

    private native void addSipAddress(long j, String str);

    private native String asVcard4String(long j);

    private native Vcard clone(long j);

    private native void editMainSipAddress(long j, String str);

    private native boolean generateUniqueId(long j);

    private native String getEtag(long j);

    private native String[] getExtendedPropertiesValuesByName(long j, String str);

    private native String getFamilyName(long j);

    private native String getFullName(long j);

    private native String getGivenName(long j);

    private native String getOrganization(long j);

    private native String[] getPhoneNumbers(long j);

    private native FriendPhoneNumber[] getPhoneNumbersWithLabel(long j);

    private native String getPhoto(long j);

    private native Address[] getSipAddresses(long j);

    private native boolean getSkipValidation(long j);

    private native String getUid(long j);

    private native String getUrl(long j);

    private native void removeExtentedPropertiesByName(long j, String str);

    private native void removeOrganization(long j);

    private native void removePhoneNumber(long j, String str);

    private native void removePhoneNumberWithLabel(long j, FriendPhoneNumber friendPhoneNumber);

    private native void removePhoto(long j);

    private native void removeSipAddress(long j, String str);

    private native void setEtag(long j, String str);

    private native void setFamilyName(long j, String str);

    private native void setFullName(long j, String str);

    private native void setGivenName(long j, String str);

    private native void setOrganization(long j, String str);

    private native void setPhoto(long j, String str);

    private native void setSkipValidation(long j, boolean z);

    private native void setUid(long j, String str);

    private native void setUrl(long j, String str);

    private native boolean unref(long j, boolean z);

    protected VcardImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Vcard
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getEtag() {
        return getEtag(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setEtag(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEtag() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEtag(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getFamilyName() {
        return getFamilyName(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setFamilyName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFamilyName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFamilyName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getFullName() {
        return getFullName(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setFullName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFullName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFullName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getGivenName() {
        return getGivenName(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setGivenName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setGivenName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setGivenName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getOrganization() {
        return getOrganization(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setOrganization(String str) {
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

    @Override // org.linphone.core.Vcard
    public synchronized String[] getPhoneNumbers() {
        return getPhoneNumbers(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized FriendPhoneNumber[] getPhoneNumbersWithLabel() {
        return getPhoneNumbersWithLabel(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getPhoto() {
        return getPhoto(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setPhoto(String str) {
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

    @Override // org.linphone.core.Vcard
    public synchronized Address[] getSipAddresses() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getSipAddresses() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getSipAddresses(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized boolean getSkipValidation() {
        return getSkipValidation(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setSkipValidation(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSkipValidation() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSkipValidation(this.nativePtr, z);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getUid() {
        return getUid(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setUid(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUid() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUid(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String getUrl() {
        return getUrl(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void setUrl(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void addExtendedProperty(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addExtendedProperty() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addExtendedProperty(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void addPhoneNumber(String str) {
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

    @Override // org.linphone.core.Vcard
    public synchronized void addPhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber) {
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

    @Override // org.linphone.core.Vcard
    public synchronized void addSipAddress(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addSipAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addSipAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String asVcard4String() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call asVcard4String() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return asVcard4String(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized Vcard clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void editMainSipAddress(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call editMainSipAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        editMainSipAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized boolean generateUniqueId() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call generateUniqueId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return generateUniqueId(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized String[] getExtendedPropertiesValuesByName(String str) {
        return getExtendedPropertiesValuesByName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void removeExtentedPropertiesByName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeExtentedPropertiesByName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeExtentedPropertiesByName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void removeOrganization() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeOrganization() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeOrganization(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void removePhoneNumber(String str) {
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

    @Override // org.linphone.core.Vcard
    public synchronized void removePhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber) {
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

    @Override // org.linphone.core.Vcard
    public synchronized void removePhoto() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removePhoto() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removePhoto(this.nativePtr);
    }

    @Override // org.linphone.core.Vcard
    public synchronized void removeSipAddress(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeSipAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeSipAddress(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Vcard
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Vcard
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Vcard
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
