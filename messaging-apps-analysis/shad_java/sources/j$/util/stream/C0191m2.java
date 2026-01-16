package j$.util.stream;

import j$.util.function.Consumer;
import java.util.Arrays;

/* renamed from: j$.util.stream.m2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0191m2 extends C0185l2 implements InterfaceC0219r1 {
    C0191m2(long j) {
        super(j);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(int i) {
        AbstractC0202o1.d(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        int i = this.b;
        long[] jArr = this.a;
        if (i >= jArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
        }
        this.b = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0225s1
    public /* bridge */ /* synthetic */ A1 b() {
        b();
        return this;
    }

    @Override // j$.util.stream.InterfaceC0219r1, j$.util.stream.InterfaceC0225s1
    public InterfaceC0255y1 b() {
        if (this.b >= this.a.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }

    @Override // j$.util.function.Consumer
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        AbstractC0202o1.c(this, l);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void n() {
        if (this.b < this.a.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.a.length)));
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        if (j != this.a.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.a.length)));
        }
        this.b = 0;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }

    @Override // j$.util.stream.C0185l2
    public String toString() {
        return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
    }
}
