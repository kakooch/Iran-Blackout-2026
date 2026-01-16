package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import ir.nasim.AbstractC9256Zd5;
import ir.nasim.C15791kA6;
import ir.nasim.features.root.RootActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class LE {
    private final InterfaceC10056b03 a;
    private final InterfaceC7742Sz6 b;
    private final Context c;
    private final int d;

    public LE(InterfaceC10056b03 interfaceC10056b03, InterfaceC7742Sz6 interfaceC7742Sz6, Context context, int i) {
        AbstractC13042fc3.i(interfaceC10056b03, "shortcutManager");
        AbstractC13042fc3.i(interfaceC7742Sz6, "iconFactory");
        AbstractC13042fc3.i(context, "context");
        this.a = interfaceC10056b03;
        this.b = interfaceC7742Sz6;
        this.c = context;
        this.d = i;
    }

    public final void a(String str, String str2, AbstractC9256Zd5 abstractC9256Zd5, IntentSender intentSender) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(abstractC9256Zd5, "shortcutType");
        if (c()) {
            Intent intent = new Intent(this.c, (Class<?>) RootActivity.class);
            intent.setAction(abstractC9256Zd5.a());
            if (abstractC9256Zd5 instanceof AbstractC9256Zd5.a) {
                AbstractC9256Zd5.a aVar = (AbstractC9256Zd5.a) abstractC9256Zd5;
                intent.putExtra("arg_peer_id_key", aVar.c().getPeerId());
                intent.putExtra("arg_ex_peer_type_value_key", aVar.c().getExPeerType().getValue());
            } else if (abstractC9256Zd5 instanceof AbstractC9256Zd5.c) {
                intent.putExtra("arg_peer_id_key", ((AbstractC9256Zd5.c) abstractC9256Zd5).c());
            } else {
                if (!(abstractC9256Zd5 instanceof AbstractC9256Zd5.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                intent.putExtra("arg_peer_id_key", ((AbstractC9256Zd5.d) abstractC9256Zd5).c());
            }
            ShortcutInfo shortcutInfoP = new C15791kA6.b(this.c, abstractC9256Zd5.b()).m(str).e(str2 != null ? this.b.a(str2) : null).f(intent).a().p();
            InterfaceC10056b03 interfaceC10056b03 = this.a;
            AbstractC13042fc3.f(shortcutInfoP);
            interfaceC10056b03.c(shortcutInfoP, intentSender);
        }
    }

    public final boolean b(String str) {
        AbstractC13042fc3.i(str, "id");
        if (!c()) {
            return false;
        }
        List listA = this.a.a();
        if ((listA instanceof Collection) && listA.isEmpty()) {
            return false;
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            if (AbstractC13042fc3.d(MA6.a(it.next()).getId(), str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        if (this.d < 26) {
            return false;
        }
        return this.a.b();
    }
}
