package ir.nasim;

import ai.bale.proto.PassportStruct$PassportField;
import ai.bale.proto.PassportStruct$PassportFieldGroup;
import com.google.protobuf.StringValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.tA, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21133tA implements InterfaceC14123hO3 {
    private final InterfaceC14123hO3 a;

    public C21133tA(InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC14123hO3, "fieldMapper");
        this.a = interfaceC14123hO3;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CX4 a(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        StringValue title;
        AbstractC13042fc3.i(passportStruct$PassportFieldGroup, "input");
        String value = null;
        PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup2 = passportStruct$PassportFieldGroup.hasTitle() ? passportStruct$PassportFieldGroup : null;
        if (passportStruct$PassportFieldGroup2 != null && (title = passportStruct$PassportFieldGroup2.getTitle()) != null) {
            value = title.getValue();
        }
        boolean inline = passportStruct$PassportFieldGroup.getInline();
        List<PassportStruct$PassportField> fieldsList = passportStruct$PassportFieldGroup.getFieldsList();
        AbstractC13042fc3.h(fieldsList, "getFieldsList(...)");
        List<PassportStruct$PassportField> list = fieldsList;
        InterfaceC14123hO3 interfaceC14123hO3 = this.a;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((BX4) interfaceC14123hO3.a((PassportStruct$PassportField) it.next()));
        }
        return new CX4(value, inline, arrayList);
    }
}
