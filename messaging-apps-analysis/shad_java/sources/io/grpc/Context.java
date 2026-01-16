package io.grpc;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class Context {
    final int generation = 0;
    static final Logger log = Logger.getLogger(Context.class.getName());
    public static final Context ROOT = new Context();

    public interface CancellationListener {
    }

    public Throwable cancellationCause() {
        return null;
    }

    public Deadline getDeadline() {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public void removeListener(CancellationListener cancellationListener) {
    }

    static Storage storage() {
        return LazyStorage.storage;
    }

    private static final class LazyStorage {
        static final Storage storage;

        static {
            AtomicReference atomicReference = new AtomicReference();
            storage = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                atomicReference.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    public static Context current() {
        Context contextCurrent = storage().current();
        return contextCurrent == null ? ROOT : contextCurrent;
    }

    private Context() {
        validateGeneration(0);
    }

    public Context attach() {
        Context contextDoAttach = storage().doAttach(this);
        return contextDoAttach == null ? ROOT : contextDoAttach;
    }

    public void detach(Context context) {
        checkNotNull(context, "toAttach");
        storage().detach(this, context);
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
    }

    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        @Deprecated
        public void attach(Context context) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public Context doAttach(Context context) {
            Context contextCurrent = current();
            attach(context);
            return contextCurrent;
        }
    }

    static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private static void validateGeneration(int i) {
        if (i == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }
}
