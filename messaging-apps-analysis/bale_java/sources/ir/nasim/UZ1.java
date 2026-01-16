package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C4081Dp3;

/* loaded from: classes4.dex */
public abstract class UZ1 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(interfaceC14603iB2, "innerTextField");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-814021830);
            if (this.a.length() == 0) {
                G10 g10 = G10.a;
                int i3 = G10.b;
                AbstractC9105Ym7.b(this.b, null, g10.a(interfaceC22053ub1, i3).x(), 0L, null, null, null, 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, g10.d(interfaceC22053ub1, i3).b(), interfaceC22053ub1, 0, 3120, 55290);
            }
            interfaceC22053ub1.Q();
            interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i2 & 14));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ androidx.compose.ui.focus.m d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, androidx.compose.ui.focus.m mVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = mVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                androidx.compose.ui.focus.m.g(this.d, 0, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x08fb  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0955  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x097b  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x098a  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0a9d  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0b31  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0b52  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0bad  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0bb9  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0bbd  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0bea  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0c0b  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0c10  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0cfa  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0d6f  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0df0  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0e10  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0e22  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0e5a  */
    /* JADX WARN: Removed duplicated region for block: B:488:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final java.lang.String r120, final ir.nasim.UA2 r121, final java.lang.String r122, final java.lang.String r123, androidx.compose.ui.e r124, ir.nasim.InterfaceC14603iB2 r125, boolean r126, boolean r127, ir.nasim.InterfaceC14603iB2 r128, ir.nasim.InterfaceC14603iB2 r129, ir.nasim.AbstractC14472hy4 r130, ir.nasim.C21605tp3 r131, ir.nasim.C11329cp3 r132, boolean r133, int r134, int r135, ir.nasim.InterfaceC18507om4 r136, boolean r137, boolean r138, java.lang.String r139, boolean r140, ir.nasim.InterfaceC22053ub1 r141, final int r142, final int r143, final int r144, final int r145) {
        /*
            Method dump skipped, instructions count: 3708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UZ1.f(java.lang.String, ir.nasim.UA2, java.lang.String, java.lang.String, androidx.compose.ui.e, ir.nasim.iB2, boolean, boolean, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.hy4, ir.nasim.tp3, ir.nasim.cp3, boolean, int, int, ir.nasim.om4, boolean, boolean, java.lang.String, boolean, ir.nasim.ub1, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.v0(interfaceC11943do6, str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC5517Jr2 interfaceC5517Jr2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isFocused");
        AbstractC13042fc3.i(interfaceC5517Jr2, "it");
        interfaceC9102Ym4.setValue(Boolean.valueOf(interfaceC5517Jr2.a()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(C4081Dp3.b bVar) {
        AbstractC13042fc3.i(bVar, "$this$keyframes");
        bVar.d(SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER);
        return C19938rB7.a;
    }

    private static final float j(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(androidx.compose.ui.focus.m mVar) {
        AbstractC13042fc3.i(mVar, "$focusRequester");
        androidx.compose.ui.focus.m.g(mVar, 0, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(String str, UA2 ua2, String str2, String str3, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, boolean z, boolean z2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, AbstractC14472hy4 abstractC14472hy4, C21605tp3 c21605tp3, C11329cp3 c11329cp3, boolean z3, int i, int i2, InterfaceC18507om4 interfaceC18507om4, boolean z4, boolean z5, String str4, boolean z6, int i3, int i4, int i5, int i6, InterfaceC22053ub1 interfaceC22053ub1, int i7) {
        AbstractC13042fc3.i(str, "$value");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(str2, "$label");
        AbstractC13042fc3.i(str3, "$placeholder");
        f(str, ua2, str2, str3, eVar, interfaceC14603iB2, z, z2, interfaceC14603iB22, interfaceC14603iB23, abstractC14472hy4, c21605tp3, c11329cp3, z3, i, i2, interfaceC18507om4, z4, z5, str4, z6, interfaceC22053ub1, QJ5.a(i3 | 1), QJ5.a(i4), QJ5.a(i5), i6);
        return C19938rB7.a;
    }
}
