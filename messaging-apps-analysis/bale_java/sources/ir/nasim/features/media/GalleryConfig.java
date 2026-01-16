package ir.nasim.features.media;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class GalleryConfig implements Parcelable {
    public static final Parcelable.Creator<GalleryConfig> CREATOR = new a();
    private String[] a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private boolean h;
    private boolean i;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GalleryConfig createFromParcel(Parcel parcel) {
            return new GalleryConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GalleryConfig[] newArray(int i) {
            return new GalleryConfig[i];
        }
    }

    public static class b {
        private String[] a;
        private String b;
        private boolean c = false;
        private boolean d = true;
        private boolean e = true;
        private boolean f = false;
        private boolean g = false;
        private int h = 9;
        private long i;

        public GalleryConfig a() {
            int i;
            int i2 = 1;
            if (!this.c && (i = this.h) > 0) {
                i2 = i;
            }
            this.h = i2;
            return new GalleryConfig(this.a, this.b, this.c, this.d, this.h, this.i, this.e, this.f, this.g);
        }

        public b b(String[] strArr) {
            this.a = strArr;
            return this;
        }

        public b c(String str) {
            this.b = str;
            return this;
        }

        public b d(int i) {
            this.h = i;
            return this;
        }

        public b e(boolean z) {
            this.e = z;
            return this;
        }

        public b f(boolean z) {
            this.f = z;
            return this;
        }

        public b g(boolean z) {
            this.g = z;
            return this;
        }

        public b h(boolean z) {
            this.c = z;
            return this;
        }
    }

    public boolean a() {
        return this.h;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.a);
        parcel.writeString(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f);
        parcel.writeLong(this.g);
    }

    private GalleryConfig(String[] strArr, String str, boolean z, boolean z2, int i, long j, boolean z3, boolean z4, boolean z5) {
        this.a = strArr;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.h = z4;
        this.i = z5;
        this.f = i;
        this.g = j;
    }

    protected GalleryConfig(Parcel parcel) {
        this.a = parcel.createStringArray();
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.f = parcel.readInt();
        this.g = parcel.readLong();
    }
}
