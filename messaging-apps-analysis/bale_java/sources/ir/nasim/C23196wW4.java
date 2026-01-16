package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity;

/* renamed from: ir.nasim.wW4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23196wW4 {
    public static final C23196wW4 a = new C23196wW4();

    private C23196wW4() {
    }

    private final Parcel b(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        AbstractC13042fc3.h(parcelObtain, "obtain(...)");
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        return parcelObtain;
    }

    public final byte[] a(AbsFeedMessageDataEntity absFeedMessageDataEntity) {
        AbstractC13042fc3.i(absFeedMessageDataEntity, "absFeedMessage");
        Parcel parcelObtain = Parcel.obtain();
        AbstractC13042fc3.h(parcelObtain, "obtain(...)");
        absFeedMessageDataEntity.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        AbstractC13042fc3.f(bArrMarshall);
        return bArrMarshall;
    }

    public final Object c(byte[] bArr, Parcelable.Creator creator) {
        AbstractC13042fc3.i(bArr, "bytes");
        AbstractC13042fc3.i(creator, "creator");
        Parcel parcelB = b(bArr);
        Object objCreateFromParcel = creator.createFromParcel(parcelB);
        parcelB.recycle();
        return objCreateFromParcel;
    }
}
