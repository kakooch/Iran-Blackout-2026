package ir.nasim;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.AccessDeniedException;

/* renamed from: ir.nasim.Fm2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4521Fm2 implements InterfaceC23384wp6 {
    private final File a;
    private final EnumC9334Zm2 b;
    private final UA2 c;
    private final UA2 d;
    private final InterfaceC14603iB2 e;
    private final int f;

    /* renamed from: ir.nasim.Fm2$a */
    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file);
            AbstractC13042fc3.i(file, "rootDir");
        }
    }

    /* renamed from: ir.nasim.Fm2$b */
    private final class b extends Y0 {
        private final ArrayDeque c;

        /* renamed from: ir.nasim.Fm2$b$a */
        private final class a extends a {
            private boolean b;
            private File[] c;
            private int d;
            private boolean e;
            final /* synthetic */ b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File file) {
                super(file);
                AbstractC13042fc3.i(file, "rootDir");
                this.f = bVar;
            }

            @Override // ir.nasim.C4521Fm2.c
            public File b() {
                if (!this.e && this.c == null) {
                    UA2 ua2 = C4521Fm2.this.c;
                    if (ua2 != null && !((Boolean) ua2.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = a().listFiles();
                    this.c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        InterfaceC14603iB2 interfaceC14603iB2 = C4521Fm2.this.e;
                        if (interfaceC14603iB2 != null) {
                            interfaceC14603iB2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    AbstractC13042fc3.f(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.c;
                        AbstractC13042fc3.f(fileArr2);
                        int i2 = this.d;
                        this.d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.b) {
                    this.b = true;
                    return a();
                }
                UA2 ua22 = C4521Fm2.this.d;
                if (ua22 != null) {
                    ua22.invoke(a());
                }
                return null;
            }
        }

        /* renamed from: ir.nasim.Fm2$b$b, reason: collision with other inner class name */
        private final class C0375b extends c {
            private boolean b;
            final /* synthetic */ b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0375b(b bVar, File file) {
                super(file);
                AbstractC13042fc3.i(file, "rootFile");
                this.c = bVar;
            }

            @Override // ir.nasim.C4521Fm2.c
            public File b() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return a();
            }
        }

        /* renamed from: ir.nasim.Fm2$b$c */
        private final class c extends a {
            private boolean b;
            private File[] c;
            private int d;
            final /* synthetic */ b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                AbstractC13042fc3.i(file, "rootDir");
                this.e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // ir.nasim.C4521Fm2.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.b
                    r1 = 0
                    if (r0 != 0) goto L28
                    ir.nasim.Fm2$b r0 = r10.e
                    ir.nasim.Fm2 r0 = ir.nasim.C4521Fm2.this
                    ir.nasim.UA2 r0 = ir.nasim.C4521Fm2.e(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r10.b = r0
                    java.io.File r0 = r10.a()
                    return r0
                L28:
                    java.io.File[] r0 = r10.c
                    if (r0 == 0) goto L47
                    int r2 = r10.d
                    ir.nasim.AbstractC13042fc3.f(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    ir.nasim.Fm2$b r0 = r10.e
                    ir.nasim.Fm2 r0 = ir.nasim.C4521Fm2.this
                    ir.nasim.UA2 r0 = ir.nasim.C4521Fm2.g(r0)
                    if (r0 == 0) goto L46
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r10.c
                    if (r0 != 0) goto L93
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.c = r0
                    if (r0 != 0) goto L77
                    ir.nasim.Fm2$b r0 = r10.e
                    ir.nasim.Fm2 r0 = ir.nasim.C4521Fm2.this
                    ir.nasim.iB2 r0 = ir.nasim.C4521Fm2.f(r0)
                    if (r0 == 0) goto L77
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L77:
                    java.io.File[] r0 = r10.c
                    if (r0 == 0) goto L81
                    ir.nasim.AbstractC13042fc3.f(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L93
                L81:
                    ir.nasim.Fm2$b r0 = r10.e
                    ir.nasim.Fm2 r0 = ir.nasim.C4521Fm2.this
                    ir.nasim.UA2 r0 = ir.nasim.C4521Fm2.g(r0)
                    if (r0 == 0) goto L92
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L92:
                    return r1
                L93:
                    java.io.File[] r0 = r10.c
                    ir.nasim.AbstractC13042fc3.f(r0)
                    int r1 = r10.d
                    int r2 = r1 + 1
                    r10.d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4521Fm2.b.c.b():java.io.File");
            }
        }

        /* renamed from: ir.nasim.Fm2$b$d */
        public /* synthetic */ class d {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC9334Zm2.values().length];
                try {
                    iArr[EnumC9334Zm2.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC9334Zm2.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        public b() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.c = arrayDeque;
            if (C4521Fm2.this.a.isDirectory()) {
                arrayDeque.push(f(C4521Fm2.this.a));
            } else if (C4521Fm2.this.a.isFile()) {
                arrayDeque.push(new C0375b(this, C4521Fm2.this.a));
            } else {
                c();
            }
        }

        private final a f(File file) {
            int i = d.a[C4521Fm2.this.b.ordinal()];
            if (i == 1) {
                return new c(this, file);
            }
            if (i == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File g() {
            File fileB;
            while (true) {
                c cVar = (c) this.c.peek();
                if (cVar == null) {
                    return null;
                }
                fileB = cVar.b();
                if (fileB == null) {
                    this.c.pop();
                } else {
                    if (AbstractC13042fc3.d(fileB, cVar.a()) || !fileB.isDirectory() || this.c.size() >= C4521Fm2.this.f) {
                        break;
                    }
                    this.c.push(f(fileB));
                }
            }
            return fileB;
        }

        @Override // ir.nasim.Y0
        protected void b() {
            File fileG = g();
            if (fileG != null) {
                d(fileG);
            } else {
                c();
            }
        }
    }

    /* renamed from: ir.nasim.Fm2$c */
    private static abstract class c {
        private final File a;

        public c(File file) {
            AbstractC13042fc3.i(file, "root");
            this.a = file;
        }

        public final File a() {
            return this.a;
        }

        public abstract File b();
    }

    private C4521Fm2(File file, EnumC9334Zm2 enumC9334Zm2, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, int i) {
        this.a = file;
        this.b = enumC9334Zm2;
        this.c = ua2;
        this.d = ua22;
        this.e = interfaceC14603iB2;
        this.f = i;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new b();
    }

    /* synthetic */ C4521Fm2(File file, EnumC9334Zm2 enumC9334Zm2, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2, ED1 ed1) {
        this(file, (i2 & 2) != 0 ? EnumC9334Zm2.a : enumC9334Zm2, ua2, ua22, interfaceC14603iB2, (i2 & 32) != 0 ? Integer.MAX_VALUE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4521Fm2(File file, EnumC9334Zm2 enumC9334Zm2) {
        this(file, enumC9334Zm2, null, null, null, 0, 32, null);
        AbstractC13042fc3.i(file, "start");
        AbstractC13042fc3.i(enumC9334Zm2, "direction");
    }
}
