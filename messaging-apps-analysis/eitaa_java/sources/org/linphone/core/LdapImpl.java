package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Ldap.java */
/* loaded from: classes3.dex */
class LdapImpl implements Ldap {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native Core getCore(long j);

    private native int getIndex(long j);

    private native LdapParams getParams(long j);

    private native Ldap newWithParams(long j, Core core, LdapParams ldapParams);

    private native void setIndex(long j, int i);

    private native void setParams(long j, LdapParams ldapParams);

    private native boolean unref(long j, boolean z);

    protected LdapImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Ldap
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Ldap
    public synchronized Core getCore() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCore() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Ldap
    public synchronized int getIndex() {
        return getIndex(this.nativePtr);
    }

    @Override // org.linphone.core.Ldap
    public synchronized void setIndex(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setIndex() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setIndex(this.nativePtr, i);
    }

    @Override // org.linphone.core.Ldap
    public synchronized LdapParams getParams() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getParams(this.nativePtr);
    }

    @Override // org.linphone.core.Ldap
    public synchronized void setParams(LdapParams ldapParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setParams(this.nativePtr, ldapParams);
    }

    @Override // org.linphone.core.Ldap
    public synchronized Ldap newWithParams(Core core, LdapParams ldapParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newWithParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newWithParams(this.nativePtr, core, ldapParams);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Ldap
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Ldap
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Ldap
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
