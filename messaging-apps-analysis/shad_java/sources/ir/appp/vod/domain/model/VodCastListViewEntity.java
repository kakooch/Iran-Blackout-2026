package ir.appp.vod.domain.model;

/* compiled from: VodCastListViewEntity.kt */
/* loaded from: classes3.dex */
public final class VodCastListViewEntity {
    private final String category;
    private final String data;
    private final String id;
    private final Type type;

    /* compiled from: VodCastListViewEntity.kt */
    public enum Type {
        HEADER,
        TEXT,
        IMAGE,
        EMPTY
    }

    public final Type getType() {
        return this.type;
    }

    public final String getData() {
        return this.data;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCategory() {
        return this.category;
    }
}
