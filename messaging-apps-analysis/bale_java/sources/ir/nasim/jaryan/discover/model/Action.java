package ir.nasim.jaryan.discover.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.core.modules.profile.entity.ExPeer;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J2\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u001c\u0010\u0012J\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH×\u0003¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010\u0018¨\u0006'"}, d2 = {"Lir/nasim/jaryan/discover/model/Action;", "Landroid/os/Parcelable;", "", "typeIsURL", "", "url", "Lir/nasim/core/modules/profile/entity/ExPeer;", "exPeer", "<init>", "(ZLjava/lang/String;Lir/nasim/core/modules/profile/entity/ExPeer;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "()Lir/nasim/core/modules/profile/entity/ExPeer;", "copy", "(ZLjava/lang/String;Lir/nasim/core/modules/profile/entity/ExPeer;)Lir/nasim/jaryan/discover/model/Action;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getTypeIsURL", "Ljava/lang/String;", "getUrl", "Lir/nasim/core/modules/profile/entity/ExPeer;", "getExPeer", "jaryan_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class Action implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Action> CREATOR = new a();

    @InterfaceC23984xq6("exPeer")
    private final ExPeer exPeer;

    @InterfaceC23984xq6("typeIsURL")
    private final boolean typeIsURL;

    @InterfaceC23984xq6("url")
    private final String url;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Action createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new Action(parcel.readInt() != 0, parcel.readString(), (ExPeer) parcel.readParcelable(Action.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Action[] newArray(int i) {
            return new Action[i];
        }
    }

    public Action(boolean z, String str, ExPeer exPeer) {
        this.typeIsURL = z;
        this.url = str;
        this.exPeer = exPeer;
    }

    public static /* synthetic */ Action copy$default(Action action, boolean z, String str, ExPeer exPeer, int i, Object obj) {
        if ((i & 1) != 0) {
            z = action.typeIsURL;
        }
        if ((i & 2) != 0) {
            str = action.url;
        }
        if ((i & 4) != 0) {
            exPeer = action.exPeer;
        }
        return action.copy(z, str, exPeer);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getTypeIsURL() {
        return this.typeIsURL;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final ExPeer getExPeer() {
        return this.exPeer;
    }

    public final Action copy(boolean typeIsURL, String url, ExPeer exPeer) {
        return new Action(typeIsURL, url, exPeer);
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
        return this.typeIsURL == action.typeIsURL && AbstractC13042fc3.d(this.url, action.url) && AbstractC13042fc3.d(this.exPeer, action.exPeer);
    }

    public final ExPeer getExPeer() {
        return this.exPeer;
    }

    public final boolean getTypeIsURL() {
        return this.typeIsURL;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.typeIsURL) * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ExPeer exPeer = this.exPeer;
        return iHashCode2 + (exPeer != null ? exPeer.hashCode() : 0);
    }

    public String toString() {
        return "Action(typeIsURL=" + this.typeIsURL + ", url=" + this.url + ", exPeer=" + this.exPeer + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.typeIsURL ? 1 : 0);
        dest.writeString(this.url);
        dest.writeParcelable(this.exPeer, flags);
    }
}
