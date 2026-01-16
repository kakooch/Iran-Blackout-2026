package androidx.work.impl;

import android.content.Context;
import ir.nasim.AbstractC9264Ze4;
import ir.nasim.C19079pk5;
import ir.nasim.H03;
import ir.nasim.InterfaceC12694f27;

/* loaded from: classes2.dex */
public abstract class a {
    public static AbstractC9264Ze4 a = new C0136a(1, 2);
    public static AbstractC9264Ze4 b = new b(3, 4);
    public static AbstractC9264Ze4 c = new c(4, 5);
    public static AbstractC9264Ze4 d = new d(6, 7);
    public static AbstractC9264Ze4 e = new e(7, 8);
    public static AbstractC9264Ze4 f = new f(8, 9);
    public static AbstractC9264Ze4 g = new g(11, 12);

    /* renamed from: androidx.work.impl.a$a, reason: collision with other inner class name */
    class C0136a extends AbstractC9264Ze4 {
        C0136a(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            interfaceC12694f27.O("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            interfaceC12694f27.O("DROP TABLE IF EXISTS alarmInfo");
            interfaceC12694f27.O("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    class b extends AbstractC9264Ze4 {
        b(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    }

    class c extends AbstractC9264Ze4 {
        c(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            interfaceC12694f27.O("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    class d extends AbstractC9264Ze4 {
        d(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    class e extends AbstractC9264Ze4 {
        e(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    class f extends AbstractC9264Ze4 {
        f(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class g extends AbstractC9264Ze4 {
        g(int i, int i2) {
            super(i, i2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class h extends AbstractC9264Ze4 {
        final Context c;

        public h(Context context, int i, int i2) {
            super(i, i2);
            this.c = context;
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            if (this.b >= 10) {
                interfaceC12694f27.i0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    public static class i extends AbstractC9264Ze4 {
        final Context c;

        public i(Context context) {
            super(9, 10);
            this.c = context;
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            C19079pk5.b(this.c, interfaceC12694f27);
            H03.a(this.c, interfaceC12694f27);
        }
    }
}
