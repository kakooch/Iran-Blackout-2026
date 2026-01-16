package ir.nasim;

import android.util.Base64;

/* renamed from: ir.nasim.j90, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC15184j90 {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
