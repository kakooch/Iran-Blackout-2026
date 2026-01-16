package ir.nasim;

import java.util.Queue;

/* renamed from: ir.nasim.fg4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13110fg4 {
    private final C15887kL3 a;

    /* renamed from: ir.nasim.fg4$a */
    class a extends C15887kL3 {
        a(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.C15887kL3
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b bVar, Object obj) {
            bVar.c();
        }
    }

    /* renamed from: ir.nasim.fg4$b */
    static final class b {
        private static final Queue d = YM7.g(0);
        private int a;
        private int b;
        private Object c;

        private b() {
        }

        static b a(Object obj, int i, int i2) {
            b bVar;
            Queue queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.b(obj, i, i2);
            return bVar;
        }

        private void b(Object obj, int i, int i2) {
            this.c = obj;
            this.b = i;
            this.a = i2;
        }

        public void c() {
            Queue queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c);
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public C13110fg4(long j) {
        this.a = new a(j);
    }

    public Object a(Object obj, int i, int i2) {
        b bVarA = b.a(obj, i, i2);
        Object objG = this.a.g(bVarA);
        bVarA.c();
        return objG;
    }

    public void b(Object obj, int i, int i2, Object obj2) {
        this.a.k(b.a(obj, i, i2), obj2);
    }
}
