package ir.nasim;

import ai.bale.proto.StoryStruct$StoryReaction;
import ir.nasim.AbstractC11710dT6;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.cT6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10946cT6 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC11710dT6 a(List list) {
        Object obj;
        Object next;
        AbstractC13042fc3.i(list, "input");
        if (list.isEmpty()) {
            return AbstractC11710dT6.a.a;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((StoryStruct$StoryReaction) next).getReactionType() == PU6.StoryReactionType_Emoji) {
                break;
            }
        }
        StoryStruct$StoryReaction storyStruct$StoryReaction = (StoryStruct$StoryReaction) next;
        if (storyStruct$StoryReaction != null) {
            String value = storyStruct$StoryReaction.getReactionText().getValue();
            AbstractC13042fc3.h(value, "getValue(...)");
            return new AbstractC11710dT6.b(value);
        }
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((StoryStruct$StoryReaction) next2).getReactionType() == PU6.StoryReactionType_View) {
                obj = next2;
                break;
            }
        }
        return ((StoryStruct$StoryReaction) obj) != null ? AbstractC11710dT6.c.a : AbstractC11710dT6.a.a;
    }
}
