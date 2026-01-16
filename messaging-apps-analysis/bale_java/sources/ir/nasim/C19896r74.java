package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.r74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19896r74 implements InterfaceC19305q74 {
    private C4275El a;
    private final V25 b;
    private E84 c;
    private C10299bQ2 d;
    private final C6287Mz e;

    /* renamed from: ir.nasim.r74$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        long d;
        int e;
        /* synthetic */ Object f;
        int h;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C19896r74.this.c(0L, null, 0, null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    public C19896r74(C4275El c4275El, V25 v25, E84 e84, C10299bQ2 c10299bQ2, C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c4275El, "albumToMessageIdDataSource");
        AbstractC13042fc3.i(v25, "peerToOutPeerMapper");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c4275El;
        this.b = v25;
        this.c = e84;
        this.d = c10299bQ2;
        this.e = c6287Mz;
    }

    private final DB3 f(C11458d25 c11458d25) {
        return this.c.H0(c11458d25);
    }

    private final J44 h(J44 j44, long j) {
        long jS = j;
        List listP1 = AbstractC15401jX0.p1(j44.R());
        Iterator it = listP1.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (AbstractC13042fc3.d(((GG5) it.next()).u(), "👁️")) {
                break;
            }
            i++;
        }
        if (i == -1) {
            listP1.add(new GG5("👁️", AbstractC10360bX0.m(), jS));
        } else {
            GG5 gg5 = (GG5) listP1.get(i);
            if (jS == gg5.s()) {
                return null;
            }
            if (jS < gg5.s()) {
                C17213mb2.a.d("ViewCount", "oldCount: " + gg5.s() + ", newCount: " + jS);
                jS = gg5.s();
            }
            listP1.remove(i);
            listP1.add(i, new GG5("👁️", AbstractC10360bX0.m(), jS));
        }
        return J44.D(j44, 0L, 0L, 0L, 0, null, null, listP1, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null);
    }

    @Override // ir.nasim.InterfaceC19305q74
    public void a(C11458d25 c11458d25, long j, List list) {
        Object next;
        J44 j44H;
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "views");
        DB3 db3F = f(c11458d25);
        J44 j44 = (J44) db3F.a(j);
        if (j44 == null) {
            return;
        }
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl == null) {
            return;
        }
        List<J44> listR = c11907dl.r();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
        for (J44 j442 : listR) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                C23807xY7 c23807xY7 = (C23807xY7) next;
                if (c23807xY7.g() == j442.i() && c23807xY7.f() == j442.h()) {
                    break;
                }
            }
            C23807xY7 c23807xY72 = (C23807xY7) next;
            if (c23807xY72 != null && (j44H = h(j442, c23807xY72.h())) != null) {
                j442 = j44H;
            }
            arrayList.add(j442);
        }
        C11907dl c11907dl2 = new C11907dl(arrayList);
        db3F.d(J44.D(j44, 0L, 0L, 0L, 0, null, c11907dl2, AbstractC12519el.a(c11907dl2), 0, null, null, 0L, null, null, false, null, false, null, null, 262047, null));
    }

    @Override // ir.nasim.InterfaceC19305q74
    public void b(C11458d25 c11458d25, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        f(c11458d25).d(j44);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC19305q74
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(long r19, ir.nasim.C11458d25 r21, int r22, ir.nasim.EnumC15083iz r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r24
            boolean r2 = r1 instanceof ir.nasim.C19896r74.a
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.r74$a r2 = (ir.nasim.C19896r74.a) r2
            int r3 = r2.h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.h = r3
            goto L1c
        L17:
            ir.nasim.r74$a r2 = new ir.nasim.r74$a
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.f
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.h
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L59
            if (r4 == r6) goto L40
            if (r4 != r5) goto L38
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            java.lang.Object r1 = r1.l()
            goto Lab
        L38:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L40:
            int r4 = r2.e
            long r8 = r2.d
            java.lang.Object r10 = r2.c
            ir.nasim.p92 r10 = (ir.nasim.C18732p92) r10
            java.lang.Object r11 = r2.b
            ir.nasim.iz r11 = (ir.nasim.EnumC15083iz) r11
            java.lang.Object r12 = r2.a
            ir.nasim.r74 r12 = (ir.nasim.C19896r74) r12
            ir.nasim.AbstractC10685c16.b(r1)
            r16 = r4
            r13 = r8
            r15 = r11
            r4 = r12
            goto L80
        L59:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.p92 r10 = ir.nasim.C18732p92.a
            ir.nasim.V25 r1 = r0.b
            r2.a = r0
            r4 = r23
            r2.b = r4
            r2.c = r10
            r8 = r19
            r2.d = r8
            r11 = r22
            r2.e = r11
            r2.h = r6
            r12 = r21
            java.lang.Object r1 = r1.a(r12, r2)
            if (r1 != r3) goto L7b
            return r3
        L7b:
            r15 = r4
            r13 = r8
            r16 = r11
            r4 = r0
        L80:
            ai.bale.proto.PeersStruct$OutPeer r1 = (ai.bale.proto.PeersStruct$OutPeer) r1
            ir.nasim.nA r12 = r10.I0(r1)
            ir.nasim.AbstractC13042fc3.f(r12)
            java.util.List r17 = ir.nasim.PC.c
            ir.nasim.ST5 r1 = new ir.nasim.ST5
            r11 = r1
            r11.<init>(r12, r13, r15, r16, r17)
            ir.nasim.Mz r4 = r4.e
            ir.nasim.Nv5 r1 = r4.q(r1)
            java.lang.String r4 = "api(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r4)
            r2.a = r7
            r2.b = r7
            r2.c = r7
            r2.h = r5
            java.lang.Object r1 = ir.nasim.AbstractC6756Ov5.d(r1, r7, r2, r6, r7)
            if (r1 != r3) goto Lab
            return r3
        Lab:
            boolean r2 = ir.nasim.C9475a16.j(r1)
            if (r2 == 0) goto Lcd
            ir.nasim.VZ5 r1 = (ir.nasim.VZ5) r1
            java.util.List r1 = r1.y()
            java.lang.String r2 = "getHistory(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            java.lang.Object r1 = ir.nasim.ZW0.s0(r1)
            ir.nasim.zz r1 = (ir.nasim.C25247zz) r1
            if (r1 == 0) goto Lc8
            ir.nasim.J44 r7 = ir.nasim.C18732p92.M(r1)
        Lc8:
            java.lang.Object r1 = ir.nasim.C9475a16.b(r7)
            goto Ld1
        Lcd:
            java.lang.Object r1 = ir.nasim.C9475a16.b(r1)
        Ld1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19896r74.c(long, ir.nasim.d25, int, ir.nasim.iz, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC19305q74
    public void d(C11458d25 c11458d25, long j, long j2, List list, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "newReactions");
        if (!z) {
            g(c11458d25, j, j2, list, f(c11458d25));
        } else if (c11458d25.z()) {
            g(c11458d25, j, j2, list, this.c.F0());
            if (((C14697iL2) this.d.X1().d(c11458d25.getPeerId())).H0()) {
                g(c11458d25, j, j2, list, f(c11458d25));
            }
        }
    }

    @Override // ir.nasim.InterfaceC19305q74
    public void e(C11458d25 c11458d25, long j, long j2, long j3) {
        J44 j44H;
        AbstractC13042fc3.i(c11458d25, "peer");
        DB3 db3F = f(c11458d25);
        J44 j44 = (J44) db3F.a(j);
        if (j44 == null || (j44H = h(j44, j3)) == null) {
            return;
        }
        db3F.d(j44H);
    }

    public final void g(C11458d25 c11458d25, long j, long j2, List list, DB3 db3) {
        J44 j44;
        J44 j442;
        Object next;
        List listP1;
        C11907dl c11907dl;
        DB3 db32;
        ArrayList arrayList;
        J44 j443;
        J44 j444;
        List listR;
        Object next2;
        long j3 = j;
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "newReactions");
        if (db3 == null) {
            return;
        }
        J44 j445 = (J44) db3.a(j3);
        if (j445 == null) {
            Long lC = this.a.c(c11458d25.u(), new XV4(Long.valueOf(j), Long.valueOf(j2)));
            if (lC != null) {
                J44 j446 = (J44) f(c11458d25).a(lC.longValue());
                if (j446 == null) {
                    return;
                }
                AbstractC17457n0 abstractC17457n0F = j446.F();
                C11907dl c11907dl2 = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
                if (c11907dl2 == null || (listR = c11907dl2.r()) == null) {
                    j444 = null;
                } else {
                    Iterator it = listR.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        J44 j447 = (J44) next2;
                        if (j447.i() == j3 && j447.h() == j2) {
                            break;
                        }
                    }
                    j444 = (J44) next2;
                }
                j443 = j446;
                j445 = j444;
            } else {
                j443 = null;
            }
            if (j445 == null) {
                return;
            }
            j44 = j445;
            j442 = j443;
        } else {
            j44 = j445;
            j442 = null;
        }
        Iterator it2 = j44.R().iterator();
        while (true) {
            if (it2.hasNext()) {
                next = it2.next();
                if (AbstractC13042fc3.d(((GG5) next).u(), "👁️")) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        GG5 gg5 = (GG5) next;
        if (gg5 == null) {
            if (j442 == null) {
                db3.d(J44.D(j44, 0L, 0L, 0L, 0, null, null, list, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null));
                return;
            }
            DB3 db33 = db3;
            AbstractC17457n0 abstractC17457n0F2 = j442.F();
            c11907dl = abstractC17457n0F2 instanceof C11907dl ? (C11907dl) abstractC17457n0F2 : null;
            if (c11907dl == null) {
                return;
            }
            List<J44> listR2 = c11907dl.r();
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listR2, 10));
            for (J44 j44D : listR2) {
                if (j44D.i() == j3 && j44D.h() == j2) {
                    arrayList = arrayList2;
                    db32 = db33;
                    j44D = J44.D(j44D, 0L, 0L, 0L, 0, null, null, list, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null);
                } else {
                    db32 = db33;
                    arrayList = arrayList2;
                }
                ArrayList arrayList3 = arrayList;
                arrayList3.add(j44D);
                db33 = db32;
                arrayList2 = arrayList3;
                j3 = j;
            }
            C11907dl c11907dl3 = new C11907dl(arrayList2);
            db33.d(J44.D(j442, 0L, 0L, 0L, 0, null, c11907dl3, AbstractC12519el.a(c11907dl3), 0, null, null, 0L, null, null, false, null, false, null, null, 262047, null));
            return;
        }
        Iterator it3 = list.iterator();
        int i = 0;
        while (true) {
            if (!it3.hasNext()) {
                i = -1;
                break;
            } else if (AbstractC13042fc3.d(((GG5) it3.next()).u(), "👁️")) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            listP1 = AbstractC15401jX0.S0(list, gg5);
        } else {
            listP1 = AbstractC15401jX0.p1(list);
            listP1.remove(i);
            listP1.add(gg5);
        }
        List list2 = listP1;
        if (j442 == null) {
            db3.d(J44.D(j44, 0L, 0L, 0L, 0, null, null, list2, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null));
            return;
        }
        AbstractC17457n0 abstractC17457n0F3 = j442.F();
        c11907dl = abstractC17457n0F3 instanceof C11907dl ? (C11907dl) abstractC17457n0F3 : null;
        if (c11907dl == null) {
            return;
        }
        List<J44> listR3 = c11907dl.r();
        ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(listR3, 10));
        for (J44 j44D2 : listR3) {
            if (j44D2.i() == j && j44D2.h() == j2) {
                j44D2 = J44.D(j44D2, 0L, 0L, 0L, 0, null, null, list2, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null);
            }
            arrayList4.add(j44D2);
        }
        C11907dl c11907dl4 = new C11907dl(arrayList4);
        f(c11458d25).d(J44.D(j442, 0L, 0L, 0L, 0, null, c11907dl4, AbstractC12519el.a(c11907dl4), 0, null, null, 0L, null, null, false, null, false, null, null, 262047, null));
    }
}
