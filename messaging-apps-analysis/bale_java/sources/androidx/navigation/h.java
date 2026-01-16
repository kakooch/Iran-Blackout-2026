package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
public class h {
    private final Uri a;
    private final String b;
    private final String c;

    public static final class a {
        public static final C0104a d = new C0104a(null);
        private Uri a;
        private String b;
        private String c;

        /* renamed from: androidx.navigation.h$a$a, reason: collision with other inner class name */
        public static final class C0104a {
            private C0104a() {
            }

            public final a a(Uri uri) {
                AbstractC13042fc3.i(uri, "uri");
                a aVar = new a(null);
                aVar.b(uri);
                return aVar;
            }

            public /* synthetic */ C0104a(ED1 ed1) {
                this();
            }
        }

        private a() {
        }

        public final h a() {
            return new h(this.a, this.b, this.c);
        }

        public final a b(Uri uri) {
            AbstractC13042fc3.i(uri, "uri");
            this.a = uri;
            return this;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public h(Uri uri, String str, String str2) {
        this.a = uri;
        this.b = str;
        this.c = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Uri c() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (c() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(c()));
        }
        if (a() != null) {
            sb.append(" action=");
            sb.append(a());
        }
        if (b() != null) {
            sb.append(" mimetype=");
            sb.append(b());
        }
        sb.append(" }");
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        AbstractC13042fc3.i(intent, "intent");
    }
}
