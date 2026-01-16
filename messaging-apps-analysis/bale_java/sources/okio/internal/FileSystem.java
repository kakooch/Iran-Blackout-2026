package okio.internal;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC6703Op6;
import ir.nasim.AbstractC9131Yp6;
import ir.nasim.BJ;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC23384wp6;
import ir.nasim.SA1;
import ir.nasim.V06;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import okio.FileMetadata;
import okio.Path;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0010\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0014\u0010\r\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aH\u0010\u001e\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010 \u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lokio/FileSystem;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "commonMetadata", "(Lokio/FileSystem;Lokio/Path;)Lokio/FileMetadata;", "", "commonExists", "(Lokio/FileSystem;Lokio/Path;)Z", "dir", "mustCreate", "Lir/nasim/rB7;", "commonCreateDirectories", "(Lokio/FileSystem;Lokio/Path;Z)V", "source", "target", "commonCopy", "(Lokio/FileSystem;Lokio/Path;Lokio/Path;)V", "fileOrDirectory", "mustExist", "commonDeleteRecursively", "followSymlinks", "Lir/nasim/wp6;", "commonListRecursively", "(Lokio/FileSystem;Lokio/Path;Z)Lir/nasim/wp6;", "Lir/nasim/Op6;", "fileSystem", "Lir/nasim/BJ;", "stack", "postorder", "collectRecursively", "(Lir/nasim/Op6;Lokio/FileSystem;Lir/nasim/BJ;Lokio/Path;ZZLir/nasim/rm1;)Ljava/lang/Object;", "symlinkTarget", "(Lokio/FileSystem;Lokio/Path;)Lokio/Path;", "okio"}, k = 2, mv = {1, 9, 0})
/* renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* loaded from: classes8.dex */
public final class FileSystem {

    @SA1(c = "okio.internal.-FileSystem", f = "FileSystem.kt", l = {116, 135, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER}, m = "collectRecursively")
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: okio.internal.-FileSystem$collectRecursively$1, reason: invalid class name */
    static final class AnonymousClass1 extends AbstractC22163um1 {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= RecyclerView.UNDEFINED_DURATION;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    @SA1(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", l = {96}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lir/nasim/Op6;", "Lokio/Path;", "Lir/nasim/rB7;", "<anonymous>", "(Lir/nasim/Op6;)V"}, k = 3, mv = {1, 9, 0})
    /* renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name and case insensitive filesystem */
    static final class C252611 extends V06 implements InterfaceC14603iB2 {
        final /* synthetic */ Path $dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ okio.FileSystem $this_commonListRecursively;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C252611(Path path, okio.FileSystem fileSystem, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C252611 c252611 = new C252611(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, interfaceC20295rm1);
            c252611.L$0 = obj;
            return c252611;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C252611) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC6703Op6 abstractC6703Op6;
            BJ bj;
            Iterator<Path> it;
            Object objE = AbstractC14862ic3.e();
            int i = this.label;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC6703Op6 abstractC6703Op62 = (AbstractC6703Op6) this.L$0;
                BJ bj2 = new BJ();
                bj2.addLast(this.$dir);
                abstractC6703Op6 = abstractC6703Op62;
                bj = bj2;
                it = this.$this_commonListRecursively.list(this.$dir).iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                BJ bj3 = (BJ) this.L$1;
                AbstractC6703Op6 abstractC6703Op63 = (AbstractC6703Op6) this.L$0;
                AbstractC10685c16.b(obj);
                bj = bj3;
                abstractC6703Op6 = abstractC6703Op63;
            }
            while (it.hasNext()) {
                Path next = it.next();
                okio.FileSystem fileSystem = this.$this_commonListRecursively;
                boolean z = this.$followSymlinks;
                this.L$0 = abstractC6703Op6;
                this.L$1 = bj;
                this.L$2 = it;
                this.label = 1;
                if (FileSystem.collectRecursively(abstractC6703Op6, fileSystem, bj, next, z, false, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e2, code lost:
    
        if (r7 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e4, code lost:
    
        r6.addLast(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
    
        r7 = r6;
        r10 = r11;
        r11 = r12;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0129, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012a, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object collectRecursively(ir.nasim.AbstractC6703Op6 r15, okio.FileSystem r16, ir.nasim.BJ r17, okio.Path r18, boolean r19, boolean r20, ir.nasim.InterfaceC20295rm1 r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(ir.nasim.Op6, okio.FileSystem, ir.nasim.BJ, okio.Path, boolean, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #4 {all -> 0x003a, blocks: (B:3:0x0014, B:21:0x0040, B:27:0x0053, B:16:0x0036, B:13:0x0031, B:4:0x001c), top: B:46:0x0014, inners: #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053 A[Catch: all -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x003a, blocks: (B:3:0x0014, B:21:0x0040, B:27:0x0053, B:16:0x0036, B:13:0x0031, B:4:0x001c), top: B:46:0x0014, inners: #1, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void commonCopy(okio.FileSystem r4, okio.Path r5, okio.Path r6) {
        /*
            java.lang.String r0 = "<this>"
            ir.nasim.AbstractC13042fc3.i(r4, r0)
            java.lang.String r0 = "source"
            ir.nasim.AbstractC13042fc3.i(r5, r0)
            java.lang.String r0 = "target"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            okio.Source r5 = r4.source(r5)
            r0 = 0
            okio.Sink r4 = r4.sink(r6)     // Catch: java.lang.Throwable -> L3a
            okio.BufferedSink r4 = okio.Okio.buffer(r4)     // Catch: java.lang.Throwable -> L3a
            long r1 = r4.writeAll(r5)     // Catch: java.lang.Throwable -> L2e
            java.lang.Long r6 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L2c
            r4.close()     // Catch: java.lang.Throwable -> L2a
            goto L2c
        L2a:
            r4 = move-exception
            goto L3e
        L2c:
            r4 = r0
            goto L3e
        L2e:
            r6 = move-exception
            if (r4 == 0) goto L3c
            r4.close()     // Catch: java.lang.Throwable -> L35
            goto L3c
        L35:
            r4 = move-exception
            ir.nasim.AbstractC16041kc2.a(r6, r4)     // Catch: java.lang.Throwable -> L3a
            goto L3c
        L3a:
            r4 = move-exception
            goto L54
        L3c:
            r4 = r6
            r6 = r0
        L3e:
            if (r4 != 0) goto L53
            ir.nasim.AbstractC13042fc3.f(r6)     // Catch: java.lang.Throwable -> L3a
            long r1 = r6.longValue()     // Catch: java.lang.Throwable -> L3a
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L61
            r5.close()     // Catch: java.lang.Throwable -> L51
            goto L61
        L51:
            r0 = move-exception
            goto L61
        L53:
            throw r4     // Catch: java.lang.Throwable -> L3a
        L54:
            if (r5 == 0) goto L5e
            r5.close()     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r5 = move-exception
            ir.nasim.AbstractC16041kc2.a(r4, r5)
        L5e:
            r3 = r0
            r0 = r4
            r4 = r3
        L61:
            if (r0 != 0) goto L67
            ir.nasim.AbstractC13042fc3.f(r4)
            return
        L67:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path path, boolean z) {
        AbstractC13042fc3.i(fileSystem, "<this>");
        AbstractC13042fc3.i(path, "dir");
        BJ bj = new BJ();
        for (Path pathParent = path; pathParent != null && !fileSystem.exists(pathParent); pathParent = pathParent.parent()) {
            bj.addFirst(pathParent);
        }
        if (z && bj.isEmpty()) {
            throw new IOException(path + " already exists.");
        }
        Iterator<E> it = bj.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path path, boolean z) {
        AbstractC13042fc3.i(fileSystem, "<this>");
        AbstractC13042fc3.i(path, "fileOrDirectory");
        Iterator it = AbstractC9131Yp6.b(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) {
        AbstractC13042fc3.i(fileSystem, "<this>");
        AbstractC13042fc3.i(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final InterfaceC23384wp6 commonListRecursively(okio.FileSystem fileSystem, Path path, boolean z) {
        AbstractC13042fc3.i(fileSystem, "<this>");
        AbstractC13042fc3.i(path, "dir");
        return AbstractC9131Yp6.b(new C252611(path, fileSystem, z, null));
    }

    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws FileNotFoundException {
        AbstractC13042fc3.i(fileSystem, "<this>");
        AbstractC13042fc3.i(path, "path");
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) {
        AbstractC13042fc3.i(fileSystem, "<this>");
        AbstractC13042fc3.i(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path pathParent = path.parent();
        AbstractC13042fc3.f(pathParent);
        return pathParent.resolve(symlinkTarget);
    }
}
