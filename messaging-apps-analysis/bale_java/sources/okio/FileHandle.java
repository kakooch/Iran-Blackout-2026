package okio;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import java.io.Closeable;
import java.io.EOFException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002?@B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0016\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\rJ\r\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u0011J\r\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u000e\u001a\u00020 2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010!J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010\n\u001a\u00020&2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010'J\r\u0010(\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020&¢\u0006\u0004\b\"\u0010*J\u001d\u0010$\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b$\u0010+J\r\u0010,\u001a\u00020\u000f¢\u0006\u0004\b,\u0010\u001fJ/\u0010-\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H$¢\u0006\u0004\b-\u0010\u0017J/\u0010.\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H$¢\u0006\u0004\b.\u0010\u001dJ\u000f\u0010/\u001a\u00020\u000fH$¢\u0006\u0004\b/\u0010\u001fJ\u0017\u00100\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0007H$¢\u0006\u0004\b0\u0010\u001bJ\u000f\u00101\u001a\u00020\u0007H$¢\u0006\u0004\b1\u0010\u0019J\u000f\u00102\u001a\u00020\u000fH$¢\u0006\u0004\b2\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00103R\u0016\u00107\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010;\u001a\u000609j\u0002`:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "readWrite", "<init>", "(Z)V", "", "fileOffset", "Lokio/Buffer;", "sink", "byteCount", "readNoCloseCheck", "(JLokio/Buffer;J)J", "source", "Lir/nasim/rB7;", "writeNoCloseCheck", "(JLokio/Buffer;J)V", "", "array", "", "arrayOffset", "read", "(J[BII)I", "size", "()J", "resize", "(J)V", "write", "(J[BII)V", "flush", "()V", "Lokio/Source;", "(J)Lokio/Source;", "position", "(Lokio/Source;)J", "reposition", "(Lokio/Source;J)V", "Lokio/Sink;", "(J)Lokio/Sink;", "appendingSink", "()Lokio/Sink;", "(Lokio/Sink;)J", "(Lokio/Sink;J)V", "close", "protectedRead", "protectedWrite", "protectedFlush", "protectedResize", "protectedSize", "protectedClose", "Z", "getReadWrite", "()Z", "closed", "openStreamCount", TokenNames.I, "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private final ReentrantLock lock = _JvmPlatformKt.newLock();
    private int openStreamCount;
    private final boolean readWrite;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "Lokio/FileHandle;", "fileHandle", "", "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "source", "byteCount", "Lir/nasim/rB7;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "J", "getPosition", "()J", "setPosition", "(J)V", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okio"}, k = 1, mv = {1, 9, 0})
    private static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle, long j) {
            AbstractC13042fc3.i(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                }
            } finally {
                lock.unlock();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.protectedFlush();
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer source, long byteCount) {
            AbstractC13042fc3.i(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.writeNoCloseCheck(this.position, source, byteCount);
            this.position += byteCount;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "Lokio/FileHandle;", "fileHandle", "", "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lir/nasim/rB7;", "close", "()V", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "J", "getPosition", "()J", "setPosition", "(J)V", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okio"}, k = 1, mv = {1, 9, 0})
    private static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle, long j) {
            AbstractC13042fc3.i(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                }
            } finally {
                lock.unlock();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        @Override // okio.Source
        public long read(Buffer sink, long byteCount) {
            AbstractC13042fc3.i(sink, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long noCloseCheck = this.fileHandle.readNoCloseCheck(this.position, sink, byteCount);
            if (noCloseCheck != -1) {
                this.position += noCloseCheck;
            }
            return noCloseCheck;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public FileHandle(boolean z) {
        this.readWrite = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long fileOffset, Buffer sink, long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        long j = byteCount + fileOffset;
        long j2 = fileOffset;
        while (true) {
            if (j2 >= j) {
                break;
            }
            Segment segmentWritableSegment$okio = sink.writableSegment$okio(1);
            int iProtectedRead = protectedRead(j2, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j - j2, 8192 - r7));
            if (iProtectedRead == -1) {
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    sink.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
                if (fileOffset == j2) {
                    return -1L;
                }
            } else {
                segmentWritableSegment$okio.limit += iProtectedRead;
                long j3 = iProtectedRead;
                j2 += j3;
                sink.setSize$okio(sink.size() + j3);
            }
        }
        return j2 - fileOffset;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        return fileHandle.sink(j);
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        return fileHandle.source(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long fileOffset, Buffer source, long byteCount) {
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, byteCount);
        long j = byteCount + fileOffset;
        while (fileOffset < j) {
            Segment segment = source.head;
            AbstractC13042fc3.f(segment);
            int iMin = (int) Math.min(j - fileOffset, segment.limit - segment.pos);
            protectedWrite(fileOffset, segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j2 = iMin;
            fileOffset += j2;
            source.setSize$okio(source.size() - j2);
            if (segment.pos == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final Sink appendingSink() {
        return sink(size());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
            protectedClose();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
            protectedFlush();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(Source source) {
        long size;
        AbstractC13042fc3.i(source, "source");
        if (source instanceof buffer) {
            buffer bufferVar = (buffer) source;
            size = bufferVar.bufferField.size();
            source = bufferVar.source;
        } else {
            size = 0;
        }
        if (!(source instanceof FileHandleSource) || ((FileHandleSource) source).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        FileHandleSource fileHandleSource = (FileHandleSource) source;
        if (!fileHandleSource.getClosed()) {
            return fileHandleSource.getPosition() - size;
        }
        throw new IllegalStateException("closed".toString());
    }

    protected abstract void protectedClose();

    protected abstract void protectedFlush();

    protected abstract int protectedRead(long fileOffset, byte[] array, int arrayOffset, int byteCount);

    protected abstract void protectedResize(long size);

    protected abstract long protectedSize();

    protected abstract void protectedWrite(long fileOffset, byte[] array, int arrayOffset, int byteCount);

    public final int read(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        AbstractC13042fc3.i(array, "array");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
            return protectedRead(fileOffset, array, arrayOffset, byteCount);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void reposition(Source source, long position) throws EOFException {
        AbstractC13042fc3.i(source, "source");
        if (!(source instanceof buffer)) {
            if (!(source instanceof FileHandleSource) || ((FileHandleSource) source).getFileHandle() != this) {
                throw new IllegalArgumentException("source was not created by this FileHandle".toString());
            }
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (!(!fileHandleSource.getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            fileHandleSource.setPosition(position);
            return;
        }
        buffer bufferVar = (buffer) source;
        Source source2 = bufferVar.source;
        if (!(source2 instanceof FileHandleSource) || ((FileHandleSource) source2).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        FileHandleSource fileHandleSource2 = (FileHandleSource) source2;
        if (!(!fileHandleSource2.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        long size = bufferVar.bufferField.size();
        long position2 = position - (fileHandleSource2.getPosition() - size);
        if (0 <= position2 && position2 < size) {
            bufferVar.skip(position2);
        } else {
            bufferVar.bufferField.clear();
            fileHandleSource2.setPosition(position);
        }
    }

    public final void resize(long size) {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
            protectedResize(size);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Sink sink(long fileOffset) {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSink(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
            return protectedSize();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Source source(long fileOffset) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSource(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void write(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        AbstractC13042fc3.i(array, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
            protectedWrite(fileOffset, array, arrayOffset, byteCount);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long read(long fileOffset, Buffer sink, long byteCount) {
        AbstractC13042fc3.i(sink, "sink");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                C19938rB7 c19938rB7 = C19938rB7.a;
                reentrantLock.unlock();
                return readNoCloseCheck(fileOffset, sink, byteCount);
            }
            throw new IllegalStateException("closed".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long position(Sink sink) {
        long size;
        AbstractC13042fc3.i(sink, "sink");
        if (sink instanceof buffer) {
            buffer bufferVar = (buffer) sink;
            size = bufferVar.bufferField.size();
            sink = bufferVar.sink;
        } else {
            size = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.getClosed()) {
                return fileHandleSink.getPosition() + size;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    public final void write(long fileOffset, Buffer source, long byteCount) {
        AbstractC13042fc3.i(source, "source");
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    reentrantLock.unlock();
                    writeNoCloseCheck(fileOffset, source, byteCount);
                    return;
                }
                throw new IllegalStateException("closed".toString());
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void reposition(Sink sink, long position) {
        AbstractC13042fc3.i(sink, "sink");
        if (sink instanceof buffer) {
            buffer bufferVar = (buffer) sink;
            Sink sink2 = bufferVar.sink;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
                FileHandleSink fileHandleSink = (FileHandleSink) sink2;
                if (!fileHandleSink.getClosed()) {
                    bufferVar.emit();
                    fileHandleSink.setPosition(position);
                    return;
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
            if (!fileHandleSink2.getClosed()) {
                fileHandleSink2.setPosition(position);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }
}
