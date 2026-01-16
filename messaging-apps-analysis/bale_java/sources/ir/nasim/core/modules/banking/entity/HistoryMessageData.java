package ir.nasim.core.modules.banking.entity;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b\u001a\u0010\u001d\"\u0004\b!\u0010\u001fR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lir/nasim/core/modules/banking/entity/HistoryMessageData;", "Landroid/os/Parcelable;", "", "peer", "date", "id", "<init>", "(JJJ)V", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "c", "()J", "setPeer", "(J)V", "b", "setDate", "setId", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class HistoryMessageData implements Parcelable {
    public static final Parcelable.Creator<HistoryMessageData> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata */
    private long peer;

    /* renamed from: b, reason: from kotlin metadata */
    private long date;

    /* renamed from: c, reason: from kotlin metadata */
    private long id;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HistoryMessageData createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new HistoryMessageData(parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HistoryMessageData[] newArray(int i) {
            return new HistoryMessageData[i];
        }
    }

    public HistoryMessageData(long j, long j2, long j3) {
        this.peer = j;
        this.date = j2;
        this.id = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final long getPeer() {
        return this.peer;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryMessageData)) {
            return false;
        }
        HistoryMessageData historyMessageData = (HistoryMessageData) other;
        return this.peer == historyMessageData.peer && this.date == historyMessageData.date && this.id == historyMessageData.id;
    }

    public int hashCode() {
        return (((Long.hashCode(this.peer) * 31) + Long.hashCode(this.date)) * 31) + Long.hashCode(this.id);
    }

    public String toString() {
        return "{\n" + this.peer + "  " + this.date + "   " + this.id + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.peer);
        dest.writeLong(this.date);
        dest.writeLong(this.id);
    }
}
