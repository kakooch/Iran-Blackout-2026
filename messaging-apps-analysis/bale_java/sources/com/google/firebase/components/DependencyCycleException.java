package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class DependencyCycleException extends DependencyException {
    private final List a;

    public DependencyCycleException(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.a = list;
    }
}
