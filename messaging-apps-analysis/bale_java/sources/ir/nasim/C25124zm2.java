package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC23350wm2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: ir.nasim.zm2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C25124zm2 implements InterfaceC23940xm2 {
    public static final a g = new a(null);
    private final long a;
    private final String b;
    private final AbstractC13778go1 c;
    private final SA2 d;
    private RandomAccessFile e;
    private final InterfaceC19699qn4 f;

    /* renamed from: ir.nasim.zm2$a */
    public static final class a {
        private a() {
        }

        public final void a(long j, String str, boolean z, boolean z2) {
            AbstractC13042fc3.i(str, "fileDescriptor");
            File file = new File(str);
            if (file.exists()) {
                if (z) {
                    file.delete();
                    return;
                }
                if (z2 && file.length() != j) {
                    file.delete();
                } else {
                    if (file.canRead() && file.canWrite()) {
                        return;
                    }
                    throw new SecurityException(str + " can't be read or be written.");
                }
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zm2$b */
    public interface b {
        C25124zm2 a(long j, String str, boolean z, boolean z2);
    }

    /* renamed from: ir.nasim.zm2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C25124zm2.this.a(this);
        }
    }

    /* renamed from: ir.nasim.zm2$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        int e;
        int f;
        /* synthetic */ Object g;
        int i;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C25124zm2.this.b(0, null, 0, 0, this);
        }
    }

    /* renamed from: ir.nasim.zm2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ byte[] f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, int i2, byte[] bArr, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
            this.f = bArr;
            this.g = i3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C25124zm2.this.new e(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            RandomAccessFile randomAccessFile = C25124zm2.this.e;
            RandomAccessFile randomAccessFile2 = null;
            if (randomAccessFile == null) {
                AbstractC13042fc3.y("randomAccessFile");
                randomAccessFile = null;
            }
            randomAccessFile.seek(this.d);
            if (this.e > 8388608) {
                int i = 0;
                while (true) {
                    int i2 = this.e;
                    if (i >= i2) {
                        break;
                    }
                    int iMin = Math.min(8388608, i2 - i);
                    RandomAccessFile randomAccessFile3 = C25124zm2.this.e;
                    if (randomAccessFile3 == null) {
                        AbstractC13042fc3.y("randomAccessFile");
                        randomAccessFile3 = null;
                    }
                    randomAccessFile3.write(this.f, this.g + i, iMin);
                    i += iMin;
                }
            } else {
                RandomAccessFile randomAccessFile4 = C25124zm2.this.e;
                if (randomAccessFile4 == null) {
                    AbstractC13042fc3.y("randomAccessFile");
                } else {
                    randomAccessFile2 = randomAccessFile4;
                }
                randomAccessFile2.write(this.f, this.g, this.e);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C25124zm2(long j, String str, AbstractC13778go1 abstractC13778go1, SA2 sa2) {
        AbstractC13042fc3.i(str, "fileDescriptor");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(sa2, "randomAccessFileGenerator");
        this.a = j;
        this.b = str;
        this.c = abstractC13778go1;
        this.d = sa2;
        this.f = AbstractC20899sn4.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile d(long j, String str, boolean z, boolean z2) throws IOException {
        AbstractC13042fc3.i(str, "$fileDescriptor");
        g.a(j, str, z, z2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rws");
        if (randomAccessFile.length() != j) {
            randomAccessFile.setLength(j);
        }
        return randomAccessFile;
    }

    private final Object f(int i, byte[] bArr, int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new e(i, i3, bArr, i2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22754vm2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C25124zm2.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.zm2$c r0 = (ir.nasim.C25124zm2.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.zm2$c r0 = new ir.nasim.zm2$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r0 = r0.a
            ir.nasim.zm2 r0 = (ir.nasim.C25124zm2) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.qn4 r6 = r5.f
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r0 = r6.a(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            java.io.RandomAccessFile r6 = r0.e     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
            java.lang.String r2 = "randomAccessFile"
            if (r6 != 0) goto L5f
            ir.nasim.AbstractC13042fc3.y(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
            r6 = r4
            goto L5f
        L59:
            r6 = move-exception
            goto L82
        L5b:
            r6 = move-exception
            goto L74
        L5d:
            r6 = move-exception
            goto L81
        L5f:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
            if (r6 == 0) goto L68
            r6.sync()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
        L68:
            java.io.RandomAccessFile r6 = r0.e     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
            if (r6 != 0) goto L70
            ir.nasim.AbstractC13042fc3.y(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
            r6 = r4
        L70:
            r6.close()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b java.util.concurrent.CancellationException -> L5d
            goto L7b
        L74:
            java.lang.String r0 = "FileSystemOutputImpl"
            java.lang.String r2 = "Failed to close the file."
            ir.nasim.C19406qI3.c(r0, r2, r6)     // Catch: java.lang.Throwable -> L59
        L7b:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L59
            r1.e(r4)
            return r6
        L81:
            throw r6     // Catch: java.lang.Throwable -> L59
        L82:
            r1.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C25124zm2.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC23940xm2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(int r11, byte[] r12, int r13, int r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C25124zm2.b(int, byte[], int, int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC22754vm2
    public InterfaceC23350wm2 init() {
        InterfaceC23350wm2 cVar;
        try {
            this.e = (RandomAccessFile) this.d.invoke();
            return null;
        } catch (FileNotFoundException e2) {
            cVar = new InterfaceC23350wm2.a(e2);
            return cVar;
        } catch (SecurityException e3) {
            cVar = new InterfaceC23350wm2.b(e3);
            return cVar;
        } catch (Exception e4) {
            cVar = new InterfaceC23350wm2.c(e4);
            return cVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C25124zm2(final long j, final String str, final boolean z, final boolean z2, AbstractC13778go1 abstractC13778go1) {
        this(j, str, abstractC13778go1, new SA2() { // from class: ir.nasim.ym2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C25124zm2.d(j, str, z, z2);
            }
        });
        AbstractC13042fc3.i(str, "fileDescriptor");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
    }
}
