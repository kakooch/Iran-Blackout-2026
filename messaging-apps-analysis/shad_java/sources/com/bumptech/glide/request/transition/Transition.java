package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public interface Transition<R> {

    public interface ViewAdapter {
    }

    boolean transition(R r, ViewAdapter viewAdapter);
}
