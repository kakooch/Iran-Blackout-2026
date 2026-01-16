package ir.nasim;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* renamed from: ir.nasim.iw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15058iw1 {
    public AbstractC12710f43 a(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
        parcelObtain.recycle();
        return AbstractC3344Am0.b(C14451hw1.A0, (ArrayList) AbstractC20011rK.e(bundle.getParcelableArrayList("c")));
    }
}
