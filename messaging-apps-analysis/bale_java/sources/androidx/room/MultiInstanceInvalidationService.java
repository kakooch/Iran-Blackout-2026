package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.c;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "a", TokenNames.I, "c", "()I", "d", "(I)V", "maxClientId", "", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "clientNames", "Landroid/os/RemoteCallbackList;", "Landroidx/room/b;", "Landroid/os/RemoteCallbackList;", "()Landroid/os/RemoteCallbackList;", "callbackList", "Landroidx/room/c$a;", "Landroidx/room/c$a;", "binder", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: from kotlin metadata */
    private int maxClientId;

    /* renamed from: b, reason: from kotlin metadata */
    private final Map clientNames = new LinkedHashMap();

    /* renamed from: c, reason: from kotlin metadata */
    private final RemoteCallbackList callbackList = new b();

    /* renamed from: d, reason: from kotlin metadata */
    private final c.a binder = new a();

    public static final class a extends c.a {
        a() {
        }

        @Override // androidx.room.c
        public void V0(int i, String[] strArr) {
            AbstractC13042fc3.i(strArr, "tables");
            RemoteCallbackList callbackList = MultiInstanceInvalidationService.this.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList) {
                String str = (String) multiInstanceInvalidationService.getClientNames().get(Integer.valueOf(i));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.getCallbackList().beginBroadcast();
                for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.getCallbackList().getBroadcastCookie(i2);
                        AbstractC13042fc3.g(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.getClientNames().get(num);
                        if (i != iIntValue && AbstractC13042fc3.d(str, str2)) {
                            try {
                                ((androidx.room.b) multiInstanceInvalidationService.getCallbackList().getBroadcastItem(i2)).Q(strArr);
                            } catch (RemoteException e) {
                                Log.w("ROOM", "Error invoking a remote callback", e);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.getCallbackList().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.getCallbackList().finishBroadcast();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        @Override // androidx.room.c
        public void x2(androidx.room.b bVar, int i) {
            AbstractC13042fc3.i(bVar, "callback");
            RemoteCallbackList callbackList = MultiInstanceInvalidationService.this.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList) {
                multiInstanceInvalidationService.getCallbackList().unregister(bVar);
            }
        }

        @Override // androidx.room.c
        public int z1(androidx.room.b bVar, String str) {
            AbstractC13042fc3.i(bVar, "callback");
            int i = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList callbackList = MultiInstanceInvalidationService.this.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.getMaxClientId() + 1);
                    int maxClientId = multiInstanceInvalidationService.getMaxClientId();
                    if (multiInstanceInvalidationService.getCallbackList().register(bVar, Integer.valueOf(maxClientId))) {
                        multiInstanceInvalidationService.getClientNames().put(Integer.valueOf(maxClientId), str);
                        i = maxClientId;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.getMaxClientId() - 1);
                        multiInstanceInvalidationService.getMaxClientId();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }
    }

    public static final class b extends RemoteCallbackList {
        b() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(androidx.room.b bVar, Object obj) {
            AbstractC13042fc3.i(bVar, "callback");
            AbstractC13042fc3.i(obj, ParameterNames.COOKIE);
            MultiInstanceInvalidationService.this.getClientNames().remove((Integer) obj);
        }
    }

    /* renamed from: a, reason: from getter */
    public final RemoteCallbackList getCallbackList() {
        return this.callbackList;
    }

    /* renamed from: b, reason: from getter */
    public final Map getClientNames() {
        return this.clientNames;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxClientId() {
        return this.maxClientId;
    }

    public final void d(int i) {
        this.maxClientId = i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        return this.binder;
    }
}
