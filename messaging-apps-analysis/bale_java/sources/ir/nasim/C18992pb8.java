package ir.nasim;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.C17810nb8;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.pb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18992pb8 implements InterfaceC18401ob8 {
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;
    private final AbstractC11429cz6 d;
    private final AbstractC11429cz6 e;
    private final AbstractC11429cz6 f;
    private final AbstractC11429cz6 g;
    private final AbstractC11429cz6 h;
    private final AbstractC11429cz6 i;
    private final AbstractC11429cz6 j;

    /* renamed from: ir.nasim.pb8$a */
    class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C17810nb8 c17810nb8) throws Throwable {
            String str = c17810nb8.a;
            if (str == null) {
                interfaceC15121j27.y1(1);
            } else {
                interfaceC15121j27.U0(1, str);
            }
            interfaceC15121j27.k1(2, AbstractC22060ub8.j(c17810nb8.b));
            String str2 = c17810nb8.c;
            if (str2 == null) {
                interfaceC15121j27.y1(3);
            } else {
                interfaceC15121j27.U0(3, str2);
            }
            String str3 = c17810nb8.d;
            if (str3 == null) {
                interfaceC15121j27.y1(4);
            } else {
                interfaceC15121j27.U0(4, str3);
            }
            byte[] bArrP = androidx.work.b.p(c17810nb8.e);
            if (bArrP == null) {
                interfaceC15121j27.y1(5);
            } else {
                interfaceC15121j27.n1(5, bArrP);
            }
            byte[] bArrP2 = androidx.work.b.p(c17810nb8.f);
            if (bArrP2 == null) {
                interfaceC15121j27.y1(6);
            } else {
                interfaceC15121j27.n1(6, bArrP2);
            }
            interfaceC15121j27.k1(7, c17810nb8.g);
            interfaceC15121j27.k1(8, c17810nb8.h);
            interfaceC15121j27.k1(9, c17810nb8.i);
            interfaceC15121j27.k1(10, c17810nb8.k);
            interfaceC15121j27.k1(11, AbstractC22060ub8.a(c17810nb8.l));
            interfaceC15121j27.k1(12, c17810nb8.m);
            interfaceC15121j27.k1(13, c17810nb8.n);
            interfaceC15121j27.k1(14, c17810nb8.o);
            interfaceC15121j27.k1(15, c17810nb8.p);
            interfaceC15121j27.k1(16, c17810nb8.q ? 1L : 0L);
            interfaceC15121j27.k1(17, AbstractC22060ub8.i(c17810nb8.r));
            C18424oe1 c18424oe1 = c17810nb8.j;
            if (c18424oe1 == null) {
                interfaceC15121j27.y1(18);
                interfaceC15121j27.y1(19);
                interfaceC15121j27.y1(20);
                interfaceC15121j27.y1(21);
                interfaceC15121j27.y1(22);
                interfaceC15121j27.y1(23);
                interfaceC15121j27.y1(24);
                interfaceC15121j27.y1(25);
                return;
            }
            interfaceC15121j27.k1(18, AbstractC22060ub8.h(c18424oe1.b()));
            interfaceC15121j27.k1(19, c18424oe1.g() ? 1L : 0L);
            interfaceC15121j27.k1(20, c18424oe1.h() ? 1L : 0L);
            interfaceC15121j27.k1(21, c18424oe1.f() ? 1L : 0L);
            interfaceC15121j27.k1(22, c18424oe1.i() ? 1L : 0L);
            interfaceC15121j27.k1(23, c18424oe1.c());
            interfaceC15121j27.k1(24, c18424oe1.d());
            byte[] bArrC = AbstractC22060ub8.c(c18424oe1.a());
            if (bArrC == null) {
                interfaceC15121j27.y1(25);
            } else {
                interfaceC15121j27.n1(25, bArrC);
            }
        }
    }

    /* renamed from: ir.nasim.pb8$b */
    class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: ir.nasim.pb8$c */
    class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: ir.nasim.pb8$d */
    class d extends AbstractC11429cz6 {
        d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* renamed from: ir.nasim.pb8$e */
    class e extends AbstractC11429cz6 {
        e(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* renamed from: ir.nasim.pb8$f */
    class f extends AbstractC11429cz6 {
        f(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: ir.nasim.pb8$g */
    class g extends AbstractC11429cz6 {
        g(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: ir.nasim.pb8$h */
    class h extends AbstractC11429cz6 {
        h(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* renamed from: ir.nasim.pb8$i */
    class i extends AbstractC11429cz6 {
        i(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public C18992pb8(D26 d26) {
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
        this.d = new c(d26);
        this.e = new d(d26);
        this.f = new e(d26);
        this.g = new f(d26);
        this.h = new g(d26);
        this.i = new h(d26);
        this.j = new i(d26);
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public void a(String str) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.c.b();
        if (str == null) {
            interfaceC15121j27B.y1(1);
        } else {
            interfaceC15121j27B.U0(1, str);
        }
        this.a.e();
        try {
            interfaceC15121j27B.V();
            this.a.F();
        } finally {
            this.a.j();
            this.c.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public int b(Ta8 ta8, String... strArr) {
        this.a.d();
        StringBuilder sbB = WY6.b();
        sbB.append("UPDATE workspec SET state=");
        sbB.append(Separators.QUESTION);
        sbB.append(" WHERE id IN (");
        WY6.a(sbB, strArr.length);
        sbB.append(Separators.RPAREN);
        InterfaceC15121j27 interfaceC15121j27G = this.a.g(sbB.toString());
        interfaceC15121j27G.k1(1, AbstractC22060ub8.j(ta8));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                interfaceC15121j27G.y1(i2);
            } else {
                interfaceC15121j27G.U0(i2, str);
            }
            i2++;
        }
        this.a.e();
        try {
            int iV = interfaceC15121j27G.V();
            this.a.F();
            return iV;
        } finally {
            this.a.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List c(long j) throws Throwable {
        O26 o26;
        O26 o26C = O26.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        o26C.k1(1, j);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "required_network_type");
            int iE2 = AbstractC5795Kw1.e(cursorC, "requires_charging");
            int iE3 = AbstractC5795Kw1.e(cursorC, "requires_device_idle");
            int iE4 = AbstractC5795Kw1.e(cursorC, "requires_battery_not_low");
            int iE5 = AbstractC5795Kw1.e(cursorC, "requires_storage_not_low");
            int iE6 = AbstractC5795Kw1.e(cursorC, "trigger_content_update_delay");
            int iE7 = AbstractC5795Kw1.e(cursorC, "trigger_max_content_delay");
            int iE8 = AbstractC5795Kw1.e(cursorC, "content_uri_triggers");
            int iE9 = AbstractC5795Kw1.e(cursorC, "id");
            int iE10 = AbstractC5795Kw1.e(cursorC, "state");
            int iE11 = AbstractC5795Kw1.e(cursorC, "worker_class_name");
            int iE12 = AbstractC5795Kw1.e(cursorC, "input_merger_class_name");
            int iE13 = AbstractC5795Kw1.e(cursorC, "input");
            int iE14 = AbstractC5795Kw1.e(cursorC, "output");
            o26 = o26C;
            try {
                int iE15 = AbstractC5795Kw1.e(cursorC, "initial_delay");
                int iE16 = AbstractC5795Kw1.e(cursorC, "interval_duration");
                int iE17 = AbstractC5795Kw1.e(cursorC, "flex_duration");
                int iE18 = AbstractC5795Kw1.e(cursorC, "run_attempt_count");
                int iE19 = AbstractC5795Kw1.e(cursorC, "backoff_policy");
                int iE20 = AbstractC5795Kw1.e(cursorC, "backoff_delay_duration");
                int iE21 = AbstractC5795Kw1.e(cursorC, "period_start_time");
                int iE22 = AbstractC5795Kw1.e(cursorC, "minimum_retention_duration");
                int iE23 = AbstractC5795Kw1.e(cursorC, "schedule_requested_at");
                int iE24 = AbstractC5795Kw1.e(cursorC, "run_in_foreground");
                int iE25 = AbstractC5795Kw1.e(cursorC, "out_of_quota_policy");
                int i2 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(iE9);
                    int i3 = iE9;
                    String string2 = cursorC.getString(iE11);
                    int i4 = iE11;
                    C18424oe1 c18424oe1 = new C18424oe1();
                    int i5 = iE;
                    c18424oe1.k(AbstractC22060ub8.e(cursorC.getInt(iE)));
                    c18424oe1.m(cursorC.getInt(iE2) != 0);
                    c18424oe1.n(cursorC.getInt(iE3) != 0);
                    c18424oe1.l(cursorC.getInt(iE4) != 0);
                    c18424oe1.o(cursorC.getInt(iE5) != 0);
                    int i6 = iE2;
                    int i7 = iE3;
                    c18424oe1.p(cursorC.getLong(iE6));
                    c18424oe1.q(cursorC.getLong(iE7));
                    c18424oe1.j(AbstractC22060ub8.b(cursorC.getBlob(iE8)));
                    C17810nb8 c17810nb8 = new C17810nb8(string, string2);
                    c17810nb8.b = AbstractC22060ub8.g(cursorC.getInt(iE10));
                    c17810nb8.d = cursorC.getString(iE12);
                    c17810nb8.e = androidx.work.b.h(cursorC.getBlob(iE13));
                    int i8 = i2;
                    c17810nb8.f = androidx.work.b.h(cursorC.getBlob(i8));
                    int i9 = iE15;
                    i2 = i8;
                    c17810nb8.g = cursorC.getLong(i9);
                    int i10 = iE12;
                    int i11 = iE16;
                    c17810nb8.h = cursorC.getLong(i11);
                    int i12 = iE4;
                    int i13 = iE17;
                    c17810nb8.i = cursorC.getLong(i13);
                    int i14 = iE18;
                    c17810nb8.k = cursorC.getInt(i14);
                    int i15 = iE19;
                    c17810nb8.l = AbstractC22060ub8.d(cursorC.getInt(i15));
                    iE17 = i13;
                    int i16 = iE20;
                    c17810nb8.m = cursorC.getLong(i16);
                    int i17 = iE21;
                    c17810nb8.n = cursorC.getLong(i17);
                    iE21 = i17;
                    int i18 = iE22;
                    c17810nb8.o = cursorC.getLong(i18);
                    int i19 = iE23;
                    c17810nb8.p = cursorC.getLong(i19);
                    int i20 = iE24;
                    c17810nb8.q = cursorC.getInt(i20) != 0;
                    int i21 = iE25;
                    c17810nb8.r = AbstractC22060ub8.f(cursorC.getInt(i21));
                    c17810nb8.j = c18424oe1;
                    arrayList.add(c17810nb8);
                    iE2 = i6;
                    iE25 = i21;
                    iE12 = i10;
                    iE15 = i9;
                    iE16 = i11;
                    iE18 = i14;
                    iE23 = i19;
                    iE9 = i3;
                    iE11 = i4;
                    iE = i5;
                    iE24 = i20;
                    iE22 = i18;
                    iE3 = i7;
                    iE20 = i16;
                    iE4 = i12;
                    iE19 = i15;
                }
                cursorC.close();
                o26.j();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorC.close();
                o26.j();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            o26 = o26C;
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List d() throws Throwable {
        O26 o26;
        O26 o26C = O26.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "required_network_type");
            int iE2 = AbstractC5795Kw1.e(cursorC, "requires_charging");
            int iE3 = AbstractC5795Kw1.e(cursorC, "requires_device_idle");
            int iE4 = AbstractC5795Kw1.e(cursorC, "requires_battery_not_low");
            int iE5 = AbstractC5795Kw1.e(cursorC, "requires_storage_not_low");
            int iE6 = AbstractC5795Kw1.e(cursorC, "trigger_content_update_delay");
            int iE7 = AbstractC5795Kw1.e(cursorC, "trigger_max_content_delay");
            int iE8 = AbstractC5795Kw1.e(cursorC, "content_uri_triggers");
            int iE9 = AbstractC5795Kw1.e(cursorC, "id");
            int iE10 = AbstractC5795Kw1.e(cursorC, "state");
            int iE11 = AbstractC5795Kw1.e(cursorC, "worker_class_name");
            int iE12 = AbstractC5795Kw1.e(cursorC, "input_merger_class_name");
            int iE13 = AbstractC5795Kw1.e(cursorC, "input");
            int iE14 = AbstractC5795Kw1.e(cursorC, "output");
            o26 = o26C;
            try {
                int iE15 = AbstractC5795Kw1.e(cursorC, "initial_delay");
                int iE16 = AbstractC5795Kw1.e(cursorC, "interval_duration");
                int iE17 = AbstractC5795Kw1.e(cursorC, "flex_duration");
                int iE18 = AbstractC5795Kw1.e(cursorC, "run_attempt_count");
                int iE19 = AbstractC5795Kw1.e(cursorC, "backoff_policy");
                int iE20 = AbstractC5795Kw1.e(cursorC, "backoff_delay_duration");
                int iE21 = AbstractC5795Kw1.e(cursorC, "period_start_time");
                int iE22 = AbstractC5795Kw1.e(cursorC, "minimum_retention_duration");
                int iE23 = AbstractC5795Kw1.e(cursorC, "schedule_requested_at");
                int iE24 = AbstractC5795Kw1.e(cursorC, "run_in_foreground");
                int iE25 = AbstractC5795Kw1.e(cursorC, "out_of_quota_policy");
                int i2 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(iE9);
                    int i3 = iE9;
                    String string2 = cursorC.getString(iE11);
                    int i4 = iE11;
                    C18424oe1 c18424oe1 = new C18424oe1();
                    int i5 = iE;
                    c18424oe1.k(AbstractC22060ub8.e(cursorC.getInt(iE)));
                    c18424oe1.m(cursorC.getInt(iE2) != 0);
                    c18424oe1.n(cursorC.getInt(iE3) != 0);
                    c18424oe1.l(cursorC.getInt(iE4) != 0);
                    c18424oe1.o(cursorC.getInt(iE5) != 0);
                    int i6 = iE2;
                    int i7 = iE3;
                    c18424oe1.p(cursorC.getLong(iE6));
                    c18424oe1.q(cursorC.getLong(iE7));
                    c18424oe1.j(AbstractC22060ub8.b(cursorC.getBlob(iE8)));
                    C17810nb8 c17810nb8 = new C17810nb8(string, string2);
                    c17810nb8.b = AbstractC22060ub8.g(cursorC.getInt(iE10));
                    c17810nb8.d = cursorC.getString(iE12);
                    c17810nb8.e = androidx.work.b.h(cursorC.getBlob(iE13));
                    int i8 = i2;
                    c17810nb8.f = androidx.work.b.h(cursorC.getBlob(i8));
                    i2 = i8;
                    int i9 = iE15;
                    c17810nb8.g = cursorC.getLong(i9);
                    int i10 = iE13;
                    int i11 = iE16;
                    c17810nb8.h = cursorC.getLong(i11);
                    int i12 = iE4;
                    int i13 = iE17;
                    c17810nb8.i = cursorC.getLong(i13);
                    int i14 = iE18;
                    c17810nb8.k = cursorC.getInt(i14);
                    int i15 = iE19;
                    c17810nb8.l = AbstractC22060ub8.d(cursorC.getInt(i15));
                    iE17 = i13;
                    int i16 = iE20;
                    c17810nb8.m = cursorC.getLong(i16);
                    int i17 = iE21;
                    c17810nb8.n = cursorC.getLong(i17);
                    iE21 = i17;
                    int i18 = iE22;
                    c17810nb8.o = cursorC.getLong(i18);
                    int i19 = iE23;
                    c17810nb8.p = cursorC.getLong(i19);
                    int i20 = iE24;
                    c17810nb8.q = cursorC.getInt(i20) != 0;
                    int i21 = iE25;
                    c17810nb8.r = AbstractC22060ub8.f(cursorC.getInt(i21));
                    c17810nb8.j = c18424oe1;
                    arrayList.add(c17810nb8);
                    iE25 = i21;
                    iE2 = i6;
                    iE13 = i10;
                    iE15 = i9;
                    iE16 = i11;
                    iE18 = i14;
                    iE23 = i19;
                    iE9 = i3;
                    iE11 = i4;
                    iE = i5;
                    iE24 = i20;
                    iE22 = i18;
                    iE3 = i7;
                    iE20 = i16;
                    iE4 = i12;
                    iE19 = i15;
                }
                cursorC.close();
                o26.j();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorC.close();
                o26.j();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            o26 = o26C;
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List e(String str) {
        O26 o26C = O26.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public Ta8 f(String str) {
        O26 o26C = O26.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            return cursorC.moveToFirst() ? AbstractC22060ub8.g(cursorC.getInt(0)) : null;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public C17810nb8 g(String str) throws Throwable {
        O26 o26;
        int iE;
        int iE2;
        int iE3;
        int iE4;
        int iE5;
        int iE6;
        int iE7;
        int iE8;
        int iE9;
        int iE10;
        int iE11;
        int iE12;
        int iE13;
        int iE14;
        C17810nb8 c17810nb8;
        O26 o26C = O26.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            iE = AbstractC5795Kw1.e(cursorC, "required_network_type");
            iE2 = AbstractC5795Kw1.e(cursorC, "requires_charging");
            iE3 = AbstractC5795Kw1.e(cursorC, "requires_device_idle");
            iE4 = AbstractC5795Kw1.e(cursorC, "requires_battery_not_low");
            iE5 = AbstractC5795Kw1.e(cursorC, "requires_storage_not_low");
            iE6 = AbstractC5795Kw1.e(cursorC, "trigger_content_update_delay");
            iE7 = AbstractC5795Kw1.e(cursorC, "trigger_max_content_delay");
            iE8 = AbstractC5795Kw1.e(cursorC, "content_uri_triggers");
            iE9 = AbstractC5795Kw1.e(cursorC, "id");
            iE10 = AbstractC5795Kw1.e(cursorC, "state");
            iE11 = AbstractC5795Kw1.e(cursorC, "worker_class_name");
            iE12 = AbstractC5795Kw1.e(cursorC, "input_merger_class_name");
            iE13 = AbstractC5795Kw1.e(cursorC, "input");
            iE14 = AbstractC5795Kw1.e(cursorC, "output");
            o26 = o26C;
        } catch (Throwable th) {
            th = th;
            o26 = o26C;
        }
        try {
            int iE15 = AbstractC5795Kw1.e(cursorC, "initial_delay");
            int iE16 = AbstractC5795Kw1.e(cursorC, "interval_duration");
            int iE17 = AbstractC5795Kw1.e(cursorC, "flex_duration");
            int iE18 = AbstractC5795Kw1.e(cursorC, "run_attempt_count");
            int iE19 = AbstractC5795Kw1.e(cursorC, "backoff_policy");
            int iE20 = AbstractC5795Kw1.e(cursorC, "backoff_delay_duration");
            int iE21 = AbstractC5795Kw1.e(cursorC, "period_start_time");
            int iE22 = AbstractC5795Kw1.e(cursorC, "minimum_retention_duration");
            int iE23 = AbstractC5795Kw1.e(cursorC, "schedule_requested_at");
            int iE24 = AbstractC5795Kw1.e(cursorC, "run_in_foreground");
            int iE25 = AbstractC5795Kw1.e(cursorC, "out_of_quota_policy");
            if (cursorC.moveToFirst()) {
                String string = cursorC.getString(iE9);
                String string2 = cursorC.getString(iE11);
                C18424oe1 c18424oe1 = new C18424oe1();
                c18424oe1.k(AbstractC22060ub8.e(cursorC.getInt(iE)));
                c18424oe1.m(cursorC.getInt(iE2) != 0);
                c18424oe1.n(cursorC.getInt(iE3) != 0);
                c18424oe1.l(cursorC.getInt(iE4) != 0);
                c18424oe1.o(cursorC.getInt(iE5) != 0);
                c18424oe1.p(cursorC.getLong(iE6));
                c18424oe1.q(cursorC.getLong(iE7));
                c18424oe1.j(AbstractC22060ub8.b(cursorC.getBlob(iE8)));
                C17810nb8 c17810nb82 = new C17810nb8(string, string2);
                c17810nb82.b = AbstractC22060ub8.g(cursorC.getInt(iE10));
                c17810nb82.d = cursorC.getString(iE12);
                c17810nb82.e = androidx.work.b.h(cursorC.getBlob(iE13));
                c17810nb82.f = androidx.work.b.h(cursorC.getBlob(iE14));
                c17810nb82.g = cursorC.getLong(iE15);
                c17810nb82.h = cursorC.getLong(iE16);
                c17810nb82.i = cursorC.getLong(iE17);
                c17810nb82.k = cursorC.getInt(iE18);
                c17810nb82.l = AbstractC22060ub8.d(cursorC.getInt(iE19));
                c17810nb82.m = cursorC.getLong(iE20);
                c17810nb82.n = cursorC.getLong(iE21);
                c17810nb82.o = cursorC.getLong(iE22);
                c17810nb82.p = cursorC.getLong(iE23);
                c17810nb82.q = cursorC.getInt(iE24) != 0;
                c17810nb82.r = AbstractC22060ub8.f(cursorC.getInt(iE25));
                c17810nb82.j = c18424oe1;
                c17810nb8 = c17810nb82;
            } else {
                c17810nb8 = null;
            }
            cursorC.close();
            o26.j();
            return c17810nb8;
        } catch (Throwable th2) {
            th = th2;
            cursorC.close();
            o26.j();
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List h(String str) {
        O26 o26C = O26.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List i(String str) {
        O26 o26C = O26.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(androidx.work.b.h(cursorC.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List j(int i2) throws Throwable {
        O26 o26;
        O26 o26C = O26.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        o26C.k1(1, i2);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "required_network_type");
            int iE2 = AbstractC5795Kw1.e(cursorC, "requires_charging");
            int iE3 = AbstractC5795Kw1.e(cursorC, "requires_device_idle");
            int iE4 = AbstractC5795Kw1.e(cursorC, "requires_battery_not_low");
            int iE5 = AbstractC5795Kw1.e(cursorC, "requires_storage_not_low");
            int iE6 = AbstractC5795Kw1.e(cursorC, "trigger_content_update_delay");
            int iE7 = AbstractC5795Kw1.e(cursorC, "trigger_max_content_delay");
            int iE8 = AbstractC5795Kw1.e(cursorC, "content_uri_triggers");
            int iE9 = AbstractC5795Kw1.e(cursorC, "id");
            int iE10 = AbstractC5795Kw1.e(cursorC, "state");
            int iE11 = AbstractC5795Kw1.e(cursorC, "worker_class_name");
            int iE12 = AbstractC5795Kw1.e(cursorC, "input_merger_class_name");
            int iE13 = AbstractC5795Kw1.e(cursorC, "input");
            int iE14 = AbstractC5795Kw1.e(cursorC, "output");
            o26 = o26C;
            try {
                int iE15 = AbstractC5795Kw1.e(cursorC, "initial_delay");
                int iE16 = AbstractC5795Kw1.e(cursorC, "interval_duration");
                int iE17 = AbstractC5795Kw1.e(cursorC, "flex_duration");
                int iE18 = AbstractC5795Kw1.e(cursorC, "run_attempt_count");
                int iE19 = AbstractC5795Kw1.e(cursorC, "backoff_policy");
                int iE20 = AbstractC5795Kw1.e(cursorC, "backoff_delay_duration");
                int iE21 = AbstractC5795Kw1.e(cursorC, "period_start_time");
                int iE22 = AbstractC5795Kw1.e(cursorC, "minimum_retention_duration");
                int iE23 = AbstractC5795Kw1.e(cursorC, "schedule_requested_at");
                int iE24 = AbstractC5795Kw1.e(cursorC, "run_in_foreground");
                int iE25 = AbstractC5795Kw1.e(cursorC, "out_of_quota_policy");
                int i3 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(iE9);
                    int i4 = iE9;
                    String string2 = cursorC.getString(iE11);
                    int i5 = iE11;
                    C18424oe1 c18424oe1 = new C18424oe1();
                    int i6 = iE;
                    c18424oe1.k(AbstractC22060ub8.e(cursorC.getInt(iE)));
                    c18424oe1.m(cursorC.getInt(iE2) != 0);
                    c18424oe1.n(cursorC.getInt(iE3) != 0);
                    c18424oe1.l(cursorC.getInt(iE4) != 0);
                    c18424oe1.o(cursorC.getInt(iE5) != 0);
                    int i7 = iE2;
                    int i8 = iE3;
                    c18424oe1.p(cursorC.getLong(iE6));
                    c18424oe1.q(cursorC.getLong(iE7));
                    c18424oe1.j(AbstractC22060ub8.b(cursorC.getBlob(iE8)));
                    C17810nb8 c17810nb8 = new C17810nb8(string, string2);
                    c17810nb8.b = AbstractC22060ub8.g(cursorC.getInt(iE10));
                    c17810nb8.d = cursorC.getString(iE12);
                    c17810nb8.e = androidx.work.b.h(cursorC.getBlob(iE13));
                    int i9 = i3;
                    c17810nb8.f = androidx.work.b.h(cursorC.getBlob(i9));
                    i3 = i9;
                    int i10 = iE15;
                    c17810nb8.g = cursorC.getLong(i10);
                    int i11 = iE12;
                    int i12 = iE16;
                    c17810nb8.h = cursorC.getLong(i12);
                    int i13 = iE4;
                    int i14 = iE17;
                    c17810nb8.i = cursorC.getLong(i14);
                    int i15 = iE18;
                    c17810nb8.k = cursorC.getInt(i15);
                    int i16 = iE19;
                    c17810nb8.l = AbstractC22060ub8.d(cursorC.getInt(i16));
                    iE17 = i14;
                    int i17 = iE20;
                    c17810nb8.m = cursorC.getLong(i17);
                    int i18 = iE21;
                    c17810nb8.n = cursorC.getLong(i18);
                    iE21 = i18;
                    int i19 = iE22;
                    c17810nb8.o = cursorC.getLong(i19);
                    int i20 = iE23;
                    c17810nb8.p = cursorC.getLong(i20);
                    int i21 = iE24;
                    c17810nb8.q = cursorC.getInt(i21) != 0;
                    int i22 = iE25;
                    c17810nb8.r = AbstractC22060ub8.f(cursorC.getInt(i22));
                    c17810nb8.j = c18424oe1;
                    arrayList.add(c17810nb8);
                    iE25 = i22;
                    iE2 = i7;
                    iE12 = i11;
                    iE15 = i10;
                    iE16 = i12;
                    iE18 = i15;
                    iE23 = i20;
                    iE9 = i4;
                    iE11 = i5;
                    iE = i6;
                    iE24 = i21;
                    iE22 = i19;
                    iE3 = i8;
                    iE20 = i17;
                    iE4 = i13;
                    iE19 = i16;
                }
                cursorC.close();
                o26.j();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorC.close();
                o26.j();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            o26 = o26C;
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public int k() {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.i.b();
        this.a.e();
        try {
            int iV = interfaceC15121j27B.V();
            this.a.F();
            return iV;
        } finally {
            this.a.j();
            this.i.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public int l(String str, long j) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.h.b();
        interfaceC15121j27B.k1(1, j);
        if (str == null) {
            interfaceC15121j27B.y1(2);
        } else {
            interfaceC15121j27B.U0(2, str);
        }
        this.a.e();
        try {
            int iV = interfaceC15121j27B.V();
            this.a.F();
            return iV;
        } finally {
            this.a.j();
            this.h.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List m(String str) {
        O26 o26C = O26.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "state");
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                C17810nb8.b bVar = new C17810nb8.b();
                bVar.a = cursorC.getString(iE);
                bVar.b = AbstractC22060ub8.g(cursorC.getInt(iE2));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List n(int i2) throws Throwable {
        O26 o26;
        O26 o26C = O26.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        o26C.k1(1, i2);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "required_network_type");
            int iE2 = AbstractC5795Kw1.e(cursorC, "requires_charging");
            int iE3 = AbstractC5795Kw1.e(cursorC, "requires_device_idle");
            int iE4 = AbstractC5795Kw1.e(cursorC, "requires_battery_not_low");
            int iE5 = AbstractC5795Kw1.e(cursorC, "requires_storage_not_low");
            int iE6 = AbstractC5795Kw1.e(cursorC, "trigger_content_update_delay");
            int iE7 = AbstractC5795Kw1.e(cursorC, "trigger_max_content_delay");
            int iE8 = AbstractC5795Kw1.e(cursorC, "content_uri_triggers");
            int iE9 = AbstractC5795Kw1.e(cursorC, "id");
            int iE10 = AbstractC5795Kw1.e(cursorC, "state");
            int iE11 = AbstractC5795Kw1.e(cursorC, "worker_class_name");
            int iE12 = AbstractC5795Kw1.e(cursorC, "input_merger_class_name");
            int iE13 = AbstractC5795Kw1.e(cursorC, "input");
            int iE14 = AbstractC5795Kw1.e(cursorC, "output");
            o26 = o26C;
            try {
                int iE15 = AbstractC5795Kw1.e(cursorC, "initial_delay");
                int iE16 = AbstractC5795Kw1.e(cursorC, "interval_duration");
                int iE17 = AbstractC5795Kw1.e(cursorC, "flex_duration");
                int iE18 = AbstractC5795Kw1.e(cursorC, "run_attempt_count");
                int iE19 = AbstractC5795Kw1.e(cursorC, "backoff_policy");
                int iE20 = AbstractC5795Kw1.e(cursorC, "backoff_delay_duration");
                int iE21 = AbstractC5795Kw1.e(cursorC, "period_start_time");
                int iE22 = AbstractC5795Kw1.e(cursorC, "minimum_retention_duration");
                int iE23 = AbstractC5795Kw1.e(cursorC, "schedule_requested_at");
                int iE24 = AbstractC5795Kw1.e(cursorC, "run_in_foreground");
                int iE25 = AbstractC5795Kw1.e(cursorC, "out_of_quota_policy");
                int i3 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(iE9);
                    int i4 = iE9;
                    String string2 = cursorC.getString(iE11);
                    int i5 = iE11;
                    C18424oe1 c18424oe1 = new C18424oe1();
                    int i6 = iE;
                    c18424oe1.k(AbstractC22060ub8.e(cursorC.getInt(iE)));
                    c18424oe1.m(cursorC.getInt(iE2) != 0);
                    c18424oe1.n(cursorC.getInt(iE3) != 0);
                    c18424oe1.l(cursorC.getInt(iE4) != 0);
                    c18424oe1.o(cursorC.getInt(iE5) != 0);
                    int i7 = iE2;
                    int i8 = iE3;
                    c18424oe1.p(cursorC.getLong(iE6));
                    c18424oe1.q(cursorC.getLong(iE7));
                    c18424oe1.j(AbstractC22060ub8.b(cursorC.getBlob(iE8)));
                    C17810nb8 c17810nb8 = new C17810nb8(string, string2);
                    c17810nb8.b = AbstractC22060ub8.g(cursorC.getInt(iE10));
                    c17810nb8.d = cursorC.getString(iE12);
                    c17810nb8.e = androidx.work.b.h(cursorC.getBlob(iE13));
                    int i9 = i3;
                    c17810nb8.f = androidx.work.b.h(cursorC.getBlob(i9));
                    i3 = i9;
                    int i10 = iE15;
                    c17810nb8.g = cursorC.getLong(i10);
                    int i11 = iE12;
                    int i12 = iE16;
                    c17810nb8.h = cursorC.getLong(i12);
                    int i13 = iE4;
                    int i14 = iE17;
                    c17810nb8.i = cursorC.getLong(i14);
                    int i15 = iE18;
                    c17810nb8.k = cursorC.getInt(i15);
                    int i16 = iE19;
                    c17810nb8.l = AbstractC22060ub8.d(cursorC.getInt(i16));
                    iE17 = i14;
                    int i17 = iE20;
                    c17810nb8.m = cursorC.getLong(i17);
                    int i18 = iE21;
                    c17810nb8.n = cursorC.getLong(i18);
                    iE21 = i18;
                    int i19 = iE22;
                    c17810nb8.o = cursorC.getLong(i19);
                    int i20 = iE23;
                    c17810nb8.p = cursorC.getLong(i20);
                    int i21 = iE24;
                    c17810nb8.q = cursorC.getInt(i21) != 0;
                    int i22 = iE25;
                    c17810nb8.r = AbstractC22060ub8.f(cursorC.getInt(i22));
                    c17810nb8.j = c18424oe1;
                    arrayList.add(c17810nb8);
                    iE25 = i22;
                    iE2 = i7;
                    iE12 = i11;
                    iE15 = i10;
                    iE16 = i12;
                    iE18 = i15;
                    iE23 = i20;
                    iE9 = i4;
                    iE11 = i5;
                    iE = i6;
                    iE24 = i21;
                    iE22 = i19;
                    iE3 = i8;
                    iE20 = i17;
                    iE4 = i13;
                    iE19 = i16;
                }
                cursorC.close();
                o26.j();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorC.close();
                o26.j();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            o26 = o26C;
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public void o(String str, androidx.work.b bVar) throws Throwable {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.d.b();
        byte[] bArrP = androidx.work.b.p(bVar);
        if (bArrP == null) {
            interfaceC15121j27B.y1(1);
        } else {
            interfaceC15121j27B.n1(1, bArrP);
        }
        if (str == null) {
            interfaceC15121j27B.y1(2);
        } else {
            interfaceC15121j27B.U0(2, str);
        }
        this.a.e();
        try {
            interfaceC15121j27B.V();
            this.a.F();
        } finally {
            this.a.j();
            this.d.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public void p(C17810nb8 c17810nb8) {
        this.a.d();
        this.a.e();
        try {
            this.b.k(c17810nb8);
            this.a.F();
        } finally {
            this.a.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public List q() throws Throwable {
        O26 o26;
        O26 o26C = O26.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "required_network_type");
            int iE2 = AbstractC5795Kw1.e(cursorC, "requires_charging");
            int iE3 = AbstractC5795Kw1.e(cursorC, "requires_device_idle");
            int iE4 = AbstractC5795Kw1.e(cursorC, "requires_battery_not_low");
            int iE5 = AbstractC5795Kw1.e(cursorC, "requires_storage_not_low");
            int iE6 = AbstractC5795Kw1.e(cursorC, "trigger_content_update_delay");
            int iE7 = AbstractC5795Kw1.e(cursorC, "trigger_max_content_delay");
            int iE8 = AbstractC5795Kw1.e(cursorC, "content_uri_triggers");
            int iE9 = AbstractC5795Kw1.e(cursorC, "id");
            int iE10 = AbstractC5795Kw1.e(cursorC, "state");
            int iE11 = AbstractC5795Kw1.e(cursorC, "worker_class_name");
            int iE12 = AbstractC5795Kw1.e(cursorC, "input_merger_class_name");
            int iE13 = AbstractC5795Kw1.e(cursorC, "input");
            int iE14 = AbstractC5795Kw1.e(cursorC, "output");
            o26 = o26C;
            try {
                int iE15 = AbstractC5795Kw1.e(cursorC, "initial_delay");
                int iE16 = AbstractC5795Kw1.e(cursorC, "interval_duration");
                int iE17 = AbstractC5795Kw1.e(cursorC, "flex_duration");
                int iE18 = AbstractC5795Kw1.e(cursorC, "run_attempt_count");
                int iE19 = AbstractC5795Kw1.e(cursorC, "backoff_policy");
                int iE20 = AbstractC5795Kw1.e(cursorC, "backoff_delay_duration");
                int iE21 = AbstractC5795Kw1.e(cursorC, "period_start_time");
                int iE22 = AbstractC5795Kw1.e(cursorC, "minimum_retention_duration");
                int iE23 = AbstractC5795Kw1.e(cursorC, "schedule_requested_at");
                int iE24 = AbstractC5795Kw1.e(cursorC, "run_in_foreground");
                int iE25 = AbstractC5795Kw1.e(cursorC, "out_of_quota_policy");
                int i2 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(iE9);
                    int i3 = iE9;
                    String string2 = cursorC.getString(iE11);
                    int i4 = iE11;
                    C18424oe1 c18424oe1 = new C18424oe1();
                    int i5 = iE;
                    c18424oe1.k(AbstractC22060ub8.e(cursorC.getInt(iE)));
                    c18424oe1.m(cursorC.getInt(iE2) != 0);
                    c18424oe1.n(cursorC.getInt(iE3) != 0);
                    c18424oe1.l(cursorC.getInt(iE4) != 0);
                    c18424oe1.o(cursorC.getInt(iE5) != 0);
                    int i6 = iE2;
                    int i7 = iE3;
                    c18424oe1.p(cursorC.getLong(iE6));
                    c18424oe1.q(cursorC.getLong(iE7));
                    c18424oe1.j(AbstractC22060ub8.b(cursorC.getBlob(iE8)));
                    C17810nb8 c17810nb8 = new C17810nb8(string, string2);
                    c17810nb8.b = AbstractC22060ub8.g(cursorC.getInt(iE10));
                    c17810nb8.d = cursorC.getString(iE12);
                    c17810nb8.e = androidx.work.b.h(cursorC.getBlob(iE13));
                    int i8 = i2;
                    c17810nb8.f = androidx.work.b.h(cursorC.getBlob(i8));
                    i2 = i8;
                    int i9 = iE15;
                    c17810nb8.g = cursorC.getLong(i9);
                    int i10 = iE13;
                    int i11 = iE16;
                    c17810nb8.h = cursorC.getLong(i11);
                    int i12 = iE4;
                    int i13 = iE17;
                    c17810nb8.i = cursorC.getLong(i13);
                    int i14 = iE18;
                    c17810nb8.k = cursorC.getInt(i14);
                    int i15 = iE19;
                    c17810nb8.l = AbstractC22060ub8.d(cursorC.getInt(i15));
                    iE17 = i13;
                    int i16 = iE20;
                    c17810nb8.m = cursorC.getLong(i16);
                    int i17 = iE21;
                    c17810nb8.n = cursorC.getLong(i17);
                    iE21 = i17;
                    int i18 = iE22;
                    c17810nb8.o = cursorC.getLong(i18);
                    int i19 = iE23;
                    c17810nb8.p = cursorC.getLong(i19);
                    int i20 = iE24;
                    c17810nb8.q = cursorC.getInt(i20) != 0;
                    int i21 = iE25;
                    c17810nb8.r = AbstractC22060ub8.f(cursorC.getInt(i21));
                    c17810nb8.j = c18424oe1;
                    arrayList.add(c17810nb8);
                    iE25 = i21;
                    iE2 = i6;
                    iE13 = i10;
                    iE15 = i9;
                    iE16 = i11;
                    iE18 = i14;
                    iE23 = i19;
                    iE9 = i3;
                    iE11 = i4;
                    iE = i5;
                    iE24 = i20;
                    iE22 = i18;
                    iE3 = i7;
                    iE20 = i16;
                    iE4 = i12;
                    iE19 = i15;
                }
                cursorC.close();
                o26.j();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorC.close();
                o26.j();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            o26 = o26C;
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public boolean r() {
        boolean z = false;
        O26 o26C = O26.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            if (cursorC.moveToFirst()) {
                if (cursorC.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public int s(String str) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.g.b();
        if (str == null) {
            interfaceC15121j27B.y1(1);
        } else {
            interfaceC15121j27B.U0(1, str);
        }
        this.a.e();
        try {
            int iV = interfaceC15121j27B.V();
            this.a.F();
            return iV;
        } finally {
            this.a.j();
            this.g.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public int t(String str) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.f.b();
        if (str == null) {
            interfaceC15121j27B.y1(1);
        } else {
            interfaceC15121j27B.U0(1, str);
        }
        this.a.e();
        try {
            int iV = interfaceC15121j27B.V();
            this.a.F();
            return iV;
        } finally {
            this.a.j();
            this.f.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC18401ob8
    public void u(String str, long j) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.e.b();
        interfaceC15121j27B.k1(1, j);
        if (str == null) {
            interfaceC15121j27B.y1(2);
        } else {
            interfaceC15121j27B.U0(2, str);
        }
        this.a.e();
        try {
            interfaceC15121j27B.V();
            this.a.F();
        } finally {
            this.a.j();
            this.e.h(interfaceC15121j27B);
        }
    }
}
