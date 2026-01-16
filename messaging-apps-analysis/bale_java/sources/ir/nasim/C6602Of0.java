package ir.nasim;

import android.graphics.Bitmap;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* renamed from: ir.nasim.Of0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C6602Of0 implements InterfaceC15888kL4 {

    /* renamed from: ir.nasim.Of0$a */
    private static class a {
        static boolean a(Bitmap bitmap) {
            return bitmap.hasGainmap();
        }
    }

    /* renamed from: ir.nasim.Of0$b */
    static abstract class b {
        b() {
        }

        static b c(PS4 ps4, int i) {
            return new RS(ps4, i);
        }

        abstract int a();

        abstract PS4 b();
    }

    C6602Of0() {
    }

    private static int b(Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 34 || !a.a(bitmap)) ? 256 : 4101;
    }

    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PS4 apply(b bVar) {
        PS4 ps4B = bVar.b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) ps4B.c()).compress(Bitmap.CompressFormat.JPEG, bVar.a(), byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C14871id2 c14871id2D = ps4B.d();
        Objects.requireNonNull(c14871id2D);
        return PS4.m(byteArray, c14871id2D, b((Bitmap) ps4B.c()), ps4B.h(), ps4B.b(), ps4B.f(), ps4B.g(), ps4B.a());
    }
}
