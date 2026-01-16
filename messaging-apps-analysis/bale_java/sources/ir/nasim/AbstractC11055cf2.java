package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;

/* renamed from: ir.nasim.cf2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11055cf2 {
    public static void a(boolean z, String str) throws ParserException {
        if (!z) {
            throw ParserException.a(str, null);
        }
    }

    public static boolean b(InterfaceC9845af2 interfaceC9845af2, byte[] bArr, int i, int i2, boolean z) throws EOFException {
        try {
            return interfaceC9845af2.c(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int c(InterfaceC9845af2 interfaceC9845af2, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iJ = interfaceC9845af2.j(bArr, i + i3, i2 - i3);
            if (iJ == -1) {
                break;
            }
            i3 += iJ;
        }
        return i3;
    }

    public static boolean d(InterfaceC9845af2 interfaceC9845af2, byte[] bArr, int i, int i2) {
        try {
            interfaceC9845af2.readFully(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(InterfaceC9845af2 interfaceC9845af2, int i) {
        try {
            interfaceC9845af2.k(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
