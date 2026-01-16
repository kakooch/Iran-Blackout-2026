package ir.nasim;

import android.content.Context;
import ir.nasim.features.smiles.panel.emoji.db.EmojiDatabase;

/* renamed from: ir.nasim.d62, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11495d62 {
    private static final a a = new a(null);

    /* renamed from: ir.nasim.d62$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public final EmojiDatabase a(Context context) {
        AbstractC13042fc3.i(context, "context");
        return (EmojiDatabase) C26.a(context, EmojiDatabase.class, "emoji_shortcode.db").f("db/emojis.db").g().e();
    }

    public final InterfaceC10115b62 b(EmojiDatabase emojiDatabase) {
        AbstractC13042fc3.i(emojiDatabase, "emojiDatabase");
        return emojiDatabase.H();
    }
}
