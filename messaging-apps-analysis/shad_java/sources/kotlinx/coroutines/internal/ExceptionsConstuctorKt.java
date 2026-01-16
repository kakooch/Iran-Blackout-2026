package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt {
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();

    public static final <E extends Throwable> E tryCopyException(E e) {
        Object objM542constructorimpl;
        ReentrantReadWriteLock.ReadLock lock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.Companion;
                objM542constructorimpl = Result.m542constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th));
            }
            return (E) (Result.m544isFailureimpl(objM542constructorimpl) ? null : objM542constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
        ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
        lock2.lock();
        try {
            Function1<Throwable, Throwable> function1 = exceptionCtors.get(e.getClass());
            if (function1 != null) {
                return (E) function1.invoke(e);
            }
            int i = 0;
            if (throwableFields != fieldsCountOrDefault(e.getClass(), 0)) {
                lock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    lock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    exceptionCtors.put(e.getClass(), new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(Throwable th2) {
                            return null;
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        lock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            Iterator it = ArraysKt___ArraysKt.sortedWith(e.getClass().getConstructors(), new Comparator<T>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
                }
            }).iterator();
            Function1<Throwable, Throwable> function1CreateConstructor = null;
            while (it.hasNext() && (function1CreateConstructor = createConstructor((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = cacheLock;
            lock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                lock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                exceptionCtors.put(e.getClass(), function1CreateConstructor != null ? function1CreateConstructor : new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(Throwable th2) {
                        return null;
                    }
                });
                Unit unit2 = Unit.INSTANCE;
                while (i < readHoldCount) {
                    lock.lock();
                    i++;
                }
                writeLock.unlock();
                if (function1CreateConstructor != null) {
                    return (E) function1CreateConstructor.invoke(e);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    lock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }

    private static final Function1<Throwable, Throwable> createConstructor(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable th) {
                    Object objM542constructorimpl;
                    Object objNewInstance;
                    try {
                        Result.Companion companion = Result.Companion;
                        objNewInstance = constructor.newInstance(new Object[0]);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    Throwable th3 = (Throwable) objNewInstance;
                    th3.initCause(th);
                    objM542constructorimpl = Result.m542constructorimpl(th3);
                    if (Result.m544isFailureimpl(objM542constructorimpl)) {
                        objM542constructorimpl = null;
                    }
                    return (Throwable) objM542constructorimpl;
                }
            };
        }
        if (length != 1) {
            if (length == 2 && Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable th) {
                        Object objM542constructorimpl;
                        Object objNewInstance;
                        try {
                            Result.Companion companion = Result.Companion;
                            objNewInstance = constructor.newInstance(th.getMessage(), th);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (objNewInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                        objM542constructorimpl = Result.m542constructorimpl((Throwable) objNewInstance);
                        if (Result.m544isFailureimpl(objM542constructorimpl)) {
                            objM542constructorimpl = null;
                        }
                        return (Throwable) objM542constructorimpl;
                    }
                };
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (Intrinsics.areEqual(cls, Throwable.class)) {
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable th) {
                    Object objM542constructorimpl;
                    Object objNewInstance;
                    try {
                        Result.Companion companion = Result.Companion;
                        objNewInstance = constructor.newInstance(th);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    objM542constructorimpl = Result.m542constructorimpl((Throwable) objNewInstance);
                    if (Result.m544isFailureimpl(objM542constructorimpl)) {
                        objM542constructorimpl = null;
                    }
                    return (Throwable) objM542constructorimpl;
                }
            };
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable th) {
                    Object objM542constructorimpl;
                    Object objNewInstance;
                    try {
                        Result.Companion companion = Result.Companion;
                        objNewInstance = constructor.newInstance(th.getMessage());
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    Throwable th3 = (Throwable) objNewInstance;
                    th3.initCause(th);
                    objM542constructorimpl = Result.m542constructorimpl(th3);
                    if (Result.m544isFailureimpl(objM542constructorimpl)) {
                        objM542constructorimpl = null;
                    }
                    return (Throwable) objM542constructorimpl;
                }
            };
        }
        return null;
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object objM542constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            objM542constructorimpl = Result.m542constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th));
        }
        Integer numValueOf = Integer.valueOf(i);
        if (Result.m544isFailureimpl(objM542constructorimpl)) {
            objM542constructorimpl = numValueOf;
        }
        return ((Number) objM542constructorimpl).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }
}
