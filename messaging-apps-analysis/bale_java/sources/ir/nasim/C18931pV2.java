package ir.nasim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: ir.nasim.pV2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18931pV2 extends C16651le1 implements InterfaceC17158mV2 {
    public C16651le1[] V0 = new C16651le1[4];
    public int W0 = 0;

    @Override // ir.nasim.InterfaceC17158mV2
    public void a(C16651le1 c16651le1) {
        if (c16651le1 == this || c16651le1 == null) {
            return;
        }
        int i = this.W0 + 1;
        C16651le1[] c16651le1Arr = this.V0;
        if (i > c16651le1Arr.length) {
            this.V0 = (C16651le1[]) Arrays.copyOf(c16651le1Arr, c16651le1Arr.length * 2);
        }
        C16651le1[] c16651le1Arr2 = this.V0;
        int i2 = this.W0;
        c16651le1Arr2[i2] = c16651le1;
        this.W0 = i2 + 1;
    }

    @Override // ir.nasim.InterfaceC17158mV2
    public void c() {
        this.W0 = 0;
        Arrays.fill(this.V0, (Object) null);
    }

    @Override // ir.nasim.C16651le1
    public void n(C16651le1 c16651le1, HashMap map) {
        super.n(c16651le1, map);
        C18931pV2 c18931pV2 = (C18931pV2) c16651le1;
        this.W0 = 0;
        int i = c18931pV2.W0;
        for (int i2 = 0; i2 < i; i2++) {
            a((C16651le1) map.get(c18931pV2.V0[i2]));
        }
    }

    public void q1(ArrayList arrayList, int i, C14590i98 c14590i98) {
        for (int i2 = 0; i2 < this.W0; i2++) {
            c14590i98.a(this.V0[i2]);
        }
        for (int i3 = 0; i3 < this.W0; i3++) {
            AbstractC19459qO2.a(this.V0[i3], i, arrayList, c14590i98);
        }
    }

    public int r1(int i) {
        int i2;
        int i3;
        for (int i4 = 0; i4 < this.W0; i4++) {
            C16651le1 c16651le1 = this.V0[i4];
            if (i == 0 && (i3 = c16651le1.S0) != -1) {
                return i3;
            }
            if (i == 1 && (i2 = c16651le1.T0) != -1) {
                return i2;
            }
        }
        return -1;
    }

    public void b(C17242me1 c17242me1) {
    }
}
