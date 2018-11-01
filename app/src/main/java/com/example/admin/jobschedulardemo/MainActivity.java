package com.example.admin.jobschedulardemo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    private static final int JOB_ID=101;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);*/

        ComponentName componentName=new ComponentName(this,MJobSchedular.class);
        JobInfo.Builder builder=new JobInfo.Builder(JOB_ID,componentName);
        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo=builder.build();
        jobScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void scheduleJobStart(View view) {
        jobScheduler.schedule(jobInfo);
        Toast.makeText(this,"Job Scheduled...",Toast.LENGTH_LONG).show();
    }

    public void clearJob(View view) {
        jobScheduler.cancel(JOB_ID);
        Toast.makeText(this,"Job Canceled...",Toast.LENGTH_LONG).show();
    }
}
