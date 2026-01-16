package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.InterfaceC12954fS7;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
    private final InterfaceC12954fS7 a;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(InterfaceC12954fS7 interfaceC12954fS7) {
        this.a = interfaceC12954fS7;
    }

    public InterfaceC12954fS7 a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new androidx.versionedparcelable.a(parcel).L(this.a);
    }

    protected ParcelImpl(Parcel parcel) {
        this.a = new androidx.versionedparcelable.a(parcel).u();
    }
}
