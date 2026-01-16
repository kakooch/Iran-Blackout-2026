package ir.nasim;

import ir.nasim.RL5;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* loaded from: classes8.dex */
public final class KL5 extends ML5 implements InterfaceC14921ii3 {
    private final Field a;

    public KL5(Field field) {
        AbstractC13042fc3.i(field, "member");
        this.a = field;
    }

    @Override // ir.nasim.InterfaceC14921ii3
    public boolean K() {
        return U().isEnumConstant();
    }

    @Override // ir.nasim.InterfaceC14921ii3
    public boolean P() {
        return false;
    }

    @Override // ir.nasim.ML5
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Field U() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC14921ii3
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public RL5 getType() {
        RL5.a aVar = RL5.a;
        Type genericType = U().getGenericType();
        AbstractC13042fc3.h(genericType, "member.genericType");
        return aVar.a(genericType);
    }
}
