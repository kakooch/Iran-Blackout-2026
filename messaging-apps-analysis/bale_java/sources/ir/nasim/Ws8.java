package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public enum Ws8 implements InterfaceC14986io8 {
    INSTANCE;

    private static final AtomicReference b = new AtomicReference(null);

    public final void a(Qo8 qo8) {
        b.set(qo8);
    }

    @Override // ir.nasim.InterfaceC14986io8
    public final Qo8 zza() {
        return (Qo8) b.get();
    }
}
