package ir.nasim;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import ir.nasim.AbstractC12710f43;
import java.util.List;

/* renamed from: ir.nasim.ym0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class BinderC24528ym0 extends Binder {
    private static final int h;
    private final AbstractC12710f43 a;

    static {
        h = AbstractC9683aN7.a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public BinderC24528ym0(List list) {
        this.a = AbstractC12710f43.O(list);
    }

    public static AbstractC12710f43 a(IBinder iBinder) {
        int i;
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        int i2 = 0;
        int i3 = 1;
        while (i3 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i2);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i = parcelObtain2.readInt();
                        if (i == 1) {
                            aVarL.a((Bundle) AbstractC20011rK.e(parcelObtain2.readBundle()));
                            i2++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i3 = i;
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return aVarL.h();
    }

    @Override // android.os.Binder
    protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.a.size();
        int i3 = parcel.readInt();
        while (i3 < size && parcel2.dataSize() < h) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) this.a.get(i3));
            i3++;
        }
        parcel2.writeInt(i3 < size ? 2 : 0);
        return true;
    }
}
