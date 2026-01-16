package androidx.compose.runtime;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ZG6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableState;", TokenNames.T, "Landroidx/compose/runtime/g;", "Landroid/os/Parcelable;", "value", "Lir/nasim/ZG6;", "policy", "<init>", "(Ljava/lang/Object;Lir/nasim/ZG6;)V", "Landroid/os/Parcel;", "parcel", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "d", "b", "runtime_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class ParcelableSnapshotMutableState<T> extends g implements Parcelable {
    public static final Parcelable.Creator<ParcelableSnapshotMutableState<Object>> CREATOR = new a();

    public static final class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSnapshotMutableState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSnapshotMutableState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            ZG6 zg6J;
            if (classLoader == null) {
                classLoader = a.class.getClassLoader();
            }
            Object value = parcel.readValue(classLoader);
            int i = parcel.readInt();
            if (i == 0) {
                zg6J = AbstractC10222bH6.j();
            } else if (i == 1) {
                zg6J = AbstractC10222bH6.s();
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Unsupported MutableState policy " + i + " was restored");
                }
                zg6J = AbstractC10222bH6.p();
            }
            return new ParcelableSnapshotMutableState(value, zg6J);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ParcelableSnapshotMutableState[] newArray(int i) {
            return new ParcelableSnapshotMutableState[i];
        }
    }

    public ParcelableSnapshotMutableState(Object obj, ZG6 zg6) {
        super(obj, zg6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int i;
        parcel.writeValue(getValue());
        ZG6 zg6C = c();
        if (AbstractC13042fc3.d(zg6C, AbstractC10222bH6.j())) {
            i = 0;
        } else if (AbstractC13042fc3.d(zg6C, AbstractC10222bH6.s())) {
            i = 1;
        } else {
            if (!AbstractC13042fc3.d(zg6C, AbstractC10222bH6.p())) {
                throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
            }
            i = 2;
        }
        parcel.writeInt(i);
    }
}
