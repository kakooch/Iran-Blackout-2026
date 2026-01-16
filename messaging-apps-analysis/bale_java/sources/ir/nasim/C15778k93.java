package ir.nasim;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* renamed from: ir.nasim.k93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15778k93 {
    private final c a;

    /* renamed from: ir.nasim.k93$c */
    private interface c {
        Object a();

        Uri b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public C15778k93(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new a(uri, clipDescription, uri2);
        } else {
            this.a = new b(uri, clipDescription, uri2);
        }
    }

    public static C15778k93 f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new C15778k93(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.a.b();
    }

    public ClipDescription b() {
        return this.a.getDescription();
    }

    public Uri c() {
        return this.a.d();
    }

    public void d() {
        this.a.c();
    }

    public Object e() {
        return this.a.a();
    }

    /* renamed from: ir.nasim.k93$a */
    private static final class a implements c {
        final InputContentInfo a;

        a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // ir.nasim.C15778k93.c
        public Object a() {
            return this.a;
        }

        @Override // ir.nasim.C15778k93.c
        public Uri b() {
            return this.a.getContentUri();
        }

        @Override // ir.nasim.C15778k93.c
        public void c() {
            this.a.requestPermission();
        }

        @Override // ir.nasim.C15778k93.c
        public Uri d() {
            return this.a.getLinkUri();
        }

        @Override // ir.nasim.C15778k93.c
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private C15778k93(c cVar) {
        this.a = cVar;
    }

    /* renamed from: ir.nasim.k93$b */
    private static final class b implements c {
        private final Uri a;
        private final ClipDescription b;
        private final Uri c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // ir.nasim.C15778k93.c
        public Object a() {
            return null;
        }

        @Override // ir.nasim.C15778k93.c
        public Uri b() {
            return this.a;
        }

        @Override // ir.nasim.C15778k93.c
        public Uri d() {
            return this.c;
        }

        @Override // ir.nasim.C15778k93.c
        public ClipDescription getDescription() {
            return this.b;
        }

        @Override // ir.nasim.C15778k93.c
        public void c() {
        }
    }
}
