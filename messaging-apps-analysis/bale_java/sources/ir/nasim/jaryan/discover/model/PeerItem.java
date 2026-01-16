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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH×\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u001a¨\u0006$"}, d2 = {"Lir/nasim/jaryan/discover/model/PeerItem;", "Landroid/os/Parcelable;", "Lir/nasim/jaryan/discover/model/Action;", "action", "Lir/nasim/core/modules/profile/entity/ExPeer;", "exPeer", "<init>", "(Lir/nasim/jaryan/discover/model/Action;Lir/nasim/core/modules/profile/entity/ExPeer;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "component1", "()Lir/nasim/jaryan/discover/model/Action;", "component2", "()Lir/nasim/core/modules/profile/entity/ExPeer;", "copy", "(Lir/nasim/jaryan/discover/model/Action;Lir/nasim/core/modules/profile/entity/ExPeer;)Lir/nasim/jaryan/discover/model/PeerItem;", "", "toString", "()Ljava/lang/String;", "Lir/nasim/jaryan/discover/model/Action;", "getAction", "Lir/nasim/core/modules/profile/entity/ExPeer;", "getExPeer", "jaryan_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class PeerItem implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PeerItem> CREATOR = new a();

    @InterfaceC23984xq6("action")
    private final Action action;

    @InterfaceC23984xq6("exPeer")
    private final ExPeer exPeer;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PeerItem createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new PeerItem(Action.CREATOR.createFromParcel(parcel), (ExPeer) parcel.readParcelable(PeerItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PeerItem[] newArray(int i) {
            return new PeerItem[i];
        }
    }

    public PeerItem(Action action, ExPeer exPeer) {
        AbstractC13042fc3.i(action, "action");
        AbstractC13042fc3.i(exPeer, "exPeer");
        this.action = action;
        this.exPeer = exPeer;
    }

    public static /* synthetic */ PeerItem copy$default(PeerItem peerItem, Action action, ExPeer exPeer, int i, Object obj) {
        if ((i & 1) != 0) {
            action = peerItem.action;
        }
        if ((i & 2) != 0) {
            exPeer = peerItem.exPeer;
        }
        return peerItem.copy(action, exPeer);
    }

    /* renamed from: component1, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final ExPeer getExPeer() {
        return this.exPeer;
    }

    public final PeerItem copy(Action action, ExPeer exPeer) {
        AbstractC13042fc3.i(action, "action");
        AbstractC13042fc3.i(exPeer, "exPeer");
        return new PeerItem(action, exPeer);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbstractC13042fc3.d(PeerItem.class, other != null ? other.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(other, "null cannot be cast to non-null type ir.nasim.jaryan.discover.model.PeerItem");
        return AbstractC13042fc3.d(this.exPeer, ((PeerItem) other).exPeer);
    }

    public final Action getAction() {
        return this.action;
    }

    public final ExPeer getExPeer() {
        return this.exPeer;
    }

    public int hashCode() {
        return this.exPeer.hashCode();
    }

    public String toString() {
        return "PeerItem(action=" + this.action + ", exPeer=" + this.exPeer + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        this.action.writeToParcel(dest, flags);
        dest.writeParcelable(this.exPeer, flags);
    }
}
