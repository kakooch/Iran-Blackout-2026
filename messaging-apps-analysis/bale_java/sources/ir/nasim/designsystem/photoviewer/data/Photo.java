package ir.nasim.designsystem.photoviewer.data;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b$\u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010!R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b%\u0010#\"\u0004\b*\u0010+R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010#R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010#\"\u0004\b0\u0010+R$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010)\u001a\u0004\b2\u0010#\"\u0004\b3\u0010+R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010)\u001a\u0004\b(\u0010#R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b,\u0010#R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010;\u001a\u0004\b<\u0010=R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00105\u001a\u0004\b:\u00107\"\u0004\b>\u00109R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010?\u001a\u0004\b4\u0010A\"\u0004\bD\u0010CR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR(\u0010M\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b@\u0010E\u0012\u0004\bK\u0010L\u001a\u0004\b.\u0010G\"\u0004\bJ\u0010IR(\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\bF\u0010&\u0012\u0004\bP\u0010L\u001a\u0004\b1\u0010!\"\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lir/nasim/designsystem/photoviewer/data/Photo;", "Landroid/os/Parcelable;", "", "userId", "", "avatar", "senderName", "photoUri", "photoPath", "", "placeHolder", "caption", "date", "", "timeStamp", DialogEntity.COLUMN_MESSAGE, "width", "height", "", "isGif", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;Ljava/lang/Integer;Z)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "a", TokenNames.I, "m", "b", "Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "c", "k", "d", "i", "t", "e", "h", "s", "f", "[B", "j", "()[B", "u", "([B)V", "g", "J", "l", "()J", "setMessage", "Ljava/lang/Integer;", "n", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "setHeight", "Z", "o", "()Z", "setGif", "(Z)V", "q", "getDownloadingNow$annotations", "()V", "downloadingNow", "r", "(I)V", "getDownloadingProgress$annotations", "downloadingProgress", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("userId")
    private final int userId;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("avatar")
    private String avatar;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("senderName")
    private final String senderName;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("photoUri")
    private String photoUri;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("photoPath")
    private String photoPath;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("placeHolder")
    private byte[] placeHolder;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("caption")
    private final String caption;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("date")
    private final String date;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("timeStamp")
    private final long timeStamp;

    /* renamed from: j, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6(DialogEntity.COLUMN_MESSAGE)
    private byte[] message;

    /* renamed from: k, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("width")
    private Integer width;

    /* renamed from: l, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("height")
    private Integer height;

    /* renamed from: m, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("isGif")
    private boolean isGif;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean downloadingNow;

    /* renamed from: o, reason: from kotlin metadata */
    private int downloadingProgress;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Photo createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new Photo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.createByteArray(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Photo[] newArray(int i) {
            return new Photo[i];
        }
    }

    public Photo(int i, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6, long j, byte[] bArr2, Integer num, Integer num2, boolean z) {
        AbstractC13042fc3.i(str2, "senderName");
        AbstractC13042fc3.i(str6, "date");
        this.userId = i;
        this.avatar = str;
        this.senderName = str2;
        this.photoUri = str3;
        this.photoPath = str4;
        this.placeHolder = bArr;
        this.caption = str5;
        this.date = str6;
        this.timeStamp = j;
        this.message = bArr2;
        this.width = num;
        this.height = num2;
        this.isGif = z;
    }

    /* renamed from: a, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: b, reason: from getter */
    public final String getCaption() {
        return this.caption;
    }

    /* renamed from: c, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getDownloadingNow() {
        return this.downloadingNow;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getDownloadingProgress() {
        return this.downloadingProgress;
    }

    public boolean equals(Object other) {
        return (other instanceof Photo) && ((Photo) other).timeStamp == this.timeStamp;
    }

    /* renamed from: f, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* renamed from: g, reason: from getter */
    public final byte[] getMessage() {
        return this.message;
    }

    /* renamed from: h, reason: from getter */
    public final String getPhotoPath() {
        return this.photoPath;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.userId) * 31;
        String str = this.avatar;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.senderName.hashCode()) * 31;
        String str2 = this.photoUri;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.photoPath;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        byte[] bArr = this.placeHolder;
        int iHashCode5 = (iHashCode4 + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
        String str4 = this.caption;
        int iHashCode6 = (((((iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.date.hashCode()) * 31) + Long.hashCode(this.timeStamp)) * 31;
        byte[] bArr2 = this.message;
        int iHashCode7 = (iHashCode6 + (bArr2 == null ? 0 : Arrays.hashCode(bArr2))) * 31;
        Integer num = this.width;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        return ((iHashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isGif);
    }

    /* renamed from: i, reason: from getter */
    public final String getPhotoUri() {
        return this.photoUri;
    }

    /* renamed from: j, reason: from getter */
    public final byte[] getPlaceHolder() {
        return this.placeHolder;
    }

    /* renamed from: k, reason: from getter */
    public final String getSenderName() {
        return this.senderName;
    }

    /* renamed from: l, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: m, reason: from getter */
    public final int getUserId() {
        return this.userId;
    }

    /* renamed from: n, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsGif() {
        return this.isGif;
    }

    public final void p(String str) {
        this.avatar = str;
    }

    public final void q(boolean z) {
        this.downloadingNow = z;
    }

    public final void r(int i) {
        this.downloadingProgress = i;
    }

    public final void s(String str) {
        this.photoPath = str;
    }

    public final void t(String str) {
        this.photoUri = str;
    }

    public String toString() {
        return "Photo(userId=" + this.userId + ", avatar=" + this.avatar + ", senderName=" + this.senderName + ", photoUri=" + this.photoUri + ", photoPath=" + this.photoPath + ", placeHolder=" + Arrays.toString(this.placeHolder) + ", caption=" + this.caption + ", date=" + this.date + ", timeStamp=" + this.timeStamp + ", message=" + Arrays.toString(this.message) + ", width=" + this.width + ", height=" + this.height + ", isGif=" + this.isGif + Separators.RPAREN;
    }

    public final void u(byte[] bArr) {
        this.placeHolder = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.userId);
        dest.writeString(this.avatar);
        dest.writeString(this.senderName);
        dest.writeString(this.photoUri);
        dest.writeString(this.photoPath);
        dest.writeByteArray(this.placeHolder);
        dest.writeString(this.caption);
        dest.writeString(this.date);
        dest.writeLong(this.timeStamp);
        dest.writeByteArray(this.message);
        Integer num = this.width;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.height;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeInt(this.isGif ? 1 : 0);
    }

    public /* synthetic */ Photo(int i, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6, long j, byte[] bArr2, Integer num, Integer num2, boolean z, int i2, ED1 ed1) {
        this(i, str, str2, str3, str4, bArr, str5, str6, j, bArr2, (i2 & 1024) != 0 ? null : num, (i2 & 2048) != 0 ? null : num2, (i2 & 4096) != 0 ? false : z);
    }
}
