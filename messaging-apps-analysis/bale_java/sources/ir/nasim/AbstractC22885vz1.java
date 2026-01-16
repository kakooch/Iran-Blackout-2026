package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.vz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22885vz1 {
    public static void a(com.google.android.exoplayer2.upstream.a aVar) {
        if (aVar != null) {
            try {
                aVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
