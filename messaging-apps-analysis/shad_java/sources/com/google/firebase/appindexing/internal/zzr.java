package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseUserActions;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public final class zzr extends FirebaseUserActions {
    private zzt zza;

    public zzr(Context context) {
        this.zza = new zzt(context);
    }

    @Override // com.google.firebase.appindexing.FirebaseUserActions
    public final Task<Void> end(Action action) {
        return zza(2, action);
    }

    private final Task<Void> zza(int i, Action action) {
        zza[] zzaVarArr = new zza[1];
        if (action != null) {
            if (!(action instanceof zza)) {
                return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Custom Action objects are not allowed. Please use the 'Actions' or 'ActionBuilder' class for creating Action objects."));
            }
            zzaVarArr[0] = (zza) action;
            zzaVarArr[0].zza().zza(i);
        }
        return this.zza.doWrite(new zzq(this, zzaVarArr));
    }
}
