package com.broadcasts.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * an annotation that determines the Broadcast Receiver data path in manifest, and in run-time it is
 * the same as invoking {@code IntentFilter.addDataPath(String, int)}
 *
 * Created by Ahmed Adel Ismail on 1/20/2018.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BroadcastReceiverDataPath {

    String path();

    int type();
}
