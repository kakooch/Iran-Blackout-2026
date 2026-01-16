package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ir.nasim.Yj7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9078Yj7 {
    public static Object a(Task task) throws InterruptedException {
        AbstractC3795Cj5.h();
        AbstractC3795Cj5.k(task, "Task must not be null");
        if (task.o()) {
            return f(task);
        }
        C24486yh8 c24486yh8 = new C24486yh8(null);
        g(task, c24486yh8);
        c24486yh8.b();
        return f(task);
    }

    public static Object b(Task task, long j, TimeUnit timeUnit) throws TimeoutException {
        AbstractC3795Cj5.h();
        AbstractC3795Cj5.k(task, "Task must not be null");
        AbstractC3795Cj5.k(timeUnit, "TimeUnit must not be null");
        if (task.o()) {
            return f(task);
        }
        C24486yh8 c24486yh8 = new C24486yh8(null);
        g(task, c24486yh8);
        if (c24486yh8.d(j, timeUnit)) {
            return f(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static Task c(Executor executor, Callable callable) {
        AbstractC3795Cj5.k(executor, "Executor must not be null");
        AbstractC3795Cj5.k(callable, "Callback must not be null");
        yv8 yv8Var = new yv8();
        executor.execute(new Qv8(yv8Var, callable));
        return yv8Var;
    }

    public static Task d(Exception exc) {
        yv8 yv8Var = new yv8();
        yv8Var.r(exc);
        return yv8Var;
    }

    public static Task e(Object obj) {
        yv8 yv8Var = new yv8();
        yv8Var.s(obj);
        return yv8Var;
    }

    private static Object f(Task task) throws ExecutionException {
        if (task.p()) {
            return task.l();
        }
        if (task.n()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.k());
    }

    private static void g(Task task, Eh8 eh8) {
        Executor executor = AbstractC6151Mj7.b;
        task.g(executor, eh8);
        task.e(executor, eh8);
        task.a(executor, eh8);
    }
}
