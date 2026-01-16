package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10754c85;
import ir.nasim.AbstractC18939pW1;
import java.util.ArrayList;

/* renamed from: ir.nasim.xy6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC24061xy6 {
    private static int a = -1;

    public static C11507d74 b(C18823pJ2 c18823pJ2) {
        C11507d74 c11507d74 = new C11507d74(c18823pJ2);
        String strQ = C4044Dl2.q(c11507d74);
        if (c11507d74.u0()) {
            AbstractC10754c85.a aVarL = strQ != null ? C17481n23.T().L(strQ) : C17481n23.T().K(d(c11507d74.H()), c18823pJ2.i(), c11507d74.U());
            if (aVarL != null) {
                c11507d74.y = strQ;
                c11507d74.z = aVarL.b;
            } else {
                C19406qI3.b("baleMessages", "can't load image to file ");
            }
        } else if (c11507d74.v0()) {
            AbstractC18939pW1.a aVar = new AbstractC18939pW1.a();
            aVar.f = C17481n23.T().M(d(c11507d74.H()), c18823pJ2.i(), c11507d74.U());
            aVar.b = C3971Dd1.c().b();
            aVar.h = c11507d74.i();
            aVar.a = c11507d74.U();
            aVar.d = c11507d74.s0();
            aVar.e = c11507d74.H().z().f();
            aVar.c = c11507d74.i() + "_" + c11507d74.U() + ".jpg";
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.f);
            if (strQ == null) {
                strQ = C4044Dl2.m().j(2) + Separators.SLASH + aVar.c;
            }
            c11507d74.y = strQ;
            c11507d74.z = arrayList;
        } else if (c11507d74.t0()) {
            AbstractC18939pW1.a aVar2 = new AbstractC18939pW1.a();
            aVar2.b = C3971Dd1.c().b();
            aVar2.h = c11507d74.i();
            aVar2.a = c11507d74.U();
            aVar2.d = c11507d74.s0();
            aVar2.e = c11507d74.H().z().f();
            aVar2.c = c11507d74.i() + "_" + c11507d74.U() + ".mp3";
            c11507d74.y = strQ;
        }
        return c11507d74;
    }

    public static C11507d74 c(J44 j44, boolean z) {
        C11507d74 c11507d74 = new C11507d74(j44);
        String strQ = z ? C4044Dl2.q(c11507d74) : null;
        if (c11507d74.u0()) {
            AbstractC10754c85.a aVarL = strQ != null ? C17481n23.T().L(strQ) : C17481n23.T().K(d(c11507d74.H()), j44.i(), c11507d74.U());
            if (aVarL != null) {
                c11507d74.y = strQ;
                c11507d74.z = aVarL.b;
            } else {
                C19406qI3.b("baleMessages", "can't load image to file ");
            }
        } else if (c11507d74.v0()) {
            AbstractC18939pW1.a aVar = new AbstractC18939pW1.a();
            aVar.f = C17481n23.T().M(d(c11507d74.H()), j44.i(), c11507d74.U());
            aVar.b = C3971Dd1.c().b();
            aVar.h = c11507d74.i();
            aVar.a = c11507d74.U();
            aVar.d = c11507d74.s0();
            aVar.e = c11507d74.H().z().f();
            aVar.c = c11507d74.i() + "_" + c11507d74.U() + ".jpg";
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.f);
            if (strQ == null) {
                strQ = C4044Dl2.m().j(2) + Separators.SLASH + aVar.c;
            }
            c11507d74.y = strQ;
            c11507d74.z = arrayList;
        } else if (c11507d74.t0()) {
            AbstractC18939pW1.a aVar2 = new AbstractC18939pW1.a();
            aVar2.b = C3971Dd1.c().b();
            aVar2.h = c11507d74.i();
            aVar2.a = c11507d74.U();
            aVar2.d = c11507d74.s0();
            aVar2.e = c11507d74.H().z().f();
            aVar2.c = c11507d74.i() + "_" + c11507d74.U() + ".mp3";
            c11507d74.y = strQ;
        }
        return c11507d74;
    }

    private static byte[] d(C24967zW1 c24967zW1) {
        C22694vg2 c22694vg2V = c24967zW1 != null ? c24967zW1.v() : null;
        if (c22694vg2V != null) {
            return c22694vg2V.c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ArrayList arrayList, long j, int i, int i2, boolean z) {
        C15225jD4.b().c(C15225jD4.r, Long.valueOf(j), Integer.valueOf(arrayList.size()), arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public static void f(long j, int i, C11507d74 c11507d74, int i2, boolean z, int i3) {
        int i4 = (int) j;
        if (z || i4 == 0) {
            g(j, i, c11507d74, i2, i3);
        } else if (a < 0) {
            C19406qI3.b("baleMessages", "NewMessagesFragmentImpl or it's displayList is null");
        }
    }

    private static void g(long j, int i, C11507d74 c11507d74, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        try {
            try {
                a = -1;
                z = true;
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
            h(arrayList, j, i, c11507d74, i2, true, i3, z);
        } catch (Throwable th) {
            h(arrayList, j, i, c11507d74, i2, true, i3, z);
            throw th;
        }
    }

    private static void h(final ArrayList arrayList, final long j, int i, C11507d74 c11507d74, final int i2, boolean z, final int i3, final boolean z2) {
        int i4 = (int) j;
        if (z && arrayList.size() == 0 && i4 != 0) {
            f(j, i, c11507d74, i2, false, i3);
        } else {
            AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.wy6
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC24061xy6.e(arrayList, j, i3, i2, z2);
                }
            });
        }
    }
}
