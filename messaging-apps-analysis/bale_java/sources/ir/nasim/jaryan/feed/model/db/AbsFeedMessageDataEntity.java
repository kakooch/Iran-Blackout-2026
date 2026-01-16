package ir.nasim.jaryan.feed.model.db;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16111kj2;
import ir.nasim.ED1;
import ir.nasim.EnumC12502ej2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import livekit.org.webrtc.MediaStreamTrack;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity;", "Landroid/os/Parcelable;", "<init>", "()V", "", "a", "()I", "holderType", "TextMessage", "PhotoMessage", "GifMessage", "VideoMessage", "MediaMessage", "AlbumMessage", "AlbumItem", "UnknownMessage", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$AlbumMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$TextMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$UnknownMessage;", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public abstract class AbsFeedMessageDataEntity implements Parcelable {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0005¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity;", "Landroid/os/Parcelable;", "<init>", "()V", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$GifMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$PhotoMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$VideoMessage;", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static abstract class MediaMessage extends AbsFeedMessageDataEntity implements Parcelable {
        public /* synthetic */ MediaMessage(ED1 ed1) {
            this();
        }

        private MediaMessage() {
            super(null);
        }
    }

    private AbsFeedMessageDataEntity() {
    }

    /* renamed from: a */
    public abstract int getHolderType();

    public /* synthetic */ AbsFeedMessageDataEntity(ED1 ed1) {
        this();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001\u001cB)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\u0016\u0010\u0013J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010 \u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$AlbumMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity;", "", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$AlbumItem;", "albumItems", "", "holderType", "", "type", "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", TokenNames.I, "c", "Ljava/lang/String;", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class AlbumMessage extends AbsFeedMessageDataEntity {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int d = 8;

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final List albumItems;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int holderType;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String type;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$AlbumMessage$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final List d(Parcel parcel) {
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(parcel.readTypedObject(AlbumItem.INSTANCE));
                }
                return AbstractC15401jX0.n0(AbstractC15401jX0.m1(arrayList));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AlbumMessage createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new AlbumMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AlbumMessage[] newArray(int i) {
                return new AlbumMessage[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ AlbumMessage(List list, int i, String str, int i2, ED1 ed1) {
            this(list, (i2 & 2) != 0 ? EnumC12502ej2.f.j() : i, (i2 & 4) != 0 ? "album" : str);
        }

        @Override // ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity
        /* renamed from: a, reason: from getter */
        public int getHolderType() {
            return this.holderType;
        }

        /* renamed from: b, reason: from getter */
        public final List getAlbumItems() {
            return this.albumItems;
        }

        /* renamed from: c, reason: from getter */
        public String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlbumMessage)) {
                return false;
            }
            AlbumMessage albumMessage = (AlbumMessage) other;
            return AbstractC13042fc3.d(this.albumItems, albumMessage.albumItems) && this.holderType == albumMessage.holderType && AbstractC13042fc3.d(this.type, albumMessage.type);
        }

        public int hashCode() {
            return (((this.albumItems.hashCode() * 31) + Integer.hashCode(this.holderType)) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "AlbumMessage(albumItems=" + this.albumItems + ", holderType=" + this.holderType + ", type=" + this.type + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeTypedList(this.albumItems);
            parcel.writeInt(getHolderType());
            parcel.writeString(getType());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlbumMessage(List list, int i, String str) {
            super(null);
            AbstractC13042fc3.i(list, "albumItems");
            AbstractC13042fc3.i(str, "type");
            this.albumItems = list;
            this.holderType = i;
            this.type = str;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public AlbumMessage(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            List listD = INSTANCE.d(parcel);
            int i = parcel.readInt();
            String string = parcel.readString();
            AbstractC13042fc3.f(string);
            this(listD, i, string);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 62\u00020\u0001:\u0001\u001cBe\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010\u0006\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b$\u0010#\"\u0004\b%\u0010&R\"\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010(\u001a\u0004\b \u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u0010\f\u001a\u00020\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u00100\u001a\u0004\b,\u0010\u001b\"\u0004\b1\u00102R\u001a\u0010\r\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b3\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b4\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u0010!\u001a\u0004\b5\u0010#¨\u00067"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$GifMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "", "thumbnail", "", "caption", "fileName", "", "fileId", "accessHash", "", "fileStorageVersion", "fileSize", "height", "width", "holderType", "type", "<init>", "([BLjava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;IIIILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "[B", "i", "()[B", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "setFileName", "(Ljava/lang/String;)V", "d", "J", "()J", "setFileId", "(J)V", "f", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", TokenNames.I, "setFileSize", "(I)V", "h", "k", "j", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final class GifMessage extends MediaMessage {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int l = 8;

        /* renamed from: a, reason: from kotlin metadata */
        private final byte[] thumbnail;

        /* renamed from: b, reason: from kotlin metadata */
        private final String caption;

        /* renamed from: c, reason: from kotlin metadata */
        private String fileName;

        /* renamed from: d, reason: from kotlin metadata */
        private long fileId;

        /* renamed from: e, reason: from kotlin metadata */
        private final long accessHash;

        /* renamed from: f, reason: from kotlin metadata */
        private final Integer fileStorageVersion;

        /* renamed from: g, reason: from kotlin metadata */
        private int fileSize;

        /* renamed from: h, reason: from kotlin metadata */
        private final int height;

        /* renamed from: i, reason: from kotlin metadata */
        private final int width;

        /* renamed from: j, reason: from kotlin metadata */
        private final int holderType;

        /* renamed from: k, reason: from kotlin metadata */
        private final String type;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$GifMessage$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GifMessage createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new GifMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public GifMessage[] newArray(int i) {
                return new GifMessage[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ GifMessage(byte[] bArr, String str, String str2, long j, long j2, Integer num, int i, int i2, int i3, int i4, String str3, int i5, ED1 ed1) {
            this(bArr, str, str2, j, j2, num, i, i2, i3, (i5 & 512) != 0 ? EnumC12502ej2.g.j() : i4, (i5 & 1024) != 0 ? "gif" : str3);
        }

        @Override // ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity
        /* renamed from: a, reason: from getter */
        public int getHolderType() {
            return this.holderType;
        }

        /* renamed from: b, reason: from getter */
        public long getAccessHash() {
            return this.accessHash;
        }

        /* renamed from: c, reason: from getter */
        public String getCaption() {
            return this.caption;
        }

        /* renamed from: d, reason: from getter */
        public long getFileId() {
            return this.fileId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public String getFileName() {
            return this.fileName;
        }

        /* renamed from: f, reason: from getter */
        public int getFileSize() {
            return this.fileSize;
        }

        /* renamed from: g, reason: from getter */
        public Integer getFileStorageVersion() {
            return this.fileStorageVersion;
        }

        /* renamed from: h, reason: from getter */
        public int getHeight() {
            return this.height;
        }

        /* renamed from: i, reason: from getter */
        public byte[] getThumbnail() {
            return this.thumbnail;
        }

        /* renamed from: j, reason: from getter */
        public String getType() {
            return this.type;
        }

        /* renamed from: k, reason: from getter */
        public int getWidth() {
            return this.width;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeByteArray(getThumbnail());
            parcel.writeString(getCaption());
            parcel.writeString(getFileName());
            parcel.writeLong(getFileId());
            parcel.writeLong(getAccessHash());
            parcel.writeValue(getFileStorageVersion());
            parcel.writeInt(getFileSize());
            parcel.writeInt(getHeight());
            parcel.writeInt(getWidth());
            parcel.writeInt(getHolderType());
            parcel.writeString(getType());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifMessage(byte[] bArr, String str, String str2, long j, long j2, Integer num, int i, int i2, int i3, int i4, String str3) {
            super(null);
            AbstractC13042fc3.i(bArr, "thumbnail");
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(str2, "fileName");
            AbstractC13042fc3.i(str3, "type");
            this.thumbnail = bArr;
            this.caption = str;
            this.fileName = str2;
            this.fileId = j;
            this.accessHash = j2;
            this.fileStorageVersion = num;
            this.fileSize = i;
            this.height = i2;
            this.width = i3;
            this.holderType = i4;
            this.type = str3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public GifMessage(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            byte[] bArrCreateByteArray = parcel.createByteArray();
            AbstractC13042fc3.f(bArrCreateByteArray);
            String string = parcel.readString();
            AbstractC13042fc3.f(string);
            String string2 = parcel.readString();
            AbstractC13042fc3.f(string2);
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            Object value = parcel.readValue(Integer.TYPE.getClassLoader());
            Integer num = value instanceof Integer ? (Integer) value : null;
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            String string3 = parcel.readString();
            AbstractC13042fc3.f(string3);
            this(bArrCreateByteArray, string, string2, j, j2, num, i, i2, i3, i4, string3);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 62\u00020\u0001:\u0001\u001cBe\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010\u0006\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b$\u0010#\"\u0004\b%\u0010&R\"\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010(\u001a\u0004\b \u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u0010\f\u001a\u00020\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u00100\u001a\u0004\b,\u0010\u001b\"\u0004\b1\u00102R\u001a\u0010\r\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b3\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b4\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u0010!\u001a\u0004\b5\u0010#¨\u00067"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$PhotoMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "", "thumbnail", "", "caption", "fileName", "", "fileId", "accessHash", "", "fileStorageVersion", "fileSize", "height", "width", "holderType", "type", "<init>", "([BLjava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;IIIILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "[B", "i", "()[B", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "setFileName", "(Ljava/lang/String;)V", "d", "J", "()J", "setFileId", "(J)V", "f", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", TokenNames.I, "setFileSize", "(I)V", "h", "k", "j", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final class PhotoMessage extends MediaMessage {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int l = 8;

        /* renamed from: a, reason: from kotlin metadata */
        private final byte[] thumbnail;

        /* renamed from: b, reason: from kotlin metadata */
        private final String caption;

        /* renamed from: c, reason: from kotlin metadata */
        private String fileName;

        /* renamed from: d, reason: from kotlin metadata */
        private long fileId;

        /* renamed from: e, reason: from kotlin metadata */
        private final long accessHash;

        /* renamed from: f, reason: from kotlin metadata */
        private final Integer fileStorageVersion;

        /* renamed from: g, reason: from kotlin metadata */
        private int fileSize;

        /* renamed from: h, reason: from kotlin metadata */
        private final int height;

        /* renamed from: i, reason: from kotlin metadata */
        private final int width;

        /* renamed from: j, reason: from kotlin metadata */
        private final int holderType;

        /* renamed from: k, reason: from kotlin metadata */
        private final String type;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$PhotoMessage$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PhotoMessage createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new PhotoMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public PhotoMessage[] newArray(int i) {
                return new PhotoMessage[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ PhotoMessage(byte[] bArr, String str, String str2, long j, long j2, Integer num, int i, int i2, int i3, int i4, String str3, int i5, ED1 ed1) {
            this(bArr, str, str2, j, j2, num, i, i2, i3, (i5 & 512) != 0 ? EnumC12502ej2.d.j() : i4, (i5 & 1024) != 0 ? "photo" : str3);
        }

        @Override // ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity
        /* renamed from: a, reason: from getter */
        public int getHolderType() {
            return this.holderType;
        }

        /* renamed from: b, reason: from getter */
        public long getAccessHash() {
            return this.accessHash;
        }

        /* renamed from: c, reason: from getter */
        public String getCaption() {
            return this.caption;
        }

        /* renamed from: d, reason: from getter */
        public long getFileId() {
            return this.fileId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public String getFileName() {
            return this.fileName;
        }

        /* renamed from: f, reason: from getter */
        public int getFileSize() {
            return this.fileSize;
        }

        /* renamed from: g, reason: from getter */
        public Integer getFileStorageVersion() {
            return this.fileStorageVersion;
        }

        /* renamed from: h, reason: from getter */
        public int getHeight() {
            return this.height;
        }

        /* renamed from: i, reason: from getter */
        public byte[] getThumbnail() {
            return this.thumbnail;
        }

        /* renamed from: j, reason: from getter */
        public String getType() {
            return this.type;
        }

        /* renamed from: k, reason: from getter */
        public int getWidth() {
            return this.width;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeByteArray(getThumbnail());
            parcel.writeString(getCaption());
            parcel.writeString(getFileName());
            parcel.writeLong(getFileId());
            parcel.writeLong(getAccessHash());
            parcel.writeValue(getFileStorageVersion());
            parcel.writeInt(getFileSize());
            parcel.writeInt(getHeight());
            parcel.writeInt(getWidth());
            parcel.writeInt(getHolderType());
            parcel.writeString(getType());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhotoMessage(byte[] bArr, String str, String str2, long j, long j2, Integer num, int i, int i2, int i3, int i4, String str3) {
            super(null);
            AbstractC13042fc3.i(bArr, "thumbnail");
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(str2, "fileName");
            AbstractC13042fc3.i(str3, "type");
            this.thumbnail = bArr;
            this.caption = str;
            this.fileName = str2;
            this.fileId = j;
            this.accessHash = j2;
            this.fileStorageVersion = num;
            this.fileSize = i;
            this.height = i2;
            this.width = i3;
            this.holderType = i4;
            this.type = str3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public PhotoMessage(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            byte[] bArrCreateByteArray = parcel.createByteArray();
            AbstractC13042fc3.f(bArrCreateByteArray);
            String string = parcel.readString();
            AbstractC13042fc3.f(string);
            String string2 = parcel.readString();
            AbstractC13042fc3.f(string2);
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            Object value = parcel.readValue(Integer.TYPE.getClassLoader());
            Integer num = value instanceof Integer ? (Integer) value : null;
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            String string3 = parcel.readString();
            AbstractC13042fc3.f(string3);
            this(bArrCreateByteArray, string, string2, j, j2, num, i, i2, i3, i4, string3);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001\u001cB1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\u0016\u0010\u0013J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u001a\u0010\u0007\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\"\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b#\u0010\u0015¨\u0006%"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$TextMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity;", "", ParameterNames.TEXT, "", "", "mentions", "holderType", "type", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "Ljava/util/List;", "()Ljava/util/List;", TokenNames.I, "d", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class TextMessage extends AbsFeedMessageDataEntity {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int e = 8;

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final List mentions;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final int holderType;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final String type;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$TextMessage$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TextMessage createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new TextMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TextMessage[] newArray(int i) {
                return new TextMessage[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ TextMessage(String str, List list, int i, String str2, int i2, ED1 ed1) {
            this(str, list, (i2 & 4) != 0 ? EnumC12502ej2.c.j() : i, (i2 & 8) != 0 ? ParameterNames.TEXT : str2);
        }

        @Override // ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity
        /* renamed from: a, reason: from getter */
        public int getHolderType() {
            return this.holderType;
        }

        /* renamed from: b, reason: from getter */
        public final List getMentions() {
            return this.mentions;
        }

        /* renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: d, reason: from getter */
        public String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextMessage)) {
                return false;
            }
            TextMessage textMessage = (TextMessage) other;
            return AbstractC13042fc3.d(this.text, textMessage.text) && AbstractC13042fc3.d(this.mentions, textMessage.mentions) && this.holderType == textMessage.holderType && AbstractC13042fc3.d(this.type, textMessage.type);
        }

        public int hashCode() {
            return (((((this.text.hashCode() * 31) + this.mentions.hashCode()) * 31) + Integer.hashCode(this.holderType)) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "TextMessage(text=" + this.text + ", mentions=" + this.mentions + ", holderType=" + this.holderType + ", type=" + this.type + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeString(this.text);
            AbstractC16111kj2.b(parcel, this.mentions);
            parcel.writeInt(getHolderType());
            parcel.writeString(getType());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextMessage(String str, List list, int i, String str2) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(list, "mentions");
            AbstractC13042fc3.i(str2, "type");
            this.text = str;
            this.mentions = list;
            this.holderType = i;
            this.type = str2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public TextMessage(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            String string = parcel.readString();
            AbstractC13042fc3.f(string);
            List listA = AbstractC16111kj2.a(parcel);
            int i = parcel.readInt();
            String string2 = parcel.readString();
            AbstractC13042fc3.f(string2);
            this(string, listA, i, string2);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\u0010J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H×\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$UnknownMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity;", "", "holderType", "", "type", "<init>", "(ILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", TokenNames.I, "b", "Ljava/lang/String;", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class UnknownMessage extends AbsFeedMessageDataEntity {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int holderType;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final String type;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$UnknownMessage$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnknownMessage createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new UnknownMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public UnknownMessage[] newArray(int i) {
                return new UnknownMessage[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ UnknownMessage(int i, String str, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? EnumC12502ej2.b.j() : i, (i2 & 2) != 0 ? "unsupported" : str);
        }

        @Override // ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity
        /* renamed from: a, reason: from getter */
        public int getHolderType() {
            return this.holderType;
        }

        /* renamed from: b, reason: from getter */
        public String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownMessage)) {
                return false;
            }
            UnknownMessage unknownMessage = (UnknownMessage) other;
            return this.holderType == unknownMessage.holderType && AbstractC13042fc3.d(this.type, unknownMessage.type);
        }

        public int hashCode() {
            return (Integer.hashCode(this.holderType) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "UnknownMessage(holderType=" + this.holderType + ", type=" + this.type + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeInt(getHolderType());
            parcel.writeString(getType());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownMessage(int i, String str) {
            super(null);
            AbstractC13042fc3.i(str, "type");
            this.holderType = i;
            this.type = str;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public UnknownMessage(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            AbstractC13042fc3.f(string);
            this(i, string);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001\u001eBw\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010\u0006\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010#\u001a\u0004\b&\u0010%\"\u0004\b'\u0010(R\"\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010*\u001a\u0004\b\"\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b2\u0010#\u001a\u0004\b3\u0010%R\"\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00104\u001a\u0004\b2\u0010\u001d\"\u0004\b5\u00106R\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b7\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b8\u0010\u001dR\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b)\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u0010#\u001a\u0004\b9\u0010%¨\u0006;"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$VideoMessage;", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "", "thumbnail", "", "caption", "fileName", "", "fileId", "accessHash", "", "fileStorageVersion", "mimeType", "fileSize", "height", "width", "duration", "holderType", "type", "<init>", "([BLjava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;Ljava/lang/String;IIIIILjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "[B", "k", "()[B", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "setFileName", "(Ljava/lang/String;)V", "d", "J", "e", "()J", "setFileId", "(J)V", "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", "g", "j", TokenNames.I, "setFileSize", "(I)V", "i", "m", "l", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final class VideoMessage extends MediaMessage {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int n = 8;

        /* renamed from: a, reason: from kotlin metadata */
        private final byte[] thumbnail;

        /* renamed from: b, reason: from kotlin metadata */
        private final String caption;

        /* renamed from: c, reason: from kotlin metadata */
        private String fileName;

        /* renamed from: d, reason: from kotlin metadata */
        private long fileId;

        /* renamed from: e, reason: from kotlin metadata */
        private final long accessHash;

        /* renamed from: f, reason: from kotlin metadata */
        private final Integer fileStorageVersion;

        /* renamed from: g, reason: from kotlin metadata */
        private final String mimeType;

        /* renamed from: h, reason: from kotlin metadata */
        private int fileSize;

        /* renamed from: i, reason: from kotlin metadata */
        private final int height;

        /* renamed from: j, reason: from kotlin metadata */
        private final int width;

        /* renamed from: k, reason: from kotlin metadata */
        private final int duration;

        /* renamed from: l, reason: from kotlin metadata */
        private final int holderType;

        /* renamed from: m, reason: from kotlin metadata */
        private final String type;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$VideoMessage$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public VideoMessage createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new VideoMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public VideoMessage[] newArray(int i) {
                return new VideoMessage[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ VideoMessage(byte[] bArr, String str, String str2, long j, long j2, Integer num, String str3, int i, int i2, int i3, int i4, int i5, String str4, int i6, ED1 ed1) {
            this(bArr, str, str2, j, j2, num, str3, i, i2, i3, i4, (i6 & 2048) != 0 ? EnumC12502ej2.e.j() : i5, (i6 & 4096) != 0 ? MediaStreamTrack.VIDEO_TRACK_KIND : str4);
        }

        @Override // ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity
        /* renamed from: a, reason: from getter */
        public int getHolderType() {
            return this.holderType;
        }

        /* renamed from: b, reason: from getter */
        public long getAccessHash() {
            return this.accessHash;
        }

        /* renamed from: c, reason: from getter */
        public String getCaption() {
            return this.caption;
        }

        /* renamed from: d, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public long getFileId() {
            return this.fileId;
        }

        /* renamed from: f, reason: from getter */
        public String getFileName() {
            return this.fileName;
        }

        /* renamed from: g, reason: from getter */
        public int getFileSize() {
            return this.fileSize;
        }

        /* renamed from: h, reason: from getter */
        public Integer getFileStorageVersion() {
            return this.fileStorageVersion;
        }

        /* renamed from: i, reason: from getter */
        public int getHeight() {
            return this.height;
        }

        /* renamed from: j, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: k, reason: from getter */
        public byte[] getThumbnail() {
            return this.thumbnail;
        }

        /* renamed from: l, reason: from getter */
        public String getType() {
            return this.type;
        }

        /* renamed from: m, reason: from getter */
        public int getWidth() {
            return this.width;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeByteArray(getThumbnail());
            parcel.writeString(getCaption());
            parcel.writeString(getFileName());
            parcel.writeLong(getFileId());
            parcel.writeLong(getAccessHash());
            parcel.writeValue(getFileStorageVersion());
            parcel.writeString(this.mimeType);
            parcel.writeInt(getFileSize());
            parcel.writeInt(getHeight());
            parcel.writeInt(getWidth());
            parcel.writeInt(this.duration);
            parcel.writeInt(getHolderType());
            parcel.writeString(getType());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoMessage(byte[] bArr, String str, String str2, long j, long j2, Integer num, String str3, int i, int i2, int i3, int i4, int i5, String str4) {
            super(null);
            AbstractC13042fc3.i(bArr, "thumbnail");
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(str2, "fileName");
            AbstractC13042fc3.i(str4, "type");
            this.thumbnail = bArr;
            this.caption = str;
            this.fileName = str2;
            this.fileId = j;
            this.accessHash = j2;
            this.fileStorageVersion = num;
            this.mimeType = str3;
            this.fileSize = i;
            this.height = i2;
            this.width = i3;
            this.duration = i4;
            this.holderType = i5;
            this.type = str4;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public VideoMessage(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            byte[] bArrCreateByteArray = parcel.createByteArray();
            AbstractC13042fc3.f(bArrCreateByteArray);
            String string = parcel.readString();
            AbstractC13042fc3.f(string);
            String string2 = parcel.readString();
            AbstractC13042fc3.f(string2);
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            Object value = parcel.readValue(Integer.TYPE.getClassLoader());
            Integer num = value instanceof Integer ? (Integer) value : null;
            String string3 = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            int i5 = parcel.readInt();
            String string4 = parcel.readString();
            AbstractC13042fc3.f(string4);
            this(bArrCreateByteArray, string, string2, j, j2, num, string3, i, i2, i3, i4, i5, string4);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0016\u0010\u0012J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001c\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"¨\u0006$"}, d2 = {"Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$AlbumItem;", "Landroid/os/Parcelable;", "", "itemRid", "itemDate", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "mediaMessage", "<init>", "(JJLir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "b", "()J", "c", "Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "()Lir/nasim/jaryan/feed/model/db/AbsFeedMessageDataEntity$MediaMessage;", "CREATOR", "jaryan_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class AlbumItem implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final long itemRid;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final long itemDate;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final MediaMessage mediaMessage;

        /* renamed from: ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity$AlbumItem$a, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AlbumItem createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new AlbumItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AlbumItem[] newArray(int i) {
                return new AlbumItem[i];
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public AlbumItem(long j, long j2, MediaMessage mediaMessage) {
            AbstractC13042fc3.i(mediaMessage, "mediaMessage");
            this.itemRid = j;
            this.itemDate = j2;
            this.mediaMessage = mediaMessage;
        }

        /* renamed from: a, reason: from getter */
        public final long getItemDate() {
            return this.itemDate;
        }

        /* renamed from: b, reason: from getter */
        public final long getItemRid() {
            return this.itemRid;
        }

        /* renamed from: c, reason: from getter */
        public final MediaMessage getMediaMessage() {
            return this.mediaMessage;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlbumItem)) {
                return false;
            }
            AlbumItem albumItem = (AlbumItem) other;
            return this.itemRid == albumItem.itemRid && this.itemDate == albumItem.itemDate && AbstractC13042fc3.d(this.mediaMessage, albumItem.mediaMessage);
        }

        public int hashCode() {
            return (((Long.hashCode(this.itemRid) * 31) + Long.hashCode(this.itemDate)) * 31) + this.mediaMessage.hashCode();
        }

        public String toString() {
            return "AlbumItem(itemRid=" + this.itemRid + ", itemDate=" + this.itemDate + ", mediaMessage=" + this.mediaMessage + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC13042fc3.i(parcel, "parcel");
            parcel.writeLong(this.itemRid);
            parcel.writeLong(this.itemDate);
            parcel.writeParcelable(this.mediaMessage, flags);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public AlbumItem(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            Parcelable parcelable = parcel.readParcelable(MediaMessage.class.getClassLoader());
            AbstractC13042fc3.f(parcelable);
            this(j, j2, (MediaMessage) parcelable);
        }
    }
}
