package com.bumptech.glide.load.engine;

import android.util.Log;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.DW5;
import ir.nasim.HL4;
import ir.nasim.HW5;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.RW5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class i {
    private final Class a;
    private final List b;
    private final RW5 c;
    private final InterfaceC20850si5 d;
    private final String e;

    interface a {
        DW5 a(DW5 dw5);
    }

    public i(Class cls, Class cls2, Class cls3, List list, RW5 rw5, InterfaceC20850si5 interfaceC20850si5) {
        this.a = cls;
        this.b = list;
        this.c = rw5;
        this.d = interfaceC20850si5;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private DW5 b(com.bumptech.glide.load.data.a aVar, int i, int i2, HL4 hl4) {
        List list = (List) AbstractC3322Aj5.d((List) this.d.b());
        try {
            return c(aVar, i, i2, hl4, list);
        } finally {
            this.d.a(list);
        }
    }

    private DW5 c(com.bumptech.glide.load.data.a aVar, int i, int i2, HL4 hl4, List list) throws GlideException {
        int size = this.b.size();
        DW5 dw5A = null;
        for (int i3 = 0; i3 < size; i3++) {
            HW5 hw5 = (HW5) this.b.get(i3);
            try {
                if (hw5.b(aVar.c(), hl4)) {
                    dw5A = hw5.a(aVar.c(), i, i2, hl4);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + hw5, e);
                }
                list.add(e);
            }
            if (dw5A != null) {
                break;
            }
        }
        if (dw5A != null) {
            return dw5A;
        }
        throw new GlideException(this.e, new ArrayList(list));
    }

    public DW5 a(com.bumptech.glide.load.data.a aVar, int i, int i2, HL4 hl4, a aVar2) {
        return this.c.a(aVar2.a(b(aVar, i, i2, hl4)), hl4);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
