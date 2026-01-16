package ir.nasim.jaryan.search.data;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.KS2;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u0013¨\u0006'"}, d2 = {"Lir/nasim/jaryan/search/data/TooltipConfig;", "Landroid/os/Parcelable;", "", "uid", "", DialogEntity.COLUMN_MESSAGE, "date", "<init>", "(JLjava/lang/String;J)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "copy", "(JLjava/lang/String;J)Lir/nasim/jaryan/search/data/TooltipConfig;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUid", "Ljava/lang/String;", "getMessage", "getDate", "Companion", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class TooltipConfig implements Parcelable {
    public static final int $stable = 0;
    private final long date;
    private final String message;
    private final long uid;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<TooltipConfig> CREATOR = new b();

    /* renamed from: ir.nasim.jaryan.search.data.TooltipConfig$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final TooltipConfig a(String str) {
            AbstractC13042fc3.i(str, "json");
            if (str.length() == 0) {
                return null;
            }
            try {
                return (TooltipConfig) new KS2().k(str, TooltipConfig.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TooltipConfig createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new TooltipConfig(parcel.readLong(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TooltipConfig[] newArray(int i) {
            return new TooltipConfig[i];
        }
    }

    public TooltipConfig(long j, String str, long j2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        this.uid = j;
        this.message = str;
        this.date = j2;
    }

    public static /* synthetic */ TooltipConfig copy$default(TooltipConfig tooltipConfig, long j, String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = tooltipConfig.uid;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = tooltipConfig.message;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j2 = tooltipConfig.date;
        }
        return tooltipConfig.copy(j3, str2, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    public final TooltipConfig copy(long uid, String message, long date) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        return new TooltipConfig(uid, message, date);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TooltipConfig)) {
            return false;
        }
        TooltipConfig tooltipConfig = (TooltipConfig) other;
        return this.uid == tooltipConfig.uid && AbstractC13042fc3.d(this.message, tooltipConfig.message) && this.date == tooltipConfig.date;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((Long.hashCode(this.uid) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.date);
    }

    public String toString() {
        return "TooltipConfig(uid=" + this.uid + ", message=" + this.message + ", date=" + this.date + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.uid);
        dest.writeString(this.message);
        dest.writeLong(this.date);
    }
}
