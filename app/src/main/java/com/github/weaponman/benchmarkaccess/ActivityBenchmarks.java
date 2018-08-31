package com.github.weaponman.benchmarkaccess;

import android.support.v4.util.ArrayMap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import dk.ilios.spanner.AfterExperiment;
import dk.ilios.spanner.BeforeExperiment;
import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.Param;
import dk.ilios.spanner.SpannerConfig;

public class ActivityBenchmarks {

    private File filesDir = MyApplication.getContext().getFilesDir();
    private File resultsDir = new File(filesDir, "results");

    @BenchmarkConfiguration
    public SpannerConfig configuration = new SpannerConfig.Builder()
            .saveResults(resultsDir, ActivityBenchmarks.class.getCanonicalName() + ".json")
            .medianFailureLimit(.2f)
            .uploadResults()
            .build();

    @Param(value = {
            "test",
            "test2",
            "test3",
            "test4",
            "test5",
            "test6",
            "test7",
            "miss"
    })
    public String value;

    public static Map<String, TestInterface> values = new HashMap<>();
    public static Map<String, TestInterface> valuesArrayMap = new ArrayMap<>();

    static {
        values.put("test", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });

        values.put("test2", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        values.put("test3", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        values.put("test4", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        values.put("test5", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        values.put("test6", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        values.put("test7", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });

        valuesArrayMap.put("test", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });

        valuesArrayMap.put("test2", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        valuesArrayMap.put("test3", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        valuesArrayMap.put("test4", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        valuesArrayMap.put("test5", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        valuesArrayMap.put("test6", new TestInterface() {
            @Override
            public void set(int a) {

            }
        });
        valuesArrayMap.put("test7", new TestInterface() {
            @Override
            public void set(int a) {


            }
        });
    }


    @BeforeExperiment
    public void before() {

    }

    @AfterExperiment
    public void after() {

    }

    @Benchmark
    public void hashMap() {
        int val = 0;
        TestInterface testInterface = values.get(value);
        if (testInterface != null) {
            testInterface.set(val);
        }
    }


    @Benchmark
    public void arrayMap() {
        int val = 0;
        TestInterface testInterface = valuesArrayMap.get(value);
        if (testInterface != null) {
            testInterface.set(val);
        }
    }

    @Benchmark
    public void switchCase() {
        int val = 0;
        switch (value) {
            case "test":
                val = 1;
                break;
            case "test2":
                val = 2;
                break;
            case "test3":
                val = 3;
                break;
            case "test4":
                val = 4;
                break;
            case "test5":
                val = 5;
                break;
            case "test6":
                val = 6;
                break;
            case "test7":
                val = 7;
                break;

        }
    }
}