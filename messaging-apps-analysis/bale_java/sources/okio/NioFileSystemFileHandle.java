package okio;

import ir.nasim.AbstractC13042fc3;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c¨\u0006\u001d"}, d2 = {"Lokio/NioFileSystemFileHandle;", "Lokio/FileHandle;", "", "readWrite", "Ljava/nio/channels/FileChannel;", "fileChannel", "<init>", "(ZLjava/nio/channels/FileChannel;)V", "", "size", "Lir/nasim/rB7;", "protectedResize", "(J)V", "protectedSize", "()J", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedRead", "(J[BII)I", "protectedWrite", "(J[BII)V", "protectedFlush", "()V", "protectedClose", "Ljava/nio/channels/FileChannel;", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class NioFileSystemFileHandle extends FileHandle {
    private final FileChannel fileChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NioFileSystemFileHandle(boolean z, FileChannel fileChannel) {
        super(z);
        AbstractC13042fc3.i(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedClose() {
        this.fileChannel.close();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    @Override // okio.FileHandle
    protected synchronized int protectedRead(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        AbstractC13042fc3.i(array, "array");
        this.fileChannel.position(fileOffset);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, arrayOffset, byteCount);
        int i = 0;
        while (true) {
            if (i >= byteCount) {
                break;
            }
            int i2 = this.fileChannel.read(byteBufferWrap);
            if (i2 != -1) {
                i += i2;
            } else if (i == 0) {
                return -1;
            }
        }
        return i;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedResize(long size) {
        try {
            long size2 = size();
            long j = size - size2;
            if (j > 0) {
                int i = (int) j;
                protectedWrite(size2, new byte[i], 0, i);
            } else {
                this.fileChannel.truncate(size);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okio.FileHandle
    protected synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedWrite(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        AbstractC13042fc3.i(array, "array");
        this.fileChannel.position(fileOffset);
        this.fileChannel.write(ByteBuffer.wrap(array, arrayOffset, byteCount));
    }
}
