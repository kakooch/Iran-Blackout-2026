package okio;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16632lc2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23384wp6;
import ir.nasim.UA2;
import ir.nasim.Y73;
import java.util.List;
import kotlin.Metadata;
import okio.Path;
import okio.internal.ResourceFileSystem;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0012J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\fH&¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010#J5\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010$2\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00028\u00000%H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010)J!\u0010,\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\fH&¢\u0006\u0004\b,\u0010-J\u0015\u0010,\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b,\u0010.J?\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u0010$2\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\f2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00028\u00000%H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u00102J!\u00104\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\fH&¢\u0006\u0004\b4\u0010-J\u0015\u00104\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b4\u0010.J!\u00106\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\fH&¢\u0006\u0004\b6\u00107J\u0015\u00106\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b6\u00108J\u001f\u00109\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b9\u00107J\u0015\u00109\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b9\u00108J\u001f\u0010;\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H&¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010<J!\u0010>\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\fH&¢\u0006\u0004\b>\u00107J\u0015\u0010>\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b>\u00108J!\u0010@\u001a\u0002052\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b@\u00107J\u0015\u0010@\u001a\u0002052\u0006\u0010?\u001a\u00020\u0004¢\u0006\u0004\b@\u00108J\u001f\u0010A\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H&¢\u0006\u0004\bA\u0010<\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006C"}, d2 = {"Lokio/FileSystem;", "", "<init>", "()V", "Lokio/Path;", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "metadata", "(Lokio/Path;)Lokio/FileMetadata;", "metadataOrNull", "", "exists", "(Lokio/Path;)Z", "dir", "", "list", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "followSymlinks", "Lir/nasim/wp6;", "listRecursively", "(Lokio/Path;Z)Lir/nasim/wp6;", "(Lokio/Path;)Lir/nasim/wp6;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", TokenNames.T, "Lkotlin/Function1;", "Lokio/BufferedSource;", "readerAction", "-read", "(Lokio/Path;Lir/nasim/UA2;)Ljava/lang/Object;", "read", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "(Lokio/Path;)Lokio/Sink;", "Lokio/BufferedSink;", "writerAction", "-write", "(Lokio/Path;ZLir/nasim/UA2;)Ljava/lang/Object;", "write", "appendingSink", "Lir/nasim/rB7;", "createDirectory", "(Lokio/Path;Z)V", "(Lokio/Path;)V", "createDirectories", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "copy", "delete", "fileOrDirectory", "deleteRecursively", "createSymlink", "Companion", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public abstract class FileSystem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "asOkioFileSystem", "Ljava/nio/file/FileSystem;", "get", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final FileSystem get(java.nio.file.FileSystem fileSystem) {
            AbstractC13042fc3.i(fileSystem, "<this>");
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m174write$default(FileSystem fileSystem, Path path, boolean z, UA2 ua2, int i, Object obj) throws Throwable {
        Object objInvoke;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        AbstractC13042fc3.i(path, "file");
        AbstractC13042fc3.i(ua2, "writerAction");
        BufferedSink bufferedSinkBuffer = Okio.buffer(fileSystem.sink(path, z));
        Throwable th = null;
        try {
            objInvoke = ua2.invoke(bufferedSinkBuffer);
            Y73.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Y73.a(1);
        } catch (Throwable th3) {
            Y73.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th4) {
                    AbstractC16632lc2.a(th3, th4);
                }
            }
            Y73.a(1);
            objInvoke = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        AbstractC13042fc3.f(objInvoke);
        return objInvoke;
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.INSTANCE;
        String property = System.getProperty("java.io.tmpdir");
        AbstractC13042fc3.h(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        AbstractC13042fc3.h(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.appendingSink(path, z);
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectories(path, z);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectory(path, z);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.delete(path, z);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.deleteRecursively(path, z);
    }

    public static final FileSystem get(java.nio.file.FileSystem fileSystem) {
        return INSTANCE.get(fileSystem);
    }

    public static /* synthetic */ InterfaceC23384wp6 listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.listRecursively(path, z);
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return fileSystem.openReadWrite(path, z, z2);
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.sink(path, z);
    }

    /* renamed from: -read, reason: not valid java name */
    public final <T> T m175read(Path file, UA2 readerAction) throws Throwable {
        T t;
        AbstractC13042fc3.i(file, "file");
        AbstractC13042fc3.i(readerAction, "readerAction");
        BufferedSource bufferedSourceBuffer = Okio.buffer(source(file));
        Throwable th = null;
        try {
            t = (T) readerAction.invoke(bufferedSourceBuffer);
            Y73.b(1);
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Y73.a(1);
        } catch (Throwable th3) {
            Y73.b(1);
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th4) {
                    AbstractC16632lc2.a(th3, th4);
                }
            }
            Y73.a(1);
            th = th3;
            t = null;
        }
        if (th != null) {
            throw th;
        }
        AbstractC13042fc3.f(t);
        return t;
    }

    /* renamed from: -write, reason: not valid java name */
    public final <T> T m176write(Path file, boolean mustCreate, UA2 writerAction) throws Throwable {
        T t;
        AbstractC13042fc3.i(file, "file");
        AbstractC13042fc3.i(writerAction, "writerAction");
        BufferedSink bufferedSinkBuffer = Okio.buffer(sink(file, mustCreate));
        Throwable th = null;
        try {
            t = (T) writerAction.invoke(bufferedSinkBuffer);
            Y73.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Y73.a(1);
        } catch (Throwable th3) {
            Y73.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th4) {
                    AbstractC16632lc2.a(th3, th4);
                }
            }
            Y73.a(1);
            th = th3;
            t = null;
        }
        if (th != null) {
            throw th;
        }
        AbstractC13042fc3.f(t);
        return t;
    }

    public final Sink appendingSink(Path file) {
        AbstractC13042fc3.i(file, "file");
        return appendingSink(file, false);
    }

    public abstract Sink appendingSink(Path file, boolean mustExist);

    public abstract void atomicMove(Path source, Path target);

    public abstract Path canonicalize(Path path);

    public void copy(Path source, Path target) {
        AbstractC13042fc3.i(source, "source");
        AbstractC13042fc3.i(target, "target");
        okio.internal.FileSystem.commonCopy(this, source, target);
    }

    public final void createDirectories(Path dir, boolean mustCreate) {
        AbstractC13042fc3.i(dir, "dir");
        okio.internal.FileSystem.commonCreateDirectories(this, dir, mustCreate);
    }

    public final void createDirectory(Path dir) {
        AbstractC13042fc3.i(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(Path dir, boolean mustCreate);

    public abstract void createSymlink(Path source, Path target);

    public final void delete(Path path) {
        AbstractC13042fc3.i(path, "path");
        delete(path, false);
    }

    public abstract void delete(Path path, boolean mustExist);

    public void deleteRecursively(Path fileOrDirectory, boolean mustExist) {
        AbstractC13042fc3.i(fileOrDirectory, "fileOrDirectory");
        okio.internal.FileSystem.commonDeleteRecursively(this, fileOrDirectory, mustExist);
    }

    public final boolean exists(Path path) {
        AbstractC13042fc3.i(path, "path");
        return okio.internal.FileSystem.commonExists(this, path);
    }

    public abstract List<Path> list(Path dir);

    public abstract List<Path> listOrNull(Path dir);

    public InterfaceC23384wp6 listRecursively(Path dir, boolean followSymlinks) {
        AbstractC13042fc3.i(dir, "dir");
        return okio.internal.FileSystem.commonListRecursively(this, dir, followSymlinks);
    }

    public final FileMetadata metadata(Path path) {
        AbstractC13042fc3.i(path, "path");
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract FileHandle openReadOnly(Path file);

    public final FileHandle openReadWrite(Path file) {
        AbstractC13042fc3.i(file, "file");
        return openReadWrite(file, false, false);
    }

    public abstract FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist);

    public final Sink sink(Path file) {
        AbstractC13042fc3.i(file, "file");
        return sink(file, false);
    }

    public abstract Sink sink(Path file, boolean mustCreate);

    public abstract Source source(Path file);

    public final void createDirectories(Path dir) {
        AbstractC13042fc3.i(dir, "dir");
        createDirectories(dir, false);
    }

    public final void deleteRecursively(Path fileOrDirectory) {
        AbstractC13042fc3.i(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    public final InterfaceC23384wp6 listRecursively(Path dir) {
        AbstractC13042fc3.i(dir, "dir");
        return listRecursively(dir, false);
    }
}
