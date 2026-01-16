package ir.nasim;

import androidx.compose.ui.draw.ShadowGraphicsLayerElement;

/* renamed from: ir.nasim.Lw6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6033Lw6 {
    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, float f, InterfaceC10031ax6 interfaceC10031ax6, boolean z, long j, long j2) {
        return (C17784nZ1.p(f, C17784nZ1.q((float) 0)) > 0 || z) ? eVar.i(new ShadowGraphicsLayerElement(f, interfaceC10031ax6, z, j, j2, null)) : eVar;
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, float f, InterfaceC10031ax6 interfaceC10031ax6, boolean z, long j, long j2, int i, Object obj) {
        boolean z2;
        InterfaceC10031ax6 interfaceC10031ax6A = (i & 2) != 0 ? MK5.a() : interfaceC10031ax6;
        if ((i & 4) != 0) {
            z2 = false;
            if (C17784nZ1.p(f, C17784nZ1.q(0)) > 0) {
                z2 = true;
            }
        } else {
            z2 = z;
        }
        return a(eVar, f, interfaceC10031ax6A, z2, (i & 8) != 0 ? AbstractC23676xK2.a() : j, (i & 16) != 0 ? AbstractC23676xK2.a() : j2);
    }
}
