package ir.nasim.core.modules.banking.entity;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C5721Ko;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001:\u0005/0123B9\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0014JH\u0010\u001b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006HÇ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH×\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006H×\u0001¢\u0006\u0004\b \u0010\u0014J\u001a\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H×\u0003¢\u0006\u0004\b#\u0010$R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010\u0014R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b\t\u0010\u0019R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010)\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010.¨\u00064"}, d2 = {"Lir/nasim/core/modules/banking/entity/MyBankData;", "Landroid/os/Parcelable;", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/banking/entity/MyBankData$Shelf;", "Lkotlin/collections/ArrayList;", "shelves", "", "itemsVersion", "", "isChanged", ParameterNames.VERSION, "<init>", "(Ljava/util/ArrayList;IZI)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/ArrayList;", "component2", "component3", "()Z", "component4", "copy", "(Ljava/util/ArrayList;IZI)Lir/nasim/core/modules/banking/entity/MyBankData;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getShelves", "setShelves", "(Ljava/util/ArrayList;)V", TokenNames.I, "getItemsVersion", "Z", "getVersion", "setVersion", "(I)V", "Shelf", "Item", "Payload", "Peer", "Message", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MyBankData implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MyBankData> CREATOR = new a();

    @InterfaceC23984xq6("isChanged")
    private final boolean isChanged;

    @InterfaceC23984xq6("itemsVersion")
    private final int itemsVersion;

    @InterfaceC23984xq6("shelves")
    private ArrayList<Shelf> shelves;

    @InterfaceC23984xq6(ParameterNames.VERSION)
    private int version;

    @Keep
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H×\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\nH×\u0001¢\u0006\u0004\b\u001b\u0010\u0010J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH×\u0003¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010$R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010!\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010$R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lir/nasim/core/modules/banking/entity/MyBankData$Message;", "Landroid/os/Parcelable;", "", "date", DialogEntity.COLUMN_RID, "seq", "<init>", "(JJLjava/lang/Long;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "component3", "()Ljava/lang/Long;", "copy", "(JJLjava/lang/Long;)Lir/nasim/core/modules/banking/entity/MyBankData$Message;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getDate", "setDate", "(J)V", "getRid", "setRid", "Ljava/lang/Long;", "getSeq", "setSeq", "(Ljava/lang/Long;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
    @KeepName
    public static final /* data */ class Message implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Message> CREATOR = new a();

        @InterfaceC23984xq6("date")
        private long date;

        @InterfaceC23984xq6(DialogEntity.COLUMN_RID)
        private long rid;

        @InterfaceC23984xq6("seq")
        private Long seq;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Message createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Message(parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Message[] newArray(int i) {
                return new Message[i];
            }
        }

        public Message(long j, long j2, Long l) {
            this.date = j;
            this.rid = j2;
            this.seq = l;
        }

        public static /* synthetic */ Message copy$default(Message message, long j, long j2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = message.date;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = message.rid;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                l = message.seq;
            }
            return message.copy(j3, j4, l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getDate() {
            return this.date;
        }

        /* renamed from: component2, reason: from getter */
        public final long getRid() {
            return this.rid;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getSeq() {
            return this.seq;
        }

        public final Message copy(long date, long rid, Long seq) {
            return new Message(date, rid, seq);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return this.date == message.date && this.rid == message.rid && AbstractC13042fc3.d(this.seq, message.seq);
        }

        public final long getDate() {
            return this.date;
        }

        public final long getRid() {
            return this.rid;
        }

        public final Long getSeq() {
            return this.seq;
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.date) * 31) + Long.hashCode(this.rid)) * 31;
            Long l = this.seq;
            return iHashCode + (l == null ? 0 : l.hashCode());
        }

        public final void setDate(long j) {
            this.date = j;
        }

        public final void setRid(long j) {
            this.rid = j;
        }

        public final void setSeq(Long l) {
            this.seq = l;
        }

        public String toString() {
            return "Message(date=" + this.date + ", rid=" + this.rid + ", seq=" + this.seq + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeLong(this.date);
            dest.writeLong(this.rid);
            Long l = this.seq;
            if (l == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeLong(l.longValue());
            }
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H×\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001c\u0010\u0010J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH×\u0003¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010%R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010)R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lir/nasim/core/modules/banking/entity/MyBankData$Peer;", "Landroid/os/Parcelable;", "", "type", "", "id", "accessHash", "<init>", "(Ljava/lang/Integer;JLjava/lang/Long;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/Integer;", "component2", "()J", "component3", "()Ljava/lang/Long;", "copy", "(Ljava/lang/Integer;JLjava/lang/Long;)Lir/nasim/core/modules/banking/entity/MyBankData$Peer;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getType", "setType", "(Ljava/lang/Integer;)V", "J", "getId", "setId", "(J)V", "Ljava/lang/Long;", "getAccessHash", "setAccessHash", "(Ljava/lang/Long;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
    @KeepName
    public static final /* data */ class Peer implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Peer> CREATOR = new a();

        @InterfaceC23984xq6("accessHash")
        private Long accessHash;

        @InterfaceC23984xq6("id")
        private long id;

        @InterfaceC23984xq6("type")
        private Integer type;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Peer createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Peer(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readLong(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Peer[] newArray(int i) {
                return new Peer[i];
            }
        }

        public Peer(Integer num, long j, Long l) {
            this.type = num;
            this.id = j;
            this.accessHash = l;
        }

        public static /* synthetic */ Peer copy$default(Peer peer, Integer num, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                num = peer.type;
            }
            if ((i & 2) != 0) {
                j = peer.id;
            }
            if ((i & 4) != 0) {
                l = peer.accessHash;
            }
            return peer.copy(num, j, l);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getAccessHash() {
            return this.accessHash;
        }

        public final Peer copy(Integer type, long id, Long accessHash) {
            return new Peer(type, id, accessHash);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Peer)) {
                return false;
            }
            Peer peer = (Peer) other;
            return AbstractC13042fc3.d(this.type, peer.type) && this.id == peer.id && AbstractC13042fc3.d(this.accessHash, peer.accessHash);
        }

        public final Long getAccessHash() {
            return this.accessHash;
        }

        public final long getId() {
            return this.id;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            Integer num = this.type;
            int iHashCode = (((num == null ? 0 : num.hashCode()) * 31) + Long.hashCode(this.id)) * 31;
            Long l = this.accessHash;
            return iHashCode + (l != null ? l.hashCode() : 0);
        }

        public final void setAccessHash(Long l) {
            this.accessHash = l;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public String toString() {
            return "Peer(type=" + this.type + ", id=" + this.id + ", accessHash=" + this.accessHash + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            Integer num = this.type;
            if (num == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(num.intValue());
            }
            dest.writeLong(this.id);
            Long l = this.accessHash;
            if (l == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeLong(l.longValue());
            }
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJX\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÇ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\"\u0010\u0019J\u0010\u0010#\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H×\u0003¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010+R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010/R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00100\u001a\u0004\b\u0007\u0010\u001b\"\u0004\b1\u00102R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u00106R6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u00107\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lir/nasim/core/modules/banking/entity/MyBankData$Shelf;", "Landroid/os/Parcelable;", "", "id", "", "title", "", "isEditable", "badgeType", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/banking/entity/MyBankData$Item;", "Lkotlin/collections/ArrayList;", "items", "<init>", "(ILjava/lang/String;ZLjava/lang/Integer;Ljava/util/ArrayList;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()Z", "component4", "()Ljava/lang/Integer;", "component5", "()Ljava/util/ArrayList;", "copy", "(ILjava/lang/String;ZLjava/lang/Integer;Ljava/util/ArrayList;)Lir/nasim/core/modules/banking/entity/MyBankData$Shelf;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "setId", "(I)V", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "Z", "setEditable", "(Z)V", "Ljava/lang/Integer;", "getBadgeType", "setBadgeType", "(Ljava/lang/Integer;)V", "Ljava/util/ArrayList;", "getItems", "setItems", "(Ljava/util/ArrayList;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
    @KeepName
    public static final /* data */ class Shelf implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Shelf> CREATOR = new a();

        @InterfaceC23984xq6("badgeType")
        private Integer badgeType;

        @InterfaceC23984xq6("id")
        private int id;

        @InterfaceC23984xq6("isEditable")
        private boolean isEditable;

        @InterfaceC23984xq6("items")
        private ArrayList<Item> items;

        @InterfaceC23984xq6("title")
        private String title;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Shelf createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                AbstractC13042fc3.i(parcel, "parcel");
                int i = parcel.readInt();
                String string = parcel.readString();
                boolean z = parcel.readInt() != 0;
                Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i2 = parcel.readInt();
                    arrayList = new ArrayList(i2);
                    for (int i3 = 0; i3 != i2; i3++) {
                        arrayList.add(Item.CREATOR.createFromParcel(parcel));
                    }
                }
                return new Shelf(i, string, z, numValueOf, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Shelf[] newArray(int i) {
                return new Shelf[i];
            }
        }

        public Shelf(int i, String str, boolean z, Integer num, ArrayList<Item> arrayList) {
            AbstractC13042fc3.i(str, "title");
            this.id = i;
            this.title = str;
            this.isEditable = z;
            this.badgeType = num;
            this.items = arrayList;
        }

        public static /* synthetic */ Shelf copy$default(Shelf shelf, int i, String str, boolean z, Integer num, ArrayList arrayList, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = shelf.id;
            }
            if ((i2 & 2) != 0) {
                str = shelf.title;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                z = shelf.isEditable;
            }
            boolean z2 = z;
            if ((i2 & 8) != 0) {
                num = shelf.badgeType;
            }
            Integer num2 = num;
            if ((i2 & 16) != 0) {
                arrayList = shelf.items;
            }
            return shelf.copy(i, str2, z2, num2, arrayList);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsEditable() {
            return this.isEditable;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getBadgeType() {
            return this.badgeType;
        }

        public final ArrayList<Item> component5() {
            return this.items;
        }

        public final Shelf copy(int id, String title, boolean isEditable, Integer badgeType, ArrayList<Item> items) {
            AbstractC13042fc3.i(title, "title");
            return new Shelf(id, title, isEditable, badgeType, items);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Shelf)) {
                return false;
            }
            Shelf shelf = (Shelf) other;
            return this.id == shelf.id && AbstractC13042fc3.d(this.title, shelf.title) && this.isEditable == shelf.isEditable && AbstractC13042fc3.d(this.badgeType, shelf.badgeType) && AbstractC13042fc3.d(this.items, shelf.items);
        }

        public final Integer getBadgeType() {
            return this.badgeType;
        }

        public final int getId() {
            return this.id;
        }

        public final ArrayList<Item> getItems() {
            return this.items;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.isEditable)) * 31;
            Integer num = this.badgeType;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            ArrayList<Item> arrayList = this.items;
            return iHashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public final boolean isEditable() {
            return this.isEditable;
        }

        public final void setBadgeType(Integer num) {
            this.badgeType = num;
        }

        public final void setEditable(boolean z) {
            this.isEditable = z;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setItems(ArrayList<Item> arrayList) {
            this.items = arrayList;
        }

        public final void setTitle(String str) {
            AbstractC13042fc3.i(str, "<set-?>");
            this.title = str;
        }

        public String toString() {
            return "Shelf(id=" + this.id + ", title=" + this.title + ", isEditable=" + this.isEditable + ", badgeType=" + this.badgeType + ", items=" + this.items + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(this.id);
            dest.writeString(this.title);
            dest.writeInt(this.isEditable ? 1 : 0);
            Integer num = this.badgeType;
            if (num == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(num.intValue());
            }
            ArrayList<Item> arrayList = this.items;
            if (arrayList == null) {
                dest.writeInt(0);
                return;
            }
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Item> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
    }

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MyBankData createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Shelf.CREATOR.createFromParcel(parcel));
            }
            return new MyBankData(arrayList, parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MyBankData[] newArray(int i) {
            return new MyBankData[i];
        }
    }

    public MyBankData(ArrayList<Shelf> arrayList, int i, boolean z, int i2) {
        AbstractC13042fc3.i(arrayList, "shelves");
        this.shelves = arrayList;
        this.itemsVersion = i;
        this.isChanged = z;
        this.version = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyBankData copy$default(MyBankData myBankData, ArrayList arrayList, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = myBankData.shelves;
        }
        if ((i3 & 2) != 0) {
            i = myBankData.itemsVersion;
        }
        if ((i3 & 4) != 0) {
            z = myBankData.isChanged;
        }
        if ((i3 & 8) != 0) {
            i2 = myBankData.version;
        }
        return myBankData.copy(arrayList, i, z, i2);
    }

    public final ArrayList<Shelf> component1() {
        return this.shelves;
    }

    /* renamed from: component2, reason: from getter */
    public final int getItemsVersion() {
        return this.itemsVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsChanged() {
        return this.isChanged;
    }

    /* renamed from: component4, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final MyBankData copy(ArrayList<Shelf> shelves, int itemsVersion, boolean isChanged, int version) {
        AbstractC13042fc3.i(shelves, "shelves");
        return new MyBankData(shelves, itemsVersion, isChanged, version);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyBankData)) {
            return false;
        }
        MyBankData myBankData = (MyBankData) other;
        return AbstractC13042fc3.d(this.shelves, myBankData.shelves) && this.itemsVersion == myBankData.itemsVersion && this.isChanged == myBankData.isChanged && this.version == myBankData.version;
    }

    public final int getItemsVersion() {
        return this.itemsVersion;
    }

    public final ArrayList<Shelf> getShelves() {
        return this.shelves;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.shelves.hashCode() * 31) + Integer.hashCode(this.itemsVersion)) * 31) + Boolean.hashCode(this.isChanged)) * 31) + Integer.hashCode(this.version);
    }

    public final boolean isChanged() {
        return this.isChanged;
    }

    public final void setShelves(ArrayList<Shelf> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.shelves = arrayList;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "MyBankData(shelves=" + this.shelves + ", itemsVersion=" + this.itemsVersion + ", isChanged=" + this.isChanged + ", version=" + this.version + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        ArrayList<Shelf> arrayList = this.shelves;
        dest.writeInt(arrayList.size());
        Iterator<Shelf> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.itemsVersion);
        dest.writeInt(this.isChanged ? 1 : 0);
        dest.writeInt(this.version);
    }

    public /* synthetic */ MyBankData(ArrayList arrayList, int i, boolean z, int i2, int i3, ED1 ed1) {
        this(arrayList, i, (i3 & 4) != 0 ? false : z, i2);
    }

    @Keep
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b!\u0010\"J$\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003¢\u0006\u0004\b#\u0010$Jh\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÇ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b'\u0010\u001bJ\u0010\u0010(\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b(\u0010\u0019J\u001a\u0010+\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010)H×\u0003¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u00100R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u00104R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00105\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u00108R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010-\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u00100R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010;\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010>R6\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010?\u001a\u0004\b@\u0010$\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lir/nasim/core/modules/banking/entity/MyBankData$Payload;", "Landroid/os/Parcelable;", "", "url", "Lir/nasim/core/modules/banking/entity/MyBankData$Peer;", "peer", "Lir/nasim/core/modules/banking/entity/MyBankData$Message;", DialogEntity.COLUMN_MESSAGE, "ussdCode", "", "withIntent", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/banking/entity/MyBankData$Item;", "Lkotlin/collections/ArrayList;", "menuItems", "<init>", "(Ljava/lang/String;Lir/nasim/core/modules/banking/entity/MyBankData$Peer;Lir/nasim/core/modules/banking/entity/MyBankData$Message;Ljava/lang/String;ZLjava/util/ArrayList;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Lir/nasim/core/modules/banking/entity/MyBankData$Peer;", "component3", "()Lir/nasim/core/modules/banking/entity/MyBankData$Message;", "component4", "component5", "()Z", "component6", "()Ljava/util/ArrayList;", "copy", "(Ljava/lang/String;Lir/nasim/core/modules/banking/entity/MyBankData$Peer;Lir/nasim/core/modules/banking/entity/MyBankData$Message;Ljava/lang/String;ZLjava/util/ArrayList;)Lir/nasim/core/modules/banking/entity/MyBankData$Payload;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "setUrl", "(Ljava/lang/String;)V", "Lir/nasim/core/modules/banking/entity/MyBankData$Peer;", "getPeer", "setPeer", "(Lir/nasim/core/modules/banking/entity/MyBankData$Peer;)V", "Lir/nasim/core/modules/banking/entity/MyBankData$Message;", "getMessage", "setMessage", "(Lir/nasim/core/modules/banking/entity/MyBankData$Message;)V", "getUssdCode", "setUssdCode", "Z", "getWithIntent", "setWithIntent", "(Z)V", "Ljava/util/ArrayList;", "getMenuItems", "setMenuItems", "(Ljava/util/ArrayList;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
    @KeepName
    public static final /* data */ class Payload implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Payload> CREATOR = new a();

        @InterfaceC23984xq6("menu_items")
        private ArrayList<Item> menuItems;

        @InterfaceC23984xq6(DialogEntity.COLUMN_MESSAGE)
        private Message message;

        @InterfaceC23984xq6("peer")
        private Peer peer;

        @InterfaceC23984xq6("url")
        private String url;

        @InterfaceC23984xq6("ussdCode")
        private String ussdCode;

        @InterfaceC23984xq6("withIntent")
        private boolean withIntent;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Payload createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                AbstractC13042fc3.i(parcel, "parcel");
                String string = parcel.readString();
                Peer peerCreateFromParcel = parcel.readInt() == 0 ? null : Peer.CREATOR.createFromParcel(parcel);
                Message messageCreateFromParcel = parcel.readInt() == 0 ? null : Message.CREATOR.createFromParcel(parcel);
                String string2 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i = parcel.readInt();
                    arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(Item.CREATOR.createFromParcel(parcel));
                    }
                }
                return new Payload(string, peerCreateFromParcel, messageCreateFromParcel, string2, z, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Payload[] newArray(int i) {
                return new Payload[i];
            }
        }

        public Payload(String str, Peer peer, Message message, String str2, boolean z, ArrayList<Item> arrayList) {
            this.url = str;
            this.peer = peer;
            this.message = message;
            this.ussdCode = str2;
            this.withIntent = z;
            this.menuItems = arrayList;
        }

        public static /* synthetic */ Payload copy$default(Payload payload, String str, Peer peer, Message message, String str2, boolean z, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = payload.url;
            }
            if ((i & 2) != 0) {
                peer = payload.peer;
            }
            Peer peer2 = peer;
            if ((i & 4) != 0) {
                message = payload.message;
            }
            Message message2 = message;
            if ((i & 8) != 0) {
                str2 = payload.ussdCode;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z = payload.withIntent;
            }
            boolean z2 = z;
            if ((i & 32) != 0) {
                arrayList = payload.menuItems;
            }
            return payload.copy(str, peer2, message2, str3, z2, arrayList);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final Peer getPeer() {
            return this.peer;
        }

        /* renamed from: component3, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUssdCode() {
            return this.ussdCode;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getWithIntent() {
            return this.withIntent;
        }

        public final ArrayList<Item> component6() {
            return this.menuItems;
        }

        public final Payload copy(String url, Peer peer, Message message, String ussdCode, boolean withIntent, ArrayList<Item> menuItems) {
            return new Payload(url, peer, message, ussdCode, withIntent, menuItems);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Payload)) {
                return false;
            }
            Payload payload = (Payload) other;
            return AbstractC13042fc3.d(this.url, payload.url) && AbstractC13042fc3.d(this.peer, payload.peer) && AbstractC13042fc3.d(this.message, payload.message) && AbstractC13042fc3.d(this.ussdCode, payload.ussdCode) && this.withIntent == payload.withIntent && AbstractC13042fc3.d(this.menuItems, payload.menuItems);
        }

        public final ArrayList<Item> getMenuItems() {
            return this.menuItems;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final Peer getPeer() {
            return this.peer;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getUssdCode() {
            return this.ussdCode;
        }

        public final boolean getWithIntent() {
            return this.withIntent;
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Peer peer = this.peer;
            int iHashCode2 = (iHashCode + (peer == null ? 0 : peer.hashCode())) * 31;
            Message message = this.message;
            int iHashCode3 = (iHashCode2 + (message == null ? 0 : message.hashCode())) * 31;
            String str2 = this.ussdCode;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.withIntent)) * 31;
            ArrayList<Item> arrayList = this.menuItems;
            return iHashCode4 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public final void setMenuItems(ArrayList<Item> arrayList) {
            this.menuItems = arrayList;
        }

        public final void setMessage(Message message) {
            this.message = message;
        }

        public final void setPeer(Peer peer) {
            this.peer = peer;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final void setUssdCode(String str) {
            this.ussdCode = str;
        }

        public final void setWithIntent(boolean z) {
            this.withIntent = z;
        }

        public String toString() {
            return "Payload(url=" + this.url + ", peer=" + this.peer + ", message=" + this.message + ", ussdCode=" + this.ussdCode + ", withIntent=" + this.withIntent + ", menuItems=" + this.menuItems + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.url);
            Peer peer = this.peer;
            if (peer == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                peer.writeToParcel(dest, flags);
            }
            Message message = this.message;
            if (message == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                message.writeToParcel(dest, flags);
            }
            dest.writeString(this.ussdCode);
            dest.writeInt(this.withIntent ? 1 : 0);
            ArrayList<Item> arrayList = this.menuItems;
            if (arrayList == null) {
                dest.writeInt(0);
                return;
            }
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Item> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }

        public /* synthetic */ Payload(String str, Peer peer, Message message, String str2, boolean z, ArrayList arrayList, int i, ED1 ed1) {
            this(str, peer, message, str2, (i & 16) != 0 ? false : z, arrayList);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b'\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\"\u0010 J\u0012\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b#\u0010 J\u0010\u0010$\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b&\u0010%J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001dJ\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001dJ\u0010\u0010-\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b-\u0010%J\u0012\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b.\u0010 J\u0010\u0010/\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b/\u0010%J¦\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0013\u001a\u00020\tHÇ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b2\u0010 J\u0010\u00103\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b3\u0010\u001dJ\u001a\u00106\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000104H×\u0003¢\u0006\u0004\b6\u00107R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010;R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010<\u001a\u0004\b=\u0010 \"\u0004\b>\u0010?R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010<\u001a\u0004\b@\u0010 \"\u0004\bA\u0010?R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010<\u001a\u0004\bB\u0010 \"\u0004\bC\u0010?R$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010<\u001a\u0004\bD\u0010 \"\u0004\bE\u0010?R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010F\u001a\u0004\bG\u0010%\"\u0004\bH\u0010IR\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010F\u001a\u0004\b\u000b\u0010%\"\u0004\bJ\u0010IR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010K\u001a\u0004\bL\u0010(\"\u0004\bM\u0010NR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010O\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010RR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u00108\u001a\u0004\bS\u0010\u001d\"\u0004\bT\u0010;R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u00108\u001a\u0004\bU\u0010\u001d\"\u0004\bV\u0010;R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010F\u001a\u0004\b\u0011\u0010%\"\u0004\bW\u0010IR$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010<\u001a\u0004\bX\u0010 \"\u0004\bY\u0010?R\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010F\u001a\u0004\b\u0013\u0010%\"\u0004\bZ\u0010I¨\u0006["}, d2 = {"Lir/nasim/core/modules/banking/entity/MyBankData$Item;", "Landroid/os/Parcelable;", "", "id", "", "title", "eventKey", ParameterNames.ICON, "badge", "", "blinkBadge", "isAds", "action", "Lir/nasim/core/modules/banking/entity/MyBankData$Payload;", "payload", "minAppVersion", "maxAppVersion", "isDisabled", "alterMessage", "isDefault", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Lir/nasim/core/modules/banking/entity/MyBankData$Payload;IIZLjava/lang/String;Z)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "()Z", "component7", "component8", "()Ljava/lang/Integer;", "component9", "()Lir/nasim/core/modules/banking/entity/MyBankData$Payload;", "component10", "component11", "component12", "component13", "component14", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Lir/nasim/core/modules/banking/entity/MyBankData$Payload;IIZLjava/lang/String;Z)Lir/nasim/core/modules/banking/entity/MyBankData$Item;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "setId", "(I)V", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getEventKey", "setEventKey", "getIcon", "setIcon", "getBadge", "setBadge", "Z", "getBlinkBadge", "setBlinkBadge", "(Z)V", "setAds", "Ljava/lang/Integer;", "getAction", "setAction", "(Ljava/lang/Integer;)V", "Lir/nasim/core/modules/banking/entity/MyBankData$Payload;", "getPayload", "setPayload", "(Lir/nasim/core/modules/banking/entity/MyBankData$Payload;)V", "getMinAppVersion", "setMinAppVersion", "getMaxAppVersion", "setMaxAppVersion", "setDisabled", "getAlterMessage", "setAlterMessage", "setDefault", "nasim_release"}, k = 1, mv = {2, 0, 0})
    @KeepName
    public static final /* data */ class Item implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Item> CREATOR = new a();

        @InterfaceC23984xq6("action")
        private Integer action;

        @InterfaceC23984xq6("alterMessage")
        private String alterMessage;

        @InterfaceC23984xq6("badge")
        private String badge;

        @InterfaceC23984xq6("blinkBadge")
        private boolean blinkBadge;

        @InterfaceC23984xq6("enetKey")
        private String eventKey;

        @InterfaceC23984xq6(ParameterNames.ICON)
        private String icon;

        @InterfaceC23984xq6("id")
        private int id;

        @InterfaceC23984xq6("isAds")
        private boolean isAds;

        @InterfaceC23984xq6("isDefault")
        private boolean isDefault;

        @InterfaceC23984xq6("isDisabled")
        private boolean isDisabled;

        @InterfaceC23984xq6("maxAppVersion")
        private int maxAppVersion;

        @InterfaceC23984xq6("minAppVersion")
        private int minAppVersion;

        @InterfaceC23984xq6("payload")
        private Payload payload;

        @InterfaceC23984xq6("title")
        private String title;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Item createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Item(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Payload.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        public Item(int i, String str, String str2, String str3, String str4, boolean z, boolean z2, Integer num, Payload payload, int i2, int i3, boolean z3, String str5, boolean z4) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str3, ParameterNames.ICON);
            this.id = i;
            this.title = str;
            this.eventKey = str2;
            this.icon = str3;
            this.badge = str4;
            this.blinkBadge = z;
            this.isAds = z2;
            this.action = num;
            this.payload = payload;
            this.minAppVersion = i2;
            this.maxAppVersion = i3;
            this.isDisabled = z3;
            this.alterMessage = str5;
            this.isDefault = z4;
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component10, reason: from getter */
        public final int getMinAppVersion() {
            return this.minAppVersion;
        }

        /* renamed from: component11, reason: from getter */
        public final int getMaxAppVersion() {
            return this.maxAppVersion;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getIsDisabled() {
            return this.isDisabled;
        }

        /* renamed from: component13, reason: from getter */
        public final String getAlterMessage() {
            return this.alterMessage;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getIsDefault() {
            return this.isDefault;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getEventKey() {
            return this.eventKey;
        }

        /* renamed from: component4, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        /* renamed from: component5, reason: from getter */
        public final String getBadge() {
            return this.badge;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getBlinkBadge() {
            return this.blinkBadge;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsAds() {
            return this.isAds;
        }

        /* renamed from: component8, reason: from getter */
        public final Integer getAction() {
            return this.action;
        }

        /* renamed from: component9, reason: from getter */
        public final Payload getPayload() {
            return this.payload;
        }

        public final Item copy(int id, String title, String eventKey, String icon, String badge, boolean blinkBadge, boolean isAds, Integer action, Payload payload, int minAppVersion, int maxAppVersion, boolean isDisabled, String alterMessage, boolean isDefault) {
            AbstractC13042fc3.i(title, "title");
            AbstractC13042fc3.i(icon, ParameterNames.ICON);
            return new Item(id, title, eventKey, icon, badge, blinkBadge, isAds, action, payload, minAppVersion, maxAppVersion, isDisabled, alterMessage, isDefault);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return this.id == item.id && AbstractC13042fc3.d(this.title, item.title) && AbstractC13042fc3.d(this.eventKey, item.eventKey) && AbstractC13042fc3.d(this.icon, item.icon) && AbstractC13042fc3.d(this.badge, item.badge) && this.blinkBadge == item.blinkBadge && this.isAds == item.isAds && AbstractC13042fc3.d(this.action, item.action) && AbstractC13042fc3.d(this.payload, item.payload) && this.minAppVersion == item.minAppVersion && this.maxAppVersion == item.maxAppVersion && this.isDisabled == item.isDisabled && AbstractC13042fc3.d(this.alterMessage, item.alterMessage) && this.isDefault == item.isDefault;
        }

        public final Integer getAction() {
            return this.action;
        }

        public final String getAlterMessage() {
            return this.alterMessage;
        }

        public final String getBadge() {
            return this.badge;
        }

        public final boolean getBlinkBadge() {
            return this.blinkBadge;
        }

        public final String getEventKey() {
            return this.eventKey;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final int getId() {
            return this.id;
        }

        public final int getMaxAppVersion() {
            return this.maxAppVersion;
        }

        public final int getMinAppVersion() {
            return this.minAppVersion;
        }

        public final Payload getPayload() {
            return this.payload;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31;
            String str = this.eventKey;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.icon.hashCode()) * 31;
            String str2 = this.badge;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.blinkBadge)) * 31) + Boolean.hashCode(this.isAds)) * 31;
            Integer num = this.action;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Payload payload = this.payload;
            int iHashCode5 = (((((((iHashCode4 + (payload == null ? 0 : payload.hashCode())) * 31) + Integer.hashCode(this.minAppVersion)) * 31) + Integer.hashCode(this.maxAppVersion)) * 31) + Boolean.hashCode(this.isDisabled)) * 31;
            String str3 = this.alterMessage;
            return ((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isDefault);
        }

        public final boolean isAds() {
            return this.isAds;
        }

        public final boolean isDefault() {
            return this.isDefault;
        }

        public final boolean isDisabled() {
            return this.isDisabled;
        }

        public final void setAction(Integer num) {
            this.action = num;
        }

        public final void setAds(boolean z) {
            this.isAds = z;
        }

        public final void setAlterMessage(String str) {
            this.alterMessage = str;
        }

        public final void setBadge(String str) {
            this.badge = str;
        }

        public final void setBlinkBadge(boolean z) {
            this.blinkBadge = z;
        }

        public final void setDefault(boolean z) {
            this.isDefault = z;
        }

        public final void setDisabled(boolean z) {
            this.isDisabled = z;
        }

        public final void setEventKey(String str) {
            this.eventKey = str;
        }

        public final void setIcon(String str) {
            AbstractC13042fc3.i(str, "<set-?>");
            this.icon = str;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setMaxAppVersion(int i) {
            this.maxAppVersion = i;
        }

        public final void setMinAppVersion(int i) {
            this.minAppVersion = i;
        }

        public final void setPayload(Payload payload) {
            this.payload = payload;
        }

        public final void setTitle(String str) {
            AbstractC13042fc3.i(str, "<set-?>");
            this.title = str;
        }

        public String toString() {
            return "Item(id=" + this.id + ", title=" + this.title + ", eventKey=" + this.eventKey + ", icon=" + this.icon + ", badge=" + this.badge + ", blinkBadge=" + this.blinkBadge + ", isAds=" + this.isAds + ", action=" + this.action + ", payload=" + this.payload + ", minAppVersion=" + this.minAppVersion + ", maxAppVersion=" + this.maxAppVersion + ", isDisabled=" + this.isDisabled + ", alterMessage=" + this.alterMessage + ", isDefault=" + this.isDefault + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(this.id);
            dest.writeString(this.title);
            dest.writeString(this.eventKey);
            dest.writeString(this.icon);
            dest.writeString(this.badge);
            dest.writeInt(this.blinkBadge ? 1 : 0);
            dest.writeInt(this.isAds ? 1 : 0);
            Integer num = this.action;
            if (num == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(num.intValue());
            }
            Payload payload = this.payload;
            if (payload == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                payload.writeToParcel(dest, flags);
            }
            dest.writeInt(this.minAppVersion);
            dest.writeInt(this.maxAppVersion);
            dest.writeInt(this.isDisabled ? 1 : 0);
            dest.writeString(this.alterMessage);
            dest.writeInt(this.isDefault ? 1 : 0);
        }

        public /* synthetic */ Item(int i, String str, String str2, String str3, String str4, boolean z, boolean z2, Integer num, Payload payload, int i2, int i3, boolean z3, String str5, boolean z4, int i4, ED1 ed1) {
            this(i, str, str2, str3, str4, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? false : z2, num, payload, (i4 & 512) != 0 ? C5721Ko.a.h() : i2, (i4 & 1024) != 0 ? C5721Ko.a.h() : i3, (i4 & 2048) != 0 ? false : z3, (i4 & 4096) != 0 ? null : str5, (i4 & 8192) != 0 ? false : z4);
        }
    }
}
