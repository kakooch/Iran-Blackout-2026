package ir.nasim;

import android.content.res.Resources;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.chat.ChatFragment;
import ir.nasim.data.model.story.PostToStoryOrigin;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.t64, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C21098t64 {
    public static final C21098t64 a = new C21098t64();

    private C21098t64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(C8967Xz7 c8967Xz7, ChatFragment chatFragment) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        if (c8967Xz7 != null) {
            chatFragment.wr(c8967Xz7);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.bp(j44);
        return C19938rB7.a;
    }

    private final AbstractC8081Ul1.b C(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_ask_ai_message, KB5.magic_ai, null, sa2, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.ns(j44);
        return C19938rB7.a;
    }

    private final AbstractC8081Ul1.b D(AbstractC8081Ul1.b bVar, boolean z, boolean z2, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, (z2 && z) ? AbstractC12217eE5.message_voice_copy_tr : z ? AbstractC12217eE5.message_voice_copy : AbstractC12217eE5.messages_action_copy, KB5.copy, null, sa2, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D0(ChatFragment chatFragment, J44 j44, M44 m44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(m44, "$this_with");
        chatFragment.Vi(new J44[]{j44}, m44.g());
        return C19938rB7.a;
    }

    private final AbstractC8081Ul1.b E(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_post_link, KB5.link, null, sa2, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.pj(j44);
        return C19938rB7.a;
    }

    private final AbstractC8081Ul1.b F(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_delete, KB5.delete, null, sa2, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F0(ChatFragment chatFragment, J44 j44, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        ChatFragment.hj(chatFragment, new J44[]{j44}, c8967Xz7, false, false, null, 28, null);
        return C19938rB7.a;
    }

    private final AbstractC8081Ul1.b G(AbstractC8081Ul1.b bVar, boolean z, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, z ? AbstractC12217eE5.remove_send_comment_permission : AbstractC12217eE5.group_context_remove, z ? KB5.ban_comment : KB5.delete_user, null, sa2, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G0(ChatFragment chatFragment, J44 j44, C11458d25 c11458d25) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(c11458d25, "$peer");
        chatFragment.tj(j44, c11458d25);
        return C19938rB7.a;
    }

    private final AbstractC8081Ul1.b H(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_save_downloads, KB5.download, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b I(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_save_music, KB5.download, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b J(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_edit, KB5.edit, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b K(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_forward, KB5.forward_e, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b L(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.show_replies, KB5.view_reply, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b M(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_pin, KB5.pin, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b N(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.story_add_post_to_story, KB5.add_story, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b O(AbstractC8081Ul1.b bVar, String str, InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2) {
        return bVar.g(str, KB5.emoji, (4 & 4) != 0 ? null : null, (4 & 8) != 0 ? null : interfaceC10258bL6, sa2);
    }

    private final AbstractC8081Ul1.b P(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_quote, KB5.reply, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b Q(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.group_context_report_abuse, AbstractC23008wB5.alert, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b R(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, DD5.retract_vote, AbstractC15208jB5.retract_vote, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b S(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_save_gallery, KB5.image, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b T(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.add_to_gifs, KB5.add_gif, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b U(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_saved_message, KB5.saved_message, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b V(AbstractC8081Ul1.b bVar, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, SA2 sa2) {
        return bVar.l(interfaceC10258bL6, KB5.seen, (4 & 4) != 0 ? null : null, (4 & 8) != 0 ? null : interfaceC10258bL62, sa2);
    }

    private final AbstractC8081Ul1.b W(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.context_menu_select, KB5.tick_square, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b X(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.menu_share, KB5.share, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b Y(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_share_text, KB5.share, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b Z(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, DD5.poll_off, AbstractC15208jB5.poll_off, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b a0(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_unpin, KB5.pin_off, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b b0(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_call_again, KB5.call, null, sa2, 4, null);
    }

    private final AbstractC8081Ul1.b c0(AbstractC8081Ul1.b bVar, SA2 sa2) {
        return AbstractC8081Ul1.b.k(bVar, AbstractC12217eE5.messages_action_call_video_again, KB5.video, null, sa2, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f0() {
        C15225jD4.b().c(C15225jD4.q, new Object[0]);
        C5074Hu0.a.d(EnumC22288uz0.d, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g0() {
        C15225jD4.b().c(C15225jD4.p, new Object[0]);
        C5074Hu0.a.d(EnumC22288uz0.d, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h0(C8967Xz7 c8967Xz7, ChatFragment chatFragment) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        Object objF = c8967Xz7 != null ? c8967Xz7.f() : null;
        C13121fh5 c13121fh5 = objF instanceof C13121fh5 ? (C13121fh5) objF : null;
        if (c13121fh5 != null) {
            chatFragment.Yr(c13121fh5.b(), c8967Xz7.h().i());
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i0(C8967Xz7 c8967Xz7, ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        Object objF = c8967Xz7 != null ? c8967Xz7.f() : null;
        C13121fh5 c13121fh5 = objF instanceof C13121fh5 ? (C13121fh5) objF : null;
        if (c13121fh5 == null) {
            return C19938rB7.a;
        }
        chatFragment.tp(c13121fh5.b(), j44.i());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.Ui(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k0(ChatFragment chatFragment, J44 j44) throws Resources.NotFoundException {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.wj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.dj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        ChatFragment.Xi(chatFragment, new J44[]{j44}, false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n0(ChatFragment chatFragment, J44 j44) throws IOException {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.wp(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.bj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.bj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.qj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.uj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.fi(j44, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.aj(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.Bp(j44, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v0(C8967Xz7 c8967Xz7, ChatFragment chatFragment) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        if (c8967Xz7 != null) {
            chatFragment.Pg(c8967Xz7, PostToStoryOrigin.b);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(final ChatFragment chatFragment, final J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.Cp(new UA2() { // from class: ir.nasim.k64
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21098t64.x0(chatFragment, j44, (OP5) obj);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x0(ChatFragment chatFragment, J44 j44, OP5 op5) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(op5, "reportType");
        chatFragment.lp(AbstractC9766aX0.e(j44), op5);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y0(C8967Xz7 c8967Xz7, ChatFragment chatFragment, InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        if (c8967Xz7 != null) {
            chatFragment.Ir(c8967Xz7, interfaceC10258bL6);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z0(ChatFragment chatFragment, J44 j44) {
        AbstractC13042fc3.i(chatFragment, "$chatFragment");
        AbstractC13042fc3.i(j44, "$message");
        chatFragment.Ng(j44);
        return C19938rB7.a;
    }

    public final AbstractC8081Ul1 d0(final M44 m44, final J44 j44, final ChatFragment chatFragment, final C11458d25 c11458d25, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, final InterfaceC10258bL6 interfaceC10258bL63, final C8967Xz7 c8967Xz7) throws Resources.NotFoundException {
        AbstractC13042fc3.i(m44, "availableActions");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(chatFragment, "chatFragment");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        if (m44.A()) {
            a.b0(bVar, new SA2() { // from class: ir.nasim.R54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.f0();
                }
            });
        }
        if (m44.z()) {
            a.c0(bVar, new SA2() { // from class: ir.nasim.T54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.g0();
                }
            });
        }
        if (m44.q()) {
            a.P(bVar, new SA2() { // from class: ir.nasim.b64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.q0(chatFragment, j44);
                }
            });
        }
        if (m44.d()) {
            a.T(bVar, new SA2() { // from class: ir.nasim.d64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.z0(chatFragment, j44);
                }
            });
        }
        if (m44.n()) {
            a.M(bVar, new SA2() { // from class: ir.nasim.e64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.B0(chatFragment, j44);
                }
            });
        }
        if (m44.y()) {
            a.a0(bVar, new SA2() { // from class: ir.nasim.f64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.C0(chatFragment, j44);
                }
            });
        }
        if (m44.e() || m44.g()) {
            a.D(bVar, j44.H() instanceof J08, m44.g(), new SA2() { // from class: ir.nasim.g64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.D0(chatFragment, j44, m44);
                }
            });
        }
        if (m44.m()) {
            a.L(bVar, new SA2() { // from class: ir.nasim.h64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.E0(chatFragment, j44);
                }
            });
        }
        if (m44.l()) {
            a.K(bVar, new SA2() { // from class: ir.nasim.i64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.F0(chatFragment, j44, c8967Xz7);
                }
            });
        }
        if (m44.u()) {
            a.U(bVar, new SA2() { // from class: ir.nasim.j64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.G0(chatFragment, j44, c11458d25);
                }
            });
        }
        if (m44.o()) {
            a.Z(bVar, new SA2() { // from class: ir.nasim.c64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.h0(c8967Xz7, chatFragment);
                }
            });
        }
        if (m44.s()) {
            a.R(bVar, new SA2() { // from class: ir.nasim.l64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.i0(c8967Xz7, chatFragment, j44);
                }
            });
        }
        if (m44.e() && C8386Vt0.a.t4()) {
            a.C(bVar, new SA2() { // from class: ir.nasim.m64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.j0(chatFragment, j44);
                }
            });
        }
        if (m44.x()) {
            a.Y(bVar, new SA2() { // from class: ir.nasim.n64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.k0(chatFragment, j44);
                }
            });
        }
        if (m44.k()) {
            a.J(bVar, new SA2() { // from class: ir.nasim.o64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.l0(chatFragment, j44);
                }
            });
        }
        if (m44.h()) {
            a.F(bVar, new SA2() { // from class: ir.nasim.p64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.m0(chatFragment, j44);
                }
            });
        }
        if (m44.t()) {
            a.S(bVar, new SA2() { // from class: ir.nasim.q64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.n0(chatFragment, j44);
                }
            });
        }
        if (m44.j() || AbstractC21772u64.b(j44)) {
            if (AbstractC14815iX3.h(j44)) {
                a.I(bVar, new SA2() { // from class: ir.nasim.r64
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21098t64.o0(chatFragment, j44);
                    }
                });
            } else {
                a.H(bVar, new SA2() { // from class: ir.nasim.s64
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21098t64.p0(chatFragment, j44);
                    }
                });
            }
        }
        if (m44.w()) {
            a.X(bVar, new SA2() { // from class: ir.nasim.S54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.r0(chatFragment, j44);
                }
            });
        }
        if (m44.f()) {
            a.E(bVar, new SA2() { // from class: ir.nasim.U54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.s0(chatFragment, j44);
                }
            });
        }
        if (m44.i()) {
            a.G(bVar, chatFragment.im(), new SA2() { // from class: ir.nasim.V54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.t0(chatFragment, j44);
                }
            });
        }
        if (m44.v()) {
            a.W(bVar, new SA2() { // from class: ir.nasim.W54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.u0(chatFragment, j44);
                }
            });
        }
        if (m44.c()) {
            a.N(bVar, new SA2() { // from class: ir.nasim.X54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.v0(c8967Xz7, chatFragment);
                }
            });
        }
        if (m44.r()) {
            a.Q(bVar, new SA2() { // from class: ir.nasim.Y54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.w0(chatFragment, j44);
                }
            });
        }
        if (m44.C() && interfaceC10258bL62 != null && interfaceC10258bL63 != null) {
            a.V(bVar, interfaceC10258bL63, interfaceC10258bL62, new SA2() { // from class: ir.nasim.Z54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.y0(c8967Xz7, chatFragment, interfaceC10258bL63);
                }
            });
        }
        if (m44.B() && interfaceC10258bL6 != null) {
            List listR = j44.R();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listR) {
                if (!AbstractC13042fc3.d(((GG5) obj).u(), "👁️")) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            long jW = 0;
            while (it.hasNext()) {
                jW += ((GG5) it.next()).w();
            }
            a.O(bVar, XY6.v(String.valueOf(jW)) + Separators.SP + chatFragment.b6().getQuantityString(AbstractC17590nD5.reaction_string, (int) jW), interfaceC10258bL6, new SA2() { // from class: ir.nasim.a64
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21098t64.A0(c8967Xz7, chatFragment);
                }
            });
        }
        return bVar;
    }
}
