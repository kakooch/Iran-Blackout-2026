package ir.nasim;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Do0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4069Do0 implements Z72 {
    @Override // ir.nasim.Z72
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, File file, HL4 hl4) throws Throwable {
        try {
            AbstractC5254Io0.f(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
