package ir.nasim;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC12710f43;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16831lw1 implements InterfaceC2029g {
    public static final C16831lw1 c = new C16831lw1(AbstractC12710f43.V(), 0);
    private static final String d = AbstractC9683aN7.r0(0);
    private static final String e = AbstractC9683aN7.r0(1);
    public static final InterfaceC2029g.a f = new InterfaceC2029g.a() { // from class: ir.nasim.kw1
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C16831lw1.d(bundle);
        }
    };
    public final AbstractC12710f43 a;
    public final long b;

    public C16831lw1(List list, long j) {
        this.a = AbstractC12710f43.O(list);
        this.b = j;
    }

    private static AbstractC12710f43 c(List list) {
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        for (int i = 0; i < list.size(); i++) {
            if (((C14451hw1) list.get(i)).d == null) {
                aVarL.a((C14451hw1) list.get(i));
            }
        }
        return aVarL.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16831lw1 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d);
        return new C16831lw1(parcelableArrayList == null ? AbstractC12710f43.V() : AbstractC3344Am0.b(C14451hw1.A0, parcelableArrayList), bundle.getLong(e));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d, AbstractC3344Am0.d(c(this.a)));
        bundle.putLong(e, this.b);
        return bundle;
    }
}
