package ir.nasim;

import ir.nasim.C3419Au3;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.gW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13604gW3 {

    /* renamed from: ir.nasim.gW3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C3419Au3.e.values().length];
            try {
                iArr[C3419Au3.e.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C3419Au3.e.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C3419Au3.e.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C3419Au3.e.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[C3419Au3.e.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public static final List a(InterfaceC10436bc3 interfaceC10436bc3) {
        AbstractC13042fc3.g(interfaceC10436bc3, "null cannot be cast to non-null type androidx.compose.ui.node.MeasureScopeWithLayoutNode");
        C3419Au3 c3419Au3G1 = ((InterfaceC12986fW3) interfaceC10436bc3).G1();
        boolean zB = b(c3419Au3G1);
        List listV = c3419Au3G1.V();
        ArrayList arrayList = new ArrayList(listV.size());
        int size = listV.size();
        for (int i = 0; i < size; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) listV.get(i);
            arrayList.add(zB ? c3419Au3.P() : c3419Au3.Q());
        }
        return arrayList;
    }

    private static final boolean b(C3419Au3 c3419Au3) {
        int i = a.a[c3419Au3.g0().ordinal()];
        if (i == 1 || i == 2) {
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        C3419Au3 c3419Au3A0 = c3419Au3.A0();
        if (c3419Au3A0 != null) {
            return b(c3419Au3A0);
        }
        throw new IllegalArgumentException("no parent for idle node".toString());
    }
}
