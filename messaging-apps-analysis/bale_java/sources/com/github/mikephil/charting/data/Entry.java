package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes2.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new a();
    private float d;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    }

    public Entry() {
        this.d = 0.0f;
    }

    public Entry copy() {
        return new Entry(this.d, getY(), getData());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry == null || entry.getData() != getData()) {
            return false;
        }
        float fAbs = Math.abs(entry.d - this.d);
        float f = Utils.FLOAT_EPSILON;
        return fAbs <= f && Math.abs(entry.getY() - getY()) <= f;
    }

    public float getX() {
        return this.d;
    }

    public void setX(float f) {
        this.d = f;
    }

    public String toString() {
        return "Entry, x: " + this.d + " y: " + getY();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.d);
        parcel.writeFloat(getY());
        if (getData() == null) {
            parcel.writeInt(0);
        } else {
            if (!(getData() instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) getData(), i);
        }
    }

    public Entry(float f, float f2) {
        super(f2);
        this.d = f;
    }

    public Entry(float f, float f2, Object obj) {
        super(f2, obj);
        this.d = f;
    }

    public Entry(float f, float f2, Drawable drawable) {
        super(f2, drawable);
        this.d = f;
    }

    public Entry(float f, float f2, Drawable drawable, Object obj) {
        super(f2, drawable, obj);
        this.d = f;
    }

    protected Entry(Parcel parcel) {
        this.d = 0.0f;
        this.d = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
