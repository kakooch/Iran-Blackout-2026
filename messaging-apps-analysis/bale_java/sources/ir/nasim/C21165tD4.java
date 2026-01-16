package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Build;
import android.os.Bundle;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.tD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21165tD4 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final String a;
    private final String b;
    private final long c;
    private final String d;
    private final FileReference e;
    private final String f;
    private final AbstractC24063xz g;
    private final String h;
    private final String i;
    private final C11458d25 j;
    private final long k;

    /* renamed from: ir.nasim.tD4$a */
    public static final class a {
        private a() {
        }

        private final AbstractC24063xz c(Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("baseMessage");
                if (stringExtra != null) {
                    return AbstractC24063xz.r(C14582i90.a(stringExtra));
                }
            } catch (Exception e) {
                C19406qI3.a("NotificationData", e.getMessage(), new Object[0]);
            }
            return null;
        }

        private final C14733iO2 d(int i) {
            return (C14733iO2) AbstractC5969Lp4.b().n(i);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final ir.nasim.core.modules.file.entity.FileReference e(ir.nasim.C11458d25 r3) {
            /*
                r2 = this;
                boolean r0 = r3.z()
                r1 = 0
                if (r0 == 0) goto L20
                int r3 = r3.getPeerId()
                ir.nasim.iO2 r3 = r2.d(r3)
                if (r3 == 0) goto L1e
                ir.nasim.qQ7 r3 = r3.j()
                if (r3 == 0) goto L1e
                java.lang.Object r3 = r3.b()
                ir.nasim.core.modules.profile.entity.Avatar r3 = (ir.nasim.core.modules.profile.entity.Avatar) r3
                goto L32
            L1e:
                r3 = r1
                goto L32
            L20:
                ir.nasim.tK7 r3 = r2.i(r3)
                if (r3 == 0) goto L1e
                ir.nasim.qQ7 r3 = r3.h()
                if (r3 == 0) goto L1e
                java.lang.Object r3 = r3.b()
                ir.nasim.core.modules.profile.entity.Avatar r3 = (ir.nasim.core.modules.profile.entity.Avatar) r3
            L32:
                if (r3 == 0) goto L3e
                ir.nasim.core.modules.profile.entity.AvatarImage r3 = r3.getImageDefaultSize()
                if (r3 == 0) goto L3e
                ir.nasim.core.modules.file.entity.FileReference r1 = r3.getFileReference()
            L3e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21165tD4.a.e(ir.nasim.d25):ir.nasim.core.modules.file.entity.FileReference");
        }

        private final String g(C11458d25 c11458d25, Intent intent) {
            C10410bZ6 c10410bZ6R;
            String str;
            C10410bZ6 c10410bZ6V;
            String str2;
            String stringExtra = intent.getStringExtra("title");
            if (stringExtra != null && stringExtra.length() > 0) {
                return stringExtra;
            }
            if (c11458d25.z()) {
                C14733iO2 c14733iO2D = d(c11458d25.getPeerId());
                if (c14733iO2D != null && (c10410bZ6V = c14733iO2D.v()) != null && (str2 = (String) c10410bZ6V.b()) != null) {
                    return str2;
                }
                String string = C5721Ko.a.d().getString(AbstractC12217eE5.all_default_group_title);
                AbstractC13042fc3.h(string, "getString(...)");
                return string;
            }
            C21231tK7 c21231tK7I = i(c11458d25);
            if (c21231tK7I != null && (c10410bZ6R = c21231tK7I.r()) != null && (str = (String) c10410bZ6R.b()) != null) {
                return str;
            }
            String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }

        private final String h(int i, String str, long j) {
            C14733iO2 c14733iO2D;
            if (Build.VERSION.SDK_INT >= 29 || (c14733iO2D = d(i)) == null || c14733iO2D.q() != ZN2.GROUP) {
                return str;
            }
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j);
            if (c21231tK7 != null) {
                return ((String) c21231tK7.r().b()) + ": " + str;
            }
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
            AbstractC13042fc3.h(string, "getString(...)");
            return string + ": " + str;
        }

        private final C21231tK7 i(C11458d25 c11458d25) {
            return (C21231tK7) AbstractC5969Lp4.g().n(c11458d25.getPeerId());
        }

        public final C11458d25 a(Intent intent) {
            AbstractC13042fc3.i(intent, "intent");
            String stringExtra = intent.getStringExtra("peerType");
            String stringExtra2 = intent.getStringExtra("peer_user_id");
            W25 w25 = AbstractC13042fc3.d(stringExtra, "2") ? W25.b : W25.a;
            AbstractC13042fc3.f(stringExtra2);
            return new C11458d25(w25, Integer.parseInt(stringExtra2));
        }

        public final C21165tD4 b(Intent intent) {
            long j;
            long j2;
            Object obj;
            String string;
            AbstractC13042fc3.i(intent, "intent");
            String stringExtra = intent.getStringExtra("messageDate");
            String str = stringExtra == null ? "" : stringExtra;
            String stringExtra2 = intent.getStringExtra("senderUserId");
            long j3 = stringExtra2 != null ? Long.parseLong(stringExtra2) : 0L;
            String stringExtra3 = intent.getStringExtra("MessageRID");
            String str2 = stringExtra3 == null ? "" : stringExtra3;
            String stringExtra4 = intent.getStringExtra("pushType");
            if (stringExtra4 == null) {
                stringExtra4 = TokenNames.MESSAGE;
            }
            String str3 = stringExtra4;
            String stringExtra5 = intent.getStringExtra(ParameterNames.ICON);
            C11458d25 c11458d25A = a(intent);
            if (AbstractC13042fc3.d("REACTION", str3)) {
                Bundle extras = intent.getExtras();
                if (extras == null || (obj = extras.get("pushSendTime")) == null || (string = obj.toString()) == null) {
                    j2 = 0;
                    return new C21165tD4(g(c11458d25A, intent), f(c11458d25A, intent), j3, str, e(c11458d25A), str2, c(intent), str3, stringExtra5, c11458d25A, j2);
                }
                j = Long.parseLong(string);
            } else {
                j = Long.parseLong(str);
            }
            j2 = j;
            return new C21165tD4(g(c11458d25A, intent), f(c11458d25A, intent), j3, str, e(c11458d25A), str2, c(intent), str3, stringExtra5, c11458d25A, j2);
        }

        public final String f(C11458d25 c11458d25, Intent intent) {
            String stringExtra;
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(intent, "intent");
            if (!AbstractC5969Lp4.d().B0() || (stringExtra = intent.getStringExtra(ParameterNames.TEXT)) == null || stringExtra.length() <= 0) {
                String string = C5721Ko.a.d().getString(AbstractC12217eE5.notification_privacy_title);
                AbstractC13042fc3.h(string, "getString(...)");
                return string;
            }
            if (!c11458d25.z()) {
                return stringExtra;
            }
            String stringExtra2 = intent.getStringExtra("senderUserId");
            return C21165tD4.l.h(c11458d25.getPeerId(), stringExtra, stringExtra2 != null ? Long.parseLong(stringExtra2) : 0L);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tD4$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public C21165tD4(String str, String str2, long j, String str3, FileReference fileReference, String str4, AbstractC24063xz abstractC24063xz, String str5, String str6, C11458d25 c11458d25, long j2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, ParameterNames.TEXT);
        AbstractC13042fc3.i(str3, "messageDate");
        AbstractC13042fc3.i(str4, "messageRid");
        AbstractC13042fc3.i(str5, "pushType");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
        this.e = fileReference;
        this.f = str4;
        this.g = abstractC24063xz;
        this.h = str5;
        this.i = str6;
        this.j = c11458d25;
        this.k = j2;
    }

    public final AbstractC24063xz a() {
        return this.g;
    }

    public final FileReference b() {
        return this.e;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.f;
    }

    public final C11458d25 e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21165tD4)) {
            return false;
        }
        C21165tD4 c21165tD4 = (C21165tD4) obj;
        return AbstractC13042fc3.d(this.a, c21165tD4.a) && AbstractC13042fc3.d(this.b, c21165tD4.b) && this.c == c21165tD4.c && AbstractC13042fc3.d(this.d, c21165tD4.d) && AbstractC13042fc3.d(this.e, c21165tD4.e) && AbstractC13042fc3.d(this.f, c21165tD4.f) && AbstractC13042fc3.d(this.g, c21165tD4.g) && AbstractC13042fc3.d(this.h, c21165tD4.h) && AbstractC13042fc3.d(this.i, c21165tD4.i) && AbstractC13042fc3.d(this.j, c21165tD4.j) && this.k == c21165tD4.k;
    }

    public final String f() {
        return this.h;
    }

    public final Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putString("title", this.a);
        bundle.putString(ParameterNames.TEXT, this.b);
        bundle.putString("messageDate", this.d);
        bundle.putString("peer_user_id", String.valueOf(this.j.getPeerId()));
        int i = b.a[this.j.s().ordinal()];
        String str = i != 1 ? i != 2 ? null : "1" : "2";
        bundle.putString("senderUserId", String.valueOf(this.c));
        bundle.putString("peerType", str);
        return bundle;
    }

    public final long h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        FileReference fileReference = this.e;
        int iHashCode2 = (((iHashCode + (fileReference == null ? 0 : fileReference.hashCode())) * 31) + this.f.hashCode()) * 31;
        AbstractC24063xz abstractC24063xz = this.g;
        int iHashCode3 = (((iHashCode2 + (abstractC24063xz == null ? 0 : abstractC24063xz.hashCode())) * 31) + this.h.hashCode()) * 31;
        String str = this.i;
        return ((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.j.hashCode()) * 31) + Long.hashCode(this.k);
    }

    public final long i() {
        return this.k;
    }

    public final String j() {
        return this.i;
    }

    public final String k() {
        return this.b;
    }

    public final String l() {
        return this.a;
    }

    public String toString() {
        return "NotificationData(title=" + this.a + ", text=" + this.b + ", senderId=" + this.c + ", messageDate=" + this.d + ", fileReference=" + this.e + ", messageRid=" + this.f + ", baseMessage=" + this.g + ", pushType=" + this.h + ", specificIconKey=" + this.i + ", peer=" + this.j + ", sortTime=" + this.k + Separators.RPAREN;
    }

    public /* synthetic */ C21165tD4(String str, String str2, long j, String str3, FileReference fileReference, String str4, AbstractC24063xz abstractC24063xz, String str5, String str6, C11458d25 c11458d25, long j2, int i, ED1 ed1) {
        this(str, str2, j, str3, fileReference, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? null : abstractC24063xz, str5, (i & 256) != 0 ? null : str6, c11458d25, j2);
    }
}
