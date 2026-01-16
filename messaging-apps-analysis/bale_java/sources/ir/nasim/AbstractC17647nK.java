package ir.nasim;

import java.util.HashMap;

/* renamed from: ir.nasim.nK, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17647nK extends K6 {
    private static final RL j = AbstractC20507s76.f(1);
    private final HashMap f = new HashMap();
    private final HashMap g = new HashMap();
    private final HashMap h = new HashMap();
    private final String i = "AskableActor";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(long j2, Object obj, Object obj2) {
        D(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void F(long j2) {
        synchronized (this.f) {
            try {
                C7234Qv5 c7234Qv5 = (C7234Qv5) this.g.get(Long.valueOf(j2));
                C19406qI3.a("AskableActor", "Try to cancel " + j2 + " at: " + AbstractC13372g7.a(), new Object[0]);
                if (c7234Qv5 != null) {
                    C6517Nv5.F(new Exception("Ask TimeOut")).i0(c7234Qv5);
                    this.f.remove(Long.valueOf(j2));
                    this.g.remove(Long.valueOf(j2));
                }
                this.h.remove(Long.valueOf(j2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void D(long j2) {
        synchronized (this.f) {
            try {
                C10054b01 c10054b01 = (C10054b01) this.h.get(Long.valueOf(j2));
                C19406qI3.a("AskableActor", "Task " + j2 + " is done at: " + AbstractC13372g7.a(), new Object[0]);
                if (c10054b01 != null) {
                    c10054b01.a();
                    C7234Qv5 c7234Qv5 = (C7234Qv5) this.g.get(Long.valueOf(j2));
                    C6517Nv5 c6517Nv5 = (C6517Nv5) this.f.get(Long.valueOf(j2));
                    if (c7234Qv5 != null && c6517Nv5 != null) {
                        c6517Nv5.i0(c7234Qv5);
                        this.f.remove(Long.valueOf(j2));
                        this.g.remove(Long.valueOf(j2));
                    }
                    this.h.remove(Long.valueOf(j2));
                }
                this.f.remove(Long.valueOf(j2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C6517Nv5 G(Object obj) {
        throw new RuntimeException("Not implemented");
    }

    @Override // ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (!(obj instanceof C14685iK)) {
            super.m(obj);
            return;
        }
        C14685iK c14685iK = (C14685iK) obj;
        try {
            C6517Nv5 c6517Nv5G = G(c14685iK.b());
            if (c6517Nv5G == null) {
                return;
            }
            final long jB = j.b();
            if (c14685iK.c() > 0) {
                C6517Nv5 c6517Nv5Z = c6517Nv5G.z(new InterfaceC3273Ae1() { // from class: ir.nasim.lK
                    @Override // ir.nasim.InterfaceC3273Ae1
                    public final void apply(Object obj2, Object obj3) {
                        this.a.E(jB, obj2, obj3);
                    }
                });
                this.g.put(Long.valueOf(jB), c14685iK.a());
                this.f.put(Long.valueOf(jB), c6517Nv5Z);
                C10054b01 c10054b01 = new C10054b01(new Runnable() { // from class: ir.nasim.mK
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.F(jB);
                    }
                });
                this.h.put(Long.valueOf(jB), c10054b01);
                c10054b01.d(c14685iK.c());
                C19406qI3.a("AskableActor", "Timer is started for " + jB + " at: " + AbstractC13372g7.a() + " in " + c14685iK.c() + "ms", new Object[0]);
            } else {
                c6517Nv5G.i0(c14685iK.a());
            }
        } catch (Exception e) {
            c14685iK.a().c(e);
            throw e;
        }
    }
}
