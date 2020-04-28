package com.example.convert;

import android.app.Application;
import org.koin.android.java.KoinAndroidApplication;
import org.koin.core.KoinApplication;
import org.koin.core.context.GlobalContext;
import org.koin.core.logger.Level;

import static org.koin.core.context.ContextFunctionsKt.startKoin;
import static com.example.convert.AppModuleKt.appModule;

public class MainJavaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KoinApplication koinApplication = KoinAndroidApplication.create(this, Level.INFO).modules(appModule);
        startKoin(new GlobalContext(), koinApplication);
    }
}
