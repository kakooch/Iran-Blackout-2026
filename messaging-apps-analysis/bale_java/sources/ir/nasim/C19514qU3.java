package ir.nasim;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import ir.nasim.AbstractC17150mU3;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.qU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C19514qU3 extends AbstractC17150mU3 {
    private final TextView.BufferType a;
    private final HW4 b;
    private final AbstractC24951zU3 c;
    private final C18332oU3 d;
    private final List e;
    private final boolean f;

    C19514qU3(TextView.BufferType bufferType, AbstractC17150mU3.b bVar, HW4 hw4, AbstractC24951zU3 abstractC24951zU3, C18332oU3 c18332oU3, List list, boolean z) {
        this.a = bufferType;
        this.b = hw4;
        this.c = abstractC24951zU3;
        this.d = c18332oU3;
        this.e = list;
        this.f = z;
    }

    @Override // ir.nasim.AbstractC17150mU3
    public Spanned b(String str) {
        Spanned spannedD = d(c(str));
        return (TextUtils.isEmpty(spannedD) && this.f && !TextUtils.isEmpty(str)) ? new SpannableStringBuilder(str) : spannedD;
    }

    public TA4 c(String str) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            str = ((InterfaceC21991uU3) it.next()).g(str);
        }
        return this.b.b(str);
    }

    public Spanned d(TA4 ta4) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((InterfaceC21991uU3) it.next()).b(ta4);
        }
        InterfaceC24357yU3 interfaceC24357yU3A = this.c.a();
        ta4.a(interfaceC24357yU3A);
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((InterfaceC21991uU3) it2.next()).h(ta4, interfaceC24357yU3A);
        }
        return interfaceC24357yU3A.m().m();
    }
}
