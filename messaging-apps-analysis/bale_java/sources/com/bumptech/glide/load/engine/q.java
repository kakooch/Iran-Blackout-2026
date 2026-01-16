package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.i;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.DW5;
import ir.nasim.HL4;
import ir.nasim.InterfaceC20850si5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class q {
    private final Class a;
    private final InterfaceC20850si5 b;
    private final List c;
    private final String d;

    public q(Class cls, Class cls2, Class cls3, List list, InterfaceC20850si5 interfaceC20850si5) {
        this.a = cls;
        this.b = interfaceC20850si5;
        this.c = (List) AbstractC3322Aj5.c(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private DW5 b(com.bumptech.glide.load.data.a aVar, HL4 hl4, int i, int i2, i.a aVar2, List list) throws GlideException {
        int size = this.c.size();
        DW5 dw5A = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                dw5A = ((i) this.c.get(i3)).a(aVar, i, i2, hl4, aVar2);
            } catch (GlideException e) {
                list.add(e);
            }
            if (dw5A != null) {
                break;
            }
        }
        if (dw5A != null) {
            return dw5A;
        }
        throw new GlideException(this.d, new ArrayList(list));
    }

    public DW5 a(com.bumptech.glide.load.data.a aVar, HL4 hl4, int i, int i2, i.a aVar2) {
        List list = (List) AbstractC3322Aj5.d((List) this.b.b());
        try {
            return b(aVar, hl4, i, i2, aVar2, list);
        } finally {
            this.b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }
}
