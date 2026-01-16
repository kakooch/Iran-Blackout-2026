package ir.nasim.core.modules.market.model;

import ai.bale.proto.MarketStruct$Product;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.gson.JsonParseException;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12056dy;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001<BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b \u0010\u001aJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010$J\\\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÇ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b(\u0010\u001fJ\u0010\u0010)\u001a\u00020\u0007H×\u0001¢\u0006\u0004\b)\u0010\u001aJ\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010*H×\u0003¢\u0006\u0004\b-\u0010.R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b1\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b3\u0010\u001fR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b5\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b7\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u00108\u001a\u0004\b9\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00108\u001a\u0004\b:\u0010$¨\u0006="}, d2 = {"Lir/nasim/core/modules/market/model/MarketPost;", "Landroid/os/Parcelable;", "", "fileId", "accessHash", "", "fileName", "", "fileSize", "groupId", "rId", DialogEntity.COLUMN_SORT_DATE, "<init>", "(JJLjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "Lir/nasim/core/modules/file/entity/FileReference;", "fileReference", "()Lir/nasim/core/modules/file/entity/FileReference;", "Lir/nasim/rB7;", "validate", "()V", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "component3", "()Ljava/lang/String;", "component4", "component5", "()Ljava/lang/Integer;", "component6", "()Ljava/lang/Long;", "component7", "copy", "(JJLjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lir/nasim/core/modules/market/model/MarketPost;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFileId", "getAccessHash", "Ljava/lang/String;", "getFileName", TokenNames.I, "getFileSize", "Ljava/lang/Integer;", "getGroupId", "Ljava/lang/Long;", "getRId", "getSortDate", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketPost implements Parcelable {
    public static final int $stable = 0;

    @InterfaceC23984xq6("accessHash")
    private final long accessHash;

    @InterfaceC23984xq6("fileId")
    private final long fileId;

    @InterfaceC23984xq6("fileName")
    private final String fileName;

    @InterfaceC23984xq6("fileSize")
    private final int fileSize;

    @InterfaceC23984xq6("groupId")
    private final Integer groupId;

    @InterfaceC23984xq6("rId")
    private final Long rId;

    @InterfaceC23984xq6(DialogEntity.COLUMN_SORT_DATE)
    private final Long sortDate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MarketPost> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketPost$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final MarketPost a(MarketStruct$Product marketStruct$Product) {
            AbstractC13042fc3.i(marketStruct$Product, "response");
            long fileId = marketStruct$Product.getProductImageLocation().getFileLocation().getFileId();
            long accessHash = marketStruct$Product.getProductImageLocation().getFileLocation().getAccessHash();
            String productImageName = marketStruct$Product.getProductImageName();
            AbstractC13042fc3.h(productImageName, "getProductImageName(...)");
            return new MarketPost(fileId, accessHash, productImageName, marketStruct$Product.getProductImageLocation().getFileSize(), Integer.valueOf(marketStruct$Product.getProductMessage().getPeer().getId()), Long.valueOf(marketStruct$Product.getProductMessage().getRandomId()), Long.valueOf(marketStruct$Product.getProductMessage().getDate()));
        }

        public final ArrayList b(List list) {
            AbstractC13042fc3.i(list, "response");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(MarketPost.INSTANCE.a((MarketStruct$Product) it.next()));
            }
            return arrayList;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketPost createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketPost(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketPost[] newArray(int i) {
            return new MarketPost[i];
        }
    }

    public MarketPost(long j, long j2, String str, int i, Integer num, Long l, Long l2) {
        AbstractC13042fc3.i(str, "fileName");
        this.fileId = j;
        this.accessHash = j2;
        this.fileName = str;
        this.fileSize = i;
        this.groupId = num;
        this.rId = l;
        this.sortDate = l2;
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
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getGroupId() {
        return this.groupId;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getRId() {
        return this.rId;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getSortDate() {
        return this.sortDate;
    }

    public final MarketPost copy(long fileId, long accessHash, String fileName, int fileSize, Integer groupId, Long rId, Long sortDate) {
        AbstractC13042fc3.i(fileName, "fileName");
        return new MarketPost(fileId, accessHash, fileName, fileSize, groupId, rId, sortDate);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketPost)) {
            return false;
        }
        MarketPost marketPost = (MarketPost) other;
        return this.fileId == marketPost.fileId && this.accessHash == marketPost.accessHash && AbstractC13042fc3.d(this.fileName, marketPost.fileName) && this.fileSize == marketPost.fileSize && AbstractC13042fc3.d(this.groupId, marketPost.groupId) && AbstractC13042fc3.d(this.rId, marketPost.rId) && AbstractC13042fc3.d(this.sortDate, marketPost.sortDate);
    }

    public final FileReference fileReference() {
        return new FileReference(new C12056dy(this.fileId, this.accessHash, 1), this.fileName, "", this.fileSize);
    }

    public final long getAccessHash() {
        return this.accessHash;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final Integer getGroupId() {
        return this.groupId;
    }

    public final Long getRId() {
        return this.rId;
    }

    public final Long getSortDate() {
        return this.sortDate;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.fileId) * 31) + Long.hashCode(this.accessHash)) * 31) + this.fileName.hashCode()) * 31) + Integer.hashCode(this.fileSize)) * 31;
        Integer num = this.groupId;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.rId;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.sortDate;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "MarketPost(fileId=" + this.fileId + ", accessHash=" + this.accessHash + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", groupId=" + this.groupId + ", rId=" + this.rId + ", sortDate=" + this.sortDate + Separators.RPAREN;
    }

    public final void validate() {
        if (this.fileName == null) {
            throw new JsonParseException("'fileName' is null!");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.fileId);
        dest.writeLong(this.accessHash);
        dest.writeString(this.fileName);
        dest.writeInt(this.fileSize);
        Integer num = this.groupId;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l = this.rId;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Long l2 = this.sortDate;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
    }

    public /* synthetic */ MarketPost(long j, long j2, String str, int i, Integer num, Long l, Long l2, int i2, ED1 ed1) {
        this(j, j2, str, i, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : l, (i2 & 64) != 0 ? null : l2);
    }
}
