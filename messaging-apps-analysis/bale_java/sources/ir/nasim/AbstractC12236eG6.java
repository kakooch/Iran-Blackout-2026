package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.VF6;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.eG6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12236eG6 {
    public static final C14054hG6 a(VF6 vf6, Resources resources) throws Resources.NotFoundException {
        C14054hG6 c14054hG6;
        C14054hG6 c14054hG62;
        AbstractC13042fc3.i(vf6, "<this>");
        AbstractC13042fc3.i(resources, "resources");
        if (vf6 instanceof VF6.a) {
            return new C14054hG6(AbstractC13463gG6.c.b, ((VF6.a) vf6).d());
        }
        if (vf6 instanceof VF6.e) {
            AbstractC13463gG6.c cVar = AbstractC13463gG6.c.b;
            String string = resources.getString(AbstractC12217eE5.pin_dialog_limit, Integer.valueOf(((VF6.e) vf6).d()));
            AbstractC13042fc3.h(string, "getString(...)");
            c14054hG62 = new C14054hG6(cVar, string);
        } else if (vf6 instanceof VF6.j) {
            AbstractC13463gG6.c cVar2 = AbstractC13463gG6.c.b;
            String string2 = resources.getString(AbstractC12217eE5.unable_to_delete_conversation, ((VF6.j) vf6).d());
            AbstractC13042fc3.h(string2, "getString(...)");
            c14054hG62 = new C14054hG6(cVar2, string2);
        } else {
            if (!(vf6 instanceof VF6.d)) {
                if (AbstractC13042fc3.d(vf6, VF6.k.b)) {
                    AbstractC13463gG6.c cVar3 = AbstractC13463gG6.c.b;
                    String string3 = resources.getString(AbstractC12217eE5.error_time_out);
                    AbstractC13042fc3.h(string3, "getString(...)");
                    c14054hG6 = new C14054hG6(cVar3, string3);
                } else if (AbstractC13042fc3.d(vf6, VF6.l.b)) {
                    AbstractC13463gG6.c cVar4 = AbstractC13463gG6.c.b;
                    String string4 = resources.getString(AbstractC12217eE5.toast_unable_delete_chat);
                    AbstractC13042fc3.h(string4, "getString(...)");
                    c14054hG6 = new C14054hG6(cVar4, string4);
                } else if (vf6 instanceof VF6.c) {
                    AbstractC13463gG6.a aVar = new AbstractC13463gG6.a(resources.getString(AbstractC12217eE5.snackbar_action_undo), Integer.valueOf(KB5.undo), true, ((VF6.c) vf6).d());
                    String string5 = resources.getString(AbstractC12217eE5.delete_chats_in_dialogs_container);
                    AbstractC13042fc3.h(string5, "getString(...)");
                    c14054hG62 = new C14054hG6(aVar, string5);
                } else if (vf6 instanceof VF6.g) {
                    AbstractC13463gG6.a aVar2 = new AbstractC13463gG6.a(resources.getString(AbstractC12217eE5.snackbar_action_undo), Integer.valueOf(KB5.undo), true, ((VF6.g) vf6).d());
                    String string6 = resources.getString(AbstractC12217eE5.delete_channel_in_dialogs_container);
                    AbstractC13042fc3.h(string6, "getString(...)");
                    c14054hG62 = new C14054hG6(aVar2, string6);
                } else if (vf6 instanceof VF6.h) {
                    AbstractC13463gG6.a aVar3 = new AbstractC13463gG6.a(resources.getString(AbstractC12217eE5.snackbar_action_undo), Integer.valueOf(KB5.undo), true, ((VF6.h) vf6).d());
                    String string7 = resources.getString(AbstractC12217eE5.delete_group_in_dialogs_container);
                    AbstractC13042fc3.h(string7, "getString(...)");
                    c14054hG62 = new C14054hG6(aVar3, string7);
                } else if (vf6 instanceof VF6.i) {
                    AbstractC13463gG6.a aVar4 = new AbstractC13463gG6.a(resources.getString(AbstractC12217eE5.snackbar_action_undo), Integer.valueOf(KB5.undo), true, ((VF6.i) vf6).d());
                    String string8 = resources.getString(AbstractC12217eE5.delete_chat_in_dialogs_container);
                    AbstractC13042fc3.h(string8, "getString(...)");
                    c14054hG62 = new C14054hG6(aVar4, string8);
                } else if (vf6 instanceof VF6.f) {
                    AbstractC13463gG6.b bVar = new AbstractC13463gG6.b(KB5.tick_done);
                    String string9 = resources.getString(AbstractC12217eE5.archive_chat_in_dialogs_container);
                    AbstractC13042fc3.h(string9, "getString(...)");
                    c14054hG6 = new C14054hG6(bVar, string9);
                } else {
                    if (!(vf6 instanceof VF6.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AbstractC13463gG6.b bVar2 = new AbstractC13463gG6.b(KB5.tick_done);
                    String string10 = resources.getString(AbstractC12217eE5.archive_chats_in_dialogs_container);
                    AbstractC13042fc3.h(string10, "getString(...)");
                    c14054hG6 = new C14054hG6(bVar2, string10);
                }
                return c14054hG6;
            }
            AbstractC13463gG6.c cVar5 = AbstractC13463gG6.c.b;
            String string11 = resources.getString(AbstractC12217eE5.unable_to_delete_conversations, Integer.valueOf(((VF6.d) vf6).d()));
            AbstractC13042fc3.h(string11, "getString(...)");
            c14054hG62 = new C14054hG6(cVar5, string11);
        }
        return c14054hG62;
    }
}
