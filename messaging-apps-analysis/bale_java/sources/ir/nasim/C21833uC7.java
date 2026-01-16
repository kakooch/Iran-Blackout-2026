package ir.nasim;

import ai.bale.proto.TimcheOuterClass$UpdateAskBotReview;

/* renamed from: ir.nasim.uC7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21833uC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21159tC7 a(TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview) {
        AbstractC13042fc3.i(timcheOuterClass$UpdateAskBotReview, "input");
        return new C21159tC7(timcheOuterClass$UpdateAskBotReview.getBotId(), timcheOuterClass$UpdateAskBotReview.hasPreviousRating() ? Integer.valueOf(timcheOuterClass$UpdateAskBotReview.getPreviousRating().getValue()) : null, timcheOuterClass$UpdateAskBotReview.hasPreviousComment() ? timcheOuterClass$UpdateAskBotReview.getPreviousComment().getValue() : null);
    }
}
