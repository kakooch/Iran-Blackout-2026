package okio.internal;

import ir.nasim.AbstractC13042fc3;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "size", "", "truncate", "<init>", "(Lokio/Source;JZ)V", "Lokio/Buffer;", "newSize", "Lir/nasim/rB7;", "truncateToSize", "(Lokio/Buffer;J)V", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "J", "Z", "bytesReceived", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(Source source, long j, boolean z) {
        super(source);
        AbstractC13042fc3.i(source, "delegate");
        this.size = j;
        this.truncate = z;
    }

    private final void truncateToSize(Buffer buffer, long j) throws EOFException {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer sink, long byteCount) throws IOException {
        AbstractC13042fc3.i(sink, "sink");
        long j = this.bytesReceived;
        long j2 = this.size;
        if (j > j2) {
            byteCount = 0;
        } else if (this.truncate) {
            long j3 = j2 - j;
            if (j3 == 0) {
                return -1L;
            }
            byteCount = Math.min(byteCount, j3);
        }
        long j4 = super.read(sink, byteCount);
        if (j4 != -1) {
            this.bytesReceived += j4;
        }
        long j5 = this.bytesReceived;
        long j6 = this.size;
        if ((j5 >= j6 || j4 != -1) && j5 <= j6) {
            return j4;
        }
        if (j4 > 0 && j5 > j6) {
            truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
