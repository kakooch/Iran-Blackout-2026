package ir.nasim.database.pinMessages;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.ED1;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001$B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000eJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\fR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b!\u0010\fR\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\"\u0010\f¨\u0006%"}, d2 = {"Lir/nasim/database/pinMessages/PinMessageEntity;", "", "", "peerUniqueId", "", DialogEntity.COLUMN_EX_PEER_TYPE, DialogEntity.COLUMN_RID, "date", "editedAt", "<init>", "(JIJJJ)V", "component1", "()J", "component2", "()I", "component3", "component4", "component5", "copy", "(JIJJJ)Lir/nasim/database/pinMessages/PinMessageEntity;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getPeerUniqueId", TokenNames.I, "getExPeerType", "getRid", "getDate", "getEditedAt", "Companion", "a", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class PinMessageEntity {
    public static final String COLS_EX_PEER_TYPE = "ex_peer_type";
    public static final String COLS_MESSAGE_DATE = "message_date";
    public static final String COLS_MESSAGE_EDITED_AT = "message_edited_at";
    public static final String COLS_MESSAGE_RID = "message_rid";
    public static final String COLS_PEER_UNIQUE_ID = "peer_unique_id";
    public static final String ENTITY_NAME = "pin_message";
    private final long date;
    private final long editedAt;
    private final int exPeerType;
    private final long peerUniqueId;
    private final long rid;

    public PinMessageEntity(long j, int i, long j2, long j3, long j4) {
        this.peerUniqueId = j;
        this.exPeerType = i;
        this.rid = j2;
        this.date = j3;
        this.editedAt = j4;
    }

    /* renamed from: component1, reason: from getter */
    public final long getPeerUniqueId() {
        return this.peerUniqueId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getExPeerType() {
        return this.exPeerType;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRid() {
        return this.rid;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final long getEditedAt() {
        return this.editedAt;
    }

    public final PinMessageEntity copy(long peerUniqueId, int exPeerType, long rid, long date, long editedAt) {
        return new PinMessageEntity(peerUniqueId, exPeerType, rid, date, editedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PinMessageEntity)) {
            return false;
        }
        PinMessageEntity pinMessageEntity = (PinMessageEntity) other;
        return this.peerUniqueId == pinMessageEntity.peerUniqueId && this.exPeerType == pinMessageEntity.exPeerType && this.rid == pinMessageEntity.rid && this.date == pinMessageEntity.date && this.editedAt == pinMessageEntity.editedAt;
    }

    public final long getDate() {
        return this.date;
    }

    public final long getEditedAt() {
        return this.editedAt;
    }

    public final int getExPeerType() {
        return this.exPeerType;
    }

    public final long getPeerUniqueId() {
        return this.peerUniqueId;
    }

    public final long getRid() {
        return this.rid;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.peerUniqueId) * 31) + Integer.hashCode(this.exPeerType)) * 31) + Long.hashCode(this.rid)) * 31) + Long.hashCode(this.date)) * 31) + Long.hashCode(this.editedAt);
    }

    public String toString() {
        return "PinMessageEntity(peerUniqueId=" + this.peerUniqueId + ", exPeerType=" + this.exPeerType + ", rid=" + this.rid + ", date=" + this.date + ", editedAt=" + this.editedAt + Separators.RPAREN;
    }

    public /* synthetic */ PinMessageEntity(long j, int i, long j2, long j3, long j4, int i2, ED1 ed1) {
        this(j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? -1L : j2, (i2 & 8) != 0 ? -1L : j3, (i2 & 16) != 0 ? -1L : j4);
    }
}
