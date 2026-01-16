package okio;

import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC12992fX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.InterfaceC23384wp6;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.xbill.DNS.Type;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b+\u0010*J\u001f\u0010-\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b2\u0010.J\u001f\u00103\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u00101J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0002\u00106\u001a\u0004\b\u0002\u00107¨\u00068"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "<init>", "(Lokio/FileSystem;)V", "Lokio/Path;", "path", "", "functionName", "parameterName", "onPathParameter", "(Lokio/Path;Ljava/lang/String;Ljava/lang/String;)Lokio/Path;", "onPathResult", "(Lokio/Path;Ljava/lang/String;)Lokio/Path;", "canonicalize", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "dir", "", "list", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "", "followSymlinks", "Lir/nasim/wp6;", "listRecursively", "(Lokio/Path;Z)Lir/nasim/wp6;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "Lir/nasim/rB7;", "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "toString", "()Ljava/lang/String;", "Lokio/FileSystem;", "()Lokio/FileSystem;", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lokio/Path;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: okio.ForwardingFileSystem$listRecursively$1, reason: invalid class name */
    static final class AnonymousClass1 extends AbstractC8614Ws3 implements UA2 {
        AnonymousClass1() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Path invoke(Path path) {
            AbstractC13042fc3.i(path, "it");
            return ForwardingFileSystem.this.onPathResult(path, "listRecursively");
        }
    }

    public ForwardingFileSystem(FileSystem fileSystem) {
        AbstractC13042fc3.i(fileSystem, "delegate");
        this.delegate = fileSystem;
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean mustExist) {
        AbstractC13042fc3.i(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", "file"), mustExist);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        AbstractC13042fc3.i(source, "source");
        AbstractC13042fc3.i(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        AbstractC13042fc3.i(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean mustCreate) {
        AbstractC13042fc3.i(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), mustCreate);
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) {
        AbstractC13042fc3.i(source, "source");
        AbstractC13042fc3.i(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", "target"));
    }

    /* renamed from: delegate, reason: from getter */
    public final FileSystem getDelegate() {
        return this.delegate;
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean mustExist) {
        AbstractC13042fc3.i(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), mustExist);
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) {
        AbstractC13042fc3.i(dir, "dir");
        List<Path> list = this.delegate.list(onPathParameter(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "list"));
        }
        AbstractC12992fX0.A(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        AbstractC13042fc3.i(dir, "dir");
        List<Path> listListOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (listListOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listListOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "listOrNull"));
        }
        AbstractC12992fX0.A(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public InterfaceC23384wp6 listRecursively(Path dir, boolean followSymlinks) {
        AbstractC13042fc3.i(dir, "dir");
        return AbstractC11342cq6.C(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), followSymlinks), new AnonymousClass1());
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        AbstractC13042fc3.i(path, "path");
        FileMetadata fileMetadataMetadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (fileMetadataMetadataOrNull == null) {
            return null;
        }
        return fileMetadataMetadataOrNull.getSymlinkTarget() == null ? fileMetadataMetadataOrNull : fileMetadataMetadataOrNull.copy((Type.IXFR & 1) != 0 ? fileMetadataMetadataOrNull.isRegularFile : false, (Type.IXFR & 2) != 0 ? fileMetadataMetadataOrNull.isDirectory : false, (Type.IXFR & 4) != 0 ? fileMetadataMetadataOrNull.symlinkTarget : onPathResult(fileMetadataMetadataOrNull.getSymlinkTarget(), "metadataOrNull"), (Type.IXFR & 8) != 0 ? fileMetadataMetadataOrNull.size : null, (Type.IXFR & 16) != 0 ? fileMetadataMetadataOrNull.createdAtMillis : null, (Type.IXFR & 32) != 0 ? fileMetadataMetadataOrNull.lastModifiedAtMillis : null, (Type.IXFR & 64) != 0 ? fileMetadataMetadataOrNull.lastAccessedAtMillis : null, (Type.IXFR & 128) != 0 ? fileMetadataMetadataOrNull.extras : null);
    }

    public Path onPathParameter(Path path, String functionName, String parameterName) {
        AbstractC13042fc3.i(path, "path");
        AbstractC13042fc3.i(functionName, "functionName");
        AbstractC13042fc3.i(parameterName, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String functionName) {
        AbstractC13042fc3.i(path, "path");
        AbstractC13042fc3.i(functionName, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        AbstractC13042fc3.i(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", "file"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) {
        AbstractC13042fc3.i(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", "file"), mustCreate, mustExist);
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean mustCreate) {
        AbstractC13042fc3.i(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", "file"), mustCreate);
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        AbstractC13042fc3.i(file, "file");
        return this.delegate.source(onPathParameter(file, "source", "file"));
    }

    public String toString() {
        return AbstractC10882cM5.b(getClass()).p() + '(' + this.delegate + ')';
    }
}
