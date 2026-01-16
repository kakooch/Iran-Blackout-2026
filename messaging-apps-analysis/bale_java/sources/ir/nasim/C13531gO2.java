package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.gO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13531gO2 extends AbstractC18385oa2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final ArrayList a;
    private final boolean b;

    /* renamed from: ir.nasim.gO2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C13531gO2(ArrayList arrayList, boolean z) {
        AbstractC13042fc3.i(arrayList, "uIds");
        this.a = arrayList;
        this.b = z;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "group_visible";
    }

    public final ArrayList b() {
        return this.a;
    }
}
