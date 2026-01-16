package ir.nasim;

import android.util.Base64;
import java.util.Random;

/* renamed from: ir.nasim.dg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11866dg8 {
    private static final Random a = new Random();

    public static String a() {
        byte[] bArr = new byte[16];
        a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
