package androidx.work.impl;

import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.room.d;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C12249eI1;
import ir.nasim.C12428eb8;
import ir.nasim.C13143fj7;
import ir.nasim.C14246hb8;
import ir.nasim.C15533jk5;
import ir.nasim.C18992pb8;
import ir.nasim.C20783sb8;
import ir.nasim.C5822Kz1;
import ir.nasim.D26;
import ir.nasim.InterfaceC11606dI1;
import ir.nasim.InterfaceC11816db8;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC13330g27;
import ir.nasim.InterfaceC13655gb8;
import ir.nasim.InterfaceC14943ik5;
import ir.nasim.InterfaceC18401ob8;
import ir.nasim.InterfaceC20190rb8;
import ir.nasim.J26;
import ir.nasim.P47;
import ir.nasim.Q47;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile InterfaceC18401ob8 q;
    private volatile InterfaceC11606dI1 r;
    private volatile InterfaceC20190rb8 s;
    private volatile P47 t;
    private volatile InterfaceC11816db8 u;
    private volatile InterfaceC13655gb8 v;
    private volatile InterfaceC14943ik5 w;

    @Override // androidx.work.impl.WorkDatabase
    public InterfaceC11606dI1 I() {
        InterfaceC11606dI1 interfaceC11606dI1;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new C12249eI1(this);
                }
                interfaceC11606dI1 = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC11606dI1;
    }

    @Override // androidx.work.impl.WorkDatabase
    public InterfaceC14943ik5 M() {
        InterfaceC14943ik5 interfaceC14943ik5;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            try {
                if (this.w == null) {
                    this.w = new C15533jk5(this);
                }
                interfaceC14943ik5 = this.w;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC14943ik5;
    }

    @Override // androidx.work.impl.WorkDatabase
    public P47 N() {
        P47 p47;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new Q47(this);
                }
                p47 = this.t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return p47;
    }

    @Override // androidx.work.impl.WorkDatabase
    public InterfaceC11816db8 O() {
        InterfaceC11816db8 interfaceC11816db8;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            try {
                if (this.u == null) {
                    this.u = new C12428eb8(this);
                }
                interfaceC11816db8 = this.u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC11816db8;
    }

    @Override // androidx.work.impl.WorkDatabase
    public InterfaceC13655gb8 P() {
        InterfaceC13655gb8 interfaceC13655gb8;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            try {
                if (this.v == null) {
                    this.v = new C14246hb8(this);
                }
                interfaceC13655gb8 = this.v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC13655gb8;
    }

    @Override // androidx.work.impl.WorkDatabase
    public InterfaceC18401ob8 Q() {
        InterfaceC18401ob8 interfaceC18401ob8;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new C18992pb8(this);
                }
                interfaceC18401ob8 = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC18401ob8;
    }

    @Override // androidx.work.impl.WorkDatabase
    public InterfaceC20190rb8 R() {
        InterfaceC20190rb8 interfaceC20190rb8;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new C20783sb8(this);
                }
                interfaceC20190rb8 = this.s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC20190rb8;
    }

    @Override // ir.nasim.D26
    protected d h() {
        return new d(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // ir.nasim.D26
    protected InterfaceC13330g27 i(C5822Kz1 c5822Kz1) {
        return c5822Kz1.c.a(InterfaceC13330g27.b.a(c5822Kz1.a).c(c5822Kz1.b).b(new J26(c5822Kz1, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    class a extends J26.b {
        a(int i) {
            super(i);
        }

        @Override // ir.nasim.J26.b
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            interfaceC12694f27.O("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC12694f27.O("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // ir.nasim.J26.b
        public void b(InterfaceC12694f27 interfaceC12694f27) {
            interfaceC12694f27.O("DROP TABLE IF EXISTS `Dependency`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `WorkSpec`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `WorkTag`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `SystemIdInfo`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `WorkName`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `WorkProgress`");
            interfaceC12694f27.O("DROP TABLE IF EXISTS `Preference`");
            if (((D26) WorkDatabase_Impl.this).h != null) {
                int size = ((D26) WorkDatabase_Impl.this).h.size();
                for (int i = 0; i < size; i++) {
                    ((D26.b) ((D26) WorkDatabase_Impl.this).h.get(i)).b(interfaceC12694f27);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.J26.b
        public void c(InterfaceC12694f27 interfaceC12694f27) {
            if (((D26) WorkDatabase_Impl.this).h != null) {
                int size = ((D26) WorkDatabase_Impl.this).h.size();
                for (int i = 0; i < size; i++) {
                    ((D26.b) ((D26) WorkDatabase_Impl.this).h.get(i)).a(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void d(InterfaceC12694f27 interfaceC12694f27) {
            ((D26) WorkDatabase_Impl.this).a = interfaceC12694f27;
            interfaceC12694f27.O("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.z(interfaceC12694f27);
            if (((D26) WorkDatabase_Impl.this).h != null) {
                int size = ((D26) WorkDatabase_Impl.this).h.size();
                for (int i = 0; i < size; i++) {
                    ((D26.b) ((D26) WorkDatabase_Impl.this).h.get(i)).c(interfaceC12694f27);
                }
            }
        }

        @Override // ir.nasim.J26.b
        public void f(InterfaceC12694f27 interfaceC12694f27) throws IOException {
            AbstractC7716Sx1.b(interfaceC12694f27);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.J26.b
        public J26.c g(InterfaceC12694f27 interfaceC12694f27) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new C13143fj7.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new C13143fj7.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new C13143fj7.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new C13143fj7.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new C13143fj7.e("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new C13143fj7.e("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            C13143fj7 c13143fj7 = new C13143fj7("Dependency", map, hashSet, hashSet2);
            C13143fj7 c13143fj7A = C13143fj7.a(interfaceC12694f27, "Dependency");
            if (!c13143fj7.equals(c13143fj7A)) {
                return new J26.c(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + c13143fj7 + "\n Found:\n" + c13143fj7A);
            }
            HashMap map2 = new HashMap(25);
            map2.put("id", new C13143fj7.a("id", "TEXT", true, 1, null, 1));
            map2.put("state", new C13143fj7.a("state", "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new C13143fj7.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new C13143fj7.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            map2.put("input", new C13143fj7.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new C13143fj7.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new C13143fj7.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new C13143fj7.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new C13143fj7.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new C13143fj7.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new C13143fj7.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new C13143fj7.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("period_start_time", new C13143fj7.a("period_start_time", "INTEGER", true, 0, null, 1));
            map2.put("minimum_retention_duration", new C13143fj7.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new C13143fj7.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new C13143fj7.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new C13143fj7.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("required_network_type", new C13143fj7.a("required_network_type", "INTEGER", false, 0, null, 1));
            map2.put("requires_charging", new C13143fj7.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new C13143fj7.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new C13143fj7.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new C13143fj7.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new C13143fj7.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new C13143fj7.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new C13143fj7.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new C13143fj7.e("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new C13143fj7.e("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            C13143fj7 c13143fj72 = new C13143fj7("WorkSpec", map2, hashSet3, hashSet4);
            C13143fj7 c13143fj7A2 = C13143fj7.a(interfaceC12694f27, "WorkSpec");
            if (!c13143fj72.equals(c13143fj7A2)) {
                return new J26.c(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + c13143fj72 + "\n Found:\n" + c13143fj7A2);
            }
            HashMap map3 = new HashMap(2);
            map3.put(ParameterNames.TAG, new C13143fj7.a(ParameterNames.TAG, "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new C13143fj7.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new C13143fj7.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new C13143fj7.e("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            C13143fj7 c13143fj73 = new C13143fj7("WorkTag", map3, hashSet5, hashSet6);
            C13143fj7 c13143fj7A3 = C13143fj7.a(interfaceC12694f27, "WorkTag");
            if (!c13143fj73.equals(c13143fj7A3)) {
                return new J26.c(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + c13143fj73 + "\n Found:\n" + c13143fj7A3);
            }
            HashMap map4 = new HashMap(2);
            map4.put("work_spec_id", new C13143fj7.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("system_id", new C13143fj7.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new C13143fj7.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            C13143fj7 c13143fj74 = new C13143fj7("SystemIdInfo", map4, hashSet7, new HashSet(0));
            C13143fj7 c13143fj7A4 = C13143fj7.a(interfaceC12694f27, "SystemIdInfo");
            if (!c13143fj74.equals(c13143fj7A4)) {
                return new J26.c(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + c13143fj74 + "\n Found:\n" + c13143fj7A4);
            }
            HashMap map5 = new HashMap(2);
            map5.put("name", new C13143fj7.a("name", "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new C13143fj7.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new C13143fj7.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new C13143fj7.e("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            C13143fj7 c13143fj75 = new C13143fj7("WorkName", map5, hashSet8, hashSet9);
            C13143fj7 c13143fj7A5 = C13143fj7.a(interfaceC12694f27, "WorkName");
            if (!c13143fj75.equals(c13143fj7A5)) {
                return new J26.c(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + c13143fj75 + "\n Found:\n" + c13143fj7A5);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new C13143fj7.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put("progress", new C13143fj7.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new C13143fj7.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            C13143fj7 c13143fj76 = new C13143fj7("WorkProgress", map6, hashSet10, new HashSet(0));
            C13143fj7 c13143fj7A6 = C13143fj7.a(interfaceC12694f27, "WorkProgress");
            if (!c13143fj76.equals(c13143fj7A6)) {
                return new J26.c(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + c13143fj76 + "\n Found:\n" + c13143fj7A6);
            }
            HashMap map7 = new HashMap(2);
            map7.put("key", new C13143fj7.a("key", "TEXT", true, 1, null, 1));
            map7.put("long_value", new C13143fj7.a("long_value", "INTEGER", false, 0, null, 1));
            C13143fj7 c13143fj77 = new C13143fj7("Preference", map7, new HashSet(0), new HashSet(0));
            C13143fj7 c13143fj7A7 = C13143fj7.a(interfaceC12694f27, "Preference");
            if (c13143fj77.equals(c13143fj7A7)) {
                return new J26.c(true, null);
            }
            return new J26.c(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + c13143fj77 + "\n Found:\n" + c13143fj7A7);
        }

        @Override // ir.nasim.J26.b
        public void e(InterfaceC12694f27 interfaceC12694f27) {
        }
    }
}
