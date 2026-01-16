package ir.nasim;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class YY3 {
    ZY3 a;

    public YY3(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new C12404eZ3(str, i, i2);
        } else {
            this.a = new C13013fZ3(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YY3) {
            return this.a.equals(((YY3) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public YY3(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String strA = C12404eZ3.a(remoteUserInfo);
        if (strA != null) {
            if (!TextUtils.isEmpty(strA)) {
                this.a = new C12404eZ3(remoteUserInfo);
                return;
            }
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        throw new NullPointerException("package shouldn't be null");
    }
}
