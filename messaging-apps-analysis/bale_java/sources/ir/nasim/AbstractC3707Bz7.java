package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.List;

/* renamed from: ir.nasim.Bz7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3707Bz7 {

    /* renamed from: ir.nasim.Bz7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ List e;
        final /* synthetic */ InterfaceC17916nm4 f;
        final /* synthetic */ InterfaceC23352wm4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, List list, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC23352wm4 interfaceC23352wm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9102Ym4;
            this.d = interfaceC9102Ym42;
            this.e = list;
            this.f = interfaceC17916nm4;
            this.g = interfaceC23352wm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC3707Bz7.n(this.c, this.d, (String) this.e.get(this.f.d()));
            this.g.w(AbstractC17026mG5.a.k());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bz7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ EnumC5594Jz7 f;
        final /* synthetic */ long g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ List i;
        final /* synthetic */ InterfaceC17916nm4 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ InterfaceC23352wm4 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, EnumC5594Jz7 enumC5594Jz7, long j, SA2 sa22, List list, InterfaceC17916nm4 interfaceC17916nm4, boolean z, InterfaceC23352wm4 interfaceC23352wm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = sa2;
            this.d = interfaceC9102Ym4;
            this.e = interfaceC9102Ym42;
            this.f = enumC5594Jz7;
            this.g = j;
            this.h = sa22;
            this.i = list;
            this.j = interfaceC17916nm4;
            this.k = z;
            this.l = interfaceC23352wm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0129  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 340
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3707Bz7.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:277:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(androidx.compose.ui.e r45, final ir.nasim.UA2 r46, final java.lang.String r47, ir.nasim.C9348Zn7 r48, int r49, boolean r50, int r51, int r52, ir.nasim.UA2 r53, ir.nasim.C17784nZ1 r54, long r55, ir.nasim.EnumC5594Jz7 r57, boolean r58, boolean r59, boolean r60, boolean r61, java.lang.String r62, ir.nasim.SA2 r63, ir.nasim.SA2 r64, ir.nasim.InterfaceC22053ub1 r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 1117
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3707Bz7.f(androidx.compose.ui.e, ir.nasim.UA2, java.lang.String, ir.nasim.Zn7, int, boolean, int, int, ir.nasim.UA2, ir.nasim.nZ1, long, ir.nasim.Jz7, boolean, boolean, boolean, boolean, java.lang.String, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:353:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(androidx.compose.ui.e r56, final ir.nasim.UA2 r57, final java.util.List r58, ir.nasim.C9348Zn7 r59, int r60, boolean r61, int r62, int r63, ir.nasim.UA2 r64, ir.nasim.C17784nZ1 r65, long r66, ir.nasim.EnumC5594Jz7 r68, boolean r69, boolean r70, boolean r71, boolean r72, java.lang.String r73, ir.nasim.SA2 r74, ir.nasim.SA2 r75, ir.nasim.InterfaceC22053ub1 r76, final int r77, final int r78, final int r79) {
        /*
            Method dump skipped, instructions count: 1769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3707Bz7.g(androidx.compose.ui.e, ir.nasim.UA2, java.util.List, ir.nasim.Zn7, int, boolean, int, int, ir.nasim.UA2, ir.nasim.nZ1, long, ir.nasim.Jz7, boolean, boolean, boolean, boolean, java.lang.String, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int, int):void");
    }

    public static final void h(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1875025126);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C22043ua1.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.wz7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC3707Bz7.i(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        h(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C13774gn7 c13774gn7) {
        AbstractC13042fc3.i(c13774gn7, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(C13774gn7 c13774gn7) {
        AbstractC13042fc3.i(c13774gn7, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(androidx.compose.ui.e eVar, UA2 ua2, String str, C9348Zn7 c9348Zn7, int i, boolean z, int i2, int i3, UA2 ua22, C17784nZ1 c17784nZ1, long j, EnumC5594Jz7 enumC5594Jz7, boolean z2, boolean z3, boolean z4, boolean z5, String str2, SA2 sa2, SA2 sa22, int i4, int i5, int i6, InterfaceC22053ub1 interfaceC22053ub1, int i7) {
        AbstractC13042fc3.i(ua2, "$getEmojiString");
        AbstractC13042fc3.i(str, "$text");
        f(eVar, ua2, str, c9348Zn7, i, z, i2, i3, ua22, c17784nZ1, j, enumC5594Jz7, z2, z3, z4, z5, str2, sa2, sa22, interfaceC22053ub1, QJ5.a(i4 | 1), QJ5.a(i5), i6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(androidx.compose.ui.e eVar, UA2 ua2, List list, C9348Zn7 c9348Zn7, int i, boolean z, int i2, int i3, UA2 ua22, C17784nZ1 c17784nZ1, long j, EnumC5594Jz7 enumC5594Jz7, boolean z2, boolean z3, boolean z4, boolean z5, String str, SA2 sa2, SA2 sa22, int i4, int i5, int i6, InterfaceC22053ub1 interfaceC22053ub1, int i7) {
        AbstractC13042fc3.i(ua2, "$getEmojiString");
        AbstractC13042fc3.i(list, "$textList");
        g(eVar, ua2, list, c9348Zn7, i, z, i2, i3, ua22, c17784nZ1, j, enumC5594Jz7, z2, z3, z4, z5, str, sa2, sa22, interfaceC22053ub1, QJ5.a(i4 | 1), QJ5.a(i5), i6);
        return C19938rB7.a;
    }

    public static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, String str) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "currentText");
        AbstractC13042fc3.i(interfaceC9102Ym42, "remainingText");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        interfaceC9102Ym42.setValue(str);
        interfaceC9102Ym4.setValue("");
    }
}
