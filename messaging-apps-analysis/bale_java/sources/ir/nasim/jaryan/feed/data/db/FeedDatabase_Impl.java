package ir.nasim.jaryan.feed.data.db;

import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.room.d;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C13143fj7;
import ir.nasim.C16091kh2;
import ir.nasim.C16682lh2;
import ir.nasim.C17273mh2;
import ir.nasim.C17864nh2;
import ir.nasim.C18455oh2;
import ir.nasim.C19046ph2;
import ir.nasim.C5822Kz1;
import ir.nasim.D26;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC13330g27;
import ir.nasim.InterfaceC15500jh2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J26;
import ir.nasim.SA2;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.pinMessages.PinMessageEntity;
import ir.nasim.jaryan.feed.data.db.FeedDatabase_Impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000f0\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\r\u0012\u0004\u0012\u00020\u00130\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lir/nasim/jaryan/feed/data/db/FeedDatabase_Impl;", "Lir/nasim/jaryan/feed/data/db/FeedDatabase;", "<init>", "()V", "Lir/nasim/Kz1;", "config", "Lir/nasim/g27;", "i", "(Lir/nasim/Kz1;)Lir/nasim/g27;", "Landroidx/room/d;", "h", "()Landroidx/room/d;", "", "Ljava/lang/Class;", "", "", "r", "()Ljava/util/Map;", "", "Lir/nasim/JS;", "q", "()Ljava/util/Set;", "autoMigrationSpecs", "Lir/nasim/Ze4;", "k", "(Ljava/util/Map;)Ljava/util/List;", "Lir/nasim/jh2;", "H", "()Lir/nasim/jh2;", "Lir/nasim/Yu3;", "p", "Lir/nasim/Yu3;", "_feedDao", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class FeedDatabase_Impl extends FeedDatabase {

    /* renamed from: p, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _feedDao = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qh2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return FeedDatabase_Impl.J(this.a);
        }
    });

    public static final class a extends J26.b {
        a() {
            super(8);
        }

        @Override // ir.nasim.J26.b
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `feed` (`sort_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rid` INTEGER NOT NULL, `date` INTEGER NOT NULL, `peer_id` INTEGER NOT NULL, `ex_peer_type` TEXT NOT NULL, `message` BLOB NOT NULL, `reaction` TEXT NOT NULL, `forwarded_count` INTEGER, `sender_uid` INTEGER NOT NULL, `upvote_count` INTEGER, `is_upvoted_by_me` INTEGER, `category` TEXT NOT NULL DEFAULT '', `message_type` INTEGER NOT NULL, `tag` TEXT, `parent_post_id` TEXT DEFAULT 'NULL', `grouped_id` INTEGER, `comment_count` INTEGER, `category_id` INTEGER NOT NULL DEFAULT 0, `file_id` INTEGER NOT NULL DEFAULT 0)");
            interfaceC12694f27.O("CREATE UNIQUE INDEX IF NOT EXISTS `index_feed_rid_date_peer_id` ON `feed` (`rid`, `date`, `peer_id`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC12694f27.O("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '26b15d35e1d9d57b057ccdaec85450d7')");
        }

        @Override // ir.nasim.J26.b
        public void b(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `feed`");
            List list = ((D26) FeedDatabase_Impl.this).h;
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
            List list = ((D26) FeedDatabase_Impl.this).h;
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
            ((D26) FeedDatabase_Impl.this).a = interfaceC12694f27;
            FeedDatabase_Impl.this.z(interfaceC12694f27);
            List list = ((D26) FeedDatabase_Impl.this).h;
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
            HashMap map = new HashMap(19);
            map.put("sort_id", new C13143fj7.a("sort_id", "INTEGER", true, 1, null, 1));
            map.put(DialogEntity.COLUMN_RID, new C13143fj7.a(DialogEntity.COLUMN_RID, "INTEGER", true, 0, null, 1));
            map.put("date", new C13143fj7.a("date", "INTEGER", true, 0, null, 1));
            map.put("peer_id", new C13143fj7.a("peer_id", "INTEGER", true, 0, null, 1));
            map.put(PinMessageEntity.COLS_EX_PEER_TYPE, new C13143fj7.a(PinMessageEntity.COLS_EX_PEER_TYPE, "TEXT", true, 0, null, 1));
            map.put(DialogEntity.COLUMN_MESSAGE, new C13143fj7.a(DialogEntity.COLUMN_MESSAGE, "BLOB", true, 0, null, 1));
            map.put("reaction", new C13143fj7.a("reaction", "TEXT", true, 0, null, 1));
            map.put("forwarded_count", new C13143fj7.a("forwarded_count", "INTEGER", false, 0, null, 1));
            map.put("sender_uid", new C13143fj7.a("sender_uid", "INTEGER", true, 0, null, 1));
            map.put("upvote_count", new C13143fj7.a("upvote_count", "INTEGER", false, 0, null, 1));
            map.put("is_upvoted_by_me", new C13143fj7.a("is_upvoted_by_me", "INTEGER", false, 0, null, 1));
            map.put(SearchSuggestion.CATEGORY_ICON, new C13143fj7.a(SearchSuggestion.CATEGORY_ICON, "TEXT", true, 0, "''", 1));
            map.put("message_type", new C13143fj7.a("message_type", "INTEGER", true, 0, null, 1));
            map.put(ParameterNames.TAG, new C13143fj7.a(ParameterNames.TAG, "TEXT", false, 0, null, 1));
            map.put("parent_post_id", new C13143fj7.a("parent_post_id", "TEXT", false, 0, "'NULL'", 1));
            map.put("grouped_id", new C13143fj7.a("grouped_id", "INTEGER", false, 0, null, 1));
            map.put("comment_count", new C13143fj7.a("comment_count", "INTEGER", false, 0, null, 1));
            map.put("category_id", new C13143fj7.a("category_id", "INTEGER", true, 0, "0", 1));
            map.put("file_id", new C13143fj7.a("file_id", "INTEGER", true, 0, "0", 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new C13143fj7.e("index_feed_rid_date_peer_id", true, AbstractC10360bX0.p(DialogEntity.COLUMN_RID, "date", "peer_id"), AbstractC10360bX0.p("ASC", "ASC", "ASC")));
            C13143fj7 c13143fj7 = new C13143fj7("feed", map, hashSet, hashSet2);
            C13143fj7 c13143fj7A = C13143fj7.e.a(interfaceC12694f27, "feed");
            if (c13143fj7.equals(c13143fj7A)) {
                return new J26.c(true, null);
            }
            return new J26.c(false, "feed(ir.nasim.jaryan.feed.model.db.FeedEntity).\n Expected:\n" + c13143fj7 + "\n Found:\n" + c13143fj7A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.jaryan.feed.data.db.a J(FeedDatabase_Impl feedDatabase_Impl) {
        AbstractC13042fc3.i(feedDatabase_Impl, "this$0");
        return new ir.nasim.jaryan.feed.data.db.a(feedDatabase_Impl);
    }

    @Override // ir.nasim.jaryan.feed.data.db.FeedDatabase
    public InterfaceC15500jh2 H() {
        return (InterfaceC15500jh2) this._feedDao.getValue();
    }

    @Override // ir.nasim.D26
    protected d h() {
        return new d(this, new HashMap(0), new HashMap(0), "feed");
    }

    @Override // ir.nasim.D26
    protected InterfaceC13330g27 i(C5822Kz1 config) {
        AbstractC13042fc3.i(config, "config");
        return config.c.a(InterfaceC13330g27.b.f.a(config.a).c(config.b).b(new J26(config, new a(), "26b15d35e1d9d57b057ccdaec85450d7", "196e9420484050b401b194049cfbd83a")).a());
    }

    @Override // ir.nasim.D26
    public List k(Map autoMigrationSpecs) {
        AbstractC13042fc3.i(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C16091kh2());
        arrayList.add(new C16682lh2());
        arrayList.add(new C17273mh2());
        arrayList.add(new C17864nh2());
        arrayList.add(new C18455oh2());
        arrayList.add(new C19046ph2());
        return arrayList;
    }

    @Override // ir.nasim.D26
    public Set q() {
        return new HashSet();
    }

    @Override // ir.nasim.D26
    protected Map r() {
        HashMap map = new HashMap();
        map.put(InterfaceC15500jh2.class, ir.nasim.jaryan.feed.data.db.a.f.a());
        return map;
    }
}
