package ir.nasim.core.modules.file.upload;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.lifecycle.DefaultLifecycleObserver;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19067pj3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9374Zq6;
import ir.nasim.C12889fL5;
import ir.nasim.C16446lH7;
import ir.nasim.C19115po1;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C5735Kp4;
import ir.nasim.E84;
import ir.nasim.ED1;
import ir.nasim.EnumC23558x74;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC12532em2;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J44;
import ir.nasim.L0;
import ir.nasim.Q64;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.W25;
import ir.nasim.XV4;
import ir.nasim.YG7;
import ir.nasim.core.modules.file.upload.UploadService;
import ir.nasim.features.root.RootActivity;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 e2\u00020\u0001:\u0003fghB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u0003J)\u0010 \u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010\u0003R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00107\u001a\b\u0018\u000104R\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010K\u001a\u00020D8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010S\u001a\u00020L8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010[\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR(\u0010d\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b]\u0010^\u0012\u0004\bc\u0010\u0003\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006i"}, d2 = {"Lir/nasim/core/modules/file/upload/UploadService;", "Landroid/app/Service;", "<init>", "()V", "Lir/nasim/core/modules/file/upload/UploadService$a;", "command", "", "y", "(Lir/nasim/core/modules/file/upload/UploadService$a;)I", "Lir/nasim/gj3;", "B", "()Lir/nasim/gj3;", "Lir/nasim/rB7;", "H", "(Lir/nasim/rm1;)Ljava/lang/Object;", TokenNames.F, "Lir/nasim/YG7;", "details", "Lir/nasim/Q64;", "messageId", "Landroid/app/PendingIntent;", "p", "(Lir/nasim/YG7;Lir/nasim/Q64;)Landroid/app/PendingIntent;", "A", "D", TokenNames.E, "z", "onCreate", "Landroid/content/Intent;", "intent", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "p0", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "rootIntent", "onTaskRemoved", "(Landroid/content/Intent;)V", "onDestroy", "Lir/nasim/lH7;", "d", "Lir/nasim/lH7;", "notificationManager", "Landroid/os/PowerManager;", "e", "Lir/nasim/Yu3;", "w", "()Landroid/os/PowerManager;", "powerManager", "Landroid/os/PowerManager$WakeLock;", "f", "Landroid/os/PowerManager$WakeLock;", "wakeLock", "Lir/nasim/ho1;", "g", "Lir/nasim/ho1;", "exceptionHandler", "Lir/nasim/ro1;", "h", "s", "()Lir/nasim/ro1;", "coroutineScope", "i", "Lir/nasim/gj3;", "notificationLauncherJob", "Landroid/app/AlarmManager;", "j", "Landroid/app/AlarmManager;", "r", "()Landroid/app/AlarmManager;", "setAlarmManager", "(Landroid/app/AlarmManager;)V", "alarmManager", "Lir/nasim/em2;", "k", "Lir/nasim/em2;", "t", "()Lir/nasim/em2;", "setFileRepository", "(Lir/nasim/em2;)V", "fileRepository", "Lir/nasim/E84;", "l", "Lir/nasim/E84;", "v", "()Lir/nasim/E84;", "setMessagesModule", "(Lir/nasim/E84;)V", "messagesModule", "Lir/nasim/go1;", "m", "Lir/nasim/go1;", "u", "()Lir/nasim/go1;", "setIoDispatcher", "(Lir/nasim/go1;)V", "getIoDispatcher$annotations", "ioDispatcher", "n", "a", "c", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class UploadService extends Hilt_UploadService {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int o = 8;

    /* renamed from: d, reason: from kotlin metadata */
    private C16446lH7 notificationManager;

    /* renamed from: f, reason: from kotlin metadata */
    private PowerManager.WakeLock wakeLock;

    /* renamed from: i, reason: from kotlin metadata */
    private InterfaceC13730gj3 notificationLauncherJob;

    /* renamed from: j, reason: from kotlin metadata */
    public AlarmManager alarmManager;

    /* renamed from: k, reason: from kotlin metadata */
    public InterfaceC12532em2 fileRepository;

    /* renamed from: l, reason: from kotlin metadata */
    public E84 messagesModule;

    /* renamed from: m, reason: from kotlin metadata */
    public AbstractC13778go1 ioDispatcher;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 powerManager = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rH7
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return UploadService.x(this.a);
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    private final InterfaceC14371ho1 exceptionHandler = new e(InterfaceC14371ho1.h0, this);

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 coroutineScope = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.sH7
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return UploadService.o(this.a);
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class a {
        public static final a a = new a("START", 0);
        public static final a b = new a("STICKY", 1);
        public static final a c = new a("NOT_STICKY", 2);
        public static final a d = new a("STOP", 3);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d};
        }

        public static F92 j() {
            return f;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.core.modules.file.upload.UploadService$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent d(Context context, a aVar) {
            Intent intent = new Intent(context, (Class<?>) UploadService.class);
            intent.setAction(aVar.name());
            return intent;
        }

        private final PendingIntent e(Context context, a aVar, int i) {
            PendingIntent service = PendingIntent.getService(context, i, d(context, aVar), 1140850688);
            AbstractC13042fc3.h(service, "getService(...)");
            return service;
        }

        static /* synthetic */ PendingIntent f(Companion companion, Context context, a aVar, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.e(context, aVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(Context context, Intent intent) {
            try {
                context.startService(intent);
            } catch (IllegalStateException e) {
                C19406qI3.c("UploadService", "Failed to start the service with intent(action=" + intent.getAction() + Separators.RPAREN, e);
            }
        }

        public final void c(Context context, InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
            C19406qI3.a("UploadService", "bindToService()", new Object[0]);
            try {
                g(context, d(context, a.a));
                interfaceC18633oz3.getLifecycle().a(new c(context));
            } catch (Exception e) {
                C19406qI3.j("UploadService", "Failed to bind the service.", e);
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private static final class c implements DefaultLifecycleObserver {
        private final Context a;
        private ServiceConnection b;

        public static final class a implements ServiceConnection {
            a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                C19406qI3.a("UploadService", "onServiceConnected()", new Object[0]);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C19406qI3.a("UploadService", "onServiceDisconnected()", new Object[0]);
            }
        }

        public c(Context context) {
            AbstractC13042fc3.i(context, "context");
            this.a = context;
        }

        private final void a() {
            C19406qI3.a("UploadService", "bind(" + this.b + Separators.RPAREN, new Object[0]);
            if (this.b != null) {
                return;
            }
            ServiceConnection serviceConnectionB = b();
            this.b = serviceConnectionB;
            this.a.bindService(new Intent(this.a, (Class<?>) UploadService.class), serviceConnectionB, 1);
        }

        private final ServiceConnection b() {
            return new a();
        }

        private final void d() {
            C19406qI3.a("UploadService", "unbind(" + this.b + Separators.RPAREN, new Object[0]);
            ServiceConnection serviceConnection = this.b;
            if (serviceConnection != null) {
                this.a.unbindService(serviceConnection);
            }
            this.b = null;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            C19406qI3.a("UploadService", "onDestroy()", new Object[0]);
            interfaceC18633oz3.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            C19406qI3.a("UploadService", "onStart()", new Object[0]);
            a();
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            C19406qI3.a("UploadService", "onStop()", new Object[0]);
            d();
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public static final class e extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ UploadService b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC14371ho1.a aVar, UploadService uploadService) {
            super(aVar);
            this.b = uploadService;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            C19406qI3.d("UploadService", th);
            this.b.E();
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ UploadService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UploadService uploadService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = uploadService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    UploadService uploadService = this.c;
                    this.b = 1;
                    if (uploadService.H(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ UploadService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(UploadService uploadService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = uploadService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    UploadService uploadService = this.c;
                    this.b = 1;
                    if (uploadService.F(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = UploadService.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(UploadService.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(UploadService.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ UploadService c;
            final /* synthetic */ YG7 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UploadService uploadService, YG7 yg7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = uploadService;
                this.d = yg7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.c.v().H0(this.d.c()).a(this.d.b());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = UploadService.this.new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            YG7 yg7;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            C16446lH7 c16446lH7 = null;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                YG7 yg72 = (YG7) this.c;
                if (yg72 == null) {
                    C16446lH7 c16446lH72 = UploadService.this.notificationManager;
                    if (c16446lH72 == null) {
                        AbstractC13042fc3.y("notificationManager");
                        c16446lH72 = null;
                    }
                    c16446lH72.g(null);
                    return C19938rB7.a;
                }
                AbstractC19067pj3.n(getContext());
                C16446lH7 c16446lH73 = UploadService.this.notificationManager;
                if (c16446lH73 == null) {
                    AbstractC13042fc3.y("notificationManager");
                    c16446lH73 = null;
                }
                c16446lH73.g(UploadService.q(UploadService.this, yg72, null, 2, null));
                AbstractC13778go1 abstractC13778go1U = UploadService.this.u();
                a aVar = new a(UploadService.this, yg72, null);
                this.c = yg72;
                this.b = 1;
                Object objG = AbstractC9323Zl0.g(abstractC13778go1U, aVar, this);
                if (objG == objE) {
                    return objE;
                }
                yg7 = yg72;
                obj = objG;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                yg7 = (YG7) this.c;
                AbstractC10685c16.b(obj);
            }
            J44 j44 = (J44) obj;
            if (j44 != null) {
                if (j44.L() != EnumC23558x74.PENDING) {
                    j44 = null;
                }
                if (j44 != null) {
                    AbstractC19067pj3.n(getContext());
                    Q64 q64 = new Q64(j44.h(), j44.i());
                    C16446lH7 c16446lH74 = UploadService.this.notificationManager;
                    if (c16446lH74 == null) {
                        AbstractC13042fc3.y("notificationManager");
                    } else {
                        c16446lH7 = c16446lH74;
                    }
                    c16446lH7.g(UploadService.this.p(yg7, q64));
                    return C19938rB7.a;
                }
            }
            C19406qI3.j("UploadService", "Failed to get the uploading message", new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(YG7 yg7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(yg7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ C12889fL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = UploadService.this.new h(this.e, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            YG7 yg7 = (YG7) this.c;
            C16446lH7 c16446lH7 = UploadService.this.notificationManager;
            if (c16446lH7 == null) {
                AbstractC13042fc3.y("notificationManager");
                c16446lH7 = null;
            }
            c16446lH7.h(yg7);
            Object obj2 = this.e.a;
            if (obj2 == null && yg7 != null) {
                UploadService.this.A();
            } else if (obj2 != null && yg7 == null) {
                UploadService.this.D();
            }
            this.e.a = yg7;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(YG7 yg7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(yg7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        C19406qI3.a("UploadService", "startForeground()", new Object[0]);
        C16446lH7 c16446lH7 = this.notificationManager;
        C16446lH7 c16446lH72 = null;
        if (c16446lH7 == null) {
            AbstractC13042fc3.y("notificationManager");
            c16446lH7 = null;
        }
        int iE = c16446lH7.e();
        C16446lH7 c16446lH73 = this.notificationManager;
        if (c16446lH73 == null) {
            AbstractC13042fc3.y("notificationManager");
        } else {
            c16446lH72 = c16446lH73;
        }
        AbstractC9374Zq6.a(this, iE, c16446lH72.d(), 1);
        PowerManager.WakeLock wakeLockNewWakeLock = this.wakeLock;
        if (wakeLockNewWakeLock == null) {
            wakeLockNewWakeLock = w().newWakeLock(1, "ir.nasim.bale:upload_service_lock");
            this.wakeLock = wakeLockNewWakeLock;
        }
        if (!wakeLockNewWakeLock.isHeld()) {
            wakeLockNewWakeLock.acquire();
        }
        Companion companion = INSTANCE;
        companion.g(this, companion.d(this, a.b));
    }

    private final InterfaceC13730gj3 B() {
        C19406qI3.a("UploadService", "startService()", new Object[0]);
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(s(), null, null, new f(null), 3, null);
        interfaceC13730gj3D.s(new UA2() { // from class: ir.nasim.tH7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return UploadService.C(this.a, (Throwable) obj);
            }
        });
        return interfaceC13730gj3D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(UploadService uploadService, Throwable th) {
        AbstractC13042fc3.i(uploadService, "this$0");
        if (th != null && !(th instanceof CancellationException)) {
            C19406qI3.c("UploadService", "Observer canceled with " + th.getMessage(), th);
        }
        C16446lH7 c16446lH7 = uploadService.notificationManager;
        if (c16446lH7 == null) {
            AbstractC13042fc3.y("notificationManager");
            c16446lH7 = null;
        }
        c16446lH7.g(null);
        c16446lH7.h(null);
        uploadService.D();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        C19406qI3.a("UploadService", "stopForeground()", new Object[0]);
        AbstractC9374Zq6.b(this, 1);
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
        this.wakeLock = null;
        Companion companion = INSTANCE;
        companion.g(this, companion.d(this, a.c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        C19406qI3.a("UploadService", "stopService()", new Object[0]);
        InterfaceC13730gj3 interfaceC13730gj3 = this.notificationLauncherJob;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.notificationLauncherJob = null;
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object F(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.x(t().d(), new UA2() { // from class: ir.nasim.uH7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return UploadService.G((YG7) obj);
            }
        }), new g(null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final XV4 G(YG7 yg7) {
        return AbstractC4616Fw7.a(yg7 != null ? yg7.c() : null, yg7 != null ? Long.valueOf(yg7.b()) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(t().d(), new h(new C12889fL5(), null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC20315ro1 o(UploadService uploadService) {
        AbstractC13042fc3.i(uploadService, "this$0");
        return AbstractC20906so1.a(new C19115po1(uploadService.getClass().getSimpleName() + "Scope").X(uploadService.exceptionHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent p(YG7 details, Q64 messageId) {
        RootActivity.Companion companion = RootActivity.INSTANCE;
        int peerId = details.c().getPeerId();
        W25 w25S = details.c().s();
        AbstractC13042fc3.h(w25S, "getPeerType(...)");
        PendingIntent activity = PendingIntent.getActivity(this, 0, RootActivity.Companion.b(companion, this, peerId, w25S, messageId, false, 16, null), 167772160);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    static /* synthetic */ PendingIntent q(UploadService uploadService, YG7 yg7, Q64 q64, int i, Object obj) {
        if ((i & 2) != 0) {
            q64 = null;
        }
        return uploadService.p(yg7, q64);
    }

    private final InterfaceC20315ro1 s() {
        return (InterfaceC20315ro1) this.coroutineScope.getValue();
    }

    private final PowerManager w() {
        return (PowerManager) this.powerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerManager x(UploadService uploadService) {
        AbstractC13042fc3.i(uploadService, "this$0");
        Object systemService = uploadService.getSystemService("power");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return (PowerManager) systemService;
    }

    private final int y(a command) {
        C19406qI3.a("UploadService", "processCommand(" + command + Separators.RPAREN, new Object[0]);
        int i = d.a[command.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                E();
            }
        } else if (this.notificationLauncherJob == null) {
            this.notificationLauncherJob = B();
        }
        return 2;
    }

    private final void z() {
        r().set(3, SystemClock.elapsedRealtime() + AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, Companion.f(INSTANCE, this, a.a, 0, 4, null));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent p0) {
        return new Binder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.core.modules.file.upload.Hilt_UploadService, android.app.Service
    public void onCreate() {
        C19406qI3.a("UploadService", "onCreate()", new Object[0]);
        C5735Kp4.w().L();
        super.onCreate();
        C16446lH7 c16446lH7 = new C16446lH7(this, null, 2, 0 == true ? 1 : 0);
        c16446lH7.f();
        this.notificationManager = c16446lH7;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) s().getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.notificationLauncherJob = null;
        C19406qI3.a("UploadService", "onDestroy()", new Object[0]);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Object obj = null;
        C19406qI3.a("UploadService", "onStartCommand(" + (intent != null ? intent.getAction() : null) + Separators.RPAREN, new Object[0]);
        Iterator<E> it = a.j().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (AbstractC13042fc3.d(intent != null ? intent.getAction() : null, ((a) next).name())) {
                obj = next;
                break;
            }
        }
        a aVar = (a) obj;
        C19406qI3.a("UploadService", "onStartCommand() with command: " + aVar, new Object[0]);
        if (aVar == null) {
            aVar = a.a;
        }
        return y(aVar);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        C19406qI3.j("UploadService", "onTaskRemoved()", new Object[0]);
        z();
    }

    public final AlarmManager r() {
        AlarmManager alarmManager = this.alarmManager;
        if (alarmManager != null) {
            return alarmManager;
        }
        AbstractC13042fc3.y("alarmManager");
        return null;
    }

    public final InterfaceC12532em2 t() {
        InterfaceC12532em2 interfaceC12532em2 = this.fileRepository;
        if (interfaceC12532em2 != null) {
            return interfaceC12532em2;
        }
        AbstractC13042fc3.y("fileRepository");
        return null;
    }

    public final AbstractC13778go1 u() {
        AbstractC13778go1 abstractC13778go1 = this.ioDispatcher;
        if (abstractC13778go1 != null) {
            return abstractC13778go1;
        }
        AbstractC13042fc3.y("ioDispatcher");
        return null;
    }

    public final E84 v() {
        E84 e84 = this.messagesModule;
        if (e84 != null) {
            return e84;
        }
        AbstractC13042fc3.y("messagesModule");
        return null;
    }
}
