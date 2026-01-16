package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Environment;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.core.runtime.logger.LogDirectoryException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.Ml2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6164Ml2 {
    private static OutputStreamWriter e;
    private static NZ f;
    public static final C6164Ml2 a = new C6164Ml2();
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
    private static byte[] c = new byte[0];
    private static final ReentrantLock d = new ReentrantLock();
    private static final InterfaceC9173Yu3 g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Kl2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C6164Ml2.m();
        }
    });

    /* renamed from: ir.nasim.Ml2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            File fileU = C6164Ml2.a.u();
            return AbstractC6392Nk0.a(fileU != null ? AbstractC12542en2.p(fileU) : false);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ml2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (C6164Ml2.e == null) {
                return AbstractC6392Nk0.a(true);
            }
            try {
                C19406qI3.a("FileLog", "disableStoreLogs success", new Object[0]);
                C6164Ml2.a.z("-----log Stopped-----");
                C6164Ml2.c = null;
                NZ nz = C6164Ml2.f;
                if (nz != null) {
                    nz.recycle();
                }
                C6164Ml2.f = null;
                OutputStreamWriter outputStreamWriter = C6164Ml2.e;
                if (outputStreamWriter != null) {
                    outputStreamWriter.flush();
                }
                OutputStreamWriter outputStreamWriter2 = C6164Ml2.e;
                if (outputStreamWriter2 != null) {
                    outputStreamWriter2.close();
                }
                C6164Ml2.e = null;
                return AbstractC6392Nk0.a(true);
            } catch (Exception e) {
                C19406qI3.c("FileLog", "disableStoreLogs error:", e);
                return AbstractC6392Nk0.a(false);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ml2$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objS = C6164Ml2.this.s(this);
            return objS == AbstractC14862ic3.e() ? objS : C9475a16.a(objS);
        }
    }

    /* renamed from: ir.nasim.Ml2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6164Ml2 c6164Ml2 = C6164Ml2.a;
                File fileU = c6164Ml2.u();
                if (fileU == null) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new LogDirectoryException())));
                }
                File fileV = c6164Ml2.v();
                if (fileV == null) {
                    C9475a16.a aVar2 = C9475a16.b;
                    return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new LogDirectoryException())));
                }
                String str = C6164Ml2.b.format(AbstractC6392Nk0.e(System.currentTimeMillis()));
                AbstractC13042fc3.h(str, "format(...)");
                String str2 = String.format("baleLogs_%s.zip", Arrays.copyOf(new Object[]{str}, 1));
                AbstractC13042fc3.h(str2, "format(...)");
                File file = new File(fileV, str2);
                String str3 = String.format("baleLogs_%s.log", Arrays.copyOf(new Object[]{"[0-9]{4}_[0-9]{2}_[0-9]{2}_[0-9]{2}_[0-9]{2}_[0-9]{2}"}, 1));
                AbstractC13042fc3.h(str3, "format(...)");
                C20644sM5 c20644sM5 = new C20644sM5(str3);
                this.b = 1;
                objE = AbstractC7150Qm2.e(fileU, file, c20644sM5, this);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objE = ((C9475a16) obj).l();
            }
            return C9475a16.a(objE);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ml2$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objT = C6164Ml2.this.t(this);
            return objT == AbstractC14862ic3.e() ? objT : C9475a16.a(objT);
        }
    }

    /* renamed from: ir.nasim.Ml2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
                java.lang.Object r9 = r9.l()
                goto Le5
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                java.lang.Object r1 = r8.b
                java.io.File r1 = (java.io.File) r1
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
                java.lang.Object r9 = r9.l()
                goto L90
            L2f:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.Ml2 r9 = ir.nasim.C6164Ml2.a
                java.io.File r1 = ir.nasim.C6164Ml2.f(r9)
                if (r1 != 0) goto L4e
                ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
                ir.nasim.core.runtime.logger.LogDirectoryException r9 = new ir.nasim.core.runtime.logger.LogDirectoryException
                r9.<init>()
                java.lang.Object r9 = ir.nasim.AbstractC10685c16.a(r9)
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            L4e:
                java.io.File r9 = ir.nasim.C6164Ml2.h(r9)
                if (r9 != 0) goto L68
                ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
                ir.nasim.core.runtime.logger.LogDirectoryException r9 = new ir.nasim.core.runtime.logger.LogDirectoryException
                r9.<init>()
                java.lang.Object r9 = ir.nasim.AbstractC10685c16.a(r9)
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            L68:
                ir.nasim.sM5 r4 = new ir.nasim.sM5
                java.lang.String r5 = "[0-9]{4}_[0-9]{2}_[0-9]{2}_[0-9]{2}_[0-9]{2}_[0-9]{2}"
                java.lang.Object[] r5 = new java.lang.Object[]{r5}
                java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r3)
                java.lang.String r6 = "baleLogs_%s.log"
                java.lang.String r5 = java.lang.String.format(r6, r5)
                java.lang.String r6 = "format(...)"
                ir.nasim.AbstractC13042fc3.h(r5, r6)
                r4.<init>(r5)
                r8.b = r9
                r8.c = r3
                java.lang.Object r1 = ir.nasim.AbstractC7150Qm2.c(r1, r4, r8)
                if (r1 != r0) goto L8d
                return r0
            L8d:
                r7 = r1
                r1 = r9
                r9 = r7
            L90:
                boolean r3 = ir.nasim.C9475a16.j(r9)
                if (r3 == 0) goto Ld8
                boolean r3 = ir.nasim.C9475a16.g(r9)
                r4 = 0
                if (r3 == 0) goto L9f
                r3 = r4
                goto La0
            L9f:
                r3 = r9
            La0:
                if (r3 == 0) goto Ld8
                java.io.File r3 = new java.io.File
                boolean r5 = ir.nasim.C9475a16.g(r9)
                if (r5 == 0) goto Lab
                r9 = r4
            Lab:
                ir.nasim.AbstractC13042fc3.f(r9)
                java.lang.String r9 = (java.lang.String) r9
                r3.<init>(r9)
                java.io.File r9 = new java.io.File
                java.lang.String r5 = ir.nasim.AbstractC9925an2.r(r3)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                java.lang.String r5 = ".zip"
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                r9.<init>(r1, r5)
                r8.b = r4
                r8.c = r2
                java.lang.Object r9 = ir.nasim.AbstractC7150Qm2.f(r3, r9, r8)
                if (r9 != r0) goto Le5
                return r0
            Ld8:
                ir.nasim.core.runtime.logger.LogDirectoryException r9 = new ir.nasim.core.runtime.logger.LogDirectoryException
                r9.<init>()
                java.lang.Object r9 = ir.nasim.AbstractC10685c16.a(r9)
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
            Le5:
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6164Ml2.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ml2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                File fileU = C6164Ml2.a.u();
                if (fileU == null) {
                    return C19938rB7.a;
                }
                this.b = fileU;
                this.c = 1;
                if (AbstractC7150Qm2.d(fileU, 104857600L, this) == objE) {
                    return objE;
                }
                file = fileU;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = (File) this.b;
                AbstractC10685c16.b(obj);
            }
            C6164Ml2 c6164Ml2 = C6164Ml2.a;
            File fileV = c6164Ml2.v();
            if (fileV != null) {
                AbstractC6392Nk0.a(AbstractC12542en2.p(fileV));
            }
            if (C6164Ml2.e != null) {
                return C19938rB7.a;
            }
            String str = C6164Ml2.b.format(AbstractC6392Nk0.e(System.currentTimeMillis()));
            AbstractC13042fc3.h(str, "format(...)");
            String str2 = String.format("baleLogs_%s.log", Arrays.copyOf(new Object[]{str}, 1));
            AbstractC13042fc3.h(str2, "format(...)");
            File file2 = new File(file, str2);
            AbstractC7150Qm2.a(file2);
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file2));
                outputStreamWriter.write(c6164Ml2.r().b());
                outputStreamWriter.flush();
                C6164Ml2.e = outputStreamWriter;
                C6164Ml2.f = new NZ("FileLog");
            } catch (Exception e) {
                C19406qI3.c("FileLog", "createLogToFileStream error:", e);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private C6164Ml2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String str) throws IOException {
        AbstractC13042fc3.i(str, "$data");
        try {
            OutputStreamWriter outputStreamWriter = e;
            if (outputStreamWriter != null) {
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
            }
        } catch (Exception e2) {
            C19406qI3.d("FileLog", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC23069wI3 m() {
        return ((QI3) C92.a(C5721Ko.a.d(), QI3.class)).w();
    }

    public static final void n() {
        C6164Ml2 c6164Ml2 = a;
        if (c6164Ml2.r().a()) {
            c6164Ml2.w();
        } else {
            c = null;
        }
    }

    public static final boolean p() {
        return ((Boolean) AbstractC9323Zl0.e(C12366eV1.b(), new b(null))).booleanValue();
    }

    private final String q(C20606sI3 c20606sI3) {
        if (c20606sI3.c() != null && c20606sI3.a() != null) {
            String str = String.format("%s-%s/%s: %s, exception=%s", Arrays.copyOf(new Object[]{b.format(Long.valueOf(System.currentTimeMillis())), c20606sI3.b(), c20606sI3.d(), c20606sI3.c(), AbstractC16632lc2.b(c20606sI3.a())}, 5));
            AbstractC13042fc3.h(str, "format(...)");
            return str;
        }
        if (c20606sI3.c() != null) {
            String str2 = String.format("%s-%s/%s: %s", Arrays.copyOf(new Object[]{b.format(Long.valueOf(System.currentTimeMillis())), c20606sI3.b(), c20606sI3.d(), c20606sI3.c()}, 4));
            AbstractC13042fc3.h(str2, "format(...)");
            return str2;
        }
        if (c20606sI3.a() != null) {
            String str3 = String.format("%s-%s/%s: %s", Arrays.copyOf(new Object[]{b.format(Long.valueOf(System.currentTimeMillis())), c20606sI3.b(), c20606sI3.d(), AbstractC16632lc2.b(c20606sI3.a())}, 4));
            AbstractC13042fc3.h(str3, "format(...)");
            return str3;
        }
        String str4 = String.format("%s-%s/%s: %s", Arrays.copyOf(new Object[]{b.format(Long.valueOf(System.currentTimeMillis())), c20606sI3.b(), c20606sI3.d(), ""}, 4));
        AbstractC13042fc3.h(str4, "format(...)");
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC23069wI3 r() {
        return (InterfaceC23069wI3) g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File u() {
        try {
            C9475a16.a aVar = C9475a16.b;
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            C9475a16.b(AbstractC10685c16.a(th));
        }
        if (AbstractC13042fc3.d("mounted", Environment.getExternalStorageState())) {
            File file = new File(C5721Ko.a.d().getExternalFilesDir(null), "logs");
            file.mkdirs();
            return file;
        }
        C9475a16.b(C19938rB7.a);
        try {
            File file2 = new File(C5721Ko.a.d().getCacheDir(), "logs");
            file2.mkdirs();
            return file2;
        } catch (Throwable th2) {
            C9475a16.a aVar3 = C9475a16.b;
            C9475a16.b(AbstractC10685c16.a(th2));
            try {
                File file3 = new File(C5721Ko.a.d().getFilesDir(), "logs");
                file3.mkdirs();
                return file3;
            } catch (Exception e2) {
                C17213mb2.a.e(new Exception(new LogDirectoryException().getMessage(), e2));
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File v() {
        try {
            C9475a16.a aVar = C9475a16.b;
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            C9475a16.b(AbstractC10685c16.a(th));
        }
        if (AbstractC13042fc3.d("mounted", Environment.getExternalStorageState())) {
            File file = new File(C5721Ko.a.d().getExternalFilesDir(null), "tempLogs");
            file.mkdirs();
            return file;
        }
        C9475a16.b(C19938rB7.a);
        try {
            File file2 = new File(C5721Ko.a.d().getCacheDir(), "tempLogs");
            file2.mkdirs();
            return file2;
        } catch (Throwable th2) {
            C9475a16.a aVar3 = C9475a16.b;
            C9475a16.b(AbstractC10685c16.a(th2));
            try {
                File file3 = new File(C5721Ko.a.d().getFilesDir(), "tempLogs");
                file3.mkdirs();
                return file3;
            } catch (Exception e2) {
                C17213mb2.a.e(new Exception(new LogDirectoryException().getMessage(), e2));
                return null;
            }
        }
    }

    private final void y() {
        byte[] bArr = c;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        ReentrantLock reentrantLock = d;
        reentrantLock.lock();
        try {
            if (c != null && bArr.length != 0) {
                a.z(new String(bArr, C12275eL0.b));
                c = null;
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean z(final String str) {
        NZ nz = f;
        if (nz != null) {
            return Boolean.valueOf(nz.postRunnable(new Runnable() { // from class: ir.nasim.Ll2
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    C6164Ml2.A(str);
                }
            }));
        }
        return null;
    }

    public final Object o(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new a(null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C6164Ml2.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Ml2$c r0 = (ir.nasim.C6164Ml2.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ml2$c r0 = new ir.nasim.Ml2$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = ir.nasim.C12366eV1.b()
            ir.nasim.Ml2$d r2 = new ir.nasim.Ml2$d
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6164Ml2.s(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C6164Ml2.e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Ml2$e r0 = (ir.nasim.C6164Ml2.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ml2$e r0 = new ir.nasim.Ml2$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = ir.nasim.C12366eV1.b()
            ir.nasim.Ml2$f r2 = new ir.nasim.Ml2$f
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6164Ml2.t(ir.nasim.rm1):java.lang.Object");
    }

    public final void w() {
        AbstractC9323Zl0.e(C12366eV1.b(), new g(null));
    }

    public final void x(C20606sI3 c20606sI3) {
        AbstractC13042fc3.i(c20606sI3, "data");
        if (e != null) {
            y();
            z(q(c20606sI3) + Separators.RETURN);
            return;
        }
        if (c != null) {
            byte[] bytes = (q(c20606sI3) + Separators.RETURN).getBytes(C12275eL0.b);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            byte[] bArr = c;
            c = bArr != null ? AbstractC9648aK.z(bArr, bytes) : null;
        }
    }
}
