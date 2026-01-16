package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.MW1;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.nW1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17757nW1 {

    /* renamed from: ir.nasim.nW1$a */
    public static final class a extends AbstractC17757nW1 {
        public static final C1413a i = new C1413a(null);
        public static final int j = 8;
        private static EnumC18310oS k = EnumC18310oS.a;
        private final MW1 a;
        private final T74 b;
        private final Spannable c;
        private final Spannable d;
        private final boolean e;
        private final VL f;
        private final boolean g;
        private final EnumC18310oS h;

        /* renamed from: ir.nasim.nW1$a$a, reason: collision with other inner class name */
        public static final class C1413a {
            private C1413a() {
            }

            public final void a(EnumC18310oS enumC18310oS) {
                AbstractC13042fc3.i(enumC18310oS, "<set-?>");
                a.k = enumC18310oS;
            }

            public /* synthetic */ C1413a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MW1 mw1, T74 t74, Spannable spannable, Spannable spannable2, boolean z, VL vl, boolean z2) {
            super(null);
            AbstractC13042fc3.i(mw1, "documentState");
            AbstractC13042fc3.i(t74, "messageUniqueId");
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            this.a = mw1;
            this.b = t74;
            this.c = spannable;
            this.d = spannable2;
            this.e = z;
            this.f = vl;
            this.g = z2;
            this.h = z ? b.e.a() : k;
        }

        @Override // ir.nasim.AbstractC17757nW1
        public EnumC18310oS a() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC17757nW1
        public MW1 b() {
            return this.a;
        }

        public final Spannable d() {
            return this.d;
        }

        public final VL e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f) && this.g == aVar.g;
        }

        public final T74 f() {
            return this.b;
        }

        public final boolean g() {
            return this.g;
        }

        public final Spannable h() {
            return this.c;
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Spannable spannable = this.c;
            int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
            Spannable spannable2 = this.d;
            return ((((((iHashCode2 + (spannable2 != null ? spannable2.hashCode() : 0)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g);
        }

        public final boolean i() {
            return this.e;
        }

        public String toString() {
            MW1 mw1 = this.a;
            T74 t74 = this.b;
            Spannable spannable = this.c;
            Spannable spannable2 = this.d;
            return "Audio(documentState=" + mw1 + ", messageUniqueId=" + t74 + ", trackName=" + ((Object) spannable) + ", artistName=" + ((Object) spannable2) + ", isMusic=" + this.e + ", audio=" + this.f + ", needResetAudioMetaData=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.nW1$b */
    public static class b extends AbstractC17757nW1 {
        public static final a e = new a(null);
        public static final int f = 8;
        private static EnumC18310oS g = EnumC18310oS.a;
        private final MW1 a;
        private final Spannable b;
        private final Spannable c;
        private final EnumC18310oS d;

        /* renamed from: ir.nasim.nW1$b$a */
        public static final class a {
            private a() {
            }

            public final EnumC18310oS a() {
                return b.g;
            }

            public final void b(EnumC18310oS enumC18310oS) {
                AbstractC13042fc3.i(enumC18310oS, "<set-?>");
                b.g = enumC18310oS;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MW1 mw1, Spannable spannable, Spannable spannable2) {
            super(null);
            AbstractC13042fc3.i(mw1, "documentState");
            AbstractC13042fc3.i(spannable, "name");
            AbstractC13042fc3.i(spannable2, "mimeType");
            this.a = mw1;
            this.b = spannable;
            this.c = spannable2;
            this.d = g;
        }

        @Override // ir.nasim.AbstractC17757nW1
        public EnumC18310oS a() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC17757nW1
        public MW1 b() {
            return this.a;
        }

        public final Spannable e() {
            return this.c;
        }

        public final Spannable f() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.nW1$c */
    public static abstract class c extends AbstractC17757nW1 {

        /* renamed from: ir.nasim.nW1$c$a */
        public static final class a extends c {
            public static final C1414a f = new C1414a(null);
            public static final int g = 8;
            private static EnumC18310oS h = EnumC18310oS.a;
            private final MW1 a;
            private final XV4 b;
            private final byte[] c;
            private final String d;
            private final EnumC18310oS e;

            /* renamed from: ir.nasim.nW1$c$a$a, reason: collision with other inner class name */
            public static final class C1414a {
                private C1414a() {
                }

                public final void a(EnumC18310oS enumC18310oS) {
                    AbstractC13042fc3.i(enumC18310oS, "<set-?>");
                    a.h = enumC18310oS;
                }

                public /* synthetic */ C1414a(ED1 ed1) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(MW1 mw1, XV4 xv4, byte[] bArr, String str) {
                super(null);
                AbstractC13042fc3.i(mw1, "documentState");
                AbstractC13042fc3.i(xv4, "originalSize");
                AbstractC13042fc3.i(str, "mimeType");
                this.a = mw1;
                this.b = xv4;
                this.c = bArr;
                this.d = str;
                this.e = h;
            }

            @Override // ir.nasim.AbstractC17757nW1
            public EnumC18310oS a() {
                return this.e;
            }

            @Override // ir.nasim.AbstractC17757nW1
            public MW1 b() {
                return this.a;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public String c() {
                return this.d;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public XV4 d() {
                return this.b;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public byte[] e() {
                return this.c;
            }
        }

        /* renamed from: ir.nasim.nW1$c$c, reason: collision with other inner class name */
        public static abstract class AbstractC1416c extends c {
            private final MW1.b a;
            private final XV4 b;
            private final String c;

            /* renamed from: ir.nasim.nW1$c$c$a */
            public static final class a extends AbstractC1416c {
                private final byte[] d;
                private final String e;
                private final EnumC18310oS f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(MW1.b bVar, XV4 xv4, byte[] bArr, String str) {
                    super(bVar, xv4, null, 4, null);
                    AbstractC13042fc3.i(bVar, "documentState");
                    AbstractC13042fc3.i(xv4, "originalSize");
                    AbstractC13042fc3.i(str, "cacheKey");
                    this.d = bArr;
                    this.e = str;
                    this.f = EnumC18310oS.d;
                }

                @Override // ir.nasim.AbstractC17757nW1
                public EnumC18310oS a() {
                    return this.f;
                }

                @Override // ir.nasim.AbstractC17757nW1.c
                public byte[] e() {
                    return this.d;
                }

                public final String g() {
                    return this.e;
                }
            }

            /* renamed from: ir.nasim.nW1$c$c$b */
            public static final class b extends AbstractC1416c {
                private final Integer d;
                private final Long e;
                private final byte[] f;
                private final EnumC18310oS g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(MW1.b bVar, XV4 xv4, Integer num, Long l) {
                    super(bVar, xv4, null, 4, null);
                    AbstractC13042fc3.i(bVar, "documentState");
                    AbstractC13042fc3.i(xv4, "originalSize");
                    this.d = num;
                    this.e = l;
                    this.g = EnumC18310oS.d;
                }

                @Override // ir.nasim.AbstractC17757nW1
                public EnumC18310oS a() {
                    return this.g;
                }

                @Override // ir.nasim.AbstractC17757nW1.c
                public byte[] e() {
                    return this.f;
                }

                public final Integer g() {
                    return this.d;
                }
            }

            public /* synthetic */ AbstractC1416c(MW1.b bVar, XV4 xv4, String str, ED1 ed1) {
                this(bVar, xv4, str);
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public String c() {
                return this.c;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public XV4 d() {
                return this.b;
            }

            @Override // ir.nasim.AbstractC17757nW1
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public MW1.b b() {
                return this.a;
            }

            public /* synthetic */ AbstractC1416c(MW1.b bVar, XV4 xv4, String str, int i, ED1 ed1) {
                this(bVar, xv4, (i & 4) != 0 ? "" : str, null);
            }

            private AbstractC1416c(MW1.b bVar, XV4 xv4, String str) {
                super(null);
                this.a = bVar;
                this.b = xv4;
                this.c = str;
            }
        }

        /* renamed from: ir.nasim.nW1$c$d */
        public static class d extends c {
            public static final a g = new a(null);
            public static final int h = 8;
            private static EnumC18310oS i = EnumC18310oS.a;
            private final MW1 a;
            private final XV4 b;
            private final byte[] c;
            private final String d;
            private final int e;
            private final EnumC18310oS f;

            /* renamed from: ir.nasim.nW1$c$d$a */
            public static final class a {
                private a() {
                }

                public final void a(EnumC18310oS enumC18310oS) {
                    AbstractC13042fc3.i(enumC18310oS, "<set-?>");
                    d.i = enumC18310oS;
                }

                public /* synthetic */ a(ED1 ed1) {
                    this();
                }
            }

            /* renamed from: ir.nasim.nW1$c$d$b */
            public static final class b extends d {
                private final MW1.a j;
                private final Spannable k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(MW1.a aVar, XV4 xv4, byte[] bArr, String str, int i, Spannable spannable) {
                    super(aVar, xv4, bArr, str, i);
                    AbstractC13042fc3.i(aVar, "documentState");
                    AbstractC13042fc3.i(xv4, "originalSize");
                    AbstractC13042fc3.i(str, "mimeType");
                    AbstractC13042fc3.i(spannable, "description");
                    this.j = aVar;
                    this.k = spannable;
                }

                public final Spannable h() {
                    return this.k;
                }

                @Override // ir.nasim.AbstractC17757nW1.c.d, ir.nasim.AbstractC17757nW1
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public MW1.a b() {
                    return this.j;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(MW1 mw1, XV4 xv4, byte[] bArr, String str, int i2) {
                super(null);
                AbstractC13042fc3.i(mw1, "documentState");
                AbstractC13042fc3.i(xv4, "originalSize");
                AbstractC13042fc3.i(str, "mimeType");
                this.a = mw1;
                this.b = xv4;
                this.c = bArr;
                this.d = str;
                this.e = i2;
                this.f = i;
            }

            @Override // ir.nasim.AbstractC17757nW1
            public EnumC18310oS a() {
                return this.f;
            }

            @Override // ir.nasim.AbstractC17757nW1
            public MW1 b() {
                return this.a;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public String c() {
                return this.d;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public XV4 d() {
                return this.b;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public byte[] e() {
                return this.c;
            }

            public final int g() {
                return this.e;
            }
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }

        public abstract String c();

        public abstract XV4 d();

        public abstract byte[] e();

        /* renamed from: ir.nasim.nW1$c$b */
        public static class b extends c {
            public static final a f = new a(null);
            public static final int g = 8;
            private static EnumC18310oS h = EnumC18310oS.a;
            private final MW1 a;
            private final XV4 b;
            private final byte[] c;
            private final String d;
            private EnumC18310oS e;

            /* renamed from: ir.nasim.nW1$c$b$a */
            public static final class a {
                private a() {
                }

                public final void a(EnumC18310oS enumC18310oS) {
                    AbstractC13042fc3.i(enumC18310oS, "<set-?>");
                    b.h = enumC18310oS;
                }

                public /* synthetic */ a(ED1 ed1) {
                    this();
                }
            }

            /* renamed from: ir.nasim.nW1$c$b$b, reason: collision with other inner class name */
            public static final class C1415b extends b {
                private final Drawable i;
                private final int j;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C1415b(Drawable drawable, int i, MW1 mw1, XV4 xv4) {
                    super(mw1, xv4, null, "", null, 16, null);
                    AbstractC13042fc3.i(drawable, "drawable");
                    AbstractC13042fc3.i(mw1, "documentState");
                    AbstractC13042fc3.i(xv4, "originalSize");
                    this.i = drawable;
                    this.j = i;
                }

                public final int g() {
                    return this.j;
                }

                public final Drawable h() {
                    return this.i;
                }
            }

            public /* synthetic */ b(MW1 mw1, XV4 xv4, byte[] bArr, String str, EnumC18310oS enumC18310oS, int i, ED1 ed1) {
                this(mw1, xv4, bArr, str, (i & 16) != 0 ? h : enumC18310oS);
            }

            @Override // ir.nasim.AbstractC17757nW1
            public EnumC18310oS a() {
                return this.e;
            }

            @Override // ir.nasim.AbstractC17757nW1
            public MW1 b() {
                return this.a;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public String c() {
                return this.d;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public XV4 d() {
                return this.b;
            }

            @Override // ir.nasim.AbstractC17757nW1.c
            public byte[] e() {
                return this.c;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(MW1 mw1, XV4 xv4, byte[] bArr, String str, EnumC18310oS enumC18310oS) {
                super(null);
                AbstractC13042fc3.i(mw1, "documentState");
                AbstractC13042fc3.i(xv4, "originalSize");
                AbstractC13042fc3.i(str, "mimeType");
                AbstractC13042fc3.i(enumC18310oS, "autoDownload");
                this.a = mw1;
                this.b = xv4;
                this.c = bArr;
                this.d = str;
                this.e = enumC18310oS;
            }
        }

        private c() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.nW1$d */
    public static final class d extends b {
        public static final a i = new a(null);
        public static final int j = 8;
        private static final InterfaceC9173Yu3 k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oW1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC17757nW1.d.j();
            }
        });
        private final byte[] h;

        /* renamed from: ir.nasim.nW1$d$a */
        public static final class a {
            private a() {
            }

            public final List a() {
                return (List) d.k.getValue();
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MW1 mw1, Spannable spannable, Spannable spannable2, byte[] bArr) {
            super(mw1, spannable, spannable2);
            AbstractC13042fc3.i(mw1, "documentState");
            AbstractC13042fc3.i(spannable, "name");
            AbstractC13042fc3.i(spannable2, "mimeType");
            this.h = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List j() {
            return AbstractC10360bX0.p("gif", "jpeg", "jpg", "png", "svg", "webp");
        }

        public final byte[] i() {
            return this.h;
        }
    }

    private AbstractC17757nW1() {
    }

    public abstract EnumC18310oS a();

    public abstract MW1 b();

    public /* synthetic */ AbstractC17757nW1(ED1 ed1) {
        this();
    }
}
