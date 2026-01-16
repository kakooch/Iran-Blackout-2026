package ir.nasim;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* renamed from: ir.nasim.fH2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12850fH2 implements KW5 {
    @Override // ir.nasim.KW5
    public T72 a(HL4 hl4) {
        return T72.SOURCE;
    }

    @Override // ir.nasim.Z72
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(DW5 dw5, File file, HL4 hl4) throws Throwable {
        try {
            AbstractC5254Io0.f(((C11598dH2) dw5.get()).c(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
