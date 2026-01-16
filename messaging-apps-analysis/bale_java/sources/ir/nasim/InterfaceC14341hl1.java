package ir.nasim;

import ai.bale.proto.FilesStruct$FastThumb;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.hl1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC14341hl1 {

    /* renamed from: ir.nasim.hl1$a */
    public static final class a implements InterfaceC14341hl1 {
        private final FilesStruct$FastThumb a;
        private final T74 b;
        private final String c;
        private final C14733iO2 d;
        private final FileReference e;
        private final InterfaceC4557Fq2 f;

        public a(FilesStruct$FastThumb filesStruct$FastThumb, T74 t74, String str, C14733iO2 c14733iO2, FileReference fileReference, InterfaceC4557Fq2 interfaceC4557Fq2) {
            AbstractC13042fc3.i(t74, "messageId");
            AbstractC13042fc3.i(str, "detail");
            AbstractC13042fc3.i(c14733iO2, "apiGroup");
            AbstractC13042fc3.i(interfaceC4557Fq2, "downloadState");
            this.a = filesStruct$FastThumb;
            this.b = t74;
            this.c = str;
            this.d = c14733iO2;
            this.e = fileReference;
            this.f = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public String a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public C14733iO2 c() {
            return this.d;
        }

        public final InterfaceC4557Fq2 d() {
            return this.f;
        }

        public final FilesStruct$FastThumb e() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f);
        }

        public int hashCode() {
            FilesStruct$FastThumb filesStruct$FastThumb = this.a;
            int iHashCode = (((((((filesStruct$FastThumb == null ? 0 : filesStruct$FastThumb.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            FileReference fileReference = this.e;
            return ((iHashCode + (fileReference != null ? fileReference.hashCode() : 0)) * 31) + this.f.hashCode();
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public T74 l() {
            return this.b;
        }

        public String toString() {
            return "PhotoResult(fastThumb=" + this.a + ", messageId=" + this.b + ", detail=" + this.c + ", apiGroup=" + this.d + ", fileReference=" + this.e + ", downloadState=" + this.f + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.hl1$b */
    public static final class b implements InterfaceC14341hl1 {
        private final T74 a;
        private final String b;
        private final C14733iO2 c;

        public b(T74 t74, String str, C14733iO2 c14733iO2) {
            AbstractC13042fc3.i(t74, "messageId");
            AbstractC13042fc3.i(str, "detail");
            AbstractC13042fc3.i(c14733iO2, "apiGroup");
            this.a = t74;
            this.b = str;
            this.c = c14733iO2;
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public C14733iO2 c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public T74 l() {
            return this.a;
        }

        public String toString() {
            return "TextResult(messageId=" + this.a + ", detail=" + this.b + ", apiGroup=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.hl1$c */
    public static final class c implements InterfaceC14341hl1 {
        private final FilesStruct$FastThumb a;
        private final T74 b;
        private final String c;
        private final C14733iO2 d;
        private final InterfaceC10258bL6 e;

        public c(FilesStruct$FastThumb filesStruct$FastThumb, T74 t74, String str, C14733iO2 c14733iO2, InterfaceC10258bL6 interfaceC10258bL6) {
            AbstractC13042fc3.i(t74, "messageId");
            AbstractC13042fc3.i(str, "detail");
            AbstractC13042fc3.i(c14733iO2, "apiGroup");
            this.a = filesStruct$FastThumb;
            this.b = t74;
            this.c = str;
            this.d = c14733iO2;
            this.e = interfaceC10258bL6;
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public String a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public C14733iO2 c() {
            return this.d;
        }

        public final InterfaceC10258bL6 d() {
            return this.e;
        }

        public final FilesStruct$FastThumb e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e);
        }

        public int hashCode() {
            FilesStruct$FastThumb filesStruct$FastThumb = this.a;
            int iHashCode = (((((((filesStruct$FastThumb == null ? 0 : filesStruct$FastThumb.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            InterfaceC10258bL6 interfaceC10258bL6 = this.e;
            return iHashCode + (interfaceC10258bL6 != null ? interfaceC10258bL6.hashCode() : 0);
        }

        @Override // ir.nasim.InterfaceC14341hl1
        public T74 l() {
            return this.b;
        }

        public String toString() {
            return "VideoResult(fastThumb=" + this.a + ", messageId=" + this.b + ", detail=" + this.c + ", apiGroup=" + this.d + ", downloadState=" + this.e + Separators.RPAREN;
        }
    }

    String a();

    default String b() {
        long jD = l().d();
        int peerId = l().e().getPeerId();
        long jF = l().f();
        StringBuilder sb = new StringBuilder();
        sb.append(jD);
        sb.append(peerId);
        sb.append(jF);
        return sb.toString();
    }

    C14733iO2 c();

    T74 l();
}
