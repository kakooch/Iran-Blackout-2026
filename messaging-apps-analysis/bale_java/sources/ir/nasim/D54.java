package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.text.Spannable;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10613bu0;
import ir.nasim.AbstractC12888fL4;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14486i0;
import ir.nasim.D54;
import ir.nasim.GM3;
import ir.nasim.GY;
import ir.nasim.InterfaceC18963pY7;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC19554qY7;
import ir.nasim.M44;
import ir.nasim.MW1;
import ir.nasim.UG5;
import ir.nasim.chat.ChatFragment;
import ir.nasim.chat.ChatViewModel;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.data.model.story.PostToStoryOrigin;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public final class D54 extends AbstractC23538x54 {
    private final SA2 a;
    private final ChatViewModel b;
    private final UA2 c;
    private final UA2 d;
    private final UA2 e;
    private ChatFragment f;
    private UG5 g;
    private final InterfaceC22948w54 h;
    private final InterfaceC12810fC7 i;
    private final InterfaceC24373yW1 j;
    private final InterfaceC14227ha k;
    private final EY2 l;
    private final BB7 m;
    private final InterfaceC6594Oe1 n;
    private final InterfaceC18458oh5 o;

    public static final class a implements InterfaceC14227ha {
        a() {
        }

        @Override // ir.nasim.InterfaceC14227ha
        public void a(C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.Pg(c8967Xz7, PostToStoryOrigin.c);
            }
        }
    }

    public static final class b implements InterfaceC22948w54 {

        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.D54$b$a$a, reason: collision with other inner class name */
            public static final class C0314a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.D54$b$a$a$a, reason: collision with other inner class name */
                public static final class C0315a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0315a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C0314a.this.a(null, this);
                    }
                }

                public C0314a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.D54.b.a.C0314a.C0315a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.D54$b$a$a$a r0 = (ir.nasim.D54.b.a.C0314a.C0315a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.D54$b$a$a$a r0 = new ir.nasim.D54$b$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        java.util.List r5 = (java.util.List) r5
                        int r5 = r5.size()
                        java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.D54.b.a.C0314a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C0314a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        b() {
        }

        private final void A(int i) {
            C22042ua0 c22042ua0B = C24137y63.b(i);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                C22042ua0.A9(chatFragmentE, c22042ua0B, false, null, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(ChatFragment chatFragment, C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(chatFragment, "$chatFragment");
            AbstractC13042fc3.i(c8967Xz7, "$message");
            SZ2 messagesAdapter = chatFragment.getMessagesAdapter();
            if (messagesAdapter != null) {
                messagesAdapter.s(c8967Xz7.j(), false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(b bVar, int i, C21231tK7 c21231tK7) {
            AbstractC13042fc3.i(bVar, "this$0");
            if (c21231tK7.y()) {
                return;
            }
            bVar.A(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(b bVar, int i, Exception exc) {
            AbstractC13042fc3.i(bVar, "this$0");
            bVar.A(i);
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void a(final int i) {
            C19482qQ7 c19482qQ7O;
            Integer num;
            if (D54.this.b.m6() == ExPeerType.GROUP) {
                C14733iO2 c14733iO2W6 = D54.this.b.w6();
                boolean z = false;
                if (((c14733iO2W6 == null || (c19482qQ7O = c14733iO2W6.o()) == null || (num = (Integer) c19482qQ7O.b()) == null) ? 0 : num.intValue()) != 0) {
                    C14733iO2 c14733iO2W62 = D54.this.b.w6();
                    if (c14733iO2W62 != null && c14733iO2W62.x() == i) {
                        z = true;
                    }
                    if (z) {
                        AbstractC5969Lp4.g().k(i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.F54
                            @Override // ir.nasim.InterfaceC24449ye1
                            public final void apply(Object obj) {
                                D54.b.y(this.a, i, (C21231tK7) obj);
                            }
                        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.G54
                            @Override // ir.nasim.InterfaceC24449ye1
                            public final void apply(Object obj) {
                                D54.b.z(this.a, i, (Exception) obj);
                            }
                        });
                        return;
                    }
                }
            }
            A(i);
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void b(J44 j44, C17532n74 c17532n74) {
            Integer numU;
            Integer numS;
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            ChatViewModel chatViewModel = D54.this.b;
            long jI = j44.i();
            long jH = j44.h();
            int iIntValue = 0;
            int iIntValue2 = (c17532n74 == null || (numS = c17532n74.s()) == null) ? 0 : numS.intValue();
            if (c17532n74 != null && (numU = c17532n74.u()) != null) {
                iIntValue = numU.intValue();
            }
            chatViewModel.J9(jI, jH, iIntValue2, iIntValue);
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void c(Context context, J44 j44, C11458d25 c11458d25) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c11458d25, "peer");
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                C3785Ci4 c3785Ci4 = C3785Ci4.a;
                FragmentActivity fragmentActivityQ7 = chatFragmentE.Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                c3785Ci4.D(context, j44, c11458d25, fragmentActivityQ7);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x015b  */
        @Override // ir.nasim.InterfaceC22948w54
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void e(android.view.View r44, final ir.nasim.C8967Xz7 r45) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 680
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.D54.b.e(android.view.View, ir.nasim.Xz7):void");
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void f(C10240bJ6 c10240bJ6) {
            AbstractC13042fc3.i(c10240bJ6, "sponsored");
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(c10240bJ6.c()));
                C18987pb3 c18987pb3 = C18987pb3.a;
                FragmentActivity fragmentActivityQ7 = chatFragmentE.Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                if (!c18987pb3.k0(intent, fragmentActivityQ7)) {
                    AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                    Uri uri = Uri.parse(c10240bJ6.c());
                    AbstractC13042fc3.h(uri, "parse(...)");
                    aVar.B(uri);
                }
            } catch (Exception unused) {
                AbstractC7426Rr.a aVar2 = AbstractC7426Rr.a;
                Uri uri2 = Uri.parse(c10240bJ6.c());
                AbstractC13042fc3.h(uri2, "parse(...)");
                aVar2.B(uri2);
            }
            UA2 ua2 = D54.this.c;
            if (ua2 != null) {
                ua2.invoke(c10240bJ6);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void g(C8967Xz7 c8967Xz7, String str, View view) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(str, "reactionCode");
            AbstractC13042fc3.i(view, "anchor");
            if (AbstractC9222Yz7.a(c8967Xz7)) {
                return;
            }
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
            } else {
                D54.this.P(c8967Xz7, str, view);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public boolean h(C8967Xz7 c8967Xz7, String str) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(str, "url");
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return false;
            }
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
                return true;
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("intent_extra_ex_peer_id_key", new ExPeer(chatFragmentE.z(), chatFragmentE.Y2().getPeerId()));
            if (!AbstractC9222Yz7.a(c8967Xz7)) {
                if (((Boolean) D54.this.d.invoke(String.valueOf(intent.getData()))).booleanValue()) {
                    return true;
                }
                C18987pb3 c18987pb3 = C18987pb3.a;
                FragmentActivity fragmentActivityQ7 = chatFragmentE.Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                return c18987pb3.k0(intent, fragmentActivityQ7);
            }
            UA2 ua2 = D54.this.c;
            if (ua2 != null) {
                Object objF = c8967Xz7.f();
                AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Sponsored");
                ua2.invoke((C10240bJ6) objF);
            }
            C18987pb3 c18987pb32 = C18987pb3.a;
            FragmentActivity fragmentActivityQ72 = chatFragmentE.Q7();
            AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
            if (c18987pb32.k0(intent, fragmentActivityQ72)) {
                return true;
            }
            if (!H15.h.matcher(uri.toString()).find()) {
                return false;
            }
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            AbstractC13042fc3.f(uri);
            aVar.B(uri);
            return true;
        }

        @Override // ir.nasim.InterfaceC22948w54
        public boolean j(View view, C8967Xz7 c8967Xz7, String str) throws Resources.NotFoundException {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            if (AbstractC9222Yz7.a(c8967Xz7) || !c8967Xz7.c().o()) {
                return false;
            }
            if (((List) D54.this.a.invoke()).contains("❤")) {
                t(c8967Xz7, "❤", AbstractC13042fc3.d("❤", str));
                return true;
            }
            e(view, c8967Xz7);
            return true;
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void k(C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            J44 j44J = c8967Xz7.j();
            if (j44J.g0()) {
                return;
            }
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
                return;
            }
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.Si(j44J, c8967Xz7, true);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void l(C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                ChatFragment.Xi(chatFragmentE, new J44[]{c8967Xz7.j()}, false, null, 4, null);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public boolean m(C8967Xz7 c8967Xz7) {
            ChatFragment chatFragmentE;
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            if (AbstractC9222Yz7.a(c8967Xz7) || (c8967Xz7.j().F() instanceof C21788u80) || c8967Xz7.j().c0() || (chatFragmentE = D54.this.E()) == null) {
                return false;
            }
            if (!(c8967Xz7.f() instanceof C8304Vk)) {
                return chatFragmentE.Bn(c8967Xz7.j());
            }
            InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
            return true;
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void n(C8967Xz7 c8967Xz7, String str) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(str, "hashtag");
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
                return;
            }
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.f5(str);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void o(C8967Xz7 c8967Xz7, Boolean bool) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            J44 j44J = c8967Xz7.j();
            if (j44J.g0()) {
                return;
            }
            boolean z = false;
            if (!(c8967Xz7.f() instanceof C8304Vk)) {
                if (bool != null) {
                    ChatFragment chatFragmentE = D54.this.E();
                    if (chatFragmentE != null) {
                        chatFragmentE.gn(j44J, bool.booleanValue());
                        return;
                    }
                    return;
                }
                ChatFragment chatFragmentE2 = D54.this.E();
                if (chatFragmentE2 != null) {
                    ChatFragment.hn(chatFragmentE2, j44J, false, 2, null);
                    return;
                }
                return;
            }
            Object objF = c8967Xz7.f();
            AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Album");
            List listA = ((C8304Vk) objF).a();
            if ((listA instanceof Collection) && listA.isEmpty()) {
                z = true;
            } else {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (!AbstractC13042fc3.d(((C14339hl) it.next()).e(), Boolean.TRUE)) {
                        break;
                    }
                }
                z = true;
            }
            ChatFragment chatFragmentE3 = D54.this.E();
            if (chatFragmentE3 != null) {
                chatFragmentE3.Bp(c8967Xz7.j(), !z);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void p(C8967Xz7 c8967Xz7, C4602Fv2 c4602Fv2) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c4602Fv2, "forward");
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
                return;
            }
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.Tm(c4602Fv2.d(), c4602Fv2.e(), c4602Fv2.c(), c4602Fv2.a());
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void q(String str) {
            InterfaceC11677dQ0 interfaceC11677dQ0Uj;
            ChatFragment chatFragmentE;
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE2 = D54.this.E();
            if (chatFragmentE2 == null || (interfaceC11677dQ0Uj = chatFragmentE2.Uj()) == null) {
                return;
            }
            C11458d25 c11458d25R = C11458d25.r(D54.this.b.K5());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            Fragment fragmentB = InterfaceC11677dQ0.b(interfaceC11677dQ0Uj, c11458d25R, ExPeerType.BOT, null, null, false, null, null, null, null, 0L, null, null, D54.this.b.L5(), false, null, null, null, null, null, false, null, null, null, null, str, false, null, 117436412, null);
            if (fragmentB == null || (chatFragmentE = D54.this.E()) == null) {
                return;
            }
            C22042ua0.A9(chatFragmentE, fragmentB, false, null, 6, null);
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void r(C8967Xz7 c8967Xz7, G73 g73) {
            ChatFragment chatFragmentE;
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(g73, "templateButton");
            if (AbstractC9222Yz7.a(c8967Xz7) || (chatFragmentE = D54.this.E()) == null) {
                return;
            }
            chatFragmentE.jo(g73, c8967Xz7.j());
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void s(C8967Xz7 c8967Xz7) {
            ChatFragment chatFragmentE;
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            if (AbstractC9222Yz7.a(c8967Xz7) || (chatFragmentE = D54.this.E()) == null) {
                return;
            }
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
                return;
            }
            J44 j44J = c8967Xz7.j();
            C8445Vz5 c8445Vz5Q = j44J.Q();
            if (c8445Vz5Q == null) {
                return;
            }
            if (c8445Vz5Q.D() != null) {
                int iZ = c8445Vz5Q.z();
                String strD = c8445Vz5Q.D();
                AbstractC13042fc3.h(strD, "getStoryId(...)");
                chatFragmentE.vl(iZ, strD);
                return;
            }
            if (c8445Vz5Q.r() instanceof NH1) {
                return;
            }
            chatFragmentE.oj(chatFragmentE.Y2(), c8445Vz5Q.s(), c8445Vz5Q.h());
            if (chatFragmentE.repliedMessagesStack.search(j44J) == -1) {
                chatFragmentE.repliedMessagesStack.push(j44J);
            }
        }

        @Override // ir.nasim.InterfaceC22948w54
        public void t(C8967Xz7 c8967Xz7, String str, boolean z) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(str, "reactionCode");
            if (AbstractC9222Yz7.a(c8967Xz7)) {
                return;
            }
            if (D54.this.k()) {
                InterfaceC22948w54.d(this, c8967Xz7, null, 2, null);
            } else {
                D54.this.O(c8967Xz7, str, z);
            }
        }
    }

    public static final class c implements InterfaceC6594Oe1 {
        c() {
        }

        @Override // ir.nasim.InterfaceC6594Oe1
        public void a(String str) {
            AbstractC13042fc3.i(str, "phone");
            C5735Kp4 c5735Kp4W = C5735Kp4.w();
            ChatFragment chatFragmentE = D54.this.E();
            c5735Kp4W.J(chatFragmentE != null ? chatFragmentE.S7() : null, str, "");
        }

        @Override // ir.nasim.InterfaceC6594Oe1
        public void b(String str) {
            AbstractC13042fc3.i(str, "phone");
            ChatViewModel chatViewModel = D54.this.b;
            ChatFragment chatFragmentE = D54.this.E();
            chatViewModel.kb(str, chatFragmentE != null ? chatFragmentE.S7() : null);
        }

        @Override // ir.nasim.InterfaceC6594Oe1
        public void c(String str, long j, C6833Pe1 c6833Pe1) {
            AbstractC13042fc3.i(str, "phone");
            AbstractC13042fc3.i(c6833Pe1, "content");
            ChatViewModel chatViewModel = D54.this.b;
            ChatFragment chatFragmentE = D54.this.E();
            chatViewModel.r4(str, chatFragmentE != null ? chatFragmentE.S7() : null, j, c6833Pe1);
        }
    }

    public static final class e implements EY2 {
        e() {
        }

        @Override // ir.nasim.EY2
        public void a(C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.Cn(c8967Xz7);
            }
        }
    }

    public static final class f implements InterfaceC18458oh5 {
        f() {
        }

        @Override // ir.nasim.InterfaceC18458oh5
        public void a(long j, List list, long j2) {
            AbstractC13042fc3.i(list, "optionIds");
            D54.this.b.t4(j, list, j2);
        }

        @Override // ir.nasim.InterfaceC18458oh5
        public void b(long j, String str, List list, int i) {
            AbstractC13042fc3.i(str, "question");
            AbstractC13042fc3.i(list, "answers");
            D54.this.b.Ka(j, str, list, i);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.ur(str);
            }
        }
    }

    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ C8967Xz7 b;
        final /* synthetic */ String c;

        h(C8967Xz7 c8967Xz7, String str) {
            this.b = c8967Xz7;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(D54 d54, int i) {
            AbstractC13042fc3.i(d54, "this$0");
            UG5 ug5 = d54.g;
            if (ug5 != null) {
                ug5.dismiss();
            }
            C18987pb3.x1(C18987pb3.a, new C11458d25(W25.a, i), null, null, false, null, null, false, null, null, false, null, 2046, null);
            return C19938rB7.a;
        }

        public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "modifier");
            int i2 = (i & 6) == 0 ? i | (interfaceC22053ub1.V(eVar) ? 4 : 2) : i;
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C20996sx3 c20996sx3B = AbstractC21683tx3.b(D54.this.b.h7(), null, interfaceC22053ub1, 0, 1);
            HashMap map = new HashMap();
            List listR = this.b.j().R();
            String str = this.c;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listR) {
                if (AbstractC13042fc3.d(((GG5) obj).u(), str)) {
                    arrayList.add(obj);
                }
            }
            List<GG5> listJ0 = AbstractC15401jX0.j0(arrayList);
            C8967Xz7 c8967Xz7 = this.b;
            for (GG5 gg5 : listJ0) {
                String strU = gg5.u();
                List listR2 = c8967Xz7.j().R();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listR2) {
                    if (AbstractC13042fc3.d(((GG5) obj2).u(), gg5.u())) {
                        arrayList2.add(obj2);
                    }
                }
                Iterator it = arrayList2.iterator();
                long jW = 0;
                while (it.hasNext()) {
                    jW += ((GG5) it.next()).w();
                }
                int i3 = (int) jW;
                C11066cg3 c11066cg3H = c20996sx3B.h();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : c11066cg3H) {
                    DH5 dh5 = (DH5) obj3;
                    if (AbstractC13042fc3.d(gg5.u(), dh5 != null ? dh5.c() : null)) {
                        arrayList3.add(obj3);
                    }
                }
                map.put(strU, Integer.valueOf(Math.abs(i3 - arrayList3.size())));
                Integer num = (Integer) map.get(gg5.u());
                if ((num != null ? num.intValue() : 0) < 1) {
                    map.remove(gg5.u());
                }
            }
            interfaceC22053ub1.W(-1030393707);
            boolean zD = interfaceC22053ub1.D(D54.this);
            final D54 d54 = D54.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.N54
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj4) {
                        return D54.h.c(d54, ((Integer) obj4).intValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            List listR3 = this.b.j().R();
            String str2 = this.c;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj4 : listR3) {
                if (AbstractC13042fc3.d(((GG5) obj4).u(), str2)) {
                    arrayList4.add(obj4);
                }
            }
            Iterator it2 = arrayList4.iterator();
            long jW2 = 0;
            while (it2.hasNext()) {
                jW2 += ((GG5) it2.next()).w();
            }
            CH5.v(eVar, c20996sx3B, map, false, null, ua2, Math.min(6, (int) jW2), interfaceC22053ub1, (i2 & 14) | (C20996sx3.f << 3), 24);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class i implements InterfaceC7199Qr6 {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ChatFragment chatFragment, C9456Zz7 c9456Zz7) {
            AbstractC13042fc3.i(chatFragment, "$chatFragment");
            AbstractC13042fc3.i(c9456Zz7, "$message");
            SZ2 messagesAdapter = chatFragment.getMessagesAdapter();
            if (messagesAdapter != null) {
                messagesAdapter.s(c9456Zz7.g(), false);
            }
        }

        @Override // ir.nasim.InterfaceC7199Qr6
        public void a(C9456Zz7 c9456Zz7) {
            AbstractC13042fc3.i(c9456Zz7, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.Bn(c9456Zz7.g());
            }
        }

        @Override // ir.nasim.InterfaceC7199Qr6
        public void b(J44 j44) {
            AbstractC13042fc3.i(j44, "oldMessage");
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                ChatFragment.hn(chatFragmentE, j44, false, 2, null);
            }
        }

        @Override // ir.nasim.InterfaceC7199Qr6
        public void c(View view, Point point, final C9456Zz7 c9456Zz7, J44 j44) throws Resources.NotFoundException {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(point, "point");
            AbstractC13042fc3.i(c9456Zz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(j44, "oldMessage");
            final ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return;
            }
            if ((chatFragmentE.im() && D54.this.b.s9(c9456Zz7.g())) || ChatFragment.hn(chatFragmentE, j44, false, 2, null)) {
                return;
            }
            AbstractC8081Ul1 abstractC8081Ul1D0 = C21098t64.a.d0(c9456Zz7.c(), j44, chatFragmentE, chatFragmentE.Y2(), (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 16) != 0 ? null : null, (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 32) != 0 ? null : null, (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 64) != 0 ? null : null, (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 128) != 0 ? null : null);
            if (abstractC8081Ul1D0.b()) {
                return;
            }
            SZ2 messagesAdapter = chatFragmentE.getMessagesAdapter();
            if (messagesAdapter != null) {
                messagesAdapter.s(c9456Zz7.g(), true);
            }
            View rootView = view.getRootView();
            AbstractC13042fc3.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            chatFragmentE.Pq(new GY.a(view, (ViewGroup) rootView, null, 4, null).h(point).d(true).e(new Runnable() { // from class: ir.nasim.O54
                @Override // java.lang.Runnable
                public final void run() {
                    D54.i.e(chatFragmentE, c9456Zz7);
                }
            }), abstractC8081Ul1D0);
        }
    }

    public static final class j implements InterfaceC12810fC7 {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ChatFragment chatFragment, J44 j44) {
            AbstractC13042fc3.i(chatFragment, "$chatFragment");
            AbstractC13042fc3.i(j44, "$message");
            SZ2 messagesAdapter = chatFragment.getMessagesAdapter();
            if (messagesAdapter != null) {
                messagesAdapter.s(j44, false);
            }
        }

        @Override // ir.nasim.InterfaceC12810fC7
        public void a(int i) {
            C22042ua0 c22042ua0B = C24137y63.b(i);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                C22042ua0.A9(chatFragmentE, c22042ua0B, false, null, 6, null);
            }
        }

        @Override // ir.nasim.InterfaceC12810fC7
        public boolean b(J44 j44) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return false;
            }
            return chatFragmentE.Bn(j44);
        }

        @Override // ir.nasim.InterfaceC12810fC7
        public void c(View view, final J44 j44) throws Resources.NotFoundException {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            final ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null || ChatFragment.hn(chatFragmentE, j44, false, 2, null)) {
                return;
            }
            M44.a aVar = new M44.a();
            aVar.K(true);
            aVar.S(true);
            AbstractC8081Ul1 abstractC8081Ul1D0 = C21098t64.a.d0(aVar.a(), j44, chatFragmentE, chatFragmentE.Y2(), (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 16) != 0 ? null : null, (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 32) != 0 ? null : null, (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 64) != 0 ? null : null, (SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER & 128) != 0 ? null : null);
            if (abstractC8081Ul1D0.b()) {
                return;
            }
            SZ2 messagesAdapter = chatFragmentE.getMessagesAdapter();
            if (messagesAdapter != null) {
                messagesAdapter.s(j44, true);
            }
            View rootView = view.getRootView();
            AbstractC13042fc3.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            chatFragmentE.Pq(new GY.a(view, (ViewGroup) rootView, null, 4, null).h(AbstractC5770Kt3.a()).d(true).e(new Runnable() { // from class: ir.nasim.P54
                @Override // java.lang.Runnable
                public final void run() {
                    D54.j.e(chatFragmentE, j44);
                }
            }), abstractC8081Ul1D0);
        }
    }

    public D54(SA2 sa2, ChatViewModel chatViewModel, UA2 ua2, UA2 ua22, UA2 ua23) {
        AbstractC13042fc3.i(sa2, "availableReactionsProvider");
        AbstractC13042fc3.i(chatViewModel, "chatViewModel");
        AbstractC13042fc3.i(ua22, "handleCallLinkUrl");
        AbstractC13042fc3.i(ua23, "handleLinkStatus");
        this.a = sa2;
        this.b = chatViewModel;
        this.c = ua2;
        this.d = ua22;
        this.e = ua23;
        this.h = new b();
        this.i = new j();
        this.j = new d();
        this.k = new a();
        this.l = new e();
        this.m = new g();
        this.n = new c();
        this.o = new f();
    }

    private final Drawable B(Context context, boolean z) {
        int iC = (int) ((8 * AbstractC3742Cd6.c()) + 0.5d);
        int iB = OY0.b(context, AbstractC21139tA5.n40);
        if (!z) {
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{iB}), null, AbstractC4310Eo7.d(iC, OY0.b(context, AbstractC21139tA5.colorSurface)));
        }
        Drawable drawableD = AbstractC4310Eo7.d(iC, iB);
        AbstractC13042fc3.f(drawableD);
        return drawableD;
    }

    private final void C() {
        ChatFragment chatFragment = this.f;
        if (chatFragment != null) {
            Context contextS7 = chatFragment.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = chatFragment.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            Dialog dialogC = AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, D61.a.c(), 4, null);
            dialogC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.y54
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    D54.D(this.a, dialogInterface);
                }
            });
            dialogC.setCanceledOnTouchOutside(false);
            dialogC.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(D54 d54, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(d54, "this$0");
        d54.b.A5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List F(String str, M44 m44) {
        ChatFragment chatFragment = this.f;
        if (chatFragment == null) {
            return AbstractC10360bX0.m();
        }
        C16731lm1 c16731lm1 = new C16731lm1(chatFragment.S7(), AbstractC23035wE5.Theme_Bale_Base);
        if (!m44.p()) {
            return AbstractC10360bX0.m();
        }
        Iterable<String> iterable = (Iterable) this.a.invoke();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        for (String str2 : iterable) {
            boolean zD = AbstractC13042fc3.d(str2, str);
            arrayList.add(new C13471gH5(str2, zD, R62.A(str2), B(c16731lm1, zD)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GM3 G(final C8967Xz7 c8967Xz7) {
        C19482qQ7 c19482qQ7E;
        long millis = TimeUnit.HOURS.toMillis(this.b.F6());
        boolean z = false;
        if (!C8386Vt0.M7() ? !C14593iA1.L(c8967Xz7.j().h()) : System.currentTimeMillis() - c8967Xz7.j().h() >= millis) {
            z = true;
        }
        if (C8386Vt0.K7() && c8967Xz7.g() == null && this.b.m6() == ExPeerType.CHANNEL) {
            C14733iO2 c14733iO2W6 = this.b.w6();
            if (((c14733iO2W6 == null || (c19482qQ7E = c14733iO2W6.E()) == null) ? null : (W06) c19482qQ7E.b()) != W06.PRIVATE && !z && M(c8967Xz7.j().F())) {
                return this.b.g5(c8967Xz7.j().i()) ? new GM3.c(new SA2() { // from class: ir.nasim.z54
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return D54.H(this.a, c8967Xz7);
                    }
                }) : !this.b.g5(c8967Xz7.j().i()) ? new GM3.b(new SA2() { // from class: ir.nasim.A54
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return D54.I(this.a, c8967Xz7);
                    }
                }) : GM3.a.b;
            }
        }
        return GM3.a.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(D54 d54, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(d54, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        d54.b.Aa(c8967Xz7.j().h(), c8967Xz7.j().i());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(D54 d54, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(d54, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        ChatFragment chatFragment = d54.f;
        if (chatFragment == null) {
            return C19938rB7.a;
        }
        ChatViewModel chatViewModel = d54.b;
        long jH = c8967Xz7.j().h();
        long jI = c8967Xz7.j().i();
        Context contextS7 = chatFragment.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        chatViewModel.cc(jH, jI, contextS7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RJ4 J(final C8967Xz7 c8967Xz7) {
        return new RJ4() { // from class: ir.nasim.B54
            @Override // ir.nasim.RJ4
            public final void a(String str, boolean z) {
                D54.K(this.a, c8967Xz7, str, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(D54 d54, C8967Xz7 c8967Xz7, String str, boolean z) {
        AbstractC13042fc3.i(d54, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(str, "emojiCode");
        d54.O(c8967Xz7, str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean L(ir.nasim.C8967Xz7 r5) {
        /*
            r4 = this;
            ir.nasim.chat.ChatViewModel r0 = r4.b
            boolean r0 = r0.J8()
            r1 = 0
            if (r0 == 0) goto L6a
            ir.nasim.chat.ChatViewModel r0 = r4.b
            ir.nasim.core.modules.profile.entity.ExPeerType r0 = r0.m6()
            ir.nasim.core.modules.profile.entity.ExPeerType r2 = ir.nasim.core.modules.profile.entity.ExPeerType.GROUP
            if (r0 != r2) goto L6a
            ir.nasim.Vt0 r0 = ir.nasim.C8386Vt0.a
            boolean r2 = r0.E6()
            r3 = 1
            if (r2 == 0) goto L44
            ir.nasim.J44 r2 = r5.j()
            ir.nasim.Vz5 r2 = r2.Q()
            if (r2 == 0) goto L2f
            int r2 = r2.w()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L30
        L2f:
            r2 = 0
        L30:
            if (r2 == 0) goto L69
            ir.nasim.J44 r2 = r5.j()
            ir.nasim.Vz5 r2 = r2.Q()
            if (r2 == 0) goto L41
            int r2 = r2.w()
            goto L42
        L41:
            r2 = r1
        L42:
            if (r2 == 0) goto L69
        L44:
            boolean r0 = r0.E6()
            if (r0 != 0) goto L6a
            ir.nasim.J44 r0 = r5.j()
            ir.nasim.Vz5 r0 = r0.Q()
            if (r0 == 0) goto L69
            ir.nasim.J44 r5 = r5.j()
            ir.nasim.Vz5 r5 = r5.Q()
            if (r5 == 0) goto L66
            boolean r5 = r5.E()
            if (r5 != 0) goto L66
            r5 = r3
            goto L67
        L66:
            r5 = r1
        L67:
            if (r5 == 0) goto L6a
        L69:
            r1 = r3
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.D54.L(ir.nasim.Xz7):boolean");
    }

    private final boolean M(AbstractC17457n0 abstractC17457n0) {
        if (!(abstractC17457n0 instanceof C23345wl7) && !(abstractC17457n0 instanceof LC3) && !(abstractC17457n0 instanceof GS7) && !(abstractC17457n0 instanceof C13388g85) && !(abstractC17457n0 instanceof XG2)) {
            if (!(C8386Vt0.a.j4() ? abstractC17457n0 instanceof C11907dl : false)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19554qY7 N(InterfaceC18505om2 interfaceC18505om2) {
        if (interfaceC18505om2 instanceof C4512Fl2) {
            return new InterfaceC19554qY7.a(((C4512Fl2) interfaceC18505om2).c);
        }
        if (!(interfaceC18505om2 instanceof C11920dm2)) {
            throw new NoWhenBranchMatchedException();
        }
        C11920dm2 c11920dm2 = (C11920dm2) interfaceC18505om2;
        return new InterfaceC19554qY7.b(c11920dm2.b().getFileId(), c11920dm2.b().getAccessHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(C8967Xz7 c8967Xz7, String str, boolean z) {
        C8445Vz5 c8445Vz5Q;
        if (!C8386Vt0.a.E6() && c8967Xz7.j().Q() != null && (c8445Vz5Q = c8967Xz7.j().Q()) != null && c8445Vz5Q.E()) {
            C8445Vz5 c8445Vz5Q2 = c8967Xz7.j().Q();
            if ((c8445Vz5Q2 != null ? c8445Vz5Q2.w() : 0) == 0) {
                return;
            }
        }
        if (c8967Xz7.f() instanceof C8304Vk) {
            Object objF = c8967Xz7.f();
            AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Album");
            Iterator it = ((C8304Vk) objF).a().iterator();
            while (it.hasNext()) {
                O(((C14339hl) it.next()).d(), str, z);
            }
            return;
        }
        if (!this.b.J8()) {
            ChatFragment chatFragment = this.f;
            if ((chatFragment != null ? chatFragment.z() : null) == ExPeerType.GROUP) {
                C();
            }
        }
        if (z) {
            this.b.ha(c8967Xz7.j().R(), str, c8967Xz7.h().i(), c8967Xz7.h().h());
        } else {
            this.b.q4(c8967Xz7.j().R(), str, c8967Xz7.h().i(), c8967Xz7.h().h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(final C8967Xz7 c8967Xz7, String str, View view) {
        J44 j44J;
        J44 j44J2;
        List listR;
        List listR2;
        final ChatFragment chatFragment = this.f;
        if (chatFragment != null && L(c8967Xz7)) {
            ChatViewModel chatViewModel = this.b;
            AbstractC17457n0 abstractC17457n0F = c8967Xz7.j().F();
            C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
            if (c11907dl == null || (listR2 = c11907dl.r()) == null || (j44J = (J44) AbstractC15401jX0.q0(listR2)) == null) {
                j44J = c8967Xz7.j();
            }
            long jH = j44J.h();
            AbstractC17457n0 abstractC17457n0F2 = c8967Xz7.j().F();
            C11907dl c11907dl2 = abstractC17457n0F2 instanceof C11907dl ? (C11907dl) abstractC17457n0F2 : null;
            if (c11907dl2 == null || (listR = c11907dl2.r()) == null || (j44J2 = (J44) AbstractC15401jX0.q0(listR)) == null) {
                j44J2 = c8967Xz7.j();
            }
            chatViewModel.l5(str, jH, j44J2.i());
            View rootView = view.getRootView();
            AbstractC13042fc3.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            InterfaceC18633oz3 interfaceC18633oz3P6 = chatFragment.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            UG5 ug5C = new UG5.a(view, (ViewGroup) rootView, interfaceC18633oz3P6).i(AbstractC5770Kt3.a()).e(true).f(new SA2() { // from class: ir.nasim.C54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return D54.Q(chatFragment, c8967Xz7);
                }
            }).h(AbstractC19242q11.c(-203543135, true, new h(c8967Xz7, str))).c();
            ug5C.h();
            this.b.pb("Group_message_reaction", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(chatFragment.Y2().getPeerId())), AbstractC4616Fw7.a("Action_type", 2)));
            this.g = ug5C;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(ChatFragment chatFragment, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        SZ2 messagesAdapter = chatFragment.getMessagesAdapter();
        if (messagesAdapter != null) {
            messagesAdapter.s(c8967Xz7.j(), false);
        }
        return C19938rB7.a;
    }

    public final ChatFragment E() {
        return this.f;
    }

    public final void R(ChatFragment chatFragment) {
        this.f = chatFragment;
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC14227ha a() {
        return this.k;
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC22948w54 b() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC6594Oe1 c() {
        return this.n;
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC24373yW1 d() {
        return this.j;
    }

    @Override // ir.nasim.AbstractC23538x54
    public UA2 e() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC23538x54
    public EY2 f() {
        return this.l;
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC18458oh5 g() {
        return this.o;
    }

    @Override // ir.nasim.AbstractC23538x54
    public BB7 h() {
        return this.m;
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC7199Qr6 i() {
        return new i();
    }

    @Override // ir.nasim.AbstractC23538x54
    public InterfaceC12810fC7 j() {
        return this.i;
    }

    @Override // ir.nasim.AbstractC23538x54
    public boolean k() {
        SZ2 messagesAdapter;
        ChatFragment chatFragment = this.f;
        if (chatFragment == null || (messagesAdapter = chatFragment.getMessagesAdapter()) == null) {
            return false;
        }
        return messagesAdapter.i();
    }

    public static final class d implements InterfaceC24373yW1 {

        static final class b implements InterfaceC15796kB2 {
            final /* synthetic */ SA2 a;

            b(SA2 sa2) {
                this.a = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(Dialog dialog, SA2 sa2) {
                AbstractC13042fc3.i(dialog, "$it");
                AbstractC13042fc3.i(sa2, "$onAccept");
                dialog.dismiss();
                sa2.invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(Dialog dialog) {
                AbstractC13042fc3.i(dialog, "$it");
                dialog.dismiss();
                return C19938rB7.a;
            }

            public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(dialog, "it");
                D61 d61 = D61.a;
                InterfaceC14603iB2 interfaceC14603iB2D = d61.d();
                AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
                InterfaceC14603iB2 interfaceC14603iB2E = d61.e();
                AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                interfaceC22053ub1.W(2097394863);
                boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
                final SA2 sa2 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.L54
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return D54.d.b.d(dialog, sa2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa22 = (SA2) objB;
                interfaceC22053ub1.Q();
                int i2 = AbstractC12217eE5.apk_installation_dialog_positive_button;
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                interfaceC22053ub1.W(2097404441);
                boolean zD2 = interfaceC22053ub1.D(dialog);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.M54
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return D54.d.b.f(dialog);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.E(interfaceC14603iB2D, c0905b, interfaceC14603iB2E, cVar, aVar, sa22, i2, c1454b, (SA2) objB2, AbstractC12217eE5.Cancel, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        d() {
        }

        private final boolean n(String str) {
            return AbstractC20153rZ6.B(str, ".apk", true);
        }

        private final boolean o(C11458d25 c11458d25) {
            return D54.this.b.J6().contains(Long.valueOf(c11458d25.u()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(ChatFragment chatFragment, J44 j44, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(chatFragment, "$chatFragment");
            AbstractC13042fc3.i(j44, "$oldMessage");
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            if (chatFragment.h9()) {
                return;
            }
            ChatFragment.tr(chatFragment, interfaceC3346Am2.getDescriptor(), j44, null, false, 12, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(ChatFragment chatFragment, J44 j44, AbstractC17757nW1 abstractC17757nW1, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(chatFragment, "$chatFragment");
            AbstractC13042fc3.i(j44, "$oldMessage");
            AbstractC13042fc3.i(abstractC17757nW1, "$document");
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            if (chatFragment.h9()) {
                return;
            }
            chatFragment.sr(interfaceC3346Am2.getDescriptor(), j44, ((AbstractC17757nW1.c.a) abstractC17757nW1).d(), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(ChatFragment chatFragment, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(chatFragment, "$chatFragment");
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            if (chatFragment.h9()) {
                return;
            }
            chatFragment.Go(interfaceC3346Am2.getDescriptor(), interfaceC3346Am2.getDescriptor());
        }

        private final void s(Context context, SA2 sa2) {
            if (D54.this.E() == null) {
                return;
            }
            ChatFragment chatFragmentE = D54.this.E();
            AbstractC13042fc3.f(chatFragmentE);
            AbstractC21375tZ.c(context, chatFragmentE, null, AbstractC19242q11.c(-890710375, true, new b(sa2)), 4, null).show();
        }

        private final void t(final Context context, final C12461ef1 c12461ef1) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c12461ef1.f());
            arrayList.addAll(c12461ef1.c());
            new AlertDialog.a(context).f((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.nasim.H54
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    D54.d.u(c12461ef1, context, dialogInterface, i);
                }
            }).a().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(C12461ef1 c12461ef1, Context context, DialogInterface dialogInterface, int i) {
            AbstractC13042fc3.i(c12461ef1, "$contactInfo");
            AbstractC13042fc3.i(context, "$context");
            try {
                context.startActivity(i + 1 <= c12461ef1.f().size() ? new Intent("android.intent.action.DIAL", Uri.fromParts("tel", (String) c12461ef1.f().get(i), null)) : new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", (String) c12461ef1.c().get(i - c12461ef1.f().size()), null)));
            } catch (Exception unused) {
            }
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void a(J44 j44) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.xm(j44.i(), j44.h(), new a(), false);
            }
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void b(C8967Xz7 c8967Xz7, final AbstractC17757nW1 abstractC17757nW1, View view) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(abstractC17757nW1, "document");
            final ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return;
            }
            if (D54.this.k()) {
                InterfaceC22948w54.d(D54.this.b(), c8967Xz7, null, 2, null);
                return;
            }
            final J44 j44J = c8967Xz7.j();
            if (abstractC17757nW1 instanceof AbstractC17757nW1.c.b) {
                if (!C8386Vt0.B8() || !(j44J.H() instanceof C13388g85)) {
                    AbstractC17757nW1.c.b bVar = (AbstractC17757nW1.c.b) abstractC17757nW1;
                    if (bVar.b() instanceof MW1.a) {
                        MW1 mw1B = bVar.b();
                        AbstractC13042fc3.g(mw1B, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Local");
                        ChatFragment.tr(chatFragmentE, ((MW1.a) mw1B).a().c, j44J, null, false, 12, null);
                        return;
                    } else {
                        if (bVar.b() instanceof MW1.b) {
                            MW1 mw1B2 = bVar.b();
                            AbstractC13042fc3.g(mw1B2, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Remote");
                            long fileId = ((MW1.b) mw1B2).a().b().getFileId();
                            MW1 mw1B3 = bVar.b();
                            AbstractC13042fc3.g(mw1B3, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Remote");
                            chatFragmentE.Gh(fileId, ((MW1.b) mw1B3).a().b().getAccessHash(), new InterfaceC24449ye1() { // from class: ir.nasim.I54
                                @Override // ir.nasim.InterfaceC24449ye1
                                public final void apply(Object obj) {
                                    D54.d.p(chatFragmentE, j44J, (InterfaceC3346Am2) obj);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                Spannable spannableD = c8967Xz7.d();
                String string = spannableD != null ? spannableD.toString() : null;
                C24967zW1 c24967zW1H = j44J.H();
                AbstractC13042fc3.g(c24967zW1H, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PhotoContent");
                C13388g85 c13388g85 = (C13388g85) c24967zW1H;
                InterfaceC18505om2 interfaceC18505om2A = ((AbstractC17757nW1.c.b) abstractC17757nW1).b().a();
                InterfaceC19554qY7 interfaceC19554qY7N = D54.this.N(interfaceC18505om2A);
                long jI = c8967Xz7.h().i();
                long jH = c8967Xz7.h().h();
                String strX = c13388g85.x();
                String strA = interfaceC18505om2A.a();
                int iU = c8967Xz7.j().U();
                C22694vg2 c22694vg2V = c13388g85.v();
                chatFragmentE.Qo(new InterfaceC18963pY7.b(jI, jH, strA, iU, interfaceC18505om2A.f(), string, strX, new C15539jl1(c13388g85.E(), c13388g85.D()), interfaceC19554qY7N, c22694vg2V != null ? c22694vg2V.c() : null), view);
                return;
            }
            if (abstractC17757nW1 instanceof AbstractC17757nW1.c.a) {
                if (!C8386Vt0.B8() || !C8386Vt0.D8() || !(j44J.H() instanceof XG2)) {
                    AbstractC17757nW1.c.a aVar = (AbstractC17757nW1.c.a) abstractC17757nW1;
                    if (aVar.b() instanceof MW1.a) {
                        MW1 mw1B4 = aVar.b();
                        AbstractC13042fc3.g(mw1B4, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Local");
                        chatFragmentE.sr(((MW1.a) mw1B4).a().c, j44J, aVar.d(), true);
                        return;
                    } else {
                        if (aVar.b() instanceof MW1.b) {
                            MW1 mw1B5 = aVar.b();
                            AbstractC13042fc3.g(mw1B5, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Remote");
                            long fileId2 = ((MW1.b) mw1B5).a().b().getFileId();
                            MW1 mw1B6 = aVar.b();
                            AbstractC13042fc3.g(mw1B6, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Remote");
                            chatFragmentE.Gh(fileId2, ((MW1.b) mw1B6).a().b().getAccessHash(), new InterfaceC24449ye1() { // from class: ir.nasim.J54
                                @Override // ir.nasim.InterfaceC24449ye1
                                public final void apply(Object obj) {
                                    D54.d.q(chatFragmentE, j44J, abstractC17757nW1, (InterfaceC3346Am2) obj);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                Spannable spannableD2 = c8967Xz7.d();
                String string2 = spannableD2 != null ? spannableD2.toString() : null;
                C24967zW1 c24967zW1H2 = j44J.H();
                AbstractC13042fc3.g(c24967zW1H2, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.GifContent");
                XG2 xg2 = (XG2) c24967zW1H2;
                InterfaceC18505om2 interfaceC18505om2A2 = ((AbstractC17757nW1.c.a) abstractC17757nW1).b().a();
                InterfaceC19554qY7 interfaceC19554qY7N2 = D54.this.N(interfaceC18505om2A2);
                long jI2 = c8967Xz7.h().i();
                long jH2 = c8967Xz7.h().h();
                String strX2 = xg2.x();
                String strA2 = interfaceC18505om2A2.a();
                long jE = xg2.E();
                int iU2 = c8967Xz7.j().U();
                C22694vg2 c22694vg2V2 = xg2.v();
                ChatFragment.Ro(chatFragmentE, new InterfaceC18963pY7.a(jE, jI2, jH2, strA2, iU2, interfaceC18505om2A2.f(), string2, strX2, new C15539jl1(xg2.G(), xg2.F()), interfaceC19554qY7N2, c22694vg2V2 != null ? c22694vg2V2.c() : null), null, 2, null);
                return;
            }
            if (abstractC17757nW1 instanceof AbstractC17757nW1.c.d) {
                Spannable spannableD3 = c8967Xz7.d();
                String string3 = spannableD3 != null ? spannableD3.toString() : null;
                C24967zW1 c24967zW1H3 = j44J.H();
                GS7 gs7 = c24967zW1H3 instanceof GS7 ? (GS7) c24967zW1H3 : null;
                if (gs7 == null) {
                    return;
                }
                InterfaceC18505om2 interfaceC18505om2A3 = ((AbstractC17757nW1.c.d) abstractC17757nW1).b().a();
                InterfaceC19554qY7 interfaceC19554qY7N3 = D54.this.N(interfaceC18505om2A3);
                long jI3 = c8967Xz7.h().i();
                long jH3 = c8967Xz7.h().h();
                String strX3 = gs7.x();
                String strA3 = interfaceC18505om2A3.a();
                int iU3 = c8967Xz7.j().U();
                long jG = gs7.G();
                C22694vg2 c22694vg2V3 = gs7.v();
                chatFragmentE.Qo(new InterfaceC18963pY7.c(jG, jI3, jH3, strA3, iU3, interfaceC18505om2A3.f(), string3, strX3, new C15539jl1(gs7.I(), gs7.H()), interfaceC19554qY7N3, c22694vg2V3 != null ? c22694vg2V3.c() : null), view);
                return;
            }
            if (abstractC17757nW1 instanceof AbstractC17757nW1.b) {
                AbstractC17757nW1.b bVar2 = (AbstractC17757nW1.b) abstractC17757nW1;
                if (bVar2.b() instanceof MW1.a) {
                    MW1 mw1B7 = bVar2.b();
                    AbstractC13042fc3.g(mw1B7, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Local");
                    C4512Fl2 c4512Fl2A = ((MW1.a) mw1B7).a();
                    chatFragmentE.Go(c4512Fl2A.c, c4512Fl2A.a());
                    return;
                }
                if (bVar2.b() instanceof MW1.b) {
                    MW1 mw1B8 = bVar2.b();
                    AbstractC13042fc3.g(mw1B8, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Remote");
                    long fileId3 = ((MW1.b) mw1B8).a().b().getFileId();
                    MW1 mw1B9 = bVar2.b();
                    AbstractC13042fc3.g(mw1B9, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Remote");
                    chatFragmentE.Gh(fileId3, ((MW1.b) mw1B9).a().b().getAccessHash(), new InterfaceC24449ye1() { // from class: ir.nasim.K54
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj) {
                            D54.d.r(chatFragmentE, (InterfaceC3346Am2) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (abstractC17757nW1 instanceof AbstractC17757nW1.a) {
                VL vlE = ((AbstractC17757nW1.a) abstractC17757nW1).e();
                C23709xO c23709xO = C23709xO.a;
                if (c23709xO.x(vlE)) {
                    c23709xO.v(vlE);
                    return;
                } else {
                    c23709xO.y(vlE);
                    return;
                }
            }
            if (!(abstractC17757nW1 instanceof AbstractC17757nW1.c.AbstractC1416c.b)) {
                if (!(abstractC17757nW1 instanceof AbstractC17757nW1.c.AbstractC1416c.a)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                Integer numG = ((AbstractC17757nW1.c.AbstractC1416c.b) abstractC17757nW1).g();
                if (numG != null) {
                    chatFragmentE.go(numG.intValue());
                }
            }
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void c(C8967Xz7 c8967Xz7, String str, SA2 sa2) {
            C11458d25 c11458d25Y2;
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(str, "fileName");
            AbstractC13042fc3.i(sa2, "onAccept");
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return;
            }
            C8445Vz5 c8445Vz5Q = c8967Xz7.j().Q();
            if (c8445Vz5Q == null || (c11458d25Y2 = c8445Vz5Q.u()) == null) {
                c11458d25Y2 = chatFragmentE.Y2();
            }
            Context contextS7 = chatFragmentE.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            m(contextS7, c11458d25Y2, str, sa2);
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void d(C8967Xz7 c8967Xz7, Object obj) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(obj, "data");
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE == null) {
                return;
            }
            if (obj instanceof C19943rC3) {
                chatFragmentE.Po(((C19943rC3) obj).b(), AbstractC12888fL4.a.b);
                return;
            }
            if (obj instanceof C12494ei4) {
                D54 d54 = D54.this;
                C3785Ci4 c3785Ci4 = C3785Ci4.a;
                FragmentActivity fragmentActivityQ7 = chatFragmentE.Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                J44 j44J = c8967Xz7.j();
                C11458d25 c11458d25Y2 = chatFragmentE.Y2();
                C14486i0.a aVar = C14486i0.f;
                FragmentActivity fragmentActivityQ72 = chatFragmentE.Q7();
                AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
                c3785Ci4.o(fragmentActivityQ7, j44J, c11458d25Y2, true, aVar.a(fragmentActivityQ72), chatFragmentE.Nk(), d54.b.p7());
                return;
            }
            if (obj instanceof C6244Mu1) {
                J44 j44J2 = c8967Xz7.j();
                CrowdfundingContentInfo crowdfundingContentInfoC = ((C6244Mu1) obj).c();
                crowdfundingContentInfoC.z(j44J2.h());
                crowdfundingContentInfoC.w(j44J2.toByteArray());
                chatFragmentE.Rq(j44J2, crowdfundingContentInfoC);
                return;
            }
            if (!(obj instanceof AbstractC10613bu0)) {
                if (obj instanceof C19405qI2) {
                    if (((C19405qI2) obj).b()) {
                        chatFragmentE.Ko(c8967Xz7.j());
                        return;
                    } else {
                        chatFragmentE.Io(chatFragmentE.Q7(), c8967Xz7.j());
                        return;
                    }
                }
                if (obj instanceof C12461ef1) {
                    Context contextS7 = chatFragmentE.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    t(contextS7, (C12461ef1) obj);
                    return;
                } else {
                    if (obj instanceof RH3) {
                        chatFragmentE.An((RH3) obj);
                        return;
                    }
                    return;
                }
            }
            Context contextS72 = chatFragmentE.S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            if (!C4100Dr4.a(contextS72)) {
                Context contextS73 = chatFragmentE.S7();
                AbstractC13042fc3.h(contextS73, "requireContext(...)");
                C24398yZ.c(contextS73, chatFragmentE).show();
            } else if (!(obj instanceof AbstractC10613bu0.a)) {
                chatFragmentE.xl();
                C5074Hu0.a.d(EnumC22288uz0.c, false);
            } else {
                ChatFragment chatFragmentE2 = D54.this.E();
                if (chatFragmentE2 != null) {
                    chatFragmentE2.wl();
                }
                C5074Hu0.a.d(EnumC22288uz0.c, true);
            }
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void e(long j, long j2, C8967Xz7 c8967Xz7, Object obj, SA2 sa2) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(obj, "data");
            AbstractC13042fc3.i(sa2, "onError");
            D54.this.b.Rc(j, j2, c8967Xz7, sa2);
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void f(C8967Xz7 c8967Xz7, EnumC9477a18 enumC9477a18, String str) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(enumC9477a18, "voiceTranscriptState");
            D54.this.b.H9(c8967Xz7, enumC9477a18, str);
        }

        @Override // ir.nasim.InterfaceC24373yW1
        public void g(String str) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            ChatViewModel.oc(D54.this.b, str, Integer.valueOf(KB5.icon_danger_circle), null, 4, null);
        }

        public final void m(Context context, C11458d25 c11458d25, String str, SA2 sa2) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str, "fileName");
            AbstractC13042fc3.i(sa2, "downloadAction");
            if (!n(str) || o(c11458d25)) {
                sa2.invoke();
            } else {
                s(context, sa2);
            }
        }

        public static final class a implements X64 {
            a() {
            }

            @Override // ir.nasim.X64
            public void a() {
            }
        }
    }

    public static final class g implements BB7 {
        g() {
        }

        @Override // ir.nasim.BB7
        public void a(C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            ChatFragment chatFragmentE = D54.this.E();
            if (chatFragmentE != null) {
                chatFragmentE.ts(c8967Xz7.j());
            }
        }

        @Override // ir.nasim.BB7
        public void b() {
        }
    }
}
