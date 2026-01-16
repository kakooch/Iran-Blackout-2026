package io.appmetrica.analytics.appsetid.internal;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.tasks.Task;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
import ir.nasim.KE;
import ir.nasim.WI4;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/appsetid/internal/AppSetIdRetriever;", "Lio/appmetrica/analytics/appsetid/internal/IAppSetIdRetriever;", "<init>", "()V", "Landroid/content/Context;", "context", "Lio/appmetrica/analytics/appsetid/internal/AppSetIdListener;", "listener", "Lir/nasim/rB7;", "retrieveAppSetId", "(Landroid/content/Context;Lio/appmetrica/analytics/appsetid/internal/AppSetIdListener;)V", "appsetid_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class AppSetIdRetriever implements IAppSetIdRetriever {
    private final Object a = new Object();
    private final ArrayList b = new ArrayList();

    public static final AppSetIdScope access$convertScope(AppSetIdRetriever appSetIdRetriever, int i) {
        appSetIdRetriever.getClass();
        return i != 1 ? i != 2 ? AppSetIdScope.UNKNOWN : AppSetIdScope.DEVELOPER : AppSetIdScope.APP;
    }

    @Override // io.appmetrica.analytics.appsetid.internal.IAppSetIdRetriever
    public void retrieveAppSetId(Context context, final AppSetIdListener listener) {
        Task taskF = AppSet.a(context).f();
        WI4 wi4 = new WI4() { // from class: io.appmetrica.analytics.appsetid.internal.AppSetIdRetriever$retrieveAppSetId$onCompleteListener$1
            @Override // ir.nasim.WI4
            public void onComplete(Task completedTask) {
                Object obj = this.a.a;
                AppSetIdRetriever appSetIdRetriever = this.a;
                synchronized (obj) {
                    appSetIdRetriever.b.remove(this);
                }
                if (completedTask.p()) {
                    listener.onAppSetIdRetrieved(((KE) completedTask.l()).a(), AppSetIdRetriever.access$convertScope(this.a, ((KE) completedTask.l()).b()));
                } else {
                    listener.onFailure(completedTask.k());
                }
            }
        };
        synchronized (this.a) {
            this.b.add(wi4);
        }
        taskF.b(wi4);
    }
}
