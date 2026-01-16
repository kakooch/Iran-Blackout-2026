package ir.nasim;

import android.net.Uri;
import androidx.camera.core.ImageCaptureException;
import ir.nasim.C24677z13;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* renamed from: ir.nasim.Xj3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C8799Xj3 implements InterfaceC15888kL4 {

    /* renamed from: ir.nasim.Xj3$a */
    static abstract class a {
        abstract C24677z13.d a();

        abstract PS4 b();
    }

    C8799Xj3() {
    }

    private static Uri b(File file, C24677z13.d dVar) {
        throw null;
    }

    private static File c(C24677z13.d dVar) {
        throw null;
    }

    private static boolean d(C24677z13.d dVar) {
        throw null;
    }

    private static boolean e(C24677z13.d dVar) {
        throw null;
    }

    private static boolean f(C24677z13.d dVar) {
        throw null;
    }

    static Uri g(File file, C24677z13.d dVar) {
        Uri uriB = null;
        try {
            try {
                if (e(dVar)) {
                    uriB = b(file, dVar);
                } else if (f(dVar) || d(dVar)) {
                    throw null;
                }
                file.delete();
                return uriB;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);
            }
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    private static void h(File file, C14871id2 c14871id2, C24677z13.d dVar, int i) throws ImageCaptureException, NumberFormatException {
        try {
            C14871id2 c14871id2E = C14871id2.e(file);
            c14871id2.d(c14871id2E);
            if (c14871id2E.n() == 0 && i != 0) {
                c14871id2E.u(i);
            }
            throw null;
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e);
        }
    }

    private static void i(File file, byte[] bArr) throws ImageCaptureException, IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, new C8736Xc3().b(bArr));
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e);
        }
    }

    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C24677z13.e apply(a aVar) throws ImageCaptureException, IOException, NumberFormatException {
        PS4 ps4B = aVar.b();
        aVar.a();
        File fileC = c(null);
        i(fileC, (byte[]) ps4B.c());
        C14871id2 c14871id2D = ps4B.d();
        Objects.requireNonNull(c14871id2D);
        h(fileC, c14871id2D, null, ps4B.f());
        return new C24677z13.e(g(fileC, null));
    }
}
