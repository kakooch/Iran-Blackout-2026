package ir.nasim;

import ai.bale.proto.StoryOuterClass$ResponseGetStoryWidgets;
import ai.bale.proto.StoryStruct$Widget;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9736aT6;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class MX6 {
    public static final int c = C6287Mz.e;
    private final VV6 a;
    private final C9736aT6.a b;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return MX6.this.a(null, this);
        }
    }

    public MX6(VV6 vv6, C9736aT6.a aVar) {
        AbstractC13042fc3.i(vv6, "viewStoryApi");
        AbstractC13042fc3.i(aVar, "protobufMapperFactory");
        this.a = vv6;
        this.b = aVar;
    }

    private final List b(StoryOuterClass$ResponseGetStoryWidgets storyOuterClass$ResponseGetStoryWidgets, QQ6 qq6) {
        C9736aT6 c9736aT6A = this.b.a(qq6);
        List<StoryStruct$Widget> widgetsList = storyOuterClass$ResponseGetStoryWidgets.getWidgetsList();
        AbstractC13042fc3.h(widgetsList, "getWidgetsList(...)");
        List<StoryStruct$Widget> list = widgetsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (StoryStruct$Widget storyStruct$Widget : list) {
            AbstractC13042fc3.f(storyStruct$Widget);
            arrayList.add(c9736aT6A.a(storyStruct$Widget));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.QQ6 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.MX6.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.MX6$a r0 = (ir.nasim.MX6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.MX6$a r0 = new ir.nasim.MX6$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            ir.nasim.QQ6 r5 = (ir.nasim.QQ6) r5
            java.lang.Object r0 = r0.a
            ir.nasim.MX6 r0 = (ir.nasim.MX6) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L50
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.VV6 r6 = r4.a
            java.lang.String r2 = r5.l()
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r6.d(r2, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            r0 = r4
        L50:
            ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
            boolean r1 = r6 instanceof ir.nasim.Z06.b
            if (r1 == 0) goto L63
            ir.nasim.Z06$b r6 = (ir.nasim.Z06.b) r6
            com.google.protobuf.P r6 = r6.a()
            ai.bale.proto.StoryOuterClass$ResponseGetStoryWidgets r6 = (ai.bale.proto.StoryOuterClass$ResponseGetStoryWidgets) r6
            java.util.List r5 = r0.b(r6, r5)
            return r5
        L63:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MX6.a(ir.nasim.QQ6, ir.nasim.rm1):java.lang.Object");
    }
}
