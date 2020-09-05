package com.example.runtastic.Services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u00013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0003J\u0010\u0010#\u001a\n %*\u0004\u0018\u00010$0$H\u0002J\b\u0010&\u001a\u00020\u001dH\u0016J\"\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(H\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\nH\u0003R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/example/runtastic/Services/TrackingService;", "Landroidx/lifecycle/LifecycleService;", "()V", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationProviderClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationProviderClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "isFirstRun", "", "()Z", "setFirstRun", "(Z)V", "isTimerEnabled", "lapTime", "", "lastSecondTimeStamp", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "timeRun", "timeRunInSeconds", "Landroidx/lifecycle/MutableLiveData;", "timeStarted", "addEmptyPolyline", "", "addPathPoint", "", "location", "Landroid/location/Location;", "createNotificationChannel", "notificationManager", "Landroid/app/NotificationManager;", "getMainActivityPendingIntent", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "onCreate", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "pauseService", "postInitialValues", "startForegroundService", "startTimer", "updateLocationTracking", "isTracking", "Companion", "app_debug"})
public final class TrackingService extends androidx.lifecycle.LifecycleService {
    private boolean isFirstRun = true;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> timeRunInSeconds = null;
    private boolean isTimerEnabled = false;
    private long lapTime = 0L;
    private long timeRun = 0L;
    private long timeStarted = 0L;
    private long lastSecondTimeStamp = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.location.LocationCallback locationCallback = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.MutableLiveData<java.lang.Long> timeRunInMilis = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTracking = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.MutableLiveData<java.util.List<java.util.List<com.google.android.gms.maps.model.LatLng>>> pathPoints = null;
    public static final com.example.runtastic.Services.TrackingService.Companion Companion = null;
    
    public final boolean isFirstRun() {
        return false;
    }
    
    public final void setFirstRun(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.FusedLocationProviderClient getFusedLocationProviderClient() {
        return null;
    }
    
    public final void setFusedLocationProviderClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    private final void postInitialValues() {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void startTimer() {
    }
    
    private final void pauseService() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void updateLocationTracking(boolean isTracking) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.LocationCallback getLocationCallback() {
        return null;
    }
    
    private final void addPathPoint(android.location.Location location) {
    }
    
    private final java.lang.Object addEmptyPolyline() {
        return null;
    }
    
    private final void startForegroundService() {
    }
    
    private final android.app.PendingIntent getMainActivityPendingIntent() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void createNotificationChannel(android.app.NotificationManager notificationManager) {
    }
    
    public TrackingService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/example/runtastic/Services/TrackingService$Companion;", "", "()V", "isTracking", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "pathPoints", "", "Lcom/google/android/gms/maps/model/LatLng;", "getPathPoints", "timeRunInMilis", "", "getTimeRunInMilis", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.MutableLiveData<java.lang.Long> getTimeRunInMilis() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTracking() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.MutableLiveData<java.util.List<java.util.List<com.google.android.gms.maps.model.LatLng>>> getPathPoints() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}