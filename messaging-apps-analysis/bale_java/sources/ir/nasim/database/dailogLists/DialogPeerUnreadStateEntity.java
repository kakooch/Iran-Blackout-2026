package ir.nasim.database.dailogLists;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u001c"}, d2 = {"Lir/nasim/database/dailogLists/DialogPeerUnreadStateEntity;", "", "", "peerUid", "", "isMute", "<init>", "(JZ)V", "component1", "()J", "component2", "()Z", "copy", "(JZ)Lir/nasim/database/dailogLists/DialogPeerUnreadStateEntity;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getPeerUid", "Z", "Companion", "a", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class DialogPeerUnreadStateEntity {
    public static final String COLUMN_PEER_UID = "peerUid";
    public static final String TABLE_NAME = "dialog_peer_unread_state";
    private final boolean isMute;
    private final long peerUid;

    public DialogPeerUnreadStateEntity(long j, boolean z) {
        this.peerUid = j;
        this.isMute = z;
    }

    public static /* synthetic */ DialogPeerUnreadStateEntity copy$default(DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dialogPeerUnreadStateEntity.peerUid;
        }
        if ((i & 2) != 0) {
            z = dialogPeerUnreadStateEntity.isMute;
        }
        return dialogPeerUnreadStateEntity.copy(j, z);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPeerUid() {
        return this.peerUid;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMute() {
        return this.isMute;
    }

    public final DialogPeerUnreadStateEntity copy(long peerUid, boolean isMute) {
        return new DialogPeerUnreadStateEntity(peerUid, isMute);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogPeerUnreadStateEntity)) {
            return false;
        }
        DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity = (DialogPeerUnreadStateEntity) other;
        return this.peerUid == dialogPeerUnreadStateEntity.peerUid && this.isMute == dialogPeerUnreadStateEntity.isMute;
    }

    public final long getPeerUid() {
        return this.peerUid;
    }

    public int hashCode() {
        return (Long.hashCode(this.peerUid) * 31) + Boolean.hashCode(this.isMute);
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public String toString() {
        return "DialogPeerUnreadStateEntity(peerUid=" + this.peerUid + ", isMute=" + this.isMute + Separators.RPAREN;
    }
}
