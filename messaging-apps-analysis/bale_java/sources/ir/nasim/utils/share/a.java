package ir.nasim.utils.share;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C19247q16;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.TF2;
import ir.nasim.UA2;
import ir.nasim.utils.share.SharedContent;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public final class a {
    private static final C1646a e = new C1646a(null);
    public static final int f = 8;
    private final Context a;
    private final AbstractC13778go1 b;
    private final C19247q16 c;
    private final TF2 d;

    /* renamed from: ir.nasim.utils.share.a$a, reason: collision with other inner class name */
    private static final class C1646a {
        private C1646a() {
        }

        public /* synthetic */ C1646a(ED1 ed1) {
            this();
        }
    }

    private interface b {

        /* renamed from: ir.nasim.utils.share.a$b$a, reason: collision with other inner class name */
        public static final class C1647a implements b {
            private final Uri a;
            private final String b;
            private final CharSequence c;
            private final String d;
            private final c e;

            public C1647a(Uri uri, String str, CharSequence charSequence, String str2, c cVar) {
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(str, "filePath");
                AbstractC13042fc3.i(str2, "mimeType");
                AbstractC13042fc3.i(cVar, "contentType");
                this.a = uri;
                this.b = str;
                this.c = charSequence;
                this.d = str2;
                this.e = cVar;
            }

            public final CharSequence a() {
                return this.c;
            }

            public final c b() {
                return this.e;
            }

            public final String c() {
                return this.b;
            }

            public String d() {
                return this.d;
            }

            public final Uri e() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C1647a)) {
                    return false;
                }
                C1647a c1647a = (C1647a) obj;
                return AbstractC13042fc3.d(this.a, c1647a.a) && AbstractC13042fc3.d(this.b, c1647a.b) && AbstractC13042fc3.d(this.c, c1647a.c) && AbstractC13042fc3.d(this.d, c1647a.d) && this.e == c1647a.e;
            }

            public int hashCode() {
                int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
                CharSequence charSequence = this.c;
                return ((((iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
            }

            public String toString() {
                Uri uri = this.a;
                String str = this.b;
                CharSequence charSequence = this.c;
                return "Stream(uri=" + uri + ", filePath=" + str + ", caption=" + ((Object) charSequence) + ", mimeType=" + this.d + ", contentType=" + this.e + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.utils.share.a$b$b, reason: collision with other inner class name */
        public static final class C1648b implements b {
            private final CharSequence a;

            public C1648b(CharSequence charSequence) {
                AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
                this.a = charSequence;
            }

            public final CharSequence a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1648b) && AbstractC13042fc3.d(this.a, ((C1648b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Text(text=" + ((Object) this.a) + Separators.RPAREN;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class c {
        public static final C1649a b;
        public static final c c = new c("AUDIO", 0, "audio/");
        public static final c d = new c("GIF", 1, "image/gif");
        public static final c e = new c("IMAGE", 2, "image/");
        public static final c f = new c("VIDEO", 3, "video/");
        public static final c g = new c("FILE", 4, "*/");
        private static final /* synthetic */ c[] h;
        private static final /* synthetic */ F92 i;
        private final String a;

        /* renamed from: ir.nasim.utils.share.a$c$a, reason: collision with other inner class name */
        public static final class C1649a {
            private C1649a() {
            }

            public final c a(String str) {
                Object obj;
                if (str == null) {
                    return c.g;
                }
                Iterator<E> it = c.p().iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (AbstractC20153rZ6.S(str, ((c) next).q(), false, 2, null)) {
                        obj = next;
                        break;
                    }
                }
                c cVar = (c) obj;
                return cVar == null ? c.g : cVar;
            }

            public /* synthetic */ C1649a(ED1 ed1) {
                this();
            }
        }

        static {
            c[] cVarArrA = a();
            h = cVarArrA;
            i = G92.a(cVarArrA);
            b = new C1649a(null);
        }

        private c(String str, int i2, String str2) {
            this.a = str2;
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{c, d, e, f, g};
        }

        public static F92 p() {
            return i;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) h.clone();
        }

        public final String j() {
            return this.a + Separators.STAR;
        }

        public final String q() {
            return this.a;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[c.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[c.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return a.this.n(null, null, null, null, this);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return a.this.o(null, null, null, null, this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return a.this.q(null, null, null, null, this);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return a.this.r(null, this);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        int j;
        private /* synthetic */ Object k;
        final /* synthetic */ Intent m;

        /* renamed from: ir.nasim.utils.share.a$i$a, reason: collision with other inner class name */
        static final class C1650a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ a c;
            final /* synthetic */ Uri d;
            final /* synthetic */ String e;
            final /* synthetic */ String f;
            final /* synthetic */ CharSequence g;

            /* renamed from: ir.nasim.utils.share.a$i$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1651a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[c.values().length];
                    try {
                        iArr[c.c.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[c.d.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[c.e.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[c.f.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1650a(a aVar, Uri uri, String str, String str2, CharSequence charSequence, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = uri;
                this.e = str;
                this.f = str2;
                this.g = charSequence;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1650a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    a aVar = this.c;
                    Uri uri = this.d;
                    AbstractC13042fc3.f(uri);
                    String strJ = this.e;
                    if (strJ == null) {
                        strJ = c.g.j();
                    }
                    this.b = 1;
                    obj = a.w(aVar, uri, strJ, null, this, 2, null);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            AbstractC10685c16.b(obj);
                            return (SharedContent.MediaContent) obj;
                        }
                        if (i == 3) {
                            AbstractC10685c16.b(obj);
                            return (SharedContent.MediaContent) obj;
                        }
                        if (i == 4) {
                            AbstractC10685c16.b(obj);
                            return (SharedContent.MediaContent) obj;
                        }
                        if (i != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return (SharedContent.MediaContent) obj;
                    }
                    AbstractC10685c16.b(obj);
                }
                String str = (String) obj;
                int i2 = C1651a.a[c.b.a(str).ordinal()];
                if (i2 == 1) {
                    Uri uri2 = this.d;
                    AbstractC13042fc3.f(uri2);
                    a aVar2 = this.c;
                    String str2 = this.f;
                    CharSequence charSequence = this.g;
                    this.b = 2;
                    obj = aVar2.n(uri2, str2, str, charSequence, this);
                    if (obj == objE) {
                        return objE;
                    }
                    return (SharedContent.MediaContent) obj;
                }
                if (i2 == 2) {
                    Uri uri3 = this.d;
                    AbstractC13042fc3.f(uri3);
                    return this.c.p(uri3, this.f, this.g);
                }
                if (i2 == 3) {
                    Uri uri4 = this.d;
                    AbstractC13042fc3.f(uri4);
                    a aVar3 = this.c;
                    String str3 = this.f;
                    CharSequence charSequence2 = this.g;
                    this.b = 3;
                    obj = aVar3.q(uri4, str3, str, charSequence2, this);
                    if (obj == objE) {
                        return objE;
                    }
                    return (SharedContent.MediaContent) obj;
                }
                if (i2 != 4) {
                    Uri uri5 = this.d;
                    AbstractC13042fc3.f(uri5);
                    a aVar4 = this.c;
                    String str4 = this.f;
                    CharSequence charSequence3 = this.g;
                    this.b = 5;
                    obj = aVar4.o(uri5, str4, str, charSequence3, this);
                    if (obj == objE) {
                        return objE;
                    }
                    return (SharedContent.MediaContent) obj;
                }
                Uri uri6 = this.d;
                AbstractC13042fc3.f(uri6);
                a aVar5 = this.c;
                String str5 = this.f;
                CharSequence charSequence4 = this.g;
                this.b = 4;
                obj = aVar5.t(uri6, str5, str, charSequence4, this);
                if (obj == objE) {
                    return objE;
                }
                return (SharedContent.MediaContent) obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1650a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Intent intent, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.m = intent;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = a.this.new i(this.m, interfaceC20295rm1);
            iVar.k = obj;
            return iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x016d  */
        /* JADX WARN: Type inference failed for: r10v10, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0101 -> B:31:0x010d). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 468
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return a.this.t(null, null, null, null, this);
        }
    }

    static final class k extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return a.this.u(null, this);
        }
    }

    static final class l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return a.this.v(null, null, null, this);
        }
    }

    static final class m extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* renamed from: ir.nasim.utils.share.a$m$a, reason: collision with other inner class name */
        static final class C1652a extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ String c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1652a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1652a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.c;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1652a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new m(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19247q16 c19247q16 = a.this.c;
                String str = this.d;
                C1652a c1652a = new C1652a(this.e, null);
                this.b = 1;
                obj = c19247q16.c(str, c1652a, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Intent d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Intent intent, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = intent;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new n(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Exception {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.b
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                ir.nasim.AbstractC10685c16.b(r15)
                goto L5c
            L13:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L1b:
                ir.nasim.AbstractC10685c16.b(r15)
                goto L81
            L1f:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.utils.share.a r15 = ir.nasim.utils.share.a.this
                android.content.Intent r1 = r14.d
                boolean r15 = ir.nasim.utils.share.a.m(r15, r1)
                if (r15 != 0) goto L2d
                return r4
            L2d:
                android.content.Intent r15 = r14.d
                java.lang.String r15 = r15.getAction()
                if (r15 == 0) goto Ld5
                int r1 = r15.hashCode()
                r5 = -1173264947(0xffffffffba1165cd, float:-5.5464805E-4)
                if (r1 == r5) goto L6c
                r5 = -58484670(0xfffffffffc839842, float:-5.4662324E36)
                if (r1 == r5) goto L45
                goto Ld5
            L45:
                java.lang.String r1 = "android.intent.action.SEND_MULTIPLE"
                boolean r15 = r15.equals(r1)
                if (r15 != 0) goto L4f
                goto Ld5
            L4f:
                ir.nasim.utils.share.a r15 = ir.nasim.utils.share.a.this
                android.content.Intent r1 = r14.d
                r14.b = r2
                java.lang.Object r15 = ir.nasim.utils.share.a.f(r15, r1, r14)
                if (r15 != r0) goto L5c
                return r0
            L5c:
                r0 = r15
                java.util.List r0 = (java.util.List) r0
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r0 = r0 ^ r3
                if (r0 == 0) goto L69
                r4 = r15
            L69:
                java.util.List r4 = (java.util.List) r4
                goto L89
            L6c:
                java.lang.String r1 = "android.intent.action.SEND"
                boolean r15 = r15.equals(r1)
                if (r15 == 0) goto Ld5
                ir.nasim.utils.share.a r15 = ir.nasim.utils.share.a.this
                android.content.Intent r1 = r14.d
                r14.b = r3
                java.lang.Object r15 = ir.nasim.utils.share.a.e(r15, r1, r14)
                if (r15 != r0) goto L81
                return r0
            L81:
                ir.nasim.utils.share.SharedContent r15 = (ir.nasim.utils.share.SharedContent) r15
                if (r15 == 0) goto L89
                java.util.List r4 = ir.nasim.ZW0.e(r15)
            L89:
                android.content.Intent r15 = r14.d
                java.lang.String r0 = "SharedIntentHandlerUseCase"
                if (r4 == 0) goto Lb8
                r5 = r4
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                r12 = 62
                r13 = 0
                java.lang.String r6 = "\n"
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                java.lang.String r15 = ir.nasim.ZW0.A0(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "The generated contents: \n"
                r1.append(r2)
                r1.append(r15)
                java.lang.String r15 = r1.toString()
                r1 = 0
                java.lang.Object[] r1 = new java.lang.Object[r1]
                ir.nasim.C19406qI3.a(r0, r15, r1)
                goto Ld5
            Lb8:
                android.os.Bundle r15 = r15.getExtras()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Failed to generate contents from extras("
                r1.append(r2)
                r1.append(r15)
                java.lang.String r15 = ")"
                r1.append(r15)
                java.lang.String r15 = r1.toString()
                ir.nasim.C19406qI3.b(r0, r15)
            Ld5:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public a(Context context, AbstractC13778go1 abstractC13778go1, C19247q16 c19247q16, TF2 tf2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c19247q16, "retrieveMimeType");
        AbstractC13042fc3.i(tf2, "getFilePathFromUri");
        this.a = context;
        this.b = abstractC13778go1;
        this.c = c19247q16;
        this.d = tf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(android.net.Uri r9, java.lang.String r10, java.lang.String r11, java.lang.CharSequence r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof ir.nasim.utils.share.a.e
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.utils.share.a$e r0 = (ir.nasim.utils.share.a.e) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.utils.share.a$e r0 = new ir.nasim.utils.share.a$e
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.f
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r9 = r5.c
            r12 = r9
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.Object r9 = r5.b
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.a
            android.net.Uri r9 = (android.net.Uri) r9
            ir.nasim.AbstractC10685c16.b(r13)
            r11 = r13
            goto L65
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            ir.nasim.AbstractC10685c16.b(r13)
            r13 = 2
            r1 = 0
            java.lang.String r3 = "/*"
            r4 = 0
            boolean r13 = ir.nasim.AbstractC14836iZ6.C(r11, r3, r4, r13, r1)
            if (r13 == 0) goto L65
            r5.a = r9
            r5.b = r10
            r5.c = r12
            r5.f = r2
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            java.lang.Object r11 = w(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L65
            return r0
        L65:
            java.lang.String r11 = (java.lang.String) r11
            ir.nasim.utils.share.SharedContent$MediaContent$Audio r13 = new ir.nasim.utils.share.SharedContent$MediaContent$Audio
            r13.<init>(r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.n(android.net.Uri, java.lang.String, java.lang.String, java.lang.CharSequence, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(android.net.Uri r9, java.lang.String r10, java.lang.String r11, java.lang.CharSequence r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof ir.nasim.utils.share.a.f
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.utils.share.a$f r0 = (ir.nasim.utils.share.a.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.utils.share.a$f r0 = new ir.nasim.utils.share.a$f
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.f
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r9 = r5.c
            r12 = r9
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.Object r9 = r5.b
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.a
            android.net.Uri r9 = (android.net.Uri) r9
            ir.nasim.AbstractC10685c16.b(r13)
            r11 = r13
            goto L65
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            ir.nasim.AbstractC10685c16.b(r13)
            r13 = 2
            r1 = 0
            java.lang.String r3 = "/*"
            r4 = 0
            boolean r13 = ir.nasim.AbstractC14836iZ6.C(r11, r3, r4, r13, r1)
            if (r13 == 0) goto L65
            r5.a = r9
            r5.b = r10
            r5.c = r12
            r5.f = r2
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            java.lang.Object r11 = w(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L65
            return r0
        L65:
            java.lang.String r11 = (java.lang.String) r11
            ir.nasim.utils.share.SharedContent$MediaContent$File r13 = new ir.nasim.utils.share.SharedContent$MediaContent$File
            r13.<init>(r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.o(android.net.Uri, java.lang.String, java.lang.String, java.lang.CharSequence, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedContent.MediaContent.Gif p(Uri uri, String str, CharSequence charSequence) {
        return new SharedContent.MediaContent.Gif(uri, str, charSequence, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(android.net.Uri r9, java.lang.String r10, java.lang.String r11, java.lang.CharSequence r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof ir.nasim.utils.share.a.g
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.utils.share.a$g r0 = (ir.nasim.utils.share.a.g) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.utils.share.a$g r0 = new ir.nasim.utils.share.a$g
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.f
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r9 = r5.c
            r12 = r9
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.Object r9 = r5.b
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.a
            android.net.Uri r9 = (android.net.Uri) r9
            ir.nasim.AbstractC10685c16.b(r13)
            r11 = r13
            goto L65
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            ir.nasim.AbstractC10685c16.b(r13)
            r13 = 2
            r1 = 0
            java.lang.String r3 = "/*"
            r4 = 0
            boolean r13 = ir.nasim.AbstractC14836iZ6.C(r11, r3, r4, r13, r1)
            if (r13 == 0) goto L65
            r5.a = r9
            r5.b = r10
            r5.c = r12
            r5.f = r2
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            java.lang.Object r11 = w(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L65
            return r0
        L65:
            java.lang.String r11 = (java.lang.String) r11
            ir.nasim.utils.share.SharedContent$MediaContent$Image r13 = new ir.nasim.utils.share.SharedContent$MediaContent$Image
            r13.<init>(r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.q(android.net.Uri, java.lang.String, java.lang.String, java.lang.CharSequence, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(android.content.Intent r8, ir.nasim.InterfaceC20295rm1 r9) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.utils.share.a.h
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.utils.share.a$h r0 = (ir.nasim.utils.share.a.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.utils.share.a$h r0 = new ir.nasim.utils.share.a$h
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r9)
            goto L8b
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.a
            ir.nasim.utils.share.a r8 = (ir.nasim.utils.share.a) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L4b
        L3c:
            ir.nasim.AbstractC10685c16.b(r9)
            r0.a = r7
            r0.d = r4
            java.lang.Object r9 = r7.u(r8, r0)
            if (r9 != r1) goto L4a
            return r1
        L4a:
            r8 = r7
        L4b:
            ir.nasim.utils.share.a$b r9 = (ir.nasim.utils.share.a.b) r9
            r2 = 0
            if (r9 != 0) goto L51
            return r2
        L51:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Resolved extras from the intent: "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "SharedIntentHandlerUseCase"
            ir.nasim.C19406qI3.a(r6, r4, r5)
            boolean r4 = r9 instanceof ir.nasim.utils.share.a.b.C1648b
            if (r4 == 0) goto L7a
            ir.nasim.utils.share.SharedContent$Text r8 = new ir.nasim.utils.share.SharedContent$Text
            ir.nasim.utils.share.a$b$b r9 = (ir.nasim.utils.share.a.b.C1648b) r9
            java.lang.CharSequence r9 = r9.a()
            r8.<init>(r9)
            goto L8e
        L7a:
            boolean r4 = r9 instanceof ir.nasim.utils.share.a.b.C1647a
            if (r4 == 0) goto L8f
            ir.nasim.utils.share.a$b$a r9 = (ir.nasim.utils.share.a.b.C1647a) r9
            r0.a = r2
            r0.d = r3
            java.lang.Object r9 = r8.z(r9, r0)
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r8 = r9
            ir.nasim.utils.share.SharedContent r8 = (ir.nasim.utils.share.SharedContent) r8
        L8e:
            return r8
        L8f:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.r(android.content.Intent, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(Intent intent, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new i(intent, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(android.net.Uri r9, java.lang.String r10, java.lang.String r11, java.lang.CharSequence r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof ir.nasim.utils.share.a.j
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.utils.share.a$j r0 = (ir.nasim.utils.share.a.j) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.utils.share.a$j r0 = new ir.nasim.utils.share.a$j
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.f
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r9 = r5.c
            r12 = r9
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.Object r9 = r5.b
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.a
            android.net.Uri r9 = (android.net.Uri) r9
            ir.nasim.AbstractC10685c16.b(r13)
            r11 = r13
            goto L65
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            ir.nasim.AbstractC10685c16.b(r13)
            r13 = 2
            r1 = 0
            java.lang.String r3 = "/*"
            r4 = 0
            boolean r13 = ir.nasim.AbstractC14836iZ6.C(r11, r3, r4, r13, r1)
            if (r13 == 0) goto L65
            r5.a = r9
            r5.b = r10
            r5.c = r12
            r5.f = r2
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            java.lang.Object r11 = w(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L65
            return r0
        L65:
            r1 = r9
            r2 = r10
            r4 = r12
            r3 = r11
            java.lang.String r3 = (java.lang.String) r3
            ir.nasim.utils.share.SharedContent$MediaContent$Video r9 = new ir.nasim.utils.share.SharedContent$MediaContent$Video
            r6 = 16
            r7 = 0
            r5 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.t(android.net.Uri, java.lang.String, java.lang.String, java.lang.CharSequence, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(android.content.Intent r14, ir.nasim.InterfaceC20295rm1 r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.u(android.content.Intent, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(android.net.Uri r6, java.lang.String r7, java.lang.String r8, ir.nasim.InterfaceC20295rm1 r9) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r9 instanceof ir.nasim.utils.share.a.l
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.utils.share.a$l r0 = (ir.nasim.utils.share.a.l) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.utils.share.a$l r0 = new ir.nasim.utils.share.a$l
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r9)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.q16 r9 = r5.c
            ir.nasim.utils.share.a$m r2 = new ir.nasim.utils.share.a$m
            r4 = 0
            r2.<init>(r7, r8, r4)
            r0.c = r3
            java.lang.Object r9 = r9.b(r6, r2, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L4f
            ir.nasim.utils.share.a$c r6 = ir.nasim.utils.share.a.c.g
            java.lang.String r9 = r6.j()
        L4f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.share.a.v(android.net.Uri, java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object w(a aVar, Uri uri, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return aVar.v(uri, str, str2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(Intent intent) {
        return AbstractC15401jX0.i0(AbstractC10360bX0.p("android.intent.action.SEND", "android.intent.action.SEND_MULTIPLE"), intent.getAction()) && (intent.hasExtra("android.intent.extra.TEXT") || intent.hasExtra("android.intent.extra.HTML_TEXT") || intent.hasExtra("android.intent.extra.STREAM"));
    }

    private final Object z(b.C1647a c1647a, InterfaceC20295rm1 interfaceC20295rm1) {
        int i2 = d.a[c1647a.b().ordinal()];
        if (i2 == 1) {
            Object objN = n(c1647a.e(), c1647a.c(), c1647a.d(), c1647a.a(), interfaceC20295rm1);
            return objN == AbstractC14862ic3.e() ? objN : (SharedContent.MediaContent) objN;
        }
        if (i2 == 2) {
            return p(c1647a.e(), c1647a.c(), c1647a.a());
        }
        if (i2 == 3) {
            Object objQ = q(c1647a.e(), c1647a.c(), c1647a.d(), c1647a.a(), interfaceC20295rm1);
            return objQ == AbstractC14862ic3.e() ? objQ : (SharedContent.MediaContent) objQ;
        }
        if (i2 == 4) {
            Object objT = t(c1647a.e(), c1647a.c(), c1647a.d(), c1647a.a(), interfaceC20295rm1);
            return objT == AbstractC14862ic3.e() ? objT : (SharedContent.MediaContent) objT;
        }
        if (i2 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        Object objO = o(c1647a.e(), c1647a.c(), c1647a.d(), c1647a.a(), interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : (SharedContent.MediaContent) objO;
    }

    public final Object x(Intent intent, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new n(intent, null), interfaceC20295rm1);
    }
}
