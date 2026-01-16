package ir.nasim;

import android.os.Build;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.Objects;

/* renamed from: ir.nasim.qk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19666qk1 {
    private final Object a;
    private final View b;

    /* renamed from: ir.nasim.qk1$a */
    private static class a {
        static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newAutofillId(autofillId, j);
        }

        static ViewStructure b(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j);
        }

        static void c(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        static void d(ContentCaptureSession contentCaptureSession, AutofillId autofillId) {
            contentCaptureSession.notifyViewDisappeared(autofillId);
        }

        public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    private C19666qk1(ContentCaptureSession contentCaptureSession, View view) {
        this.a = contentCaptureSession;
        this.b = view;
    }

    public static C19666qk1 g(ContentCaptureSession contentCaptureSession, View view) {
        return new C19666qk1(contentCaptureSession, view);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentCaptureSession contentCaptureSessionA = AbstractC19075pk1.a(this.a);
            C21330tU c21330tUA = AbstractC14199hW7.a(this.b);
            Objects.requireNonNull(c21330tUA);
            a.f(contentCaptureSessionA, c21330tUA.a(), new long[]{Long.MIN_VALUE});
        }
    }

    public AutofillId b(long j) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession contentCaptureSessionA = AbstractC19075pk1.a(this.a);
        C21330tU c21330tUA = AbstractC14199hW7.a(this.b);
        Objects.requireNonNull(c21330tUA);
        return a.a(contentCaptureSessionA, c21330tUA.a(), j);
    }

    public KX7 c(AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return KX7.i(a.b(AbstractC19075pk1.a(this.a), autofillId, j));
        }
        return null;
    }

    public void d(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.c(AbstractC19075pk1.a(this.a), viewStructure);
        }
    }

    public void e(AutofillId autofillId) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.d(AbstractC19075pk1.a(this.a), autofillId);
        }
    }

    public void f(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.e(AbstractC19075pk1.a(this.a), autofillId, charSequence);
        }
    }
}
