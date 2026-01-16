package ir.nasim.jaryan.discover.model;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J0\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0011¨\u0006&"}, d2 = {"Lir/nasim/jaryan/discover/model/BannerItem;", "Landroid/os/Parcelable;", "Lir/nasim/jaryan/discover/model/FileLocation;", "fileLocation", "", "action", "", "fileSize", "<init>", "(Lir/nasim/jaryan/discover/model/FileLocation;Ljava/lang/String;I)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lir/nasim/jaryan/discover/model/FileLocation;", "component2", "()Ljava/lang/String;", "component3", "copy", "(Lir/nasim/jaryan/discover/model/FileLocation;Ljava/lang/String;I)Lir/nasim/jaryan/discover/model/BannerItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/jaryan/discover/model/FileLocation;", "getFileLocation", "Ljava/lang/String;", "getAction", TokenNames.I, "getFileSize", "jaryan_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class BannerItem implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<BannerItem> CREATOR = new a();

    @InterfaceC23984xq6("action")
    private final String action;

    @InterfaceC23984xq6("fileLocation")
    private final FileLocation fileLocation;

    @InterfaceC23984xq6("fileSize")
    private final int fileSize;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BannerItem createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new BannerItem(parcel.readInt() == 0 ? null : FileLocation.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BannerItem[] newArray(int i) {
            return new BannerItem[i];
        }
    }

    public BannerItem(FileLocation fileLocation, String str, int i) {
        AbstractC13042fc3.i(str, "action");
        this.fileLocation = fileLocation;
        this.action = str;
        this.fileSize = i;
    }

    public static /* synthetic */ BannerItem copy$default(BannerItem bannerItem, FileLocation fileLocation, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fileLocation = bannerItem.fileLocation;
        }
        if ((i2 & 2) != 0) {
            str = bannerItem.action;
        }
        if ((i2 & 4) != 0) {
            i = bannerItem.fileSize;
        }
        return bannerItem.copy(fileLocation, str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final FileLocation getFileLocation() {
        return this.fileLocation;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFileSize() {
        return this.fileSize;
    }

    public final BannerItem copy(FileLocation fileLocation, String action, int fileSize) {
        AbstractC13042fc3.i(action, "action");
        return new BannerItem(fileLocation, action, fileSize);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerItem)) {
            return false;
        }
        BannerItem bannerItem = (BannerItem) other;
        return AbstractC13042fc3.d(this.fileLocation, bannerItem.fileLocation) && AbstractC13042fc3.d(this.action, bannerItem.action) && this.fileSize == bannerItem.fileSize;
    }

    public final String getAction() {
        return this.action;
    }

    public final FileLocation getFileLocation() {
        return this.fileLocation;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public int hashCode() {
        FileLocation fileLocation = this.fileLocation;
        return ((((fileLocation == null ? 0 : fileLocation.hashCode()) * 31) + this.action.hashCode()) * 31) + Integer.hashCode(this.fileSize);
    }

    public String toString() {
        return "BannerItem(fileLocation=" + this.fileLocation + ", action=" + this.action + ", fileSize=" + this.fileSize + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        FileLocation fileLocation = this.fileLocation;
        if (fileLocation == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            fileLocation.writeToParcel(dest, flags);
        }
        dest.writeString(this.action);
        dest.writeInt(this.fileSize);
    }
}
