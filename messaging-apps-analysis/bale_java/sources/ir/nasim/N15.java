package ir.nasim;

import android.text.Spannable;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes5.dex */
public abstract class N15 {
    private final boolean a;

    public static final class a extends N15 {
        private final boolean b;

        public a(boolean z) {
            super(false, null);
            this.b = z;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public static final class b extends N15 {
        private final C8304Vk b;
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C8304Vk c8304Vk, boolean z) {
            super(false, null);
            AbstractC13042fc3.i(c8304Vk, "album");
            this.b = c8304Vk;
            this.c = z;
        }

        public final C8304Vk b() {
            return this.b;
        }

        public final boolean c() {
            return this.c;
        }
    }

    public static final class c extends N15 {
        private final C8304Vk b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C8304Vk c8304Vk) {
            super(false, null);
            AbstractC13042fc3.i(c8304Vk, "album");
            this.b = c8304Vk;
        }

        public final C8304Vk b() {
            return this.b;
        }
    }

    public static final class d extends N15 {
        private final C20610sI7 b;

        public d(C20610sI7 c20610sI7) {
            super(false, null);
            this.b = c20610sI7;
        }

        public final C20610sI7 b() {
            return this.b;
        }
    }

    public static final class e extends N15 {
        private final Avatar b;
        private final Spannable c;
        private final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Avatar avatar, Spannable spannable, int i) {
            super(false, null);
            AbstractC13042fc3.i(spannable, "name");
            this.b = avatar;
            this.c = spannable;
            this.d = i;
        }

        public final Avatar b() {
            return this.b;
        }

        public final int c() {
            return this.d;
        }

        public final Spannable d() {
            return this.c;
        }
    }

    public static final class f extends N15 {
        private final int b;
        private final boolean c;
        private final boolean d;

        public f(int i, boolean z, boolean z2) {
            super(false, null);
            this.b = i;
            this.c = z;
            this.d = z2;
        }

        public final int b() {
            return this.b;
        }

        public final boolean c() {
            return this.d;
        }

        public final boolean d() {
            return this.c;
        }
    }

    public static final class g extends N15 {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(false, null);
            AbstractC13042fc3.i(str, "newContentDescription");
            this.b = str;
        }

        public final String b() {
            return this.b;
        }
    }

    public static final class h extends N15 {
        private final C8967Xz7 b;
        private final C6244Mu1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(C8967Xz7 c8967Xz7, C6244Mu1 c6244Mu1) {
            super(false, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c6244Mu1, "document");
            this.b = c8967Xz7;
            this.c = c6244Mu1;
        }

        public final C6244Mu1 b() {
            return this.c;
        }

        public final C8967Xz7 c() {
            return this.b;
        }
    }

    public static final class i extends N15 {
        private final MW1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(MW1 mw1) {
            super(false, null);
            AbstractC13042fc3.i(mw1, "documentState");
            this.b = mw1;
        }

        public final MW1 b() {
            return this.b;
        }
    }

    public static final class j extends N15 {
        private final C8967Xz7 b;
        private final Spannable c;
        private final Spannable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(C8967Xz7 c8967Xz7, Spannable spannable, Spannable spannable2) {
            super(true, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(spannable, "state");
            this.b = c8967Xz7;
            this.c = spannable;
            this.d = spannable2;
        }

        public final Spannable b() {
            return this.d;
        }

        public final C8967Xz7 c() {
            return this.b;
        }

        public final Spannable d() {
            return this.c;
        }
    }

    public static final class k extends N15 {
        private final C8967Xz7 b;
        private final C19672qk7 c;
        private final AbstractC23538x54 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(C8967Xz7 c8967Xz7, C19672qk7 c19672qk7, AbstractC23538x54 abstractC23538x54) {
            super(true, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
            this.b = c8967Xz7;
            this.c = c19672qk7;
            this.d = abstractC23538x54;
        }

        public final C8967Xz7 b() {
            return this.b;
        }

        public final AbstractC23538x54 c() {
            return this.d;
        }

        public final C19672qk7 d() {
            return this.c;
        }
    }

    public static final class l extends N15 {
        private final C8967Xz7 b;
        private final C4602Fv2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(C8967Xz7 c8967Xz7, C4602Fv2 c4602Fv2) {
            super(true, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
            this.c = c4602Fv2;
        }

        public final C4602Fv2 b() {
            return this.c;
        }

        public final C8967Xz7 c() {
            return this.b;
        }
    }

    public static final class m extends N15 {
        private final Spannable b;
        private final Spannable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Spannable spannable, Spannable spannable2) {
            super(false, null);
            AbstractC13042fc3.i(spannable, "usersCountSpannable");
            AbstractC13042fc3.i(spannable2, "liveStatusSpannable");
            this.b = spannable;
            this.c = spannable2;
        }

        public final Spannable b() {
            return this.c;
        }

        public final Spannable c() {
            return this.b;
        }
    }

    public static final class n extends N15 {
        private final C8967Xz7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(C8967Xz7 c8967Xz7) {
            super(false, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
        }

        public final C8967Xz7 b() {
            return this.b;
        }
    }

    public static final class o extends N15 {
        private final C16885m18 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(C16885m18 c16885m18) {
            super(false, null);
            AbstractC13042fc3.i(c16885m18, "voteResult");
            this.b = c16885m18;
        }

        public final C16885m18 b() {
            return this.b;
        }
    }

    public static final class p extends N15 {
        private final C8967Xz7 b;
        private final Spannable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(C8967Xz7 c8967Xz7, Spannable spannable) {
            super(false, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
            this.c = spannable;
        }

        public final C8967Xz7 b() {
            return this.b;
        }

        public final Spannable c() {
            return this.c;
        }
    }

    public static final class q extends N15 {
        private final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(List list) {
            super(false, null);
            AbstractC13042fc3.i(list, "voters");
            this.b = list;
        }

        public final List b() {
            return this.b;
        }
    }

    public static final class r extends N15 {
        private final C8967Xz7 b;
        private final Spannable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(C8967Xz7 c8967Xz7, Spannable spannable) {
            super(false, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
            this.c = spannable;
        }

        public final C8967Xz7 b() {
            return this.b;
        }
    }

    public static final class s extends N15 {
        private final C8967Xz7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(C8967Xz7 c8967Xz7) {
            super(true, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
        }

        public final C8967Xz7 b() {
            return this.b;
        }
    }

    public static final class t extends N15 {
        private final boolean b;
        private final boolean c;
        private final boolean d;

        public t(boolean z, boolean z2, boolean z3) {
            super(true, null);
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        public final boolean b() {
            return this.d;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.b;
        }
    }

    public static final class u extends N15 {
        private final C8967Xz7 b;
        private final Spannable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(C8967Xz7 c8967Xz7, Spannable spannable) {
            super(true, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
            this.c = spannable;
        }

        public final C8967Xz7 b() {
            return this.b;
        }
    }

    public static final class v extends N15 {
        private final C8967Xz7 b;
        private final Spannable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(C8967Xz7 c8967Xz7, Spannable spannable) {
            super(true, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(spannable, "state");
            this.b = c8967Xz7;
            this.c = spannable;
        }

        public final C8967Xz7 b() {
            return this.b;
        }

        public final Spannable c() {
            return this.c;
        }
    }

    public static final class w extends N15 {
        private final C8967Xz7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(C8967Xz7 c8967Xz7) {
            super(false, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            this.b = c8967Xz7;
        }

        public final C8967Xz7 b() {
            return this.b;
        }
    }

    public static final class x extends N15 {
        public static final int c = GM3.a;
        private final GM3 b;

        public x(GM3 gm3) {
            super(false, null);
            this.b = gm3;
        }

        public final GM3 b() {
            return this.b;
        }
    }

    public static final class y extends N15 {
        private final C8967Xz7 b;
        private final AbstractC17757nW1.c.d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(C8967Xz7 c8967Xz7, AbstractC17757nW1.c.d dVar) {
            super(false, null);
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(dVar, MediaStreamTrack.VIDEO_TRACK_KIND);
            this.b = c8967Xz7;
            this.c = dVar;
        }

        public final C8967Xz7 b() {
            return this.b;
        }

        public final AbstractC17757nW1.c.d c() {
            return this.c;
        }
    }

    public /* synthetic */ N15(boolean z, ED1 ed1) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }

    private N15(boolean z) {
        this.a = z;
    }
}
