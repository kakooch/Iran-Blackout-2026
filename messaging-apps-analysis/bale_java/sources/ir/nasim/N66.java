package ir.nasim;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zzd;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class N66 {
    private static int h;
    private static PendingIntent i;
    private static final Executor j = new Executor() { // from class: ir.nasim.Rv8
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private static final Pattern k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    private final Context b;
    private final Tu8 c;
    private final ScheduledExecutorService d;
    private Messenger f;
    private zzd g;
    private final C24792zC6 a = new C24792zC6();
    private Messenger e = new Messenger(new HandlerC17279mh8(this, Looper.getMainLooper()));

    public N66(Context context) {
        this.b = context;
        this.c = new Tu8(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.d = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ Task b(Bundle bundle) {
        return j(bundle) ? AbstractC9078Yj7.e(null) : AbstractC9078Yj7.e(bundle);
    }

    static /* bridge */ /* synthetic */ void d(N66 n66, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new Nk8());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        n66.g = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        n66.f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String strValueOf = String.valueOf(action);
                        Log.d("Rpc", strValueOf.length() != 0 ? "Unexpected response action: ".concat(strValueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = k.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        n66.i(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String strValueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(strValueOf2);
                    Log.w("Rpc", sb.toString());
                    return;
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (n66.a) {
                        for (int i2 = 0; i2 < n66.a.size(); i2++) {
                            try {
                                n66.i((String) n66.a.g(i2), intent2.getExtras());
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
                    Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                n66.i(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    private final Task f(Bundle bundle) throws RemoteException {
        final String strG = g();
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        synchronized (this.a) {
            this.a.put(strG, c4982Hj7);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        h(this.b, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(strG).length() + 5);
        sb.append("|ID|");
        sb.append(strG);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 8);
            sb2.append("Sending ");
            sb2.append(strValueOf);
            Log.d("Rpc", sb2.toString());
        }
        intent.putExtra("google.messenger", this.e);
        if (this.f != null || this.g != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    this.g.b(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
        } else if (this.c.b() == 2) {
            this.b.sendBroadcast(intent);
        } else {
            this.b.startService(intent);
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.d.schedule(new Runnable() { // from class: ir.nasim.Lv8
            @Override // java.lang.Runnable
            public final void run() {
                if (c4982Hj7.d(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        c4982Hj7.a().c(j, new WI4() { // from class: ir.nasim.Av8
            @Override // ir.nasim.WI4
            public final void onComplete(Task task) {
                this.a.e(strG, scheduledFutureSchedule, task);
            }
        });
        return c4982Hj7.a();
    }

    private static synchronized String g() {
        int i2;
        i2 = h;
        h = i2 + 1;
        return Integer.toString(i2);
    }

    private static synchronized void h(Context context, Intent intent) {
        try {
            if (i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                i = Fg8.a(context, 0, intent2, Fg8.a);
            }
            intent.putExtra("app", i);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void i(String str, Bundle bundle) {
        synchronized (this.a) {
            try {
                C4982Hj7 c4982Hj7 = (C4982Hj7) this.a.remove(str);
                if (c4982Hj7 != null) {
                    c4982Hj7.c(bundle);
                } else {
                    String strValueOf = String.valueOf(str);
                    Log.w("Rpc", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean j(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task a(final Bundle bundle) {
        return this.c.a() < 12000000 ? this.c.b() != 0 ? f(bundle).j(j, new InterfaceC20886sm1() { // from class: ir.nasim.lv8
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task) {
                return this.a.c(bundle, task);
            }
        }) : AbstractC9078Yj7.d(new IOException("MISSING_INSTANCEID_SERVICE")) : com.google.android.gms.cloudmessaging.m.b(this.b).d(1, bundle).h(j, new InterfaceC20886sm1() { // from class: ir.nasim.sv8
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task) throws IOException {
                if (task.p()) {
                    return (Bundle) task.l();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    String strValueOf = String.valueOf(task.k());
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
                    sb.append("Error making request: ");
                    sb.append(strValueOf);
                    Log.d("Rpc", sb.toString());
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", task.k());
            }
        });
    }

    public final /* synthetic */ Task c(Bundle bundle, Task task) {
        return (task.p() && j((Bundle) task.l())) ? f(bundle).q(j, new G07() { // from class: ir.nasim.Fv8
            @Override // ir.nasim.G07
            public final Task a(Object obj) {
                return N66.b((Bundle) obj);
            }
        }) : task;
    }

    public final /* synthetic */ void e(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.a) {
            this.a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
