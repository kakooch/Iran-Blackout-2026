package ir.nasim;

import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.b83, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C10136b83 implements InterfaceC9542a83 {
    private final List a;
    private final Map b;

    public C10136b83(List list, Map map) {
        this.a = list;
        this.b = map;
    }

    @Override // ir.nasim.InterfaceC9542a83
    public C22401vA3 a(String str) {
        return (C22401vA3) this.b.get(str);
    }

    @Override // ir.nasim.InterfaceC9542a83
    public List b() {
        return this.a;
    }
}
