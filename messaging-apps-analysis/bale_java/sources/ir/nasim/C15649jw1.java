package ir.nasim;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.jw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15649jw1 {
    public byte[] a(List list) {
        ArrayList<? extends Parcelable> arrayListD = AbstractC3344Am0.d(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListD);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
