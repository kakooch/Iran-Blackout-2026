package ir.nasim;

import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.util.ArrayList;

/* renamed from: ir.nasim.Yc1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9009Yc1 {
    private SJ1 c;
    private C13274fx e;
    private String i;
    private final ArrayList a = new ArrayList();
    private final ArrayList b = new ArrayList();
    private boolean d = false;
    private int f = 100;
    private int g = 15000;
    private int h = 50;
    private final ArrayList j = new ArrayList();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.C9009Yc1 a(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9009Yc1.a(java.lang.String):ir.nasim.Yc1");
    }

    public C9009Yc1 b(String str) {
        if (!this.j.contains(str)) {
            this.j.add(str);
        }
        return this;
    }

    public C9009Yc1 c(String str) {
        this.a.add(new C18610ow7(str));
        return this;
    }

    public C8468Wc1 d() {
        this.a.add(0, new C18610ow7("7675fdb8f3bad0df14e766973c2ab0cc0881063cc29f0d62e6ffaab1c9959f52"));
        if (this.b.size() == 0) {
            throw new RuntimeException("Endpoints not set");
        }
        if (this.c == null) {
            throw new RuntimeException("Phonebook Provider not set");
        }
        if (this.e == null) {
            throw new RuntimeException("Api Configuration not set");
        }
        ArrayList arrayList = this.b;
        ConnectionEndpoint[] connectionEndpointArr = (ConnectionEndpoint[]) arrayList.toArray(new ConnectionEndpoint[arrayList.size()]);
        SJ1 sj1 = this.c;
        C13274fx c13274fx = this.e;
        int i = this.f;
        int i2 = this.g;
        int i3 = this.h;
        String str = this.i;
        ArrayList arrayList2 = this.j;
        String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        ArrayList arrayList3 = this.a;
        return new C8468Wc1(connectionEndpointArr, sj1, c13274fx, i, i2, i3, str, strArr, (C18610ow7[]) arrayList3.toArray(new C18610ow7[arrayList3.size()]));
    }

    public C9009Yc1 e(C13274fx c13274fx) {
        this.e = c13274fx;
        return this;
    }

    public C9009Yc1 f(SJ1 sj1) {
        this.c = sj1;
        return this;
    }

    public C9009Yc1 g(String str) {
        this.i = str;
        return this;
    }
}
