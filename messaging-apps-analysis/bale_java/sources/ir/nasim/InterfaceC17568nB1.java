package ir.nasim;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.nB1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC17568nB1 {

    /* renamed from: ir.nasim.nB1$a */
    public static final class a implements InterfaceC17568nB1 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.InterfaceC17568nB1
        public Set a() {
            return AbstractC4597Fu6.d();
        }

        @Override // ir.nasim.InterfaceC17568nB1
        public InterfaceC3311Ai3 b(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return null;
        }

        @Override // ir.nasim.InterfaceC17568nB1
        public Set c() {
            return AbstractC4597Fu6.d();
        }

        @Override // ir.nasim.InterfaceC17568nB1
        public InterfaceC14921ii3 d(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return null;
        }

        @Override // ir.nasim.InterfaceC17568nB1
        public Set e() {
            return AbstractC4597Fu6.d();
        }

        @Override // ir.nasim.InterfaceC17568nB1
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public List f(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return AbstractC10360bX0.m();
        }
    }

    Set a();

    InterfaceC3311Ai3 b(C6432No4 c6432No4);

    Set c();

    InterfaceC14921ii3 d(C6432No4 c6432No4);

    Set e();

    Collection f(C6432No4 c6432No4);
}
