package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONException;

/* renamed from: ir.nasim.Pe1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6833Pe1 extends AbstractC17457n0 {
    private String c;
    private String d;
    private String e;
    private ArrayList f;
    private ArrayList g;
    private int h;
    private boolean i;
    private Avatar j;

    public C6833Pe1(C11909dl1 c11909dl1) {
        super(c11909dl1);
        this.e = ((C8664Wy) c11909dl1.c()).u();
        C19231q00 c19231q00 = new C19231q00(new C19231q00(this.e).g("data").o().L("contact").o());
        this.c = c19231q00.n("name");
        try {
            this.d = c19231q00.n("photo");
        } catch (Exception e) {
            C19406qI3.c("ContactContent", "contact photo", e);
        }
        this.f = new ArrayList();
        C13149fk3 c13149fk3H = c19231q00.h("phones");
        for (int i = 0; i < c13149fk3H.size(); i++) {
            this.f.add(c13149fk3H.E(i).v());
        }
        this.g = new ArrayList();
        C13149fk3 c13149fk3H2 = c19231q00.h("emails");
        for (int i2 = 0; i2 < c13149fk3H2.size(); i2++) {
            this.g.add(c13149fk3H2.E(i2).v());
        }
    }

    public static C6833Pe1 r(String str, ArrayList arrayList, ArrayList arrayList2, String str2) {
        try {
            C19231q00 c19231q00 = new C19231q00();
            c19231q00.f("dataType", "contact");
            C19231q00 c19231q002 = new C19231q00();
            c19231q002.f("name", str);
            if (str2 != null) {
                c19231q002.f("photo", str2);
            }
            C13149fk3 c13149fk3 = new C13149fk3();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c13149fk3.D((String) it.next());
            }
            C13149fk3 c13149fk32 = new C13149fk3();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c13149fk32.D((String) it2.next());
            }
            c19231q002.c("emails", c13149fk32);
            c19231q002.c("phones", c13149fk3);
            C8542Wk3 c8542Wk3 = new C8542Wk3();
            c8542Wk3.C("contact", c19231q002.l());
            c19231q00.d("data", c8542Wk3);
            return new C6833Pe1(new C11909dl1(new C8664Wy(c19231q00.toString())));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void A(boolean z) {
        this.i = z;
    }

    public void B(int i) {
        this.h = i;
    }

    public C6833Pe1 C(int i, boolean z, Avatar avatar) {
        B(i);
        A(z);
        z(avatar);
        return this;
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_contact);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C6833Pe1 c6833Pe1 = (C6833Pe1) obj;
        return this.h == c6833Pe1.h && this.i == c6833Pe1.i && Objects.equals(this.c, c6833Pe1.c) && Objects.equals(this.d, c6833Pe1.d) && Objects.equals(this.e, c6833Pe1.e) && Objects.equals(this.f, c6833Pe1.f) && Objects.equals(this.g, c6833Pe1.g) && Objects.equals(this.j, c6833Pe1.j);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.e, this.f, this.g, Integer.valueOf(this.h), Boolean.valueOf(this.i), this.j);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        return context.getString(AbstractC12217eE5.message_holder_content_contact) + this.c + (!this.f.isEmpty() ? XY6.t((String) this.f.get(0)) : "");
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        StringBuilder sb = new StringBuilder("");
        Iterator it = w().iterator();
        while (it.hasNext()) {
            sb.append(Separators.RETURN.concat((String) it.next()));
        }
        Iterator it2 = t().iterator();
        while (it2.hasNext()) {
            sb.append(Separators.RETURN.concat((String) it2.next()));
        }
        return new C23345wl7(new C11909dl1(new ZC(sb.toString(), new ArrayList(), null, null)));
    }

    public Avatar s() {
        return this.j;
    }

    public ArrayList t() {
        return this.g;
    }

    public boolean u() {
        return this.i;
    }

    public String v() {
        return this.c;
    }

    public ArrayList w() {
        return this.f;
    }

    public String x() {
        return this.e;
    }

    public int y() {
        return this.h;
    }

    public void z(Avatar avatar) {
        this.j = avatar;
    }
}
