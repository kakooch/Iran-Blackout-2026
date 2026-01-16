package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.x;
import androidx.lifecycle.j;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();
    final int[] a;
    final ArrayList b;
    final int[] c;
    final int[] d;
    final int e;
    final String f;
    final int g;
    final int h;
    final CharSequence i;
    final int j;
    final CharSequence k;
    final ArrayList l;
    final ArrayList m;
    final boolean n;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i) {
            return new BackStackRecordState[i];
        }
    }

    BackStackRecordState(C1957a c1957a) {
        int size = c1957a.c.size();
        this.a = new int[size * 6];
        if (!c1957a.i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.b = new ArrayList(size);
        this.c = new int[size];
        this.d = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            x.a aVar = (x.a) c1957a.c.get(i2);
            int i3 = i + 1;
            this.a[i] = aVar.a;
            ArrayList arrayList = this.b;
            Fragment fragment = aVar.b;
            arrayList.add(fragment != null ? fragment.f : null);
            int[] iArr = this.a;
            iArr[i3] = aVar.c ? 1 : 0;
            iArr[i + 2] = aVar.d;
            iArr[i + 3] = aVar.e;
            int i4 = i + 5;
            iArr[i + 4] = aVar.f;
            i += 6;
            iArr[i4] = aVar.g;
            this.c[i2] = aVar.h.ordinal();
            this.d[i2] = aVar.i.ordinal();
        }
        this.e = c1957a.h;
        this.f = c1957a.k;
        this.g = c1957a.v;
        this.h = c1957a.l;
        this.i = c1957a.m;
        this.j = c1957a.n;
        this.k = c1957a.o;
        this.l = c1957a.p;
        this.m = c1957a.q;
        this.n = c1957a.r;
    }

    private void a(C1957a c1957a) {
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= this.a.length) {
                c1957a.h = this.e;
                c1957a.k = this.f;
                c1957a.i = true;
                c1957a.l = this.h;
                c1957a.m = this.i;
                c1957a.n = this.j;
                c1957a.o = this.k;
                c1957a.p = this.l;
                c1957a.q = this.m;
                c1957a.r = this.n;
                return;
            }
            x.a aVar = new x.a();
            int i3 = i + 1;
            aVar.a = this.a[i];
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Instantiate " + c1957a + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            aVar.h = j.b.values()[this.c[i2]];
            aVar.i = j.b.values()[this.d[i2]];
            int[] iArr = this.a;
            int i4 = i + 2;
            if (iArr[i3] == 0) {
                z = false;
            }
            aVar.c = z;
            int i5 = iArr[i4];
            aVar.d = i5;
            int i6 = iArr[i + 3];
            aVar.e = i6;
            int i7 = i + 5;
            int i8 = iArr[i + 4];
            aVar.f = i8;
            i += 6;
            int i9 = iArr[i7];
            aVar.g = i9;
            c1957a.d = i5;
            c1957a.e = i6;
            c1957a.f = i8;
            c1957a.g = i9;
            c1957a.f(aVar);
            i2++;
        }
    }

    public C1957a b(FragmentManager fragmentManager) {
        C1957a c1957a = new C1957a(fragmentManager);
        a(c1957a);
        c1957a.v = this.g;
        for (int i = 0; i < this.b.size(); i++) {
            String str = (String) this.b.get(i);
            if (str != null) {
                ((x.a) c1957a.c.get(i)).b = fragmentManager.m0(str);
            }
        }
        c1957a.y(1);
        return c1957a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList(this.b);
        parcel.writeIntArray(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeStringList(this.l);
        parcel.writeStringList(this.m);
        parcel.writeInt(this.n ? 1 : 0);
    }

    BackStackRecordState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.createStringArrayList();
        this.c = parcel.createIntArray();
        this.d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.i = (CharSequence) creator.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.k = (CharSequence) creator.createFromParcel(parcel);
        this.l = parcel.createStringArrayList();
        this.m = parcel.createStringArrayList();
        this.n = parcel.readInt() != 0;
    }
}
