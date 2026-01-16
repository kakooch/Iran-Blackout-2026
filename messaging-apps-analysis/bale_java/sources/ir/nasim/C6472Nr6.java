package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.banking.entity.MyBankData;
import ir.nasim.database.entity.ServiceItemMenuItemEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Nr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6472Nr6 {
    public static final a q = new a(null);
    public static final int r = 8;
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final boolean h;
    private final int i;
    private final Integer j;
    private final Integer k;
    private final String l;
    private final String m;
    private final String n;
    private final List o;
    private final int p;

    /* renamed from: ir.nasim.Nr6$a */
    public static final class a {
        private a() {
        }

        public final C6472Nr6 a(C5988Lr6 c5988Lr6, boolean z) {
            ArrayList arrayList;
            AbstractC13042fc3.i(c5988Lr6, "serviceItemEntity");
            List listM0 = AbstractC20762sZ6.M0(c5988Lr6.f(), new char[]{'|'}, false, 2, 2, null);
            String str = (String) AbstractC15401jX0.t0(listM0, 0);
            String str2 = (String) AbstractC15401jX0.t0(listM0, 1);
            String strC = c5988Lr6.c();
            List listM02 = strC != null ? AbstractC20762sZ6.M0(strC, new char[]{'|'}, false, 2, 2, null) : null;
            String str3 = listM02 != null ? (String) AbstractC15401jX0.t0(listM02, 0) : null;
            String str4 = listM02 != null ? (String) AbstractC15401jX0.t0(listM02, 1) : null;
            List listI = c5988Lr6.i();
            if (listI != null) {
                List<ServiceItemMenuItemEntity> list = listI;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (ServiceItemMenuItemEntity serviceItemMenuItemEntity : list) {
                    arrayList2.add(new MyBankData.Item(serviceItemMenuItemEntity.getId(), serviceItemMenuItemEntity.getTitle(), null, serviceItemMenuItemEntity.getIcon(), null, false, false, Integer.valueOf(serviceItemMenuItemEntity.getAction()), new MyBankData.Payload(serviceItemMenuItemEntity.getUrl(), null, null, null, false, null, 16, null), 0, 0, false, null, false, 15968, null));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new C6472Nr6(c5988Lr6.g(), c5988Lr6.n(), str, str2, str3, str4, c5988Lr6.b(), z, c5988Lr6.a(), c5988Lr6.k(), c5988Lr6.l(), c5988Lr6.o(), c5988Lr6.d(), c5988Lr6.e(), arrayList, c5988Lr6.m());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C6472Nr6(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i2, Integer num, Integer num2, String str7, String str8, String str9, List list, int i3) {
        AbstractC13042fc3.i(str, "title");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = z;
        this.i = i2;
        this.j = num;
        this.k = num2;
        this.l = str7;
        this.m = str8;
        this.n = str9;
        this.o = list;
        this.p = i3;
    }

    public final int a() {
        return this.i;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6472Nr6)) {
            return false;
        }
        C6472Nr6 c6472Nr6 = (C6472Nr6) obj;
        return this.a == c6472Nr6.a && AbstractC13042fc3.d(this.b, c6472Nr6.b) && AbstractC13042fc3.d(this.c, c6472Nr6.c) && AbstractC13042fc3.d(this.d, c6472Nr6.d) && AbstractC13042fc3.d(this.e, c6472Nr6.e) && AbstractC13042fc3.d(this.f, c6472Nr6.f) && AbstractC13042fc3.d(this.g, c6472Nr6.g) && this.h == c6472Nr6.h && this.i == c6472Nr6.i && AbstractC13042fc3.d(this.j, c6472Nr6.j) && AbstractC13042fc3.d(this.k, c6472Nr6.k) && AbstractC13042fc3.d(this.l, c6472Nr6.l) && AbstractC13042fc3.d(this.m, c6472Nr6.m) && AbstractC13042fc3.d(this.n, c6472Nr6.n) && AbstractC13042fc3.d(this.o, c6472Nr6.o) && this.p == c6472Nr6.p;
    }

    public final String f() {
        return this.d;
    }

    public final String g() {
        return this.c;
    }

    public final int h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.g;
        int iHashCode6 = (((((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31;
        Integer num = this.j;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.k;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.l;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.m;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.n;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List list = this.o;
        return ((iHashCode11 + (list != null ? list.hashCode() : 0)) * 31) + Integer.hashCode(this.p);
    }

    public final List i() {
        return this.o;
    }

    public final Integer j() {
        return this.j;
    }

    public final Integer k() {
        return this.k;
    }

    public final int l() {
        return this.p;
    }

    public final boolean m() {
        return this.h;
    }

    public final String n() {
        return this.b;
    }

    public final String o() {
        return this.l;
    }

    public String toString() {
        return "ServiceItemUI(id=" + this.a + ", title=" + this.b + ", iconUrlLight=" + this.c + ", iconUrlDark=" + this.d + ", customIconUrlLight=" + this.e + ", customIconUrlDark=" + this.f + ", badge=" + this.g + ", shouldShowBadge=" + this.h + ", action=" + this.i + ", peerId=" + this.j + ", peerType=" + this.k + ", url=" + this.l + ", eventKey=" + this.m + ", eventName=" + this.n + ", menuItems=" + this.o + ", sectionId=" + this.p + Separators.RPAREN;
    }
}
