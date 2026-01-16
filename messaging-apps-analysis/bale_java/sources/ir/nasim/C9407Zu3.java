package ir.nasim;

/* renamed from: ir.nasim.Zu3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C9407Zu3 implements InterfaceC7959Tx5 {
    private static final Object c = new Object();
    private volatile Object a = c;
    private volatile InterfaceC7959Tx5 b;

    public C9407Zu3(InterfaceC7959Tx5 interfaceC7959Tx5) {
        this.b = interfaceC7959Tx5;
    }

    @Override // ir.nasim.InterfaceC7959Tx5
    public Object get() {
        Object obj = this.a;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.a;
                    if (obj == obj2) {
                        obj = this.b.get();
                        this.a = obj;
                        this.b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
