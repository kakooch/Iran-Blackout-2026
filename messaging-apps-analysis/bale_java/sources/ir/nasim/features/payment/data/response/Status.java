package ir.nasim.features.payment.data.response;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ:\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u001a\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH×\u0003¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010#\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b$\u0010%R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b(\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u001a¨\u0006+"}, d2 = {"Lir/nasim/features/payment/data/response/Status;", "Landroid/os/Parcelable;", "", "isEnable", "", DialogEntity.COLUMN_MESSAGE, "title", "", "minAppVersion", "<init>", "(ZLjava/lang/String;Ljava/lang/String;J)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "component4", "()J", "copy", "(ZLjava/lang/String;Ljava/lang/String;J)Lir/nasim/features/payment/data/response/Status;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "setEnable", "(Z)V", "Ljava/lang/String;", "getMessage", "getTitle", "J", "getMinAppVersion", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class Status implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Status> CREATOR = new a();

    @InterfaceC23984xq6("Enable")
    private boolean isEnable;

    @InterfaceC23984xq6("Message")
    private final String message;

    @InterfaceC23984xq6("MinAppVersion")
    private final long minAppVersion;

    @InterfaceC23984xq6("Title")
    private final String title;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Status createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new Status(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Status[] newArray(int i) {
            return new Status[i];
        }
    }

    public Status(boolean z, String str, String str2, long j) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        this.isEnable = z;
        this.message = str;
        this.title = str2;
        this.minAppVersion = j;
    }

    public static /* synthetic */ Status copy$default(Status status, boolean z, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = status.isEnable;
        }
        if ((i & 2) != 0) {
            str = status.message;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = status.title;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            j = status.minAppVersion;
        }
        return status.copy(z, str3, str4, j);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final long getMinAppVersion() {
        return this.minAppVersion;
    }

    public final Status copy(boolean isEnable, String message, String title, long minAppVersion) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        return new Status(isEnable, message, title, minAppVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Status)) {
            return false;
        }
        Status status = (Status) other;
        return this.isEnable == status.isEnable && AbstractC13042fc3.d(this.message, status.message) && AbstractC13042fc3.d(this.title, status.title) && this.minAppVersion == status.minAppVersion;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getMinAppVersion() {
        return this.minAppVersion;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.isEnable) * 31) + this.message.hashCode()) * 31;
        String str = this.title;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.minAppVersion);
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setEnable(boolean z) {
        this.isEnable = z;
    }

    public String toString() {
        return "Status(isEnable=" + this.isEnable + ", message=" + this.message + ", title=" + this.title + ", minAppVersion=" + this.minAppVersion + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.isEnable ? 1 : 0);
        dest.writeString(this.message);
        dest.writeString(this.title);
        dest.writeLong(this.minAppVersion);
    }

    public /* synthetic */ Status(boolean z, String str, String str2, long j, int i, ED1 ed1) {
        this(z, str, str2, (i & 8) != 0 ? 0L : j);
    }
}
