package ir.nasim.database.dailogLists;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11279ck3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC3859Cq6;
import ir.nasim.AbstractC4987Hk3;
import ir.nasim.C13722gi5;
import ir.nasim.C14333hk3;
import ir.nasim.C19938rB7;
import ir.nasim.C4093Dq6;
import ir.nasim.C9475a16;
import ir.nasim.ED1;
import ir.nasim.UA2;
import ir.nasim.database.dailogLists.DialogLastMessage;
import java.util.List;

/* loaded from: classes5.dex */
public final class f {
    public static final f a = new f();
    private static final AbstractC3859Cq6 b;
    private static final AbstractC11279ck3 c;

    static {
        C4093Dq6 c4093Dq6 = new C4093Dq6();
        C13722gi5 c13722gi5 = new C13722gi5(AbstractC10882cM5.b(DialogLastMessage.class), null);
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Text.class), DialogLastMessage.Text.INSTANCE.serializer());
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Document.class), DialogLastMessage.Document.INSTANCE.serializer());
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Link.class), DialogLastMessage.Link.INSTANCE.serializer());
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Album.class), DialogLastMessage.Album.INSTANCE.serializer());
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Unknown.class), DialogLastMessage.Unknown.INSTANCE.serializer());
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Call.class), DialogLastMessage.Call.INSTANCE.serializer());
        c13722gi5.b(AbstractC10882cM5.b(DialogLastMessage.Live.class), DialogLastMessage.Live.INSTANCE.serializer());
        c13722gi5.a(c4093Dq6);
        b = c4093Dq6.f();
        c = AbstractC4987Hk3.b(null, new UA2() { // from class: ir.nasim.QP1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.database.dailogLists.f.b((C14333hk3) obj);
            }
        }, 1, null);
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b(C14333hk3 c14333hk3) {
        AbstractC13042fc3.i(c14333hk3, "$this$Json");
        c14333hk3.e(b);
        c14333hk3.c("_messageType");
        c14333hk3.d(true);
        return C19938rB7.a;
    }

    public final DialogLastMessage c(String str) {
        Object objB;
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return null;
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b((DialogLastMessage) c.b(DialogLastMessage.INSTANCE.serializer(), str));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.e(objB) != null) {
            objB = new DialogLastMessage.Unknown(0, (MessageState) null, false, 7, (ED1) null);
        }
        return (DialogLastMessage) objB;
    }

    public final String d(DialogLastMessage dialogLastMessage) {
        Object objB;
        AbstractC13042fc3.i(dialogLastMessage, "lastMessage");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(c.c(DialogLastMessage.INSTANCE.serializer(), dialogLastMessage));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (String) objB;
    }

    public final List e(String str) {
        Object objB;
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return AbstractC10360bX0.m();
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b((List) AbstractC11279ck3.d.b(AbstractC18503om0.g(MessageIdentifier.INSTANCE.serializer()), str));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (List) objB;
    }

    public final String f(List list) {
        Object objB;
        AbstractC13042fc3.i(list, "messages");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(AbstractC11279ck3.d.c(AbstractC18503om0.g(MessageIdentifier.INSTANCE.serializer()), list));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (String) objB;
    }
}
