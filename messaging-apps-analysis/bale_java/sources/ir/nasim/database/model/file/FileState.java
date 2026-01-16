package ir.nasim.database.model.file;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lir/nasim/database/model/file/FileState;", "", "NotDownloaded", "Downloaded", "Lir/nasim/database/model/file/FileState$Downloaded;", "Lir/nasim/database/model/file/FileState$NotDownloaded;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public interface FileState {

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lir/nasim/database/model/file/FileState$Downloaded;", "Lir/nasim/database/model/file/FileState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class Downloaded implements FileState {
        public static final Downloaded INSTANCE = new Downloaded();

        private Downloaded() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Downloaded);
        }

        public int hashCode() {
            return -258189175;
        }

        public String toString() {
            return "Downloaded";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lir/nasim/database/model/file/FileState$NotDownloaded;", "Lir/nasim/database/model/file/FileState;", "chunkSize", "", "remainingChunkIndices", "", "<init>", "(ILjava/util/List;)V", "getChunkSize", "()I", "getRemainingChunkIndices", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class NotDownloaded implements FileState {
        private final int chunkSize;
        private final List<Integer> remainingChunkIndices;

        public NotDownloaded(int i, List<Integer> list) {
            AbstractC13042fc3.i(list, "remainingChunkIndices");
            this.chunkSize = i;
            this.remainingChunkIndices = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NotDownloaded copy$default(NotDownloaded notDownloaded, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = notDownloaded.chunkSize;
            }
            if ((i2 & 2) != 0) {
                list = notDownloaded.remainingChunkIndices;
            }
            return notDownloaded.copy(i, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getChunkSize() {
            return this.chunkSize;
        }

        public final List<Integer> component2() {
            return this.remainingChunkIndices;
        }

        public final NotDownloaded copy(int chunkSize, List<Integer> remainingChunkIndices) {
            AbstractC13042fc3.i(remainingChunkIndices, "remainingChunkIndices");
            return new NotDownloaded(chunkSize, remainingChunkIndices);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotDownloaded)) {
                return false;
            }
            NotDownloaded notDownloaded = (NotDownloaded) other;
            return this.chunkSize == notDownloaded.chunkSize && AbstractC13042fc3.d(this.remainingChunkIndices, notDownloaded.remainingChunkIndices);
        }

        public final int getChunkSize() {
            return this.chunkSize;
        }

        public final List<Integer> getRemainingChunkIndices() {
            return this.remainingChunkIndices;
        }

        public int hashCode() {
            return (Integer.hashCode(this.chunkSize) * 31) + this.remainingChunkIndices.hashCode();
        }

        public String toString() {
            return "NotDownloaded(chunkSize=" + this.chunkSize + ", remainingChunkIndices=" + this.remainingChunkIndices + Separators.RPAREN;
        }
    }
}
