package j$.util;

import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;

/* loaded from: classes2.dex */
public interface s<T, T_CONS> extends java.util.Iterator<T>, Iterator {

    public interface a extends s<Double, j$.util.function.s> {
        void e(j$.util.function.s sVar);

        void forEachRemaining(Consumer consumer);

        @Override // java.util.Iterator, j$.util.Iterator
        Double next();

        double nextDouble();
    }

    public interface b extends s<Integer, y> {
        void c(y yVar);

        void forEachRemaining(Consumer consumer);

        @Override // java.util.Iterator, j$.util.Iterator
        Integer next();

        int nextInt();
    }

    public interface c extends s<Long, E> {
        void d(E e);

        void forEachRemaining(Consumer consumer);

        @Override // java.util.Iterator, j$.util.Iterator
        Long next();

        long nextLong();
    }

    void forEachRemaining(Object obj);
}
