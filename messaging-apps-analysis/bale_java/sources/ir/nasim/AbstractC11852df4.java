package ir.nasim;

/* renamed from: ir.nasim.df4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC11852df4 {
    private static final AbstractC9264Ze4 a = new b();
    private static final AbstractC9264Ze4 b = new c();
    private static final AbstractC9264Ze4 c = new d();
    private static final AbstractC9264Ze4 d = new e();
    private static final AbstractC9264Ze4 e = new f();
    private static final AbstractC9264Ze4 f = new g();
    private static final AbstractC9264Ze4 g = new h();
    private static final AbstractC9264Ze4 h = new i();
    private static final AbstractC9264Ze4 i = new a();

    /* renamed from: ir.nasim.df4$a */
    public static final class a extends AbstractC9264Ze4 {
        a() {
            super(17, 18);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
            interfaceC12694f27.O("\n            CREATE TABLE IF NOT EXISTS `live_streams_new` (\n                `live_key` INTEGER NOT NULL PRIMARY KEY,\n                `peer_unique_id` INTEGER NOT NULL,\n                `message_rid` INTEGER NOT NULL,\n                `message_date` INTEGER NOT NULL,\n                `user_count` INTEGER NOT NULL\n            )\n        ");
            interfaceC12694f27.O("\n            INSERT INTO `live_streams_new` (\n                `live_key`,\n                `peer_unique_id`,\n                `message_rid`,\n                `message_date`,\n                `user_count`\n            )\n            SELECT \n                `live_key`,\n                `peer_unique_id`,\n                `message_rid`,\n                `message_date`,\n                `user_count`\n            FROM `live_streams` AS t1\n            WHERE t1.`id` = (\n                SELECT MAX(t2.`id`)\n                FROM `live_streams` AS t2\n                WHERE t2.`live_key` = t1.`live_key`\n            )\n        ");
            interfaceC12694f27.O("DROP TABLE `live_streams`");
        }
    }

    /* renamed from: ir.nasim.df4$b */
    public static final class b extends AbstractC9264Ze4 {
        b() {
            super(1, 2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("DROP TABLE  IF EXISTS `call_log`");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `call_log` (`time` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `peer` INTEGER NOT NULL, `initiator` INTEGER NOT NULL, `finisher` INTEGER NOT NULL, `personal_call_state` INTEGER NOT NULL, `group_call_state` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    /* renamed from: ir.nasim.df4$c */
    public static final class c extends AbstractC9264Ze4 {
        c() {
            super(2, 3);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `saved_gifs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,`file_id` INTEGER NOT NULL,`access_hash` INTEGER NOT NULL,`file_storage_version` INTEGER NOT NULL,`width` INTEGER NOT NULL,`height` INTEGER NOT NULL,`file_size` INTEGER NOT NULL,`duration` INTEGER NOT NULL,`used_at` INTEGER NOT NULL)");
        }
    }

    /* renamed from: ir.nasim.df4$d */
    public static final class d extends AbstractC9264Ze4 {
        d() {
            super(3, 4);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("DROP TABLE  IF EXISTS `call_log`");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `call_log` (`time` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `peer` INTEGER NOT NULL, `initiator` INTEGER NOT NULL, `finisher` INTEGER NOT NULL, `personal_call_state` INTEGER NOT NULL, `group_call_state` INTEGER NOT NULL, `id` INTEGER NOT NULL, `peersList` TEXT NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`id`));");
        }
    }

    /* renamed from: ir.nasim.df4$e */
    public static final class e extends AbstractC9264Ze4 {
        e() {
            super(4, 3);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("DROP TABLE  IF EXISTS `call_log`");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `call_log` (`time` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `peer` INTEGER NOT NULL, `initiator` INTEGER NOT NULL, `finisher` INTEGER NOT NULL, `personal_call_state` INTEGER NOT NULL, `group_call_state` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    /* renamed from: ir.nasim.df4$f */
    public static final class f extends AbstractC9264Ze4 {
        f() {
            super(4, 6);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("ALTER TABLE `saved_gifs` ADD COLUMN 'mime_type' TEXT DEFAULT NULL;");
            interfaceC12694f27.O("ALTER TABLE `saved_gifs` ADD COLUMN 'thumb' BLOB DEFAULT NULL;");
        }
    }

    /* renamed from: ir.nasim.df4$g */
    public static final class g extends AbstractC9264Ze4 {
        g() {
            super(5, 6);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
        }
    }

    /* renamed from: ir.nasim.df4$h */
    public static final class h extends AbstractC9264Ze4 {
        h() {
            super(6, 7);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `notification_records` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `peer_id` TEXT NOT NULL,\n    `message_rid` TEXT,\n    `message_date` TEXT,\n    `push_type` INTEGER NOT NULL,\n    `push_send_date` INTEGER,\n    `content` TEXT,\n    `reaction_count` INTEGER\n);\n");
        }
    }

    /* renamed from: ir.nasim.df4$i */
    public static final class i extends AbstractC9264Ze4 {
        i() {
            super(7, 8);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.I();
            try {
                interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS notification_records_new (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `peer_id` TEXT NOT NULL,\n    `message_rid` TEXT NOT NULL DEFAULT '',\n    `message_date` INTEGER NOT NULL DEFAULT 0,\n    `push_type` INTEGER NOT NULL,\n    `push_send_date` INTEGER NOT NULL DEFAULT 0,\n    `content` TEXT,\n    `reaction_count` INTEGER\n);");
                interfaceC12694f27.O("INSERT INTO notification_records_new (\n    `peer_id`,\n    `message_rid`,\n    `message_date`,\n    `push_type`,\n    `push_send_date`,\n    `content`,\n    `reaction_count`\n)\nSELECT\n    IFNULL(`peer_id`, ''),\n    IFNULL(`message_rid`, ''),\n    IFNULL(`message_date`, 0),\n    `push_type`,\n    IFNULL(`push_send_date`, 0),\n    `content`,\n    `reaction_count`\nFROM\n    `notification_records`;");
                interfaceC12694f27.O("DROP TABLE `notification_records`;");
                interfaceC12694f27.O("ALTER TABLE notification_records_new RENAME TO `notification_records`;");
                interfaceC12694f27.h0();
            } finally {
                interfaceC12694f27.t0();
            }
        }
    }

    public static final AbstractC9264Ze4 a() {
        return i;
    }

    public static final AbstractC9264Ze4 b() {
        return a;
    }

    public static final AbstractC9264Ze4 c() {
        return b;
    }

    public static final AbstractC9264Ze4 d() {
        return c;
    }

    public static final AbstractC9264Ze4 e() {
        return d;
    }

    public static final AbstractC9264Ze4 f() {
        return e;
    }

    public static final AbstractC9264Ze4 g() {
        return f;
    }

    public static final AbstractC9264Ze4 h() {
        return g;
    }

    public static final AbstractC9264Ze4 i() {
        return h;
    }
}
