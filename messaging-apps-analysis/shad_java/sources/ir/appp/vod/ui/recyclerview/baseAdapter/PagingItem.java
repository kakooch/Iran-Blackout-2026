package ir.appp.vod.ui.recyclerview.baseAdapter;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasePagingAdapter.kt */
/* loaded from: classes3.dex */
public abstract class PagingItem<T> {
    public /* synthetic */ PagingItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PagingItem() {
    }

    /* compiled from: BasePagingAdapter.kt */
    public static final class Loading<T> extends PagingItem<T> {
        public Loading() {
            super(null);
        }
    }

    /* compiled from: BasePagingAdapter.kt */
    public static final class Content<T> extends PagingItem<T> {
        private T data;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual(this.data, ((Content) obj).data);
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Content(data=" + this.data + ")";
        }

        public Content(T t) {
            super(null);
            this.data = t;
        }

        public final T getData() {
            return this.data;
        }
    }
}
