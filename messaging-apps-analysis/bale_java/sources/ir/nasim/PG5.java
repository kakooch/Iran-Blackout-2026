package ir.nasim;

import java.util.HashSet;
import java.util.List;

/* loaded from: classes5.dex */
public final class PG5 {
    public static final PG5 a = new PG5();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NG5
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return PG5.c();
        }
    });
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.OG5
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return PG5.g();
        }
    });
    public static final int d = 8;

    private PG5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c() {
        return AbstractC20762sZ6.N0(AbstractC5969Lp4.d().o2().S().F4(), new String[]{","}, false, 0, 6, null);
    }

    private final HashSet e() {
        return (HashSet) c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet g() {
        return AbstractC4597Fu6.e("❤", "👍", "👎", "😂", "😭", "🙏", "🇮🇷", "🇵🇸", "🌷", "😍", "😎", "😱", "😡", "😐", "🤯", "🥳", "👏", "🔥", "✅", "😔", "🖤", "🥲", "🤩", "👌", "🤲", "🫠", "🫡", "🗿", "💔", "❤️\u200d🔥", "❤\u200d🔥", "👀", "🤣", "😁", "🥲", "😇", "🙂", "🙃", "😉", "🥰", "🤓", "🤩", "😕", "🥺", "😐", "🙄", "😷", "👾", "🙌", "🤝", "🤦\u200d♂️️", "🤦\u200d♂", "🌚", "🌝", "🌎", "⛄️", "⛄", "🎂", "🏆", "⚽️", "⚽", "⚡", "🕊️", "🕊", "🎉", "🤡", "💯", "👻", "💊", "🦄", "🇱🇧");
    }

    public final List d() {
        return (List) b.getValue();
    }

    public final boolean f(String str) {
        AbstractC13042fc3.i(str, "reactionCode");
        return e().contains(str);
    }
}
