package androidx.compose.ui.graphics;

import ir.nasim.AbstractC23676xK2;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.MK5;
import ir.nasim.ON5;
import ir.nasim.Q93;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public abstract class b {
    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, UA2 ua2) {
        return eVar.i(new BlockGraphicsLayerElement(ua2));
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, InterfaceC10031ax6 interfaceC10031ax6, boolean z, ON5 on5, long j2, long j3, int i) {
        return eVar.i(new GraphicsLayerElement(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, interfaceC10031ax6, z, on5, j2, j3, i, null));
    }

    public static /* synthetic */ androidx.compose.ui.e c(androidx.compose.ui.e eVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, InterfaceC10031ax6 interfaceC10031ax6, boolean z, ON5 on5, long j2, long j3, int i, int i2, Object obj) {
        return b(eVar, (i2 & 1) != 0 ? 1.0f : f, (i2 & 2) != 0 ? 1.0f : f2, (i2 & 4) == 0 ? f3 : 1.0f, (i2 & 8) != 0 ? 0.0f : f4, (i2 & 16) != 0 ? 0.0f : f5, (i2 & 32) != 0 ? 0.0f : f6, (i2 & 64) != 0 ? 0.0f : f7, (i2 & 128) != 0 ? 0.0f : f8, (i2 & 256) == 0 ? f9 : 0.0f, (i2 & 512) != 0 ? 8.0f : f10, (i2 & 1024) != 0 ? f.b.a() : j, (i2 & 2048) != 0 ? MK5.a() : interfaceC10031ax6, (i2 & 4096) != 0 ? false : z, (i2 & 8192) != 0 ? null : on5, (i2 & 16384) != 0 ? AbstractC23676xK2.a() : j2, (i2 & 32768) != 0 ? AbstractC23676xK2.a() : j3, (i2 & 65536) != 0 ? a.a.a() : i);
    }

    public static final androidx.compose.ui.e d(androidx.compose.ui.e eVar) {
        return Q93.b() ? eVar.i(c(androidx.compose.ui.e.a, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null)) : eVar;
    }
}
