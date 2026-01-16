package ir.nasim;

import ai.bale.proto.PfmStruct$PfmTransactionTag;
import android.graphics.Color;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.features.pfm.tags.PFMTag;

/* loaded from: classes6.dex */
public abstract class RQ4 {
    public static final boolean a(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, "<this>");
        return pFMTag.getParentTag() != null;
    }

    public static final PFMTag b(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        AbstractC13042fc3.i(pfmStruct$PfmTransactionTag, "<this>");
        PFMTag pFMTag = (PFMTag) C23077wJ2.a.f().get(Long.valueOf(pfmStruct$PfmTransactionTag.getId()));
        if (pFMTag == null) {
            pFMTag = new PFMTag(0, 0L, null, null, null, 0, 0, null, 255, null);
        }
        String value = pfmStruct$PfmTransactionTag.getColor().getValue();
        int color = (value == null || value.length() == 0) ? pFMTag.getColor() : Color.parseColor(pfmStruct$PfmTransactionTag.getColor().getValue());
        int userId = pfmStruct$PfmTransactionTag.getUserId();
        long id = pfmStruct$PfmTransactionTag.getId();
        String label = pfmStruct$PfmTransactionTag.getLabel();
        AbstractC13042fc3.h(label, "getLabel(...)");
        String label2 = label.length() == 0 ? pFMTag.getLabel() : pfmStruct$PfmTransactionTag.getLabel();
        AbstractC13042fc3.f(label2);
        EnumC18897pR4 enumC18897pR4A = AbstractC19488qR4.a(pfmStruct$PfmTransactionTag.getTransactionType());
        PfmStruct$PfmTransactionTag parentTag = pfmStruct$PfmTransactionTag.getParentTag();
        PFMTag pFMTagB = null;
        if (parentTag != null && parentTag.getId() != 0) {
            PfmStruct$PfmTransactionTag parentTag2 = pfmStruct$PfmTransactionTag.getParentTag();
            AbstractC13042fc3.h(parentTag2, "getParentTag(...)");
            pFMTagB = b(parentTag2);
        }
        return new PFMTag(userId, id, label2, enumC18897pR4A, pFMTagB, pFMTag.getIconId(), color, null, 128, null);
    }

    public static final PfmStruct$PfmTransactionTag c(PFMTag pFMTag) {
        StringValue stringValueH;
        AbstractC13042fc3.i(pFMTag, "<this>");
        String strW2 = pFMTag.getColor() == 0 ? null : C5495Jo7.a.w2(pFMTag.getColor());
        PfmStruct$PfmTransactionTag.a aVarE = PfmStruct$PfmTransactionTag.newBuilder().F(pFMTag.getUserId()).B(pFMTag.getId()).C(pFMTag.getLabel()).E(AbstractC19488qR4.b(pFMTag.getTransactionType()));
        if (strW2 != null && (stringValueH = GY6.h(strW2)) != null) {
            aVarE.A(stringValueH);
        }
        PFMTag parentTag = pFMTag.getParentTag();
        if (parentTag != null) {
            aVarE.D(c(parentTag));
        }
        GeneratedMessageLite generatedMessageLiteA = aVarE.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (PfmStruct$PfmTransactionTag) generatedMessageLiteA;
    }
}
