package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.s35, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20466s35 extends AbstractC17902nl0 {
    private ArrayList a = new ArrayList();

    public static C20466s35 q(byte[] bArr) {
        return (C20466s35) AbstractC16720ll0.b(new C20466s35(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        Iterator it = c19084pl0.l(1).iterator();
        while (it.hasNext()) {
            try {
                this.a.add(C19857r35.u((byte[]) it.next()));
            } catch (IOException e) {
                C19406qI3.c("PendingMessagesStorage", "parse", e);
            }
        }
    }

    public ArrayList r() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
    }
}
