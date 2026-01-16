package ir.nasim;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* renamed from: ir.nasim.fz1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13294fz1 {
    private final long a;
    private final Deque b = new LinkedList();
    private long c;

    public C13294fz1(long j) {
        this.a = j;
    }

    public final synchronized void a() {
        this.b.clear();
        this.c = 0L;
    }

    public final synchronized C13885gz1 b() {
        if (this.b.isEmpty()) {
            return null;
        }
        C13885gz1 c13885gz1 = (C13885gz1) this.b.removeFirst();
        this.c -= c13885gz1.a().capacity();
        return c13885gz1;
    }

    public final synchronized List c() {
        return AbstractC15401jX0.m1(this.b);
    }

    public final synchronized List d(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        while ((!this.b.isEmpty()) && ((C13885gz1) this.b.getFirst()).b() <= i) {
            C13885gz1 c13885gz1B = b();
            AbstractC13042fc3.f(c13885gz1B);
            arrayList.add(c13885gz1B);
        }
        return arrayList;
    }

    public final synchronized void e(C13885gz1 c13885gz1) {
        AbstractC13042fc3.i(c13885gz1, "item");
        this.b.add(c13885gz1);
        this.c += c13885gz1.a().capacity();
    }

    public final synchronized void f(long j) {
        while ((!this.b.isEmpty()) && this.c > this.a + j) {
            b();
        }
    }
}
