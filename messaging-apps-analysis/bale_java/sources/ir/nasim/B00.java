package ir.nasim;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.RemoteViews;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.C18862pN5;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.pinMessages.PinMessageEntity;
import ir.nasim.features.firebase.newPush.receiver.CopyActionReceiver;
import ir.nasim.features.firebase.newPush.receiver.ReadActionReceiver;
import ir.nasim.features.firebase.newPush.receiver.ReplyActionReceiver;
import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class B00 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final Context a;

    public static final class a {
        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final B00 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return new b(context, null, 2, 0 == true ? 1 : 0);
        }

        public final B00 b(Context context, AbstractC24063xz abstractC24063xz) {
            AbstractC13042fc3.i(context, "context");
            return new b(context, abstractC24063xz);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ B00(Context context, ED1 ed1) {
        this(context);
    }

    public abstract void A(String str);

    public abstract void B(long j);

    public abstract void a(Context context, C11458d25 c11458d25, String str);

    public abstract void b(String str);

    public abstract void c(Context context, C11458d25 c11458d25);

    public abstract void d(Context context, C11458d25 c11458d25);

    public abstract Notification e();

    public abstract void f(Notification notification);

    public abstract void g(boolean z);

    public abstract void h(String str);

    public abstract void i(int i);

    public abstract void j(CharSequence charSequence);

    public abstract void k(CharSequence charSequence);

    public abstract void l(int i);

    public abstract void m(RemoteViews remoteViews);

    public abstract void n(RemoteViews remoteViews);

    public abstract void o(RemoteViews remoteViews);

    public abstract void p(String str);

    public abstract void q(String str);

    public abstract void r(String str);

    public abstract void s(int i);

    public abstract void t(boolean z);

    public abstract void u(boolean z);

    public abstract void v(PendingIntent pendingIntent);

    public abstract void w(int i);

    public abstract void x(C15791kA6 c15791kA6);

    public abstract void y(int i);

    public abstract void z(AbstractC16407lD4.j jVar);

    private B00(Context context) {
        this.a = context;
    }

    private static final class b extends B00 {
        private final AbstractC16407lD4.e d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, AbstractC24063xz abstractC24063xz) {
            AbstractC16407lD4.e eVar;
            super(context, null);
            AbstractC13042fc3.i(context, "context");
            E00 e00 = E00.a;
            if (e00.o()) {
                eVar = new AbstractC16407lD4.e(context, e00.m(context, abstractC24063xz));
            } else {
                eVar = new AbstractC16407lD4.e(context);
                eVar.L(AbstractC9599aE4.a.m(abstractC24063xz));
            }
            this.d = eVar;
        }

        @Override // ir.nasim.B00
        public void A(String str) {
            AbstractC13042fc3.i(str, "threadId");
            this.d.d().putString("threadMessageRID", str);
        }

        @Override // ir.nasim.B00
        public void B(long j) {
            this.d.S(j);
            this.d.I(true);
        }

        @Override // ir.nasim.B00
        public void a(Context context, C11458d25 c11458d25, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str, "textToCopy");
            Intent intent = new Intent(context, (Class<?>) CopyActionReceiver.class);
            intent.setAction("ACTION_COPY");
            intent.putExtra("KEY_TEXT_TO_COPY", str);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, c11458d25.getPeerId(), intent, 167772160);
            String string = context.getString(AbstractC12217eE5.messages_action_copy);
            AbstractC13042fc3.h(string, "getString(...)");
            AbstractC16407lD4.a aVarB = new AbstractC16407lD4.a.C1367a(KB5.copy, string, broadcast).b();
            AbstractC13042fc3.h(aVarB, "build(...)");
            this.d.b(aVarB);
        }

        @Override // ir.nasim.B00
        public void b(String str) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.d.d().putString(DialogEntity.COLUMN_EX_PEER_TYPE, str);
        }

        @Override // ir.nasim.B00
        public void c(Context context, C11458d25 c11458d25) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c11458d25, "peer");
            Intent intent = new Intent(context, (Class<?>) ReadActionReceiver.class);
            intent.setAction("ir.nasim.intent.receiver.MARK_AS_READ");
            intent.putExtra("PEER_ID", c11458d25.u());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, c11458d25.getPeerId(), intent, 33554432);
            String string = context.getString(AbstractC12217eE5.mark_as_read);
            AbstractC13042fc3.h(string, "getString(...)");
            AbstractC16407lD4.a aVarB = new AbstractC16407lD4.a.C1367a(KB5.bale_text_logo, string, broadcast).b();
            AbstractC13042fc3.h(aVarB, "build(...)");
            this.d.b(aVarB);
        }

        @Override // ir.nasim.B00
        public void d(Context context, C11458d25 c11458d25) throws Resources.NotFoundException {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c11458d25, "peer");
            String string = context.getResources().getString(AbstractC12217eE5.reply_label);
            AbstractC13042fc3.h(string, "getString(...)");
            C18862pN5 c18862pN5A = new C18862pN5.d("key_text_reply").b(string).a();
            AbstractC13042fc3.h(c18862pN5A, "build(...)");
            Intent intent = new Intent(context, (Class<?>) ReplyActionReceiver.class);
            intent.setAction("ir.nasim.intent.receiver.REPLY");
            intent.putExtra("PEER_UNIQUE_ID", c11458d25.u());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, c11458d25.getPeerId(), intent, 167772160);
            String string2 = context.getString(AbstractC12217eE5.reply_label);
            AbstractC13042fc3.h(string2, "getString(...)");
            AbstractC16407lD4.a aVarB = new AbstractC16407lD4.a.C1367a(KB5.conv_send, string2, broadcast).a(c18862pN5A).b();
            AbstractC13042fc3.h(aVarB, "build(...)");
            CharSequence charSequence = aVarB.j;
            if (charSequence == null || charSequence.length() == 0) {
                aVarB.j = context.getString(AbstractC12217eE5.reply_label);
            }
            this.d.b(aVarB);
        }

        @Override // ir.nasim.B00
        public Notification e() {
            Notification notificationC = this.d.c();
            AbstractC13042fc3.h(notificationC, "build(...)");
            return notificationC;
        }

        @Override // ir.nasim.B00
        public void f(Notification notification) {
            if (notification != null) {
                Iterator itA = DJ.a(notification.actions);
                while (itA.hasNext()) {
                    Notification.Action action = (Notification.Action) itA.next();
                    AbstractC16407lD4.a.C1367a c1367a = new AbstractC16407lD4.a.C1367a(action.icon, action.title, action.actionIntent);
                    if (action.getRemoteInputs() != null) {
                        RemoteInput[] remoteInputs = action.getRemoteInputs();
                        AbstractC13042fc3.h(remoteInputs, "getRemoteInputs(...)");
                        if (!(remoteInputs.length == 0)) {
                            Iterator itA2 = DJ.a(action.getRemoteInputs());
                            while (itA2.hasNext()) {
                                Object next = itA2.next();
                                AbstractC13042fc3.h(next, "next(...)");
                                RemoteInput remoteInput = (RemoteInput) next;
                                C18862pN5 c18862pN5A = new C18862pN5.d(remoteInput.getResultKey()).b(remoteInput.getLabel()).a();
                                AbstractC13042fc3.h(c18862pN5A, "build(...)");
                                c1367a.a(c18862pN5A);
                            }
                        }
                    }
                    this.d.b(c1367a.b());
                }
                this.d.t(notification.extras);
                this.d.l(notification.contentIntent);
            }
        }

        @Override // ir.nasim.B00
        public void g(boolean z) {
            this.d.f(z);
        }

        @Override // ir.nasim.B00
        public void h(String str) {
            AbstractC13042fc3.i(str, SearchSuggestion.CATEGORY_ICON);
            this.d.h(str);
        }

        @Override // ir.nasim.B00
        public void i(int i) {
            this.d.j(i);
        }

        @Override // ir.nasim.B00
        public void j(CharSequence charSequence) {
            this.d.m(charSequence);
        }

        @Override // ir.nasim.B00
        public void k(CharSequence charSequence) {
            AbstractC13042fc3.i(charSequence, "contentTitle");
            this.d.n(charSequence);
        }

        @Override // ir.nasim.B00
        public void l(int i) {
            this.d.d().putInt("counter", i);
        }

        @Override // ir.nasim.B00
        public void m(RemoteViews remoteViews) {
            AbstractC13042fc3.i(remoteViews, "customBigContentView");
            this.d.o(remoteViews);
        }

        @Override // ir.nasim.B00
        public void n(RemoteViews remoteViews) {
            AbstractC13042fc3.i(remoteViews, "customContentView");
            this.d.p(remoteViews);
        }

        @Override // ir.nasim.B00
        public void o(RemoteViews remoteViews) {
            AbstractC13042fc3.i(remoteViews, "customContentView");
            this.d.q(remoteViews);
        }

        @Override // ir.nasim.B00
        public void p(String str) {
            AbstractC13042fc3.i(str, "peerUniqueId");
            this.d.d().putString(PinMessageEntity.COLS_PEER_UNIQUE_ID, str);
        }

        @Override // ir.nasim.B00
        public void q(String str) {
            AbstractC13042fc3.i(str, "pushType");
            this.d.d().putString("pushType", str);
        }

        @Override // ir.nasim.B00
        public void r(String str) {
            AbstractC13042fc3.i(str, "group");
            this.d.w(str);
        }

        @Override // ir.nasim.B00
        public void s(int i) {
            this.d.x(i);
        }

        @Override // ir.nasim.B00
        public void t(boolean z) {
            this.d.y(z);
        }

        @Override // ir.nasim.B00
        public void u(boolean z) {
            this.d.E(z);
        }

        @Override // ir.nasim.B00
        public void v(PendingIntent pendingIntent) {
            AbstractC13042fc3.i(pendingIntent, "pendingIntent");
            this.d.l(pendingIntent);
        }

        @Override // ir.nasim.B00
        public void w(int i) {
            if (E00.a.o()) {
                return;
            }
            this.d.F(i);
        }

        @Override // ir.nasim.B00
        public void x(C15791kA6 c15791kA6) {
            AbstractC13042fc3.i(c15791kA6, "shortcutInfoCompat");
            this.d.H(c15791kA6);
        }

        @Override // ir.nasim.B00
        public void y(int i) {
            this.d.K(i);
        }

        @Override // ir.nasim.B00
        public void z(AbstractC16407lD4.j jVar) {
            AbstractC13042fc3.i(jVar, "s");
            this.d.M(jVar);
        }

        public /* synthetic */ b(Context context, AbstractC24063xz abstractC24063xz, int i, ED1 ed1) {
            this(context, (i & 2) != 0 ? null : abstractC24063xz);
        }
    }
}
