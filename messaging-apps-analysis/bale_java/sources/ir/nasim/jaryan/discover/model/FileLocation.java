package ir.nasim.jaryan.discover.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12056dy;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\u001a\u0010\u0010J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u0010¨\u0006'"}, d2 = {"Lir/nasim/jaryan/discover/model/FileLocation;", "Landroid/os/Parcelable;", "", "fileId", "accessHash", "", "storageVersion", "<init>", "(JJI)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "component3", "copy", "(JJI)Lir/nasim/jaryan/discover/model/FileLocation;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFileId", "getAccessHash", TokenNames.I, "getStorageVersion", "Companion", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class FileLocation implements Parcelable {
    public static final int $stable = 0;

    @InterfaceC23984xq6("accessHash")
    private final long accessHash;

    @InterfaceC23984xq6("fileId")
    private final long fileId;

    @InterfaceC23984xq6("storageVersion")
    private final int storageVersion;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FileLocation> CREATOR = new b();

    /* renamed from: ir.nasim.jaryan.discover.model.FileLocation$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C12056dy a(FileLocation fileLocation) {
            AbstractC13042fc3.i(fileLocation, "<this>");
            return new C12056dy(fileLocation.getFileId(), fileLocation.getAccessHash(), Integer.valueOf(fileLocation.getStorageVersion()));
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FileLocation createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new FileLocation(parcel.readLong(), parcel.readLong(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FileLocation[] newArray(int i) {
            return new FileLocation[i];
        }
    }

    public FileLocation(long j, long j2, int i) {
        this.fileId = j;
        this.accessHash = j2;
        this.storageVersion = i;
    }

    public static /* synthetic */ FileLocation copy$default(FileLocation fileLocation, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = fileLocation.fileId;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = fileLocation.accessHash;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = fileLocation.storageVersion;
        }
        return fileLocation.copy(j3, j4, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFileId() {
        return this.fileId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getAccessHash() {
        return this.accessHash;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStorageVersion() {
        return this.storageVersion;
    }

    public final FileLocation copy(long fileId, long accessHash, int storageVersion) {
        return new FileLocation(fileId, accessHash, storageVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileLocation)) {
            return false;
        }
        FileLocation fileLocation = (FileLocation) other;
        return this.fileId == fileLocation.fileId && this.accessHash == fileLocation.accessHash && this.storageVersion == fileLocation.storageVersion;
    }

    public final long getAccessHash() {
        return this.accessHash;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final int getStorageVersion() {
        return this.storageVersion;
    }

    public int hashCode() {
        return (((Long.hashCode(this.fileId) * 31) + Long.hashCode(this.accessHash)) * 31) + Integer.hashCode(this.storageVersion);
    }

    public String toString() {
        return "FileLocation(fileId=" + this.fileId + ", accessHash=" + this.accessHash + ", storageVersion=" + this.storageVersion + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.fileId);
        dest.writeLong(this.accessHash);
        dest.writeInt(this.storageVersion);
    }
}
