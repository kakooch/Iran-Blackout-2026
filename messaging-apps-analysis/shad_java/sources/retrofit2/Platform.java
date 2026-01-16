package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes5.dex */
class Platform {
    private static final Platform PLATFORM = findPlatform();

    Executor defaultCallbackExecutor() {
        return null;
    }

    int defaultConverterFactoriesSize() {
        return 0;
    }

    boolean isDefaultMethod(Method method) {
        return false;
    }

    Platform() {
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() throws ClassNotFoundException {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new Java8();
        } catch (ClassNotFoundException unused2) {
            return new Platform();
        }
    }

    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
        if (executor != null) {
            return Collections.singletonList(new ExecutorCallAdapterFactory(executor));
        }
        return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    static class Java8 extends Platform {
        @Override // retrofit2.Platform
        int defaultConverterFactoriesSize() {
            return 1;
        }

        Java8() {
        }

        @Override // retrofit2.Platform
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }

        @Override // retrofit2.Platform
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.Platform
        List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(CompletableFutureCallAdapterFactory.INSTANCE);
            if (executor != null) {
                arrayList.add(new ExecutorCallAdapterFactory(executor));
            } else {
                arrayList.add(DefaultCallAdapterFactory.INSTANCE);
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override // retrofit2.Platform
        List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }
    }

    static class Android extends Platform {
        Android() {
        }

        @Override // retrofit2.Platform
        boolean isDefaultMethod(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            ExecutorCallAdapterFactory executorCallAdapterFactory = new ExecutorCallAdapterFactory(executor);
            return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, executorCallAdapterFactory) : Collections.singletonList(executorCallAdapterFactory);
        }

        @Override // retrofit2.Platform
        List<? extends Converter.Factory> defaultConverterFactories() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(OptionalConverterFactory.INSTANCE);
            }
            return Collections.emptyList();
        }

        @Override // retrofit2.Platform
        int defaultConverterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }
    }
}
