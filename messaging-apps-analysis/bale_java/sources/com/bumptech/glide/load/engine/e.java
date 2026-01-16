package com.bumptech.glide.load.engine;

import ir.nasim.HL4;
import ir.nasim.InterfaceC21989uU1;
import ir.nasim.Z72;
import java.io.File;

/* loaded from: classes2.dex */
class e implements InterfaceC21989uU1.b {
    private final Z72 a;
    private final Object b;
    private final HL4 c;

    e(Z72 z72, Object obj, HL4 hl4) {
        this.a = z72;
        this.b = obj;
        this.c = hl4;
    }

    @Override // ir.nasim.InterfaceC21989uU1.b
    public boolean a(File file) {
        return this.a.b(this.b, file, this.c);
    }
}
