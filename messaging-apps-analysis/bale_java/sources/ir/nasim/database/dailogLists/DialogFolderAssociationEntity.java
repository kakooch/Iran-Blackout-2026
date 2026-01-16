package ir.nasim.database.dailogLists;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u000e¨\u0006!"}, d2 = {"Lir/nasim/database/dailogLists/DialogFolderAssociationEntity;", "", "", "peerUid", "", DialogFolderAssociationEntity.COLUMN_FOLDER_ID, DialogFolderAssociationEntity.COLUMN_PINNED_INDEX, "<init>", "(JILjava/lang/Integer;)V", "component1", "()J", "component2", "()I", "component3", "()Ljava/lang/Integer;", "copy", "(JILjava/lang/Integer;)Lir/nasim/database/dailogLists/DialogFolderAssociationEntity;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getPeerUid", TokenNames.I, "getFolderId", "Ljava/lang/Integer;", "getPinnedIndex", "Companion", "a", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class DialogFolderAssociationEntity {
    public static final String COLUMN_FOLDER_ID = "folderId";
    public static final String COLUMN_PEER_UID = "peerUid";
    public static final String COLUMN_PINNED_INDEX = "pinnedIndex";
    public static final String TABLE_NAME = "dialog_folder_associations";
    private final int folderId;
    private final long peerUid;
    private final Integer pinnedIndex;

    public DialogFolderAssociationEntity(long j, int i, Integer num) {
        this.peerUid = j;
        this.folderId = i;
        this.pinnedIndex = num;
    }

    public static /* synthetic */ DialogFolderAssociationEntity copy$default(DialogFolderAssociationEntity dialogFolderAssociationEntity, long j, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dialogFolderAssociationEntity.peerUid;
        }
        if ((i2 & 2) != 0) {
            i = dialogFolderAssociationEntity.folderId;
        }
        if ((i2 & 4) != 0) {
            num = dialogFolderAssociationEntity.pinnedIndex;
        }
        return dialogFolderAssociationEntity.copy(j, i, num);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPeerUid() {
        return this.peerUid;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFolderId() {
        return this.folderId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getPinnedIndex() {
        return this.pinnedIndex;
    }

    public final DialogFolderAssociationEntity copy(long peerUid, int folderId, Integer pinnedIndex) {
        return new DialogFolderAssociationEntity(peerUid, folderId, pinnedIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogFolderAssociationEntity)) {
            return false;
        }
        DialogFolderAssociationEntity dialogFolderAssociationEntity = (DialogFolderAssociationEntity) other;
        return this.peerUid == dialogFolderAssociationEntity.peerUid && this.folderId == dialogFolderAssociationEntity.folderId && AbstractC13042fc3.d(this.pinnedIndex, dialogFolderAssociationEntity.pinnedIndex);
    }

    public final int getFolderId() {
        return this.folderId;
    }

    public final long getPeerUid() {
        return this.peerUid;
    }

    public final Integer getPinnedIndex() {
        return this.pinnedIndex;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.peerUid) * 31) + Integer.hashCode(this.folderId)) * 31;
        Integer num = this.pinnedIndex;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "DialogFolderAssociationEntity(peerUid=" + this.peerUid + ", folderId=" + this.folderId + ", pinnedIndex=" + this.pinnedIndex + Separators.RPAREN;
    }

    public /* synthetic */ DialogFolderAssociationEntity(long j, int i, Integer num, int i2, ED1 ed1) {
        this(j, i, (i2 & 4) != 0 ? null : num);
    }
}
