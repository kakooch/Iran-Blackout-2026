package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.sI7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20610sI7 {
    private final FileReference a;
    private final FileReference b;
    private final WU c;

    public C20610sI7(FileReference fileReference, FileReference fileReference2, WU wu) {
        AbstractC13042fc3.i(wu, "placeHolder");
        this.a = fileReference;
        this.b = fileReference2;
        this.c = wu;
    }

    public final FileReference a() {
        return this.b;
    }

    public final FileReference b() {
        return this.a;
    }

    public final WU c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C20610sI7.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.UserAvatar");
        C20610sI7 c20610sI7 = (C20610sI7) obj;
        return AbstractC13042fc3.d(this.a, c20610sI7.a) && AbstractC13042fc3.d(this.b, c20610sI7.b) && this.c.a() == c20610sI7.c.a() && AbstractC13042fc3.d(this.c.b(), c20610sI7.c.b());
    }

    public int hashCode() {
        FileReference fileReference = this.a;
        int iHashCode = (fileReference != null ? fileReference.hashCode() : 0) * 31;
        FileReference fileReference2 = this.b;
        return ((iHashCode + (fileReference2 != null ? fileReference2.hashCode() : 0)) * 31) + this.c.hashCode();
    }
}
