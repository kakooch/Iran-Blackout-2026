package ir.nasim.features.onboarding.data.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH×\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010\u0018R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b \u0010'\u001a\u0004\b\u001e\u0010(R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b#\u0010)\u001a\u0004\b!\u0010*R\u0019\u0010\f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-¨\u0006."}, d2 = {"Lir/nasim/features/onboarding/data/model/PeerData;", "Landroid/os/Parcelable;", "", "peerId", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "peerType", "", "name", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatar", "", DialogEntity.COLUMN_HAS_BLUE_TICK, "isJoined", "<init>", "(ILir/nasim/core/modules/profile/entity/ExPeerType;Ljava/lang/String;Lir/nasim/core/modules/profile/entity/Avatar;ZLjava/lang/Boolean;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", TokenNames.I, "d", "b", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "e", "()Lir/nasim/core/modules/profile/entity/ExPeerType;", "c", "Ljava/lang/String;", "Lir/nasim/core/modules/profile/entity/Avatar;", "()Lir/nasim/core/modules/profile/entity/Avatar;", "Z", "()Z", "f", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class PeerData implements Parcelable {
    public static final Parcelable.Creator<PeerData> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final int peerId;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final ExPeerType peerType;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String name;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final Avatar avatar;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final boolean hasBlueTick;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final Boolean isJoined;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PeerData createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            ExPeerType exPeerTypeValueOf = parcel.readInt() == 0 ? null : ExPeerType.valueOf(parcel.readString());
            String string = parcel.readString();
            Avatar avatar = (Avatar) parcel.readSerializable();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PeerData(i, exPeerTypeValueOf, string, avatar, z, boolValueOf);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PeerData[] newArray(int i) {
            return new PeerData[i];
        }
    }

    public PeerData(int i, ExPeerType exPeerType, String str, Avatar avatar, boolean z, Boolean bool) {
        AbstractC13042fc3.i(str, "name");
        this.peerId = i;
        this.peerType = exPeerType;
        this.name = str;
        this.avatar = avatar;
        this.hasBlueTick = z;
        this.isJoined = bool;
    }

    /* renamed from: a, reason: from getter */
    public final Avatar getAvatar() {
        return this.avatar;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasBlueTick() {
        return this.hasBlueTick;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final int getPeerId() {
        return this.peerId;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final ExPeerType getPeerType() {
        return this.peerType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeerData)) {
            return false;
        }
        PeerData peerData = (PeerData) other;
        return this.peerId == peerData.peerId && this.peerType == peerData.peerType && AbstractC13042fc3.d(this.name, peerData.name) && AbstractC13042fc3.d(this.avatar, peerData.avatar) && this.hasBlueTick == peerData.hasBlueTick && AbstractC13042fc3.d(this.isJoined, peerData.isJoined);
    }

    /* renamed from: f, reason: from getter */
    public final Boolean getIsJoined() {
        return this.isJoined;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.peerId) * 31;
        ExPeerType exPeerType = this.peerType;
        int iHashCode2 = (((iHashCode + (exPeerType == null ? 0 : exPeerType.hashCode())) * 31) + this.name.hashCode()) * 31;
        Avatar avatar = this.avatar;
        int iHashCode3 = (((iHashCode2 + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.hasBlueTick)) * 31;
        Boolean bool = this.isJoined;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "PeerData(peerId=" + this.peerId + ", peerType=" + this.peerType + ", name=" + this.name + ", avatar=" + this.avatar + ", hasBlueTick=" + this.hasBlueTick + ", isJoined=" + this.isJoined + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.peerId);
        ExPeerType exPeerType = this.peerType;
        if (exPeerType == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(exPeerType.name());
        }
        dest.writeString(this.name);
        dest.writeSerializable(this.avatar);
        dest.writeInt(this.hasBlueTick ? 1 : 0);
        Boolean bool = this.isJoined;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public /* synthetic */ PeerData(int i, ExPeerType exPeerType, String str, Avatar avatar, boolean z, Boolean bool, int i2, ED1 ed1) {
        this(i, exPeerType, str, avatar, z, (i2 & 32) != 0 ? null : bool);
    }
}
