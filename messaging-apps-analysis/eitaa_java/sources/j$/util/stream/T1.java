package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
interface T1<T> {

    public interface a<T> extends C2<T> {

        /* renamed from: j$.util.stream.T1$a$a, reason: collision with other inner class name */
        public interface InterfaceC0047a extends a<Double>, C2.e {
            @Override // j$.util.stream.T1.a
            b a();
        }

        public interface b extends a<Integer>, C2.f {
            @Override // j$.util.stream.T1.a
            c a();
        }

        public interface c extends a<Long>, C2.g {
            @Override // j$.util.stream.T1.a
            d a();
        }

        T1 a();
    }

    public interface b extends e<Double, j$.util.function.s, double[], Spliterator.a, b> {
    }

    public interface c extends e<Integer, j$.util.function.y, int[], Spliterator.b, c> {
    }

    public interface d extends e<Long, j$.util.function.E, long[], Spliterator.c, d> {
    }

    public interface e<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_NODE extends e<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends T1<T> {
        @Override // j$.util.stream.T1
        e b(int i);

        Object c(int i);

        void d(Object obj, int i);

        Object e();

        void g(Object obj);

        @Override // j$.util.stream.T1
        Spliterator.d spliterator();
    }

    T1 b(int i);

    long count();

    void forEach(Consumer consumer);

    void i(Object[] objArr, int i);

    int n();

    Object[] p(j$.util.function.z zVar);

    T1 q(long j, long j2, j$.util.function.z zVar);

    Spliterator spliterator();
}
