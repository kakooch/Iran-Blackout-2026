package ir.nasim.database.dailogLists;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lir/nasim/database/dailogLists/SortedDialogEntry;", "", "peerUid", "", DialogEntity.COLUMN_IS_PINNED, "", "<init>", "(JZ)V", "getPeerUid", "()J", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SortedDialogEntry {
    private final boolean isPinned;
    private final long peerUid;

    public SortedDialogEntry(long j, boolean z) {
        this.peerUid = j;
        this.isPinned = z;
    }

    public static /* synthetic */ SortedDialogEntry copy$default(SortedDialogEntry sortedDialogEntry, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = sortedDialogEntry.peerUid;
        }
        if ((i & 2) != 0) {
            z = sortedDialogEntry.isPinned;
        }
        return sortedDialogEntry.copy(j, z);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPeerUid() {
        return this.peerUid;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    public final SortedDialogEntry copy(long peerUid, boolean isPinned) {
        return new SortedDialogEntry(peerUid, isPinned);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SortedDialogEntry)) {
            return false;
        }
        SortedDialogEntry sortedDialogEntry = (SortedDialogEntry) other;
        return this.peerUid == sortedDialogEntry.peerUid && this.isPinned == sortedDialogEntry.isPinned;
    }

    public final long getPeerUid() {
        return this.peerUid;
    }

    public int hashCode() {
        return (Long.hashCode(this.peerUid) * 31) + Boolean.hashCode(this.isPinned);
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public String toString() {
        return "SortedDialogEntry(peerUid=" + this.peerUid + ", isPinned=" + this.isPinned + Separators.RPAREN;
    }
}
