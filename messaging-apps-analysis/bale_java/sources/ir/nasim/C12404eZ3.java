package ir.nasim;

import android.media.session.MediaSessionManager;

/* renamed from: ir.nasim.eZ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C12404eZ3 extends C13013fZ3 {
    final MediaSessionManager.RemoteUserInfo d;

    C12404eZ3(String str, int i, int i2) {
        super(str, i, i2);
        this.d = AbstractC11761dZ3.a(str, i, i2);
    }

    static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPackageName();
    }

    C12404eZ3(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        this.d = remoteUserInfo;
    }
}
