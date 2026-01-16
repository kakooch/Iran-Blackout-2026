package ir.eitaa.messenger;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$KeepAliveJob$MQAI5xlMbu2heJHtxk5-pctOVvA, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$KeepAliveJob$MQAI5xlMbu2heJHtxk5pctOVvA implements Runnable {
    public static final /* synthetic */ $$Lambda$KeepAliveJob$MQAI5xlMbu2heJHtxk5pctOVvA INSTANCE = new $$Lambda$KeepAliveJob$MQAI5xlMbu2heJHtxk5pctOVvA();

    private /* synthetic */ $$Lambda$KeepAliveJob$MQAI5xlMbu2heJHtxk5pctOVvA() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        KeepAliveJob.finishJobInternal();
    }
}
