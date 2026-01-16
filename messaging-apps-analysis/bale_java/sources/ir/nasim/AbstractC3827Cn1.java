package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$MessageReaction;
import ai.bale.proto.MessagingStruct$ReactionContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Cn1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3827Cn1 {
    private static final boolean c(List list) {
        return list.isEmpty() || h(((J44) AbstractC15401jX0.C0(list)).O()) == null || h(((J44) AbstractC15401jX0.q0(list)).N()) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(J44 j44) {
        return (h(j44.O()) == null || h(j44.N()) == null) ? false : true;
    }

    private static final List e(List list, int i) {
        J44 j44 = (J44) AbstractC15401jX0.F0(list);
        if (j44 == null || !j44.a0() || h(j44.O()) == null) {
            return list;
        }
        int i2 = 0;
        for (int iO = AbstractC10360bX0.o(list); -1 < iO && AbstractC13042fc3.d(((J44) list.get(iO)).J(), j44.J()); iO--) {
            i2++;
        }
        return i2 == i ? list : list.subList(0, list.size() - i2);
    }

    private static final List f(List list, int i) {
        J44 j44 = (J44) AbstractC15401jX0.s0(list);
        if (j44 == null || !j44.a0() || j44.N() == null) {
            return list;
        }
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext() && AbstractC13042fc3.d(((J44) it.next()).J(), j44.J())) {
            i2++;
        }
        return i2 == i ? list : list.subList(i2, list.size());
    }

    public static final List g(List list, int i, int i2) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.size() >= i || !c(list)) {
            return f(e(list, i2), i2);
        }
        J44 j44 = (J44) AbstractC15401jX0.s0(list);
        C11458d25 c11458d25E = j44 != null ? C11458d25.E(j44.U()) : null;
        C19406qI3.j("ConversationHistoryActor_" + (c11458d25E != null ? Long.valueOf(c11458d25E.u()) : null), "End of list detected based on the loaded size(" + list.size() + ").", new Object[0]);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3460Az h(C3460Az c3460Az) {
        if (c3460Az == null || (c3460Az.i() == 0 && c3460Az.h() == 0)) {
            return null;
        }
        return c3460Az;
    }

    public static final J44 i(J44 j44, long j, long j2, MessagingStruct$ReactionContainer messagingStruct$ReactionContainer) {
        AbstractC13042fc3.i(j44, "<this>");
        AbstractC13042fc3.i(messagingStruct$ReactionContainer, "container");
        List<MessagingStruct$MessageReaction> reactionsList = messagingStruct$ReactionContainer.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        List<MessagingStruct$MessageReaction> list = reactionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$MessageReaction messagingStruct$MessageReaction : list) {
            CollectionsStruct$Int64Value cardinality = messagingStruct$MessageReaction.getCardinality();
            long jLongValue = 0;
            if (cardinality != null) {
                Long lValueOf = Long.valueOf(cardinality.getValue());
                if (lValueOf.longValue() <= 0) {
                    lValueOf = null;
                }
                if (lValueOf != null) {
                    jLongValue = lValueOf.longValue();
                }
            }
            String code = messagingStruct$MessageReaction.getCode();
            AbstractC13042fc3.h(code, "getCode(...)");
            List<Integer> usersList = messagingStruct$MessageReaction.getUsersList();
            AbstractC13042fc3.h(usersList, "getUsersList(...)");
            arrayList.add(new GG5(code, usersList, jLongValue));
        }
        return j(j44, j, j2, arrayList);
    }

    public static final J44 j(J44 j44, long j, long j2, List list) {
        AbstractC13042fc3.i(j44, "<this>");
        AbstractC13042fc3.i(list, "reactionsList");
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl == null) {
            return j44;
        }
        List<J44> listR = c11907dl.r();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
        for (J44 j44L : listR) {
            if (j44L.i() == j && j44L.h() == j2) {
                j44L = l(j44L, list);
            }
            arrayList.add(j44L);
        }
        C11907dl c11907dl2 = new C11907dl(arrayList);
        return J44.D(j44, 0L, 0L, 0L, 0, null, c11907dl2, AbstractC12519el.a(c11907dl2), 0, null, null, 0L, null, null, false, null, false, null, null, 262047, null);
    }

    public static final J44 k(J44 j44, MessagingStruct$ReactionContainer messagingStruct$ReactionContainer) {
        AbstractC13042fc3.i(j44, "<this>");
        AbstractC13042fc3.i(messagingStruct$ReactionContainer, "container");
        List<MessagingStruct$MessageReaction> reactionsList = messagingStruct$ReactionContainer.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        List<MessagingStruct$MessageReaction> list = reactionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$MessageReaction messagingStruct$MessageReaction : list) {
            CollectionsStruct$Int64Value cardinality = messagingStruct$MessageReaction.getCardinality();
            long jLongValue = 0;
            if (cardinality != null) {
                Long lValueOf = Long.valueOf(cardinality.getValue());
                if (lValueOf.longValue() <= 0) {
                    lValueOf = null;
                }
                if (lValueOf != null) {
                    jLongValue = lValueOf.longValue();
                }
            }
            String code = messagingStruct$MessageReaction.getCode();
            AbstractC13042fc3.h(code, "getCode(...)");
            List<Integer> usersList = messagingStruct$MessageReaction.getUsersList();
            AbstractC13042fc3.h(usersList, "getUsersList(...)");
            arrayList.add(new GG5(code, usersList, jLongValue));
        }
        return l(j44, arrayList);
    }

    public static final J44 l(J44 j44, List list) {
        Object next;
        List listS0 = list;
        AbstractC13042fc3.i(j44, "<this>");
        AbstractC13042fc3.i(listS0, "newReactions");
        Iterator it = j44.R().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((GG5) next).u(), "👁️")) {
                break;
            }
        }
        GG5 gg5 = (GG5) next;
        if (gg5 != null) {
            listS0 = AbstractC15401jX0.S0(listS0, gg5);
        }
        return J44.D(j44, 0L, 0L, 0L, 0, null, null, listS0, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null);
    }
}
