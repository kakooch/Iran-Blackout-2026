package j$.util.concurrent;

import java.security.PrivilegedAction;

/* loaded from: classes2.dex */
class c implements PrivilegedAction<Boolean> {
    c() {
    }

    @Override // java.security.PrivilegedAction
    public Boolean run() {
        return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
    }
}
