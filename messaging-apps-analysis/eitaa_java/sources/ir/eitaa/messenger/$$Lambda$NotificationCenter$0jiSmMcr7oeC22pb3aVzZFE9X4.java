package ir.eitaa.messenger;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$NotificationCenter$0jiSmMcr7oeC22pb3aVzZFE-9X4, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$NotificationCenter$0jiSmMcr7oeC22pb3aVzZFE9X4 implements Runnable {
    public final /* synthetic */ NotificationCenter f$0;

    public /* synthetic */ $$Lambda$NotificationCenter$0jiSmMcr7oeC22pb3aVzZFE9X4(NotificationCenter notificationCenter) {
        this.f$0 = notificationCenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.checkForExpiredNotifications();
    }
}
