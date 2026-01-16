package ir.nasim;

import android.content.Context;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import ir.nasim.C13388g85;
import ir.nasim.GS7;
import ir.nasim.J08;
import ir.nasim.TM;
import ir.nasim.XG2;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class RW1 {
    public static final RW1 a = new RW1();
    private static final String[] b = {"audio/ogg", "audio/opus"};
    private static final String[] c = {"mime_type", "_display_name", "_size"};
    public static final int d = 8;

    private static final class a {
        private final String a;
        private final String b;
        private final String c;
        private final String d;
        private final int e;

        public a(String str, String str2, String str3, String str4, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public final int c() {
            return this.e;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.c;
        }
    }

    private static final class b {
        private final String a;
        private final String b;
        private final String c;
        private final String d;
        private final long e;

        public b(String str, String str2, String str3, String str4, long j) {
            AbstractC13042fc3.i(str, "fullPath");
            AbstractC13042fc3.i(str2, "displayName");
            AbstractC13042fc3.i(str3, "extension");
            AbstractC13042fc3.i(str4, "mimeType");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = j;
        }

        public static /* synthetic */ b b(b bVar, String str, String str2, String str3, String str4, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bVar.a;
            }
            if ((i & 2) != 0) {
                str2 = bVar.b;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = bVar.c;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = bVar.d;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                j = bVar.e;
            }
            return bVar.a(str, str5, str6, str7, j);
        }

        public final b a(String str, String str2, String str3, String str4, long j) {
            AbstractC13042fc3.i(str, "fullPath");
            AbstractC13042fc3.i(str2, "displayName");
            AbstractC13042fc3.i(str3, "extension");
            AbstractC13042fc3.i(str4, "mimeType");
            return new b(str, str2, str3, str4, j);
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.c;
        }

        public final String e() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && this.e == bVar.e;
        }

        public final String f() {
            return this.d;
        }

        public final long g() {
            return this.e;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e);
        }

        public String toString() {
            return "DocumentInfo(fullPath=" + this.a + ", displayName=" + this.b + ", extension=" + this.c + ", mimeType=" + this.d + ", size=" + this.e + Separators.RPAREN;
        }
    }

    private static final class c {
        private final int a;
        private final int b;
        private final long c;
        private final Bitmap d;

        public c(int i, int i2, long j, Bitmap bitmap) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bitmap;
        }

        public final long a() {
            return this.c;
        }

        public final int b() {
            return this.b;
        }

        public final Bitmap c() {
            return this.d;
        }

        public final int d() {
            return this.a;
        }
    }

    private static final class d {
        private final int a;
        private final int b;
        private final int c;
        private final Bitmap d;

        public d(int i, int i2, int i3, Bitmap bitmap) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = bitmap;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.b;
        }

        public final Bitmap c() {
            return this.d;
        }

        public final int d() {
            return this.a;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Context context, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Uri uriFromFile;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.length() == 0 || (uriFromFile = Uri.fromFile((file = new File(this.c)))) == null) {
                    return null;
                }
                RW1 rw1 = RW1.a;
                b bVarL = rw1.L(rw1.D(this.d, uriFromFile, file, this.e), this.d, uriFromFile);
                String str = this.f;
                this.b = 1;
                obj = rw1.n(bVarL, str, this);
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

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String string;
            Object objA;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = this.c;
            if (str != null) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                string = str.subSequence(i, length + 1).toString();
            } else {
                string = null;
            }
            try {
                a aVarZ = RW1.a.z(this.d.e());
                if (aVarZ == null) {
                    return null;
                }
                if (AbstractC10242bK.U(RW1.b, this.d.f())) {
                    J08.a aVar = J08.l;
                    String strE = this.d.e();
                    String strC = this.d.c();
                    String strA = C14225hZ6.a(string);
                    objA = aVar.b(strE, strC, strA == null ? "" : strA, (int) this.d.g(), aVarZ.c());
                } else {
                    TM.a aVar2 = TM.q;
                    String strE2 = this.d.e();
                    String strC2 = this.d.c();
                    String strA2 = C14225hZ6.a(string);
                    if (strA2 == null) {
                        strA2 = "";
                    }
                    objA = aVar2.a(strE2, strC2, strA2, (int) this.d.g(), aVarZ.b(), aVarZ.a(), aVarZ.e(), aVarZ.d(), null, null, aVarZ.c());
                }
                return objA;
            } catch (Exception e) {
                C19406qI3.c("DocumentsMaker", e.getMessage(), e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Context context, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Uri uriFromFile;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.length() == 0 || (uriFromFile = Uri.fromFile((file = new File(this.c)))) == null) {
                    return null;
                }
                RW1 rw1 = RW1.a;
                b bVarL = rw1.L(rw1.D(this.d, uriFromFile, file, this.e), this.d, uriFromFile);
                String str = this.f;
                this.b = 1;
                obj = rw1.p(bVarL, str, this);
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

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String string;
            Bitmap bitmapO;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = this.c;
            if (str != null) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                string = str.subSequence(i, length + 1).toString();
            } else {
                string = null;
            }
            try {
                Bitmap bitmapE = V13.e(this.d.e());
                C22694vg2 c22694vg2 = (bitmapE == null || (bitmapO = V13.o(bitmapE, 30, 30)) == null) ? null : new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO));
                String strC = this.d.c();
                int iG = (int) this.d.g();
                String strE = this.d.e();
                String strA = C14225hZ6.a(string);
                if (strA == null) {
                    strA = "";
                }
                return C24967zW1.r(strC, iG, strE, strA, this.d.f(), c22694vg2);
            } catch (Exception e) {
                C19406qI3.c("DocumentsMaker", e.getMessage(), e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, Context context, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Uri uriFromFile;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.length() == 0 || (uriFromFile = Uri.fromFile((file = new File(this.c)))) == null) {
                    return null;
                }
                RW1 rw1 = RW1.a;
                b bVarL = rw1.L(rw1.D(this.d, uriFromFile, file, this.e), this.d, uriFromFile);
                String str = this.f;
                this.b = 1;
                obj = rw1.r(bVarL, str, this);
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

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            String string;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = this.c;
            if (str != null) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                string = str.subSequence(i, length + 1).toString();
            } else {
                string = null;
            }
            c cVarH = RW1.a.H(this.d);
            if (cVarH == null) {
                return null;
            }
            Bitmap bitmapC = cVarH.c();
            C22694vg2 c22694vg2 = bitmapC != null ? new C22694vg2(bitmapC.getWidth(), bitmapC.getHeight(), V13.i(bitmapC)) : new C22694vg2(cVarH.d(), cVarH.b(), new byte[0]);
            try {
                XG2.a aVar = XG2.l;
                String strE = this.d.e();
                String strC = this.d.c();
                String strA = C14225hZ6.a(string);
                if (strA == null) {
                    strA = "";
                }
                return aVar.a(strE, strC, strA, (int) cVarH.a(), cVarH.d(), cVarH.b(), 0, c22694vg2, this.d.f());
            } catch (Exception e) {
                C19406qI3.c("DocumentsMaker", e.getMessage(), e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, Context context, String str2, String str3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
            this.g = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Uri uriFromFile;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return (C24967zW1) obj;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return (C24967zW1) obj;
            }
            AbstractC10685c16.b(obj);
            if (this.c.length() == 0 || (uriFromFile = Uri.fromFile((file = new File(this.c)))) == null) {
                return null;
            }
            RW1 rw1 = RW1.a;
            b bVarL = rw1.L(rw1.D(this.d, uriFromFile, file, this.e), this.d, uriFromFile);
            if (AbstractC20153rZ6.S(bVarL.f(), "image/", false, 2, null)) {
                String str = this.f;
                boolean z = this.g;
                this.b = 1;
                obj = rw1.v(bVarL, str, z, this);
                if (obj == objE) {
                    return objE;
                }
                return (C24967zW1) obj;
            }
            if (!AbstractC20153rZ6.S(bVarL.f(), "video/", false, 2, null)) {
                return null;
            }
            String str2 = this.f;
            boolean z2 = this.g;
            this.b = 2;
            obj = rw1.y(bVarL, str2, false, z2, this);
            if (obj == objE) {
                return objE;
            }
            return (C24967zW1) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, Context context, String str2, String str3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
            this.g = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new l(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Uri uriFromFile;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.length() == 0 || (uriFromFile = Uri.fromFile((file = new File(this.c)))) == null) {
                    return null;
                }
                RW1 rw1 = RW1.a;
                b bVarL = rw1.L(rw1.D(this.d, uriFromFile, file, this.e), this.d, uriFromFile);
                String str = this.f;
                boolean z = this.g;
                this.b = 1;
                obj = rw1.v(bVarL, str, z, this);
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

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ b d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, b bVar, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = bVar;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            String string;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                String str = this.c;
                if (str != null) {
                    int length = str.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    string = str.subSequence(i, length + 1).toString();
                } else {
                    string = null;
                }
                Bitmap bitmapE = V13.e(this.d.e());
                if (bitmapE == null) {
                    return null;
                }
                Bitmap bitmapO = V13.o(bitmapE, 30, 30);
                C22694vg2 c22694vg2 = bitmapO != null ? new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO)) : new C22694vg2(bitmapE.getWidth(), bitmapE.getHeight(), new byte[0]);
                if (this.e) {
                    String strC = this.d.c();
                    int iG = (int) this.d.g();
                    String strE = this.d.e();
                    String strA = C14225hZ6.a(string);
                    return C24967zW1.r(strC, iG, strE, strA == null ? "" : strA, this.d.f(), c22694vg2);
                }
                String strG = RW1.a.G();
                if (strG == null) {
                    return null;
                }
                V13.f(bitmapE, strG);
                C13388g85.a aVar = C13388g85.l;
                String strC2 = this.d.c();
                String strA2 = C14225hZ6.a(string);
                return aVar.a(strG, strC2, strA2 == null ? "" : strA2, (int) new File(strG).length(), bitmapE.getWidth(), bitmapE.getHeight(), c22694vg2);
            } catch (Exception e) {
                C19406qI3.c("DocumentsMaker", e.getMessage(), e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(String str, Context context, String str2, String str3, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
            this.g = z;
            this.h = z2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new n(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            Uri uriFromFile;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.length() == 0 || (uriFromFile = Uri.fromFile((file = new File(this.c)))) == null) {
                    return null;
                }
                RW1 rw1 = RW1.a;
                b bVarL = rw1.L(rw1.D(this.d, uriFromFile, file, this.e), this.d, uriFromFile);
                String str = this.f;
                boolean z = this.g;
                boolean z2 = this.h;
                this.b = 1;
                obj = rw1.y(bVarL, str, z, z2, this);
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

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ b c;
        final /* synthetic */ String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(b bVar, String str, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bVar;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new o(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String string;
            Object objD;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                d dVarA = RW1.a.A(this.c.e());
                if (dVarA == null) {
                    return null;
                }
                Bitmap bitmapC = dVarA.c();
                C22694vg2 c22694vg2 = bitmapC != null ? new C22694vg2(bitmapC.getWidth(), bitmapC.getHeight(), V13.i(bitmapC)) : new C22694vg2(dVarA.d(), dVarA.b(), new byte[0]);
                String str = this.d;
                if (str != null) {
                    int length = str.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    string = str.subSequence(i, length + 1).toString();
                } else {
                    string = null;
                }
                if (this.e) {
                    String strC = this.c.c();
                    int iG = (int) this.c.g();
                    String strE = this.c.e();
                    String strA = C14225hZ6.a(string);
                    objD = C24967zW1.r(strC, iG, strE, strA == null ? "" : strA, this.c.f(), c22694vg2);
                } else {
                    GS7.a aVar = GS7.n;
                    String strE2 = this.c.e();
                    String strC2 = this.c.c();
                    String strA2 = C14225hZ6.a(string);
                    objD = aVar.d(strE2, strC2, strA2 == null ? "" : strA2, (int) this.c.g(), dVarA.d(), dVarA.b(), dVarA.a(), c22694vg2, this.f);
                }
                return objD;
            } catch (Exception e) {
                C19406qI3.c("DocumentsMaker", e.getMessage(), e);
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private RW1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d A(String str) throws IllegalArgumentException {
        int i2;
        int i3;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (strExtractMetadata == null) {
                return null;
            }
            int i4 = (int) (Long.parseLong(strExtractMetadata) / 1000);
            if (Build.VERSION.SDK_INT < 27) {
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (frameAtTime == null) {
                    return null;
                }
                return new d(frameAtTime.getWidth(), frameAtTime.getHeight(), i4, V13.o(frameAtTime, 30, 30));
            }
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            if (strExtractMetadata2 != null) {
                int i5 = Integer.parseInt(strExtractMetadata2);
                String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                if (strExtractMetadata3 != null) {
                    int i6 = Integer.parseInt(strExtractMetadata3);
                    String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
                    int i7 = strExtractMetadata4 != null ? Integer.parseInt(strExtractMetadata4) : 0;
                    if (i7 == 90 || i7 == 270) {
                        i2 = i5;
                        i3 = i6;
                    } else {
                        i3 = i5;
                        i2 = i6;
                    }
                    return new d(i3, i2, i4, mediaMetadataRetriever.getScaledFrameAtTime(0L, 2, 30, 30));
                }
            }
            return null;
        } catch (Exception e2) {
            C19406qI3.c("DocumentsMaker", e2.getMessage(), e2);
            return null;
        }
    }

    private final String B(b bVar, int i2) {
        String strM = C6906Pm2.m(bVar.c());
        if (bVar.d().length() == 0) {
            return strM + " (" + i2 + Separators.RPAREN;
        }
        return strM + " (" + i2 + ")." + bVar.d();
    }

    private final String C(Cursor cursor, String str) {
        String string = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"));
        return string == null ? str : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b D(Context context, Uri uri, File file, String str) throws IOException {
        String name = file.getName();
        String absolutePath = file.getAbsolutePath();
        Cursor cursorQuery = context.getContentResolver().query(uri, c, null, null, null);
        Cursor cursor = cursorQuery;
        try {
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                RW1 rw1 = a;
                AbstractC13042fc3.f(name);
                String strC = rw1.C(cursorQuery, name);
                if (str == null) {
                    str = rw1.I(cursorQuery, strC);
                }
                String str2 = str;
                String strE = rw1.E(strC, str2);
                long jK = rw1.K(cursorQuery, file.length());
                AbstractC13042fc3.f(absolutePath);
                b bVar = new b(absolutePath, strC, strE, str2, jK);
                YV0.a(cursor, null);
                return bVar;
            }
            RW1 rw12 = a;
            AbstractC13042fc3.f(name);
            String strE2 = rw12.E(name, null);
            if (str == null) {
                str = rw12.J(strE2);
            }
            AbstractC13042fc3.f(absolutePath);
            b bVar2 = new b(absolutePath, name, strE2, str, file.length());
            YV0.a(cursor, null);
            return bVar2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(cursor, th);
                throw th2;
            }
        }
    }

    private final String E(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str2);
        if (!(true ^ (extensionFromMimeType == null || extensionFromMimeType.length() == 0))) {
            extensionFromMimeType = null;
        }
        return extensionFromMimeType == null ? C6906Pm2.l(str) : extensionFromMimeType;
    }

    private final String F(String str) {
        return AbstractC20153rZ6.S(str, "image/", false, 2, null) ? "images" : AbstractC20153rZ6.S(str, "video/", false, 2, null) ? "videos" : AbstractC20153rZ6.S(str, "audio/", false, 2, null) ? "audios" : "documents";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String G() {
        return C4053Dm2.m("jpg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c H(b bVar) throws Throwable {
        c cVar = null;
        try {
            if (AbstractC13042fc3.d(bVar.f(), "image/gif")) {
                Bitmap bitmapE = V13.e(bVar.e());
                if (bitmapE == null) {
                    return null;
                }
                Bitmap bitmapO = V13.o(bitmapE, 30, 30);
                String strG = G();
                if (strG == null) {
                    return null;
                }
                V13.f(bitmapE, strG);
                cVar = new c(bitmapE.getWidth(), bitmapE.getHeight(), new File(strG).length(), bitmapO);
            } else {
                d dVarA = A(bVar.e());
                if (dVarA == null) {
                    return null;
                }
                cVar = new c(dVarA.d(), dVarA.b(), bVar.g(), dVarA.c());
            }
        } catch (Exception e2) {
            C19406qI3.d("DocumentsMaker", e2);
        }
        return cVar;
    }

    private final String I(Cursor cursor, String str) {
        String string = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
        return (string == null || AbstractC20762sZ6.X(string, Separators.QUESTION, false, 2, null)) ? J(E(str, string)) : string;
    }

    private final String J(String str) {
        String mimeTypeFromExtension;
        return (str.length() <= 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str)) == null) ? "?/?" : mimeTypeFromExtension;
    }

    private final long K(Cursor cursor, long j2) throws IllegalArgumentException {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_size");
        Long lValueOf = cursor.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursor.getLong(columnIndexOrThrow));
        return lValueOf != null ? lValueOf.longValue() : j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b L(b bVar, Context context, Uri uri) throws IOException {
        File externalFilesDir;
        if (AbstractC20153rZ6.E(uri.getScheme(), "file", false, 2, null) || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
            return bVar;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        String strF = F(bVar.f());
        String str = File.separator;
        File file = new File(absolutePath + str + strF + str);
        if (!file.exists() && !file.mkdirs()) {
            file = new File(absolutePath + str);
        }
        File file2 = new File(file, bVar.c());
        int i2 = 1;
        String strC = bVar.c();
        while (file2.exists()) {
            strC = B(bVar, i2);
            i2++;
            file2 = new File(file, strC);
        }
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return bVar;
        }
        VZ2.b(inputStreamOpenInputStream, file2);
        String absolutePath2 = file2.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath2, "getAbsolutePath(...)");
        return b.b(bVar, absolutePath2, strC, null, null, 0L, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(b bVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new f(str, bVar, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(b bVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new h(str, bVar, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(b bVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new j(str, bVar, null), interfaceC20295rm1);
    }

    public static /* synthetic */ Object t(RW1 rw1, Context context, String str, String str2, boolean z, String str3, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str3 = null;
        }
        return rw1.s(context, str, str2, z, str3, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v(b bVar, String str, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new m(str, bVar, z, null), interfaceC20295rm1);
    }

    public static /* synthetic */ Object w(RW1 rw1, Context context, String str, String str2, boolean z, String str3, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str3 = null;
        }
        return rw1.u(context, str, str2, z, str3, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y(b bVar, String str, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new o(bVar, str, z2, z, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a z(String str) throws IllegalArgumentException {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            int i2 = strExtractMetadata != null ? Integer.parseInt(strExtractMetadata) : 0;
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(2);
            if (strExtractMetadata2 != null) {
                strSubstring = strExtractMetadata2.substring(0, AbstractC23053wG5.i(strExtractMetadata2.length(), 256));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
            } else {
                strSubstring = null;
            }
            if (strSubstring == null) {
                strSubstring = "";
            }
            String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(1);
            if (strExtractMetadata3 != null) {
                strSubstring2 = strExtractMetadata3.substring(0, AbstractC23053wG5.i(strExtractMetadata3.length(), 256));
                AbstractC13042fc3.h(strSubstring2, "substring(...)");
            } else {
                strSubstring2 = null;
            }
            if (strSubstring2 == null) {
                strSubstring2 = "";
            }
            String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(6);
            if (strExtractMetadata4 != null) {
                strSubstring3 = strExtractMetadata4.substring(0, AbstractC23053wG5.i(strExtractMetadata4.length(), 256));
                AbstractC13042fc3.h(strSubstring3, "substring(...)");
            } else {
                strSubstring3 = null;
            }
            if (strSubstring3 == null) {
                strSubstring3 = "";
            }
            String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(7);
            if (strExtractMetadata5 != null) {
                strSubstring4 = strExtractMetadata5.substring(0, AbstractC23053wG5.i(strExtractMetadata5.length(), 256));
                AbstractC13042fc3.h(strSubstring4, "substring(...)");
            } else {
                strSubstring4 = null;
            }
            return new a(strSubstring, strSubstring2, strSubstring4 == null ? "" : strSubstring4, strSubstring3, i2);
        } catch (Exception e2) {
            C19406qI3.c("DocumentsMaker", e2.getMessage(), e2);
            return null;
        }
    }

    public final Object m(Context context, String str, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new e(str, context, str3, str2, null), interfaceC20295rm1);
    }

    public final Object o(Context context, String str, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new g(str, context, str3, str2, null), interfaceC20295rm1);
    }

    public final Object q(Context context, String str, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new i(str, context, str3, str2, null), interfaceC20295rm1);
    }

    public final Object s(Context context, String str, String str2, boolean z, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new k(str, context, str3, str2, z, null), interfaceC20295rm1);
    }

    public final Object u(Context context, String str, String str2, boolean z, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new l(str, context, str3, str2, z, null), interfaceC20295rm1);
    }

    public final Object x(Context context, String str, String str2, boolean z, boolean z2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new n(str, context, str3, str2, z2, z, null), interfaceC20295rm1);
    }
}
