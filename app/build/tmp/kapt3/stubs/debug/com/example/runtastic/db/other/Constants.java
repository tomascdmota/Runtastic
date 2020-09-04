package com.example.runtastic.db.other;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/runtastic/db/other/Constants;", "", "()V", "ACTION_PAUSE_SERVICE", "", "ACTION_SHOW_TRACKING_FRAGMENT", "ACTION_START_OR_RESUME_SERVICE", "ACTION_STOP_SERVICE", "FASTEST_lOCATION_INTERVAL", "", "LOCATION_UPDATE_INTERVAL", "NOTIFICATION_CHANNEL_ID", "NOTIFICATION_CHANNEL_NAME", "NOTIFICATION_ID", "", "REQUEST_CODE_LOCATION_PERMISSION", "RUNNING_DATABASE_NAME", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RUNNING_DATABASE_NAME = "running_db";
    public static final int REQUEST_CODE_LOCATION_PERMISSION = 0;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_ID = "tracking_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_NAME = "Tracking";
    public static final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT";
    public static final long LOCATION_UPDATE_INTERVAL = 5000L;
    public static final long FASTEST_lOCATION_INTERVAL = 2000L;
    public static final com.example.runtastic.db.other.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}