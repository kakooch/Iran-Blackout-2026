package ir.eitaa.messenger;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$MessagesController$og_uVNDITyR6Mkc5OjMbP3_qV3o, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$MessagesController$og_uVNDITyR6Mkc5OjMbP3_qV3o implements Runnable {
    public final /* synthetic */ MessagesController f$0;

    public /* synthetic */ $$Lambda$MessagesController$og_uVNDITyR6Mkc5OjMbP3_qV3o(MessagesController messagesController) {
        this.f$0 = messagesController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.removePromoDialog();
    }
}
