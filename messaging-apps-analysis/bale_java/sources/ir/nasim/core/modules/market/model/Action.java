package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001c\u0010\u0013J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH×\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010\u0018¨\u0006("}, d2 = {"Lir/nasim/core/modules/market/model/Action;", "Landroid/os/Parcelable;", "", "id", "", "type", "", "url", "<init>", "(Ljava/lang/Long;ILjava/lang/String;)V", "Lir/nasim/rB7;", "validate", "()V", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/Long;", "component2", "component3", "()Ljava/lang/String;", "copy", "(Ljava/lang/Long;ILjava/lang/String;)Lir/nasim/core/modules/market/model/Action;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", TokenNames.I, "getType", "Ljava/lang/String;", "getUrl", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class Action implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<Action> CREATOR = new a();

    @InterfaceC23984xq6("id")
    private final Long id;

    @InterfaceC23984xq6("type")
    private final int type;

    @InterfaceC23984xq6("url")
    private final String url;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Action createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new Action(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Action[] newArray(int i) {
            return new Action[i];
        }
    }

    public Action(Long l, int i, String str) {
        this.id = l;
        this.type = i;
        this.url = str;
    }

    public static /* synthetic */ Action copy$default(Action action, Long l, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = action.id;
        }
        if ((i2 & 2) != 0) {
            i = action.type;
        }
        if ((i2 & 4) != 0) {
            str = action.url;
        }
        return action.copy(l, i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final Action copy(Long id, int type, String url) {
        return new Action(id, type, url);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Action)) {
            return false;
        }
        Action action = (Action) other;
        return AbstractC13042fc3.d(this.id, action.id) && this.type == action.type && AbstractC13042fc3.d(this.url, action.url);
    }

    public final Long getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (((l == null ? 0 : l.hashCode()) * 31) + Integer.hashCode(this.type)) * 31;
        String str = this.url;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Action(id=" + this.id + ", type=" + this.type + ", url=" + this.url + Separators.RPAREN;
    }

    public final void validate() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        Long l = this.id;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeInt(this.type);
        dest.writeString(this.url);
    }
}
