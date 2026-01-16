package ir.nasim;

import ai.bale.proto.Turing$UpdateGeneralNotificationMessage;
import ai.bale.proto.TuringStruct$CustomGeneralMessageAction;
import ai.bale.proto.TuringStruct$CustomOpenUrlAction;
import ir.nasim.AbstractC10026ax1;

/* loaded from: classes5.dex */
public final class HD7 implements InterfaceC14123hO3 {
    private final AbstractC10026ax1 c(TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction) {
        if (!turingStruct$CustomGeneralMessageAction.hasCustomOpenUrlAction()) {
            return turingStruct$CustomGeneralMessageAction.hasCustomDoNothingAction() ? AbstractC10026ax1.a.a : AbstractC10026ax1.c.a;
        }
        TuringStruct$CustomOpenUrlAction customOpenUrlAction = turingStruct$CustomGeneralMessageAction.getCustomOpenUrlAction();
        String url = customOpenUrlAction.getUrl();
        AbstractC13042fc3.h(url, "getUrl(...)");
        String buttonTitle = customOpenUrlAction.getButtonTitle();
        AbstractC13042fc3.h(buttonTitle, "getButtonTitle(...)");
        return new AbstractC10026ax1.b(url, buttonTitle, customOpenUrlAction.getShouldSearchInternal());
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GD7 a(Turing$UpdateGeneralNotificationMessage turing$UpdateGeneralNotificationMessage) {
        AbstractC10026ax1 abstractC10026ax1C;
        AbstractC13042fc3.i(turing$UpdateGeneralNotificationMessage, "input");
        String title = turing$UpdateGeneralNotificationMessage.getTitle();
        String description = turing$UpdateGeneralNotificationMessage.getDescription();
        AbstractC13042fc3.f(title);
        AbstractC13042fc3.f(description);
        if (turing$UpdateGeneralNotificationMessage.hasAction()) {
            TuringStruct$CustomGeneralMessageAction action = turing$UpdateGeneralNotificationMessage.getAction();
            AbstractC13042fc3.h(action, "getAction(...)");
            abstractC10026ax1C = c(action);
        } else {
            abstractC10026ax1C = null;
        }
        return new GD7(title, description, abstractC10026ax1C);
    }
}
