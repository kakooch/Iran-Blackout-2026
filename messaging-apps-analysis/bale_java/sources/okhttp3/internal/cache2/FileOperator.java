package okhttp3.internal.cache2;

import ir.nasim.AbstractC13042fc3;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import okio.Buffer;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "Ljava/nio/channels/FileChannel;", "fileChannel", "<init>", "(Ljava/nio/channels/FileChannel;)V", "", "pos", "Lokio/Buffer;", "source", "byteCount", "Lir/nasim/rB7;", "write", "(JLokio/Buffer;J)V", "sink", "read", "Ljava/nio/channels/FileChannel;", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        AbstractC13042fc3.i(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long pos, Buffer sink, long byteCount) throws IOException {
        AbstractC13042fc3.i(sink, "sink");
        if (byteCount < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (byteCount > 0) {
            long jTransferTo = this.fileChannel.transferTo(pos, byteCount, sink);
            pos += jTransferTo;
            byteCount -= jTransferTo;
        }
    }

    public final void write(long pos, Buffer source, long byteCount) throws IOException {
        AbstractC13042fc3.i(source, "source");
        if (byteCount < 0 || byteCount > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (byteCount > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(source, pos, byteCount);
            pos += jTransferFrom;
            byteCount -= jTransferFrom;
        }
    }
}
