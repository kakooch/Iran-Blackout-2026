package ir.nasim;

/* renamed from: ir.nasim.bV2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC10344bV2 {

    /* renamed from: ir.nasim.bV2$a */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int a;

        a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    a b(String str);
}
