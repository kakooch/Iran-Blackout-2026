package ir.nasim.features.call.ui.startOutGoingCall;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C11458d25;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\u001aB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0015\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!¨\u0006#"}, d2 = {"Lir/nasim/features/call/ui/startOutGoingCall/StartOutGoingCallPeerData;", "Landroid/os/Parcelable;", "", "peerUniqueId", "", "peerId", "", "isPrivatePeer", "<init>", "(JIZ)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "J", "b", "()J", TokenNames.I, "c", "Z", "()Z", "d", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class StartOutGoingCallPeerData implements Parcelable {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final long peerUniqueId;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final int peerId;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean isPrivatePeer;

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<StartOutGoingCallPeerData> CREATOR = new b();

    /* renamed from: ir.nasim.features.call.ui.startOutGoingCall.StartOutGoingCallPeerData$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final StartOutGoingCallPeerData a(C11458d25 c11458d25) {
            AbstractC13042fc3.i(c11458d25, "peer");
            return new StartOutGoingCallPeerData(c11458d25.u(), c11458d25.getPeerId(), c11458d25.C());
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StartOutGoingCallPeerData createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new StartOutGoingCallPeerData(parcel.readLong(), parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StartOutGoingCallPeerData[] newArray(int i) {
            return new StartOutGoingCallPeerData[i];
        }
    }

    public StartOutGoingCallPeerData(long j, int i, boolean z) {
        this.peerUniqueId = j;
        this.peerId = i;
        this.isPrivatePeer = z;
    }

    /* renamed from: a, reason: from getter */
    public final int getPeerId() {
        return this.peerId;
    }

    /* renamed from: b, reason: from getter */
    public final long getPeerUniqueId() {
        return this.peerUniqueId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsPrivatePeer() {
        return this.isPrivatePeer;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartOutGoingCallPeerData)) {
            return false;
        }
        StartOutGoingCallPeerData startOutGoingCallPeerData = (StartOutGoingCallPeerData) other;
        return this.peerUniqueId == startOutGoingCallPeerData.peerUniqueId && this.peerId == startOutGoingCallPeerData.peerId && this.isPrivatePeer == startOutGoingCallPeerData.isPrivatePeer;
    }

    public int hashCode() {
        return (((Long.hashCode(this.peerUniqueId) * 31) + Integer.hashCode(this.peerId)) * 31) + Boolean.hashCode(this.isPrivatePeer);
    }

    public String toString() {
        return "StartOutGoingCallPeerData(peerUniqueId=" + this.peerUniqueId + ", peerId=" + this.peerId + ", isPrivatePeer=" + this.isPrivatePeer + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.peerUniqueId);
        dest.writeInt(this.peerId);
        dest.writeInt(this.isPrivatePeer ? 1 : 0);
    }
}
