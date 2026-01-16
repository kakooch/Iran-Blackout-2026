package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.jj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15520jj2 {

    /* renamed from: ir.nasim.jj2$a */
    public static final class a {
        private final long a;
        private final long b;
        private final d c;

        public a(long j, long j2, d dVar) {
            AbstractC13042fc3.i(dVar, "mediaMessage");
            this.a = j;
            this.b = j2;
            this.c = dVar;
        }

        public final long a() {
            return this.b;
        }

        public final d b() {
            return this.c;
        }

        public final long c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AlbumItem(rid=" + this.a + ", date=" + this.b + ", mediaMessage=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.jj2$d */
    public static abstract class d extends AbstractC15520jj2 {
        private final byte[] a;
        private final String b;
        private final FileReference c;
        private final int d;
        private final int e;
        private final int f;

        public /* synthetic */ d(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3, ED1 ed1) {
            this(bArr, str, fileReference, i, i2, i3);
        }

        public abstract String c();

        public abstract FileReference d();

        public abstract int e();

        public abstract byte[] f();

        public abstract int g();

        public /* synthetic */ d(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3, int i4, ED1 ed1) {
            this(bArr, str, fileReference, i, i2, (i4 & 32) != 0 ? 0 : i3, null);
        }

        private d(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3) {
            super(null);
            this.a = bArr;
            this.b = str;
            this.c = fileReference;
            this.d = i;
            this.e = i2;
            this.f = i3;
        }
    }

    /* renamed from: ir.nasim.jj2$g */
    public static final class g extends AbstractC15520jj2 {
        public static final g a = new g();
        private static final int b = EnumC12502ej2.b.j();
        private static final String c = "unsupported";

        private g() {
            super(null);
        }

        @Override // ir.nasim.AbstractC15520jj2
        public int a() {
            return b;
        }

        @Override // ir.nasim.AbstractC15520jj2
        public String b() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof g);
        }

        public int hashCode() {
            return 157134499;
        }

        public String toString() {
            return "UnknownMessage";
        }
    }

    private AbstractC15520jj2() {
    }

    public abstract int a();

    public abstract String b();

    public /* synthetic */ AbstractC15520jj2(ED1 ed1) {
        this();
    }

    /* renamed from: ir.nasim.jj2$b */
    public static final class b extends AbstractC15520jj2 {
        private final List a;
        private final int b;
        private final String c;

        public /* synthetic */ b(List list, int i, String str, int i2, ED1 ed1) {
            this(list, (i2 & 2) != 0 ? EnumC12502ej2.f.j() : i, (i2 & 4) != 0 ? "album" : str);
        }

        @Override // ir.nasim.AbstractC15520jj2
        public int a() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC15520jj2
        public String b() {
            return this.c;
        }

        public final List c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AlbumMessage(albumItems=" + this.a + ", holderType=" + this.b + ", type=" + this.c + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, int i, String str) {
            super(null);
            AbstractC13042fc3.i(list, "albumItems");
            AbstractC13042fc3.i(str, "type");
            this.a = list;
            this.b = i;
            this.c = str;
        }
    }

    /* renamed from: ir.nasim.jj2$c */
    public static final class c extends e {
        private final int n;
        private final String o;

        public /* synthetic */ c(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3, String str2, int i4, ED1 ed1) {
            this(bArr, str, fileReference, i, i2, (i4 & 32) != 0 ? EnumC12502ej2.g.j() : i3, (i4 & 64) != 0 ? "gif" : str2);
        }

        @Override // ir.nasim.AbstractC15520jj2.e, ir.nasim.AbstractC15520jj2
        public int a() {
            return this.n;
        }

        @Override // ir.nasim.AbstractC15520jj2.e, ir.nasim.AbstractC15520jj2
        public String b() {
            return this.o;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3, String str2) {
            super(bArr, str, fileReference, i, i2, 0, null, 96, null);
            AbstractC13042fc3.i(bArr, "thumbnail");
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(str2, "type");
            this.n = i3;
            this.o = str2;
        }
    }

    /* renamed from: ir.nasim.jj2$e */
    public static class e extends d {
        private final byte[] g;
        private final String h;
        private final FileReference i;
        private final int j;
        private final int k;
        private final int l;
        private final String m;

        public /* synthetic */ e(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3, String str2, int i4, ED1 ed1) {
            this(bArr, str, fileReference, i, i2, (i4 & 32) != 0 ? EnumC12502ej2.d.j() : i3, (i4 & 64) != 0 ? "photo" : str2);
        }

        @Override // ir.nasim.AbstractC15520jj2
        public int a() {
            return this.l;
        }

        @Override // ir.nasim.AbstractC15520jj2
        public String b() {
            return this.m;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public String c() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public FileReference d() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public int e() {
            return this.j;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public byte[] f() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public int g() {
            return this.k;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(byte[] bArr, String str, FileReference fileReference, int i, int i2, int i3, String str2) {
            super(bArr, str, fileReference, i, i2, 0, 32, null);
            AbstractC13042fc3.i(bArr, "thumbnail");
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(str2, "type");
            this.g = bArr;
            this.h = str;
            this.i = fileReference;
            this.j = i;
            this.k = i2;
            this.l = i3;
            this.m = str2;
        }
    }

    /* renamed from: ir.nasim.jj2$f */
    public static final class f extends AbstractC15520jj2 {
        private final String a;
        private final List b;
        private final int c;
        private final String d;

        public /* synthetic */ f(String str, List list, int i, String str2, int i2, ED1 ed1) {
            this(str, list, (i2 & 4) != 0 ? EnumC12502ej2.c.j() : i, (i2 & 8) != 0 ? ParameterNames.TEXT : str2);
        }

        @Override // ir.nasim.AbstractC15520jj2
        public int a() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC15520jj2
        public String b() {
            return this.d;
        }

        public final String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC13042fc3.d(this.a, fVar.a) && AbstractC13042fc3.d(this.b, fVar.b) && this.c == fVar.c && AbstractC13042fc3.d(this.d, fVar.d);
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "TextMessage(text=" + this.a + ", mentions=" + this.b + ", holderType=" + this.c + ", type=" + this.d + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, List list, int i, String str2) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(list, "mentions");
            AbstractC13042fc3.i(str2, "type");
            this.a = str;
            this.b = list;
            this.c = i;
            this.d = str2;
        }
    }

    /* renamed from: ir.nasim.jj2$h */
    public static final class h extends d {
        private final byte[] g;
        private final FileReference h;
        private final String i;
        private final String j;
        private final int k;
        private final int l;
        private final int m;
        private final int n;
        private final String o;

        public /* synthetic */ h(byte[] bArr, FileReference fileReference, String str, String str2, int i, int i2, int i3, int i4, String str3, int i5, ED1 ed1) {
            this(bArr, fileReference, str, str2, i, i2, i3, (i5 & 128) != 0 ? EnumC12502ej2.e.j() : i4, (i5 & 256) != 0 ? MediaStreamTrack.VIDEO_TRACK_KIND : str3);
        }

        @Override // ir.nasim.AbstractC15520jj2
        public int a() {
            return this.n;
        }

        @Override // ir.nasim.AbstractC15520jj2
        public String b() {
            return this.o;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public String c() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public FileReference d() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public int e() {
            return this.k;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public byte[] f() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC15520jj2.d
        public int g() {
            return this.l;
        }

        public final int h() {
            return this.m;
        }

        public final String i() {
            return this.j;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(byte[] bArr, FileReference fileReference, String str, String str2, int i, int i2, int i3, int i4, String str3) {
            super(bArr, str, fileReference, i, i2, 0, 32, null);
            AbstractC13042fc3.i(bArr, "thumbnail");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(str3, "type");
            this.g = bArr;
            this.h = fileReference;
            this.i = str;
            this.j = str2;
            this.k = i;
            this.l = i2;
            this.m = i3;
            this.n = i4;
            this.o = str3;
        }
    }
}
