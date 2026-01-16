package ir.eitaa.messenger.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICustomTabsCallback extends IInterface {
    void extraCallback(String var1, Bundle var2) throws RemoteException;

    void onMessageChannelReady(Bundle var1) throws RemoteException;

    void onNavigationEvent(int var1, Bundle var2) throws RemoteException;

    void onPostMessage(String var1, Bundle var2) throws RemoteException;

    public static abstract class Stub extends Binder implements ICustomTabsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 2) {
                data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                onNavigationEvent(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            }
            if (code == 3) {
                data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                extraCallback(data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            }
            if (code == 4) {
                data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                onMessageChannelReady(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            }
            if (code != 5) {
                if (code == 1598968902) {
                    reply.writeString("android.support.customtabs.ICustomTabsCallback");
                    return true;
                }
                return super.onTransact(code, data, reply, flags);
            }
            data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            onPostMessage(data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
            reply.writeNoException();
            return true;
        }
    }
}
