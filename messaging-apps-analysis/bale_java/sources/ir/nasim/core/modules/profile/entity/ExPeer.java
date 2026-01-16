package ir.nasim.core.modules.profile.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC16720ll0;
import ir.nasim.AbstractC17902nl0;
import ir.nasim.C19084pl0;
import ir.nasim.C19675ql0;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.database.dailogLists.DialogEntity;

@Keep
@KeepName
/* loaded from: classes5.dex */
public class ExPeer extends AbstractC17902nl0 implements Parcelable {
    public static final Parcelable.Creator<ExPeer> CREATOR = new a();

    @InterfaceC23984xq6(DialogEntity.COLUMN_EX_PEER_TYPE)
    private ExPeerType exPeerType;

    @InterfaceC23984xq6("peerId")
    private int peerId;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExPeer createFromParcel(Parcel parcel) {
            return new ExPeer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExPeer[] newArray(int i) {
            return new ExPeer[i];
        }
    }

    protected ExPeer(Parcel parcel) {
        this.peerId = parcel.readInt();
    }

    public static ExPeer fromBytes(byte[] bArr) {
        return (ExPeer) AbstractC16720ll0.b(new ExPeer(), bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExPeer exPeer = (ExPeer) obj;
        return this.peerId == exPeer.peerId && this.exPeerType == exPeer.exPeerType;
    }

    public ExPeerType getExPeerType() {
        return this.exPeerType;
    }

    public int getPeerId() {
        return this.peerId;
    }

    public int hashCode() {
        return (this.exPeerType.hashCode() * 31) + this.peerId;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.exPeerType = ExPeerType.fromValue(iH);
        }
        this.peerId = c19084pl0.g(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        ExPeerType exPeerType = this.exPeerType;
        if (exPeerType != null) {
            c19675ql0.f(1, exPeerType.getValue());
        }
        c19675ql0.f(2, this.peerId);
    }

    public String toString() {
        return "ExPeerType{exType:" + this.exPeerType + ", id:" + this.peerId + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ExPeerType exPeerType = this.exPeerType;
        if (exPeerType != null) {
            parcel.writeInt(exPeerType.getValue());
        }
        parcel.writeInt(this.peerId);
    }

    public ExPeer(ExPeerType exPeerType, int i) {
        this.exPeerType = exPeerType;
        this.peerId = i;
    }

    public ExPeer() {
    }
}
