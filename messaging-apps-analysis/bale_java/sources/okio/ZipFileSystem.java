package okio;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16632lc2;
import ir.nasim.ED1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.Metadata;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010!J\u001f\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010(J\u001f\u0010+\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020*2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010,J\u001f\u00101\u001a\u00020*2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00102R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00103R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00104R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00105¨\u00067"}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "fileSystem", "", "Lokio/internal/ZipEntry;", "entries", "", "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "path", "canonicalizeInternal", "(Lokio/Path;)Lokio/Path;", "dir", "", "throwOnFailure", "", "list", "(Lokio/Path;Z)Ljava/util/List;", "canonicalize", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "Lir/nasim/rB7;", "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "Lokio/Path;", "Lokio/FileSystem;", "Ljava/util/Map;", "Ljava/lang/String;", "Companion", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.INSTANCE, Separators.SLASH, false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public ZipFileSystem(Path path, FileSystem fileSystem, Map<Path, ZipEntry> map, String str) {
        AbstractC13042fc3.i(path, "zipPath");
        AbstractC13042fc3.i(fileSystem, "fileSystem");
        AbstractC13042fc3.i(map, "entries");
        this.zipPath = path;
        this.fileSystem = fileSystem;
        this.entries = map;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean mustExist) throws IOException {
        AbstractC13042fc3.i(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) throws IOException {
        AbstractC13042fc3.i(source, "source");
        AbstractC13042fc3.i(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) throws FileNotFoundException {
        AbstractC13042fc3.i(path, "path");
        Path pathCanonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(pathCanonicalizeInternal)) {
            return pathCanonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean mustCreate) throws IOException {
        AbstractC13042fc3.i(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) throws IOException {
        AbstractC13042fc3.i(source, "source");
        AbstractC13042fc3.i(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean mustExist) throws IOException {
        AbstractC13042fc3.i(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) throws IOException {
        AbstractC13042fc3.i(dir, "dir");
        List<Path> list = list(dir, true);
        AbstractC13042fc3.f(list);
        return list;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        AbstractC13042fc3.i(dir, "dir");
        return list(dir, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #4 {all -> 0x007a, blocks: (B:13:0x0054, B:31:0x0080, B:37:0x008b, B:26:0x0076, B:23:0x0071, B:14:0x0060), top: B:56:0x0054, inners: #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b A[Catch: all -> 0x007a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x007a, blocks: (B:13:0x0054, B:31:0x0080, B:37:0x008b, B:26:0x0076, B:23:0x0071, B:14:0x0060), top: B:56:0x0054, inners: #1, #5 }] */
    @Override // okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okio.FileMetadata metadataOrNull(okio.Path r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.String r0 = "path"
            ir.nasim.AbstractC13042fc3.i(r14, r0)
            okio.Path r14 = r13.canonicalizeInternal(r14)
            java.util.Map<okio.Path, okio.internal.ZipEntry> r0 = r13.entries
            java.lang.Object r14 = r0.get(r14)
            okio.internal.ZipEntry r14 = (okio.internal.ZipEntry) r14
            r0 = 0
            if (r14 != 0) goto L15
            return r0
        L15:
            okio.FileMetadata r12 = new okio.FileMetadata
            boolean r1 = r14.getIsDirectory()
            r2 = r1 ^ 1
            boolean r3 = r14.getIsDirectory()
            boolean r1 = r14.getIsDirectory()
            if (r1 == 0) goto L29
            r5 = r0
            goto L32
        L29:
            long r4 = r14.getSize()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r5 = r1
        L32:
            java.lang.Long r7 = r14.getLastModifiedAtMillis()
            r10 = 128(0x80, float:1.8E-43)
            r11 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            long r1 = r14.getOffset()
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L4c
            return r12
        L4c:
            okio.FileSystem r1 = r13.fileSystem
            okio.Path r2 = r13.zipPath
            okio.FileHandle r1 = r1.openReadOnly(r2)
            long r2 = r14.getOffset()     // Catch: java.lang.Throwable -> L7a
            okio.Source r14 = r1.source(r2)     // Catch: java.lang.Throwable -> L7a
            okio.BufferedSource r14 = okio.Okio.buffer(r14)     // Catch: java.lang.Throwable -> L7a
            okio.FileMetadata r2 = okio.internal.ZipFilesKt.readLocalHeader(r14, r12)     // Catch: java.lang.Throwable -> L6e
            if (r14 == 0) goto L6c
            r14.close()     // Catch: java.lang.Throwable -> L6a
            goto L6c
        L6a:
            r14 = move-exception
            goto L7e
        L6c:
            r14 = r0
            goto L7e
        L6e:
            r2 = move-exception
            if (r14 == 0) goto L7c
            r14.close()     // Catch: java.lang.Throwable -> L75
            goto L7c
        L75:
            r14 = move-exception
            ir.nasim.AbstractC16041kc2.a(r2, r14)     // Catch: java.lang.Throwable -> L7a
            goto L7c
        L7a:
            r14 = move-exception
            goto L8c
        L7c:
            r14 = r2
            r2 = r0
        L7e:
            if (r14 != 0) goto L8b
            ir.nasim.AbstractC13042fc3.f(r2)     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Throwable -> L89
            goto L98
        L89:
            r0 = move-exception
            goto L98
        L8b:
            throw r14     // Catch: java.lang.Throwable -> L7a
        L8c:
            if (r1 == 0) goto L96
            r1.close()     // Catch: java.lang.Throwable -> L92
            goto L96
        L92:
            r1 = move-exception
            ir.nasim.AbstractC16041kc2.a(r14, r1)
        L96:
            r2 = r0
            r0 = r14
        L98:
            if (r0 != 0) goto L9e
            ir.nasim.AbstractC13042fc3.f(r2)
            return r2
        L9e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.metadataOrNull(okio.Path):okio.FileMetadata");
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        AbstractC13042fc3.i(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) throws IOException {
        AbstractC13042fc3.i(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean mustCreate) throws IOException {
        AbstractC13042fc3.i(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path file) throws Throwable {
        BufferedSource bufferedSourceBuffer;
        AbstractC13042fc3.i(file, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(file));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        FileHandle fileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        Throwable th = null;
        try {
            bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(zipEntry.getOffset()));
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    AbstractC16632lc2.a(th3, th4);
                }
            }
            bufferedSourceBuffer = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        AbstractC13042fc3.f(bufferedSourceBuffer);
        ZipFilesKt.skipLocalHeader(bufferedSourceBuffer);
        return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(bufferedSourceBuffer, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSourceBuffer, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
    }

    private final List<Path> list(Path dir, boolean throwOnFailure) throws IOException {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(dir));
        if (zipEntry != null) {
            return AbstractC15401jX0.m1(zipEntry.getChildren());
        }
        if (!throwOnFailure) {
            return null;
        }
        throw new IOException("not a directory: " + dir);
    }
}
