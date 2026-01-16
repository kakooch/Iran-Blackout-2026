package ir.nasim.features.smiles.panel.emoji.db;

import androidx.room.d;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C13143fj7;
import ir.nasim.C5822Kz1;
import ir.nasim.D26;
import ir.nasim.InterfaceC10115b62;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC13330g27;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J26;
import ir.nasim.SA2;
import ir.nasim.features.smiles.panel.emoji.db.EmojiDatabase_Impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000f0\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r\u0012\u0004\u0012\u00020\u00130\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lir/nasim/features/smiles/panel/emoji/db/EmojiDatabase_Impl;", "Lir/nasim/features/smiles/panel/emoji/db/EmojiDatabase;", "<init>", "()V", "Lir/nasim/Kz1;", "config", "Lir/nasim/g27;", "i", "(Lir/nasim/Kz1;)Lir/nasim/g27;", "Landroidx/room/d;", "h", "()Landroidx/room/d;", "", "Ljava/lang/Class;", "", "", "r", "()Ljava/util/Map;", "", "Lir/nasim/JS;", "q", "()Ljava/util/Set;", "autoMigrationSpecs", "Lir/nasim/Ze4;", "k", "(Ljava/util/Map;)Ljava/util/List;", "Lir/nasim/b62;", "H", "()Lir/nasim/b62;", "Lir/nasim/Yu3;", "p", "Lir/nasim/Yu3;", "_emojiKeywordDao", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class EmojiDatabase_Impl extends EmojiDatabase {

    /* renamed from: p, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _emojiKeywordDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.U52
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return EmojiDatabase_Impl.J(this.a);
        }
    });

    public static final class a extends J26.b {
        a() {
            super(2);
        }

        @Override // ir.nasim.J26.b
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `keyword` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `emoji_code` TEXT NOT NULL, `pack_id` INTEGER NOT NULL, `keywords_en` TEXT, `keywords_fa` TEXT)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `pack` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name_en` TEXT NOT NULL, `name_fa` TEXT NOT NULL)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC12694f27.O("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '57ebb4e9ec6667a1314375c5273bdeb2')");
        }

        @Override // ir.nasim.J26.b
        public void b(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `keyword`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `pack`");
            List list = ((D26) EmojiDatabase_Impl.this).h;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((D26.b) it.next()).b(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void c(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            List list = ((D26) EmojiDatabase_Impl.this).h;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((D26.b) it.next()).a(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void d(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            ((D26) EmojiDatabase_Impl.this).a = interfaceC12694f27;
            EmojiDatabase_Impl.this.z(interfaceC12694f27);
            List list = ((D26) EmojiDatabase_Impl.this).h;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((D26.b) it.next()).c(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void e(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }

        @Override // ir.nasim.J26.b
        public void f(InterfaceC12694f27 interfaceC12694f27) throws IOException {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            AbstractC7716Sx1.b(interfaceC12694f27);
        }

        @Override // ir.nasim.J26.b
        public J26.c g(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            HashMap map = new HashMap(5);
            map.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map.put("emoji_code", new C13143fj7.a("emoji_code", "TEXT", true, 0, null, 1));
            map.put("pack_id", new C13143fj7.a("pack_id", "INTEGER", true, 0, null, 1));
            map.put("keywords_en", new C13143fj7.a("keywords_en", "TEXT", false, 0, null, 1));
            map.put("keywords_fa", new C13143fj7.a("keywords_fa", "TEXT", false, 0, null, 1));
            C13143fj7 c13143fj7 = new C13143fj7("keyword", map, new HashSet(0), new HashSet(0));
            C13143fj7.b bVar = C13143fj7.e;
            C13143fj7 c13143fj7A = bVar.a(interfaceC12694f27, "keyword");
            if (!c13143fj7.equals(c13143fj7A)) {
                return new J26.c(false, "keyword(ir.nasim.features.smiles.panel.emoji.db.EmojiKeywordEntity).\n Expected:\n" + c13143fj7 + "\n Found:\n" + c13143fj7A);
            }
            HashMap map2 = new HashMap(3);
            map2.put("id", new C13143fj7.a("id", "INTEGER", true, 1, null, 1));
            map2.put("name_en", new C13143fj7.a("name_en", "TEXT", true, 0, null, 1));
            map2.put("name_fa", new C13143fj7.a("name_fa", "TEXT", true, 0, null, 1));
            C13143fj7 c13143fj72 = new C13143fj7("pack", map2, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A2 = bVar.a(interfaceC12694f27, "pack");
            if (c13143fj72.equals(c13143fj7A2)) {
                return new J26.c(true, null);
            }
            return new J26.c(false, "pack(ir.nasim.features.smiles.panel.emoji.db.EmojiPackEntity).\n Expected:\n" + c13143fj72 + "\n Found:\n" + c13143fj7A2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.smiles.panel.emoji.db.a J(EmojiDatabase_Impl emojiDatabase_Impl) {
        AbstractC13042fc3.i(emojiDatabase_Impl, "this$0");
        return new ir.nasim.features.smiles.panel.emoji.db.a(emojiDatabase_Impl);
    }

    @Override // ir.nasim.features.smiles.panel.emoji.db.EmojiDatabase
    public InterfaceC10115b62 H() {
        return (InterfaceC10115b62) this._emojiKeywordDao.getValue();
    }

    @Override // ir.nasim.D26
    protected d h() {
        return new d(this, new HashMap(0), new HashMap(0), "keyword", "pack");
    }

    @Override // ir.nasim.D26
    protected InterfaceC13330g27 i(C5822Kz1 config) {
        AbstractC13042fc3.i(config, "config");
        return config.c.a(InterfaceC13330g27.b.f.a(config.a).c(config.b).b(new J26(config, new a(), "57ebb4e9ec6667a1314375c5273bdeb2", "27ba01850cf3a9428c0d600da094f39b")).a());
    }

    @Override // ir.nasim.D26
    public List k(Map autoMigrationSpecs) {
        AbstractC13042fc3.i(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // ir.nasim.D26
    public Set q() {
        return new HashSet();
    }

    @Override // ir.nasim.D26
    protected Map r() {
        HashMap map = new HashMap();
        map.put(InterfaceC10115b62.class, ir.nasim.features.smiles.panel.emoji.db.a.c.a());
        return map;
    }
}
