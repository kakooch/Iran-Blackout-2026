package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7150Qm2;
import ir.nasim.C9475a16;
import ir.nasim.core.runtime.logger.EmptyException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: ir.nasim.Qm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7150Qm2 {

    /* renamed from: ir.nasim.Qm2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ File d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = file;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            File[] fileArrListFiles;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            long length = 0;
            if (!this.d.exists()) {
                return AbstractC6392Nk0.e(0L);
            }
            if (!this.d.isDirectory()) {
                return AbstractC6392Nk0.e(this.d.length());
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.d);
            while (!linkedList.isEmpty()) {
                AbstractC20906so1.f(interfaceC20315ro1);
                File file = (File) linkedList.remove(0);
                if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                    Iterator itA = DJ.a(fileArrListFiles);
                    while (itA.hasNext()) {
                        File file2 = (File) itA.next();
                        length += file2.length();
                        if (file2.isDirectory()) {
                            AbstractC13042fc3.f(file2);
                            linkedList.add(file2);
                        }
                    }
                }
            }
            return AbstractC6392Nk0.e(length);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qm2$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            Object objC = AbstractC7150Qm2.c(null, null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.Qm2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20644sM5 c;
        final /* synthetic */ File d;

        /* renamed from: ir.nasim.Qm2$c$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C20644sM5 c20644sM5, File file, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c20644sM5;
            this.d = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(C20644sM5 c20644sM5, File file, String str) {
            AbstractC13042fc3.f(str);
            return c20644sM5.g(str);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                final C20644sM5 c20644sM5 = this.c;
                File[] fileArrListFiles = this.d.listFiles(c20644sM5 != null ? new FilenameFilter() { // from class: ir.nasim.Rm2
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file, String str) {
                        return AbstractC7150Qm2.c.y(c20644sM5, file, str);
                    }
                } : null);
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(((File) AbstractC10242bK.R0(fileArrListFiles, new a()).get(0)).getPath()));
                }
                C9475a16.a aVar2 = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new EmptyException())));
            } catch (Exception e) {
                C9475a16.a aVar3 = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(e)));
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qm2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        int d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ File g;
        final /* synthetic */ long h;

        /* renamed from: ir.nasim.Qm2$d$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(File file, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = file;
            this.h = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.g, this.h, interfaceC20295rm1);
            dVar.f = obj;
            return dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:37:0x00a1, B:39:0x00ad, B:34:0x0086, B:32:0x007f), top: B:45:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ad A[Catch: Exception -> 0x0020, TRY_LEAVE, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:37:0x00a1, B:39:0x00ad, B:34:0x0086, B:32:0x007f), top: B:45:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009e -> B:37:0x00a1). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.e
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L37
                if (r1 == r4) goto L2b
                if (r1 != r2) goto L23
                int r1 = r12.d
                int r5 = r12.c
                java.lang.Object r6 = r12.b
                java.io.File[] r6 = (java.io.File[]) r6
                java.lang.Object r7 = r12.f
                ir.nasim.ro1 r7 = (ir.nasim.InterfaceC20315ro1) r7
                ir.nasim.AbstractC10685c16.b(r13)     // Catch: java.lang.Exception -> L20
                goto La1
            L20:
                r13 = move-exception
                goto Lb4
            L23:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L2b:
                java.lang.Object r1 = r12.b
                java.io.File[] r1 = (java.io.File[]) r1
                java.lang.Object r5 = r12.f
                ir.nasim.ro1 r5 = (ir.nasim.InterfaceC20315ro1) r5
                ir.nasim.AbstractC10685c16.b(r13)
                goto L63
            L37:
                ir.nasim.AbstractC10685c16.b(r13)
                java.lang.Object r13 = r12.f
                r5 = r13
                ir.nasim.ro1 r5 = (ir.nasim.InterfaceC20315ro1) r5
                java.io.File r13 = r12.g
                java.io.File[] r1 = r13.listFiles()
                if (r1 != 0) goto L4c
                java.lang.Boolean r13 = ir.nasim.AbstractC6392Nk0.a(r3)
                return r13
            L4c:
                int r13 = r1.length
                if (r13 != 0) goto L54
                java.lang.Boolean r13 = ir.nasim.AbstractC6392Nk0.a(r3)
                return r13
            L54:
                java.io.File r13 = r12.g
                r12.f = r5
                r12.b = r1
                r12.e = r4
                java.lang.Object r13 = ir.nasim.AbstractC7150Qm2.b(r13, r12)
                if (r13 != r0) goto L63
                return r0
            L63:
                java.lang.Number r13 = (java.lang.Number) r13
                long r6 = r13.longValue()
                long r8 = r12.h
                int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r13 >= 0) goto L74
                java.lang.Boolean r13 = ir.nasim.AbstractC6392Nk0.a(r4)
                return r13
            L74:
                int r13 = r1.length
                if (r13 <= r4) goto L7f
                ir.nasim.Qm2$d$a r13 = new ir.nasim.Qm2$d$a
                r13.<init>()
                ir.nasim.XJ.K(r1, r13)
            L7f:
                int r13 = r1.length     // Catch: java.lang.Exception -> L20
                r6 = r1
                r7 = r5
                r1 = r13
                r5 = r3
            L84:
                if (r5 >= r1) goto Lbb
                r13 = r6[r5]     // Catch: java.lang.Exception -> L20
                ir.nasim.AbstractC20906so1.f(r7)     // Catch: java.lang.Exception -> L20
                r13.delete()     // Catch: java.lang.Exception -> L20
                java.io.File r13 = r12.g     // Catch: java.lang.Exception -> L20
                r12.f = r7     // Catch: java.lang.Exception -> L20
                r12.b = r6     // Catch: java.lang.Exception -> L20
                r12.c = r5     // Catch: java.lang.Exception -> L20
                r12.d = r1     // Catch: java.lang.Exception -> L20
                r12.e = r2     // Catch: java.lang.Exception -> L20
                java.lang.Object r13 = ir.nasim.AbstractC7150Qm2.b(r13, r12)     // Catch: java.lang.Exception -> L20
                if (r13 != r0) goto La1
                return r0
            La1:
                java.lang.Number r13 = (java.lang.Number) r13     // Catch: java.lang.Exception -> L20
                long r8 = r13.longValue()     // Catch: java.lang.Exception -> L20
                long r10 = r12.h     // Catch: java.lang.Exception -> L20
                int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r13 >= 0) goto Lb2
                java.lang.Boolean r13 = ir.nasim.AbstractC6392Nk0.a(r4)     // Catch: java.lang.Exception -> L20
                return r13
            Lb2:
                int r5 = r5 + r4
                goto L84
            Lb4:
                java.lang.String r0 = "FileUtils"
                java.lang.String r1 = "removeOlder files error:"
                ir.nasim.C19406qI3.c(r0, r1, r13)
            Lbb:
                java.lang.Boolean r13 = ir.nasim.AbstractC6392Nk0.a(r3)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7150Qm2.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qm2$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            Object objE = AbstractC7150Qm2.e(null, null, null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.Qm2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ File d;
        final /* synthetic */ File e;
        final /* synthetic */ C20644sM5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(File file, File file2, C20644sM5 c20644sM5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = file;
            this.e = file2;
            this.f = c20644sM5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(C20644sM5 c20644sM5, File file, String str) {
            AbstractC13042fc3.f(str);
            return c20644sM5.g(str);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, this.f, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File[] fileArrListFiles;
            Object objB;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            if (!this.d.isDirectory() || (fileArrListFiles = this.d.listFiles()) == null || fileArrListFiles.length == 0) {
                C9475a16.a aVar = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new EmptyException())));
            }
            if (!AbstractC13042fc3.d(AbstractC12542en2.q(this.e), "zip")) {
                C9475a16.a aVar2 = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("<zip> should be *.zip file!"))));
            }
            if (this.e.exists()) {
                this.e.delete();
            }
            if (!AbstractC7150Qm2.a(this.e)) {
                C9475a16.a aVar3 = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("<zip> can't create destination file!"))));
            }
            try {
                C12889fL5 c12889fL5 = new C12889fL5();
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.e)));
                byte[] bArr = new byte[1024];
                final C20644sM5 c20644sM5 = this.f;
                File[] fileArrListFiles2 = this.d.listFiles(c20644sM5 != null ? new FilenameFilter() { // from class: ir.nasim.Sm2
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file, String str) {
                        return AbstractC7150Qm2.f.y(c20644sM5, file, str);
                    }
                } : null);
                if (fileArrListFiles2 != null) {
                    for (File file : fileArrListFiles2) {
                        AbstractC20906so1.f(interfaceC20315ro1);
                        c12889fL5.a = new BufferedInputStream(new FileInputStream(file), 1024);
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        while (true) {
                            Object obj2 = c12889fL5.a;
                            AbstractC13042fc3.f(obj2);
                            int i = ((BufferedInputStream) obj2).read(bArr, 0, 1024);
                            if (i != -1) {
                                zipOutputStream.write(bArr, 0, i);
                            }
                        }
                        Object obj3 = c12889fL5.a;
                        AbstractC13042fc3.f(obj3);
                        ((BufferedInputStream) obj3).close();
                    }
                }
                zipOutputStream.close();
                C9475a16.a aVar4 = C9475a16.b;
                objB = C9475a16.b(this.e.getPath());
            } catch (Exception e) {
                this.e.delete();
                C9475a16.a aVar5 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(e));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qm2$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            Object objF = AbstractC7150Qm2.f(null, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.Qm2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ File d;
        final /* synthetic */ File e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(File file, File file2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = file;
            this.e = file2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, this.e, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            Object objB;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            if (this.d.isDirectory()) {
                C9475a16.a aVar = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("<zipSingle> file is directory!"))));
            }
            if (!AbstractC13042fc3.d(AbstractC12542en2.q(this.e), "zip")) {
                C9475a16.a aVar2 = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("<zipSingle> should be *.zip file!"))));
            }
            if (this.e.exists()) {
                this.e.delete();
            }
            if (!AbstractC7150Qm2.a(this.e)) {
                C9475a16.a aVar3 = C9475a16.b;
                return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("<zipSingle> can't create destination file!"))));
            }
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.e)));
                byte[] bArr = new byte[1024];
                AbstractC20906so1.f(interfaceC20315ro1);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.d), 1024);
                zipOutputStream.putNextEntry(new ZipEntry(this.d.getName()));
                while (true) {
                    int i = bufferedInputStream.read(bArr, 0, 1024);
                    if (i == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, i);
                }
                bufferedInputStream.close();
                zipOutputStream.close();
                C9475a16.a aVar4 = C9475a16.b;
                objB = C9475a16.b(this.e.getPath());
            } catch (Exception e) {
                this.e.delete();
                C9475a16.a aVar5 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(e));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final boolean a(File file) {
        AbstractC13042fc3.i(file, "<this>");
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            return file.createNewFile();
        } catch (Exception unused) {
            return false;
        }
    }

    public static final Object b(File file, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new a(file, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(java.io.File r5, ir.nasim.C20644sM5 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.AbstractC7150Qm2.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Qm2$b r0 = (ir.nasim.AbstractC7150Qm2.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.Qm2$b r0 = new ir.nasim.Qm2$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = ir.nasim.C12366eV1.b()
            ir.nasim.Qm2$c r2 = new ir.nasim.Qm2$c
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.b = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7150Qm2.c(java.io.File, ir.nasim.sM5, ir.nasim.rm1):java.lang.Object");
    }

    public static final Object d(File file, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new d(file, j, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(java.io.File r5, java.io.File r6, ir.nasim.C20644sM5 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            boolean r0 = r8 instanceof ir.nasim.AbstractC7150Qm2.e
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Qm2$e r0 = (ir.nasim.AbstractC7150Qm2.e) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.Qm2$e r0 = new ir.nasim.Qm2$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = ir.nasim.C12366eV1.b()
            ir.nasim.Qm2$f r2 = new ir.nasim.Qm2$f
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.b = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7150Qm2.e(java.io.File, java.io.File, ir.nasim.sM5, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(java.io.File r5, java.io.File r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.AbstractC7150Qm2.g
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Qm2$g r0 = (ir.nasim.AbstractC7150Qm2.g) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.Qm2$g r0 = new ir.nasim.Qm2$g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = ir.nasim.C12366eV1.b()
            ir.nasim.Qm2$h r2 = new ir.nasim.Qm2$h
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.b = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7150Qm2.f(java.io.File, java.io.File, ir.nasim.rm1):java.lang.Object");
    }
}
