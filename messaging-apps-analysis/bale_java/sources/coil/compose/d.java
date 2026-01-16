package coil.compose;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC22917w23;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.T92;
import ir.nasim.TG3;
import ir.nasim.U92;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public abstract class d {
    public static final void a(Object obj, String str, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, boolean z, T92 t92, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3, int i4) {
        interfaceC22053ub1.A(1451072229);
        androidx.compose.ui.e eVar2 = (i4 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        UA2 ua2A = (i4 & 8) != 0 ? AsyncImagePainter.INSTANCE.a() : ua2;
        UA2 ua23 = (i4 & 16) != 0 ? null : ua22;
        InterfaceC12529em interfaceC12529emE = (i4 & 32) != 0 ? InterfaceC12529em.a.e() : interfaceC12529em;
        InterfaceC13157fl1 interfaceC13157fl1E = (i4 & 64) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        float f2 = (i4 & 128) != 0 ? 1.0f : f;
        AbstractC24975zX0 abstractC24975zX02 = (i4 & 256) != 0 ? null : abstractC24975zX0;
        int iB = (i4 & 512) != 0 ? InterfaceC17460n02.i0.b() : i;
        boolean z2 = (i4 & 1024) != 0 ? true : z;
        T92 t92A = (i4 & 2048) != 0 ? U92.a() : t92;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1451072229, i2, i3, "coil.compose.AsyncImage (SingletonAsyncImage.kt:161)");
        }
        int i5 = i2 << 3;
        int i6 = i3 << 3;
        a.b(obj, str, AbstractC22917w23.c(TG3.a(), interfaceC22053ub1, 6), eVar2, ua2A, ua23, interfaceC12529emE, interfaceC13157fl1E, f2, abstractC24975zX02, iB, z2, t92A, interfaceC22053ub1, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 520 | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), ((i2 >> 27) & 14) | (i6 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i6 & 896), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
    }
}
