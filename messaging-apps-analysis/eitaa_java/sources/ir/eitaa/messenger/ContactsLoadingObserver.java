package ir.eitaa.messenger;

import android.os.Handler;
import android.os.Looper;
import ir.eitaa.messenger.NotificationCenter;

/* loaded from: classes.dex */
public final class ContactsLoadingObserver {
    private final Callback callback;
    private final ContactsController contactsController;
    private final int currentAccount;
    private final Handler handler;
    private final NotificationCenter notificationCenter;
    private final NotificationCenter.NotificationCenterDelegate observer = new NotificationCenter.NotificationCenterDelegate() { // from class: ir.eitaa.messenger.ContactsLoadingObserver.1
        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            if (id == NotificationCenter.contactsDidLoad) {
                ContactsLoadingObserver.this.onContactsLoadingStateUpdated(account, false);
            }
        }
    };
    private final Runnable releaseRunnable;
    private boolean released;

    public interface Callback {
        void onResult(boolean contactsLoaded);
    }

    public static void observe(Callback callback, long expirationTime) {
        new ContactsLoadingObserver(callback).start(expirationTime);
    }

    private ContactsLoadingObserver(Callback callback) {
        this.callback = callback;
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.releaseRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsLoadingObserver$1PLglTj8pBv6zvOJZ7bzO61dZMk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$ContactsLoadingObserver();
            }
        };
        this.contactsController = ContactsController.getInstance(i);
        this.notificationCenter = NotificationCenter.getInstance(i);
        this.handler = new Handler(Looper.myLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ContactsLoadingObserver() {
        onContactsLoadingStateUpdated(this.currentAccount, true);
    }

    public void start(long expirationTime) {
        if (onContactsLoadingStateUpdated(this.currentAccount, false)) {
            return;
        }
        this.notificationCenter.addObserver(this.observer, NotificationCenter.contactsDidLoad);
        this.handler.postDelayed(this.releaseRunnable, expirationTime);
    }

    public void release() {
        if (this.released) {
            return;
        }
        NotificationCenter notificationCenter = this.notificationCenter;
        if (notificationCenter != null) {
            notificationCenter.removeObserver(this.observer, NotificationCenter.contactsDidLoad);
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.releaseRunnable);
        }
        this.released = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onContactsLoadingStateUpdated(int account, boolean force) {
        if (this.released) {
            return false;
        }
        boolean z = this.contactsController.contactsLoaded;
        if (!z && !force) {
            return false;
        }
        release();
        this.callback.onResult(z);
        return true;
    }
}
