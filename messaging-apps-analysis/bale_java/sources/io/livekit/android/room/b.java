package io.livekit.android.room;

import android.gov.nist.javax.sdp.fields.AttributeField;
import android.javax.sdp.SdpException;
import io.livekit.android.room.n;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20235rg3;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C23425wt7;
import ir.nasim.C24454ye6;
import ir.nasim.C3278Ae6;
import ir.nasim.C3517Be6;
import ir.nasim.C3751Ce6;
import ir.nasim.InterfaceC16586lX3;
import ir.nasim.XV4;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class b {
    public static final void a(InterfaceC16586lX3 interfaceC16586lX3, Map map) throws SdpException {
        String strA;
        Object next;
        boolean z;
        AbstractC13042fc3.i(interfaceC16586lX3, "media");
        AbstractC13042fc3.i(map, "trackBitrates");
        C3517Be6 c3517Be6C = AbstractC20235rg3.c(interfaceC16586lX3);
        if (c3517Be6C == null || (strA = c3517Be6C.a()) == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            n nVar = (n) entry.getKey();
            C23425wt7 c23425wt7 = (C23425wt7) entry.getValue();
            if (nVar instanceof n.a) {
                boolean z2 = false;
                int i = 2;
                Object obj = null;
                if (AbstractC20762sZ6.X(strA, ((n.a) nVar).a(), false, 2, null)) {
                    Iterator it = AbstractC20235rg3.d(interfaceC16586lX3).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (AbstractC20153rZ6.D(((C3751Ce6) ((XV4) next).b()).a(), c23425wt7.a(), true)) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    XV4 xv4 = (XV4) next;
                    if (xv4 != null) {
                        long jB = ((C3751Ce6) xv4.b()).b();
                        Iterator it2 = AbstractC20235rg3.b(interfaceC16586lX3).iterator();
                        boolean z3 = false;
                        while (true) {
                            if (!it2.hasNext()) {
                                z = z3;
                                break;
                            }
                            XV4 xv42 = (XV4) it2.next();
                            AttributeField attributeField = (AttributeField) xv42.a();
                            C3278Ae6 c3278Ae6 = (C3278Ae6) xv42.b();
                            if (c3278Ae6.b() == jB) {
                                String strA2 = c3278Ae6.a();
                                if (!AbstractC20762sZ6.X(c3278Ae6.a(), "x-google-start-bitrate", z2, i, obj)) {
                                    strA2 = strA2 + ";x-google-start-bitrate=" + AbstractC20723sV3.e(c23425wt7.b() * 0.7d);
                                }
                                if (!AbstractC20762sZ6.X(c3278Ae6.a(), "x-google-max-bitrate", false, 2, obj)) {
                                    strA2 = strA2 + ";x-google-max-bitrate=" + c23425wt7.b();
                                }
                                if (!AbstractC13042fc3.d(c3278Ae6.a(), strA2)) {
                                    attributeField.setValue(c3278Ae6.b() + ' ' + strA2);
                                    z = true;
                                    break;
                                }
                                z2 = false;
                                i = 2;
                                obj = null;
                                z3 = true;
                            }
                        }
                        if (!z) {
                            interfaceC16586lX3.addAttribute(new C3278Ae6(jB, "x-google-start-bitrate=" + (c23425wt7.b() * 0.7d) + ";x-google-max-bitrate=" + c23425wt7.b()).c());
                        }
                    }
                }
            }
        }
    }

    public static final void b(InterfaceC16586lX3 interfaceC16586lX3) {
        C3751Ce6 c3751Ce6;
        String strA;
        boolean z;
        AbstractC13042fc3.i(interfaceC16586lX3, "mediaDesc");
        XV4 xv4 = (XV4) AbstractC15401jX0.s0(AbstractC20235rg3.d(interfaceC16586lX3));
        if (xv4 == null || (c3751Ce6 = (C3751Ce6) xv4.f()) == null || (strA = c3751Ce6.a()) == null || !c(strA)) {
            return;
        }
        List listA = AbstractC20235rg3.a(interfaceC16586lX3);
        boolean z2 = false;
        long jB = 0;
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C24454ye6 c24454ye6 = (C24454ye6) ((XV4) it.next()).b();
                if (AbstractC13042fc3.d(c24454ye6.a(), "https://aomediacodec.github.io/av1-rtp-spec/#dependency-descriptor-rtp-header-extension")) {
                    z = true;
                } else {
                    if (c24454ye6.b() > jB) {
                        jB = c24454ye6.b();
                    }
                    z = false;
                }
                if (z) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            return;
        }
        interfaceC16586lX3.addAttribute(new C24454ye6(jB + 1, null, null, "https://aomediacodec.github.io/av1-rtp-spec/#dependency-descriptor-rtp-header-extension", null).c());
    }

    public static final boolean c(String str) {
        return str != null && (AbstractC20153rZ6.D("av1", str, true) || AbstractC20153rZ6.D("vp9", str, true));
    }
}
