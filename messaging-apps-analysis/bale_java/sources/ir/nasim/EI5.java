package ir.nasim;

import ir.nasim.C24949zU1;
import ir.nasim.InterfaceC21332tU1;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;

/* loaded from: classes2.dex */
public final class EI5 implements InterfaceC21332tU1 {
    public static final a e = new a(null);
    private final long a;
    private final Path b;
    private final FileSystem c;
    private final C24949zU1 d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b implements InterfaceC21332tU1.b {
        private final C24949zU1.b a;

        public b(C24949zU1.b bVar) {
            this.a = bVar;
        }

        @Override // ir.nasim.InterfaceC21332tU1.b
        public void abort() {
            this.a.a();
        }

        @Override // ir.nasim.InterfaceC21332tU1.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a() {
            C24949zU1.d dVarC = this.a.c();
            if (dVarC != null) {
                return new c(dVarC);
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC21332tU1.b
        public Path getData() {
            return this.a.f(1);
        }

        @Override // ir.nasim.InterfaceC21332tU1.b
        public Path o() {
            return this.a.f(0);
        }
    }

    private static final class c implements InterfaceC21332tU1.c {
        private final C24949zU1.d a;

        public c(C24949zU1.d dVar) {
            this.a = dVar;
        }

        @Override // ir.nasim.InterfaceC21332tU1.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b m1() {
            C24949zU1.b bVarA = this.a.a();
            if (bVarA != null) {
                return new b(bVarA);
            }
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // ir.nasim.InterfaceC21332tU1.c
        public Path getData() {
            return this.a.b(1);
        }

        @Override // ir.nasim.InterfaceC21332tU1.c
        public Path o() {
            return this.a.b(0);
        }
    }

    public EI5(long j, Path path, FileSystem fileSystem, AbstractC13778go1 abstractC13778go1) {
        this.a = j;
        this.b = path;
        this.c = fileSystem;
        this.d = new C24949zU1(c(), d(), abstractC13778go1, e(), 1, 2);
    }

    private final String f(String str) {
        return ByteString.INSTANCE.encodeUtf8(str).sha256().hex();
    }

    @Override // ir.nasim.InterfaceC21332tU1
    public InterfaceC21332tU1.b a(String str) {
        C24949zU1.b bVarG = this.d.G(f(str));
        if (bVarG != null) {
            return new b(bVarG);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC21332tU1
    public InterfaceC21332tU1.c b(String str) {
        C24949zU1.d dVarH = this.d.H(f(str));
        if (dVarH != null) {
            return new c(dVarH);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC21332tU1
    public FileSystem c() {
        return this.c;
    }

    public Path d() {
        return this.b;
    }

    public long e() {
        return this.a;
    }
}
