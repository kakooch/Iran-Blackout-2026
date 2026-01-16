package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.wrappers.C0280i0;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j$.util.stream.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0200o implements Consumer, j$.util.function.z {
    public final /* synthetic */ int a = 5;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C0200o(BiConsumer biConsumer, Object obj) {
        this.b = biConsumer;
        this.c = obj;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        switch (this.a) {
            case 0:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.c;
                if (obj != null) {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    break;
                } else {
                    atomicBoolean.set(true);
                    break;
                }
            case 5:
                ((BiConsumer) this.b).accept(this.c, obj);
                break;
            default:
                ((C0199n4) this.b).f((Consumer) this.c, obj);
                break;
        }
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
            case 0:
                break;
            case 5:
                break;
        }
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.z
    public Object get() {
        switch (this.a) {
            case 1:
                return new C0166i1((EnumC0178k1) this.b, (j$.wrappers.D) this.c);
            case 2:
                return new C0154g1((EnumC0178k1) this.b, (j$.wrappers.U) this.c);
            case 3:
                return new C0160h1((EnumC0178k1) this.b, (C0280i0) this.c);
            default:
                return new C0148f1((EnumC0178k1) this.b, (j$.util.function.y) this.c);
        }
    }

    public /* synthetic */ C0200o(EnumC0178k1 enumC0178k1, j$.util.function.y yVar) {
        this.b = enumC0178k1;
        this.c = yVar;
    }

    public /* synthetic */ C0200o(EnumC0178k1 enumC0178k1, j$.wrappers.D d) {
        this.b = enumC0178k1;
        this.c = d;
    }

    public /* synthetic */ C0200o(EnumC0178k1 enumC0178k1, j$.wrappers.U u) {
        this.b = enumC0178k1;
        this.c = u;
    }

    public /* synthetic */ C0200o(EnumC0178k1 enumC0178k1, C0280i0 c0280i0) {
        this.b = enumC0178k1;
        this.c = c0280i0;
    }

    public /* synthetic */ C0200o(C0199n4 c0199n4, Consumer consumer) {
        this.b = c0199n4;
        this.c = consumer;
    }

    public /* synthetic */ C0200o(AtomicBoolean atomicBoolean, ConcurrentHashMap concurrentHashMap) {
        this.b = atomicBoolean;
        this.c = concurrentHashMap;
    }
}
