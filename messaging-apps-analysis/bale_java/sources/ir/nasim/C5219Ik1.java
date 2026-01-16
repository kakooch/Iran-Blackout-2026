package ir.nasim;

import android.content.ClipData;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* renamed from: ir.nasim.Ik1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5219Ik1 {
    private final f a;

    /* renamed from: ir.nasim.Ik1$a */
    public static final class a {
        private final c a;

        public a(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.a = new b(clipData, i);
            } else {
                this.a = new d(clipData, i);
            }
        }

        public C5219Ik1 a() {
            return this.a.a();
        }

        public a b(Bundle bundle) {
            this.a.setExtras(bundle);
            return this;
        }

        public a c(int i) {
            this.a.c(i);
            return this;
        }

        public a d(Uri uri) {
            this.a.b(uri);
            return this;
        }
    }

    /* renamed from: ir.nasim.Ik1$b */
    private static final class b implements c {
        private final ContentInfo.Builder a;

        b(ClipData clipData, int i) {
            this.a = AbstractC6393Nk1.a(clipData, i);
        }

        @Override // ir.nasim.C5219Ik1.c
        public C5219Ik1 a() {
            return new C5219Ik1(new e(this.a.build()));
        }

        @Override // ir.nasim.C5219Ik1.c
        public void b(Uri uri) {
            this.a.setLinkUri(uri);
        }

        @Override // ir.nasim.C5219Ik1.c
        public void c(int i) {
            this.a.setFlags(i);
        }

        @Override // ir.nasim.C5219Ik1.c
        public void setExtras(Bundle bundle) {
            this.a.setExtras(bundle);
        }
    }

    /* renamed from: ir.nasim.Ik1$c */
    private interface c {
        C5219Ik1 a();

        void b(Uri uri);

        void c(int i);

        void setExtras(Bundle bundle);
    }

    /* renamed from: ir.nasim.Ik1$d */
    private static final class d implements c {
        ClipData a;
        int b;
        int c;
        Uri d;
        Bundle e;

        d(ClipData clipData, int i) {
            this.a = clipData;
            this.b = i;
        }

        @Override // ir.nasim.C5219Ik1.c
        public C5219Ik1 a() {
            return new C5219Ik1(new g(this));
        }

        @Override // ir.nasim.C5219Ik1.c
        public void b(Uri uri) {
            this.d = uri;
        }

        @Override // ir.nasim.C5219Ik1.c
        public void c(int i) {
            this.c = i;
        }

        @Override // ir.nasim.C5219Ik1.c
        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }
    }

    /* renamed from: ir.nasim.Ik1$e */
    private static final class e implements f {
        private final ContentInfo a;

        e(ContentInfo contentInfo) {
            this.a = AbstractC4985Hk1.a(AbstractC4980Hj5.g(contentInfo));
        }

        @Override // ir.nasim.C5219Ik1.f
        public int A() {
            return this.a.getFlags();
        }

        @Override // ir.nasim.C5219Ik1.f
        public ClipData a() {
            return this.a.getClip();
        }

        @Override // ir.nasim.C5219Ik1.f
        public ContentInfo b() {
            return this.a;
        }

        @Override // ir.nasim.C5219Ik1.f
        public int i() {
            return this.a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.a + "}";
        }
    }

    /* renamed from: ir.nasim.Ik1$f */
    private interface f {
        int A();

        ClipData a();

        ContentInfo b();

        int i();
    }

    /* renamed from: ir.nasim.Ik1$g */
    private static final class g implements f {
        private final ClipData a;
        private final int b;
        private final int c;
        private final Uri d;
        private final Bundle e;

        g(d dVar) {
            this.a = (ClipData) AbstractC4980Hj5.g(dVar.a);
            this.b = AbstractC4980Hj5.c(dVar.b, 0, 5, "source");
            this.c = AbstractC4980Hj5.f(dVar.c, 1);
            this.d = dVar.d;
            this.e = dVar.e;
        }

        @Override // ir.nasim.C5219Ik1.f
        public int A() {
            return this.c;
        }

        @Override // ir.nasim.C5219Ik1.f
        public ClipData a() {
            return this.a;
        }

        @Override // ir.nasim.C5219Ik1.f
        public ContentInfo b() {
            return null;
        }

        @Override // ir.nasim.C5219Ik1.f
        public int i() {
            return this.b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.a.getDescription());
            sb.append(", source=");
            sb.append(C5219Ik1.e(this.b));
            sb.append(", flags=");
            sb.append(C5219Ik1.a(this.c));
            if (this.d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.d.toString().length() + Separators.RPAREN;
            }
            sb.append(str);
            sb.append(this.e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    C5219Ik1(f fVar) {
        this.a = fVar;
    }

    static String a(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    static String e(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static C5219Ik1 g(ContentInfo contentInfo) {
        return new C5219Ik1(new e(contentInfo));
    }

    public ClipData b() {
        return this.a.a();
    }

    public int c() {
        return this.a.A();
    }

    public int d() {
        return this.a.i();
    }

    public ContentInfo f() {
        ContentInfo contentInfoB = this.a.b();
        Objects.requireNonNull(contentInfoB);
        return AbstractC4985Hk1.a(contentInfoB);
    }

    public String toString() {
        return this.a.toString();
    }
}
