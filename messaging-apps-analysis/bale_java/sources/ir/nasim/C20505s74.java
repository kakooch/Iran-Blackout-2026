package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.s74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20505s74 implements InterfaceC20468s37 {
    private final OK7 a;
    private final C10299bQ2 b;
    private final Context c;

    /* renamed from: ir.nasim.s74$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C20505s74.this.a(null, this);
        }
    }

    public C20505s74(OK7 ok7, C10299bQ2 c10299bQ2, Context context) {
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(context, "context");
        this.a = ok7;
        this.b = c10299bQ2;
        this.c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ai.bale.proto.SearchStruct$MessageSearchItem r25, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20505s74.a(ai.bale.proto.SearchStruct$MessageSearchItem, ir.nasim.rm1):java.lang.Object");
    }
}
