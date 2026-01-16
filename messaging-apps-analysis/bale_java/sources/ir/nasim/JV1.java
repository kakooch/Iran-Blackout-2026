package ir.nasim;

/* loaded from: classes.dex */
final class JV1 implements YM5 {
    private final UA2 a;
    private KV1 b;

    public JV1(UA2 ua2) {
        this.a = ua2;
    }

    @Override // ir.nasim.YM5
    public void b() {
        this.b = (KV1) this.a.invoke(AbstractC10721c52.a);
    }

    @Override // ir.nasim.YM5
    public void e() {
        KV1 kv1 = this.b;
        if (kv1 != null) {
            kv1.dispose();
        }
        this.b = null;
    }

    @Override // ir.nasim.YM5
    public void d() {
    }
}
