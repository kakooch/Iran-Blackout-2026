package j$.util.stream;

import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface C2<T> extends Consumer<T> {

    public static abstract class a<E_OUT> implements e {
        protected final C2 a;

        public a(C2 c2) {
            c2.getClass();
            this.a = c2;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.Consumer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d) {
            S1.a(this, d);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.a.m(j);
        }

        @Override // j$.util.stream.C2
        public boolean o() {
            return this.a.o();
        }
    }

    public static abstract class b<E_OUT> implements f {
        protected final C2 a;

        public b(C2 c2) {
            c2.getClass();
            this.a = c2;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.Consumer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            S1.b(this, num);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.a.m(j);
        }

        @Override // j$.util.stream.C2
        public boolean o() {
            return this.a.o();
        }
    }

    public static abstract class c<E_OUT> implements g {
        protected final C2 a;

        public c(C2 c2) {
            c2.getClass();
            this.a = c2;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.Consumer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l) {
            S1.c(this, l);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.a.m(j);
        }

        @Override // j$.util.stream.C2
        public boolean o() {
            return this.a.o();
        }
    }

    public static abstract class d<T, E_OUT> implements C2<T> {
        protected final C2 a;

        public d(C2 c2) {
            c2.getClass();
            this.a = c2;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(double d) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.C2, j$.util.function.y
        public /* synthetic */ void accept(int i) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.C2
        public /* synthetic */ void accept(long j) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.C2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.C2
        public void m(long j) {
            this.a.m(j);
        }

        @Override // j$.util.stream.C2
        public boolean o() {
            return this.a.o();
        }
    }

    public interface e extends C2<Double>, j$.util.function.s {
        @Override // j$.util.stream.C2
        void accept(double d);
    }

    public interface f extends C2<Integer>, j$.util.function.y {
        @Override // j$.util.stream.C2, j$.util.function.y
        void accept(int i);
    }

    public interface g extends C2<Long>, j$.util.function.E {
        @Override // j$.util.stream.C2
        void accept(long j);
    }

    void accept(double d2);

    void accept(int i);

    void accept(long j);

    void l();

    void m(long j);

    boolean o();
}
