package ir.nasim.features.share;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001e\u0010\u0014R!\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001b\u0010\u0014¨\u0006\""}, d2 = {"Lir/nasim/features/share/ShareData;", "Landroid/os/Parcelable;", "", "sendText", "sendUriString", "", "sendUriMultiple", "sendMimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "d", "c", "Ljava/util/List;", "()Ljava/util/List;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class ShareData implements Parcelable {
    public static final Parcelable.Creator<ShareData> CREATOR = new a();
    public static final int e = 8;

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String sendText;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String sendUriString;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final List sendUriMultiple;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final String sendMimeType;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ShareData createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new ShareData(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ShareData[] newArray(int i) {
            return new ShareData[i];
        }
    }

    public ShareData(String str, String str2, List list, String str3) {
        this.sendText = str;
        this.sendUriString = str2;
        this.sendUriMultiple = list;
        this.sendMimeType = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getSendMimeType() {
        return this.sendMimeType;
    }

    /* renamed from: b, reason: from getter */
    public final String getSendText() {
        return this.sendText;
    }

    /* renamed from: c, reason: from getter */
    public final List getSendUriMultiple() {
        return this.sendUriMultiple;
    }

    /* renamed from: d, reason: from getter */
    public final String getSendUriString() {
        return this.sendUriString;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareData)) {
            return false;
        }
        ShareData shareData = (ShareData) other;
        return AbstractC13042fc3.d(this.sendText, shareData.sendText) && AbstractC13042fc3.d(this.sendUriString, shareData.sendUriString) && AbstractC13042fc3.d(this.sendUriMultiple, shareData.sendUriMultiple) && AbstractC13042fc3.d(this.sendMimeType, shareData.sendMimeType);
    }

    public int hashCode() {
        String str = this.sendText;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sendUriString;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.sendUriMultiple;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.sendMimeType;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ShareData(sendText=" + this.sendText + ", sendUriString=" + this.sendUriString + ", sendUriMultiple=" + this.sendUriMultiple + ", sendMimeType=" + this.sendMimeType + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.sendText);
        dest.writeString(this.sendUriString);
        dest.writeStringList(this.sendUriMultiple);
        dest.writeString(this.sendMimeType);
    }
}
