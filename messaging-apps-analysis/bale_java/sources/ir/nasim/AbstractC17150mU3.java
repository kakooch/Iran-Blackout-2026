package ir.nasim;

import android.content.Context;
import android.text.Spanned;

/* renamed from: ir.nasim.mU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17150mU3 {

    /* renamed from: ir.nasim.mU3$a */
    public interface a {
        AbstractC17150mU3 a();

        a b(InterfaceC21991uU3 interfaceC21991uU3);
    }

    /* renamed from: ir.nasim.mU3$b */
    public interface b {
    }

    public static a a(Context context) {
        return new C17741nU3(context).b(C7158Qn1.n());
    }

    public abstract Spanned b(String str);
}
