package ir.nasim;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.gov.nist.core.Separators;
import android.os.Bundle;

/* renamed from: ir.nasim.Jj1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5444Jj1 extends AbstractThreadedSyncAdapter {
    public C5444Jj1(Context context, boolean z) {
        super(context, z);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        C19406qI3.a("ContactsSyncAdapter", "onPerformSync", new Object[0]);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onSyncCanceled() {
        C19406qI3.j("ContactsSyncAdapter", "onSyncCanceled()", new Object[0]);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onSyncCanceled(Thread thread) {
        C19406qI3.j("ContactsSyncAdapter", "onSyncCanceled(" + thread + Separators.RPAREN, new Object[0]);
    }
}
