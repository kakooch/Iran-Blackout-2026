package kotlinx.coroutines.flow;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    boolean compareAndSet(T t, T t2);

    T getValue();
}
