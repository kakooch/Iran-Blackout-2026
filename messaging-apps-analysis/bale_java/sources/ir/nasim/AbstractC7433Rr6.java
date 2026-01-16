package ir.nasim;

import android.text.Spannable;
import java.util.List;

/* renamed from: ir.nasim.Rr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7433Rr6 {

    /* renamed from: ir.nasim.Rr6$a */
    public static final class a extends AbstractC7433Rr6 {
        private final C8894Xu a;
        private final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C8894Xu c8894Xu, List list) {
            super(null);
            AbstractC13042fc3.i(list, "commonGroups");
            this.a = c8894Xu;
            this.b = list;
        }

        public final C8894Xu a() {
            return this.a;
        }

        public final List b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Rr6$b */
    public static final class b extends AbstractC7433Rr6 {
        private final Spannable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Spannable spannable) {
            super(null);
            AbstractC13042fc3.i(spannable, "body");
            this.a = spannable;
        }

        public final Spannable a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Rr6$c */
    public static final class c extends AbstractC7433Rr6 {
        private final GM5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GM5 gm5) {
            super(null);
            AbstractC13042fc3.i(gm5, "relatedChannelsListener");
            this.a = gm5;
        }
    }

    /* renamed from: ir.nasim.Rr6$d */
    public static final class d extends AbstractC7433Rr6 {
        private final List a;
        private final GM5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, GM5 gm5) {
            super(null);
            AbstractC13042fc3.i(list, "relatedChannels");
            AbstractC13042fc3.i(gm5, "relatedChannelsListener");
            this.a = list;
            this.b = gm5;
        }

        public final List a() {
            return this.a;
        }

        public final GM5 b() {
            return this.b;
        }
    }

    private AbstractC7433Rr6() {
    }

    public /* synthetic */ AbstractC7433Rr6(ED1 ed1) {
        this();
    }
}
