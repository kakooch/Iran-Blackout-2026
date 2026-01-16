package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.j;

/* loaded from: classes2.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
    final String a;
    final String b;
    final boolean c;
    final boolean d;
    final int e;
    final int f;
    final String g;
    final boolean h;
    final boolean i;
    final boolean j;
    final boolean k;
    final int l;
    final String m;
    final int n;
    final boolean o;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    FragmentState(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.f;
        this.c = fragment.p;
        this.d = fragment.r;
        this.e = fragment.z;
        this.f = fragment.A;
        this.g = fragment.B;
        this.h = fragment.H;
        this.i = fragment.m;
        this.j = fragment.G;
        this.k = fragment.D;
        this.l = fragment.L0.ordinal();
        this.m = fragment.i;
        this.n = fragment.j;
        this.o = fragment.D0;
    }

    Fragment a(o oVar, ClassLoader classLoader) {
        Fragment fragmentA = oVar.a(classLoader, this.a);
        fragmentA.f = this.b;
        fragmentA.p = this.c;
        fragmentA.r = this.d;
        fragmentA.s = true;
        fragmentA.z = this.e;
        fragmentA.A = this.f;
        fragmentA.B = this.g;
        fragmentA.H = this.h;
        fragmentA.m = this.i;
        fragmentA.G = this.j;
        fragmentA.D = this.k;
        fragmentA.L0 = j.b.values()[this.l];
        fragmentA.i = this.m;
        fragmentA.j = this.n;
        fragmentA.D0 = this.o;
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.b);
        sb.append(")}:");
        if (this.c) {
            sb.append(" fromLayout");
        }
        if (this.d) {
            sb.append(" dynamicContainer");
        }
        if (this.f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f));
        }
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.g);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        if (this.m != null) {
            sb.append(" targetWho=");
            sb.append(this.m);
            sb.append(" targetRequestCode=");
            sb.append(this.n);
        }
        if (this.o) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    FragmentState(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt() != 0;
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readInt() != 0;
    }
}
