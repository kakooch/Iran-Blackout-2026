package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: DialPlan.java */
/* loaded from: classes3.dex */
class DialPlanImpl implements DialPlan {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native DialPlan byCcc(long j, String str);

    private native DialPlan byCccAsInt(long j, int i);

    private native DialPlan[] getAllList(long j);

    private native String getCountry(long j);

    private native String getCountryCallingCode(long j);

    private native String getInternationalCallPrefix(long j);

    private native String getIsoCountryCode(long j);

    private native int getNationalNumberLength(long j);

    private native boolean isGeneric(long j);

    private native int lookupCccFromE1644(long j, String str);

    private native int lookupCccFromIso(long j, String str);

    private native boolean unref(long j, boolean z);

    protected DialPlanImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.DialPlan
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.DialPlan
    public synchronized String getCountry() {
        return getCountry(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized String getCountryCallingCode() {
        return getCountryCallingCode(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized String getInternationalCallPrefix() {
        return getInternationalCallPrefix(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized boolean isGeneric() {
        return isGeneric(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized String getIsoCountryCode() {
        return getIsoCountryCode(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized int getNationalNumberLength() {
        return getNationalNumberLength(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized DialPlan byCcc(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call byCcc() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return byCcc(this.nativePtr, str);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized DialPlan byCccAsInt(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call byCccAsInt() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return byCccAsInt(this.nativePtr, i);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized DialPlan[] getAllList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getAllList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getAllList(this.nativePtr);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized int lookupCccFromE164(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call lookupCccFromE164() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return lookupCccFromE1644(this.nativePtr, str);
    }

    @Override // org.linphone.core.DialPlan
    public synchronized int lookupCccFromIso(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call lookupCccFromIso() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return lookupCccFromIso(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.DialPlan
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.DialPlan
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.DialPlan
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
