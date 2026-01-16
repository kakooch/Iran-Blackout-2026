package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.Wk3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8542Wk3 extends AbstractC22735vk3 {
    private final C19343qB3 a = new C19343qB3(false);

    public void C(String str, AbstractC22735vk3 abstractC22735vk3) {
        C19343qB3 c19343qB3 = this.a;
        if (abstractC22735vk3 == null) {
            abstractC22735vk3 = C8074Uk3.a;
        }
        c19343qB3.put(str, abstractC22735vk3);
    }

    public void D(String str, Boolean bool) {
        C(str, bool == null ? C8074Uk3.a : new C9906al3(bool));
    }

    public void E(String str, Number number) {
        C(str, number == null ? C8074Uk3.a : new C9906al3(number));
    }

    public void F(String str, String str2) {
        C(str, str2 == null ? C8074Uk3.a : new C9906al3(str2));
    }

    public Set I() {
        return this.a.entrySet();
    }

    public AbstractC22735vk3 L(String str) {
        return (AbstractC22735vk3) this.a.get(str);
    }

    public C8542Wk3 N(String str) {
        return (C8542Wk3) this.a.get(str);
    }

    public boolean O(String str) {
        return this.a.containsKey(str);
    }

    public Set P() {
        return this.a.keySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C8542Wk3) && ((C8542Wk3) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
