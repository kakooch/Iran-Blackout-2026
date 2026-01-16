package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import ir.nasim.InterfaceC10344bV2;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: ir.nasim.fE1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C12822fE1 implements InterfaceC9750aV2, InterfaceC10344bV2 {
    private static final ThreadFactory f = new ThreadFactory() { // from class: ir.nasim.bE1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return C12822fE1.m(runnable);
        }
    };
    private final InterfaceC7959Tx5 a;
    private final Context b;
    private final InterfaceC7959Tx5 c;
    private final Set d;
    private final Executor e;

    private C12822fE1(final Context context, final String str, Set set, InterfaceC7959Tx5 interfaceC7959Tx5) {
        this(new InterfaceC7959Tx5() { // from class: ir.nasim.cE1
            @Override // ir.nasim.InterfaceC7959Tx5
            public final Object get() {
                return C12822fE1.k(context, str);
            }
        }, set, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f), interfaceC7959Tx5, context);
    }

    public static I01 h() {
        return I01.d(C12822fE1.class, InterfaceC9750aV2.class, InterfaceC10344bV2.class).b(C10226bI1.i(Context.class)).b(C10226bI1.i(C5490Jo2.class)).b(C10226bI1.k(YU2.class)).b(C10226bI1.j(InterfaceC19410qI7.class)).f(new Y01() { // from class: ir.nasim.aE1
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return C12822fE1.i(s01);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C12822fE1 i(S01 s01) {
        return new C12822fE1((Context) s01.a(Context.class), ((C5490Jo2) s01.a(C5490Jo2.class)).n(), s01.c(YU2.class), s01.d(InterfaceC19410qI7.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String j() {
        String string;
        synchronized (this) {
            try {
                C14796iV2 c14796iV2 = (C14796iV2) this.a.get();
                List listC = c14796iV2.c();
                c14796iV2.b();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < listC.size(); i++) {
                    AbstractC15385jV2 abstractC15385jV2 = (AbstractC15385jV2) listC.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", abstractC15385jV2.c());
                    jSONObject.put("dates", new JSONArray((Collection) abstractC15385jV2.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put(ParameterNames.VERSION, "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C14796iV2 k(Context context, String str) {
        return new C14796iV2(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void l() {
        synchronized (this) {
            ((C14796iV2) this.a.get()).k(System.currentTimeMillis(), ((InterfaceC19410qI7) this.c.get()).getUserAgent());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread m(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    @Override // ir.nasim.InterfaceC9750aV2
    public Task a() {
        return FI7.a(this.b) ^ true ? AbstractC9078Yj7.e("") : AbstractC9078Yj7.c(this.e, new Callable() { // from class: ir.nasim.dE1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.j();
            }
        });
    }

    @Override // ir.nasim.InterfaceC10344bV2
    public synchronized InterfaceC10344bV2.a b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C14796iV2 c14796iV2 = (C14796iV2) this.a.get();
        if (!c14796iV2.i(jCurrentTimeMillis)) {
            return InterfaceC10344bV2.a.NONE;
        }
        c14796iV2.g();
        return InterfaceC10344bV2.a.GLOBAL;
    }

    public Task n() {
        return this.d.size() <= 0 ? AbstractC9078Yj7.e(null) : FI7.a(this.b) ^ true ? AbstractC9078Yj7.e(null) : AbstractC9078Yj7.c(this.e, new Callable() { // from class: ir.nasim.eE1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.l();
            }
        });
    }

    C12822fE1(InterfaceC7959Tx5 interfaceC7959Tx5, Set set, Executor executor, InterfaceC7959Tx5 interfaceC7959Tx52, Context context) {
        this.a = interfaceC7959Tx5;
        this.d = set;
        this.e = executor;
        this.c = interfaceC7959Tx52;
        this.b = context;
    }
}
