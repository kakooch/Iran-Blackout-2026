package com.google.android.search.verification.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

/* loaded from: classes3.dex */
public interface ISearchActionVerificationService extends IInterface {
    int getVersion() throws RemoteException;

    boolean isSearchAction(Intent intent, Bundle options) throws RemoteException;

    public static abstract class Stub extends BaseStub implements ISearchActionVerificationService {
        public static ISearchActionVerificationService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
            if (iInterfaceQueryLocalInterface instanceof ISearchActionVerificationService) {
                return (ISearchActionVerificationService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(obj);
        }

        public static class Proxy extends BaseProxy implements ISearchActionVerificationService {
            Proxy(IBinder remote) {
                super(remote, "com.google.android.search.verification.api.ISearchActionVerificationService");
            }

            @Override // com.google.android.search.verification.api.ISearchActionVerificationService
            public boolean isSearchAction(Intent intent, Bundle options) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, intent);
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, options);
                Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
                boolean zCreateBoolean = Codecs.createBoolean(parcelTransactAndReadException);
                parcelTransactAndReadException.recycle();
                return zCreateBoolean;
            }

            @Override // com.google.android.search.verification.api.ISearchActionVerificationService
            public int getVersion() throws RemoteException {
                Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                int i = parcelTransactAndReadException.readInt();
                parcelTransactAndReadException.recycle();
                return i;
            }
        }
    }
}
