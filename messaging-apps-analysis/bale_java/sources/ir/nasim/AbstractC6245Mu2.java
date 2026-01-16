package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* renamed from: ir.nasim.Mu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6245Mu2 {

    /* renamed from: ir.nasim.Mu2$a */
    public static class a {
        private final int a;
        private final b[] b;

        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        static a a(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }

        public b[] b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Mu2$b */
    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) AbstractC4980Hj5.g(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        static b a(Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.Mu2$c */
    public static class c {
        public abstract void a(int i);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return AbstractC10050az7.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, C19767qu2 c19767qu2) {
        return AbstractC19176pu2.e(context, c19767qu2, cancellationSignal);
    }

    public static Typeface c(Context context, C19767qu2 c19767qu2, int i, boolean z, int i2, Handler handler, c cVar) {
        C17558nA0 c17558nA0 = new C17558nA0(cVar, handler);
        return z ? AbstractC20376ru2.e(context, c19767qu2, c17558nA0, i, i2) : AbstractC20376ru2.d(context, c19767qu2, i, null, c17558nA0);
    }
}
