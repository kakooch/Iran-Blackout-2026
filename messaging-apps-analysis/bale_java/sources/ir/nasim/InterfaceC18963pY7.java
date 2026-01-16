package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.pY7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC18963pY7 extends Serializable {

    /* renamed from: ir.nasim.pY7$a */
    public static final class a implements InterfaceC18963pY7 {
        private final long a;
        private final long b;
        private final long c;
        private final String d;
        private final int e;
        private final long f;
        private final String g;
        private final String h;
        private final C15539jl1 i;
        private final InterfaceC19554qY7 j;
        private final byte[] k;

        public a(long j, long j2, long j3, String str, int i, long j4, String str2, String str3, C15539jl1 c15539jl1, InterfaceC19554qY7 interfaceC19554qY7, byte[] bArr) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(c15539jl1, "size");
            AbstractC13042fc3.i(interfaceC19554qY7, "source");
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = str;
            this.e = i;
            this.f = j4;
            this.g = str2;
            this.h = str3;
            this.i = c15539jl1;
            this.j = interfaceC19554qY7;
            this.k = bArr;
        }

        public String a() {
            return this.g;
        }

        public final long b() {
            return this.a;
        }

        public long c() {
            return this.f;
        }

        public String d() {
            return this.h;
        }

        public int e() {
            return this.e;
        }

        public C15539jl1 f() {
            return this.i;
        }

        public InterfaceC19554qY7 g() {
            return this.j;
        }

        public String getName() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC18963pY7
        public long h() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC18963pY7
        public long i() {
            return this.b;
        }

        public byte[] j() {
            return this.k;
        }
    }

    /* renamed from: ir.nasim.pY7$b */
    public static final class b implements InterfaceC18963pY7 {
        private final long a;
        private final long b;
        private final String c;
        private final int d;
        private final long e;
        private final String f;
        private final String g;
        private final C15539jl1 h;
        private final InterfaceC19554qY7 i;
        private final byte[] j;

        public b(long j, long j2, String str, int i, long j3, String str2, String str3, C15539jl1 c15539jl1, InterfaceC19554qY7 interfaceC19554qY7, byte[] bArr) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(c15539jl1, "size");
            AbstractC13042fc3.i(interfaceC19554qY7, "source");
            this.a = j;
            this.b = j2;
            this.c = str;
            this.d = i;
            this.e = j3;
            this.f = str2;
            this.g = str3;
            this.h = c15539jl1;
            this.i = interfaceC19554qY7;
            this.j = bArr;
        }

        public String a() {
            return this.f;
        }

        public long b() {
            return this.e;
        }

        public String c() {
            return this.g;
        }

        public int d() {
            return this.d;
        }

        public C15539jl1 e() {
            return this.h;
        }

        public InterfaceC19554qY7 f() {
            return this.i;
        }

        public byte[] g() {
            return this.j;
        }

        public String getName() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC18963pY7
        public long h() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC18963pY7
        public long i() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.pY7$c */
    public static final class c implements InterfaceC18963pY7 {
        private final long a;
        private final long b;
        private final long c;
        private final String d;
        private final int e;
        private final long f;
        private final String g;
        private final String h;
        private final C15539jl1 i;
        private final InterfaceC19554qY7 j;
        private final byte[] k;

        public c(long j, long j2, long j3, String str, int i, long j4, String str2, String str3, C15539jl1 c15539jl1, InterfaceC19554qY7 interfaceC19554qY7, byte[] bArr) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(c15539jl1, "size");
            AbstractC13042fc3.i(interfaceC19554qY7, "source");
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = str;
            this.e = i;
            this.f = j4;
            this.g = str2;
            this.h = str3;
            this.i = c15539jl1;
            this.j = interfaceC19554qY7;
            this.k = bArr;
        }

        public String a() {
            return this.g;
        }

        public final long b() {
            return this.a;
        }

        public long c() {
            return this.f;
        }

        public String d() {
            return this.h;
        }

        public int e() {
            return this.e;
        }

        public C15539jl1 f() {
            return this.i;
        }

        public InterfaceC19554qY7 g() {
            return this.j;
        }

        public String getName() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC18963pY7
        public long h() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC18963pY7
        public long i() {
            return this.b;
        }

        public byte[] j() {
            return this.k;
        }
    }

    long h();

    long i();
}
