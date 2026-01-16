package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.C23345wl7;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.dl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11907dl extends AbstractC17457n0 {
    private final List c;

    public C11907dl(List list) {
        AbstractC13042fc3.i(list, "messages");
        FG3 fg3 = new FG3();
        fg3.u(list);
        this(new C8540Wk1(fg3));
    }

    private final int s(List list) {
        Iterator it = list.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((J44) it.next()).F().hashCode();
        }
        return iHashCode;
    }

    private final boolean t(List list, List list2) {
        if (list.size() == list2.size()) {
            List<XV4> listV1 = AbstractC15401jX0.v1(list, list2);
            if (!(listV1 instanceof Collection) || !listV1.isEmpty()) {
                for (XV4 xv4 : listV1) {
                    if (!AbstractC13042fc3.d(((J44) xv4.a()).F(), ((J44) xv4.b()).F())) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_album);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C11907dl.class, obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        return t(this.c, ((C11907dl) obj).c);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + s(this.c);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.media_album);
        AbstractC13042fc3.h(string, "getString(...)");
        if (l().v().length() == 0) {
            return string + Separators.SP + this.c.size() + context.getString(AbstractC12217eE5.chat_fragment_album_item_content_description);
        }
        return string + Separators.SP + this.c.size() + context.getString(AbstractC12217eE5.chat_fragment_album_item_content_description) + context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description) + Separators.SP + AbstractC12519el.b(this);
    }

    @Override // ir.nasim.AbstractC17457n0
    public int k() {
        return this.c.size();
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        C23345wl7.a aVar = C23345wl7.g;
        String strB = AbstractC12519el.b(this);
        if (strB == null) {
            strB = "";
        }
        return C23345wl7.a.c(aVar, strB, null, 2, null);
    }

    public final List r() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11907dl(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "localContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalAlbum");
        this.c = ((FG3) abstractC19230q0C).s();
    }
}
